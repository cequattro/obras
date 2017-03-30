package gob.sunafil.xlsx;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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


public class tramaValidatorXlsx {

	public static String errorLog="";
	static String breakpLineWriter;
	public static boolean hayError=false;
	
	public static boolean isHayError() {
		return hayError;
	}

	public static void setHayError(boolean hayError) {
		tramaValidatorXlsx.hayError = hayError;
	}

	public tramaValidatorXlsx(){}
	
	public void Process(){
		try{
			Properties configProp = new Properties();
			//InputStream inputProp = new FileInputStream("D://Willy//fileconverter//logueo//si.expedientesAB//src//gob//sunafil//xlsx//config.properties");
		    //configProp.load(inputProp);
			String resource = "pe/gob/sunafil/gentrama/util/properties/sunafil_resources.properties";
			//String resource = "gob/sunafil/xlsx/config.properties";
			Reader reader = Resources.getResourceAsReader(resource);
			configProp.load(reader);
		    
			String folderPathImport = configProp.getProperty("ruta.import.sin.slash");
			//String folderPathImport = configProp.getProperty("folderPathImportBN");
			String sheetName = configProp.getProperty("sufijo");
			readExcelFilesFolder(folderPathImport, sheetName);
			System.out.println(errorLog);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void readExcelFilesFolder(String folderPath, String sheetName){
		File[] listFile = new File(folderPath).listFiles();
		if(listFile != null){
			for(File file: listFile){
				String fileNamePath = file.getAbsolutePath();
				String fileName = file.getName();
				if(file.isFile() && (fileNamePath.toUpperCase().endsWith(".XLSX")) ){
					//Convert to text file
					readExcelSheet(fileNamePath, fileName, sheetName);
				}
			}
		}
	}
	
	private static void readExcelSheet(String fileNamePath, String fileName, String sheetName){
	    //InputStream inputProp = null;
		String resource = "pe/gob/sunafil/gentrama/util/properties/sunafil_resources.properties";
		//String resource = "gob/sunafil/xlsx/config.properties";		
	    Properties configProp = new Properties(); 
	    try{
	    	//inputProp = new FileInputStream("D://Willy//fileconverter//logueo//si.expedientesAB//src//gob//sunafil//xlsx//config.properties");    
		    //configProp.load(inputProp);	    	
	    	Reader reader = Resources.getResourceAsReader(resource);
	    	configProp.load(reader);
		    String breakpLine = "<br/>"+configProp.getProperty("breakpLine");
		    breakpLineWriter = configProp.getProperty("breakpLineWriter");
		    String folderPathExport = configProp.getProperty("ruta.txt");
		    //String folderPathExport = configProp.getProperty("folderPathExportBN");
		    InputStream inp = new FileInputStream(fileNamePath);
	    	Workbook wb = WorkbookFactory.create(inp);
	    	if(wb.getNumberOfSheets()!=6)//5 antes
			{
				//System.out.println("No hay suficientes libros en archivo "+fileName);
				errorLog+="No hay suficientes libros en archivo "+fileName+breakpLine;
				hayError=true;
				return;
			}
	    	else
	    	{
	    		System.out.println("Número de libros óptimo en archivo "+fileName);
	    		//errorLog+="Número de libros óptimo en archivo "+fileName+breakpLine;
	    	}
	    	boolean flagRepeat=false;
			List <String> allCodReg=new ArrayList<String>();
			List <String> allCodReg4=new ArrayList<String>();
			List <String> allCodReg5=new ArrayList<String>();
	    	for(int sheetNo=0; sheetNo < wb.getNumberOfSheets(); sheetNo++){
	    			
	    			Sheet sheet = wb.getSheetAt(sheetNo);
	    			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
	    			String content="";	    			
	    			
	    			if(sheetNo==4 || sheetNo==5)//3 y 4 antes
	    			{
	    				int columnCount=0;
	    				for (Row row : sheet) {
	    					if(row.getRowNum()!=0){
		    		        for (Cell cell : row) {
		    		            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
		    		            //System.out.print(cellRef.formatAsString());	
		    		            		    		            
		    		            //valida x celda
		    		            if(cell.getColumnIndex()==0)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, false),4,"0",0);
			    		        }
		    		            else if(cell.getColumnIndex()==1)
			    		        {
			    		        	content=completarCon(new Date().toLocaleString(),10," ",1);//recuperar fecha de BD
			    		        }
		    		            else if(cell.getColumnIndex()==2)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, false).replace("-", ""),10,"0",0);
			    		        	if(getCellContent(cell, evaluator, false).replace("-", "").length()!=10 && row.getRowNum()!=0)
			    		        	{
			    		        		errorLog+="Error de formato de PFF02-CODREG(debe tener 10 dígitos) en archivo "+fileName+", libro "+(sheetNo+1)+", en celda "+cellRef.formatAsString()+breakpLine;
			    		        		hayError=true;
			    		        	}
			    		        	if(sheetNo==4)
			    		        	{
			    		        		allCodReg4.add(content);
			    		        	}
			    		        	else if (sheetNo==5)
			    		        	{
			    		        		allCodReg5.add(content);
			    		        	}
			    		        	allCodReg.add(content);
			    		        }
		    		            else if(cell.getColumnIndex()==3)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, false),10,"0",0);
			    		        }
		    		            else if(cell.getColumnIndex()==4)
			    		        {
			    		        	//content=completarCon(getCellContent(cell, evaluator, false),10,"0",0);
		    		            	content=completarCon(getCellContent(cell, evaluator, false).replace("-", ""),10,"0",0);
			    		        	if(getCellContent(cell, evaluator, false).replace("-", "").length()!=10 && row.getRowNum()!=0)
			    		        	{
			    		        		errorLog+="Error de formato de PFF02-CCLIENTE(debe tener 10 dígitos) en archivo "+fileName+", libro "+(sheetNo+1)+", en celda "+cellRef.formatAsString()+breakpLine;
			    		        		hayError=true;
			    		        	}
			    		        }
		    		            else if(cell.getColumnIndex()==5)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, false),32," ",1);
			    		        	if("".equals(getCellContent(cell, evaluator, false).trim()))
			    		        	{
			    		        		errorLog+="Error de formato de PFF02-ACLIENTE(no debe estar vacío) en archivo "+fileName+", libro "+(sheetNo+1)+", en celda "+cellRef.formatAsString()+breakpLine;
			    		        		hayError=true;
			    		        	}
			    		        }
		    		            else if(cell.getColumnIndex()==6)
			    		        {
			    		        	//content=completarCon(getCellContent(cell, evaluator, false),10,"0",0);
		    		            	content=completarCon(getCellContent(cell, evaluator, false).replace("-", ""),10,"0",0);
			    		        	if(getCellContent(cell, evaluator, false).replace("-", "").length()!=10 && row.getRowNum()!=0)
			    		        	{
			    		        		errorLog+="Error de formato de PFF02-NFACTURA(debe tener 10 dígitos) en archivo "+fileName+", libro "+(sheetNo+1)+", en celda "+cellRef.formatAsString()+breakpLine;
			    		        		hayError=true;
			    		        	}
			    		        }
		    		            else if(cell.getColumnIndex()==7)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, false),3," ",1);
			    		        }
		    		            else if(cell.getColumnIndex()==8)
			    		        {
		    		            	String temp=getCellContent(cell, evaluator, false);
		    		            	//exp revisar
		    		            	if("".equalsIgnoreCase(temp))
		    		            	{
		    		            		try {
		    		            			temp=""+cell.getNumericCellValue();
										} catch (Exception e) {
											e.printStackTrace();
										}	
		    		            		if("".equalsIgnoreCase(temp))
		    		            		{
		    		            			try {
		    		            				temp=""+cell.getStringCellValue();
											} catch (Exception e) {
												// TODO: handle exception
											}
		    		            		}
		    		            	}		    		            	
		    		            	//end exp revisar
		    		            	if(temp.contains("."))
		    		            	{
		    		            		temp=completarCon(temp.split("\\.")[0],13,"0",0)+completarCon(temp.split("\\.")[1],2,"0",1);
		    		            		content=temp;
		    		            	}
		    		            	else if(temp.contains(","))
		    		            	{
		    		            		temp=completarCon(temp.split(",")[0],13,"0",0)+completarCon(temp.split(",")[1],2,"0",1);
		    		            		content=temp;
		    		            	}
		    		            	else
		    		            	{
		    		            		content=completarCon(getCellContent(cell, evaluator, false)+"00",15,"0",0);
		    		            	}		    
		    		            	//exp revisar
		    		            	System.out.println("col 8 ["+temp+"]");
		    		            	if("".equals(temp.trim()) || "000000000000000".equals(temp.trim()))
			    		        	{
			    		        		errorLog+="Error de formato de PFF02-SIMPORTE(debe ser diferente de cero) en archivo "+fileName+", libro "+(sheetNo+1)+", en celda "+cellRef.formatAsString()+breakpLine;
			    		        		hayError=true;
			    		        	}
		    		            	//end exp revisar
			    		        }
		    		            else if(cell.getColumnIndex()==9)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, true),10," ",1);
			    		        }
		    		            else if(cell.getColumnIndex()==10)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, false),8,"0",0);
			    		        }
		    		            else if(cell.getColumnIndex()==11)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, false).replace(".", "").replace(",", ""),15," ",1);		    		        	
			    		        }
		    		            else if(cell.getColumnIndex()==12)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, false),15,"0",0);
			    		        }
		    		            else if(cell.getColumnIndex()==13)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, false),15,"0",0);
			    		        }
		    		            else if(cell.getColumnIndex()==14)
			    		        {
			    		        	content=completarCon(getCellContent(cell, evaluator, false),25,"0",0);
			    		        }
		    		            if(content.contains("="))//|| content.contains("'") se quito por que puede haber nombres de empresa con apostrofes
		    		            {
		    		            	errorLog+="Error de formula en archivo "+fileName+", libro "+(sheetNo+1)+", en celda "+cellRef.formatAsString()+breakpLine;
		    		            	hayError=true;
		    		            }
		    		            content="";		    		            
		    		            //end valida x celda		    		            		    		            		    		            		    		            
		    		            
		    		            ++columnCount;		    		            			    		        
		    		        }	    		            	    		        	    		           
		    		        if(columnCount!=17)
		    		        {
		    		        	errorLog+="Número de columnas incorrectas("+columnCount+") en archivo "+fileName+", libro "+(sheetNo+1)+", En fila "+row.getRowNum()+breakpLine;
		    		        	hayError=true;
		    		        }
		    		        columnCount=0;
	    					}
		    		    }	  
	    			}			    			
	    	}
	    	//validacion de repetidos 4
	    	Set<String> set4 = new HashSet<String>(allCodReg4);
	    	System.out.println("set size "+set4.size() +"VS list size"+ allCodReg4.size());
	    	if(set4.size() < allCodReg4.size()){//solo la cabecera se repite
	    		errorLog+="Hay elementos duplicados en columna PFF02-CODREG, en libro 5 del archivo "+breakpLine;
	    		hayError=true;
	    		return;
	    	}
	    	//end validacion de repetidos 4
	    	//validacion de repetidos 5
	    	Set<String> set5 = new HashSet<String>(allCodReg5);
	    	System.out.println("set size "+set5.size() +"VS list size"+ allCodReg5.size());
	    	if(set5.size() < allCodReg5.size()){//solo la cabecera se repite
	    		errorLog+="Hay elementos duplicados en columna PFF02-CODREG, en libro 6 del archivo "+breakpLine;
	    		hayError=true;
	    		return;
	    	}
	    	//end validacion de repetidos 5
	    	//validacion de repetidos total
	    	Set<String> set = new HashSet<String>(allCodReg);
	    	System.out.println("set size "+set.size() +"VS list size"+ allCodReg.size());
	    	if(set.size() < allCodReg.size()){//solo la cabecera se repite
	    		errorLog+="Hay elementos duplicados en columna PFF02-CODREG, entre los libros 5 y 6 del archivo "+breakpLine;
	    		hayError=true;
	    	}
	    	//end validacion de repetidos total
	    }
	    catch(Exception ex){
	    	ex.printStackTrace();
	    }
	}
	
	private static String removeCharacterSpecial(String input){
	    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	    return output;
	}
	
	private static void createDocument(String newTextFile, String title, String poliza, String empresa, String fecha, String namefragment, String content){
		try
		{
			System.out.println("----------------------------");
			System.out.println("-- CREATE DOCUMENT INICIO --");
			System.out.println("----------------------------");
			System.out.println("newTextFile : " + newTextFile);
			
			File file = new File(newTextFile);
			FileOutputStream fosAll = new FileOutputStream(file);
			OutputStreamWriter oswAll = new OutputStreamWriter(new BufferedOutputStream(fosAll),"utf-8");
			Writer writer = new BufferedWriter(oswAll);
			
			writer.append(content);
			writer.close();
			file.createNewFile();
			
			if(file.exists()){
				System.out.println("create document text file: successful "+file.getName());				
			}else {
				System.out.println("create document text file: with error");
			}
			System.out.println("-------------------------");
			System.out.println("-- CREATE DOCUMENT FIN --");
			System.out.println("-------------------------");
		}
		catch(Exception ex){
			System.out.println("create document text file: with error");
			System.out.println("-------------------------");
			System.out.println("-- CREATE DOCUMENT FIN --");
			System.out.println("-------------------------");
		}
	}
	
	public static String getCellContent(Cell cell, FormulaEvaluator evaluator, Boolean isDate)
	{
		String content = "";
		switch (cell.getCellType()) {
	        case Cell.CELL_TYPE_STRING:
	        	content+=(cell.getRichStringCellValue().getString());
	            break;
	        case Cell.CELL_TYPE_NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	            	content+=(cell.getDateCellValue());
	            } else {
	            	content+=(cell.getNumericCellValue());
	            }
	            break;
	        case Cell.CELL_TYPE_BOOLEAN:
	        	content+=(cell.getBooleanCellValue());
	            break;
	        case Cell.CELL_TYPE_FORMULA:
	        	CellValue cellValue = evaluator.evaluate(cell);
	        	
	        	switch (cellValue.getCellType()) {
		            case Cell.CELL_TYPE_BOOLEAN:
		            	content+=(cellValue.getBooleanValue());
		                break;
		            case Cell.CELL_TYPE_NUMERIC:
		            	if(isDate)
		            	{
		            		content+=DateUtil.getJavaDate(cellValue.getNumberValue()).toLocaleString();
		            		//content+=(new Date((long)(cellValue.getNumberValue()*1000)).toLocaleString());
		            	}
		            	else
		            	{
		            		content+=(cellValue.getNumberValue());
		            	}
		                break;
		            case Cell.CELL_TYPE_STRING:
		            	content+=(cellValue.getStringValue());
		                break;
		            case Cell.CELL_TYPE_BLANK:
		            	content+="";
		                break;
		            case Cell.CELL_TYPE_ERROR:
		            	content+="";
		                break;
		            // CELL_TYPE_FORMULA will never happen
		            case Cell.CELL_TYPE_FORMULA: 
		                break;
		        }
	        	
	        	//content+=(cell.getCellFormula());
	            break;
	        default:
	            System.out.println();
	    }
		return content;
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