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

public class tramaConverterTxt {//para xlsx con apache poi

	public static String curDate;
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
	    	//head
	    	Row rowHead = sheet.createRow((short)lineNum);//
	    	rowHead.createCell(0).setCellValue("Código del Banco");//
	    	rowHead.createCell(1).setCellValue("Fecha de actualización de datos");//
	    	rowHead.createCell(2).setCellValue("Código asignado por el Beneficiario al registro");//
	    	rowHead.createCell(3).setCellValue("Código del Beneficiario");//
	    	rowHead.createCell(4).setCellValue("Código del cliente que realiza el pago al Beneficiario");//
	    	rowHead.createCell(5).setCellValue("Nombre del cliente que realizará el pago al Beneficiario");//
	    	rowHead.createCell(6).setCellValue("Referencia asignada por el Beneficiario al Pago-N° de Factura");//
	    	rowHead.createCell(7).setCellValue("Código de moneda");//
	    	rowHead.createCell(8).setCellValue("Monto del Pago");//
	    	rowHead.createCell(9).setCellValue("Fecha de Vencimiento del pago");//
	    	rowHead.createCell(10).setCellValue("Tasa de interés asignada por el Beneficiario al pago");//
	    	rowHead.createCell(11).setCellValue("Número de cuenta del Banco");//
	    	rowHead.createCell(12).setCellValue("Fecha de Pago");//
	    	rowHead.createCell(13).setCellValue("Hora de Pago");//
	    	rowHead.createCell(14).setCellValue("Interés cobrado");//
	    	rowHead.createCell(15).setCellValue("Monto pagado");//
	    	rowHead.createCell(16).setCellValue("Tipo de pago: T7 =efect, T8=cheque");//
	    	rowHead.createCell(17).setCellValue("Fecha Valor");//
	    	rowHead.createCell(18).setCellValue("Código de Agencia");//
	    	rowHead.createCell(19).setCellValue("Identificación del Corresponsal");//
	    	rowHead.createCell(20).setCellValue("Situación del Pago (0=cheque ok. 1 = chq. Rechazado)");//
	    	rowHead.createCell(21).setCellValue("Tipo de Cobranza");//
	    	rowHead.createCell(22).setCellValue("Monto en Efectivo");//
	    	rowHead.createCell(23).setCellValue("Monto en Cheque");//
	    	rowHead.createCell(24).setCellValue("Monto Revertido");//
	    	rowHead.createCell(25).setCellValue("Código del Banco del Cheque");//
	    	rowHead.createCell(26).setCellValue("Número de Cheque");//
	    	rowHead.createCell(27).setCellValue("PFF03-SGASTOS-DEVOL");//
	    	rowHead.createCell(28).setCellValue("PFF03-FDEVOLUC-CHEQ");//
	    	rowHead.createCell(29).setCellValue("Tipo de Cancelación");//
	    	rowHead.createCell(30).setCellValue("Libre");//
	    	rowHead.createCell(31).setCellValue("Libre");//
	    	rowHead.createCell(32).setCellValue("Libre");//
	    	//end head
	    	while ((line = br.readLine()) != null) {
	    		if(line.length()==333)//end SUB
	    		{	    			
	    			lineNum++;
		    		System.out.println("row : "+lineNum+" ::: "+line.length());
		    		Row row = sheet.createRow((short)lineNum);//
		    	    row.createCell(0).setCellValue(line.substring(0, 4));//
		    	    row.createCell(1).setCellValue(line.substring(4,14));//
		    	    row.createCell(2).setCellValue(line.substring(14,16)+"-"+line.substring(16,18)+"-"+line.substring(18,20)+"-"+line.substring(20,24));//CONFIG FORMAT(00-00-00-0000) line.substring(14,24)
		    	    row.createCell(3).setCellValue(line.substring(24,34));//
		    	    row.createCell(4).setCellValue(line.substring(34,44));//
		    	    row.createCell(5).setCellValue(line.substring(44,76));//
		    	    row.createCell(6).setCellValue(line.substring(76,86));//
		    	    row.createCell(7).setCellValue(line.substring(86,89));//
		    	    row.createCell(8).setCellValue(new Double(""+Integer.parseInt(line.substring(89,102))+"."+line.substring(102,104)));//DOS ULTIMOS DEC line.substring(89,104)
		    	    row.createCell(9).setCellValue(line.substring(104,114));//
		    	    row.createCell(10).setCellValue(new Double(""+Integer.parseInt(line.substring(114,118))+"."+line.substring(118,122)));//4 ULTIMOS DEC line.substring(114,122)
		    	    row.createCell(11).setCellValue(line.substring(122,132));//
		    	    row.createCell(12).setCellValue(line.substring(132,142));//
		    	    row.createCell(13).setCellValue(line.substring(142,147));//
		    	    row.createCell(14).setCellValue(new Double(""+Integer.parseInt(line.substring(147,160))+"."+line.substring(160,162)));//DOS ULTIMOS DEC line.substring(147,162)
		    	    row.createCell(15).setCellValue(new Double(""+Integer.parseInt(line.substring(162,175))+"."+line.substring(175,177)));//DOS ULTIMOS DEC line.substring(162,177)
		    	    row.createCell(16).setCellValue(line.substring(177,179));//
		    	    row.createCell(17).setCellValue(line.substring(179,189));//
		    	    row.createCell(18).setCellValue(line.substring(189,192));//
		    	    row.createCell(19).setCellValue(line.substring(192,202));//
		    	    row.createCell(20).setCellValue(line.substring(202,203));//
		    	    row.createCell(21).setCellValue(line.substring(203,205));//
		    	    row.createCell(22).setCellValue(line.substring(205,220));//
		    	    row.createCell(23).setCellValue(line.substring(220,235));//
		    	    row.createCell(24).setCellValue(line.substring(235,250));//
		    	    row.createCell(25).setCellValue(line.substring(250,254));//
		    	    row.createCell(26).setCellValue(line.substring(254,262));//
		    	    row.createCell(27).setCellValue(line.substring(262,277));//
		    	    row.createCell(28).setCellValue(line.substring(277,287));//
		    	    row.createCell(29).setCellValue(line.substring(287,288));//
		    	    row.createCell(30).setCellValue(line.substring(288,303));//
		    	    row.createCell(31).setCellValue(line.substring(303,318));//
		    	    row.createCell(32).setCellValue(line.substring(318,333));//
	    		}	    		
	    	}
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

	
}