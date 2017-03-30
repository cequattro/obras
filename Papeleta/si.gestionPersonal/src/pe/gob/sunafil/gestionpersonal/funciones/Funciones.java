package pe.gob.sunafil.gestionpersonal.funciones;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonalDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.ReporteDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTurnopersonalrrhh;

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
      * Obtiene un dato del archivo Property: pe.gob.sunafil.libroreclam.util.properties.sunafil_app
      * @param dato Dato dentor del archivo Property.
      * @return (String)
      */
      public static String ObtProp_App(String dato) {
         String variable = "";
         try {
             ResourceBundle bundle = ResourceBundle.getBundle("pe.gob.sunafil.gestionpersonal.util.properties.mtpe_app");
             variable = bundle.getString(dato);
         } catch (Exception e) {
             depurador.info("ERROR : Funciones : ObtenerDatosProperties => : "+e);
         }
         return variable;
     }
      
      /**
       * Obtiene un dato del archivo Property: pe.gob.sunafil.libroreclam.util.properties.mtpe_resources
       * @param dato Dato dentor del archivo Property.
       * @return (String)
       */
       public static String ObtProp_Resources(String dato) {
          String variable = "";
          try {
              ResourceBundle bundle = ResourceBundle.getBundle("pe.gob.sunafil.gestionpersonal.util.properties.mtpe_resources");
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
     
     public static boolean contieneLetras(String texto){
 		String [] letras= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z","|","°","#","!","$","%","&","/","(",")"};
 		for(String letra:letras){
 			if((texto.toUpperCase()).contains(letra))
 				return true;
 		}
 		return false;
 	}
 	public static void mostrarMensajeInfo(String msg)
 	{		
 		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
 	}
 	
 	public static void mostrarMensajeError(String msg)
 	{
 		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
 	}
 	
 	public static boolean documentoNoValido(String tipoDocId, String codigoPersonal){
 		System.out.println("Numero de Documento de identidad: "+tipoDocId);
 		if(tipoDocId!=null && !"".equals(tipoDocId.trim()))
 		{
 			if("03".equals(tipoDocId.trim()))
 			{
 				if(codigoPersonal!=null && !"".equals(codigoPersonal.trim()))
 				{
 					if(codigoPersonal.trim().length()!=8)
 					{
 						mostrarMensajeError("Debe ingresar un número de DNI de 8 dígitos.");						
 						return true;
 					}else 
 					{
 						if(contieneLetras(codigoPersonal.trim())){
 							mostrarMensajeError("DNI no valido");
 							return true;
 						}
 					}
 				}
 				else
 				{
 					mostrarMensajeError("Debe ingresar un número de DNI de 8 dígitos.");					
 					return true;
 				}
 			}
 			else if("06".equals(tipoDocId.trim()) || "08".equals(tipoDocId.trim()))
 			{
 				if(codigoPersonal!=null && !"".equals(codigoPersonal.trim())){}
 				else
 				{
 					mostrarMensajeError("Debe ingresar un nro de documento.");					
 					return true;
 				}
 			}
 		}
 		if(codigoPersonal!=null && !"".equals(codigoPersonal.trim())  ){
 			if(tipoDocId!=null && !"".equals(tipoDocId.trim())){}
 			else{
 				mostrarMensajeError("Debe seleccionar un tipo de documento.");				
				return true;
				}
 		}
 			
     	return false;
 	}
 	
 	public static boolean validarFechaReporte(String anio,String mes){
 		ReporteDespatch reporteDespatch=new ReporteDespatch();
			String fechadmy;
			try {
				fechadmy = reporteDespatch.ObtieneFechaDMY();
				System.out.println("["+fechadmy.split("/")[2].substring(0, 4)+"]");
				
				if(Integer.parseInt(anio)>Integer.parseInt(fechadmy.split("/")[2].substring(0, 4)))
				{
					mostrarMensajeError("No puede ver el reporte de un año futuro.");				
					return false;
				}
				
				if(Integer.parseInt(anio)==Integer.parseInt(fechadmy.split("/")[2].substring(0, 4)) &&
						Integer.parseInt(mes)>Integer.parseInt(fechadmy.split("/")[1]))
				{
					mostrarMensajeError("No puede ver el reporte de un mes futuro.");				
					return false;
				}
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			
 	}
 	public static boolean reporteValidado(boolean opcion,String mes,String anio,String selectedIntendencia,String codTipoDocId,String codPersonal){
 		if(mes!=null && !"".equals(mes.trim())){}
 		else
 		{
 			mostrarMensajeError("Debe seleccionar un mes.");				
 			return false;
 		}
 		if(anio!=null && !"".equals(anio.trim())){}
 		else
 		{
 			mostrarMensajeError("Debe seleccionar un año.");				
 			return false;
 		}
 		try {
 			if(!validarFechaReporte(anio, mes))
 				return false;
 			
 		} catch (Exception e) {
 			// TODO: handle exception
 			return false;
 		}
 		
 		/*if(selectedIntendencia!=null && !"".equals(selectedIntendencia.trim())){}
 		else
 		{
 			mostrarMensajeError("Debe seleccionar una intendencia.");				
 			return false;
 		}*/
 		if(documentoNoValido(codTipoDocId, codPersonal)){
 			return false;
 		}
 		return true;
 	}
 	
 	public static List<TdtbcDependencia> obTenerDependencias(String query,String selectedIntendencia){
 		PersonalDespatch personalDespatch = new PersonalDespatch();
 		List<TdtbcDependencia> dependenciasAutocomplete = new ArrayList<TdtbcDependencia>();
		try {
			return dependenciasAutocomplete = personalDespatch.getAutocompletarDependenciaEIntendencia(query,selectedIntendencia);
							//PGP_Usuario.getN_numint());
		} catch (Exception e) {
			e.printStackTrace();
			return dependenciasAutocomplete;
		}
 	}
 	
 	public static List<String> completeText(String query,String selectedIntendencia,List<TdtbcDependencia> dependenciasAutocomplete) {
		

		List<String> results = new ArrayList<String>();

		for (Iterator iterator = dependenciasAutocomplete.iterator(); iterator.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator.next();
			results.add(tdtbcDependencia.getvDesdep());
		}
		return results;
	}
 	
 	public static TdtbcDependencia  onItemSelect(SelectEvent event, List<TdtbcDependencia> dependenciasAutocomplete,TdtbcDependencia anterior){
 		for (Iterator iterator = dependenciasAutocomplete.iterator(); iterator.hasNext();) {
			TdtbcDependencia tdtbcDependencia = (TdtbcDependencia) iterator.next();
			if (event.getObject().toString().equals(tdtbcDependencia.getvDesdep())) {
				System.out.println("Numero de Dependencia:"+tdtbcDependencia.getnNumdep());
				return tdtbcDependencia;
			}
		}
 		System.out.println("Error no encontro dependencia:");
 		return anterior;
 		
 	}
 	
 	public static String completarCon(String base, int longitud,String charCompletar, int lado)
	{
		String result="";
		if(base.length()<longitud)
		{
			int n=longitud-base.length();
			String ceros="";
			for (int i = 0; i < n; i++) {
				ceros+=charCompletar;
			}
			if(lado==0)//izq
			{
				result = ceros+base;
			}
			else if(lado==1)//der
			{
				result = base+ceros;
			}
		}
		else if(base.length()>longitud)
		{
			result = base.substring(0, longitud);
		}
		else if(base.length()==longitud)
		{
			result=base;
		}
		return result;
	}
 	
 	public static void imprimir(String texto){
 	   System.out.println(texto);
    }
 	
 	public static String getPwdMaster()
 	{
 		ReporteDespatch reporteDespatch=new ReporteDespatch();
 		try { 			
 			String pwd=reporteDespatch.getPwdMaster();
 			return pwd;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
 	}
 	
 	public static void mostrarTurnos(String codPersonal){
		   PersonalDespatch personalDespatch = new PersonalDespatch();
		   List<VstTurnopersonalrrhh> personalTurno= null;
	   	try {
	   		personalTurno= personalDespatch.getTurnoPersonal(codPersonal);//tengo codturno
	   		for(VstTurnopersonalrrhh turno:personalTurno){
	   			System.out.println("Turno:"+turno.getvDesturno());
	   		}
	   	}catch(Exception x){
	   		
	   	}
	   }
 	
}