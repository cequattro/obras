package pe.gob.sunafil.tramiteext.mybatis.despachadores;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.rest.objeto;
import pe.gob.sunafil.tramiteext.bean.AsociacionPorPersona;
import pe.gob.sunafil.tramiteext.mybatis.implementacion.IMPRegistrar;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar;
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

public class RegistrarDespatch {
	
	 private static final RegistrarDespatch instance = new RegistrarDespatch();
	 
	 private INTRegistrar registrarDAO;	 
	 
	 public RegistrarDespatch() {
		 registrarDAO = new IMPRegistrar();
	    }

	 public List <SitbTdocide> getTipoDocRemitente() throws Exception
	 {
		 return registrarDAO.getTipoDocRemitente();
	 }
	 
	 public List <TdtbcTipodoctramite> getTipoDocTramite() throws Exception
	 {
		 return registrarDAO.getTipoDocTramite();
	 }
	 
	 public List <TdtbcDependencia> getAutocompletarDependencia(String query) throws Exception
	 {
		 return registrarDAO.getAutocompletarDependencia(query);
	 }
	 
	 public List <TdtbcTramite> getTipoTramite() throws Exception
	 {
		 return registrarDAO.getTipoTramite();
	 }
	 
	 public List <TdtbcTramite> getTipoTramiteSinTupa() throws Exception
	 {
		 return registrarDAO.getTipoTramiteSinTupa();
	 }
	 
	 public List <TdtbcDependencia> getDependencia(String nNumint) throws Exception
	 {
		 return registrarDAO.getDependencia(nNumint);
	 }
	 
	 public List <TdtbcDependencia> getAutocompletarDependenciaEIntendencia(String query, String nNumint) throws Exception
	 {
		 return registrarDAO.getAutocompletarDependenciaEIntendencia(query, nNumint);
	 }
	 
	 public List <TdtbcIntendencia> getIntendencia(String nNumint) throws Exception
	 {
		 return registrarDAO.getIntendencia(nNumint);
	 }
	 
	 public List <TdtbdTupa> getProcedimiento(BigDecimal nNumint) throws Exception
	 {
		 return registrarDAO.getProcedimiento(nNumint);
	 }
	 
	 public TdtbdTupa getProcedimientoPorNro(String vCodtupa, BigDecimal nNumint) throws Exception
	 {
		 return registrarDAO.getProcedimientoPorNro(vCodtupa, nNumint);
	 }
	 
	 public List <TdtbdTupa> getProcedimientoPorNroYDescripcion(String vCodtupa, String vDestupa, BigDecimal nNumint) throws Exception
	 {
		 return registrarDAO.getProcedimientoPorNroYDescripcion(vCodtupa, vDestupa, nNumint);
	 }
	 
	 public TdtbcDependencia getDependenciaPorCodigo(Short nNumdep) throws Exception
	 {
		 return registrarDAO.getDependenciaPorCodigo(nNumdep);
	 }
	 
	 public List <TdtbdReqtupa> getRequisitosPorTupa(TdtbdTupa tupa) throws Exception
	 {
		 return registrarDAO.getRequisitosPorTupa(tupa);
	 }
	 
	 public TdtbcEntidad getEntidadPorCodigo(String vCodentidad) throws Exception
	 {
		 return registrarDAO.getEntidadPorCodigo(vCodentidad);
	 }
	 
	 public List <TdtbdCentrolab> getDireccionesPorEntidad(String vCodentidad) throws Exception
	 {
		 return registrarDAO.getDireccionesPorEntidad(vCodentidad);
	 }
	 
	 public List <VstDireccionestrex> getDirsPorEntidad(String vCodentidad) throws Exception
	 {
		 return registrarDAO.getDirsPorEntidad(vCodentidad);
	 }
	 
	 public VstDireccionestrex getDirPorCodigoYEntidad(String vCodentidad, Short nCodcenlab) throws Exception
	 {
		 return registrarDAO.getDirPorCodigoYEntidad(vCodentidad, nCodcenlab);
	 }
	 
	 public int insertarEntidad(TdtbcEntidad entidad) throws Exception
	 {
		 return registrarDAO.insertarEntidad(entidad);
	 }
	 
	 public TdtbcEntidad getEntidadPorCodigoYTipoDoc(String vCodentidad, String vCodtipodocid) throws Exception
	 {
		 return registrarDAO.getEntidadPorCodigoYTipoDoc(vCodentidad, vCodtipodocid);
	 }
	 
