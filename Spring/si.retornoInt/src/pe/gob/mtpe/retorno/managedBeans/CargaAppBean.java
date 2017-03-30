package pe.gob.mtpe.retorno.managedBeans;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mtpe.retorno.despachadores.LoginDespatch;
import pe.gob.mtpe.retorno.service.LogeoService;
import pe.gob.mtpe.retorno.util.funciones.Encriptar;
import pe.gob.mtpe.retorno.util.funciones.Funciones;
import pe.gob.mtpe.retorno.utils.FacesUtils;

@Controller
@Scope("session")
public class CargaAppBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4672776344360694163L;

	private String sistema;
	private String tamano;
	private String menu;
	private String seguridad;
	private String s_fecha;
	private String ruta;
	 
	@Autowired
	private LoginDespatch loginDespatch;

	private static Logger depurador = Logger.getLogger(CargaAppBean.class);

	public void CargaApp() {

		// depurador.info("-- Load App --");

		try {
			ruta = Funciones.ObtieneProperty("pe.gob.mtpe.retorno.util.properties.mtpe_app","mtpe.framework.ruta");
			sistema=Funciones.leerPropertyExterno(ruta,"mtpe.framework.sistema");
			depurador.info("Sistema => " + sistema);
			// Instacia el Despachador para hacer uso de la clase sistema mtpe.framework.propiedades			
			// Obtiene la Fecha del Servidor
			s_fecha = loginDespatch.ObtieneFecha();
			depurador.info("FECHA = >" + s_fecha);			
			FacesUtils.setSessionAttribute("tamano", tamano);
			FacesUtils.setSessionAttribute("sistema", sistema);
			
		} catch (Exception e) {
			depurador.error("Error ", e);
		}
	}

	/**
	 * @zona get y set
	 * 
	 */

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(String seguridad) {
		this.seguridad = seguridad;
	}

	public String getS_fecha() {
		return s_fecha;
	}

	public void setS_fecha(String s_fecha) {
		this.s_fecha = s_fecha;
	}

}
