package pe.gob.sunafil.gentrama.utils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;




public class Utilitarios {
	
	public String construirTablahtml(List<List<String>> cabecerass,List<List> listaDatas,List<List<String>> camposs,String titulo,List<List> superCabecerass,List<String> estilosFilas,Integer saltoLineaFinal){
		//cambiar por la forma formal despues
		String tabla="";
		if(!titulo.equals("")){
			tabla="<fieldset><legend><h3>"+titulo+"</h3></legend> ";
		}
		tabla+="<table border=1 cellspacing=0 cellpadding=0 width=100%>";
		
		
		for (int z=0;z<listaDatas.size();z++) {
			List listaData=new ArrayList();
			listaData=listaDatas.get(z);
			tabla+="<tr>";
			List superCabeceras=new ArrayList();
			superCabeceras=superCabecerass.get(z);
			for(int f=0;f<superCabeceras.size();f++){
				tabla+="<th colspan="+Integer.parseInt(((Map)superCabeceras.get(f)).get("colsPanForm").toString())+" " +
						" style="+((Map)superCabeceras.get(f)).get("estiloSuperCabecera").toString()+" >"
						+((Map)superCabeceras.get(f)).get("DesSuperCabecera").toString()+"</th>";			
								
				}
			tabla+="</tr>";			
			
			
			//Le pondremos el color de fondo representado en colorFondo de donde a donde en colFinalFormato color de letra y demas despues
			int indice2=0;
			tabla+="<tr>";
			List<String> cabeceras=new ArrayList<String>();
			cabeceras=cabecerass.get(z);
			for(int f=0;f<superCabeceras.size();f++){
					int indice1=0;				
					indice1=Integer.parseInt(((Map)superCabeceras.get(f)).get("colFinalFormato").toString());				
					for(int i=indice2==0?0:indice2+1;i<cabeceras.size();i++){
						if(indice2!=indice1 ){
							tabla+="<th style="+((Map)superCabeceras.get(f)).get("estiloCabecera").toString()+" >"+cabeceras.get(i)+"</th>";						
						}
						if(i==indice1){
							indice2=i;
						
						}
					}
					
				}
			tabla+="</tr>";	
			
			List<String> campos=new ArrayList<String>();
			campos=camposs.get(z);
				for(int i=0;i<listaData.size();i++){
					tabla+="<tr>";
						for(int j=0;j<campos.size();j++){
							tabla+="<td align=center style="+estilosFilas.get(z)+">";
							tabla+=((Map)listaData.get(i)).get(campos.get(j))==null || ((Map)listaData.get(i)).get(campos.get(j)).toString().equals("")?"-":((Map)listaData.get(i)).get(campos.get(j)).toString();
							tabla+="</td>";
						}
					tabla+="</tr>"; 
				}
		}
		
		//Fin de la tabla
			tabla+="</table>";
		if(!titulo.equals("")){
			tabla+="</fieldset>";
		}
		if(saltoLineaFinal==0){
			tabla+="<br>";
		}
		
		
		System.out.println(tabla);
		return tabla;
	}
	public String construirTablahtml(List<String> cabecera,List listaData,List<String> campos,String titulo,List superCabeceras){
		//cambiar por la forma formal despues
		String tabla="";
		if(!titulo.equals("")){
			tabla="<fieldset><legend><h3>"+titulo+"</h3></legend> ";
		}
		tabla+="<table border=1 cellspacing=0 cellpadding=0 width=100%>";
		
		int indiceA=0;
		tabla+="<tr>";
		for(int f=0;f<superCabeceras.size();f++){
			tabla+="<th colspan="+Integer.parseInt(((Map)superCabeceras.get(f)).get("colsPanForm").toString())+" " +
					"bgcolor=#"+((Map)superCabeceras.get(f)).get("colorFondo").toString()+" >"
					+((Map)superCabeceras.get(f)).get("DesSuperCabecera").toString()+"</th>";			
							
			}
		tabla+="</tr>";			
		
		
		//Le pondremos el color de fondo representado en colorFondo de donde a donde en colFinalFormato color de letra y demas despues
		int indice2=0;
		tabla+="<tr>";
		for(int f=0;f<superCabeceras.size();f++){
				int indice1=0;				
				indice1=Integer.parseInt(((Map)superCabeceras.get(f)).get("colFinalFormato").toString());				
				for(int i=indice2==0?0:indice2+1;i<cabecera.size();i++){
					if(indice2!=indice1 ){
						tabla+="<th bgcolor=#"+((Map)superCabeceras.get(f)).get("colorFondo").toString()+" >"+cabecera.get(i)+"</th>";						
					}
					if(i==indice1){
						indice2=i;
					
					}
				}
				
			}
		tabla+="</tr>";	
		
			for(int i=0;i<listaData.size();i++){
				tabla+="<tr>";
					for(int j=0;j<campos.size();j++){
						tabla+="<td align=center>";
						tabla+=((Map)listaData.get(i)).get(campos.get(j))==null || ((Map)listaData.get(i)).get(campos.get(j)).toString().equals("")?"-":((Map)listaData.get(i)).get(campos.get(j)).toString();
						tabla+="</td>";
					}
				tabla+="</tr>"; 
			}
		
		//Fin de la tabla
		if(!titulo.equals("")){
			tabla+="</table></fieldset>";
		}
		tabla+="<br>";
		
		
		System.out.println(tabla);
		return tabla;
	}
	
