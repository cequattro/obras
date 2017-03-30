package pe.gob.sunafil.gestionpersonal.txt;

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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.MarcacionDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcCargamasiva;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcErrcarmas;

public class tramaConverterTxt {//para xlsx con apache poi

	public static String curDate;
	public static Date initDate;
	public static Date endDate;		
	public static String usuarioRegistro;
	public static String hostRegistro;	
	public static String grupoCargaGlobal;				

	public static String getGrupoCargaGlobal() {
		return grupoCargaGlobal;
	}

	public static void setGrupoCargaGlobal(String grupoCargaGlobal) {
		tramaConverterTxt.grupoCargaGlobal = grupoCargaGlobal;
	}

	public static String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public static void setUsuarioRegistro(String usuarioRegistro) {
		tramaConverterTxt.usuarioRegistro = usuarioRegistro;
	}

	public static String getHostRegistro() {
		return hostRegistro;
	}

	public static void setHostRegistro(String hostRegistro) {
		tramaConverterTxt.hostRegistro = hostRegistro;
	}

	public static Date getInitDate() {
		return initDate;
	}

	public static void setInitDate(Date initDate) {
		tramaConverterTxt.initDate = initDate;
	}

	public static Date getEndDate() {
		return endDate;
	}

	public static void setEndDate(Date endDate) {
		tramaConverterTxt.endDate = endDate;
	}

	public static String getCurDate() {
		return curDate;
	}

	public static void setCurDate(String curDate) {
		tramaConverterTxt.curDate = curDate;
	}

