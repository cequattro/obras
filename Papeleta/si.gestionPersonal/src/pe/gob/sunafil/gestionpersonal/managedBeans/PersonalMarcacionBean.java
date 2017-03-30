package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.MarcacionDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonalDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonalMarcacionDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcDepenrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;
import pe.gob.sunafil.gestionpersonal.bean.Permisos;

@ManagedBean(name="personalMarcacionBean")
@SessionScoped
public class PersonalMarcacionBean {

	private static final long serialVersionUID = 2L;

	private static Logger logger = Logger.getLogger(PersonalMarcacionBean.class.getName());
	
	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;
	@ManagedProperty("#{loginBean.PGP_Permisos}")
	private Permisos PGP_Permisos;
	private List<SitbTdocide> listaTipoDoc;
	private Date fMarcacionI=new Date();
	private Date fMarcacionF=new Date();
	private String justificacionVerTipo;
	private String justificacionVerMotivo;
	private VstPersonalrrhh filtro = new VstPersonalrrhh();
	private List<VstMarcacionrrhh>listaMarcaciones;
	PersonalMarcacionDespatch personalMarcacionDespatch;
	
	private String selectedIntendencia;
	private List<TdtbcDependencia> listaDeDependencias=new ArrayList<TdtbcDependencia>();	
	private String selectedDependencia;		
	private boolean esJefeDeDependenciaLogueada=false;
	private boolean esJefeDeRecursos=false;	
	private String txt1;
	private TdtbcDependencia dependenciaSeleccionada;	
	private List<TdtbcDependencia> dependenciasAutocomplete;
	private RhtbcDepenrrhh dependenciaRRHH;
	
	
	public PersonalMarcacionBean()
	{
		//set default selected
		/*if(isEsJefeDeDependenciaLogueada() && !isEsJefeDeRecursos())
		{
			selectedDependencia=PGP_Usuario.getN_numdep();
		}*/
	}				
	
	public RhtbcDepenrrhh getDependenciaRRHH() {		
		try {
			personalMarcacionDespatch= new PersonalMarcacionDespatch();
			dependenciaRRHH=personalMarcacionDespatch.getDependenciaRRHH();
			return dependenciaRRHH;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}					
	}
	
	

	public Permisos getPGP_Permisos() {
		return PGP_Permisos;
	}

	public void setPGP_Permisos(Permisos pGP_Permisos) {
		PGP_Permisos = pGP_Permisos;
	}

