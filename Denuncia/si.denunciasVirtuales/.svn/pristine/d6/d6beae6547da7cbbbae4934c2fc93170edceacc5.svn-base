package pe.gob.sunafil.denunciavirtual.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import pe.gob.sunafil.denunciavirtual.funciones.Funciones;
import pe.gob.sunafil.denunciavirtual.utils.FacesUtils;
import pe.gob.sunafil.denunciavirtual.utils.Utilitarios;

@ManagedBean(name="pantallaIncioBean")
@SessionScoped
public class PantallaInicioBean {
	
	private static Logger logger = Logger.getLogger(PantallaInicioBean.class.getName());
	
	//RUTA UBICACION DE LA GUIA DE USUARIO
	private String destination= Funciones.ObtProp_Resources("ubicacion.guia");
	
	/**
	 * Constructor
	 */
	public PantallaInicioBean() {
		inicializar();
	}
	
	/**
	 * Metodo para inicializar los valores
	 */
	@SuppressWarnings("rawtypes")
	public void inicializar(){
		logger.info("Inicializando Bean de Pantalla de Inicio");
	}
	
	/**
	 * Metodo que nos lleva al Formulario de Registro del Libro de Reclamaciones
	 * @return vista
	 */
	public String toRegistroLibro(){
		logger.info("Ingresando al formulario de Libro de Reclamaciones");
		FacesUtils.removeSessionAttribute("libroBean");
		return "pretty:registroLibro";
	}
	
	/**
	 * Metodo que muestra el PDF en otra pestaña del navegador.
	 * @throws Exception
	 */
	public void mostrarGuiaUsuario() throws Exception{
		logger.info("Mostrando la Guia de Usuario");
		FacesUtils.mostrarPDF(destination, "MANUAL_O_GUIA_DEL_USUARIO.pdf");
	}
	
	/**
	 * Metodo Utilizado para cerrar sesion en el Sistema.
	 * @return
	 */
	public String salir(){
		logger.info("Terminando la Sesion");
		Utilitarios.terminarSesion();
		return "pretty:salir";
	}

}
