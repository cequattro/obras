package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPPersonal;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcTipopers;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcCargosindica;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcClascar;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcResolucion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcSindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTiporesol;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodia;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdDependientes;
//import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdDestaque;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerdireccion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxentfinanciera;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxprofesion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxregpensionario;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxseguro;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxsindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbDistrito;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEntfinanciera;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEscalaremun;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEstadocivil;
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
import pe.gob.sunafil.gestionpersonal.persistence.model.VstResolucion;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstSeguro;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstSindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTiporesolucion;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTurnopersonalrrhh;

public class PersonalDespatch {
	
	 private static final PersonalDespatch instance = new PersonalDespatch();
	 
	 private INTPersonal personalDAO;
	 private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	 
	 public PersonalDespatch() {
		 personalDAO = new IMPPersonal();
	    }	 
	 
	 public List <TdtbcDependencia> getAutocompletarDependenciaEIntendencia(String query, String nNumint) throws Exception
	 {
		 return personalDAO.getAutocompletarDependenciaEIntendencia(query, nNumint);
	 }
	 
	 public List <SitbTdocide> getTipoDocRemitente() throws Exception
	 {
		 return personalDAO.getTipoDocRemitente();
	 }
	 
	 public List <PrtbcPersonal> getPersonal(PrtbcPersonal filtro) throws Exception
	 {
		 return personalDAO.getPersonal(filtro);
	 }
	 
	 public List <VstPersonalrrhh> getPersonalRRHH(VstPersonalrrhh filtro) throws Exception
	 {
		 return personalDAO.getPersonalRRHH(filtro);
	 }
	 
	 public List <PrtbcTipopers> getTipoPersonal() throws Exception
	 {
		 return personalDAO.getTipoPersonal();
	 }
	 
	 public List <SitbPercargo> getCargos() throws Exception
	 {
		 return personalDAO.getCargos();
	 }
	 
	 public List <SitbEscalaremun> getEscalas() throws Exception
	 {
		 return personalDAO.getEscalas();
	 }
	 
	 public int insertarPersonal(PrtbcPersonal entidad) throws Exception
	 {
		 return personalDAO.insertarPersonal(entidad);
	 }
	 
	 public TdtbcDependencia getDependenciaPorCodigo(Short nNumdep) throws Exception
	 {
		 return personalDAO.getDependenciaPorCodigo(nNumdep);
	 }
	 
	 public int actualizarPersonal(PrtbcPersonal entidad) throws Exception
	 {
		 return personalDAO.actualizarPersonal(entidad);
	 }
	 
	 public List <TdtbcIntendencia> getIntendencia(String nNumint) throws Exception
	 {
		 return personalDAO.getIntendencia(nNumint);
	 }
	 
	 public List <RhtbcTurno> getTurnos() throws Exception
	 {
		 return personalDAO.getTurnos();
	 }
	 
	 public List <RhtbcTurnodia> getTurnoDia(Short nCodturno) throws Exception
	 {
		 return personalDAO.getTurnoDia(nCodturno);
	 }
	 
	 public List <VstTurnopersonalrrhh> getTurnoPersonal(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getTurnoPersonal(vCodpersonal);
	 }
	 
	 public List <RhtbdPersonal> getDetallePersonal(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetallePersonal(vCodpersonal);
	 }
	 
	 public RhmvcPerturno getCorrelativoGlobalPerTurno() throws Exception
	 {
		 return personalDAO.getCorrelativoGlobalPerTurno();
	 }
	 
	 public int insertarPerTurno(RhmvcPerturno entidad) throws Exception
	 {
		 return personalDAO.insertarPerTurno(entidad);
	 }
	 
	 public int insertarDetallePersonal(RhtbdPersonal entidad) throws Exception
	 {
		 return personalDAO.insertarDetallePersonal(entidad);
	 }
		
	 public int actualizarDetallePersonal(RhtbdPersonal entidad) throws Exception
	 {
		 return personalDAO.actualizarDetallePersonal(entidad);
	 }
	
