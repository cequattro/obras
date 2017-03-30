package pe.gob.sunafil.postulacioncas.managedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import pe.gob.sunafil.pidereniec.bean.PersonaReniecBean;
import pe.gob.sunafil.postulacioncas.bean.Combo;
import pe.gob.sunafil.postulacioncas.bean.DomicilioEntidad;
import pe.gob.sunafil.postulacioncas.bean.Entidad;
import pe.gob.sunafil.postulacioncas.bean.Reclamo;
import pe.gob.sunafil.postulacioncas.bean.TipoIdentificiacionReclamo;
import pe.gob.sunafil.postulacioncas.funciones.Funciones;
import pe.gob.sunafil.postulacioncas.mybatis.despachadores.CombosDespatch;
import pe.gob.sunafil.postulacioncas.mybatis.despachadores.ReclamoDespatch;
import pe.gob.sunafil.postulacioncas.mybatis.despachadores.ReporteDespatch;
import pe.gob.sunafil.postulacioncas.reniecws.PideReniecWebService;
import pe.gob.sunafil.postulacioncas.utils.FacesUtils;
import pe.gob.sunafil.postulacioncas.utils.Utilitarios;

@ManagedBean(name="libroBean")
@SessionScoped
public class LibroReclamBean {
	private static Logger logger = Logger.getLogger(LibroReclamBean.class.getName());
	
		
	private Reclamo reclamo;
	private Entidad entidad;
	private DomicilioEntidad domEntidad;
	private List<TipoIdentificiacionReclamo> lstTipIdentifReclamo;

	private List<Combo> listaProvincias;
	private List<Combo> listaDistritos;
	private List<Combo> listaTiposIdentifDeReclamo;
	private String[] selectedTiposIdentifDeReclamo;
	
	//DESCRIPCION DE OTRO TIPO DE IDENTIFICACION DE RECLAMO (tir)
	private String v_desotrtir;
	
	private boolean show_desotrtir;
	private boolean show_inputs_person;
	private boolean show_inputs_ruc;
	private boolean is_NombresReadonly;
	private boolean is_NumDocReadonly;
	private boolean show_btn_reniec;
	private boolean show_btn_cambioNumDoc;
	
	private CombosDespatch dspcombos = new CombosDespatch();
	
	//PARA MOSTRAR AL FINAL:
	private String numeroReclamo;
	
	/**
	 * Constructor
	 */
	public LibroReclamBean() {
		inicializar();
	}
	
