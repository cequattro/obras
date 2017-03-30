package pe.gob.mtpe.retorno.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.gob.mtpe.retorno.bean.Usuario;

public interface SeguridadDao {

	public List 	tresUltClavesEncriptadas(Usuario usuario) throws Exception;
	public String	esUsuarioNuevo(Usuario usuario) throws Exception;	
	public String	fechaUltActualizacion(Usuario usuario) throws Exception;	
	public String	diasCaducaFecha(Usuario usuario) throws Exception;	
	public String	diasNoActualizaFecha(Usuario usuario) throws Exception;	
	public String	numMeses(String valor) throws Exception;	
	public String	numMesValidacion() throws Exception;
	public void 	cambiarClave(Map parametros)throws Exception;
}
