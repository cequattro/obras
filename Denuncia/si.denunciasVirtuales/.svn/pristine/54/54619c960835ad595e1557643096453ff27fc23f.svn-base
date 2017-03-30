package pe.gob.sunafil.denunciavirtual.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import pe.gob.sunafil.denunciavirtual.bean.Usuario;
import pe.gob.sunafil.denunciavirtual.funciones.Funciones;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTLogueo;
import pe.gob.sunafil.denunciavirtual.utils.FacesUtils;

@ManagedBean(name="cargaAppBean")
@SessionScoped
public class CargaAppBean implements Serializable {

	private static final long serialVersionUID = 4672776344360694163L;
	private static Logger logger = Logger.getLogger(CargaAppBean.class.getName());
	
	private String tamano;
	private String seguridad;
	private String s_fecha;
	
	@ManagedProperty(value="#{iMPLogueo}") // applicationContext.xml (SPRING)
	private INTLogueo iNTLogueo;	
	
	/**
	 * Metodo que carga los datos iniciales de la sesion asi como el usuariologueado para validarlo luego con el PhaseListener
	 * @return
	 */
	public String CargaApp(){
		
		 logger.info("-- Load App --");

	        try{
	        	boolean haysesion = FacesUtils.existeUsuarioLogueado();
	        	if(haysesion){
	        		System.out.println("AUN HAY SESION DE USUARIO, NO SE VUELVE A CARGAR NADA");
	        	}else{
	        		System.out.println("INGRESO POR PRIMERA VEZ, SE VA A CARGAR DATOS INICIALES DE SESION");

		            tamano = Funciones.ObtieneProperty("pe.gob.sunafil.denunciavirtual.util.properties.sunafil_app","sunafil.framework.pagina.tamano");
		            seguridad = Funciones.ObtieneProperty("pe.gob.sunafil.denunciavirtual.util.properties.sunafil_app","sunafil.framework.seguridad");        
	
		            if(tamano.trim().equals("%")){tamano = "100%";}else{tamano="1050";}
	
		            
		            logger.info("Tamano Pagina => "+tamano);
		            logger.info("Seguridad => "+seguridad);	             
		            
		            //Instacia el Despachador para hacer uso de la clase
		            //LoginDespatch loginDespatch = new LoginDespatch();
		            //Obtiene la Fecha del Servidor
		            //s_fecha = loginDespatch.ObtieneFecha();
		            
		            s_fecha		 =iNTLogueo.ObtieneFecha();//Con Spring
		            String v_fecActual	 =iNTLogueo.ObtieneFecActual();//Con Spring y formato string de fecha dd/mm/yyyy
		            String v_anhoActual =v_fecActual.substring(6, 10);
		            
		            logger.info("FECHA = >"+s_fecha);
		            logger.info("v_fecActual = >"+v_fecActual);
		            logger.info("v_anhoActual = >"+v_anhoActual);
		            FacesUtils.setSessionAttribute("tamano",tamano);
		            FacesUtils.setSessionAttribute("v_fecActual",v_fecActual);
		            FacesUtils.setSessionAttribute("v_anhoActual",v_anhoActual);
		          
		            //******************************************
		            //PARA CONTROLAR LA SESSION DEL USUARIO
		            //******************************************
		            Usuario usuario = new Usuario();
		            usuario.setV_codusu("USU_EXTERNO");
		            FacesUtils.setUsuarioLogueado(usuario);
	        	}
	        	
	        } catch (Exception e) {
	           logger.error(e.getMessage(),e);
	        }
	        
	        return "pretty:inicio";
	}

	
	/**
	 * @zona get y set 
	 * 
	 */
	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
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

	public INTLogueo getiNTLogueo() {
		return iNTLogueo;
	}


	public void setiNTLogueo(INTLogueo iNTLogueo) {
		this.iNTLogueo = iNTLogueo;
	}
	
}