	 public int eliminarDetallePersonal(RhtbdPersonal entidad) throws Exception
	 {
		 return personalDAO.eliminarDetallePersonal(entidad);
	 }
	 
	 public RhtbdPersonal getCorrelativoGlobalDetalle(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getCorrelativoGlobalDetalle(vCodpersonal);
	 }
	 
	 public List <VstDetpersonalrrhh> getVistaDetallePersonal(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getVistaDetallePersonal(vCodpersonal);
	 }
	 
	 public int disableDetallePersonal(String vCodpersonal) throws Exception
	 {
		 return personalDAO.disableDetallePersonal(vCodpersonal);
	 }
	 
	 public int disableFlgActDetallePersonal(String vCodpersonal) throws Exception
	 {
		 return personalDAO.disableFlgActDetallePersonal(vCodpersonal);
	 }
	 
	 public int eliminarPerTurno(RhmvcPerturno entidad) throws Exception
	 {
		 return personalDAO.eliminarPerTurno(entidad);
	 }
	 
	 public int actualizarPerTurno(RhmvcPerturno entidad) throws Exception
	 {
		 return personalDAO.actualizarPerTurno(entidad);
	 }
	 
	 public int disableDateDetallePersonal(String vCodpersonal, Date dFecfin) throws Exception
	 {
		 return personalDAO.disableDateDetallePersonal(vCodpersonal, dFecfin);
	 }
	 
	 public String currentDate() throws Exception
	 {
		 return personalDAO.currentDate();
	 }
	 
	 public boolean getTieneTurnoActivo(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getTieneTurnoActivo(vCodpersonal);
	 }
	 
	 public int disableDatePerTurno(String vCodpersonal, Date dFecfin) throws Exception
	 {
		 return personalDAO.disableDatePerTurno(vCodpersonal, dFecfin);
	 }
	 
	 public RhtbdPersonal getMinDateDetalle(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getMinDateDetalle(vCodpersonal);
	 }
	 
	 public RhmvcPerturno getMinDatePerTurno(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getMinDatePerTurno(vCodpersonal);
	 }
	 
	 public RhmvcPerturno getMaxDatePerTurno(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getMaxDatePerTurno(vCodpersonal);
	 }
	 
	 public boolean getTieneOtroTurnoActivo(String vCodpersonal, Short nCodperturno) throws Exception
	 {
		 return personalDAO.getTieneOtroTurnoActivo(vCodpersonal, nCodperturno);
	 }
	 
	 public boolean getTieneDetalleActivo(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getTieneDetalleActivo(vCodpersonal);
	 }
	 
	 public List<PrtbcPersonal> getAutoCompletarPersonal(String query) throws Exception
	 {
		 return personalDAO.getAutoCompletarPersonal(query);
	 }
	 
	 public List <VstTurnopersonalrrhh> getTurnoPersonal(String vCodpersonal,Date fecha) throws Exception
	 {
		 return personalDAO.getTurnoPersonal(vCodpersonal,fecha);
	 }
	 
	 public RhtbdPersonal getDefaultDetalle(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDefaultDetalle(vCodpersonal);
	 }
	 
	 public boolean tieneMarcacionMayorAFecha(String vCodpersonal, Date fecha) throws Exception
	 {
		 return personalDAO.tieneMarcacionMayorAFecha(vCodpersonal, fecha);
	 }
	 
	 //NUEVOS CAMPOS
	 public List <RhtbcSindicato> getSindicatos() throws Exception
	 {
		 return personalDAO.getSindicatos();
	 }
	 
	 public List <SitbProfesion> getProfesiones() throws Exception
	 {
		 return personalDAO.getProfesiones();
	 }
	 
	 public List <SitbEntfinanciera> getEntidadesFinancieras() throws Exception
	 {
		 return personalDAO.getEntidadesFinancieras();
	 }
	 
	 public List <SitbSeguro> getSeguros() throws Exception
	 {
		 return personalDAO.getSeguros();
	 }
	 
