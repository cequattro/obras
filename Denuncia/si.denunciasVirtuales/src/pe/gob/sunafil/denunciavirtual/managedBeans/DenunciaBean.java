package pe.gob.sunafil.denunciavirtual.managedBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;

import org.apache.axis.AxisFault;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;
import org.reniec.rel.ReniecBean;

import pe.client.ClientePIDE;
import pe.gob.sunafil.denunciavirtual.bean.Combo;
import pe.gob.sunafil.denunciavirtual.bean.DocumentoxSolicitud;
import pe.gob.sunafil.denunciavirtual.bean.Empresa;
import pe.gob.sunafil.denunciavirtual.bean.Persona;
import pe.gob.sunafil.denunciavirtual.bean.Solicitud;
import pe.gob.sunafil.denunciavirtual.funciones.Funciones;
import pe.gob.sunafil.denunciavirtual.mybatis.despachadores.CombosDespatch;
import pe.gob.sunafil.denunciavirtual.mybatis.despachadores.EmpleadorDespatch;
import pe.gob.sunafil.denunciavirtual.mybatis.despachadores.ReporteDespatch;
import pe.gob.sunafil.denunciavirtual.persistence.model.DlmvSolicitud;
import pe.gob.sunafil.denunciavirtual.persistence.model.DlmvdDocxsol;
import pe.gob.sunafil.denunciavirtual.persistence.model.DltbEmpleador;
import pe.gob.sunafil.denunciavirtual.persistence.model.DltbcMateria;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbDepxdistrito;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbTipomoneda;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdmvcHojarutaKey;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcCorrelativo;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcEntidad;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbdCentrolab;
import pe.gob.sunafil.denunciavirtual.reniecws.ReniecWebService;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcSoldenvirtual;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.SitbEmpleador;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.VstIntendenRegionales;
import pe.gob.sunafil.denunciavirtual.utils.EnviarMail;
import pe.gob.sunafil.denunciavirtual.utils.FacesUtils;
import pe.gob.sunat.servicio2.registro.consultaruc.bean.BeanDdp;



@ManagedBean(name="denunciaBean")
@SessionScoped
public class DenunciaBean {
	
	private static Logger logger = Logger.getLogger(DenunciaBean.class.getName());
	
	private boolean datos2MostrarSgte=false;
	
	private Solicitud solicitud;
	private DocumentoxSolicitud docxsolicitud;
	private List<Combo> listaProvinciasEmp;
	private List<Combo> listaDistritosEmp;	
	private CombosDespatch dspcombos = new CombosDespatch();
	private List<Combo> listaProvinciasPer;
	private List<Combo> listaDistritosPer;
	private boolean labora=false;
	private String mensaje;
	private String materia;
	private BeanDdp datosRUC;
	private List <SitbTipomoneda> listaTipoMoneda;
	private List <DltbcMateria> listaMateria;
	
	//FILE INICIAL
	private UploadedFile file;
	private String fileName;
	
	//FILE DNI
	private UploadedFile fileDNI;
	private String fileDNIName;
	
	//FILE CONTRATO
	private UploadedFile fileContrato;
	private String fileContratoName;
	
	//FILE BOLETA
	private UploadedFile fileBoleta;
	private String fileBoletaName;
	
	//FILE OTROS
	private UploadedFile fileOtros;
	private String fileOtrosName;
	
	
	private TdmvcRegistro registroGuardado;
	private TdtbcEntidad entidadSeleccionada;
	private TdtbdCentrolab direccionSeleccionada;
	private SitbDepxdistrito unidadSIITSeleccionada;
	private String esMTPE;
	private TdtbcIntendencia intendenciaTrExSeleccionada;
	private VstIntendenRegionales intendenciaSIITSeleccionada;
	
	/**
	 * Constructor
	 */
	public DenunciaBean(){
		inicializar();
	}
	
