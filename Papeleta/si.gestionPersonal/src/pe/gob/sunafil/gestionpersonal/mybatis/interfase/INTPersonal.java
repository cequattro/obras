package pe.gob.sunafil.gestionpersonal.mybatis.interfase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

public interface INTPersonal {

	public List <TdtbcDependencia> getAutocompletarDependenciaEIntendencia(String query, String nNumint) throws Exception;	
	
	public List <SitbTdocide> getTipoDocRemitente() throws Exception;
	
	public List <PrtbcPersonal> getPersonal(PrtbcPersonal filtro) throws Exception;
	
	public List <VstPersonalrrhh> getPersonalRRHH(VstPersonalrrhh filtro) throws Exception;
	
	public List <PrtbcTipopers> getTipoPersonal() throws Exception;
	
	public List <SitbPercargo> getCargos() throws Exception;
	
	public List <SitbEscalaremun> getEscalas() throws Exception;
	
	public int insertarPersonal(PrtbcPersonal entidad) throws Exception;
	
	public int actualizarPersonal(PrtbcPersonal entidad) throws Exception;
	
	public TdtbcDependencia getDependenciaPorCodigo(Short nNumdep) throws Exception;
	
	public List <TdtbcIntendencia> getIntendencia(String nNumint) throws Exception;
	
	public List <RhtbcTurno> getTurnos() throws Exception;
	
	public List <RhtbcTurnodia> getTurnoDia(Short nCodturno) throws Exception;
	
	public List <VstTurnopersonalrrhh> getTurnoPersonal(String vCodpersonal) throws Exception;
	
	public List <RhtbdPersonal> getDetallePersonal(String vCodpersonal) throws Exception;
	
	public RhmvcPerturno getCorrelativoGlobalPerTurno() throws Exception;
	
	public int insertarPerTurno(RhmvcPerturno entidad) throws Exception;
	
	public int insertarDetallePersonal(RhtbdPersonal entidad) throws Exception;
	
	public int actualizarDetallePersonal(RhtbdPersonal entidad) throws Exception;
	
	public int eliminarDetallePersonal(RhtbdPersonal entidad) throws Exception;
	
	public RhtbdPersonal getCorrelativoGlobalDetalle(String vCodpersonal) throws Exception;
	
	public List <VstDetpersonalrrhh> getVistaDetallePersonal(String vCodpersonal) throws Exception;
	
	public int disableDetallePersonal(String vCodpersonal) throws Exception;
	
	public int disableFlgActDetallePersonal(String vCodpersonal) throws Exception;
	
	public int eliminarPerTurno(RhmvcPerturno entidad) throws Exception;
	
	public int actualizarPerTurno(RhmvcPerturno entidad) throws Exception;
	
	public int disableDateDetallePersonal(String vCodpersonal, Date dFecfin) throws Exception;
	
	public String currentDate() throws Exception;
	
	public boolean getTieneTurnoActivo(String vCodpersonal) throws Exception;
	
	public int disableDatePerTurno(String vCodpersonal, Date dFecfin) throws Exception;
	
	public RhtbdPersonal getMinDateDetalle(String vCodpersonal) throws Exception;
	
	public RhmvcPerturno getMinDatePerTurno(String vCodpersonal) throws Exception;
	
	public RhmvcPerturno getMaxDatePerTurno(String vCodpersonal) throws Exception;
	
	public boolean getTieneOtroTurnoActivo(String vCodpersonal, Short nCodperturno) throws Exception;
	
	public boolean getTieneDetalleActivo(String vCodpersonal) throws Exception;
	
	public List<PrtbcPersonal> getAutoCompletarPersonal(String query) throws Exception;
	
	public List <VstTurnopersonalrrhh> getTurnoPersonal(String vCodpersonal,Date fecha) throws Exception;
	
	public RhtbdPersonal getDefaultDetalle(String vCodpersonal) throws Exception;
	
	public boolean tieneMarcacionMayorAFecha(String vCodpersonal, Date fecha) throws Exception;
	
	//NUEVOS CAMPOS
	
	public List <RhtbcSindicato> getSindicatos() throws Exception;
	
	public List <SitbProfesion> getProfesiones() throws Exception;
	
	public List <SitbEntfinanciera> getEntidadesFinancieras() throws Exception;
	
	public List <SitbSeguro> getSeguros() throws Exception;
	
	public List <SitbSeguro> getSegurosSCTR() throws Exception;
	
	public List <SitbRegpensionario> getRegimenesPensionarios() throws Exception;
	
