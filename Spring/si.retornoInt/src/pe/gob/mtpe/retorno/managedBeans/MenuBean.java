package pe.gob.mtpe.retorno.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import pe.gob.mtpe.retorno.bean.MenuHijo;
import pe.gob.mtpe.retorno.bean.MenuPadre;
import pe.gob.mtpe.retorno.bean.Permisos;
import pe.gob.mtpe.retorno.bean.Usuario;
import pe.gob.mtpe.retorno.util.funciones.Funciones;
import pe.gob.mtpe.retorno.utils.FacesUtils;

/***
 * 
 * @author Mario Zumaeta
 * @fecha 04/09/2013
 *
 */

@ManagedBean(name = "menuBean")
@SessionScoped
public class MenuBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1336811357241296446L;

	
	private List<MenuPadre> PGP_MenuPadre;	
	private List<MenuHijo> PGP_MenuHijo;	
	private Usuario PGP_Usuario;
	private Permisos PGP_Permisos;

	private MenuModel menuModel;

	private String vieneMenu;

	public MenuBean() {

		menuModel = new DefaultMenuModel();

	}

	/**
	 * @Construyendo el menU
	 */
	private void construyeMenu() {
		PGP_Usuario=((Usuario)FacesUtils.getSessionAttribute("PGP_Usuario"));
		PGP_Permisos=((Permisos)FacesUtils.getSessionAttribute("PGP_Permisos"));
		
		if(PGP_MenuPadre==null){
			PGP_MenuPadre=new ArrayList<MenuPadre>();
			PGP_MenuPadre=(List<MenuPadre>)FacesUtils.getSessionAttribute("PGP_MenuPadre");
		}
		if(PGP_MenuHijo==null){
			PGP_MenuHijo=new ArrayList<MenuHijo>();
			PGP_MenuHijo=(List<MenuHijo>)FacesUtils.getSessionAttribute("PGP_MenuHijo");
		}
		for (int i = 0; i < PGP_MenuPadre.size(); i++) {
			
			DefaultSubMenu  submenu=new DefaultSubMenu(PGP_MenuPadre.get(i).v_menu);			
			
				for (int j = 0; j < PGP_MenuHijo.size(); j++) {
					if(PGP_MenuHijo.get(j).getV_codpad().equals(PGP_MenuPadre.get(i).getMen_padre())){
						DefaultMenuItem itemM=new DefaultMenuItem(PGP_MenuHijo.get(j).v_desmen);						
						itemM.setId("id"+j);					
						itemM.setAjax(false);						
						String url=PGP_MenuHijo.get(j).v_url;					
						itemM.setCommand(url);						
						
						submenu.addElement(itemM);                                
					}
				}
			menuModel.addElement(submenu);
		
		}
		
		

		/**
		 * ===========================================
		 */

		DefaultMenuItem salir = new DefaultMenuItem("Salir");
		salir.setId("id_Salir");
		String url = "#{menuBean.efectuarSalir}";
		salir.setCommand(url);		
		menuModel.addElement(salir);
		
		DefaultMenuItem guia = new DefaultMenuItem("GUIA DE USUARIO");
		guia.setId("id_guia");
		String urlguia = "#{menuBean.mostrarManual}";
		guia.setAjax(false);
		guia.setTarget("_blank");		
		guia.setCommand(urlguia);		
		menuModel.addElement(guia);

	}

	public String efectuarSalir() {
		String vista = "pretty:login";
		FacesUtils.removeUsuarioLogueado();		
		FacesUtils.removeSessionAttribute("loginBean");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		return vista;
	}
	
	public void mostrarManual()throws Exception{		
		String rutaGeneral = Funciones.ObtieneProperty("pe.gob.mtpe.retorno.util.properties.mtpe_app","mtpe.framework.ruta");
		String rutaArchivo = Funciones.leerPropertyExterno(rutaGeneral, "mtpe.framework.rutaManualInterno");
		String nombreArchivo = Funciones.leerPropertyExterno(rutaGeneral, "mtpe.framework.nombreManualInterno");
		
		FacesUtils.mostrarPDF(rutaArchivo, nombreArchivo);		
		
	}

	/**
	 * 
	 */

	/**
	 * 
	 * Redireccion al cambio de contraseñas
	 * 
	 */

	public String admRetorno() {
		String vista = "";
		vista = "pretty:administracion";		
		return vista;
	}

	public String redCamContrasena() {
		String vista = "";
		vista = "pretty:mnt_contrasena";

		return vista;
	}

	public String redPreguntaFrec() {
		String vista = "";
		vista = "pretty:preguntasFrecuentes";

		return vista;
	}

	public String redPReportes() {
		String vista = "";
		vista = "pretty:reportes";

		return vista;
	}

	/**
	 * @zona get set
	 */

	public List<MenuPadre> getPGP_MenuPadre() {
		return PGP_MenuPadre;
	}

	public void setPGP_MenuPadre(List<MenuPadre> pGP_MenuPadre) {
		PGP_MenuPadre = pGP_MenuPadre;
	}

	public MenuModel getMenuModel() {
		if (menuModel.getElements().size() == 0) {
			construyeMenu();
		}
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public List<MenuHijo> getPGP_MenuHijo() {
		return PGP_MenuHijo;
	}

	public void setPGP_MenuHijo(List<MenuHijo> pGP_MenuHijo) {
		PGP_MenuHijo = pGP_MenuHijo;
	}

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}

	public String getVieneMenu() {
		return vieneMenu;
	}

	public void setVieneMenu(String vieneMenu) {
		this.vieneMenu = vieneMenu;
	}

	public Permisos getPGP_Permisos() {
		return PGP_Permisos;
	}

	public void setPGP_Permisos(Permisos pGP_Permisos) {
		PGP_Permisos = pGP_Permisos;
	}

	
}
