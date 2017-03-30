package pe.gob.sunafil.tramiteext.managedBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import pe.gob.sunafil.tramiteext.bean.Usuario;
import pe.gob.sunafil.tramiteext.funciones.Funciones;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.BandejaDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.ConsultaDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.DistribucionDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.LoginDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.RegistrarDespatch;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocide;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcCorte;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcHojarutaKey;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex;
import pe.gob.sunafil.tramiteext.utils.FacesUtils;

@ManagedBean(name="distribucionBean")
@SessionScoped
public class DistribucionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7449223606952642283L;
	
	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;
	
	//GENERAR CARGO
	private Date curDate=new Date();
	private List <VstBandejastrex> listaRegistrosCargo;
	private String[] selectedDependencias;
	private boolean esGrabar=false;
	private TdmvcCorte corte;
	private String dependenciasInLine;
	private boolean selectAllDep=true;	
	private String[] allDependencias;

	//HISTORICO CARGO
	private Date fechaI=new Date();
	private Date fechaF=new Date();
	private String vCodcorte;
	private String vAnocorte;
	private List <TdmvcCorte> lstCargo;
	private TdmvcCorte cargoAdjuntar;
	private UploadedFile file;
	private StreamedContent fileDownload;
	
	public String[] getAllDependencias() {
		
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		List <TdtbcDependencia> listaDependencia;
		try {
			listaDependencia=registrarDespatch.getDependencia(PGP_Usuario.getN_numint());
		} catch (Exception e) {
			listaDependencia=null;
			e.printStackTrace();
		}		
		allDependencias = new String[listaDependencia.size()];
		int i=0;
		for (Iterator iterator = listaDependencia.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			allDependencias[i]=""+tdtbcDependencia.getnNumdep();
			++i;
		}		
		return allDependencias;
	}

	public void setAllDependencias(String[] allDependencias) {
		this.allDependencias = allDependencias;
	}
	
	public boolean isSelectAllDep() {
		return selectAllDep;
	}

	public void setSelectAllDep(boolean selectAllDep) {
		this.selectAllDep = selectAllDep;
	}
	
	public StreamedContent getFileDownload() {
		return fileDownload;
	}

	public void setFileDownload(StreamedContent fileDownload) {
		this.fileDownload = fileDownload;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public TdmvcCorte getCargoAdjuntar() {
		return cargoAdjuntar;
	}

	public void setCargoAdjuntar(TdmvcCorte cargoAdjuntar) {
		this.cargoAdjuntar = cargoAdjuntar;
	}

	public List<TdmvcCorte> getLstCargo() {
		return lstCargo;
	}

	public void setLstCargo(List<TdmvcCorte> lstCargo) {
		this.lstCargo = lstCargo;
	}

	public String getvCodcorte() {
		return vCodcorte;
	}

	public void setvCodcorte(String vCodcorte) {
		this.vCodcorte = vCodcorte;
	}

	public String getvAnocorte() {
		return vAnocorte;
	}

	public void setvAnocorte(String vAnocorte) {
		this.vAnocorte = vAnocorte;
	}	
	
	public Date getFechaI() {
		return fechaI;
	}

	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}

	public Date getFechaF() {
		return fechaF;
	}

	public void setFechaF(Date fechaF) {
		this.fechaF = fechaF;
	}	
	
	public String getDependenciasInLine() {
		return dependenciasInLine;
	}

	public void setDependenciasInLine(String dependenciasInLine) {
		this.dependenciasInLine = dependenciasInLine;
	}

	public TdmvcCorte getCorte() {
		return corte;
	}

	public void setCorte(TdmvcCorte corte) {
		this.corte = corte;
	}

	public boolean isEsGrabar() {
		return esGrabar;
	}

	public void setEsGrabar(boolean esGrabar) {
		this.esGrabar = esGrabar;
	}

	public String[] getSelectedDependencias() {
		return selectedDependencias;
	}

	public void setSelectedDependencias(String[] selectedDependencias) {
		this.selectedDependencias = selectedDependencias;
	}

	public List<VstBandejastrex> getListaRegistrosCargo() {
		return listaRegistrosCargo;
	}

	public void setListaRegistrosCargo(List<VstBandejastrex> listaRegistrosCargo) {
		this.listaRegistrosCargo = listaRegistrosCargo;
	}

	public Date getCurDate() {
		return curDate;
	}

	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}	
	
	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}

	public String getSiguienteCorrelativoGlobal(String anio)
	{
		DistribucionDespatch distribucionDespatch = new DistribucionDespatch();
		try {
			TdmvcCorte correlativo=distribucionDespatch.getCorrelativoGlobalCorte(anio);
			if(correlativo!=null)
			{
				return ""+(Integer.parseInt(correlativo.getvCodcorte())+1);
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
	
	public void grabar()
	{
		if(selectAllDep)
		{
			selectedDependencias=getAllDependencias();
		}
		else if(!selectAllDep)
		{
			if(selectedDependencias!=null && selectedDependencias.length!=0){}
			else
			{
				System.out.println("Debe seleccionar al menos una dependencia.");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe seleccionar al menos una dependencia."));
				return;
			}
		}
		dependenciasInLine="";
		List<Short> destinos=new ArrayList<Short>();
		for (int i = 0; i < selectedDependencias.length; i++) {
			destinos.add(new Short(selectedDependencias[i]));//destinos.add(new Short(selectedDependencias[i].split(" ")[0]));
			System.out.println("DEP :: "+selectedDependencias[i]);
			//dependenciasInLine+=selectedDependencias[i].split(" ")[0]+", ";
			//para la des completa descomentar linea sgte y comentar linea anterior
			dependenciasInLine+=selectedDependencias[i]+", ";
		}
		dependenciasInLine=dependenciasInLine.substring(0, dependenciasInLine.length()-2);
		
		DistribucionDespatch distribucionDespatch = new DistribucionDespatch();		
		Date fechaFNP=curDate;	
		Date fechaFplusNP=curDate;
		if(fechaFNP!=null)
		{
			Calendar c = Calendar.getInstance(); 
			c.setTime(fechaFNP); 
			c.add(Calendar.DATE, 1);
			fechaFplusNP = c.getTime();
		}		
		try {									
			//de no ser necesario restringir la lista solo a los registros con la misma dep origen que el usuario logueado poner null en el primer parametro
			listaRegistrosCargo=distribucionDespatch.getRegistrosCargo(PGP_Usuario.getN_numdep(), curDate, fechaFplusNP, null, null, null, null, new Short("0"), destinos);
		} catch (Exception e) {
			listaRegistrosCargo=null;
			e.printStackTrace();
		}		
		if(listaRegistrosCargo.size()==0)
		{
			System.out.println("No hay documentos pendientes, no se puede generar cargo.");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No hay documentos pendientes, no se puede generar cargo."));
			return;
		}
		corte = new TdmvcCorte();
		try {//inserta corte			
			corte.setvAnocorte(""+(Calendar.getInstance().get(Calendar.YEAR)));
			corte.setvCodcorte(getSiguienteCorrelativoGlobal(corte.getvAnocorte()));
			corte.setdFeccorte(new Date());
			corte.setnNumdepori(new Short(PGP_Usuario.getN_numdep()));
			corte.setnCantidad(listaRegistrosCargo.size());
			corte.setnFlganulado(new Short("0"));
			corte.setvObservacion("");//pendiente ver que poner ahi
			corte.setvNomusureg(PGP_Usuario.getV_codusu());
			corte.setdFecreg(corte.getdFeccorte());
			corte.setvNomusumod(PGP_Usuario.getV_codusu());
			corte.setdFecmod(corte.getdFeccorte());
			distribucionDespatch.insertarCorte(corte);
			//actualizar campos cod_corte y anio_corte en registro
			TdmvcRegistro entidad=new TdmvcRegistro();
			entidad.setvCodcorte(corte.getvCodcorte());
			entidad.setvAnocorte(corte.getvAnocorte());
			distribucionDespatch.updateRegistrosCargo(entidad, PGP_Usuario.getN_numdep(), curDate, fechaFplusNP, null, null, null, new Short("0"), destinos, listaRegistrosCargo);
			esGrabar=true;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Cargo generado. Puede proceder con la impresión."));
		} catch (Exception e) {
			e.printStackTrace();
			corte=null;
			esGrabar=false;
		}
			
	}
	
	public void generarCargo()
	{
		DistribucionDespatch distribucionDespatch = new DistribucionDespatch();	
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		if(corte!=null)
		{
			try {					
				Map parametros = new HashMap();
				String horaCorte=getFormatHourCargo(corte.getvCodcorte(), corte.getvAnocorte());
				parametros.put("fechaActual", getFormatDMY());//getFormatDate(corte.getdFeccorte())+" "+horaCorte
				parametros.put("nroCargo", corte.getvCodcorte()+"-"+corte.getvAnocorte());
				parametros.put("depOrigen", PGP_Usuario.getV_desdep());
				parametros.put("depDestinos", dependenciasInLine);
				parametros.put("fechaDel", getFormatDate(corte.getdFeccorte())+" "+horaCorte);
				parametros.put("fechaAl", getFormatDate(corte.getdFeccorte())+" "+horaCorte);
				parametros.put("nomUsuario", getNombrePorUsername(corte.getvNomusureg()));//PGP_Usuario.getV_desnombres()+" "+PGP_Usuario.getV_desapepat()+" "+PGP_Usuario.getV_desapemat()
				List<Map>  lstData=new ArrayList<Map>();
				//recupera la lista en base al cargo generado
				listaRegistrosCargo=distribucionDespatch.getRegistrosPorCargo(corte.getvAnocorte(), corte.getvCodcorte());
				for (VstBandejastrex currentRecord: listaRegistrosCargo)
				{
					Map data = new HashMap();
					data.put("cur", currentRecord.getvNumanoreg()+"-"+currentRecord.getvNumreg());
					data.put("hr", currentRecord.getvNumhoja()+"-"+currentRecord.getvAniohoja());
					data.put("entidad", currentRecord.getvDesnombre());
					data.put("asunto", currentRecord.getvAsuntodetallado());
					data.put("fecha", getFormatDate(currentRecord.getdFecreg())+" "+getFormatHourRegistro(currentRecord));
					data.put("documento", (currentRecord.getvDestipodoc()!=null && currentRecord.getvNumdoc()!=null)?currentRecord.getvDestipodoc()+"-"+currentRecord.getvNumdoc():"");
					data.put("folios", ""+currentRecord.getnNumfolios());
					data.put("usuario", currentRecord.getvNomusureg());
					TdtbcDependencia depT=registrarDespatch.getDependenciaPorCodigo(currentRecord.getnNumdepdest());
					data.put("dependencia", depT.getvDesdep());//depT.getnNumdep()+" "+depT.getvDesdep()
					lstData.add(data);
				}
				System.out.println("Recupera la lista de "+lstData.size());
				FacesUtils.mostrarReporteJasper(parametros, "cargo.jasper", lstData, "CargoGenerado");
				System.out.println("Muestra reporte");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}	
	}
	
	public String getFormatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
	
	public String getFormatHour(Date date) {
        return new SimpleDateFormat("HH:mm").format(date);
    }
	
	public String genCargo(){
		curDate=new Date();
		listaRegistrosCargo=null;
		selectedDependencias=null;
		esGrabar=false;
		corte=null;
		dependenciasInLine="";
		selectAllDep=true;
		String vista="pretty:genCargoPretty";
        //CODIGO
        return  vista;
	}
	
	public void buscarHistorico()
	{
		if(fechaF==null && fechaI!=null)
		{
			lstCargo=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Se requiere ingresar Fecha Desde y Fecha Hasta."));
            return;
		}
		if(fechaF!=null && fechaI==null)
		{
			lstCargo=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Se requiere ingresar Fecha Desde y Fecha Hasta."));
            return;
		}
		if(fechaF!=null && fechaI!=null)
		{
			if(fechaF.before(fechaI))
			{
				lstCargo=null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "La fecha hasta debe ser mayor que la fecha desde."));
	            return;
			}
		}
		DistribucionDespatch distribucionDespatch = new DistribucionDespatch();
		try {
			Date fechaFplus=fechaF;
			if(fechaF!=null)
			{
				Calendar c = Calendar.getInstance(); 
				c.setTime(fechaF); 
				c.add(Calendar.DATE, 1);
				fechaFplus = c.getTime();
			}						
			if("".equals(vAnocorte))
			{
				vAnocorte=null;
			}
			if("".equals(vCodcorte))
			{
				vCodcorte=null;
			}
			lstCargo=distribucionDespatch.getHistoricoCargo(PGP_Usuario.getN_numdep(), fechaI, fechaF!=null?fechaFplus:null, vAnocorte, vCodcorte);
		} catch (Exception e) {
			lstCargo=null;
			e.printStackTrace();
		}
	}
	
	public void generarCargo(TdmvcCorte currentCorte)
	{
		DistribucionDespatch distribucionDespatch = new DistribucionDespatch();	
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		if(currentCorte!=null)
		{
			List<String> dependenciasList=new ArrayList<String>();
			String curDependenciasInLine="";
			try {					
				Map parametros = new HashMap();
				String horaCorte=getFormatHourCargo(currentCorte.getvCodcorte(), currentCorte.getvAnocorte());
				parametros.put("fechaActual", getFormatDMY());//getFormatDate(currentCorte.getdFeccorte())+" "+horaCorte
				parametros.put("nroCargo", currentCorte.getvCodcorte()+"-"+currentCorte.getvAnocorte());
				parametros.put("depOrigen", PGP_Usuario.getV_desdep());				
				parametros.put("fechaDel", getFormatDate(currentCorte.getdFeccorte())+" "+horaCorte);
				parametros.put("fechaAl", getFormatDate(currentCorte.getdFeccorte())+" "+horaCorte);
				parametros.put("nomUsuario", getNombrePorUsername(currentCorte.getvNomusureg()));//PGP_Usuario.getV_desnombres()+" "+PGP_Usuario.getV_desapepat()+" "+PGP_Usuario.getV_desapemat()
				List<Map>  lstData=new ArrayList<Map>();
				//recupera la lista en base al cargo generado
				List <VstBandejastrex> listaRegistrosCargoHistorico=distribucionDespatch.getRegistrosPorCargo(currentCorte.getvAnocorte(), currentCorte.getvCodcorte());
				for (VstBandejastrex currentRecord: listaRegistrosCargoHistorico)
				{
					Map data = new HashMap();
					data.put("cur", currentRecord.getvNumanoreg()+"-"+currentRecord.getvNumreg());
					data.put("hr", currentRecord.getvNumhoja()+"-"+currentRecord.getvAniohoja());
					data.put("entidad", currentRecord.getvDesnombre());
					data.put("asunto", currentRecord.getvAsuntodetallado());
					data.put("fecha", getFormatDate(currentRecord.getdFecreg())+" "+getFormatHourRegistro(currentRecord));
					data.put("documento", (currentRecord.getvDestipodoc()!=null && currentRecord.getvNumdoc()!=null)?currentRecord.getvDestipodoc()+"-"+currentRecord.getvNumdoc():"");
					data.put("folios", ""+currentRecord.getnNumfolios());
					data.put("usuario", currentRecord.getvNomusureg());
					TdtbcDependencia depT=registrarDespatch.getDependenciaPorCodigo(currentRecord.getnNumdepdest());
					data.put("dependencia", depT.getvDesdep());//depT.getnNumdep()+" "+depT.getvDesdep()
					dependenciasList.add(""+currentRecord.getnNumdepdest());
					lstData.add(data);
				}
				Set<String> uniqueDep = new HashSet<String>(dependenciasList);
				for (Iterator iterator = uniqueDep.iterator(); iterator
						.hasNext();) {
					TdtbcDependencia depTemp=registrarDespatch.getDependenciaPorCodigo(new Short(iterator.next().toString()));
					curDependenciasInLine+=depTemp.getnNumdep()+" "+depTemp.getvDesdep()+", ";
				}
				curDependenciasInLine=curDependenciasInLine.substring(0, curDependenciasInLine.length()-2);
				parametros.put("depDestinos", curDependenciasInLine);//pendiente hacer funcion q liste las dependencias en base a un cargo del historico
				System.out.println("Recupera la lista de "+lstData.size());
				FacesUtils.mostrarReporteJasper(parametros, "cargo.jasper", lstData, "CargoGenerado");
				System.out.println("Muestra reporte");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}	
	}
	
	public void dialogReferencia(TdmvcCorte currentCorte){			
		cargoAdjuntar=currentCorte;
		RequestContext.getCurrentInstance().execute("dialogWidget.show()");
	}
	
	public void upload() {    	
		System.out.println("Entro a upload");
		DistribucionDespatch distribucionDespatch = new DistribucionDespatch();
        if(file != null) {        	
        	if(!file.getFileName().toUpperCase().contains(".PDF"))
        	{
	            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe seleccionar un archivo con extensión PDF."));
	            return;
        	}
        	if(file.getSize()>1024000L)
        	{
	            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe seleccionar un archivo de un tamaño máximo de 1MB."));
	            return;
        	}
        	
        	System.out.println("begin upload");
            InputStream in;
			try {
				in = file.getInputstream();
				String rutaCargo=Funciones.ObtProp_Resources("ruta.cargo");
				File file = new File(rutaCargo+"/"+cargoAdjuntar.getvCodcorte()+"-"+cargoAdjuntar.getvAnocorte()+".pdf");
				//File file = new File("D://Willy//pdfcargo//"+cargoAdjuntar.getvCodcorte()+"-"+cargoAdjuntar.getvAnocorte()+".pdf");
				OutputStream out = new FileOutputStream(file);
		        byte[] buf = new byte[1024];
		        int len;
		        while((len=in.read(buf))>0){
		            out.write(buf,0,len);
		        }
		        out.close();
		        in.close();
		        System.out.println("end upload");	
		        try {
		        	cargoAdjuntar.setvObservacion(cargoAdjuntar.getvCodcorte()+"-"+cargoAdjuntar.getvAnocorte()+".pdf");
		        	distribucionDespatch.actualizarCargo(cargoAdjuntar);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
		        System.out.println("end update bd filename");
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Archivo fue subido."));
			} catch (IOException e) {
				e.printStackTrace();	            
	            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Archivo no fue subido, contactar con el administrador."));
			}
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Seleccione un archivo primero."));
        }
    }
	
	public StreamedContent download(TdmvcCorte item)
    {    	
    	InputStream stream;
		try {
			String rutaCargo=Funciones.ObtProp_Resources("ruta.cargo");
			stream = new FileInputStream(rutaCargo+"/"+item.getvCodcorte()+"-"+item.getvAnocorte()+".pdf");
			//stream = new FileInputStream("D://Willy//pdfcargo//"+item.getvCodcorte()+"-"+item.getvAnocorte()+".pdf");
			fileDownload = new DefaultStreamedContent(stream, "application/pdf", "cargo-"+item.getvCodcorte()+"-"+item.getvAnocorte()+".pdf");
			return fileDownload;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}       
    }
	
	public String getFormatHourCargo(String corte, String anio) {
		try {
			ConsultaDespatch consultaDespatch=new ConsultaDespatch();		
			Map parametros = new HashMap();
			parametros.put("PARAM_CORTE", corte);
			parametros.put("PARAM_ANIO", anio);
			return consultaDespatch.getHoraCargo(parametros);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	public String getFormatHourRegistro(VstBandejastrex registro) {
		try {
			ConsultaDespatch consultaDespatch=new ConsultaDespatch();		
			Map parametros = new HashMap();
			parametros.put("PARAM_V_NUMANOREG", registro.getvNumanoreg());
			parametros.put("PARAM_N_NUMDEP", registro.getnNumdep());
			parametros.put("PARAM_N_NUMTIPODOC", registro.getnNumtipodoc());
			parametros.put("PARAM_V_NUMREG", registro.getvNumreg());
			return consultaDespatch.getHoraRegistro(parametros);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	public String getFormatDMY()
	{
		try {
			LoginDespatch loginDespatch = new LoginDespatch();
	        return loginDespatch.ObtieneFechaDMY();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	public String getNombrePorUsername(String userName)
	{
		try {
			LoginDespatch loginDespatch = new LoginDespatch();
	        return loginDespatch.getNombrePorUsername(userName.toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	public String hisCargo(){
		fechaI=new Date();
		fechaF=new Date();
		vCodcorte=null;
		vAnocorte=null;
		lstCargo=null;
		String vista="pretty:hisCargoPretty";
        //CODIGO
        return  vista;
	}

}
