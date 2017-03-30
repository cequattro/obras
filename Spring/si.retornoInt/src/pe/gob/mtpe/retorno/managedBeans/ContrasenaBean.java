package pe.gob.mtpe.retorno.managedBeans;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mtpe.retorno.bean.Usuario;
import pe.gob.mtpe.retorno.despachadores.SeguridadDespatch;
import pe.gob.mtpe.retorno.util.funciones.Encriptar;
import pe.gob.mtpe.retorno.utils.FacesUtils;


@Controller
@Scope("session")
public class ContrasenaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1399767096675317993L;
	private static Logger depurador = Logger.getLogger(ContrasenaBean.class.getName());
	
	
	
	private Usuario  PGP_Usuario;
	
	private String clave;
	private String claveAntigua;
	private String claveRepeticion;
	@ManagedProperty("#{loginBean.indicadorMenu}")
	private String indicadorMenu;
	
	private String usuario;
	
	@Autowired
	private SeguridadDespatch objSeg;
	
	public String cambiarContrasena() throws Exception {
		try{
			depurador.info("clave "+claveAntigua);
			RequestContext context=RequestContext.getCurrentInstance();
			if(!clave.equals(null)){
				clave=clave.trim();
			}	
			
			//String clasClave=(String)request.getParameter("verdict");			
			Encriptar enc = new Encriptar();			
			Usuario objUsuario = ((Usuario)FacesUtils.getSessionAttribute("PGP_Usuario"));
			String forwardName = "pretty:contrasena";	
			HashMap map=new HashMap();
			String claveDesencriptada = "";
			
			List lista = objSeg.listaClavesDesencriptadas(objUsuario);			 
			boolean correcto=true;
			
			if(!claveAntigua.equals(enc.Desencriptar(objUsuario.getV_codusu(),objUsuario.getV_passusu()))){
				correcto=false;
				FacesUtils.showFacesMessage("La Contraseña Actual no es la Correcta.", 1);
				
			}
			
			if(!clave.equals(claveRepeticion)){
				correcto=false;
				FacesUtils.showFacesMessage("La confirmación de la contraseña no coincide. Por favor, asegúrese de que su contraseña y la confirmación de la contraseña sean iguales.", 1);
				
			}
			 
			if(clave.toUpperCase().equals(objUsuario.getV_codusu())){
				correcto=false;
				FacesUtils.showFacesMessage("La contraseña no puede ser igual al usuario.", 1);
				
			}			
			
			if(clave.equals(claveAntigua)){
				correcto=false;
				FacesUtils.showFacesMessage("No puede repetir la misma contraseña.", 1);
				
			}
			
			
			
			for (int i = 0; i < lista.size(); i++) {				 
				map = (HashMap) lista.get(i);				 
				claveDesencriptada = enc.Desencriptar(objUsuario.getV_codusu(),(String) map.get("pass"));
				//depurador.info("Password ["+(i+1)+"] => "+claveDesencriptada);
				// VALIDA SI LA NUEVA CLAVE SE HA UTILIZADO EN LAS 3 ULTIMAS
				// ACTUALIZACIONES
				 
				if (claveDesencriptada.equals(clave)) {
					
					if("S".equals(indicadorMenu)){
						indicadorMenu="S";
					}else{
						indicadorMenu="N";
					}
					
					usuario=objUsuario.getV_codusu();					
					
	
					if (lista.size() >= 3) {
						correcto=false;
						FacesUtils.showFacesMessage("La contraseña que usted intenta actualizar ya ha sido utilizada en sus tres últimas modificaciones.", 1);
					}
					if (lista.size() == 2) {
						correcto=false;
						FacesUtils.showFacesMessage("La contraseña que usted intenta actualizar ya ha sido utilizada en sus dos ultimas modificaciones.", 1);
					}
					if (lista.size() == 1) {
						correcto=false;
						FacesUtils.showFacesMessage("La contraseña que usted intenta actualizar ya ha sido asignada como temporal.", 1);
					}
					
	
					forwardName = "pretty:contrasena";
					if(correcto==false){
						context.addCallbackParam("correcto", correcto);
					}
					return forwardName;
				}
	
			}
			
			context.addCallbackParam("correcto", correcto);
			
			if(correcto==false){
				return "pretty:contrasena";
			}
			depurador.info("Contraseña nueva => "+clave);
			depurador.info("Contraseña nueva encriptada => "+enc.Encriptar(
					objUsuario.getV_codusu().trim(), clave));
			
			InetAddress local = InetAddress.getLocalHost();
			InetAddress inet2 = InetAddress.getByName("" + local.getHostAddress());
			String hostRegistra = inet2.getHostName();
			objSeg.cambiarClave(objUsuario.getV_codusu().trim(), enc.Encriptar(objUsuario.getV_codusu().trim(), clave), hostRegistra);			
			FacesUtils.showFacesMessage("Su contraseña ha sido actualizada exitosamente", 3);
			
			if(correcto==true){
				FacesUtils.removeUsuarioLogueado();
				forwardName="pretty:login";
				
			}
			return forwardName;
			
		} catch (Exception e) {
            depurador.error("Exception() : CambioContrasenaAction:muestra() : " + e);
            e.printStackTrace();
            return "pretty:contrasena";
            
            
        }
	}
	
	
	public void resetContrasena(){		
		RequestContext.getCurrentInstance().reset(":formContrasena:pgContrasena");		
	}

	/**
	 * @zona get set
	 * @return
	 */
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}

	public String getIndicadorMenu() {
		return indicadorMenu;
	}

	public void setIndicadorMenu(String indicadorMenu) {
		this.indicadorMenu = indicadorMenu;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClaveAntigua() {
		return claveAntigua;
	}

	public void setClaveAntigua(String claveAntigua) {
		this.claveAntigua = claveAntigua;
	}

	public String getClaveRepeticion() {
		return claveRepeticion;
	}

	public void setClaveRepeticion(String claveRepeticion) {
		this.claveRepeticion = claveRepeticion;
	}

	 
	
	
	

}
