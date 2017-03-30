package pe.gob.sunafil.tramiteext.managedBeans;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.gob.sunafil.tramiteext.bean.Usuario;
import pe.gob.sunafil.tramiteext.funciones.Funciones;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.RegistrarDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.ReporteDespatch;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdTupa;
import pe.gob.sunafil.tramiteext.utils.FacesUtils;

import java.io.FileOutputStream;
import java.math.BigDecimal;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name="reporteBean")
@SessionScoped
public class ReporteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4797563263978301236L;
	
	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;
	 
	//REPORTE POR USUARIO
	private Date rptUFI=new Date();
	private Date rptUFF=new Date();
	private String rptUIntendencia;
	private List<Map> lstRptUsuario;		

	//REPORTE POR PROCEDIMIENTO
	private Date rptPFI=new Date();
	private Date rptPFF=new Date();
	private String rptPIntendencia;
	private String rptPProcedimiento;
	private String rptPEstado;
	private List<Map> lstRptProcedimiento;
	private List <TdtbdTupa> listaProcedimiento;
	
	//REPORTE CONSOLIDADO
	private Date rptCFI=new Date();
	private Date rptCFF=new Date();
	private String rptCIntendencia;	
	private String rptCEstado;
	private List<Map> lstRptConsolidado;
		
	public List<TdtbdTupa> getListaProcedimiento() {
		RegistrarDespatch registrarDespatch = new RegistrarDespatch();
		try {
			listaProcedimiento=registrarDespatch.getProcedimientoAll(new BigDecimal(PGP_Usuario.getN_numint()));
		} catch (Exception e) {
			listaProcedimiento=null;
			e.printStackTrace();
		}
		return listaProcedimiento;
	}

	public void setListaProcedimiento(List<TdtbdTupa> listaProcedimiento) {
		this.listaProcedimiento = listaProcedimiento;
	}
	
	public Date getRptCFI() {
		return rptCFI;
	}

	public void setRptCFI(Date rptCFI) {
		this.rptCFI = rptCFI;
	}

	public Date getRptCFF() {
		return rptCFF;
	}

	public void setRptCFF(Date rptCFF) {
		this.rptCFF = rptCFF;
	}

	public String getRptCIntendencia() {
		return rptCIntendencia;
	}

	public void setRptCIntendencia(String rptCIntendencia) {
		this.rptCIntendencia = rptCIntendencia;
	}

	public String getRptCEstado() {
		return rptCEstado;
	}

	public void setRptCEstado(String rptCEstado) {
		this.rptCEstado = rptCEstado;
	}

	public List<Map> getLstRptConsolidado() {
		return lstRptConsolidado;
	}

	public void setLstRptConsolidado(List<Map> lstRptConsolidado) {
		this.lstRptConsolidado = lstRptConsolidado;
	}	
	
	public List<Map> getLstRptProcedimiento() {
		return lstRptProcedimiento;
	}

	public void setLstRptProcedimiento(List<Map> lstRptProcedimiento) {
		this.lstRptProcedimiento = lstRptProcedimiento;
	}

	public List<Map> getLstRptUsuario() {
		return lstRptUsuario;
	}

	public void setLstRptUsuario(List<Map> lstRptUsuario) {
		this.lstRptUsuario = lstRptUsuario;
	}
	
	public Date getRptPFI() {
		return rptPFI;
	}

	public void setRptPFI(Date rptPFI) {
		this.rptPFI = rptPFI;
	}

	public Date getRptPFF() {
		return rptPFF;
	}

	public void setRptPFF(Date rptPFF) {
		this.rptPFF = rptPFF;
	}

	public String getRptPIntendencia() {
		return rptPIntendencia;
	}

	public void setRptPIntendencia(String rptPIntendencia) {
		this.rptPIntendencia = rptPIntendencia;
	}

	public String getRptPProcedimiento() {
		return rptPProcedimiento;
	}

	public void setRptPProcedimiento(String rptPProcedimiento) {
		this.rptPProcedimiento = rptPProcedimiento;
	}

	public String getRptPEstado() {
		return rptPEstado;
	}

	public void setRptPEstado(String rptPEstado) {
		this.rptPEstado = rptPEstado;
	}		
	
	public Date getRptUFI() {
		return rptUFI;
	}

	public void setRptUFI(Date rptUFI) {
		this.rptUFI = rptUFI;
	}

	public Date getRptUFF() {
		return rptUFF;
	}

	public void setRptUFF(Date rptUFF) {
		this.rptUFF = rptUFF;
	}

	public String getRptUIntendencia() {
		return rptUIntendencia;
	}

	public void setRptUIntendencia(String rptUIntendencia) {
		this.rptUIntendencia = rptUIntendencia;
	}	

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}
	
	public String getFormatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
	
	public StreamedContent rptPorUsuario(long dat) 
    {		
		if(rptUFI!=null && rptUFF!=null)
		{
			if(rptUFF.before(rptUFI))
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "La fecha hasta debe ser mayor que la fecha desde."));
	            return null;
			}
			/*Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(rptUFI);
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(rptUFF);
			int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);*/
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.setTime(rptUFI);
			end.setTime(rptUFF);
			Date startDate = start.getTime();
			Date endDate = end.getTime();
			long startTime = startDate.getTime();
			long endTime = endDate.getTime();
			long diffTime = endTime - startTime;
			long diffDays = diffTime / (1000 * 60 * 60 * 24);
			DateFormat dateFormat = DateFormat.getDateInstance();
			System.out.println("The difference between "+
			  dateFormat.format(startDate)+" and "+
			  dateFormat.format(endDate)+" is "+
			  diffDays+" days.");
			if(diffDays>31 || diffDays<-31)//if(diffMonth>1 || diffMonth<-1)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "El rango de fechas puede ser como máximo un mes."));
	            return null;
			}
			long rnd=System.currentTimeMillis();
			try {
				if("".equals(rptUIntendencia.trim()))
				{
					rptUIntendencia=null;
				}
				Calendar c = Calendar.getInstance(); 
				c.setTime(rptUFF); 
				c.add(Calendar.DATE, 1);
				Date fechaFplus = c.getTime();
				ReporteDespatch reporteDespatch=new ReporteDespatch();		
				Map parametros = new HashMap();
				parametros.put("PARAM_FI", rptUFI);
				parametros.put("PARAM_FF", fechaFplus);
				parametros.put("PARAM_INTENDENCIA", rptUIntendencia);			
				lstRptUsuario=reporteDespatch.reporteUsuario(parametros);	
				String rutaRpt=Funciones.ObtProp_Resources("ruta.reportes");
				if(lstRptUsuario!=null)
				{
					List<String> intendenciasList=new ArrayList<String>();
					Workbook wb = new XSSFWorkbook();
				    Sheet sheet = wb.createSheet("REPORTE POR USUARIO");
				    
				    Font font = wb.createFont();
		    	    font.setColor(HSSFColor.BLACK.index);
		    	    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		    	    CellStyle style0 = wb.createCellStyle();
		    	    style0.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		    	    style0.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    	    style0.setFont(font);		    	    
		    	    CellStyle style1 = wb.createCellStyle();
		    	    style1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		    	    style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    	    style1.setFont(font);
		    	    style1.setBorderBottom(CellStyle.BORDER_THIN);
		    	    style1.setBorderTop(CellStyle.BORDER_THIN);
		    	    style1.setBorderRight(CellStyle.BORDER_THIN);
		    	    style1.setBorderLeft(CellStyle.BORDER_THIN);
				    /*sheet.setColumnWidth(0, 100);
				    sheet.setColumnWidth(1, 100);
				    sheet.setColumnWidth(2, 100);
				    sheet.autoSizeColumn(0);
				    sheet.autoSizeColumn(1);
				    sheet.autoSizeColumn(2);*/
				    int lineNum=0;
				    Row row = sheet.createRow((short)lineNum);
				    Cell cell=row.createCell(0);
				    cell.setCellValue("DOCUMENTOS EXTERNOS - REGISTRO POR USUARIO ");
				    cell.setCellStyle(style0);
		    	    sheet.addMergedRegion(new CellRangeAddress(
		    	            0, //first row (0-based)
		    	            0, //last row  (0-based)
		    	            0, //first column (0-based)
		    	            3  //last column  (0-based)
		    	    ));
		    	    ++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(0).setCellValue("Rango de fecha del "+getFormatDate(rptUFI)+" al "+getFormatDate(rptUFF));
		    	    sheet.addMergedRegion(new CellRangeAddress(
		    	            1, //first row (0-based)
		    	            1, //last row  (0-based)
		    	            0, //first column (0-based)
		    	            3  //last column  (0-based)
		    	    ));
		    	    ++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(0).setCellValue(" ");
		    	    sheet.addMergedRegion(new CellRangeAddress(
		    	            2, //first row (0-based)
		    	            2, //last row  (0-based)
		    	            0, //first column (0-based)
		    	            3  //last column  (0-based)
		    	    ));
		    	    /*++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(0).setCellValue("N° ");
		    	    row.createCell(1).setCellValue("USUARIO");
		    	    row.createCell(2).setCellValue("TOTAL");*/
				    for (Iterator iterator = lstRptUsuario.iterator(); iterator
							.hasNext();) {
						Map map = (Map) iterator.next();
						/*lineNum++;
						System.out.println("row : "+lineNum+" ::: "+map.get("NOMBRE"));
						row = sheet.createRow((short)lineNum);
			    	    row.createCell(0).setCellValue((lineNum-3)+"");
			    	    row.createCell(1).setCellValue(map.get("NOMBRE")+"");
			    	    row.createCell(2).setCellValue(map.get("TOTAL")+"");*/
			    	    intendenciasList.add(map.get("V_DESINT")+"");
					}
				    int totalGeneral=0;
				    Set<String> uniqueInt = new HashSet<String>(intendenciasList);
					for (Iterator iterator = uniqueInt.iterator(); iterator
							.hasNext();) {	
						String intendencia=iterator.next().toString();
						int intendenciaCount=0;
						int intendenciaIndex=0;
						++lineNum;
			    	    row = sheet.createRow((short)lineNum);
			    	    row.createCell(0).setCellValue(intendencia);
			    	    sheet.addMergedRegion(new CellRangeAddress(
			    	    		lineNum, //first row (0-based)
			    	    		lineNum, //last row  (0-based)
			    	            0, //first column (0-based)
			    	            3  //last column  (0-based)
			    	    ));
						++lineNum;
			    	    row = sheet.createRow((short)lineNum);
			    	    
			    	    
			    	    
			    	    
			    	    cell=row.createCell(0);
			    	    cell.setCellValue("N° ");
			    	    cell.setCellStyle(style1);
			    	    cell=row.createCell(1);
			    	    cell.setCellValue("USUARIO");
			    	    cell.setCellStyle(style1);
			    	    cell=row.createCell(2);
			    	    cell.setCellValue("TOTAL");
			    	    cell.setCellStyle(style1);
			    	    
						for (Iterator iterator2 = lstRptUsuario.iterator(); iterator2
								.hasNext();) {
							Map map = (Map) iterator2.next();
							if(intendencia.equalsIgnoreCase(map.get("V_DESINT").toString()))
							{
								++intendenciaIndex;
								lineNum++;
								System.out.println("row : "+lineNum+" ::: "+map.get("NOMBRE"));
								row = sheet.createRow((short)lineNum);
					    	    row.createCell(0).setCellValue(intendenciaIndex+"");
					    	    row.createCell(1).setCellValue(map.get("NOMBRE")+"");
					    	    row.createCell(2).setCellValue(map.get("TOTAL")+"");
					    	    intendenciaCount+=Integer.parseInt(map.get("TOTAL").toString());
							}
						}
						++lineNum;
			    	    row = sheet.createRow((short)lineNum);
			    	    row.createCell(0).setCellValue(" ");
			    	    row.createCell(1).setCellValue("TOTAL");
			    	    row.createCell(2).setCellValue(""+intendenciaCount);
			    	    totalGeneral+=intendenciaCount;
					}
					++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(0).setCellValue(" ");
		    	    row.createCell(1).setCellValue("TOTAL GENERAL");
		    	    row.createCell(2).setCellValue(""+totalGeneral);
				    FileOutputStream fileOut;
				    fileOut = new FileOutputStream(rutaRpt+"/rptPorUsuario"+rnd+".xlsx");
					//fileOut = new FileOutputStream("D://Willy//plantilla//si.plantillaseg//WebContent//jsfDocs//modulos//ejemplo//rptPorUsuario"+rnd+".xlsx");
					wb.write(fileOut);
					fileOut.close();
				}									
				//FacesUtils.mostrarXLSX("/jsfDocs/modulos/ejemplo/", "rptPorUsuario.xlsx");
				
				InputStream stream;
				try {
					stream = new FileInputStream(rutaRpt+"/rptPorUsuario"+rnd+".xlsx");
					//stream = new FileInputStream("D://Willy//plantilla//si.plantillaseg//WebContent//jsfDocs//modulos//ejemplo//rptPorUsuario"+rnd+".xlsx");
					StreamedContent fileDownload = new DefaultStreamedContent(stream, "application/vnd.ms-excel", "rptPorUsuario-"+rnd+".xlsx");
					return fileDownload;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				lstRptUsuario=null;
				return null;
			}
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar fechas."));
            return null;
		}		
    }
	
	public StreamedContent rptPorProcedimiento(long dat)
	{		
		if(rptPFI!=null && rptPFF!=null)
		{
			if(rptPFF.before(rptPFI))
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "La fecha hasta debe ser mayor que la fecha desde."));
	            return null;
			}
			/*Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(rptUFI);
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(rptUFF);
			int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);*/
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.setTime(rptPFI);
			end.setTime(rptPFF);
			Date startDate = start.getTime();
			Date endDate = end.getTime();
			long startTime = startDate.getTime();
			long endTime = endDate.getTime();
			long diffTime = endTime - startTime;
			long diffDays = diffTime / (1000 * 60 * 60 * 24);
			DateFormat dateFormat = DateFormat.getDateInstance();
			System.out.println("The difference between "+
			  dateFormat.format(startDate)+" and "+
			  dateFormat.format(endDate)+" is "+
			  diffDays+" days.");
			if(diffDays>31 || diffDays<-31)//if(diffMonth>1 || diffMonth<-1)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "El rango de fechas puede ser como máximo un mes."));
	            return null;
			}
			long rnd=System.currentTimeMillis();
			try {
				if("".equals(rptPIntendencia.trim()))
				{
					rptPIntendencia=null;
				}
				if("".equals(rptPProcedimiento.trim()))
				{
					rptPProcedimiento=null;
				}
				if("".equals(rptPEstado.trim()))
				{
					rptPEstado=null;
				}
				Calendar c = Calendar.getInstance(); 
				c.setTime(rptPFF); 
				c.add(Calendar.DATE, 1);
				Date fechaFplus = c.getTime();
				ReporteDespatch reporteDespatch=new ReporteDespatch();
				Map parametros = new HashMap();
				parametros.put("PARAM_FI", rptPFI);
				parametros.put("PARAM_FF", fechaFplus);
				parametros.put("PARAM_INTENDENCIA", rptPIntendencia);			
				parametros.put("PARAM_TUPA", rptPProcedimiento);
				parametros.put("PARAM_ESTADO", rptPEstado);
				lstRptProcedimiento=reporteDespatch.reporteProcedimiento(parametros);
				if(lstRptProcedimiento!=null)
				{
					List<String> intendenciasList=new ArrayList<String>();
					Workbook wb = new XSSFWorkbook();
				    Sheet sheet = wb.createSheet("REPORTE POR PROCEDIMIENTO");
				    
				    Font font = wb.createFont();
		    	    font.setColor(HSSFColor.BLACK.index);
		    	    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		    	    CellStyle style0 = wb.createCellStyle();
		    	    style0.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		    	    style0.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    	    style0.setFont(font);	
		    	    CellStyle style1 = wb.createCellStyle();
		    	    style1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		    	    style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    	    style1.setFont(font);
		    	    style1.setBorderBottom(CellStyle.BORDER_THIN);
		    	    style1.setBorderTop(CellStyle.BORDER_THIN);
		    	    style1.setBorderRight(CellStyle.BORDER_THIN);
		    	    style1.setBorderLeft(CellStyle.BORDER_THIN);
				    
				    int lineNum=0;
				    Row row = sheet.createRow((short)lineNum);
				    Cell cell=row.createCell(0);
				    cell.setCellValue("REGISTRO - PROCEDIMIENTOS ADMINISTRATIVOS ");
				    cell.setCellStyle(style0);
		    	    sheet.addMergedRegion(new CellRangeAddress(
		    	            0, //first row (0-based)
		    	            0, //last row  (0-based)
		    	            0, //first column (0-based)
		    	            3  //last column  (0-based)
		    	    ));
		    	    ++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(0).setCellValue("Rango de fecha del "+getFormatDate(rptPFI)+" al "+getFormatDate(rptPFF));
		    	    sheet.addMergedRegion(new CellRangeAddress(
		    	            1, //first row (0-based)
		    	            1, //last row  (0-based)
		    	            0, //first column (0-based)
		    	            3  //last column  (0-based)
		    	    ));
		    	    ++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(0).setCellValue(" ");
		    	    sheet.addMergedRegion(new CellRangeAddress(
		    	            2, //first row (0-based)
		    	            2, //last row  (0-based)
		    	            0, //first column (0-based)
		    	            3  //last column  (0-based)
		    	    ));
		    	    ++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    cell=row.createCell(0);
		    	    cell.setCellValue("N° ");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(1);
		    	    cell.setCellValue("NOMBRE DEL SOLICITANTE");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(2);
		    	    cell.setCellValue("HOJA DE RUTA");//ANTES ESTABA EL CUR
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(3);
		    	    cell.setCellValue("FECHA DE REGISTRO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(4);
		    	    cell.setCellValue("ASUNTO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(5);
		    	    cell.setCellValue("DESCRIPCIÓN DEL PROCEDIMIENTO TUPA");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(6);
		    	    cell.setCellValue("N° ITEM DEL TUPA");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(7);
		    	    cell.setCellValue("UBICACIÓN DEL EXPEDIENTE(Unidad Orgánica)");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(8);
		    	    cell.setCellValue("ESTADO DEL EXPEDIENTE");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(9);
		    	    cell.setCellValue("USUARIO DE REGISTRO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(10);
		    	    cell.setCellValue("INTENDENCIA");
		    	    cell.setCellStyle(style1);
		    	    for (Iterator iterator = lstRptProcedimiento.iterator(); iterator
							.hasNext();) {
						Map map = (Map) iterator.next();
						lineNum++;
						System.out.println("row : "+lineNum+" ::: "+map.get("CUR"));
						row = sheet.createRow((short)lineNum);
			    	    row.createCell(0).setCellValue((lineNum-3)+"");
			    	    row.createCell(1).setCellValue(map.get("V_DESNOMBRE")+"");
			    	    row.createCell(2).setCellValue(map.get("CUR")+"");
			    	    row.createCell(3).setCellValue(map.get("D_FECREG")+"");
			    	    row.createCell(4).setCellValue(map.get("V_ASUNTODETALLADO")+"");
			    	    row.createCell(5).setCellValue(map.get("V_DESTUPA")+"");
			    	    row.createCell(6).setCellValue(map.get("V_CODTUPA")+"");
			    	    row.createCell(7).setCellValue(map.get("V_DESDEPDEST")+"");
			    	    row.createCell(8).setCellValue(map.get("ESTADO")+"");
			    	    row.createCell(9).setCellValue(map.get("V_NOMUSUREG")+"");
			    	    row.createCell(10).setCellValue(map.get("V_DESINT")+"");
					}
		    	    FileOutputStream fileOut;
		    	    String rutaRpt=Funciones.ObtProp_Resources("ruta.reportes");
		    	    fileOut = new FileOutputStream(rutaRpt+"/rptPorProcedimiento"+rnd+".xlsx");
					//fileOut = new FileOutputStream("D://Willy//plantilla//si.plantillaseg//WebContent//jsfDocs//modulos//ejemplo//rptPorProcedimiento"+rnd+".xlsx");
					wb.write(fileOut);
					fileOut.close();
					InputStream stream;
					try {
						stream = new FileInputStream(rutaRpt+"/rptPorProcedimiento"+rnd+".xlsx");
						//stream = new FileInputStream("D://Willy//plantilla//si.plantillaseg//WebContent//jsfDocs//modulos//ejemplo//rptPorProcedimiento"+rnd+".xlsx");
						StreamedContent fileDownload = new DefaultStreamedContent(stream, "application/vnd.ms-excel", "rptPorProcedimiento-"+rnd+".xlsx");
						return fileDownload;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					} 
				}
			} catch (Exception e) {
				e.printStackTrace();
				lstRptProcedimiento=null;
				return null;
			}
			return null;
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar fechas."));
			return null;
		}		
	}
	
	public String consolidado(){
		String vista="pretty:rptConsolidadoPretty";
        //CODIGO
        return  vista;
	}
	
	public StreamedContent rptConsolidado(long dat)
	{
		if(Integer.parseInt(PGP_Usuario.getN_numint())!=1)
		{
			if("".equals(rptCIntendencia.trim()))
			{
				rptCIntendencia=null;
			}
			if(rptCIntendencia!=null){}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe seleccionar un origen."));
	            return null;
			}
		}
		if(rptCFI!=null && rptCFF!=null)
		{
			if(rptCFF.before(rptCFI))
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "La fecha hasta debe ser mayor que la fecha desde."));
	            return null;
			}
			/*Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(rptUFI);
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(rptUFF);
			int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);*/
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.setTime(rptCFI);
			end.setTime(rptCFF);
			Date startDate = start.getTime();
			Date endDate = end.getTime();
			long startTime = startDate.getTime();
			long endTime = endDate.getTime();
			long diffTime = endTime - startTime;
			long diffDays = diffTime / (1000 * 60 * 60 * 24);
			DateFormat dateFormat = DateFormat.getDateInstance();
			System.out.println("The difference between "+
			  dateFormat.format(startDate)+" and "+
			  dateFormat.format(endDate)+" is "+
			  diffDays+" days.");
			if(diffDays>31 || diffDays<-31)//if(diffMonth>1 || diffMonth<-1)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "El rango de fechas puede ser como máximo un mes."));
	            return null;
			}
			long rnd=System.currentTimeMillis();
			try {
				if("".equals(rptCIntendencia.trim()))
				{
					rptCIntendencia=null;
				}
				if("".equals(rptCEstado.trim()))
				{
					rptCEstado=null;
				}
				Calendar c = Calendar.getInstance(); 
				c.setTime(rptCFF); 
				c.add(Calendar.DATE, 1);
				Date fechaFplus = c.getTime();
				ReporteDespatch reporteDespatch=new ReporteDespatch();
				Map parametros = new HashMap();
				parametros.put("PARAM_FI", rptCFI);
				parametros.put("PARAM_FF", fechaFplus);
				parametros.put("PARAM_INTENDENCIA", rptCIntendencia);			
				parametros.put("PARAM_TUPA", null);
				parametros.put("PARAM_ESTADO", rptCEstado);
				lstRptConsolidado=reporteDespatch.reporteConsolidado(parametros);
				if(lstRptConsolidado!=null)
				{
					List<String> intendenciasList=new ArrayList<String>();
					Workbook wb = new XSSFWorkbook();
				    Sheet sheet = wb.createSheet("REPORTE CONSOLIDADO");
				    
				    Font font = wb.createFont();
		    	    font.setColor(HSSFColor.BLACK.index);
		    	    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		    	    CellStyle style0 = wb.createCellStyle();
		    	    style0.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		    	    style0.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    	    style0.setFont(font);	
		    	    CellStyle style1 = wb.createCellStyle();
		    	    style1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		    	    style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    	    style1.setFont(font);
		    	    style1.setBorderBottom(CellStyle.BORDER_THIN);
		    	    style1.setBorderTop(CellStyle.BORDER_THIN);
		    	    style1.setBorderRight(CellStyle.BORDER_THIN);
		    	    style1.setBorderLeft(CellStyle.BORDER_THIN);
				    
				    int lineNum=0;
				    Row row = sheet.createRow((short)lineNum);
				    Cell cell=row.createCell(0);
				    cell.setCellValue("REGISTRO - CONSOLIDADO ");
				    cell.setCellStyle(style0);
		    	    sheet.addMergedRegion(new CellRangeAddress(
		    	            0, //first row (0-based)
		    	            0, //last row  (0-based)
		    	            0, //first column (0-based)
		    	            3  //last column  (0-based)
		    	    ));
		    	    ++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(0).setCellValue("Rango de fecha del "+getFormatDate(rptCFI)+" al "+getFormatDate(rptCFF));
		    	    sheet.addMergedRegion(new CellRangeAddress(
		    	            1, //first row (0-based)
		    	            1, //last row  (0-based)
		    	            0, //first column (0-based)
		    	            3  //last column  (0-based)
		    	    ));
		    	    ++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(0).setCellValue(" ");
		    	    sheet.addMergedRegion(new CellRangeAddress(
		    	            2, //first row (0-based)
		    	            2, //last row  (0-based)
		    	            0, //first column (0-based)
		    	            3  //last column  (0-based)
		    	    ));
		    	    ++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    cell=row.createCell(0);
		    	    cell.setCellValue("N° ");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(1);
		    	    cell.setCellValue("NOMBRE DEL SOLICITANTE");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(2);
		    	    cell.setCellValue("HOJA DE RUTA");//ANTES ESTABA EL CUR
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(3);
		    	    cell.setCellValue("FECHA DE REGISTRO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(4);
		    	    cell.setCellValue("ASUNTO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(5);
		    	    cell.setCellValue("TRÁMITE");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(6);
		    	    cell.setCellValue("DESCRIPCIÓN DEL PROCEDIMIENTO TUPA");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(7);
		    	    cell.setCellValue("N° ITEM DEL TUPA");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(8);
		    	    cell.setCellValue("UBICACIÓN DEL EXPEDIENTE(Unidad Orgánica)");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(9);
		    	    cell.setCellValue("ESTADO DEL EXPEDIENTE");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(10);
		    	    cell.setCellValue("USUARIO DE REGISTRO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(11);
		    	    cell.setCellValue("INTENDENCIA");
		    	    cell.setCellStyle(style1);		    	    
		    	    cell=row.createCell(12);
		    	    cell.setCellValue("TIPO DE DOCUMENTO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(13);
		    	    cell.setCellValue("NRO DE DOCUMENTO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(14);
		    	    cell.setCellValue("NRO DE FOLIOS");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(15);
		    	    cell.setCellValue("OBSERVACIÓN");
		    	    cell.setCellStyle(style1);
		    	    for (Iterator iterator = lstRptConsolidado.iterator(); iterator
							.hasNext();) {
						Map map = (Map) iterator.next();
						lineNum++;
						System.out.println("row : "+lineNum+" ::: "+map.get("CUR"));
						row = sheet.createRow((short)lineNum);
			    	    row.createCell(0).setCellValue((lineNum-3)+"");
			    	    row.createCell(1).setCellValue(map.get("V_DESNOMBRE")+"");
			    	    row.createCell(2).setCellValue(map.get("CUR")+"");
			    	    row.createCell(3).setCellValue(map.get("D_FECREG")+"");
			    	    row.createCell(4).setCellValue(map.get("V_ASUNTODETALLADO")+"");
			    	    row.createCell(5).setCellValue(map.get("V_DESTRAM")+"");
			    	    row.createCell(6).setCellValue(map.get("V_DESTUPA")+"");
			    	    row.createCell(7).setCellValue(map.get("V_CODTUPA")+"");
			    	    row.createCell(8).setCellValue(map.get("V_DESDEPDEST")+"");
			    	    row.createCell(9).setCellValue(map.get("ESTADO")+"");
			    	    row.createCell(10).setCellValue(map.get("V_NOMUSUREG")+"");
			    	    row.createCell(11).setCellValue(map.get("V_DESINT")+"");			    	    
			    	    row.createCell(12).setCellValue(map.get("V_DESTIPODOC")+"");
			    	    row.createCell(13).setCellValue(map.get("V_NUMDOC")+"");
			    	    row.createCell(14).setCellValue(map.get("N_NUMFOLIOS")+"");
			    	    row.createCell(15).setCellValue(map.get("V_OBSERVACION")+"");
					}
		    	    FileOutputStream fileOut;
		    	    String rutaRpt=Funciones.ObtProp_Resources("ruta.reportes");
		    	    fileOut = new FileOutputStream(rutaRpt+"/rptConsolidado"+rnd+".xlsx");
					//fileOut = new FileOutputStream("D://Willy//plantilla//si.plantillaseg//WebContent//jsfDocs//modulos//ejemplo//rptPorProcedimiento"+rnd+".xlsx");
					wb.write(fileOut);
					fileOut.close();
					InputStream stream;
					try {
						stream = new FileInputStream(rutaRpt+"/rptConsolidado"+rnd+".xlsx");
						//stream = new FileInputStream("D://Willy//plantilla//si.plantillaseg//WebContent//jsfDocs//modulos//ejemplo//rptPorProcedimiento"+rnd+".xlsx");
						StreamedContent fileDownload = new DefaultStreamedContent(stream, "application/vnd.ms-excel", "rptConsolidado-"+rnd+".xlsx");
						return fileDownload;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					} 
				}
			} catch (Exception e) {
				e.printStackTrace();
				lstRptConsolidado=null;
				return null;
			}
			return null;
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar fechas."));
			return null;
		}		
	}

}
