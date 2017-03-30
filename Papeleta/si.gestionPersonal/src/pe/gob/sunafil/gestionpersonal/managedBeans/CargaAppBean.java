package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.LoginDespatch;
import pe.gob.sunafil.gestionpersonal.utils.FacesUtils;




@ManagedBean(name="cargaAppBean")
@SessionScoped
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
	
	
	
	public void CargaApp(){
		
		 //depurador.info("-- Load App --");

	        try{
	            sistema = Funciones.ObtieneProperty("pe.gob.sunafil.gestionpersonal.util.properties.mtpe_app","mtpe.framework.sistema");
	            tamano = Funciones.ObtieneProperty("pe.gob.sunafil.gestionpersonal.util.properties.mtpe_app","mtpe.framework.pagina.tamano");
	            menu = Funciones.ObtieneProperty("pe.gob.sunafil.gestionpersonal.util.properties.mtpe_app","mtpe.framework.menu");
	            seguridad = Funciones.ObtieneProperty("pe.gob.sunafil.gestionpersonal.util.properties.mtpe_app","mtpe.framework.seguridad");        

	            if(tamano.trim().equals("%")){tamano = "100%";}else{tamano="1050";}

	            System.out.println("Sistema => "+sistema);
	            System.out.println("Tamano Pagina => "+tamano);
	            System.out.println("Menu => "+menu);
	            System.out.println("Seguridad => "+seguridad);	             
	            
	            //Instacia el Despachador para hacer uso de la clase
	            LoginDespatch loginDespatch = new LoginDespatch();
	            //Obtiene la Fecha del Servidor
	            s_fecha = loginDespatch.ObtieneFecha();
	            System.out.println("FECHA = >"+s_fecha);
	            FacesUtils.setSessionAttribute("tamano",tamano);
	          
	            
	            
	        } catch (Exception e) {	          
	           e.printStackTrace();
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