	 public List <SitbSeguro> getSegurosSCTR() throws Exception
	 {
		 return personalDAO.getSegurosSCTR();
	 }
	 
	 public List <SitbRegpensionario> getRegimenesPensionarios() throws Exception
	 {
		 return personalDAO.getRegimenesPensionarios();
	 }
	 
	 public List <SitbEstadocivil> getEstadosCiviles() throws Exception
	 {
		 return personalDAO.getEstadosCiviles();
	 }
	 
	 public List <SitbDistrito> getDistritos() throws Exception
	 {
		 return personalDAO.getDistritos();
	 }
	 
	 public List <SitbZona> getZonas() throws Exception
	 {
		 return personalDAO.getZonas();
	 }
	 
	 public List <SitbTipvia> getTiposVia() throws Exception
	 {
		 return personalDAO.getTiposVia();
	 }
	 
	 public List <SitbVinculfamili> getVinculos() throws Exception
	 {
		 return personalDAO.getVinculos();
	 }
	 
	 public List <RhtbcTiporesol> getTiposResolucion() throws Exception
	 {
		 return personalDAO.getTiposResolucion();
	 }
	 
	 public List <RhtbcResolucion> getResolucionesDestaque() throws Exception
	 {
		 return personalDAO.getResolucionesDestaque();
	 }
	 
	 public List <VstTiporesolucion> getTodasResoluciones() throws Exception
	 {
		 return personalDAO.getTodasResoluciones();
	 }
	 
	 public List <RhtbcCargosindica> getCargosSindicales() throws Exception
	 {
		 return personalDAO.getCargosSindicales();
	 }
	 
	 public List <RhtbcClascar> getClasificacionCargos() throws Exception
	 {
		 return personalDAO.getClasificacionCargos();
	 }
	 
	 //INSERT NUEVOS
		
	 public int insertarDetalleSindicato(RhtbdPerxsindicato entidad) throws Exception
	 {
		 return personalDAO.insertarDetalleSindicato(entidad); 
	 }
	 
	 public int insertarDetalleProfesion(RhtbdPerxprofesion entidad) throws Exception
	 {
		 return personalDAO.insertarDetalleProfesion(entidad);
	 }
	 
	 public int insertarDetalleInformacionFinanciera(RhtbdPerxentfinanciera entidad) throws Exception
	 {
		 return personalDAO.insertarDetalleInformacionFinanciera(entidad);
	 }
	 
	 public int insertarDetalleSeguro(RhtbdPerxseguro entidad) throws Exception
	 {
		 return personalDAO.insertarDetalleSeguro(entidad);
	 }
	 
	 public int insertarDetalleRegimenPensionario(RhtbdPerxregpensionario entidad) throws Exception
	 {
		 return personalDAO.insertarDetalleRegimenPensionario(entidad);
	 }
	 
	 public int insertarDetalleDireccion(RhtbdPerdireccion entidad) throws Exception
	 {
		 return personalDAO.insertarDetalleDireccion(entidad);
	 }
	 
	 /*public int insertarDetalleDestaque(RhtbdDestaque entidad) throws Exception
	 {
		 return personalDAO.insertarDetalleDestaque(entidad);
	 }*/
	 
	 public int insertarDependiente(RhtbdDependientes entidad) throws Exception
	 {
		 return personalDAO.insertarDependiente(entidad);
	 }
	 
	 public int insertarResolucion(RhtbcResolucion entidad) throws Exception
	 {
		 return personalDAO.insertarResolucion(entidad);
	 }
	 
	 //UPDATE NUEVOS
		
	 public int actualizarDetalleSindicato(RhtbdPerxsindicato entidad) throws Exception
	 {
		 return personalDAO.actualizarDetalleSindicato(entidad);
	 }
	 
	 public int actualizaDetalleProfesion(RhtbdPerxprofesion entidad) throws Exception
	 {
		 return personalDAO.actualizaDetalleProfesion(entidad);
	 }
	 
