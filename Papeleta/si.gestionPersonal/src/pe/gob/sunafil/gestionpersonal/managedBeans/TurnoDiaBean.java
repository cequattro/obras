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
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.TurnoDiaDespatch;
import pe.gob.sunafil.gestionpersonal.reniecws.ReniecWebService;
import pe.gob.sunafil.gestionpersonal.utils.EnviarMail;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
@ManagedBean(name = "turnoDiaBean")
@SessionScoped
public class TurnoDiaBean implements Serializable {
	private static final long serialVersionUID = 5154405390560909774L;

	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario PGP_Usuario;
	@ManagedProperty("#{loginBean.PGP_Permisos}")
	private Permisos PGP_Permisos;
	private List<RhtbcTurnodia> listaTurnoDia;
	private RhtbcTurno turnoSeleccionado=new RhtbcTurno();
	//private RhtbcTurnodia filtro=new RhtbcTurnodia();
	private RhtbcTurnodia nuevoTurnodia =new RhtbcTurnodia();
	private String anteriorDia;
	private RhtbcTurnodia editarTurnodia =new RhtbcTurnodia();
	
	private List<RhtbcTurnodia> listaDetTurnoDia;
	private RhtbcTurnodia eliminarTurnodia;
	
	private boolean chkMarca=false;	
	private boolean chkMarcaEdit=false;
	
	public void checkedChangeMarcaEdit()
	{
		if(chkMarcaEdit)
		{
			//setear nulos aqui en caso de necesitarse
			editarTurnodia.setnHorafin(new Short("-1"));
			editarTurnodia.setnMinutofin(new Short("-1"));			
		}
		else
		{
			editarTurnodia.setnHorafin(null);
			editarTurnodia.setnMinutofin(null);
		}
	}
	
	public void checkedChangeMarca()
	{
		if(chkMarca)
		{
			//setear nulos aqui en caso de necesitarse
			nuevoTurnodia.setnHorafin(new Short("-1"));
			nuevoTurnodia.setnMinutofin(new Short("-1"));			
		}
		else
		{
			nuevoTurnodia.setnHorafin(null);
			nuevoTurnodia.setnMinutofin(null);
		}
	}

	public boolean isChkMarcaEdit() {
		return chkMarcaEdit;
	}

	public void setChkMarcaEdit(boolean chkMarcaEdit) {
		this.chkMarcaEdit = chkMarcaEdit;
	}

	public boolean isChkMarca() {
		return chkMarca;
	}

	public void setChkMarca(boolean chkMarca) {
		this.chkMarca = chkMarca;
	}

	public RhtbcTurnodia getNuevoTurnodia() {
		return nuevoTurnodia;
	}

	public void setNuevoTurnodia(RhtbcTurnodia nuevoTurnodia) {
		this.nuevoTurnodia = nuevoTurnodia;
	}
	
	public String getAnteriorDia() {
		return anteriorDia;
	}

	public void setAnteriorDia(String anteriorDia) {
		this.anteriorDia = anteriorDia;
	}

	public RhtbcTurnodia getEditarTurnodia() {
		return editarTurnodia;
	}

	public void setEditarTurnodia(RhtbcTurnodia editarTurnodia) {
		this.editarTurnodia = editarTurnodia;
	}

	public RhtbcTurnodia getEliminarTurnodia() {
		return eliminarTurnodia;
	}

	public void setEliminarTurnodia(RhtbcTurnodia eliminarTurnodia) {
		this.eliminarTurnodia = eliminarTurnodia;
	}

	public List<RhtbcTurnodia> getListaDetTurnoDia() {
		return listaDetTurnoDia;
	}

	public void setListaDetTurnoDia(List<RhtbcTurnodia> listaDetTurnoDia) {
		this.listaDetTurnoDia = listaDetTurnoDia;
	}

	private static Logger logger = Logger.getLogger(MenuBean.class.getName());
	
	

	public RhtbcTurno getTurnoSeleccionado() {
		return turnoSeleccionado;
	}