	public List <SitbEstadocivil> getEstadosCiviles() throws Exception;
	
	public List <SitbDistrito> getDistritos() throws Exception;
	
	public List <SitbZona> getZonas() throws Exception;
	
	public List <SitbTipvia> getTiposVia() throws Exception;
	
	public List <SitbVinculfamili> getVinculos() throws Exception;
	
	public List <RhtbcTiporesol> getTiposResolucion() throws Exception;
	
	public List <RhtbcResolucion> getResolucionesDestaque() throws Exception;
	
	public List <VstTiporesolucion> getTodasResoluciones() throws Exception;
	
	public List <RhtbcCargosindica> getCargosSindicales() throws Exception;
	
	public List <RhtbcClascar> getClasificacionCargos() throws Exception;
	
	//INSERT NUEVOS
	
	public int insertarDetalleSindicato(RhtbdPerxsindicato entidad) throws Exception;
	
	public int insertarDetalleProfesion(RhtbdPerxprofesion entidad) throws Exception;
	
	public int insertarDetalleInformacionFinanciera(RhtbdPerxentfinanciera entidad) throws Exception;
	
	public int insertarDetalleSeguro(RhtbdPerxseguro entidad) throws Exception;
	
	public int insertarDetalleRegimenPensionario(RhtbdPerxregpensionario entidad) throws Exception;
	
	public int insertarDetalleDireccion(RhtbdPerdireccion entidad) throws Exception;
	
	//public int insertarDetalleDestaque(RhtbdDestaque entidad) throws Exception;
	
	public int insertarDependiente(RhtbdDependientes entidad) throws Exception;
	
	public int insertarResolucion(RhtbcResolucion entidad) throws Exception;
	
	//UPDATE NUEVOS
	
	public int actualizarDetalleSindicato(RhtbdPerxsindicato entidad) throws Exception;
	
	public int actualizaDetalleProfesion(RhtbdPerxprofesion entidad) throws Exception;
	
	public int actualizaDetalleInformacionFinanciera(RhtbdPerxentfinanciera entidad) throws Exception;
	
	public int actualizaDetalleSeguro(RhtbdPerxseguro entidad) throws Exception;
	
	public int actualizaDetalleRegimenPensionario(RhtbdPerxregpensionario entidad) throws Exception;
	
	public int actualizaDetalleDireccion(RhtbdPerdireccion entidad) throws Exception;
	
	//public int actualizaDetalleDestaque(RhtbdDestaque entidad) throws Exception;
	
	public int actualizaDependiente(RhtbdDependientes entidad) throws Exception;
	
	public int actualizaResolucion(RhtbcResolucion entidad) throws Exception;
	
	//GETBYPERSONAL NUEVOS
	
	public List <RhtbdPerxsindicato> getDetalleSindicato(String vCodpersonal) throws Exception;
	
	public List <RhtbdPerxprofesion> getDetalleProfesion(String vCodpersonal) throws Exception;
	
	public List <RhtbdPerxentfinanciera> getDetalleInformacionFinanciera(String vCodpersonal) throws Exception;
	
	public List <RhtbdPerxseguro> getDetalleSeguro(String vCodpersonal) throws Exception;
	
	public List <RhtbdPerxregpensionario> getDetalleRegimenPensionario(String vCodpersonal) throws Exception;
	
	public List <RhtbdPerdireccion> getDetalleDireccion(String vCodpersonal) throws Exception;
	
	//public List <RhtbdDestaque> getDetalleDestaque(String vCodpersonal) throws Exception;
	
	public List <RhtbdDependientes> getDependientes(String vCodpersonal) throws Exception;
	
	public List <RhtbcResolucion> getResoluciones() throws Exception;
	
	//GETBYPERSONAL NUEVOS (VISTAS)
	
	public List <VstSindicato> getDetalleSindicatoVista(String vCodpersonal) throws Exception;
	
	public List <VstProfesion> getDetalleProfesionVista(String vCodpersonal) throws Exception;
	
	public List <VstEntfinanciera> getDetalleInformacionFinancieraVista(String vCodpersonal) throws Exception;
	
	public List <VstSeguro> getDetalleSeguroVista(String vCodpersonal) throws Exception;
	
	public List <VstSeguro> getDetalleSeguroVistaSCTR(String vCodpersonal) throws Exception;
	
	public List <VstRegpensionario> getDetalleRegimenPensionarioVista(String vCodpersonal) throws Exception;
	
