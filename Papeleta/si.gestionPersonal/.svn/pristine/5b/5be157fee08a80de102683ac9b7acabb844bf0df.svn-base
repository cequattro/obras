package pe.gob.sunafil.gestionpersonal.managedBeans;

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

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import pe.gob.sunafil.gestionpersonal.bean.Permisos;
import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.FeriadoDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonalDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.TurnoDiaDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcFerxint;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstFeriadorrhh;
import pe.gob.sunafil.gestionpersonal.utils.FacesUtils;

@ManagedBean(name = "feriadoBean")
@SessionScoped
public class FeriadoBean {
	
	private static final long serialVersionUID = 5154405390560909774L;

	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario PGP_Usuario;
	@ManagedProperty("#{loginBean.PGP_Permisos}")
	private Permisos PGP_Permisos;
	private List<VstFeriadorrhh> listaFeriados;
	private RhtbcFerxint filtro=new RhtbcFerxint();
	private Date fechaI=new Date();
	private Date fechaF=new Date();
	private RhtbcFerxint eliminarFeriado;
	private RhtbcFerxint editarFeriado= new RhtbcFerxint();
	private RhtbcFerxint nuevoFeriado=new RhtbcFerxint();
	private String selIntendenciaAdd;
	private Date fechaIAdd=new Date();
	private Date fechaFAdd=new Date();
	private boolean chkRecuperable=false;
	private String motivo;
	private List <TdtbcIntendencia> listaIntendencia;
	private List <TdtbcIntendencia> listaIntendenciaAdd;
	private static Logger logger = Logger.getLogger(MenuBean.class.getName());			
	
	public List<TdtbcIntendencia> getListaIntendenciaAdd() {
		return listaIntendenciaAdd;
	}