	 public int actualizaDetalleInformacionFinanciera(RhtbdPerxentfinanciera entidad) throws Exception
	 {
		 return personalDAO.actualizaDetalleInformacionFinanciera(entidad);
	 }
	 
	 public int actualizaDetalleSeguro(RhtbdPerxseguro entidad) throws Exception
	 {
		 return personalDAO.actualizaDetalleSeguro(entidad);
	 }
	 
	 public int actualizaDetalleRegimenPensionario(RhtbdPerxregpensionario entidad) throws Exception
	 {
		 return personalDAO.actualizaDetalleRegimenPensionario(entidad);
	 }
	 
	 public int actualizaDetalleDireccion(RhtbdPerdireccion entidad) throws Exception
	 {
		 return personalDAO.actualizaDetalleDireccion(entidad);
	 }
	 
	 /*public int actualizaDetalleDestaque(RhtbdDestaque entidad) throws Exception
	 {
		 return personalDAO.actualizaDetalleDestaque(entidad);
	 }*/
	 
	 public int actualizaDependiente(RhtbdDependientes entidad) throws Exception
	 {
		 return personalDAO.actualizaDependiente(entidad);
	 }
	 
	 public int actualizaResolucion(RhtbcResolucion entidad) throws Exception
	 {
		 return personalDAO.actualizaResolucion(entidad);
	 }
	 
	 //GETBYPERSONAL NUEVOS
		
	 public List <RhtbdPerxsindicato> getDetalleSindicato(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleSindicato(vCodpersonal);
	 }
	 
	 public List <RhtbdPerxprofesion> getDetalleProfesion(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleProfesion(vCodpersonal);
	 }
	 
	 public List <RhtbdPerxentfinanciera> getDetalleInformacionFinanciera(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleInformacionFinanciera(vCodpersonal);
	 }
	 
	 public List <RhtbdPerxseguro> getDetalleSeguro(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleSeguro(vCodpersonal);
	 }
	 
	 public List <RhtbdPerxregpensionario> getDetalleRegimenPensionario(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleRegimenPensionario(vCodpersonal);
	 }
	 
	 public List <RhtbdPerdireccion> getDetalleDireccion(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleDireccion(vCodpersonal);
	 }
	 
	 /*public List <RhtbdDestaque> getDetalleDestaque(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleDestaque(vCodpersonal);
	 }*/
	 
	 public List <RhtbdDependientes> getDependientes(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDependientes(vCodpersonal);
	 }
	 
	 public List <RhtbcResolucion> getResoluciones() throws Exception
	 {
		 return personalDAO.getResoluciones();
	 }
	 
	//GETBYPERSONAL NUEVOS (VISTAS)
	 
	 public List <VstSindicato> getDetalleSindicatoVista(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleSindicatoVista(vCodpersonal);
	 }
	 
	 public List <VstProfesion> getDetalleProfesionVista(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleProfesionVista(vCodpersonal);
	 }
	 
	 public List <VstEntfinanciera> getDetalleInformacionFinancieraVista(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleInformacionFinancieraVista(vCodpersonal);
	 }
	 
	 public List <VstSeguro> getDetalleSeguroVista(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleSeguroVista(vCodpersonal);
	 }
	 
	 public List <VstSeguro> getDetalleSeguroVistaSCTR(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleSeguroVistaSCTR(vCodpersonal);
	 }
	 
	 public List <VstRegpensionario> getDetalleRegimenPensionarioVista(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleRegimenPensionarioVista(vCodpersonal);
	 }
	 
	 public List <VstDirecciones> getDetalleDireccionVista(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDetalleDireccionVista(vCodpersonal);
	 }
	 
	 public List <VstDependientes> getDependientesVista(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getDependientesVista(vCodpersonal);
	 }
	 
	 public List <VstResolucion> getResolucionesVista() throws Exception
	 {
		 return personalDAO.getResolucionesVista();
	 }
	 
