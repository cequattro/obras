package pe.gob.mtpe.retorno.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javassist.bytecode.stackmap.TypeData.ClassName;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.xml.ws.WebServiceException;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Departamento;
import pe.gob.mtpe.retorno.bean.Discapacidad;
import pe.gob.mtpe.retorno.bean.Distrito;
import pe.gob.mtpe.retorno.bean.Familia;
import pe.gob.mtpe.retorno.bean.Niveleducati;
import pe.gob.mtpe.retorno.bean.Ocupacion;
import pe.gob.mtpe.retorno.bean.Pais;
import pe.gob.mtpe.retorno.bean.ParamBus;
import pe.gob.mtpe.retorno.bean.Persona;
import pe.gob.mtpe.retorno.bean.Profesion;
import pe.gob.mtpe.retorno.bean.Provincia;
import pe.gob.mtpe.retorno.bean.Rango;
import pe.gob.mtpe.retorno.bean.Retorno;
import pe.gob.mtpe.retorno.bean.Tdocide;
import pe.gob.mtpe.retorno.service.ComunService;
import pe.gob.mtpe.retorno.service.PersonaService;
import pe.gob.mtpe.retorno.service.RetornoService;
import pe.gob.mtpe.retorno.utils.FacesUtils;
import pe.gob.mtpe.retorno.utils.Funciones;
import pe.gob.mtpe.retorno.ws.ReniecWebService;

@Controller
@Scope("session")
public class RetornoBean implements Serializable {

	final static Logger logger = Logger.getLogger(ClassName.class);
	/**
	 * Variables
	 */

	@Autowired
	private PersonaService personaService;

	@Autowired
	private ComunService comunService;

	@Autowired
	private RetornoService retornoService;

	@Autowired
	private ReniecWebService reniecWebService;

	private ParamBus paramBusOcupacion;
	private ParamBus paramBus;
	private List<Ocupacion> lstOcupacion;
	private List<Profesion> lstProfesion;
	private DPersona dpersona;
	private Ocupacion ocupacion1;
	private Profesion profesion;
	private List<Tdocide> lstTipoDoc;
	private List<Departamento> lstDepartamento;
	private List<Provincia> lstProvincia;
	private List<Distrito> lstDistrito;
	Departamento departamento;
	private Persona persona;
	Provincia provincia;
	private List<Pais> lstPais;
	private List<Discapacidad> lstDiscapacidad;
	private List<Niveleducati> lstNiveleducati;

	private String rfamiliar;
	private String vOcupacion;
	private Ocupacion ocupacion2;
	private Ocupacion ocupacion3;
	private Ocupacion ocupacion4;
	private Familia conyugue;
	private List<Familia> lstHijos;
	private Familia otraFamilia;
	private Retorno motivoRetorno;
	private List<Retorno> lstMotivos;
	private List<Rango> lstMonto;
	private List<Rango> lstTiempoDesem;
	private Retorno motivo;
	private Integer nlenthNumdoc;
	
	private String  txtInsertarPersona;
	private boolean blnInsertarPersona;
	private boolean blnActualizaPersona;
	private boolean blnBuscoPersona;
	
	public Familia getOtraFamilia() {
		return otraFamilia;
	}

	public void setOtraFamilia(Familia otraFamilia) {
		this.otraFamilia = otraFamilia;
	}

	public RetornoBean() {
		inicializarObjetos();

	}

	private void inicializarObjetos() {
		paramBusOcupacion = new ParamBus();
		lstOcupacion = new ArrayList<Ocupacion>();
		dpersona = new DPersona();
		ocupacion1 = new Ocupacion();
		lstProfesion = new ArrayList<Profesion>();
		paramBus = new ParamBus();
		profesion = new Profesion();
		persona = new Persona();
		lstTipoDoc = new ArrayList<Tdocide>();
		lstDepartamento = new ArrayList<Departamento>();
		lstProvincia = new ArrayList<Provincia>();
		departamento = new Departamento();
		provincia = new Provincia();
		lstDistrito = new ArrayList<Distrito>();
		lstPais = new ArrayList<Pais>();
		lstDiscapacidad = new ArrayList<Discapacidad>();
		lstNiveleducati = new ArrayList<Niveleducati>();
		ocupacion2 = new Ocupacion();
		conyugue = new Familia();

		lstHijos = new ArrayList<Familia>();
		otraFamilia = new Familia();
		motivoRetorno = new Retorno();
		lstMonto = new ArrayList<Rango>();
		lstTiempoDesem = new ArrayList<Rango>();
		motivo = new Retorno();
		ocupacion3 = new Ocupacion();
		ocupacion4 = new Ocupacion();
		nlenthNumdoc = 0;
		txtInsertarPersona="";
		blnInsertarPersona=false;
		blnBuscoPersona=false;
		blnActualizaPersona=true;

	}

