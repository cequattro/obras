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
import java.util.List;
import java.util.Properties;

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

public class tramaConverterXlsx {//para xlsx con apache poi

	public static String curDate;
	public static String getCurDate() {
		return curDate;
	}

	public static void setCurDate(String curDate) {
		tramaConverterXlsx.curDate = curDate;
	}

	static String breakpLineWriter;
	public void Process(){
		try{
			Properties configProp = new Properties();
			//InputStream inputProp = new FileInputStream("config.properties");    
		    //configProp.load(inputProp);
			String resource = "pe/gob/sunafil/gentrama/util/properties/sunafil_resources.properties";
			//String resource = "gob/sunafil/xlsx/config.properties";
			Reader reader = Resources.getResourceAsReader(resource);
			configProp.load(reader);
		    
			String folderPathImport = configProp.getProperty("ruta.import.sin.slash");
			//String folderPathImport = configProp.getProperty("folderPathImportBN");
			String sheetName = configProp.getProperty("sufijo");
			readExcelFilesFolder(folderPathImport, sheetName);
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
	    	//inputProp = new FileInputStream("config.properties");    
		    //configProp.load(inputProp);
	    	Reader reader = Resources.getResourceAsReader(resource);
	    	configProp.load(reader);
		    String breakpLine = configProp.getProperty("breakpLine");
		    breakpLineWriter = configProp.getProperty("breakpLineWriter");
		    String folderPathExport = configProp.getProperty("ruta.txt");
		    //String folderPathExport = configProp.getProperty("folderPathExportBN");
		    InputStream inp = new FileInputStream(fileNamePath);
	    	Workbook wb = WorkbookFactory.create(inp);
	    	String content = "";
	    	for(int sheetNo=0; sheetNo < wb.getNumberOfSheets(); sheetNo++){
	    			
	    			Sheet sheet = wb.getSheetAt(sheetNo);
	    			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
	    			//String content = "";
	    			
	    			if(sheetNo==4 || sheetNo==5){//3 y 4 antes
	    			
	    			for (Row row : sheet) {
	    				if(row.getRowNum()!=0 && ("PENDIENTE".equalsIgnoreCase(getCellContent(row.getCell(16),evaluator,false)) || "VENCIDO".equalsIgnoreCase(getCellContent(row.getCell(16),evaluator,false)))){
	    		        for (Cell cell : row) {	    		        	
	    		        	
	    		            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
	    		            //System.out.print(cellRef.formatAsString());	    		            	    		          	    		            
	    		            
	    		            if(cell.getColumnIndex()==0)
		    		        {
		    		        	content+=completarCon(getCellContent(cell, evaluator, false),4,"0",0);
		    		        }
	    		            else if(cell.getColumnIndex()==1)
		    		        {
		    		        	content+=completarCon(getCurDate(),10," ",1);//recuperar fecha de BD new Date().toLocaleString()
		    		        }
	    		            else if(cell.getColumnIndex()==2)
		    		        {
		    		        	content+=completarCon(getCellContent(cell, evaluator, false).replace("-", ""),10,"0",0);
		    		        }
	    		            else if(cell.getColumnIndex()==3)
		    		        {
		    		        	content+=completarCon(getCellContent(cell, evaluator, false),10,"0",0);
		    		        }
	    		            else if(cell.getColumnIndex()==4)
		    		        {
		    		        	//content+=completarCon(getCellContent(cell, evaluator, false),10,"0",0);
	    		            	content+=completarCon(getCellContent(cell, evaluator, false).replace("-", ""),10,"0",0);
		    		        }
	    		            else if(cell.getColumnIndex()==5)
		    		        {
		    		        	content+=completarCon(removeCharacterSpecial(getCellContent(cell, evaluator, false)),32," ",1);
		    		        }
	    		            else if(cell.getColumnIndex()==6)
		    		        {
		    		        	//content+=completarCon(getCellContent(cell, evaluator, false),10,"0",0);
	    		            	content+=completarCon(getCellContent(cell, evaluator, false).replace("-", ""),10,"0",0);
		    		        }
	    		            else if(cell.getColumnIndex()==7)
		    		        {
		    		        	content+=completarCon(getCellContent(cell, evaluator, false),3," ",1);
		    		        }
	    		            else if(cell.getColumnIndex()==8)
		    		        {
	    		            	String temp=getCellContent(cell, evaluator, false);
	    		            	//System.out.println("importe ::: ["+temp+"] - "+cell.getNumericCellValue());
	    		            	if("".equalsIgnoreCase(temp))
	    		            	{
	    		            		temp=""+cell.getNumericCellValue();
	    		            	}
	    		            	if(temp.contains("."))
	    		            	{
	    		            		temp=completarCon(temp.split("\\.")[0],13,"0",0)+completarCon(temp.split("\\.")[1],2,"0",1);
	    		            		content+=temp;
	    		            	}
	    		            	else if(temp.contains(","))
	    		            	{
	    		            		temp=completarCon(temp.split(",")[0],13,"0",0)+completarCon(temp.split(",")[1],2,"0",1);
	    		            		content+=temp;
	    		            	}
	    		            	else
	    		            	{
	    		            		content+=completarCon(getCellContent(cell, evaluator, false)+"00",15,"0",0);
	    		            	}		    		        	
		    		        }
	    		            else if(cell.getColumnIndex()==9)
		    		        {
		    		        	content+=completarCon(getCellContent(cell, evaluator, true),10," ",1);
		    		        }
	    		            else if(cell.getColumnIndex()==10)
		    		        {
		    		        	content+=completarCon(getCellContent(cell, evaluator, false),8,"0",0);
		    		        }
	    		            else if(cell.getColumnIndex()==11)
		    		        {
		    		        	content+=completarCon(getCellContent(cell, evaluator, false).replace(".", "").replace(",", "").replace("E10", ""),15," ",1);		    		        	
		    		        }
	    		            else if(cell.getColumnIndex()==12)
		    		        {
		    		        	content+=completarCon(getCellContent(cell, evaluator, false),15,"0",0);
		    		        }
	    		            else if(cell.getColumnIndex()==13)
		    		        {
		    		        	content+=completarCon(getCellContent(cell, evaluator, false),15,"0",0);
		    		        }
	    		            else if(cell.getColumnIndex()==14)
		    		        {
		    		        	content+=completarCon(getCellContent(cell, evaluator, false),25,"0",0);
		    		        }	
	    		        }    	    		        	    		            	    		        	    		          
	    		        content+=breakpLine;
	    				}
	    		    }	    			
	    		    			
	    			/*String nameDocument = fileName.substring(0, fileName.length()-5);
	    			String newTextFileAll = folderPathExport + "//" + nameDocument;
	    			newTextFileAll = newTextFileAll + "_" + sheetName+"_libro" +sheetNo + ".txt";//al quitar [+"_libro" +sheetNo] se asume que solo habra un libro por archivo excel	    				    			    							
	    			String titleAll = "";
	    			String poliza = "";
	    			String empresa = "";
	    			String fecha = "";

	    			createDocument(newTextFileAll, titleAll, poliza, empresa, fecha, "", content);*/	  
	    			
	    		}
	    	}
	    	
	    	
	    	//new
	    	String nameDocument = fileName.substring(0, fileName.length()-5);	    			
			String newTextFileAll = folderPathExport + "/" + nameDocument;
			//String newTextFileAll = folderPathExport + "//" + nameDocument;
			newTextFileAll = newTextFileAll + "_" + sheetName+"_libros.txt";//al quitar [+"_libro" +sheetNo] se asume que solo habra un libro por archivo excel	    				    			    							
			String titleAll = "";
			String poliza = "";
			String empresa = "";
			String fecha = "";

			createDocument(newTextFileAll, titleAll, poliza, empresa, fecha, "", content);
	    	//end new
	    	
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
}