	/**
	 * Metodo para inicializar valores:
	 */
	public void inicializar(){
		logger.info("Entra a inicializar DenunciaBean");
		try {
			solicitud = new Solicitud();
			solicitud.setPersona(new Persona());
			solicitud.setEmpresa(new Empresa());
			docxsolicitud = new DocumentoxSolicitud();
			datos2MostrarSgte=false;
			mensaje="";
			materia="";
			fileName=null;
			file=null;
			fileDNIName=null;
			fileDNI=null;
			fileContratoName=null;
			fileContrato=null;
			fileBoletaName=null;
			fileBoleta=null;
			fileOtrosName=null;
			fileOtros=null;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	
	/**
	 * Metodo que dirige al usuario a la pantalla del PASO 1
	 * @return
	 */
	public String datos1DenunciaVirtual(){
		logger.info("Ingresando al formulario de Denuncia Virtual a la Pantalla PASO 1");
		inicializar();
		return "pretty:registroTrabajador";
	}
	
	/**
	 * Metodo llamado en la pantalla del PASO 1, para validar los datos de la persona y pasar al PASO 2
	 * @return
	 */
	public String datos2Empleador(){
		
		logger.info("Verificando Trabajador (DNI y codigo de verificacion) para pasar al PASO 2.");
		
		String vista="pretty:registroTrabajador";
		
		solicitud.getPersona().setV_codtdocide("03");//TODOS SERAN DNI
		
		if(solicitud.getPersona().getV_numdoc()!=null && !"".equals(solicitud.getPersona().getV_numdoc().trim()) 
				&& solicitud.getPersona().getV_codverific()!=null && !"".equals(solicitud.getPersona().getV_codverific().trim())){
			
			if(solicitud.getPersona().getV_numdoc().length()<8){
				FacesUtils.showFacesMessage("Estimado usuario, su número de DNI no cuenta con 8 dígitos, por favor verificar.", 1);
			}else{
				ReniecWebService rws = new ReniecWebService(FacesUtils.getIpAddress(),"DENVIRTUAL");
				
				ReniecBean rBean = rws.obtenerPersonaSWReniec(solicitud.getPersona(),"012");
				if("0000".equals(rBean.getV_coderror())){
					
					if(solicitud.getPersona().getV_codverific().equals(rBean.getV_codverific())){
						solicitud.getPersona().setV_appaterno(rBean.getV_appaterno());
						solicitud.getPersona().setV_apmaterno(rBean.getV_apmaterno());
						solicitud.getPersona().setV_nombres(rBean.getV_nombres());
						solicitud.getPersona().setV_flgreniec("S");//MANDANDO EL FLAGRENIEC "S"
						solicitud.getPersona().setV_codverific(rBean.getV_codverific());//
						logger.info("Ingresando a PASO 2");
						vista="pretty:registroEmpleador";
					}else{
						FacesUtils.showFacesMessage("Estimado usuario el DNI o el código de verificación ingresado es incorrecto, favor de validar.", 1);
					}	

				}else if("DNE".equals(rBean.getV_coderror()) || "NHC".equals(rBean.getV_coderror())){
		    		FacesUtils.showFacesMessage("Estimado usuario, su número de DNI no se encontró en RENIEC, por favor verificar.", 1);
				}else if("21".equals(rBean.getV_coderror())){
					FacesUtils.showFacesMessage("El DNI solicitado se encuentra cancelado en el Registro Único de Identificación de las Personas Naturales (RUIPN)", 1);
				}else if("22".equals(rBean.getV_coderror()) ){
					FacesUtils.showFacesMessage("El DNI solicitado se encuentra restringido en el Registro Único de Identificación de las Personas Naturales (RUIPN)", 1);
				}else if("23".equals(rBean.getV_coderror())){
					FacesUtils.showFacesMessage("El DNI solicitado se encuentra observado en el Registro Único de Identificación de las Personas Naturales (RUIPN)", 1);
				}else if("5".equals(rBean.getV_coderror())){
					FacesUtils.showFacesMessage("Se alcanzaron el máximo de consultas por día a RENIEC, para validar su codigo de verificación, por favor intente en otro momento.", 1);
				}else if("3".equals(rBean.getV_coderror())){
					FacesUtils.showFacesMessage("La consulta a RENIEC no esta permitida en este horario del dia consultado, para validar su codigo de verificación, por favor intente en otro momento.", 1);
		    	}else if("EXCEPTION".equals(rBean.getV_coderror())){
		    		FacesUtils.showFacesMessage("Se encontraron inconvenientes al consultar a RENIEC, por favor intente denuevo. Si el problema persiste comunicarse con la oficina de sistemas.", 1);
		    	}else{
		    		FacesUtils.showFacesMessage("El Servicio de RENIEC no se encuentra activo, para validar su codigo de verificación, por favor intente en otro momento.", 1);
		    	}
				
			}
			
			
		}else{
			FacesUtils.showFacesMessage("Debe ingresar su DNI y el dígito verificador.", 1);
		}
		
        return  vista;
	}
	
	/** 
	 * Metodo llamado en el PASO 2: Para validar datos del RUC y si pertenece a SUNAFIL o MTPE.
	 */
	public void activaRuc(){
		logger.info("PASO 2: Ingresando a ActivaRUC- Validacion de RUC ingresado");
		
		solicitud.getEmpresa().setV_razsoc(null);
		
		logger.info("RUC a evaluar=> "+solicitud.getEmpresa().getV_codemp());
		
		try{
			//VALIDAMOS SI TIENE 11 DIGITOS LO INGRESADO:
			if(solicitud.getEmpresa().getV_codemp()!=null){
				
				if(solicitud.getEmpresa().getV_codemp().trim().length()!=11){
					solicitud.getEmpresa().setV_razsoc(null);//INGRESAMOS NULL A LA RAZON SOCIAL
					FacesUtils.showFacesMessage("Estimado usuario, el RUC ingresado debe ser de 11 dígitos, favor de verificar.",1);
					return;
				}
				
			}else if("".equals(solicitud.getEmpresa().getV_codemp().trim()) || solicitud.getEmpresa().getV_codemp()==null){
				FacesUtils.showFacesMessage("Estimado usuario, debe ingresar un número de RUC.",1);
				return;
			}
			
			//INSTANCIANDO EL DESPACHADOR DE EMPLEADOR
			EmpleadorDespatch empDsp = new EmpleadorDespatch();
			
			//========================================================================================================================
			//VALIDAMOS SI EXISTE EN NUESTRA TABLA DLTB_EMPLEADOR
			//========================================================================================================================
			logger.info("Validamos si existe en nuestra tabla DLTB_EMPLEADOR");
			DltbEmpleador entEmpleador;
			try {
				entEmpleador=empDsp.getEmpleadorPorCodigo(solicitud.getEmpresa().getV_codemp());
			} catch (Exception e) {
				FacesUtils.showFacesMessage( "Estimado usuario, se presentaron inconvenientes al obtener los datos del empleador, por favor intentar nuevamente. Si el problema persiste por favor comunicarse con sistemas SUNAFIL.",1);
				return;
			}
			
			if(entEmpleador!=null){
				
				logger.info("Empleador si Existe en tabla DLTB_EMPLEADOR => "+entEmpleador.getvRazsoc());
				solicitud.getEmpresa().setV_razsoc(entEmpleador.getvRazsoc());//SETEAMOS LA RAZON SOCIAL
				
			}else{
				
				//========================================================================================================================
				//SI NO EXISTE EN DLTB_EMPLEADOR, BUSCAMOS EN LA TABLA SIMINTRA1.SITB_EMPLEADOR DE LA BD DEL MTPE:
				//========================================================================================================================
				logger.info("Verificamos si existe en la tabla SIMINTRA1.SITB_EMPLEADOR  de la BD MTPE");
				SitbEmpleador sitbEmpleador;
				try {
					sitbEmpleador=empDsp.getSitbEmpleadorPorRUC(solicitud.getEmpresa().getV_codemp());
				} catch (Exception e) {
					FacesUtils.showFacesMessage( "Estimado usuario, se presentaron inconvenientes al obtener los datos del empleador, por favor intentar nuevamente. Si el problema persiste por favor comunicarse con sistemas SUNAFIL.",1);
					return;
				}
				
				if(sitbEmpleador!=null){
					logger.info("Empleador si Existe en tabla SIMINTRA1.SITB_EMPLEADOR DE LA BD DEL MTPE: => "+sitbEmpleador.getvRazsoc());
					solicitud.getEmpresa().setV_razsoc(sitbEmpleador.getvRazsoc());//SETEAMOS LA RAZON SOCIAL
					
				}else{
					
					//========================================================================================================================
					//SI NO EXISTE EN NINGUNA DE LAS DOS TABLAS ANTERIRES, SE CONSULTA AL WS DE SUNAT:
					//========================================================================================================================
					logger.info("Se procede a consultar al WS de SUNAT, al no encontrarse en las tablas anteriores.");
					ClientePIDE ws=new ClientePIDE();
					try {
						datosRUC=ws.getDatosPrincipalesTh(solicitud.getEmpresa().getV_codemp());
					} catch (AxisFault e) {
						logger.error("Error AxisFault al conectarse al WS de SUNAT => "+e.getMessage(),e);
						datosRUC=null;					
						FacesUtils.showFacesMessage("Estimado usuario, en estos momentos no podemos conectarnos con SUNAT para obtener los datos del Empleador, porfavor intentar más tarde.",1);
						return;
					} catch (Exception e) {
						logger.error("Error Exception al conectarse al WS de SUNAT=> => "+e.getMessage(),e);
						datosRUC=null;
						FacesUtils.showFacesMessage("Estimado usuario, en estos momentos no podemos conectarnos con SUNAT para obtener los datos del Empleador, porfavor intentar más tarde.",1);
						return;
					}
					
					
					if(datosRUC!=null && datosRUC.getDdp_nombre()!=null){
						solicitud.getEmpresa().setV_razsoc(datosRUC.getDdp_nombre());//SETEAMOS LA RAZON SOCIAL
					}else{
						//SI AL OBTENER DE SUNAT NO ENCONTRAMOS NADA SE LE AVISA AL TRABAJADOR	
						solicitud.getEmpresa().setV_razsoc(null);
						FacesUtils.showFacesMessage("Estimado usuario, el RUC ingresado no existe, por favor verificar.",1);
						return;
					}					
					
				}
				
				//========================================================================================================================
				//SE INSERTA EN LA TABLA DLTB_EMPLEADOR, EN CASO HAYAMOS OBTENIDO A LA EMPRESA DE OTRA FUENTE:
				//========================================================================================================================
				logger.info("Insertando el empleador obtenido en la BD");
				DltbEmpleador empleador=new DltbEmpleador();
				empleador.setvCodemp(solicitud.getEmpresa().getV_codemp());
				empleador.setvRazsoc(solicitud.getEmpresa().getV_razsoc());
				int result =  empDsp.insertarEmpleador(empleador);
				if(result == 0 ) {
					solicitud.getEmpresa().setV_razsoc("");
					solicitud.getEmpresa().setV_codemp("");
					FacesUtils.showFacesMessage( "Estimado usuario, se presentaron inconvenientes con el empleador, por favor intente denuevo. Si el problema persiste por favor comunicarse con sistemas SUNAFIL.",1);
					return;
				}
				
			}
			
			//========================================================================================================================
			//VERIFICAMOS SI ES DE COMPETENCIA DE SUNAFIL:
			//========================================================================================================================
			try {
				esMTPE = empDsp.verificarEmpMTPE(solicitud.getEmpresa());
			} catch (Exception e) {
				FacesUtils.showFacesMessage( "Estimado usuario, se presentaron inconvenientes al validar los datos del empleador, por favor intentar nuevamente. Si el problema persiste por favor comunicarse con sistemas SUNAFIL.",1);
				return;
			}
			
			logger.info("Es una empresa que le compete al MTPE?=>"+esMTPE);
			if("SI".equalsIgnoreCase(esMTPE)){
				FacesUtils.showFacesMessage("Estimado usuario, Sunafil no tiene competencia para inspeccionar a su empleador por tratarse de una microempresa. Por favor, diríjase a la Dirección Regional de Trabajo donde se encuentre su centro de trabajo.",1);
				return;
			}
			
			
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			FacesUtils.showFacesMessage("Se encontraron inconvenientes, por favor intente denuevo. Si el problema persiste comunicarse con la oficina de sistemas SUNAFIL.", 1);
		}
	}
	
	public void cambiaDatosDeEmpPaso2(){
		logger.info("Cambiando de datos del empleador en paso2");
		datos2MostrarSgte=false;
	}
	
	
	/**
	 * Metodo el cual valida los datos de departamento provincia y distrito que es de competencia SUNAFIL
	 * => Actualización: Ya no sería necesario validar el UBIGEO porque pidieron que los combos dep prov y dist solo salgan los de competencia de sunafil
	 */
	public void activaDatos2EmpleadorSgte()
	{
		logger.info("PASO 2: Ingresando a activaDatos2EmpleadorSgte, validando la informacion para mostrar el boton de siguiente paso");
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		if("SI".equalsIgnoreCase(esMTPE)){
			//YA QUE LA EMPRESA LE COMPETE AL MTPE EL TRABAJADOR DEBE PRESENTAR SU SOLICITUD EN EL MTPE:				
			FacesUtils.showFacesMessage("Estimado usuario, Sunafil no tiene competencia para inspeccionar a su empleador por tratarse de una microempresa. Por favor, diríjase a la Dirección Regional de Trabajo donde se encuentre su centro de trabajo.",1);
			return;
		}
		if(solicitud.getEmpresa().getV_razsoc()!=null && !"".equals(solicitud.getEmpresa().getV_razsoc().trim()))
		{
			if(solicitud.getV_coddepemp()!=null && !"".equals(solicitud.getV_coddepemp().trim())){}
			else
			{
				FacesUtils.showFacesMessage("Por favor, debe seleccionar el departamento.",1);
				return;
			}
			
			if(solicitud.getV_codproemp()!=null && !"".equals(solicitud.getV_codproemp().trim())){}
			else
			{
				FacesUtils.showFacesMessage("Por favor, debe seleccionar la provincia.",1);
				return;
			}
			
			if(solicitud.getV_coddisemp()!=null && !"".equals(solicitud.getV_coddisemp().trim())){}
			else
			{
				FacesUtils.showFacesMessage("Por favor, debe seleccionar el distrito.",1);
				return;
			}
			
			List<String> intendenciasHabilitadas;
			try {
				intendenciasHabilitadas=empDsp.getIntendenciasHabilitadasSIIT();
			} catch (Exception e) {
				FacesUtils.showFacesMessage( "Estimado usuario, se presentaron inconvenientes, por favor intente denuevo. Si el problema persiste por favor comunicarse con sistemas SUNAFIL.",1);
				return;
			}
			
			if(!intendenciasHabilitadas.contains(solicitud.getV_coddepemp()))
			{
				datos2MostrarSgte=false;
				Combo empDep=new Combo();
				try {
					empDep=dspcombos.departamentoByCod(solicitud.getV_coddepemp()).get(0);
				} catch (Exception e) {
					logger.warn("No se pudo obtener el nombre del departamento pero igual se notifica al trabajador que presente su denuncia el su dirección regional.");
				}
				
				FacesUtils.showFacesMessage("Estimado usuario, Sunafil no tiene competencia para inspeccionar a su empleador en el departamento seleccionado. Por favor, diríjase a la Dirección Regional de Trabajo - "+empDep.getV_descripcion()+".",1);
				//FacesUtils.showFacesMessage("Estimado trabajador, favor de presentar su solicitud de inspección en la mesa de partes de la Dirección Regional de Trabajo - "+empDep.getV_descripcion()+".",1);
				return;
			}
			else
			{
				try {
					//*****************************************************************************************
					//SE ESTA OBTENIENDO LA DEPENDENCIA POR LA NUEVA TABLA SITB_DEPXDISTRITO (SIMINTRA1):
					//*****************************************************************************************
					unidadSIITSeleccionada=empDsp.getDependenciaSIITPorUbigeo(solicitud.getV_coddepemp(),solicitud.getV_codproemp(),solicitud.getV_coddisemp());					
					intendenciaSIITSeleccionada=empDsp.getIntendenciaSIITPorCodigo(unidadSIITSeleccionada.getnNumdepsun()+"");
				} catch (Exception e) {
					FacesUtils.showFacesMessage( "Estimado usuario, se presentaron inconvenientes, por favor intente denuevo. Si el problema persiste por favor comunicarse con sistemas SUNAFIL.",1);
					return;
				}				
				datos2MostrarSgte=true;
			}	
		}
		else
		{
			datos2MostrarSgte=false;
			FacesUtils.showFacesMessage("Debe ingresar un RUC válido.",1);
		}	
	}
	
	/**
	 * Metodo utilizado para ingresar al PASO 3, aqui se guarda la solicitud con estado sin enviar
	 * @return
	 */
	public String datos3Solicitud(){
		//REGISTRAR SOLICITUD
		logger.info("Ingresando a registrar la solicitud");
		
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		int newIdSolicitud = empDsp.obtieneNuevaSolicitud();
		if(newIdSolicitud == -1) {
			FacesUtils.showFacesMessage("Estimado usuario, se encontraron inconvenientes, por favor intentar nuevamente. Si el problema persiste comuniquese con sistemas-SUNAFIL.", 1);
			return "pretty:registroEmpleador";
		}
		
		logger.info("codigo obtenido=>"+newIdSolicitud);
		solicitud.setN_codsol(""+newIdSolicitud);
		
		//INSERTAMOS
		System.out.println(solicitud.getPersona().getV_codtdocide()+" DNI "+solicitud.getPersona().getV_numdoc());
		DlmvSolicitud solicitudEnt=new DlmvSolicitud();
		solicitudEnt.setnCodsol(new BigDecimal(""+solicitud.getN_codsol()));
		solicitudEnt.setvCodtdocide(solicitud.getPersona().getV_codtdocide());
		solicitudEnt.setvNumdoc(solicitud.getPersona().getV_numdoc());
		solicitudEnt.setvCodemp(solicitud.getEmpresa().getV_codemp());
		solicitudEnt.setvCoddepemp(solicitud.getV_coddepemp());
		solicitudEnt.setvCodproemp(solicitud.getV_codproemp());
		solicitudEnt.setvCoddisemp(solicitud.getV_coddisemp());
		solicitudEnt.setnFlgest(new BigDecimal("0"));
		solicitudEnt.setvCodusureg(solicitud.getPersona().getV_numdoc());//EL DNI DEL USUARIO SERA EL USUARIO QUE REGISTRA
		solicitudEnt.setvHostreg(FacesUtils.getIpAddress());
		int result = empDsp.insertarSolicitud(solicitudEnt);
		if(result == 0){
			FacesUtils.showFacesMessage("Estimado usuario, se encontraron inconvenientes, por favor intentar nuevamente. Si el problema persiste comuniquese con sistemas-SUNAFIL.", 1);
			return "pretty:registroEmpleador";
		}
		
		//SETEANDO POR DEFECTO QUE TIENE RELACION LABORAL
		solicitud.setV_flgrellab(true);
		
		String vista="pretty:registroSolicitud";

        return  vista;
	}
	
	public String retornarADatos3Solicitud()
	{
		String vista="pretty:registroSolicitud";
        //CODIGO
        return  vista;
	}
	
	/**
	 * Metodo de validación de la información ingresada en el PASO 3.
	 * @return
	 */
	public boolean validaPaso3(){
		
		logger.info("validando datos del paso 3");
		if(solicitud.getV_coddepper()!=null && !"".equals(solicitud.getV_coddepper().trim())){}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor seleccione departamento.",1);
			return false;
		}
		
		if(solicitud.getV_codproper()!=null && !"".equals(solicitud.getV_codproper().trim())){}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor seleccione provincia.",1);
			return false;
		}
		
		if(solicitud.getV_coddisper()!=null && !"".equals(solicitud.getV_coddisper().trim())){}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor seleccione distrito.",1);
			return false;
		}
		