	@PostConstruct
	public void inicializarListas() throws Exception {		
		lstDiscapacidad = comunService.listaDiscapacidad();
		lstNiveleducati = comunService.listarNivelEducativo();
		lstPais = comunService.listaPais();
		lstDepartamento = comunService.ListaDepartamentos();
		lstTipoDoc = comunService.listarTipoDocumento();
		Rango pRango = new Rango();
		pRango.setvTiprango("1");
		lstMonto = retornoService.listarRango(pRango);
		pRango.setvTiprango("2");
		lstTiempoDesem = retornoService.listarRango(pRango);

	}

	public void limpiarFormulario() throws Exception {
		inicializarObjetos();
		inicializarListas();

	}

	public void tamanoNumDoc() throws Exception {

		if ("03".equals(dpersona.getvCodtdocide())) {
			nlenthNumdoc = 8;
		} else if ("08".equals(dpersona.getvCodtdocide())) {
			nlenthNumdoc = 12;
		}

		dpersona.setvNumdoc("");

	}
	
	public void mostrarManual()throws Exception{		
		String rutaGeneral = Funciones.ObtieneProperty("pe.gob.mtpe.retorno.util.properties.mtpe_app","mtpe.framework.ruta");
		String rutaArchivo = Funciones.leerPropertyExterno(rutaGeneral, "mtpe.framework.rutaManualExterno");
		String nombreArchivo = Funciones.leerPropertyExterno(rutaGeneral, "mtpe.framework.nombreManualExterno");
		
		FacesUtils.mostrarPDF(rutaArchivo, nombreArchivo);		
		
	}


	public void buscarPersona() {
		String num = dpersona.getvNumdoc();
		String tip = dpersona.getvCodtdocide();
		RequestContext context = RequestContext.getCurrentInstance();
		try {
			blnBuscoPersona=true;
			int existeRegistro = 0;
			int existePersona = 0;
			existeRegistro = retornoService.consultaNumeroRegistros(dpersona);
			persona = personaService.buscarPersona(dpersona);
			
			
			if (existeRegistro > 0) {
				dpersona = retornoService.cargarDPersona(dpersona);	
				paramBus = new ParamBus();
				paramBus.setvCodprof(dpersona.getvCodprof());				
				profesion = comunService.buscarProfesion(paramBus).get(0);
				paramBus.setvCodocupac(dpersona.getvCodocuper());
				ocupacion1 = comunService.buscarOcupacion(paramBus).get(0);
				paramBus.setvCodocupac(dpersona.getvCodocuext());
				ocupacion2 = comunService.buscarOcupacion(paramBus).get(0);
				paramBus.setvCodocupac(dpersona.getvCodocudes1());
				ocupacion3 = comunService.buscarOcupacion(paramBus).get(0);
				paramBus.setvCodocupac(dpersona.getvCodocudes2());
				ocupacion4 = comunService.buscarOcupacion(paramBus).get(0);
				motivo = retornoService.CargarMotivoRetorno(dpersona);
				if (lstHijos != null) {
					lstHijos = retornoService.cargarHijoRetorno(dpersona);
				}
				dpersona.setnNumhijosRet(lstHijos.size());				
				
			} else {
				existePersona = personaService.consultaNumeroPersonas(dpersona);
				dpersona = new DPersona();
				ocupacion1=new Ocupacion();
				ocupacion2=new Ocupacion();
				ocupacion3=new Ocupacion();
				ocupacion4=new Ocupacion();
				profesion=new Profesion(); 

				if (existePersona == 0) {
					persona = new Persona();
					persona.setvNumdoc(num);
					persona.setvCodtdocide(tip);
					persona = reniecWebService.obtenerPersonaSWReniec(persona);
				}
				dpersona.setvNumdoc(num);
				dpersona.setvCodtdocide(tip);

			}
			
			if (persona != null) {
				if (persona.getvCoddepnac() != null) {
					departamento.setvCoddep(persona.getvCoddepnac());
					lstProvincia = comunService.ListaProvincias(departamento);
					provincia.setvCoddep(persona.getvCoddepnac());
					provincia.setvCodpro(persona.getvCodpronac());
					lstDistrito = comunService.ListaDistritos(provincia);
				}
			}else{				
				txtInsertarPersona="Este documento no se encuentra en nuestra base de datos ¿desea registrarlo?";
				persona=new Persona();
				persona.setvNumdoc(num);
				persona.setvCodtdocide(tip);				
				context.execute("dlgConfirmRegistroPersona.show()");
			}
			context.update("formRetorno");
		}catch(WebServiceException w){	
			
			if("DNE".equals(w.getMessage())){
				FacesUtils.showFacesMessage("El DNI consultado no existe", 1);
				context.update("formRetorno");
				blnInsertarPersona=false;
				blnActualizaPersona=false;
			}else{
				txtInsertarPersona="Ha ocurrido un problema de conexión con la RENIEC no se puede validar el documento¿desea registrarlo?";
				persona=new Persona();
				persona.setvNumdoc(num);
				persona.setvCodtdocide(tip);	
				dpersona.setvNumdoc(num);
				dpersona.setvCodtdocide(tip);
				context.update("formRetorno");
				context.execute("dlgConfirmRegistroPersona.show()");
			}			
			
			
		}catch (Exception e) {
			logger.error("ERROR ", e);
			persona = new Persona();
		}

	}	
	

