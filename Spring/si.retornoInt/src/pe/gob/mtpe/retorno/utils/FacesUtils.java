package pe.gob.mtpe.retorno.utils;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class FacesUtils { 

	final static Logger logger=Logger.getLogger(FacesUtils.class);
	
	public static Object getSessionAttribute(String attribute) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(false);
		Object o = null;
		if (session!=null) {
			o = session.getAttribute(attribute);
		}
		return o;
	}
	
	public static void setSessionAttribute(String attribue, Object value) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(false);
		session.setAttribute(attribue, value);
	}
	
	public static void removeSessionAttribute(String attribute) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(false);
		session.removeAttribute(attribute);
	}
	
	public static void removeUsuarioLogueado() {
		removeSessionAttribute("usuario");
	}
	
	public static void showFacesMessage(String texto, int tipo) {
		switch (tipo) {
		case 1:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, texto, "Error"));
			break;
		case 2:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, texto, "Fatal"));
			break;
		case 3:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, texto, "Informacion"));
			break;
		case 4:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, texto, "Advertencia"));
			break;
		default:
			break;
		}
	}
	
	 public static void refrescante() {
		    FacesContext context = FacesContext.getCurrentInstance();
		    Application application = context.getApplication();
		    ViewHandler viewHandler = application.getViewHandler();
		    UIViewRoot viewRoot = viewHandler.createView(context, context
		     .getViewRoot().getViewId());
		    context.setViewRoot(viewRoot);
		    context.renderResponse(); 
		  }
	 
	 public static void mostrarReporte(Map parameters,String reporte,List lista, String nombreReporte) throws  JRException,IOException{
	    	
	   	 byte[] bytes=null;
	   	 	 parameters.put("PV_RUTA_IMAGEN",FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/logos/logo_mtpe.png")) ;
	         logger.info(" 1 ======>"+reporte);
	         ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	         logger.info(" 2 ======>");
	        
	         logger.info(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         JasperDesign jasperDesign = JRXmlLoader.load(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         logger.info(" 3 ======>");
	         JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
	         logger.info(" 4 ======>");
	         bytes = JasperRunManager.runReportToPdf(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         
	         HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	        
	         response.setHeader("Content-Disposition", "inline; filename=\""+nombreReporte+".pdf\";");
	         
	         ServletOutputStream ouputStream = response.getOutputStream();
	         
	         FacesContext facesContext = FacesContext.getCurrentInstance();
	          try {
	        	  logger.info(" 5 ======>");
	        	 
	              if(bytes != null && bytes.length > 0){
	            	
	                    JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
	                   
	                    ouputStream.flush();
	                    ouputStream.close();
	               	  
	                    facesContext.responseComplete();
	                    facesContext.renderResponse();
	                    logger.info(" 6 ======>");
	                    
	            }
	              
	              logger.info(" 7 ======>");
	         } catch (Exception e) {
	            e.printStackTrace();
	         }finally{
	        	 
	         }
	          

	  }
	 
	 public static void  mostrarReporteWorkbookExcel(Workbook wb,String nombreReporte) throws IOException{
			//=================================================
	        //SEGUIMOS LOS PASOS PARA MOSTRAR EL OUTPUTsTREAM
	        //================================================
			HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        response.setHeader("Content-Disposition", "inline; filename=\""+nombreReporte+".xlsx\";");
				
			ServletOutputStream ouputStream = response.getOutputStream();		
			wb.write(ouputStream);	
			ouputStream.flush();		
			ouputStream.close();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.responseComplete();
			facesContext.renderResponse();
		 }
	 
	 public static void mostrarReporteExcel(Map parameters,String reporte,List lista, String nombreReporte) throws  JRException,IOException{
	    	
	   	 byte[] bytes=null;
	   	 	 //parameters.put("PV_RUTA_IMAGEN",FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/logos/logo_mtpe.png")) ;
	         logger.info(" 1 ======>"+reporte);
	         ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	         logger.info(" 2 ======>");
	        
	         logger.info(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         JasperDesign jasperDesign = JRXmlLoader.load(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         logger.info(" 3 ======>");
	         JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
	         logger.info(" 4 ======>");
	         
	         JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         
	         JRXlsExporter exporterXLS=new JRXlsExporter();
	         
	         
	         HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	         response.setContentType("application/ms-excel");
			 response.setHeader("Content-Disposition", "inline; filename=\""+nombreReporte+".xls\";");	
	         
	         ServletOutputStream ouputStream = response.getOutputStream();
	         ByteArrayOutputStream output = new ByteArrayOutputStream();
	         
	         FacesContext facesContext = FacesContext.getCurrentInstance();
	         
	            
	          try {
	        	  logger.info(" 5 ======>");
	        	 
	        	 
	        	  exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
	        	  exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BACKGROUND, Boolean.FALSE);
	        	  exporterXLS.setParameter(JRXlsExporterParameter.CREATE_CUSTOM_PALETTE, Boolean.TRUE);
	        	  
	        	  exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            	  exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
            	  exporterXLS.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.FALSE);
	        	  exporterXLS.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,Boolean.FALSE);
	        	  exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.FALSE);
	        	
	        	  
	        	  exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
	        	  exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
	        	 
	        	  exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
	        	  exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, ouputStream);
	        	
	         
	            	  exporterXLS.exportReport();
	            	  ouputStream.write(output.toByteArray());
	            	  
	                   
	                    ouputStream.flush();
	                    ouputStream.close();
	               	  
	                    facesContext.responseComplete();
	                    facesContext.renderResponse();
	                    logger.info(" 6 ======>");
	                    
	          
	              
	              logger.info(" 7 ======>");
	         } catch (Exception e) {
	            e.printStackTrace();
	         }finally{
	        	 ouputStream.flush();
                 ouputStream.close();
	         }
	          

	  }
	 
	 
	
	 
	 public static void mostrarPDF(String rutaCadena,String nombreArchivo)throws Exception{		
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();        
        String ruta=rutaCadena;
        File file = new File(ruta, nombreArchivo);
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            
            input = new BufferedInputStream(new FileInputStream(file), 1024);

            
            response.reset();
            response.setHeader("Content-Type", "application/pdf");
            response.setHeader("Content-Length", String.valueOf(file.length()));
            response.setHeader("Content-Disposition", "inline; filename=\"" + nombreArchivo + "\"");
            output = new BufferedOutputStream(response.getOutputStream(), 1024);

           
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }

            
            output.flush();
        } finally {
            
            close(output);
            close(input);
        }

      
        facesContext.responseComplete();
		 
		 
		 
	}
	 private static void close(Closeable resource) {
	        if (resource != null) {
	            try {
	                resource.close();
	            } catch (IOException e) {
	                
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 
	 public static String getIpAddress(){
		 HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		 String ip = "";
		 ip = request.getRemoteAddr();  
		 return ip;
	 }
	 
	
	 public static void  crearEstilosToWorkbook(Workbook wb,CellStyle style0,CellStyle style1,CellStyle style2){
		//=================================================================
		//INI CREANDO LOS ESTILOS:
		//=========================================================
		Font font = wb.createFont();
 	    font.setColor(HSSFColor.BLACK.index);
 	    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
 	    
 	    style0.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
 	    style0.setFillPattern(CellStyle.SOLID_FOREGROUND);
 	    style0.setFont(font);		    	    
 	    style0.setAlignment(CellStyle.ALIGN_CENTER);
 	   
 	    style1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
 	    style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
 	    style1.setFont(font);
 	    style1.setBorderBottom(CellStyle.BORDER_THIN);
 	    style1.setBorderTop(CellStyle.BORDER_THIN);
 	    style1.setBorderRight(CellStyle.BORDER_THIN);
 	    style1.setBorderLeft(CellStyle.BORDER_THIN);
 	    style1.setAlignment(CellStyle.ALIGN_CENTER);
 	    
 	   
	    style2.setBorderBottom(CellStyle.BORDER_THIN);
	    style2.setBorderTop(CellStyle.BORDER_THIN);
	    style2.setBorderRight(CellStyle.BORDER_THIN);
	    style2.setBorderLeft(CellStyle.BORDER_THIN);
	    style2.setAlignment(CellStyle.ALIGN_CENTER);
 	    //=============================================================
 	    //FIN CREANDO ESTILOS
 	    //=============================================================
	 }
	 
	 public static void  crearEncabezadoReporte15(Workbook wb,Sheet sheet, Row row, CellStyle style0,CellStyle style1, int lineNum){
		//=============================================================
 	    //INI CREANDO ENCABEZADOS
 	    //=============================================================
 	        	    
 	    //===============  LINEA 1   ==================
	    
	    Cell cell=row.createCell(0);//PRIMERA CELDA DE LA FILA 1
	    cell.setCellValue("REPORTE DE POTENCIALES RETORNANTES POR GENERO SEGUN TIEMPO DE DESEMPLEO");
	    cell.setCellStyle(style0);//LE AGREGAMOS EL ESTILO 0
	    //COMBINAMOS UN AREA DELIMINADA POR SUS CUATRO COORDENADAS POR ASI DECIRLO
 	    sheet.addMergedRegion(new CellRangeAddress(
 	            0, //first row (0-based)
 	            0, //last row  (0-based)
 	            0, //first column (0-based)
 	            8  //last column  (0-based)
 	    ));
 	    ++lineNum;//1 
 	    
 	    //===============  LINEA 2   ==================
 	    row = sheet.createRow((short)lineNum);//FILA 2
 	    row.createCell(0).setCellValue(" ");//PRIMERA CELDA DE LA FILA 2
 	    //COMBINAMOS UN AREA DELIMINADA POR SUS CUATRO COORDENADAS POR ASI DECIRLO
 	    sheet.addMergedRegion(new CellRangeAddress(
 	    		lineNum, //first row (0-based)
 	    		lineNum, //last row  (0-based)
 	            0, //first column (0-based)
 	            8  //last column  (0-based)
 	    ));
 	    ++lineNum;//2
 	    
 	    
 	    //===============  LINEA 3   ==================
 	    row = sheet.createRow((short)lineNum);//FILA 3
 	    
 	    cell = row.createCell(1);//CELDA 1
 	    cell.setCellValue("TIEMPO DE DESEMPLEO");//PRIMERA CELDA DE LA FILA 2
 	    sheet.addMergedRegion(new CellRangeAddress(
 	    		lineNum, //first row (0-based)
 	    		4, //last row  (0-based)
 	            1, //first column (0-based)
 	            1  //last column  (0-based)
 	    ));
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    
 	    cell = row.createCell(2);//CELDA 2
 	    cell.setCellValue("GENERO");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    sheet.addMergedRegion(new CellRangeAddress(
 	    		lineNum, //first row (0-based)
 	    		lineNum, //last row  (0-based)
 	            2, //first column (0-based)
 	            4  //last column  (0-based)
 	    ));
 	    row.createCell(3).setCellStyle(style1);//CELDA 3
 	    row.createCell(4).setCellStyle(style1);//CELDA 4	    	    
 	    ++lineNum;//3
 	    
 	    //===============  LINEA 4   ==================
 	    row = sheet.createRow((short)lineNum);//FILA 4
 	    row.createCell(1).setCellStyle(style1);//CELDA 1		    	    
 	    cell = row.createCell(2);//CELDA 2
 	    cell.setCellValue("HOMBRES");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    cell = row.createCell(3);//CELDA 2
 	    cell.setCellValue("MUJERES");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    cell = row.createCell(4);//CELDA 2
 	    cell.setCellValue("TOTAL");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    ++lineNum;//4
 	    
 	    //===============  LINEA 5   ==================
 	    row = sheet.createRow((short)lineNum);//FILA 4
 	    row.createCell(1).setCellStyle(style1);//CELDA 1
 	    cell = row.createCell(2);//CELDA 2
 	    cell.setCellValue("N");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    cell = row.createCell(3);//CELDA 2
 	    cell.setCellValue("N");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    cell = row.createCell(4);//CELDA 2
 	    cell.setCellValue("N");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    ++lineNum;//5
 	    //=============================================================
 	    //FIN CREANDO ENCABEZADOS
 	    //=============================================================
	}
	 
	 public static void  crearEncabezadoReporte16(Workbook wb,Sheet sheet, Row row, CellStyle style0,CellStyle style1, int lineNum){
		//=============================================================
 	    //INI CREANDO ENCABEZADOS
 	    //=============================================================
 	        	    
 	    //===============  LINEA 1   ==================
	    
	    Cell cell=row.createCell(0);//PRIMERA CELDA DE LA FILA 1
	    cell.setCellValue("REPORTE DE POTENCIALES RETORNANTES POR GRUPOS DE EDAD SEGUN TIEMPO DE DESEMPLEO");
	    cell.setCellStyle(style0);//LE AGREGAMOS EL ESTILO 0
	    //COMBINAMOS UN AREA DELIMINADA POR SUS CUATRO COORDENADAS POR ASI DECIRLO
 	    sheet.addMergedRegion(new CellRangeAddress(
 	            0, //first row (0-based)
 	            0, //last row  (0-based)
 	            0, //first column (0-based)
 	            11  //last column  (0-based)
 	    ));
 	    ++lineNum;//1 
 	    
 	    //===============  LINEA 2   ==================
 	    row = sheet.createRow((short)lineNum);//FILA 2
 	    row.createCell(0).setCellValue(" ");//PRIMERA CELDA DE LA FILA 2
 	    //COMBINAMOS UN AREA DELIMINADA POR SUS CUATRO COORDENADAS POR ASI DECIRLO
 	    sheet.addMergedRegion(new CellRangeAddress(
 	    		lineNum, //first row (0-based)
 	    		lineNum, //last row  (0-based)
 	            0, //first column (0-based)
 	            11  //last column  (0-based)
 	    ));
 	    ++lineNum;//2
 	    
 	    
 	    //===============  LINEA 3   ==================
 	    row = sheet.createRow((short)lineNum);//FILA 3
 	    
 	    cell = row.createCell(1);//CELDA 1
 	    cell.setCellValue("TIEMPO DE DESEMPLEO");//PRIMERA CELDA DE LA FILA 2
 	    sheet.addMergedRegion(new CellRangeAddress(
 	    		lineNum, //first row (0-based)
 	    		5, //last row  (0-based)
 	            1, //first column (0-based)
 	            1  //last column  (0-based)
 	    ));
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    
 	    cell = row.createCell(2);//CELDA 2
 	    cell.setCellValue("GRUPOS DE EDAD");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    sheet.addMergedRegion(new CellRangeAddress(
 	    		lineNum, //first row (0-based)
 	    		lineNum, //last row  (0-based)
 	            2, //first column (0-based)
 	            10  //last column  (0-based)
 	    ));
	 	row.createCell(3).setCellStyle(style1);//CELDA 3
	 	row.createCell(4).setCellStyle(style1);//CELDA 4
	 	row.createCell(5).setCellStyle(style1);//CELDA 5
	 	row.createCell(6).setCellStyle(style1);//CELDA 6
	 	row.createCell(7).setCellStyle(style1);//CELDA 7
	 	row.createCell(8).setCellStyle(style1);//CELDA 8
	 	row.createCell(9).setCellStyle(style1);//CELDA 9
	 	row.createCell(10).setCellStyle(style1);//CELDA 10
 	    ++lineNum;//3
 	    
 	    //===============  LINEA 4   ==================
 	    row = sheet.createRow((short)lineNum);//FILA 4
 	    row.createCell(1).setCellStyle(style1);//CELDA 1		    	    
 	    
 	    cell = row.createCell(2);//CELDA 2
 	    cell.setCellValue("Joven");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    sheet.addMergedRegion(new CellRangeAddress(
	    		lineNum, //first row (0-based)
	    		lineNum, //last row  (0-based)
	            2, //first column (0-based)
	            3  //last column  (0-based)
	    ));
 	    row.createCell(3).setCellStyle(style1);//CELDA 3
 	   
 	    cell = row.createCell(4);
 	    cell.setCellValue("Adulto Joven");
 	    cell.setCellStyle(style1);
 	    sheet.addMergedRegion(new CellRangeAddress(
	    		lineNum, //first row (0-based)
	    		lineNum, //last row  (0-based)
	            4, //first column (0-based)
	            5  //last column  (0-based)
	    ));
	    row.createCell(5).setCellStyle(style1);//CELDA 5
	   
	    cell = row.createCell(6);
 	    cell.setCellValue("Adulto");
 	    cell.setCellStyle(style1);
 	    sheet.addMergedRegion(new CellRangeAddress(
	    		lineNum, //first row (0-based)
	    		lineNum, //last row  (0-based)
	            6, //first column (0-based)
	            7  //last column  (0-based)
	    ));
	    row.createCell(7).setCellStyle(style1);//CELDA 5
 	    
	    cell = row.createCell(8);
 	    cell.setCellValue("Adulto Mayor");
 	    cell.setCellStyle(style1);
 	    sheet.addMergedRegion(new CellRangeAddress(
	    		lineNum, //first row (0-based)
	    		lineNum, //last row  (0-based)
	            8, //first column (0-based)
	            9  //last column  (0-based)
	    ));
	    row.createCell(9).setCellStyle(style1);//CELDA 5
	    
 	    cell = row.createCell(10);//CELDA 2
 	    cell.setCellValue("TOTAL");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    ++lineNum;//4
 	    
 	    //===============  LINEA 5   ==================
 	    row = sheet.createRow((short)lineNum);//FILA 4
 	    row.createCell(1).setCellStyle(style1);//CELDA 1		    	    
 	    
 	    cell = row.createCell(2);//CELDA 2
 	    cell.setCellValue("15 - 29");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    sheet.addMergedRegion(new CellRangeAddress(
	    		lineNum, //first row (0-based)
	    		lineNum, //last row  (0-based)
	            2, //first column (0-based)
	            3  //last column  (0-based)
	    ));
 	    row.createCell(3).setCellStyle(style1);//CELDA 3
 	   
 	    cell = row.createCell(4);
 	    cell.setCellValue("30 - 44");
 	    cell.setCellStyle(style1);
 	    sheet.addMergedRegion(new CellRangeAddress(
	    		lineNum, //first row (0-based)
	    		lineNum, //last row  (0-based)
	            4, //first column (0-based)
	            5  //last column  (0-based)
	    ));
	    row.createCell(5).setCellStyle(style1);//CELDA 5
	   
	    cell = row.createCell(6);
 	    cell.setCellValue("45 - 59");
 	    cell.setCellStyle(style1);
 	    sheet.addMergedRegion(new CellRangeAddress(
	    		lineNum, //first row (0-based)
	    		lineNum, //last row  (0-based)
	            6, //first column (0-based)
	            7  //last column  (0-based)
	    ));
	    row.createCell(7).setCellStyle(style1);//CELDA 5
 	    
	    cell = row.createCell(8);
 	    cell.setCellValue("60 A +");
 	    cell.setCellStyle(style1);
 	    sheet.addMergedRegion(new CellRangeAddress(
	    		lineNum, //first row (0-based)
	    		lineNum, //last row  (0-based)
	            8, //first column (0-based)
	            9  //last column  (0-based)
	    ));
	    row.createCell(9).setCellStyle(style1);//CELDA 5
	    
 	    cell = row.createCell(10);//CELDA 2
 	    cell.setCellValue("");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    ++lineNum;//5
 	    
 	    //===============  LINEA 6   ==================
 	    row = sheet.createRow((short)lineNum);//FILA 4
 	    row.createCell(1).setCellStyle(style1);//CELDA 1
 	    
 	    cell = row.createCell(2);//CELDA 2
 	    cell.setCellValue("N");//PRIMERA CELDA DE LA FILA 2
 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
 	    
 	    cell = row.createCell(3);
 	    cell.setCellValue("%");
 	    cell.setCellStyle(style1);
 	    
 	    cell = row.createCell(4);
	    cell.setCellValue("N");
	    cell.setCellStyle(style1);
 	    
	    cell = row.createCell(5);
 	    cell.setCellValue("%");
 	    cell.setCellStyle(style1);
 	    
 	    cell = row.createCell(6);
	    cell.setCellValue("N");
	    cell.setCellStyle(style1);
	    
	    cell = row.createCell(7);
 	    cell.setCellValue("%");
 	    cell.setCellStyle(style1);
 	    
 	    cell = row.createCell(8);
	    cell.setCellValue("N");
	    cell.setCellStyle(style1);
	    
	    cell = row.createCell(9);
 	    cell.setCellValue("%");
 	    cell.setCellStyle(style1);
 	    
 	    cell = row.createCell(10);
	    cell.setCellValue("");
	    cell.setCellStyle(style1);
	    
 	    ++lineNum;//6
 	    //=============================================================
 	    //FIN CREANDO ENCABEZADOS
 	    //=============================================================
	}
	 
	 public static void  crearEncabezadoReporte17(Workbook wb,Sheet sheet, Row row, CellStyle style0,CellStyle style1, int lineNum){
			//=============================================================
	 	    //INI CREANDO ENCABEZADOS
	 	    //=============================================================
	 	        	    
	 	    //===============  LINEA 1   ==================
		    
		    Cell cell=row.createCell(0);//PRIMERA CELDA DE LA FILA 1
		    cell.setCellValue("REPORTE DE POTENCIALES RETORNANTES Y FAMILIARES, POR GRUPOS QUINQUENALES DE EDAD, SEGUN PAIS DE RESIDENCIA");
		    cell.setCellStyle(style0);//LE AGREGAMOS EL ESTILO 0
		    //COMBINAMOS UN AREA DELIMINADA POR SUS CUATRO COORDENADAS POR ASI DECIRLO
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	            0, //first row (0-based)
	 	            0, //last row  (0-based)
	 	            0, //first column (0-based)
	 	            37  //last column  (0-based)
	 	    ));
	 	    ++lineNum;//1 
	 	    
	 	    //===============  LINEA 2   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 2
	 	    row.createCell(0).setCellValue(" ");//PRIMERA CELDA DE LA FILA 2
	 	    //COMBINAMOS UN AREA DELIMINADA POR SUS CUATRO COORDENADAS POR ASI DECIRLO
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	    		lineNum, //first row (0-based)
	 	    		lineNum, //last row  (0-based)
	 	            0, //first column (0-based)
	 	            37  //last column  (0-based)
	 	    ));
	 	    ++lineNum;//2
	 	    
	 	    
	 	    //===============  LINEA 3   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 3
	 	    
	 	    cell = row.createCell(1);//CELDA 1
	 	    cell.setCellValue("PAIS DE RESIDENCIA");//PRIMERA CELDA DE LA FILA 2
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	    		lineNum, //first row (0-based)
	 	    		4, //last row  (0-based)
	 	            1, //first column (0-based)
	 	            1  //last column  (0-based)
	 	    ));
	 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
	 	    
	 	    cell = row.createCell(2);//CELDA 2
	 	    cell.setCellValue("GRUPOS QUINQUENAL DE EDAD");//PRIMERA CELDA DE LA FILA 2
	 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	    		lineNum, //first row (0-based)
	 	    		lineNum, //last row  (0-based)
	 	            2, //first column (0-based)
	 	            36  //last column  (0-based)
	 	    ));
	 	    for(int i=3; i<=36; i++){
	 	    	row.createCell(i).setCellStyle(style1);//CELDA 3
	 	    }
	 	    ++lineNum;//3
	 	    
	 	    //===============  LINEA 4   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 4
	 	    row.createCell(1).setCellStyle(style1);//CELDA 1		    	    
	 	    int ini=0;
		    int fin=4;
		    for(int i=2; i<=35; i++){
		    	cell = row.createCell(i);
		    	if(fin==84){
		    		cell.setCellValue(ini+" A +");
		    	}else{
		    		cell.setCellValue(ini+"-"+fin);
		    	}
		 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
		 	    sheet.addMergedRegion(new CellRangeAddress(
			    		lineNum, //first row (0-based)
			    		lineNum, //last row  (0-based)
			            i, //first column (0-based)
			            i+1  //last column  (0-based)
			    ));
		 	    i=i+1;
		 	    ini=ini+5;
		 	    fin=fin+5;
		 	    row.createCell(i).setCellStyle(style1);
	 	    }
		    cell = row.createCell(36);//CELDA 2
	 	    cell.setCellValue("TOTAL");//PRIMERA CELDA DE LA FILA 2
	 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
	 	    ++lineNum;//4
	 	    
	 	    
	 	    //===============  LINEA 5   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 4
	 	    row.createCell(1).setCellStyle(style1);//CELDA 1
	 	    
	 	    for(int i=2; i<=35; i++){
	 	    	cell = row.createCell(i);
	 	    	if(i%2==0){
	 	    		cell.setCellValue("N");
	 	    	}else{
	 	    		cell.setCellValue("%");
	 	    	}
		 	    cell.setCellStyle(style1);
	 	    }
	 	    cell = row.createCell(36);
	 	    cell.setCellValue("");
	 	    cell.setCellStyle(style1);
	 	    ++lineNum;//5
	 	    //=============================================================
	 	    //FIN CREANDO ENCABEZADOS
	 	    //=============================================================
		}
	 
	 
	 public static void  crearEncabezadoReporte18(Workbook wb,Sheet sheet, Row row, CellStyle style0,CellStyle style1, int lineNum){
			//=============================================================
	 	    //INI CREANDO ENCABEZADOS
	 	    //=============================================================
	 	        	    
	 	    //===============  LINEA 1   ==================
		    
		    Cell cell=row.createCell(0);//PRIMERA CELDA DE LA FILA 1
		    cell.setCellValue("REPORTE DE POTENCIALES RETORNANTES Y FAMILIARES POR GENERO SEGUN DEPARTAMENTO DE RETORNO");
		    cell.setCellStyle(style0);//LE AGREGAMOS EL ESTILO 0
		    //COMBINAMOS UN AREA DELIMINADA POR SUS CUATRO COORDENADAS POR ASI DECIRLO
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	            0, //first row (0-based)
	 	            0, //last row  (0-based)
	 	            0, //first column (0-based)
	 	            7  //last column  (0-based)
	 	    ));
	 	    ++lineNum;//1 
	 	    
	 	    //===============  LINEA 2   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 2
	 	    row.createCell(0).setCellValue(" ");//PRIMERA CELDA DE LA FILA 2
	 	    //COMBINAMOS UN AREA DELIMINADA POR SUS CUATRO COORDENADAS POR ASI DECIRLO
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	    		lineNum, //first row (0-based)
	 	    		lineNum, //last row  (0-based)
	 	            0, //first column (0-based)
	 	            7  //last column  (0-based)
	 	    ));
	 	    ++lineNum;//2
	 	    
	 	    
	 	    //===============  LINEA 3   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 3
	 	    
	 	    cell = row.createCell(1);//CELDA 1
	 	    cell.setCellValue("TIEMPO DE DESEMPLEO");//PRIMERA CELDA DE LA FILA 2
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	    		lineNum, //first row (0-based)
	 	    		4, //last row  (0-based)
	 	            1, //first column (0-based)
	 	            1  //last column  (0-based)
	 	    ));
	 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
	 	    
	 	    cell = row.createCell(2);//CELDA 2
	 	    cell.setCellValue("GENERO");//PRIMERA CELDA DE LA FILA 2
	 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	    		lineNum, //first row (0-based)
	 	    		lineNum, //last row  (0-based)
	 	            2, //first column (0-based)
	 	            6  //last column  (0-based)
	 	    ));
	 	    for(int i=3; i<=6; i++){
	 	    	row.createCell(i).setCellStyle(style1);
	 	    }
	 	    ++lineNum;//3
	 	    
	 	    //===============  LINEA 4   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 4
	 	    row.createCell(1).setCellStyle(style1);//CELDA 1		    	    
	 	    for(int i=2; i<=5; i++){
		    	cell = row.createCell(i);
		    	if(i==2){
		    		cell.setCellValue("HOMBRES");
		    	}else{
		    		cell.setCellValue("MUJERES");
		    	}
		 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
		 	    sheet.addMergedRegion(new CellRangeAddress(
			    		lineNum, //first row (0-based)
			    		lineNum, //last row  (0-based)
			            i, //first column (0-based)
			            i+1  //last column  (0-based)
			    ));
		 	    i=i+1;
		 	    row.createCell(i).setCellStyle(style1);
	 	    }
		    cell = row.createCell(6);//CELDA 2
	 	    cell.setCellValue("TOTAL");//PRIMERA CELDA DE LA FILA 2
	 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
	 	    ++lineNum;//4
	 	    
	 	    
	 	    //===============  LINEA 5   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 4
	 	    row.createCell(1).setCellStyle(style1);//CELDA 1
	 	    
	 	    for(int i=2; i<=5; i++){
	 	    	cell = row.createCell(i);
	 	    	if(i%2==0){
	 	    		cell.setCellValue("N");
	 	    	}else{
	 	    		cell.setCellValue("%");
	 	    	}
		 	    cell.setCellStyle(style1);
	 	    }
	 	    cell = row.createCell(6);
	 	    cell.setCellValue("N");
	 	    cell.setCellStyle(style1);
	 	    ++lineNum;//5
	 	    //=============================================================
	 	    //FIN CREANDO ENCABEZADOS
	 	    //=============================================================
		}
	 
	 public static void  crearEncabezadoReporte19(Workbook wb,Sheet sheet, Row row, CellStyle style0,CellStyle style1, int lineNum){
			//=============================================================
	 	    //INI CREANDO ENCABEZADOS
	 	    //=============================================================
	 	        	    
	 	    //===============  LINEA 1   ==================
		    
		    Cell cell=row.createCell(0);//PRIMERA CELDA DE LA FILA 1
		    cell.setCellValue("REPORTE DE POTENCIALES RETORNANTES Y FAMILIARES, POR GRUPOS QUINQUENALES DE EDAD, SEGUN DEPARTAMENTO DE RETORNO");
		    cell.setCellStyle(style0);//LE AGREGAMOS EL ESTILO 0
		    //COMBINAMOS UN AREA DELIMINADA POR SUS CUATRO COORDENADAS POR ASI DECIRLO
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	            0, //first row (0-based)
	 	            0, //last row  (0-based)
	 	            0, //first column (0-based)
	 	            37  //last column  (0-based)
	 	    ));
	 	    ++lineNum;//1 
	 	    
	 	    //===============  LINEA 2   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 2
	 	    row.createCell(0).setCellValue(" ");//PRIMERA CELDA DE LA FILA 2
	 	    //COMBINAMOS UN AREA DELIMINADA POR SUS CUATRO COORDENADAS POR ASI DECIRLO
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	    		lineNum, //first row (0-based)
	 	    		lineNum, //last row  (0-based)
	 	            0, //first column (0-based)
	 	            37  //last column  (0-based)
	 	    ));
	 	    ++lineNum;//2
	 	    
	 	    
	 	    //===============  LINEA 3   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 3
	 	    
	 	    cell = row.createCell(1);//CELDA 1
	 	    cell.setCellValue("DEPARTAMENTO DE RETORNO");//PRIMERA CELDA DE LA FILA 2
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	    		lineNum, //first row (0-based)
	 	    		4, //last row  (0-based)
	 	            1, //first column (0-based)
	 	            1  //last column  (0-based)
	 	    ));
	 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
	 	    
	 	    cell = row.createCell(2);//CELDA 2
	 	    cell.setCellValue("GRUPOS QUINQUENAL DE EDAD");//PRIMERA CELDA DE LA FILA 2
	 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
	 	    sheet.addMergedRegion(new CellRangeAddress(
	 	    		lineNum, //first row (0-based)
	 	    		lineNum, //last row  (0-based)
	 	            2, //first column (0-based)
	 	            36  //last column  (0-based)
	 	    ));
	 	    for(int i=3; i<=36; i++){
	 	    	row.createCell(i).setCellStyle(style1);//CELDA 3
	 	    }
	 	    ++lineNum;//3
	 	    
	 	    //===============  LINEA 4   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 4
	 	    row.createCell(1).setCellStyle(style1);//CELDA 1		    	    
	 	    int ini=0;
		    int fin=4;
		    for(int i=2; i<=35; i++){
		    	cell = row.createCell(i);
		    	if(fin==84){
		    		cell.setCellValue(ini+" A +");
		    	}else{
		    		cell.setCellValue(ini+"-"+fin);
		    	}
		 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
		 	    sheet.addMergedRegion(new CellRangeAddress(
			    		lineNum, //first row (0-based)
			    		lineNum, //last row  (0-based)
			            i, //first column (0-based)
			            i+1  //last column  (0-based)
			    ));
		 	    i=i+1;
		 	    ini=ini+5;
		 	    fin=fin+5;
		 	    row.createCell(i).setCellStyle(style1);
	 	    }
		    cell = row.createCell(36);//CELDA 2
	 	    cell.setCellValue("TOTAL");//PRIMERA CELDA DE LA FILA 2
	 	    cell.setCellStyle(style1);//LE AGREGAMOS EL ESTILO 0
	 	    ++lineNum;//4
	 	    
	 	    
	 	    //===============  LINEA 5   ==================
	 	    row = sheet.createRow((short)lineNum);//FILA 4
	 	    row.createCell(1).setCellStyle(style1);//CELDA 1
	 	    
	 	    for(int i=2; i<=35; i++){
	 	    	cell = row.createCell(i);
	 	    	if(i%2==0){
	 	    		cell.setCellValue("N");
	 	    	}else{
	 	    		cell.setCellValue("%");
	 	    	}
		 	    cell.setCellStyle(style1);
	 	    }
	 	    cell = row.createCell(36);
	 	    cell.setCellValue("");
	 	    cell.setCellStyle(style1);
	 	    ++lineNum;//5
	 	    //=============================================================
	 	    //FIN CREANDO ENCABEZADOS
	 	    //=============================================================
		}
	 
	
			
}

