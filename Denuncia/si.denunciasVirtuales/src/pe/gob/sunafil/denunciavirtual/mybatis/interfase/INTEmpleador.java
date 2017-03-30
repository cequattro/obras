package pe.gob.sunafil.denunciavirtual.mybatis.interfase;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import pe.gob.sunafil.denunciavirtual.bean.Empresa;
import pe.gob.sunafil.denunciavirtual.persistence.model.DlmvSolicitud;
import pe.gob.sunafil.denunciavirtual.persistence.model.DlmvdDocxsol;
import pe.gob.sunafil.denunciavirtual.persistence.model.DltbEmpleador;
import pe.gob.sunafil.denunciavirtual.persistence.model.DltbcMateria;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbDepxdistrito;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbTipomoneda;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdmvcHojarutaKey;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcCorrelativo;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcEntidad;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbdCentrolab;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcSoldenvirtual;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.SitbEmpleador;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.VstIntendenRegionales;

public interface INTEmpleador {

	public String verificarEmpMTPE(Empresa empresa) throws Exception;
	
	public DltbEmpleador getEmpleadorPorCodigo(String vCodemp) throws Exception;
	
	public SitbEmpleador getSitbEmpleadorPorRUC(String vCodemp) throws Exception;
	
	
	public int insertarEmpleador(DltbEmpleador entidad);
	
	public List <String> getIntendenciasHabilitadasSIIT() throws Exception;
	
	public int obtieneNuevaSolicitud() ;
	
	public int insertarSolicitud(DlmvSolicitud entidad) ;
	
	public int actualizarSolicitud(DlmvSolicitud solicitud) ;
	
	public List <SitbTipomoneda> getTipoMoneda() throws Exception;
	
	public int actualizarArchivo(DlmvdDocxsol archivo) throws Exception;
	
	public List <DltbcMateria> getMateria() throws Exception;
	
	public String getCorrelativoSolicitud(String vAnhosol) throws Exception;
	
	public int insertarRegistro(TdmvcRegistro registro);
	
	public TdtbcIntendencia getIntendenciaPorUbigeo(String vUbigeo) throws Exception;
	
	public TdtbcCorrelativo getCorrelativo(String vNumano, Short nNumdep, Short nNumtipodoc) throws Exception;
	
	public int actualizarCorrelativo(TdtbcCorrelativo correlativo) throws Exception;
	
	public int insertarCorrelativo(TdtbcCorrelativo correlativo) throws Exception;
	
	public TdmvcHojarutaKey getCorrelativoGlobal(Short vAniohoja) throws Exception;
	
	public void insertarCorrelativoGlobal(TdmvcHojarutaKey correlativoGlobal) throws Exception;
	
	public TdtbcEntidad getEntidadPorCodigo(String vCodentidad) throws Exception;
	
	public int insertarEntidad(TdtbcEntidad entidad);
	
	public int actualizarEntidad(TdtbcEntidad entidad);
	
	public Short getCorrelativoDireccionPorEntidad(String vCodentidad) throws Exception;
	
	public int insertarDireccion(TdtbdCentrolab direccion);
	
	public DltbcMateria getMateriaPorCodigo(BigDecimal nCodmat) throws Exception;
	
	public SitbTipomoneda getMonedaPorCodigo(String vCodtmon) throws Exception;
	
	public void insertarReporte(IltbcSoldenvirtual entidad) throws Exception;
	
	public String insertarRegistroEntradaSIIT(Map parametros) throws Exception;
	
	public SitbDepxdistrito getDependenciaSIITPorUbigeo(String vcoddep,String vcodpro,String vcoddis) throws Exception;
	
	public VstIntendenRegionales getIntendenciaSIITPorCodigo(String nNumdep) throws Exception;
}