	public String construirTablahtml(List<String> cabecera,List listaData,List<String> campos,String titulo){
		//cambiar por la forma formal despues
		String tabla="";
		if(!titulo.equals("")){
			tabla="<fieldset><legend><h3>"+titulo+"</h3></legend> ";
		}
		tabla+="<table border=1 cellspacing=0 cellpadding=0 width=100%><tr>";
			for(int i=0;i<cabecera.size();i++){
				tabla+="<th bgcolor=#FF9900 >"+cabecera.get(i)+"</th>";
			}
		tabla+="</tr>";	
			for(int i=0;i<listaData.size();i++){
				tabla+="<tr>";
					for(int j=0;j<campos.size();j++){
						tabla+="<td align=center>";
						tabla+=((Map)listaData.get(i)).get(campos.get(j))==null || ((Map)listaData.get(i)).get(campos.get(j)).toString().equals("")?"-":((Map)listaData.get(i)).get(campos.get(j)).toString();
						tabla+="</td>";
					}
				tabla+="</tr>"; 
			}
		
		//Fin de la tabla
		if(!titulo.equals("")){
			tabla+="</table></fieldset>";
		}
		tabla+="<br>";
		
		
		System.out.println(tabla);
		return tabla;
	}
	

	public String quitarEspacios(String cadena){
		
		String[] arreglo=cadena.split("%");
		String cadenaNueva="";
		for(int i=0;i<arreglo.length;i++){
			cadenaNueva+= arreglo[i]+" ";
		}
		
		return cadenaNueva.trim();
		
	}
	
	public String convierteString(String fecha) {

		String nuevaFecha = "";

		nuevaFecha = fecha.substring(6, 10) + fecha.substring(3, 5)
				+ fecha.substring(0, 2);

		System.out.println("NUEVA FECHA " + nuevaFecha);

		return nuevaFecha;
	}

	public String convierteString(String mes, String ano) {

		String nuevaFecha = "";
		String parteMes = "";

		if (mes.equals("ENERO")) {
			parteMes = "01";
		}
		if (mes.equals("FEBRERO")) {
			parteMes = "02";
		}
		if (mes.equals("MARZO")) {
			parteMes = "03";
		}
		if (mes.equals("ABRIL")) {
			parteMes = "04";
		}
		if (mes.equals("MAYO")) {
			parteMes = "05";
		}
		if (mes.equals("JUNIO")) {
			parteMes = "06";
		}
		if (mes.equals("JULIO")) {
			parteMes = "07";
		}
		if (mes.equals("AGOSTO")) {
			parteMes = "08";
		}
		if (mes.equals("SETIEMBRE")) {
			parteMes = "09";
		}
		if (mes.equals("OCTUBRE")) {
			parteMes = "10";
		}
		if (mes.equals("NOVIEMBRE")) {
			parteMes = "11";
		}
		if (mes.equals("DICIEMBRE")) {
			parteMes = "12";
		}
		nuevaFecha = ano + parteMes;

		return nuevaFecha;

	}
	public String mesFormatoNum(String mes) {

		String nuevaFecha = "";
		String parteMes = "";

		if (mes.equals("ENERO")) {
			parteMes = "01";
		}
		if (mes.equals("FEBRERO")) {
			parteMes = "02";
		}
		if (mes.equals("MARZO")) {
			parteMes = "03";
		}
		if (mes.equals("ABRIL")) {
			parteMes = "04";
		}
		if (mes.equals("MAYO")) {
			parteMes = "05";
		}
		if (mes.equals("JUNIO")) {
			parteMes = "06";
		}
		if (mes.equals("JULIO")) {
			parteMes = "07";
		}
		if (mes.equals("AGOSTO")) {
			parteMes = "08";
		}
		if (mes.equals("SETIEMBRE")) {
			parteMes = "09";
		}
		if (mes.equals("OCTUBRE")) {
			parteMes = "10";
		}
		if (mes.equals("NOVIEMBRE")) {
			parteMes = "11";
		}
		if (mes.equals("DICIEMBRE")) {
			parteMes = "12";
		}
		nuevaFecha = parteMes;

		return nuevaFecha;

	}
	public String obtieneIp() {

		String ip = null;

		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			return ip;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return ip;
	}

