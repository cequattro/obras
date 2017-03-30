package pe.gob.mtpe.retorno.dao;

import java.util.Map;

import pe.gob.mtpe.retorno.bean.MenuHijo;
import pe.gob.mtpe.retorno.bean.MenuPadre;
import pe.gob.mtpe.retorno.bean.Permisos;
import pe.gob.mtpe.retorno.bean.Usuario;

public interface LogeoDao {
	
	public Usuario 		obtieneUsuario(Map parametros) throws Exception;
	public Permisos 	obtienePermisos(Map parametros) throws Exception; 
	public MenuHijo 	obtieneMenuHijo(Map parametros) throws Exception;
	public MenuPadre 	obtieneMenuPadre(Map parametros) throws Exception;
	public String 		obtieneFecha() throws Exception;
}
