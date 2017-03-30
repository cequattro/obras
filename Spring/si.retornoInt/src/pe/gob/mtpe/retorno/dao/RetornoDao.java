package pe.gob.mtpe.retorno.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Familia;
import pe.gob.mtpe.retorno.bean.ParamAdmRetorno;
import pe.gob.mtpe.retorno.bean.Rango;
import pe.gob.mtpe.retorno.bean.Retorno;

public interface RetornoDao {
	
	public List<Retorno> listarMotivos() throws Exception;
	public void insertardPersona(@Param("dPersona") DPersona dPersona) throws Exception;
	public List<Rango> listarRango(@Param("pRango") Rango pRango) throws Exception;
	public void insertaFamilia(Familia familia ) throws Exception;
	public void eliminarFamilia(DPersona dPersona) throws Exception;
	public void eliminardPersona(DPersona dPersona) throws Exception;
	public Integer consultaNumeroRegistros(DPersona dPersona) throws Exception;
	public DPersona cargarDPersona(DPersona dpersona) throws Exception;
	public Retorno  CargarMotivoRetorno(DPersona dpersona) throws Exception;
	public List<Familia> cargarHijoRetorno(DPersona dpersona) throws Exception;
	public List<Map> listarAdmRetorno(ParamAdmRetorno paramAdmRetorno) throws  Exception;
	public List<Map> mostrarFicha(DPersona dpersona) throws Exception;
}
