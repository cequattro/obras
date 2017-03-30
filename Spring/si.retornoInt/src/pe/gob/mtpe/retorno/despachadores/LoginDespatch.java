package pe.gob.mtpe.retorno.despachadores;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import pe.gob.mtpe.retorno.bean.Permisos;
import pe.gob.mtpe.retorno.bean.Usuario;
import pe.gob.mtpe.retorno.service.LogeoService;
import pe.gob.mtpe.retorno.service.impl.LogeoServiceImpl;

/**
 * Capa Intermedia para la Implementacion de los Métodos del DAO ( Interfase y
 * Implentación)
 */

@Component
public class LoginDespatch {

	private static Logger depurador = Logger.getLogger(LoginDespatch.class);

	@Autowired
	private LogeoService logeoService;

	public LoginDespatch() {
		// logeoService=new LogeoServiceImpl();
	}

	/**
	 * Declaracion de la instancia de la clase e instancia la Clase DAO (
	 * Interfase )
	 */

	/**
	 * Metodo que implementa la Validación del Usuario logueado al Sistema.
	 * 
	 * @return UsuarioBean, bean con todos los datos del Usuario Logueado.
	 * @param loginForm
	 *            Formulario del Logueo.
	 * @throws java.lang.Exception
	 */
	public Usuario ValidaLogueo(Usuario loginForm) throws Exception {

		depurador.info("Obteniendo el usuario del logueo");

		// Valida el usuario logueado

		List lUsuario = logeoService.ValidaLogueo(loginForm);

		Usuario usuarioBean = null;

		// Verifica si la consulta devuelve al usuario logueado
		if (lUsuario.size() == 0) {
			// usuario no existe
			depurador.info("Usuario no existe. BeanUsuario = null");
			usuarioBean = null;
		} else {
			// usuario existe
			depurador.info("Pasando la Informacion al BeanUsuario");
			usuarioBean = new Usuario();
			// traspaso de los datos encontrados al UsuarioBean
			usuarioBean = ((Usuario) lUsuario.get(0));
			depurador.info(usuarioBean);
		}

		return usuarioBean;

	}

	/**
	 * Metodo que implementa la Validación del Usuario logueado al Sistema.
	 * 
	 * @return UsuarioBean, bean con todos los datos del Usuario Logueado.
	 * @param usuarioBean
	 *            UsuarioBean, bean con todos los datos del Usuario Logueado.
	 * @throws java.lang.Exception
	 */
	public Permisos ObtienePermisos(Usuario usuarioBean) throws Exception {

		depurador.info("Obteniendo el usuario del logueo");

		// Valida el usuario logueado
		List lPermisos = logeoService.ObtienePermisos(usuarioBean);
		Permisos permisosBean = null;

		// Verifica si la consulta devuelve al usuario logueado
		if (lPermisos.size() == 0) {
			// usuario no existe
			depurador.info("Usuario no tiene Permisos para acceder al Sistema existe. PermisosBean = null");
			usuarioBean = null;
		} else {
			// usuario existe
			depurador.info("Pasando la Informacion al PermisosBean");
			permisosBean = new Permisos();
			// traspaso de los datos encontrados al UsuarioBean
			permisosBean = ((Permisos) lPermisos.get(0));
			depurador.info(permisosBean);
		}

		return permisosBean;

	}

	/**
	 * Metodo que obtiene la lista del Menu Padre.
	 * 
	 * @return UsuarioBean, bean con todos los datos del Usuario Logueado.
	 * @param usuarioBean
	 *            UsuarioBean, bean con todos los datos del Usuario Logueado.
	 * @param permisosBean
	 *            PermisosBean, bean con todos los datos de los permisos del
	 *            Usuario Logueado.
	 * @throws java.lang.Exception
	 */
	public List ObtieneMenuPadre(Usuario usuarioBean, Permisos permisosBean) throws Exception {

		depurador.info("Obteniendo el MenuPadre");

		// Valida el usuario logueado
		List lMenuPadre = logeoService.ObtieneMenuPadre(usuarioBean, permisosBean);
		// depurador.info(lMenuPadre.size());
		lMenuPadre.size();
		return lMenuPadre;

	}

	/**
	 * Metodo que obtiene la lista del Menu Hijo.
	 * 
	 * @return UsuarioBean, bean con todos los datos del Usuario Logueado.
	 * @param usuarioBean
	 *            UsuarioBean, bean con todos los datos del Usuario Logueado.
	 * @throws java.lang.Exception
	 */
	public List ObtieneMenuHijo(Usuario usuarioBean) throws Exception {

		depurador.info("Obteniendo el MenuHijo");

		// Valida el usuario logueado
		List lMenuHIjo = logeoService.ObtieneMenuHijo(usuarioBean);

		return lMenuHIjo;

	}

	/**
	 * Metodo que obtiene la fecha de la base de datos.
	 * 
	 * @return String, con la Fecha formateada
	 */
	public String ObtieneFecha() throws Exception {
		depurador.info("ObtieneFecha");
		String fecha = logeoService.ObtieneFecha();
		return fecha;
	}

}