	public void registrarFormulario() throws Exception {
		String texto="";
		Integer tipo=1;
		try {
			if(blnBuscoPersona==false){
				texto+="DEBE PRESIONAR EL BOTÓN BUSCAR EN LA SECCIÓN DE DATOS PERSONALES<br/>";
			}else{
				if(!persona.getvCodtdocide().equals(dpersona.getvCodtdocide())|| !persona.getvNumdoc().equals(dpersona.getvNumdoc())){
					texto+="A CAMBIADO EL TIPO O NÚMERO DE DOCUMENTO CON QUE EMPEZÓ EL REGISTRO,DEBE PRESIONAR EL BOTÓN BUSCAR EN LA SECCIÓN DE DATOS PERSONALES NUEVAMENTE<br/>";
				}
			}
			
					
			if(Funciones.compararFechas("01/"+dpersona.getdFeciniper(), "01/"+dpersona.getdFecfinper())){
				texto+="La fecha de fin de la última ocupación laboral en el Perú no debe ser menor a la fecha de inicio<br/>";
			}
			if(Funciones.compararFechas("01/"+dpersona.getdFeciniext(), "01/"+dpersona.getdFecfinext())){
				texto+="La fecha de fin de la última ocupación laboral en el extranjero no debe ser menor a la fecha de inicio<br/>";
			}
			
			String fechaActual="";			
			Calendar c = Calendar.getInstance();			
			String dia = c.get(Calendar.DATE)<10?"0"+Integer.toString(c.get(Calendar.DATE)):Integer.toString(c.get(Calendar.DATE));		
			String mes =(c.get(Calendar.MONTH)+1)<10?"0"+Integer.toString(c.get(Calendar.MONTH)+1):Integer.toString(c.get(Calendar.MONTH)+1);
			String annio = Integer.toString(c.get(Calendar.YEAR));
			fechaActual=dia+"/"+mes+"/"+annio;			
			
			if(Funciones.compararFechas("01/"+dpersona.getdFeciniper(),fechaActual)){
				texto+="La fecha de inicio de la última ocupación laboral en el Perú no debe ser mayor a la fecha actual<br/>";
			}
			
			if(Funciones.compararFechas("01/"+dpersona.getdFecfinper(),fechaActual)){
				texto+="La fecha de fin de la última ocupación laboral en el Perú no debe ser mayor a la fecha actual<br/>";
			}
			
			if(Funciones.compararFechas("01/"+dpersona.getdFeciniext(),fechaActual)){
				texto+="La fecha de inicio de la última ocupación laboral en el extranjero no debe ser mayor a la fecha actual<br/>";
			}			
			
			if(Funciones.compararFechas( "01/"+dpersona.getdFecfinext(),fechaActual)){
				texto+="La fecha de fin de la última ocupación laboral en el extranjero no debe ser mayor a la fecha actual<br/>";
			}
			
			
			if(Funciones.compararFechas("01/"+dpersona.getdFecsalper(), "01/"+dpersona.getdFecretper())){
				texto+="La Fecha de Probable Retorno al Perú no debe ser menor a la Fecha de Salida del Perú<br/>";
			}
			
			
			
			if(Funciones.compararFechas("01/"+dpersona.getdFecfinper(), "01/"+dpersona.getdFecsalper())){
				texto+="La Fecha de Salida del Perú no debe ser menor a la Fecha de Cese de la Última Ocupación Laboral en Perú<br/>";
			}
			
			if(Funciones.compararFechas("01/"+dpersona.getdFecfinext(), "01/"+dpersona.getdFecsalper())){
				texto+="La Fecha de Salida del Perú no debe ser menor a la Fecha de Cese de la Última Ocupación Laboral en Extranjero<br/>";
			}
			
			if(Funciones.compararFechas("01/"+dpersona.getdFecfinper(), "01/"+dpersona.getdFecretper())){
				texto+="La Fecha de Retorno del Perú no debe ser menor a la Fecha de Cese de la Última Ocupación Laboral en Perú<br/>";
			}
			
			if(Funciones.compararFechas("01/"+dpersona.getdFecfinext(), "01/"+dpersona.getdFecretper())){
				texto+="La Fecha de Retorno del Perú no debe ser menor a la Fecha de Cese de la Última Ocupación Laboral en Extranjero<br/>";
			}
			
			
			
			if("S".equals(dpersona.getvFlgretfam())){
				if(dpersona.getnNumhijosRet()!=null){
					if(dpersona.getnNumhijosRet().equals(lstHijos.size())){
						dpersona.setLstHijos(lstHijos);
					}else if(dpersona.getnNumhijosRet().equals(0)){
						texto+="Debe ingresar el número de hijos con que retornará \n";
					}else{
						texto+="La cantidad de N° Hijos no corresponde con la lista descrita mas adelante<br/>";
					}
				}
			}
			
			if(dpersona.getvCoddepret1().equals(dpersona.getvCoddepret2())){
				texto+="Los posibles departamentos de retorno no pueden ser iguales<br/>";
			}
			
			if(dpersona.getvCodocudes1().equals(dpersona.getvCodocudes2())){
				texto+="Las ocupaciones en que podría desempeñarse no pueden ser iguales<br/>";
			}
			
			if (blnActualizaPersona==false) {
				texto+="Debe ingresar un DNI válido<br/>";
			}
			
			RequestContext context=RequestContext.getCurrentInstance();
			if("".equals(texto)){
				dpersona.setdFeciniper("01/"+dpersona.getdFeciniper());
				dpersona.setdFecfinper("01/"+dpersona.getdFecfinper());
				dpersona.setdFeciniext("01/"+dpersona.getdFeciniext());
				dpersona.setdFecfinext("01/"+dpersona.getdFecfinext());
				dpersona.setdFecsalper("01/"+dpersona.getdFecsalper());
				dpersona.setdFecretper("01/"+dpersona.getdFecretper());
				
				if(blnInsertarPersona==true){
					personaService.insertPersona(persona);
				}
				personaService.actualizarPersona(persona);	
				retornoService.insertardPersona(dpersona);
				context.addCallbackParam("error",false);
				inicializarObjetos();
				inicializarListas();
			}else{
				
				FacesUtils.showFacesMessage(texto, tipo);
				context.addCallbackParam("error",true);
			}
		} catch (Exception e) {
			logger.error("ERROR ", e);
			RequestContext context=RequestContext.getCurrentInstance();
			texto="Error en el sistema";
			FacesUtils.showFacesMessage(texto, tipo);
			context.addCallbackParam("error",true);
		}

	}