	static String breakpLineWriter;
	public void Process(){
		try{
			Properties configProp = new Properties();
			String resource = "pe/gob/sunafil/gestionpersonal/util/properties/mtpe_resources.properties";
			//String resource = "gob/sunafil/xlsx/config.properties";
			Reader reader = Resources.getResourceAsReader(resource);
			configProp.load(reader);		    
			String folderPathImport = configProp.getProperty("ruta.xls")+"/";
			//String folderPathImport = configProp.getProperty("folderTxt");			
			Workbook wb = new XSSFWorkbook();//
		    //Sheet sheet = wb.createSheet("Filas sin DNI");//
			BufferedReader br;
			br = new BufferedReader(new FileReader(folderPathImport+"temporal.txt"));
	    	String line;
	    	int lineNum=0;
	    	int lineTotal=0;
	    	int lineBD=0;
	    	int lineDeleted=0;
	    	int lineDepured=0;
	    	int lineMarcacionDepured=0;

	    	MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
	    	BigDecimal grupoCarga=new BigDecimal("0");
	    	try {
				grupoCarga=new BigDecimal(getSiguienteCorrelativoGrupoCargaMasiva());
				this.setGrupoCargaGlobal(""+grupoCarga);
			} catch (Exception e) {				
				e.printStackTrace();
			}
	    	//end head
	    	while ((line = br.readLine()) != null) {
	    		if(line.length()==37)//end SUB
	    		{	    	
	    			lineTotal++;
	    			
	    			String[] rowArray=line.split("	");	    			
	    			
	    			SimpleDateFormat simpleDate=new SimpleDateFormat("dd/MM/yyyy");
	    			Date dateRow=simpleDate.parse(rowArray[1].substring(8, 10)+"/"
							+rowArray[1].substring(5, 7)+"/"
							+rowArray[1].substring(0, 4));
	    			
	    			if(!dateRow.before(initDate) && !dateRow.after(endDate)){//fecha en carga masiva
	    			
	    			
	    			RhtbcCargamasiva entidad=new RhtbcCargamasiva();
	    			
	    			
	    			entidad.setnCodcarga(new BigDecimal(getSiguienteCorrelativoItemCargaMasiva()));	    			
	    			entidad.setvCodpersonal(rowArray[0].trim());
	    			entidad.setdFecha(dateRow);
	    			entidad.setnHora(new Short(rowArray[1].substring(11).split(":")[0]));
	    			entidad.setnMinuto(new Short(rowArray[1].substring(11).split(":")[1]));
	    			entidad.setnSegundo(new Short(rowArray[1].substring(11).split(":")[2]));
	    			entidad.setvCodusureg(this.getUsuarioRegistro());
	    			entidad.setdFecreg(new Date());
	    			entidad.setvHostreg(this.getHostRegistro());
	    			entidad.setnGrupocarga(new BigDecimal(this.getGrupoCargaGlobal()));
	    			
	    					 
	    			System.out.println("Insertando en carga masiva ::: Fecha : "+rowArray[1].substring(8, 10)+"/"
							+rowArray[1].substring(5, 7)+"/"
							+rowArray[1].substring(0, 4)+" Personal : "+rowArray[0].trim());
	    			marcacionDespatch.insertarItemCargaMasiva(entidad);
	    			
	    			boolean existePersonal=false;
	    			try {
	    				existePersonal=marcacionDespatch.getExistePersonal(rowArray[0].trim());
					} catch (Exception e) {
						existePersonal=false;
						e.printStackTrace();
					}
	    			if(!existePersonal)
	    			{//si no existe personal insertar en errores
	    				lineNum++;
	    				RhtbcErrcarmas error=new RhtbcErrcarmas();
		    					    			
	    				error.setnCoderror(new BigDecimal(getSiguienteCorrelativoItemError()));	    			
	    				error.setvCodpersonal(rowArray[0].trim());
	    				error.setdFecha(dateRow);
	    				error.setnHora(new Short(rowArray[1].substring(11).split(":")[0]));
	    				error.setnMinuto(new Short(rowArray[1].substring(11).split(":")[1]));
	    				error.setnSegundo(new Short(rowArray[1].substring(11).split(":")[2]));
	    				error.setvCodusureg(this.getUsuarioRegistro());
	    				error.setdFecreg(new Date());
		    			error.setvHostreg(this.getHostRegistro());
		    			error.setvMotivo("No existe un registro activo de personal con este número de documento.");
		    			error.setnGrupocarga(new BigDecimal(this.getGrupoCargaGlobal()));
		    			error.setnCodcarga(entidad.getnCodcarga());
		    					 
		    			System.out.println("Insertando en error ::: Fecha : "+rowArray[1].substring(8, 10)+"/"
								+rowArray[1].substring(5, 7)+"/"
								+rowArray[1].substring(0, 4)+" Personal : "+rowArray[0].trim());
		    			marcacionDespatch.insertarItemError(error);
	    			}
	    			else
	    			{
	    				if(dateRow.before(initDate) && dateRow.after(endDate))
	    				{//si la marcación leída no esta en el rango de fecha de carga
	    					RhtbcErrcarmas error=new RhtbcErrcarmas();
			    			
		    				error.setnCoderror(new BigDecimal(getSiguienteCorrelativoItemError()));	    			
		    				error.setvCodpersonal(rowArray[0].trim());
		    				error.setdFecha(dateRow);
		    				error.setnHora(new Short(rowArray[1].substring(11).split(":")[0]));
		    				error.setnMinuto(new Short(rowArray[1].substring(11).split(":")[1]));
		    				error.setnSegundo(new Short(rowArray[1].substring(11).split(":")[2]));
		    				error.setvCodusureg(this.getUsuarioRegistro());
		    				error.setdFecreg(new Date());
			    			error.setvHostreg(this.getHostRegistro());
			    			error.setvMotivo("La marcación no está en el rango de fecha de carga ingresado.");
			    			error.setnGrupocarga(new BigDecimal(this.getGrupoCargaGlobal()));
			    			error.setnCodcarga(entidad.getnCodcarga());
			    					 
			    			System.out.println("Insertando en error ::: Fecha : "+rowArray[1].substring(8, 10)+"/"
									+rowArray[1].substring(5, 7)+"/"
									+rowArray[1].substring(0, 4)+" Personal : "+rowArray[0].trim());
			    			marcacionDespatch.insertarItemError(error);
	    				}
	    			}
	    			}//end if fecha en carga masiva
	    			else
	    			{
	    				System.out.println("Linea "+lineTotal+" no cumple con filtro de fechas");
	    			}
	    		}	    		
	    	}
	    	
	    	List <RhtbcErrcarmas> rowsDepured=null;
	    	try {			
	    		System.out.println("Depurando items repetidos...");
	    		rowsDepured=marcacionDespatch.depurarCargaMasivaItemsRepetidos(new BigDecimal(this.getGrupoCargaGlobal()));
				if(rowsDepured!=null)
				{
					lineDepured=rowsDepured.size();
				}				
			} catch (Exception e) {
				rowsDepured=null;
				lineDepured=0;
				e.printStackTrace();
			}
	    	
	    	List <RhmvcMarcacion> marcacionesDepured=null;
	    	try {	
	    		System.out.println("Insertando marcaciones...");
	    		marcacionesDepured=marcacionDespatch.insertarCargaMasivaAMarcaciones(new BigDecimal(this.getGrupoCargaGlobal()));
				if(rowsDepured!=null)
				{
					lineMarcacionDepured=marcacionesDepured.size();
				}				
			} catch (Exception e) {
				marcacionesDepured=null;
				lineMarcacionDepured=0;
				e.printStackTrace();
			}
	    	
	    	List <RhtbcErrcarmas> errores=null;
	    	int lineasConError=0;
	    	try {						
	    		errores=marcacionDespatch.getErroresDeGrupo(new BigDecimal(this.getGrupoCargaGlobal()));
	    		int lineErrorCount=0;
	    	    Sheet sheet1 = wb.createSheet("Marcaciones con error");
	    	    
	    	    Row rowHead1 = sheet1.createRow((short)lineErrorCount);//
		    	rowHead1.createCell(0).setCellValue("Código del Personal");//
		    	rowHead1.createCell(1).setCellValue("Fecha y Hora");//
		    	rowHead1.createCell(2).setCellValue("Mensaje");//
				if(errores!=null)
				{
					lineasConError=marcacionesDepured.size();
					for (Iterator iterator = errores.iterator(); iterator
							.hasNext();) {
						RhtbcErrcarmas rhtbcErrcarmas = (RhtbcErrcarmas) iterator
								.next();
						lineErrorCount++;			    		
			    		Row row1 = sheet1.createRow((short)lineErrorCount);//		    		
			    	    row1.createCell(0).setCellValue(rhtbcErrcarmas.getvCodpersonal());//
			    	    row1.createCell(1).setCellValue(getFormatDate(rhtbcErrcarmas.getdFecha())+" "
			    	    								+completarCon(""+rhtbcErrcarmas.getnHora(),2,"0",0)+":"
			    	    								+completarCon(""+rhtbcErrcarmas.getnMinuto(),2,"0",0)+":"
			    	    								+completarCon(""+rhtbcErrcarmas.getnSegundo(),2,"0",0));//
			    	    row1.createCell(2).setCellValue(rhtbcErrcarmas.getvMotivo());
					}
				}				
			} catch (Exception e) {
				errores=null;
				lineasConError=0;
				e.printStackTrace();
			}	    		    	
    	    
    	    int lineNumResumen=0;
    	    Sheet sheet2 = wb.createSheet("Resumen de Carga");    	    
    	    
    	    Row rowHead2 = sheet2.createRow((short)lineNumResumen);//
	    	rowHead2.createCell(0).setCellValue("Resumen de Carga");//
	    	rowHead2.createCell(1).setCellValue(" ");//
	    	rowHead2.createCell(2).setCellValue(" ");//
	    	
	    	lineNumResumen++;	    	    		
    		Row row = sheet2.createRow((short)lineNumResumen);//		    		
    	    row.createCell(0).setCellValue("LINEAS LEIDAS");//
    	    row.createCell(1).setCellValue(""+lineTotal);//
    	    row.createCell(2).setCellValue("");
    	    lineNumResumen++;
    		Row row2 = sheet2.createRow((short)lineNumResumen);//		    		
    	    row2.createCell(0).setCellValue("LINEAS SIN DNI REGISTRADO");//
    	    row2.createCell(1).setCellValue(""+(lineNum));//
    	    row2.createCell(2).setCellValue("");    	        	        	    
    	    
    	    lineNumResumen++;    		
    		Row row3 = sheet2.createRow((short)lineNumResumen);//		    		
    	    row3.createCell(0).setCellValue("LINEAS INSERTADAS EN BASE DE DATOS");//
    	    row3.createCell(1).setCellValue(""+(lineMarcacionDepured));//
    	    row3.createCell(2).setCellValue("");
    	    lineNumResumen++;    		
    		Row row4 = sheet2.createRow((short)lineNumResumen);//		    		
    	    row4.createCell(0).setCellValue("LINEAS CON MINUTOS REPETIDOS OMITIDAS");//
    	    row4.createCell(1).setCellValue(""+(lineDepured));//
    	    row4.createCell(2).setCellValue("");
    	    
	    	//endresumen totales
	    	 
	    	FileOutputStream fileOut;//
			fileOut = new FileOutputStream(folderPathImport+"workbookOut.xlsx");//
			wb.write(fileOut);//
			fileOut.close();//
	    	br.close();						
		}
		catch(Exception ex){
			ex.printStackTrace();
		}		
	}
	
