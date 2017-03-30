package pe.gob.mtpe.retorno.dao;

import org.apache.ibatis.annotations.Param;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Distrito;
import pe.gob.mtpe.retorno.bean.Persona;

public interface PersonaDao {
	
	public Persona  buscarPersona(@Param("persona") DPersona persona) throws Exception;
	public Integer  consultaNumeroPersonas(DPersona persona) throws Exception;
	public void     actualizarPersona(Persona persona) throws Exception;
	public void     insertPersona(Persona persona) throws Exception;
	public String   verificaActuPersonaReniec(Persona persona)throws Exception;
	public Distrito obtieneDistritoNacimiento(Distrito distrito)throws Exception;

}
