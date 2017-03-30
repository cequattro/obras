package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import pe.gob.sunafil.gestionpersonal.bean.Permisos;
import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.CargosDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargo;

@ManagedBean(name = "cargosBean")
@SessionScoped
public class CargosBean {
	
	private static final long serialVersionUID = 5154405390560909774L;

	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario PGP_Usuario;
	@ManagedProperty("#{loginBean.PGP_Permisos}")
	private Permisos PGP_Permisos;
	private List<SitbPercargo> listaCargos;
	private SitbPercargo filtro=new SitbPercargo();
	private SitbPercargo eliminarCargo;
	private String anteriorDescripcion;
	private SitbPercargo editarCargo= new SitbPercargo();
	private SitbPercargo nuevoCargo=new SitbPercargo();
	private static Logger logger = Logger.getLogger(MenuBean.class.getName());
	//private Date dFecini = new Date();
	
	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public SitbPercargo getFiltro() {
		return filtro;
	}

	public void setFiltro(SitbPercargo filtro) {
		this.filtro = filtro;
	}

	public SitbPercargo getEliminarCargo() {
		return eliminarCargo;
	}

	public void setEliminarCargo(SitbPercargo eliminarCargo) {
		this.eliminarCargo = eliminarCargo;
	}

	public String getAnteriorDescripcion() {
		return anteriorDescripcion;
	}

	public void setAnteriorDescripcion(String anteriorDescripcion) {
		this.anteriorDescripcion = anteriorDescripcion;
	}

	public SitbPercargo getEditarCargo() {
		return editarCargo;
	}

	public void setEditarCargo(SitbPercargo editarCargo) {
		this.editarCargo = editarCargo;
	}

	public SitbPercargo getNuevoCargo() {
		return nuevoCargo;
	}

