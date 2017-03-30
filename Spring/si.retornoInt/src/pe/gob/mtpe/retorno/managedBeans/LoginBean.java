package pe.gob.mtpe.retorno.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mtpe.retorno.bean.MenuHijo;
import pe.gob.mtpe.retorno.bean.MenuPadre;
import pe.gob.mtpe.retorno.bean.Permisos;
import pe.gob.mtpe.retorno.bean.Usuario;
import pe.gob.mtpe.retorno.despachadores.LoginDespatch;
import pe.gob.mtpe.retorno.facade.LoginFacade;
import pe.gob.mtpe.retorno.service.SeguridadService;
import pe.gob.mtpe.retorno.utils.FacesUtils;

@Controller
@Scope("session")
public class LoginBean implements Serializable {

	/**
	 * Clase en donde se cargan los Parametros Globales del Framework. Esta
	 * clase de valida los datos del Usuario que esta Ingresado y recopila la
	 * informacion necesaria del Usuario dentro del aplicativo.
	 */
	private static final long serialVersionUID = 1329010889751268286L;
	private static Logger depurador = Logger.getLogger(LoginBean.class);

	

	@Autowired
	private SeguridadService seguridadService;
	
	@Autowired
	private LoginDespatch loginDespatch;

	private Usuario usuario;	
	private String sistema;

	private Usuario PGP_Usuario;
	private Permisos PGP_Permisos;
	private List<MenuPadre> PGP_MenuPadre;
	private List<MenuHijo> PGP_MenuHijo;
	private String indicadorMenu;

	private static Logger logger = Logger.getLogger(LoginBean.class.getName());

	public LoginBean() {
		usuario = new Usuario();
	}
	
	/*public String Login() {
		String vista = "pretty:administracion";

		return vista;

	}
*/

