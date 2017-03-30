package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.util.StringUtils;

import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.MarcacionDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonalDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.TurnoDiaDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipojus;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipomarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodia;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTurnopersonalrrhh;
import pe.gob.sunafil.gestionpersonal.utils.FacesUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import pe.gob.sunafil.gestionpersonal.txt.*;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@ManagedBean(name="marcacionBean")
@SessionScoped
public class MarcacionBean  implements Serializable {
	
	private static final long serialVersionUID = -2255841932878027343L;

	private static Logger logger = Logger.getLogger(MarcacionBean.class.getName());
	
	private PersonalDespatch personalDespatch= new PersonalDespatch();
	
	//De DAT a EXCEL
	private UploadedFile fileTxt;
	private Boolean uploadedTxt;
	private Boolean convertedTxt;
	private StreamedContent fileDownloadTxt;
	private Date fCargaI=new Date();
	private Date fCargaF=new Date();
	
	//personal marcacion
	private VstPersonalrrhh filtro = new VstPersonalrrhh();
	private List<SitbTdocide> listaTipoDoc;
	private String txt1;
	private ArrayList<PrtbcPersonal>  personalAutocomplete;
	private List<TdtbcDependencia> dependenciasAutocomplete;
	private TdtbcDependencia dependenciaSeleccionada;
	private PrtbcPersonal personalSeleccionado;
	private String selectedIntendencia;
	private List <TdtbcIntendencia> listaIntendencia;	
	private Date fMarcacionI=new Date();
	private Date fMarcacionF=new Date();
	private List<VstMarcacionrrhh> listaMarcaciones;		
	private List<RhtbcTipomarcacion> listaTipoMarcacion;
	private List<RhtbcTipojus> listaTipoJustificacion;
	private RhmvcMarcacion justificacion = new RhmvcMarcacion();
	private RhmvcMarcacion justificacionEliminar = new RhmvcMarcacion();
	private VstMarcacionrrhh justificacionVer = new VstMarcacionrrhh();
	
	
	//justificacion
	private VstPersonalrrhh filtroJustificacion = new VstPersonalrrhh();
	private List<VstPersonalrrhh> listaPersonal;
	private VstPersonalrrhh personal;
	private boolean option;
	private String tipoTardanza;
	RhtbcTurnodia  turnodia = new RhtbcTurnodia();
	String  descripcionTurno = "";
	private boolean chkBloque=false;
	private Date fechaFin;
	///INICIO METODOS GET AND SET
	public ArrayList<PrtbcPersonal> getPersonalAutocomplete() {
		return personalAutocomplete;
	}

	public boolean isChkBloque() {
		return chkBloque;
	}

	public void setChkBloque(boolean chkBloque) {
		this.chkBloque = chkBloque;
	}

	public void setPersonalAutocomplete(
			ArrayList<PrtbcPersonal> personalAutocomplete) {
		this.personalAutocomplete = personalAutocomplete;
	}

	public VstMarcacionrrhh getJustificacionVer() {
		return justificacionVer;
	}

	public void setJustificacionVer(VstMarcacionrrhh justificacionVer) {
		this.justificacionVer = justificacionVer;
	}

	public RhmvcMarcacion getJustificacionEliminar() {
		return justificacionEliminar;
	}

	public void setJustificacionEliminar(RhmvcMarcacion justificacionEliminar) {
		this.justificacionEliminar = justificacionEliminar;
	}

	public List<RhtbcTipojus> getListaTipoJustificacion() {
		MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
		try {
			listaTipoJustificacion = marcacionDespatch.getTipoJustificacion();
		} catch (Exception e) {
			listaTipoJustificacion = null;
			e.printStackTrace();
		}
		return listaTipoJustificacion;
	}

	public void setListaTipoJustificacion(List<RhtbcTipojus> listaTipoJustificacion) {
		this.listaTipoJustificacion = listaTipoJustificacion;
	}

	public RhmvcMarcacion getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(RhmvcMarcacion justificacion) {
		this.justificacion = justificacion;
	}

	public void setListaTipoMarcacion(List<RhtbcTipomarcacion> listaTipoMarcacion) {
		this.listaTipoMarcacion = listaTipoMarcacion;
	}

	public List<VstMarcacionrrhh> getListaMarcaciones() {
		return listaMarcaciones;
	}

	public void setListaMarcaciones(List<VstMarcacionrrhh> listaMarcaciones) {
		this.listaMarcaciones = listaMarcaciones;
	}

	public Date getfMarcacionI() {
		return fMarcacionI;
	}

	public void setfMarcacionI(Date fMarcacionI) {
		this.fMarcacionI = fMarcacionI;
	}

	public Date getfMarcacionF() {
		return fMarcacionF;
	}

	public void setfMarcacionF(Date fMarcacionF) {
		this.fMarcacionF = fMarcacionF;
	}