	public void cargarMotivos() throws Exception {
		try {
			lstMotivos = retornoService.listarMotivos();
		} catch (Exception e) {
			logger.error("ERROR ", e);
		}
	}

	public void agregarHijos() {
		try {
			lstHijos = new ArrayList<Familia>();
			for (int i = 0; i < dpersona.getnNumhijosRet(); i++) {
				Familia f = new Familia();
				f.setvCodtdocide(dpersona.getvCodtdocide());
				f.setvNumdoc(dpersona.getvNumdoc());
				lstHijos.add(f);
			}
		} catch (Exception e) {
			logger.error("ERROR ", e);
		}

	}

	public void mostrarOcupacion() {
		lstOcupacion = new ArrayList<Ocupacion>();
	}

	public void mostrarProfesion() {
		lstProfesion = new ArrayList<Profesion>();
	}

	public void listarDistritos() throws Exception {
		try {
			provincia.setvCoddep(persona.getvCoddepnac());
			provincia.setvCodpro(persona.getvCodpronac());
			lstDistrito = comunService.ListaDistritos(provincia);
		} catch (Exception e) {
			logger.error("ERROR ", e);
		}
	}

	public void listarProvincias() throws Exception {
		try {
			departamento.setvCoddep(persona.getvCoddepnac());
			lstProvincia = comunService.ListaProvincias(departamento);
		} catch (Exception e) {
			logger.error("ERROR ", e);
		}
	}