	//cambiar a Login sin prod
	@SuppressWarnings("unchecked")
	public String Login() {		
		String vista = "pretty:principal";
		boolean correcto;

		try {
			
			
			
			// DECLARAMOS LOS  ERRORS

			// CONVERTIMOS A MAYUSCULA EL USUARIO PASADO
			usuario.setV_usuario(usuario.getV_usuario().toUpperCase());
			// CASTEAMOS EL FORMULARIO RECIBIDO POR EL JSP
			Usuario loginForm = usuario;

			

			// VALIDAMOS SI EXISTE EL USUARIO
			Usuario usuarioBean = loginDespatch.ValidaLogueo(loginForm);
			if (usuarioBean == null) {
				FacesUtils.showFacesMessage("El Usuario no existe.", 1);
				return "";
			}
			
			usuarioBean.setV_usuario(loginForm.getV_usuario());			
			sistema=FacesUtils.getSessionAttribute("sistema").toString();
			// INSERTMOS EL CODIGO DE SISTEMA AL USUARIOBEAN
			usuarioBean.setV_codsis(sistema);
			// VERIFICAMOS EL ESTADO EL USUARIO LOGUEADO
			Permisos permisosBean = null;
			if (usuarioBean.getV_flgact().trim().equals("N") || usuarioBean.getV_flgact().trim().equals("E")) {
				FacesUtils.showFacesMessage("El Usuario Ingresado se encuentra Inactivo.", 1);
				return "";
			} else {
				// VERIFICAMOS SI TIENE PERMISO DE INGRESAR AL SISTEMA
				permisosBean = loginDespatch.ObtienePermisos(usuarioBean);
				if (permisosBean == null) {
					FacesUtils.showFacesMessage("El Usuario no cuenta con los Permisos para ingresar a este Sistema.",1);
					return "";
				}
			}

			// *********************************************************************/
			// *********** GESTIONAMOS LAS CONTRASEñAS *********/
			// VERIFICAMOS AHORA QUE SU CONTRASEñA SEA LA CORRECTA */
			// *********************************************************************/

			// VERIFICAMOS SI EL PASSWORD ES CORRECTO
			correcto = LoginFacade.GestionPassword(loginForm, usuarioBean);
			if (!correcto) {
				FacesUtils.showFacesMessage("La Contrasena ingresada es Incorrecta.", 1);
				return "";
			}
			// eS NECESARIO LLENAR ESTE OBJETO AQUI PARA QUE FUNCIONE CUANDO EL
			// SISTEMA TE OBLIGA CAMBIAR LA CONTRASEñA
			// CARGAMOS EL HOST DESDE EL CUAL INGRESA AL SISTEMA EL USUARIO:

			String v_hostreg = "" + FacesUtils.getIpAddress();
			usuarioBean.setV_hostreg(v_hostreg);

			PGP_Usuario = usuarioBean;	
			FacesUtils.setSessionAttribute("PGP_Usuario", PGP_Usuario);			
			// EN CASO DE QUE EL USUARIO SEA NUEVO
			if (seguridadService.retornaFlgNuevo(usuarioBean).equals("S")) {
				FacesUtils.showFacesMessage(
						"Usted ingresó por primera vez al sistema, por razones de seguridad debe cambiar su contraseña. RECUERDE no revelar su contraseña a nadie.",
						2);

				return "pretty:NewContrasena";
			}

			// SI EL USUARIO NO HA ACTUALIZADO SU CLAVE EN 4 MESES O MÁS:
			double cantidadMeses = Double.parseDouble(seguridadService
					.retornaMeses(seguridadService.retornaFechaUltActualizacion(usuarioBean).substring(0, 10)));
			int cantidadMesesCaduca = Integer.parseInt(seguridadService.retornaMesesValidacion());

			String diasParaCaduqueFecha = seguridadService.retornaDiasCaducaFecha(usuarioBean);
			String diasNoActualizacion = seguridadService.retornaDiasNoActualizaFecha(usuarioBean);
			Integer intDiasParaCaduqueFecha = Integer.parseInt(diasParaCaduqueFecha);
			Integer intDiasNoActualizacion = Integer.parseInt(diasNoActualizacion);

			// VEMOS SI ESTA POR CADUCAR SU CONTRASEñA EN 5 DíAS
			if (intDiasParaCaduqueFecha > intDiasNoActualizacion) {
				if (intDiasParaCaduqueFecha - intDiasNoActualizacion <= 5) {
					FacesUtils.showFacesMessage("Por razones de seguridad, su contraseña expiraró dentro de "
							+ (intDiasParaCaduqueFecha - intDiasNoActualizacion)
							+ " día(s), por lo que deberá cambiarla antes de la fecha de expiración.", 2);

				}

			}

			// SI PASO LA CANTIDAD DE MESES LO ENVIAMOS A CAMBIAR SU CONTRASEÑA:
			if (cantidadMeses >= cantidadMesesCaduca) {
				FacesUtils.showFacesMessage(
						"Su contraseña no ha sido actualizada en cuatro meses o años, por favor actualícela. RECUERDE no revelar su contraseña a nadie.",
						2);

				return "pretty:NewContrasena";
			}
			// *********************************************************************/
			// ************** FIN DE GESTIONAMOS LAS CONTRASEñAS
			// ****************/
			// *********************************************************************/

			// CARGANDO EL MENU DEL SISTEMA:

			PGP_Permisos = permisosBean;

			//

			PGP_MenuHijo = loginDespatch.ObtieneMenuHijo(usuarioBean);
			PGP_MenuPadre = loginDespatch.ObtieneMenuPadre(usuarioBean, permisosBean);
			FacesUtils.setSessionAttribute("PGP_MenuPadre", PGP_MenuPadre);
			FacesUtils.setSessionAttribute("PGP_MenuHijo", PGP_MenuHijo);
			
			

			// PGP_Usuario=usuarioBean;
			PGP_Permisos = permisosBean;			
			FacesUtils.setSessionAttribute("PGP_Permisos", PGP_Permisos);
			

		} catch (Exception e) {
			logger.error("Error", e);
			return null;
		}
		return vista;

	}

	public String formularioRetorno() {
		String vista = "pretty:retorno";

		return vista;

	}

	public String salir() {
		String vista = "";
		vista = "pretty:login";
		return vista;
	}

	/**
	 * @ZONA DE GET Y SET
	 */

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

	public List<MenuPadre> getPGP_MenuPadre() {
		return PGP_MenuPadre;
	}

	public void setPGP_MenuPadre(List<MenuPadre> pGP_MenuPadre) {
		PGP_MenuPadre = pGP_MenuPadre;
	}

	public List<MenuHijo> getPGP_MenuHijo() {
		return PGP_MenuHijo;
	}

	public void setPGP_MenuHijo(List<MenuHijo> pGP_MenuHijo) {
		PGP_MenuHijo = pGP_MenuHijo;
	}

	public String getIndicadorMenu() {
		return indicadorMenu;
	}

	public void setIndicadorMenu(String indicadorMenu) {
		this.indicadorMenu = indicadorMenu;
	}
}
