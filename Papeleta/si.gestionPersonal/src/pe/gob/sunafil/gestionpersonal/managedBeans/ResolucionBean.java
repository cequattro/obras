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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.reniec.rel.ReniecBean;

import pe.gob.sunafil.gestionpersonal.bean.Permisos;
import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonalDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.TurnoDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcResolucion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTiporesol;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxseguro;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxsindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstResolucion;
import pe.gob.sunafil.gestionpersonal.utils.FacesUtils;
import pe.gob.sunafil.gestionpersonal.funciones.Funciones;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

@ManagedBean(name = "resolucionBean")
@SessionScoped
public class ResolucionBean implements Serializable {

	private static final long serialVersionUID = 9104965955194261298L;

	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario PGP_Usuario;
	@ManagedProperty("#{loginBean.PGP_Permisos}")
	private Permisos PGP_Permisos;

	private static Logger logger = Logger.getLogger(MenuBean.class.getName());	
	
	private RhtbcResolucion filtro=new RhtbcResolucion();
	private List<VstResolucion> listaResoluciones;
	
	private List <RhtbcTiporesol> listaTiposResolucion;
	private RhtbcResolucion nuevaResolucion;
	private Date dFeciniResolucion=new Date();
	private Date dFecfinResolucion=new Date();
	
	private VstResolucion eliminarResolucion;
	
	private RhtbcResolucion editarResolucion;
	private Date dFeciniResolucionE=new Date();
	private Date dFecfinResolucionE=new Date();
	
	private RhtbcResolucion adjuntarResolucion;	
	private UploadedFile file;	
	private StreamedContent fileDownload;		

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

	public RhtbcResolucion getAdjuntarResolucion() {
		return adjuntarResolucion;
	}

	public void setAdjuntarResolucion(RhtbcResolucion adjuntarResolucion) {
		this.adjuntarResolucion = adjuntarResolucion;
	}

	public RhtbcResolucion getFiltro() {
		return filtro;
	}

	public void setFiltro(RhtbcResolucion filtro) {
		this.filtro = filtro;
	}

	public List<VstResolucion> getListaResoluciones() {
		return listaResoluciones;
	}

	public void setListaResoluciones(List<VstResolucion> listaResoluciones) {
		this.listaResoluciones = listaResoluciones;
	}