		if(solicitud.getV_dirper()!=null && !"".equals(solicitud.getV_dirper().trim())){}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor ingrese dirección.",1);
			return false;
		}
		
		/*if(solicitud.getV_telfijo()!=null && !"".equals(solicitud.getV_telfijo().trim())){}
		else
		{
			FacesUtils.showFacesMessage("Ingrese teléfono fijo.",1);
			return false;
		}*/
		
		if(solicitud.getV_telcel()!=null && !"".equals(solicitud.getV_telcel().trim())){
			if(solicitud.getV_telcel().length() != 9){
				FacesUtils.showFacesMessage("Estimado usuario, por favor ingresar los 9 digitos de su teléfono celular.",1);
				return false;
			}
		}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor ingrese teléfono celular.",1);
			return false;
		}
		
		if(solicitud.getV_email()!=null && !"".equals(solicitud.getV_email().trim()))
		{
			if(!FacesUtils.validarEmail(solicitud.getV_email()))
			{
				FacesUtils.showFacesMessage("Estimado usuario, por favor ingrese correo electrónico válido.",1);
				return false;
			}
		}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor ingrese correo electrónico.",1);
			return false;
		}
		
		if(solicitud.getD_fecing()!=null)
		{
			if((new Date()).before(solicitud.getD_fecing()))
			{
				FacesUtils.showFacesMessage("Estimado usuario, la fecha de ingreso no puede ser mayor a la fecha actual, por favor verificar.",1);
	            return false;
			}
		}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor ingrese fecha de ingreso.",1);
			return false;
		}
		
		if(!solicitud.getV_flgrellab())
		{
			if(solicitud.getD_fecces()!=null)
			{
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				//OBTENEMOS LA FECHA ACTUAL:
				String fechaActual = (String)FacesUtils.getSessionAttribute("v_fecActual");
				System.out.println("fechaActual ::."+fechaActual);
				Date dateActual;
				try {
					dateActual = sdf.parse(fechaActual);
				} catch (Exception e) {
					FacesUtils.showFacesMessage("Estimado usuario, ocurrieron inconvenientes con el sistema por favor comunicarse son el area de informática.",1);
		            return false;
				}
				
				
				if((dateActual).before(solicitud.getD_fecces()))
				{
					FacesUtils.showFacesMessage("Estimado usuario, la fecha de cese no puede ser mayor a la fecha actual, por favor verificar.",1);
		            return false;
				}
				if(solicitud.getD_fecces().before(solicitud.getD_fecing()))
				{
					FacesUtils.showFacesMessage("Estimado usuario, la fecha de cese debe ser mayor que la fecha de ingreso, por favor verificar.",1);
		            return false;
				}
				Calendar startCalendar = new GregorianCalendar();
				startCalendar.setTime(solicitud.getD_fecces());
				Calendar endCalendar = new GregorianCalendar();
				endCalendar.setTime(dateActual);
				int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
				System.out.println("dateDiff ::: "+diffYear);
				if(diffYear>=5)
				{
					FacesUtils.showFacesMessage("Estimado usuario, verifique la fecha de cese, no se procesan denuncias con una antigüedad mayor a 5 años.",1);
		            return false;
				}
			}
			else
			{
				FacesUtils.showFacesMessage("Estimado usuario, por favor ingrese fecha de cese.",1);
				return false;
			}
		}
		
		if(solicitud.getV_cargo()!=null && !"".equals(solicitud.getV_cargo().trim())){}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor ingrese el cargo.",1);
			return false;
		}
		
		if(solicitud.getV_codtmon()!=null && !"".equals(solicitud.getV_codtmon().trim())){}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor seleccione la moneda de la remuneración.",1);
			return false;
		}
		
		if(solicitud.getN_monto()!=null && !"".equals(solicitud.getN_monto().trim())){
			
		}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor ingrese monto de la remuneración.",1);
			return false;
		}
		
		if(solicitud.getV_diremp()!=null && !"".equals(solicitud.getV_diremp().trim())){}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor ingrese dirección del centro de trabajo.",1);
			return false;
		}
		
		if(file != null) 
		{
			if(!file.getFileName().toUpperCase().endsWith(".PDF"))
        	{
				FacesUtils.showFacesMessage("Estimado usuario, por favor debe seleccionar un archivo de Croquis con extensión PDF.",1);
	            return false;
        	}else if(file.getSize()>1024000L)
        	{
        		FacesUtils.showFacesMessage("Estimado usuario, por favor debe seleccionar un archivo de Croquis con un tamaño máximo de 1MB.",1);
	            return false;
        	}
			
			//VERIFICAMOS EL TAMAÑO DEL ARCHIVO:
			
		}
		/*else
		{
			FacesUtils.showFacesMessage("Seleccione un archivo.",1);
			return false;
		}*/
		
		return true;
	}
	
	/**
	 * Metodo utilizado para subir archivos adjuntos
	 * @param tipoDoc
	 * @return 0 si subio mal o paso algo
	 */
	public int rutinaSubirArchivos(String tipoDoc){
		
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		System.out.println("begin upload "+tipoDoc);
        InputStream in;
		try {
			if("1".equals(tipoDoc))
			{
				in = file.getInputstream();
			}
			else if("2".equals(tipoDoc))
			{
				in = fileDNI.getInputstream();
			}
			else if("3".equals(tipoDoc))
			{
				in = fileContrato.getInputstream();
			}
			else if("4".equals(tipoDoc))
			{
				in = fileBoleta.getInputstream();
			}
			else
			{
				in = fileOtros.getInputstream();
			}
			String destination = Funciones.ObtProp_App("ruta.fileserver");
			File file = new File(destination+tipoDoc+"-"+solicitud.getN_codsol()+".pdf");
			OutputStream out = new FileOutputStream(file);
	        byte[] buf = new byte[1024];
	        int len;
	        while((len=in.read(buf))>0){
	            out.write(buf,0,len);
	        }
	        out.close();
	        in.close();
	        System.out.println("end upload "+tipoDoc);	
		} catch (IOException e) {
			logger.error("Archivo "+tipoDoc+" no fue subido =>"+e.getMessage(),e);
			return 0;
		}
	        
        try {
        	DlmvdDocxsol archivoAdjunto=new DlmvdDocxsol();
        	archivoAdjunto.setnCodsol(new BigDecimal(""+solicitud.getN_codsol()));
        	archivoAdjunto.setnCoddoc(new BigDecimal(""+tipoDoc));
        	archivoAdjunto.setvNombrearc(archivoAdjunto.getnCoddoc()+"-"+solicitud.getN_codsol()+".pdf");
        	empDsp.actualizarArchivo(archivoAdjunto);
		} catch (Exception ee) {
			logger.error("No se pudo actualizar los nombres del archivo en la BD =>"+ee.getMessage(),ee);
			//ELIMINAMOS EL ARCHIVO SUBIDO:
			int resultElim = eliminarArchSubidos(tipoDoc+"-"+solicitud.getN_codsol()+".pdf");
			if( resultElim == 0){
				logger.error("No se pudo eliminar el archivo luego de detectar el error de actualización, tener presente para que si se puede hacerlo manualmente ya que no servirá de nada y ocupará espacio");
			}
			return 0;
		}
        System.out.println("end update bd filename "+tipoDoc);
        System.out.println("Archivo "+tipoDoc+" fue subido.");	        
		return 1;
	}
	
	/**
	 * Metodo utilizado para pasar al PASO 4. Es del botón Siguiente.
	 * @return
	 */
	public String datos4Denuncia(){
		
		if(!validaPaso3())
		{
			return "pretty:registroSolicitud";
		}
		logger.info("Ingresando al Paso 4");
		
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		
		DlmvSolicitud solicitudEnt=new DlmvSolicitud();
		solicitudEnt.setnCodsol(new BigDecimal(""+solicitud.getN_codsol()));
		solicitudEnt.setvCoddepper(solicitud.getV_coddepper());
		solicitudEnt.setvCodproper(solicitud.getV_codproper());
		solicitudEnt.setvCoddisper(solicitud.getV_coddisper());
		solicitudEnt.setvDirper(solicitud.getV_dirper());
		if(solicitud.getV_telfijo()!=null && !"".equals(solicitud.getV_telfijo().trim()))
		{
			solicitudEnt.setvTelfijo(solicitud.getV_telfijo());
		}
		else
		{
			solicitud.setV_telfijo("   ");
			solicitudEnt.setvTelfijo("   ");//VERIFICAR PARA QUE SE HACE ESTO CASO CONTRARIO SE QUITA PARA QUE NO INSERTE
		}
		solicitudEnt.setvTelcel(solicitud.getV_telcel());
		solicitudEnt.setvEmail(solicitud.getV_email());
		solicitudEnt.setvFlgrellab(solicitud.getV_flgrellab()?"S":"N");
		solicitudEnt.setdFecing(solicitud.getD_fecing());
		if(!solicitud.getV_flgrellab())
		{
			solicitudEnt.setdFecces(solicitud.getD_fecces());
			solicitudEnt.setvFlgres("N");
		}
		if(solicitud.getV_flgrellab())
		{
			solicitudEnt.setvFlgres("S");
		}
		solicitudEnt.setvCargo(solicitud.getV_cargo());
		solicitudEnt.setvCodtmon(solicitud.getV_codtmon());
		solicitudEnt.setnMonto(new BigDecimal(solicitud.getN_monto()));
		solicitudEnt.setvDiremp(solicitud.getV_diremp());
		solicitudEnt.setvCodusumod(solicitud.getPersona().getV_numdoc());//EL DNI DE LA PERSONA SERA EL USUARIO QUE MODIFICA
		solicitudEnt.setvHostmod(FacesUtils.getIpAddress());//LA IP DEL MISMO USUARIO 
		
		int result = empDsp.actualizarSolicitud(solicitudEnt);
		if(result == 0){
			FacesUtils.showFacesMessage("Estimado usuario, se presentaron inconvenientes al ingresar sus datos, por favor vuelta a intentar. Si el problema persiste por favor comunicarse con sistemas SUNAFIL.",1);
			return "pretty:registroSolicitud";
		}
		
		//LO SUBIREMOS AL FINAL:
		/*
		//upload y update de documento de tipo 1(CROQUIS) en tbl dlmvd_docxsol
		if(file!=null)
		{
			logger.info("ingresando a subir el archivo de croquis");
			rutinaSubirArchivos("1");
		}				
		//end upload y update de documento de tipo 1(CROQUIS) en tbl dlmvd_docxsol
		*/
		String vista="pretty:registroDenuncia";
        //CODIGO
        return  vista;
	}
	
	public boolean validaPaso3B()
	{
		logger.info("Ingresando a validar el formulario del ultimo paso");
		if(solicitud.getV_motivo()!=null && !"".equals(solicitud.getV_motivo().trim())){}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor ingrese la descripción de la denuncia.",1);
			return false;
		}
		
		//POR AHORA NO SE PEDIRA MATERIA YA QUE SOLICITARON QUE SE QUITARA. FEC RETIRO DE ESTA VALIDACION 27/06/2016
		/*
		if(solicitud.getV_flgrellab())//SI TIENE RELACION LABORAL
		{
			if(solicitud.getN_codmat()!=null && solicitud.getN_codmat()!=(new BigDecimal("-1")))
			{
				if(solicitud.getN_codmat()==(new BigDecimal("4")))//4:Es la opcion de "OTROS"
				{
					if(solicitud.getV_desotros()!=null && !"".equals(solicitud.getV_desotros().trim())){}
					else
					{
						FacesUtils.showFacesMessage("Especifique la materia.",1);
						return false;
					}
				}
			}
			else
			{
				FacesUtils.showFacesMessage("Seleccione materia.",1);
				return false;
			}
		}
		*/
		//SE LE SETEA NULO AL CODIGO DE MATERIA PARA QUE NO LO INSERTE:
		//solicitud.setN_codmat(null);
		
		
		if(fileDNI != null) 
		{
			if(!fileDNI.getFileName().toUpperCase().endsWith(".PDF"))
        	{
				FacesUtils.showFacesMessage("Estimado usuario, por favor debe seleccionar un archivo de su DNI con extensión PDF.",1);
	            return false;
        	}else if(fileDNI.getSize()>1024000L)
        	{
        		FacesUtils.showFacesMessage("Estimado usuario, por favor debe seleccionar un archivo de su DNI con un tamaño máximo de 1MB.",1);
	            return false;
        	}
		}
		else
		{
			FacesUtils.showFacesMessage("Estimado usuario, por favor seleccione un archivo de su DNI.",1);
			return false;
		}
		//YA NO SERÁ OBLIGATORIO LA VALIDACION DE SUBIR CONTRATO BOLETA
		if(fileContrato != null) 
		{
			if(!fileContrato.getFileName().toUpperCase().endsWith(".PDF"))
        	{
				FacesUtils.showFacesMessage("Estimado usuario, por favor debe seleccionar un archivo de su Contrato con extensión PDF.",1);
	            return false;
        	}else if(fileContrato.getSize()>1024000L)
        	{
        		FacesUtils.showFacesMessage("Estimado usuario, por favor debe seleccionar un archivo de su Contrato de un tamaño máximo de 1MB.",1);
	            return false;
        	}
		}
		/*
		else
		{
			FacesUtils.showFacesMessage("Seleccione un archivo de su Contrato.",1);
			return false;
		}*/
		
		if(fileBoleta != null) 
		{
			if(!fileBoleta.getFileName().toUpperCase().endsWith(".PDF"))
        	{
				FacesUtils.showFacesMessage("Estimado usuario, por favor debe seleccionar un archivo de su Boleta con extensión PDF.",1);
	            return false;
        	}else if(fileBoleta.getSize()>1024000L)
        	{
        		FacesUtils.showFacesMessage("Estimado usuario, por favor debe seleccionar un archivo de su Boleta de un tamaño máximo de 1MB.",1);
	            return false;
        	}
		}
		/*
		else
		{
			FacesUtils.showFacesMessage("Seleccione un archivo de su Boleta.",1);
			return false;
		}		
		*/
		
		if(fileOtros != null) 
		{
			if(!fileOtros.getFileName().toUpperCase().endsWith(".PDF"))
        	{
				FacesUtils.showFacesMessage("Estimado usuario, por favor debe seleccionar un archivo de otros documentos con extensión PDF.",1);
	            return false;
        	}else if(fileOtros.getSize()>1024000L)
        	{
        		FacesUtils.showFacesMessage("Estimado usuario, por favor debe seleccionar el archivo Otros de un tamaño máximo de 1MB.",1);
	            return false;
        	}
		}
		/*else
		{
			FacesUtils.showFacesMessage("Seleccione un archivo de otros documentos.",1);
			return false;
		}*/
		
		return true;
	}
	
	/**
	 * Metodo utilizado para enviar la denuncia virtual, es el botón final
	 * @return
	 */
	public String datos5Confirmacion(){		
		if(!validaPaso3B())
		{
			return "pretty:registroDenuncia";
		}
		logger.info("Registrando la denuncia virtual, paso final:");
		
		String msgErrorRegistroGeneral = "Estimado usuario, se presentaron inconvenientes al ingresar sus datos, por favor vuelva a intentar. Si el problema persiste por favor comunicarse con sistemas SUNAFIL.";
		
		//#########################################################################################################################
		//PRIMERO: SUBIMOS LOS ARCHIVOS YA QUE SI NO SUBEN NO SE PUEDE VALIDAR LUEGO POR LA SIAI ENTONCES NO SACARIAN SU DENUNCIA
		//#########################################################################################################################
		logger.info("guardando...  PASO 1/7");
		//====================================================
		//INI:::SUBIENDO ARCHIVOS AL FILE SERVER:
		//====================================================
		int returnSubida=1;
		if(file!=null){
			returnSubida = rutinaSubirArchivos("1");
		}
		if(fileDNI!=null){
			returnSubida = rutinaSubirArchivos("2");
		}
		if(fileContrato!=null){
			returnSubida = rutinaSubirArchivos("3");
		}
		if(fileBoleta!=null){
			returnSubida = rutinaSubirArchivos("4");
		}
		if(fileOtros != null){
			returnSubida = rutinaSubirArchivos("5");
		}
		//SI OCURRIESE ALGUN ERROR SE AVISA AL USUARIO:
		if(returnSubida == 0){
			FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
			return "pretty:registroDenuncia";
		}
		//====================================================
		//FIN:::SUBIDA ARCHIVOS
		//====================================================
		
		
		//#########################################################################################################################
		//SEGUNDO: ACTUALIZAMOS TODA LA DATA PARA PODERLA PROCESAR EN LOS 3 ESQUEMAS LUEGO:
		//#########################################################################################################################
		logger.info("guardando...  PASO 2/7");
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		
		DlmvSolicitud solicitudEnt=new DlmvSolicitud();
		solicitudEnt.setnCodsol(new BigDecimal(""+solicitud.getN_codsol()));
		solicitudEnt.setvMotivo(solicitud.getV_motivo());
		if(solicitud.getV_flgrellab()){
			solicitudEnt.setnCodmat(solicitud.getN_codmat());
			if(solicitud.getN_codmat()==(new BigDecimal("4")))//SI ES TIPO OTRA MATERIA (OTROS)
			{
				solicitudEnt.setvDesotros(solicitud.getV_desotros());
			}			
		}
		solicitudEnt.setnFlgest(new BigDecimal("1"));//1:INDICA SOLICITUD ENVIADA. 0: SOLICITUD NO ENVIADA
		
		//OBTENEMOS EL AÑO ACTUAL:
		String anhoActual = (String)FacesUtils.getSessionAttribute("v_anhoActual");
		
		solicitudEnt.setvAnhosol(anhoActual);
		
		//OBTENEMOS EL CORRELATIVO DE LA SOLICITUD:
		String corrSol = "";
		try {
			corrSol=getSiguienteCorrelativoSolicitud(solicitudEnt.getvAnhosol());
		} catch (Exception e) {
			FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
			return "pretty:registroDenuncia";
		}
		
		solicitudEnt.setvNumsol(completarCon(corrSol,10,"0",0));
		solicitud.setV_anhosol(solicitudEnt.getvAnhosol());
		solicitud.setV_numsol(solicitudEnt.getvNumsol());
		
		
		
		//#########################################################################################################################
		//TERCERO: INSERTAR EN TRAMITE.TDMVC_REGISTRO Y ACTUALIZAR CAMPOS DE HR EN SOLICITUD
		//#########################################################################################################################
		logger.info("guardando...  PASO 3/7");
		TdmvcRegistro entReg=new TdmvcRegistro();		
		entReg.setvNumanoreg(anhoActual);
		
		//recuperar intendencia en base a departamento seleccionado
		//recupera dependencia en base a intendencia
		TdtbcIntendencia entInt=new TdtbcIntendencia();
		try {
			entInt=empDsp.getIntendenciaPorUbigeo(solicitud.getV_coddepemp());
			logger.info("la intendencia base obtenida del departamento seleccionado es entInt.getnNumdeputd()=>"+entInt.getnNumdeputd());
			intendenciaTrExSeleccionada=entInt;
		} catch (Exception e) {
			FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
			return "pretty:registroDenuncia";
		}
		
		if(entInt!=null)
		{
			entReg.setnNumdep(new Short(""+entInt.getnNumdeputd()));
			entReg.setnNumtipodoc(new Short("0"));
			String numreg;
			try {
				numreg = getSiguienteCorrelativo(entReg.getvNumanoreg(), entReg.getnNumdep(), new Short("0"));
				logger.info("Correlativo obtenido de la tabla corelativos de tramite=>"+numreg);
			} catch (Exception e) {
				FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
				return "pretty:registroDenuncia";
			}
			
			
			entReg.setvNumreg(completarCon(numreg,10,"0",0));
			entReg.setnTippriori(new Short("0"));//prioridad normal
			entReg.setdFecemision(new Date());
			entReg.setvTiporigen("E");
			
			//recupera la entidad en base solo a V_CODENTIDAD, si esta con otro V_CODTIPODOCID update a 03, si no existe recuperar de lo ya insertado en DENVIRTUAL(Ssolicitud.getPersona()) Y COPIAR EN TDTBC_ENTIDAD de TRAMITE
			TdtbcEntidad entEnt=new TdtbcEntidad();
			try {
				entEnt=empDsp.getEntidadPorCodigo(solicitud.getPersona().getV_numdoc());
			} catch (Exception e) {
				FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
				return "pretty:registroDenuncia";
			}
			if(entEnt!=null)
			{//VERIFICA Q EL CODIGO DE TIPO DOC SEA 03 : DNI SINO ACTUALIZA DATOS Y TIPO DOC
				
				if("03".equals(entEnt.getvCodtipodocid())) {
					
					if(entEnt.getvNombres()!=null && entEnt.getvApepat()!=null && entEnt.getvApemat()!=null) {
						//ACTUALIZA OTROS DATOS
						entEnt.setvDesnombre(solicitud.getPersona().getV_nombres()+" "+solicitud.getPersona().getV_appaterno()+" "+solicitud.getPersona().getV_apmaterno());
						entEnt.setvApepat(solicitud.getPersona().getV_appaterno());
						entEnt.setvApemat(solicitud.getPersona().getV_apmaterno());
						entEnt.setvNombres(solicitud.getPersona().getV_nombres());
						entEnt.setvDescorreoe(solicitud.getV_email());
						
					} else {
						//SOLO ACTUALIZA EMAIL
						entEnt.setvDescorreoe(solicitud.getV_email());
					}
					
				} else {
					
					entEnt.setvCodtipodocid("03");
					entEnt.setvDesnombre(solicitud.getPersona().getV_nombres()+" "+solicitud.getPersona().getV_appaterno()+" "+solicitud.getPersona().getV_apmaterno());
					entEnt.setvApepat(solicitud.getPersona().getV_appaterno());
					entEnt.setvApemat(solicitud.getPersona().getV_apmaterno());
					entEnt.setvNombres(solicitud.getPersona().getV_nombres());
					entEnt.setvDescorreoe(solicitud.getV_email());
					
				}
				
				//USUARIO QUE ACTUALIZA LE PONEMOS EL ESQUEMA DE DENUNCIA VIRTUAL
				entEnt.setvNomusumod("DENVIRTUAL");
				
				int result = empDsp.actualizarEntidad(entEnt);
				if(result == 1){//OK
					entidadSeleccionada=entEnt;
				} else {
					FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
					return "pretty:registroDenuncia";
				}
				
			} else {
				
				//INSERTA EN TABLA TDTBC_ENTIDAD LO QUE HAY EN SOLICITUD.GETPERSONA()
				entEnt=new TdtbcEntidad();
				entEnt.setvCodentidad(solicitud.getPersona().getV_numdoc());
				entEnt.setvCodtipodocid(solicitud.getPersona().getV_codtdocide());
				entEnt.setvDesnombre(solicitud.getPersona().getV_nombres()+" "+solicitud.getPersona().getV_appaterno()+" "+solicitud.getPersona().getV_apmaterno());
				entEnt.setvDirentidad(solicitud.getV_dirper().toUpperCase());
				entEnt.setvDescorreoe(solicitud.getV_email());
				entEnt.setvNomusureg("DENVIRTUAL");
				//entEnt.setdFecreg(new Date());
				entEnt.setvNomusumod("DENVIRTUAL");
				entEnt.setdFecmod(new Date());
				entEnt.setvApepat(solicitud.getPersona().getV_appaterno());
				entEnt.setvApemat(solicitud.getPersona().getV_apmaterno());
				entEnt.setvNombres(solicitud.getPersona().getV_nombres());
				
				//INSERTA LA ENTIDAD:
				int result = empDsp.insertarEntidad(entEnt);
				if(result == 1){
					entidadSeleccionada=entEnt;
				} else {
					FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
					return "pretty:registroDenuncia";
				}
				
			}
			
			entReg.setvCodentidad(entidadSeleccionada.getvCodentidad());
			entReg.setvCodaccionante(entidadSeleccionada.getvCodentidad());
			
			//INSERTA UNA NUEVA DIRECCION PARA EL ENTIDAD EN TDTBD_CENTROLAB DE TRAMITE
			if(entidadSeleccionada!=null)
			{
				TdtbdCentrolab nuevaDireccion= new TdtbdCentrolab();
				nuevaDireccion.setvCodentidad(entidadSeleccionada.getvCodentidad());
				nuevaDireccion.setvDircenlab(solicitud.getV_dirper().toUpperCase());
				nuevaDireccion.setvNomusureg("DENVIRTUAL");
//				nuevaDireccion.setdFecreg(new Date());
				nuevaDireccion.setvNomusumod("DENVIRTUAL");
//				nuevaDireccion.setdFecmod(new Date());
				nuevaDireccion.setvCoddep(solicitud.getV_coddepper());
				nuevaDireccion.setvCodpro(solicitud.getV_codproper());
				nuevaDireccion.setvCoddis(solicitud.getV_coddisper());
				
				//OBTENEMOS EL CORRELATIVO DEL CENTRO LABORAL:
				Short nCodcenlab = 1;
				try {
					nCodcenlab = empDsp.getCorrelativoDireccionPorEntidad(entidadSeleccionada.getvCodentidad());
				} catch (Exception e) {
					FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
					return "pretty:registroDenuncia";
				}
				
				//SETEAMOS EL CORRELATIVO OBTENIDO:
				nuevaDireccion.setnCodcenlab(nCodcenlab);
				
				//INSERTAMOS EL NUEVO CENTRO LABORAL:
				int result = empDsp.insertarDireccion(nuevaDireccion);
				if( result == 1){
					direccionSeleccionada=nuevaDireccion;
				} else {
					FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
					return "pretty:registroDenuncia";
				}
				
			}
			
			//INSERTAMOS y OBTENEMOS EL CORRELATIVO DE HOJA DE RUTA:
			String numHojaRuta;
			try {
				numHojaRuta = getSiguienteCorrelativoGlobal(new Short(entReg.getvNumanoreg()));
			} catch (Exception e) {
				FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
				return "pretty:registroDenuncia";
			}
			
			
			//INSERTAMOS A LA TABLA BASE DE TRAMITE.TDMVC_REGISTRO
			
			entReg.setnCodcenlab(direccionSeleccionada.getnCodcenlab());
			entReg.setdFecrecep(new Date());//PARA FECHA DE LA BASE DE DATOS
			entReg.setvDesasunto("DENUNCIA VIRTUAL");
			entReg.setvAsuntodetallado("DENUNCIA VIRTUAL");
			entReg.setvNomusureg("DENVIRTUAL");
			entReg.setdFecreg(new Date());//PARA FECHA DE LA BASE DE DATOS
			entReg.setvNumhoja(completarCon(numHojaRuta,10,"0",0));//correlativo global 
			entReg.setvAniohoja(new Short(entReg.getvNumanoreg()));
			entReg.setnFlgasocia(new Short("0"));
			entReg.setvFlgcosuco("N");
			entReg.setnCodtram(new BigDecimal("8"));
			
			int result = empDsp.insertarRegistro(entReg);
			if(result == 1){
				registroGuardado=entReg;
				solicitudEnt.setvAnhohoja(""+registroGuardado.getvAniohoja());
				solicitudEnt.setvNumhoja(registroGuardado.getvNumhoja());
			}else{
				FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
				return "pretty:registroDenuncia";
			}
			
		}
		else
		{
			logger.info("No se pudo recuperar equivalente en la dependendencia e insertar registro en esquema TRAMITE");
			FacesUtils.showFacesMessage("Estimado usuario, se obtuvo problemas para obtener su Hoja de Ruta debido a que no existe la Intendencia de SUNAFIL en el departamento seleccionado, por favor verificar.",1);
			return "pretty:registroDenuncia";
		}
		///////////////////////////////////////////////////
		//FIN DE REGISTRAR EN TRAMITE DOCUMENTARIO
		/////////////////////////////////////////////////
		
		
		
		
		//#########################################################################################################################
		//CUARTO: INSERTAMOS EN LA BASE DE DATOS DEL SIIT - GENERAMOS EL NUEVO REGISTRO DE ENTRADA
		//#########################################################################################################################
		logger.info("guardando...  PASO 4/7");
		//GUARDAR EN SIIT CON SP INSPECCIONES_REG_ENTRADA.SPR_INS_REXDENVIRTUAL
		try {
			Map parametros = new HashMap();
			parametros.put("P_N_NUMDEP", unidadSIITSeleccionada.getnNumdepsun());
			parametros.put("P_V_NUMREGMP", registroGuardado.getvNumhoja());
			parametros.put("P_V_ANHOREGMP", registroGuardado.getvAniohoja());
			parametros.put("P_D_FECINGMP", registroGuardado.getdFecreg());
			parametros.put("P_V_NUMDREMMP", registroGuardado.getvCodentidad());
			parametros.put("P_V_REMITEMP", solicitud.getPersona().getV_nombres()+" "+solicitud.getPersona().getV_appaterno()+" "+solicitud.getPersona().getV_apmaterno());
			parametros.put("P_V_NUMDOC", registroGuardado.getvCodentidad());
			parametros.put("P_V_APEPATER", solicitud.getPersona().getV_appaterno());
			parametros.put("P_V_APEMATER", solicitud.getPersona().getV_apmaterno());
			parametros.put("P_V_NOMBRES", solicitud.getPersona().getV_nombres());
			parametros.put("P_V_CODEMP", solicitud.getEmpresa().getV_codemp());
			parametros.put("P_V_ASUNTO", solicitud.getV_motivo());
			parametros.put("P_N_COSOL", solicitud.getN_codsol());
			parametros.put("P_V_FLGLEVRI", "N");
			parametros.put("P_V_FLGRES", solicitud.getV_flgrellab()?"S":"N");
			parametros.put("P_V_CODUSUREG", "DENVIRTUAL");
			parametros.put("P_V_HOSTREG", FacesUtils.getIpAddress());
			
			String nroRASIIT=empDsp.insertarRegistroEntradaSIIT(parametros);
			System.out.println("Insertó registro de entrada en SIIT ::: "+nroRASIIT);
		} catch (Exception e) {
			FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
			return "pretty:registroDenuncia";
		}
		//END GUARDAR EN SIIT CON SP INSPECCIONES_REG_ENTRADA.SPR_INS_REXDENVIRTUAL
		
		
		//#########################################################################################################################
		//QUINTO: INSERTAMOS EN LA BASE DE DATOS DEL SIIT - GUARDAMOS LOS DATOS EN LA TABLA DE DENUNCIA VIRTUAL PARA LOS REPORTES
		//#########################################################################################################################		
		logger.info("guardando...  PASO 5/7");
		//GUARDAR EN TABLA REPORTE DEL SIIT
		try {
			Combo solDep=dspcombos.departamentoByCod(solicitud.getV_coddepper()).get(0);
			Combo solPro=dspcombos.provinciaByCod(solicitud.getV_coddepper(), solicitud.getV_codproper()).get(0);
			Combo solDis=dspcombos.distritoByCod(solicitud.getV_coddepper(), solicitud.getV_codproper(), solicitud.getV_coddisper()).get(0);	
			SitbTipomoneda solMon=empDsp.getMonedaPorCodigo(solicitud.getV_codtmon());
			Combo empDep=dspcombos.departamentoByCod(solicitud.getV_coddepemp()).get(0);
			Combo empPro=dspcombos.provinciaByCod(solicitud.getV_coddepemp(), solicitud.getV_codproemp()).get(0);
			Combo empDis=dspcombos.distritoByCod(solicitud.getV_coddepemp(), solicitud.getV_codproemp(), solicitud.getV_coddisemp()).get(0);
			
			//SE COMENTA PORQUE PIDIERON NO MOSTRAR MATERIAS: 28/06/2016
			//DltbcMateria materia=(!solicitud.getV_flgrellab())?new DltbcMateria():empDsp.getMateriaPorCodigo(solicitud.getN_codmat());
			
			IltbcSoldenvirtual entRep=new IltbcSoldenvirtual();			
			entRep.setnCodsol(new BigDecimal(""+solicitud.getN_codsol()));
			entRep.setvNumhoja(registroGuardado.getvNumhoja());
			entRep.setvAnhohoja(""+registroGuardado.getvAniohoja());
			entRep.setvNumsol(solicitud.getV_numsol());
			entRep.setnAnhosol(solicitud.getV_anhosol());
			entRep.setdFecreg(registroGuardado.getdFecreg());
			entRep.setvApepater(solicitud.getPersona().getV_appaterno());
			entRep.setvApemater(solicitud.getPersona().getV_apmaterno());
			entRep.setvNombres(solicitud.getPersona().getV_nombres());
			entRep.setvTelfijo(solicitud.getV_telfijo());
			entRep.setvTelcel(solicitud.getV_telcel());
			entRep.setvEmail(solicitud.getV_email());
			entRep.setvCoddepper(solicitud.getV_coddepper());
			entRep.setvCodproper(solicitud.getV_codproper());
			entRep.setvCoddisper(solicitud.getV_coddisper());
			entRep.setvDesdepper(solDep.getV_descripcion());
			entRep.setvDesproper(solPro.getV_descripcion());
			entRep.setvDesdisper(solDis.getV_descripcion());
			entRep.setvDirper(solicitud.getV_dirper().toUpperCase());
			entRep.setvFlgrellab(solicitud.getV_flgrellab()?"S":"N");
			entRep.setdFecing(solicitud.getD_fecing());
			if(solicitud.getD_fecces()!=null)
			{
				entRep.setdFecces(solicitud.getD_fecces());
			}			
			entRep.setvCargo(solicitud.getV_cargo().toUpperCase());
			entRep.setvCodtmon(solicitud.getV_codtmon());
			entRep.setvDestmon(solMon.getvDestmon());
			entRep.setnMonto(new BigDecimal(solicitud.getN_monto()));
			entRep.setvRazsoc(solicitud.getEmpresa().getV_razsoc());
			entRep.setvCoddepemp(solicitud.getV_coddepemp());
			entRep.setvCodproemp(solicitud.getV_codproemp());
			entRep.setvCoddisemp(solicitud.getV_coddisemp());
			entRep.setvDesdepemp(empDep.getV_descripcion());
			entRep.setvDesproemp(empPro.getV_descripcion());
			entRep.setvDesdisemp(empDis.getV_descripcion());
			entRep.setvDiremp(solicitud.getV_diremp().toUpperCase());
			
			//SE COMENTA PORQUE PIDIERON NO MOSTRAR MATERIAS: 28/06/2016
			/*
			if(solicitud.getV_flgrellab())
			{
				
				//entRep.setnCodmat(solicitud.getN_codmat());
				//entRep.setvDesmat(materia.getvDesmat());
			}
			if(solicitud.getN_codmat()==(new BigDecimal("4")))
			{
				entRep.setvDesotros(solicitud.getV_desotros().toUpperCase());				
			}
			*/
			entRep.setvMotivo(solicitud.getV_motivo().toUpperCase());
			entRep.setvDesintreg(intendenciaSIITSeleccionada.getvDesdep());//intendenciaTrExSeleccionada.getvDesint()
			
			empDsp.insertarReporte(entRep);			
		} catch (Exception e) {
			FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
			return "pretty:registroDenuncia";
		}				
		//END GUARDAR EN TABLA REPORTE DEL SIIT
		
		
		//#########################################################################################################################
		//SEXTO: ENVIAMOS EL CORREO CON LA CONSTANCIA:
		//#########################################################################################################################
		logger.info("guardando...  PASO 6/7");
		//enviar correo a solicitante con un resumen de la solicitud
		EnviarMail enviarCorreo=new EnviarMail();
		String[] direcciones=new String[3];
		direcciones[0]=solicitud.getV_email().toLowerCase();//Mail de solicitante
		direcciones[1]="rgarrido@sunafil.gob.pe";//Willy
		direcciones[2]="rgarrido@sunafil.gob.pe";//Richard
		String mensaje="";								
		String asunto="Nueva Denuncia Virtual";
		mensaje  = formatEmail()+" <br/><br/><br/>";//"<b>DNI</b> =<b>'"+entidadSeleccionada.getvCodentidad()+"'</b> <br/>"
				 //+ ":: Nueva denuncia virtual. <br/>";				 
		if(direcciones.length>0 && direcciones!=null){
			try {
				enviarCorreo.generarEnvioDeCorreos(mensaje, direcciones,asunto);
			} catch (Exception e1) {
				logger.error("Error al enviar el correo, e.getMessage()=>"+e1.getMessage());
				logger.error(e1.getMessage(),e1);
				FacesUtils.showFacesMessage(msgErrorRegistroGeneral,1);
				return "pretty:registroDenuncia";
			}
		}
		//END ENVIAR CORREO A SOLICITANTE CON UN RESUMEN DE LA SOLICITUD
		
		
		
		
		
		//#########################################################################################################################
		//SEPTIMO: ACTUALIZAMOS LOS DATOS DE LA SOLICITUD A ENVIADO! PASO FINAL
		//#########################################################################################################################
		logger.info("guardando...  PASO 7/7 FINAL");
		int result = empDsp.actualizarSolicitud(solicitudEnt);
		if(result == 0){
			FacesUtils.showFacesMessage("Estimado usuario, se presentaron inconvenientes al ingresar sus datos, por favor vuelta a intentar. Si el problema persiste por favor comunicarse con sistemas SUNAFIL.",1);
			return "pretty:registroSolicitud";
		}
		
		String vista="pretty:registroConfirmacion";
        return  vista;
	}
	
	public String getSiguienteCorrelativoGlobal(Short anio) throws Exception
	{
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		try {
			TdmvcHojarutaKey correlativo=empDsp.getCorrelativoGlobal(anio);
			if(correlativo!=null)
			{
				//INSERTA CON CORRELATIVO INCREMENTADO
				correlativo.setvCodhoja(""+(Integer.parseInt(correlativo.getvCodhoja())+1));								
				empDsp.insertarCorrelativoGlobal(correlativo);
				return correlativo.getvCodhoja();
			}
			else
			{
				//INSERTA CORRELATIVO EN 1
				correlativo=new TdmvcHojarutaKey();
				correlativo.setvAniohoja(anio);
				correlativo.setvCodhoja("1");
				empDsp.insertarCorrelativoGlobal(correlativo);
				return correlativo.getvCodhoja();
			}
			
		} catch (Exception e) {
			logger.error("Error al gestionar el obtener siguiente correlativo global de hoja de ruta => "+e.getMessage(),e);
			throw e;
		}				
	}
	
	public String getSiguienteCorrelativo(String anio, Short numDep, Short tipoD) throws Exception
	{
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		try {
			TdtbcCorrelativo correlativo=empDsp.getCorrelativo(anio, numDep, tipoD);
			if(correlativo!=null)
			{
				//actualiza con correlativo incrementado
				correlativo.setnNumultimo(correlativo.getnNumultimo()+1);
				empDsp.actualizarCorrelativo(correlativo);
				return ""+correlativo.getnNumultimo();
			}
			else
			{
				//inserta correlativo en 1
				correlativo=new TdtbcCorrelativo();
				correlativo.setvNumano(anio);
				correlativo.setnNumdep(numDep);
				correlativo.setnNumtipodoc(tipoD);
				correlativo.setnNumultimo(1L);
				correlativo.setvNomusureg("DENVIRTUAL");
				correlativo.setdFecreg(new Date());
				correlativo.setvNomusumod("DENVIRTUAL");
				correlativo.setdFecmod(new Date());
				empDsp.insertarCorrelativo(correlativo);
				return ""+correlativo.getnNumultimo();
			}
			
		} catch (Exception e) {
			throw e;
		}				
	}
	
	public String getSiguienteCorrelativoSolicitud(String anio) throws Exception
	{
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		try {
			String correlativo=empDsp.getCorrelativoSolicitud(anio);
			if(correlativo!=null)
			{
				return ""+(Integer.parseInt(correlativo)+1);
			}
			else
			{
				return "1";
			}
			
		} catch (Exception e) {
			throw e;
		}				
	}
	
	public static String completarCon(String base, int longitud,String charCompletar, int lado)
	{
		String result="";
		if(base.length()<longitud)
		{
			int n=longitud-base.length();
			String ceros="";
			for (int i = 0; i < n; i++) {
				ceros+=charCompletar;
			}
			if(lado==0)//izq
			{
				result = ceros+base;
			}
			else if(lado==1)//der
			{
				result = base+ceros;
			}
		}
		else if(base.length()>longitud)
		{
			result = base.substring(0, longitud);
		}
		else if(base.length()==longitud)
		{
			result=base;
		}
		return result;
	}
	
	public void imprimirConfirmacion() 
    {
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		try {			
			Map parametros = new HashMap();
			parametros.put("V_HOJARUTA", registroGuardado.getvNumhoja());//
			parametros.put("N_ANIOHR", ""+registroGuardado.getvAniohoja());//			
			parametros.put("V_SAI", solicitud.getV_numsol());//
			parametros.put("N_ANIOSAI", solicitud.getV_anhosol());//
			parametros.put("D_FECREG", getFormatDate(registroGuardado.getdFecreg())+" "+getFormatHour(registroGuardado.getdFecreg()));//
			parametros.put("V_SOLAPEPAT", solicitud.getPersona().getV_appaterno());//
			parametros.put("V_SOLAPEMAT", solicitud.getPersona().getV_apmaterno());//
			parametros.put("V_SOLNOMBRES", solicitud.getPersona().getV_nombres());//
			parametros.put("V_SOLTLFFIJO", solicitud.getV_telfijo());//
			parametros.put("V_SOLTLFCEL", solicitud.getV_telcel());//
			parametros.put("V_SOLEMAIL", solicitud.getV_email());//
			parametros.put("V_SOLCODDEP", solicitud.getV_coddepper());//
			parametros.put("V_SOLCODPRO", solicitud.getV_codproper());//
			parametros.put("V_SOLCODDIS", solicitud.getV_coddisper());//			
			Combo solDep=dspcombos.departamentoByCod(solicitud.getV_coddepper()).get(0);
			Combo solPro=dspcombos.provinciaByCod(solicitud.getV_coddepper(), solicitud.getV_codproper()).get(0);
			Combo solDis=dspcombos.distritoByCod(solicitud.getV_coddepper(), solicitud.getV_codproper(), solicitud.getV_coddisper()).get(0);			
			parametros.put("V_SOLDEPDES", solDep.getV_descripcion());//
			parametros.put("V_SOLPRODES", solPro.getV_descripcion());//
			parametros.put("V_SOLDISDES", solDis.getV_descripcion());//
			parametros.put("V_SOLDIRECCION", solicitud.getV_dirper().toUpperCase());//
			parametros.put("V_SOLLABORA", solicitud.getV_flgrellab()?"SI":"NO");//
			parametros.put("D_SOLFING", getFormatDate(solicitud.getD_fecing()));//
			parametros.put("D_SOLFCES", solicitud.getD_fecces()!=null?getFormatDate(solicitud.getD_fecces()):"");//
			parametros.put("V_SOLCARGO", solicitud.getV_cargo().toUpperCase());//
			parametros.put("N_SOLCODMONEDA", solicitud.getV_codtmon());//
			SitbTipomoneda solMon=empDsp.getMonedaPorCodigo(solicitud.getV_codtmon());
			parametros.put("V_SOLDESMONEDA", solMon.getvDestmon());
			parametros.put("N_SOLMONTO", solicitud.getN_monto());//
			parametros.put("V_EMPRAZONSOC", solicitud.getEmpresa().getV_razsoc());//
			parametros.put("V_EMPCODDEP", solicitud.getV_coddepemp());//
			parametros.put("V_EMPCODPRO", solicitud.getV_codproemp());//
			parametros.put("V_EMPCODDIS", solicitud.getV_coddisemp());//
			Combo empDep=dspcombos.departamentoByCod(solicitud.getV_coddepemp()).get(0);
			Combo empPro=dspcombos.provinciaByCod(solicitud.getV_coddepemp(), solicitud.getV_codproemp()).get(0);
			Combo empDis=dspcombos.distritoByCod(solicitud.getV_coddepemp(), solicitud.getV_codproemp(), solicitud.getV_coddisemp()).get(0);
			parametros.put("V_EMPDEPDES", empDep.getV_descripcion());//
			parametros.put("V_EMPPRODES", empPro.getV_descripcion());//
			parametros.put("V_EMPDISDES", empDis.getV_descripcion());//
			parametros.put("V_EMPDIRECCION", solicitud.getV_diremp().toUpperCase());//			
			//DltbcMateria materia=empDsp.getMateriaPorCodigo(solicitud.getN_codmat());
			//SE COMENTA LAS MATERIAS YA QUE PIDIERON QUE NO SE MUESTRE
			//DltbcMateria materia=(!solicitud.getV_flgrellab())?new DltbcMateria():empDsp.getMateriaPorCodigo(solicitud.getN_codmat());
			if(solicitud.getV_flgrellab())
			{
//				parametros.put("N_CODMATERIA", ""+solicitud.getN_codmat());//
//				parametros.put("V_DESMATERIA", materia.getvDesmat());
//				parametros.put("V_DESMATOTRO", solicitud.getV_desotros());//
				
				parametros.put("N_CODMATERIA", "");//
				parametros.put("V_DESMATERIA", "");
				parametros.put("V_DESMATOTRO", "");//
			}
			else
			{
				parametros.put("N_CODMATERIA", "");//
				parametros.put("V_DESMATERIA", "");
				parametros.put("V_DESMATOTRO", "");//
			}
			parametros.put("V_DESDENUNCIA", solicitud.getV_motivo().toUpperCase());//
			parametros.put("V_DESINTREG", intendenciaSIITSeleccionada.getvDesdep());//intendenciaTrExSeleccionada.getvDesint()
			List<Map>  dummyList=new ArrayList<Map>();
			dummyList.add(parametros);
			FacesUtils.mostrarReporteJasper(parametros, "constancia_denuncia.jasper", dummyList, "ConstanciaDeDenuncia");
			System.out.println("Muestra reporte");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	
	public String formatEmail()
	{
		String body="";
		try {
			EmpleadorDespatch empDsp = new EmpleadorDespatch();
			Combo solDep=dspcombos.departamentoByCod(solicitud.getV_coddepper()).get(0);
			Combo solPro=dspcombos.provinciaByCod(solicitud.getV_coddepper(), solicitud.getV_codproper()).get(0);
			Combo solDis=dspcombos.distritoByCod(solicitud.getV_coddepper(), solicitud.getV_codproper(), solicitud.getV_coddisper()).get(0);	
			SitbTipomoneda solMon=empDsp.getMonedaPorCodigo(solicitud.getV_codtmon());
			Combo empDep=dspcombos.departamentoByCod(solicitud.getV_coddepemp()).get(0);
			Combo empPro=dspcombos.provinciaByCod(solicitud.getV_coddepemp(), solicitud.getV_codproemp()).get(0);
			Combo empDis=dspcombos.distritoByCod(solicitud.getV_coddepemp(), solicitud.getV_codproemp(), solicitud.getV_coddisemp()).get(0);
			//DltbcMateria materia=empDsp.getMateriaPorCodigo(solicitud.getN_codmat());
			
			//COMENTADO POR QUE PIDIERON SCAR LA MATERIA: 28/06/2016
			//DltbcMateria materia=(!solicitud.getV_flgrellab())?new DltbcMateria():empDsp.getMateriaPorCodigo(solicitud.getN_codmat());
			body="<style type=\"text/css\">\n" +
					".tg  {border-collapse:collapse;border-spacing:0;}\n" +
					".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;}\n" +
					".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;}\n" +
					".tg .tg-yw4l{vertical-align:top}\n" +
					"</style>\n" +
					"<table class=\"tg\">\n" +
					"<tr>\n" +
					"    <th class=\"tg-yw4l\" colspan=\"2\" style=\"vertical-align:middle;\"><img alt=\"\" height=\"40px\" src=\"http://www.sunafil.gob.pe/portal/images/Logo-Sunafil-Final.png\"></th>\n" +
					"    <th class=\"tg-yw4l\" colspan=\"2\" style=\"vertical-align:middle;\">HOJA DE RUTA N&#176; "+registroGuardado.getvNumhoja()+"-"+registroGuardado.getvAniohoja()+"</th>\n" +
					"  </tr>"+
					/*"  <tr>\n" +
					"    <th class=\"tg-yw4l\" colspan=\"2\" rowspan=\"2\"><img alt=\"\" height=\"40px\" src=\"http://www.sunafil.gob.pe/portal/images/Logo-Sunafil-Final.png\"></th>\n" +
					"    <th class=\"tg-yw4l\" colspan=\"2\">HOJA DE RUTA N&#176; "+registroGuardado.getvNumhoja()+"-"+registroGuardado.getvAniohoja()+"</th>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"2\"><center>SOLICITUD DE ACTUACI&Oacute;N INSPECTIVA N&#176; "+solicitud.getV_numsol()+"-"+solicitud.getV_anhosol()+"</center></td>\n" +
					"  </tr>\n" +*/
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\" style=\"color:white;background-color:#666666\"><center>SOLICITUD DE ACTUACI&Oacute;N INSPECTIVA</center></td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Entidad:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">Superintendencia Nacional de Fiscalizaci&oacute;n Laboral</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Intendencia Regional:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+intendenciaSIITSeleccionada.getvDesdep()+"</td>\n" +//intendenciaTrExSeleccionada.getvDesint()
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Fecha de Registro:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+getFormatDate(registroGuardado.getdFecreg())+" "+getFormatHour(registroGuardado.getdFecreg())+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\" style=\"color:white;background-color:#666666\"> 1. Datos del Solicitante</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Apellidos y Nombre:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+solicitud.getPersona().getV_appaterno()+" "+solicitud.getPersona().getV_apmaterno()+" "+solicitud.getPersona().getV_nombres()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Tel&eacute;fono Fijo:</td>\n" +
					"    <td class=\"tg-yw4l\">"+solicitud.getV_telfijo()+"</td>\n" +
					"    <td class=\"tg-yw4l\">Tel&eacute;fono Celular:</td>\n" +
					"    <td class=\"tg-yw4l\">"+solicitud.getV_telcel()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Correo Electr&oacute;nico:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+solicitud.getV_email()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\">Domicilio:<hr/></td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"2\">Departamento / Provincia / Distrito:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"2\">"+solDep.getV_descripcion()+" / "+solPro.getV_descripcion()+" / "+solDis.getV_descripcion()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Direcci&oacute;n:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+solicitud.getV_dirper().toUpperCase()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\">Datos Laborales:<hr/></td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">Se encuentra actualmente laborando en la empresa?</td>\n" +
					"    <td class=\"tg-yw4l\">"+(solicitud.getV_flgrellab()?"SI":"NO")+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Fecha de Ingreso:</td>\n" +
					"    <td class=\"tg-yw4l\">"+getFormatDate(solicitud.getD_fecing())+"</td>\n" +
					"    <td class=\"tg-yw4l\">Fecha de Cese:</td>\n" +
					"    <td class=\"tg-yw4l\">"+(solicitud.getD_fecces()!=null?getFormatDate(solicitud.getD_fecces()):"")+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Cargo: </td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+solicitud.getV_cargo().toUpperCase()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Remuneraci&oacute;n Moneda:</td>\n" +
					"    <td class=\"tg-yw4l\">"+solMon.getvDestmon()+"</td>\n" +
					"    <td class=\"tg-yw4l\">Monto:</td>\n" +
					"    <td class=\"tg-yw4l\">"+solicitud.getN_monto()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\" style=\"color:white;background-color:#666666\"> 2. Datos del Empleador</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Raz&oacute;n Social:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+solicitud.getEmpresa().getV_razsoc()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\">Centro de Trabajo:<hr/></td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"2\">Departamento / Provincia / Distrito:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"2\">"+empDep.getV_descripcion()+" / "+empPro.getV_descripcion()+" / "+empDis.getV_descripcion()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Direcci&oacute;n:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+solicitud.getV_diremp().toUpperCase()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\" style=\"color:white;background-color:#666666\"> 3. Datos de la Denuncia</td>\n" +
					"  </tr>\n" +
					//COMENTADO POR QUE PIDIERON SCAR LA MATERIA: 28/06/2016
					/*
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Materia:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+((solicitud.getV_flgrellab())?materia.getvDesmat():"")+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Especifique:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+((solicitud.getV_flgrellab())?(solicitud.getV_desotros()!=null?solicitud.getV_desotros():""):"")+"</td>\n" +
					"  </tr>\n" +
					*/
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\">Descripci&oacute;n de Denuncia:<hr/></td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\">"+solicitud.getV_motivo().toUpperCase()+"</td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\" style=\"color:white;background-color:#666666\"> Su solicitud ha sido enviada de manera satisfactoria gener&aacute;ndose la hoja de ruta N&#176; "+registroGuardado.getvNumhoja()+"-"+registroGuardado.getvAniohoja()+"-SUNAFIL, la cual le servir&aacute; para realizar el seguimiento respectivo en la p&aacute;gina Web de la Sunafil a trav&eacute;s de la opci&oacute;n Consulta tu Tr&aacute;mite o en el siguiente link: <a style=\"color:#2424e3;\" target=\"_blank\" href=\"http://appweb.trabajo.gob.pe/si.consultaWebSIIT/\">http://appweb.trabajo.gob.pe/si.consultaWebSIIT/</a> </td>" +
					"  </tr>\n" +
					"</table>\n";
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return body;
	}
	
	public void dialogReferencia(){		
		RequestContext.getCurrentInstance().execute("dialogWidget.show()");
	}
	
	public String getFormatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
	
	public String getFormatHour(Date date) {
        return new SimpleDateFormat("HH:mm").format(date);
    }
	
	public void generarConstancia(){
		try {
			ReporteDespatch dspReporte=new ReporteDespatch();					
			Map parameters = new HashedMap();
			//LA RUTA IMAGEN LA PONE EL METODO MOSTRARREPORTE
			List<Map>  lstReclamo=dspReporte.reporteConstanciaReclamo(solicitud);
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
	 * Metodo con el cual se obtiene las provincias del departamento competencia SUNAFIL seleccionado.
	 */
	public void selCmbDepartamentoEmp(){
		logger.info("Obteniendo Cmb Provincia");
		try{
			listaProvinciasEmp = new ArrayList<Combo>();
			String coddepemp = solicitud.getV_coddepemp(); 
			listaProvinciasEmp = dspcombos.listaProvinciasxDepEmp(coddepemp);
			
			//DESSELECCIONANDO LA PROVINCIA
			solicitud.setV_codproemp("");
			//DESSELECCIONANDO EL DISTRITO
			solicitud.setV_coddisemp("");
			
			//LIMPIAMOS LOS DISTRITOS
			listaDistritosEmp = new ArrayList<Combo>();
			
		}catch(Exception e){
			logger.error("Error en Listar las provincias y distritos: "+e.getMessage(),e);
		}
	}
	
	
	/**
	 * Metodo con el cual se obtiene los distritos de la provincia de competencia SUNAFIL seleccionado.
	 */
	public void selCmbProvinciaEmp(){
		logger.info("Obteniendo Cmb Distrito");
		try{
			listaDistritosEmp = new ArrayList<Combo>();
			String coddepemp = solicitud.getV_coddepemp();
			String codproemp = solicitud.getV_codproemp();
			listaDistritosEmp = dspcombos.listaDistritosxProEmp(coddepemp,codproemp);
			//DESSELECCIONANDO EL DISTRITO
			solicitud.setV_coddisemp("");
			
		}catch(Exception e){
			logger.error("Error en Listar los distritos: "+e.getMessage(),e);
		}
	}
	
	public void selCmbDepartamentoPer(){
		logger.info("Obteniendo Cmb Provincia");
		try{
			listaProvinciasPer = new ArrayList<Combo>();
			String coddepper = solicitud.getV_coddepper(); 
			listaProvinciasPer = dspcombos.listaProvinciasxDep(coddepper);
			
			//DESSELECCIONANDO LA PROVINCIA
			solicitud.setV_codproper("");
			//DESSELECCIONANDO EL DISTRITO
			solicitud.setV_coddisper("");
			
			//LIMPIAMOS LOS DISTRITOS
			listaDistritosPer = new ArrayList<Combo>();
			
		}catch(Exception e){
			logger.error("Error en Listar las provincias y distritos: "+e.getMessage(),e);
		}
	}
	
	public void selCmbProvinciaPer(){
		logger.info("Obteniendo Cmb Distrito");
		try{
			listaDistritosPer = new ArrayList<Combo>();
			String coddepper = solicitud.getV_coddepper();
			String codproper = solicitud.getV_codproper();
			listaDistritosPer = dspcombos.listaDistritosxPro(coddepper,codproper);
			//DESSELECCIONANDO EL DISTRITO
			solicitud.setV_coddisper("");
			
		}catch(Exception e){
			logger.error("Error en Listar los distritos: "+e.getMessage(),e);
		}
	}
	
	//=========================================
	//METODOS PARA CAMBIAR DE DOCUMENTO:
	//=========================================
	public void cambiaFileCroquis(){
		logger.info("Cambiando archivo Croquis");
		setFileName(null);
		System.out.println("Croquis seteado en fileName a NULL");
		//ELIMINAMOS EL ARCHIVO DE CROQUIS:
		logger.info("eliminando archivo de croquis..");
		eliminarArchSubidos("1"+"-"+solicitud.getN_codsol()+".pdf");//1:ES CROQUIS
		logger.info("fin cambio de archivo de croquis..");
	}
	
	public void cambiaFileDNI(){
		logger.info("Cambiando archivo DNI");
		setFileDNIName(null);
		System.out.println("Dni seteado en fileDNIName a NULL");
		//ELIMINAMOS EL ARCHIVO DE DNI:
		logger.info("eliminando archivo de DNI..");
		eliminarArchSubidos("2"+"-"+solicitud.getN_codsol()+".pdf");//2:ES DNI
		logger.info("fin cambio de archivo de DNI..");
	}
	
	public void cambiaFileContrato(){
		logger.info("Cambiando archivo Contrato");
		setFileContratoName(null);
		System.out.println("Contrato seteado en fileContratoName a NULL");
		//ELIMINAMOS EL ARCHIVO DE CONTRATO:
		logger.info("eliminando archivo de Contrato..");
		eliminarArchSubidos("3"+"-"+solicitud.getN_codsol()+".pdf");//3:ES CONTRATO
		
		logger.info("fin cambio de archivo de Contrato..");
	}
	public void cambiaFileBoleta(){
		logger.info("Cambiando archivo Boleta");
		setFileBoletaName(null);
		//ELIMINAMOS EL ARCHIVO DE BOLETA:
		logger.info("eliminando archivo de Boleta..");
		eliminarArchSubidos("4"+"-"+solicitud.getN_codsol()+".pdf");//4:ES BOLETA
		System.out.println("Boleta seteado en fileName a NULL");
		logger.info("fin cambio de archivo de Boleta..");
	}
	public void cambiaFileOtros(){
		logger.info("Cambiando archivo Otros");
		setFileOtrosName(null);
		//ELIMINAMOS EL ARCHIVO DE OTROS:
		logger.info("eliminando archivo de Otros..");
		eliminarArchSubidos("5"+"-"+solicitud.getN_codsol()+".pdf");//5:ES OTROS
		System.out.println("Otros seteado en fileName a NULL");
		logger.info("fin cambio de archivo de Otros..");
	}
	
	
	public int eliminarArchSubidos(String nombArch){
		try{
			String destination = Funciones.ObtProp_App("ruta.fileserver");
			FacesUtils.eliminarArchivo(nombArch,  destination.trim());
			return 1;
		}catch(Exception e){
			return 0;
		}
	}
	
	
	/**
	 * Metodo que muestra el PDF en otra pestaña del navegador.
	 * @throws Exception
	 */
	public void mostrarGuiaUsuario() throws Exception{
		//RUTA UBICACION DE LA GUIA DE USUARIO
		String ubic_guia_usuario= Funciones.ObtProp_Resources("ubicacion.guia");
		FacesUtils.mostrarPDF(ubic_guia_usuario, "MANUAL_O_GUIA_DEL_USUARIO.pdf");
	}
	
	
	//##############################################################################################################
	//      ZONA DE GET Y SET
	//##############################################################################################################
	

	public boolean isDatos2MostrarSgte() {
		return datos2MostrarSgte;
	}

	public void setDatos2MostrarSgte(boolean datos2MostrarSgte) {
		this.datos2MostrarSgte = datos2MostrarSgte;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public DocumentoxSolicitud getDocxsolicitud() {
		return docxsolicitud;
	}

	public void setDocxsolicitud(DocumentoxSolicitud docxsolicitud) {
		this.docxsolicitud = docxsolicitud;
	}

	public List<Combo> getListaProvinciasEmp() {
		return listaProvinciasEmp;
	}

	public void setListaProvinciasEmp(List<Combo> listaProvinciasEmp) {
		this.listaProvinciasEmp = listaProvinciasEmp;
	}

	public List<Combo> getListaDistritosEmp() {
		return listaDistritosEmp;
	}

	public void setListaDistritosEmp(List<Combo> listaDistritosEmp) {
		this.listaDistritosEmp = listaDistritosEmp;
	}

	public CombosDespatch getDspcombos() {
		return dspcombos;
	}

	public void setDspcombos(CombosDespatch dspcombos) {
		this.dspcombos = dspcombos;
	}

	public List<Combo> getListaProvinciasPer() {
		return listaProvinciasPer;
	}

	public void setListaProvinciasPer(List<Combo> listaProvinciasPer) {
		this.listaProvinciasPer = listaProvinciasPer;
	}

	public List<Combo> getListaDistritosPer() {
		return listaDistritosPer;
	}

	public void setListaDistritosPer(List<Combo> listaDistritosPer) {
		this.listaDistritosPer = listaDistritosPer;
	}

	public boolean isLabora() {
		return labora;
	}

	public void setLabora(boolean labora) {
		this.labora = labora;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public BeanDdp getDatosRUC() {
		return datosRUC;
	}

	public void setDatosRUC(BeanDdp datosRUC) {
		this.datosRUC = datosRUC;
	}

	public VstIntendenRegionales getIntendenciaSIITSeleccionada() {
		return intendenciaSIITSeleccionada;
	}

	public void setIntendenciaSIITSeleccionada(
			VstIntendenRegionales intendenciaSIITSeleccionada) {
		this.intendenciaSIITSeleccionada = intendenciaSIITSeleccionada;
	}

	public TdtbcIntendencia getIntendenciaTrExSeleccionada() {
		return intendenciaTrExSeleccionada;
	}

	public void setIntendenciaTrExSeleccionada(
			TdtbcIntendencia intendenciaTrExSeleccionada) {
		this.intendenciaTrExSeleccionada = intendenciaTrExSeleccionada;
	}

	public String getEsMTPE() {
		return esMTPE;
	}

	public void setEsMTPE(String esMTPE) {
		this.esMTPE = esMTPE;
	}

	

	public SitbDepxdistrito getUnidadSIITSeleccionada() {
		return unidadSIITSeleccionada;
	}

	public void setUnidadSIITSeleccionada(SitbDepxdistrito unidadSIITSeleccionada) {
		this.unidadSIITSeleccionada = unidadSIITSeleccionada;
	}

	public TdtbdCentrolab getDireccionSeleccionada() {
		return direccionSeleccionada;
	}

	public void setDireccionSeleccionada(TdtbdCentrolab direccionSeleccionada) {
		this.direccionSeleccionada = direccionSeleccionada;
	}

	public TdtbcEntidad getEntidadSeleccionada() {
		return entidadSeleccionada;
	}

	public void setEntidadSeleccionada(TdtbcEntidad entidadSeleccionada) {
		this.entidadSeleccionada = entidadSeleccionada;
	}

	public TdmvcRegistro getRegistroGuardado() {
		return registroGuardado;
	}

	public void setRegistroGuardado(TdmvcRegistro registroGuardado) {
		this.registroGuardado = registroGuardado;
	}

	public UploadedFile getFileDNI() {
		return fileDNI;
	}

	public void setFileDNI(UploadedFile fileDNI) {
		this.fileDNI = fileDNI;
		if (this.fileDNI != null) {
            fileDNIName = fileDNI.getFileName();
		}
	}

	public UploadedFile getFileContrato() {
		return fileContrato;
	}

	public void setFileContrato(UploadedFile fileContrato) {
		this.fileContrato = fileContrato;
		if (this.fileContrato != null) {
            fileContratoName = fileContrato.getFileName();
		}
	}

	public UploadedFile getFileBoleta() {
		return fileBoleta;
	}

	public void setFileBoleta(UploadedFile fileBoleta) {
		this.fileBoleta = fileBoleta;
		if (this.fileBoleta != null) {
            fileBoletaName = fileBoleta.getFileName();
		}
	}

	public UploadedFile getFileOtros() {
		return fileOtros;
	}

	public void setFileOtros(UploadedFile fileOtros) {
		this.fileOtros = fileOtros;
		if (this.fileOtros != null) {
            fileOtrosName = fileOtros.getFileName();
		}
	}	

	public List<DltbcMateria> getListaMateria() {
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		try {
			listaMateria=empDsp.getMateria();
		} catch (Exception e) {
			listaMateria=null;
			e.printStackTrace();
		}
		return listaMateria;
	}

	public void setListaMateria(List<DltbcMateria> listaMateria) {
		this.listaMateria = listaMateria;
	}

	public List<SitbTipomoneda> getListaTipoMoneda() {
		EmpleadorDespatch empDsp = new EmpleadorDespatch();
		try {
			listaTipoMoneda=empDsp.getTipoMoneda();
		} catch (Exception e) {
			listaTipoMoneda=null;
			e.printStackTrace();
		}
		return listaTipoMoneda;
	}

	public void setListaTipoMoneda(List<SitbTipomoneda> listaTipoMoneda) {
		this.listaTipoMoneda = listaTipoMoneda;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
		if (this.file != null) {
            fileName = file.getFileName();
        }
	}
	
	
	
	//***********************
	//LOS NOMBRES DE FILE 
	//***********************
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDNIName() {
		return fileDNIName;
	}

	public void setFileDNIName(String fileDNIName) {
		this.fileDNIName = fileDNIName;
	}

	public String getFileContratoName() {
		return fileContratoName;
	}

	public void setFileContratoName(String fileContratoName) {
		this.fileContratoName = fileContratoName;
	}

	public String getFileBoletaName() {
		return fileBoletaName;
	}

	public void setFileBoletaName(String fileBoletaName) {
		this.fileBoletaName = fileBoletaName;
	}

	public String getFileOtrosName() {
		return fileOtrosName;
	}

	public void setFileOtrosName(String fileOtrosName) {
		this.fileOtrosName = fileOtrosName;
	}
	
}