	public void setTurnoSeleccionado(RhtbcTurno turnoSeleccionado) {
		this.turnoSeleccionado = turnoSeleccionado;
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

	public List<RhtbcTurnodia> getListaTurnoDia() {
		return listaTurnoDia;
	}

	public void setListaTurnoDia(List<RhtbcTurnodia> listaTurnoDia) {
		this.listaTurnoDia = listaTurnoDia;
	}
	
	public String selectTurno(RhtbcTurno seleccionado)
	{
		turnoSeleccionado=seleccionado;
		cargarListaDetalleTurnoDia();
		String vista = "pretty:turnoDiaPretty";
		// CODIGO
		return vista;
	}
	
	/**************************************************************
	 ****************  CODIGO PARA AGREGAR TURNO  *****************
	 **************************************************************/

	/**Abre el cuadro de dialogo para agregar un turno dia*/
	public void dialogDetalleAbrir(){
		//reset detalle
		nuevoTurnodia=new RhtbcTurnodia();
		chkMarca=false;
		//dependenciaSeleccionada3 = null;
		//dFecini=new Date();
		//end reset detalle
		RequestContext.getCurrentInstance().execute("formDialogWidgetAgregarTurnoDia.show()");
	}
	
	/**Agrega un turno dia si es posible y cierra el cuadro de dialogo para agregar turno dia*/
	public void agregar(){
		
		TurnoDiaDespatch turnoDiaDespatch = new TurnoDiaDespatch();
		if(errorEnAlgunCampo(nuevoTurnodia,false))
			return;
		try {		
			nuevoTurnodia.setvDesturnodia(nuevoTurnodia.getvDesturnodia().toUpperCase());
			nuevoTurnodia.setnCodturno(turnoSeleccionado.getnCodturno());
			nuevoTurnodia.setnCodturnodia(new Short(getSiguienteCorrelativoTurnoDia(nuevoTurnodia.getvDesturnodia())));
			if(!turnoDiaDespatch.getTieneTurnoDia(nuevoTurnodia.getnCodturno(),nuevoTurnodia.getnCodturnodia())){	
			nuevoTurnodia.setvDesturnoabr(nuevoTurnodia.getvDesturnodia().substring(0, 3).toUpperCase());
			turnoDiaDespatch.insertarDetalleTurnoDia(nuevoTurnodia);	
			mostrarMensajeInfo("Turno Dia Agregado");
			}
			else{
				mostrarMensajeError("Turno Dia Repetido");
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaDetalleTurnoDia();
		RequestContext.getCurrentInstance().execute("formDialogWidgetAgregarTurnoDia.hide()");
	}
	
	/**************************************************************
	 ****************  		FIN AGREGAR TURNO  	  *****************
	 **************************************************************/
	
	
	/*****************************************************************
	 ****************  CODIGO PARA ACTUALIZAR TURNO  *****************
	 *****************************************************************/
	/*private void mensaje(RhtbcTurnodia turnodia){
		System.out.println(turnodia.toString());
	}*/
	
	/**Abre el cuadro de dialogo para Editar un Turno dia despues de haber sido seleccionado un turno dia*/
	public void desplegarOpcionEditar(RhtbcTurnodia item){
		editarTurnodia=item;//turno actual	
		chkMarcaEdit=((new Short("-1")).equals(item.getnHorafin())&&(new Short("-1")).equals(item.getnMinutofin()));
		//mostrarMensajeError("MINUTOS ini:"+item.getnMinutoini());
		RequestContext.getCurrentInstance().execute("formDialogWidgetEditar.show()");
		
	}

	/**Edita el turno seleccionado y cierra el cuadro de dialogo editar turno dia*/
	public void actualizar(){
		TurnoDiaDespatch turnoDespatch=new TurnoDiaDespatch();
		//mensaje(editarTurnodia);
		if(errorEnAlgunCampo(editarTurnodia,true))
		{
			cargarListaDetalleTurnoDia();
			return;
		}	
		else
		{
			try {
				//cargarListaDetalleTurnoDia();
				//if(!turnoDespatch.getTieneTurnoDiaRepetidoUpdate(editarTurnodia.getvDesturnodia(),editarTurnodia.getnCodturno(),editarTurnodia.getnCodturnodia())){
					turnoDespatch.actualizarTurno(editarTurnodia);
					mostrarMensajeInfo("Detalle actualizado.");		
					System.out.println("editado");
				//}
				//else{
					//mostrarMensajeError("Turno Repetido");
					//return;
				//}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cargarListaDetalleTurnoDia();
			RequestContext.getCurrentInstance().execute("formDialogWidgetEditar.hide()");
		}
		
	}
	
	/*****************************************************************
	 ****************  	  	FIN ACTUALIZAR TURNO 	 *****************
	 *****************************************************************/

	
	/***************************************************************
	 ****************  CODIGO PARA ELIMINAR TURNO  *****************
	 ***************************************************************/
	
	/**Abre el cuadro de advertencia preguntando si desea eliminar turno dia*/
	public void selectEliminar(RhtbcTurnodia item){
		eliminarTurnodia=new RhtbcTurnodia();
		eliminarTurnodia.setvDesturnodia(item.getvDesturnodia());
		//eliminarDetTurno.setnCorper(item.getnCorper());//agregar ncorper a la vista VstDetpersonalrrhh y regenerar
		eliminarTurnodia=item;
		RequestContext.getCurrentInstance().execute("formDialogEliminarTurnoDia.show()");
	}
	
	/**Eliminar el turno seleccionado y cierra el cuadro de advertencia*/
	public void eliminar()
	{
		TurnoDiaDespatch turnoDiaDespatch = new TurnoDiaDespatch();
		try {					
			//eliminar detalle	
			if(turnoDiaDespatch.getTienePersonalAsignado(eliminarTurnodia))
			{
				mostrarMensajeError("No se puede eliminar día porque ha realizado movimientos.");
				return;
			}
			turnoDiaDespatch.eliminarTurnoDia(eliminarTurnodia);
			//post load
			cargarListaDetalleTurnoDia();
			//mostrarMensajeInfo("Detalle fue eliminado.");			
		} catch (Exception e) {
			cargarListaDetalleTurnoDia();
			//mostrarMensajeError("Hubo problemas con la eliminación.");			
		}
	}
	
	/***************************************************************
	 ****************  	   FIN ELIMINAR TURNO  	   *****************
	 ***************************************************************/
	
	
	/******************************************************
	 ****************  FUNCIONES COMUNES  *****************
	 ******************************************************/
	
	/**Compara el dia que se va agregar con los dias en la lista para verificar que no se repita alguno*/
	/*private boolean seRepite(RhtbcTurnodia nuevo,boolean actualizando){
		boolean seRepite=false;
		//cargarListaTurnos();
		for (Iterator iterator = listaTurnoDia.iterator(); iterator.hasNext();) {
			RhtbcTurnodia rhtbcTurno = (RhtbcTurnodia) iterator.next();
			seRepite=iguales(rhtbcTurno,nuevo);
			if(seRepite)
			{
				if(actualizando && anteriorDia.equals(nuevo.getvDesturnodia()))
					seRepite=false;
				break;
			}
		}
		System.out.println("Se repite:"+seRepite);
		return seRepite;
	}*/
	
	/**Compara un dia con otro*/
	/*
	private boolean iguales(RhtbcTurnodia primero,RhtbcTurnodia segundo){
		//	MostrarDatos(primero);MostrarDatos(segundo);
			if(primero.getvDesturnodia().toUpperCase().equals(segundo.getvDesturnodia().toUpperCase()) )
				return true;
			else
				return false;
		}*/
	/**Estos metodos ya no son necesarios por que se esta usando el metodo getSiguienteCorrelativoTurnoDia
	 * Pero se podrian modificar para que funcionen comparando otros elementos no solo dias*/
	
	/**Muestra la lista de turnos dia*/
	public void cargarListaDetalleTurnoDia()
	{
		TurnoDiaDespatch turnoDiaDespatch=new TurnoDiaDespatch();
		try {
			listaTurnoDia=turnoDiaDespatch.getTurnosDia(turnoSeleccionado.getnCodturno());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**Compara el dia que se va agregar con la lista de dias usados para verificar que no se repita alguno*/
	public String getSiguienteCorrelativoTurnoDia(String dia)
	{
		Map dias = new HashMap();			
		dias.put("LUNES", "1");			
		dias.put("MARTES", "2");
		dias.put("MIERCOLES", "3");
		dias.put("JUEVES", "4");
		dias.put("VIERNES", "5");
		dias.put("SABADO", "6");
		dias.put("DOMINGO", "7");
		return dias.get(dia).toString();
		
		/*TurnoDiaDespatch turnoDiaDespatch=new TurnoDiaDespatch();
		try {
			RhtbcTurnodia correlativo=turnoDiaDespatch.getCorrelativoTurnoDia(nCodturno);
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCodturnodia()+1);
			}
			else
			{
				//devuelve correlativo en 1				
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}			*/	
	}
	/**Verifica que lo escrito en el campo dia pertenezca a un dia de la semana
	 * Ya no es necesario porque se usa un combo box que solo permite poner dias validos*/
	/*private boolean diaValido(RhtbcTurnodia nuevo){
		if(nuevo.getvDesturnodia()!=null)
			if(diaValido(nuevo.getvDesturnodia()))
				return true;
		else
			mostrarMensajeError("Dia no Seleccionado");
			
		return false;
	}
	private boolean diaValido(String dia){
		if("LUNES".equals(dia.toUpperCase().trim()))
			return true;
		if("MARTES".equals(dia.toUpperCase().trim()))
			return true;
		if("MIERCOLES".equals(dia.toUpperCase().trim()))
			return true;
		if("JUEVES".equals(dia.toUpperCase().trim()))
			return true;
		if("VIERNES".equals(dia.toUpperCase().trim()))
			return true;
		if("SABADO".equals(dia.toUpperCase().trim()))
			return true;
		if("DOMINGO".equals(dia.toUpperCase().trim()))
			return true;
		return false;
	}*/
	
	/**Retornara true indicando que existe un error numerico 
	 * en caso el numero entrante sea menor que el minimo permitido o que sea mayor que el maximo permitido
	 * El minimo y maximo permitido dependera del campo opcion: tolerancia, horaFinal, minutos, horaInicial*/
	private boolean errorNumerico(Short numero,int opcion){
		short /*minimo=-1,*/maximo;
		switch (opcion) {
			case 1://Tolerancia
				maximo=30;
				break;
			case 2://Hora Final
				maximo=24;
				break;
			case 3://minutos
				maximo=60;
				break;
			case 4://Hora Inicial
				maximo=23;
				break;
		default:
			maximo=0;
			break;
		}
		if(numero>=maximo /*|| numero<=minimo*/)
			return true;
		else
			return false;
	}
	private boolean errorNumericoFinal(Short numero,int opcion){
		short minimo=-1,maximo;
		switch (opcion) {
			case 1://Tolerancia
				minimo=0;
				maximo=30;
				break;
			case 2://Hora Final
				minimo=-1;
				maximo=24;
				break;
			case 3://minutos
				minimo=-1;
				maximo=60;
				break;
			case 4://Hora Inicial
				minimo=0;
				maximo=23;
				break;
		default:
			maximo=0;
			break;
		}
		if(numero>=maximo || numero<minimo)
			return true;
		else
			return false;
	}
	/**ya no se usa minimo porque el script returnSolonumero  no permite el ingreso de -*/
	
	
	/**Retornara true indicando error en algun campo 
	 * si alguno de los campos horaInicio, minutoInicio, horaFin, minutoFin o tolerancia 
	 * no son validos*/
	private boolean errorEnAlgunCampo(RhtbcTurnodia nuevo,boolean actualizando){
		
		//if(!diaValido(nuevo))return true;
		if(!horasValidasInicio(nuevo))return true;
		if(!minutosValidosInicio(nuevo))return true;
		if(!horasValidasFin(nuevo))return true;
		if(!(new Short("-1")).equals(nuevo.getnHorafin()))
		{
			System.out.println("Entrooooooooo ::::");
			if(!horaFinMayorHoraInicio(nuevo.getnHoraini(),nuevo.getnHorafin())) return true;
		}		
		if(!minutosValidosFin(nuevo))return true;
		if(!toleranciaValida(nuevo)) return true;
		return false;
	}
	
	
	/**Verifica que la hora de fin sea mayor que la hora de inicio en caso contrario devolvera false y mostrara un mensaje*/
	private boolean horaFinMayorHoraInicio(Short horaInicio, Short horaFin){
		if(horaFin>horaInicio){
			
				return true;
			}
		else
		{
			mostrarMensajeError("La Hora de inicio no puede ser mayor o igual a la Hora de Fin");
			return false;
		}
	}
	
	/**Verifica que la tolerancia sea valida que no sea nula y que no sea menor del minimo permitido y no pase del maximo permitido */
	private boolean toleranciaValida(RhtbcTurnodia nuevo){
		if(nuevo.getnTolerancia()!=null){
			if(errorNumerico(nuevo.getnTolerancia(),1)){
				mostrarMensajeError("La tolerancia debe ser un maximo de 30 minutos");
				return false;
			}else return true;
		}
		else{
			mostrarMensajeError("Debe Escribir una Tolerancia.");
			return true;
		}
	}

	/**Verifica que la hora de Inicio sea valida que no sea nula y que no sea menor del minimo permitido y no pase del maximo permitido */
	private boolean horasValidasInicio(RhtbcTurnodia nuevo) {
		// TODO Auto-generated method stub
		if(nuevo.getnHoraini()!=null ){
			
			if(errorNumerico(nuevo.getnHoraini(),4)){
				mostrarMensajeError("Debe escribir una Hora de Inicio de 0 - 22");
				return false;
			}else 
				return true;
		}
		else{
			mostrarMensajeError("Debe Escribir una Hora de Inicio.");
			return false;
		}
	}
	
	/**Verifica que el minuto de Inicio sea valido que no sea nulo y que no sea menor del minimo permitido y no pase del maximo permitido */
	private boolean minutosValidosInicio(RhtbcTurnodia nuevo){
		if(nuevo.getnMinutoini()!=null ){
			if(errorNumerico(nuevo.getnMinutoini(),3)){
				mostrarMensajeError("Debe escribir una cantidad de minutos de Inicio de 0-59");
				return false;
			}
			else return true;
		}
		else{
			mostrarMensajeError("Debe Escribir una cantidad de minutos de Inicio.");
			return false;
		}
	}
	
	/**Verifica que el minuto de Fin sea valido que no sea nulo y que no sea menor del minimo permitido y no pase del maximo permitido */
	private boolean minutosValidosFin(RhtbcTurnodia nuevo){
		if(nuevo.getnMinutofin()!=null ){
			//mostrarMensajeInfo("Minutos Validos Fin"+nuevo.getnMinutofin());
			if(errorNumericoFinal(nuevo.getnMinutofin(),3)){
				mostrarMensajeError("Debe escribir una cantidad de minutos de Fin de 0-59");
				return false;
			}
			else {
				
				return true;}
		}
		else{
			mostrarMensajeError("Debe Escribir una cantidad de minutos de fin.");
			return false;
		}
	}
	public String completarConCeros(Short numero){
    	if(numero!=null){
    		String num=""+numero;
    		for(int i=num.length();i<2;i++)
    			num="0"+num;
    		return num;
    	}
    	else 
    		return "nulo";
    }
	
	/**Verifica que la hora de fin sea valida que no sea nula y que no sea menor del minimo permitido y no pase del maximo permitido */
	private boolean horasValidasFin(RhtbcTurnodia nuevo){
		if(nuevo.getnHorafin()!=null ){
			if(errorNumericoFinal(nuevo.getnHorafin(),2)){
				mostrarMensajeError("Debe escribir una Hora de Fin de 0 - 23");
				return false;
				}
			else return true;
		}
		else{
			mostrarMensajeError("Debe Escribir una Hora de Fin.");
			return false;
		}
	}
	
	/**********************************************************
	 ****************  FIN FUNCIONES COMUNES  *****************
	 **********************************************************/
	
	
	/*****************************************************************
	 ****************  CODIGO PARA MOSTRAR MENSAJES  *****************
	 *****************************************************************/
	
	public void mostrarMensajeInfo(String msg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public void mostrarMensajeError(String msg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}
	
	/*****************************************************************
	 ****************  		FIN MOSTRAR MENSAJES  	 *****************
	 *****************************************************************/
}
