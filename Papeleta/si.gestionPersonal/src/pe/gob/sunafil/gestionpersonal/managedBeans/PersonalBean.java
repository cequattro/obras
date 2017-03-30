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

import pe.gob.sunafil.gestionpersonal.bean.Combo;
import pe.gob.sunafil.gestionpersonal.bean.Permisos;
import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonalDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcTipopers;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcCargosindica;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcClascar;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcResolucion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcSindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodia;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdDependientes;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerdireccion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxentfinanciera;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxprofesion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxregpensionario;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxseguro;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxsindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEntfinanciera;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEscalaremun;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargo;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbProfesion;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbRegpensionario;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbSeguro;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTipvia;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbVinculfamili;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbZona;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDependientes;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDetpersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDirecciones;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstEntfinanciera;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstProfesion;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstRegpensionario;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstSeguro;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstSindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTiporesolucion;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTurnopersonalrrhh;
import pe.gob.sunafil.gestionpersonal.utils.FacesUtils;
import pe.gob.sunafil.gestionpersonal.bean.Persona;
import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.CargosDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.CombosDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonaDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonaReniecDespatch;
import pe.gob.sunafil.gestionpersonal.reniecws.ReniecWebService;
import pe.gob.sunafil.gestionpersonal.utils.EnviarMail;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

