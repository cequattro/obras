package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import pe.gob.sunafil.gestionpersonal.funciones.Funciones;

@ManagedBean(name="funcionesFechasBean")
public class FuncionesFechas {

	private List<String> listaAniosSunafil;
	
	public static String getFormatDate(Date date) {
		if(date!=null){
			return new SimpleDateFormat("dd/MM/yyyy").format(date);}
		else{
			return "";}
	}
 	
	 public static String getFormatDateDDMMYYYY(Date date) {
		 if(date!=null){
			return new SimpleDateFormat("ddMMyyyy").format(date);}
		 else{
			 return "";
		 }
	}
	 
 	public static String getMesFormat(String nro)
	{
		switch (Integer.parseInt(nro)) {
		case 1:
			return "ENERO";			
			
		case 2:
			return "FEBRERO";
			
		case 3:
			return "MARZO";
			
		case 4:
			return "ABRIL";
			
		case 5:
			return "MAYO";
			
		case 6:
			return "JUNIO";
			
		case 7:
			return "JULIO";
			
		case 8:
			return "AGOSTO";
			
		case 9:
			return "SEPTIEMBRE";
			
		case 10:
			return "OCTUBRE";
			
		case 11:
			return "NOVIEMBRE";
			
		case 12:
			return "DICIEMBRE";

		default:
			return "";
		}
		
	}
 	
 	public static boolean validaFecha(Date fecha){
 		if(fecha!=null){
        	if(fecha.after(new Date()))
        	{
        		Funciones.mostrarMensajeError("No puede ingresar Fechas Futuras.");
        		return false;
        	}
    	}
    	else
    	{
    		Funciones.mostrarMensajeError("Debe ingresar una fecha.");
    		return false;
    	}
 		return true;
 	}
 	public static boolean validaFecha(Date fechaInicio,Date fechaFinal){
    	if(fechaInicio==null && fechaFinal==null)
    		{
    		Funciones.mostrarMensajeError("Debe ingresar Fechas");
    			return false;
    		}
    	else{
    		if(fechaInicio == null && fechaFinal!=null)
    		{
    			Funciones.mostrarMensajeError("Debe ingresar fecha de inicio.");
	    		return false;
    		}
    		else if(fechaInicio != null && fechaFinal==null){
    			Funciones.mostrarMensajeError("Debe ingresar fecha de fin.");
	    		return false;
	    	}
    		else//ambos diferentes de null
	    	{
	    		if(fechaInicio.after(fechaFinal))
	    		{
	    			Funciones.mostrarMensajeError("La fecha de inicio no puede ser mayor a la fecha fin.");
	        		return false;
	    		}/*else if(fechaInicio.after(new Date()))
	    	    	{
	    			Funciones.mostrarMensajeError("No puede ingresar Fechas Futuras.");
	    	    		return false;
	    	    	}
	    		else if(fechaFinal.after(new Date()))
	    	    	{
	    			Funciones.mostrarMensajeError("No puede ingresar Fechas Futuras.");
	    	    		return false;
	    	    	}*/
	    		else 
	    		{
	    			return true;
	    		}
	    				
	    	}
    	}
    }

	public List<String> getListaAniosSunafil() {
		return listaAniosSunafil;
	}
	
	public static String getEdad(Date birthday) {
        Calendar fromDate=Calendar.getInstance();
        Calendar toDate=Calendar.getInstance();
        fromDate.setTime(birthday);
        toDate.setTime(new Date());
        int increment = 0;
        int year,month,day;
        System.out.println(fromDate.getActualMaximum(Calendar.DAY_OF_MONTH));
        if (fromDate.get(Calendar.DAY_OF_MONTH) > toDate.get(Calendar.DAY_OF_MONTH)) {
            increment =fromDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
         System.out.println("increment"+increment);
// DAY CALCULATION
        if (increment != 0) {
            day = (toDate.get(Calendar.DAY_OF_MONTH) + increment) - fromDate.get(Calendar.DAY_OF_MONTH);
            increment = 1;
        } else {
            day = toDate.get(Calendar.DAY_OF_MONTH) - fromDate.get(Calendar.DAY_OF_MONTH);
        }

// MONTH CALCULATION
        if ((fromDate.get(Calendar.MONTH) + increment) > toDate.get(Calendar.MONTH)) {
            month = (toDate.get(Calendar.MONTH) + 12) - (fromDate.get(Calendar.MONTH) + increment);
            increment = 1;
        } else {
            month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) + increment);
            increment = 0;
        }

// YEAR CALCULATION
        year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);
     //return   year+" años, "+month+" meses, "+day+" días";
     return   year+" años";
    }
	
	public FuncionesFechas(){
		int anioInicioSunafil=2017;//2014
		Calendar fecha = Calendar.getInstance();
        int anioActual = fecha.get(Calendar.YEAR);
		int temp=anioInicioSunafil;
		listaAniosSunafil= new ArrayList<String>();
		while(temp<=anioActual){
			listaAniosSunafil.add(temp+"");
			temp++;
		}
	}


}
