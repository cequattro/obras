package pe.gob.sunafil.postulacioncas.mybatis.despachadores;

 
import org.apache.log4j.Logger;

import pe.gob.sunafil.postulacioncas.mybatis.implementacion.IMPLogueo;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTLogueo;




/**
 * Capa Intermedia para la Implementacion de los Métodos del DAO ( Interfase y Implentación)
 */
public class LoginDespatch {
    
    private static final LoginDespatch instance = new LoginDespatch();
     
    private INTLogueo logueoDAO;
    private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
    
    /**
     * Declaracion de la instancia de la clase e instancia la Clase DAO ( Interfase )
     */
    public LoginDespatch() {
        logueoDAO = new IMPLogueo();
    }
    
    /**
     * Metodo que obtiene la fecha de la base de datos.
     * @return String, con la Fecha formateada
     */   
    public String ObtieneFecha()throws Exception{
        logger.info("ObtieneFecha");
        String fecha = logueoDAO.ObtieneFecha();
        return fecha;
    }
    
}