@ManagedBean(name = "personalBean")
@SessionScoped
public class PersonalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5154405390560909774L;

	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario PGP_Usuario;
	@ManagedProperty("#{loginBean.PGP_Permisos}")
	private Permisos PGP_Permisos;

	private static Logger logger = Logger.getLogger(MenuBean.class.getName());

	// BANDEJA PERSONAL
	private List<VstPersonalrrhh> listaPersonal;
	private VstPersonalrrhh filtro = new VstPersonalrrhh();
	private List<SitbTdocide> listaTipoDoc;
	private String txt1;
	private List<TdtbcDependencia> dependenciasAutocomplete;
	private TdtbcDependencia dependenciaSeleccionada;
	private String selectedIntendencia;
	private List <TdtbcIntendencia> listaIntendencia;		
	private boolean modoCompleto;

	// NUEVO PERSONAL
	private PrtbcPersonal nuevoPersonal = new PrtbcPersonal();
	private List<PrtbcTipopers> listaTipoPersonal;
	private String txt2;
	private List<TdtbcDependencia> dependenciasAutocomplete2;
	private TdtbcDependencia dependenciaSeleccionada2;
	private List<SitbPercargo> listaCargoPersonal;
	private List<SitbEscalaremun> listaEscala;
	private String mensajeValida;
	private String selectedIntendencia2;
	private PersonaDespatch pd;
	private Date fechaInicio=new Date();
	private boolean hayCargoNuevo=false;
	private SitbPercargo nuevoCargo;
	private String nroContrato;
	private String anioContrato;
	
	// EDITAR PERSONAL	
	private PrtbcPersonal selectedPersonal = new PrtbcPersonal();
	private String txt3;
	private List<TdtbcDependencia> dependenciasAutocomplete3;
	private TdtbcDependencia dependenciaSeleccionada3;
	private String mensajeValidaEdit;
	private String selectedIntendencia3;	
	private List<VstDetpersonalrrhh> listaDetPersonal;
	private List<VstSindicato> listaSindicato;
	private List<VstProfesion> listaProfesion;
	private List<VstEntfinanciera> listaEntfinanciera;
	private List<VstSeguro> listaSeguro;
	private List<VstSeguro> listaSeguroSCTR;
	private List<VstRegpensionario> listaRegPensionario;
	private List<VstDirecciones> listaDirecciones;
	private List<VstDependientes> listaDependientes;
	private RhtbdPersonal nuevoDetPersonal;
	private RhtbdPersonal eliminarDetPersonal;
	private VstDetpersonalrrhh eliminarDetPersonalV;
	private Date dFecini=new Date();
	private RhtbdPersonal principalDetPersonal;
	private VstDetpersonalrrhh principalDetPersonalV;
	private Date fechaBaja=new Date();	
	private String txt4;
	private List<TdtbcDependencia> dependenciasAutocomplete4;
	private TdtbcDependencia dependenciaSeleccionada4;
	private String selectedIntendencia4;
	private RhtbdPersonal editarDetPersonal;
	private Date dFeciniE=new Date();
	private Date dFecfinE=new Date();
	private boolean soloVer;
	private boolean deshabilitarTipoYEscala=false;
	
	private List <VstTiporesolucion> listaResolucionesDestaque;
	private List <RhtbcClascar> listaClasificacionesCargo;
	
	private List <RhtbcSindicato> listaCabSindicato;
	private List <RhtbcCargosindica> listaCargoSindical;
	private RhtbdPerxsindicato nuevoDetSindicato;
	private Date dFeciniSindicato=new Date();
	
	private List <SitbProfesion> listaCabProfesion;
	private RhtbdPerxprofesion nuevoDetProfesion;
	private String txtProfesion;
	private List<SitbProfesion> profesionesAutocomplete;
	private SitbProfesion profesionSeleccionada;
	
	private List <SitbEntfinanciera> listaCabEntFinanciera;
	private RhtbdPerxentfinanciera nuevoDetEntFinanciera;
	private Date dFeciniEntFinanciera=new Date();
	
	private List <SitbSeguro> listaCabSeguro;
	private RhtbdPerxseguro nuevoDetSeguro;
	private Date dFeciniEntSeguro=new Date();
	
	private List <SitbSeguro> listaCabSeguroSCTR;
	private RhtbdPerxseguro nuevoDetSeguroSCTR;
	private Date dFeciniEntSeguroSCTR=new Date();
			
	private List <SitbZona> listaCabZona;
	private List <SitbTipvia> listaCabTipoVia;
	private RhtbdPerdireccion nuevoDetDireccion;
	private String v_coddep;
	private String v_codpro;
	private String v_coddis;
	private List<Combo> listaProvincias;
	private List<Combo> listaDistritos;	
	private CombosDespatch dspcombos = new CombosDespatch();
	
	private List <SitbRegpensionario> listaCabRegPensionario;
	private RhtbdPerxregpensionario nuevoDetRegPensionario;
	private Date dFeciniRegPensionario=new Date();
	
	private List<SitbVinculfamili> listaVinculo;
	private RhtbdDependientes nuevoDependiente;
	private Date dFecNacDependiente=new Date();
	
	private VstSindicato eliminarDetSindicato;
	private VstProfesion eliminarDetProfesion;
	private VstEntfinanciera eliminarDetEntFinanciera;
	private VstSeguro eliminarDetSeguro;
	private VstSeguro eliminarDetSeguroSCTR;
	private VstRegpensionario eliminarRegPensionario;
	private VstDirecciones eliminarDetDireccion;
	private VstDependientes eliminarDependiente;
	
	private RhtbdPerxsindicato editarDetSindicato;
	private Date dFeciniSindicatoE=new Date();
	private Date dFecfinSindicatoE=new Date();
	private String txtProfesionE;
	private List<SitbProfesion> profesionesAutocompleteE;
	private SitbProfesion profesionSeleccionadaE;
	
	private RhtbdPerxprofesion editarDetProfesion;
	
	private RhtbdPerxentfinanciera editarDetEntFinanciera;
	private Date dFeciniEntFinancieraE=new Date();
	private Date dFecfinEntFinancieraE=new Date();
	
	private RhtbdPerxseguro editarDetSeguro;
	private Date dFeciniEntSeguroE=new Date();
	private Date dFecfinEntSeguroE=new Date();
	
	private RhtbdPerxseguro editarDetSeguroSCTR;
	private Date dFeciniEntSeguroSCTRE=new Date();
	private Date dFecfinEntSeguroSCTRE=new Date();
	
	private RhtbdPerxregpensionario editarDetRegPensionario;
	private Date dFeciniRegPensionarioE=new Date();
	private Date dFecfinRegPensionarioE=new Date();
	
	private RhtbdPerdireccion editarDetDireccion;
	private String v_coddepE;
	private String v_codproE;
	private String v_coddisE;
	private List<Combo> listaProvinciasE;
	private List<Combo> listaDistritosE;	
	
	private RhtbdDependientes editarDependiente;
	private Date dFecNacDependienteE=new Date();
	
	// TURNO POR PERSONAL
	private VstPersonalrrhh selectedPersonalT=new VstPersonalrrhh();
	private List<RhtbcTurno> listaTurno;
	private RhmvcPerturno nuevoPerTurno=new RhmvcPerturno();	
	private List<RhtbcTurnodia> listaTurnoDia;
	private List<VstTurnopersonalrrhh> listaTurnoPersonal;
	private String mensajeValidaTP;
	private RhmvcPerturno eliminarPerTurno;
	private VstTurnopersonalrrhh eliminarPerTurnoV;
	private RhmvcPerturno editarPerTurno;	
	private VstTurnopersonalrrhh editarPerTurnoV;
	private List<RhtbcTurnodia> listaTurnoDiaE;		
	private String mensajeValidaTPE;		
	private RhmvcPerturno zoomPerTurno;	
	private List<RhtbcTurnodia> listaTurnoDiaZ;		
			
	public List<RhtbcClascar> getListaClasificacionesCargo() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaClasificacionesCargo = personalDespatch.getClasificacionCargos();
		} catch (Exception e) {
			listaClasificacionesCargo = null;
			e.printStackTrace();
		}
		return listaClasificacionesCargo;
	}

	public void setListaClasificacionesCargo(
			List<RhtbcClascar> listaClasificacionesCargo) {
		this.listaClasificacionesCargo = listaClasificacionesCargo;
	}

	public List<RhtbcCargosindica> getListaCargoSindical() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaCargoSindical = personalDespatch.getCargosSindicales();
		} catch (Exception e) {
			listaCargoSindical = null;
			e.printStackTrace();
		}
		return listaCargoSindical;
	}

	public void setListaCargoSindical(List<RhtbcCargosindica> listaCargoSindical) {
		this.listaCargoSindical = listaCargoSindical;
	}

	public List<VstTiporesolucion> getListaResolucionesDestaque() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaResolucionesDestaque = personalDespatch.getTodasResoluciones();
		} catch (Exception e) {
			listaResolucionesDestaque = null;
			e.printStackTrace();
		}
		return listaResolucionesDestaque;
	}

	public void setListaResolucionesDestaque(
			List<VstTiporesolucion> listaResolucionesDestaque) {
		this.listaResolucionesDestaque = listaResolucionesDestaque;
	}

	public RhtbdDependientes getEditarDependiente() {
		return editarDependiente;
	}

	public void setEditarDependiente(RhtbdDependientes editarDependiente) {
		this.editarDependiente = editarDependiente;
	}

	public Date getdFecNacDependienteE() {
		return dFecNacDependienteE;
	}

	public void setdFecNacDependienteE(Date dFecNacDependienteE) {
		this.dFecNacDependienteE = dFecNacDependienteE;
	}

	public VstDependientes getEliminarDependiente() {
		return eliminarDependiente;
	}

	public void setEliminarDependiente(VstDependientes eliminarDependiente) {
		this.eliminarDependiente = eliminarDependiente;
	}

	public RhtbdDependientes getNuevoDependiente() {
		return nuevoDependiente;
	}

	public void setNuevoDependiente(RhtbdDependientes nuevoDependiente) {
		this.nuevoDependiente = nuevoDependiente;
	}

	public Date getdFecNacDependiente() {
		return dFecNacDependiente;
	}

	public void setdFecNacDependiente(Date dFecNacDependiente) {
		this.dFecNacDependiente = dFecNacDependiente;
	}

	public List<SitbVinculfamili> getListaVinculo() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaVinculo = personalDespatch.getVinculos();
		} catch (Exception e) {
			listaVinculo = null;
			e.printStackTrace();
		}
		return listaVinculo;
	}

	public void setListaVinculo(List<SitbVinculfamili> listaVinculo) {
		this.listaVinculo = listaVinculo;
	}

	public List<VstDependientes> getListaDependientes() {
		return listaDependientes;
	}

	public void setListaDependientes(List<VstDependientes> listaDependientes) {
		this.listaDependientes = listaDependientes;
	}

	public RhtbdPerxseguro getEditarDetSeguroSCTR() {
		return editarDetSeguroSCTR;
	}

	public void setEditarDetSeguroSCTR(RhtbdPerxseguro editarDetSeguroSCTR) {
		this.editarDetSeguroSCTR = editarDetSeguroSCTR;
	}

	public Date getdFeciniEntSeguroSCTRE() {
		return dFeciniEntSeguroSCTRE;
	}

	public void setdFeciniEntSeguroSCTRE(Date dFeciniEntSeguroSCTRE) {
		this.dFeciniEntSeguroSCTRE = dFeciniEntSeguroSCTRE;
	}

	public Date getdFecfinEntSeguroSCTRE() {
		return dFecfinEntSeguroSCTRE;
	}

	public void setdFecfinEntSeguroSCTRE(Date dFecfinEntSeguroSCTRE) {
		this.dFecfinEntSeguroSCTRE = dFecfinEntSeguroSCTRE;
	}

	public VstSeguro getEliminarDetSeguroSCTR() {
		return eliminarDetSeguroSCTR;
	}

	public void setEliminarDetSeguroSCTR(VstSeguro eliminarDetSeguroSCTR) {
		this.eliminarDetSeguroSCTR = eliminarDetSeguroSCTR;
	}

	public List<SitbSeguro> getListaCabSeguroSCTR() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaCabSeguroSCTR=personalDespatch.getSegurosSCTR();
		} catch (Exception e) {
			listaCabSeguroSCTR=null;
			e.printStackTrace();
		}
		return listaCabSeguroSCTR;
	}

	public void setListaCabSeguroSCTR(List<SitbSeguro> listaCabSeguroSCTR) {
		this.listaCabSeguroSCTR = listaCabSeguroSCTR;
	}

	public RhtbdPerxseguro getNuevoDetSeguroSCTR() {
		return nuevoDetSeguroSCTR;
	}

	public void setNuevoDetSeguroSCTR(RhtbdPerxseguro nuevoDetSeguroSCTR) {
		this.nuevoDetSeguroSCTR = nuevoDetSeguroSCTR;
	}

	public Date getdFeciniEntSeguroSCTR() {
		return dFeciniEntSeguroSCTR;
	}

	public void setdFeciniEntSeguroSCTR(Date dFeciniEntSeguroSCTR) {
		this.dFeciniEntSeguroSCTR = dFeciniEntSeguroSCTR;
	}

	public List<VstSeguro> getListaSeguroSCTR() {
		return listaSeguroSCTR;
	}

	public void setListaSeguroSCTR(List<VstSeguro> listaSeguroSCTR) {
		this.listaSeguroSCTR = listaSeguroSCTR;
	}

	public String getTxtProfesionE() {
		return txtProfesionE;
	}

	public void setTxtProfesionE(String txtProfesionE) {
		this.txtProfesionE = txtProfesionE;
	}

	public List<SitbProfesion> getProfesionesAutocompleteE() {
		return profesionesAutocompleteE;
	}

	public void setProfesionesAutocompleteE(
			List<SitbProfesion> profesionesAutocompleteE) {
		this.profesionesAutocompleteE = profesionesAutocompleteE;
	}

	public SitbProfesion getProfesionSeleccionadaE() {
		return profesionSeleccionadaE;
	}

	public void setProfesionSeleccionadaE(SitbProfesion profesionSeleccionadaE) {
		this.profesionSeleccionadaE = profesionSeleccionadaE;
	}

	public List<SitbProfesion> getProfesionesAutocomplete() {
		return profesionesAutocomplete;
	}

	public void setProfesionesAutocomplete(
			List<SitbProfesion> profesionesAutocomplete) {
		this.profesionesAutocomplete = profesionesAutocomplete;
	}

	public SitbProfesion getProfesionSeleccionada() {
		return profesionSeleccionada;
	}

	public void setProfesionSeleccionada(SitbProfesion profesionSeleccionada) {
		this.profesionSeleccionada = profesionSeleccionada;
	}

	public String getTxtProfesion() {
		return txtProfesion;
	}

	public void setTxtProfesion(String txtProfesion) {
		this.txtProfesion = txtProfesion;
	}

	public String getV_coddepE() {
		return v_coddepE;
	}

	public void setV_coddepE(String v_coddepE) {
		this.v_coddepE = v_coddepE;
	}

	public String getV_codproE() {
		return v_codproE;
	}

	public void setV_codproE(String v_codproE) {
		this.v_codproE = v_codproE;
	}

	public String getV_coddisE() {
		return v_coddisE;
	}

	public void setV_coddisE(String v_coddisE) {
		this.v_coddisE = v_coddisE;
	}

	public List<Combo> getListaProvinciasE() {
		return listaProvinciasE;
	}

	public void setListaProvinciasE(List<Combo> listaProvinciasE) {
		this.listaProvinciasE = listaProvinciasE;
	}

	public List<Combo> getListaDistritosE() {
		return listaDistritosE;
	}

	public void setListaDistritosE(List<Combo> listaDistritosE) {
		this.listaDistritosE = listaDistritosE;
	}

	public Date getdFeciniRegPensionarioE() {
		return dFeciniRegPensionarioE;
	}

	public void setdFeciniRegPensionarioE(Date dFeciniRegPensionarioE) {
		this.dFeciniRegPensionarioE = dFeciniRegPensionarioE;
	}

	public Date getdFecfinRegPensionarioE() {
		return dFecfinRegPensionarioE;
	}

	public void setdFecfinRegPensionarioE(Date dFecfinRegPensionarioE) {
		this.dFecfinRegPensionarioE = dFecfinRegPensionarioE;
	}

	public Date getdFeciniEntSeguroE() {
		return dFeciniEntSeguroE;
	}

	public void setdFeciniEntSeguroE(Date dFeciniEntSeguroE) {
		this.dFeciniEntSeguroE = dFeciniEntSeguroE;
	}

	public Date getdFecfinEntSeguroE() {
		return dFecfinEntSeguroE;
	}

	public void setdFecfinEntSeguroE(Date dFecfinEntSeguroE) {
		this.dFecfinEntSeguroE = dFecfinEntSeguroE;
	}

	public Date getdFeciniEntFinancieraE() {
		return dFeciniEntFinancieraE;
	}

	public void setdFeciniEntFinancieraE(Date dFeciniEntFinancieraE) {
		this.dFeciniEntFinancieraE = dFeciniEntFinancieraE;
	}

	public Date getdFecfinEntFinancieraE() {
		return dFecfinEntFinancieraE;
	}

	public void setdFecfinEntFinancieraE(Date dFecfinEntFinancieraE) {
		this.dFecfinEntFinancieraE = dFecfinEntFinancieraE;
	}

	public Date getdFeciniSindicatoE() {
		return dFeciniSindicatoE;
	}

	public void setdFeciniSindicatoE(Date dFeciniSindicatoE) {
		this.dFeciniSindicatoE = dFeciniSindicatoE;
	}

	public Date getdFecfinSindicatoE() {
		return dFecfinSindicatoE;
	}

	public void setdFecfinSindicatoE(Date dFecfinSindicatoE) {
		this.dFecfinSindicatoE = dFecfinSindicatoE;
	}

	public RhtbdPerxsindicato getEditarDetSindicato() {
		return editarDetSindicato;
	}

	public void setEditarDetSindicato(RhtbdPerxsindicato editarDetSindicato) {
		this.editarDetSindicato = editarDetSindicato;
	}

	public RhtbdPerxprofesion getEditarDetProfesion() {
		return editarDetProfesion;
	}

	public void setEditarDetProfesion(RhtbdPerxprofesion editarDetProfesion) {
		this.editarDetProfesion = editarDetProfesion;
	}

	public RhtbdPerxentfinanciera getEditarDetEntFinanciera() {
		return editarDetEntFinanciera;
	}

	public void setEditarDetEntFinanciera(
			RhtbdPerxentfinanciera editarDetEntFinanciera) {
		this.editarDetEntFinanciera = editarDetEntFinanciera;
	}

	public RhtbdPerxseguro getEditarDetSeguro() {
		return editarDetSeguro;
	}

	public void setEditarDetSeguro(RhtbdPerxseguro editarDetSeguro) {
		this.editarDetSeguro = editarDetSeguro;
	}

	public RhtbdPerxregpensionario getEditarDetRegPensionario() {
		return editarDetRegPensionario;
	}

	public void setEditarDetRegPensionario(RhtbdPerxregpensionario editarDetRegPensionario) {
		this.editarDetRegPensionario = editarDetRegPensionario;
	}

	public RhtbdPerdireccion getEditarDetDireccion() {
		return editarDetDireccion;
	}

	public void setEditarDetDireccion(RhtbdPerdireccion editarDetDireccion) {
		this.editarDetDireccion = editarDetDireccion;
	}

	public VstSindicato getEliminarDetSindicato() {
		return eliminarDetSindicato;
	}

	public void setEliminarDetSindicato(VstSindicato eliminarDetSindicato) {
		this.eliminarDetSindicato = eliminarDetSindicato;
	}

	public VstProfesion getEliminarDetProfesion() {
		return eliminarDetProfesion;
	}

	public void setEliminarDetProfesion(VstProfesion eliminarDetProfesion) {
		this.eliminarDetProfesion = eliminarDetProfesion;
	}

	public VstEntfinanciera getEliminarDetEntFinanciera() {
		return eliminarDetEntFinanciera;
	}

	public void setEliminarDetEntFinanciera(
			VstEntfinanciera eliminarDetEntFinanciera) {
		this.eliminarDetEntFinanciera = eliminarDetEntFinanciera;
	}

	public VstSeguro getEliminarDetSeguro() {
		return eliminarDetSeguro;
	}

	public void setEliminarDetSeguro(VstSeguro eliminarDetSeguro) {
		this.eliminarDetSeguro = eliminarDetSeguro;
	}

	public VstRegpensionario getEliminarRegPensionario() {
		return eliminarRegPensionario;
	}

	public void setEliminarRegPensionario(VstRegpensionario eliminarRegPensionario) {
		this.eliminarRegPensionario = eliminarRegPensionario;
	}

	public VstDirecciones getEliminarDetDireccion() {
		return eliminarDetDireccion;
	}

	public void setEliminarDetDireccion(VstDirecciones eliminarDetDireccion) {
		this.eliminarDetDireccion = eliminarDetDireccion;
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
	
	public void selCmbDepartamentoE(){
		logger.info("Obteniendo Cmb Provincia E");
		try{
			listaProvinciasE = new ArrayList<Combo>();
			String coddepE = v_coddepE; 
			listaProvinciasE = dspcombos.listaProvinciasxDep(coddepE);
			
			//DESSELECCIONANDO LA PROVINCIA
			setV_codproE("");
			//DESSELECCIONANDO EL DISTRITO
			setV_coddisE("");
			
			//LIMPIAMOS LOS DISTRITOS
			listaDistritosE = new ArrayList<Combo>();
			
		}catch(Exception e){
			logger.error("Error en Listar las provincias y distritos E: "+e.getMessage(),e);
		}
	}
	
	public void selCmbProvinciaE(){
		logger.info("Obteniendo Cmb Distrito E");
		try{
			listaDistritosE = new ArrayList<Combo>();
			String coddepE = getV_coddepE();
			String codproE = getV_codproE();
			listaDistritosE = dspcombos.listaDistritosxPro(coddepE,codproE);
			//DESSELECCIONANDO EL DISTRITO
			setV_coddisE("");
			
		}catch(Exception e){
			logger.error("Error en Listar los distritos E: "+e.getMessage(),e);
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

	public CombosDespatch getDspcombos() {
		return dspcombos;
	}

	public void setDspcombos(CombosDespatch dspcombos) {
		this.dspcombos = dspcombos;
	}

	public List<SitbZona> getListaCabZona() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaCabZona=personalDespatch.getZonas();
		} catch (Exception e) {
			listaCabZona=null;
			e.printStackTrace();
		}
		return listaCabZona;
	}

	public void setListaCabZona(List<SitbZona> listaCabZona) {
		this.listaCabZona = listaCabZona;
	}

	public List<SitbTipvia> getListaCabTipoVia() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaCabTipoVia=personalDespatch.getTiposVia();
		} catch (Exception e) {
			listaCabTipoVia=null;
			e.printStackTrace();
		}
		return listaCabTipoVia;
	}

	public void setListaCabTipoVia(List<SitbTipvia> listaCabTipoVia) {
		this.listaCabTipoVia = listaCabTipoVia;
	}

	public RhtbdPerdireccion getNuevoDetDireccion() {
		return nuevoDetDireccion;
	}

	public void setNuevoDetDireccion(RhtbdPerdireccion nuevoDetDireccion) {
		this.nuevoDetDireccion = nuevoDetDireccion;
	}

	public List<SitbRegpensionario> getListaCabRegPensionario() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaCabRegPensionario=personalDespatch.getRegimenesPensionarios();
		} catch (Exception e) {
			listaCabRegPensionario=null;
			e.printStackTrace();
		}
		return listaCabRegPensionario;
	}

	public void setListaCabRegPensionario(
			List<SitbRegpensionario> listaCabRegPensionario) {
		this.listaCabRegPensionario = listaCabRegPensionario;
	}

	public RhtbdPerxregpensionario getNuevoDetRegPensionario() {
		return nuevoDetRegPensionario;
	}

	public void setNuevoDetRegPensionario(RhtbdPerxregpensionario nuevoDetRegPensionario) {
		this.nuevoDetRegPensionario = nuevoDetRegPensionario;
	}

	public Date getdFeciniRegPensionario() {
		return dFeciniRegPensionario;
	}

	public void setdFeciniRegPensionario(Date dFeciniRegPensionario) {
		this.dFeciniRegPensionario = dFeciniRegPensionario;
	}

	public Date getdFeciniEntSeguro() {
		return dFeciniEntSeguro;
	}

	public void setdFeciniEntSeguro(Date dFeciniEntSeguro) {
		this.dFeciniEntSeguro = dFeciniEntSeguro;
	}

	public List<SitbSeguro> getListaCabSeguro() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaCabSeguro=personalDespatch.getSeguros();
		} catch (Exception e) {
			listaCabSeguro=null;
			e.printStackTrace();
		}
		return listaCabSeguro;
	}

	public void setListaCabSeguro(List<SitbSeguro> listaCabSeguro) {
		this.listaCabSeguro = listaCabSeguro;
	}

	public RhtbdPerxseguro getNuevoDetSeguro() {
		return nuevoDetSeguro;
	}

	public void setNuevoDetSeguro(RhtbdPerxseguro nuevoDetSeguro) {
		this.nuevoDetSeguro = nuevoDetSeguro;
	}

	public Date getdFeciniEntFinanciera() {
		return dFeciniEntFinanciera;
	}

	public void setdFeciniEntFinanciera(Date dFeciniEntFinanciera) {
		this.dFeciniEntFinanciera = dFeciniEntFinanciera;
	}

	public List<SitbEntfinanciera> getListaCabEntFinanciera() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaCabEntFinanciera=personalDespatch.getEntidadesFinancieras();
		} catch (Exception e) {
			listaCabEntFinanciera=null;
			e.printStackTrace();
		}
		return listaCabEntFinanciera;
	}

	public void setListaCabEntFinanciera(
			List<SitbEntfinanciera> listaCabEntFinanciera) {
		this.listaCabEntFinanciera = listaCabEntFinanciera;
	}

	public RhtbdPerxentfinanciera getNuevoDetEntFinanciera() {
		return nuevoDetEntFinanciera;
	}

	public void setNuevoDetEntFinanciera(
			RhtbdPerxentfinanciera nuevoDetEntFinanciera) {
		this.nuevoDetEntFinanciera = nuevoDetEntFinanciera;
	}

	public List<SitbProfesion> getListaCabProfesion() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaCabProfesion=personalDespatch.getProfesiones();
		} catch (Exception e) {
			listaCabProfesion=null;
			e.printStackTrace();
		}
		return listaCabProfesion;
	}

	public void setListaCabProfesion(List<SitbProfesion> listaCabProfesion) {
		this.listaCabProfesion = listaCabProfesion;
	}

	public RhtbdPerxprofesion getNuevoDetProfesion() {
		return nuevoDetProfesion;
	}

	public void setNuevoDetProfesion(RhtbdPerxprofesion nuevoDetProfesion) {
		this.nuevoDetProfesion = nuevoDetProfesion;
	}

	public Date getdFeciniSindicato() {
		return dFeciniSindicato;
	}

	public void setdFeciniSindicato(Date dFeciniSindicato) {
		this.dFeciniSindicato = dFeciniSindicato;
	}

	public RhtbdPerxsindicato getNuevoDetSindicato() {
		return nuevoDetSindicato;
	}

	public void setNuevoDetSindicato(RhtbdPerxsindicato nuevoDetSindicato) {
		this.nuevoDetSindicato = nuevoDetSindicato;
	}

	public List<RhtbcSindicato> getListaCabSindicato() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaCabSindicato=personalDespatch.getSindicatos();
		} catch (Exception e) {
			listaCabSindicato=null;
			e.printStackTrace();
		}
		return listaCabSindicato;
	}

	public void setListaCabSindicato(List<RhtbcSindicato> listaCabSindicato) {
		this.listaCabSindicato = listaCabSindicato;
	}

	public List<VstDirecciones> getListaDirecciones() {
		return listaDirecciones;
	}

	public void setListaDirecciones(List<VstDirecciones> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

	public List<VstRegpensionario> getListaRegPensionario() {
		return listaRegPensionario;
	}

	public void setListaRegPensionario(List<VstRegpensionario> listaRegPensionario) {
		this.listaRegPensionario = listaRegPensionario;
	}

	public List<VstSeguro> getListaSeguro() {
		return listaSeguro;
	}

	public void setListaSeguro(List<VstSeguro> listaSeguro) {
		this.listaSeguro = listaSeguro;
	}

	public List<VstEntfinanciera> getListaEntfinanciera() {
		return listaEntfinanciera;
	}

	public void setListaEntfinanciera(List<VstEntfinanciera> listaEntfinanciera) {
		this.listaEntfinanciera = listaEntfinanciera;
	}

	public List<VstProfesion> getListaProfesion() {
		return listaProfesion;
	}

	public void setListaProfesion(List<VstProfesion> listaProfesion) {
		this.listaProfesion = listaProfesion;
	}

	public List<VstSindicato> getListaSindicato() {
		return listaSindicato;
	}

	public void setListaSindicato(List<VstSindicato> listaSindicato) {
		this.listaSindicato = listaSindicato;
	}

	public String getNroContrato() {
		return nroContrato;
	}

	public void setNroContrato(String nroContrato) {
		this.nroContrato = nroContrato;
	}

	public String getAnioContrato() {
		return anioContrato;
	}

	public void setAnioContrato(String anioContrato) {
		this.anioContrato = anioContrato;
	}

	public SitbPercargo getNuevoCargo() {
		return nuevoCargo;
	}

	public void setNuevoCargo(SitbPercargo nuevoCargo) {
		this.nuevoCargo = nuevoCargo;
	}

	public boolean isHayCargoNuevo() {
		return hayCargoNuevo;
	}

	public void setHayCargoNuevo(boolean hayCargoNuevo) {
		this.hayCargoNuevo = hayCargoNuevo;
	}

	public boolean isDeshabilitarTipoYEscala() {
		return deshabilitarTipoYEscala;
	}

	public void setDeshabilitarTipoYEscala(boolean deshabilitarTipoYEscala) {
		this.deshabilitarTipoYEscala = deshabilitarTipoYEscala;
	}

	public VstTurnopersonalrrhh getEditarPerTurnoV() {
		return editarPerTurnoV;
	}

	public void setEditarPerTurnoV(VstTurnopersonalrrhh editarPerTurnoV) {
		this.editarPerTurnoV = editarPerTurnoV;
	}

	public boolean isSoloVer() {
		return soloVer;
	}

	public void setSoloVer(boolean soloVer) {
		this.soloVer = soloVer;
	}

	public boolean isModoCompleto() {
		return modoCompleto;
	}

	public void setModoCompleto(boolean modoCompleto) {
		this.modoCompleto = modoCompleto;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public RhmvcPerturno getZoomPerTurno() {
		return zoomPerTurno;
	}

	public void setZoomPerTurno(RhmvcPerturno zoomPerTurno) {
		this.zoomPerTurno = zoomPerTurno;
	}

	public List<RhtbcTurnodia> getListaTurnoDiaZ() {
		return listaTurnoDiaZ;
	}

	public void setListaTurnoDiaZ(List<RhtbcTurnodia> listaTurnoDiaZ) {
		this.listaTurnoDiaZ = listaTurnoDiaZ;
	}

	public String getMensajeValidaTPE() {
		return mensajeValidaTPE;
	}

	public void setMensajeValidaTPE(String mensajeValidaTPE) {
		this.mensajeValidaTPE = mensajeValidaTPE;
	}

	public List<RhtbcTurnodia> getListaTurnoDiaE() {
		return listaTurnoDiaE;
	}

	public void setListaTurnoDiaE(List<RhtbcTurnodia> listaTurnoDiaE) {
		this.listaTurnoDiaE = listaTurnoDiaE;
	}

	public RhmvcPerturno getEditarPerTurno() {
		return editarPerTurno;
	}

	public void setEditarPerTurno(RhmvcPerturno editarPerTurno) {
		this.editarPerTurno = editarPerTurno;
	}

	public RhmvcPerturno getEliminarPerTurno() {
		return eliminarPerTurno;
	}

	public void setEliminarPerTurno(RhmvcPerturno eliminarPerTurno) {
		this.eliminarPerTurno = eliminarPerTurno;
	}

	public VstTurnopersonalrrhh getEliminarPerTurnoV() {
		return eliminarPerTurnoV;
	}

	public void setEliminarPerTurnoV(VstTurnopersonalrrhh eliminarPerTurnoV) {
		this.eliminarPerTurnoV = eliminarPerTurnoV;
	}

	public VstDetpersonalrrhh getPrincipalDetPersonalV() {
		return principalDetPersonalV;
	}

	public void setPrincipalDetPersonalV(VstDetpersonalrrhh principalDetPersonalV) {
		this.principalDetPersonalV = principalDetPersonalV;
	}

	public RhtbdPersonal getPrincipalDetPersonal() {
		return principalDetPersonal;
	}

	public void setPrincipalDetPersonal(RhtbdPersonal principalDetPersonal) {
		this.principalDetPersonal = principalDetPersonal;
	}

	public Date getdFeciniE() {
		return dFeciniE;
	}

	public void setdFeciniE(Date dFeciniE) {
		this.dFeciniE = dFeciniE;
	}

	public Date getdFecfinE() {
		return dFecfinE;
	}

	public void setdFecfinE(Date dFecfinE) {
		this.dFecfinE = dFecfinE;
	}

	public Date getdFecini() {
		return dFecini;
	}

	public void setdFecini(Date dFecini) {
		this.dFecini = dFecini;
	}

	public String getTxt4() {
		return txt4;
	}

	public void setTxt4(String txt4) {
		this.txt4 = txt4;
	}

	public List<TdtbcDependencia> getDependenciasAutocomplete4() {
		return dependenciasAutocomplete4;
	}

	public void setDependenciasAutocomplete4(
			List<TdtbcDependencia> dependenciasAutocomplete4) {
		this.dependenciasAutocomplete4 = dependenciasAutocomplete4;
	}

	public TdtbcDependencia getDependenciaSeleccionada4() {
		return dependenciaSeleccionada4;
	}

	public void setDependenciaSeleccionada4(
			TdtbcDependencia dependenciaSeleccionada4) {
		this.dependenciaSeleccionada4 = dependenciaSeleccionada4;
	}

	public String getSelectedIntendencia4() {
		return selectedIntendencia4;
	}

	public void setSelectedIntendencia4(String selectedIntendencia4) {
		this.selectedIntendencia4 = selectedIntendencia4;
	}

	public RhtbdPersonal getEditarDetPersonal() {
		return editarDetPersonal;
	}

	public void setEditarDetPersonal(RhtbdPersonal editarDetPersonal) {
		this.editarDetPersonal = editarDetPersonal;
	}

	public VstDetpersonalrrhh getEliminarDetPersonalV() {
		return eliminarDetPersonalV;
	}

	public void setEliminarDetPersonalV(VstDetpersonalrrhh eliminarDetPersonalV) {
		this.eliminarDetPersonalV = eliminarDetPersonalV;
	}

	public RhtbdPersonal getEliminarDetPersonal() {
		return eliminarDetPersonal;
	}

	public void setEliminarDetPersonal(RhtbdPersonal eliminarDetPersonal) {
		this.eliminarDetPersonal = eliminarDetPersonal;
	}

	public RhtbdPersonal getNuevoDetPersonal() {
		return nuevoDetPersonal;
	}

	public void setNuevoDetPersonal(RhtbdPersonal nuevoDetPersonal) {
		this.nuevoDetPersonal = nuevoDetPersonal;
	}

	public List<VstDetpersonalrrhh> getListaDetPersonal() {
		return listaDetPersonal;
	}

	public void setListaDetPersonal(List<VstDetpersonalrrhh> listaDetPersonal) {
		this.listaDetPersonal = listaDetPersonal;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getMensajeValidaTP() {
		return mensajeValidaTP;
	}

	public void setMensajeValidaTP(String mensajeValidaTP) {
		this.mensajeValidaTP = mensajeValidaTP;
	}

	public List<VstTurnopersonalrrhh> getListaTurnoPersonal() {
		return listaTurnoPersonal;
	}

	public void setListaTurnoPersonal(List<VstTurnopersonalrrhh> listaTurnoPersonal) {
		this.listaTurnoPersonal = listaTurnoPersonal;
	}

	public List<RhtbcTurnodia> getListaTurnoDia() {
		return listaTurnoDia;
	}

	public void setListaTurnoDia(List<RhtbcTurnodia> listaTurnoDia) {
		this.listaTurnoDia = listaTurnoDia;
	}

	public List<RhtbcTurno> getListaTurno() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaTurno=personalDespatch.getTurnos();
		} catch (Exception e) {
			listaTurno=null;
			e.printStackTrace();
		}
		return listaTurno;
	}

	public void setListaTurno(List<RhtbcTurno> listaTurno) {
		this.listaTurno = listaTurno;
	}

	public RhmvcPerturno getNuevoPerTurno() {
		return nuevoPerTurno;
	}

	public void setNuevoPerTurno(RhmvcPerturno nuevoPerTurno) {
		this.nuevoPerTurno = nuevoPerTurno;
	}

	public VstPersonalrrhh getSelectedPersonalT() {
		return selectedPersonalT;
	}

	public void setSelectedPersonalT(VstPersonalrrhh selectedPersonalT) {
		this.selectedPersonalT = selectedPersonalT;
	}

	public String getSelectedIntendencia2() {
		return selectedIntendencia2;
	}

	public void setSelectedIntendencia2(String selectedIntendencia2) {
		this.selectedIntendencia2 = selectedIntendencia2;
	}

	public String getSelectedIntendencia3() {
		return selectedIntendencia3;
	}

	public void setSelectedIntendencia3(String selectedIntendencia3) {
		this.selectedIntendencia3 = selectedIntendencia3;
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
	
	public String getSelectedIntendencia() {
		return selectedIntendencia;
	}

	public void setSelectedIntendencia(String selectedIntendencia) {
		this.selectedIntendencia = selectedIntendencia;
	}
	
	public PrtbcPersonal getSelectedPersonal() {
		return selectedPersonal;
	}

	public void setSelectedPersonal(PrtbcPersonal selectedPersonal) {
		this.selectedPersonal = selectedPersonal;
	}

	public String getTxt3() {
		return txt3;
	}

	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}

	public List<TdtbcDependencia> getDependenciasAutocomplete3() {
		return dependenciasAutocomplete3;
	}

	public void setDependenciasAutocomplete3(
			List<TdtbcDependencia> dependenciasAutocomplete3) {
		this.dependenciasAutocomplete3 = dependenciasAutocomplete3;
	}

	public TdtbcDependencia getDependenciaSeleccionada3() {
		return dependenciaSeleccionada3;
	}

	public void setDependenciaSeleccionada3(
			TdtbcDependencia dependenciaSeleccionada3) {
		this.dependenciaSeleccionada3 = dependenciaSeleccionada3;
	}

	public String getMensajeValidaEdit() {
		return mensajeValidaEdit;
	}

	public void setMensajeValidaEdit(String mensajeValidaEdit) {
		this.mensajeValidaEdit = mensajeValidaEdit;
	}

	public String getMensajeValida() {
		return mensajeValida;
	}

	public void setMensajeValida(String mensajeValida) {
		this.mensajeValida = mensajeValida;
	}

	public List<SitbEscalaremun> getListaEscala() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaEscala = personalDespatch.getEscalas();
		} catch (Exception e) {
			listaEscala = null;
			e.printStackTrace();
		}
		return listaEscala;
	}

	public void setListaEscala(List<SitbEscalaremun> listaEscala) {
		this.listaEscala = listaEscala;
	}

	public List<SitbPercargo> getListaCargoPersonal() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaCargoPersonal = personalDespatch.getCargos();
		} catch (Exception e) {
			listaCargoPersonal = null;
			e.printStackTrace();
		}
		return listaCargoPersonal;
	}

	public void setListaCargoPersonal(List<SitbPercargo> listaCargoPersonal) {
		this.listaCargoPersonal = listaCargoPersonal;
	}

	public String getTxt2() {
		return txt2;
	}

	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}

	public List<TdtbcDependencia> getDependenciasAutocomplete2() {
		return dependenciasAutocomplete2;
	}

	public void setDependenciasAutocomplete2(
			List<TdtbcDependencia> dependenciasAutocomplete2) {
		this.dependenciasAutocomplete2 = dependenciasAutocomplete2;
	}

	public TdtbcDependencia getDependenciaSeleccionada2() {
		return dependenciaSeleccionada2;
	}

	public void setDependenciaSeleccionada2(
			TdtbcDependencia dependenciaSeleccionada2) {
		this.dependenciaSeleccionada2 = dependenciaSeleccionada2;
	}

	public List<PrtbcTipopers> getListaTipoPersonal() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaTipoPersonal = personalDespatch.getTipoPersonal();
		} catch (Exception e) {
			listaTipoPersonal = null;
			e.printStackTrace();
		}
		return listaTipoPersonal;
	}

	public void setListaTipoPersonal(List<PrtbcTipopers> listaTipoPersonal) {
		this.listaTipoPersonal = listaTipoPersonal;
	}

	public PrtbcPersonal getNuevoPersonal() {
		return nuevoPersonal;
	}

	public void setNuevoPersonal(PrtbcPersonal nuevoPersonal) {
		this.nuevoPersonal = nuevoPersonal;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public List<TdtbcDependencia> getDependenciasAutocomplete() {
		return dependenciasAutocomplete;
	}

	public void setDependenciasAutocomplete(
			List<TdtbcDependencia> dependenciasAutocomplete) {
		this.dependenciasAutocomplete = dependenciasAutocomplete;
	}

	public TdtbcDependencia getDependenciaSeleccionada() {
		return dependenciaSeleccionada;
	}

	public void setDependenciaSeleccionada(
			TdtbcDependencia dependenciaSeleccionada) {
		this.dependenciaSeleccionada = dependenciaSeleccionada;
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

	public List<VstPersonalrrhh> getListaPersonal() {
		return listaPersonal;
	}

	public void setListaPersonal(List<VstPersonalrrhh> listaPersonal) {
		this.listaPersonal = listaPersonal;
	}

	public VstPersonalrrhh getFiltro() {
		return filtro;
	}

	public void setFiltro(VstPersonalrrhh filtro) {
		this.filtro = filtro;
	}

	public List<SitbTdocide> getListaTipoDoc() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaTipoDoc = personalDespatch.getTipoDocRemitente();
		} catch (Exception e) {
			listaTipoDoc = null;
			e.printStackTrace();
		}
		return listaTipoDoc;
	}

	public void setListaTipoDoc(List<SitbTdocide> listaTipoDoc) {
		this.listaTipoDoc = listaTipoDoc;
	}

	public void buscarPersonal() {
		if (txt1 != null && !"".equals(txt1)) {
		} else {
			filtro.setnNumdep(null);
		}
		if (((filtro.getvCodtipodocid() == null || "".equals(filtro.getvCodtipodocid().trim())) && (filtro.getvCodpersonal()==null || "".equals(filtro.getvCodpersonal().trim())))
				&& (selectedIntendencia == null || "".equals(selectedIntendencia.trim()))
				&& (filtro.getnNumdep() == null)
				&& ("".equals(filtro.getvDesapepat().trim())
						&& "".equals(filtro.getvDesapemat().trim()) && ""
							.equals(filtro.getvDesnombres().trim()))) {
			listaPersonal = null;
			Funciones.mostrarMensajeError("Debe ingresar o seleccionar al menos un criterio de búsqueda.");
			return;
		}
		if(Funciones.documentoNoValido(filtro.getvCodtipodocid(), filtro.getvCodpersonal())){return;}
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {			
			if(selectedIntendencia != null && !"".equals(selectedIntendencia.trim()))
			{
				filtro.setnNumint(new BigDecimal(selectedIntendencia));
			}
			listaPersonal = personalDespatch.getPersonalRRHH(filtro);
		} catch (Exception e) {
			listaPersonal = null;
			e.printStackTrace();
		}
	}

	public String verPersonal(boolean modo) {
		modoCompleto=modo;
		selectedIntendencia="";
		txt1 = "";
		dependenciaSeleccionada = null;
		listaPersonal = null;
		filtro = new VstPersonalrrhh();
		String vista = "pretty:personalPretty";
		// CODIGO
		return vista;
	}
	
	public String verPersonalTurno(boolean modo) {
		modoCompleto=modo;
		selectedIntendencia="";
		txt1 = "";
		dependenciaSeleccionada = null;
		listaPersonal = null;
		filtro = new VstPersonalrrhh();
		String vista = "pretty:personalTurnoPretty";
		// CODIGO
		return vista;
	}
	
	public List<String> completeTextProfesionE(String query) {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		profesionesAutocompleteE = new ArrayList<SitbProfesion>();
		try {
			profesionesAutocompleteE = personalDespatch
					.getAutocompletarProfesion(query);							
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> results = new ArrayList<String>();

		for (Iterator iterator = profesionesAutocompleteE.iterator(); iterator
				.hasNext();) {
			SitbProfesion sitbProfesion = (SitbProfesion) iterator
					.next();
			results.add(sitbProfesion.getvDesprof());
		}
		return results;
	}
	
	public void onItemSelectProfesionE(SelectEvent event) {
		for (Iterator iterator = profesionesAutocompleteE.iterator(); iterator
				.hasNext();) {
			SitbProfesion sitbProfesion = (SitbProfesion) iterator
					.next();
			if (event.getObject().toString()
					.equals(sitbProfesion.getvDesprof())) {
				profesionSeleccionadaE = sitbProfesion;
				editarDetProfesion.setvCodprof(profesionSeleccionadaE.getvCodprof());				
			}
		}
	}
	
	public List<String> completeTextProfesion(String query) {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		profesionesAutocomplete = new ArrayList<SitbProfesion>();
		try {
			profesionesAutocomplete = personalDespatch
					.getAutocompletarProfesion(query);							
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> results = new ArrayList<String>();

		for (Iterator iterator = profesionesAutocomplete.iterator(); iterator
				.hasNext();) {
			SitbProfesion sitbProfesion = (SitbProfesion) iterator
					.next();
			results.add(sitbProfesion.getvDesprof());
		}
		return results;
	}
	
	public void onItemSelectProfesion(SelectEvent event) {
		for (Iterator iterator = profesionesAutocomplete.iterator(); iterator
				.hasNext();) {
			SitbProfesion sitbProfesion = (SitbProfesion) iterator
					.next();
			if (event.getObject().toString()
					.equals(sitbProfesion.getvDesprof())) {
				profesionSeleccionada = sitbProfesion;
				nuevoDetProfesion.setvCodprof(profesionSeleccionada.getvCodprof());				
			}
		}
	}

	public List<String> completeText(String query) {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		dependenciasAutocomplete = new ArrayList<TdtbcDependencia>();
		try {
			dependenciasAutocomplete = personalDespatch
					.getAutocompletarDependenciaEIntendencia(query,
							selectedIntendencia);
							//PGP_Usuario.getN_numint());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> results = new ArrayList<String>();

		for (Iterator iterator = dependenciasAutocomplete.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			results.add(tdtbcDependencia.getvDesdep());
		}
		return results;
	}

	public void onItemSelect(SelectEvent event) {
		for (Iterator iterator = dependenciasAutocomplete.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			if (event.getObject().toString()
					.equals(tdtbcDependencia.getvDesdep())) {
				dependenciaSeleccionada = tdtbcDependencia;
				filtro.setnNumdep(dependenciaSeleccionada.getnNumdep());
			}
		}
	}

	public List<String> completeText2(String query) {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		dependenciasAutocomplete2 = new ArrayList<TdtbcDependencia>();
		try {
			dependenciasAutocomplete2 = personalDespatch
					.getAutocompletarDependenciaEIntendencia(query,
							selectedIntendencia2);
							//PGP_Usuario.getN_numint());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> results = new ArrayList<String>();

		for (Iterator iterator = dependenciasAutocomplete2.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			results.add(tdtbcDependencia.getvDesdep());
		}
		return results;
	}

	public void onItemSelect2(SelectEvent event) {
		for (Iterator iterator = dependenciasAutocomplete2.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			if (event.getObject().toString()
					.equals(tdtbcDependencia.getvDesdep())) {
				dependenciaSeleccionada2 = tdtbcDependencia;
				nuevoPersonal.setnNumdep(dependenciaSeleccionada2.getnNumdep());
			}
		}
	}

	public boolean validaFormulario() {
		if(nuevoPersonal.getvCodtipodocid()!=null && !"".equals(nuevoPersonal.getvCodtipodocid().trim())){}
		else
		{
			mensajeValida="Seleccione un tipo de documento de personal.";
			return false;
		}
		if(nuevoPersonal.getvCodpersonal()!=null && !"".equals(nuevoPersonal.getvCodpersonal().trim()))
		{
			if("03".equals(nuevoPersonal.getvCodtipodocid()) || "06".equals(nuevoPersonal.getvCodtipodocid()) || "08".equals(nuevoPersonal.getvCodtipodocid()))
			{
				if(nuevoPersonal.getvDesapepat()!=null && !"".equals(nuevoPersonal.getvDesapepat().trim()) && nuevoPersonal.getvDesapemat()!=null && !"".equals(nuevoPersonal.getvDesapemat().trim()) && nuevoPersonal.getvDesnombres()!=null && !"".equals(nuevoPersonal.getvDesnombres().trim())){}
				else
				{
					mensajeValida="Ingrese nombres y apellidos del personal.";
					return false;
				}
			}			
		}
		else
		{
			mensajeValida="Ingrese número de documento de remitente.";
			return false;
		}
		if(nuevoPersonal.getvCodtipo()!=null && !"".equals(nuevoPersonal.getvCodtipo().trim())){}
		else
		{
			mensajeValida="Seleccione un tipo de personal.";
			return false;
		}
		if(nuevoPersonal.getnNumdep()!=null){}
		else
		{
			mensajeValida="Ingrese una dependencia destino.";
			return false;
		}
		if(hayCargoNuevo)
		{
			if(nuevoCargo.getvNomcargo()!=null && !"".equals(nuevoCargo.getvNomcargo().trim())){}
			else
			{
				mensajeValida="Ingrese un cargo de personal.";
				return false;
			}
		}
		else
		{
			if(nuevoPersonal.getvCodcargo()!=null && !"".equals(nuevoPersonal.getvCodcargo().trim())){}
			else
			{
				mensajeValida="Seleccione un cargo de personal.";
				return false;
			}
		}		
		/*if(nuevoPersonal.getvCodescala()!=null && !"".equals(nuevoPersonal.getvCodescala().trim())){}
		else
		{
			mensajeValida="Seleccione una escala remunerativa.";
			return false;
		}	*/	
		/*if(nuevoPersonal.getvCorreoe()!=null && !"".equals(nuevoPersonal.getvCorreoe().trim())){}
		else
		{
			mensajeValida="Ingrese correo electrónico de personal.";
			return false;
		}
		if(!FacesUtils.validarEmail(nuevoPersonal.getvCorreoe()))
		{
			mensajeValida="Estimado usuario, por favor ingrese correo electrónico válido.";
			return false;
		}
		if(nuevoPersonal.getnFlgactivo()!=null){}
		else
		{
			mensajeValida="Seleccione un estado.";
			return false;
		}*/
		if(nuevoPersonal.getdFecnac()!=null)
		{
			if(nuevoPersonal.getdFecnac().after(new Date()))
			{
				mensajeValida="La fecha de nacimiento no puede ser mayor a la fecha actual.";
				return false;
			}
			if(!validaFechaRegular18(nuevoPersonal.getdFecnac()))
			{
				mensajeValida="Verifique la fecha de nacimiento.";
				return false;
			}
		}
		else
		{
			mensajeValida="Ingrese fecha de nacimiento.";
			return false;
		}
		if(fechaInicio!=null)
		{
			/*if(!validaFechaInicioSUNAFIL(fechaInicio))
			{
				mensajeValida="La fecha de inicio no puede ser anterior a la fecha de creación de SUNAFIL.";
				return false;
			}*/
			if(fechaInicio.after(new Date()))
			{
				mensajeValida="La fecha de inicio no puede ser mayor a la fecha actual.";
				return false;
			}
		}
		else
		{
			mensajeValida="Ingrese fecha de inicio.";
			return false;
		}
		return true;
	}

	public String guardar() {
		if (txt2 != null && !"".equals(txt2)) {
		} else {
			nuevoPersonal.setnNumdep(null);
		}
		PersonalDespatch personalDespatch = new PersonalDespatch();
		if(!validaFormulario())
		{
			Funciones.mostrarMensajeError(mensajeValida);			
			return "pretty:nuevoPersonalPretty";
		}
		//pendiente validar que no este ya registrado en tabla personal
		PrtbcPersonal reviewTemp;
		try {
			PrtbcPersonal filtroTemp=new PrtbcPersonal();			
			filtroTemp.setvCodtipodocid(nuevoPersonal.getvCodtipodocid());
			filtroTemp.setvCodpersonal(nuevoPersonal.getvCodpersonal());
			reviewTemp = personalDespatch.getPersonal(filtroTemp).get(0);
		} catch (Exception e) {
			reviewTemp=null;
		}	
		if(reviewTemp!=null)
		{
			Funciones.mostrarMensajeError("Ya existe una persona registrada con este número de documento, favor de verificar.");			
			return "pretty:nuevoPersonalPretty";
		}
		//end validar ya registrado
		try {
			if(hayCargoNuevo)
			{//primero intentar guardar el cargo(por si se repite) y luego asignarlo a nuevoPersonal
				//
				CargosDespatch cargosDespatch=new CargosDespatch();
				if(nombreCargoEsNulo(nuevoCargo))
					return "pretty:nuevoPersonalPretty";
				try {
					nuevoCargo.setvNomcargo(nuevoCargo.getvNomcargo().toUpperCase());
					nuevoCargo.setvFlgact("1");
					if(!cargosDespatch.getTieneCargo(nuevoCargo.getvNomcargo()))
					{
						nuevoCargo.setvCodcargo(getSiguienteCorrelativoGlobalPerCargo());
						nuevoCargo.setvDescargo(nuevoCargo.getvNomcargo());
						cargosDespatch.insertarCargo(nuevoCargo);
						nuevoPersonal.setvCodcargo(nuevoCargo.getvCodcargo());
					}else
					{
						Funciones.mostrarMensajeError("Cargo repetido");
						return "pretty:nuevoPersonalPretty";
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//
			}
			nuevoPersonal.setvDesapepat(nuevoPersonal.getvDesapepat().toUpperCase());
			nuevoPersonal.setvDesapemat(nuevoPersonal.getvDesapemat().toUpperCase());
			nuevoPersonal.setvDesnombres(nuevoPersonal.getvDesnombres().toUpperCase());
			nuevoPersonal.setnFlgactivo(new Short("1"));
			nuevoPersonal.setvCorreoe(" ");
			nuevoPersonal.setnCodperrhh(new BigDecimal(nuevoPersonal.getvCodpersonal()));
			nuevoPersonal.setvCodescala("0");
			nuevoPersonal.setvNomusureg(PGP_Usuario.getV_codusu());
			nuevoPersonal.setdFecreg(new Date());
			personalDespatch.insertarPersonal(nuevoPersonal);
			//insertar detalle personal
			RhtbdPersonal nuevoDetallePersonal=new RhtbdPersonal();
			nuevoDetallePersonal.setvCodpersonal(nuevoPersonal.getvCodpersonal());
			String detttt=getSiguienteCorrelativoGlobalDetalle(nuevoPersonal.getvCodpersonal());
			System.out.println("detttt :::: "+detttt);
			nuevoDetallePersonal.setnCorper(new BigDecimal(detttt));
			nuevoDetallePersonal.setnNumdep(nuevoPersonal.getnNumdep());
			nuevoDetallePersonal.setvCodcargo(nuevoPersonal.getvCodcargo());
			nuevoDetallePersonal.setvCodescala(nuevoPersonal.getvCodescala());
			nuevoDetallePersonal.setvCodtipo(nuevoPersonal.getvCodtipo());
			nuevoDetallePersonal.setvFlgprin("S");
			nuevoDetallePersonal.setvFlgact("S");
			nuevoDetallePersonal.setdFecini(fechaInicio);
			nuevoDetallePersonal.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoDetallePersonal.setdFecreg(new Date());
			nuevoDetallePersonal.setvNumcon(nroContrato);
			nuevoDetallePersonal.setvAnocon(anioContrato);
			personalDespatch.insertarDetallePersonal(nuevoDetallePersonal);			
			//end insertar detalle personal			
			//asignar turno CAS por defecto
			if("7".equals(nuevoPersonal.getvCodtipo()))
			{
				RhmvcPerturno defaultPerTurno=new RhmvcPerturno();
				defaultPerTurno.setdFecinicio(new Date());
				defaultPerTurno.setnCodturno(new Short("1"));//CAS
				defaultPerTurno.setvCodpersonal(nuevoPersonal.getvCodpersonal());
				defaultPerTurno.setnCodperturno(new Short(getSiguienteCorrelativoGlobalPerTurno()));
				defaultPerTurno.setvFlgact("S");			
				try {
					personalDespatch.insertarPerTurno(defaultPerTurno);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
			//end asignar turno CAS por defecto
			VstPersonalrrhh entTemp=new VstPersonalrrhh();
			entTemp.setvCodtipodocid(nuevoPersonal.getvCodtipodocid());
			entTemp.setvCodpersonal(nuevoPersonal.getvCodpersonal());
			filtro=entTemp;
			buscarPersonal();
			Funciones.mostrarMensajeInfo("Nuevo personal registrado.");			
			return "pretty:personalPretty";
		} catch (Exception e) {
			e.printStackTrace();
			return "pretty:nuevoPersonalPretty";
		}
	}

	public String nuevo() {
		selectedIntendencia2="";
		txt2 = "";
		dependenciaSeleccionada2 = null;
		nuevoPersonal = new PrtbcPersonal();
		fechaInicio=new Date();
		hayCargoNuevo=false;
		anioContrato="";
		nroContrato="";
		String vista = "pretty:nuevoPersonalPretty";
		// CODIGO
		return vista;
	}
	
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
	
	public List<String> completeText3(String query) {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		dependenciasAutocomplete3 = new ArrayList<TdtbcDependencia>();
		try {
			dependenciasAutocomplete3 = personalDespatch
					.getAutocompletarDependenciaEIntendencia(query,
							selectedIntendencia3);
							//PGP_Usuario.getN_numint());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> results = new ArrayList<String>();

		for (Iterator iterator = dependenciasAutocomplete3.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			results.add(tdtbcDependencia.getvDesdep());
		}
		return results;
	}

	public void onItemSelect3(SelectEvent event) {
		for (Iterator iterator = dependenciasAutocomplete3.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			if (event.getObject().toString()
					.equals(tdtbcDependencia.getvDesdep())) {
				dependenciaSeleccionada3 = tdtbcDependencia;
				nuevoDetPersonal.setnNumdep(dependenciaSeleccionada3.getnNumdep());
			}
		}
	}
	
	public boolean validaFormularioEditar() {
		if(selectedPersonal.getvCodtipodocid()!=null && !"".equals(selectedPersonal.getvCodtipodocid().trim())){}
		else
		{
			mensajeValida="Seleccione un tipo de documento de personal.";
			return false;
		}
		if(selectedPersonal.getvCodpersonal()!=null && !"".equals(selectedPersonal.getvCodpersonal().trim()))
		{
			if("03".equals(selectedPersonal.getvCodtipodocid()) || "06".equals(selectedPersonal.getvCodtipodocid()) || "08".equals(selectedPersonal.getvCodtipodocid()))
			{
				if(selectedPersonal.getvDesapepat()!=null && !"".equals(selectedPersonal.getvDesapepat().trim()) && selectedPersonal.getvDesapemat()!=null && !"".equals(selectedPersonal.getvDesapemat().trim()) && selectedPersonal.getvDesnombres()!=null && !"".equals(selectedPersonal.getvDesnombres().trim())){}
				else
				{
					mensajeValida="Ingrese nombres y apellidos del personal.";
					return false;
				}
			}			
		}
		else
		{
			mensajeValida="Ingrese número de documento de personal.";
			return false;
		}
		/*if(selectedPersonal.getvCodtipo()!=null && !"".equals(selectedPersonal.getvCodtipo().trim())){}
		else
		{
			mensajeValida="Seleccione un tipo de personal.";
			return false;
		}
		if(selectedPersonal.getnNumdep()!=null){}
		else
		{
			mensajeValida="Ingrese una dependencia destino.";
			return false;
		}
		if(selectedPersonal.getvCodcargo()!=null && !"".equals(selectedPersonal.getvCodcargo().trim())){}
		else
		{
			mensajeValida="Seleccione un cargo de personal.";
			return false;
		}
		if(selectedPersonal.getvCodescala()!=null && !"".equals(selectedPersonal.getvCodescala().trim())){}
		else
		{
			mensajeValida="Seleccione una escala remunerativa.";
			return false;
		}		
		if(selectedPersonal.getvCorreoe()!=null && !"".equals(selectedPersonal.getvCorreoe().trim())){}
		else
		{
			mensajeValida="Ingrese correo electrónico de personal.";
			return false;
		}
		if(!FacesUtils.validarEmail(selectedPersonal.getvCorreoe()))
		{
			mensajeValida="Estimado usuario, por favor ingrese correo electrónico válido.";
			return false;
		}*/
		if(selectedPersonal.getnFlgactivo()!=null)
		{
			if(selectedPersonal.getnFlgactivo()==0)
			{
				if(fechaBaja!=null)
				{
					if(!validaFechaInicioSUNAFIL(fechaBaja))
					{
						mensajeValida="La fecha de baja no puede ser anterior a la creación de SUNAFIL.";
						return false;
					}
				}
				else
				{
					mensajeValida="Ingrese fecha de baja.";
					return false;
				}
			}
		}
		else
		{
			mensajeValida="Seleccione un estado.";
			return false;
		}
		if(selectedPersonal.getdFecnac()!=null)
		{
			if(selectedPersonal.getdFecnac().after(new Date()))
			{
				mensajeValida="La fecha de nacimiento no puede ser mayor a la fecha actual.";
				return false;
			}
			if(!validaFechaRegular18(selectedPersonal.getdFecnac()))
			{
				mensajeValida="Verifique la fecha de nacimiento..";
				return false;
			}
		}
		else
		{
			mensajeValida="Ingrese fecha de nacimiento.";
			return false;
		}
		return true;
	}
	
	public void editar(boolean origen) {//String		
		if (txt3 != null && !"".equals(txt3)) {
		} else {
			selectedPersonal.setnNumdep(null);
		}
		PersonalDespatch personalDespatch = new PersonalDespatch();
		if(!validaFormularioEditar())
		{
			Funciones.mostrarMensajeError(mensajeValida);			
			return;
			//return "pretty:editarPersonalPretty";
		}
		//manejo de confirm
		if(origen && selectedPersonal.getnFlgactivo()==0)
		{
			System.out.println("Entro a manejo de confirm");
			RequestContext.getCurrentInstance().execute("dialogWidgetBaja.show()");			
			return;
			//return "pretty:editarPersonalPretty";
		}
		//end manejo de confirm
		try {
			selectedPersonal.setvDesapepat(selectedPersonal.getvDesapepat().toUpperCase());
			selectedPersonal.setvDesapemat(selectedPersonal.getvDesapemat().toUpperCase());
			selectedPersonal.setvDesnombres(selectedPersonal.getvDesnombres().toUpperCase());
			selectedPersonal.setvNomusumod(PGP_Usuario.getV_codusu());
			selectedPersonal.setdFecmod(new Date());
			personalDespatch.actualizarPersonal(selectedPersonal);
			//si estado es inactivo entonces actualizar todos los detalles a inactivo también
			if(selectedPersonal.getnFlgactivo()==0)
			{
				personalDespatch.disableDateDetallePersonal(selectedPersonal.getvCodpersonal(), fechaBaja);
				personalDespatch.disableFlgActDetallePersonal(selectedPersonal.getvCodpersonal());
				personalDespatch.disableDatePerTurno(selectedPersonal.getvCodpersonal(), fechaBaja);
			}			
			//end si estado es inactivo entonces actualizar todos los detalles a inactivo también
			VstPersonalrrhh entTemp=new VstPersonalrrhh();
			entTemp.setvCodtipodocid(selectedPersonal.getvCodtipodocid());
			entTemp.setvCodpersonal(selectedPersonal.getvCodpersonal());
			filtro=entTemp;
			buscarPersonal();
			cargarListaDetallePersonal();
			cargarListaSindicato();
			cargarListaProfesion();
			cargarListaEntfinanciera();
			cargarListaSeguro();
			cargarListaSeguroSCTR();
			cargarListaRegPensionario();
			cargarListaDirecciones();
			cargarListaDependientes();
			Funciones.mostrarMensajeInfo("Personal actualizado.");			
			//return "pretty:personalPretty";
			return;
		} catch (Exception e) {
			e.printStackTrace();
			//return "pretty:editarPersonalPretty";
			return;
		}
	}
	
	public void cargarListaDetallePersonal()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaDetPersonal=personalDespatch.getVistaDetallePersonal(selectedPersonal.getvCodpersonal());
		} catch (Exception e) {
			listaDetPersonal=null;
			e.printStackTrace();
		}
	}
	
	public void cargarListaSindicato()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaSindicato=personalDespatch.getDetalleSindicatoVista(selectedPersonal.getvCodpersonal());
		} catch (Exception e) {
			listaSindicato=null;
			e.printStackTrace();
		}
	}
	
	public void cargarListaProfesion()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaProfesion=personalDespatch.getDetalleProfesionVista(selectedPersonal.getvCodpersonal());
		} catch (Exception e) {
			listaProfesion=null;
			e.printStackTrace();
		}
	}
	
	public void cargarListaEntfinanciera()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaEntfinanciera=personalDespatch.getDetalleInformacionFinancieraVista(selectedPersonal.getvCodpersonal());
		} catch (Exception e) {
			listaEntfinanciera=null;
			e.printStackTrace();
		}
	}
	
	public void cargarListaSeguro()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaSeguro=personalDespatch.getDetalleSeguroVista(selectedPersonal.getvCodpersonal());
		} catch (Exception e) {
			listaSeguro=null;
			e.printStackTrace();
		}
	}
	
	public void cargarListaSeguroSCTR()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaSeguroSCTR=personalDespatch.getDetalleSeguroVistaSCTR(selectedPersonal.getvCodpersonal());
		} catch (Exception e) {
			listaSeguroSCTR=null;
			e.printStackTrace();
		}
	}
	
	public void cargarListaRegPensionario()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaRegPensionario=personalDespatch.getDetalleRegimenPensionarioVista(selectedPersonal.getvCodpersonal());
		} catch (Exception e) {
			listaRegPensionario=null;
			e.printStackTrace();
		}
	}
	
	public void cargarListaDirecciones()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaDirecciones=personalDespatch.getDetalleDireccionVista(selectedPersonal.getvCodpersonal());
		} catch (Exception e) {
			listaDirecciones=null;
			e.printStackTrace();
		}
	}
	
	public void cargarListaDependientes()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaDependientes=personalDespatch.getDependientesVista(selectedPersonal.getvCodpersonal());
		} catch (Exception e) {
			listaDependientes=null;
			e.printStackTrace();
		}
	}
	
	public String selectEditar(VstPersonalrrhh item)
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		selectedPersonal=new PrtbcPersonal();
		selectedPersonal.setvCodtipodocid(item.getvCodtipodocid());
		selectedPersonal.setvCodpersonal(item.getvCodpersonal());
		selectedPersonal.setvDesapepat(item.getvDesapepat());
		selectedPersonal.setvDesapemat(item.getvDesapemat());
		selectedPersonal.setvDesnombres(item.getvDesnombres());
		selectedPersonal.setvCodtipo(item.getvCodtipo());
		selectedPersonal.setnNumdep(item.getnNumdep());
		selectedPersonal.setvCodcargo(item.getvCodcargo());
		selectedPersonal.setvCodescala(item.getvCodescala());
		selectedPersonal.setvCorreoe(item.getvCorreoe());
		selectedPersonal.setnFlgactivo(item.getnFlgactivo());
		selectedPersonal.setdFecnac(item.getdFecnac());
		selectedPersonal.setvNumtelfij(item.getvNumtelfij());
		selectedPersonal.setvNumtelcel(item.getvNumtelcel());
		selectedPersonal.setvCorreoins(item.getvCorreoins());
		selectedPersonal.setvCorreoper(item.getvCorreoper());		
		cargarListaDetallePersonal();
		cargarListaSindicato();
		cargarListaProfesion();
		cargarListaEntfinanciera();
		cargarListaSeguro();
		cargarListaSeguroSCTR();
		cargarListaRegPensionario();
		cargarListaDirecciones();
		cargarListaDependientes();
		//selectedPersonal=item;
		/*try {
			dependenciaSeleccionada3=personalDespatch.getDependenciaPorCodigo(item.getnNumdep());
			txt3=dependenciaSeleccionada3.getvDesdep();
			selectedIntendencia3=""+dependenciaSeleccionada3.getnNumint();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String vista = "pretty:editarPersonalPretty"; 
        //CODIGO
        return vista;
	}
	
	public void itemChangeIntendencia()
	{
		if(selectedIntendencia == null || "".equals(selectedIntendencia.trim()))
		{
			txt1 = "";
			dependenciaSeleccionada = null;
		}
	}
	
	public void itemChangeIntendencia2()
	{
		if(selectedIntendencia2 == null || "".equals(selectedIntendencia2.trim()))
		{
			txt2 = "";
			dependenciaSeleccionada2 = null;
		}
	}
	
	public void itemChangeIntendencia3()
	{
		if(selectedIntendencia3 == null || "".equals(selectedIntendencia3.trim()))
		{
			txt3 = "";
			dependenciaSeleccionada3 = null;
		}
	}
	
	public void getDatosReniec()
	{		
		if(nuevoPersonal.getvCodtipodocid()!=null && !"".equals(nuevoPersonal.getvCodtipodocid().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de documento de personal.");			
			return;
		}		
		if(nuevoPersonal.getvCodpersonal()!=null && !"".equals(nuevoPersonal.getvCodpersonal().trim()))
		{
			if(nuevoPersonal.getvCodpersonal().trim().length()!=8)
			{
				Funciones.mostrarMensajeError("El número de DNI debe tener 8 dígitos.");						
				return;
			}
		}
		else
		{
			Funciones.mostrarMensajeError("Ingrese un número de DNI.");					
			return;
		}
		Persona per=new Persona();
		try {
			per=obtenerPersona(nuevoPersonal.getvCodtipodocid(),nuevoPersonal.getvCodpersonal());
		} catch (Exception e) {
			per=null;
			e.printStackTrace();
		}
		try {
			per.valuesToString();
		} catch (Exception e) {
			e.printStackTrace();
		}							
		if(per!=null && ("0000".equals(per.getV_coderror()) || per.getV_coderror()==null))
		{			
			nuevoPersonal.setvDesapepat(per.getV_apepater());
			nuevoPersonal.setvDesapemat(per.getV_apemater());
			nuevoPersonal.setvDesnombres(per.getV_nombres());
			nuevoPersonal.setdFecnac(per.getD_fecnac());													
		}
		else if("DNE".equals(per.getV_coderror()) || "NHC".equals(per.getV_coderror()))
		{
			System.out.println("No recupero nada");
			nuevoPersonal.setvDesapepat("");
			nuevoPersonal.setvDesapemat("");
			nuevoPersonal.setvDesnombres("");			
			nuevoPersonal.setdFecnac(null);
			Funciones.mostrarMensajeError("No se ha encontrado una persona con ese número de DNI.");			
		}			
	}
	
	public void getDatosReniecDependiente()
	{		
		if(nuevoDependiente.getvCodtdocide()!=null && !"".equals(nuevoDependiente.getvCodtdocide().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de documento de dependiente.");			
			return;
		}		
		if(nuevoDependiente.getvNumdoc()!=null && !"".equals(nuevoDependiente.getvNumdoc().trim()))
		{
			if(nuevoDependiente.getvNumdoc().trim().length()!=8)
			{
				Funciones.mostrarMensajeError("El número de DNI debe tener 8 dígitos.");						
				return;
			}
		}
		else
		{
			Funciones.mostrarMensajeError("Ingrese un número de DNI.");					
			return;
		}
		Persona per=new Persona();
		try {
			per=obtenerPersona(nuevoDependiente.getvCodtdocide(),nuevoDependiente.getvNumdoc());
		} catch (Exception e) {
			per=null;
			e.printStackTrace();
		}
		try {
			per.valuesToString();
		} catch (Exception e) {
			e.printStackTrace();
		}							
		if(per!=null && ("0000".equals(per.getV_coderror()) || per.getV_coderror()==null))
		{			
			nuevoDependiente.setvApepatmat(per.getV_apepater());
			nuevoDependiente.setvApematmat(per.getV_apemater());
			nuevoDependiente.setvNombres(per.getV_nombres());
			nuevoDependiente.setdFecnac(per.getD_fecnac());					
			dFecNacDependiente=per.getD_fecnac();
			nuevoDependiente.setvFlgreniec("S");
		}
		else if("DNE".equals(per.getV_coderror()) || "NHC".equals(per.getV_coderror()))
		{
			System.out.println("No recupero nada");
			nuevoDependiente.setvApepatmat("");
			nuevoDependiente.setvApematmat("");
			nuevoDependiente.setvNombres("");			
			nuevoDependiente.setdFecnac(null);
			dFecNacDependiente=new Date();
			nuevoDependiente.setvFlgreniec("N");
			Funciones.mostrarMensajeError("No se ha encontrado una persona con ese número de DNI.");			
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
						vflgReniec="N";
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
							System.out.println("fechaaa :::"+pexTemp.getV_fecnac());
							SimpleDateFormat simpleDate=new SimpleDateFormat("dd/MM/yyyy");
							pex.setD_fecnac(simpleDate.parse(pexTemp.getV_fecnac()));
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
								Funciones.mostrarMensajeError(texto);								
								if(validaEnvioCorreo==true){												
									EnviarMail enviarCorreo=new EnviarMail();
									String[] direcciones=new String[1];									
									direcciones[0]="wcastro@sunafil.gob.pe";
									String mensaje="No se encontro DNI";								
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
			//FacesUtils.showFacesMessage("Problema de comunicación con RENIEC porfavor registrar", 1);			
			EnviarMail enviarCorreo=new EnviarMail();
			String[] direcciones=new String[1];		
			direcciones[0]="wcastro@sunafil.gob.pe";
			String mensaje="No se encontro DNI";								
			String asunto="Error grave web Service RENIEC RETCC VIRTUAL";
			logger.error("Enviando correo de aviso de error grave en el catch.");
			//mensaje=e.getMessage();
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
	
	public void cargarListaTurnoPersonal()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaTurnoPersonal=personalDespatch.getTurnoPersonal(selectedPersonalT.getvCodpersonal());
		} catch (Exception e) {
			listaTurnoPersonal=null;
			e.printStackTrace();
		}
	}
	
	public String selectEditarT(VstPersonalrrhh item)
	{
		selectedPersonalT=item;		
		cargarListaTurnoPersonal();
		String vista = "pretty:turnoPersonalPretty"; 
        //CODIGO
        return vista;
	}
	
	public boolean validarFormularioTurnoPersonal()
	{		
		System.out.println("nuevoPerTurno.getnCodturno() ::: "+nuevoPerTurno.getnCodturno());		
		//validar q no haya otro turno activo para esa persona
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			boolean flag=personalDespatch.getTieneTurnoActivo(selectedPersonalT.getvCodpersonal());
			if(flag)
			{
				mensajeValidaTP="La persona ya tiene un turno en estado activo.";
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//end validar q no haya otro turno activo para esa persona
		//validar q	la fecha ingresada sea debe ser mayor o igual q la fecha menor de inicio de labores
		if(nuevoPerTurno.getdFecinicio()!=null)
		{
			if(!validaFechaInicioSUNAFIL(nuevoPerTurno.getdFecinicio()))
			{
				mensajeValidaTP="La fecha de inicio no puede ser anterior a la fecha de creación de SUNAFIL.";
				return false;
			}			
			try {
				Date minFecha=personalDespatch.getMinDateDetalle(selectedPersonalT.getvCodpersonal()).getdFecini();
				if(nuevoPerTurno.getdFecinicio().before(minFecha))
				{
					mensajeValidaTP="La fecha de Inicio de Turno debe ser mayor que la fecha de Inicio de Labores.";
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//end validar q	la fecha ingresada sea debe ser mayor o igual q la fecha menor de inicio de labores
		//validar q los rangos de fecha no se cruzen
		if(nuevoPerTurno.getdFecinicio()!=null)
		{
			try {
				Date minFecha=personalDespatch.getMinDatePerTurno(selectedPersonalT.getvCodpersonal()).getdFecinicio();
				Date maxFecha=personalDespatch.getMaxDatePerTurno(selectedPersonalT.getvCodpersonal()).getdFecfin();
				if(minFecha!=null && maxFecha!=null)
				{
					if(nuevoPerTurno.getdFecinicio().after(minFecha) && nuevoPerTurno.getdFecinicio().before(maxFecha))
					{
						mensajeValidaTP="La fecha de Inicio ingresada se cruza con un registro de turno.";
						return false;
					}
				}
				if(minFecha!=null && maxFecha==null)
				{
					if(nuevoPerTurno.getdFecinicio().before(minFecha))
					{
						mensajeValidaTP="La fecha de Inicio ingresada no puede ser menor que la fecha de inicio de otro registro de turno.";
						return false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//end validar q los rangos de fecha no se cruzen
		if(nuevoPerTurno.getnCodturno()!=null && nuevoPerTurno.getnCodturno()!=0){}
		else
		{
			mensajeValidaTP="Seleccione un turno.";
			return false;
		}
		/*if(nuevoPerTurno.getvFlgact()!=null && !"".equals(nuevoPerTurno.getvFlgact())){}
		else
		{
			mensajeValidaTP="Seleccione un estado.";
			return false;
		}*/
		if(nuevoPerTurno.getdFecinicio()!=null){}
		else
		{
			mensajeValidaTP="Ingrese fecha inicio.";
			return false;
		}
		/*if(nuevoPerTurno.getdFecfin()!=null){}
		else
		{
			mensajeValidaTP="Ingrese fecha fin.";
			return false;
		}
		if(nuevoPerTurno.getdFecinicio()!=null && nuevoPerTurno.getdFecfin()!=null)
		{
			if(nuevoPerTurno.getdFecinicio().after(nuevoPerTurno.getdFecfin()))
			{
				mensajeValidaTP="La fecha fin debe ser mayor a la fecha inicio.";
				return false;
			}
		}*/
		return true;
	}
	
	public String guardarTurnoPersonal()
	{
		if(!validarFormularioTurnoPersonal())
		{
			Funciones.mostrarMensajeError(mensajeValidaTP);			
			return "pretty:turnoPersonalPretty";
		}
		//pendiente validar
		nuevoPerTurno.setvCodpersonal(selectedPersonalT.getvCodpersonal());
		nuevoPerTurno.setnCodperturno(new Short(getSiguienteCorrelativoGlobalPerTurno()));
		nuevoPerTurno.setvFlgact("S");
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			personalDespatch.insertarPerTurno(nuevoPerTurno);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaTurnoPersonal();
		limpiarTurnoPersonal();
		Funciones.mostrarMensajeInfo("Se guardó el turno.");		
		String vista = "pretty:turnoPersonalPretty"; 
        //CODIGO
        return vista;
	}
	
	public void itemChangeTurno()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaTurnoDia=personalDespatch.getTurnoDia(nuevoPerTurno.getnCodturno());
		} catch (Exception e) {
			listaTurnoDia=null;
			e.printStackTrace();
		}		
	}
	
	public void limpiarTurnoPersonal()
	{
		nuevoPerTurno.setnCodturno(null);
		nuevoPerTurno.setvFlgact(null);
		nuevoPerTurno.setdFecinicio(null);
		nuevoPerTurno.setdFecfin(null);
	}
	
	public String getSiguienteCorrelativoGlobalPerTurno()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			RhmvcPerturno correlativo=personalDespatch.getCorrelativoGlobalPerTurno();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCodperturno()+1);
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
	
	public String verPersonalAfterTurno()
	{
		VstPersonalrrhh entTemp=new VstPersonalrrhh();
		entTemp.setvCodtipodocid(selectedPersonalT.getvCodtipodocid());
		entTemp.setvCodpersonal(selectedPersonalT.getvCodpersonal());
		filtro=entTemp;
		buscarPersonal();		
		String vista = "pretty:personalPretty";
		if(!modoCompleto)
		{
			vista = "pretty:personalTurnoPretty";
		}
		// CODIGO
		return vista;
	}
	
	public String getSiguienteCorrelativoGlobalDetalle(String vCodpersonal)
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			RhtbdPersonal correlativo=personalDespatch.getCorrelativoGlobalDetalle(vCodpersonal);
			if(correlativo!=null)
			{
				return ""+(Integer.parseInt(correlativo.getnCorper()+"")+1);
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
	
	public void dialogDetalle(){
		//reset detalle
		nuevoDetPersonal=new RhtbdPersonal();
		selectedIntendencia3="";
		txt3 = "";
		dependenciaSeleccionada3 = null;
		dFecini=new Date();
		deshabilitarTipoYEscala=false;
		//end reset detalle
		
		//intenta recuperar el detalle activo y principal y setea el tipo de personal y escala por defecto y bloquea esos selectores
		try {
			PersonalDespatch personalDespatch = new PersonalDespatch();
			RhtbdPersonal defaultDetalle=personalDespatch.getDefaultDetalle(selectedPersonal.getvCodpersonal());
			if(defaultDetalle!=null)
			{
				nuevoDetPersonal.setvCodtipo(defaultDetalle.getvCodtipo());
				nuevoDetPersonal.setvCodescala(defaultDetalle.getvCodescala());
				deshabilitarTipoYEscala=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//end intenta recuperar el detalle activo y principal y setea el tipo de personal y escala por defecto y bloquea esos selectores
		
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalle.show()");
	}
	
	public void dialogDetalleSindicato(){
		nuevoDetSindicato=new RhtbdPerxsindicato();
		dFeciniSindicato=new Date();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSindicato.show()");
	}
	
	public void dialogDetalleProfesion(){
		nuevoDetProfesion=new RhtbdPerxprofesion();
		txtProfesion="";
		profesionesAutocomplete=new ArrayList<SitbProfesion>();
		profesionSeleccionada=new SitbProfesion();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleProfesion.show()");
	}
	
	public void dialogDetalleEntFinanciera(){
		nuevoDetEntFinanciera=new RhtbdPerxentfinanciera();
		dFeciniEntFinanciera=new Date();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleEntFinanciera.show()");
	}
	
	public void dialogDetalleSeguro(){
		nuevoDetSeguro=new RhtbdPerxseguro();
		dFeciniEntSeguro=new Date();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSeguro.show()");
	}
	
	public void dialogDetalleSeguroSCTR(){
		nuevoDetSeguroSCTR=new RhtbdPerxseguro();
		dFeciniEntSeguroSCTR=new Date();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSeguroSCTR.show()");
	}
	
	public void dialogDetalleRegPensionario(){
		nuevoDetRegPensionario=new RhtbdPerxregpensionario();
		dFeciniRegPensionario=new Date();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleRegPensionario.show()");
	}
	
	public void dialogDetalleDireccion(){
		nuevoDetDireccion=new RhtbdPerdireccion();		
		v_coddep="";
		v_codpro="";
		v_coddis="";
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleDireccion.show()");
	}
	
	public void dialogDetalleDependiente(){
		nuevoDependiente=new RhtbdDependientes();
		dFecNacDependiente=new Date();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleDependiente.show()");
	}
	
	public void agregarDependiente()
	{
		if(nuevoDependiente.getnCodvinfam()!=null && !(new BigDecimal("0")).equals(nuevoDependiente.getnCodvinfam())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un vínculo.");
			return;
		}
		if(nuevoDependiente.getvCodtdocide()!=null && !"".equals(nuevoDependiente.getvCodtdocide().trim())){}
		else
		{			
			Funciones.mostrarMensajeError("Seleccione un tipo de documento.");
			return;
		}
		if(nuevoDependiente.getvNumdoc()!=null && !"".equals(nuevoDependiente.getvNumdoc().trim())){}
		else
		{			
			Funciones.mostrarMensajeError("Ingrese un número de documento.");
			return;
		}
		if(nuevoDependiente.getvApepatmat()!=null && !"".equals(nuevoDependiente.getvApepatmat().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese apellido paterno.");			
			return;
		}
		if(nuevoDependiente.getvApematmat()!=null && !"".equals(nuevoDependiente.getvApematmat().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese apellido materno.");
			return;
		}
		if(nuevoDependiente.getvNombres()!=null && !"".equals(nuevoDependiente.getvNombres().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese nombres.");
			return;
		}
		if(nuevoDependiente.getvGenero()!=null && !"".equals(nuevoDependiente.getvGenero().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione género.");
			return;
		}
		if(dFecNacDependiente!=null){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese fecha de nacimiento.");			
			return;
		}
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			if(personalDespatch.getTieneDependienteRepetido(selectedPersonal.getvCodpersonal(),nuevoDependiente.getvCodtdocide(),nuevoDependiente.getvNumdoc()))
			{
				Funciones.mostrarMensajeError("Ya se ha registrado el dependiente para este trabajador.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		try {				
			nuevoDependiente.setvApepatmat(nuevoDependiente.getvApepatmat().toUpperCase());
			nuevoDependiente.setvApematmat(nuevoDependiente.getvApematmat().toUpperCase());
			nuevoDependiente.setvNombres(nuevoDependiente.getvNombres().toUpperCase());
			nuevoDependiente.setvCodpersonal(selectedPersonal.getvCodpersonal());
			nuevoDependiente.setdFecnac(dFecNacDependiente);			
			nuevoDependiente.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoDependiente.setdFecreg(new Date());
			nuevoDependiente.setvHostreg(FacesUtils.getIpAddress());
			
			personalDespatch.insertarDependiente(nuevoDependiente);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaDependientes();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleDependiente.hide()");
		Funciones.mostrarMensajeInfo("Se registró el dependiente.");
	}
	
	public void agregarDetalleDireccion()
	{
		if(v_coddep!=null && !"".equals(v_coddep.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione región.");
			return;
		}
		if(v_codpro!=null && !"".equals(v_codpro.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione provincia.");
			return;
		}
		if(v_coddis!=null && !"".equals(v_coddis.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione distrito.");
			return;
		}
		if(nuevoDetDireccion.getvCodzon()!=null && !"".equals(nuevoDetDireccion.getvCodzon().trim())){}
		else
		{			
			Funciones.mostrarMensajeError("Seleccione un tipo de zona.");
			return;
		}
		if(nuevoDetDireccion.getvCodtvia()!=null && !"".equals(nuevoDetDireccion.getvCodtvia().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de vía.");			
			return;
		}
		if(nuevoDetDireccion.getvDeszona()!=null && !"".equals(nuevoDetDireccion.getvDeszona().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese zona.");			
			return;
		}
		if(nuevoDetDireccion.getvDireccion()!=null && !"".equals(nuevoDetDireccion.getvDireccion().trim())){}
		else
		{			
			Funciones.mostrarMensajeError("Ingrese dirección.");	
			return;
		}
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			personalDespatch.desactivarUltDetallesDireccionPorPersonal(selectedPersonal.getvCodpersonal());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {			
			nuevoDetDireccion.setvDeszona(nuevoDetDireccion.getvDeszona().toUpperCase());
			nuevoDetDireccion.setvDireccion(nuevoDetDireccion.getvDireccion().toUpperCase());
			nuevoDetDireccion.setnCorperdir(new BigDecimal(getSiguienteCorrelativoDireccion()));
			nuevoDetDireccion.setvCodpersonal(selectedPersonal.getvCodpersonal());
			nuevoDetDireccion.setvCoddep(v_coddep);
			nuevoDetDireccion.setvCodpro(v_codpro);
			nuevoDetDireccion.setvCoddis(v_coddis);
			nuevoDetDireccion.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoDetDireccion.setdFecreg(new Date());
			nuevoDetDireccion.setvHostreg(FacesUtils.getIpAddress());
			nuevoDetDireccion.setvFlgdirult("S");
			
			personalDespatch.insertarDetalleDireccion(nuevoDetDireccion);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaDirecciones();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleDireccion.hide()");
		Funciones.mostrarMensajeInfo("Se registró la dirección.");
	}
	
	public void agregarRegPensionario()
	{
		if(nuevoDetRegPensionario.getnCodregpen()!=null && !(new BigDecimal("0")).equals(nuevoDetRegPensionario.getnCodregpen())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de régimen.");			
			return;
		}
		if(dFeciniRegPensionario!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniRegPensionario))
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
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			if(personalDespatch.getTieneRegimenActivo(selectedPersonal.getvCodpersonal()))
			{
				Funciones.mostrarMensajeError("Existe información de régimen activa, primero debe establecer una fecha de fin.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(personalDespatch.getTieneRegimenCruzeIni(selectedPersonal.getvCodpersonal(), dFeciniRegPensionario) || 
					personalDespatch.getTieneRegimenCruzeFin(selectedPersonal.getvCodpersonal(), dFeciniRegPensionario))
			{
				Funciones.mostrarMensajeError("La fecha de inicio ingresada se cruza con un registro ya existente.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {			
			nuevoDetRegPensionario.setnCorperregpen(new BigDecimal(getSiguienteCorrelativoRegimenPensionario()));
			nuevoDetRegPensionario.setvCodpersonal(selectedPersonal.getvCodpersonal());
			nuevoDetRegPensionario.setdFecini(dFeciniRegPensionario);
			nuevoDetRegPensionario.setvFlgact("S");
			nuevoDetRegPensionario.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoDetRegPensionario.setdFecreg(new Date());
			nuevoDetRegPensionario.setvHostreg(FacesUtils.getIpAddress());
			
			personalDespatch.insertarDetalleRegimenPensionario(nuevoDetRegPensionario);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaRegPensionario();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleRegPensionario.hide()");
		Funciones.mostrarMensajeInfo("Se registró el régimen pensionario.");
	}
	
	public void agregarDetalleSeguro()
	{
		if(nuevoDetSeguro.getnCodseguro()!=null && !(new BigDecimal("0")).equals(nuevoDetSeguro.getnCodseguro())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de seguro.");			
			return;
		}
		if(dFeciniEntSeguro!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniEntSeguro))
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
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			if(personalDespatch.getTieneSeguroActivo(selectedPersonal.getvCodpersonal()))
			{
				Funciones.mostrarMensajeError("Existe información de seguro activa, primero debe establecer una fecha de fin.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(personalDespatch.getTieneSeguroCruzeIni(selectedPersonal.getvCodpersonal(), dFeciniEntSeguro) || 
					personalDespatch.getTieneSeguroCruzeFin(selectedPersonal.getvCodpersonal(), dFeciniEntSeguro))
			{
				Funciones.mostrarMensajeError("La fecha de inicio ingresada se cruza con un registro ya existente.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {			
			nuevoDetSeguro.setnCorperseg(new BigDecimal(getSiguienteCorrelativoSeguro()));
			nuevoDetSeguro.setvCodpersonal(selectedPersonal.getvCodpersonal());
			nuevoDetSeguro.setdFecini(dFeciniEntSeguro);
			nuevoDetSeguro.setvFlgact("S");
			nuevoDetSeguro.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoDetSeguro.setdFecreg(new Date());
			nuevoDetSeguro.setvHostreg(FacesUtils.getIpAddress());
			
			personalDespatch.insertarDetalleSeguro(nuevoDetSeguro);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaSeguro();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSeguro.hide()");
		Funciones.mostrarMensajeInfo("Se registró el seguro.");
	}
	
	public void agregarDetalleSeguroSCTR()
	{
		if(nuevoDetSeguroSCTR.getnCodseguro()!=null && !(new BigDecimal("0")).equals(nuevoDetSeguroSCTR.getnCodseguro())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de seguro SCTR.");			
			return;
		}
		if(dFeciniEntSeguroSCTR!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniEntSeguroSCTR))
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
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			if(personalDespatch.getTieneSeguroSCTRActivo(selectedPersonal.getvCodpersonal()))
			{
				Funciones.mostrarMensajeError("Existe información de seguro activa, primero debe establecer una fecha de fin.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(personalDespatch.getTieneSeguroSCTRCruzeIni(selectedPersonal.getvCodpersonal(), dFeciniEntSeguroSCTR) || 
					personalDespatch.getTieneSeguroSCTRCruzeFin(selectedPersonal.getvCodpersonal(), dFeciniEntSeguroSCTR))
			{
				Funciones.mostrarMensajeError("La fecha de inicio ingresada se cruza con un registro ya existente.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {			
			nuevoDetSeguroSCTR.setnCorperseg(new BigDecimal(getSiguienteCorrelativoSeguro()));
			nuevoDetSeguroSCTR.setvCodpersonal(selectedPersonal.getvCodpersonal());
			nuevoDetSeguroSCTR.setdFecini(dFeciniEntSeguroSCTR);
			nuevoDetSeguroSCTR.setvFlgact("S");
			nuevoDetSeguroSCTR.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoDetSeguroSCTR.setdFecreg(new Date());
			nuevoDetSeguroSCTR.setvHostreg(FacesUtils.getIpAddress());
			
			personalDespatch.insertarDetalleSeguro(nuevoDetSeguroSCTR);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaSeguroSCTR();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSeguroSCTR.hide()");
		Funciones.mostrarMensajeInfo("Se registró el seguro SCTR.");
	}
	
	public void agregarDetalleEntFinanciera()
	{
		if(nuevoDetEntFinanciera.getnCodentfin()!=null && !(new BigDecimal("0")).equals(nuevoDetEntFinanciera.getnCodentfin())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione una entidad financiera.");			
			return;
		}
		if(nuevoDetEntFinanciera.getvNumcuenta()!=null && !"".equals(nuevoDetEntFinanciera.getvNumcuenta().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese un número de cuenta.");			
			return;
		}
		if(nuevoDetEntFinanciera.getvCodcci()!=null && !"".equals(nuevoDetEntFinanciera.getvCodcci().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese un número de CCI.");			
			return;
		}
		if(dFeciniEntFinanciera!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniEntFinanciera))
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
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			if(personalDespatch.getTieneEntidadActiva(selectedPersonal.getvCodpersonal()))
			{
				Funciones.mostrarMensajeError("Existe información financiera activa, primero debe establecer una fecha de fin.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(personalDespatch.getTieneEntidadCruzeIni(selectedPersonal.getvCodpersonal(), dFeciniEntFinanciera) || 
					personalDespatch.getTieneEntidadCruzeFin(selectedPersonal.getvCodpersonal(), dFeciniEntFinanciera))
			{
				Funciones.mostrarMensajeError("La fecha de inicio ingresada se cruza con un registro ya existente.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {			
			nuevoDetEntFinanciera.setnCorperentfin(new BigDecimal(getSiguienteCorrelativoInformacionFinanciera()));
			nuevoDetEntFinanciera.setvCodpersonal(selectedPersonal.getvCodpersonal());
			nuevoDetEntFinanciera.setdFecini(dFeciniEntFinanciera);
			nuevoDetEntFinanciera.setvFlgact("S");
			nuevoDetEntFinanciera.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoDetEntFinanciera.setdFecreg(new Date());
			nuevoDetEntFinanciera.setvHostreg(FacesUtils.getIpAddress());
			
			personalDespatch.insertarDetalleInformacionFinanciera(nuevoDetEntFinanciera);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaEntfinanciera();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleEntFinanciera.hide()");
		Funciones.mostrarMensajeInfo("Se registró la entidad financiera.");
	}
	
	public void agregarDetalleProfesion()
	{
		if(txtProfesion!=null && !"".equals(txtProfesion.trim())){}
		else
		{
			profesionSeleccionada=new SitbProfesion();
			nuevoDetProfesion.setvCodprof(null);
			Funciones.mostrarMensajeError("Seleccione una profesión.");			
			return;
		}
		if(nuevoDetProfesion.getvCodprof()!=null && !("").equals(nuevoDetProfesion.getvCodprof().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione una profesión.");			
			return;
		}
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			if(personalDespatch.getTieneProfesionRepetidaUpdate(nuevoDetProfesion.getvCodprof(), selectedPersonal.getvCodpersonal()))
			{
				Funciones.mostrarMensajeError("La profesión ya esta asignada al personal.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {			
			nuevoDetProfesion.setnCorperpro(new BigDecimal(getSiguienteCorrelativoProfesion()));
			nuevoDetProfesion.setvCodpersonal(selectedPersonal.getvCodpersonal());
			nuevoDetProfesion.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoDetProfesion.setdFecreg(new Date());
			nuevoDetProfesion.setvHostreg(FacesUtils.getIpAddress());
			
			personalDespatch.insertarDetalleProfesion(nuevoDetProfesion);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaProfesion();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleProfesion.hide()");
		Funciones.mostrarMensajeInfo("Se registró la profesión.");
	}
	
	public void agregarDetalleSindicato()
	{
		if(nuevoDetSindicato.getnCodsindic()!=null && !(new BigDecimal("0")).equals(nuevoDetSindicato.getnCodsindic())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un sindicato.");			
			return;
		}
		if(nuevoDetSindicato.getnCodcarsin()!=null && !(new BigDecimal("0")).equals(nuevoDetSindicato.getnCodcarsin())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un cargo sindical.");			
			return;
		}
		if(dFeciniSindicato!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniSindicato))
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
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			if(personalDespatch.getTieneSindicatoActivo(selectedPersonal.getvCodpersonal()))
			{
				Funciones.mostrarMensajeError("Existe información de sindicato activa, primero debe establecer una fecha de fin.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(personalDespatch.getTieneSindicatoCruzeIni(selectedPersonal.getvCodpersonal(), dFeciniSindicato) || 
					personalDespatch.getTieneSindicatoCruzeFin(selectedPersonal.getvCodpersonal(), dFeciniSindicato))
			{
				Funciones.mostrarMensajeError("La fecha de inicio ingresada se cruza con un registro ya existente.");			
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {			
			nuevoDetSindicato.setnCorpersin(new BigDecimal(getSiguienteCorrelativoSindicato()));
			nuevoDetSindicato.setvCodpersonal(selectedPersonal.getvCodpersonal());
			nuevoDetSindicato.setdFecini(dFeciniSindicato);
			nuevoDetSindicato.setvFlgact("S");
			nuevoDetSindicato.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoDetSindicato.setdFecreg(new Date());
			nuevoDetSindicato.setvHostreg(FacesUtils.getIpAddress());
			
			personalDespatch.insertarDetalleSindicato(nuevoDetSindicato);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaSindicato();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSindicato.hide()");
		Funciones.mostrarMensajeInfo("Se registró el sindicato.");
	}
	
	public void agregarDetalle()
	{
		if(dependenciaSeleccionada3!=null){}
		else
		{
			Funciones.mostrarMensajeError("Debe seleccionar una Dependencia.");
			return;
		}		
		if(nuevoDetPersonal.getvCodtipo()!=null && !"".equals(nuevoDetPersonal.getvCodtipo().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de personal.");			
			return;
		}
		if(nuevoDetPersonal.getvCodcargo()!=null && !"".equals(nuevoDetPersonal.getvCodcargo().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un cargo de personal.");			
			return;
		}
		/*if(nuevoDetPersonal.getvCodescala()!=null && !"".equals(nuevoDetPersonal.getvCodescala().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione una escala remunerativa.");			
			return;
		}*/
		if(dFecini!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFecini))
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
		for (Iterator iterator = listaDetPersonal.iterator(); iterator
				.hasNext();) {
			VstDetpersonalrrhh det = (VstDetpersonalrrhh) iterator
					.next();
			String fechaIniList=new String(FuncionesFechas.getFormatDate(det.getdFecini()));
			String fechaIniIns=new String(FuncionesFechas.getFormatDate(dFecini));			
			if(det.getnNumdep().equals(dependenciaSeleccionada3.getnNumdep()))
			{
				if(fechaIniList.equalsIgnoreCase(fechaIniIns))
				{
					Funciones.mostrarMensajeError("Dependencia ya existe en la misma fecha de inicio.");					
					return;
				}
			}
			if(!fechaIniList.equalsIgnoreCase(fechaIniIns))
			{
				if(det.getnNumdep().equals(dependenciaSeleccionada3.getnNumdep()) && "S".equals(det.getvFlgact()))
				{
					Funciones.mostrarMensajeError("La Dependencia ya existe activa en la lista de detalles.");					
					return;
				}
			}
			if(det.getnNumdep().equals(dependenciaSeleccionada3.getnNumdep()))
			{
				if(det.getdFecfin()!=null)
				{
					if(dFecini.after(det.getdFecini()) && dFecini.before(det.getdFecfin()))
					{
						Funciones.mostrarMensajeError("La Fecha de inicio ingresada hace conflicto con un detalle ya existente.");						
						return;
					}
				}
			}
			
		}
		
		if("4".equals(nuevoDetPersonal.getvCodtipo()))
		{
			if("S".equals(nuevoDetPersonal.getvFlgdes()))
			{
				if(nuevoDetPersonal.getnCodres()!=null && !(new BigDecimal("0").equals(nuevoDetPersonal.getnCodres()))){}
				else
				{
					Funciones.mostrarMensajeError("Si el detalle es un destaque debe seleccionar una resolución.");				
					return;
				}
			}
			else
			{
				nuevoDetPersonal.setvFlgdes("N");
				nuevoDetPersonal.setnCodres(null);
			}
			if(nuevoDetPersonal.getnCorclacar()!=null && !(new BigDecimal("0").equals(nuevoDetPersonal.getnCorclacar()))){}	
			else
			{
				Funciones.mostrarMensajeError("Debe seleccionar una clasificación de cargo.");				
				return;
			}
		}
		else
		{
			nuevoDetPersonal.setvFlgdes("N");
			nuevoDetPersonal.setnCodres(null);
			nuevoDetPersonal.setnCorclacar(null);
		}
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {		
			//reset los otros detalles a no principal
			//personalDespatch.disableDetallePersonal(selectedPersonal.getvCodpersonal());
			//end reset los otros detalles a no principal
			nuevoDetPersonal.setvCodpersonal(selectedPersonal.getvCodpersonal());
			nuevoDetPersonal.setnCorper(new BigDecimal(getSiguienteCorrelativoGlobalDetalle(selectedPersonal.getvCodpersonal())));
			nuevoDetPersonal.setnNumdep(dependenciaSeleccionada3.getnNumdep());
			if(personalDespatch.getTieneDetalleActivo(selectedPersonal.getvCodpersonal()))
			{
				nuevoDetPersonal.setvFlgprin("N");
			}			
			else
			{
				nuevoDetPersonal.setvFlgprin("S");
				//actualizar dependencia en cabecera de personal
				selectedPersonal.setnNumdep(nuevoDetPersonal.getnNumdep());
				selectedPersonal.setdFecmod(new Date());
				personalDespatch.actualizarPersonal(selectedPersonal);
			}
			nuevoDetPersonal.setvFlgact("S");			
			nuevoDetPersonal.setvCodusureg(PGP_Usuario.getV_codusu());
			nuevoDetPersonal.setdFecini(dFecini);
			nuevoDetPersonal.setdFecreg(new Date());
			nuevoDetPersonal.setvCodescala("0");
			personalDespatch.insertarDetallePersonal(nuevoDetPersonal);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaDetallePersonal();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalle.hide()");
	}
	
	public void dialogReferenciaEliminar(VstDetpersonalrrhh item){		
		eliminarDetPersonal=new RhtbdPersonal();
		eliminarDetPersonal.setvCodpersonal(item.getvCodpersonal());
		eliminarDetPersonal.setnCorper(item.getnCorper());//agregar ncorper a la vista VstDetpersonalrrhh y regenerar
		eliminarDetPersonalV=item;
		RequestContext.getCurrentInstance().execute("dialogWidget3.show()");
	}
	
	public void dialogReferenciaEliminarSindicato(VstSindicato item){		
		eliminarDetSindicato=new VstSindicato();
		eliminarDetSindicato=item;
		RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleSindicato.show()");
	}
	
	public void dialogReferenciaEliminarProfesion(VstProfesion item){		
		eliminarDetProfesion=new VstProfesion();
		eliminarDetProfesion=item;
		RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleProfesion.show()");
	}
	
	public void dialogReferenciaEliminarEntFinanciera(VstEntfinanciera item){		
		eliminarDetEntFinanciera=new VstEntfinanciera();
		eliminarDetEntFinanciera=item;
		RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleEntFinanciera.show()");
	}
	
	public void dialogReferenciaEliminarSeguro(VstSeguro item){		
		eliminarDetSeguro=new VstSeguro();
		eliminarDetSeguro=item;		
		RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleSeguro.show()");
	}
	
	public void dialogReferenciaEliminarSeguroSCTR(VstSeguro item){		
		eliminarDetSeguroSCTR=new VstSeguro();
		eliminarDetSeguroSCTR=item;		
		RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleSeguroSCTR.show()");
	}
	
	public void dialogReferenciaEliminarRegPensionario(VstRegpensionario item){		
		eliminarRegPensionario=new VstRegpensionario();
		eliminarRegPensionario=item;		
		RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleRegPensionario.show()");
	}
	
	public void dialogReferenciaEliminarDireccion(VstDirecciones item){		
		eliminarDetDireccion=new VstDirecciones();
		eliminarDetDireccion=item;		
		RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleDireccion.show()");
	}
	
	public void dialogReferenciaEliminarDependiente(VstDependientes item){		
		eliminarDependiente=new VstDependientes();
		eliminarDependiente=item;		
		RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleDependiente.show()");
	}
	
	public void eliminarDependiente()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {		
			//eliminar dependiente
			RhtbdDependientes entidad=new RhtbdDependientes();
			entidad.setvNumdoc(eliminarDependiente.getvNumdoc());
			entidad.setvCodtdocide(eliminarDependiente.getvCodtdocide());
			entidad.setvCodpersonal(eliminarDependiente.getvCodpersonal());
			personalDespatch.eliminarDependiente(entidad);
			//post load
			cargarListaDependientes();		
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleDependiente.hide()");
			Funciones.mostrarMensajeInfo("Dependiente fue eliminado.");
		} catch (Exception e) {
			cargarListaDependientes();						
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleDependiente.hide()");
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");
		}
	}
	
	public void eliminarDireccion()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {		
			//eliminar detalle seguro
			RhtbdPerdireccion entidad=new RhtbdPerdireccion();
			entidad.setnCorperdir(eliminarDetDireccion.getnCorperdir());
			personalDespatch.eliminarDetalleDireccion(entidad);
			//post load
			cargarListaDirecciones();				
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleDireccion.hide()");
			Funciones.mostrarMensajeInfo("Detalle de dirección fue eliminado.");
		} catch (Exception e) {
			cargarListaDirecciones();						
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleDireccion.hide()");
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");
		}
	}
	
	public void eliminarRegPensionario()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {		
			//eliminar detalle seguro
			RhtbdPerxregpensionario entidad=new RhtbdPerxregpensionario();
			entidad.setnCorperregpen(eliminarRegPensionario.getnCorperregpen());
			personalDespatch.eliminarDetalleRegimenPensionario(entidad);
			//post load
			cargarListaRegPensionario();				
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleRegPensionario.hide()");
			Funciones.mostrarMensajeInfo("Detalle de régimen pensionario fue eliminado.");
		} catch (Exception e) {
			cargarListaRegPensionario();						
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleRegPensionario.hide()");
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");
		}
	}
	
	public void eliminarSeguro()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {		
			//eliminar detalle seguro
			RhtbdPerxseguro entidad=new RhtbdPerxseguro();
			entidad.setnCorperseg(eliminarDetSeguro.getnCorperseg());
			personalDespatch.eliminarDetalleSeguro(entidad);
			//post load
			cargarListaSeguro();				
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleSeguro.hide()");
			Funciones.mostrarMensajeInfo("Detalle de seguro fue eliminado.");
		} catch (Exception e) {
			cargarListaSeguro();						
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleSeguro.hide()");
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");
		}
	}
	
	public void eliminarSeguroSCTR()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {		
			//eliminar detalle seguro
			RhtbdPerxseguro entidad=new RhtbdPerxseguro();
			entidad.setnCorperseg(eliminarDetSeguroSCTR.getnCorperseg());
			personalDespatch.eliminarDetalleSeguro(entidad);
			//post load
			cargarListaSeguroSCTR();				
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleSeguroSCTR.hide()");
			Funciones.mostrarMensajeInfo("Detalle de seguro SCTR fue eliminado.");
		} catch (Exception e) {
			cargarListaSeguro();						
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleSeguroSCTR.hide()");
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");
		}
	}
	
	public void eliminarEntFinanciera()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {		
			//eliminar detalle ent financiera
			RhtbdPerxentfinanciera entidad=new RhtbdPerxentfinanciera();
			entidad.setnCorperentfin(eliminarDetEntFinanciera.getnCorperentfin());
			personalDespatch.eliminarDetalleInformacionFinanciera(entidad);
			//post load
			cargarListaEntfinanciera();				
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleEntFinanciera.hide()");
			Funciones.mostrarMensajeInfo("Detalle de entidad financiera fue eliminado.");
		} catch (Exception e) {
			cargarListaEntfinanciera();						
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleEntFinanciera.hide()");
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");
		}
	}
	
	public void eliminarProfesion()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {		
			//eliminar detalle profesion
			RhtbdPerxprofesion entidad=new RhtbdPerxprofesion();
			entidad.setnCorperpro(eliminarDetProfesion.getnCorperpro());
			personalDespatch.eliminarDetalleProfesion(entidad);
			//post load
			cargarListaProfesion();				
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleProfesion.hide()");
			Funciones.mostrarMensajeInfo("Detalle de profesión fue eliminado.");
		} catch (Exception e) {
			cargarListaProfesion();						
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleProfesion.hide()");
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");
		}
	}
	
	public void eliminarSindicato()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {		
			//eliminar detalle sindicato
			RhtbdPerxsindicato entidad=new RhtbdPerxsindicato();
			entidad.setnCorpersin(eliminarDetSindicato.getnCorpersin());
			personalDespatch.eliminarDetalleSindicato(entidad);
			//post load
			cargarListaSindicato();			
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleSindicato.hide()");
			Funciones.mostrarMensajeInfo("Detalle de sindicato fue eliminado.");
		} catch (Exception e) {
			cargarListaSindicato();			
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalleSindicato.hide()");
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");
		}
	}
	
	public void eliminar()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {					
			
			try {
				if(personalDespatch.tieneMarcacionMayorAFecha(eliminarDetPersonal.getvCodpersonal(), eliminarDetPersonalV.getdFecini()))
				{
					cargarListaDetallePersonal();
					Funciones.mostrarMensajeError("No se pudo eliminar el detalle debido a que existen marcaciones registradas.");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
			//eliminar detalle	
			personalDespatch.eliminarDetallePersonal(eliminarDetPersonal);
			//post load
			cargarListaDetallePersonal();
			Funciones.mostrarMensajeInfo("Detalle fue eliminado.");			
		} catch (Exception e) {
			cargarListaDetallePersonal();
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");			
		}
	}
	
	public void itemChangeIntendencia4()
	{
		if(selectedIntendencia4 == null || "".equals(selectedIntendencia4.trim()))
		{
			txt4 = "";
			dependenciaSeleccionada4 = null;
		}
	}
	
	public List<String> completeText4(String query) {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		dependenciasAutocomplete4 = new ArrayList<TdtbcDependencia>();
		try {
			dependenciasAutocomplete4 = personalDespatch
					.getAutocompletarDependenciaEIntendencia(query,
							selectedIntendencia4);
							//PGP_Usuario.getN_numint());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> results = new ArrayList<String>();

		for (Iterator iterator = dependenciasAutocomplete4.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			results.add(tdtbcDependencia.getvDesdep());
		}
		return results;
	}
	
	public void onItemSelect4(SelectEvent event) {
		for (Iterator iterator = dependenciasAutocomplete4.iterator(); iterator
				.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator
					.next();
			if (event.getObject().toString()
					.equals(tdtbcDependencia.getvDesdep())) {
				dependenciaSeleccionada4 = tdtbcDependencia;
				editarDetPersonal.setnNumdep(dependenciaSeleccionada4.getnNumdep());
			}
		}
	}
	
	public void dialogDetalleE(VstDetpersonalrrhh item){		
		//cargar editar detalle
		editarDetPersonal=new RhtbdPersonal();
		editarDetPersonal.setnCorper(item.getnCorper());
		editarDetPersonal.setvCodtipo(item.getvCodtipo());
		editarDetPersonal.setvCodcargo(item.getvCodcargo());
		editarDetPersonal.setvCodescala(item.getvCodescala());
		editarDetPersonal.setdFecini(item.getdFecini());
		editarDetPersonal.setdFecfin(item.getdFecfin());
		dFeciniE=item.getdFecini();
		dFecfinE=item.getdFecfin();
		editarDetPersonal.setvFlgact(item.getvFlgact());
		editarDetPersonal.setvFlgprin(item.getvFlgprin());
		editarDetPersonal.setvAnocon(item.getvAnocon());
		editarDetPersonal.setvNumcon(item.getvNumcon());
		if("4".equals(editarDetPersonal.getvCodtipo()))
		{
			if(item.getvFlgdes()!=null)
			{
				editarDetPersonal.setvFlgdes(item.getvFlgdes());
				if(item.getnCodres()!=null && !(new BigDecimal("0").equals(item.getnCodres())))
				{
					editarDetPersonal.setnCodres(item.getnCodres());
				}
				if("N".equals(item.getvFlgdes()))
				{
					editarDetPersonal.setnCodres(null);
				}
			}
			else
			{
				editarDetPersonal.setvFlgdes("N");
			}						
			if(item.getnCorclacar()!=null && !(new BigDecimal("0").equals(item.getnCorclacar())))
			{
				editarDetPersonal.setnCorclacar(item.getnCorclacar());
			}	
			else
			{
				editarDetPersonal.setnCorclacar(null);
			}
		}
		else
		{
			editarDetPersonal.setvFlgdes("N");
			editarDetPersonal.setnCodres(null);
			editarDetPersonal.setnCorclacar(null);
		}		
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			dependenciaSeleccionada4=personalDespatch.getDependenciaPorCodigo(item.getnNumdep());
			txt4=dependenciaSeleccionada4.getvDesdep();
			selectedIntendencia4=""+dependenciaSeleccionada4.getnNumint();
			//
			if(item.getnNumint()!=null && !(new BigDecimal("0").equals(item.getnNumint()))){}
			else
			{
				selectedIntendencia4="-1";
			}
			//
		} catch (Exception e) {
			e.printStackTrace();
		}				
		//end cargar editar detalle
		soloVer=false;
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleE.show()");
	}
	
	public void dialogDetalleV(VstDetpersonalrrhh item){
		//cargar editar detalle
		editarDetPersonal=new RhtbdPersonal();
		editarDetPersonal.setnCorper(item.getnCorper());
		editarDetPersonal.setvCodtipo(item.getvCodtipo());
		editarDetPersonal.setvCodcargo(item.getvCodcargo());
		editarDetPersonal.setvCodescala(item.getvCodescala());
		editarDetPersonal.setdFecini(item.getdFecini());
		editarDetPersonal.setdFecfin(item.getdFecfin());
		dFeciniE=item.getdFecini();
		dFecfinE=item.getdFecfin();
		editarDetPersonal.setvFlgact(item.getvFlgact());
		editarDetPersonal.setvFlgprin(item.getvFlgprin());
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			dependenciaSeleccionada4=personalDespatch.getDependenciaPorCodigo(item.getnNumdep());
			txt4=dependenciaSeleccionada4.getvDesdep();
			selectedIntendencia4=""+dependenciaSeleccionada4.getnNumint();
		} catch (Exception e) {
			e.printStackTrace();
		}				
		//end cargar editar detalle
		soloVer=true;
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleE.show()");
	}
	
	public void dialogDetalleSindicatoE(VstSindicato item){
		editarDetSindicato=new RhtbdPerxsindicato();
		editarDetSindicato.setnCorpersin(item.getnCorpersin());
		editarDetSindicato.setvCodpersonal(item.getvCodpersonal());
		editarDetSindicato.setnCodsindic(item.getnCodsindic());
		editarDetSindicato.setdFecini(item.getdFecini());
		editarDetSindicato.setdFecfin(item.getdFecfin());
		dFeciniSindicatoE=item.getdFecini();
		dFecfinSindicatoE=item.getdFecfin();
		editarDetSindicato.setnCodcarsin(item.getnCodcarsin());	
		editarDetSindicato.setvFlgact(item.getvFlgact());		
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSindicatoE.show()");
	}
	
	public void dialogDetalleProfesionE(VstProfesion item){
		editarDetProfesion=new RhtbdPerxprofesion();
		editarDetProfesion.setnCorperpro(item.getnCorperpro());
		editarDetProfesion.setvCodpersonal(item.getvCodpersonal());
		editarDetProfesion.setvCodprof(item.getvCodprof());
		txtProfesionE=item.getvDesprof();
		profesionSeleccionadaE=new SitbProfesion();
		profesionSeleccionadaE.setvCodprof(item.getvCodprof());
		profesionSeleccionadaE.setvDesprof(item.getvDesprof());
		profesionSeleccionadaE.setnFlgsunmin(item.getnFlgsunmin());
		profesionSeleccionadaE.setvCodggprof(item.getvCodggprof());
		profesionSeleccionadaE.setvFlginei(item.getvFlginei());
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleProfesionE.show()");
	}
	
	public void dialogDetalleEntFinancieraE(VstEntfinanciera item){
		editarDetEntFinanciera=new RhtbdPerxentfinanciera();
		editarDetEntFinanciera.setnCorperentfin(item.getnCorperentfin());
		editarDetEntFinanciera.setvCodpersonal(item.getvCodpersonal());
		editarDetEntFinanciera.setnCodentfin(item.getnCodentfin());
		editarDetEntFinanciera.setvNumcuenta(item.getvNumcuenta());
		editarDetEntFinanciera.setvCodcci(item.getvCodcci());
		editarDetEntFinanciera.setdFecini(item.getdFecini());
		editarDetEntFinanciera.setdFecfin(item.getdFecfin());
		dFeciniEntFinancieraE=item.getdFecini();
		dFecfinEntFinancieraE=item.getdFecfin();		
		editarDetEntFinanciera.setvFlgact(item.getvFlgact());		
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleEntFinancieraE.show()");
	}
	
	public void dialogDetalleSeguroE(VstSeguro item){
		editarDetSeguro=new RhtbdPerxseguro();
		editarDetSeguro.setnCorperseg(item.getnCorperseg());
		editarDetSeguro.setvCodpersonal(item.getvCodpersonal());
		editarDetSeguro.setnCodseguro(item.getnCodseguro());
		editarDetSeguro.setdFecini(item.getdFecini());
		editarDetSeguro.setdFecfin(item.getdFecfin());
		dFeciniEntSeguroE=item.getdFecini();
		dFecfinEntSeguroE=item.getdFecfin();		
		editarDetSeguro.setvFlgact(item.getvFlgact());		
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSeguroE.show()");
	}
	
	public void dialogDetalleSeguroSCTRE(VstSeguro item){
		editarDetSeguroSCTR=new RhtbdPerxseguro();
		editarDetSeguroSCTR.setnCorperseg(item.getnCorperseg());
		editarDetSeguroSCTR.setvCodpersonal(item.getvCodpersonal());
		editarDetSeguroSCTR.setnCodseguro(item.getnCodseguro());
		editarDetSeguroSCTR.setdFecini(item.getdFecini());
		editarDetSeguroSCTR.setdFecfin(item.getdFecfin());
		dFeciniEntSeguroSCTRE=item.getdFecini();
		dFecfinEntSeguroSCTRE=item.getdFecfin();		
		editarDetSeguroSCTR.setvFlgact(item.getvFlgact());		
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSeguroSCTRE.show()");
	}
	
	public void dialogDetalleRegPensionarioE(VstRegpensionario item){
		editarDetRegPensionario=new RhtbdPerxregpensionario();
		editarDetRegPensionario.setnCorperregpen(item.getnCorperregpen());
		editarDetRegPensionario.setvCodpersonal(item.getvCodpersonal());
		editarDetRegPensionario.setnCodregpen(item.getnCodregpen());
		editarDetRegPensionario.setdFecini(item.getdFecini());
		editarDetRegPensionario.setdFecfin(item.getdFecfin());
		dFeciniRegPensionarioE=item.getdFecini();
		dFecfinRegPensionarioE=item.getdFecfin();		
		editarDetRegPensionario.setvFlgact(item.getvFlgact());		
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleRegPensionarioE.show()");
	}
	
	public void dialogDetalleDireccionE(VstDirecciones item){
		editarDetDireccion=new RhtbdPerdireccion();
		editarDetDireccion.setnCorperdir(item.getnCorperdir());
		editarDetDireccion.setvCodpersonal(item.getvCodpersonal());
		editarDetDireccion.setvCoddep(item.getvCoddep());
		v_coddepE=item.getvCoddep();
		try {
			listaProvinciasE = dspcombos.listaProvinciasxDep(item.getvCoddep());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		editarDetDireccion.setvCodpro(item.getvCodpro());
		v_codproE=item.getvCodpro();
		try {
			listaDistritosE = dspcombos.listaDistritosxPro(item.getvCoddep(),item.getvCodpro());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		editarDetDireccion.setvCoddis(item.getvCoddis());
		v_coddisE=item.getvCoddis();
		editarDetDireccion.setvCodzon(item.getvCodzon());
		editarDetDireccion.setvDeszona(item.getvDeszona());
		editarDetDireccion.setvCodtvia(item.getvCodtvia());
		editarDetDireccion.setvDireccion(item.getvDireccion());
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleDireccionE.show()");
	}
	
	public void dialogDetalleDependienteE(VstDependientes item){
		editarDependiente=new RhtbdDependientes();
		editarDependiente.setvNumdoc(item.getvNumdoc());
		editarDependiente.setvCodtdocide(item.getvCodtdocide());
		editarDependiente.setvCodpersonal(item.getvCodpersonal());
		editarDependiente.setvApepatmat(item.getvApepatmat());
		editarDependiente.setvApematmat(item.getvApematmat());
		editarDependiente.setvNombres(item.getvNombres());
		editarDependiente.setdFecnac(item.getdFecnac());
		dFecNacDependienteE=item.getdFecnac();
		editarDependiente.setvGenero(item.getvGenero());
		editarDependiente.setnCodvinfam(item.getnCodvinfam());			
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleDependienteE.show()");
	}
	
	public void actualizarDependiente()
	{
		if(editarDependiente.getnCodvinfam()!=null && !(new BigDecimal("0")).equals(editarDependiente.getnCodvinfam())){}
		else
		{
			mensajeValida="Seleccione un vínculo.";
			return;
		}
		if(editarDependiente.getvCodtdocide()!=null && !"".equals(editarDependiente.getvCodtdocide().trim())){}
		else
		{
			mensajeValida="Seleccione un tipo de documento.";
			return;
		}
		if(editarDependiente.getvNumdoc()!=null && !"".equals(editarDependiente.getvNumdoc().trim())){}
		else
		{
			mensajeValida="Ingrese un número de documento.";
			return;
		}
		if(editarDependiente.getvApepatmat()!=null && !"".equals(editarDependiente.getvApepatmat().trim())){}
		else
		{
			mensajeValida="Ingrese apellido paterno.";
			return;
		}
		if(editarDependiente.getvApematmat()!=null && !"".equals(editarDependiente.getvApematmat().trim())){}
		else
		{
			mensajeValida="Ingrese apellido materno.";
			return;
		}
		if(editarDependiente.getvNombres()!=null && !"".equals(editarDependiente.getvNombres().trim())){}
		else
		{
			mensajeValida="Ingrese nombres.";
			return;
		}
		if(editarDependiente.getvGenero()!=null && !"".equals(editarDependiente.getvGenero().trim())){}
		else
		{
			mensajeValida="Seleccione género.";
			return;
		}
		if(dFecNacDependienteE!=null){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese fecha de nacimiento.");			
			return;
		}
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {			
			editarDependiente.setvApepatmat(editarDependiente.getvApepatmat().toUpperCase());
			editarDependiente.setvApematmat(editarDependiente.getvApematmat().toUpperCase());
			editarDependiente.setvNombres(editarDependiente.getvNombres().toUpperCase());
			editarDependiente.setdFecnac(dFecNacDependienteE);
			editarDependiente.setvCodusumod(PGP_Usuario.getV_codusu());
			editarDependiente.setdFecmod(new Date());
			personalDespatch.actualizaDependiente(editarDependiente);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaDependientes();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleDependienteE.hide()");
		Funciones.mostrarMensajeInfo("Dependiente actualizado.");
	}
	
	public void actualizarDetalleDireccion()
	{
		if(v_coddepE!=null && !"".equals(v_coddepE.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione región.");
			return;
		}
		if(v_codproE!=null && !"".equals(v_codproE.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione provincia.");
			return;
		}
		if(v_coddisE!=null && !"".equals(v_coddisE.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione distrito.");
			return;
		}
		if(editarDetDireccion.getvCodzon()!=null && !"".equals(editarDetDireccion.getvCodzon().trim())){}
		else
		{
			mensajeValida="Seleccione un tipo de zona.";
			return;
		}
		if(editarDetDireccion.getvCodtvia()!=null && !"".equals(editarDetDireccion.getvCodtvia().trim())){}
		else
		{
			mensajeValida="Seleccione un tipo de vía.";
			return;
		}
		if(editarDetDireccion.getvDeszona()!=null && !"".equals(editarDetDireccion.getvDeszona().trim())){}
		else
		{
			mensajeValida="Ingrese zona.";
			return;
		}
		if(editarDetDireccion.getvDireccion()!=null && !"".equals(editarDetDireccion.getvDireccion().trim())){}
		else
		{
			mensajeValida="Ingrese dirección.";
			return;
		}
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {			
			editarDetDireccion.setvCoddep(v_coddepE);
			editarDetDireccion.setvCodpro(v_codproE);
			editarDetDireccion.setvCoddis(v_coddisE);
			editarDetDireccion.setvCodusumod(PGP_Usuario.getV_codusu());
			editarDetDireccion.setdFecmod(new Date());
			personalDespatch.actualizaDetalleDireccion(editarDetDireccion);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaDirecciones();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleDireccionE.hide()");
		Funciones.mostrarMensajeInfo("Detalle de dirección actualizado.");
	}
	
	public void actualizarDetalleRegPensionario()
	{
		if(editarDetRegPensionario.getnCodregpen()!=null && !(new BigDecimal("0")).equals(editarDetRegPensionario.getnCodregpen())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de régimen.");			
			return;
		}
		if(dFeciniRegPensionarioE!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniRegPensionarioE))
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
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {			
			editarDetRegPensionario.setvCodusumod(PGP_Usuario.getV_codusu());
			editarDetRegPensionario.setdFecmod(new Date());
			if(dFeciniRegPensionarioE!=null)
			{
				editarDetRegPensionario.setdFecini(dFeciniRegPensionarioE);
			}
			if(dFecfinRegPensionarioE!=null)
			{
				editarDetRegPensionario.setdFecfin(dFecfinRegPensionarioE);
			}
			else
			{
				editarDetRegPensionario.setdFecfin(null);
			}
			personalDespatch.actualizaDetalleRegimenPensionario(editarDetRegPensionario);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaRegPensionario();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleRegPensionarioE.hide()");
		Funciones.mostrarMensajeInfo("Detalle de régimen pensionario actualizado.");
	}
	
	public void actualizarDetalleSeguro()
	{
		if(editarDetSeguro.getnCodseguro()!=null && !(new BigDecimal("0")).equals(editarDetSeguro.getnCodseguro())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de seguro.");			
			return;
		}
		if(dFeciniEntSeguroE!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniEntSeguroE))
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
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {			
			editarDetSeguro.setvCodusumod(PGP_Usuario.getV_codusu());
			editarDetSeguro.setdFecmod(new Date());
			if(dFeciniEntSeguroE!=null)
			{
				editarDetSeguro.setdFecini(dFeciniEntSeguroE);
			}
			if(dFecfinEntSeguroE!=null)
			{
				editarDetSeguro.setdFecfin(dFecfinEntSeguroE);
			}
			else
			{
				editarDetSeguro.setdFecfin(null);
			}
			personalDespatch.actualizaDetalleSeguro(editarDetSeguro);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaSeguro();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSeguroE.hide()");
		Funciones.mostrarMensajeInfo("Detalle de seguro actualizado.");
	}
	
	public void actualizarDetalleSeguroSCTR()
	{
		if(editarDetSeguroSCTR.getnCodseguro()!=null && !(new BigDecimal("0")).equals(editarDetSeguroSCTR.getnCodseguro())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de seguro.");			
			return;
		}
		if(dFeciniEntSeguroSCTRE!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniEntSeguroSCTRE))
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
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {			
			editarDetSeguroSCTR.setvCodusumod(PGP_Usuario.getV_codusu());
			editarDetSeguroSCTR.setdFecmod(new Date());
			if(dFeciniEntSeguroSCTRE!=null)
			{
				editarDetSeguroSCTR.setdFecini(dFeciniEntSeguroSCTRE);
			}
			if(dFecfinEntSeguroE!=null)
			{
				editarDetSeguroSCTR.setdFecfin(dFecfinEntSeguroSCTRE);
			}
			else
			{
				editarDetSeguroSCTR.setdFecfin(null);
			}
			personalDespatch.actualizaDetalleSeguro(editarDetSeguroSCTR);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaSeguroSCTR();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSeguroSCTRE.hide()");
		Funciones.mostrarMensajeInfo("Detalle de seguro SCTR actualizado.");
	}
	
	public void actualizarDetalleEntFinanciera()
	{
		if(editarDetEntFinanciera.getnCodentfin()!=null && !(new BigDecimal("0")).equals(editarDetEntFinanciera.getnCodentfin())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione una entidad financiera.");			
			return;
		}
		if(editarDetEntFinanciera.getvNumcuenta()!=null && !"".equals(editarDetEntFinanciera.getvNumcuenta().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese un número de cuenta.");			
			return;
		}
		if(editarDetEntFinanciera.getvCodcci()!=null && !"".equals(editarDetEntFinanciera.getvCodcci().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Ingrese un número de CCI.");			
			return;
		}
		if(dFeciniEntFinancieraE!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniEntFinancieraE))
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
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {			
			editarDetEntFinanciera.setvCodusumod(PGP_Usuario.getV_codusu());
			editarDetEntFinanciera.setdFecmod(new Date());
			if(dFeciniEntFinancieraE!=null)
			{
				editarDetEntFinanciera.setdFecini(dFeciniEntFinancieraE);
			}
			if(dFecfinEntFinancieraE!=null)
			{
				editarDetEntFinanciera.setdFecfin(dFecfinEntFinancieraE);
			}
			else
			{
				editarDetEntFinanciera.setdFecfin(null);
			}
			personalDespatch.actualizaDetalleInformacionFinanciera(editarDetEntFinanciera);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaEntfinanciera();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleEntFinancieraE.hide()");
		Funciones.mostrarMensajeInfo("Detalle de entidad financiera actualizado.");
	}
	
	public void actualizarDetalleProfesion()
	{
		if(txtProfesionE!=null && !"".equals(txtProfesionE.trim())){}
		else
		{
			profesionSeleccionadaE=new SitbProfesion();
			editarDetProfesion.setvCodprof(null);
			Funciones.mostrarMensajeError("Seleccione una profesión.");			
			return;
		}
		if(editarDetProfesion.getvCodprof()!=null && !("").equals(editarDetProfesion.getvCodprof().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione una profesión.");			
			return;
		}
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {				
			editarDetProfesion.setvCodusumod(PGP_Usuario.getV_codusu());
			editarDetProfesion.setdFecmod(new Date());
			personalDespatch.actualizaDetalleProfesion(editarDetProfesion);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaProfesion();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleProfesionE.hide()");
		Funciones.mostrarMensajeInfo("Detalle de profesión actualizado.");
	}
	
	public void actualizarDetalleSindicato()
	{
		if(editarDetSindicato.getnCodsindic()!=null && !(new BigDecimal("0")).equals(editarDetSindicato.getnCodsindic())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un sindicato.");			
			return;
		}
		if(editarDetSindicato.getnCodcarsin()!=null && !(new BigDecimal("0")).equals(editarDetSindicato.getnCodcarsin())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un cargo sindical.");			
			return;
		}
		if(dFeciniSindicatoE!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniSindicatoE))
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
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {			
			editarDetSindicato.setvCodusumod(PGP_Usuario.getV_codusu());
			editarDetSindicato.setdFecmod(new Date());
			if(dFeciniSindicatoE!=null)
			{
				editarDetSindicato.setdFecini(dFeciniSindicatoE);
			}
			if(dFecfinSindicatoE!=null)
			{
				editarDetSindicato.setdFecfin(dFecfinSindicatoE);
			}
			else
			{
				editarDetSindicato.setdFecfin(null);
			}
			personalDespatch.actualizarDetalleSindicato(editarDetSindicato);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaSindicato();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleSindicatoE.hide()");
		Funciones.mostrarMensajeInfo("Detalle de sindicato actualizado.");		
	}
	
	public void actualizarDetalle(boolean origen)
	{
		if(dependenciaSeleccionada4!=null){}
		else
		{
			Funciones.mostrarMensajeError("Debe seleccionar una Dependencia.");			
			return;
		}		
		if(editarDetPersonal.getvCodtipo()!=null && !"".equals(editarDetPersonal.getvCodtipo().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un tipo de personal.");			
			return;
		}
		if(editarDetPersonal.getvCodcargo()!=null && !"".equals(editarDetPersonal.getvCodcargo().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione un cargo de personal.");			
			return;
		}
		if(editarDetPersonal.getvCodescala()!=null && !"".equals(editarDetPersonal.getvCodescala().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione una escala remunerativa.");			
			return;
		}
		if(dFeciniE!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFeciniE))
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
		if(editarDetPersonal.getvFlgact()!=null && !"".equals(editarDetPersonal.getvFlgact().trim())){}
		else
		{
			Funciones.mostrarMensajeError("Seleccione una estado.");			
			return;
		}		
		if(dFecfinE!=null)
		{
			if(!validaFechaInicioSUNAFIL(dFecfinE))
			{
				Funciones.mostrarMensajeError("La fecha de fin no puede ser anterior a la fecha de creación de SUNAFIL.");				
				return;
			}
			if(dFecfinE.after(dFeciniE)){}
			else
			{
				Funciones.mostrarMensajeError("La fecha de fin ingresada debe ser mayor a la fecha de inicio.");				
				return;
			}
		}
		if("N".equals(editarDetPersonal.getvFlgact()))
		{//si es inactivo validar ingreso de fecha fin
			if(dFecfinE!=null){}
			else
			{				
				Funciones.mostrarMensajeError("Si selecciona estado inactivo debe ingresar una fecha de fin.");				
				return;
			}			
		}
		if("4".equals(editarDetPersonal.getvCodtipo()))
		{
			if("S".equals(editarDetPersonal.getvFlgdes()))
			{
				if(editarDetPersonal.getnCodres()!=null && !(new BigDecimal("0").equals(editarDetPersonal.getnCodres()))){}
				else
				{
					Funciones.mostrarMensajeError("Si el detalle es un destaque debe seleccionar una resolución.");				
					return;
				}
			}
			else
			{
				editarDetPersonal.setnCodres(null);
			}			
			if(editarDetPersonal.getnCorclacar()!=null && !(new BigDecimal("0").equals(editarDetPersonal.getnCorclacar()))){}	
			else
			{
				Funciones.mostrarMensajeError("Debe seleccionar una clasificación de cargo.");				
				return;
			}
		}
		else
		{
			editarDetPersonal.setvFlgdes("N");
			editarDetPersonal.setnCodres(null);
			editarDetPersonal.setnCorclacar(null);
		}
		//manejo de confirm
		if(origen && "N".equals(editarDetPersonal.getvFlgact()))
		{
			System.out.println("Entro a manejo de confirm detalle");
			RequestContext.getCurrentInstance().execute("dialogWidgetBajaDetalle.show()");
			return;			
		}
		//end manejo de confirm
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			editarDetPersonal.setvCodpersonal(selectedPersonal.getvCodpersonal());			
			editarDetPersonal.setnNumdep(dependenciaSeleccionada4.getnNumdep());
			//editarDetPersonal.setvFlgprin("S");//pendiente hacer combo
			//editarDetPersonal.setvFlgact("S");//pendiente hacer combo			
			editarDetPersonal.setvCodusumod(PGP_Usuario.getV_codusu());
			editarDetPersonal.setdFecmod(new Date());
			if(dFeciniE!=null)
			{
				editarDetPersonal.setdFecini(dFeciniE);
			}
			if(dFecfinE!=null)
			{
				editarDetPersonal.setdFecfin(dFecfinE);
			}
			personalDespatch.actualizarDetallePersonal(editarDetPersonal);
			//pendiente actualizar cabecera personal
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaDetallePersonal();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleE.hide()");
		Funciones.mostrarMensajeInfo("Detalle actualizado.");		
		System.out.println("editado");
	}
	
	public void dialogSetPrincipal(VstDetpersonalrrhh item){		
		principalDetPersonal=new RhtbdPersonal();
		principalDetPersonal.setvCodpersonal(item.getvCodpersonal());
		principalDetPersonal.setnCorper(item.getnCorper());//agregar ncorper a la vista VstDetpersonalrrhh y regenerar
		principalDetPersonal.setvFlgprin("S");
		principalDetPersonal.setnNumdep(item.getnNumdep());
		principalDetPersonal.setvCodtipo(item.getvCodtipo());
		principalDetPersonal.setvCodcargo(item.getvCodcargo());
		principalDetPersonal.setvCodescala(item.getvCodescala());
		principalDetPersonalV=item;
		RequestContext.getCurrentInstance().execute("dialogWidget4.show()");
	}
	
	public void principal()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {		
			//reset los otros detalles a no principal
			personalDespatch.disableDetallePersonal(selectedPersonal.getvCodpersonal());
			//end reset los otros detalles a no principal
			//establecer principal	
			personalDespatch.actualizarDetallePersonal(principalDetPersonal);
			//actualizar datos de cabecera
			selectedPersonal.setnNumdep(principalDetPersonal.getnNumdep());
			selectedPersonal.setvCodtipo(principalDetPersonal.getvCodtipo());
			selectedPersonal.setvCodcargo(principalDetPersonal.getvCodcargo());
			selectedPersonal.setvCodescala(principalDetPersonal.getvCodescala());			
			personalDespatch.actualizarPersonal(selectedPersonal);
			//post load
			cargarListaDetallePersonal();
			Funciones.mostrarMensajeInfo("La dependencia seleccionada fue puesta como principal.");			
		} catch (Exception e) {
			cargarListaDetallePersonal();			
			Funciones.mostrarMensajeError("Hubo problemas con la configuración de dependencia principal.");
		}
	}
	
	public String verPersonalReturn() {
		selectedIntendencia="";
		txt1 = "";
		dependenciaSeleccionada = null;
		listaPersonal = null;
		VstPersonalrrhh entTemp=new VstPersonalrrhh();
		entTemp.setvCodtipodocid(selectedPersonal.getvCodtipodocid());
		entTemp.setvCodpersonal(selectedPersonal.getvCodpersonal());
		filtro=entTemp;
		buscarPersonal();
		String vista = "pretty:personalPretty";
		// CODIGO
		return vista;
	}
	
	public void dialogTurnoE(VstTurnopersonalrrhh item)
	{		
		//cargar editar per turno
		editarPerTurnoV=item;
		editarPerTurno=new RhmvcPerturno();
		editarPerTurno.setnCodperturno(item.getnCodperturno());
		editarPerTurno.setnCodturno(item.getnCodturno());
		editarPerTurno.setdFecinicio(item.getdFecinicio());
		editarPerTurno.setdFecfin(item.getdFecfin());		
		editarPerTurno.setvCodpersonal(item.getvCodpersonal());
		editarPerTurno.setvFlgact(item.getvFlgact());
		itemChangeTurnoE();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleE.show()");
	}
	
	public void itemChangeTurnoE()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaTurnoDiaE=personalDespatch.getTurnoDia(editarPerTurno.getnCodturno());
		} catch (Exception e) {
			listaTurnoDiaE=null;
			e.printStackTrace();
		}		
	}
	
	public boolean validarFormularioTurnoPersonalE()
	{				
		if(editarPerTurno.getnCodturno()!=null && editarPerTurno.getnCodturno()!=0){}
		else
		{
			mensajeValidaTPE="Seleccione un turno.";
			return false;
		}
		if(editarPerTurno.getvFlgact()!=null && !"".equals(editarPerTurno.getvFlgact()))
		{
			if("N".equals(editarPerTurno.getvFlgact()))
			{
				if(editarPerTurno.getdFecfin()!=null)
				{
					if(!validaFechaInicioSUNAFIL(editarPerTurno.getdFecfin()))
					{
						mensajeValidaTPE="La fecha de fin no puede ser anterior a la fecha de creación de SUNAFIL.";
						return false;
					}
				}
				else
				{
					mensajeValidaTPE="Ingrese fecha fin.";
					return false;
				}
				if(editarPerTurno.getdFecinicio()!=null && editarPerTurno.getdFecfin()!=null)
				{
					if(editarPerTurno.getdFecinicio().after(editarPerTurno.getdFecfin()))
					{
						mensajeValidaTPE="La fecha fin debe ser mayor a la fecha inicio.";
						return false;
					}
				}
			}
			else if("S".equals(editarPerTurno.getvFlgact()))
			{
				//validar q no haya otro turno activo para esa persona
				PersonalDespatch personalDespatch = new PersonalDespatch();
				try {
					boolean flag=personalDespatch.getTieneOtroTurnoActivo(selectedPersonalT.getvCodpersonal(),editarPerTurno.getnCodperturno());
					if(flag)
					{
						mensajeValidaTPE="La persona ya tiene un turno en estado activo.";
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//end validar q no haya otro turno activo para esa persona
			}	
		}
		else
		{
			mensajeValidaTPE="Seleccione un estado.";
			return false;
		}
		if(editarPerTurno.getdFecinicio()!=null)
		{
			if(!validaFechaInicioSUNAFIL(editarPerTurno.getdFecinicio()))
			{
				mensajeValidaTPE="La fecha de inicio no puede ser anterior a la fecha de creación de SUNAFIL.";
				return false;
			}
		}
		else
		{
			mensajeValidaTPE="Ingrese fecha inicio.";
			return false;
		}		
		return true;
	}
	
	public void actualizarPerTurno(boolean origen)
	{
		if(!validarFormularioTurnoPersonalE())
		{
			Funciones.mostrarMensajeError(mensajeValidaTPE);			
			return;
		}
		//manejo de confirm
		if(origen && "N".equals(editarPerTurno.getvFlgact()))
		{
			System.out.println("Entro a manejo de confirm detalle per turno");
			RequestContext.getCurrentInstance().execute("dialogWidgetBaja.show()");
			return;			
		}
		//end manejo de confirm
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {					
			personalDespatch.actualizarPerTurno(editarPerTurno);
			//pendiente actualizar cabecera personal
		} catch (Exception e) {
			e.printStackTrace();
		}		
		cargarListaTurnoPersonal();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleE.hide()");
		Funciones.mostrarMensajeInfo("Turno actualizado.");
	}
	
	public void dialogTurnoEliminar(VstTurnopersonalrrhh item)
	{
		eliminarPerTurno=new RhmvcPerturno();
		eliminarPerTurno.setnCodperturno(item.getnCodperturno());
		eliminarPerTurnoV=item;
		RequestContext.getCurrentInstance().execute("dialogWidget3.show()");
	}
	
	public void eliminarPerTurno()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {					
			//eliminar per turno	
			personalDespatch.eliminarPerTurno(eliminarPerTurno);
			//post load
			cargarListaTurnoPersonal();
			Funciones.mostrarMensajeInfo("Detalle de turno fue eliminado.");			
		} catch (Exception e) {
			cargarListaTurnoPersonal();
			Funciones.mostrarMensajeError("Hubo problemas con la eliminación.");			
		}
	}
	
	public void dialogTurnoVer(VstTurnopersonalrrhh item)
	{
		//cargar ver per turno
		zoomPerTurno=new RhmvcPerturno();
		zoomPerTurno.setnCodperturno(item.getnCodperturno());
		zoomPerTurno.setnCodturno(item.getnCodturno());
		zoomPerTurno.setdFecinicio(item.getdFecinicio());
		zoomPerTurno.setdFecfin(item.getdFecfin());		
		zoomPerTurno.setvCodpersonal(item.getvCodpersonal());
		zoomPerTurno.setvFlgact(item.getvFlgact());
		itemChangeTurnoZ();
		RequestContext.getCurrentInstance().execute("dialogWidgetDetalleV.show()");
	}
	
	public void itemChangeTurnoZ()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaTurnoDiaZ=personalDespatch.getTurnoDia(zoomPerTurno.getnCodturno());
		} catch (Exception e) {
			listaTurnoDiaZ=null;
			e.printStackTrace();
		}		
	}
	
	public void addNCargo()
	{
		nuevoCargo=new SitbPercargo();
		hayCargoNuevo=!hayCargoNuevo;
	}
	
	private boolean nombreCargoEsNulo(SitbPercargo nuevo){
		if(nuevo.getvNomcargo()!=null && !"".equals(nuevo.getvNomcargo().trim())){}
		else{
			Funciones.mostrarMensajeError("Debe Ingresar un Nombre de Cargo.");
			return true;
		}
		return false;
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
	
	public boolean validaFechaRegular(Date value)
	{
		try {
			SimpleDateFormat simpleDate=new SimpleDateFormat("dd/MM/yyyy");
			Date fechaRegular = simpleDate.parse("01/01/1916");
			return value.after(fechaRegular);
		} catch (Exception e) {
			return false;
		}		
	}
	
	public boolean validaFechaRegular18(Date value)
	{
		try {
			SimpleDateFormat simpleDate=new SimpleDateFormat("dd/MM/yyyy");
			Date fechaRegular = simpleDate.parse("01/01/1916");

			Calendar cal = Calendar.getInstance();
			Date today = cal.getTime();
			cal.add(Calendar.YEAR, -18); 
			Date yearsAgo18 = cal.getTime();
			
			return (value.after(fechaRegular) && value.before(yearsAgo18));
		} catch (Exception e) {
			return false;
		}		
	}
	
	public String getSiguienteCorrelativoSindicato()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			RhtbdPerxsindicato correlativo=personalDespatch.getCorrelativoSindicato();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCorpersin().add(new BigDecimal(1)));
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
	
	public String getSiguienteCorrelativoProfesion()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			RhtbdPerxprofesion correlativo=personalDespatch.getCorrelativoProfesion();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCorperpro().add(new BigDecimal(1)));
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
	
	public String getSiguienteCorrelativoInformacionFinanciera()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			RhtbdPerxentfinanciera correlativo=personalDespatch.getCorrelativoInformacionFinanciera();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCorperentfin().add(new BigDecimal(1)));
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
	
	public String getSiguienteCorrelativoSeguro()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			RhtbdPerxseguro correlativo=personalDespatch.getCorrelativoSeguro();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCorperseg().add(new BigDecimal(1)));
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
	
	public String getSiguienteCorrelativoRegimenPensionario()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			RhtbdPerxregpensionario correlativo=personalDespatch.getCorrelativoRegimenPensionario();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCorperregpen().add(new BigDecimal(1)));
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
	
	public String getSiguienteCorrelativoDireccion()
	{
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			RhtbdPerdireccion correlativo=personalDespatch.getCorrelativoDireccion();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCorperdir().add(new BigDecimal(1)));
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
	
	public static String getFormatFlgAct(String flag) {
		if(flag!=null){
			return "S".equalsIgnoreCase(flag)?"ACTIVO":"INACTIVO";}
		else{
			return "";}
	}
	
	public static String getFormatFlgUlt(String flag) {
		if(flag!=null){
			return "S".equalsIgnoreCase(flag)?"SI":"NO";}
		else{
			return "";}
	}
	
}
