package pe.gob.mtpe.retorno.ws;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.xml.ws.WebServiceException;

import org.apache.log4j.Logger;
import org.reniec.rel.ObtenerPersonaReniec;
import org.reniec.rel.ReniecBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Distrito;
import pe.gob.mtpe.retorno.bean.Persona;
import pe.gob.mtpe.retorno.dao.PersonaDao;
import pe.gob.mtpe.retorno.dao.WebServiceDao;

/**
 * CLase que llama al web service reniec
 * @version 1.0
 *
 */
@Service("reniecWebService")
public class ReniecWebService {
	
	final static Logger logger=Logger.getLogger(ReniecWebService.class);
	
	@Autowired
	private PersonaDao personaDao;
	
	@Autowired
	private WebServiceDao webServiceDao;
	
	Map<String, String> datos;
	
	public ReniecWebService(){
		
	}
	
	/**
	 * Metodo usado para obtener el token de autenticacion 
	 * @param codigoError Codigo de error del web service
	 * @return String token de autenticacion
	 * @throws Exception excepcion general
	 */
	public String getnewSessionWS(String codigoError) throws Exception {
		
		String session="";
		try {		
			datos=webServiceDao.obenterDatosServicio();			
			ObtenerPersonaReniec opr = new ObtenerPersonaReniec();
			session=opr.obtenerSession(datos.get("V_USUARIO"), datos.get("V_CLAVE"));			
			return session;					
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
		
	}
	
	/**
	 * Metodo usado para obtener los datos de la persona
	 * @param persona objeto de la clase {@link pe.gob.mtpe.retorno.bean.Persona Persona}
	 * @return persona objeto de la clase {@link pe.gob.mtpe.retorno.bean.Persona Persona}
	 * @throws Exception excepcion general
	 */
	public Persona obtenerPersonaSWReniec(Persona persona) throws Exception{
		
		Distrito dis=new Distrito();

		
		String verificacion="";
		
			
			if (persona.getvCodtdocide().equals("03")) {
				//VERIFICAMOS SI LA PERSONA EXISTE Y ESTA ACTUALIZADA SEGUN RENIEC				
				verificacion=personaDao.verificaActuPersonaReniec(persona);				
				SimpleDateFormat simpleDate=new SimpleDateFormat("yyyymmdd");
				
				//SI NO EXISTE DEBE SER NULL ENTONCES SE CONSULTA Y SE INSERTA
				if(verificacion==null){						
						persona.setvFlgreniec("S");
						
						ReniecBean reniecBean = new ReniecBean();
						ObtenerPersonaReniec opr = new ObtenerPersonaReniec();
						
						String v_numdoc="";
						v_numdoc=persona.getvNumdoc();
						
						for(int i=0;i<3;i++){
							
							String sesion = "" + getnewSessionWS(reniecBean.getV_coderror());							
							reniecBean = opr.obtenerPersona(
									sesion, 
									datos.get("V_USUARIO"), 
									"5", 
									datos.get("V_DNIFUN"), 
									v_numdoc);
							
							if(!"0000".equals(reniecBean.getV_coderror())){
								if(!"SINV".equals(reniecBean.getV_coderror()) && !"UNL".equals(reniecBean.getV_coderror())){
									throw new WebServiceException(reniecBean.getV_coderror());
								}
							}
							else {
								persona.setvCodtdocide("03");
								persona.setvNumdoc(v_numdoc);
								persona.setvApepater(reniecBean.getV_appaterno());
								persona.setvApemater(reniecBean.getV_apmaterno());
								persona.setvNombres(reniecBean.getV_nombres());
								persona.setcCodsexo(reniecBean.getV_genero());
								persona.setV_coderror(reniecBean.getV_coderror());
								
								if(reniecBean.getV_fecnac()!=null){
									Date fecha=new Date();
									fecha=simpleDate.parse(reniecBean.getV_fecnac());							
									persona.setdFecnac(fecha);
								}
								break;
							}
						}					
						
						
						if("0000".equals(persona.getV_coderror())){
							dis.setvCoddepren(reniecBean.getV_coddepnac());
							dis.setvCodproren(reniecBean.getV_codprovnac());
							dis.setvCoddisren(reniecBean.getV_coddisnac());
							dis = personaDao.obtieneDistritoNacimiento(dis);
							if(dis!=null){
								persona.setvCoddepnac(dis.getvCoddep());
								persona.setvCodpronac(dis.getvCodpro());
								persona.setvCoddisnac(dis.getvCoddis());
							}
							
							personaDao.insertPersona(persona);
							
						}
					}
				else{
					//SI EXISTE  
					//SI ESTA ACTUALIZADO SOLO SE CONSULTA 
					if(verificacion.equals("S")){						
							DPersona parametro=new DPersona();
							parametro.setvNumdoc(persona.getvNumdoc());
							parametro.setvCodtdocide(persona.getvCodtdocide());
							persona=personaDao.buscarPersona(parametro);
							
					}else{
						//SINO SE ACTUALIZA LA PERSONA						
						ReniecBean reniecBean = new ReniecBean();
						ObtenerPersonaReniec opr = new ObtenerPersonaReniec();			
						
						String v_numdoc="";
						v_numdoc=persona.getvNumdoc();
						
						for(int i=0;i<3;i++){
							String sesion = "" + getnewSessionWS(reniecBean.getV_coderror());
							
							reniecBean = opr.obtenerPersona(
									sesion, 
									datos.get("V_USUARIO"), 
									"5", 
									datos.get("V_DNIFUN"), 
									v_numdoc);							

							
							if(!"0000".equals(reniecBean.getV_coderror())){
								if(!"SINV".equals(reniecBean.getV_coderror()) && !"UNL".equals(reniecBean.getV_coderror())){
									throw new WebServiceException(reniecBean.getV_coderror());
								}
							}
							else {
								persona.setvCodtdocide("03");
								persona.setvNumdoc(v_numdoc);
								persona.setvApepater(reniecBean.getV_appaterno());
								persona.setvApemater(reniecBean.getV_apmaterno());
								persona.setvNombres(reniecBean.getV_nombres());
								persona.setcCodsexo(reniecBean.getV_genero());
								persona.setV_coderror(reniecBean.getV_coderror());
								
								if(reniecBean.getV_fecnac()!=null){
									Date fecha=new Date();
									fecha=simpleDate.parse(reniecBean.getV_fecnac());							
									persona.setdFecnac(fecha);
								}
								break;
							}
						}
						
						if("0000".equals(persona.getV_coderror())){
							persona.setvFlgreniec("S");
							dis.setvCoddepren(reniecBean.getV_coddepnac());
							dis.setvCodproren(reniecBean.getV_codprovnac());
							dis.setvCoddisren(reniecBean.getV_coddisnac());
							dis = personaDao.obtieneDistritoNacimiento(dis);
							if(dis!=null){
								persona.setvCoddepnac(dis.getvCoddep());
								persona.setvCodpronac(dis.getvCodpro());
								persona.setvCoddisnac(dis.getvCoddis());
							}
							personaDao.actualizarPersona(persona);
							
						}
						persona.setV_coderror(reniecBean.getV_coderror());
					
						
					}
				}
			} else {
				return null;
			}
			
		return persona;
	}


}
