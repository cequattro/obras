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
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcTipopers;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodia;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEscalaremun;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargo;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocideExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDetpersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTurnopersonalrrhh;
import pe.gob.sunafil.gestionpersonal.utils.FacesUtils;
import pe.gob.sunafil.gestionpersonal.bean.Persona;
import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonaDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonaReniecDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.TurnoDespatch;
import pe.gob.sunafil.gestionpersonal.reniecws.ReniecWebService;
import pe.gob.sunafil.gestionpersonal.utils.EnviarMail;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

@ManagedBean(name = "turnoBean")
@SessionScoped
public class TurnoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5154405390560909774L;

	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario PGP_Usuario;
	@ManagedProperty("#{loginBean.PGP_Permisos}")
	private Permisos PGP_Permisos;
	private List<RhtbcTurno> listaTurno;
	private RhtbcTurno filtro=new RhtbcTurno();
	private RhtbcTurno eliminarTurno;
	private String anteriorNombre;
	private RhtbcTurno editarTurno= new RhtbcTurno();
	private RhtbcTurno nuevoTurno=new RhtbcTurno();
	private static Logger logger = Logger.getLogger(MenuBean.class.getName());
	//private Date dFecini = new Date();
	
	public RhtbcTurno getEditarTurno() {
		return editarTurno;
	}

	public void setEditarTurno(RhtbcTurno editarTurno) {
		this.editarTurno = editarTurno;
	}

	public RhtbcTurno getNuevoTurno() {
		return nuevoTurno;
	}

	public void setNuevoTurno(RhtbcTurno nuevoTurno) {
		this.nuevoTurno = nuevoTurno;
	}

	public RhtbcTurno getFiltro() {
		return filtro;
	}

	public void setFiltro(RhtbcTurno filtro) {
		this.filtro = filtro;
	}

	public List<RhtbcTurno> getListaTurno() {
		return listaTurno;
	}

	public void setListaTurno(List<RhtbcTurno> listaTurno) {
		this.listaTurno = listaTurno;
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

	public String verTurno() {
		String vista = "pretty:turnoPretty";
		// CODIGO
		return vista;
	}
	
	public String nuevoTurno(){
		limpiar();
		return verTurno();
	}
	public void buscarTurno()
	{
		/*if ((filtro.getvDesturno() == null || "".equals(filtro.getvDesturno().trim())) && (filtro.getvFlgact()==null || "".equals(filtro.getvFlgact().trim()))
				&& (filtro.getvFlgnomarca()==null || "".equals(filtro.getvFlgnomarca().trim()))){
			listaTurno = null;
			mostrarMensajeError("Debe ingresar o seleccionar al menos un criterio de búsqueda.");
			return;
		}else{
			cargarListaTurnos();
		}*/
		/*Para mostrar todo cuando no hay seleccionado ningun criterio de busqueda poner en comentarios el codigo de arriba y descomentar el codigo de abajo*/
		cargarListaTurnos();
	}
	

	public void nuevo(){}
	
	public void limpiar(){
		filtro= new RhtbcTurno();
		listaTurno=null;
	}
	
	/*****************************************************************
	 ****************  CODIGO PARA ACTUALIZAR TURNO  *****************
	 *****************************************************************/
	
	public void desplegarOpcionEditar(RhtbcTurno item){
		editarTurno=item;//turno actual
		anteriorNombre=item.getvDesturno();
		System.out.println("Anterior:"+anteriorNombre);
		RequestContext.getCurrentInstance().execute("formDialogWidgetEditar.show()");
	}
	
	public void actualizar(){
		TurnoDespatch turnoDespatch=new TurnoDespatch();
		if(algunCampoEsNulo(editarTurno)){
			return ;}
		try {
			editarTurno.setvDesturno(editarTurno.getvDesturno().toUpperCase());
			//cargarListaTurnos();
			if(!turnoDespatch.getTieneTurnoRepetidoUpdate(editarTurno.getvDesturno(),editarTurno.getnCodturno())){
				turnoDespatch.actualizarTurno(editarTurno);
				Funciones.mostrarMensajeInfo("Detalle actualizado.");		
				System.out.println("editado");
			}
			else{
				cargarListaTurnos();
				Funciones.mostrarMensajeError("Turno Repetido");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cargarListaTurnos();
		RequestContext.getCurrentInstance().execute("formDialogWidgetEditar.hide()");
		
	}
	
	/**************************************************************
	 ****************  CODIGO PARA AGREGAR TURNO  *****************
	 **************************************************************/
	
	public void desplegarOpcionAgregar(){
		nuevoTurno=new RhtbcTurno();
		RequestContext.getCurrentInstance().execute("formDialogWidgetAgregar.show()");
	}
	
	public void agregar(){
		TurnoDespatch turnoDespatch=new TurnoDespatch();
		if(algunCampoEsNulo(nuevoTurno))
			return ;
		try {
			nuevoTurno.setvDesturno(nuevoTurno.getvDesturno().toUpperCase());
			nuevoTurno.setvFlgact("S");
			if(!turnoDespatch.getTieneTurno(nuevoTurno.getvDesturno())){
			nuevoTurno.setnCodturno(new Short(getSiguienteCorrelativoGlobalPerTurno()));
			turnoDespatch.insertarTurno(nuevoTurno);	
			Funciones.mostrarMensajeInfo("Turno Agregado");
			}else{
				Funciones.mostrarMensajeError("Turno repetido");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cargarListaTurnos();
		RequestContext.getCurrentInstance().execute("formDialogWidgetAgregar.hide()");
	}
	
	/***************************************************************
	 ****************  CODIGO PARA ELIMINAR TURNO  *****************
	 ***************************************************************/
	public void selectEliminar(RhtbcTurno item){
		eliminarTurno=new RhtbcTurno();
		eliminarTurno.setvDesturno(item.getvDesturno());
		//eliminarDetTurno.setnCorper(item.getnCorper());//agregar ncorper a la vista VstDetpersonalrrhh y regenerar
		eliminarTurno=item;
		RequestContext.getCurrentInstance().execute("formDialogEliminar.show()");
	}
	
	public void eliminar()
	{
		TurnoDespatch turnoDespatch = new TurnoDespatch();
		try {					
			//eliminar detalle
			if(turnoDespatch.getTienePersonalAsignado(eliminarTurno))
			{
				Funciones.mostrarMensajeError("No se puede eliminar turno porque ha realizado movimientos.");
				return;
			}
			try {
				turnoDespatch.eliminarTurnoDia(eliminarTurno);
			} catch (Exception e) {
				e.printStackTrace();
			}
			turnoDespatch.eliminarTurno(eliminarTurno);
			//post load
			cargarListaTurnos();
			Funciones.mostrarMensajeInfo("Detalle fue eliminado.");			
		} catch (Exception e) {
			cargarListaTurnos();
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");			
		}
	}
	
	/******************************************************
	 ****************  FUNCIONES COMUNES  *****************
	 ******************************************************/
	
	private boolean algunCampoEsNulo(RhtbcTurno nuevo){
		if(nuevo.getvDesturno()!=null && !"".equals(nuevo.getvDesturno().trim())){}
		else{
			Funciones.mostrarMensajeError("Debe Escribir una Descripcion.");
			return true;
		}
		if(nuevo.getvFlgnomarca()!=null && !"".equals(nuevo.getvFlgnomarca().trim())){}
		else{
			Funciones.mostrarMensajeError("Debe Escoger una Marca.");
			return true;
		}
		return false;
	}
	

	public void cargarListaTurnos()
	{
		TurnoDespatch turnoDespatch=new TurnoDespatch();
		try {
			listaTurno=turnoDespatch.getTurnos(filtro);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	/*
	private boolean seRepite(RhtbcTurno nuevo,boolean actualizando){
		boolean seRepite=false;
		//cargarListaTurnos();
		for (Iterator iterator = listaTurno.iterator(); iterator.hasNext();) {
			RhtbcTurno rhtbcTurno = (RhtbcTurno) iterator.next();
			seRepite=iguales(rhtbcTurno,nuevo);
			if(seRepite)
			{
				System.out.println("Anterior Turno:"+anteriorNombre+"| Nuevo Turno:"+nuevo.getvDesturno());
				if(actualizando && anteriorNombre.equals(nuevo.getvDesturno()))
					seRepite=false;
				break;
			}
		}
		System.out.println("Se repite:"+seRepite);
		return seRepite;
	}*/
	/*
	private boolean iguales(RhtbcTurno primero,RhtbcTurno segundo){
	//	MostrarDatos(primero);MostrarDatos(segundo);
		if(primero.getvDesturno().equals(segundo.getvDesturno()) )
			return true;
		else
			return false;
	}*/
	
	public String getSiguienteCorrelativoGlobalPerTurno()
	{
		TurnoDespatch turnoDespatch=new TurnoDespatch();
		try {
			RhtbcTurno correlativo=turnoDespatch.getCorrelativoGlobalTurno();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCodturno()+1);
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
	
	public String mostrarEstado(String vFlgact){
    	if(vFlgact.equals("S"))
    		return "ACTIVO";
    	else
    		return "INACTIVO";
    }
    
    public String mostrarMarca(String vFlgnomarca){
    	if(vFlgnomarca.equals("S"))
    		return "SI";
    	else return "NO";
    }
	/*****************************************************************
	 ****************  CODIGO PARA MOSTRAR MENSAJES  *****************
	 *****************************************************************/

}
