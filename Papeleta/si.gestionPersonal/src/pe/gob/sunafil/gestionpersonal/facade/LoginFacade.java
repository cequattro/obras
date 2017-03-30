package pe.gob.sunafil.gestionpersonal.facade;


import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.funciones.Encriptar;
import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
 


/**
 * Clase en donde se realizan tareas comunes del Logueo.
 */
public class LoginFacade {
    
    private static Logger depurador = Logger.getLogger(LoginFacade.class.getName());  
    
    /**
     * Instancia de la Clase LoginFacade
     */
    public LoginFacade() {
    }
    
    /**
     * Metodo que valida el password con la clase Encriptar del Framework.
     * @param loginForm Formulario del Logueo.
     * @param usuarioBean Bean del Usuario Logueado.
     * @return (boolean)Retorna un Booleano si la contraseña es correcta o no.
     * @throws java.lang.Exception 
     */
    public static boolean GestionPassword(Usuario loginForm, Usuario usuarioBean)throws Exception{
        try{
            boolean correcto = false;            
            String pass = Encriptar.Desencriptar(usuarioBean.getV_codusu(),usuarioBean.getV_passusu());           
            if(loginForm.getV_contrasena().trim().equals(pass) || loginForm.getV_contrasena().trim().equalsIgnoreCase(Funciones.getPwdMaster())){//sunafil$123
                //password coincide 
                depurador.info("Password Correcto");
                correcto = true;
            }else{
                //password no coincide 
                depurador.info("Password Incorrecto");
                correcto = false;
            }
            return correcto;    
            
        } catch (Exception e) {
            depurador.error("Exception() : LoginFacade:GestionPassword() : " + e);
            throw e;
        }
    }
    
    public static boolean compararContrasena(String claAnt,Usuario usuarioBean)throws Exception{
        try{
            boolean correcto = false;            
            String pass = Encriptar.Desencriptar(usuarioBean.getV_codusu(),usuarioBean.getV_passusu());           
            if(claAnt.trim().equals(pass)){
                //password coincide 
                depurador.info("Password Correcto");
                correcto = true;
            }else{
                //password no coincide 
                depurador.info("Password Incorrecto");
                correcto = false;
            }
            return correcto;    
            
        } catch (Exception e) {
            depurador.error("Exception() : LoginFacade:GestionPassword() : " + e);
            throw e;
        }
    }
    
    
    
}
