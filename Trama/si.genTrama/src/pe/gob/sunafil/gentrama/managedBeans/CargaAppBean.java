package pe.gob.sunafil.gentrama.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gentrama.bean.Usuario;
import pe.gob.sunafil.gentrama.funciones.Funciones;
import pe.gob.sunafil.gentrama.mybatis.interfase.INTLogueo;
import pe.gob.sunafil.gentrama.utils.FacesUtils;

@ManagedBean(name="cargaAppBean")
@SessionScoped
public class CargaAppBean implements Serializable {

	private static final long serialVersionUID = 4672776344360694163L;
	private static Logger logger = Logger.getLogger(CargaAppBean.class.getName());
	
	private String tamano;
	private String sistema;
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
		 String salida="pretty:login";
	        try{
	        	boolean haysesion = FacesUtils.existeUsuarioLogueado();
	        	if(haysesion){
	        		System.out.println("AUN HAY SESION DE USUARIO, NO SE VUELVE A CARGAR NADA");
	        		salida="pretty:inicio";
	        	}else{
	        		System.out.println("INGRESO POR PRIMERA VEZ, SE VA A CARGAR DATOS INICIALES DE SESION");
	        		sistema = Funciones.ObtieneProperty("pe.gob.sunafil.gentrama.util.properties.sunafil_app","sunafil.framework.sistema");
		            tamano = Funciones.ObtieneProperty("pe.gob.sunafil.gentrama.util.properties.sunafil_app","sunafil.framework.pagina.tamano");
		            seguridad = Funciones.ObtieneProperty("pe.gob.sunafil.gentrama.util.properties.sunafil_app","sunafil.framework.seguridad");        
	
		            if(tamano.trim().equals("%")){tamano = "100%";}else{tamano="1050";}
	
		            
		            logger.info("Tamano Pagina => "+tamano);
		            logger.info("Seguridad => "+seguridad);	 
		            logger.info("Sistema => "+sistema);	 
		            
		            //Instacia el Despachador para hacer uso de la clase
		            //LoginDespatch loginDespatch = new LoginDespatch();
		            //Obtiene la Fecha del Servidor
		            //s_fecha = loginDespatch.ObtieneFecha();
		            
		            s_fecha=iNTLogueo.ObtieneFecha();//Con Spring
		            logger.info("FECHA = >"+s_fecha);
		            FacesUtils.setSessionAttribute("tamano",tamano);
		          
		            //******************************************
		            //PARA CONTROLAR LA SESSION DEL USUARIO
		            //******************************************
		            /*Usuario usuario = new Usuario();
		            usuario.setV_codusu("USU_EXTERNO");
		            FacesUtils.setUsuarioLogueado(usuario);*/
	        	}
	        	
	        } catch (Exception e) {
	           logger.error(e.getMessage(),e);
	        }
	        
	        return salida;
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


	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	
}
