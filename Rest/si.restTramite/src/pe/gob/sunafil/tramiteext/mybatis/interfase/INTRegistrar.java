package pe.gob.sunafil.tramiteext.mybatis.interfase;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import pe.gob.sunafil.rest.objeto;
import pe.gob.sunafil.tramiteext.bean.AsociacionPorPersona;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocide;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcHojarutaKey;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupa;
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

public interface INTRegistrar {

	public List <SitbTdocide> getTipoDocRemitente() throws Exception;
	
	public List <TdtbcTipodoctramite> getTipoDocTramite() throws Exception;
	
	public List <TdtbcDependencia> getAutocompletarDependencia(String query) throws Exception;
	
	public List <TdtbcTramite> getTipoTramite() throws Exception;
	
	public List <TdtbcTramite> getTipoTramiteSinTupa() throws Exception;
	
	public List <TdtbcDependencia> getDependencia(String nNumint) throws Exception;
	
	public List <TdtbcDependencia> getAutocompletarDependenciaEIntendencia(String query, String nNumint) throws Exception;
	
	public List <TdtbcIntendencia> getIntendencia(String nNumint) throws Exception;
	
	public List <TdtbdTupa> getProcedimiento(BigDecimal nNumint) throws Exception;
	
	public TdtbdTupa getProcedimientoPorNro(String vCodtupa, BigDecimal nNumint) throws Exception;
	
	public List <TdtbdTupa> getProcedimientoPorNroYDescripcion(String vCodtupa, String vDestupa, BigDecimal nNumint) throws Exception;
	
	public TdtbcDependencia getDependenciaPorCodigo(Short nNumdep) throws Exception;
	
	public List <TdtbdReqtupa> getRequisitosPorTupa(TdtbdTupa tupa) throws Exception;
	
	public TdtbcEntidad getEntidadPorCodigo(String vCodentidad) throws Exception;
	
	public List <TdtbdCentrolab> getDireccionesPorEntidad(String vCodentidad) throws Exception;
	
	public List <VstDireccionestrex> getDirsPorEntidad(String vCodentidad) throws Exception;
	
	public VstDireccionestrex getDirPorCodigoYEntidad(String vCodentidad, Short nCodcenlab) throws Exception;
	
	public int insertarEntidad(TdtbcEntidad entidad) throws Exception;
	
	public TdtbcEntidad getEntidadPorCodigoYTipoDoc(String vCodentidad, String vCodtipodocid) throws Exception;
	
	public int insertarDireccion(TdtbdCentrolab direccion) throws Exception;
	
	public List <AsociacionPorPersona> getAsociacionPorPersona(TdtbcEntidad entidad, String nNumdep) throws Exception;
	
	public List <AsociacionPorPersona> getAsociacionPorHR(String vAniohoja, String vNumhoja, String nNumdep) throws Exception;		
	
	public List <Short> getEquivalenciaDependenciasSIIT(String nNumdep) throws Exception;
	
	public int actualizarEntidad(TdtbcEntidad entidad) throws Exception;
	
	public int insertarRegistro(TdmvcRegistro registro) throws Exception;
	
	public TdtbcCorrelativo getCorrelativo(String vNumano, Short nNumdep, Short nNumtipodoc) throws Exception;
	
	public int insertarCorrelativo(TdtbcCorrelativo correlativo) throws Exception;
	
	public int actualizarCorrelativo(TdtbcCorrelativo correlativo) throws Exception;
	
	public Short getCorrelativoDireccionPorEntidad(String vCodentidad) throws Exception;
	
	public int insertarRequisito(TdmvdRegreqtupa requisito) throws Exception;
	
	public TdmvcHojarutaKey getCorrelativoGlobal(Short vAniohoja) throws Exception;
	
	public int insertarCorrelativoGlobal(TdmvcHojarutaKey correlativoGlobal) throws Exception;
	
	public List<Map> reporteHojaRuta(Map map) throws Exception;
	
	public TdtbdCentrolab getDireccionPorEntidadYCodigo(String vCodentidad, Short nCodcenlab) throws Exception;
	
	public TdtbdTupa getProcedimientoPorKey(Short nNumgrupo, Short nNumdep, String vCodtupa) throws Exception;
	
	public List <TdmvdRegreqtupa> getRequisitosSeleccionadosPorRegistro(String vNumanoreg, Short nNumdep, Short nNumtipodoc, String vNumreg) throws Exception;
	
	public List <TdtbcEntidad> getEntidadPorRazonSocial(String vDesnombre) throws Exception;
	
	public objeto getServiceHR(String vAniohoja, String vNumhoja, String nNumdepsiit) throws Exception;
	
}
