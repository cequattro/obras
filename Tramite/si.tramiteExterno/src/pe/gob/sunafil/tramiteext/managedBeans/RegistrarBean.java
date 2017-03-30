package pe.gob.sunafil.tramiteext.managedBeans; 

import java.io.IOException;
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

import net.sf.jasperreports.engine.JRException;

import org.apache.axis.AxisFault;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.reniec.rel.ReniecBean;

import com.sun.servicetag.RegistrationData;

import pe.gob.sunafil.tramiteext.bean.Persona;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.ConsultaDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.LoginDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.PersonaDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.PersonaReniecDespatch;
import pe.gob.sunafil.tramiteext.utils.EnviarMail;
import pe.gob.sunafil.tramiteext.utils.FacesUtils;
import pe.gob.sunafil.tramiteext.reniecws.ReniecWebService;
import pe.gob.sunafil.tramiteext.siit.persistence.model.VstSiitToTramite;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.CombosDespatch;
import pe.gob.sunafil.tramiteext.bean.AsociacionPorPersona;
import pe.gob.sunafil.tramiteext.bean.Combo;
import pe.gob.sunafil.tramiteext.bean.Usuario;
import pe.gob.sunafil.tramiteext.funciones.Funciones;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.RegistrarDespatch;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocide;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcHojarutaKey;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbComisiones;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbCongresistas;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcCargocongres;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcCorrelativo;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTipodoctramite;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTramite;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdCentrolab;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdTupa;
import pe.gob.sunafil.tramiteext.persistence.model.VstDireccionestrex;
import pe.client.*;
import pe.gob.sunat.servicio2.registro.consultaruc.bean.BeanDdp;