	public void setListaIntendenciaAdd(List<TdtbcIntendencia> listaIntendenciaAdd) {
		this.listaIntendenciaAdd = listaIntendenciaAdd;
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

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public boolean isChkRecuperable() {
		return chkRecuperable;
	}

	public void setChkRecuperable(boolean chkRecuperable) {
		this.chkRecuperable = chkRecuperable;
	}

	public Date getFechaIAdd() {
		return fechaIAdd;
	}

	public void setFechaIAdd(Date fechaIAdd) {
		this.fechaIAdd = fechaIAdd;
	}

	public Date getFechaFAdd() {
		return fechaFAdd;
	}

	public void setFechaFAdd(Date fechaFAdd) {
		this.fechaFAdd = fechaFAdd;
	}

	public String getSelIntendenciaAdd() {
		return selIntendenciaAdd;
	}

	public void setSelIntendenciaAdd(String selIntendenciaAdd) {
		this.selIntendenciaAdd = selIntendenciaAdd;
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

	public List<VstFeriadorrhh> getListaFeriados() {
		return listaFeriados;
	}

	public void setListaFeriados(List<VstFeriadorrhh> listaFeriados) {
		this.listaFeriados = listaFeriados;
	}

	public RhtbcFerxint getFiltro() {
		return filtro;
	}

	public void setFiltro(RhtbcFerxint filtro) {
		this.filtro = filtro;
	}

	public RhtbcFerxint getEliminarFeriado() {
		return eliminarFeriado;
	}

	public void setEliminarFeriado(RhtbcFerxint eliminarFeriado) {
		this.eliminarFeriado = eliminarFeriado;
	}

	public RhtbcFerxint getEditarFeriado() {
		return editarFeriado;
	}

	public void setEditarFeriado(RhtbcFerxint editarFeriado) {
		this.editarFeriado = editarFeriado;
	}

	public RhtbcFerxint getNuevoFeriado() {
		return nuevoFeriado;
	}

	public void setNuevoFeriado(RhtbcFerxint nuevoFeriado) {
		this.nuevoFeriado = nuevoFeriado;
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

	public String verFeriado() {
		String vista = "pretty:feriadosPretty";
		// CODIGO
		return vista;
	}
	
	public String nuevoFeriado(){
		limpiar();
		return verFeriado();
	}
	public void buscarFeriado()
	{
		cargarListaFeriados();
	}
	
	public void limpiar(){
		filtro= new RhtbcFerxint();
		setListaFeriados(null);
		listaIntendenciaAdd=new ArrayList<TdtbcIntendencia>();
	}		
	
	/**************************************************************
	 ****************  CODIGO PARA AGREGAR TURNO  *****************
	 **************************************************************/
	
	public void desplegarOpcionAgregar(){
		selIntendenciaAdd=null;
		fechaIAdd=new Date();
		fechaFAdd=new Date();
		chkRecuperable=false;
		motivo="";
		RequestContext.getCurrentInstance().execute("formDialogWidgetAgregar.show()");
	}
	
	public boolean validaAgregar()
	{
		if(fechaIAdd!=null)
		{			
			if((fechaIAdd).before(new Date()))
			{
				Funciones.mostrarMensajeError("La fecha del feriado no puede ser anterior a la fecha actual.");				
				return false;
			}
		}
		else
		{			
			Funciones.mostrarMensajeError("Ingrese fecha de inicio.");
			return false;
		}
		if(fechaFAdd!=null)
		{			
			if(fechaIAdd.before(fechaIAdd))
			{
				Funciones.mostrarMensajeError("La fecha fin del feriado no puede ser anterior a la fecha de inicio.");				
				return false;
			}
		}
		else
		{			
			Funciones.mostrarMensajeError("Ingrese fecha de fin.");
			return false;
		}
		if(motivo!=null && !"".equals(motivo)){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese motivo de Feriado.");				
			return false;
		}
		return true;
	}
	
	public void agregar(){
		FeriadoDespatch feriadoDespatch=new FeriadoDespatch();
		if(!validaAgregar())
		{
			return;
		}			
		try {			
			//asignar las intendencias seleccionadas
			if(selIntendenciaAdd!=null && !"".equals(selIntendenciaAdd))
			{
				for (Iterator iterator = getListaIntendencia().iterator(); iterator
						.hasNext();) {
					TdtbcIntendencia ent = (TdtbcIntendencia) iterator.next();
					if(ent.getnNumint().equals(new BigDecimal(selIntendenciaAdd)))
					{
						listaIntendenciaAdd=new ArrayList<TdtbcIntendencia>();
						listaIntendenciaAdd.add(ent);
						break;
					}
				}
			}
			else
			{
				listaIntendenciaAdd=getListaIntendencia();
			}
			
			if(fechaIAdd.equals(fechaFAdd))
			{
				for (Iterator iterator = listaIntendenciaAdd.iterator(); iterator
						.hasNext();) {
					TdtbcIntendencia entIntendencia = (TdtbcIntendencia) iterator.next();
					RhtbcFerxint nuevoFeriado=new RhtbcFerxint();
					nuevoFeriado.setnNumint(entIntendencia.getnNumint());
					String anio=getFormatDate(fechaIAdd).split("/")[2];
					String mes=getFormatDate(fechaIAdd).split("/")[1];
					String dia=getFormatDate(fechaIAdd).split("/")[0];
					nuevoFeriado.setvAnio(anio);
					nuevoFeriado.setvCodfer(anio+mes+dia);
					nuevoFeriado.setdFecfer(fechaIAdd);
					nuevoFeriado.setvFlgrec(chkRecuperable?"S":"N");
					nuevoFeriado.setvCodusureg(PGP_Usuario.getV_codusu());
					nuevoFeriado.setdFecreg(new Date());
					nuevoFeriado.setvHostreg(FacesUtils.getIpAddress());
					nuevoFeriado.setvFlgregmar("N");
					nuevoFeriado.setvMotfer(motivo.toUpperCase());
					feriadoDespatch.insertarFeriado(nuevoFeriado);					
				}
				Funciones.mostrarMensajeInfo("Feriado registrado.");
			}
			else
			{
				Calendar calendar = Calendar.getInstance();
		    	calendar.setTime(fechaIAdd);
				long diferenciaEnMs = fechaFAdd.getTime() - fechaIAdd.getTime();
	    		long diferenciaEnDias = diferenciaEnMs / (1000 * 60 * 60 * 24);
	    		for (int i = 0; i <= diferenciaEnDias; i++) {
					//calendar.getTime()
	    			for (Iterator iterator = listaIntendenciaAdd.iterator(); iterator
							.hasNext();) {
						TdtbcIntendencia entIntendencia = (TdtbcIntendencia) iterator.next();
						RhtbcFerxint nuevoFeriado=new RhtbcFerxint();
						nuevoFeriado.setnNumint(entIntendencia.getnNumint());
						String anio=getFormatDate(calendar.getTime()).split("/")[2];
						String mes=getFormatDate(calendar.getTime()).split("/")[1];
						String dia=getFormatDate(calendar.getTime()).split("/")[0];
						nuevoFeriado.setvAnio(anio);
						nuevoFeriado.setvCodfer(anio+mes+dia);
						nuevoFeriado.setdFecfer(calendar.getTime());
						nuevoFeriado.setvFlgrec(chkRecuperable?"S":"N");
						nuevoFeriado.setvCodusureg(PGP_Usuario.getV_codusu());
						nuevoFeriado.setdFecreg(new Date());
						nuevoFeriado.setvHostreg(FacesUtils.getIpAddress());
						nuevoFeriado.setvFlgregmar("N");
						nuevoFeriado.setvMotfer(motivo.toUpperCase());
						feriadoDespatch.insertarFeriado(nuevoFeriado);						
					}	    			
	    			//al final incrementar dia
	    			calendar.add(Calendar.DAY_OF_YEAR, 1);
				}
	    		Funciones.mostrarMensajeInfo("Feriados registrados.");	    		
			}			    					
		} catch (Exception e) {			
			e.printStackTrace();
			Funciones.mostrarMensajeError("Ocurrió un error registrando feriado, contacte al administrador.");
		}
		cargarListaFeriados();
		RequestContext.getCurrentInstance().execute("formDialogWidgetAgregar.hide()");
	}
	
	public void selectEliminar(VstFeriadorrhh item){
		eliminarFeriado=new RhtbcFerxint();
		eliminarFeriado.setnNumint(item.getnNumint());
		eliminarFeriado.setvAnio(item.getvAnio());
		eliminarFeriado.setvCodfer(item.getvCodfer());
		RequestContext.getCurrentInstance().execute("formDialogEliminarFeriado.show()");
	}
	
	public void eliminar()
	{
		FeriadoDespatch feriadoDespatch=new FeriadoDespatch();
		try {					
			feriadoDespatch.eliminarFeriado(eliminarFeriado);
			cargarListaFeriados();
			Funciones.mostrarMensajeInfo("Feriado fue eliminado.");			
		} catch (Exception e) {
			cargarListaFeriados();
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");			
		}
	}
	
	public String getFormatEstado(String st)
	{
		if(st!=null && !"".equals(st))
		{
			if("S".equals(st.toUpperCase()))
			{
				return "SI";
			}
			else
			{
				return "NO";
			}
		}
		else
		{
			return "";
		} 
	}
	
	public static String getFormatDate(Date date) {
		if(date!=null){
			return new SimpleDateFormat("dd/MM/yyyy").format(date);}
		else{
			return "";}
	}
	
	public void cargarListaFeriados()
	{
		FeriadoDespatch feriadoDespatch=new FeriadoDespatch();
		try {
			setListaFeriados(feriadoDespatch.getFeriados(filtro, fechaI, fechaF));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
