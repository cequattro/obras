package pe.gob.sunafil.tramiteext.managedBeans;

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

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import pe.client.ClientePIDE;
import pe.gob.sunafil.tramiteext.bean.AsociacionPorPersona;
import pe.gob.sunafil.tramiteext.bean.Combo;
import pe.gob.sunafil.tramiteext.bean.Permisos;
import pe.gob.sunafil.tramiteext.bean.Persona;
import pe.gob.sunafil.tramiteext.bean.Usuario;
import pe.gob.sunafil.tramiteext.funciones.Funciones;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.BandejaDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.CombosDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.ConsultaDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.PersonaDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.PersonaReniecDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.RegistrarDespatch;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocide;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbComisiones;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbCongresistas;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcCargocongres;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTipodoctramite;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTramite;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdCentrolab;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdTupa;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex;
import pe.gob.sunafil.tramiteext.persistence.model.VstDireccionestrex;
import pe.gob.sunafil.tramiteext.reniecws.ReniecWebService;
import pe.gob.sunafil.tramiteext.siit.persistence.model.VstSiitToTramite;
import pe.gob.sunafil.tramiteext.utils.EnviarMail;
import pe.gob.sunafil.tramiteext.utils.FacesUtils;
import pe.gob.sunat.servicio2.registro.consultaruc.bean.BeanDdp;