	/**
	 * Metodo para inicializar los valores
	 */
	@SuppressWarnings("rawtypes")
	public void inicializar(){
		logger.info("Entra a inicializar LibroReclamoBean");
		try {
			reclamo = new Reclamo();
			entidad = new Entidad();
			domEntidad = new DomicilioEntidad();
			listaProvincias = new ArrayList<Combo>();
			listaDistritos = new ArrayList<Combo>();
			listaTiposIdentifDeReclamo = dspcombos.listaTiposIdentifDeReclamo();
			selectedTiposIdentifDeReclamo = new String[]{};
			show_desotrtir = false;
			show_inputs_person = true;//POR DEFECTO LA IMAGEN INICIAL SIN TIPO DE DOCUMENTO MOSTRARA LOS NOMBRES A LLENAR.
			show_inputs_ruc = false;
			
			is_NombresReadonly = true;//POR DEFECTO LOS CAMPOS SON READONLY
			
			show_btn_reniec = false;//POR DEFECTO EL BTN DE BUSQUEDA RENIEC NO SE MUESTRA
			show_btn_cambioNumDoc = false;//POR DEFECTO EL BTN DE CAMBIO DE TIPO Y NRO DE DOC NO SE MUESTRA
			is_NumDocReadonly = false;//POR DEFECTO EL TIPO Y NRO DE DOCUMENTO NO SON READONLY  
			
			v_desotrtir="";
			numeroReclamo="";
			logger.info("show_desotrtir=>"+show_desotrtir+" | show_inputs_person=>"+show_inputs_person+" | show_inputs_ruc=>"+show_inputs_ruc+" | ");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	/**
	 * Metodo que nos lleva al Formulario de Registro del Libro de Reclamaciones
	 * @return vista
	 */
	public String toRegistroLibro(){
		logger.info("Ingresando a la Consulta");
		//LIMPIAMOS LA PAGINA:
		inicializar();
		return "pretty:registroLibro";
	}
	
	
	public void selCmbDepartamento(){
		logger.info("Obteniendo Cmb Provincia");
		try{
			listaProvincias = new ArrayList<Combo>();
			String coddep = domEntidad.getV_coddep(); 
			listaProvincias = dspcombos.listaProvinciasxDep(coddep);
			
			//DESSELECCIONANDO LA PROVINCIA
			domEntidad.setV_codpro("");
			//DESSELECCIONANDO EL DISTRITO
			domEntidad.setV_coddis("");
			
			//LIMPIAMOS LOS DISTRITOS
			listaDistritos = new ArrayList<Combo>();
			
		}catch(Exception e){
			logger.error("Error en Listar las provincias y distritos: "+e.getMessage(),e);
		}
	}
	
	public void selCmbProvincia(){
		logger.info("Obteniendo Cmb Distrito");
		try{
			listaDistritos = new ArrayList<Combo>();
			String coddep = domEntidad.getV_coddep();
			String codpro = domEntidad.getV_codpro();
			listaDistritos = dspcombos.listaDistritosxPro(coddep,codpro);
			//DESSELECCIONANDO EL DISTRITO
			domEntidad.setV_coddis("");
			
		}catch(Exception e){
			logger.error("Error en Listar los distritos: "+e.getMessage(),e);
		}
	}
	
	
	
	public void selCmbTipoDocumento(){
		logger.info("Tipo de Documento Seleccionado=>"+entidad.getV_codtdocide());
		try{
			show_inputs_ruc=false;
			show_inputs_person=true;
			
			if(entidad.getV_codtdocide().equalsIgnoreCase("09")){
				show_inputs_ruc=true;
				show_inputs_person=false;
			}
			
			//PARA EL DNI:
			is_NombresReadonly = false;
			show_btn_reniec=false;
			if("".equals(entidad.getV_codtdocide()) || "03".equals(entidad.getV_codtdocide())){
				is_NombresReadonly = true;
				if("03".equals(entidad.getV_codtdocide())){
					show_btn_reniec=true;
				}
			}
			
		}catch(Exception e){
			logger.error("Error al seleccionar el Tipo de Documentos: "+e.getMessage(),e);
		}
	}
	
	
	public void verifMarcaOtros(){
		
		try{
			//System.out.println(Arrays.toString(selectedTiposIdentifDeReclamo));
			show_desotrtir=false;
			for (String tipo:selectedTiposIdentifDeReclamo){
				if (tipo.equals("99")){
					show_desotrtir=true;
					break;
				}
			}
			//System.out.println("Resultado show_desotrtir=>"+show_desotrtir);
			
		}catch(Exception e){
			logger.error("Error en Listar los distritos: "+e.getMessage(),e);
		}
	}
	
		
	public void mostrarDlgInsReclamo() {
		logger.info("validando Reclamo");
		RequestContext context = RequestContext.getCurrentInstance();
		boolean flagDlgInsReclamo=true;
		//========================================================================
		//=============== VALIDACION QUE NO SE PUDO EN LA VISTA ==================
		//========================================================================
				
		if ("03".equalsIgnoreCase(entidad.getV_codtdocide())){//SI ES DNI
			if(entidad.getV_numdoc().length()!=8){
				flagDlgInsReclamo=false;
				FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("libro.msg.err.dni8digitos"), 1);
			}else{
				if("".equals(entidad.getV_apepat()) ||"".equals(entidad.getV_nombres()) ){
					flagDlgInsReclamo=false;
					FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("libro.msg.err.nombres"), 1);
				}
			}
		}
		if ("09".equalsIgnoreCase(entidad.getV_codtdocide())){//SI ES RUC
			if(entidad.getV_numdoc().length()!=11){
				flagDlgInsReclamo=false;
				FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("libro.msg.err.ruc11digitos"), 1);
			}
		}
		if (!"99".equalsIgnoreCase(domEntidad.getV_codzona())){//SI NO ES "SIN ZONA" CODIGO 99
			if("".equals(domEntidad.getV_deszona().trim())){//Y NO DIGITO LA DESCRIPCCION DE LA ZONA
				flagDlgInsReclamo=false;
				FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("libro.msg.err.deszona"), 1);
			}
		}
		if("".equals(reclamo.getV_telcel().trim()) && "".equals(reclamo.getV_telfijo().trim())){
			flagDlgInsReclamo=false;
			FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("libro.msg.err.telef"), 1);
		}
		if(selectedTiposIdentifDeReclamo.length == 0){
			flagDlgInsReclamo=false;
			FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("libro.msg.err.tipidentifRec"), 1);
		}
		if(selectedTiposIdentifDeReclamo.length > 0){
			for (String tipo : selectedTiposIdentifDeReclamo){
				if ("99".equals(tipo) && "".equals(v_desotrtir.trim())){
					flagDlgInsReclamo=false;
					FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("libro.msg.err.desotrtir"), 1);
				}
			}
		}
		
		System.out.println("longitud de campos descipcción:: reclamo.v_desreclam="+reclamo.getV_desreclam().length()+" | v_desotrtir="+v_desotrtir.length());
		
		//AGREGANDO VALIDACION PARA LAS LONGITUDES DE LAS DESCRIPCIONES DE RECLAMO:
		if(v_desotrtir.length() > 300){
			flagDlgInsReclamo=false;
			FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("libro.msg.err.longDesOtrTIR")+v_desotrtir.length(), 1);
		}
		
		if(reclamo.getV_desreclam().length() > 600){
			flagDlgInsReclamo=false;
			FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("libro.msg.err.longDesReclam")+reclamo.getV_desreclam().length(), 1);
		}
		
		
		
		System.out.println(entidad.toString());
		context.addCallbackParam("flagDlgInsReclamo", flagDlgInsReclamo);		
	}
	
	
	
	
	public String registrarReclamo() throws Exception{
		String vista="pretty:registroExitoso";
		String mensajeError="";
		ReclamoDespatch dspReclamo = new ReclamoDespatch();
		
		//LIMPIANDO DATA
		if(entidad.getV_codtdocide().equals("09")){//RUC
			entidad.setV_apepat("");
			entidad.setV_apemat("");
			entidad.setV_nombres("");
		}else{
			entidad.setV_razsoc("");
		}
		reclamo.setV_email(reclamo.getV_email().toLowerCase());//A MINUSCULAS EL CORREO
		entidad.setV_numdoc(entidad.getV_numdoc().toUpperCase());//A MAYUSCULAS PARA CARNET DE EXTRANJERIA ETC
		try{
			mensajeError=dspReclamo.insertarReclamo(reclamo,entidad,domEntidad,selectedTiposIdentifDeReclamo,v_desotrtir);
		}catch(Exception e){
			mensajeError="Ocurrió un inconveniente con el ingreso de datos por favor vuelva a intentarlo, si el problema persiste por favor comuniquese con la Oficina de Informática.";
			FacesUtils.showFacesMessage(mensajeError, 1);
			vista="pretty:registroLibro";
			return vista;
		}
		numeroReclamo = mensajeError;
		
		return vista;
	}
	
	public void obtenerPersonReniec() throws Exception{
		System.out.println("Buscando en RENIEC...");
		RequestContext context = RequestContext.getCurrentInstance();
		boolean flagDlgObtReniec=false;
		boolean flagDlgAlertDigitos=false;
		boolean flagDlgErrorWS = false;
		boolean flagDlglimiteConsulRENIEC = false;
		/*
		if(entidad.getV_numdoc().length()==8){
			//OBTENIENDO DATOS DE RENIEC:
			PideReniecWebService rws = new PideReniecWebService();
			PersonaReniecBean persona = (PersonaReniecBean)rws.obtenerPersonaSWReniec(entidad);
			if(persona==null){
				System.out.println("ERROR AL OBTENER DE RENIEC");
				//OCURRIO UN ERROR AL OBTENER PERSONA EN RENIEC:
				
				entidad.setV_nombres("");
				entidad.setV_apepat("");
				entidad.setV_apemat("");
				
				flagDlgErrorWS=true;//SE MOSTRARA EL MENSAJE DE ERROR DE WEBSERVICE
				is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
				
			}else if("-8".equals(persona.getV_mensaje())){
				System.out.println("DNI NO EXISTE");
				//DNI NO EXISTE
				entidad.setV_apepat("");
				entidad.setV_apemat("");
				entidad.setV_nombres("");
				is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
				flagDlgObtReniec=true;//EL DIALOG SE MOSTRARA INDICANDO EL INCONVENIENTE
				
			}else if("-3".equals(persona.getV_mensaje())){
				System.out.println("-3 -> SIGNIFICA QUE EXCEDIÓ  EL  MÁXIMO  NRO  DE  CONSULTAS  POR MINUTO");
				//DNI NO EXISTE
				entidad.setV_apepat("");
				entidad.setV_apemat("");
				entidad.setV_nombres("");
				is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
				flagDlglimiteConsulRENIEC=true;//EL DIALOG SE MOSTRARA INDICANDO EL INCONVENIENTE
				
			}else if("AXISFAULT".equals(persona.getV_mensaje())){
				System.out.println("NO ESTA ACTIVO EL WEBSERVICES AXISFAULT");
				//ERROR AXISFAUL NO FUNCUIONA EL SERVICIO
				entidad.setV_apepat("");
				entidad.setV_apemat("");
				entidad.setV_nombres("");
				is_NombresReadonly=false;//SE DEJARA LOS CAMPOS DE NOMBRES PARA QUE DIGITE
				flagDlgErrorWS=true;//SE MOSTRARA EL MENSAJE DE ERROR DE WEBSERVICE
				
			}else{
				logger.info("persona.getDni ==>"+persona.getV_dni());
				logger.info("persona.getNombre ==>"+persona.getV_nombres());
				logger.info("persona.getApellidoPaterno ==>"+persona.getV_apepat());
				logger.info("persona.getApellidoMaterno ==>"+persona.getV_apemat());
				entidad.setV_apepat(persona.getV_apepat());
				entidad.setV_apemat(persona.getV_apemat());
				entidad.setV_nombres(persona.getV_nombres());
				is_NombresReadonly=true;//LOS CAMPOS DE NOMBRES SE PONDRAN READONLY PORQUE SON DE RENIEC
				flagDlgObtReniec=false;//EL DIALOG NO SE MOSTRARA INDICANDO EL INCONVENIENTE
			}
			//SIEMPRE SE APLICARA ESTO AL CONSULTAR POR RENIEC:
			is_NumDocReadonly=true;//NO SE EDITARA EL TIPO NI NRO DE DOC
			show_btn_cambioNumDoc=true;//SE MUESTRA EL BOTON DE CAMBIO DE TIPO U NUM DOC.
			show_btn_reniec=false;//NO SE MUESTRA EL BOTON DE RENIEC
			
		}else{
			flagDlgAlertDigitos=true;
		}
		*/
		
		context.addCallbackParam("flagDlgObtReniec", flagDlgObtReniec);
		context.addCallbackParam("flagDlglimiteConsulRENIEC", flagDlglimiteConsulRENIEC);
		context.addCallbackParam("flagDlgErrorWS", flagDlgErrorWS);
		context.addCallbackParam("flagDlgAlertDigitos", flagDlgAlertDigitos);
	}
	
	public void cambiaNumDoc() {
		System.out.println("Cambiando el tipo numdoc");
		is_NombresReadonly=true;//LOS CAMPOS DE NOMBRES SE PONDRAN READONLY COMO AL INICIALIZAR
		is_NumDocReadonly=false;//SE PODRA EDITAR EL TIPO NI NRO DE DOC
		show_btn_cambioNumDoc=false;//NO SE MUESTRA EL BOTON DE CAMBIO DE TIPO U NUM DOC.
		show_btn_reniec=false;//NO SE MUESTRA EL BOTON DE RENIEC
		//BLANQUEAMOS LOS DATOS DE LA PERSONA
		entidad.setV_codtdocide("");
		entidad.setV_numdoc("");
		entidad.setV_apepat("");
		entidad.setV_apemat("");
		entidad.setV_nombres("");
		
	}
	
	
	
	
	 public void generarConstancia(){
			try {
				ReporteDespatch dspReporte=new ReporteDespatch();					
				Map parameters = new HashedMap();
				//LA RUTA IMAGEN LA PONE EL METODO MOSTRARREPORTE
				List<Map>  lstReclamo=dspReporte.reporteConstanciaReclamo(reclamo);
				FacesUtils.mostrarReporte(parameters, "constancia_reclamo.jrxml", lstReclamo, "Constancia");
			} catch (JRException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Metodo Utilizado para cerrar sesion en el Sistema.
	 * @return
	 */
	public String salir(){
		logger.info("Terminando la Sesion");
		Utilitarios.terminarSesion();
		return "pretty:salir";
	}
	
	
	
	//####################################
	//ZONA DE GETERS Y SETERS
	//####################################
	
	public Reclamo getReclamo() {
		return reclamo;
	}
	
	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public DomicilioEntidad getDomEntidad() {
		return domEntidad;
	}

	public void setDomEntidad(DomicilioEntidad domEntidad) {
		this.domEntidad = domEntidad;
	}

	public List<TipoIdentificiacionReclamo> getLstTipIdentifReclamo() {
		return lstTipIdentifReclamo;
	}

	public void setLstTipIdentifReclamo(
			List<TipoIdentificiacionReclamo> lstTipIdentifReclamo) {
		this.lstTipIdentifReclamo = lstTipIdentifReclamo;
	}

	public List<Combo> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Combo> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public List<Combo> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Combo> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

	public List<Combo> getListaTiposIdentifDeReclamo() {
		return listaTiposIdentifDeReclamo;
	}

	public void setListaTiposIdentifDeReclamo(List<Combo> listaTiposIdentifDeReclamo) {
		this.listaTiposIdentifDeReclamo = listaTiposIdentifDeReclamo;
	}

	public String[] getSelectedTiposIdentifDeReclamo() {
		return selectedTiposIdentifDeReclamo;
	}

	public void setSelectedTiposIdentifDeReclamo(
			String[] selectedTiposIdentifDeReclamo) {
		this.selectedTiposIdentifDeReclamo = selectedTiposIdentifDeReclamo;
	}

	public String getV_desotrtir() {
		return v_desotrtir;
	}

	public void setV_desotrtir(String v_desotrtir) {
		this.v_desotrtir = v_desotrtir;
	}

	public boolean isShow_desotrtir() {
		return show_desotrtir;
	}

	public void setShow_desotrtir(boolean show_desotrtir) {
		this.show_desotrtir = show_desotrtir;
	}

	public boolean isShow_inputs_person() {
		return show_inputs_person;
	}

	public void setShow_inputs_person(boolean show_inputs_person) {
		this.show_inputs_person = show_inputs_person;
	}

	public boolean isShow_inputs_ruc() {
		return show_inputs_ruc;
	}

	public void setShow_inputs_ruc(boolean show_inputs_ruc) {
		this.show_inputs_ruc = show_inputs_ruc;
	}

	public boolean isIs_NombresReadonly() {
		return is_NombresReadonly;
	}

	public void setIs_NombresReadonly(boolean is_NombresReadonly) {
		this.is_NombresReadonly = is_NombresReadonly;
	}

	public boolean isIs_NumDocReadonly() {
		return is_NumDocReadonly;
	}

	public void setIs_NumDocReadonly(boolean is_NumDocReadonly) {
		this.is_NumDocReadonly = is_NumDocReadonly;
	}

	public boolean isShow_btn_reniec() {
		return show_btn_reniec;
	}

	public void setShow_btn_reniec(boolean show_btn_reniec) {
		this.show_btn_reniec = show_btn_reniec;
	}

	public boolean isShow_btn_cambioNumDoc() {
		return show_btn_cambioNumDoc;
	}

	public void setShow_btn_cambioNumDoc(boolean show_btn_cambioNumDoc) {
		this.show_btn_cambioNumDoc = show_btn_cambioNumDoc;
	}

	public String getNumeroReclamo() {
		return numeroReclamo;
	}

	public void setNumeroReclamo(String numeroReclamo) {
		this.numeroReclamo = numeroReclamo;
	}
}
