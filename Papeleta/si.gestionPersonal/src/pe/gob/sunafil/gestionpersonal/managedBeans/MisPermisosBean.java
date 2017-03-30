package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.MarcacionDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PermisosDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonalDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.ReporteDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.TurnoDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPermisos;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvdPermisoxest;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcEstpermiso;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipojus;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDetpersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPermisos;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.LoginDespatch;
import pe.gob.sunafil.gestionpersonal.utils.FacesUtils;

@ManagedBean(name="misPermisosBean")
@SessionScoped
public class MisPermisosBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MisPermisosBean.class.getName());
	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;
	
	//LISTADO DE PERMISOS
	private List<Map> lstPermisos = new ArrayList();	
	private List<VstPermisos> listaPermisosPersonal = new ArrayList();

	private VstPermisos filtro = new VstPermisos();
	private List<RhtbcEstpermiso> listaEstadoPermiso;
		

	private List<RhtbcTipojus> listaTipoJustificacion;
	
	
	// NUEVO PERMISO
	private Date fRegistroI=new Date();
	private Date fRegistroF=new Date();
	private String codTipoJust;
	private String observacion;
	private String spinhi;
	private String spinmi;
	private String spinhf;
	private String spinmf;
	private RhmvcPermisos nuevoPermiso = new RhmvcPermisos();
	private RhmvdPermisoxest nuevoPermisoEst = new RhmvdPermisoxest();
	private String mensajeValida;
	private List<VstDetpersonalrrhh> listaDetPersonal;
	
	
	public MisPermisosBean(){
		filtro.setdFecini("01/01/2017");
		
		Date myDate = new Date();
		filtro.setdFecfin(new SimpleDateFormat("dd/MM/yyyy").format(myDate));		
	}
		
	/*
	 * METODOS GET Y SET
	 * */
	
	public List<VstPermisos> getListaPermisosPersonal() {
		return listaPermisosPersonal;
	}

	public void setListaPermisosPersonal(List<VstPermisos> listaPermisosPersonal) {
		this.listaPermisosPersonal = listaPermisosPersonal;
	}
	
	public List<RhtbcEstpermiso> getListaEstadoPermiso() {
		PermisosDespatch permisosDespatch = new PermisosDespatch();
		try {
			listaEstadoPermiso = permisosDespatch.getEstadoPermiso();
		} catch (Exception e) {
			listaEstadoPermiso = null;
			e.printStackTrace();
		}
		return listaEstadoPermiso;
	}

	public void setListaEstadoPermiso(List<RhtbcEstpermiso> listaEstadoPermiso) {
		this.listaEstadoPermiso = listaEstadoPermiso;
	}
	
	public VstPermisos getFiltro() {
		return filtro;
	}

	public void setFiltro(VstPermisos filtro) {
		this.filtro = filtro;
	}
	
	public String getCodTipoJust() {
		return codTipoJust;
	}

	public void setCodTipoJust(String codTipoJust) {
		this.codTipoJust = codTipoJust;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getSpinhi() {
		return spinhi;
	}

	public void setSpinhi(String spinhi) {
		this.spinhi = spinhi;
	}

	public String getSpinmi() {
		return spinmi;
	}

	public void setSpinmi(String spinmi) {
		this.spinmi = spinmi;
	}

	public String getSpinhf() {
		return spinhf;
	}

	public void setSpinhf(String spinhf) {
		this.spinhf = spinhf;
	}

	public String getSpinmf() {
		return spinmf;
	}

	public void setSpinmf(String spinmf) {
		this.spinmf = spinmf;
	}

	public RhmvcPermisos getNuevoPermiso() {
		return nuevoPermiso;
	}

	public void setNuevoPermiso(RhmvcPermisos nuevoPermiso) {
		this.nuevoPermiso = nuevoPermiso;
	}
	
	
	public void buscarPermisos() {
		filtro=new VstPermisos();
		
		PermisosDespatch permisosDespatch = new PermisosDespatch();
		try {			
			listaPermisosPersonal = permisosDespatch.getPermisosPersonal(filtro);
		} catch (Exception e) {
			listaPermisosPersonal = null;
			e.printStackTrace();
		}
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
	
	public String nuevo() {
		nuevoPermiso = new RhmvcPermisos();	
		setfRegistroI(null);
		setfRegistroF(null);
		setCodTipoJust("");
		setObservacion("");
		setSpinhi("");
		setSpinmi("");
		setSpinhf("");
		setSpinmf("");
		
		String vista = "pretty:nuevoPermisoPretty";
		return vista;
	}
	
	public String guardar() {
		PermisosDespatch personalDespatch = new PermisosDespatch();
		if(!validaFormulario())
		{
			Funciones.mostrarMensajeError(mensajeValida);			
			return "pretty:nuevoPermisoPretty";
		}
		
		try {
			nuevoPermiso.setnCodpermiso(new BigDecimal(getSiguienteCorrelativoGlobalPerPermiso()));
			nuevoPermiso.setdFecini(fRegistroI);
			nuevoPermiso.setdFecfin(nuevoPermiso.getdFecini());
			nuevoPermiso.setnCodtipjus(new BigDecimal(codTipoJust));
			nuevoPermiso.setnHoraini(new Short(spinhi));
			nuevoPermiso.setnMinini(new Short(spinmi));
			nuevoPermiso.setnHorfin(new Short(spinhf));
			nuevoPermiso.setnMinfin(new Short(spinmf));
			nuevoPermiso.setvMotivo(observacion);
			nuevoPermiso.setvCodpersonal(PGP_Usuario.getV_codpersonal());
			nuevoPermiso.setnCorper(getCorPer());
			nuevoPermiso.setvFlgtipper("P");
			nuevoPermiso.setnCodestper(new BigDecimal(1));
			nuevoPermiso.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoPermiso.setdFecreg(new Date());
			nuevoPermiso.setvHostreg(FacesUtils.getIpAddress());
			
			personalDespatch.insertarPermiso(nuevoPermiso);
			
			//INSERTO EN LA TABLA PERMISOXEST
			
			nuevoPermisoEst.setnCodpermiso(nuevoPermiso.getnCodpermiso());
			nuevoPermisoEst.setnCorperest(new BigDecimal(getSiguienteCorrelativoGlobalPerPermisoXEst(nuevoPermiso.getnCodpermiso())));
			nuevoPermisoEst.setnCodestper(nuevoPermiso.getnCodestper());
			nuevoPermisoEst.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoPermisoEst.setdFecregest(new Date());
			nuevoPermisoEst.setvHostreg(FacesUtils.getIpAddress());
			
			personalDespatch.insertarPermisoXEst(nuevoPermisoEst);
			
			
			
			Funciones.mostrarMensajeInfo("Nuevo permiso registrado.");		
			return "pretty:misPermisosPretty";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "pretty:misPermisosPretty";
		}
	}
	
	public BigDecimal getCorPer()
	{	
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaDetPersonal=personalDespatch.getVistaDetallePersonal(PGP_Usuario.getV_codpersonal());
		} catch (Exception e) {
			listaDetPersonal=null;
			e.printStackTrace();
		}
		//return Integer.valueOf(listaDetPersonal.get(0).getnCorper().intValue());
		return listaDetPersonal.get(0).getnCorper();
	}
	
	public String getSiguienteCorrelativoGlobalPerPermiso()
	{
		PermisosDespatch permisoDespatch=new PermisosDespatch();
		try {
			RhmvcPermisos correlativo=permisoDespatch.getCorrelativoGlobalPermiso();
			if(correlativo!=null)
			{
				return ""+(Integer.parseInt(correlativo.getnCodpermiso()+"")+1);
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
	
	public String getSiguienteCorrelativoGlobalPerPermisoXEst(BigDecimal codPer)
	{
		PermisosDespatch permisoDespatch=new PermisosDespatch();
		try {
			RhmvdPermisoxest correlativo=permisoDespatch.getCorrelativoGlobalPermisoXEst(codPer);
			if(correlativo!=null)
			{
				return ""+(Integer.parseInt(correlativo.getnCorperest()+"")+1);
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
	
	
	public boolean validaFormulario() {
		if(fRegistroI!=null && !"".equals(fRegistroI.toString().trim())){
			if(fRegistroI.before((new Date(new Date().getYear(),new Date().getMonth(),new Date().getDate()))))
			{
				mensajeValida="La fecha del permiso no puede ser menor a la fecha actual.";
				return false;
			}
		}
		else
		{
			mensajeValida="Seleccione la fecha del permiso.";
			return false;
		}
		if(codTipoJust!=null  && !"".equals(codTipoJust.trim())){}
		else
		{
			mensajeValida="Seleccione el motivo.";
			return false;
		}
		
		if(spinhi!=null && !"0".equals(spinhi.trim())){}
		else
		{
			mensajeValida="Ingrese la hora inicio.";
			return false;
		}
		
		if(spinmi!=null && !"0".equals(spinmi.trim())){}
		else
		{
			mensajeValida="Ingrese el minuto de inicio .";
			return false;
		}
		
		if(spinhf!=null && !"0".equals(spinhf.trim())){}
		else
		{
			mensajeValida="Ingrese la hora final .";
			return false;
		}
		
		if(spinmf!=null && !"0".equals(spinmf.trim())){}
		else
		{
			mensajeValida="Ingrese el minuto final .";
			return false;
		}
		
		return true;
	}
	
	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public List<Map> getLstPermisos() {
		
		lstPermisos= new ArrayList();		
		HashMap mMap = new HashMap();
		mMap.put("fecha","10/02/2017");
        mMap.put("horaI","14:00");
        mMap.put("horaF","17:30");        
        mMap.put("motivo","COMPENSACIÓN");
        mMap.put("estado","PENDIENTE DE APROBACIÓN");        
        lstPermisos.add(mMap);
        
        mMap = new HashMap();
        mMap.put("fecha","07/02/2017");
        mMap.put("horaI","14:00");
        mMap.put("horaF","17:30");        
        mMap.put("motivo","POR DOCENCIA");
        mMap.put("estado","APROBADA"); 
        lstPermisos.add(mMap);
        
        mMap = new HashMap();
        mMap.put("fecha","01/02/2017");
        mMap.put("horaI","15:30");
        mMap.put("horaF","17:30");        
        mMap.put("motivo","PARTICULAR");
        mMap.put("estado","RECHAZADA"); 
        lstPermisos.add(mMap);
		
		return lstPermisos;
	}

	public void setLstPermisos(List<Map> lstPermisos) {
		this.lstPermisos = lstPermisos;
	}		

	
	public Date getfRegistroI() {
		return fRegistroI;
	}

	public void setfRegistroI(Date fRegistroI) {
		this.fRegistroI = fRegistroI;
	}

	public Date getfRegistroF() {
		return fRegistroF;
	}

	public void setfRegistroF(Date fRegistroF) {
		this.fRegistroF = fRegistroF;
	}
	
	public void limpiar(){}
	

	public void limpiarMPPermisos(){}

	public String verPermisos(){
		limpiar();
		String vista="pretty:misPermisosPretty";
        //CODIGO
        return  vista;
	}

	public String miPersonalPermisos(){
		limpiarMPPermisos();
		String vista="pretty:miPersonalPermisosPretty";
        //CODIGO
        return  vista;
	}
	
	public String verPermiso(){
		String vista="pretty:verPermisoPretty";
        //CODIGO
        return  vista;
	}
	
	
}