	public void buscarOcupacion() throws Exception {
		try {
			lstOcupacion = comunService.buscarOcupacion(paramBusOcupacion);
		} catch (Exception e) {
			logger.error("ERROR ", e);
		}

	}

	public void buscarProfesion() throws Exception {
		try {
			lstProfesion = comunService.buscarProfesion(paramBus);
		} catch (Exception e) {
			logger.error("ERROR ", e);
		}

	}

	/***
	 * Metodo que redirecciona y muestra las preguntas frecuentes
	 */
	public String mostrarPreguntasFrecuentes() {
		String vista = "pretty:preguntasFrecuentes";

		return vista;

	}

	/**
	 * Zona Getter setter
	 */

	public String getRfamiliar() {
		return rfamiliar;
	}

	public void setRfamiliar(String rfamiliar) {
		this.rfamiliar = rfamiliar;
	}

	public DPersona getDpersona() {
		return dpersona;
	}

	public void setDpersona(DPersona dpersona) {
		this.dpersona = dpersona;
	}

	public List<Ocupacion> getLstOcupacion() {
		return lstOcupacion;
	}

	public void setLstOcupacion(List<Ocupacion> lstOcupacion) {
		this.lstOcupacion = lstOcupacion;
	}

	public ParamBus getParamBusOcupacion() {
		return paramBusOcupacion;
	}

	public void setParamBusOcupacion(ParamBus paramBusOcupacion) {
		this.paramBusOcupacion = paramBusOcupacion;
	}

	public Ocupacion getOcupacion1() {
		return ocupacion1;
	}

	public void setOcupacion1(Ocupacion ocupacion1) {
		this.ocupacion1 = ocupacion1;
	}

	public ParamBus getParamBus() {
		return paramBus;
	}

	public void setParamBus(ParamBus paramBus) {
		this.paramBus = paramBus;
	}

	public List<Profesion> getLstProfesion() {
		return lstProfesion;
	}

