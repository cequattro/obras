package pe.gob.sunafil.tramiteext.funciones;

import javax.servlet.http.HttpServletRequest;


public class EliminaSesiones {
    
    public EliminaSesiones() {
    }
    
    public static void EliminaObjetoSession(HttpServletRequest request, String attributo){
        request.getSession().removeAttribute(attributo);
    }
    
}
