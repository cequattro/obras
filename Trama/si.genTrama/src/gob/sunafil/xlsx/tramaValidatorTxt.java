package gob.sunafil.xlsx;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class tramaValidatorTxt {

	public static String errorLog="";
	static String breakpLineWriter;
	public static boolean hayError=false;
	
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
			String resource = "pe/gob/sunafil/gentrama/util/properties/sunafil_resources.properties";
			//String resource = "gob/sunafil/xlsx/config.properties";
			Reader reader = Resources.getResourceAsReader(resource);
			configProp.load(reader);
		    
			String folderPathImport = configProp.getProperty("ruta.xls")+"/";
			//String folderPathImport = configProp.getProperty("folderTxt");
			Workbook wb = new XSSFWorkbook();//
		    Sheet sheet = wb.createSheet("libro nuevo");//
			BufferedReader br;
			br = new BufferedReader(new FileReader(folderPathImport+"temporal.txt"));
	    	String line;
	    	int lineNum=0;
	    	int lineCountTotal=0;
	    	while ((line = br.readLine()) != null) {
	    		if(line.length()!=333)//end SUB
	    		{
	    			lineNum++;		    		
	    		}	    
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