	public List<RhtbcTiporesol> getListaTiposResolucion() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaTiposResolucion=personalDespatch.getTiposResolucion();
		} catch (Exception e) {
			listaTiposResolucion=null;
			e.printStackTrace();
		}
		return listaTiposResolucion;
	}

	public void setListaTiposResolucion(List<RhtbcTiporesol> listaTiposResolucion) {
		this.listaTiposResolucion = listaTiposResolucion;
	}

	public RhtbcResolucion getNuevaResolucion() {
		return nuevaResolucion;
	}

	public void setNuevaResolucion(RhtbcResolucion nuevaResolucion) {
		this.nuevaResolucion = nuevaResolucion;
	}

	public Date getdFeciniResolucion() {
		return dFeciniResolucion;
	}

	public void setdFeciniResolucion(Date dFeciniResolucion) {
		this.dFeciniResolucion = dFeciniResolucion;
	}

	public Date getdFecfinResolucion() {
		return dFecfinResolucion;
	}

	public void setdFecfinResolucion(Date dFecfinResolucion) {
		this.dFecfinResolucion = dFecfinResolucion;
	}

	public VstResolucion getEliminarResolucion() {
		return eliminarResolucion;
	}

	public void setEliminarResolucion(VstResolucion eliminarResolucion) {
		this.eliminarResolucion = eliminarResolucion;
	}

	public RhtbcResolucion getEditarResolucion() {
		return editarResolucion;
	}

	public void setEditarResolucion(RhtbcResolucion editarResolucion) {
		this.editarResolucion = editarResolucion;
	}

	public Date getdFeciniResolucionE() {
		return dFeciniResolucionE;
	}

	public void setdFeciniResolucionE(Date dFeciniResolucionE) {
		this.dFeciniResolucionE = dFeciniResolucionE;
	}

	public Date getdFecfinResolucionE() {
		return dFecfinResolucionE;
	}

	public void setdFecfinResolucionE(Date dFecfinResolucionE) {
		this.dFecfinResolucionE = dFecfinResolucionE;
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
	
	public String verResolucion() 
	{
		String vista = "pretty:resolucionPretty";
		// CODIGO
		return vista;
	}

	public String nuevaResolucion()
	{
		limpiar();
		return verResolucion();
	}
	
	public void limpiar()
	{
		filtro=new RhtbcResolucion();
		listaResoluciones=null;
	}
	
	public void buscarResolucion()
	{
		PersonalDespatch personalDespatch=new PersonalDespatch();
		try {
			listaResoluciones=personalDespatch.getResolucionesVista(filtro);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void desplegarOpcionAgregar(){
		nuevaResolucion=new RhtbcResolucion();
		RequestContext.getCurrentInstance().execute("formDialogWidgetAgregar.show()");
	}
	
	public void agregar()
	{		
		if(nuevaResolucion.getnCortipres()!=null && !(new BigDecimal("0")).equals(nuevaResolucion.getnCortipres())){}
		else
		{			
			Funciones.mostrarMensajeError("Seleccione un tipo de resolución.");
			return;
		}
		if(nuevaResolucion.getvNumres()!=null && !"".equals(nuevaResolucion.getvNumres().trim())){}
		else
		{			
			Funciones.mostrarMensajeError("Ingrese un número de resolución.");
			return;
		}
		if(nuevaResolucion.getvAnores()!=null && !"".equals(nuevaResolucion.getvAnores().trim())){}
		else
		{			
			Funciones.mostrarMensajeError("Ingrese un año de resolución.");
			return;
		}
		if(dFeciniResolucion!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniResolucion))
			{
				Funciones.mostrarMensajeError("La fecha de inicio no puede ser anterior a la fecha de creación de SUNAFIL.");				
				return;
			}
		}
		else
		{
			Funciones.mostrarMensajeError("Ingrese fecha de inicio.");			
			return;
		}
		if(dFecfinResolucion!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFecfinResolucion))
			{
				Funciones.mostrarMensajeError("La fecha de fin no puede ser anterior a la fecha de creación de SUNAFIL.");				
				return;
			}
		}
		else
		{
			Funciones.mostrarMensajeError("Ingrese fecha de fin.");			
			return;
		}
		PersonalDespatch personalDespatch=new PersonalDespatch();
		try {
			if(personalDespatch.getTieneResolucionRepetida(nuevaResolucion.getvNumres(), nuevaResolucion.getvAnores(), nuevaResolucion.getnCortipres()))
			{
				Funciones.mostrarMensajeError("Ya se ha registrado esta resolución.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		try {
			nuevaResolucion.setnCodres(new BigDecimal(getSiguienteCorrelativoResolucion()));
			nuevaResolucion.setdFecini(dFeciniResolucion);
			nuevaResolucion.setdFecfin(dFecfinResolucion);
			personalDespatch.insertarResolucion(nuevaResolucion);						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buscarResolucion();
		RequestContext.getCurrentInstance().execute("formDialogWidgetAgregar.hide()");
		Funciones.mostrarMensajeInfo("Resolución Agregada");
	}
	
	public boolean validaFechaInicioSUNAFIL(Date value)
	{
		try {
			SimpleDateFormat simpleDate=new SimpleDateFormat("dd/MM/yyyy");
			Date fechaSUNAFIL = simpleDate.parse("31/12/2013");
			return value.after(fechaSUNAFIL);
		} catch (Exception e) {
			return false;
		}		
	}
	
	public String getSiguienteCorrelativoResolucion()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			RhtbcResolucion correlativo=personalDespatch.getCorrelativoResolucion();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCodres().add(new BigDecimal(1)));
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
	
	public void selectEliminar(VstResolucion item){
		eliminarResolucion=new VstResolucion();
		eliminarResolucion=item;
		RequestContext.getCurrentInstance().execute("formDialogEliminar.show()");
	}
	
	public void eliminar()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {					
			//VALIDACIÓN DE ASIGNACIÓN DE RESOLUCIÓN
			if(personalDespatch.getEsResolucionAsignada(eliminarResolucion.getnCodres()))
			{
				Funciones.mostrarMensajeError("No se puede eliminar resolución porque se encuentra asignada a personal.");
				return;
			}
			try {
				RhtbcResolucion entidad=new RhtbcResolucion();
				entidad.setnCodres(eliminarResolucion.getnCodres());
				personalDespatch.eliminarResolucion(entidad);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//post load
			buscarResolucion();
			Funciones.mostrarMensajeInfo("Resolución fue eliminada.");
		} catch (Exception e) {
			buscarResolucion();
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");			
		}
	}
	
	public void desplegarOpcionEditar(VstResolucion item){
		editarResolucion=new RhtbcResolucion();
		editarResolucion.setnCodres(item.getnCodres());
		editarResolucion.setnCortipres(item.getnCortipres());
		editarResolucion.setvNumres(item.getvNumres());
		editarResolucion.setvAnores(item.getvAnores());
		editarResolucion.setdFecini(item.getdFecini());
		editarResolucion.setdFecfin(item.getdFecfin());	
		dFeciniResolucionE=item.getdFecini();
		dFecfinResolucionE=item.getdFecfin();
		RequestContext.getCurrentInstance().execute("formDialogWidgetEditar.show()");
	}
	
	public void actualizar()
	{
		if(editarResolucion.getnCortipres()!=null && !(new BigDecimal("0")).equals(editarResolucion.getnCortipres())){}
		else
		{			
			Funciones.mostrarMensajeError("Seleccione un tipo de resolución.");
			return;
		}
		if(editarResolucion.getvNumres()!=null && !"".equals(editarResolucion.getvNumres().trim())){}
		else
		{			
			Funciones.mostrarMensajeError("Ingrese un número de resolución.");
			return;
		}
		if(editarResolucion.getvAnores()!=null && !"".equals(editarResolucion.getvAnores().trim())){}
		else
		{			
			Funciones.mostrarMensajeError("Ingrese un año de resolución.");
			return;
		}
		if(dFeciniResolucionE!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniResolucionE))
			{
				Funciones.mostrarMensajeError("La fecha de inicio no puede ser anterior a la fecha de creación de SUNAFIL.");				
				return;
			}
		}
		else
		{
			Funciones.mostrarMensajeError("Ingrese fecha de inicio.");			
			return;
		}
		if(dFecfinResolucionE!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFecfinResolucion))
			{
				Funciones.mostrarMensajeError("La fecha de fin no puede ser anterior a la fecha de creación de SUNAFIL.");				
				return;
			}
		}
		else
		{
			Funciones.mostrarMensajeError("Ingrese fecha de fin.");			
			return;
		}
		PersonalDespatch personalDespatch=new PersonalDespatch();		
		try {			
			editarResolucion.setdFecini(dFeciniResolucionE);
			editarResolucion.setdFecfin(dFecfinResolucionE);
			personalDespatch.actualizaResolucion(editarResolucion);						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buscarResolucion();
		RequestContext.getCurrentInstance().execute("formDialogWidgetEditar.hide()");
		Funciones.mostrarMensajeInfo("Resolución actualizada.");	
	}
	
	public void dialogReferencia(VstResolucion item){		
		adjuntarResolucion=new RhtbcResolucion();
		adjuntarResolucion.setnCodres(item.getnCodres());
		if(item.getdFecfin()!=null)
		{
			adjuntarResolucion.setdFecfin(item.getdFecfin());
		}		
		RequestContext.getCurrentInstance().execute("dialogWidget.show()");
	}
	
	public void upload() {    	
		System.out.println("Entro a upload");
		PersonalDespatch personalDespatch = new PersonalDespatch();
        if(file != null) {        	
        	if(!file.getFileName().toUpperCase().contains(".PDF"))
        	{
	            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe seleccionar un archivo con extensión PDF."));
	            Funciones.mostrarMensajeError("Debe seleccionar un archivo con extensión PDF.");
	            return;
        	}
        	if(file.getSize()>1024000L)
        	{
	            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe seleccionar un archivo de un tamaño máximo de 1MB."));
	            Funciones.mostrarMensajeError("Debe seleccionar un archivo de un tamaño máximo de 1MB.");
	            return;
        	}
        	
        	System.out.println("begin upload");
            InputStream in;
			try {
				in = file.getInputstream();
				String rutaPdf=Funciones.ObtProp_Resources("ruta.pdfsresol");
				File file = new File(rutaPdf+"/"+adjuntarResolucion.getnCodres()+".pdf");
				//File file = new File("D://Willy//pdf//"+itemAdjuntar.getvNumanoreg()+"-"+itemAdjuntar.getnNumdep()+"-"+itemAdjuntar.getnNumtipodoc()+"-"+itemAdjuntar.getvNumreg()+".pdf");
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
		        	adjuntarResolucion.setvNomarchiv(adjuntarResolucion.getnCodres()+".pdf");
		        	personalDespatch.actualizaResolucion(adjuntarResolucion);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
		        buscarResolucion();
		        System.out.println("end update bd filename");
		        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Archivo fue subido."));
		        Funciones.mostrarMensajeInfo("Archivo fue subido.");
			} catch (IOException e) {
				e.printStackTrace();	            
	            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Archivo no fue subido, contactar con el administrador."));
	            Funciones.mostrarMensajeError("Archivo no fue subido, contactar con el administrador.");
			}
        }
        else
        {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Seleccione un archivo primero."));
            Funciones.mostrarMensajeError("Seleccione un archivo primero.");
        }
    }
	
	public StreamedContent download(VstResolucion item)
    {    	
    	InputStream stream;
		try {
			String rutaPdf=Funciones.ObtProp_Resources("ruta.pdfsresol");
			stream = new FileInputStream(rutaPdf+"/"+item.getvNomarchiv());			
			fileDownload = new DefaultStreamedContent(stream, "application/pdf", "registro-"+item.getvNomarchiv());
			return fileDownload;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}       
    }
	
}
