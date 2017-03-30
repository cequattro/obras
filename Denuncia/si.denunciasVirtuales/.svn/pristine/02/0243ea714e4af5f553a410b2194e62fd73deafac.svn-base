package pe.gob.sunafil.denunciavirtual.reniecws;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import org.reniec.rel.ObtenerPersonaReniec;
import org.reniec.rel.ReniecBean;

import pe.gob.sunafil.denunciavirtual.bean.Persona;
import pe.gob.sunafil.denunciavirtual.mybatis.despachadores.PersonaReniecDespatch;
import pe.gob.sunafil.denunciavirtual.mybatis.despachadores.WebServiceDespatch;
import pe.gob.sunafil.denunciavirtual.utils.EnviarMail;


public class ReniecWebService {
	
	private static Logger logger = Logger.getLogger(ReniecWebService.class.getName());
	
	WebServiceDespatch wsd;
	
	private String ip;
	private String vNomusureg;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getvNomusureg() {
		return vNomusureg;
	}

	public void setvNomusureg(String vNomusureg) {
		this.vNomusureg = vNomusureg;
	}
	
	public ReniecWebService(){}
	
	public ReniecWebService(String ip, String vNomusureg)
	{
		this.ip = ip;
		this.vNomusureg = vNomusureg;
	}

	public String getnewSessionWS(String codigoError, String sistema) throws Exception {
		System.out.println("OBTIENE SESION DE WEBSERVICE");
		String session="";
		try {
			
			wsd = new WebServiceDespatch();
			
			ObtenerPersonaReniec opr = new ObtenerPersonaReniec();
			//===========================================================
			//CONSULTAR EN BASE DE DATOS POR LA ULTIMA SESION UTILIZADA
			//===========================================================
			session = wsd.verifySessionWS();
			System.out.println("session1 "+session);
			//SI NO HAY SESSION ACTIVA EN BASE 
			if (session == null || session.length()==0 || "SINV".equals(codigoError)) {
				
				logger.info("No se encontro session de RENIEC del día de hoy, o hay algun error en la session.Obtenemos una nueva session de RENIEC.");
				//1.OBTENER SESSION
				//session=opr.obtenerSession("SUNAFIWS", "SUNAFIWS!=");//PRUEBAS
				session=opr.obtenerSession("SNFLABWS", "MzE3NTIwMDI=");//PRODUCCION
				System.out.println("session "+session);
				if(session.length()>3 && session.length()<100){
					//2.REGISTRAR SESSION EN BASE DE DATOS	
					logger.info("Registrando sessión de WSReniec con el sistema=>"+sistema);
					wsd.savenewSessionWS(session, sistema, "E");
				}
				
			} 
			
			return session;
					
		} catch (Exception e) {
			logger.error("Error al obtener la sesion en ReniecWebService, metodo getnewSessionWS "+e.getMessage(),e);
			throw new Exception(e);
		}
		
	}
	

	
	
