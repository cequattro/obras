package pe.gob.mtpe.retorno.service;

import java.util.List;

import pe.gob.mtpe.retorno.bean.Permisos;
import pe.gob.mtpe.retorno.bean.Usuario;

public interface LogeoService {
	
	/**
	 * Metodo que valida al usuario en el Logeo
	 * @param  mensaje Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Usuario Usuario}
	 * @throws Exception-Excepcion general 	 */	
	public List 	ValidaLogueo(Usuario loginForm) throws Exception;
	
	/**
	 * Metodo que obtiene los permisos del Usuario en el Logeo
	 * @param  mensaje Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Usuario Usuario}
	 * @throws Exception-Excepcion general 	 */	
	public List 	ObtienePermisos(Usuario usuarioBean) throws Exception;
	
	/**
	 * Metodo que obtiene el Menu Hijo del Usuario en el Logeo
	 * @param  mensaje Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Usuario Usuario}
	 * @throws Exception-Excepcion general 	 */	
	public List 	ObtieneMenuHijo(Usuario usuarioBean) throws Exception;
	
	/**
	 * Metodo que obtiene el Menu Padre del Usuario en el Logeo
	 * @param  mensaje Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Usuario Usuario}
	 * @throws Exception-Excepcion general 	 */	
	public List 	ObtieneMenuPadre(Usuario usuarioBean, Permisos permisosBean) throws Exception;
	
	/**
	 * Metodo que obtiene la fecha de ingreso del Usuario en el Logeo
	 * @param  mensaje Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Usuario Usuario}
	 * @throws Exception-Excepcion general 	 */	
	public String 	ObtieneFecha() throws Exception;

}
