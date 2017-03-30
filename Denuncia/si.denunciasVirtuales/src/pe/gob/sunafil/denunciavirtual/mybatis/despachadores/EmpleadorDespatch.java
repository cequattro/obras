package pe.gob.sunafil.denunciavirtual.mybatis.despachadores;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import pe.gob.sunafil.denunciavirtual.bean.Empresa;
import pe.gob.sunafil.denunciavirtual.mybatis.implementacion.IMPEmpleador;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTEmpleador;
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


public class EmpleadorDespatch {
private INTEmpleador empDao;
	
	public EmpleadorDespatch(){
		empDao=new IMPEmpleador();
	}
	
	public String verificarEmpMTPE(Empresa empresa) throws Exception {
		return empDao.verificarEmpMTPE(empresa);
	} 
	
	public DltbEmpleador getEmpleadorPorCodigo(String vCodemp) throws Exception{
		return empDao.getEmpleadorPorCodigo(vCodemp);
	}
	
	public SitbEmpleador getSitbEmpleadorPorRUC(String vCodemp) throws Exception{
		return empDao.getSitbEmpleadorPorRUC(vCodemp);
	}
	
	public int insertarEmpleador(DltbEmpleador entidad){
		return empDao.insertarEmpleador(entidad);
	}
	
	public List <String> getIntendenciasHabilitadasSIIT() throws Exception{
		return empDao.getIntendenciasHabilitadasSIIT();
	}
	
	public int obtieneNuevaSolicitud() {
		return empDao.obtieneNuevaSolicitud();
	}
	
	public int insertarSolicitud(DlmvSolicitud entidad){
		return empDao.insertarSolicitud(entidad);
	}
	
	public int actualizarSolicitud(DlmvSolicitud solicitud){
		return empDao.actualizarSolicitud(solicitud);
	}
	
	public List <SitbTipomoneda> getTipoMoneda() throws Exception{
		return empDao.getTipoMoneda();
	}
	
	public int actualizarArchivo(DlmvdDocxsol archivo) throws Exception{
		return empDao.actualizarArchivo(archivo);
	}
	
	public List <DltbcMateria> getMateria() throws Exception{
		return empDao.getMateria();
	}
	
	public String getCorrelativoSolicitud(String vAnhosol) throws Exception{
		return empDao.getCorrelativoSolicitud(vAnhosol);
	}
	
	public int insertarRegistro(TdmvcRegistro registro){
		return empDao.insertarRegistro(registro);
	}
	
	public TdtbcIntendencia getIntendenciaPorUbigeo(String vUbigeo) throws Exception{
		return empDao.getIntendenciaPorUbigeo(vUbigeo);
	}
	
	public TdtbcCorrelativo getCorrelativo(String vNumano, Short nNumdep, Short nNumtipodoc) throws Exception{
		return empDao.getCorrelativo(vNumano, nNumdep, nNumtipodoc);
	}
	
	public int actualizarCorrelativo(TdtbcCorrelativo correlativo) throws Exception{
		return empDao.actualizarCorrelativo(correlativo);
	}
	
	public int insertarCorrelativo(TdtbcCorrelativo correlativo) throws Exception{
		return empDao.insertarCorrelativo(correlativo);
	}
	
	public TdmvcHojarutaKey getCorrelativoGlobal(Short vAniohoja) throws Exception{
		return empDao.getCorrelativoGlobal(vAniohoja);
	}
	
	public void insertarCorrelativoGlobal(TdmvcHojarutaKey correlativoGlobal) throws Exception{
		empDao.insertarCorrelativoGlobal(correlativoGlobal);
	}
	
	public TdtbcEntidad getEntidadPorCodigo(String vCodentidad) throws Exception{
		return empDao.getEntidadPorCodigo(vCodentidad);
	}
	
	public int insertarEntidad(TdtbcEntidad entidad){
		return empDao.insertarEntidad(entidad);
	}
	
	public int actualizarEntidad(TdtbcEntidad entidad){
		return empDao.actualizarEntidad(entidad);
	}
	
	public Short getCorrelativoDireccionPorEntidad(String vCodentidad) throws Exception{
		return empDao.getCorrelativoDireccionPorEntidad(vCodentidad);
	}
	
	public int insertarDireccion(TdtbdCentrolab direccion){
		return empDao.insertarDireccion(direccion);
	}
	
	public DltbcMateria getMateriaPorCodigo(BigDecimal nCodmat) throws Exception{
		return empDao.getMateriaPorCodigo(nCodmat);
	}
	
	public SitbTipomoneda getMonedaPorCodigo(String vCodtmon) throws Exception{
		return empDao.getMonedaPorCodigo(vCodtmon);
	}
	
	public void insertarReporte(IltbcSoldenvirtual entidad) throws Exception{
		empDao.insertarReporte(entidad);
	}
	
	public String insertarRegistroEntradaSIIT(Map parametros) throws Exception{
		return empDao.insertarRegistroEntradaSIIT(parametros);
	}
	
	public SitbDepxdistrito getDependenciaSIITPorUbigeo(String vcoddep,String vcodpro,String vcoddis) throws Exception{
		return empDao.getDependenciaSIITPorUbigeo( vcoddep, vcodpro, vcoddis);
	}
	
	public VstIntendenRegionales getIntendenciaSIITPorCodigo(String nNumdep) throws Exception{
		return empDao.getIntendenciaSIITPorCodigo(nNumdep);
	}

}
