package pe.gob.sunafil.postulacioncas.funciones;

import java.util.ResourceBundle;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

/**
 * Clase que implementa Métodos Utiles.
 */
public class Funciones {
    
    private static Logger depurador = Logger.getLogger(Funciones.class.getName()); 
    
    /**
     * Instancia de la Clase funciones.
     */
    public Funciones() {
    }
    
    /**
     * Obtiene un dato de un archivo Property.
     * @param archivo Nombre y ubicacion del Archivo Property.
     * @param dato Dato dentor del archivo Property.
     * @return (String)
     */
     public static String ObtieneProperty(String archivo, String dato) {
        String variable = "";
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(archivo);
            variable = bundle.getString(dato);
        } catch (Exception e) {
            depurador.info("ERROR : Funciones : ObtenerDatosProperties => : "+e);
        }
        return variable;
    }
    
     /**
      * Obtiene un dato del archivo Property: pe.gob.sunafil.postulacioncas.util.properties.sunafil_app
      * @param dato Dato dentor del archivo Property.
      * @return (String)
      */
      public static String ObtProp_App(String dato) {
         String variable = "";
         try {
             ResourceBundle bundle = ResourceBundle.getBundle("pe.gob.sunafil.postulacioncas.util.properties.sunafil_app");
             variable = bundle.getString(dato);
         } catch (Exception e) {
             depurador.info("ERROR : Funciones : ObtenerDatosProperties => : "+e);
         }
         return variable;
     }
      /**
       * Obtiene un dato del archivo Property: pe.gob.sunafil.postulacioncas.util.properties.mtpe_resources
       * @param dato Dato dentor del archivo Property.
       * @return (String)
       */
       public static String ObtProp_Resources(String dato) {
          String variable = "";
          try {
              ResourceBundle bundle = ResourceBundle.getBundle("pe.gob.sunafil.postulacioncas.util.properties.sunafil_resources");
              variable = bundle.getString(dato);
          } catch (Exception e) {
              depurador.info("ERROR : Funciones : ObtenerDatosProperties => : "+e);
          }
          return variable;
      }
       
    /**
     * Rellena una cadena con un caracter dado.
     * @param numero 
     * @param caracterRelleno 
     * @param tamanioEsperado 
     * @return 
     */
     public static String RellenarDato(String numero, char caracterRelleno,
        int tamanioEsperado) {
        String alfanumerico = "";
        int tamanioActual = numero.trim().length();

        if (tamanioActual > tamanioEsperado) {
            return alfanumerico;
        }

        for (int i = 1; i <= (tamanioEsperado - tamanioActual); i++)
            alfanumerico += caracterRelleno;

        alfanumerico += numero.trim();
        depurador.info("rellenarDato: " + alfanumerico);

        return alfanumerico;
    }
     /**
      * Funcion generada para los errores, mostrarlos en Jboss
      * @param Exception e
      * @return StringWritere sw.toString
      */
     public static String readStackTrace(Exception e) { 
         StringWriter sw = new StringWriter(); 
         PrintWriter pw = new PrintWriter(sw); 
         e.printStackTrace(pw); 
         return sw.toString(); 
     }
     
     public static void mostrarMensajeInfo(String msg)
  	{		
  		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
  	}
  	
  	public static void mostrarMensajeError(String msg)
  	{
  		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
  	}
}