	public void setNuevoCargo(SitbPercargo nuevoCargo) {
		this.nuevoCargo = nuevoCargo;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		CargosBean.logger = logger;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String verCargo() {
		String vista = "pretty:cargosPretty";
		// CODIGO
		return vista;
	}
	
	public String nuevoCargo(){
		limpiar();
		return verCargo();
	}
	public void buscarCargo()
	{
		cargarListaCargos();
	}
	
	public void limpiar(){
		filtro= new SitbPercargo();
		setListaCargos(null);
	}
	
	/*****************************************************************
	 ****************  CODIGO PARA ACTUALIZAR TURNO  *****************
	 *****************************************************************/
	
	public void desplegarOpcionEditar(SitbPercargo item){
		editarCargo=item;//turno actual
		anteriorDescripcion=item.getvDescargo();
		System.out.println("Anterior:"+anteriorDescripcion);
		RequestContext.getCurrentInstance().execute("formDialogWidgetEditar.show()");
	}
	
	public void actualizar(){
		CargosDespatch cargosDespatch=new CargosDespatch();
		if(nombreCargoEsNulo(editarCargo) || estadoEsNulo(editarCargo)){
			return ;}
		try {
			editarCargo.setvNomcargo(editarCargo.getvNomcargo().toUpperCase());
			//cargarListaTurnos();
			if(!cargosDespatch.getTieneCargoRepetidoUpdate(editarCargo.getvNomcargo(),editarCargo.getvCodcargo()))
			{
				cargosDespatch.actualizarCargo(editarCargo);
				Funciones.mostrarMensajeInfo("Cargo actualizado.");		
				System.out.println("editado");
			}
			else{
				cargarListaCargos();
				Funciones.mostrarMensajeError("Cargo Repetido");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cargarListaCargos();
		RequestContext.getCurrentInstance().execute("formDialogWidgetEditar.hide()");
		
	}
	
	/**************************************************************
	 ****************  CODIGO PARA AGREGAR TURNO  *****************
	 **************************************************************/
	
	public void desplegarOpcionAgregar(){
		nuevoCargo=new SitbPercargo();
		RequestContext.getCurrentInstance().execute("formDialogWidgetAgregar.show()");
	}
	
	public void agregar(){
		CargosDespatch cargosDespatch=new CargosDespatch();
		if(nombreCargoEsNulo(nuevoCargo))
			return ;
		try {
			nuevoCargo.setvNomcargo(nuevoCargo.getvNomcargo().toUpperCase());
			nuevoCargo.setvFlgact("1");
			if(!cargosDespatch.getTieneCargo(nuevoCargo.getvNomcargo())){
			nuevoCargo.setvCodcargo(getSiguienteCorrelativoGlobalPerCargo());
			nuevoCargo.setvDescargo(nuevoCargo.getvNomcargo());
			cargosDespatch.insertarCargo(nuevoCargo);	
			Funciones.mostrarMensajeInfo("Cargo Agregado");
			}else{
				Funciones.mostrarMensajeError("Cargo repetido");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cargarListaCargos();
		RequestContext.getCurrentInstance().execute("formDialogWidgetAgregar.hide()");
	}
	
	/***************************************************************
	 ****************  CODIGO PARA ELIMINAR TURNO  *****************
	 ***************************************************************/
	/*public void selectEliminar(RhtbcTurno item){
		eliminarCargo=new RhtbcTurno();
		eliminarCargo.setvDesturno(item.getvDesturno());
		//eliminarDetTurno.setnCorper(item.getnCorper());//agregar ncorper a la vista VstDetpersonalrrhh y regenerar
		eliminarCargo=item;
		RequestContext.getCurrentInstance().execute("formDialogEliminar.show()");
	}
	
	public void eliminar()
	{
		TurnoDespatch turnoDespatch = new TurnoDespatch();
		try {					
			//eliminar detalle
			if(turnoDespatch.getTienePersonalAsignado(eliminarCargo))
			{
				Funciones.mostrarMensajeError("No se puede eliminar turno porque ha realizado movimientos.");
				return;
			}
			try {
				turnoDespatch.eliminarTurnoDia(eliminarCargo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			turnoDespatch.eliminarTurno(eliminarCargo);
			//post load
			cargarListaCargos();
			Funciones.mostrarMensajeInfo("Detalle fue eliminado.");			
		} catch (Exception e) {
			cargarListaCargos();
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");			
		}
	}*/
	
	/******************************************************
	 ****************  FUNCIONES COMUNES  *****************
	 ******************************************************/
	
	private boolean nombreCargoEsNulo(SitbPercargo nuevo){
		if(nuevo.getvNomcargo()!=null && !"".equals(nuevo.getvNomcargo().trim())){}
		else{
			Funciones.mostrarMensajeError("Debe Ingresar un Nombre de Cargo.");
			return true;
		}
		return false;
	}
	
	private boolean estadoEsNulo(SitbPercargo nuevo){
		if(nuevo.getvFlgact()!=null && !"".equals(nuevo.getvFlgact().trim())){}
		else{
			Funciones.mostrarMensajeError("Debe Seleccionar un Estado.");
			return true;
		}
		return false;
	}
	
	public void cargarListaCargos()
	{
		CargosDespatch cargosDespatch=new CargosDespatch();
		try {
			setListaCargos(cargosDespatch.getCargos(filtro));
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
	
	public String getSiguienteCorrelativoGlobalPerCargo()
	{
		CargosDespatch cargosDespatch=new CargosDespatch();
		try {
			SitbPercargo correlativo=cargosDespatch.getCorrelativoGlobalCargo();
			if(correlativo!=null)
			{
				return ""+(Integer.parseInt(correlativo.getvCodcargo())+1);
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
		Funciones.imprimir("ESTADO:"+vFlgact);
    	if(vFlgact.equals("1"))
    		return "ACTIVO";
    	else
    		return "INACTIVO";
    }
    
	public List<SitbPercargo> getListaCargos() {
		return listaCargos;
	}

	public void setListaCargos(List<SitbPercargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

}
