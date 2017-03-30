package pe.gob.sunafil.gentrama.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gentrama.bean.Permisos;
import pe.gob.sunafil.gentrama.bean.Usuario;
import pe.gob.sunafil.gentrama.facade.LoginFacade;
import pe.gob.sunafil.gentrama.funciones.Funciones;
import pe.gob.sunafil.gentrama.mybatis.despachadores.LoginDespatch;
import pe.gob.sunafil.gentrama.mybatis.despachadores.SeguridadDespatch;
import pe.gob.sunafil.gentrama.utils.FacesUtils;


@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginBean.class.getName());
	
	private String     estadoLog;
	
	private Usuario usuario;
	
	//@ManagedProperty(value="#{cargaAppBean.sistema}")
	private String sistema;
	
	private Usuario  PGP_Usuario;
	private Permisos PGP_Permisos;
	private String indicadorMenu;
	
	public LoginBean(){
		inicializar();
	}
	
	
	/**
	 * Metodo que Inicializa el Bean:
	 */
	private void inicializar(){		
		usuario=new Usuario();
		PGP_Permisos=new Permisos();
		PGP_Usuario=new Usuario();
		sistema = Funciones.ObtieneProperty("pe.gob.sunafil.gentrama.util.properties.sunafil_app","sunafil.framework.sistema");
	}
	
	
	
	/**
	 * Metodo de Logueo al Sistema
	 * @return String vista (del pretty-config)
	 */
	public String Login(){
		String vista = "pretty:inicio";		
    	boolean correcto;
		try {
			SeguridadDespatch objSeguridad = new SeguridadDespatch();
		
			//CONVERTIMOS A MAYUSCULA EL USUARIO PASADO: 
            usuario.setV_usuario(usuario.getV_usuario().toUpperCase());
            
            //CASTEAMOS EL FORMULARIO RECIBIDO:
            Usuario loginForm = usuario;        
           
            //INSTACIAMOS EL DESPACHADOR PARA HACER USO DE LA CLASE
            LoginDespatch loginDespatch = new LoginDespatch();
             
            //VALIDAMOS SI EXISTE EL USUARIO
            Usuario usuarioBean = loginDespatch.ValidaLogueo(loginForm);            
            if(usuarioBean == null){
                FacesUtils.showFacesMessage("El Usuario no existe.", 1);              
                return "";
            }
         
            //SETEAMOS EL USUARIO:
            usuarioBean.setV_usuario(loginForm.getV_usuario());
            
            //INSERTAMOS EL CODIGO DE SISTEMA AL USUARIOBEAN
            usuarioBean.setV_codsis(sistema);
            System.out.println("sistema::::"+sistema);
            System.out.println("usuarioBean.getV_codusu::::"+usuarioBean.getV_codusu());
            //VERIFICAMOS EL ESTADO EL USUARIO LOGUEADO:
            Permisos permisosBean = null;
            if(usuarioBean.getV_flgact().trim().equals("N") || usuarioBean.getV_flgact().trim().equals("E")){
               FacesUtils.showFacesMessage("El Usuario Ingresado se encuentra Inactivo.", 1);               
               return "";
            }else{
            //VERIFICAMOS SI TIENE PERMISO DE INGRESAR AL SISTEMA
                permisosBean = loginDespatch.ObtienePermisos(usuarioBean);                
                if(permisosBean == null){
                  FacesUtils.showFacesMessage("El Usuario no cuenta con los Permisos para ingresar a este Sistema.", 1);                
                  return "";
                }
            }
          
            //*********************************************************************/
			//*********** 			GESTIONAMOS LAS CONTRASEÑAS			  *********/
			//         VERIFICAMOS AHORA QUE SU CONTRASEÑA SEA LA CORRECTA        */
			//*********************************************************************/
           
            //VERIFICAMOS SI EL PASSWORD ES CORRECTO
			correcto = LoginFacade.GestionPassword(loginForm,usuarioBean);
			if (!correcto) {
				FacesUtils.showFacesMessage("La Contrasena ingresada es Incorrecta.", 1);				
				 return "";
			}
			
			//CARGAMOS EL HOST DESDE EL CUAL INGRESA AL SISTEMA EL USUARIO:            
            String v_hostreg="" +FacesUtils.getIpAddress();
            usuarioBean.setV_hostreg(v_hostreg);
			
			//ES NECESARIO LLENAR ESTE OBJETO AQUI PARA QUE FUNCIONE CUANDO EL SISTEMA 
			//TE OBLIGA  CAMBIAR LA CONTRASEÑA POR NUEVO O CADUCIDAD:
			PGP_Usuario=usuarioBean;
			logger.info("****=> usuario.v_codusu"+usuario.v_usuario);
			
			//EN CASO DE QUE EL USUARIO SEA NUEVO
			if (objSeguridad.retornaFlgNuevo(usuarioBean).equals("S")) {			
				FacesUtils.showFacesMessage("Usted ingresá por primera vez al sistema, por razones de seguridad debe cambiar su contraseña. RECUERDE no revelar su contraseña a nadie.",2);
				return "pretty:NewContrasena";
			}
			
			//SI EL USUARIO NO HA ACTUALIZADO SU CLAVE EN 4 MESES O MÁS:
			double cantidadMeses = Double.parseDouble(
									objSeguridad.retornaMeses(
										objSeguridad.retornaFechaUltActualizacion(usuarioBean).substring(0, 10)));
			int cantidadMesesCaduca = Integer.parseInt(objSeguridad.retornaMesesValidacion());

			String diasParaCaduqueFecha = objSeguridad.retornaDiasCaducaFecha(usuarioBean);
			String diasNoActualizacion = objSeguridad.retornaDiasNoActualizaFecha(usuarioBean);
			Integer intDiasParaCaduqueFecha = Integer.parseInt(diasParaCaduqueFecha);
			Integer intDiasNoActualizacion = Integer.parseInt(diasNoActualizacion);
			
			//VEMOS SI ESTA POR CADUCAR SU CONTRASEÑA EN 5 DÍAS
			if (intDiasParaCaduqueFecha > intDiasNoActualizacion) {
				if (intDiasParaCaduqueFecha - intDiasNoActualizacion <= 5) {
					FacesUtils.showFacesMessage("Por razones de seguridad, su contraseña expirará dentro de "+
												(intDiasParaCaduqueFecha - intDiasNoActualizacion)+
												" día(s), por lo que deberá cambiarla antes de la fecha de expiración.", 2);	
                 		 
				}

			}
			
			logger.info("intDiasParaCaduqueFecha " + intDiasParaCaduqueFecha);
			logger.info("intDiasNoActualizacion " + intDiasNoActualizacion);
			logger.info("cantidadMeses " + cantidadMeses);
			logger.info("cantidadMesesCaduca " + cantidadMesesCaduca);
			
			//SI PASO LA CANTIDAD DE MESES LO ENVIAMOS A CAMBIAR SU CONTRASEÑA:
			if (cantidadMeses >= cantidadMesesCaduca) {				
				FacesUtils.showFacesMessage("Su contraseña no ha sido actualizada en cuatro meses o más, por favor actualícela. RECUERDE no revelar su contraseña a nadie.", 2);
 				return "pretty:NewContrasena";
			}
			//*********************************************************************/
			//**************   FIN DE GESTIONAMOS LAS CONTRASEÑAS  ****************/
			//*********************************************************************/
            
			//CARGANDO LOS PERMISOS:
            PGP_Permisos=permisosBean;
            
//            //CARGANDO EL MENU DEL SISTEMA:
//            PGP_MenuHijo = loginDespatch.ObtieneMenuHijo(usuarioBean);  
//            PGP_MenuPadre  = loginDespatch.ObtieneMenuPadre(usuarioBean, permisosBean);              
            
            //******************************************
            //PARA CONTROLAR LA SESSION DEL USUARIO
            //******************************************
            FacesUtils.setUsuarioLogueado(PGP_Usuario);
            
            System.out.println("llego al final");
           
		} catch (Exception e) {
			
			return null;
        }
		return  vista;
	
	}
	
	
	/**=====================================================get set=================================================================================*/

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getSistema() {
		return sistema;
	}
	
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}

	public Permisos getPGP_Permisos() {
		return PGP_Permisos;
	}

	public void setPGP_Permisos(Permisos pGP_Permisos) {
		PGP_Permisos = pGP_Permisos;
	}

	public String getEstadoLog() {
		return estadoLog;
	}

	public void setEstadoLog(String estadoLog) {
		this.estadoLog = estadoLog;
	}


	public String getIndicadorMenu() {
		return indicadorMenu;
	}

	public void setIndicadorMenu(String indicadorMenu) {
		this.indicadorMenu = indicadorMenu;
	}


}