	public ReniecBean obtenerPersonaSWReniec(Persona persona,String sistema){
		logger.info("BUSCANDO PERSONA EN WEBSERVICE");
		ReniecBean resultPersona=new ReniecBean();
		String paso = "1";//UTILIZADO PARA SABER EN QUE PARTE ES LA QUE CAE EL SISTEMA:
		String verificacion="";//UTILIZADO PARA VERIFICAR SI YA EXISTE LA PERSONA EN LA BD
		
		try {
			
			PersonaReniecDespatch dspPersonaReniec=new PersonaReniecDespatch();
			
			if (persona.getV_codtdocide().equals("03")) {
				//VERIFICAMOS SI LA PERSONA EXISTE Y ESTA ACTUALIZADA SEGUN RENIEC
				logger.debug("VERIFICAMOS SI LA PERSONA EXISTE Y ESTA ACTUALIZADA SEGUN RENIEC");
				//ESTA VERIFICACION ES DE LA TABLA SITB_PERSONA PREGUNTAMOS EL p.v_flgreniec 
				verificacion=dspPersonaReniec.verificaActuPersonaReniec(persona);
				
				//YA QUE TODO SE CONSULTARA A RENIEC PORQUE EL DIGITO VERIFICADOR SIEMPRE TIENE QUE ESTAR ACTUALIZADO:
				if(verificacion.equals("ER")){//ER:EXISTE Y DE RENIEC
					logger.info("El trabajador existe y con datos de reniec, sin embargo hay algunos datos de validacion que deben actualizarce siempre. Por eso cambiamos a ENR para que actualice");
					verificacion = "ENR" ;
					
				}
				
				if("ENR".equals(verificacion) || "NE".equals(verificacion)){//ENR:EXISTE Y NO ES DE RENIEC, NE: NO EXISTE
					
					//*****************************************************
					//OBTENEMOS LOS DATOS DE LA PERSONA CON EL WS DE RENIEC
					//*****************************************************
					ObtenerPersonaReniec opr = new ObtenerPersonaReniec();
					SimpleDateFormat simpleDate=new SimpleDateFormat("yyyyMMdd");
					Date fecha=new Date();
					//HACEMOS TRES INTENTOS
					for(int i=0;i<3;i++){
						String sesion = "" + getnewSessionWS(resultPersona.getV_coderror(),sistema);
						System.out.println("OBTIENE PERSONA [sesion:" + sesion + "]");
						resultPersona = opr.obtenerPersona(
								sesion, 
								//"SUNAFIWS", //PRUEBAS
								"SNFLABWS", //PRODUCCION
								"", 
								//"08715701",//DNI DE PRUEBAS
								"18097393",//PRODUCCION
								persona.getV_numdoc());
						
						/* CREO QUE NO DEBERIA ESTAR AQUI YA QUE SI SALE SOLO CODIGO DE ERROR Y NULO ALGUNOS DE LOS CAMPOS CAERÁ!!!!!!!!:::
						persona.setV_codtdocide("03");
						persona.setV_numdoc(persona.getV_numdoc());
						persona.setV_appaterno(resultPersona.getV_appaterno());
						persona.setV_apmaterno(resultPersona.getV_apmaterno());
						persona.setV_nombres(resultPersona.getV_nombres());
						//CODIGO DE VERIFICACION v_codverific
						persona.setV_codverific(resultPersona.getV_codverific());
						*/
						
						//SI NOS SALE CUALQUIER MENSAJE DE ERROR EXCEPTO SINV Y UNL , PODEMOS SALIR DEL BUCLE
						if(!"SINV".equals(resultPersona.getV_coderror()) && 
								!"UNL".equals(resultPersona.getV_coderror()) &&
								!"5".equals(resultPersona.getV_coderror()) //PARA VER SI PODEMOS OBTENER EN OTRO INTENTO LUEGO DE QUE EXEDIMOS LAS CONSUTLAS.
								){
							break;
						}
					}
					
					//***************************************************************************************************
					//SI PASA HASTA AQUI EL WEB SERVICE ESTA FUNCIONANDO BIEN ENTONCES ACTUALIZAMOS EL PASO:
					//PASO = 1 SOLO PARA EL ENVIO DE CORREOS SI OCURRE ALGUN ERROR CON EL WS (CAPTURADO EN EL CATCH).
					//PASO = 2 DESPUES DE CONSULTAR AL WS
					//***************************************************************************************************
					paso="2";
					
					//EL MENSAJE DE ERROR 0000 INDICA QUE T0DO SALIO BIEN:
					if("0000".equals(resultPersona.getV_coderror())){
						//SI ESTA BIEN LA CONSULTA A RENIEC FORMATEAMOS LAS FECHAS:

						if(resultPersona.getV_fecnac()!=null && !"".equals(resultPersona.getV_fecnac())){
							fecha=simpleDate.parse(resultPersona.getV_fecnac());							
							java.sql.Date sqlDateCad = new java.sql.Date(fecha.getTime());
							String stringDate = new SimpleDateFormat("dd/MM/yyyy").format( sqlDateCad );
							resultPersona.setV_fecnac(stringDate);
							System.out.println("stringDate Nacimiento=>"+stringDate);
						}
						if(resultPersona.getV_fecemision()!=null && !"".equals(resultPersona.getV_fecemision())){
							fecha=simpleDate.parse(resultPersona.getV_fecemision());							
							java.sql.Date sqlDateCad = new java.sql.Date(fecha.getTime());
							String stringDate = new SimpleDateFormat("dd/MM/yyyy").format( sqlDateCad );
							resultPersona.setV_fecemision(stringDate);
							System.out.println("stringDate Emision=>"+stringDate);
						}
						if(resultPersona.getV_fecinscrip()!=null && !"".equals(resultPersona.getV_fecinscrip())){
							fecha=simpleDate.parse(resultPersona.getV_fecinscrip());							
							java.sql.Date sqlDateCad = new java.sql.Date(fecha.getTime());
							String stringDate = new SimpleDateFormat("dd/MM/yyyy").format( sqlDateCad );
							resultPersona.setV_fecinscrip(stringDate);
							System.out.println("stringDate Inscripcion=>"+stringDate);
						}
						
						//IMPRIMIENDO LOS DATOS OBTENIDOS:
						resultPersona.valuesToString();	
						
						
						
						if(verificacion.equals("NE")){
							//SE INSERTA EN NUESTRA BD
							logger.info("Insertando datos de la persona en RENIEC");
							dspPersonaReniec.insertarPersona(resultPersona, ip, vNomusureg);
							//WebServiceDAO.insertarPersonaReniec(resultPersona,v_codusureg);
						}else{
							//SE ACTUALIZA EN NUESTRA BD
							logger.info("actualizando datos de la persona en RENIEC");
							dspPersonaReniec.actualizarPersona(resultPersona, ip, vNomusureg);						
						}
						
					}
					else{//SI NO OBTENEMOS EL MENSAJE 0000 DE QUE SALIO BIEN ENTONCES DEBIMOS HABER OBTENIDO ALGUN TIPO DE MENSAJE DE ERROR
						
						//*******************************
						//MENSAJES POSIBLES DE ERROR:
						//*******************************
						//0001:	USUARIO NO EXISTE! 
						//5:	EXEDIMOS EL MAX NRO DE CONSULTAS POR DIA 	
						//3: 	CONSULTA EN UN DIA Y HORA NO PERMITIDOS
						//DNE:	EL DNI CONSULTADO ES INVALIDO
						//NHC:	CREEEO QUE ES PORQ EL DNI NO EXISTE(ESTE CODIGO LO RECOGIMOS DE MTPE NO ESTA EN LAS ESPECIF TEC DE RENIEC)
						//0002:	EL SERVIDOR NO PUEDE ATENDER EL REQUERIMIENTO
						//SINV: CODIGO DE SESION INVALIDO
						//UNL:	LA APP QUE CONSULTA AL WS NO SE AUTENTICO SE DEBE INVOCAR PRIMERO GETSESSION
						
						if("DNE".equals(resultPersona.getV_coderror()) || "NHC".equals(resultPersona.getV_coderror()) ||
								"21".equals(resultPersona.getV_coderror()) ||
								"22".equals(resultPersona.getV_coderror()) || 
								"23".equals(resultPersona.getV_coderror())){
							logger.warn("El DNI consultado no existe o tiene restricciones en RENIEC:::resultPersona.getV_coderror()=>"+resultPersona.getV_coderror());
							
						}else{
							logger.error("Problema de comunicación con RENIEC!!:::resultPersona.getV_coderror()=>"+resultPersona.getV_coderror());
						}
						
						//INICIO ENVIO DE CORREO EN CASO DE ERROR DEL WEB SERVICE
						boolean validaEnvioCorreo = false;
						if (!"DNE".equals(resultPersona.getV_coderror()) 
								&& !"NHC".equals(resultPersona.getV_coderror()) && 
								!"21".equals(resultPersona.getV_coderror()) && 
								!"22".equals(resultPersona.getV_coderror()) && 
								!"23".equals(resultPersona.getV_coderror()))
							//NHC: Reniec no nos dice que significa pero al parecer tambien es un código que indica que no existe en RENIEC
							//21:cancelado | 22: restringido | 23: observado => en el RUIPN
						{
							//SI ES CUALQUIER OTRO ERROR DIFERENTE A QUE EL DNI SEA INCORRECTO
							validaEnvioCorreo = true;
						}
						
						if(validaEnvioCorreo==true){
							EnviarMail enviarCorreo=new EnviarMail();
							String[] direcciones=new String[4];
							direcciones[0]="kaguilar@sunafil.gob.pe";//Karina
							direcciones[1]="amatienzo@sunafil.gob.pe";//Richard
							direcciones[2]="rgarrido@sunafil.gob.pe";//Richard
							direcciones[3]="sistemas.sunafil@gmail.com";
							String mensaje="";								
							String asunto="Error Web Service de RENIEC EN DENUNCIAVIRTUAL ("+resultPersona.getV_coderror()+")";
							mensaje  ="<b>DNI</b> consultado =<b>'"+persona.getV_numdoc()+"'</b> <br/>"
									 + "::El c&oacute;digo de Error enviado por RENIEC es: <br/>" 
									 + "::reniecBean.getV_coderror()=><b>"+resultPersona.getV_coderror()+"</b>";
							if(direcciones.length>0 && direcciones!=null){
								try {
									enviarCorreo.generarEnvioDeCorreos(mensaje, direcciones,asunto);
								} catch (Exception e1) {
									logger.error("Error al enviar el correo, e.getMessage()=>"+e1.getMessage());
									logger.error(e1.getMessage(),e1);
								}
							}
						}
					}					
				}
				/*
				else if(verificacion.equals("ER")){//ER:EXISTE Y DE RENIEC
					paso="2";//LE INDICAMOS QUE YA NO UN PASO DE WS
					//SOLO CONSULTAMOS A NUESTRA BD
					logger.info("VERIFICACION = 'SA' PERSONA ACTUALIZADA");
					resultPersona=dspPersonaReniec.getTrabajador(persona.getV_numdoc());
				}
				*/
				
				
			} else {
				logger.info("El DNI consultado tiene "+persona.getV_numdoc().length()+" digitos, debe de tener 8 dígitos!! no pasa a consulta de RENIEC.");
				resultPersona.setV_coderror("8Digitos");
			}
			
			
		} catch (AxisFault e) {
			resultPersona.setV_coderror("AXISFAULT");//LO MANDAMOS COMO SERVICIO RENIEC CAIDO.
			logger.error("SERVICIO RENIEC CAIDOOOOOOOOOOOOOOOOOOOOOOOOO!!!!!!!!!!!");
			logger.error(e.getMessage(),e);
			/**INICIO ENVIO DE CORREO EN CASO DE ERROR DEL METODO**/
		
			EnviarMail enviarCorreo=new EnviarMail();
			String[] direcciones=new String[4];		
			direcciones[0]="kaguilar@sunafil.gob.pe";//kaguilar
			direcciones[1]="amatienzo@sunafil.gob.pe";//matienzo
			direcciones[2]="rgarrido@sunafil.gob.pe";
			direcciones[3]="sistemas.sunafil@gmail.com";
			String mensaje="";								
			String asunto="Servicio RENIEC CAIDO(AXISFAULT) - Web Service de RENIEC en DENUNCIAVIRTUAL";
			mensaje="DNI consultado =<b>'"+persona.getV_numdoc()+"'</b> <br/><br/><b>:::EXCEPTION (e):</b> "
					 + "<br/><br/> <b>:::e.printStackTrace()=></b><br/><br/> "
					 + EnviarMail.getStackTraceToHTML(e);
			if(direcciones.length>0 && direcciones!=null){
				try {
					enviarCorreo.generarEnvioDeCorreos(mensaje, direcciones,asunto);
				} catch (Exception e1) {
					logger.info("Error al enviar el correo, e.getMessage()=>"+e1.getMessage());
					logger.error(e1.getMessage(),e1);
				}
			}
			return resultPersona;
		}
		catch (Exception e) {	
			resultPersona.setV_coderror("EXCEPTION");
			
			logger.error(e.getMessage(),e);
			/**INICIO ENVIO DE CORREO EN CASO DE ERROR DEL METODO**/
			if(paso.equals("1")){//SI SE QUEDO EN PASO 1 QUIERE DECIR QUE EL WS ARROJÓ EL ERROR.
				EnviarMail enviarCorreo=new EnviarMail();
				String[] direcciones=new String[4];		
				direcciones[0]="kaguilar@sunafil.gob.pe";//kaguilar
				direcciones[1]="amatienzo@sunafil.gob.pe";//matienzo
				direcciones[2]="rgarrido@sunafil.gob.pe";
				direcciones[3]="sistemas.sunafil@gmail.com";
				String mensaje="";								
				String asunto="Error GRAVE Web Service de RENIEC en DENUNCIAVIRTUAL";
				mensaje="DNI consultado =<b>'"+persona.getV_numdoc()+"'</b> <br/><br/><b>:::EXCEPTION (e):</b> "
						 + "<br/><br/> <b>:::e.printStackTrace()=></b><br/><br/> "
						 + EnviarMail.getStackTraceToHTML(e);
				if(direcciones.length>0 && direcciones!=null){
					try {
						enviarCorreo.generarEnvioDeCorreos(mensaje, direcciones,asunto);
					} catch (Exception e1) {
						logger.info("Error al enviar el correo, e.getMessage()=>"+e1.getMessage());
						logger.error(e1.getMessage(),e1);
					}
				}
			}
			
			return resultPersona;
		}
		resultPersona.valuesToString();
		return resultPersona;
		
	}


}
