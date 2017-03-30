package pe.gob.mtpe.retorno.util.funciones;

import java.util.ResourceBundle;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

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
	 * 
	 * @param archivo
	 *            Nombre y ubicacion del Archivo Property.
	 * @param dato
	 *            Dato dentor del archivo Property.
	 * @return (String)
	 */
	public static String ObtieneProperty(String archivo, String dato) {
		String variable = "";
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(archivo);
			variable = bundle.getString(dato);
		} catch (Exception e) {
			depurador.info("ERROR : Funciones : ObtenerDatosProperties => : " + e);
		}
		return variable;
	}

	public static String leerPropertyExterno(String ruta, String llave) {
		Properties propiedades = new Properties();
		InputStream entrada = null;

		try {

			entrada = new FileInputStream(ruta);
			propiedades.load(entrada);
			return propiedades.getProperty(llave);

		} catch (IOException ex) {
			depurador.error("Error ", ex);
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					depurador.error("Error ",e);
				}
			}
		}

		return "";

	}

	/**
	 * Rellena una cadena con un caracter dado.
	 * 
	 * @param numero
	 * @param caracterRelleno
	 * @param tamanioEsperado
	 * @return
	 */
	public static String RellenarDato(String numero, char caracterRelleno, int tamanioEsperado) {
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
	 * 
	 * @param Exception
	 *            e
	 * @return StringWritere sw.toString
	 */
	public static String readStackTrace(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
	   /**
     * Funcin que compara si la fecha es mayor
     * @param fechaInicial
     * @param fechaFinal
     * @return boolean
     */
    public static boolean compararFechas(String fechaInicial,String fechaFinal){
   	 boolean comparar=true;
   	 DateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
   	 try {
			Date fechaInicialD=sdf.parse(fechaInicial);
			Date fechaFinalD=sdf.parse(fechaFinal);			
			comparar=fechaInicialD.after(fechaFinalD);
		} catch (ParseException e) {
			depurador.error("Error =", e);
		}
   	
   	 return comparar;
    }
    
    public static String validarFecha(String fechaCorta){
    	String mensaje="";
    	String[] fecha=fechaCorta.split("/");
		Integer mes=0;
		Integer ano=0;
		mes=Integer.parseInt(fecha[0]);
		ano=Integer.parseInt(fecha[1]);
		if(mes<1 || mes>12){
			mensaje="Ingrese formato de fecha válido";
		}
		
		if(ano<1900 || ano>2200){
			mensaje="Ingrese formato de fecha válido";
		}
		
		return mensaje;
    }
}
