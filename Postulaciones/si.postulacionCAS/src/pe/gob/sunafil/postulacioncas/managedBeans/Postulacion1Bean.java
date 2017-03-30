package pe.gob.sunafil.postulacioncas.managedBeans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.reniec.rel.ReniecBean;

import pe.gob.sunafil.pidereniec.bean.PersonaReniecBean;
import pe.gob.sunafil.postulacioncas.bean.Combo;
import pe.gob.sunafil.postulacioncas.bean.HojaDeVida;
import pe.gob.sunafil.postulacioncas.bean.Persona;
import pe.gob.sunafil.postulacioncas.funciones.Funciones;
import pe.gob.sunafil.postulacioncas.mybatis.despachadores.CombosDespatch;
import pe.gob.sunafil.postulacioncas.mybatis.despachadores.Postulacion1Despatch;
import pe.gob.sunafil.postulacioncas.reniecws.PideReniecWebService;
import pe.gob.sunafil.postulacioncas.reniecws.ReniecWebService;
import pe.gob.sunafil.postulacioncas.utils.FacesUtils;



@ManagedBean(name="postulacion1Bean")
@SessionScoped
public class Postulacion1Bean {
	private static Logger logger = Logger.getLogger(Postulacion1Bean.class.getName());
	
	private HojaDeVida hojadevida;
	private Persona persona;
	private List<Combo> listaProvinciasNac;
	private List<Combo> listaDistritosNac;
	private List<Combo> listaProvinciasDom;
	private List<Combo> listaDistritosDom;
	private CombosDespatch dspcombos = new CombosDespatch();
	private Postulacion1Despatch dsppost1 = new Postulacion1Despatch();
	private boolean muestraLineaPuesto; 
	private String mensajeValidacion;
	//PARA MANEJAR CON RENIEC:
	private boolean is_NombresReadonly;
	private boolean is_NumDocReadonly;
	private boolean show_btn_reniec;
	private boolean show_btn_cambioNumDoc;
	