	public String obtieneNombreHost() {

		String host = null;

		try {
			host = InetAddress.getLocalHost().getHostName();
			return host;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return host;
	}

	public Integer obtieneFechaActual() {

		Integer fechaActual = -1;

		Date fecha = new Date();
		String fecha1 = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		fecha1 = sdf.format(fecha);
		fechaActual = Integer.parseInt(fecha1);
		return fechaActual;

	}

	public Integer obtieneHoraActual() {

		Integer horaActual = -1;

		Date hora = new Date();
		String hora1 = null;

		SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
		hora1 = sdf.format(hora);
		horaActual = Integer.parseInt(hora1);
		return horaActual;

	}
	public String obtieneHoraActual2() {

		Integer horaActual = -1;

		Date hora = new Date();
		String hora1 = null;

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		hora1 = sdf.format(hora);
		
		return hora1;

	}
	public Integer obtieneHoraActual3() {

		Integer horaActual = -1;

		Calendar c=Calendar.getInstance();
		Integer hora1=0;
		hora1=c.get(Calendar.HOUR_OF_DAY);
		return hora1;

	}
	public boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	public boolean isDouble(String cadena) {
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	public boolean isNull(String cadena) {
		
			if(cadena.equals(null)){
				return true;
			}else{
				return false;
			}
			
	
	}

	public void abreArchivo(String ruta) {

		try {
			Runtime.getRuntime().exec(
					"rundll32 url.dll,FileProtocolHandler " + ruta);

		} catch (IOException ee) {
			ee.printStackTrace();
		}

	}
	
	public void borraArchivo(String ruta){
		
		File objArchivo= new File(ruta);
		
		if(objArchivo.exists()){
			objArchivo.delete();
		}
		
		
		
		
	}
	
	public void borrarDirectorio(String ruta){
		
		File objArchivo= new File(ruta);
		
		File arr[]=objArchivo.listFiles();
		
		System.out.println("arr "+arr);
		for(int i=0;i<arr.length;i++){
			arr[i].delete();
		}
		
	}
	
	public String gneraNombreXls(){
		String nomExcel="xls"+Math.random()+".xls";
		return nomExcel;
	}
	public String gneraNombreJPG(){
		String nomExcel="jpg"+Math.random()+".jpg";
		return nomExcel;
	}
	
	
	public String reestructuraFecha(Integer fecha){
		String fec=""+fecha;
		String nuevaFecha = "";

		nuevaFecha = fec.substring(6, 8)+"/"+fec.substring(4, 6)+"/"+fec.substring(0, 4);
		
		return nuevaFecha;
	}
	public String[] direccionesDeCorreo(List listaCorreos,String identificador){
		
		String[] direcciones=null;
		
		if(listaCorreos.size()>0){
			
			direcciones=new String[listaCorreos.size()];
			for (int i = 0; i < listaCorreos.size(); i++) {
				direcciones[i]=((Map)listaCorreos.get(i)).get(identificador).toString();
			}		 
			
		
		}
		return direcciones;
		
	}
	public static String cadenaAleatoria() {
		String cadenaAleatoria = "";
		
		char[] elementos = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
				'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
				'y', 'z' };

		char[] conjunto = new char[4];		

		for (int i = 0; i < 4; i++) {
			int el = (int) (Math.random() * 36);
			conjunto[i] = (char) elementos[el];

		}
		
		cadenaAleatoria = new String(conjunto);

		return cadenaAleatoria;

	}
	
	public static void terminarSesion() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext ec = facesContext.getExternalContext();
		HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
		httpSession.invalidate();
	}

}
