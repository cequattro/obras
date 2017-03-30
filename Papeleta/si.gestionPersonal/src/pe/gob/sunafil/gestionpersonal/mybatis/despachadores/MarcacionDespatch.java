package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPMarcacion;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcCargamasiva;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcErrcarmas;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipojus;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipomarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;

public class MarcacionDespatch {
	
	 private static final MarcacionDespatch instance = new MarcacionDespatch();
	 
	 private INTMarcacion marcacionDAO;
	 private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	 
	 public MarcacionDespatch() {
		 marcacionDAO = new IMPMarcacion();
	    }	 
	 
	 public int insertarMarcacion(RhmvcMarcacion entidad) throws Exception
	 {
		 return marcacionDAO.insertarMarcacion(entidad);
	 }	 	 
	 
	 public RhmvcMarcacion getCorrelativoGlobalMarcacion() throws Exception
	 {
		 return marcacionDAO.getCorrelativoGlobalMarcacion();
	 }
	 
	 public boolean getExistePersonal(String vCodpersonal) throws Exception
	 {
		 return marcacionDAO.getExistePersonal(vCodpersonal);
	 }
	 
	 public PrtbcPersonal getPersonal(String vCodpersonal) throws Exception
	 {
		 return marcacionDAO.getPersonal(vCodpersonal);
	 }
	 
	 public List <RhmvcMarcacion> eliminarMarcacionesRepetidas(Date dFechaI, Date dFechaF) throws Exception
	 {
		 return marcacionDAO.eliminarMarcacionesRepetidas(dFechaI, dFechaF);
	 }
	 
	 public List <VstMarcacionrrhh> getMarcaciones(VstPersonalrrhh filtro, Date fMarcacionI, Date fMarcacionF) throws Exception
	 {
		 return marcacionDAO.getMarcaciones(filtro, fMarcacionI, fMarcacionF);
	 }
	 
	 public List <RhtbcTipomarcacion> getTipoMarcacion() throws Exception
	 {
		 return marcacionDAO.getTipoMarcacion();
	 }
	 
	 public List <RhtbcTipojus> getTipoJustificacion() throws Exception
	 {
		 return marcacionDAO.getTipoJustificacion();
	 }
	 
	 public int eliminarJustificacion(RhmvcMarcacion entidad) throws Exception
	 {
		 return marcacionDAO.eliminarJustificacion(entidad);
	 }
	 
	 public List<VstMarcacionrrhh> getMarcacionesPorCodigoFecha(String vCodPersonal,Date fechaInicio,Date fechaFinal) throws Exception
	 {
		 return marcacionDAO.getMarcacionesPorCodigoFecha(vCodPersonal, fechaInicio, fechaFinal);
	 }
	 
	 public boolean getTurnoActivoParaPersonal(String vCodpersonal, String vflagAct)throws Exception
	 {
		 return marcacionDAO.getTieneTurnoActivoParaPersonal(vCodpersonal, vflagAct);
	 }
	 
	 public boolean tienePermisosParaJustificar(String vCodpersonal, String vflagAct,String vflagPrinc)throws Exception
	 {
		 return marcacionDAO.tienePermisosParaJustificar(vCodpersonal, vflagAct, vflagPrinc);
	 }
	 
	 public boolean marcoEseDia(Date fecha,String codPersonal) throws Exception
	 {
		 return marcacionDAO.marcoEseDia(fecha,codPersonal);
	 }
	 
	 /*
	 public List <RhtbcTipomarcacion> getTipoMarcacion(int tipo) throws Exception{
		 return marcacionDAO.getTipoMarcacion(tipo);
	 }*/
	 
	 public boolean existeMarcacion(String codPersonal,Date fecha, String vDestipo ) throws Exception
	 {
		 return marcacionDAO.existeMarcacion(codPersonal,fecha,vDestipo);
	 }
	 
	 public int insertarItemCargaMasiva(RhtbcCargamasiva entidad) throws Exception
	 {
		 return marcacionDAO.insertarItemCargaMasiva(entidad);
	 }
	 
	 public RhtbcCargamasiva getCorrelativoGlobalItemCargaMasiva() throws Exception
	 {
		 return marcacionDAO.getCorrelativoGlobalItemCargaMasiva();
	 }
	 
	 public RhtbcCargamasiva getCorrelativoGlobalGrupoCargaMasiva() throws Exception
	 {
		 return marcacionDAO.getCorrelativoGlobalGrupoCargaMasiva();
	 }
	 
	 public int insertarItemError(RhtbcErrcarmas entidad) throws Exception
	 {
		 return marcacionDAO.insertarItemError(entidad);
	 }
	 
	 public RhtbcErrcarmas getCorrelativoGlobalItemError() throws Exception
	 {
		 return marcacionDAO.getCorrelativoGlobalItemError();
	 }
	 
	 public List <RhtbcErrcarmas> depurarCargaMasivaItemsRepetidos(BigDecimal nGrupocarga) throws Exception
	 {
		 return marcacionDAO.depurarCargaMasivaItemsRepetidos(nGrupocarga);
	 }
	 
	 public List <RhmvcMarcacion> insertarCargaMasivaAMarcaciones(BigDecimal nGrupocarga) throws Exception
	 {
		 return marcacionDAO.insertarCargaMasivaAMarcaciones(nGrupocarga);
	 }
	 
	 public List <RhtbcErrcarmas> getErroresDeGrupo(BigDecimal nGrupocarga) throws Exception
	 {
		 return marcacionDAO.getErroresDeGrupo(nGrupocarga);
	 }
	 
	 public List<Map> reporteMisMarcaciones(Map parametros) throws Exception
	 {
		 return marcacionDAO.reporteMisMarcaciones(parametros);
	 }
}
