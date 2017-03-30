package pe.gob.mtpe.retorno.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.gob.mtpe.retorno.bean.Departamento;
import pe.gob.mtpe.retorno.bean.Discapacidad;
import pe.gob.mtpe.retorno.bean.Distrito;
import pe.gob.mtpe.retorno.bean.Niveleducati;
import pe.gob.mtpe.retorno.bean.Ocupacion;
import pe.gob.mtpe.retorno.bean.Pais;
import pe.gob.mtpe.retorno.bean.ParamBus;
import pe.gob.mtpe.retorno.bean.Profesion;
import pe.gob.mtpe.retorno.bean.Provincia;
import pe.gob.mtpe.retorno.bean.Tdocide;

public interface ComunDao {

	public List<Ocupacion> 		buscarOcupacion(@Param("paramBus") ParamBus paramBus)
								throws Exception;	
	public List<Profesion> 		buscarProfesion(@Param("paramBus") ParamBus paramBus)
								throws Exception;	
	public List<Tdocide> 		listarTipoDocumento() throws Exception;	
	public List<Departamento> 	ListaDepartamentos()throws Exception;
	public List<Provincia> 		ListaProvincias(@Param("departamento") Departamento departamento) 
								throws Exception;
	public List<Distrito> 		ListaDistritos(@Param("provincia") Provincia provincia) 
								throws Exception;
	public List<Pais>			listaPais() throws Exception;
	public List<Discapacidad>   listaDiscapacidad() throws Exception;
	public List<Niveleducati>   listarNivelEducativo() throws Exception ;
	
	
}