	public List <VstDirecciones> getDetalleDireccionVista(String vCodpersonal) throws Exception;
	
	public List <VstDependientes> getDependientesVista(String vCodpersonal) throws Exception;
	
	public List <VstResolucion> getResolucionesVista() throws Exception;
	
	public List <VstResolucion> getResolucionesVista(RhtbcResolucion filtro) throws Exception;
	
	//CORRELATIVOS NUEVOS
	
	public RhtbdPerxsindicato getCorrelativoSindicato() throws Exception;
	
	public RhtbdPerxprofesion getCorrelativoProfesion() throws Exception;
	
	public RhtbdPerxentfinanciera getCorrelativoInformacionFinanciera() throws Exception;
	
	public RhtbdPerxseguro getCorrelativoSeguro() throws Exception;
	
	public RhtbdPerxregpensionario getCorrelativoRegimenPensionario() throws Exception;
	
	public RhtbdPerdireccion getCorrelativoDireccion() throws Exception;
	
	//public RhtbdDestaque getCorrelativoDestaque() throws Exception;
	
	public RhtbcResolucion getCorrelativoResolucion() throws Exception;
	
	//DELETES NUEVOS
	
	public int eliminarDetalleSindicato(RhtbdPerxsindicato entidad) throws Exception;
	
	public int eliminarDetalleProfesion(RhtbdPerxprofesion entidad) throws Exception;
	
	public int eliminarDetalleInformacionFinanciera(RhtbdPerxentfinanciera entidad) throws Exception;
	
	public int eliminarDetalleSeguro(RhtbdPerxseguro entidad) throws Exception;
	
	public int eliminarDetalleRegimenPensionario(RhtbdPerxregpensionario entidad) throws Exception;
	
	public int eliminarDetalleDireccion(RhtbdPerdireccion entidad) throws Exception;
	
	//public int eliminarDestaque(RhtbdDestaque entidad) throws Exception;
	
	public int eliminarDependiente(RhtbdDependientes entidad) throws Exception;
	
	public int eliminarResolucion(RhtbcResolucion entidad) throws Exception;
	
	//AUTOCOMPLETE NUEVO
	
	public List <SitbProfesion> getAutocompletarProfesion(String query) throws Exception;
	
	//VALIDA REPETIDO NUEVO
	
	public boolean getTieneProfesionRepetidaUpdate(String vCodprof, String vCodpersonal) throws Exception;
	
	public boolean getTieneEntidadCruzeIni(String vCodpersonal, Date dFecini) throws Exception;
	
	public boolean getTieneEntidadCruzeFin(String vCodpersonal, Date dFecini) throws Exception;
	
	public boolean getTieneEntidadActiva(String vCodpersonal) throws Exception;
	
	public boolean getTieneSeguroCruzeIni(String vCodpersonal, Date dFecini) throws Exception;
	
	public boolean getTieneSeguroCruzeFin(String vCodpersonal, Date dFecini) throws Exception;
	
	public boolean getTieneSeguroActivo(String vCodpersonal) throws Exception;
	
	public boolean getTieneSeguroSCTRCruzeIni(String vCodpersonal, Date dFecini) throws Exception;
	
	public boolean getTieneSeguroSCTRCruzeFin(String vCodpersonal, Date dFecini) throws Exception;
	
	public boolean getTieneSeguroSCTRActivo(String vCodpersonal) throws Exception;
	
	public boolean getTieneRegimenCruzeIni(String vCodpersonal, Date dFecini) throws Exception;
	
	public boolean getTieneRegimenCruzeFin(String vCodpersonal, Date dFecini) throws Exception;
	
	public boolean getTieneRegimenActivo(String vCodpersonal) throws Exception;
	
	public boolean getTieneSindicatoCruzeIni(String vCodpersonal, Date dFecini) throws Exception;
	
	public boolean getTieneSindicatoCruzeFin(String vCodpersonal, Date dFecini) throws Exception;
	
	public boolean getTieneSindicatoActivo(String vCodpersonal) throws Exception;
	
	public boolean getTieneDependienteRepetido(String vCodpersonal, String vCodtdocide, String vNumdoc) throws Exception;
	
	public boolean getTieneResolucionRepetida(String vNumres, String vAnores, BigDecimal nCortipres) throws Exception;
	
	public boolean getEsResolucionAsignada(BigDecimal nCodres) throws Exception;
	
	//DESACTIVAR NUEVO
	
	public int desactivarUltDetallesDireccionPorPersonal(String vCodpersonal) throws Exception;
	
}