	public void setLstProfesion(List<Profesion> lstProfesion) {
		this.lstProfesion = lstProfesion;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	public List<Tdocide> getLstTipoDoc() {
		return lstTipoDoc;
	}

	public void setLstTipoDoc(List<Tdocide> lstTipoDoc) {
		this.lstTipoDoc = lstTipoDoc;
	}

	public List<Departamento> getLstDepartamento() {
		return lstDepartamento;
	}

	public void setLstDepartamento(List<Departamento> lstDepartamento) {
		this.lstDepartamento = lstDepartamento;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Provincia> getLstProvincia() {
		return lstProvincia;
	}

	public void setLstProvincia(List<Provincia> lstProvincia) {
		this.lstProvincia = lstProvincia;
	}

	public List<Distrito> getLstDistrito() {
		return lstDistrito;
	}

	public void setLstDistrito(List<Distrito> lstDistrito) {
		this.lstDistrito = lstDistrito;
	}

	public List<Pais> getLstPais() {
		return lstPais;
	}

	public void setLstPais(List<Pais> lstPais) {
		this.lstPais = lstPais;
	}

	public List<Discapacidad> getLstDiscapacidad() {
		return lstDiscapacidad;
	}

	public void setLstDiscapacidad(List<Discapacidad> lstDiscapacidad) {
		this.lstDiscapacidad = lstDiscapacidad;
	}

	public List<Niveleducati> getLstNiveleducati() {
		return lstNiveleducati;
	}

	public void setLstNiveleducati(List<Niveleducati> lstNiveleducati) {
		this.lstNiveleducati = lstNiveleducati;
	}

	public String getvOcupacion() {
		return vOcupacion;
	}

	public void setvOcupacion(String vOcupacion) {
		this.vOcupacion = vOcupacion;
	}

	public Ocupacion getOcupacion2() {
		return ocupacion2;
	}

	public void setOcupacion2(Ocupacion ocupacion2) {
		this.ocupacion2 = ocupacion2;
	}

	public Familia getConyugue() {
		return conyugue;
	}

	public void setConyugue(Familia conyugue) {
		this.conyugue = conyugue;
	}

	public List<Familia> getLstHijos() {
		return lstHijos;
	}

	public void setLstHijos(List<Familia> lstHijos) {
		this.lstHijos = lstHijos;
	}

	public Retorno getMotivoRetorno() {
		return motivoRetorno;
	}

	public void setMotivoRetorno(Retorno motivoRetorno) {
		this.motivoRetorno = motivoRetorno;
	}

	public List<Retorno> getLstMotivos() {
		return lstMotivos;
	}

	public void setLstMotivos(List<Retorno> lstMotivos) {
		this.lstMotivos = lstMotivos;
	}

	public List<Rango> getLstMonto() {
		return lstMonto;
	}

	public void setLstMonto(List<Rango> lstMonto) {
		this.lstMonto = lstMonto;
	}

	public List<Rango> getLstTiempoDesem() {
		return lstTiempoDesem;
	}

	public void setLstTiempoDesem(List<Rango> lstTiempoDesem) {
		this.lstTiempoDesem = lstTiempoDesem;
	}

	public Retorno getMotivo() {
		return motivo;
	}

	public void setMotivo(Retorno motivo) {
		this.motivo = motivo;
	}

	public Ocupacion getOcupacion3() {
		return ocupacion3;
	}

	public void setOcupacion3(Ocupacion ocupacion3) {
		this.ocupacion3 = ocupacion3;
	}

	public Ocupacion getOcupacion4() {
		return ocupacion4;
	}

	public void setOcupacion4(Ocupacion ocupacion4) {
		this.ocupacion4 = ocupacion4;
	}

	public Integer getNlenthNumdoc() {
		return nlenthNumdoc;
	}

	public void setNlenthNumdoc(Integer nlenthNumdoc) {
		this.nlenthNumdoc = nlenthNumdoc;
	}

	public String getTxtInsertarPersona() {
		return txtInsertarPersona;
	}

	public void setTxtInsertarPersona(String txtInsertarPersona) {
		this.txtInsertarPersona = txtInsertarPersona;
	}

	public boolean isBlnInsertarPersona() {
		return blnInsertarPersona;
	}

	public void setBlnInsertarPersona(boolean blnInsertarPersona) {
		this.blnInsertarPersona = blnInsertarPersona;
	}

	public boolean isBlnBuscoPersona() {
		return blnBuscoPersona;
	}

	public void setBlnBuscoPersona(boolean blnBuscoPersona) {
		this.blnBuscoPersona = blnBuscoPersona;
	}

	public boolean isBlnActualizaPersona() {
		return blnActualizaPersona;
	}

	public void setBlnActualizaPersona(boolean blnActualizaPersona) {
		this.blnActualizaPersona = blnActualizaPersona;
	}
	
	
	

}
