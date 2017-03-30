package pe.gob.sunafil.tramiteext.managedBeans;



import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext; 
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormView;

import org.apache.log4j.Logger;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.MenuModel;
import org.primefaces.model.StreamedContent;

import pe.gob.sunafil.tramiteext.bean.MenuHijo;
import pe.gob.sunafil.tramiteext.bean.MenuPadre;
import pe.gob.sunafil.tramiteext.bean.Permisos;
import pe.gob.sunafil.tramiteext.bean.Usuario;
import pe.gob.sunafil.tramiteext.utils.FacesUtils;


 
/***
 * 
 * @author Mario Zumaeta
 * @fecha 04/09/2013
 *
 */

@ManagedBean(name="menuBean")
@SessionScoped
public class MenuBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1336811357241296446L;
	private static Logger logger = Logger.getLogger(MenuBean.class.getName());
	
	@ManagedProperty("#{loginBean.PGP_MenuPadre}")
	private List<MenuPadre>	 PGP_MenuPadre;
	@ManagedProperty("#{loginBean.PGP_MenuHijo}")
	private List<MenuHijo>   PGP_MenuHijo;	
	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;
	@ManagedProperty("#{loginBean.PGP_Permisos}")
	private Permisos PGP_Permisos;
	
	private MenuModel menuModel;
	
	
	private String  vieneMenu;
	
	private List<Map> lstRegRef = new ArrayList(); 
	
	private String txt1;
	
	private String apellidoPat;
	
	private String apellidoMat;
	
	private String nombres;
	
	private String razonSocial;
	
	private String tipoDoc;
	
	private String tupa;
	
	private String tupaDes;
	
	private boolean mostrarReq=false;
	
	private List<Map> lstReferenciar = new ArrayList();
	
	private String docReferencia;
	
	private String nroDoc;
	
	private boolean esDNI=false;
	
	private boolean esRUC=false;
	
	private List<Map> lstRegistrados = new ArrayList();
	
	private List<Map> lstObservados = new ArrayList();
	
	private List<Map> lstNoPresentados = new ArrayList();
	
	private boolean esGrabar=false;
	
	private String tipoDoc2;
	
	private String nroDoc2;
	
	private String nroFolios;

	private String asunto;
	
	private String observaciones;
	
	private int[] reqChoice;
	
	private String hruta0;
	
	private String hruta1;
	
	private List<Map> lstTupa = new ArrayList();
	
	private boolean mostrarFieldsTupa=false;
	
	private List<Map> lstConsulta = new ArrayList();
	
	private String tipoBusqueda;
	
	private boolean formDisable=false;
	
	private List<Map> lstSeguimiento = new ArrayList();
	
	private String[] selectedCities;  
	
	private List<String> cities;
	
	private Date curDate=new Date();
	
	private String anyo="2016";
	
	private String hojaRuta="HOJA DE RUTA";
	
	private List<Map> lstCargo = new ArrayList();
	
	private List<Map> lstIni = new ArrayList();
	
	private List<Map> lstHR = new ArrayList();
	
    public List<Map> getLstHR() {
    	lstHR= new ArrayList();		
		HashMap mMap = new HashMap();
		mMap.put("hoja","0000045230-2015");
        mMap.put("tramite","DENUNCIAS LABORALES");
        mMap.put("remitente","WILLY CASTRO ALVARADO");
        mMap.put("documento","0000003070-2015");        
        mMap.put("asunto","DENUNCIA");
        mMap.put("destino","SUBINTENDENCIA DE ACTUACIÓN INSPECTIVA");
        mMap.put("fecha","21/11/2015");
        lstHR.add(mMap);
    	
		return lstHR;
	}

	public void setLstHR(List<Map> lstHR) {				
		this.lstHR = lstHR;
	}

	public List<Map> getLstIni() {
    	lstIni= new ArrayList();		
		HashMap mMap = new HashMap();
		mMap.put("hoja","0000045230-2015");
        mMap.put("tramite","DENUNCIAS LABORALES");
        mMap.put("documento","0000003070-2015");        
        mMap.put("asunto","DENUNCIA");
        mMap.put("destino","SUBINTENDENCIA DE ACTUACIÓN INSPECTIVA");
        mMap.put("fecha","21/11/2015");
        lstIni.add(mMap);
        
        mMap = new HashMap();
		mMap.put("hoja","0000023211-2015");
        mMap.put("tramite","DENUNCIAS LABORALES");
        mMap.put("documento","0000002095-2015");        
        mMap.put("asunto","DENUNCIA");
        mMap.put("destino","SUBINTENDENCIA DE ACTUACIÓN INSPECTIVA");
        mMap.put("fecha","27/04/2015");
        lstIni.add(mMap);
        
		return lstIni;
	}

	public void setLstIni(List<Map> lstIni) {
		this.lstIni = lstIni;
	}

	public List<Map> getLstCargo() {
    	lstCargo= new ArrayList();		
		HashMap mMap = new HashMap();
		mMap.put("codigo","00010-2016");
        mMap.put("fecha","18/01/2016 11:00 am");
        mMap.put("cantidad","4");
        mMap.put("usuario","SVASQUEZ");
        lstCargo.add(mMap);
    	
		return lstCargo;
	}

	public void setLstCargo(List<Map> lstCargo) {
		this.lstCargo = lstCargo;
	}

	public String getHojaRuta() {
		return hojaRuta;
	}

	public void setHojaRuta(String hojaRuta) {
		this.hojaRuta = hojaRuta;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public Date getCurDate() {
		return curDate;
	}

	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}

	public String[] getSelectedCities() {
		return selectedCities;
	}

	public void setSelectedCities(String[] selectedCities) {
		this.selectedCities = selectedCities;
	}

	public List<String> getCities() {
		cities = new ArrayList<String>();
        cities.add("Intendencia Nacional de Inteligencia Inspectiva");
        cities.add("Intendencia de Lima Metropolitana");
        cities.add("Sub Intendencia de Actuación Inspectiva");
        cities.add("Sub Intendencia de Resolución 1");
        cities.add("Sub Intendencia de Resolución 2");
        cities.add("Sub Intendencia de Resolución 3");
        cities.add("Sub Intendencia de Resolución 4");
        cities.add("Sub Intendencia de Resolución 5");
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}	
	
	public List<Map> getLstSeguimiento() {
		lstSeguimiento= new ArrayList();		
		HashMap mMap = new HashMap();
		mMap.put("anexo","");
        mMap.put("origen","SUNAFIL - UNIDAD DE TRAMITE DOCUMENTARIO Y ARCHIVO");
        mMap.put("destino","SUNAFIL-SECRETARIA GENERAL");
        mMap.put("documento","IF-0000000001-2016-SUNAFIL/SG/OGAJ");
        mMap.put("accion","");
        mMap.put("emision","05/01/2016 17:25:34");
        mMap.put("recepcion","05/01/2016 17:30:47");
        mMap.put("modificacion","");
        mMap.put("motivo","-");
        mMap.put("reemplazar","");
        lstSeguimiento.add(mMap);
        
        mMap = new HashMap();
        mMap.put("anexo","");
        mMap.put("origen","SUNAFIL-SECRETARIA GENERAL");
        mMap.put("destino","SUNAFIL-DESPACHO DE SUPERINTENDENTE");
        mMap.put("documento","PV-0000000004-2016-SUNAFIL/SG");
        mMap.put("accion","16,");
        mMap.put("emision","05/01/2016 17:31:59");
        mMap.put("recepcion","05/01/2016 17:34:09");
        mMap.put("modificacion","");
        mMap.put("motivo","-");
        mMap.put("reemplazar",""); 
        lstSeguimiento.add(mMap);
        
        mMap = new HashMap();
        mMap.put("anexo","");
        mMap.put("origen","SUNAFIL-DESPACHO DE SUPERINTENDENTE");
        mMap.put("destino","SUNAFIL-TRÁMITE DOCUMENTARIO Y ARCHIVO");
        mMap.put("documento","RSI-0000000001-2016-SUNAFIL/DS");
        mMap.put("accion","");
        mMap.put("emision","05/01/2016 17:34:40");
        mMap.put("recepcion","11/01/2016 18:19:50");
        mMap.put("modificacion","");
        mMap.put("motivo","Ya fue atendido");
        mMap.put("reemplazar",""); 
        lstSeguimiento.add(mMap);
        
		return lstSeguimiento;
	}

	public void setLstSeguimiento(List<Map> lstSeguimiento) {
		this.lstSeguimiento = lstSeguimiento;
	}

	public boolean isFormDisable() {
		return formDisable;
	}

	public void setFormDisable(boolean formDisable) {
		this.formDisable = formDisable;
	}

	public String getTipoBusqueda() {
		return tipoBusqueda;
	}

	public void setTipoBusqueda(String tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

	public List<Map> getLstConsulta() {
		lstConsulta= new ArrayList();		
		HashMap mMap = new HashMap();
        mMap.put("hojaRuta","0000001032-2015"); 
        mMap.put("remitente", "RICHARD GARRIDO AYRE");
        mMap.put("destino","OFICINA DE RRHH");
        mMap.put("ubicacion","MESA DE PARTES");
        mMap.put("fecha","23/12/2015");        
        mMap.put("estado","REGISTRADO");
        lstConsulta.add(mMap);		
		return lstConsulta;
	}

	public void setLstConsulta(List<Map> lstConsulta) {
		this.lstConsulta = lstConsulta;
	}

	public boolean isMostrarFieldsTupa() {
		return mostrarFieldsTupa;
	}

	public void setMostrarFieldsTupa(boolean mostrarFieldsTupa) {
		this.mostrarFieldsTupa = mostrarFieldsTupa;
	}

	public List<Map> getLstTupa() {
		lstTupa= new ArrayList();		
		HashMap mMap = new HashMap();
		mMap.put("codigo","55");
        mMap.put("descripcion","Verificación de despido arbitrario.D.S. Nº 003-97-TR, Arts. 31º, 32º y 34º"); 
        lstTupa.add(mMap);
        
        mMap = new HashMap();
		mMap.put("codigo","56");
        mMap.put("descripcion","Verificación de cierre de centro de trabajo"); 
        lstTupa.add(mMap);
        
        mMap = new HashMap();
		mMap.put("codigo","57");
        mMap.put("descripcion","Verificación de despido arbitrario"); 
        lstTupa.add(mMap);
        
        mMap = new HashMap();
		mMap.put("codigo","58");
        mMap.put("descripcion","Verificación de la disminución deliberada y reiterada en el rendimiento de las labores"); 
        lstTupa.add(mMap);
        
        mMap = new HashMap();
		mMap.put("codigo","59");
        mMap.put("descripcion","Observación del trabajador a la liquidación de la compensación por tiempo de servicios"); 
        lstTupa.add(mMap);
        
        mMap = new HashMap();
		mMap.put("codigo","60");
        mMap.put("descripcion","Otorgamiento de la constancia de cese"); 
        lstTupa.add(mMap);
        
		return lstTupa;
	}

	public void setLstTupa(List<Map> lstTupa) {
		this.lstTupa = lstTupa;
	}

	public String getHruta0() {
		return hruta0;
	}

	public void setHruta0(String hruta0) {
		this.hruta0 = hruta0;
	}

	public String getHruta1() {
		return hruta1;
	}

	public void setHruta1(String hruta1) {
		this.hruta1 = hruta1;
	}	
	
	public int[] getReqChoice() {
		return reqChoice;
	}

	public void setReqChoice(int[] reqChoice) {
		this.reqChoice = reqChoice;
	}

	public String getNroFolios() {
		return nroFolios;
	}

	public void setNroFolios(String nroFolios) {
		this.nroFolios = nroFolios;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public String getTipoDoc2() {
		return tipoDoc2;
	}

	public void setTipoDoc2(String tipoDoc2) {
		this.tipoDoc2 = tipoDoc2;
	}

	public String getNroDoc2() {
		return nroDoc2;
	}

	public void setNroDoc2(String nroDoc2) {
		this.nroDoc2 = nroDoc2;
	}	
	
	public boolean isEsGrabar() {
		return esGrabar;
	}

	public void setEsGrabar(boolean esGrabar) {
		this.esGrabar = esGrabar;
	}

	public List<Map> getLstNoPresentados() {
		/*lstNoPresentados= new ArrayList();		
		HashMap mMap = new HashMap();
        mMap.put("hojaRuta","0000000810-2015"); 
        mMap.put("tipoDoc", "MEMORÁNDUM");
        mMap.put("documento","0000000028-2015");
        mMap.put("asunto","SOLICITUD DE CONSTANCIA DE CESE");
        mMap.put("origen","MESA DE PARTES");        
        mMap.put("fechaEmision","18/12/2015");
        lstNoPresentados.add(mMap);		
		return lstNoPresentados;*/
		lstNoPresentados= new ArrayList();		
		HashMap mMap = new HashMap();
        mMap.put("hojaRuta","0000000935-2016"); 
        mMap.put("tipoDoc", "WILLY CASTRO ALVARADO");
        mMap.put("documento","OF-0000000036-2015");
        mMap.put("asunto","SOLICITUD DE INSPECCIÓN DESPIDO ARBITRARIO");
        mMap.put("origen","SUB INTENDENCIA DE ACTUACIÓN INSPECTIVA");        
        mMap.put("fechaEmision","31/12/2015");
        lstNoPresentados.add(mMap);		
		return lstNoPresentados;
	}

	public void setLstNoPresentados(List<Map> lstNoPresentados) {
		this.lstNoPresentados = lstNoPresentados;
	}

	public List<Map> getLstObservados() {
		lstObservados= new ArrayList();		
		HashMap mMap = new HashMap();
        mMap.put("hojaRuta","0000000935-2016"); 
        mMap.put("tipoDoc", "WILLY CASTRO ALVARADO");
        mMap.put("documento","OF-0000000036-2015");
        mMap.put("asunto","SOLICITUD DE INSPECCIÓN DESPIDO ARBITRARIO");
        mMap.put("origen","SUB INTENDENCIA DE ACTUACIÓN INSPECTIVA");        
        mMap.put("fechaEmision","28/12/2015");
        lstObservados.add(mMap);		
		return lstObservados;
	}

	public void setLstObservados(List<Map> lstObservados) {
		this.lstObservados = lstObservados;
	}

	public List<Map> getLstRegistrados() {		
		lstRegistrados= new ArrayList();		
		HashMap mMap = new HashMap();
        mMap.put("hojaRuta","0000001002-2015"); 
        mMap.put("tipoDoc", "RICHARD GARRIDO AYRE");
        mMap.put("documento","SL-0000000365-2015");
        mMap.put("asunto","SOBRE DE PROCESO CAS 20-2015");
        mMap.put("origen","OFICINA DE RRHH");        
        mMap.put("fechaEmision","23/12/2015");
        lstRegistrados.add(mMap);		
		return lstRegistrados;
	}

	public void setLstRegistrados(List<Map> lstRegistrados) {
		this.lstRegistrados = lstRegistrados;
	}

	public boolean isEsRUC() {
		return esRUC;
	}

	public void setEsRUC(boolean esRUC) {
		this.esRUC = esRUC;
	}

	public boolean isEsDNI() {
		return esDNI;
	}

	public void setEsDNI(boolean esDNI) {
		this.esDNI = esDNI;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getDocReferencia() {
		return docReferencia;
	}

	public void setDocReferencia(String docReferencia) {
		this.docReferencia = docReferencia;
	}

	public List<Map> getLstReferenciar() {
		lstReferenciar= new ArrayList();		
		HashMap mMap = new HashMap();
		mMap.put("hojaRuta","0000000030-2015");
        mMap.put("nroOrden","0000013730-2015"); 
        mMap.put("nroActa", "0000002191-2015");
        mMap.put("depActa","Sub Intendendencia de Resolución 3");
        mMap.put("expediente","0000000022-2015");
        mMap.put("depExpediente","Sub Intendendencia de Resolución 3");        
        mMap.put("primerInst","0000000028-2015");
        mMap.put("depPrimerInst","Sub Intendendencia de Resolución 3");
        mMap.put("segInst","0000000151-2015");
        mMap.put("depSegInst","Intendencia de Lima Metropolitana");
		lstReferenciar.add(mMap);		
		return lstReferenciar;
	}

	public void setLstReferenciar(List<Map> lstReferenciar) {
		this.lstReferenciar = lstReferenciar;
	}

	public boolean getMostrarReq() {
		return mostrarReq;
	}

	public void setMostrarReq(boolean mostrarReq) {
		this.mostrarReq = mostrarReq;
	}

	public String getTupa() {
		return tupa;
	}

	public void setTupa(String tupa) {
		this.tupa = tupa;
	}

	public String getTupaDes() {
		return tupaDes;
	}

	public void setTupaDes(String tupaDes) {
		this.tupaDes = tupaDes;
	}
	
	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}	
	
	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public List<Map> getLstRegRef() {
		return lstRegRef;
	}

	public void setLstRegRef(List<Map> lstRegRef) {
		this.lstRegRef = lstRegRef;
	}

	public MenuBean() {		
		
		menuModel= new DefaultMenuModel();
			
	}
	
	public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + (i + 1));
        }
         
        return results;
    }
	
	public void selectReferencia(String item)
	{
		hruta0=item.split("-")[0];
		hruta1=item.split("-")[1];
		txt1="Intendencia de Lima Metropolitana";
		//System.out.println("seleccionado ::: "+item);
	}
	
	public void selectTupa(String codigo, String descripcion)
	{
		tupa=codigo;
		tupaDes=descripcion;
		txt1="Sub Intendencia de Actuación Inspectiva";
		mostrarReq=true;
		//System.out.println("seleccionado ::: "+item);
	}
	
	public void activaGrabar()
	{
		esGrabar=true;
	}
	
	public void itemChangeCategoria()
	{
		if(tipoDoc2 !=null)
		{
			if("1".equalsIgnoreCase(tipoDoc2))
			{//es tupa
				mostrarFieldsTupa=true;
			}
			else
			{//no es tupa
				mostrarFieldsTupa=false;
				mostrarReq=false;
			}
		}		
	}
	
	public void itemChangeBusqueda()
	{

		/*if("1".equalsIgnoreCase(tipoBusqueda))
		{
			mostrarFieldsTupa=true;
		}
		else if("1".equalsIgnoreCase(tipoBusqueda))
		{
			mostrarFieldsTupa=false;
			mostrarReq=false;
		}
		else if("1".equalsIgnoreCase(tipoBusqueda))
		{
			
		}*/
	
	}
	
	public void imprimir() 
    {
		try {			
			if(reqChoice.length==3)//tiene todos los requisitos chekeados
			{
				FacesUtils.mostrarPDF("/jsfDocs/modulos/ejemplo/", "hr.pdf");
			}
			else
			{
				FacesUtils.mostrarPDF("/jsfDocs/modulos/ejemplo/", "observadoyhro.pdf");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void imprimirHR() 
    {
		try {			
			FacesUtils.mostrarPDF("/jsfDocs/modulos/ejemplo/", "hr.pdf");			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void imprimirHRO() 
    {
		try {			
			FacesUtils.mostrarPDF("/jsfDocs/modulos/ejemplo/", "hro.pdf");			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void imprimirHRNP() 
    {
		try {			
			FacesUtils.mostrarPDF("/jsfDocs/modulos/ejemplo/", "hrnp.pdf");			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void imprimirCargo() 
    {
		try {			
			FacesUtils.mostrarPDF("/jsfDocs/modulos/ejemplo/", "cargo.pdf");			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void imprimirO() 
    {
		try {			
			FacesUtils.mostrarPDF("/jsfDocs/modulos/ejemplo/", "observado.pdf");			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void imprimirNP() 
    {
		try {
			FacesUtils.mostrarPDF("/jsfDocs/modulos/ejemplo/", "nopresentado.pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void rptPorProcedimiento() 
    {
		try {
			FacesUtils.mostrarXLSX("/jsfDocs/modulos/ejemplo/", "rptPorProc.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void rptPorUsuario() 
    {
		try {
			FacesUtils.mostrarXLSX("/jsfDocs/modulos/ejemplo/", "rptPorUsuario.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void xlsBusqueda() 
    {
		try {
			FacesUtils.mostrarXLSX("/jsfDocs/modulos/ejemplo/", "busqueda.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public String subsanar()
	{
		tipoDoc="1";
		nroDoc="44436285";
		nombres="WILLY";
		apellidoPat="CASTRO";
		apellidoMat="ALVARADO";
		razonSocial="";
		esDNI=true;
		esRUC=false;
		tupa="55";
		tupaDes="Verificación de despido arbitrario.D.S. Nº 003-97-TR, Arts. 31º, 32º y 34º del 27/03/1997;  D.Leg. Nº 910, Art. 16.3 del 17/03/2001, modificada porLey N° 28292 del 21/07/2004.   (9)";
		txt1="SIRE1";
		mostrarReq=true;
		tipoDoc2="1";
		nroDoc2="0000000036-2015";
		nroFolios="2";
		asunto="SOLICITUD DE INSPECCIÓN DESPIDO ARBITRARIO";
		observaciones="NINGUNA";
		int[] reqChoice0= {1,11};
		reqChoice= reqChoice0;
		docReferencia="";
		hruta0="";
		hruta1="";
		esGrabar=false;
		formDisable=true;
		
		String vista="pretty:nuevoRegPretty";
        //CODIGO
        return  vista;
	}
	
	public String editar()
	{
		tipoDoc="1";
		nroDoc="44436285";
		nombres="WILLY";
		apellidoPat="CASTRO";
		apellidoMat="ALVARADO";
		razonSocial="";
		esDNI=true;
		esRUC=false;
		tupa="";
		tupaDes="";
		txt1="SIRE1";
		mostrarReq=false;
		tipoDoc2="5";
		nroDoc2="0000000365-2015";
		nroFolios="2";
		asunto="SOBRE DE PROCESO CAS 20-2015";
		observaciones="NINGUNA";
		reqChoice= null;
		docReferencia="";
		hruta0="";
		hruta1="";
		esGrabar=false;
		formDisable=false;
		
		String vista="pretty:nuevoRegPretty";
        //CODIGO
        return  vista;
	}
	
	public void activaRucODni()
	{
		if(tipoDoc!=null && nroDoc!=null)
		{
			if("03".equals(tipoDoc) && "44436285".equals(nroDoc))
			{
				nombres="WILLY";
				apellidoPat="CASTRO";
				apellidoMat="ALVARADO";
				razonSocial="";
				esDNI=true;
				esRUC=false;
			}
			else if("09".equals(tipoDoc) && "44436285111".equals(nroDoc))
			{
				nombres="";
				apellidoPat="";
				apellidoMat="";
				razonSocial="GLOBAL HUB PERÚ";
				esDNI=false;
				esRUC=true;
			}		
			else if("06".equals(tipoDoc) || "08".equals(tipoDoc))
			{
				nombres="";
				apellidoPat="";
				apellidoMat="";
				razonSocial="";
				esDNI=true;
				esRUC=false;
			}
		}		
	}
	
	public void activaTupa()
	{
		if("55".equals(tupa))
		{
			tupaDes="Verificación de despido arbitrario.D.S. Nº 003-97-TR, Arts. 31º, 32º y 34º del 27/03/1997;  D.Leg. Nº 910, Art. 16.3 del 17/03/2001, modificada porLey N° 28292 del 21/07/2004.   (9)";
			txt1="Sub Intendencia de Actuación Inspectiva";
			mostrarReq=true;
		}
		else
		{
			tupaDes="";
			txt1="";
			mostrarReq=false;
		}
	}

	/**
	 * @Construyendo el menú 
	 */
	private void construyeMenu(){
		FacesContext facesCtx = FacesContext.getCurrentInstance();
		ELContext elCtx = facesCtx.getELContext();
		ExpressionFactory expFact = facesCtx.getApplication().getExpressionFactory();
		//CUANDO TE DEN EL MENU*/
		for (int i = 0; i < PGP_MenuPadre.size(); i++) {
			logger.debug("entra aqui "+PGP_MenuPadre.get(i).v_menu+" esto es el menu");
			Submenu submenu=new Submenu();
			submenu.setLabel(PGP_MenuPadre.get(i).v_menu);
			//submenu.setIcon("icon-key");
			
				for (int j = 0; j < PGP_MenuHijo.size(); j++) {
					if(PGP_MenuHijo.get(j).getV_codpad().equals(PGP_MenuPadre.get(i).getMen_padre())){
						MenuItem itemM=new MenuItem();
						
						itemM.setId("id"+j);
						itemM.setValue(PGP_MenuHijo.get(j).v_desmen);
						itemM.setAjax(true);						 
						String url=PGP_MenuHijo.get(j).v_url;
						
						MethodExpression metodo=expFact.createMethodExpression(elCtx,url, String.class, new Class[0]);
						itemM.setActionExpression(metodo);
						//itemM.addActionListener(new MethodExpressionActionListener(metodo));	
						itemM.setIcon("ui-icon-folder-collapsed");
						//itemM.setTransient(true);
						
						submenu.getChildren().add(itemM);                                
					}
				}
			menuModel.addSubmenu(submenu);
		
		}	
		
		
		/*CUANDO NO SE TIENE LOS MENUS EN LA BD**
		MenuItem gestion=new MenuItem();

		gestion.setId("id_gestion");
		gestion.setValue("Gestionar Encuesta");
		gestion.setAjax(true);						 
		String url1="#{menuBean.redGestionarEncuesta}";
		
		MethodExpression metodo1=expFact.createMethodExpression(elCtx,url1, String.class, new Class[0]);
		gestion.setActionExpression(metodo1);		
		menuModel.addMenuItem(gestion);
		
		MenuItem contra=new MenuItem();

		contra.setId("id_contra");
		contra.setValue("Cambio de Contraseña");
		contra.setAjax(true);						 
		String url2="#{menuBean.redCamContrasena}";
		
		MethodExpression metodo2=expFact.createMethodExpression(elCtx,url2, String.class, new Class[0]);
		contra.setActionExpression(metodo2);		
		menuModel.addMenuItem(contra);
		FIN POR MIENTRAS**/		
		
		//INI::MENU PARA EJEMPLO DE PRETTY-FACES:
		MenuItem ejemplo=new MenuItem();

		ejemplo.setId("id_Ejemplo");
		ejemplo.setValue("Ejemplo");
		ejemplo.setAjax(true);
		String url_e="#{menuBean.ejemploMenu}";
		
		MethodExpression metodo_e=expFact.createMethodExpression(elCtx,url_e, String.class, new Class[0]);
		ejemplo.setActionExpression(metodo_e);		
		//menuModel.addMenuItem(ejemplo); solo ejemplo
		//FIN::
		
		
		//***************************************
		//MENUS QUE SIEMPRE DEBEN IR:
		//***************************************
		MenuItem manual=new MenuItem();

		manual.setId("id_manual");
		manual.setValue("Manual de Usuario");
		manual.setAjax(false);
		manual.setTarget("_blank");
		manual.setOnclick("this.target = '_blank'");
		manual.setIcon("ui-icon-note");
		manual.setUrl("/jsfDocs/modulos/ejemplo/manual.pdf");		
		
		MethodExpression metodo_cm=expFact.createMethodExpression(elCtx,"/jsfDocs/modulos/ejemplo/manual.pdf", String.class, new Class[0]);
		manual.setActionExpression(metodo_cm);		
		menuModel.addMenuItem(manual);//
		
		MenuItem contra=new MenuItem();

		contra.setId("id_contra");
		contra.setValue("Cambiar Contraseña");
		contra.setAjax(true);
		contra.setIcon("icon-key");
		//contra.setTransient(true);
		String url2="#{menuBean.redCamContrasena}";
		
		MethodExpression metodo_c=expFact.createMethodExpression(elCtx,url2, String.class, new Class[0]);
		contra.setActionExpression(metodo_c);		
		menuModel.addMenuItem(contra);
		
		MenuItem salir=new MenuItem();

		salir.setId("id_Salir");
		salir.setValue("Salir");
		salir.setAjax(true);
		salir.setIcon("icon-exit");
		//salir.setTransient(true);
		String url="#{menuBean.efectuarSalir}";
		
		MethodExpression metodo=expFact.createMethodExpression(elCtx,url, String.class, new Class[0]);
		salir.setActionExpression(metodo);		
		menuModel.addMenuItem(salir);
        
	        
       
	}
	
	
	public void guia() 
    {
		try {
			FacesUtils.mostrarPDF("/jsfDocs/modulos/ejemplo/", "manual.pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*String vista="pretty:manual";
        //CODIGO
        return  vista;*/
    }
	
	/**
	 * Metodo de Ejemplo el cual puede estar en algun ManagedBean
	 * @return
	 */
	public String ejemploMenu(){
		String vista="pretty:ejemploPretty";
        //CODIGO
        return  vista;
	}
	
	public String bandejaRegistrados(){
		String vista="pretty:banRegPretty";
        //CODIGO
        return  vista;
	}
	
	public String bandejaObservados(){
		String vista="pretty:banObsPretty";
        //CODIGO
        return  vista;
	}
	
	public String bandejaNoPresentados(){
		String vista="pretty:banNopPretty";
        //CODIGO
        return  vista;
	}
	
	public String nuevoRegistro(){
		tipoDoc=null;
		nroDoc="";
		nombres="";
		apellidoPat="";
		apellidoMat="";
		razonSocial="";
		esDNI=false;
		esRUC=false;
		tupa="";
		tupaDes="";
		txt1="";
		mostrarReq=false;
		tipoDoc2=null;
		nroDoc2="";
		nroFolios="";
		asunto="";
		observaciones="";		
		reqChoice= null;
		docReferencia="";
		hruta0="";
		hruta1="";
		esGrabar=false;
		formDisable=false;
		
		String vista="pretty:nuevoRegPretty";
        //CODIGO
        return  vista;
	}
	
	public void dialogReferencia(){			
		RequestContext.getCurrentInstance().execute("dialogWidget.show()");
	}
	
	public void dialogReferenciaHR(){			
		RequestContext.getCurrentInstance().execute("dialogWidgetHR.show()");
	}
	
	public void dialogReferenciaIni(){			
		RequestContext.getCurrentInstance().execute("dialogWidgetIni.show()");
	}
	
	public void dialogTupa(){			
		RequestContext.getCurrentInstance().execute("dialogWidgetTupa.show()");
	}
	
	public void dialogCargo(){			
		RequestContext.getCurrentInstance().execute("dialogWidgetCargo.show()");
	}
	
	public void dialogSeguimiento(){			
		RequestContext.getCurrentInstance().execute("dialogWidgetSeg.show()");
	}
	
	public void dialogDependencia(){
		RequestContext.getCurrentInstance().execute("dialogDependenciaWidget.show()");
	}
	
	public String reportePorProcedimiento(){
		String vista="pretty:rptPorProcedimentoPretty";
        //CODIGO
        return  vista;
	}
	
	public String reportePorUsuario(){
		String vista="pretty:rptPorUsuarioPretty";
        //CODIGO
        return  vista;
	}
	
	public String busqueda(){
		String vista="pretty:busquedaPretty";
        //CODIGO
        return  vista;
	}
	
	public String genCargo(){
		String vista="pretty:genCargoPretty";
        //CODIGO
        return  vista;
	}
	
	public String hisCargo(){
		String vista="pretty:hisCargoPretty";
        //CODIGO
        return  vista;
	}
	
	public void getSelectedDoc()
	{
		
	}
	
	/**
	 * Redireccion al cambio de contraseñas
	 * @return String 
	 */
	public String redCamContrasena() {
		String vista = "";			
		vista = "pretty:mnt_contrasena";
		return vista;
	}
	
	/**
	 * Metodo para salir del sistema.
	 * @return String
	 */
	public String efectuarSalir(){
		String vista="pretty:login";
		FacesUtils.removeUsuarioLogueado();		
		FacesUtils.removeSessionAttribute("loginBean");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        session.invalidate();
        return  vista;
	}
	
	 
	

	
	/**
	 * @zona get set
	 */


	public List<MenuPadre> getPGP_MenuPadre() {
		return PGP_MenuPadre;
	}

	public void setPGP_MenuPadre(List<MenuPadre> pGP_MenuPadre) {
		PGP_MenuPadre = pGP_MenuPadre;
	}

	

	public MenuModel getMenuModel() {
		//bug del reconstruir menu
		/*if(menuModel.getContents().size()==0){
			construyeMenu();
		}
		return menuModel;*/
		menuModel= new DefaultMenuModel();
		construyeMenu();
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public List<MenuHijo> getPGP_MenuHijo() {
		return PGP_MenuHijo;
	}

	public void setPGP_MenuHijo(List<MenuHijo> pGP_MenuHijo) {
		PGP_MenuHijo = pGP_MenuHijo;
	}
	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}

	public Permisos getPGP_Permisos() {
		return PGP_Permisos;
	}

	public void setPGP_Permisos(Permisos pGP_Permisos) {
		PGP_Permisos = pGP_Permisos;
	}

	public String getVieneMenu() {
		return vieneMenu;
	}

	public void setVieneMenu(String vieneMenu) {
		this.vieneMenu = vieneMenu;
	}

	

	
	
}
