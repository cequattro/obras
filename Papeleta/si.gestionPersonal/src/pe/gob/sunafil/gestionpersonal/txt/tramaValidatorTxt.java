package pe.gob.sunafil.gestionpersonal.txt;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.io.Resources;


public class tramaValidatorTxt {

	public static String errorLog="";
	static String breakpLineWriter;
	public static boolean hayError=false;
	public static Date initDate;
	public static Date endDate;		
	
	public static Date getInitDate() {
		return initDate;
	}

	public static void setInitDate(Date initDate) {
		tramaValidatorTxt.initDate = initDate;
	}

	public static Date getEndDate() {
		return endDate;
	}

	public static void setEndDate(Date endDate) {
		tramaValidatorTxt.endDate = endDate;
	}

	public static boolean isHayError() {
		return hayError;
	}

	public static void setHayError(boolean hayError) {
		tramaValidatorTxt.hayError = hayError;
	}

	public tramaValidatorTxt(){}
	
	public void Process(){
		try{
			Properties configProp = new Properties();
			String resource = "pe/gob/sunafil/gestionpersonal/util/properties/mtpe_resources.properties";			
			Reader reader = Resources.getResourceAsReader(resource);
			configProp.load(reader);
			String folderPathImport = configProp.getProperty("ruta.xls")+"/";			
			
			BufferedReader br;
			br = new BufferedReader(new FileReader(folderPathImport+"temporal.txt"));
	    	String line;
	    	int lineNum=0;
	    	int lineCountTotal=0;
	    	int lineToInsert=0;//new validation
	    	while ((line = br.readLine()) != null) {
	    		if(line.length()!=37)//end SUB
	    		{
	    			lineNum++;		    
	    			System.out.println("Error ::: ["+line+"]");
	    		}
	    		//new validation
	    		if(line.length()==37)
	    		{
	    			String[] rowArray=line.split("	");
	    			SimpleDateFormat simpleDate=new SimpleDateFormat("dd/MM/yyyy");
	    			Date dateRow=simpleDate.parse(rowArray[1].substring(8, 10)+"/"
							+rowArray[1].substring(5, 7)+"/"
							+rowArray[1].substring(0, 4));
	    			if(!dateRow.before(initDate) && !dateRow.after(endDate))
	    			{
	    				++lineToInsert;
	    			}
	    		}
	    		//end new validation
	    		++lineCountTotal;
	    	}
	    	if(lineNum>1)
	    	{
	    		errorLog+="Hay "+lineNum+" lineas con formato erroneo.";
	    		hayError=true;
	    	}
	    	if(lineCountTotal==1 && lineNum==1)
	    	{
	    		errorLog+="Hay "+lineNum+" línea con formato erroneo.";
	    		hayError=true;
	    	}
	    	if(lineCountTotal==0)
	    	{
	    		errorLog+="No hay líneas que leer en el archivo.";
	    		hayError=true;
	    	}
	    	if(lineToInsert==0)
	    	{
	    		errorLog+="No hay marcaciones en el archivo que coincidan con el rango de fecha ingresado.";
	    		hayError=true;
	    	}
	    	br.close();
		System.out.println(errorLog);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String getErrorLog()
	{
		return errorLog;
	}
	
	public void resetErrorLog()
	{
		errorLog="";
		hayError=false;
	}
}