	 public List <VstResolucion> getResolucionesVista(RhtbcResolucion filtro) throws Exception
	 {
		 return personalDAO.getResolucionesVista(filtro);
	 }
	 
	 //CORRELATIVOS NUEVOS
		
	 public RhtbdPerxsindicato getCorrelativoSindicato() throws Exception
	 {
		 return personalDAO.getCorrelativoSindicato();
	 }
	 
	 public RhtbdPerxprofesion getCorrelativoProfesion() throws Exception
	 {
		 return personalDAO.getCorrelativoProfesion();
	 }
	 
	 public RhtbdPerxentfinanciera getCorrelativoInformacionFinanciera() throws Exception
	 {
		 return personalDAO.getCorrelativoInformacionFinanciera();
	 }
	 
	 public RhtbdPerxseguro getCorrelativoSeguro() throws Exception
	 {
		 return personalDAO.getCorrelativoSeguro();
	 }
	 
	 public RhtbdPerxregpensionario getCorrelativoRegimenPensionario() throws Exception
	 {
		 return personalDAO.getCorrelativoRegimenPensionario();
	 }
	 
	 public RhtbdPerdireccion getCorrelativoDireccion() throws Exception
	 {
		 return personalDAO.getCorrelativoDireccion();
	 }
	 
	 /*public RhtbdDestaque getCorrelativoDestaque() throws Exception
	 {
		 return personalDAO.getCorrelativoDestaque();
	 }*/
	 
	 public RhtbcResolucion getCorrelativoResolucion() throws Exception
	 {
		 return personalDAO.getCorrelativoResolucion();
	 }
	 
	//DELETES NUEVOS
	 
	 public int eliminarDetalleSindicato(RhtbdPerxsindicato entidad) throws Exception
	 {
		 return personalDAO.eliminarDetalleSindicato(entidad);
	 }
	 
	 public int eliminarDetalleProfesion(RhtbdPerxprofesion entidad) throws Exception
	 {
		 return personalDAO.eliminarDetalleProfesion(entidad);
	 }
	 
	 public int eliminarDetalleInformacionFinanciera(RhtbdPerxentfinanciera entidad) throws Exception
	 {
		 return personalDAO.eliminarDetalleInformacionFinanciera(entidad);
	 }
	 
	 public int eliminarDetalleSeguro(RhtbdPerxseguro entidad) throws Exception
	 {
		 return personalDAO.eliminarDetalleSeguro(entidad);
	 }
	 
	 public int eliminarDetalleRegimenPensionario(RhtbdPerxregpensionario entidad) throws Exception
	 {
		 return personalDAO.eliminarDetalleRegimenPensionario(entidad);
	 }
	 
	 public int eliminarDetalleDireccion(RhtbdPerdireccion entidad) throws Exception
	 {
		 return personalDAO.eliminarDetalleDireccion(entidad);
	 }
	 
	 /*public int eliminarDestaque(RhtbdDestaque entidad) throws Exception
	 {
		 return personalDAO.eliminarDestaque(entidad);
	 }*/
	 
	 public int eliminarDependiente(RhtbdDependientes entidad) throws Exception
	 {
		 return personalDAO.eliminarDependiente(entidad);
	 }
	 
	 public int eliminarResolucion(RhtbcResolucion entidad) throws Exception
	 {
		 return personalDAO.eliminarResolucion(entidad);
	 }
	 
	 //AUTOCOMPLETE NUEVO
	 
	 public List <SitbProfesion> getAutocompletarProfesion(String query) throws Exception
	 {
		 return personalDAO.getAutocompletarProfesion(query);
	 }
	 
	//VALIDA REPETIDO NUEVO
	 
	 public boolean getTieneProfesionRepetidaUpdate(String vCodprof, String vCodpersonal) throws Exception
	 {
		 return personalDAO.getTieneProfesionRepetidaUpdate(vCodprof, vCodpersonal);
	 }
	 