	public List<SitbTdocide> getListaTipoDoc() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaTipoDoc = personalDespatch.getTipoDocRemitente();
		} catch (Exception e) {
			listaTipoDoc = null;
			e.printStackTrace();
		}
		return listaTipoDoc;
	}

	public void setListaTipoDoc(List<SitbTdocide> listaTipoDoc) {
		this.listaTipoDoc = listaTipoDoc;
	}

	public VstPersonalrrhh getFiltro() {
		return filtro;
	}

	public void setFiltro(VstPersonalrrhh filtro) {
		this.filtro = filtro;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public List<TdtbcDependencia> getDependenciasAutocomplete() {
		return dependenciasAutocomplete;
	}

	public void setDependenciasAutocomplete(
			List<TdtbcDependencia> dependenciasAutocomplete) {
		this.dependenciasAutocomplete = dependenciasAutocomplete;
	}

	public TdtbcDependencia getDependenciaSeleccionada() {
		return dependenciaSeleccionada;
	}

	public void setDependenciaSeleccionada(TdtbcDependencia dependenciaSeleccionada) {
		this.dependenciaSeleccionada = dependenciaSeleccionada;
	}

	public String getSelectedIntendencia() {
		return selectedIntendencia;
	}

	public void setSelectedIntendencia(String selectedIntendencia) {
		this.selectedIntendencia = selectedIntendencia;
	}

	public List<TdtbcIntendencia> getListaIntendencia() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaIntendencia=personalDespatch.getIntendencia(PGP_Usuario.getN_numint());
		} catch (Exception e) {
			listaIntendencia=null;
			e.printStackTrace();
		}
		return listaIntendencia;
	}

	public void setListaIntendencia(List<TdtbcIntendencia> listaIntendencia) {
		this.listaIntendencia = listaIntendencia;
	}

	public Date getfCargaI() {
		return fCargaI;
	}

	public void setfCargaI(Date fCargaI) {
		this.fCargaI = fCargaI;
	}

	public Date getfCargaF() {
		return fCargaF;
	}

	public void setfCargaF(Date fCargaF) {
		this.fCargaF = fCargaF;
	}

	public Boolean getUploadedTxt() {
		return uploadedTxt;
	}

	public void setUploadedTxt(Boolean uploadedTxt) {
		this.uploadedTxt = uploadedTxt;
	}

	public Boolean getConvertedTxt() {
		return convertedTxt;
	}

	public void setConvertedTxt(Boolean convertedTxt) {
		this.convertedTxt = convertedTxt;
	}	
	
	public UploadedFile getFileTxt() {
		return fileTxt;
	}

	public void setFileTxt(UploadedFile fileTxt) {
		this.fileTxt = fileTxt;
	}	

	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;
	
	/**
	 * Constructor
	 */
	public MarcacionBean() {
		
	}		

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}	
    
    public StreamedContent getFileDownloadTxt() {
    	exportTxt();
        return fileDownloadTxt;
    }        
    

	public String getTipoTardanza() {
		return tipoTardanza;
	}

	public void setTipoTardanza(String tipoTardanza) {
		this.tipoTardanza = tipoTardanza;
	}
	
	public PrtbcPersonal getPersonalSeleccionado() {
		return personalSeleccionado;
	}

	public void setPersonalSeleccionado(PrtbcPersonal personalSeleccionado) {
		this.personalSeleccionado = personalSeleccionado;
	}

	public VstPersonalrrhh getFiltroJustificacion() {
		return filtroJustificacion;
	}

	public void setFiltroJustificacion(VstPersonalrrhh filtroJustificacion) {
		this.filtroJustificacion = filtroJustificacion;
	}

	public List<VstPersonalrrhh> getListaPersonal() {
		return listaPersonal;
	}

	public void setListaPersonal(List<VstPersonalrrhh> listaPersonal) {
		this.listaPersonal = listaPersonal;
	}

	public boolean isOption() {
		return option;
	}

	public void setOption(boolean option) {
		this.option = option;
	}

	public VstPersonalrrhh getPersonal() {
		return personal;
	}

	public void setPersonal(VstPersonalrrhh personal) {
		this.personal = personal;
	}
	///FIN METODOS GET AND SET
	
    public void resetTxt()
    {
    	setUploadedTxt(false);
    	setConvertedTxt(false);
    }        
    
    public void convertTxt()
    {
    	System.out.println("begin validator");
        tramaConverterTxt converter = new tramaConverterTxt();
        try {
        	tramaConverterTxt.setCurDate(personalDespatch.currentDate());
        	tramaConverterTxt.setInitDate(fCargaI);
        	tramaConverterTxt.setEndDate(fCargaF);
        	tramaConverterTxt.setUsuarioRegistro(PGP_Usuario.getV_codusu());
        	tramaConverterTxt.setHostRegistro(FacesUtils.getIpAddress());
			System.out.println("fecha actual para conversor ::: "+tramaConverterTxt.getCurDate());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();			
			tramaConverterTxt.setCurDate(new Date().toLocaleString());
		}
        converter.Process();
        //System.out.println(validator.getErrorLog());
        Funciones.mostrarMensajeInfo("El proceso de carga fue ejecutado.");
        //FacesMessage message = new FacesMessage("", "Archivo convertido a EXCEL satisfactoriamente.");
        //FacesContext.getCurrentInstance().addMessage(null, message);        
        System.out.println("end validator");
        setConvertedTxt(true);
    }        
    
    public void exportTxt()
    {
    	//InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/txt/temporal_TramaBN_libros.txt");
    	InputStream stream;
		try {
			String rutaXls=Funciones.ObtProp_Resources("ruta.xls");
			stream = new FileInputStream(rutaXls+"/workbookOut.xlsx");
			//stream = new FileInputStream("D://Willy//fileconverter//code//EPS Exclusions//RewriteBN//workbookOut.xlsx");
			fileDownloadTxt = new DefaultStreamedContent(stream, "application/vnd.ms-excel", "xls_rrhh"+personalDespatch.currentDate().replace("/", "-")+".xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
    }
    
    public void uploadTxt() {    
    	if(fCargaI!=null){}
    	else
    	{
    		Funciones.mostrarMensajeError("Ingrese Fecha de inicio");
    	}
    	if(fCargaF!=null){}
    	else
    	{
    		Funciones.mostrarMensajeError("Ingrese Fecha de fin");
    	}
    	if(fCargaI.after(fCargaF))
    	{
    		Funciones.mostrarMensajeError("La fecha de inicio debe ser menor o igual a la fecha de fin");
    	}
        if(fileTxt != null) {        	
        	//if(!fileTxt.getFileName().toUpperCase().contains(".TXT") && !fileTxt.getFileName().toUpperCase().contains(".PAGOS"))
        	if(!fileTxt.getFileName().toUpperCase().contains(".DAT"))
        	{
        		Funciones.mostrarMensajeError("Debe seleccionar un archivo texto con extensión DAT.");
        		//FacesMessage message = new FacesMessage("", "Debe seleccionar un archivo texto con extensión DAT.");
	            //FacesContext.getCurrentInstance().addMessage(null, message);
	            return;
        	}        	
        	
        	System.out.println("begin upload");
            //FacesMessage message = new FacesMessage("", fileTxt.getFileName() + " fue subido.");
            //String messageString=fileTxt.getFileName() + " fue subido.";
            //FacesContext.getCurrentInstance().addMessage(null, message);
            InputStream in;
			try {
				in = fileTxt.getInputstream();
				String rutaXls=Funciones.ObtProp_Resources("ruta.xls");
				File file = new File(rutaXls+"/temporal.txt");
				//File file = new File("D://Willy//fileconverter//code//EPS Exclusions//RewriteBN//temporal.txt");
				OutputStream out = new FileOutputStream(file);
		        byte[] buf = new byte[1024];
		        int len;
		        while((len=in.read(buf))>0){
		            out.write(buf,0,len);
		        }
		        out.close();
		        in.close();
		        System.out.println("end upload");
		        
		        System.out.println("begin validator");
		        tramaValidatorTxt validator = new tramaValidatorTxt();        
		        tramaValidatorTxt.setInitDate(fCargaI);
		        tramaValidatorTxt.setEndDate(fCargaF);
		        validator.Process();
		        System.out.println(validator.getErrorLog());
		        if(tramaValidatorTxt.isHayError())
		        {
		        	//message = new FacesMessage("", validator.getErrorLog());		        	
			        //FacesContext.getCurrentInstance().addMessage(null, message);
		        	Funciones. mostrarMensajeError(validator.getErrorLog());
			        setUploadedTxt(false);
		        }
		        else
		        {
		        	//message = new FacesMessage("", this.fileTxt.getFileName() + " fue subido y validado de manera satisfactoria. Usted ya puede generar el archivo EXCEL.");
		        	//FacesContext.getCurrentInstance().addMessage(null, message);
		        	Funciones.mostrarMensajeInfo(this.fileTxt.getFileName() + " fue subido y validado de manera satisfactoria. Usted ya puede Cargar la Data.");
		        	setUploadedTxt(true);
		        }
		        validator.resetErrorLog();//resetea la cadena log de errores y flag hayError
		        System.out.println("end validator");		        
		        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Funciones.mostrarMensajeError(fileTxt.getFileName() + " no fue subido, contactar con el administrador.");
				//message = new FacesMessage("", fileTxt.getFileName() + " no fue subido, contactar con el administrador.");
	            //FacesContext.getCurrentInstance().addMessage(null, message);
			}
            
        }
        else
        {
        	Funciones.mostrarMensajeError("Seleccione un archivo.");
        }
    }
            
    public String verMarcacion(){
    	resetTxt();
		String vista="pretty:marcacionPretty";
        //CODIGO
        return  vista;
	}     
    
    public void itemChangeIntendencia()
	{
		if(selectedIntendencia == null || "".equals(selectedIntendencia.trim()))
		{
			txt1 = "";
			dependenciaSeleccionada = null;
		}
	}
    
    public List<String> completeText(String query) {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		dependenciasAutocomplete = new ArrayList<TdtbcDependencia>();
		try {
			dependenciasAutocomplete = personalDespatch
					.getAutocompletarDependenciaEIntendencia(query,
							selectedIntendencia);
							//PGP_Usuario.getN_numint());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> results = new ArrayList<String>();

		for (Iterator iterator = dependenciasAutocomplete.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			results.add(tdtbcDependencia.getvDesdep());
		}
		return results;
	}
    
    public List<String> completePersonal(String query) {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		personalAutocomplete = new ArrayList<PrtbcPersonal>();
		try {
			personalAutocomplete = (ArrayList<PrtbcPersonal>) personalDespatch.getAutoCompletarPersonal(query);
							//PGP_Usuario.getN_numint());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> results = new ArrayList<String>();

		for (Iterator iterator = personalAutocomplete.iterator(); iterator.hasNext();) {
			PrtbcPersonal personal = (PrtbcPersonal) iterator.next();
			results.add(personal.getvDesnombres()+" "+personal.getvDesapepat()+" "+personal.getvDesapemat());
		}
		return results;
	}
    
    public void onItemSelect(SelectEvent event) {
		for (Iterator iterator = dependenciasAutocomplete.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			if (event.getObject().toString()
					.equals(tdtbcDependencia.getvDesdep())) {
				dependenciaSeleccionada = tdtbcDependencia;
				filtro.setnNumdep(dependenciaSeleccionada.getnNumdep());
			}
		}
	}
    
    public void onItemSelectPersona(SelectEvent event) {
		for (Iterator iterator = personalAutocomplete.iterator(); iterator.hasNext();) {
			PrtbcPersonal persona = (PrtbcPersonal) iterator.next();
			if (event.getObject().toString().equals(persona.getvDesnombres()+" "+persona.getvDesapepat()+" "+persona.getvDesapemat())) {
				personalSeleccionado = persona;
				//filtro.setnNumdep(dependenciaSeleccionada.getnNumdep());
			}
		}
	}
   
    
    private int validaJustificar(boolean opcion,RhmvcMarcacion justification){
    	if(justification.getnCodtipo().equals(new Short("1")))
    	{
    		
    		if((turnodia.getnHoraini()==-1 || turnodia.getnMinutoini()==-1) ){
    			if(opcion)
    				Funciones.mostrarMensajeError("Justificacion no procede porque "+descripcionTurno+ " no marcan entrada");
    			return -1;
    		}
    			
    	}
    	if(justification.getnCodtipo().equals(new Short("2"))){
    		if((turnodia.getnHorafin()==-1 || turnodia.getnMinutofin()==-1) ){
    			if(opcion)
    				Funciones.mostrarMensajeError("Justificacion no procede porque "+descripcionTurno+ " no marcan salida");
    			return -3;
    		}
    	}
    	return 2;
    }
    
    private boolean verificarTurnoActivo(String codPersonal){
    	if(codPersonal!=null && !codPersonal.trim().equals("")){
        		MarcacionDespatch marcDes = new MarcacionDespatch();
        		try {
    				if(!marcDes.getTurnoActivoParaPersonal(codPersonal, "S")) 
    				{
    					Funciones.mostrarMensajeError("Justificacion no procede porque su turno no esta activo");
    					return false;
    				}else{
    					Funciones.imprimir("TIENE TURNO ACTIVO");
    					return true;
    				}
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
        	}
    	Funciones.mostrarMensajeError("Justificacion no procede porque no tiene codigo de personal");
    	return false;
    		
    }

    private boolean verificarDependenciaAsignada(String codPersonal){
    	if(codPersonal!=null && !codPersonal.trim().equals("")){
        		MarcacionDespatch marcDes = new MarcacionDespatch();
        		try {
    				if(!marcDes.tienePermisosParaJustificar(codPersonal, "S","S")) 
    				{
    					Funciones.mostrarMensajeError("Justificacion no procede porque su turno no esta activo");
    					return false;
    				}else{
    					Funciones.imprimir("TIENE DEPENDENCIA ASIGNADA");
    					return true;
    				}
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
        	}
    	Funciones.mostrarMensajeError("Justificacion no procede porque no tiene codigo de personal");
    	return false;
    	
    }
    
    public int justificar(boolean opcion,Short hora, Short minuto)
    {
    	int justifico=validaJustificar(opcion,justificacion);
    	if(justifico==2)
    	{
    		try {
    			if(opcion){
    				justificacion.setvCodpersonal(personal.getvCodpersonal());
    				justificacion.setnCodorigen(new Short("2"));//Justificacion
    				justificacion.setnSegundo(new Short("0"));
    			}
        		MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
        		justificacion.setnCodmarcacion(new BigDecimal(getSiguienteCorrelativoGlobalMarcacion()));    	
        		justificacion.setvMotjus(justificacion.getvMotjus().toUpperCase());
        		justificacion.setnHora(hora);
        		justificacion.setnMinuto(minuto);
        		justificacion.setdFecreg(new Date());
        		justificacion.setvCodusureg(PGP_Usuario.getV_codusu());
        		
    			marcacionDespatch.insertarMarcacion(justificacion);	    					    			
    		} catch (Exception e) {		    			
    			e.printStackTrace();
    		}
        	buscarMarcacion();
        	if(opcion){//cuando se esta justificando una marcacion tardia pero no un dia
        	//option=true;//regresa a la otra pantalla
        	buscarMarcacion();
			RequestContext.getCurrentInstance().execute("formDialogWidgetJustificar.hide()");
			Funciones.mostrarMensajeInfo("Justificación guardada.");
    		}
    	}
    	/*else
    	{
    		mostrarMensajeError("NO PUDO JUSTIFICAR");
    	}*/
    	return justifico;
    }
    
    public int insertarJustificacionDia(){
    	Short segundo=0,tipo=1;
    	int justifico=-1;
    	justificacion.setnCodtipo(tipo);
    	Funciones.imprimir("Entro justificacion Dia");
    	//mostrarMensajeInfo("JUSTIFICO ESTE DIA:"+justificoEsteDia(justificacion.getdFecha(),personalSeleccionado.getvCodpersonal())+" "+justificacion.getdFecha()+":"+personalSeleccionado.getvDesnombres());
    	if(justificoEsteDia(justificacion.getdFecha(),personal.getvCodpersonal()))
    		{
    		if(!chkBloque){
    			Funciones.mostrarMensajeError("Justificacion no procede porque ya justifico este dia");
    			}
    		return 0;
    		}
    	//mostrarMensajeInfo("LLENO MOTIVO JUSTIFICACION:"+(justificacion.getvMotjus()!=null && !justificacion.getvMotjus().trim().equals("")));
   
    	justificacion.setvCodpersonal(personal.getvCodpersonal());
    	justificacion.setnCodorigen(new Short("2"));//Justificacion
    	justificacion.setnSegundo(segundo);
    	//mostrarMensajeInfo("Tipo Justificacion:"+justificacion.getnCodtipjus());
    	justifico=justificar(false,turnodia.getnHoraini(),turnodia.getnMinutoini());
    	if(justifico==2){
			tipo=2;
			justificacion.setnCodtipo(tipo);
			justifico=justificar(false,turnodia.getnHorafin(),turnodia.getnMinutofin());
			if(justifico==2 || justifico==-3){
				//RequestContext.getCurrentInstance().execute("formDialogWidgetAgregar.hide()");
				buscarMarcacion();
				RequestContext.getCurrentInstance().execute("formDialogWidgetJustificar.hide()");
				if(!chkBloque){
				Funciones.mostrarMensajeInfo("Justificación de dia guardada.");}
			}
			if(justifico==-3 && !chkBloque){
				Funciones.mostrarMensajeInfo("Aunque no guardo justificacion de salida porque "+ descripcionTurno+" no registra marcacion de salida");
			}
			
    	}
    	return 1;
		//justificacion=null;
    }
    
    public String verJustificacion(){
    	limpiar();
		String vista="pretty:personalMarcacionPretty";
        //CODIGO
        return  vista;
	}
    
    
    
    public boolean validaBuscar(VstPersonalrrhh filtro)
    {
    	if (((filtro.getvCodtipodocid() == null || "".equals(filtro.getvCodtipodocid().trim())) && (filtro.getvCodpersonal()==null || "".equals(filtro.getvCodpersonal().trim())))
				&& (selectedIntendencia == null || "".equals(selectedIntendencia.trim()))
				&& (filtro.getnNumdep() == null)
				&& (fMarcacionI == null || fMarcacionF == null)
				&& (filtro.getvCodtipo()==null)
				/*&& (filtro.get)*/) {
    		listaMarcaciones = null;
    		Funciones.mostrarMensajeError("Debe ingresar o seleccionar al menos un criterio de búsqueda.");
			return false;
		}
    	if(!FuncionesFechas.validaFecha(fMarcacionI,fMarcacionF)){return false;}
    	if(Funciones.documentoNoValido(filtro.getvCodtipodocid(), filtro.getvCodpersonal())){return false;}
    	return true;
    }
    
    public void buscarMarcacion()
    {
    	if (txt1 != null && !"".equals(txt1)) {
		} else {
			filtro.setnNumdep(null);
		}
    	if(!validaBuscar(filtro)){}
    	else
    	{
    		MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
    		try {			
    			if(selectedIntendencia != null && !"".equals(selectedIntendencia.trim()))
    			{
    				filtro.setnNumint(new BigDecimal(selectedIntendencia));
    			}
    			listaMarcaciones = marcacionDespatch.getMarcaciones(filtro, fMarcacionI, fMarcacionF);
    		} catch (Exception e) {
    			listaMarcaciones = null;
    			e.printStackTrace();
    		}
    	}
    }
    
    public boolean validaBuscarPopUp(VstPersonalrrhh filtro)
    {    	
    	if (((filtro.getvCodtipodocid() == null || "".equals(filtro.getvCodtipodocid().trim())) && (filtro.getvCodpersonal()==null || "".equals(filtro.getvCodpersonal().trim())))
				&& ((filtro.getvDesapepat() == null || "".equals(filtro.getvDesapepat().trim())) && (filtro.getvDesapemat() == null || "".equals(filtro.getvDesapemat().trim())) && (filtro.getvDesnombres() == null || "".equals(filtro.getvDesnombres().trim()))))
				 {
    		listaPersonal = null;
    		Funciones.mostrarMensajeError("Debe ingresar o seleccionar al menos un criterio de búsqueda.");
			return false;
		}    	
    	if(Funciones.documentoNoValido(filtro.getvCodtipodocid(), filtro.getvCodpersonal())){return false;}
    	return true;
    }
    
    public void buscarPersonal(){
    	
    	if(!validaBuscarPopUp(filtroJustificacion)){}
    	else
    	{
    		Funciones.imprimir("TURNOS DEL PERSONAL");
    		mostrarTurnos(filtroJustificacion.getvCodpersonal());
    		PersonalDespatch personalDespatch = new PersonalDespatch();
    		try {			
    			
    			setListaPersonal(personalDespatch.getPersonalRRHH(filtroJustificacion));
    		} catch (Exception e) {
    			setListaPersonal(null);
    			e.printStackTrace();
    		}
    	}
    }
    
    public void seleccionarParaJustificar(VstPersonalrrhh item){
    	//if()
    	option=false;
    	personal= new VstPersonalrrhh();
    	personal=item;
    }
    
    public void limpiar()
    {
    	fMarcacionI=new Date();
    	fMarcacionF=new Date();
    	selectedIntendencia="";
		txt1 = "";
		dependenciaSeleccionada = null;
    	filtro=new VstPersonalrrhh();    
    	listaMarcaciones=null;
    }
  
    public void selectVer(VstMarcacionrrhh item)
    {    	
    	justificacionVer=item;
    	RequestContext.getCurrentInstance().execute("dialogWidgetDetalleV.show()");
    }
    
    private boolean justificoEsteDia(Date fecha,String codPersonal){
    	if(codPersonal!=null && !codPersonal.trim().equals("") && fecha!=null){
    		MarcacionDespatch marcDes = new MarcacionDespatch();
    		try {
				if(marcDes.marcoEseDia(fecha, codPersonal)) return true;//El empleado vino ese dia y marco
				else return false;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return false;
    }
    
    public boolean validaParametros(RhmvcMarcacion justification)
    {
    	if(tipoTardanza!=null &&  !"".equals(tipoTardanza) || chkBloque==true){}
    	else
    	{
    		Funciones.mostrarMensajeError("Seleccione un tipo de marcación.");
    		return false;
    	}
    	if(justification.getdFecha()!=null){
        	/*if(justification.getdFecha().after(new Date()))
        	{
        		Funciones.mostrarMensajeError("No puede ingresar Fechas Futuras.");
        		return false;
        	}*/
    	}
    	else
    	{
    		Funciones.mostrarMensajeError("Debe ingresar una fecha.");
    		return false;
    	}
    	if(justification.getnCodtipo()!=null){}
    	else
    	{
    		Funciones.mostrarMensajeError("Debe seleccionar un tipo.");
    		return false;
    	}
    	if(justification.getnCodtipjus()!=null && !justification.getnCodtipjus().toString().equals("0")){}
    	else
    	{
    		Funciones.mostrarMensajeError("Debe seleccionar un tipo de justificación.");
    		return false;
    	}
    	if(justification.getvMotjus() != null && !"".equals(justification.getvMotjus().trim())){}
    	else
    	{
    		Funciones.mostrarMensajeError("Debe ingresar un motivo.");
    		return false;
    	}
    	
    	return true;
    }

    
    public String getSiguienteCorrelativoGlobalMarcacion()
	{
		MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
		try {
			RhmvcMarcacion correlativo=marcacionDespatch.getCorrelativoGlobalMarcacion();
			if(correlativo!=null)
			{
				return ""+(Long.parseLong(""+correlativo.getnCodmarcacion())+1);
			}
			else
			{
				//devuelve correlativo en 1				
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
    
    public void dialogReferenciaEliminar(VstMarcacionrrhh item)
    {
    	justificacionEliminar=new RhmvcMarcacion();
    	justificacionEliminar.setnCodmarcacion(item.getnCodmarcacion());
    	justificacionEliminar.setdFecha(item.getdFecha());
    	RequestContext.getCurrentInstance().execute("dialogWidget3.show()");    	
    }
    
    private Short codTurnoDIA(Date fecha){
    	String fechaDes=fecha.toString().substring(0,3);
    	if(fechaDes.equals("Mon"))
    		return new Short("1");
    	if(fechaDes.equals("Tue"))
    		return new Short("2");
    	if(fechaDes.equals("Wed"))
        	return new Short("3");
    	if(fechaDes.equals("Thu"))
    		return new Short("4");
    	if(fechaDes.equals("Fri"))
    		return new Short("5");
    	if(fechaDes.equals("Sat"))
    		return new Short("6");
    	return new Short("0");
    }
    
    public void selectEditar(VstMarcacionrrhh item)
    {
    	justificacion.setvCodpersonal(item.getvCodpersonal());
    	justificacion.setnCodorigen(new Short("2"));//Justificacion
    	justificacion.setnCodtipo(item.getnCodtipo());
    	justificacion.setdFecha(item.getdFecha());    	
    	justificacion.setnHora(item.getnHora());
    	justificacion.setnMinuto(item.getnMinuto());
    	justificacion.setnSegundo(item.getnSegundo());
    	justificacion.setnCodtipjus(null);
    	justificacion.setvMotjus("");
    	RequestContext.getCurrentInstance().execute("dialogWidgetDetalleE.show()");
    }
    
    public void desplegarOpcionJNM(VstMarcacionrrhh item){
    	justificacion.setvCodpersonal(item.getvCodpersonal());
    	justificacion.setnCodorigen(new Short("2"));//Justificacion
    	justificacion.setnCodtipo(item.getnCodtipo());
    	justificacion.setdFecha(item.getdFecha());    	
    	justificacion.setnHora(item.getnHora());
    	justificacion.setnMinuto(item.getnMinuto());
    	justificacion.setnSegundo(item.getnSegundo());
    	justificacion.setnCodtipjus(null);
    	justificacion.setvMotjus("");
    	RequestContext.getCurrentInstance().execute("dialogWidgetDetalleE.show()");
    }
 
    public List<RhtbcTipomarcacion> getListaTipoMarcacion() {
		MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
		try {
			listaTipoMarcacion = marcacionDespatch.getTipoMarcacion();
		} catch (Exception e) {
			listaTipoMarcacion = null;
			e.printStackTrace();
		}
		return listaTipoMarcacion;
	}
//<p:commandButton icon="ui-icon-circle-plus" update=":formAgregarJustificacion" action="#{marcacionBean.desplegarOpcionJustificacion}" 
//	title="JUSTIFICAR UNA FALTA DE MARCACION" style="float: right; clear: both;" />
    /*CASO 1 TODO BIEN NO NECESITA ENTRAR     solucionado
     *CASO 2 MARCO TARDE ENTRADA MARCO NORMAL SALIDA  no deberia mostrar la opcion de justificar en salida
     *CASO 3 MARCO NORMAL ENTRADA MARCO ANTES DE TIEMPO SALIDA no deberia mostrar la opcion de justificar en entrada
     *CASO 4 NO MARCO ENTRADA MARCO NORMAL SALIDA deberia aparecer opcion de justificar entrada
     *CASO 5 MARCO NORMAL ENTRADA NO MARCO SALIDA deberia aparecer opcion de justificar salida
     *CASO 6 NO MARCO NINGUNA FALTO UN DIA*/ /** Solucionado*/
  /*  <p:commandButton icon="ui-icon-caret-2-e-w" update=":formJustificarNoMarcacion" title="JUSTIFICAR NO MARCACION" action="#{marcacionBean.desplegarOpcionJNM(item)}" 
        	rendered="#{marcacionBean.marcacionSiguienteExiste(item.vCodpersonal,item.dFecha,item.vDestipo,item.nCodorigen)==false}" immediate="true" />
        	*/
    public boolean marcacionSiguienteExiste(String vCodpersonal,Date dFecha,String vDestipo,Short nCodorigen){
    	if(nCodorigen==1){
    		MarcacionDespatch marcacionDespatch= new MarcacionDespatch();
    		try{
    			if(vDestipo.equals("ENTRADA"))
    				return marcacionDespatch.existeMarcacion(vCodpersonal, dFecha, "SALIDA");
    			else
    				return marcacionDespatch.existeMarcacion(vCodpersonal, dFecha, "ENTRADA");
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	return false;
    }
    //INDICA SI HA LLEGADO TARDE PERMITIRIA DESACTIVAR JUSTIFICACION EN CASO DE HABER LLEGADO TEMPRANO marcacionBean.marcacionFueraDeTiempo(item.vCodpersonal,item.nHora,item.nMinuto,item.dFecha,item.vDestipo,item.nCodorigen)==true 
   public boolean marcacionFueraDeTiempo(String codPersonal,Short hora,Short minutos,Date fecha,String tipoMarcacion,Short nCodorigen){
	   if(nCodorigen==1){
	   PersonalDespatch personalDespatch = new PersonalDespatch();
    	try {
			List<VstTurnopersonalrrhh> personalTurno= personalDespatch.getTurnoPersonal(codPersonal);//tengo codturno
			for(VstTurnopersonalrrhh pt :personalTurno){//conseguir el turno empieza buscando en la tabla vstTurnopersonalrrhh esta tiene 
				TurnoDiaDespatch turnoDiaDespatch= new TurnoDiaDespatch();
				if(turnoDiaDespatch.getTieneTurnoDia(pt.getnCodturno(), codTurnoDIA(fecha)))
				{
					RhtbcTurnodia turnoDiaActual=turnoDiaDespatch.getTurnoDia(pt.getnCodturno(), codTurnoDIA(fecha));	
					if(tipoMarcacion.equals("ENTRADA")){
						double horaLlegadaEsperada=turnoDiaActual.getnHoraini()*60+turnoDiaActual.getnMinutoini();
						double horaLlegadaPersonal= hora*60+minutos;
						if(horaLlegadaPersonal-horaLlegadaEsperada>=turnoDiaActual.getnTolerancia()){
							return true;//marco tarde Entrada}
						}
							
					}else
					{
						double horaSalidaEsperada=turnoDiaActual.getnHorafin()*60+turnoDiaActual.getnMinutofin();
						double horaSalidaPersonal= hora*60+minutos;
						if(horaSalidaEsperada-horaSalidaPersonal>=turnoDiaActual.getnTolerancia())
							return true;//marco antes de tiempo Salida
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	return false;//marcacion a tiempo
    }
  
   private boolean personalMarca(String flag){
	   if(!flag.equals("S")){
			   Funciones.mostrarMensajeError("No puede justificar porque personal no marca");
			   return false;
	   }
	   else {
		   return true;
		   }
   }
   
   private boolean trabajaEsteDia(Short codTurno,String desDia,Date fecha){
	   
		   TurnoDiaDespatch turnoDiaDespatch= new TurnoDiaDespatch();
		   try {
			   turnodia= turnoDiaDespatch.getTurnoDia(codTurno, codTurnoDIA(fecha));
			   if(turnodia!=null){
				   descripcionTurno= desDia;
				   return true;
			   }

		   } catch (Exception e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		   if(!chkBloque){
		   Funciones.mostrarMensajeError("El personal no asiste los "+DIA(fecha));
		   }
		   return false;
	   
   }
   
   private VstTurnopersonalrrhh seEncuentraTrabajando(String codPersonal,Date fecha){
	   
	   List<VstTurnopersonalrrhh> turnosPersonal=capturarTurnos(codPersonal);//Se capturan sus turnos
	   String mensajeError="";
	   VstTurnopersonalrrhh turno=new VstTurnopersonalrrhh();
	   
	   Funciones.imprimir("Cantidad de TURNOS:"+turnosPersonal.size());
	   for(int i=0;i<turnosPersonal.size();i++){//Se busca en cada turno
		   turno=turnosPersonal.get(i);
		   //se busca si turno contiene fecha
		  if(turno.getdFecinicio().before(fecha) || turno.getdFecinicio().equals(fecha) ){
			  Funciones.imprimir("MARCA:"+turno.getvFlgnomarca());
			  
				  if(turno.getdFecfin()!=null){
					  if(turno.getdFecfin().after(fecha) || turno.getdFecfin().equals(fecha)){
						  Funciones.imprimir("Se encuentra trabajando");
						  return turno;
					  }else{
						  mensajeError="Fecha no valida por que el empleado ya habia dejado de trabajar";
					
					  }
				  }
				  else
				  {//No esta llenado el fin de su contrato
					 Funciones.imprimir("No tiene fecha de fin");
					 return turno;
				  }
		  }
		  if(turno.getdFecinicio().after(fecha) ){
			  mensajeError="Fecha no valida por que el empleado aun no se encontraba trabajando";
		  }
	   }
		  
	   Funciones.mostrarMensajeError(mensajeError);
	   return null;
	   }
	  
	
   
   private String DIA(Date fecha){
	   String fechaDes=fecha.toString().substring(0,3);
	   if(fechaDes.equals("Mon"))
   		return "LUNES";
	   if(fechaDes.equals("Tue"))
   		return "MARTES";
   		if(fechaDes.equals("Wed"))
       		return "MIERCOLES";
   		if(fechaDes.equals("Thu"))
   		return "JUEVES";
   		if(fechaDes.equals("Fri"))
   			return "VIERNES";
   		if(fechaDes.equals("Sat"))
   			return "SABADOS";
   		return "DOMINGOS";
   		
   }
   private void mostrarTurnos(String codPersonal){
	   PersonalDespatch personalDespatch = new PersonalDespatch();
	   List<VstTurnopersonalrrhh> personalTurno= null;
   	try {
   		personalTurno= personalDespatch.getTurnoPersonal(codPersonal);//tengo codturno
   		for(VstTurnopersonalrrhh turno:personalTurno){
   			Funciones.imprimir("Turno:"+turno.getvDesturno());
   		}
   	}catch(Exception x){
   		
   	}
   }
   
   private List<VstTurnopersonalrrhh> capturarTurnos(String codPersonal/*,Date fecha*/){
	   PersonalDespatch personalDespatch = new PersonalDespatch();
	   List<VstTurnopersonalrrhh> personalTurno= null;
   	try {
   		personalTurno= personalDespatch.getTurnoPersonal(codPersonal/*,fecha*/);//tengo codturno
   		}catch(Exception x){
   			Funciones.mostrarMensajeError("No tiene turno asignado");
   		}
   	return personalTurno;
   }
   
    public void eliminarJustificacion()
    {		
		MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
		try {					
			//eliminar detalle	
			marcacionDespatch.eliminarJustificacion(justificacionEliminar);
			//post load
			buscarMarcacion();
			Funciones.mostrarMensajeInfo("Justificación fue eliminada.");			
		} catch (Exception e) {
			buscarMarcacion();
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");			
		}
    }
    
    public void desplegarOpcionAgregar(){
    	justificacion=new RhmvcMarcacion();
    	justificacion.setvMotjus("");
    	RequestContext.getCurrentInstance().execute("formDialogWidgetAgregarJD.show()");
    }
    
    public void desplegarOpcionJustificar(){
    	justificacion=new RhmvcMarcacion();
    	justificacion.setvMotjus("");
    	setListaPersonal(null);
    	filtroJustificacion=new VstPersonalrrhh();
    	personal=new VstPersonalrrhh();
    	tipoTardanza=null;
    	option=true;
    	chkBloque=false;
    	RequestContext.getCurrentInstance().execute("formDialogWidgetJustificar.show()");
    }
    
    public String completarDosDigitos(Short base)
    {
    	return Funciones.completarCon(""+base,2,"0",0);
    }
    
    public void justificarNDias(VstTurnopersonalrrhh turno,int diasJustificados){
    	int diasSinJustificar=diasJustificados;
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(justificacion.getdFecha());
    	for(int i=0;i<diasJustificados;i++){
    		justificacion.setdFecha(calendar.getTime());
    		calendar.add(Calendar.DAY_OF_YEAR, 1); 
    		Funciones.imprimir("Fecha de Justificacion:"+justificacion.getdFecha());
    		if(trabajaEsteDia(turno.getnCodturno(),turno.getvDesturno(),justificacion.getdFecha())){
    			diasSinJustificar-=insertarJustificacionDia();
    		}else{
    			
    		}
    		
    	}
    	if(diasSinJustificar<diasJustificados){
    		Funciones.mostrarMensajeInfo("Justificacion Por Bloque Exitosa");
    	}else{
    		Funciones.mostrarMensajeError("Ningun Dia es valido para Justificar");
    	}
    	
    }
    
    private void justificarPorBloque(VstTurnopersonalrrhh turno){
    	if(FuncionesFechas.validaFecha(justificacion.getdFecha(), fechaFin)){
    		Funciones.imprimir("Fecha Inicio:"+justificacion.getdFecha() + "  Fecha Fin:"+fechaFin);
    		long diferenciaEn_ms = fechaFin.getTime() - justificacion.getdFecha().getTime();
    		long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
    		dias+=1;//
        	Funciones.imprimir("DIAS DE FALTA:"+ (int)dias);
        	justificarNDias(turno,(int)dias);
    	}
    }
    
	public void justificarPersonal(){
		Funciones.imprimir("Personal:"+personal.getvCodpersonal()+"|"+ personal.getvDesnombres());
		Funciones.imprimir("Fecha Justificacion:"+justificacion.getdFecha());
		justificacion.setnCodtipo((short)1);
		boolean validaParametros=validaParametros(justificacion);
		VstTurnopersonalrrhh turno =seEncuentraTrabajando(personal.getvCodpersonal(), justificacion.getdFecha());
		boolean seEncuentraTrabajando=turno!=null;
		boolean tienTurnoActivo=verificarTurnoActivo(personal.getvCodpersonal());
		boolean tieneDependenciaAsignada=verificarDependenciaAsignada(personal.getvCodpersonal());
		Funciones.imprimir("ValidaParametros:"+validaParametros);
		Funciones.imprimir("Se encuentra trabajando:"+seEncuentraTrabajando);
		Funciones.imprimir("Turno Activo:"+tienTurnoActivo);
		Funciones.imprimir("Dependencia Asignada:"+tieneDependenciaAsignada);
		
		if(validaParametros && seEncuentraTrabajando && tienTurnoActivo && tieneDependenciaAsignada)
		{
			if(personalMarca(turno.getvFlgnomarca())){
				if(tipoTardanza == null)
				{
					if(chkBloque==false){
						Funciones.mostrarMensajeError("Debe seleccionar una falta de Marcacion: Entrada- Salida- Todo el Dia");
						return;
					}
					else{
						Funciones.imprimir("ENTRO A JUSTIFICAR POR BLOQUE");
						justificarPorBloque(turno);
					}
				}
				else
				{
					if(trabajaEsteDia(turno.getnCodturno(),turno.getvDesturno(),justificacion.getdFecha())){
						if(tipoTardanza.equals("DIA")){
						
						insertarJustificacionDia();
						}
						else if(tipoTardanza.equals("ENTRADA"))
						{
							justificar(true,turnodia.getnHoraini(),turnodia.getnMinutoini());
						}
						else {
							justificacion.setnCodtipo((short)2);
							justificar(true,turnodia.getnHorafin(),turnodia.getnMinutofin());
						}
					}
				}
			}
		//option=true;		
		}
	}
	
	public void itemChangeTipoJustificacion()
	{		
		if(justificacion.getnCodtipjus() != null && !justificacion.getnCodtipjus().equals(new BigDecimal("0")))
		{
			for (Iterator iterator = listaTipoJustificacion.iterator(); iterator
					.hasNext();) {
				RhtbcTipojus tipo = (RhtbcTipojus) iterator
						.next();
				if(tipo.getnCodtipjus().equals(justificacion.getnCodtipjus()))
				{
					justificacion.setvMotjus(tipo.getvDestipjus());					
				}
			}			
		}
		else
		{
			justificacion.setvMotjus("");			
		}
	}
	
	public void checkedChangeBloque()
	{
		if(chkBloque)
		{
			//setear nulos aqui en caso de necesitarse
		}
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


}