	 public int insertarDireccion(TdtbdCentrolab direccion) throws Exception
	 {
		 return registrarDAO.insertarDireccion(direccion);
	 }
	 
	 public List <AsociacionPorPersona> getAsociacionPorPersona(TdtbcEntidad entidad, String nNumdep) throws Exception
	 {
		 return registrarDAO.getAsociacionPorPersona(entidad, nNumdep);
	 }
	 
	 public List <AsociacionPorPersona> getAsociacionPorHR(String vAniohoja, String vNumhoja, String nNumdep) throws Exception
	 {
		 return registrarDAO.getAsociacionPorHR(vAniohoja, vNumhoja, nNumdep);
	 }
	 
	 public List <Short> getEquivalenciaDependenciasSIIT(String nNumdep) throws Exception
	 {
		 return registrarDAO.getEquivalenciaDependenciasSIIT(nNumdep);
	 }
	 
	 public int actualizarEntidad(TdtbcEntidad entidad) throws Exception
	 {
		 return registrarDAO.actualizarEntidad(entidad);
	 }
	 
	 public int insertarRegistro(TdmvcRegistro registro) throws Exception
	 {
		 return registrarDAO.insertarRegistro(registro);
	 }
	 
	 public TdtbcCorrelativo getCorrelativo(String vNumano, Short nNumdep, Short nNumtipodoc) throws Exception
	 {
		 return registrarDAO.getCorrelativo(vNumano, nNumdep, nNumtipodoc);
	 }
	 
	 public int insertarCorrelativo(TdtbcCorrelativo correlativo) throws Exception
	 {
		 return registrarDAO.insertarCorrelativo(correlativo);
	 }
	 
	 public int actualizarCorrelativo(TdtbcCorrelativo correlativo) throws Exception
	 {
		 return registrarDAO.actualizarCorrelativo(correlativo);
	 }
	 
	 public Short getCorrelativoDireccionPorEntidad(String vCodentidad) throws Exception
	 {
		 return registrarDAO.getCorrelativoDireccionPorEntidad(vCodentidad);
	 }
	 
	 public int insertarRequisito(TdmvdRegreqtupa requisito) throws Exception
	 {
		 return registrarDAO.insertarRequisito(requisito);
	 }
	 
	 public TdmvcHojarutaKey getCorrelativoGlobal(Short vAniohoja) throws Exception
	 {
		 return registrarDAO.getCorrelativoGlobal(vAniohoja);
	 }
	 
	 public int insertarCorrelativoGlobal(TdmvcHojarutaKey correlativoGlobal) throws Exception
	 {
		 return registrarDAO.insertarCorrelativoGlobal(correlativoGlobal);
	 }	 	 
	 
	 public List<Map> reporteHojaRuta(Map map) throws Exception
	 {
		 return registrarDAO.reporteHojaRuta(map);
	 }
	 
	 public TdtbdCentrolab getDireccionPorEntidadYCodigo(String vCodentidad, Short nCodcenlab) throws Exception
	 {
		 return registrarDAO.getDireccionPorEntidadYCodigo(vCodentidad, nCodcenlab);
	 }
	 
	 public TdtbdTupa getProcedimientoPorKey(Short nNumgrupo, Short nNumdep, String vCodtupa) throws Exception
	 {
		 return registrarDAO.getProcedimientoPorKey(nNumgrupo, nNumdep, vCodtupa);
	 }
	 
	 public List <TdmvdRegreqtupa> getRequisitosSeleccionadosPorRegistro(String vNumanoreg, Short nNumdep, Short nNumtipodoc, String vNumreg) throws Exception
	 {
		 return registrarDAO.getRequisitosSeleccionadosPorRegistro(vNumanoreg, nNumdep, nNumtipodoc, vNumreg);
	 }
	 
	 public List <TdtbcEntidad> getEntidadPorRazonSocial(String vDesnombre) throws Exception
	 {
		 return registrarDAO.getEntidadPorRazonSocial(vDesnombre);
	 }
	 
	 public objeto getServiceHR(String vAniohoja, String vNumhoja, String nNumdepsiit) throws Exception
	 {
		 return registrarDAO.getServiceHR(vAniohoja, vNumhoja, nNumdepsiit);
	 }
}
