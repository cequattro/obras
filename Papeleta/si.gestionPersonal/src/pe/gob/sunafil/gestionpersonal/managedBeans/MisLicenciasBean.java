package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.ReporteDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipojus;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.LoginDespatch;
import pe.gob.sunafil.gestionpersonal.utils.FacesUtils;

@ManagedBean(name="misLicenciasBean")
@SessionScoped
public class MisLicenciasBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MisLicenciasBean.class.getName());
	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;
	
	//dummy vars
	private List<Map> lstLicencias = new ArrayList();
	private List<Map> listaLicenciasPersonal = new ArrayList();
	private Date fRegistroI=new Date();
	private Date fRegistroF=new Date();
	
	private String observacion;
	private String selectedMotivo;
	private List<RhtbcTipojus> listaTipoJustificacion; 
	
	/*
	 * METODOS GET Y SET
	 * */	
	
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public String getSelectedMotivo() {
		return selectedMotivo;
	}

	public void setSelectedMotivo(String selectedMotivo) {
		this.selectedMotivo = selectedMotivo;
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
	
	public void itemChangeTipoJustificacion()
	{		
		if(selectedMotivo != null && !selectedMotivo.equals(new BigDecimal("0")))
		{	
			for (Iterator iterator = listaTipoJustificacion.iterator(); iterator
					.hasNext();) {
				RhtbcTipojus tipo = (RhtbcTipojus) iterator
						.next();
				
				if(selectedMotivo.equals(tipo.getnCodtipjus()+""))
				{   
					setObservacion(tipo.getvDestipjus());
					
				}
			}			
		}
		else
		{
			setObservacion("");			
		}
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public List<Map> getLstLicencias() {
		
		lstLicencias= new ArrayList();		
		HashMap mMap = new HashMap();
		mMap.put("fechaI","11/01/2017");
        mMap.put("fechaF","12/01/2017");                
        mMap.put("motivo","POR CAPACITACIÓN");
        mMap.put("estado","APROBADA");        
        lstLicencias.add(mMap);
        
        mMap = new HashMap();
        mMap.put("fechaI","13/02/2017");
        mMap.put("fechaF","15/02/2017");                
        mMap.put("motivo","DESCANSO MÉDICO");
        mMap.put("estado","PENDIENTE DE APROBACIÓN"); 
        lstLicencias.add(mMap);
		
		return lstLicencias;
	}

	public void setLstLicencias(List<Map> lstLicencias) {
		this.lstLicencias = lstLicencias;
	}
		
	public List<Map> getListaLicenciasPersonal() {
		
		listaLicenciasPersonal= new ArrayList();		
		HashMap mMap = new HashMap();
		mMap.put("nroDoc","44436285");
        mMap.put("nombre","WILLY CASTRO ALVARADO");
        mMap.put("fechaI","13/02/2017");        
        mMap.put("fechaF","15/02/2017");       
        mMap.put("motivo","DESCANSO MÉDICO");
        mMap.put("estado","PENDIENTE DE APROBACIÓN");        
        listaLicenciasPersonal.add(mMap);
		
		return listaLicenciasPersonal;
	}

	public void setListaLicenciasPersonal(List<Map> listaLicenciasPersonal) {
		this.listaLicenciasPersonal = listaLicenciasPersonal;
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
	
	public void limpiarNuevo(){}
	
	public void limpiarMPLicencias(){}

	public String verLicencias(){
		limpiar();
		String vista="pretty:misLicenciasPretty";
        //CODIGO
        return  vista;
	} 
	
	public String nuevaLicencia(){
		limpiarNuevo();
		String vista="pretty:nuevaLicenciaPretty";
        //CODIGO
        return  vista;
	}
	
	public String miPersonalLicencias(){
		limpiarMPLicencias();
		String vista="pretty:miPersonalLicenciasPretty";
        //CODIGO
        return  vista;
	}
	
	public String verLicencia(){
		String vista="pretty:verLicenciaPretty";
        //CODIGO
        return  vista;
	}
	
}