	public void setDependenciaRRHH(RhtbcDepenrrhh dependenciaRRHH) {
		this.dependenciaRRHH = dependenciaRRHH;
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

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public String getSelectedIntendencia() {
		return selectedIntendencia;
	}

	public void setSelectedIntendencia(String selectedIntendencia) {
		this.selectedIntendencia = selectedIntendencia;
	}

	public boolean isEsJefeDeRecursos() {
		RhtbcDepenrrhh depRRHH=getDependenciaRRHH();
		return ((isEsJefeDeDependenciaLogueada() && Integer.parseInt(PGP_Usuario.getN_numdep())==Integer.parseInt(depRRHH.getnNumdep()+"")) || PGP_Permisos.v_desper.equals("ADMINISTRADOR"));		
	}

	public void setEsJefeDeRecursos(boolean esJefeDeRecursos) {
		this.esJefeDeRecursos = esJefeDeRecursos;
	}

	public boolean isEsJefeDeDependenciaLogueada() {
		try {
			personalMarcacionDespatch= new PersonalMarcacionDespatch();
			esJefeDeDependenciaLogueada=personalMarcacionDespatch.esJefeDeDependenciaLogueada(PGP_Usuario.getV_codpersonal(), new Short(PGP_Usuario.getN_numdep()));
			return esJefeDeDependenciaLogueada || PGP_Permisos.v_desper.equals("ADMINISTRADOR");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public void setEsJefeDeDependenciaLogueada(boolean esJefeDeDependenciaLogueada) {
		this.esJefeDeDependenciaLogueada = esJefeDeDependenciaLogueada;
	}

	public String getSelectedDependencia() {
		return selectedDependencia;
	}

	public void setSelectedDependencia(String selectedDependencia) {
		this.selectedDependencia = selectedDependencia;
	}
	
	public List<TdtbcDependencia> getListaDeDependencias() {
		
		personalMarcacionDespatch= new PersonalMarcacionDespatch();
		
		listaDeDependencias=new ArrayList<TdtbcDependencia>();
		
		try {
			TdtbcDependencia dependenciaPadre=personalMarcacionDespatch.getDependencia(new Short(PGP_Usuario.getN_numdep()));
			listaDeDependencias.add(dependenciaPadre);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		getListaDeDependenciasRec(new Short(PGP_Usuario.getN_numdep()));				
		
		return listaDeDependencias;
	}
	
	
	public void getListaDeDependenciasRec(Short numdepPadre) {
		personalMarcacionDespatch= new PersonalMarcacionDespatch();
		try {			
			List<TdtbcDependencia> listaDeDependenciasNueva = personalMarcacionDespatch.getDependenciaRecursiva(numdepPadre);
			if(listaDeDependenciasNueva!=null && !listaDeDependenciasNueva.isEmpty())
			{
				for (Iterator iterator2 = listaDeDependenciasNueva.iterator(); iterator2.hasNext();) 
				{
					TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator2.next();
					listaDeDependencias.add(tdtbcDependencia);						
					//generar hijo
					getListaDeDependenciasRec(tdtbcDependencia.getnNumdep());
				}					
			}			
		} catch (Exception e) {			
			//listaDeDependencias = new ArrayList<TdtbcDependencia>();
			e.printStackTrace();
		}		
	}

	public void setListaDeDependencias(List<TdtbcDependencia> listaDeDependencias) {
		this.listaDeDependencias = listaDeDependencias;
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

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}

	public String getJustificacionVerTipo() {
		return justificacionVerTipo;
	}

	public void setJustificacionVerTipo(String justificacionVerTipo) {
		this.justificacionVerTipo = justificacionVerTipo;
	}

	public String getJustificacionVerMotivo() {
		return justificacionVerMotivo;
	}

	public void setJustificacionVerMotivo(String justificacionVerMotivo) {
		this.justificacionVerMotivo = justificacionVerMotivo;
	}

	public VstPersonalrrhh getFiltro() {
		return filtro;
	}

	public void setFiltro(VstPersonalrrhh filtro) {
		this.filtro = filtro;
	}

	public List<VstMarcacionrrhh> getListaMarcaciones() {
		return listaMarcaciones;
	}

	public void setListaMarcaciones(List<VstMarcacionrrhh> listaMarcaciones) {
		this.listaMarcaciones = listaMarcaciones;
	}

	public void setListaTipoDoc(List<SitbTdocide> listaTipoDoc) {
		this.listaTipoDoc = listaTipoDoc;
	}
	
	public String verMarcacion(){
		 limpiar();
		 String vista="pretty:miPersonalMarcacionesPretty";
	        //CODIGO
	        return  vista;
	}
	
	public void limpiar(){
		fMarcacionI=new Date();
		fMarcacionF=new Date();
		listaMarcaciones=null;
		filtro=new VstPersonalrrhh();
		selectedIntendencia="";
		txt1="";
		dependenciaSeleccionada = null;
		selectedDependencia = null;
		//mostrarMensajeInfo("ACABA DE LIMPIAR");
	} 
	
	public void selectVerJustificacion(VstMarcacionrrhh item)
    {    	
    	justificacionVerMotivo=item.getvMotjus();
    	justificacionVerTipo=item.getvDestipjus();
    	RequestContext.getCurrentInstance().execute("dialogWidgetDetalleJustificacion.show()");
    }
	
	private boolean validaBuscarMarcacion()
    {
    	if (((filtro.getvCodtipodocid() == null || "".equals(filtro.getvCodtipodocid().trim())) && (filtro.getvCodpersonal()==null || "".equals(filtro.getvCodpersonal().trim())))
				&& (filtro.getnNumdep() == null)
				&& (fMarcacionI == null || fMarcacionF == null)
				&& (filtro.getvCodtipo()==null)) {
    		listaMarcaciones = null;
    		Funciones.mostrarMensajeError("Debe ingresar o seleccionar al menos un criterio de búsqueda.");
			return false;
		}
    	if(!FuncionesFechas.validaFecha(fMarcacionI, fMarcacionF)){return false;}
    	if(Funciones.documentoNoValido(filtro.getvCodtipodocid(),filtro.getvCodpersonal())){
    		return false;
    	}
    	if(isEsJefeDeDependenciaLogueada() && !isEsJefeDeRecursos())
    	{
    		if(selectedDependencia!=null && !"".equals(selectedDependencia)){}
    		else
    		{
    			Funciones.mostrarMensajeError("Debe seleccionar una dependencia.");				
				return false;
    		}
    	}
    	return true;
    }
	
	public void buscarMarcacion()
    {		
		personalMarcacionDespatch= new PersonalMarcacionDespatch();
		//Valida si es Jefe
		try {
			if(!isEsJefeDeDependenciaLogueada())
			{
				Funciones.mostrarMensajeError("Usted no tiene los permisos para usar este modulo.");
				return ;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(selectedDependencia!=null && !"".equalsIgnoreCase(selectedDependencia))
		{
			filtro.setnNumdep(new Short(selectedDependencia));
		}		
		else
		{
			filtro.setnNumdep(null);
		}
    	if(!validaBuscarMarcacion()){}
    	else
    	{
    		PersonalMarcacionDespatch personalMarcacionDespatch = new PersonalMarcacionDespatch();
    		try {		
    			listaMarcaciones = personalMarcacionDespatch.getMarcaciones(filtro, fMarcacionI, fMarcacionF);
    		} catch (Exception e) {
    			listaMarcaciones = null;
    			e.printStackTrace();
    		}
    	}
    }
	
	public String completarDosDigitos(Short base)
    {
    	return Funciones.completarCon(""+base,2,"0",0);
    }
	
	public void itemChangeIntendencia()
	{
		if(selectedIntendencia == null || "".equals(selectedIntendencia.trim()))
		{
			txt1 = "";
			dependenciaSeleccionada = null;
			selectedDependencia = null;
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
	
	public void onItemSelect(SelectEvent event) {
		for (Iterator iterator = dependenciasAutocomplete.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			if (event.getObject().toString()
					.equals(tdtbcDependencia.getvDesdep())) {
				dependenciaSeleccionada = tdtbcDependencia;
				filtro.setnNumdep(dependenciaSeleccionada.getnNumdep());
				selectedDependencia=dependenciaSeleccionada.getnNumdep()+"";
			}
		}
	}
	
	public String emularNivel(String descripcion, String nivel)
	{
		return ""+completarConTree(descripcion, descripcion.length()+Integer.parseInt(nivel), "  ", 0);
	}
	
    public String completarConTree(String base, int longitud,String charCompletar, int lado)
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
				result = ceros+"• "+base;
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
	
}