@ManagedBean(name="bandejaBean")
@SessionScoped
public class BandejaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5154405390560909774L;
	
	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;	
	@ManagedProperty("#{loginBean.PGP_Permisos}")
	private Permisos PGP_Permisos;

	private static Logger logger = Logger.getLogger(MenuBean.class.getName());	
	
	//BANDEJA REGISTRADOS
	private List <VstBandejastrex> bandejaRegistrados;
	private Date fechaI=new Date();
	private Date fechaF=new Date();
	private String vAniohoja;
	private String vNumhoja;
	private String vCodtipodocid;
	private String vCodentidad;
	
	//BANDEJA OBSERVADOS
	private List <VstBandejastrex> bandejaObservados;
	private Date fechaIO=new Date();
	private Date fechaFO=new Date();
	private String vAniohojaO;
	private String vNumhojaO;
	private String vCodtipodocidO;
	private String vCodentidadO;
	
	//BANDEJA NO PRESENTADOS
	private List <VstBandejastrex> bandejaNoPresentados;
	private Date fechaINP=new Date();
	private Date fechaFNP=new Date();
	private String vAniohojaNP;
	private String vNumhojaNP;
	private String vCodtipodocidNP;
	private String vCodentidadNP;
	
	//BUSQUEDA RAPIDA
	private String hojaRuta;
	private String anioHR0;
	private List <VstBandejastrex> bandejaDecisor;
	
	//BANDEJAS COMUN
	private VstBandejastrex itemAdjuntar;
	private UploadedFile file;
	private StreamedContent fileDownload;
	
	//EDITAR/SUBSANAR REGISTRO
	private String pageTitle;
	private String tipoDoc;
	private String nroDoc;
	private boolean esDNI=false;
	private boolean esRUC=false;	
	private String apellidoPat;	
	private String apellidoMat;	
	private String nombres;
	private String razonSocial;
	private String v_coddep;
	private String v_codpro;
	private String v_coddis;
	private List<Combo> listaProvincias;
	private List<Combo> listaDistritos;	
	private CombosDespatch dspcombos = new CombosDespatch();
	private TdtbdCentrolab direccionActual;	
	private String direccion;
	private String hruta0;	
	private String hruta1;
	private String tipoDoc2;
	private String tupa;
	private String tupaDes;
	private boolean mostrarFieldsTupa=false;	
	private boolean mostrarCongresales=false;
	private String tipoDocRegistro;
	private String nroDocRegistro;
	private String txt1;
	private String nroFolios;
	private String observaciones;
	private String asunto;
	private String prioridad;
	private int[] reqChoice;
	private List <TdtbdReqtupa> requisitosTupaSeleccionado;
	private List <TdtbdReqtupa> requisitosTupaAll;
	private TdtbdTupa tupaSeleccionado;
	private List <TdmvdRegreqtupa> requisitosSeleccionados;	
	private List <TdmvdRegreqtupa> requisitosAll;
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
	private TdmvcRegistro registroSeleccionado;
	private VstBandejastrex itemSeleccionado;
	private List <TdtbdReqtupa> requisitosTupaPendientes;	
	private List <TdtbcDependencia> dependenciasAutocomplete;
	private TdtbcDependencia dependenciaSeleccionada;
	private String fecha;
	private String hora;
	private TdtbcEntidad entidadSeleccionada;
	private boolean hayRegEntidadManual=false;
	private List <VstDireccionestrex> direccionesEntSeleccionada;
	private BeanDdp datosRUC;
	private boolean hayDirecciones=false;
	private List <AsociacionPorPersona> asociacionPorPersona;
	private PersonaDespatch pd;
	private String direccionCombo;
	private String direccionNueva;
	private VstDireccionestrex direccionActualVista;
	private TdtbdCentrolab direccionSeleccionada;
	private List <TdtbcTramite> listaTipoTramite;		
	
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
	private List <TdtbcTipodoctramite> listaTipoDocTra;
	private List <TdtbcCargocongres> listaCargosCongresales;
	//FIN PARA LOS DOCUMENTOS CONGRESALES		
	
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
	
	public boolean isMostrarCongresales() {
		return mostrarCongresales;
	}

	public String getCodcargocong() {
		return codcargocong;
	}

	public void setCodcargocong(String codcargocong) {
		this.codcargocong = codcargocong;
	}

	public boolean isOficialMayor() {
		return oficialMayor;
	}

	public void setOficialMayor(boolean oficialMayor) {
		this.oficialMayor = oficialMayor;
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

	public void setMostrarCongresales(boolean mostrarCongresales) {
		this.mostrarCongresales = mostrarCongresales;
	}

	public List<TdmvdRegreqtupa> getRequisitosAll() {
		return requisitosAll;
	}

	public void setRequisitosAll(List<TdmvdRegreqtupa> requisitosAll) {
		this.requisitosAll = requisitosAll;
	}

	public List<TdtbdReqtupa> getRequisitosTupaAll() {
		return requisitosTupaAll;
	}

	public void setRequisitosTupaAll(List<TdtbdReqtupa> requisitosTupaAll) {
		this.requisitosTupaAll = requisitosTupaAll;
	}

	public List<TdtbcTramite> getListaTipoTramite() {		
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			listaTipoTramite=registrarDespatch.getTipoTramiteSinTupa();
		} catch (Exception e) {
			listaTipoTramite=null;
			e.printStackTrace();
		}
		return listaTipoTramite;
	}

	public void setListaTipoTramite(List<TdtbcTramite> listaTipoTramite) {
		this.listaTipoTramite = listaTipoTramite;
	}
	
	public TdtbdCentrolab getDireccionSeleccionada() {
		return direccionSeleccionada;
	}

	public void setDireccionSeleccionada(TdtbdCentrolab direccionSeleccionada) {
		this.direccionSeleccionada = direccionSeleccionada;
	}

	public VstDireccionestrex getDireccionActualVista() {
		return direccionActualVista;
	}

	public void setDireccionActualVista(VstDireccionestrex direccionActualVista) {
		this.direccionActualVista = direccionActualVista;
	}
	
	public String getDireccionNueva() {
		return direccionNueva;
	}

	public void setDireccionNueva(String direccionNueva) {
		this.direccionNueva = direccionNueva;
	}

	public TdtbcEntidad getEntidadSeleccionada() {
		return entidadSeleccionada;
	}

	public void setEntidadSeleccionada(TdtbcEntidad entidadSeleccionada) {
		this.entidadSeleccionada = entidadSeleccionada;
	}
	
	public boolean isHayRegEntidadManual() {
		return hayRegEntidadManual;
	}

	public void setHayRegEntidadManual(boolean hayRegEntidadManual) {
		this.hayRegEntidadManual = hayRegEntidadManual;
	}
	
	public List<VstDireccionestrex> getDireccionesEntSeleccionada() {
		return direccionesEntSeleccionada;
	}

	public void setDireccionesEntSeleccionada(
			List<VstDireccionestrex> direccionesEntSeleccionada) {
		this.direccionesEntSeleccionada = direccionesEntSeleccionada;
	}
	
	public BeanDdp getDatosRUC() {
		return datosRUC;
	}

	public void setDatosRUC(BeanDdp datosRUC) {
		this.datosRUC = datosRUC;
	}
	
	public boolean isHayDirecciones() {
		return hayDirecciones;
	}

	public void setHayDirecciones(boolean hayDirecciones) {
		this.hayDirecciones = hayDirecciones;
	}
	
	public List<AsociacionPorPersona> getAsociacionPorPersona() {
		return asociacionPorPersona;
	}

	public void setAsociacionPorPersona(
			List<AsociacionPorPersona> asociacionPorPersona) {
		this.asociacionPorPersona = asociacionPorPersona;
	}
	
	public String getDireccionCombo() {
		return direccionCombo;
	}

	public void setDireccionCombo(String direccionCombo) {
		this.direccionCombo = direccionCombo;
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

	public List<VstBandejastrex> getBandejaDecisor() {
		return bandejaDecisor;
	}

	public void setBandejaDecisor(List<VstBandejastrex> bandejaDecisor) {
		this.bandejaDecisor = bandejaDecisor;
	}

	public List<TdtbdReqtupa> getRequisitosTupaPendientes() {
		return requisitosTupaPendientes;
	}

	public void setRequisitosTupaPendientes(
			List<TdtbdReqtupa> requisitosTupaPendientes) {
		this.requisitosTupaPendientes = requisitosTupaPendientes;
	}

	public VstBandejastrex getItemSeleccionado() {
		return itemSeleccionado;
	}

	public void setItemSeleccionado(VstBandejastrex itemSeleccionado) {
		this.itemSeleccionado = itemSeleccionado;
	}

	public TdmvcRegistro getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(TdmvcRegistro registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public List<VstSiitToTramite> getAsociacionPorInspeccion() {
		return asociacionPorInspeccion;
	}

	public void setAsociacionPorInspeccion(
			List<VstSiitToTramite> asociacionPorInspeccion) {
		this.asociacionPorInspeccion = asociacionPorInspeccion;
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
	
	public List <Map> getAsociacionPorHR() {
		return asociacionPorHR;
	}

	public void setAsociacionPorHR(List <Map> asociacionPorHR) {
		this.asociacionPorHR = asociacionPorHR;
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
	
	public List<TdmvdRegreqtupa> getRequisitosSeleccionados() {
		return requisitosSeleccionados;
	}

	public void setRequisitosSeleccionados(
			List<TdmvdRegreqtupa> requisitosSeleccionados) {
		this.requisitosSeleccionados = requisitosSeleccionados;
	}

	public TdtbdTupa getTupaSeleccionado() {
		return tupaSeleccionado;
	}

	public void setTupaSeleccionado(TdtbdTupa tupaSeleccionado) {
		this.tupaSeleccionado = tupaSeleccionado;
	}

	public List<TdtbdReqtupa> getRequisitosTupaSeleccionado() {
		return requisitosTupaSeleccionado;
	}

	public void setRequisitosTupaSeleccionado(
			List<TdtbdReqtupa> requisitosTupaSeleccionado) {
		this.requisitosTupaSeleccionado = requisitosTupaSeleccionado;
	}

	public int[] getReqChoice() {
		return reqChoice;
	}

	public void setReqChoice(int[] reqChoice) {
		this.reqChoice = reqChoice;
	}

	public String getTipoDoc2() {
		return tipoDoc2;
	}

	public void setTipoDoc2(String tipoDoc2) {
		this.tipoDoc2 = tipoDoc2;
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

	public boolean isMostrarFieldsTupa() {
		return mostrarFieldsTupa;
	}

	public void setMostrarFieldsTupa(boolean mostrarFieldsTupa) {
		this.mostrarFieldsTupa = mostrarFieldsTupa;
	}

	public String getTipoDocRegistro() {
		return tipoDocRegistro;
	}

	public void setTipoDocRegistro(String tipoDocRegistro) {
		this.tipoDocRegistro = tipoDocRegistro;
	}

	public String getNroDocRegistro() {
		return nroDocRegistro;
	}

	public void setNroDocRegistro(String nroDocRegistro) {
		this.nroDocRegistro = nroDocRegistro;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public String getNroFolios() {
		return nroFolios;
	}

	public void setNroFolios(String nroFolios) {
		this.nroFolios = nroFolios;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
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
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TdtbdCentrolab getDireccionActual() {
		return direccionActual;
	}

	public void setDireccionActual(TdtbdCentrolab direccionActual) {
		this.direccionActual = direccionActual;
	}

	public String getV_coddep() {
		return v_coddep;
	}

	public void setV_coddep(String v_coddep) {
		this.v_coddep = v_coddep;
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

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
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

	public VstBandejastrex getItemAdjuntar() {
		return itemAdjuntar;
	}

	public void setItemAdjuntar(VstBandejastrex itemAdjuntar) {
		this.itemAdjuntar = itemAdjuntar;
	}

	public String getHojaRuta() {
		return hojaRuta;
	}

	public void setHojaRuta(String hojaRuta) {
		this.hojaRuta = hojaRuta;
	}

	public String getAnioHR0() {
		return anioHR0;
	}

	public void setAnioHR0(String anioHR0) {
		this.anioHR0 = anioHR0;
	}	
	
	public List<VstBandejastrex> getBandejaNoPresentados() {
		return bandejaNoPresentados;
	}

	public void setBandejaNoPresentados(List<VstBandejastrex> bandejaNoPresentados) {
		this.bandejaNoPresentados = bandejaNoPresentados;
	}

	public Date getFechaINP() {
		return fechaINP;
	}

	public void setFechaINP(Date fechaINP) {
		this.fechaINP = fechaINP;
	}

	public Date getFechaFNP() {
		return fechaFNP;
	}

	public void setFechaFNP(Date fechaFNP) {
		this.fechaFNP = fechaFNP;
	}

	public String getvAniohojaNP() {
		return vAniohojaNP;
	}

	public void setvAniohojaNP(String vAniohojaNP) {
		this.vAniohojaNP = vAniohojaNP;
	}

	public String getvNumhojaNP() {
		return vNumhojaNP;
	}

	public void setvNumhojaNP(String vNumhojaNP) {
		this.vNumhojaNP = vNumhojaNP;
	}

	public String getvCodtipodocidNP() {
		return vCodtipodocidNP;
	}

	public void setvCodtipodocidNP(String vCodtipodocidNP) {
		this.vCodtipodocidNP = vCodtipodocidNP;
	}

	public String getvCodentidadNP() {
		return vCodentidadNP;
	}

	public void setvCodentidadNP(String vCodentidadNP) {
		this.vCodentidadNP = vCodentidadNP;
	}	
	
	public List<VstBandejastrex> getBandejaObservados() {
		return bandejaObservados;
	}

	public void setBandejaObservados(List<VstBandejastrex> bandejaObservados) {
		this.bandejaObservados = bandejaObservados;
	}

	public Date getFechaIO() {
		return fechaIO;
	}

	public void setFechaIO(Date fechaIO) {
		this.fechaIO = fechaIO;
	}

	public Date getFechaFO() {
		return fechaFO;
	}

	public void setFechaFO(Date fechaFO) {
		this.fechaFO = fechaFO;
	}

	public String getvAniohojaO() {
		return vAniohojaO;
	}

	public void setvAniohojaO(String vAniohojaO) {
		this.vAniohojaO = vAniohojaO;
	}

	public String getvNumhojaO() {
		return vNumhojaO;
	}

	public void setvNumhojaO(String vNumhojaO) {
		this.vNumhojaO = vNumhojaO;
	}

	public String getvCodtipodocidO() {
		return vCodtipodocidO;
	}

	public void setvCodtipodocidO(String vCodtipodocidO) {
		this.vCodtipodocidO = vCodtipodocidO;
	}

	public String getvCodentidadO() {
		return vCodentidadO;
	}

	public void setvCodentidadO(String vCodentidadO) {
		this.vCodentidadO = vCodentidadO;
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

	public String getvAniohoja() {
		return vAniohoja;
	}

	public void setvAniohoja(String vAniohoja) {
		this.vAniohoja = vAniohoja;
	}

	public String getvNumhoja() {
		return vNumhoja;
	}

	public void setvNumhoja(String vNumhoja) {
		this.vNumhoja = vNumhoja;
	}

	public String getvCodtipodocid() {
		return vCodtipodocid;
	}

	public void setvCodtipodocid(String vCodtipodocid) {
		this.vCodtipodocid = vCodtipodocid;
	}

	public String getvCodentidad() {
		return vCodentidad;
	}

	public void setvCodentidad(String vCodentidad) {
		this.vCodentidad = vCodentidad;
	}	
	
	public List<VstBandejastrex> getBandejaRegistrados() {
		return bandejaRegistrados;
	}

	public void setBandejaRegistrados(List<VstBandejastrex> bandejaRegistrados) {
		this.bandejaRegistrados = bandejaRegistrados;
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

	public BandejaBean()
	{
		hojaRuta="HOJA DE RUTA";
		anioHR0=""+(Calendar.getInstance().get(Calendar.YEAR));
	}
	
	public String bandejaRegistrados(){
		//PARA QUE CARGUE LO DEL DIA POR DEFAULT CADA VEZ QUE INGRESA				
		fechaI=new Date();
		fechaF=new Date();
		vAniohoja=null;
		vNumhoja=null;
		vCodtipodocid=null;
		vCodentidad=null;
		buscarBandejaRegistrados();
		//END DEFAULT
		String vista="pretty:banRegPretty";
        //CODIGO
        return  vista;
	}
	
	public String bandejaObservados(){
		//PARA QUE CARGUE LO DEL DIA POR DEFAULT CADA VEZ QUE INGRESA				
		fechaIO=new Date();
		fechaFO=new Date();
		vAniohojaO=null;
		vNumhojaO=null;
		vCodtipodocidO=null;
		vCodentidadO=null;
		buscarBandejaObservados();
		//END DEFAULT
		String vista="pretty:banObsPretty";
        //CODIGO
        return  vista;
	}
	
	public String bandejaNoPresentados(){
		//PARA QUE CARGUE LO DEL DIA POR DEFAULT CADA VEZ QUE INGRESA				
		fechaINP=new Date();
		fechaFNP=new Date();
		vAniohojaNP=null;
		vNumhojaNP=null;
		vCodtipodocidNP=null;
		vCodentidadNP=null;
		buscarBandejaNoPresentados();
		//END DEFAULT
		String vista="pretty:banNopPretty";
        //CODIGO
        return  vista;
	}
	
	public String seleccionarDecisor(VstBandejastrex item)
	{
		String vistaSeleccionada = ""; 
		String vistaReg="pretty:banRegPretty";
		String vistaObs="pretty:banObsPretty";
		String vistaNPr="pretty:banNopPretty";

		if(item.getnFlgtrex()==0)
		{
			bandejaRegistrados=new ArrayList<VstBandejastrex>();
			bandejaRegistrados.add(item);
			vistaSeleccionada=vistaReg;
		}
		else if(item.getnFlgtrex()==1)
		{
			bandejaObservados=new ArrayList<VstBandejastrex>();
			bandejaObservados.add(item);
			vistaSeleccionada=vistaObs;
		}
		else if(item.getnFlgtrex()==2)
		{
			bandejaNoPresentados=new ArrayList<VstBandejastrex>();
			bandejaNoPresentados.add(item);
			vistaSeleccionada=vistaNPr;
		}		
        return vistaSeleccionada;
	}
	
	public String decisorBandeja()
	{
		//varibles temp se crearon para no conservar en sesion los parametros de busqueda rapida
		String hojaRutaTemp=hojaRuta;
		String anioHR0Temp=anioHR0;
		hojaRuta="HOJA DE RUTA";
		anioHR0=""+(Calendar.getInstance().get(Calendar.YEAR));
		String vistaSeleccionada="";
		String vistaPri="pretty:principal";
		String vistaReg="pretty:banRegPretty";
		String vistaObs="pretty:banObsPretty";
		String vistaNPr="pretty:banNopPretty";
		String vistaDec="pretty:banDecisorPretty";
		if(!"".equals(anioHR0Temp) && anioHR0Temp!=null && !"".equals(hojaRutaTemp) && hojaRutaTemp!=null && !"HOJA DE RUTA".equalsIgnoreCase(hojaRutaTemp))
		{
			System.out.println("Busqueda rápida validada");
		}
		else
		{
			vistaSeleccionada=vistaPri;
			System.out.println("Debe ingresar una hoja de ruta y año.");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar una hoja de ruta y año."));
			return vistaSeleccionada;
		}
		List<Short> shortValues = new ArrayList<Short>();
		BandejaDespatch bandejaDespatch = new BandejaDespatch();
		try {												
			bandejaDecisor=bandejaDespatch.getBandeja(PGP_Usuario.getN_numdep(), null, null, new Short(anioHR0Temp), completarCon(hojaRutaTemp,10,"0",0), null, null, null);
			for (VstBandejastrex registro: bandejaDecisor)
			{
				if(!shortValues.contains(registro.getnFlgtrex()))
				{
					shortValues.add(registro.getnFlgtrex());
				}				
			}
			if(shortValues.size()==0)
			{
				System.out.println("No hay registros con esos criterios");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No hay registros con esos criterios."));
				vistaSeleccionada=vistaPri;
				
				return vistaSeleccionada;
			}
			else if(shortValues.size()==1)
			{
				System.out.println("Hay registro de un solo estado");
				if(shortValues.get(0)==0)
				{
					System.out.println("En estado registrado");
					bandejaRegistrados=bandejaDecisor;
					vistaSeleccionada=vistaReg;
				}
				else if(shortValues.get(0)==1)
				{
					System.out.println("En estado observado");
					bandejaObservados=bandejaDecisor;
					vistaSeleccionada=vistaObs;
				}
				else if(shortValues.get(0)==2)
				{
					System.out.println("En estado no presentado");
					bandejaNoPresentados=bandejaDecisor;
					vistaSeleccionada=vistaNPr;
				}
			}
			else if(shortValues.size()>=2)
			{
				vistaSeleccionada=vistaDec;
			}
		} catch (Exception e) {
			bandejaDecisor=null;
			vistaSeleccionada=vistaPri;
			e.printStackTrace();
		}		
		return vistaSeleccionada;
	}
	
	public void buscarBandejaRegistrados()
	{
		if(fechaF==null && fechaI==null &&
		  (vNumhoja==null || "".equals(vNumhoja.trim())) && 
		  (vAniohoja==null || "".equals(vAniohoja.trim())) && 
		  (vCodtipodocid==null || "".equals(vCodtipodocid.trim())) && 
		  (vCodentidad==null || "".equals(vCodentidad.trim())))
		{
			bandejaRegistrados=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar o seleccionar al menos un filtro."));
			return;
		}		
		if(fechaF==null && fechaI!=null)
		{
			bandejaRegistrados=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Se requiere ingresar Fecha Desde y Fecha Hasta."));
            return;
		}
		if(fechaF!=null && fechaI==null)
		{
			bandejaRegistrados=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Se requiere ingresar Fecha Desde y Fecha Hasta."));
            return;
		}			
		if(fechaF!=null && fechaI!=null)
		{
			if(fechaF.before(fechaI))
			{
				bandejaRegistrados=null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "La fecha hasta debe ser mayor que la fecha desde."));
	            return;
			}
		}		
		BandejaDespatch bandejaDespatch = new BandejaDespatch();
		try {
			Date fechaFplus=fechaF;
			if(fechaF!=null)
			{
				Calendar c = Calendar.getInstance(); 
				c.setTime(fechaF); 
				c.add(Calendar.DATE, 1);
				fechaFplus = c.getTime();
			}						
			if("".equals(vAniohoja))
			{
				vAniohoja=null;
			}			
			bandejaRegistrados=bandejaDespatch.getBandeja(PGP_Usuario.getN_numdep(), fechaI, fechaF!=null?fechaFplus:null, vAniohoja!=null?new Short(vAniohoja):null, (vNumhoja!=null && !"".equals(vNumhoja))?completarCon(vNumhoja,10,"0",0):null, vCodtipodocid, vCodentidad, new Short("0"));
		} catch (Exception e) {
			bandejaRegistrados=null;
			e.printStackTrace();
		}
	}
	
	public void buscarBandejaObservados()
	{
		if(fechaFO==null && fechaIO==null &&
		  (vNumhojaO==null || "".equals(vNumhojaO.trim())) && 
		  (vAniohojaO==null || "".equals(vAniohojaO.trim())) && 
		  (vCodtipodocidO==null || "".equals(vCodtipodocidO.trim())) && 
		  (vCodentidadO==null || "".equals(vCodentidadO.trim())))
		{
			bandejaObservados=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar o seleccionar al menos un filtro."));
			return;
		}
		if(fechaFO==null && fechaIO!=null)
		{
			bandejaObservados=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Se requiere ingresar Fecha Desde y Fecha Hasta."));
            return;
		}
		if(fechaFO!=null && fechaIO==null)
		{
			bandejaObservados=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Se requiere ingresar Fecha Desde y Fecha Hasta."));
            return;
		}
		if(fechaFO!=null && fechaIO!=null)
		{
			if(fechaFO.before(fechaIO))
			{
				bandejaObservados=null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "La fecha hasta debe ser mayor que la fecha desde."));
	            return;
			}
		}
		BandejaDespatch bandejaDespatch = new BandejaDespatch();
		try {
			Date fechaFplusO=fechaFO;
			if(fechaFO!=null)
			{
				Calendar c = Calendar.getInstance(); 
				c.setTime(fechaFO); 
				c.add(Calendar.DATE, 1);
				fechaFplusO = c.getTime();
			}						
			if("".equals(vAniohojaO))
			{
				vAniohojaO=null;
			}			
			bandejaObservados=bandejaDespatch.getBandeja(PGP_Usuario.getN_numdep(), fechaIO, fechaFO!=null?fechaFplusO:null, vAniohojaO!=null?new Short(vAniohojaO):null, (vNumhojaO!=null && !"".equals(vNumhojaO))?completarCon(vNumhojaO,10,"0",0):null, vCodtipodocidO, vCodentidadO, new Short("1"));
		} catch (Exception e) {
			bandejaObservados=null;
			e.printStackTrace();
		}
	}
	
	public void buscarBandejaNoPresentados()
	{
		if(fechaFNP==null && fechaINP==null &&
		  (vNumhojaNP==null || "".equals(vNumhojaNP.trim())) && 
		  (vAniohojaNP==null || "".equals(vAniohojaNP.trim())) && 
		  (vCodtipodocidNP==null || "".equals(vCodtipodocidNP.trim())) && 
		  (vCodentidadNP==null || "".equals(vCodentidadNP.trim())))
		{
			bandejaNoPresentados=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar o seleccionar al menos un filtro."));
			return;
		}
		if(fechaFNP==null && fechaINP!=null)
		{
			bandejaNoPresentados=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Se requiere ingresar Fecha Desde y Fecha Hasta."));
            return;
		}
		if(fechaFNP!=null && fechaINP==null)
		{
			bandejaNoPresentados=null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Se requiere ingresar Fecha Desde y Fecha Hasta."));
            return;
		}
		if(fechaFNP!=null && fechaINP!=null)
		{
			if(fechaFNP.before(fechaINP))
			{
				bandejaNoPresentados=null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "La fecha hasta debe ser mayor que la fecha desde."));
	            return;
			}
		}
		BandejaDespatch bandejaDespatch = new BandejaDespatch();
		try {
			Date fechaFplusNP=fechaFNP;
			if(fechaFNP!=null)
			{
				Calendar c = Calendar.getInstance(); 
				c.setTime(fechaFNP); 
				c.add(Calendar.DATE, 1);
				fechaFplusNP = c.getTime();
			}						
			if("".equals(vAniohojaNP))
			{
				vAniohojaNP=null;
			}			
			bandejaNoPresentados=bandejaDespatch.getBandeja(PGP_Usuario.getN_numdep(), fechaINP, fechaFNP!=null?fechaFplusNP:null, vAniohojaNP!=null?new Short(vAniohojaNP):null, (vNumhojaNP!=null && !"".equals(vNumhojaNP))?completarCon(vNumhojaNP,10,"0",0):null, vCodtipodocidNP, vCodentidadNP, new Short("2"));
		} catch (Exception e) {
			bandejaNoPresentados=null;
			e.printStackTrace();
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
	
	public void imprimeHojaRuta(String vNumreg, Short nNumdep, String vNumanoreg)
	{
		try {
			RegistrarDespatch registrarDespatch=new RegistrarDespatch();					
			//Map parameters = new HashedMap();			
			Map parametros = new HashMap();
			parametros.put("PV_NUMREG", vNumreg);
			parametros.put("PN_NUMDEP", nNumdep);
			parametros.put("PV_NUMANOREG", vNumanoreg);
			parametros.put("PN_NUMTIPODOC", "0");
			System.out.println("RPT "+vNumreg+"-"+nNumdep+"-"+vNumanoreg+" 0");
			List<Map>  lstHR=registrarDespatch.reporteHojaRuta(parametros);
			System.out.println("Recupera la lista de "+lstHR.size());
			//FacesUtils.mostrarReporte(parameters, "rptHojaRutaInterna.jrxml", lstHR, "HojaDeRuta");//mas tiempo de compilacion
			FacesUtils.mostrarReporteJasper(parametros, "rptHojaRutaInterna.jasper", lstHR, "HojaDeRuta");//sin tiempo de compilacion solo da fill
			System.out.println("Muestra reporte");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void imprimeActaObservado(VstBandejastrex item)
	{
		try {
			RegistrarDespatch registrarDespatch=new RegistrarDespatch();					
			BandejaDespatch bandejaDespatch=new BandejaDespatch();
			//Map parameters = new HashedMap();			
			Map parametros2 = new HashMap();
			parametros2.put("reqPendientes", bandejaDespatch.getRequisitosPendientes(item));
			parametros2.put("cur",item.getvNumreg()+"-"+item.getvNumanoreg());
			parametros2.put("hora",item.getDfecregmask().substring(11));
			parametros2.put("fecha",item.getDfecregmask().substring(0,10));
			parametros2.put("entidad",item.getvDesnombre());
			parametros2.put("tipoDoc",desTipo(item.getvCodtipodocid()));
			parametros2.put("nroDoc",item.getvCodentidad());	
			
			TdtbdCentrolab domicilio=new TdtbdCentrolab();
			try {
				domicilio=registrarDespatch.getDireccionPorEntidadYCodigo(item.getvCodentidad(), item.getnCodcenlab());
			} catch (Exception e) {
				e.printStackTrace();
			}
			Combo entDep=dspcombos.departamentoByCod(domicilio.getvCoddep()).get(0);
			Combo entPro=dspcombos.provinciaByCod(domicilio.getvCoddep(), domicilio.getvCodpro()).get(0);
			Combo entDis=dspcombos.distritoByCod(domicilio.getvCoddep(), domicilio.getvCodpro(), domicilio.getvCoddis()).get(0);
			
			parametros2.put("domicilio",domicilio.getvDircenlab()+", "+entDep.getV_descripcion()+", "+entPro.getV_descripcion()+", "+entDis.getV_descripcion());
			parametros2.put("asunto",item.getvAsuntodetallado());
			parametros2.put("hr", item.getvNumhoja()+"-"+item.getvAniohoja());
			
			List<Map>  dummyList=new ArrayList<Map>();
			dummyList.add(parametros2);
			
			FacesUtils.mostrarReporteJasper(parametros2, "actaObservacion.jasper", dummyList, "ActaObservado");
			System.out.println("Muestra reporte");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void imprimeActaNoPresentado(VstBandejastrex item)
	{
		try {
			RegistrarDespatch registrarDespatch=new RegistrarDespatch();					
			BandejaDespatch bandejaDespatch=new BandejaDespatch();
			//Map parameters = new HashedMap();			
			Map parametros2 = new HashMap();
			parametros2.put("cur",item.getvNumreg()+"-"+item.getvNumanoreg());
			parametros2.put("hora",getFormatHour(item.getdFecreg()));
			parametros2.put("fecha",getFormatDate(item.getdFecreg()));
			parametros2.put("horaActual",getFormatHour(new Date()));
			parametros2.put("fechaActual",getFormatDate(new Date()));
			parametros2.put("entidad",item.getvDesnombre());
			parametros2.put("tipoDoc",desTipo(item.getvCodtipodocid()));
			parametros2.put("nroDoc",item.getvCodentidad());				
			
			TdtbdCentrolab domicilio=new TdtbdCentrolab();
			try {
				domicilio=registrarDespatch.getDireccionPorEntidadYCodigo(item.getvCodentidad(), item.getnCodcenlab());
			} catch (Exception e) {
				e.printStackTrace();
			}
			Combo entDep=dspcombos.departamentoByCod(domicilio.getvCoddep()).get(0);
			Combo entPro=dspcombos.provinciaByCod(domicilio.getvCoddep(), domicilio.getvCodpro()).get(0);
			Combo entDis=dspcombos.distritoByCod(domicilio.getvCoddep(), domicilio.getvCodpro(), domicilio.getvCoddis()).get(0);
			
			parametros2.put("domicilio",domicilio.getvDircenlab()+", "+entDep.getV_descripcion()+", "+entPro.getV_descripcion()+", "+entDis.getV_descripcion());
			parametros2.put("asunto",item.getvAsuntodetallado());
			parametros2.put("folios",""+item.getnNumfolios());
			parametros2.put("hr", item.getvNumhoja()+"-"+item.getvAniohoja());
			
			List<Map>  dummyList=new ArrayList<Map>();
			dummyList.add(parametros2);
			
			FacesUtils.mostrarReporteJasper(parametros2, "actaNoPresentado.jasper", dummyList, "ActaNoPresentado");
			System.out.println("Muestra reporte");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String getFormatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
	
	public String getFormatHour(Date date) {
        return new SimpleDateFormat("HH:mm").format(date);
    }
	
	public String getFormatStatus(Short value) {
        return (value==0)?"REGISTRADO":(value==1)?"OBSERVADO":(value==2)?"NO PRESENTADO":"";
    }
	
	public String desTipo(String tipo)
	{
		return ("03".equals(tipo)?"DNI":"09".equals(tipo)?"RUC":"06".equals(tipo)?"CARNET DE EXTRANJERIA":"08".equals(tipo)?"PASAPORTE":"");
	}
	
	public void dialogReferencia(VstBandejastrex item){		
		itemAdjuntar=item;
		RequestContext.getCurrentInstance().execute("dialogWidget.show()");
	}
	
	public void upload(int postLoad) {    	
		System.out.println("Entro a upload");
		BandejaDespatch bandejaDespatch=new BandejaDespatch();
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
				String rutaPdf=Funciones.ObtProp_Resources("ruta.pdfs");
				File file = new File(rutaPdf+"/"+itemAdjuntar.getvNumanoreg()+"-"+itemAdjuntar.getnNumdep()+"-"+itemAdjuntar.getnNumtipodoc()+"-"+itemAdjuntar.getvNumreg()+".pdf");
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
		        	bandejaDespatch.actualizarArchivo(itemAdjuntar);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
		        if(postLoad==1)
		        {
		        	buscarBandejaRegistrados();
		        }
		        else if(postLoad==2)
		        {
		        	buscarBandejaObservados();
		        }
		        else if(postLoad==3)
		        {
		        	buscarBandejaNoPresentados();
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
	
	public StreamedContent download(VstBandejastrex item)
    {    	
    	InputStream stream;
		try {
			String rutaPdf=Funciones.ObtProp_Resources("ruta.pdfs");
			stream = new FileInputStream(rutaPdf+"/"+item.getvNumanoreg()+"-"+item.getnNumdep()+"-"+item.getnNumtipodoc()+"-"+item.getvNumreg()+".pdf");
			//stream = new FileInputStream("D://Willy//pdf//"+item.getvNumanoreg()+"-"+item.getnNumdep()+"-"+item.getnNumtipodoc()+"-"+item.getvNumreg()+".pdf");
			fileDownload = new DefaultStreamedContent(stream, "application/pdf", "registro-"+item.getvNumanoreg()+"-"+item.getnNumdep()+"-"+item.getnNumtipodoc()+"-"+item.getvNumreg()+".pdf");
			return fileDownload;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}       
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
	
	public String editar(VstBandejastrex item, int title)
	{
		itemSeleccionado=item;
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		BandejaDespatch bandejaDespatch = new BandejaDespatch();
		try {
			entidadSeleccionada=registrarDespatch.getEntidadPorCodigo(item.getvCodentidad());
			obtenerDirecciones(entidadSeleccionada.getvCodentidad());
			direccionCombo=""+item.getnCodcenlab();
			String fechaHora=itemSeleccionado.getDfecregmask();
			fecha=fechaHora.substring(0,10);
			hora=fechaHora.substring(11);
		} catch (Exception e) {
			e.printStackTrace();
		}					
		pageTitle=title==0?"EDITAR":"SUBSANAR";
		tipoDoc=item.getvCodtipodocid();
		nroDoc=item.getvCodentidad();
		nombres=item.getvNombres();
		apellidoPat=item.getvApepat();
		apellidoMat=item.getvApemat();
		razonSocial=item.getvDesnombre();
		esDNI=("03".equals(tipoDoc)?true:"09".equals(tipoDoc)?false:"06".equals(tipoDoc)?true:"08".equals(tipoDoc)?true:false);
		esRUC=("03".equals(tipoDoc)?false:"09".equals(tipoDoc)?true:"06".equals(tipoDoc)?false:"08".equals(tipoDoc)?false:false);
		try {
			direccionActual=registrarDespatch.getDireccionPorEntidadYCodigo(nroDoc, item.getnCodcenlab());
			direccionActualVista=registrarDespatch.getDirPorCodigoYEntidad(nroDoc, item.getnCodcenlab());
		} catch (Exception e) {			
			e.printStackTrace();
			direccionActual=null;
		}
		if(direccionActual!=null)
		{
			direccion=direccionActualVista.getvDesdep()+" "+direccionActualVista.getvDespro()+" "+direccionActualVista.getvDesdis()+" "+direccionActual.getvDircenlab();
			v_coddep=direccionActual.getvCoddep();
			selCmbDepartamento();
			v_codpro=direccionActual.getvCodpro();
			selCmbProvincia();
			v_coddis=direccionActual.getvCoddis();			
		}		
		//hacer if de cargar solo si tiene N_FLGASOCIA=1 ::: lo hise despues de recuperar registroSeleccionado
		hruta0=item.getvNumhoja();
		hruta1=""+item.getvAniohoja();
		tipoDoc2=""+item.getnCodtram();
		itemChangeCategoria();
		tipoDocRegistro=""+item.getnTipodoc();
		nroDocRegistro=item.getvNumdoc();
		txt1=item.getvDesdep();
		try {
			dependenciaSeleccionada=registrarDespatch.getDependenciaPorCodigo(item.getnNumdepdest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		nroFolios=""+item.getnNumfolios();
		asunto=item.getvAsuntodetallado();
		observaciones=item.getvObservacion();
		prioridad=""+item.getnTippriori();
		//definir tupa, tupaDes, reqChoice desde bd si es tupa
		if("1".equals(tipoDoc2))
		{
			try {
				tupaSeleccionado=registrarDespatch.getProcedimientoPorKey(item.getnNumgrupo(), item.getnNumdepdest(), item.getvCodtupa());
				tupa=tupaSeleccionado.getvCodtupa();
				tupaDes=tupaSeleccionado.getvDestupa();
				//update 23/11/2016 historial tupa
				requisitosTupaAll=registrarDespatch.getRequisitosPorTupaAll(tupaSeleccionado);//lista completa de tupas sin tener en cuante flag activopara historial
				requisitosAll=registrarDespatch.getRequisitosAllPorRegistro(item.getvNumanoreg(), item.getnNumdep(), item.getnNumtipodoc(), item.getvNumreg());
				requisitosTupaSeleccionado=new ArrayList<TdtbdReqtupa>();
				//System.out.println("requisitosTupaAll ::"+requisitosTupaAll.size());
				//System.out.println("requisitosAll ::"+requisitosAll.size());
				//si existe en todos los requisitos historial añadir a seleccionables
				boolean flagExiste=false;
				for (Iterator iterator = requisitosTupaAll.iterator(); iterator
						.hasNext();) {
					flagExiste=false;
					TdtbdReqtupa row = (TdtbdReqtupa) iterator.next();
					//System.out.println("row :: "+row.getnNumgrupo()+"-"+row.getnNumdep()+"-"+row.getvCodtupa()+"-"+row.getnNumreq());
					for (Iterator iterator2 = requisitosAll.iterator(); iterator2
							.hasNext();) {
						TdmvdRegreqtupa row2 = (TdmvdRegreqtupa) iterator2.next();
						//System.out.println("row2 :: "+row2.getnNumgrupo()+"-"+row2.getnNumdepdest()+"-"+row2.getvCodtupa()+"-"+row2.getnNumreq());
						//PK es N_NUMGRUPO, N_NUMDEPDEST, V_CODTUPA, N_NUMREQ
						if(Integer.parseInt(row.getnNumgrupo()+"")==Integer.parseInt(row2.getnNumgrupo()+"") && 
						   Integer.parseInt(row.getnNumdep()+"")==Integer.parseInt(row2.getnNumdepdest()+"") &&
						   Integer.parseInt(row.getvCodtupa())==Integer.parseInt(row2.getvCodtupa()) &&
						   Integer.parseInt(row.getnNumreq()+"")==Integer.parseInt(row2.getnNumreq()+""))
						{
							//System.out.println("Entro a existe");
							flagExiste=true;
							break;
						}
					}
					if(flagExiste)
					{
						requisitosTupaSeleccionado.add(row);
						flagExiste=false;
					}
				}				
				//ANTIGUO requisitosTupaSeleccionado=registrarDespatch.getRequisitosPorTupa(tupaSeleccionado);
				//end update 23/11/2016 historial tupa				
				//pendiente recuperar reqChoice con un nuevo method data en imp de regreqtupa
				requisitosSeleccionados=registrarDespatch.getRequisitosSeleccionadosPorRegistro(item.getvNumanoreg(), item.getnNumdep(), item.getnNumtipodoc(), item.getvNumreg());
				reqChoice = new int[requisitosSeleccionados.size()];
				int ii=0;
				for (TdmvdRegreqtupa requisito: requisitosSeleccionados){
					reqChoice[ii]=requisito.getnNumreq();
					++ii;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		try {
			registroSeleccionado=bandejaDespatch.getRegistroPorKey(item.getvNumanoreg(), item.getnNumdep(), item.getnNumtipodoc(), item.getvNumreg());
			if("10".equals(tipoDoc2))
			{
				if(registroSeleccionado.getvCodcom()!=null)
				{
					mostrarComisiones=true;
					mostrarCongresistas=false;
					v_tipoOrigCongr="COMIS";
					codcom=registroSeleccionado.getvCodcom();	
					codcong="";
				}
				if(registroSeleccionado.getvCodcong()!=null)
				{
					mostrarCongresistas=true;
					mostrarComisiones=false;
					v_tipoOrigCongr="CONGR";
					codcong=registroSeleccionado.getvCodcong();
					codcom="";
				}
				codcargocong=""+registroSeleccionado.getnCodcarcon();
				oficialMayor="S".equalsIgnoreCase(registroSeleccionado.getvFglofimay());
			}
			if(registroSeleccionado.getnFlgasocia()==0)
			{
				hruta0="";
				hruta1="";
			}
		} catch (Exception e) {
			registroSeleccionado=null;
			e.printStackTrace();
		}
		String vista = "pretty:editarRegPretty"; 
        //CODIGO
        return vista;
	}
	
	public void itemChangeCategoria()
	{
		if(tipoDoc2 !=null)
		{
			if("1".equalsIgnoreCase(tipoDoc2))
			{//es tupa
				mostrarFieldsTupa=true;
				mostrarCongresales=false;
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
			}
			else
			{//no es tupa ni congresal
				mostrarFieldsTupa=false;
				mostrarCongresales=false;
			}
		}		
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
	
	public void dialogReferenciaHR(){			
		//para limpiar pop up
		hojaHR="";
		anioHR="";
		asociacionPorHR=null;
		RequestContext.getCurrentInstance().execute("dialogWidgetHR.show()");
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
	
	public void buscarHR()
	{
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
	
	public void selectReferencia(String item)
	{
		
		hruta0=item.split("-")[0].trim();
		hruta1=item.split("-")[1].trim();
		//pendiente setar intendencia en txt1
		//txt1="Intendencia de Lima Metropolitana";
		//pendiente setear asociacionSeleccionada;
	}
	
	public void buscarI()
	{
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
	
	public void selectReferenciaI(VstSiitToTramite item)
	{
		hruta0=item.getvNrohr();
		hruta1=item.getvAniohr();
		//pendiente setar intendencia en txt1
		//txt1="Intendencia de Lima Metropolitana";
		//pendiente setear asociacionSeleccionada;
	}
	
	public boolean validaFormulario()
	{
		//*****************************************************
		//INI - VALIDACION DE TIPO DE DOCUMENTO PARA CONGRESAL:
		//*****************************************************
		if("10".equals(tipoDoc2.trim())){
			if(tipoDocRegistro!=null && !"".equals(tipoDocRegistro.trim())){}
			else{				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Si ingresa el tipo de trámite Documento Congresal, debe seleccionar un tipo de documento."));
				return false;
			}
			if(mostrarCongresistas){
				if(codcong==null || "".equals(codcong)){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Por favor seleccione el Congresista."));
					return false;
				}
			}
			if(mostrarComisiones){
				if(codcom==null || "".equals(codcom)){					
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Por favor seleccione la Comisión."));
					return false;
				}
			}
			if(!mostrarComisiones && !mostrarCongresistas){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Por favor seleccione si el Documento Congresal es por comisión o por congresista."));
				return false;
			}
			/*if(codcargocong!=null && !"".equals(codcargocong.trim())){}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Por favor seleccione un cargo congresal."));
				return false;
			}*/
		}
		//*****************************************************
		//FIN - VALIDACION DE TIPO DE DOCUMENTO PARA CONGRESAL
		//*****************************************************
		if(dependenciaSeleccionada!=null && txt1!=null && !"".equals(txt1)){}//&& txt1!=null && !"".equals(txt1) ::: solo porsea borren
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingrese una dependencia destino."));
			return false;
		}
		if(nroFolios!=null && !"".equals(nroFolios.trim())){}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingrese numero de folios."));
			return false;
		}
		if(asunto!=null && !"".equals(asunto.trim())){}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingrese el asunto."));
			return false;
		}	
		if("ADMINISTRADOR".equals(PGP_Permisos.getV_desper()) || "DIRECTOR".equals(PGP_Permisos.getV_desper()))
		{
			if(tipoDoc!=null && !"".equals(tipoDoc.trim())){}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Seleccione un tipo de documento de remitente."));
				return false;
			}
			if(nroDoc!=null && !"".equals(nroDoc.trim()))
			{
				if("03".equals(tipoDoc) || "06".equals(tipoDoc) || "08".equals(tipoDoc))//valida campos de remitente
				{
					if(apellidoPat!=null && !"".equals(apellidoPat.trim()) && apellidoMat!=null && !"".equals(apellidoMat.trim()) && nombres!=null && !"".equals(nombres.trim())){}
					else
					{
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingrese una persona remitente."));
						return false;
					}
				}
				else if("09".equals(tipoDoc))
				{
					if(razonSocial!=null && !"".equals(razonSocial.trim())){}
					else
					{
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingrese razón social del remitente."));
						return false;
					}
				}
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingrese número de documento de remitente."));
				return false;
			}
			if(hayDirecciones)
			{//validar existencia de direccionCombo
				if(direccionCombo!=null && !"".equals(direccionCombo.trim())){}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingrese la dirección del remitente."));
					return false;
				}
			}
			else
			{//validar existencia de los campos de la nueva dirección ingresada
				if(v_coddep!=null && !"".equals(v_coddep.trim())){}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Seleccione departamento."));
					return false;
				}
				if(v_codpro!=null && !"".equals(v_codpro.trim())){}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Seleccione provincia."));
					return false;
				}
				if(v_coddis!=null && !"".equals(v_coddis.trim())){}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Seleccione distrito."));
					return false;
				}
				if(direccionNueva!=null && !"".equals(direccionNueva.trim())){}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Ingrese dirección."));
					return false;
				}
			}
			if(tipoDoc2!=null && !"".equals(tipoDoc2.trim())){}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Seleccione un tipo de tramite."));
				return false;
			}
			if(registroSeleccionado.getnFlgasocia()==1)
			{//validar HR no vacía
				if(hruta0!=null && !"".equals(hruta0.trim())){}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Seleccione una hoja de ruta."));
					return false;
				}
				if(hruta1!=null && !"".equals(hruta1.trim())){}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Seleccione una hoja de ruta."));
					return false;
				}
			}
		}
		return true;
	}
	
	public void grabar()
	{
		if("ADMINISTRADOR".equals(PGP_Permisos.getV_desper()) || "DIRECTOR".equals(PGP_Permisos.getV_desper()))
		{//---RUTINA PARA ADMIN Y DIRECTOR
			RegistrarDespatch registrarDespatch = new RegistrarDespatch();
			//si no es ni ruc ni dni entonces primero guardar persona en tabla entidad
			if(entidadSeleccionada!=null){}
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
					entPer.setvApepat(apellidoPat.toUpperCase());
					entPer.setvApemat(apellidoMat.toUpperCase());
					entPer.setvNombres(nombres.toUpperCase());
					entPer.setvFlgreniec("N");
					try {
						registrarDespatch.insertarEntidad(entPer);
						entidadSeleccionada=entPer;
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
				nuevaDireccion.setvDircenlab(direccionNueva.toUpperCase());
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
					direccionSeleccionada=nuevaDireccion;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}		
		}
		//---END RUTINA PARA ADMIN Y DIRECTOR
		//if(registroSeleccionado.getvAnocorte()!=null && registroSeleccionado.getvCodcorte()!=null)
		if(itemSeleccionado.getvAnocorte()!=null && itemSeleccionado.getvCodcorte()!=null && "OPERADOR".equals(PGP_Permisos.getV_desper()))
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Estimado Usuario, no se puede modificar debido a que se ha generado un cargo de envío."));
			return;
		}
		
		if(!validaFormulario())
		{			
			return;
		}
		
		BandejaDespatch bandejaDespatch = new BandejaDespatch();
		//ya no se setea la hoja de ruta por no ser un campo editable ni subsanable
		/*if(hruta0!=null && hruta1!=null && !"".equals(hruta0.trim()) && !"".equals(hruta1.trim()))
		{//revisar triggers after update porsea
			registroSeleccionado.setvNumhoja(hruta0);
			registroSeleccionado.setvAniohoja(new Short(hruta1));
		}*/
		//setea los campos en modo ADMINISTRADOR o DIRECTOR
		if("ADMINISTRADOR".equals(PGP_Permisos.getV_desper()) || "DIRECTOR".equals(PGP_Permisos.getV_desper()))
		{
			registroSeleccionado.setvCodentidad(entidadSeleccionada.getvCodentidad());
			registroSeleccionado.setvCodaccionante(entidadSeleccionada.getvCodentidad());
			if(hayDirecciones)
			{
				registroSeleccionado.setnCodcenlab(new Short(direccionCombo));//si se selecciona una direccion existente
			}
			else
			{
				registroSeleccionado.setnCodcenlab(direccionSeleccionada.getnCodcenlab());//primero guardar centrolab y setear variable centrolabseleccionado
			}
			registroSeleccionado.setnCodtram(new BigDecimal(tipoDoc2));
			System.out.println("Asociación es :: "+registroSeleccionado.getnFlgasocia());
			if(registroSeleccionado.getnFlgasocia()==1)
			{
				System.out.println("Replace HR on edit");
				registroSeleccionado.setvNumhoja(hruta0);
				registroSeleccionado.setvAniohoja(new Short(hruta1));
			}
		}
		//end setea los campos en modo ADMINISTRADOR o DIRECTOR
		System.out.println("tipoDocRegistro  ::: ["+tipoDocRegistro+"]");
		if(tipoDocRegistro!=null && !"".equals(tipoDocRegistro.trim()) && !"null".equals(tipoDocRegistro.trim()))
		{
			registroSeleccionado.setnTipodoc(new Short(tipoDocRegistro));
			registroSeleccionado.setvNumdoc(nroDocRegistro);
		}		
		else
		{
			registroSeleccionado.setnTipodoc(null);
			registroSeleccionado.setvNumdoc(null);
		}
		
		registroSeleccionado.setnNumdepdest(dependenciaSeleccionada.getnNumdep());
		
		registroSeleccionado.setnNumfolios(Integer.parseInt(nroFolios));
		registroSeleccionado.setvDesasunto(asunto);
		registroSeleccionado.setvAsuntodetallado(asunto);
		registroSeleccionado.setvObservacion(observaciones);
		if(prioridad!=null && !"".equals(prioridad.trim()))
		{
			registroSeleccionado.setnTippriori(new Short(prioridad));
		}	
		else
		{
			registroSeleccionado.setnTippriori(null);
		}
		if((reqChoice!=null && reqChoice.length==requisitosTupaSeleccionado.size()) || !"1".equals(tipoDoc2))
		{//guardar en 0 si los requisitos estan todos chekados sino 1
			registroSeleccionado.setnFlgtrex(new Short("0"));
		}
		else
		{
			registroSeleccionado.setnFlgtrex(new Short("1"));
		}
						
		//*****************************************************
		//INI - VALIDACION DE TIPO DE DOCUMENTO PARA CONGRESAL:
		//*****************************************************
		if("10".equalsIgnoreCase(tipoDoc2))
		{
			if(mostrarCongresistas){
				registroSeleccionado.setvCodcong(codcong);
			}else if(mostrarComisiones){
				registroSeleccionado.setvCodcom(codcom);
			}
			if(codcargocong!=null && !"".equals(codcargocong.trim()))
			{
				registroSeleccionado.setnCodcarcon(new BigDecimal(codcargocong));
			}	
			else
			{
				registroSeleccionado.setnCodcarcon(null);
			}
			registroSeleccionado.setvFglofimay(oficialMayor?"S":"N");
		}
		//*****************************************************
		//FIN - VALIDACION DE TIPO DE DOCUMENTO PARA CONGRESAL
		//*****************************************************
		
		try {
			registroSeleccionado.setdFecreg(null);//para que no actualize campo de fecha de registro al subsanar o actualizar
			registroSeleccionado.setdFecrecep(null);
			registroSeleccionado.setdFecemision(null);
			registroSeleccionado.setdFecmod(new Date());
			bandejaDespatch.actualizarRegistro(registroSeleccionado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//guardar requisitos chekeados si es tupa en TDMVD_REGREQTUPA
		if(tupaSeleccionado!=null && "1".equals(tipoDoc2))
		{			
			for (TdtbdReqtupa requisito: requisitosTupaSeleccionado){				
				TdmvdRegreqtupa entReq= new TdmvdRegreqtupa();
				entReq.setvNumanoreg(registroSeleccionado.getvNumanoreg());
				entReq.setnNumdep(registroSeleccionado.getnNumdep());
				entReq.setnNumtipodoc(registroSeleccionado.getnNumtipodoc());
				entReq.setvNumreg(registroSeleccionado.getvNumreg());
				entReq.setnNumgrupo(registroSeleccionado.getnNumgrupo());
				entReq.setnNumdepdest(registroSeleccionado.getnNumdepdest());
				entReq.setvCodtupa(registroSeleccionado.getvCodtupa());
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
					bandejaDespatch.actualizarRequisito(entReq);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Registro actualizado."));
	}
	
	public void imprimir()
	{
		if(tupaSeleccionado!=null && "1".equals(tipoDoc2) && requisitosTupaPendientes!=null)
		{//si es tupa y hay requisitos no chekeados
			try {
				RegistrarDespatch registrarDespatch=new RegistrarDespatch();					
				//Map parameters = new HashedMap();				
				Map parametros = new HashMap();
				parametros.put("PV_NUMREG", registroSeleccionado.getvNumreg());
				parametros.put("PN_NUMDEP", registroSeleccionado.getnNumdep());
				parametros.put("PV_NUMANOREG", registroSeleccionado.getvNumanoreg());
				parametros.put("PN_NUMTIPODOC", "0");
				
				Map parametros2 = new HashMap();
				parametros2.put("reqPendientes", requisitosTupaPendientes);
				parametros2.put("cur",registroSeleccionado.getvNumreg()+"-"+registroSeleccionado.getvNumanoreg());
				parametros2.put("hora",getFormatHour(registroSeleccionado.getdFecreg()));
				parametros2.put("fecha",getFormatDate(registroSeleccionado.getdFecreg()));
				parametros2.put("entidad",itemSeleccionado.getvDesnombre());
				parametros2.put("tipoDoc",desTipo(itemSeleccionado.getvCodtipodocid()));
				parametros2.put("nroDoc",itemSeleccionado.getvCodentidad());				
				parametros2.put("domicilio",registrarDespatch.getDireccionPorEntidadYCodigo(itemSeleccionado.getvCodentidad(), registroSeleccionado.getnCodcenlab()).getvDircenlab());
				parametros2.put("asunto",registroSeleccionado.getvDesasunto());
				
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
			parametros.put("PV_NUMREG", registroSeleccionado.getvNumreg());
			parametros.put("PN_NUMDEP", registroSeleccionado.getnNumdep());
			parametros.put("PV_NUMANOREG", registroSeleccionado.getvNumanoreg());
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
	
	public void activaRucODni()
	{
		if(tipoDoc!=null && nroDoc!=null && !"".equals(tipoDoc.trim()) && !"".equals(nroDoc))
		{
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
				if(nroDoc.length()!=11)
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar RUC válido"));
				}
				else
				{
					//primero buscar en tabla entidad, si no existe usar el ws pide por ruc y guardar en tabla entidad
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
						
						if(datosRUC!=null)//datosRUC.getDdp_nombre()!=null
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
	
	public Persona obtenerPersona(String tipoDoc, String nroDoc){
		Persona pex=new Persona();
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
							if (pex!=null && "0000".equals(pex.getV_coderror())) {								
								System.out.println("ENCONTRO TRABAJADOR EN WS RENIEC");
								//!!!pendiente setear pex como personaSeleccionada
								//retcc.setPersona(pex);	
								return pex;
							} else {
								String texto="";
								validaExiste=false;
								//SI NO ENCONTRO EN RENIEC O EL WS ESTA CAIDO, PERMITE GRABAR EN SITB_PERSONA
								if(pex==null){
									texto="No se encuentra el trabajador con el número de documento ingresado, deberá registrar";
								}								
								if(pex!=null){
									if("DNE".equals(pex.getV_coderror()) || "NHC".equals(pex.getV_coderror())){
										texto="El DNI consultado no existe en RENIEC por favor verificar.";
										validaExiste=true;
									}else if("AXISFAULT".equals(pex.getV_coderror())){
										//texto="Problema de comunicación con RENIEC porfavor registrar, v_coderror :: "+pex.getV_coderror();
										texto="No se ha podido conectar con Servicio de RENIEC, por favor registre manualmente los nombres. v_coderror ::"+pex.getV_coderror()+".";
										System.out.println(texto);
									}
								}								
								/**AGREGADO ENVIO CORREO**/																							
								boolean validaEnvioCorreo=false;								
								if(pex==null){
									validaEnvioCorreo=true;
								}else{
									if(!"DNE".equals(pex.getV_coderror()) && !"DNV".equals(pex.getV_coderror())){
										validaEnvioCorreo=true;
									}
								}
								//FacesUtils.showFacesMessage(texto, 1);
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", texto));
								if(validaEnvioCorreo==true){												
									EnviarMail enviarCorreo=new EnviarMail();
									String[] direcciones=new String[1];									
									direcciones[0]="wcastro@sunafil.gob.pe";
									String mensaje="";								
									String asunto="Error web Service RENIEC RETCC VIRTUAL";
									mensaje=pex==null?"EL WEB SERVICE NO ESTA FUNCIONANDO":pex.getV_coderror();
									if(direcciones.length>0 && direcciones!=null){
										try {
											enviarCorreo.generarEnvioDeCorreos(mensaje, direcciones,asunto);
										} catch (Exception e1) {					
											e1.printStackTrace();
											logger.error("Error al enviar correo =>"+e1);
										}										
									}
								}								
								/** FIN ENVIO CORREO**/
							}
						}
					}																							
			}						
		} catch (Exception e) {
			logger.error(e);			
			FacesUtils.showFacesMessage("Problema de comunicación con RENIEC porfavor registrar", 1);			
			EnviarMail enviarCorreo=new EnviarMail();
			String[] direcciones=new String[1];		
			direcciones[0]="wcastro@sunafil.gob.pe";
			String mensaje="";								
			String asunto="Error grave web Service RENIEC RETCC VIRTUAL";
			logger.error("Enviando correo de aviso de error grave en el catch.");
			mensaje=e.getMessage();
			if(direcciones.length>0 && direcciones!=null){
				try {
					enviarCorreo.generarEnvioDeCorreos(mensaje, direcciones,asunto);
				} catch (Exception e1) {					
					e1.printStackTrace();
					logger.error("Error al enviar correo en el catch =>"+e1);
				}
			}
			e.printStackTrace();			
		}		
		RequestContext context=RequestContext.getCurrentInstance();
		context.addCallbackParam("validaExiste",validaExiste );
		return pex;
	}

	public void addNDireccion()
	{
		hayDirecciones=!hayDirecciones;
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
		entidadSeleccionada=null;
		hayDirecciones=false;
		direccion="";
		direccionCombo="";
		direccionesEntSeleccionada=null;
	}
	
	public void cleanHR()
	{
		hruta0="";
		hruta1="";
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
