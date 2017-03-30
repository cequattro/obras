package pe.gob.sunafil.gestionpersonal.mybatis.interfase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcCargamasiva;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcErrcarmas;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipojus;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipomarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;

public interface INTMarcacion {

	public int insertarMarcacion(RhmvcMarcacion entidad) throws Exception;	
	
	public RhmvcMarcacion getCorrelativoGlobalMarcacion() throws Exception;
	
	public boolean getExistePersonal(String vCodpersonal) throws Exception;
	
	public PrtbcPersonal getPersonal(String vCodpersonal) throws Exception;
	
	public List <RhmvcMarcacion> eliminarMarcacionesRepetidas(Date dFechaI, Date dFechaF) throws Exception;
	
	public List <VstMarcacionrrhh> getMarcaciones(VstPersonalrrhh filtro, Date fMarcacionI, Date fMarcacionF) throws Exception;
	
	public List <RhtbcTipomarcacion> getTipoMarcacion() throws Exception;
	
	public List <RhtbcTipojus> getTipoJustificacion() throws Exception;
	
	public int eliminarJustificacion(RhmvcMarcacion entidad) throws Exception;
	
	public List<VstMarcacionrrhh> getMarcacionesPorCodigoFecha(String vCodPersonal,Date fechaInicio,Date fechaFinal) throws Exception;
	
	public boolean getTieneTurnoActivoParaPersonal(String vCodpersonal, String vflagAct)throws Exception;
	
	public boolean tienePermisosParaJustificar(String vCodpersonal, String vflagAct,String vflagPrinc)throws Exception;
	
	public boolean marcoEseDia(Date fecha,String codPersonal) throws Exception;
	
	//public List <RhtbcTipomarcacion> getTipoMarcacion(int tipo) throws Exception;
	
	public boolean existeMarcacion(String codPersonal,Date fecha, String vDestipo ) throws Exception;
	
	public int insertarItemCargaMasiva(RhtbcCargamasiva entidad) throws Exception;
	
	public RhtbcCargamasiva getCorrelativoGlobalItemCargaMasiva() throws Exception;
	
	public RhtbcCargamasiva getCorrelativoGlobalGrupoCargaMasiva() throws Exception;
	
	public int insertarItemError(RhtbcErrcarmas entidad) throws Exception;
	
	public RhtbcErrcarmas getCorrelativoGlobalItemError() throws Exception;
	
	public List <RhtbcErrcarmas> depurarCargaMasivaItemsRepetidos(BigDecimal nGrupocarga) throws Exception;
	
	public List <RhmvcMarcacion> insertarCargaMasivaAMarcaciones(BigDecimal nGrupocarga) throws Exception;
	
	public List <RhtbcErrcarmas> getErroresDeGrupo(BigDecimal nGrupocarga) throws Exception;
	
	public List<Map> reporteMisMarcaciones(Map parametros) throws Exception;
}