@ManagedBean(name="registrarBean")
@SessionScoped
public class RegistrarBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8691986714514097003L;

	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;	

	private static Logger logger = Logger.getLogger(RegistrarBean.class.getName());	
	private List <SitbTdocide> listaTipoDoc;
	private List <TdtbcTipodoctramite> listaTipoDocTra;
	private String v_coddep;
	private String v_codpro;
	private String v_coddis;
	private List<Combo> listaProvincias;
	private List<Combo> listaDistritos;	
	private CombosDespatch dspcombos = new CombosDespatch();
	private String txt1;
	private List <TdtbcTramite> listaTipoTramite;
	private List <TdtbcDependencia> listaDependencia;
	private List <TdtbcIntendencia> listaIntendencia;
	private List <TdtbdTupa> listaProcedimiento;	
	private String tupa;
	private String tupaDes;	
	private boolean mostrarReq=false;	
	private TdtbdTupa tupaSeleccionado;
	private List <TdtbdTupa> listaProcedimientoPopUp;
	private String codTupaPopUp;
	private String desTupaPopUp;
	private List <TdtbcDependencia> dependenciasAutocomplete;
	private TdtbcDependencia dependenciaSeleccionada;
	private List <TdtbdReqtupa> requisitosTupaSeleccionado;
	private String[] selectedDependencias;
	private String tipoDoc;
	private String nroDoc;
	private String apellidoPat;	
	private String apellidoMat;	
	private String nombres;
	private String razonSocial;
	private boolean esDNI=false;	
	private boolean esRUC=false;
	private boolean valRuc=false;
	private boolean mostrarMensaje=false;
	private boolean mostrarMensajeAzul=false;
	private boolean mostrarMensajeRojo=false;
	private String nroRuc;
	private TdtbcEntidad entidadSeleccionada;
	private BeanDdp datosRUC;
	private PersonaDespatch pd;
	private List <AsociacionPorPersona> asociacionPorPersona;
	private String hruta0;	
	private String hruta1;
	//private List <AsociacionPorPersona> asociacionPorHR;
	private List <Map> asociacionPorHR;
	private String hojaHR;
	private String anioHR;
	private List <VstSiitToTramite> asociacionPorInspeccion;
	private String ordInsNro;
	private String ordInsAnio;
	private String actInsNro;
	private String actInsAnio;
	private String expSanNro;
	private String expSanAnio;
	private String res1erNro;
	private String res1erAnio;
	private String res2daNro;
	private String res2daAnio;
	private boolean esGrabar=false;
	private String prioridad;
	private String tipoDocRegistro;
	private String nroDocRegistro;
	private String nroFolios;
	private String observaciones;
	private String asunto;
	private String direccion;
	private TdtbdCentrolab direccionSeleccionada;
	private String tipoDoc2;
	private boolean mostrarFieldsTupa=false;
	private boolean mostrarCongresales=false;
	private int[] reqChoice;
	//private List <TdtbdCentrolab> direccionesEntSeleccionada;
	private List <VstDireccionestrex> direccionesEntSeleccionada;
	private boolean hayDirecciones=false;
	private String direccionCombo;
	private String mensajeValida;
	private TdmvcRegistro registroGuardado;
	private List <TdtbdReqtupa> requisitosTupaPendientes;
	private boolean hayRegEntidadManual=false;
	private String rsPopUp;
	private List <TdtbcEntidad> listaEmpresaPopUp;
	private String horaRegistro;
	private String mensaje="";
	private boolean hayActEntidadManual=false;	
	
	//INI PARA LOS DOCUMENTOS CONGRESALES:
	private String codcom;
	private String codcong;
	private String codcargocong;
	private boolean oficialMayor=false;
	private String v_tipoOrigCongr;//Tipo de Origen Congresal CONGR:CONGRESISTA COMIS:COMISION
	private boolean mostrarCongresistas=false;
	private boolean mostrarComisiones=false;
	private List <TdtbComisiones> listaComisiones;
	private List <TdtbCongresistas> listaCongresistas;
	private List <TdtbcCargocongres> listaCargosCongresales;
	//FIN PARA LOS DOCUMENTOS CONGRESALES
	
	
	//****************************************************************
	//INI GET SET CONGRESALES
	//****************************************************************		
	
	public List<TdtbComisiones> getListaComisiones() {
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {			
			if(listaComisiones==null){
				System.out.println("Obteniendo las comisiones =>");
				listaComisiones=registrarDespatch.getListaComisiones();
			}
		} catch (Exception e) {
			listaComisiones=null;
			logger.warn("No se obtuvo la lista de comisiones");
		}
		
		return listaComisiones;
	}

	public boolean isOficialMayor() {
		return oficialMayor;
	}

	public void setOficialMayor(boolean oficialMayor) {
		this.oficialMayor = oficialMayor;
	}

	public String getCodcargocong() {
		return codcargocong;
	}

	public void setCodcargocong(String codcargocong) {
		this.codcargocong = codcargocong;
	}

	public List<TdtbcCargocongres> getListaCargosCongresales() {
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {			
			if(listaCargosCongresales==null){
				System.out.println("Obteniendo los cargos congresales =>");
				listaCargosCongresales=registrarDespatch.getCargosCongresales();
			}
		} catch (Exception e) {
			listaCargosCongresales=null;
			logger.warn("No se obtuvo la lista de cargos congresales");
		}		
		return listaCargosCongresales;
	}

	public void setListaCargosCongresales(
			List<TdtbcCargocongres> listaCargosCongresales) {
		this.listaCargosCongresales = listaCargosCongresales;
	}

	public void setListaComisiones(List<TdtbComisiones> listaComisiones) {
		this.listaComisiones = listaComisiones;
	}

	public List<TdtbCongresistas> getListaCongresistas() {
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {			
			if(listaCongresistas==null){
				System.out.println("Obteniendo los congresistas =>");
				listaCongresistas=registrarDespatch.getListaCongresistas();
			}
		} catch (Exception e) {
			listaCongresistas=null;
			logger.warn("No se obtuvo la lista de congresistas");
		}
		return listaCongresistas;
	}

	public void setListaCongresistas(List<TdtbCongresistas> listaCongresistas) {
		this.listaCongresistas = listaCongresistas;
	}
	
	public String getCodcom() {
		return codcom;
	}
	
	public void setCodcom(String codcom) {
		this.codcom = codcom;
	}

	public String getCodcong() {
		return codcong;
	}

	public void setCodcong(String codcong) {
		this.codcong = codcong;
	}
	
	/**
	 * Tipo de Origen Congresal 
	 * @return String, devuelve CONGR si es CONGRESISTA o COMIS si esCOMISION
	 */
	public String getV_tipoOrigCongr() {
		return v_tipoOrigCongr;
	}

	public void setV_tipoOrigCongr(String v_tipoOrigCongr) {
		this.v_tipoOrigCongr = v_tipoOrigCongr;
	}

	public boolean isMostrarCongresistas() {
		return mostrarCongresistas;
	}

	public void setMostrarCongresistas(boolean mostrarCongresistas) {
		this.mostrarCongresistas = mostrarCongresistas;
	}

	public boolean isMostrarComisiones() {
		return mostrarComisiones;
	}

	public void setMostrarComisiones(boolean mostrarComisiones) {
		this.mostrarComisiones = mostrarComisiones;
	}

	
	public boolean isMostrarCongresales() {
		return mostrarCongresales;
	}
	
	public void setMostrarCongresales(boolean mostrarCongresales) {
		this.mostrarCongresales = mostrarCongresales;
	}
	
	//****************************************************************
	//FIN GET SET CONGRESALES
	//****************************************************************
	
	public boolean isHayActEntidadManual() {
		return hayActEntidadManual;
	}

	public void setHayActEntidadManual(boolean hayActEntidadManual) {
		this.hayActEntidadManual = hayActEntidadManual;
	}

	public String getHoraRegistro() {
		return horaRegistro;
	}

	public void setHoraRegistro(String horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	public List<TdtbcEntidad> getListaEmpresaPopUp() {
		return listaEmpresaPopUp;
	}

	public void setListaEmpresaPopUp(List<TdtbcEntidad> listaEmpresaPopUp) {
		this.listaEmpresaPopUp = listaEmpresaPopUp;
	}

	public String getRsPopUp() {
		return rsPopUp;
	}

	public void setRsPopUp(String rsPopUp) {
		this.rsPopUp = rsPopUp;
	}

	public boolean isHayRegEntidadManual() {
		return hayRegEntidadManual;
	}

	public void setHayRegEntidadManual(boolean hayRegEntidadManual) {
		this.hayRegEntidadManual = hayRegEntidadManual;
	}

	public List<TdtbdReqtupa> getRequisitosTupaPendientes() {
		return requisitosTupaPendientes;
	}

	public void setRequisitosTupaPendientes(
			List<TdtbdReqtupa> requisitosTupaPendientes) {
		this.requisitosTupaPendientes = requisitosTupaPendientes;
	}

	public TdmvcRegistro getRegistroGuardado() {
		return registroGuardado;
	}

	public void setRegistroGuardado(TdmvcRegistro registroGuardado) {
		this.registroGuardado = registroGuardado;
	}

	public String getMensajeValida() {
		return mensajeValida;
	}

	public void setMensajeValida(String mensajeValida) {
		this.mensajeValida = mensajeValida;
	}

	public String getDireccionCombo() {
		return direccionCombo;
	}

	public void setDireccionCombo(String direccionCombo) {
		this.direccionCombo = direccionCombo;
	}

	public boolean isHayDirecciones() {
		return hayDirecciones;
	}

	public void setHayDirecciones(boolean hayDirecciones) {
		this.hayDirecciones = hayDirecciones;
	}

	public List<VstDireccionestrex> getDireccionesEntSeleccionada() {
		return direccionesEntSeleccionada;
	}

	public void setDireccionesEntSeleccionada(
			List<VstDireccionestrex> direccionesEntSeleccionada) {
		this.direccionesEntSeleccionada = direccionesEntSeleccionada;
	}

	public int[] getReqChoice() {
		return reqChoice;
	}

	public void setReqChoice(int[] reqChoice) {
		this.reqChoice = reqChoice;
	}

	public boolean isMostrarFieldsTupa() {
		return mostrarFieldsTupa;
	}

	public void setMostrarFieldsTupa(boolean mostrarFieldsTupa) {
		this.mostrarFieldsTupa = mostrarFieldsTupa;
	}

	public String getTipoDoc2() {
		return tipoDoc2;
	}

	public void setTipoDoc2(String tipoDoc2) {
		this.tipoDoc2 = tipoDoc2;
	}

	public TdtbdCentrolab getDireccionSeleccionada() {
		return direccionSeleccionada;
	}

	public void setDireccionSeleccionada(TdtbdCentrolab direccionSeleccionada) {
		this.direccionSeleccionada = direccionSeleccionada;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getNroFolios() {
		return nroFolios;
	}

	public void setNroFolios(String nroFolios) {
		this.nroFolios = nroFolios;
	}

	public String getNroDocRegistro() {
		return nroDocRegistro;
	}

	public void setNroDocRegistro(String nroDocRegistro) {
		this.nroDocRegistro = nroDocRegistro;
	}

	public String getTipoDocRegistro() {
		return tipoDocRegistro;
	}

	public void setTipoDocRegistro(String tipoDocRegistro) {
		this.tipoDocRegistro = tipoDocRegistro;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public boolean isEsGrabar() {
		return esGrabar;
	}

	public void setEsGrabar(boolean esGrabar) {
		this.esGrabar = esGrabar;
	}

	public String getOrdInsNro() {
		return ordInsNro;
	}

	public void setOrdInsNro(String ordInsNro) {
		this.ordInsNro = ordInsNro;
	}

	public String getOrdInsAnio() {
		return ordInsAnio;
	}

	public void setOrdInsAnio(String ordInsAnio) {
		this.ordInsAnio = ordInsAnio;
	}

	public String getActInsNro() {
		return actInsNro;
	}

	public void setActInsNro(String actInsNro) {
		this.actInsNro = actInsNro;
	}

	public String getActInsAnio() {
		return actInsAnio;
	}

	public void setActInsAnio(String actInsAnio) {
		this.actInsAnio = actInsAnio;
	}

	public String getExpSanNro() {
		return expSanNro;
	}

	public void setExpSanNro(String expSanNro) {
		this.expSanNro = expSanNro;
	}

	public String getExpSanAnio() {
		return expSanAnio;
	}

	public void setExpSanAnio(String expSanAnio) {
		this.expSanAnio = expSanAnio;
	}

	public String getRes1erNro() {
		return res1erNro;
	}

	public void setRes1erNro(String res1erNro) {
		this.res1erNro = res1erNro;
	}

	public String getRes1erAnio() {
		return res1erAnio;
	}

	public void setRes1erAnio(String res1erAnio) {
		this.res1erAnio = res1erAnio;
	}

	public String getRes2daNro() {
		return res2daNro;
	}

	public void setRes2daNro(String res2daNro) {
		this.res2daNro = res2daNro;
	}

	public String getRes2daAnio() {
		return res2daAnio;
	}

	public void setRes2daAnio(String res2daAnio) {
		this.res2daAnio = res2daAnio;
	}	
	
	public List<VstSiitToTramite> getAsociacionPorInspeccion() {
		return asociacionPorInspeccion;
	}

	public void setAsociacionPorInspeccion(
			List<VstSiitToTramite> asociacionPorInspeccion) {
		this.asociacionPorInspeccion = asociacionPorInspeccion;
	}

	public String getHojaHR() {
		return hojaHR;
	}

	public void setHojaHR(String hojaHR) {
		this.hojaHR = hojaHR;
	}

	public String getAnioHR() {
		return anioHR;
	}

	public void setAnioHR(String anioHR) {
		this.anioHR = anioHR;
	}	
	
	public List<Map> getAsociacionPorHR() {
		return asociacionPorHR;
	}

	public void setAsociacionPorHR(List<Map> asociacionPorHR) {
		this.asociacionPorHR = asociacionPorHR;
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
	
	public List<AsociacionPorPersona> getAsociacionPorPersona() {
		return asociacionPorPersona;
	}

	public void setAsociacionPorPersona(
			List<AsociacionPorPersona> asociacionPorPersona) {
		this.asociacionPorPersona = asociacionPorPersona;
	}

	public BeanDdp getDatosRUC() {
		return datosRUC;
	}

	public void setDatosRUC(BeanDdp datosRUC) {
		this.datosRUC = datosRUC;
	}

	public TdtbcEntidad getEntidadSeleccionada() {
		return entidadSeleccionada;
	}

	public void setEntidadSeleccionada(TdtbcEntidad entidadSeleccionada) {
		this.entidadSeleccionada = entidadSeleccionada;
	}

	public boolean isEsDNI() {
		return esDNI;
	}

	public void setEsDNI(boolean esDNI) {
		this.esDNI = esDNI;
	}

	public boolean isEsRUC() {
		return esRUC;
	}

	public void setEsRUC(boolean esRUC) {
		this.esRUC = esRUC;
	}	
	
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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
	
	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String[] getSelectedDependencias() {
		return selectedDependencias;
	}

	public void setSelectedDependencias(String[] selectedDependencias) {
		this.selectedDependencias = selectedDependencias;
	}

	public List<TdtbdReqtupa> getRequisitosTupaSeleccionado() {
		return requisitosTupaSeleccionado;
	}

	public void setRequisitosTupaSeleccionado(
			List<TdtbdReqtupa> requisitosTupaSeleccionado) {
		this.requisitosTupaSeleccionado = requisitosTupaSeleccionado;
	}

	public TdtbcDependencia getDependenciaSeleccionada() {
		return dependenciaSeleccionada;
	}

	public void setDependenciaSeleccionada(TdtbcDependencia dependenciaSeleccionada) {
		this.dependenciaSeleccionada = dependenciaSeleccionada;
	}

	public List<TdtbcDependencia> getDependenciasAutocomplete() {
		return dependenciasAutocomplete;
	}

	public void setDependenciasAutocomplete(
			List<TdtbcDependencia> dependenciasAutocomplete) {
		this.dependenciasAutocomplete = dependenciasAutocomplete;
	}

	public String getDesTupaPopUp() {
		return desTupaPopUp;
	}

	public void setDesTupaPopUp(String desTupaPopUp) {
		this.desTupaPopUp = desTupaPopUp;
	}

	public String getCodTupaPopUp() {
		return codTupaPopUp;
	}

	public void setCodTupaPopUp(String codTupaPopUp) {
		this.codTupaPopUp = codTupaPopUp;
	}

	public RegistrarBean()
	{
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			listaProcedimientoPopUp=registrarDespatch.getProcedimiento(new BigDecimal(PGP_Usuario.getN_numint()));
		} catch (Exception e) {
			listaProcedimientoPopUp=null;
			logger.warn("No devolvió lista de tupa nada al inicializar,se intentará al momento de seleccionar un tupa");
			//e.printStackTrace();
		}
	}
	
	public List<TdtbdTupa> getListaProcedimientoPopUp() {		
		return listaProcedimientoPopUp;
	}

	public void setListaProcedimientoPopUp(List<TdtbdTupa> listaProcedimientoPopUp) {
		this.listaProcedimientoPopUp = listaProcedimientoPopUp;
	}

	public TdtbdTupa getTupaSeleccionado() {
		return tupaSeleccionado;
	}

	public void setTupaSeleccionado(TdtbdTupa tupaSeleccionado) {
		this.tupaSeleccionado = tupaSeleccionado;
	}
	
	public boolean isMostrarReq() {
		return mostrarReq;
	}

	public void setMostrarReq(boolean mostrarReq) {
		this.mostrarReq = mostrarReq;
	}
	
	public String getTupaDes() {
		return tupaDes;
	}

	public void setTupaDes(String tupaDes) {
		this.tupaDes = tupaDes;
	}

	public String getTupa() {
		return tupa;
	}

	public void setTupa(String tupa) {
		this.tupa = tupa;
	}

	public List<TdtbdTupa> getListaProcedimiento() {
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			listaProcedimiento=registrarDespatch.getProcedimiento(new BigDecimal(PGP_Usuario.getN_numint()));
		} catch (Exception e) {
			listaProcedimiento=null;
			e.printStackTrace();
		}
		return listaProcedimiento;
	}

	public void setListaProcedimiento(List<TdtbdTupa> listaProcedimiento) {
		this.listaProcedimiento = listaProcedimiento;
	}

	public List<TdtbcIntendencia> getListaIntendencia() {
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			listaIntendencia=registrarDespatch.getIntendencia(PGP_Usuario.getN_numint());
		} catch (Exception e) {
			listaIntendencia=null;
			e.printStackTrace();
		}
		return listaIntendencia;
	}

	public void setListaIntendencia(List<TdtbcIntendencia> listaIntendencia) {
		this.listaIntendencia = listaIntendencia;
	}

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}
	
	public List<TdtbcDependencia> getListaDependencia() {
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			listaDependencia=registrarDespatch.getDependencia(PGP_Usuario.getN_numint());
		} catch (Exception e) {
			listaDependencia=null;
			e.printStackTrace();
		}
		return listaDependencia;
	}

	public void setListaDependencia(List<TdtbcDependencia> listaDependencia) {
		this.listaDependencia = listaDependencia;
	}

	public List<TdtbcTramite> getListaTipoTramite() {		
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			listaTipoTramite=registrarDespatch.getTipoTramite();
			/*if("500".equalsIgnoreCase(PGP_Usuario.getN_numdep().trim()))
			{
				listaTipoTramite=registrarDespatch.getTipoTramite();
			}
			else
			{
				listaTipoTramite=registrarDespatch.getTipoTramiteSinTupa();
			}*/
		} catch (Exception e) {
			listaTipoTramite=null;
			e.printStackTrace();
		}
		return listaTipoTramite;
	}

	public void setListaTipoTramite(List<TdtbcTramite> listaTipoTramite) {
		this.listaTipoTramite = listaTipoTramite;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public List<TdtbcTipodoctramite> getListaTipoDocTra() {
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			if("10".equalsIgnoreCase(tipoDoc2))
			{
				listaTipoDocTra=registrarDespatch.getTipoDocTramiteCongresal();
			}
			else
			{
				listaTipoDocTra=registrarDespatch.getTipoDocTramite();
			}			
		} catch (Exception e) {
			listaTipoDocTra=null;
			e.printStackTrace();
		}
		return listaTipoDocTra;
	}

	public void setListaTipoDocTra(List<TdtbcTipodoctramite> listaTipoDocTra) {
		this.listaTipoDocTra = listaTipoDocTra;
	}
	
	public String getV_codpro() {
		return v_codpro;
	}

	public void setV_codpro(String v_codpro) {
		this.v_codpro = v_codpro;
	}

	public String getV_coddis() {
		return v_coddis;
	}

	public void setV_coddis(String v_coddis) {
		this.v_coddis = v_coddis;
	}
	
	public List<Combo> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Combo> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public List<Combo> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Combo> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}	

	public String getV_coddep() {
		return v_coddep;
	}

	public void setV_coddep(String v_coddep) {
		this.v_coddep = v_coddep;
	}

	public List<SitbTdocide> getListaTipoDoc() {
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			listaTipoDoc=registrarDespatch.getTipoDocRemitente();
		} catch (Exception e) {
			listaTipoDoc=null;
			e.printStackTrace();
		}
		return listaTipoDoc;
	}

	public void setListaTipoDoc(List<SitbTdocide> listaTipoDoc) {
		this.listaTipoDoc = listaTipoDoc;
	}
	
	public boolean isValRuc() {
		return valRuc;
	}

	public void setValRuc(boolean valRuc) {
		this.valRuc = valRuc;
	}

	public String getNroRuc() {
		return nroRuc;
	}

	public void setNroRuc(String nroRuc) {
		this.nroRuc = nroRuc;
	}
	
	public boolean isMostrarMensaje() {
		return mostrarMensaje;
	}

	public void setMostrarMensaje(boolean mostrarMensaje) {
		this.mostrarMensaje = mostrarMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void selCmbDepartamento(){
		logger.info("Obteniendo Cmb Provincia");
		try{
			listaProvincias = new ArrayList<Combo>();
			String coddep = v_coddep; 
			listaProvincias = dspcombos.listaProvinciasxDep(coddep);
			
			//DESSELECCIONANDO LA PROVINCIA
			setV_codpro("");
			//DESSELECCIONANDO EL DISTRITO
			setV_coddis("");
			
			//LIMPIAMOS LOS DISTRITOS
			listaDistritos = new ArrayList<Combo>();
			
		}catch(Exception e){
			logger.error("Error en Listar las provincias y distritos: "+e.getMessage(),e);
		}
	}
	
	public void selCmbProvincia(){
		logger.info("Obteniendo Cmb Distrito");
		try{
			listaDistritos = new ArrayList<Combo>();
			String coddep = getV_coddep();
			String codpro = getV_codpro();
			listaDistritos = dspcombos.listaDistritosxPro(coddep,codpro);
			//DESSELECCIONANDO EL DISTRITO
			setV_coddis("");
			
		}catch(Exception e){
			logger.error("Error en Listar los distritos: "+e.getMessage(),e);
		}
	}
	
	public List<String> completeText(String query) {
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		dependenciasAutocomplete=new ArrayList<TdtbcDependencia>();
		try {
			dependenciasAutocomplete=registrarDespatch.getAutocompletarDependenciaEIntendencia(query, PGP_Usuario.getN_numint());
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		List<String> results = new ArrayList<String>();
		
		for (Iterator iterator = dependenciasAutocomplete.iterator(); iterator.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			results.add(tdtbcDependencia.getvDesdep());		
		}
        return results;
    }
	
	public void onItemSelect(SelectEvent event) {
		for (Iterator iterator = dependenciasAutocomplete.iterator(); iterator.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			if(event.getObject().toString().equals(tdtbcDependencia.getvDesdep()))
			{
				dependenciaSeleccionada=tdtbcDependencia;
			}			
		}
		//System.out.println("Dependencia seleccionada ::: "+dependenciaSeleccionada.getvCoddep()+" "+dependenciaSeleccionada.getvDesdep());
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }		
	
	public void activaTupa()
	{
		if(!"".equals(tupa.trim()))
		{
			RegistrarDespatch registrarDespatch = new RegistrarDespatch();
			try {
				tupaSeleccionado=registrarDespatch.getProcedimientoPorNro(tupa, new BigDecimal(PGP_Usuario.getN_numint()));
				if(tupaSeleccionado!=null)
				{
					tupaDes=tupaSeleccionado.getvDestupa();			
					mostrarReq=true;	
					reqChoice=null;
					dependenciaSeleccionada=registrarDespatch.getDependenciaPorCodigo(tupaSeleccionado.getnNumdep());
					txt1=dependenciaSeleccionada.getvDesdep();
					requisitosTupaSeleccionado=registrarDespatch.getRequisitosPorTupa(tupaSeleccionado);
					//System.out.println("Dependencia seleccionada ::: "+dependenciaSeleccionada.getvCoddep()+" "+dependenciaSeleccionada.getvDesdep());
					//-pendiente definir dependencia a cargar cuando sea tupa?? setear dependenciaSeleccionada y asignar la des a txt1
					//pendiente recuperar los requisitos del tupa
				}
				else
				{
					tupaSeleccionado=null;
					tupaDes="";				
					mostrarReq=false;
					dependenciaSeleccionada=null;
					txt1="";
					requisitosTupaSeleccionado=null;
					mostrarMensajeInfo("Información",  "No existe un Tupa con ese código");
				}
			} catch (Exception e) {
				tupaSeleccionado=null;
				tupaDes="";				
				mostrarReq=false;
				dependenciaSeleccionada=null;
				txt1="";
				requisitosTupaSeleccionado=null;
				mostrarMensajeInfo("Información",  "No existe un Tupa con ese código");
				e.printStackTrace();
			}
		}
		else
		{			
			mostrarMensajeInfo("Información","Debe ingresar un código de TUPA");
		}			
	}
	
	public void selectTupa(String codigo, String descripcion, TdtbdTupa proc)
	{
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		tupaSeleccionado=proc;
		tupa=codigo;
		tupaDes=descripcion;		
		mostrarReq=true;
		reqChoice=null;
		try {
			dependenciaSeleccionada=registrarDespatch.getDependenciaPorCodigo(tupaSeleccionado.getnNumdep());
			txt1=dependenciaSeleccionada.getvDesdep();
			requisitosTupaSeleccionado=registrarDespatch.getRequisitosPorTupa(tupaSeleccionado);
			//System.out.println("Dependencia seleccionada ::: "+dependenciaSeleccionada.getvCoddep()+" "+dependenciaSeleccionada.getvDesdep());
		} catch (Exception e) {			
			dependenciaSeleccionada=null;
			txt1="";
			requisitosTupaSeleccionado=null;
			e.printStackTrace();
		}					
		//-pendiente definir dependencia a cargar cuando sea tupa?? setear dependenciaSeleccionada y asignar la des a txt1
		//pendiente recuperar los requisitos del tupa
	}
	
	public void dialogTupa(){
		//reset busqueda tupa
		desTupaPopUp="";
		codTupaPopUp="";
		buscarTupa();
		//end reset busqueda tupa
		RequestContext.getCurrentInstance().execute("dialogWidgetTupa.show()");
	}
	
	public void buscarTupa()
	{
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			listaProcedimientoPopUp=registrarDespatch.getProcedimientoPorNroYDescripcion(codTupaPopUp, desTupaPopUp.toUpperCase(), new BigDecimal(PGP_Usuario.getN_numint()));
		} catch (Exception e) {
			listaProcedimientoPopUp=null;
			e.printStackTrace();
		}
	}
	
	public void activaRegistroManual()
	{
		if(nroDoc!=null && !"".equals(nroDoc.trim())){}
		else
		{		
			String tidotemp="";
			if("03".equals(tipoDoc))
			{
				tidotemp="DNI";
			}
			else if("09".equals(tipoDoc))
			{
				tidotemp="RUC";
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingrese "+tidotemp+" de remitente."));
			return;
		}
		//busca si existe en BD
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		TdtbcEntidad entTemp=new TdtbcEntidad();
		try {
			entTemp=registrarDespatch.getEntidadPorCodigoYTipoDoc(nroDoc, tipoDoc);
		} catch (Exception e) {
			entTemp=null;
			e.printStackTrace();
			try {
				entTemp=registrarDespatch.getEntidadPorCodigo(nroDoc);
			} catch (Exception e2) {
				entTemp=null;
				e2.printStackTrace();
			}
		}
		if(entTemp!=null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Presionar enter luego de ingresar el Número de Documento."));
			return;
		}
		if("03".equals(tipoDoc))
		{
			System.out.println("Se habilitó el modo de registro de entidad manual para DNI");
			nombres="";
			apellidoPat="";
			apellidoMat="";
			razonSocial="";
			esDNI=true;
			esRUC=false;
			hayRegEntidadManual=true;
		}
		else if("09".equals(tipoDoc))
		{
			System.out.println("Se habilitó el modo de registro de entidad manual para RUC");
			hayRegEntidadManual=true;
			datosRUC=null;
			nombres="";
			apellidoPat="";
			apellidoMat="";
			razonSocial="";
			esDNI=false;
			esRUC=true;
		}		
	}
	
	public void activaRucODni()
	{
		
		if(tipoDoc!=null && nroDoc!=null && !"".equals(tipoDoc.trim()) && !"".equals(nroDoc))
		{
			if(!"09".equals(tipoDoc))
			{
				valRuc=true;
			}				
			
			if("03".equals(tipoDoc))
			{
				if(nroDoc.length()!=8)
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar DNI válido"));
				}
				else
				{
					
					//primero buscar en tabla entidad, si no existe usar el ws pide por dni y guardar en tabla entidad
					RegistrarDespatch registrarDespatch = new RegistrarDespatch();
					try {						
						entidadSeleccionada=registrarDespatch.getEntidadPorCodigoYTipoDoc(nroDoc, tipoDoc);
					} catch (Exception e) {						
						entidadSeleccionada=null;
						e.printStackTrace();
						try {
							entidadSeleccionada=registrarDespatch.getEntidadPorCodigo(nroDoc);
						} catch (Exception e2) {
							entidadSeleccionada=null;
							e2.printStackTrace();
						}
					}
					if(entidadSeleccionada!=null)
					{
						if(entidadSeleccionada.getvNombres()!=null && entidadSeleccionada.getvApepat()!=null && entidadSeleccionada.getvApemat()!=null)
						{
							nombres=entidadSeleccionada.getvNombres();
							apellidoPat=entidadSeleccionada.getvApepat();
							apellidoMat=entidadSeleccionada.getvApemat();
							razonSocial="";
							esDNI=true;
							esRUC=false;
							hayRegEntidadManual=false;
							obtenerDirecciones(entidadSeleccionada.getvCodentidad());
						}
						else
						{//actualiza campos nuevos de registro antiguo de la tabla entidad
							Persona per=new Persona();
							try {
								per=obtenerPersona(tipoDoc,nroDoc);
							} catch (Exception e) {								
								per=null;
								e.printStackTrace();																
							}
							try {
								per.valuesToString();
							} catch (Exception e) {
								e.printStackTrace();
							}							
							if(per!=null && "0001".equals(per.getV_coderror()))
							{//no hay servicio de reniec entonces habilita la actualizacion manual 2017
								nombres="";
								apellidoPat="";
								apellidoMat="";
								razonSocial="";
								esDNI=true;
								esRUC=false;
								hayActEntidadManual=true;
							}
							if(per!=null && "0000".equals(per.getV_coderror()))
							{
								nombres=per.getV_nombres();
								apellidoPat=per.getV_apepater();
								apellidoMat=per.getV_apemater();
								razonSocial="";
								esDNI=true;
								esRUC=false;
								hayRegEntidadManual=false;
								//actualizar en tabla entidad								
								entidadSeleccionada.setvDesnombre(per.getV_nombres()+" "+per.getV_apepater()+" "+per.getV_apemater());																
								entidadSeleccionada.setdFecmod(new Date());
								entidadSeleccionada.setvApepat(per.getV_apepater());
								entidadSeleccionada.setvApemat(per.getV_apemater());
								entidadSeleccionada.setvNombres(per.getV_nombres());
								entidadSeleccionada.setvFlgreniec("S");
								try {
									registrarDespatch.actualizarEntidad(entidadSeleccionada);
								} catch (Exception e) {
									e.printStackTrace();
								}
								obtenerDirecciones(entidadSeleccionada.getvCodentidad());								
							}
							else if("DNE".equals(per.getV_coderror()) || "NHC".equals(per.getV_coderror()))
							{
								System.out.println("No recupero nada");
								nombres="";
								apellidoPat="";
								apellidoMat="";
								razonSocial="";
								esDNI=false;
								esRUC=false;
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No se ha encontrado una persona con ese número de DNI."));
							}
						}
					}
					else
					{//recupera del ws e inserta en tabla entidad
						Persona per=new Persona();
						try {
							per=obtenerPersona(tipoDoc,nroDoc);
						} catch (Exception e) {
							per=null;
							e.printStackTrace();
						}						
						try {												
							per.valuesToString();
						} catch (Exception e) {
							e.printStackTrace();
						}						
						if(per!=null && "0000".equals(per.getV_coderror()))
						{
							nombres=per.getV_nombres();
							apellidoPat=per.getV_apepater();
							apellidoMat=per.getV_apemater();
							razonSocial="";
							esDNI=true;
							esRUC=false;
							hayRegEntidadManual=false;
							//verificar(se hizo a priori) y guardar en tabla entidad
							TdtbcEntidad entPer=new TdtbcEntidad();
							entPer.setvCodentidad(nroDoc);
							entPer.setvCodtipodocid(tipoDoc);
							entPer.setvDesnombre(per.getV_nombres()+" "+per.getV_apepater()+" "+per.getV_apemater());
							entPer.setvDirentidad(" ");
							entPer.setvDescorreoe("");
							entPer.setvNomusureg("");
							entPer.setdFecreg(new Date());
							entPer.setvNomusumod("");
							entPer.setdFecmod(new Date());
							entPer.setvApepat(per.getV_apepater());
							entPer.setvApemat(per.getV_apemater());
							entPer.setvNombres(per.getV_nombres());
							entPer.setvFlgreniec("S");
							try {
								registrarDespatch.insertarEntidad(entPer);
								entidadSeleccionada=entPer;
							} catch (Exception e) {
								e.printStackTrace();
							}
							obtenerDirecciones(entidadSeleccionada.getvCodentidad());							
						}
						else if("DNE".equals(per.getV_coderror()) || "NHC".equals(per.getV_coderror()))
						{
							System.out.println("No recupero nada");
							nombres="";
							apellidoPat="";
							apellidoMat="";
							razonSocial="";
							esDNI=false;
							esRUC=false;
							hayRegEntidadManual=false;
							//se incluyo msgs dentro de obtenerPersona
							//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No se ha encontrado una persona con ese número de DNI."));
						}
						else if("5".equals(per.getV_coderror()) || "3".equals(per.getV_coderror()) || "AXISFAULT".equals(per.getV_coderror()) || per==null)
						{//habilitar modo registro de entidad manual
							System.out.println("Se habilitó el modo de registro de entidad manual");
							nombres="";
							apellidoPat="";
							apellidoMat="";
							razonSocial="";
							esDNI=true;
							esRUC=false;
							hayRegEntidadManual=true;
							//se incluyo msgs dentro de obtenerPersona
							//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No se ha podido conectar con Servicio de RENIEC, por favor registre manualmente los nombres."));
						}
					}					
				}				
			}
			else if("09".equals(tipoDoc))
			{
				/*if(esRUC){
				razonSocial
		select count(1) from SIMINTRA1.SITB_EMPMTPE t
		where t.v_codemp='nroDoc'
			}*/
				if(nroDoc.length()!=11)
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar RUC válido"));
				}
				else
				{
					RegistrarDespatch registrarDespatch = new RegistrarDespatch();
					
					try {
						entidadSeleccionada=registrarDespatch.getEntidadPorCodigoYTipoDoc(nroDoc, tipoDoc);
					} catch (Exception e) {
						entidadSeleccionada=null;
						e.printStackTrace();
					}
					if(entidadSeleccionada!=null)
					{
						nombres="";
						apellidoPat="";
						apellidoMat="";
						razonSocial=entidadSeleccionada.getvDesnombre();
						esDNI=false;
						esRUC=true;
						hayRegEntidadManual=false;
						obtenerDirecciones(entidadSeleccionada.getvCodentidad());
					}
					else
					{//recupera del ws y guarda en tabla entidad
						ClientePIDE ws=new ClientePIDE();
						try {
							datosRUC=ws.getDatosPrincipalesTh(nroDoc);
						} catch (AxisFault e) {
							hayRegEntidadManual=true;
							datosRUC=null;
						} catch (Exception e) {
							hayRegEntidadManual=false;
							datosRUC=null;
						}
						
						if(datosRUC!=null && datosRUC.getDdp_nombre()!=null)//datosRUC.getDdp_nombre()!=null
						{
							nombres="";
							apellidoPat="";
							apellidoMat="";
							razonSocial=datosRUC.getDdp_nombre();
							esDNI=false;
							esRUC=true;
							hayRegEntidadManual=false;
							//verificar(se hizo a priori) y guardar en tabla entidad
							TdtbcEntidad entEmp=new TdtbcEntidad();
							entEmp.setvCodentidad(nroDoc);
							entEmp.setvCodtipodocid(tipoDoc);
							entEmp.setvDesnombre(datosRUC.getDdp_nombre());
							entEmp.setvDirentidad(" ");
							entEmp.setvDescorreoe("");
							entEmp.setvNomusureg("");
							entEmp.setdFecreg(new Date());
							entEmp.setvNomusumod("");
							entEmp.setdFecmod(new Date());
							entEmp.setvApepat("");
							entEmp.setvApemat("");
							entEmp.setvNombres("");
							
							try {
								registrarDespatch.insertarEntidad(entEmp);
								entidadSeleccionada=entEmp;
								validaRuc(nroDoc);
							} catch (Exception e) {
								e.printStackTrace();
							}
							obtenerDirecciones(entidadSeleccionada.getvCodentidad());
						}
						else if(!hayRegEntidadManual)
						{
							nombres="";
							apellidoPat="";
							apellidoMat="";
							razonSocial="";
							esDNI=false;
							esRUC=false;
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "El RUC ingresado no existe, favor de validar."));
						}		
						else if(hayRegEntidadManual)
						{
							nombres="";
							apellidoPat="";
							apellidoMat="";
							razonSocial="";
							esDNI=false;
							esRUC=true;
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No se ha podido conectar con Servicio PIDE de SUNAT, por favor registre manualmente."));
						}
					}										
				}				
			}		
			else if("06".equals(tipoDoc) || "08".equals(tipoDoc))
			{	
				//en este caso entidadSeleccionada se intentara recuperar, si no existe se insertara en el evento de guardar el formulario
				RegistrarDespatch registrarDespatch = new RegistrarDespatch();
				try {
					entidadSeleccionada=registrarDespatch.getEntidadPorCodigoYTipoDoc(nroDoc, tipoDoc);
				} catch (Exception e) {
					entidadSeleccionada=null;
					e.printStackTrace();
				}
				if(entidadSeleccionada!=null)
				{
					nombres=entidadSeleccionada.getvNombres();
					apellidoPat=entidadSeleccionada.getvApepat();
					apellidoMat=entidadSeleccionada.getvApemat();
					razonSocial="";
					esDNI=true;
					esRUC=false;
					obtenerDirecciones(entidadSeleccionada.getvCodentidad());
				}
				else
				{
					nombres="";
					apellidoPat="";
					apellidoMat="";
					razonSocial="";
					esDNI=true;
					esRUC=false;
				}				
			}
			//recuperar las asociaciones por entidad seleccionada
			if(entidadSeleccionada!=null)
			{
				RegistrarDespatch registrarDespatch = new RegistrarDespatch();
				try {
					asociacionPorPersona=registrarDespatch.getAsociacionPorPersona(entidadSeleccionada, PGP_Usuario.getN_numdep());
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println("No existe asociaciones por entidad");
				}			

			}
			//end recuperar las asociaciones por entidad seleccionada
		}	
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe seleccionar un tipo de documento e ingresar un número."));
		}
	}
	
	public Persona obtenerPersona(String tipoDoc, String nroDoc){
		Persona pex=new Persona();
		String[] direcciones=new String[1];		
		direcciones[0]="wcastro@sunafil.gob.pe";
		String mensaje="";								
		String asunto="Error grave web Service RENIEC TRAMITE EXTERNO";
		boolean validaExiste=true;
		try {
			logger.info("Entro a Obtener Trabajador");
			pd = new PersonaDespatch();
			PersonaReniecDespatch prd=new PersonaReniecDespatch();
			//OBTENEMOS LOS DATOS INGRESADOS DE LA PERSONA:									
			if (nroDoc.length()<8) {
				FacesUtils.showFacesMessage("No es un número de documento válido", 1);
				return null;
			} else {
				String vflgReniec="";
					//EVALUA SI ES DNI
					if (tipoDoc.equals("03")) {
						//PRIMERO REALIZA LA BUSQUEDA EN SITB_PERSONA
						Persona temp=new Persona();
						temp.setV_numdoc(nroDoc);
						temp.setV_codtdocide(tipoDoc);
						ReniecBean pbusq = prd.getTrabajador(temp.getV_numdoc());
						vflgReniec=pbusq!=null?"S":"N";
						Persona pbusqTemp = pd.getTrabajador(temp);
						//Persona pbusq = pd.getTrabajador(temp);//PENDIENTE ::: IMPLEMENTAR CON NUEVO PROCEDURE
						//vflgReniec=pbusq==null?"N":pbusq.getV_flgreniec();
						
						if ("S".equals(vflgReniec)) {
							System.out.println("ENCONTRO TRABAJADOR EN SITB_PERSONA");
							//!!!pendiente pbusq pasar a tabla entidad de tramite externo 
							//retcc.setPersona(pbusq);
							return pbusqTemp;
						}else {
							//SI NO ENCONTRO BUSCA EN EL WEBSERVICE DE RENIEC
							//WS RENIEC
							ReniecWebService rws = new ReniecWebService(FacesUtils.getIpAddress(),PGP_Usuario.getV_codusu());							
							ReniecBean pexTemp =rws.obtenerPersonaSWReniec(temp,Funciones.ObtProp_App("mtpe.framework.sistema"));
							System.out.println("pexTemp.getV_coderror() : 2017 :"+pexTemp.getV_coderror());
							//Persona pex=new Persona();
							pex.setV_destdocide("DNI");
							pex.setV_codtdocide("03");
							pex.setV_numdoc(pexTemp.getV_numdoc());
							pex.setV_apepater(pexTemp.getV_appaterno());
							pex.setV_apemater(pexTemp.getV_apmaterno());
							pex.setV_nombres(pexTemp.getV_nombres());
							pex.setV_flgreniec("S");
							pex.setV_coderror(pexTemp.getV_coderror());//"0000"
							//pex.setD_feccad(pexTemp.get);
							//persona.valuesToString();							
							//System.out.println("pex.getV_coderror() "+pex.getV_coderror());
							boolean validaEnvioCorreo=false;
							if(pex==null){
								mostrarMensajeError("ERROR","No se encuentra el trabajador con el número de documento ingresado, deberá registrar manualmente");
								validaEnvioCorreo=true;
							}else
							{
								//CODIGOS DE ERROR
								if(pex.getV_coderror().equals("0000")){
									//mostrarMensajeInfo("ENCONTRADO", "Encontro trabajador en WS RENIEC");
									//return pex;
								}else{
									pex.valuesToString();
									validaExiste=false;
									if(pex.getV_coderror().equals("NTP")){
										mostrarMensajeInfo("SIN PERMISOS", "No tienen permisos de acceso al método consulta");
									}else if(pex.getV_coderror().equals("SINV")){
										mostrarMensajeInfo("SESION NO VALIDA", "Código de Sesión ingresado inválido");
									}else if(pex.getV_coderror().equals("UNL")){
										mostrarMensajeInfo("CONSULTA SIN AUTENTICACION", "Aplicación que consulta a Web Service no se ha autenticado, debe invocar previamente getSession");
									}else if(pex.getV_coderror().equals("0001")){
										mostrarMensajeInfo("Información", "Por favor completar manualmente los datos del remitente");
									}else if(pex.getV_coderror().equals("5")){
										mostrarMensajeInfo("CONSULTA INVALIDA", "Excedió el máximo numero de consultas asignadas por día");
									}else if(pex.getV_coderror().equals("3")){
										mostrarMensajeInfo("CONSULTA INVALIDA", "Esta consultando en un día y hora no permitido según convenio");
									}else if(pex.getV_coderror().equals("DNE")){
										validaExiste=true;
										validaEnvioCorreo=true;
										mostrarMensajeInfo("DNI INVALIDO", "El DNI consultado es inválido");
									}else if(pex.getV_coderror().equals("DNV")){
										validaEnvioCorreo=true;
										mostrarMensajeInfo("DNV", "El DNI del usuario de la empresa es inválido. No está autorizado a consultar");
									}else if(pex.getV_coderror().equals("0002")){
										mostrarMensajeInfo("ERROR DE SERVIDOR", "El servidor no puede atender el requerimiento");
									}else if(pex.getV_coderror().equals("21")){
										mostrarMensajeInfo("DNI INVALIDO", "El DNI solicitado se encuentra cancelado en el RUIPN");
									}else if(pex.getV_coderror().equals("22")){
										mostrarMensajeInfo("DNI INVALIDO", "El DNI solicitado se encuentra restringido en el RUIPN");
									}else if(pex.getV_coderror().equals("23")){
										mostrarMensajeInfo("DNI INVALIDO", "El DNI solicitado se encuentra observado en el RUIPN");
									}else
									{
										mostrarMensajeInfo("ERROR DESCONOCIDO","Este error esta fuera de los codigos de error establecidos");
									}
									if(validaEnvioCorreo==true){
										mensaje=pex==null?"EL WEB SERVICE NO ESTA FUNCIONANDO":pex.getV_coderror();
										enviarMailMetodo(mensaje, direcciones, asunto);
									}
								}
							}
						}
					}																							
			}						
		} catch (Exception e) {
			logger.error(e);			
			FacesUtils.showFacesMessage("Problema de comunicación con RENIEC porfavor registrar", 1);		
			logger.error("Enviando correo de aviso de error grave en el catch.");
			mensaje=e.getMessage();		
			enviarMailMetodo(mensaje,direcciones,asunto);
		}		
		RequestContext context=RequestContext.getCurrentInstance();
		context.addCallbackParam("validaExiste",validaExiste );
		return pex;
	}
	
	private void enviarMailMetodo(String mensaje,String[] direcciones,String asunto){
		EnviarMail enviarCorreo=new EnviarMail();
		if(direcciones!=null && direcciones.length>0){
			try {
				enviarCorreo.generarEnvioDeCorreos(mensaje, direcciones,asunto);
			} catch (Exception e1) {					
				e1.printStackTrace();
				logger.error("Error al enviar correo en el catch =>"+e1);
			}
		}
	}
	public void dialogReferenciaIni(){			
		//cargar la lista de asociaciones por entidad si hay delay recuperarlas al selecionar entidad
		if(entidadSeleccionada!=null)
		{		
			System.out.println("Entidad Seleccionada:"+entidadSeleccionada.getvDesnombre());
			RequestContext.getCurrentInstance().execute("dialogWidgetIni.show()");
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Primero debe ingresar un remitente."));
		}
	}
	
	public void selectReferencia(String item)
	{
		
		hruta0=item.split("-")[0].trim();
		hruta1=item.split("-")[1].trim();
		//pendiente setar intendencia en txt1
		//txt1="Intendencia de Lima Metropolitana";
		//pendiente setear asociacionSeleccionada;
	}
	
	public void dialogReferenciaHR(){			
		//para limpiar pop up
		hojaHR="";
		anioHR="";
		asociacionPorHR=null;
		RequestContext.getCurrentInstance().execute("dialogWidgetHR.show()");
	}
	
	public void buscarHR()
	{
		//Calendar actual = new GregorianCalendar();
		//int annio = Integer.toString(c.get(Calendar.YEAR));
		if(anioHR!=null && !"".equals(anioHR.trim()) && hojaHR!=null && !"".equals(hojaHR.trim()))
		{
			if(anioHR.trim().length()==4)
			{
				if((Integer.parseInt(hojaHR) <= 20183 && Integer.parseInt(anioHR) <= 2016) ||
			         	   (Integer.parseInt(hojaHR) > 20183 && Integer.parseInt(anioHR) < 2016))
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar una hoja de ruta unificada (Posterior al correlativo 20183 del año 2016)."));
				}
				else
				{
					hojaHR=completarCon(hojaHR,10,"0",0);//para autocompletar con ceros a la izq
					RegistrarDespatch registrarDespatch = new RegistrarDespatch();
					try {
						ConsultaDespatch consultaDespatch=new ConsultaDespatch();
						Map parametros = new HashMap();
						parametros.put("PARAM_HRNRO", hojaHR);
						parametros.put("PARAM_HRANIO", anioHR);
						asociacionPorHR=consultaDespatch.reporteTrazabilidadAsociacion(parametros);
					} catch (Exception e) {
						asociacionPorHR=null;
						e.printStackTrace();
					}
				}								
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Primero debe ingresar un año válido."));
			}
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Primero debe ingresar el número de hoja de ruta y el año."));
		}
	}
	
	public void dialogReferencia(){			
		//para limpiar pop up
		ordInsNro="";
		ordInsAnio="";
		actInsNro="";
		actInsAnio="";
		expSanNro="";
		expSanAnio="";
		res1erNro="";
		res1erAnio="";
		res2daNro="";
		res2daAnio="";
		asociacionPorInspeccion=null;
		RequestContext.getCurrentInstance().execute("dialogWidget.show()");
	}
	
	public void buscarI()
	{
		if( (ordInsAnio!=null && !"".equals(ordInsAnio.trim()) && ordInsNro!=null && !"".equals(ordInsNro.trim())) ||
			(actInsAnio!=null && !"".equals(actInsAnio.trim()) && actInsNro!=null && !"".equals(actInsNro.trim())) ||
			(expSanAnio!=null && !"".equals(expSanAnio.trim()) && expSanNro!=null && !"".equals(expSanNro.trim())) ||
			(res1erAnio!=null && !"".equals(res1erAnio.trim()) && res1erNro!=null && !"".equals(res1erNro.trim())) ||
			(res2daAnio!=null && !"".equals(res2daAnio.trim()) && res2daNro!=null && !"".equals(res2daNro.trim())) )
		{
			if(ordInsAnio.trim().length()==4 ||
					actInsAnio.trim().length()==4 ||
					expSanAnio.trim().length()==4 ||
					res1erAnio.trim().length()==4 ||
					res2daAnio.trim().length()==4)
			{
				if(ordInsNro!=null && !"".equals(ordInsNro.trim()))
				{
					ordInsNro=completarCon(ordInsNro,10,"0",0);//para autocompletar con ceros a la izq
				}
				if(actInsNro!=null && !"".equals(actInsNro.trim()))
				{
					actInsNro=completarCon(actInsNro,10,"0",0);//para autocompletar con ceros a la izq
				}
				if(expSanNro!=null && !"".equals(expSanNro.trim()))
				{
					expSanNro=completarCon(expSanNro,10,"0",0);//para autocompletar con ceros a la izq
				}
				if(res1erNro!=null && !"".equals(res1erNro.trim()))
				{
					res1erNro=completarCon(res1erNro,10,"0",0);//para autocompletar con ceros a la izq
				}
				if(res2daNro!=null && !"".equals(res2daNro.trim()))
				{
					res2daNro=completarCon(res2daNro,10,"0",0);//para autocompletar con ceros a la izq
				}
				RegistrarDespatch registrarDespatch = new RegistrarDespatch();		
				try {
					List<Short> dependenciasSIIT=registrarDespatch.getEquivalenciaDependenciasSIIT(PGP_Usuario.getN_numdep());
					VstSiitToTramite ent=new VstSiitToTramite();
					ent.setvNrooic(ordInsNro);
					ent.setvAniooic(ordInsAnio);
					ent.setvNroacta(actInsNro);
					ent.setvAnioacta(actInsAnio);
					ent.setvNroexpsan(expSanNro);
					ent.setvAnioexpsanc(expSanAnio);
					ent.setvNrores1ra(res1erNro); 
					ent.setvAniores1ra(res1erAnio);
					ent.setvNrores2da(res2daNro); 
					ent.setvAniores2da(res2daAnio);
					asociacionPorInspeccion=registrarDespatch.getAsociacionPorInspeccion(ent, dependenciasSIIT);//envia la lista de dependencias entre tramite y siit
				} catch (Exception e) {
					asociacionPorInspeccion=null;
					e.printStackTrace();
				}
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Primero debe ingresar un año válido."));
			}			
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Primero debe ingresar un número y el año."));
		}
	}
	
	public static String completarCon(String base, int longitud,String charCompletar, int lado)
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
				result = ceros+base;
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
	
	public void selectReferenciaI(VstSiitToTramite item)
	{
		//System.out.println("["+item.getvNrohr()+"-"+item.getvAniohr()+"]");
		if(item.getvNrohr()!=null && item.getvAniohr()!=null)
		{
			hruta0=item.getvNrohr();
			hruta1=item.getvAniohr();
		}		
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No se puede seleccionar un registro sin hoja de ruta."));
		}
		//pendiente setar intendencia en txt1
		//txt1="Intendencia de Lima Metropolitana";
		//pendiente setear asociacionSeleccionada;
	}
	
	public String getFormatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
	
	public String getSiguienteCorrelativo(String anio, Short numDep, Short tipoD)
	{
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			TdtbcCorrelativo correlativo=registrarDespatch.getCorrelativo(anio, numDep, tipoD);
			if(correlativo!=null)
			{
				//actualiza con correlativo incrementado
				correlativo.setnNumultimo(correlativo.getnNumultimo()+1);
				registrarDespatch.actualizarCorrelativo(correlativo);
				return ""+correlativo.getnNumultimo();
			}
			else
			{
				//inserta correlativo en 1
				correlativo=new TdtbcCorrelativo();
				correlativo.setvNumano(anio);
				correlativo.setnNumdep(numDep);
				correlativo.setnNumtipodoc(tipoD);
				correlativo.setnNumultimo(1L);
				correlativo.setvNomusureg("TRAMITE");
				correlativo.setdFecreg(new Date());
				correlativo.setvNomusumod("TRAMITE");
				correlativo.setdFecmod(new Date());
				registrarDespatch.insertarCorrelativo(correlativo);
				return ""+correlativo.getnNumultimo();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	public String getSiguienteCorrelativoGlobal(Short anio)
	{
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			TdmvcHojarutaKey correlativo=registrarDespatch.getCorrelativoGlobal(anio);
			if(correlativo!=null)
			{
				//inserta con correlativo incrementado
				correlativo.setvCodhoja(""+(Integer.parseInt(correlativo.getvCodhoja())+1));								
				registrarDespatch.insertarCorrelativoGlobal(correlativo);
				return correlativo.getvCodhoja();
			}
			else
			{
				//inserta correlativo en 1
				correlativo=new TdmvcHojarutaKey();
				correlativo.setvAniohoja(anio);
				correlativo.setvCodhoja("1");
				registrarDespatch.insertarCorrelativoGlobal(correlativo);
				return correlativo.getvCodhoja();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	public boolean validaFormulario()
	{
		if(tipoDoc!=null && !"".equals(tipoDoc.trim())){}
		else
		{
			mensajeValida="Seleccione un tipo de documento de remitente.";
			return false;
		}
		if(nroDoc!=null && !"".equals(nroDoc.trim()))
		{
			if("03".equals(tipoDoc) || "06".equals(tipoDoc) || "08".equals(tipoDoc))//valida campos de remitente
			{
				if(apellidoPat!=null && !"".equals(apellidoPat.trim()) && apellidoMat!=null && !"".equals(apellidoMat.trim()) && nombres!=null && !"".equals(nombres.trim())){}
				else
				{
					mensajeValida="Ingrese una persona remitente.";
					return false;
				}
			}
			else if("09".equals(tipoDoc))
			{
				if(razonSocial!=null && !"".equals(razonSocial.trim())){}
				else
				{
					mensajeValida="Ingrese razón social del remitente.";
					return false;
				}
			}
		}
		else
		{
			mensajeValida="Ingrese número de documento de remitente.";
			return false;
		}
		if(hayDirecciones)
		{//validar existencia de direccionCombo
			if(direccionCombo!=null && !"".equals(direccionCombo.trim())){}
			else
			{
				mensajeValida="Ingrese la dirección del remitente.";
				return false;
			}
		}
		else
		{//validar existencia de los campos de la nueva dirección ingresada
			if(v_coddep!=null && !"".equals(v_coddep.trim())){}
			else
			{
				mensajeValida="Seleccione departamento.";
				return false;
			}
			if(v_codpro!=null && !"".equals(v_codpro.trim())){}
			else
			{
				mensajeValida="Seleccione provincia.";
				return false;
			}
			if(v_coddis!=null && !"".equals(v_coddis.trim())){}
			else
			{
				mensajeValida="Seleccione distrito.";
				return false;
			}
			if(direccion!=null && !"".equals(direccion.trim())){}
			else
			{
				mensajeValida="Ingrese dirección.";
				return false;
			}
		}
		if(tipoDoc2!=null && !"".equals(tipoDoc2.trim())){}
		else
		{
			mensajeValida="Seleccione un tipo de tramite.";
			return false;
		}
		if(nroDocRegistro!=null && !"".equals(nroDocRegistro.trim()))
		{
			if(tipoDocRegistro!=null && !"".equals(tipoDocRegistro.trim())){}
			else
			{
				mensajeValida="Si ingresa un número de documento, debe seleccionar un tipo de documento.";
				return false;
			}
		}
		//*****************************************************
		//INI - VALIDACION DE TIPO DE DOCUMENTO PARA CONGRESAL:
		//*****************************************************
		if("10".equals(tipoDoc2.trim())){
			if(tipoDocRegistro!=null && !"".equals(tipoDocRegistro.trim())){}
			else{
				mensajeValida="Si ingresa el tipo de trámite Documento Congresal, debe seleccionar un tipo de documento.";
				return false;
			}
			if(mostrarCongresistas){
				if(codcong==null || "".equals(codcong)){
					mensajeValida="Por favor seleccione el Congresista.";
					return false;
				}
			}
			if(mostrarComisiones){
				if(codcom==null || "".equals(codcom)){
					mensajeValida="Por favor seleccione la Comisión.";
					return false;
				}
			}
			if(!mostrarComisiones && !mostrarCongresistas){
				mensajeValida="Por favor seleccione si el Documento Congresal es por comisión o por congresista.";
				return false;
			}
			/*if(codcargocong!=null && !"".equals(codcargocong.trim())){}
			else
			{
				mensajeValida="Por favor seleccione un cargo congresal.";
				return false;
			}*/
		}
		//*****************************************************
		//FIN - VALIDACION DE TIPO DE DOCUMENTO PARA CONGRESAL
		//*****************************************************
		
		//validaciones en caso sea tupa
		if("1".equals(tipoDoc2))
		{
			if(tupaSeleccionado!=null && tupa!=null && !"".equals(tupa)){}//&& tupa!=null && !"".equals(tupa) ::: solo porsea borren
			else
			{
				mensajeValida="Seleccione un TUPA.";
				return false;
			}
		}
		//fin validaciones en caso sea tupa
		if(dependenciaSeleccionada!=null && txt1!=null && !"".equals(txt1)){}//&& txt1!=null && !"".equals(txt1) ::: solo porsea borren
		else
		{
			mensajeValida="Ingrese una dependencia destino.";
			return false;
		}
		if(nroFolios!=null && !"".equals(nroFolios.trim())){}
		else
		{
			mensajeValida="Ingrese numero de folios.";
			return false;
		}
		if(asunto!=null && !"".equals(asunto.trim())){}
		else
		{
			mensajeValida="Ingrese el asunto.";
			return false;
		}
		/*if(observaciones!=null && !"".equals(observaciones.trim())){}
		else
		{
			mensajeValida="ingrese observaciones.";
			return false;
		}*/
		/*if(prioridad!=null && !"".equals(prioridad.trim())){}
		else
		{
			mensajeValida="Seleccione prioridad.";
			return false;
		}*/
		return true;
	}
	
	public void itemChangeTipoDocRemitente()
	{
		nroDoc="";
		esDNI=false;
		apellidoPat="";
		apellidoMat="";
		nombres="";
		esRUC=false;
		razonSocial="";
		mostrarMensaje=false;
		mostrarMensajeRojo=false;
		mostrarMensajeAzul=false;
		valRuc=false;
		nroRuc="";
		entidadSeleccionada=null;
		hayDirecciones=false;
		direccion="";
		direccionCombo="";
		direccionesEntSeleccionada=null;
	}
	
	public void itemChangeCategoria()
	{
		if(tipoDoc2 !=null)
		{
			if("1".equalsIgnoreCase(tipoDoc2))
			{//es tupa
				mostrarFieldsTupa=true;
				mostrarCongresales=false;
				
				dependenciaSeleccionada=null;
				txt1="";
				requisitosTupaSeleccionado=null;
			}
			else if("10".equalsIgnoreCase(tipoDoc2))
			{//es congresal
				RegistrarDespatch registrarDespatch=new RegistrarDespatch();  
				try {
					System.out.println("entro a setear secretaria general como dependencia :::: ");
					dependenciaSeleccionada=registrarDespatch.getDependenciaPorCodigo(new Short("451"));
					txt1=dependenciaSeleccionada.getvDesdep();
					System.out.println("dep  ::: "+dependenciaSeleccionada.getvDesdep());
				} catch (Exception e) {
					dependenciaSeleccionada=null;
					txt1="";
					e.printStackTrace();
				}
				
				
				mostrarCongresales=true;				
				mostrarFieldsTupa=false;
				mostrarReq=false;
				tupa="";
				tupaDes="";
				
				/*dependenciaSeleccionada=null;
				txt1="";*/
				requisitosTupaSeleccionado=null;
				
				
			}
			else
			{//no es tupa ni congresal
				mostrarFieldsTupa=false;
				mostrarCongresales=false;
				mostrarReq=false;
				tupa="";
				tupaDes="";
				
				dependenciaSeleccionada=null;
				txt1="";
				requisitosTupaSeleccionado=null;
			}
		}
		/*dependenciaSeleccionada=null;
		txt1="";*/
	}
	
	
	public void itemChangeTipoOrigCongresal()
	{
		if(v_tipoOrigCongr !=null)
		{
			if("CONGR".equalsIgnoreCase(v_tipoOrigCongr))
			{//ES POR CONGRESISTA
				mostrarCongresistas=true;
				mostrarComisiones=false;
			}
			else if("COMIS".equalsIgnoreCase(v_tipoOrigCongr))
			{//ES POR COMISION
				mostrarCongresistas=false;
				mostrarComisiones=true;
			}
			else
			{//NO ES POR CONGRESISTA NI COMISION
				mostrarCongresistas=false;
				mostrarComisiones=false;
			}
		}
	}
	
	
	
	
	public void obtenerDirecciones(String vCodentidad)
	{
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			//direccionesEntSeleccionada=registrarDespatch.getDireccionesPorEntidad(vCodentidad);
			direccionesEntSeleccionada=registrarDespatch.getDirsPorEntidad(vCodentidad);
			//si no es lista vacia activa flag para mostrar selector de direcciones
			if(direccionesEntSeleccionada!=null && direccionesEntSeleccionada.size()!=0)
			{
				System.out.println("hay direcciones");
				hayDirecciones=true;
			}
			else
			{
				System.out.println("no hay direcciones");
				hayDirecciones=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String nuevoRegistro(){
		tipoDoc=null;
		nroDoc="";
		nombres="";
		apellidoPat="";
		apellidoMat="";
		razonSocial="";
		entidadSeleccionada=null;
		esDNI=false;
		esRUC=false;
		valRuc=false;
		setMostrarMensaje(false);
		mostrarMensajeAzul=false;
		mostrarMensajeRojo=false;
		hayRegEntidadManual=false;
		hayActEntidadManual=false;
		v_coddep="";
		v_codpro="";
		v_coddis="";
		direccion="";
		hruta0="";
		hruta1="";
		tipoDoc2=null;
		tipoDocRegistro=null;
		nroDocRegistro="";		
		tupaSeleccionado=null;		
		tupa="";
		tupaDes="";
		txt1="";
		dependenciaSeleccionada=null;
		
		mostrarFieldsTupa=false;
		mostrarReq=false;
		nroFolios="";
		asunto="";
		observaciones="";		
		reqChoice= null;
		esGrabar=false;
		prioridad="0";
		hayDirecciones=false;
		direccionesEntSeleccionada=null;		
		requisitosTupaPendientes=null;
		registroGuardado=null;
		
		hojaHR="";
		anioHR="";
		asociacionPorHR=null;
		
		ordInsNro="";
		ordInsAnio="";
		actInsNro="";
		actInsAnio="";
		expSanNro="";
		expSanAnio="";
		res1erNro="";
		res1erAnio="";
		res2daNro="";
		res2daAnio="";
		asociacionPorInspeccion=null;
		
		mostrarCongresales=false;
		mostrarComisiones=false;
		mostrarCongresistas=false;
		v_tipoOrigCongr=null;
		codcom=null;
		codcong=null;
		codcargocong=null;
		oficialMayor=false;
		
		
		String vista="pretty:nuevoRegPretty";
        //CODIGO
        return  vista;
	}
	
	public void grabar()
	{		
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		//primero validar
		if(!validaFormulario())
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", mensajeValida));
			return;
		}
		//si no es ni ruc ni dni entonces primero guardar persona en tabla entidad
		if(entidadSeleccionada!=null)
		{
			if(hayActEntidadManual)
			{
				entidadSeleccionada.setvApepat(apellidoPat.toUpperCase());
				entidadSeleccionada.setvApemat(apellidoMat.toUpperCase());
				entidadSeleccionada.setvNombres(nombres.toUpperCase());
				entidadSeleccionada.setvDesnombre(nombres.toUpperCase()+" "+apellidoPat.toUpperCase()+" "+apellidoMat.toUpperCase());
				entidadSeleccionada.setvFlgreniec("N");
				try {
					registrarDespatch.actualizarEntidad(entidadSeleccionada);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else
		{//guardar entidad
			
			if("06".equals(tipoDoc) || "08".equals(tipoDoc) || hayRegEntidadManual)
			{
				TdtbcEntidad entPer=new TdtbcEntidad();
				entPer.setvCodentidad(nroDoc);
				entPer.setvCodtipodocid(tipoDoc);
				entPer.setvDesnombre(nombres.toUpperCase()+" "+apellidoPat.toUpperCase()+" "+apellidoMat.toUpperCase());
				if("09".equals(tipoDoc))
				{
					entPer.setvDesnombre(razonSocial.toUpperCase());
				}
				entPer.setvDirentidad(" ");
				entPer.setvDescorreoe("");
				entPer.setvNomusureg("");
				entPer.setdFecreg(new Date());
				entPer.setvNomusumod("");
				entPer.setdFecmod(new Date());
				System.out.println("Fecha Registro:"+entPer.getdFecreg()+"Fecha Modificacion:"+entPer.getdFecmod());
				String horaRegistro=entPer.getdFecreg()+"";
				String horaModificacion=entPer.getdFecmod()+"";
				entPer.setvApepat(apellidoPat.toUpperCase());
				entPer.setvApemat(apellidoMat.toUpperCase());
				entPer.setvNombres(nombres.toUpperCase());
				entPer.setvFlgreniec("N");
				try {
					registrarDespatch.insertarEntidad(entPer);
					entidadSeleccionada=entPer;
					System.out.println("ENTIDAD REGISTRADA");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		}		
		//guardar tabla centrolab si no hay direcciones seleccionada del combo de direcciones existentes
		if(hayDirecciones)
		{
			System.out.println("Se selecciono una direccion existente");
		}
		else
		{
			TdtbdCentrolab nuevaDireccion= new TdtbdCentrolab();
			nuevaDireccion.setvCodentidad(entidadSeleccionada.getvCodentidad());
			nuevaDireccion.setvDircenlab(direccion.toUpperCase());
			nuevaDireccion.setvNomusureg(PGP_Usuario.getV_codusu());
			nuevaDireccion.setdFecreg(new Date());
			nuevaDireccion.setvNomusumod(PGP_Usuario.getV_codusu());
			nuevaDireccion.setdFecmod(new Date());
			nuevaDireccion.setvCoddep(v_coddep);
			nuevaDireccion.setvCodpro(v_codpro);
			nuevaDireccion.setvCoddis(v_coddis);
			try {
				nuevaDireccion.setnCodcenlab(registrarDespatch.getCorrelativoDireccionPorEntidad(entidadSeleccionada.getvCodentidad()));
				registrarDespatch.insertarDireccion(nuevaDireccion);
				System.out.println("DIRECCION REGISTRADA");
				direccionSeleccionada=nuevaDireccion;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}			
		
		TdmvcRegistro entReg=new TdmvcRegistro();
		entReg.setvNumanoreg(""+(Calendar.getInstance().get(Calendar.YEAR)));
		entReg.setnNumdep(new Short(PGP_Usuario.getN_numdep()));
		entReg.setnNumtipodoc(new Short("0"));
		entReg.setvNumreg(completarCon(getSiguienteCorrelativo(entReg.getvNumanoreg(), entReg.getnNumdep(), new Short("0")),10,"0",0)); //correlativo de tipo 0 y hacer update a correlativo, cuando no hay correlativo de año, dependencia del usuario logueado y tipo 0 insertar
		if(prioridad!=null && !"".equals(prioridad.trim()))
		{
			entReg.setnTippriori(new Short(prioridad));
		}
		else
		{
			entReg.setnTippriori(new Short("0"));
		}
		entReg.setdFecemision(new Date());
		entReg.setvNumticket("");
		entReg.setvNumanoexp("");
		entReg.setnNumdepexp(null);
		entReg.setvNumexpref("");
		entReg.setvNumanoregref("");
		entReg.setnNumdepref(null);
		entReg.setnNumtipodocref(null);
		entReg.setvNumregref("");
		entReg.setnNumitemref(null);
		entReg.setnNumenvioref(null);
		entReg.setvTiporigen("E");
		entReg.setvCodentidad(entidadSeleccionada.getvCodentidad());
		if(hayDirecciones)
		{
			entReg.setnCodcenlab(new Short(direccionCombo));//si se selecciona una direccion existente
		}
		else
		{
			entReg.setnCodcenlab(direccionSeleccionada.getnCodcenlab());//primero guardar centrolab y setear variable centrolabseleccionado
		}		
		entReg.setdFecrecep(new Date());
		if(!"".equals(tipoDocRegistro.trim()) && tipoDocRegistro!=null)
		{
			entReg.setnTipodoc(new Short(tipoDocRegistro));			
		}
		else
		{
			entReg.setnTipodoc(null);
		}
		entReg.setvNumdoc(nroDocRegistro);
		entReg.setdFecdoc(null);
		entReg.setvNumdocref("");
		//la dependencia destino si es tupa se obtiene de la tabla tupa sino se puede establecer con el autocompletado
		entReg.setnNumdepdest(dependenciaSeleccionada.getnNumdep());//por esta dependencia se filtrara la pantalla de generar cargo
		if(tupaSeleccionado!=null && "1".equals(tipoDoc2))
		{
			entReg.setnNumgrupo(tupaSeleccionado.getnNumgrupo());//solo guardar si es tupa
			entReg.setvCodtupa(tupaSeleccionado.getvCodtupa());//solo guardar si es tupa
		}
		else
		{
			entReg.setnNumgrupo(null);
			entReg.setvCodtupa("");
		}
		entReg.setvCodaccionante(entidadSeleccionada.getvCodentidad());
		entReg.setvCodpersonal(PGP_Usuario.getV_codpersonal());
		entReg.setnNumfolios(Integer.parseInt(nroFolios));
		entReg.setvDesasunto(asunto);
		entReg.setnFlganulado(null);
		entReg.setnFlgcorresp(null);
		entReg.setnFlggenera(null);
		entReg.setnFlgenviado(null);
		entReg.setvCodcorte("");
		entReg.setvAnocorte("");
		entReg.setvObservacion(observaciones!=null?observaciones:"");
		entReg.setvDestasas("");
		entReg.setvNomusureg(PGP_Usuario.getV_codusu());
		entReg.setdFecreg(new Date());
		entReg.setvNomusumod("");//entReg.setvNomusumod(PGP_Usuario.getV_codusu());
		entReg.setdFecmod(null);//entReg.setdFecmod(new Date());
		entReg.setvFlgproant("");
		entReg.setvNomusuario("");
		entReg.setvCoddireccion("");
		entReg.setvDirorg("");
		entReg.setnFlgtipotra(null);
		entReg.setvCodperdest("");
		entReg.setnFlgatendido(null);
		entReg.setnFlghistorico(null);
		entReg.setnFlgpendtupa(null);
		entReg.setnFlgcongreso(null);
		entReg.setdFecatendido(null);
		entReg.setdFechistorico(null);
		entReg.setnNumenvioref(null);
		entReg.setdFecregula(null);
		entReg.setvAsuntodetallado(asunto);
		if(hruta0!=null && hruta1!=null && !"".equals(hruta0.trim()) && !"".equals(hruta1.trim()))
		{
			entReg.setvNumhoja(hruta0);
			entReg.setvAniohoja(new Short(hruta1));
			//setear N_FLGASOCIA=1
			entReg.setnFlgasocia(new Short("1"));
		}
		else
		{//obtener correlativo de nuevo tipo doc HOJA RUTA UNIFICADA para tramite externo e interno
		 //CAMBIO: ya no se usara la tabla correlativo para este caso se usara la tabla	TDMVC_HOJARUTA
			entReg.setvNumhoja(completarCon(getSiguienteCorrelativoGlobal(new Short(entReg.getvNumanoreg())),10,"0",0));//correlativo global siempre inserta
			entReg.setvAniohoja(new Short(entReg.getvNumanoreg()));
			//setear N_FLGASOCIA=0
			entReg.setnFlgasocia(new Short("0"));
		}		
		entReg.setvFlgcom("");
		entReg.setvCodcom("");
		entReg.setvCodcong("");
		entReg.setnCodcarcon(null);
		entReg.setvFglofimay("");
		entReg.setvNomarch("");
		entReg.setvFlgacred("");
		entReg.setvFlgcosuco("N");
		entReg.setvFlgasig("");
		entReg.setvDescdoc("");//campo para guardar el nombre del archivo adjunto
		entReg.setvFlgusuasig("");
		entReg.setvCodper("");
		entReg.setvTipdocweb("");
		entReg.setvRegweb("");
		entReg.setvFlganexo("");
		entReg.setvNumproley("");
		entReg.setvAnoproley("");
		if((reqChoice!=null && reqChoice.length==requisitosTupaSeleccionado.size()) || !"1".equals(tipoDoc2))
		{//guardar en 0 si los requisitos estan todos chekados sino 1
			entReg.setnFlgtrex(new Short("0"));
		}
		else
		{
			entReg.setnFlgtrex(new Short("1"));
		}
		entReg.setnCodtram(new BigDecimal(tipoDoc2));
		
		//*****************************************************
		//INI - VALIDACION DE TIPO DE DOCUMENTO PARA CONGRESAL:
		//*****************************************************
		if("10".equalsIgnoreCase(tipoDoc2))
		{
			if(mostrarCongresistas){
				entReg.setvCodcong(codcong);
			}else if(mostrarComisiones){
				entReg.setvCodcom(codcom);
			}
			if(mostrarCongresales)
			{
				if(codcargocong!=null && !"".equals(codcargocong.trim()))
				{
					entReg.setnCodcarcon(new BigDecimal(codcargocong));
				}
				else
				{
					entReg.setnCodcarcon(null);
				}
				entReg.setvFglofimay(oficialMayor?"S":"N");
			}
		}
		//*****************************************************
		//FIN - VALIDACION DE TIPO DE DOCUMENTO PARA CONGRESAL
		//*****************************************************
		
		//entReg.setdFecrecmp(null);
		//entReg.setnNumdeprmp(null);
		try {
			registrarDespatch.insertarRegistro(entReg);
			System.out.println("REGISTRO GUARDADO");
			registroGuardado=entReg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//guardar requisitos chekeados si es tupa en TDMVD_REGREQTUPA
		if(tupaSeleccionado!=null && "1".equals(tipoDoc2))
		{			
			for (TdtbdReqtupa requisito: requisitosTupaSeleccionado){				
				TdmvdRegreqtupa entReq= new TdmvdRegreqtupa();
				entReq.setvNumanoreg(entReg.getvNumanoreg());
				entReq.setnNumdep(entReg.getnNumdep());
				entReq.setnNumtipodoc(entReg.getnNumtipodoc());
				entReq.setvNumreg(entReg.getvNumreg());
				entReq.setnNumgrupo(entReg.getnNumgrupo());
				entReq.setnNumdepdest(entReg.getnNumdepdest());
				entReq.setvCodtupa(entReg.getvCodtupa());
				entReq.setnNumreq(requisito.getnNumreq());
				boolean estaChekeado=false;
				for (int i = 0; i < reqChoice.length; i++) {
					if(reqChoice[i]==Integer.parseInt(""+requisito.getnNumreq()))
					{
						estaChekeado=true;
					}
				}
				entReq.setdFecregula(estaChekeado?new Date():null);
				entReq.setnFlgpresentado(estaChekeado?new Short("1"):new Short("0"));
				if(!estaChekeado)
				{
					if(requisitosTupaPendientes!=null)
					{
						requisitosTupaPendientes.add(requisito);
					}
					else
					{
						requisitosTupaPendientes=new ArrayList<TdtbdReqtupa>();
						requisitosTupaPendientes.add(requisito);
					}
				}
				try {
					registrarDespatch.insertarRequisito(entReq);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		LoginDespatch loginDespatch = new LoginDespatch();
		try {
			horaRegistro = loginDespatch.ObtieneHora();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Registro guardado."));
		esGrabar=true;
	}
	
	public void imprimir()
	{
		if(tupaSeleccionado!=null && "1".equals(tipoDoc2) && requisitosTupaPendientes!=null)
		{//si es tupa y hay requisitos no chekeados
			try {
				RegistrarDespatch registrarDespatch=new RegistrarDespatch();					
				//Map parameters = new HashedMap();				
				Map parametros = new HashMap();
				parametros.put("PV_NUMREG", registroGuardado.getvNumreg());
				parametros.put("PN_NUMDEP", registroGuardado.getnNumdep());
				parametros.put("PV_NUMANOREG", registroGuardado.getvNumanoreg());
				parametros.put("PN_NUMTIPODOC", "0");
				
				Map parametros2 = new HashMap();
				parametros2.put("reqPendientes", requisitosTupaPendientes);
				parametros2.put("cur",registroGuardado.getvNumreg()+"-"+registroGuardado.getvNumanoreg());
				parametros2.put("hora",getFormatHour(registroGuardado.getdFecreg()));
				parametros2.put("fecha",getFormatDate(registroGuardado.getdFecreg()));
				parametros2.put("entidad",entidadSeleccionada.getvDesnombre());
				parametros2.put("tipoDoc",desTipo(entidadSeleccionada.getvCodtipodocid()));
				parametros2.put("nroDoc",entidadSeleccionada.getvCodentidad());	
				
				TdtbdCentrolab domicilio=new TdtbdCentrolab();
				try {
					domicilio=registrarDespatch.getDireccionPorEntidadYCodigo(entidadSeleccionada.getvCodentidad(), registroGuardado.getnCodcenlab());
				} catch (Exception e) {
					e.printStackTrace();
				}
				Combo entDep=dspcombos.departamentoByCod(domicilio.getvCoddep()).get(0);
				Combo entPro=dspcombos.provinciaByCod(domicilio.getvCoddep(), domicilio.getvCodpro()).get(0);
				Combo entDis=dspcombos.distritoByCod(domicilio.getvCoddep(), domicilio.getvCodpro(), domicilio.getvCoddis()).get(0);
				
				parametros2.put("domicilio",domicilio.getvDircenlab()+", "+entDep.getV_descripcion()+", "+entPro.getV_descripcion()+", "+entDis.getV_descripcion());
				parametros2.put("asunto",registroGuardado.getvDesasunto());
				parametros2.put("hr", registroGuardado.getvNumhoja()+"-"+registroGuardado.getvAniohoja());
				
				List<Map>  lstHR=registrarDespatch.reporteHojaRuta(parametros);
				List<Map>  dummyList=new ArrayList<Map>();
				dummyList.add(parametros2);
				System.out.println("Recupera la lista de "+lstHR.size());
				
				FacesUtils.mostrarDosReportesJasper(parametros, parametros2, "rptHojaRutaInterna.jasper", "actaObservacion.jasper", lstHR, dummyList, "HojaDeRutaYActaObservacion");
				System.out.println("Muestra reporte");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		else
		{//no es tupa
			imprimeSoloHojaRuta();
		}
	}
	
	public void imprimeSoloHojaRuta()
	{
		try {
			RegistrarDespatch registrarDespatch=new RegistrarDespatch();					
			//Map parameters = new HashedMap();			
			Map parametros = new HashMap();
			parametros.put("PV_NUMREG", registroGuardado.getvNumreg());
			parametros.put("PN_NUMDEP", registroGuardado.getnNumdep());
			parametros.put("PV_NUMANOREG", registroGuardado.getvNumanoreg());
			parametros.put("PN_NUMTIPODOC", "0");
			List<Map>  lstHR=registrarDespatch.reporteHojaRuta(parametros);
			System.out.println("Recupera la lista de "+lstHR.size());
			//FacesUtils.mostrarReporte(parameters, "rptHojaRutaInterna.jrxml", lstHR, "HojaDeRuta");//mas tiempo de compilacion
			FacesUtils.mostrarReporteJasper(parametros, "rptHojaRutaInterna.jasper", lstHR, "HojaDeRuta");//sin tiempo de compilacion solo da fill
			System.out.println("Muestra reporte");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String getFormatHour(Date date) {
        return new SimpleDateFormat("HH:mm").format(date);        
    }
	
	public String desTipo(String tipo)
	{
		return ("03".equals(tipo)?"DNI":"09".equals(tipo)?"RUC":"06".equals(tipo)?"CARNET DE EXTRANJERIA":"08".equals(tipo)?"PASAPORTE":"");
	}
	
	public void addNDireccion()
	{
		hayDirecciones=!hayDirecciones;
	}
	
	public void selectEntidadByRS(TdtbcEntidad item)
	{
		entidadSeleccionada=item;
		nombres="";
		apellidoPat="";
		apellidoMat="";
		nroDoc=entidadSeleccionada.getvCodentidad();
		razonSocial=entidadSeleccionada.getvDesnombre();
		esDNI=false;
		esRUC=true;
		hayRegEntidadManual=false;
		obtenerDirecciones(entidadSeleccionada.getvCodentidad());
	}
	
	public void buscarRazonSocial()
	{
		if(rsPopUp!=null && !"".equals(rsPopUp.trim()))
		{
			if(rsPopUp.trim().length()<5)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar al menos 5 letras."));
				return;
			}
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingrese una razón social."));
			return;
		}
		
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			listaEmpresaPopUp=registrarDespatch.getEntidadPorRazonSocial(rsPopUp.toUpperCase());
		} catch (Exception e) {
			listaEmpresaPopUp=null;
			e.printStackTrace();
		}
	}
	
	public void dialogRS(){
		//reset busqueda rs
		rsPopUp="";
		listaEmpresaPopUp=null;
		//end reset busqueda rs
		RequestContext.getCurrentInstance().execute("dialogWidgetRS.show()");
	}
	
	public void cleanHR()
	{
		hruta0="";
		hruta1="";
	}
	public void validarRuc(){
		
		System.out.println("Ruc:"+nroRuc);
		if(nroRuc!=null && !(nroRuc.trim()).equals("") ){
			if(nroRuc.length()<11){
				mostrarMensajeError("Ruc Invalido", "Debe tener 11 digitos");
				return;
				}
			System.out.println("Entro a validar Ruc: ");
			mostrarMensaje=true;
			setMensaje(validaRuc(nroRuc));
		}else
		{
			mostrarMensajeError("Ruc Invalido", "Ruc Vacio");
		}
		
	}
	
	private void mostrarMensajeCompetenciaInspectiva(boolean esMTPE, String msg){
		if(esMTPE)
		{
			mostrarMensajeRojo=mostrarMensaje && true;
			mostrarMensajeAzul=false;
			mostrarMensajeFatal("Competetencia Inspectiva",msg);
		}
		else
		{
			mostrarMensajeAzul=mostrarMensaje && true;
			mostrarMensajeRojo=false;
			mostrarMensajeInfo("Competetencia Inspectiva",msg);
		}
	}
	
	public String validaRuc(String nroDoc){
		RegistrarDespatch registrarDespatch= new RegistrarDespatch();
		String msg1="Estimado Usuario, la empresa: "+ razonSocial+" es de competencia ",msg2="El Ruc ingresado es de competencia";
		String mtpe=" del MTPE",sunafil=" de SUNAFIL";
		try {
			int pertenece=registrarDespatch.pertenece_Sunafil(nroDoc);
			boolean esMTPE=false;
			if(pertenece>0){
				msg1+=mtpe;
				msg2+=mtpe;
				esMTPE=true;
			}else{
				msg1+=sunafil;
				msg2+=sunafil;
				esMTPE=false;
			}
			if(razonSocial!=null && !razonSocial.trim().equals(""))//Caso en que el nro de documento es ruc
			{
				mostrarMensajeCompetenciaInspectiva(esMTPE, msg1);
			}				
			else//caso en que el nro doc no es ruc y aparece la opcion de ingresar ruc
			{
				mostrarMensajeCompetenciaInspectiva(esMTPE, msg2);
			}
				
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			mostrarMensajeError("Competetencia Inspectiva"," EXCEPTION");
			e1.printStackTrace();
			msg2="ERROR";
		}
		//msg2.
		return msg2;
	}
	
	
	
	public void mostrarMensajeInfo(String titulo,String msg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, msg));
		
	}
	public void mostrarMensajeError(String titulo,String msg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, msg));
		
	}
	public void mostrarMensajeFatal(String titulo,String msg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, msg));
		
	}

	public boolean isMostrarMensajeRojo() {
		return mostrarMensajeRojo;
	}

	public void setMostrarMensajeRojo(boolean mostrarMensajeRojo) {
		this.mostrarMensajeRojo = mostrarMensajeRojo;
	}

	public boolean isMostrarMensajeAzul() {
		return mostrarMensajeAzul;
	}

	public void setMostrarMensajeAzul(boolean mostrarMensajeAzul) {
		this.mostrarMensajeAzul = mostrarMensajeAzul;
	}

	


}
