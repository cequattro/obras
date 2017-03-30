package pe.gob.sunafil.gentrama.mybatis.despachadores;

 
import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gentrama.bean.Permisos;
import pe.gob.sunafil.gentrama.bean.Usuario;
import pe.gob.sunafil.gentrama.mybatis.implementacion.IMPLogueo;
import pe.gob.sunafil.gentrama.mybatis.interfase.INTLogueo;



 


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
     * Metodo que implementa la Validación del Usuario logueado al Sistema.
     * @return UsuarioBean, bean con todos los datos del Usuario Logueado.
     * @param loginForm Formulario del Logueo.
     * @throws java.lang.Exception 
     */
    public Usuario ValidaLogueo(Usuario loginForm)throws Exception{
        
        logger.info("Obteniendo el usuario del logueo");        
        
        //Valida el usuario logueado 
       
        List lUsuario = logueoDAO.ValidaLogueo(loginForm); 
        System.out.println("entro aqui desp "+lUsuario);
        Usuario usuarioBean = null;
        
        //Verifica si la consulta devuelve al usuario logueado
        if(lUsuario.size()==0){            
            //usuario no existe
            logger.info("Usuario no existe. BeanUsuario = null"); 
             usuarioBean = null;
        }else{
            //usuario existe
            logger.info("Pasando la Informacion al BeanUsuario"); 
            usuarioBean = new Usuario();
            //traspaso de los datos encontrados al UsuarioBean
            usuarioBean= ((Usuario)lUsuario.get(0));
            logger.info(usuarioBean);
        }           
        
        return usuarioBean;
        
    }
    
    
    /**
     * Metodo que implementa la Validación del Usuario logueado al Sistema.
     * @return UsuarioBean, bean con todos los datos del Usuario Logueado.
     * @param usuarioBean UsuarioBean, bean con todos los datos del Usuario Logueado.
     * @throws java.lang.Exception 
     */
    public Permisos ObtienePermisos(Usuario usuarioBean)throws Exception{
        
        logger.info("Obteniendo el usuario del logueo");        
        
        //Valida el usuario logueado 
        List lPermisos = logueoDAO.ObtienePermisos(usuarioBean); 
        Permisos permisosBean = null;
        
        //Verifica si la consulta devuelve al usuario logueado
        if(lPermisos.size()==0){            
            //usuario no existe
            logger.info("Usuario no tiene Permisos para acceder al Sistema existe. PermisosBean = null"); 
             usuarioBean = null;
        }else{
            //usuario existe
            logger.info("Pasando la Informacion al PermisosBean"); 
            permisosBean = new Permisos();
            //traspaso de los datos encontrados al UsuarioBean
          permisosBean=((Permisos)lPermisos.get(0));
            logger.info(permisosBean);
        }           
        
        return permisosBean;
        
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
    
    public List ObtieneMenuPadre(Usuario usuarioBean, Permisos permisosBean)throws Exception{
        
        logger.info("Obteniendo el MenuPadre");        
        
        //Valida el usuario logueado 
        List lMenuPadre = logueoDAO.ObtieneMenuPadre(usuarioBean,permisosBean);    
     //   logger.info(lMenuPadre.size());
        lMenuPadre.size();
        return lMenuPadre;
        
    } 
    
    
    /**
     * Metodo que obtiene la lista del Menu Hijo.
     * @return UsuarioBean, bean con todos los datos del Usuario Logueado.
     * @param usuarioBean UsuarioBean, bean con todos los datos del Usuario Logueado.
     * @throws java.lang.Exception 
     */
    public List ObtieneMenuHijo(Usuario usuarioBean)throws Exception{
        
        logger.info("Obteniendo el MenuHijo");        
        
        //Valida el usuario logueado 
        List lMenuHIjo = logueoDAO.ObtieneMenuHijo(usuarioBean);         
        
        return lMenuHIjo;
        
    } 
    
   
    
}