	 public boolean getTieneEntidadCruzeIni(String vCodpersonal, Date dFecini) throws Exception
	 {
		 return personalDAO.getTieneEntidadCruzeIni(vCodpersonal, dFecini);
	 }
	 
	 public boolean getTieneEntidadCruzeFin(String vCodpersonal, Date dFecini) throws Exception
	 {
		 return personalDAO.getTieneEntidadCruzeFin(vCodpersonal, dFecini);
	 }
	 
	 public boolean getTieneEntidadActiva(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getTieneEntidadActiva(vCodpersonal);
	 }
	 
	 public boolean getTieneSeguroCruzeIni(String vCodpersonal, Date dFecini) throws Exception
	 {
		 return personalDAO.getTieneSeguroCruzeIni(vCodpersonal, dFecini);
	 }
	 
	 public boolean getTieneSeguroCruzeFin(String vCodpersonal, Date dFecini) throws Exception
	 {
		 return personalDAO.getTieneSeguroCruzeFin(vCodpersonal, dFecini);
	 }
	 
	 public boolean getTieneSeguroActivo(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getTieneSeguroActivo(vCodpersonal);
	 }
	 
	 public boolean getTieneSeguroSCTRCruzeIni(String vCodpersonal, Date dFecini) throws Exception
	 {
		 return personalDAO.getTieneSeguroSCTRCruzeIni(vCodpersonal, dFecini);
	 }
	 
	 public boolean getTieneSeguroSCTRCruzeFin(String vCodpersonal, Date dFecini) throws Exception
	 {
		 return personalDAO.getTieneSeguroSCTRCruzeFin(vCodpersonal, dFecini);
	 }
	 
	 public boolean getTieneSeguroSCTRActivo(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getTieneSeguroSCTRActivo(vCodpersonal);
	 }
	 
	 public boolean getTieneRegimenCruzeIni(String vCodpersonal, Date dFecini) throws Exception
	 {
		 return personalDAO.getTieneRegimenCruzeIni(vCodpersonal, dFecini);
	 }
	 
	 public boolean getTieneRegimenCruzeFin(String vCodpersonal, Date dFecini) throws Exception
	 {
		 return personalDAO.getTieneRegimenCruzeFin(vCodpersonal, dFecini);
	 }
	 
	 public boolean getTieneRegimenActivo(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getTieneRegimenActivo(vCodpersonal);
	 }
	 
	 public boolean getTieneSindicatoCruzeIni(String vCodpersonal, Date dFecini) throws Exception
	 {
		 return personalDAO.getTieneSindicatoCruzeIni(vCodpersonal, dFecini);
	 }
	 
	 public boolean getTieneSindicatoCruzeFin(String vCodpersonal, Date dFecini) throws Exception
	 {
		 return personalDAO.getTieneSindicatoCruzeFin(vCodpersonal, dFecini);
	 }
	 
	 public boolean getTieneSindicatoActivo(String vCodpersonal) throws Exception
	 {
		 return personalDAO.getTieneSindicatoActivo(vCodpersonal);
	 }
	 
	 public boolean getTieneDependienteRepetido(String vCodpersonal, String vCodtdocide, String vNumdoc) throws Exception
	 {
		 return personalDAO.getTieneDependienteRepetido(vCodpersonal, vCodtdocide, vNumdoc);
	 }
	 
	 public boolean getTieneResolucionRepetida(String vNumres, String vAnores, BigDecimal nCortipres) throws Exception
	 {
		 return personalDAO.getTieneResolucionRepetida(vNumres, vAnores, nCortipres);
	 }
	 
	 public boolean getEsResolucionAsignada(BigDecimal nCodres) throws Exception
	 {
		 return personalDAO.getEsResolucionAsignada(nCodres);
	 }
	 
	 //DESACTIVAR NUEVO
	 
	 public int desactivarUltDetallesDireccionPorPersonal(String vCodpersonal) throws Exception
	 {
		 return personalDAO.desactivarUltDetallesDireccionPorPersonal(vCodpersonal);
	 }
}