	public Postulacion1Bean() {
		inicializar();
	}
	@SuppressWarnings("rawtypes")
	public void inicializar(){
		logger.info("Entra a inicializar postulacion1Bean");
		try {
			hojadevida = new HojaDeVida();
			persona = new Persona();
			listaProvinciasNac = new ArrayList<Combo>();
			listaDistritosNac = new ArrayList<Combo>();
			muestraLineaPuesto = true;
			mensajeValidacion = "";

			is_NombresReadonly = true;//POR DEFECTO LOS CAMPOS SON READONLY
			show_btn_reniec = false;//POR DEFECTO EL BTN DE BUSQUEDA RENIEC NO SE MUESTRA
			show_btn_cambioNumDoc = false;//POR DEFECTO EL BTN DE CAMBIO DE TIPO Y NRO DE DOC NO SE MUESTRA
			is_NumDocReadonly = false;//POR DEFECTO EL TIPO Y NRO DE DOCUMENTO NO SON READONLY  
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	
	
	/**
	 * obtiene los distritos por el departamento seleccionado
	 */
	public void selCmbDepartamentoNac(){
		logger.info("Obteniendo Cmb Provincia de Nacimiento");
		try{
			listaProvinciasNac = new ArrayList<Combo>();
			String coddep = persona.getV_coddepnac(); 
			listaProvinciasNac = dspcombos.listaProvinciasxDep(coddep);
			
			//DESSELECCIONANDO LA PROVINCIA
			persona.setV_codpronac("");
			//DESSELECCIONANDO EL DISTRITO
			persona.setV_coddisnac("");
			
			//LIMPIAMOS LOS DISTRITOS
			listaDistritosNac = new ArrayList<Combo>();
			
		}catch(Exception e){
			logger.error("Error en Listar las provincias y distritos: "+e.getMessage(),e);
		}
	}
	
	public void selCmbProvinciaNac(){
		logger.info("Obteniendo Cmb Distrito");
		try{
			listaDistritosNac = new ArrayList<Combo>();
			String coddep = persona.getV_coddepnac();
			String codpro = persona.getV_codpronac();
			listaDistritosNac = dspcombos.listaDistritosxPro(coddep,codpro);
			//DESSELECCIONANDO EL DISTRITO
			persona.setV_coddisnac("");
			
		}catch(Exception e){
			logger.error("Error en Listar los distritos: "+e.getMessage(),e);
		}
	}
	
	/**
	 * obtiene los distritos del domicilio del postulante por el departamento seleccionado
	 */
	public void selCmbDepartamentoDom(){
		logger.info("Obteniendo Cmb Provincia de Domicilio");
		System.out.println("obteniendo provincias lalala");
		try{
			listaProvinciasDom = new ArrayList<Combo>();
			String coddep = hojadevida.getV_coddepdom(); 
			listaProvinciasDom = dspcombos.listaProvinciasxDep(coddep);
			
			//DESSELECCIONANDO LA PROVINCIA
			hojadevida.setV_codprodom("");
			//DESSELECCIONANDO EL DISTRITO
			hojadevida.setV_coddisdom("");
			
			//LIMPIAMOS LOS DISTRITOS
			listaDistritosDom = new ArrayList<Combo>();
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error en Listar las provincias y distritos de domicilio: "+e.getMessage(),e);
		}
	}
	
	public void selCmbProvinciaDom(){
		logger.info("Obteniendo Cmb Distrito");
		try{
			listaDistritosDom = new ArrayList<Combo>();
			String coddep = hojadevida.getV_coddepdom();
			String codpro = hojadevida.getV_codprodom();
			listaDistritosDom = dspcombos.listaDistritosxPro(coddep,codpro);
			//DESSELECCIONANDO EL DISTRITO
			hojadevida.setV_coddisdom("");
			
		}catch(Exception e){
			logger.error("Error en Listar los distritos de domicilio: "+e.getMessage(),e);
		}
	}
	
	public void selCmbConvocatoria(){
		logger.info("Obteniendo el Nombre de la Convocatoria");
		try{
			
			String p_corconv = hojadevida.getN_corconv();
			if(p_corconv.equals("")){
				hojadevida.setV_desconv(null);
				muestraLineaPuesto=true;
			}else{
				String v_desconv = dsppost1.obtieneNombreConvocatoria(p_corconv);
				
				hojadevida.setV_desconv(v_desconv);
				if(v_desconv==null){
					muestraLineaPuesto=true;
				}else{
					muestraLineaPuesto=false;
				}
				
			}
			
		}catch(Exception e){
			logger.error("Error en selCmbConvocatoria: "+e.getMessage(),e);
		}
	}
	
	
	public void selCmbTipoDocumento(){
		logger.info("Tipo de Documento Seleccionado=>"+persona.getV_codtdocide());
		try{
			
			//PARA EL DNI:
			is_NombresReadonly = false;
			show_btn_reniec=false;
			if("".equals(persona.getV_codtdocide()) || "03".equals(persona.getV_codtdocide())){
				is_NombresReadonly = true;
				if("03".equals(persona.getV_codtdocide())){
					show_btn_reniec=true;
				}
			}
			
		}catch(Exception e){
			logger.error("Error al seleccionar el Tipo de Documentos: "+e.getMessage(),e);
		}
	}
	
	public void obtenerPersonReniec() throws Exception{
		
		System.out.println("Buscando en RENIEC...");
		
		//A QUE WEB SERVICE CONSULTAR:
		String tipo = "RENIEC"; //RENIEC/PIDE
		
		
		RequestContext context = RequestContext.getCurrentInstance();
		boolean flagDlgAlertDigitos=false;//CUANDO NO DIGITA 8 NUMEROS
		boolean flagDlgObtReniec=false;//CUANDO NO ENCUENTRA EL DNI EN RENIEC
		boolean flagDlgErrorWS = false;// CUANDO OCURRE UN EXCEPTION
		boolean flagDlglimiteConsulRENIEC = false;//LIMITE DE CONSULTAS AL DÍA
		//MENSAJES ADICIONALES PARA EL MAIN RENIEC WS
		boolean flagDlgDNIConRUIPN = false;
		boolean flagDlgHorarioFueraRENIEC = false;
		boolean flagDlgSinAccesoToRENIEC = false;
		
		if(persona.getV_numdoc().length()!=8){
			System.out.println("No tiene 8 digitos el DNI");
			flagDlgAlertDigitos=true;
			context.addCallbackParam("flagDlgAlertDigitos", flagDlgAlertDigitos);
			return;
		}
		
		
		if("RENIEC".equals(tipo)){
			System.out.println("previo a consulta RENIEC");
			ReniecWebService rws = new ReniecWebService(FacesUtils.getIpAddress(),"RRHHSYS");
			
			ReniecBean rBean = rws.obtenerPersonaSWReniec(persona,"016");//016 ES EL CODIGO DEL SISTEMA DE POSTULACION
			if("0000".equals(rBean.getV_coderror())){
				logger.info("OBTUVO RENIECO CORRECTAMENTE :D");
				
					persona.setV_apepat(rBean.getV_appaterno());
					persona.setV_apemat(rBean.getV_apmaterno());
					persona.setV_nombres(rBean.getV_nombres());
					
					SimpleDateFormat simpleDate=new SimpleDateFormat("dd/MM/yyyy");
					Date fechaNac=simpleDate.parse(rBean.getV_fecnac());
					persona.setD_fecnac(fechaNac);
					
					persona.setV_flgreniec("S");//MANDANDO EL FLAGRENIEC "S"
					
			}else if("DNE".equals(rBean.getV_coderror()) || "NHC".equals(rBean.getV_coderror())){
	    		
				//FacesUtils.showFacesMessage("Estimado usuario, su número de DNI no se encontró en RENIEC, por favor verificar.", 1);
				persona.setV_apepat("");
				persona.setV_apemat("");
				persona.setV_nombres("");
				persona.setD_fecnac(null);
				is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
				flagDlgObtReniec=true;
				
			
			}else if( "21".equals(rBean.getV_coderror()) || "22".equals(rBean.getV_coderror()) || "23".equals(rBean.getV_coderror()) ){
				//FacesUtils.showFacesMessage("El DNI solicitado se encuentra cancelado(21), restringido(22) u observado(23) en el Registro Único de Identificación de las Personas Naturales (RUIPN)", 1);
				persona.setV_apepat("");
				persona.setV_apemat("");
				persona.setV_nombres("");
				persona.setD_fecnac(null);
				is_NombresReadonly=true;//NO SE DEJA INGRESAR MANUALMENTE
				flagDlgDNIConRUIPN = true;
				
			}else if("5".equals(rBean.getV_coderror())){
				//FacesUtils.showFacesMessage("Se alcanzaron el máximo de consultas por día a RENIEC, por favor intente en otro momento.", 1);
				persona.setV_apepat("");
				persona.setV_apemat("");
				persona.setV_nombres("");
				persona.setD_fecnac(null);
				is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
				flagDlglimiteConsulRENIEC=true;
				
			}else if("3".equals(rBean.getV_coderror())){
				//FacesUtils.showFacesMessage("La consulta a RENIEC no esta permitida en este horario del dia consultado, por favor intente en otro momento.", 1);
				persona.setV_apepat("");
				persona.setV_apemat("");
				persona.setV_nombres("");
				persona.setD_fecnac(null);
				is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
				flagDlgHorarioFueraRENIEC=true;
				
			}else if("2".equals(rBean.getV_coderror())){
				//FacesUtils.showFacesMessage("Actualmente no se cuenta con el servicio de RENIEC, por favor intente manualmente.", 1);
				persona.setV_apepat("");
				persona.setV_apemat("");
				persona.setV_nombres("");
				persona.setD_fecnac(null);
				is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
				flagDlgSinAccesoToRENIEC=true;
	    	}else if("EXCEPTION".equals(rBean.getV_coderror())){
	    		//FacesUtils.showFacesMessage("Se encontraron inconvenientes al consultar a RENIEC, por favor intente denuevo. Si el problema persiste comunicarse con la oficina de sistemas.", 1);
	    		persona.setV_nombres("");
				persona.setV_apepat("");
				persona.setV_apemat("");
				persona.setD_fecnac(null);
				is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
				flagDlgErrorWS=true;//SE MOSTRARA EL MENSAJE DE ERROR DE WEBSERVICE
				
	    	}else{
	    		//FacesUtils.showFacesMessage("El Servicio de RENIEC no se encuentra activo, por favor intente en otro momento.", 1);
	    		persona.setV_apepat("");
				persona.setV_apemat("");
				persona.setV_nombres("");
				persona.setD_fecnac(null);
				is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
				flagDlgSinAccesoToRENIEC=true;
	    	}
			
			//SIEMPRE SE APLICARA ESTO AL CONSULTAR POR RENIEC:
			is_NumDocReadonly=true;//NO SE EDITARA EL TIPO NI NRO DE DOC
			show_btn_cambioNumDoc=true;//SE MUESTRA EL BOTON DE CAMBIO DE TIPO U NUM DOC.
			show_btn_reniec=false;//NO SE MUESTRA EL BOTON DE RENIEC
			
		}else{//ES DE LA PIDE

			
				System.out.println("previo a consulta PIDE RENIEC");
				//OBTENIENDO DATOS DE RENIEC:
				PideReniecWebService rws = new PideReniecWebService();
				PersonaReniecBean personaRB = (PersonaReniecBean)rws.obtenerPersonaSWReniec(persona);
				if(personaRB==null){
					System.out.println("ERROR AL OBTENER DE RENIEC");
					//OCURRIO UN ERROR AL OBTENER PERSONA EN RENIEC:
					
					persona.setV_nombres("");
					persona.setV_apepat("");
					persona.setV_apemat("");
					
					flagDlgErrorWS=true;//SE MOSTRARA EL MENSAJE DE ERROR DE WEBSERVICE
					is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
					
				}else if("-8".equals(personaRB.getV_mensaje())){
					System.out.println("DNI NO EXISTE");
					//DNI NO EXISTE
					persona.setV_apepat("");
					persona.setV_apemat("");
					persona.setV_nombres("");
					is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
					flagDlgObtReniec=true;//EL DIALOG SE MOSTRARA INDICANDO EL INCONVENIENTE
					
				}else if("-3".equals(personaRB.getV_mensaje())){
					System.out.println("-3 -> SIGNIFICA QUE EXCEDIÓ  EL  MÁXIMO  NRO  DE  CONSULTAS  POR MINUTO");
					//DNI NO EXISTE
					persona.setV_apepat("");
					persona.setV_apemat("");
					persona.setV_nombres("");
					is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
					flagDlglimiteConsulRENIEC=true;//EL DIALOG SE MOSTRARA INDICANDO EL INCONVENIENTE
					
				}else if("AXISFAULT".equals(personaRB.getV_mensaje())){
					System.out.println("NO ESTA ACTIVO EL WEBSERVICES AXISFAULT");
					//ERROR AXISFAUL NO FUNCUIONA EL SERVICIO
					persona.setV_apepat("");
					persona.setV_apemat("");
					persona.setV_nombres("");
					is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
					flagDlgErrorWS=true;//SE MOSTRARA EL MENSAJE DE ERROR DE WEBSERVICE
					
				}else{
					logger.info("persona.getDni ==>"+personaRB.getV_dni());
					logger.info("persona.getNombre ==>"+personaRB.getV_nombres());
					logger.info("persona.getApellidoPaterno ==>"+personaRB.getV_apepat());
					logger.info("persona.getApellidoMaterno ==>"+personaRB.getV_apemat());
					persona.setV_apepat(personaRB.getV_apepat());
					persona.setV_apemat(personaRB.getV_apemat());
					persona.setV_nombres(personaRB.getV_nombres());
					is_NombresReadonly=true;//LOS CAMPOS DE NOMBRES SE PONDRAN READONLY PORQUE SON DE RENIEC
					flagDlgObtReniec=false;//EL DIALOG NO SE MOSTRARA INDICANDO EL INCONVENIENTE
				}
				
				//SIEMPRE SE APLICARA ESTO AL CONSULTAR POR RENIEC:
				is_NumDocReadonly=true;//NO SE EDITARA EL TIPO NI NRO DE DOC
				show_btn_cambioNumDoc=true;//SE MUESTRA EL BOTON DE CAMBIO DE TIPO U NUM DOC.
				show_btn_reniec=false;//NO SE MUESTRA EL BOTON DE RENIEC
				
			
		}
		
		context.addCallbackParam("flagDlgObtReniec", flagDlgObtReniec);
		context.addCallbackParam("flagDlglimiteConsulRENIEC", flagDlglimiteConsulRENIEC);
		context.addCallbackParam("flagDlgErrorWS", flagDlgErrorWS);
		context.addCallbackParam("flagDlgAlertDigitos", flagDlgAlertDigitos);
		//news
		context.addCallbackParam("flagDlgDNIConRUIPN", flagDlgDNIConRUIPN);
		context.addCallbackParam("flagDlgHorarioFueraRENIEC", flagDlgHorarioFueraRENIEC);
		context.addCallbackParam("flagDlgSinAccesoToRENIEC", flagDlgSinAccesoToRENIEC);
		
	}
	
	
	public void cambiaNumDoc() {
		System.out.println("Cambiando el tipo numdoc");
		is_NombresReadonly=true;//LOS CAMPOS DE NOMBRES SE PONDRAN READONLY COMO AL INICIALIZAR
		is_NumDocReadonly=false;//SE PODRA EDITAR EL TIPO NI NRO DE DOC
		show_btn_cambioNumDoc=false;//NO SE MUESTRA EL BOTON DE CAMBIO DE TIPO U NUM DOC.
		show_btn_reniec=false;//NO SE MUESTRA EL BOTON DE RENIEC
		//BLANQUEAMOS LOS DATOS DE LA PERSONA
		persona.setV_codtdocide("");
		persona.setV_numdoc("");
		persona.setV_apepat("");
		persona.setV_apemat("");
		persona.setV_nombres("");
		persona.setD_fecnac(null);
		
	}
	
	
	public String goToDatos2Postulaciones(){
		String salida="pretty:registroPostulacion2";
		//VALIDAMOS LOS DATOS INGRESADOS:
		
		if(!validaPostulacion1()){
			Funciones.mostrarMensajeError(mensajeValidacion);
			return null;
		}
		
		return salida;
	}
	
	@SuppressWarnings("deprecation")
	public boolean validaPostulacion1(){
		
		logger.info("Validando información");
		if("".equals(hojadevida.getN_corconv())){
			mensajeValidacion="Por favor seleccione la postulación.";
			return false;
		}
		if("".equals(persona.getV_codtdocide())){
			mensajeValidacion="Por favor seleccione el tipo de documento.";
			return false;
		}
		
		if("".equals(persona.getV_apepat().trim())){
			mensajeValidacion="Por favor ingrese su appelido paterno.";
			return false;
		}
		if("".equals(persona.getV_apemat().trim())){
			mensajeValidacion="Por favor ingrese su apellido materno.";
			return false;
		}
		if("".equals(persona.getV_nombres().trim())){
			mensajeValidacion="Por favor ingrese su nombre.";
			return false;
		}
		if("".equals(persona.getV_coddepnac())){
			mensajeValidacion="Por favor seleccione su departamento de nacimiento.";
			return false;
		}
		if("".equals(persona.getV_codpronac())){
			mensajeValidacion="Por favor seleccione su provincia de nacimiento.";
			return false;
		}
		if("".equals(persona.getV_coddisnac())){
			mensajeValidacion="Por favor seleccione su distrito de nacimiento.";
			return false;
		}
		System.out.println("d_fecnac=>>>>>>>>>>>>>>>>>"+persona.getD_fecnac());
		System.out.println("d_fecnac=>>>>>>>>>>>>>>>>>"+persona.toString());
		
		
		if(persona.getD_fecnac()!=null){
			int anio_pre = persona.getD_fecnac().getYear();
			int anio = anio_pre+1900;
			System.out.println("anio_pre=>"+anio_pre);
			System.out.println("anio=>"+anio);
			if(anio <= 1900){
				System.out.println(persona.getD_fecnac().getYear());
				mensajeValidacion="Por favor verifique su fecha de nacimiento, debe ser mayor al año 1900.";
				return false;
			}
		}
		else{
			mensajeValidacion="Por favor ingrese su fecha de nacimiento.";
			return false;
		}
		
		
		if("".equals(persona.getD_fecnac()) || persona.getD_fecnac()==null){
			mensajeValidacion="Por favor ingrese su fecha de nacimiento.";
			return false;
		}		
		if("".equals(hojadevida.getV_nacionalidad().trim())){
			mensajeValidacion="Por favor ingrese su nacionalidad.";
			return false;
		}
		if("".equals(hojadevida.getV_codestciv())){
			mensajeValidacion="Por favor seleccione su estado civil.";
			return false;
		}		
		
		if("".equals(hojadevida.getV_coddepdom())){
			mensajeValidacion="Por favor seleccione el departamento de su domicilio actual.";
			return false;
		}
		if("".equals(hojadevida.getV_codprodom())){
			mensajeValidacion="Por favor seleccione la provincia de su domicilio actual.";
			return false;
		}
		if("".equals(hojadevida.getV_coddisdom())){
			mensajeValidacion="Por favor seleccione el distrito de su domicilio actual.";
			return false;
		}
		if("".equals(hojadevida.getV_urbanizac().trim())){
			mensajeValidacion="Por favor ingrese la urbanización de su domicilio actual.";
			return false;
		}
		if("".equals(hojadevida.getV_direccion().trim())){
			mensajeValidacion="Por favor ingrese la direccion de su domicilio actual.";
			return false;
		}		
		if("".equals(hojadevida.getV_telfij().trim()) && "".equals(hojadevida.getV_telcel().trim())){
			mensajeValidacion="Por favor ingrese al menos un teléfono.";
			return false;
		}
		/*if("".equals(hojadevida.getV_telcel().trim())){
			mensajeValidacion="Por favor ingrese su celular.";
			return false;
		}*/		
		if(hojadevida.getV_correo()!=null && !"".equals(hojadevida.getV_correo().trim()))
		{
			if(!FacesUtils.validarEmail(hojadevida.getV_correo()))
			{
				mensajeValidacion="Por favor ingrese correo electrónico válido.";
				return false;
			}
		}
		else
		{
			mensajeValidacion="Por favor ingrese su correo electrónico.";
			return false;
		}
		
		/*
		if("".equals(hojadevida.getV_descolegio().trim())){
			mensajeValidacion="Por favor ingrese los datos de su colegio profesional.";
			return false;
		}
		if("".equals(hojadevida.getV_numregcol().trim())){
			mensajeValidacion="Por favor ingrese su número de registro su colegiatura.";
			return false;
		}
		*/
		if("".equals(hojadevida.getV_flgdis())){
			mensajeValidacion="Por favor seleccione si es una persona con discapacidad.";
			return false;
		}
		if("S".equals(hojadevida.getV_flgdis())){
			if("".equals(hojadevida.getV_flgcerdis())){
				mensajeValidacion="Por favor seleccione si cuenta con el certificado con discapacidad.";
				return false;
			}
		}
		if("".equals(hojadevida.getV_flglicfa())){
			mensajeValidacion="Por favor seleccione si tiene licencia de las fuerzas armadas.";
			return false;
		}
		if("S".equals(hojadevida.getV_flglicfa())){
			if("".equals(hojadevida.getV_flgcerlicfa())){
				mensajeValidacion="Por favor seleccione si cuenta con el certificado que lo acredite como miembro de las fuerzas armadas.";
				return false;
			}
		}
		
		return true;		
	}
	public void dialogReferencia(){		
		RequestContext.getCurrentInstance().execute("dialogWidget.show()");
	}
	
	
	/***************************************************************************************************************
	 * ************************          ZONA DE GETS Y SETS                   *************************************
	 ***************************************************************************************************************/

	public HojaDeVida getHojadevida() {
		return hojadevida;
	}
	public void setHojadevida(HojaDeVida hojadevida) {
		this.hojadevida = hojadevida;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<Combo> getListaProvinciasNac() {
		return listaProvinciasNac;
	}
	public void setListaProvinciasNac(List<Combo> listaProvinciasNac) {
		this.listaProvinciasNac = listaProvinciasNac;
	}
	public List<Combo> getListaDistritosNac() {
		return listaDistritosNac;
	}
	public void setListaDistritosNac(List<Combo> listaDistritosNac) {
		this.listaDistritosNac = listaDistritosNac;
	}
	public List<Combo> getListaProvinciasDom() {
		return listaProvinciasDom;
	}
	public void setListaProvinciasDom(List<Combo> listaProvinciasDom) {
		this.listaProvinciasDom = listaProvinciasDom;
	}
	public List<Combo> getListaDistritosDom() {
		return listaDistritosDom;
	}
	public void setListaDistritosDom(List<Combo> listaDistritosDom) {
		this.listaDistritosDom = listaDistritosDom;
	}
	public boolean isMuestraLineaPuesto() {
		return muestraLineaPuesto;
	}
	public void setMuestraLineaPuesto(boolean muestraLineaPuesto) {
		this.muestraLineaPuesto = muestraLineaPuesto;
	}
	public String getMensajeValidacion() {
		return mensajeValidacion;
	}
	public void setMensajeValidacion(String mensajeValidacion) {
		this.mensajeValidacion = mensajeValidacion;
	}
	public boolean isIs_NombresReadonly() {
		return is_NombresReadonly;
	}
	public void setIs_NombresReadonly(boolean is_NombresReadonly) {
		this.is_NombresReadonly = is_NombresReadonly;
	}
	public boolean isShow_btn_reniec() {
		return show_btn_reniec;
	}
	public void setShow_btn_reniec(boolean show_btn_reniec) {
		this.show_btn_reniec = show_btn_reniec;
	}
	public boolean isIs_NumDocReadonly() {
		return is_NumDocReadonly;
	}
	public void setIs_NumDocReadonly(boolean is_NumDocReadonly) {
		this.is_NumDocReadonly = is_NumDocReadonly;
	}
	public boolean isShow_btn_cambioNumDoc() {
		return show_btn_cambioNumDoc;
	}
	public void setShow_btn_cambioNumDoc(boolean show_btn_cambioNumDoc) {
		this.show_btn_cambioNumDoc = show_btn_cambioNumDoc;
	}
}