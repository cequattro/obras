package pe.gob.sunafil.denunciavirtual.phaselistener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import pe.gob.sunafil.denunciavirtual.managedBeans.CargaAppBean;
import pe.gob.sunafil.denunciavirtual.utils.FacesUtils;


public class LoginPhaseListener implements PhaseListener{

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginPhaseListener.class.getName());
	
	@Override
    public void afterPhase(PhaseEvent pe) {
		
        FacesContext facesContext = pe.getFacesContext();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        //response.setHeader("Cache-Control", "no-cache");
        //response.setHeader("Pragma", "no-cache");
        //response.setDateHeader("Expires", -1);
        
        FacesContext fc = pe.getFacesContext();
        String paginaActual = fc.getViewRoot().getViewId();
        NavigationHandler nh = fc.getApplication().getNavigationHandler();
        
        
        
        boolean paginaInicio = paginaActual.lastIndexOf("index") > -1 ? true : false;
        boolean paginaTimeOut = paginaActual.lastIndexOf("timeoutsession") > -1 ? true : false;
        boolean paginaException = paginaActual.lastIndexOf("exception") > -1 ? true : false;
        boolean paginaSalir = paginaActual.lastIndexOf("Salir") > -1 ? true : false;
        boolean paginaLevantamiento = paginaActual.indexOf("levantarReserva") > -1 ? true : false;
        boolean paginaLevantamientoC = paginaActual.indexOf("levantarConfirmacion") > -1 ? true : false;
        boolean paginaLevantamientoE = paginaActual.indexOf("levantarException") > -1 ? true : false;
//        System.out.println("paginaActual:"+paginaActual);
//        System.out.println("paginaInicio:"+paginaInicio);
//        System.out.println("paginaTimeOut:"+paginaTimeOut);
//        System.out.println("paginaException:"+paginaException);
//        System.out.println("paginaSalir:"+paginaSalir);
//        System.out.println("paginaLevantamiento:"+paginaLevantamiento);
//        System.out.println("paginaLevantamientoC:"+paginaLevantamientoC);
//        System.out.println("estaLogueado():"+estaLogueado());
        if (paginaActual != null) {

            if (!estaLogueado() && !paginaInicio && !paginaTimeOut && !paginaSalir && !paginaLevantamiento && !paginaLevantamientoC && !paginaLevantamientoE && !paginaException) {
            	logger.info("No está Logueado!!!! ... redireccionando a pagina timeout");
            	nh.handleNavigation(fc, null, "pretty:timeout");
            }
            
        }
		
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    private boolean estaLogueado() {
        return FacesUtils.existeUsuarioLogueado();
     }


}