	public String getSiguienteCorrelativoGlobalMarcacion()
	{
		MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
		try {
			RhmvcMarcacion correlativo=marcacionDespatch.getCorrelativoGlobalMarcacion();
			if(correlativo!=null)
			{
				return ""+(Long.parseLong(""+correlativo.getnCodmarcacion())+1);
			}
			else
			{
				//devuelve correlativo en 1				
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	public String getSiguienteCorrelativoItemCargaMasiva()
	{
		MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
		try {
			RhtbcCargamasiva correlativo=marcacionDespatch.getCorrelativoGlobalItemCargaMasiva();
			if(correlativo!=null)
			{
				return ""+(Long.parseLong(""+correlativo.getnCodcarga())+1);
			}
			else
			{
				//devuelve correlativo en 1				
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	public String getSiguienteCorrelativoGrupoCargaMasiva()
	{
		MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
		try {
			RhtbcCargamasiva correlativo=marcacionDespatch.getCorrelativoGlobalGrupoCargaMasiva();
			if(correlativo!=null)
			{
				return ""+(Long.parseLong(""+correlativo.getnGrupocarga())+1);
			}
			else
			{
				//devuelve correlativo en 1				
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	public String getSiguienteCorrelativoItemError()
	{
		MarcacionDespatch marcacionDespatch = new MarcacionDespatch();
		try {
			RhtbcErrcarmas correlativo=marcacionDespatch.getCorrelativoGlobalItemError();
			if(correlativo!=null)
			{
				return ""+(Long.parseLong(""+correlativo.getnCoderror())+1);
			}
			else
			{
				//devuelve correlativo en 1				
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	public String getFormatDate(Date date) {
		if(date!=null)
		{
			return new SimpleDateFormat("dd/MM/yyyy").format(date);
		}
		else
		{
			return "";
		}
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