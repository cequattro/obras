package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.bean.MenuHijo;
import pe.gob.sunafil.gestionpersonal.bean.MenuPadre;
import pe.gob.sunafil.gestionpersonal.bean.Periodo;
import pe.gob.sunafil.gestionpersonal.bean.Permisos;
import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.facade.LoginFacade;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.LoginDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.SeguridadDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTLogin;
import pe.gob.sunafil.gestionpersonal.utils.FacesUtils;


@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginBean.class.getName());
	
	private String     estadoLog;
	
	private Usuario usuario;
	@ManagedProperty("#{cargaAppBean.sistema}")
	private String sistema;
	
	private Usuario  PGP_Usuario;
	private Permisos PGP_Permisos;
	private List<MenuPadre>	 PGP_MenuPadre;
	private List<MenuHijo>   PGP_MenuHijo;	
	private String indicadorMenu;
	
	@ManagedProperty(value="#{iMPLogin}") // applicationContext.xml (SPRING)
	private INTLogin iNTLogin;
	
	
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
		PGP_MenuPadre= new ArrayList<MenuPadre>();
		PGP_MenuHijo= new ArrayList<MenuHijo>();
	}
	
	
	
	/**
	 * Metodo de Logueo al Sistema
	 * @return String vista (del pretty-config)
	 */
	public String Login(){		
		String vista = "pretty:principal";		
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
            
            //CARGANDO EL MENU DEL SISTEMA:
            //temp
            PGP_MenuPadre=new ArrayList<MenuPadre>();
            PGP_MenuHijo=new ArrayList<MenuHijo>();
            
            /*MenuPadre enp=new MenuPadre();        
            enp.setN_orden("1");
            enp.setV_menu("Mantenimiento");
            enp.setMen_padre("350");
            enp.setV_icono("ico_padre.jpg");              
            PGP_MenuPadre.add(enp);
            
            enp=new MenuPadre();        
            enp.setN_orden("1");
            enp.setV_menu("Movimiento");
            enp.setMen_padre("351");
            enp.setV_icono("ico_padre.jpg");              
            PGP_MenuPadre.add(enp);
            
            enp=new MenuPadre();        
            enp.setN_orden("2");
            enp.setV_menu("Reportes");
            enp.setMen_padre("352");
            enp.setV_icono("ico_padre.jpg");            
            PGP_MenuPadre.add(enp);*/
            
            /*enp=new MenuPadre();        
            enp.setN_orden("2");
            enp.setV_menu("Bandeja de Documentos");
            enp.setMen_padre("351");
            enp.setV_icono("ico_padre.jpg");            
            PGP_MenuPadre.add(enp);
            
            enp=new MenuPadre();        
            enp.setN_orden("3");
            enp.setV_menu("Distribución");
            enp.setMen_padre("352");
            enp.setV_icono("ico_padre.jpg");
            PGP_MenuPadre.add(enp);
            
            enp=new MenuPadre();        
            enp.setN_orden("4");
            enp.setV_menu("Consulta");
            enp.setMen_padre("353");
            enp.setV_icono("ico_padre.jpg");
            PGP_MenuPadre.add(enp);
            
            enp=new MenuPadre();        
            enp.setN_orden("5");
            enp.setV_menu("Reportes");
            enp.setMen_padre("354");
            enp.setV_icono("ico_padre.jpg");            
            PGP_MenuPadre.add(enp);*/
            
            /*MenuHijo enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("350");
            enh.setV_desmen("Personal");
            enh.setV_url("#{personalBean.verPersonal(true)}");//doMantCedulas.do?method=inicio
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("350");
            enh.setV_desmen("Turno");
            enh.setV_url("#{turnoBean.nuevoTurno}");//doMantCedulas.do?method=inicio
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("351");
            enh.setV_desmen("Personal Por Turno");
            enh.setV_url("#{personalBean.verPersonalTurno(false)}");//doMantCedulas.do?method=inicio
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("351");
            enh.setV_desmen("Cargar Marcaciones");
            enh.setV_url("#{marcacionBean.verMarcacion}");//doMantCedulas.do?method=inicio
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("351");
            enh.setV_desmen("Marcaciones");
            enh.setV_url("#{marcacionBean.verJustificacion}");//doMantCedulas.do?method=inicio
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("352");
            enh.setV_desmen("Mis Marcaciones");
            enh.setV_url("#{misMarcacionesBean.verMarcacion}");//doMantCedulas.do?method=inicio
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("352");
            enh.setV_desmen("Marcaciones Personal");
            enh.setV_url("#{personalMarcacionBean.verMarcacion}");//doMantCedulas.do?method=inicio
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("352");
            enh.setV_desmen("De Personal");
            enh.setV_url("#{reporteBean.verRptPersonal}");
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);*/
            
            /*enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("351");
            enh.setV_desmen("Registrados");
            enh.setV_url("#{bandejaBean.bandejaRegistrados}");
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("351");
            enh.setV_desmen("Observados");
            enh.setV_url("#{bandejaBean.bandejaObservados}");
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("351");
            enh.setV_desmen("No Presentados");
            enh.setV_url("#{bandejaBean.bandejaNoPresentados}");
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("352");
            enh.setV_desmen("Generar Cargo");
            enh.setV_url("#{distribucionBean.genCargo}");
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("352");
            enh.setV_desmen("Histórico Cargo");
            enh.setV_url("#{menuBean.hisCargo}");
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("353");
            enh.setV_desmen("Búsqueda");
            enh.setV_url("#{consultaBean.busqueda}");
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("354");
            enh.setV_desmen("Por Procedimiento");//Reporte
            enh.setV_url("#{menuBean.reportePorProcedimiento}");
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);
            
            enh=new MenuHijo();
            enh.setN_nivel("2");
            enh.setV_codpad("354");
            enh.setV_desmen("Por Usuario");//Reporte
            enh.setV_url("#{menuBean.reportePorUsuario}");
            enh.setV_icono("ico_hijo.jpg");
            PGP_MenuHijo.add(enh);*/
                        
            
            //end temp
            //descomentar produccion
            PGP_MenuHijo = loginDespatch.ObtieneMenuHijo(usuarioBean);  
            PGP_MenuPadre  = loginDespatch.ObtieneMenuPadre(usuarioBean, permisosBean);
            //end descomentar producción
            
            //CARGANDO LOS PERMISOS:
            PGP_Permisos=permisosBean;
            System.out.println("llego al final");
           
		} catch (Exception e) {
			
			return null;
        }
		return  vista;
	
	}
	
	/**
	 * Metodo de ejemplo que utiliza el iNTLogin que fue obtenido con Spring
	 * este metodo puede ser cualquiera solo se muestra como se obtiene los metodos de iMPLogin con el Spring
	 * @return String vista (del pretty-config)
	 * @throws Exception
	 */
	public String metodoEjemplo() throws Exception{

		logger.info("Si llega");
		String vista="pretty:ejemplo";//solo ejemplo
		Periodo periodo=new Periodo();
		periodo=iNTLogin.obtenerPeriodo();
		logger.info("periodo "+periodo);
		
		return vista;
	
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



	public INTLogin getiNTLogin() {
		return iNTLogin;
	}



	public void setiNTLogin(INTLogin iNTLogin) {
		this.iNTLogin = iNTLogin;
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
