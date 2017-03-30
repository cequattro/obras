package pe.gob.mtpe.retorno.service;

import java.util.List;

import pe.gob.mtpe.retorno.bean.Usuario;

public interface SeguridadService {
	
	/**
	 * Metodo que lista las claves Desencriptadas del Usuario
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Usuario Usuario}> Retorna lista de claves desencriptadas
	 * @throws Exception excepcion general
	 */
	public List 	listaClavesDesencriptadas(Usuario usuario) throws Exception;
	
	/**
	 * Metodo retorna el nuevo flag del Usuario
	 * @param usuario objeto de la clase {@link pe.gob.mtpe.retorno.bean.Usuario Usuario}	 * @return Retorna un Entero
	 * @throws Exception excepcion general
	 */
	public String 	retornaFlgNuevo(Usuario usua) throws Exception;
	
	/**
	 * Metodo retorna la fecha de actualizacion del Usuario
	 * @param usuario objeto de la clase {@link pe.gob.mtpe.retorno.bean.Usuario Usuario}	 * @return Retorna un Entero
	 * @throws Exception excepcion general
	 */
	public String 	retornaFechaUltActualizacion(Usuario usua)throws Exception;
	
	/**
	 * Metodo retorna los dias que caduca la cuenta del Usuario
	 * @param usuario objeto de la clase {@link pe.gob.mtpe.retorno.bean.Usuario Usuario}	 * @return Retorna un Entero
	 * @throws Exception excepcion general
	 */
	public String 	retornaDiasCaducaFecha(Usuario usua) throws Exception;
	
	
	/**
	 * Metodo retorna los dias no actualizadas de la fecha cuenta del Usuario
	 * @param usuario objeto de la clase {@link pe.gob.mtpe.retorno.bean.Usuario Usuario}	 * @return Retorna un Entero
	 * @throws Exception excepcion general
	 */
	public String 	retornaDiasNoActualizaFecha(Usuario usua)throws Exception;
	
	/**
	 * Metodo retorna el metodo de meses
	 * @throws Exception excepcion general
	 */
	public String 	retornaMeses(String valor) throws Exception;
	
	/**
	 * Metodo retorna el metodo de meses validados
	 * @throws Exception excepcion general
	 */
	public String 	retornaMesesValidacion() throws Exception;
	
	/**
	 * Metodo retorna el metodo para cambiar la clave del usuario
	 * @throws Exception excepcion general
	 */
	public void cambiarClave(String codUsu, String passUsu, String nomHost)throws  Exception;
}
