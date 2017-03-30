package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.ReporteDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.ReporteErroresDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErrorescabrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErroresrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;

@ManagedBean(name = "reporteErrorBean")
@SessionScoped
public class ReporteErrorBean {

	private Date fRegistroI = new Date();
	private Date fRegistroF = new Date();
	private VstErroresrrhh filtro = new VstErroresrrhh();
	private List<VstErrorescabrrhh> listaErrores;
	private List<VstErroresrrhh> listaErroresDet;	
	
	public List<VstErroresrrhh> getListaErroresDet() {
		return listaErroresDet;
	}

	public void setListaErroresDet(List<VstErroresrrhh> listaErroresDet) {
		this.listaErroresDet = listaErroresDet;
	}

	public Date getfRegistroI() {
		return fRegistroI;
	}

	public void setfRegistroI(Date fRegistroI) {
		this.fRegistroI = fRegistroI;
	}

	public Date getfRegistroF() {
		return fRegistroF;
	}

	public void setfRegistroF(Date fRegistroF) {
		this.fRegistroF = fRegistroF;
	}

	public VstErroresrrhh getFiltro() {
		return filtro;
	}

	public void setFiltro(VstErroresrrhh filtro) {
		this.filtro = filtro;
	}

	public String verRptError() {
		limpiar();
		String vista = "pretty:rptErrorPretty";
		// CODIGO
		return vista;
	}

	public List<VstErrorescabrrhh> getListaErrores() {
		return listaErrores;
	}

	public void setListaErrores(List<VstErrorescabrrhh> listaErrores) {
		this.listaErrores = listaErrores;
	}

	public void limpiar() {
		fRegistroI = new Date();
		fRegistroF = new Date();
		setListaErrores(null);
		filtro = new VstErroresrrhh();
		// mostrarMensajeInfo("ACABA DE LIMPIAR");
	}

	public void buscarTablaErrores() {
		if (!validaBuscarErrores()) {
		} else {
			ReporteErroresDespatch reporteErroresDespatch = new ReporteErroresDespatch();
			// filtro.setvCodusureg(vCodusureg);

			// Funciones.imprimir(texto);
			try {
				listaErrores = reporteErroresDespatch.getErroresCab(fRegistroI, fRegistroF);
			} catch (Exception e) {
				listaErrores = null;
				e.printStackTrace();
			}
		}

	}

	public StreamedContent rptErrores(long dat, String grupo) {
			long rnd=System.currentTimeMillis();
			try {
				ReporteErroresDespatch reporteErroresDespatch = new ReporteErroresDespatch();
				filtro=new VstErroresrrhh();
				filtro.setnGrupocarga(new BigDecimal(grupo));
				try {
					listaErroresDet=reporteErroresDespatch.getErrores(filtro);
				} catch (Exception e) {
					e.printStackTrace();
					listaErroresDet=null;
				}				
				
				if(listaErroresDet!=null)
				{
					Workbook wb = new XSSFWorkbook();
				    Sheet sheet = wb.createSheet("REPORTE ERRORES");
				    
				    Font fontTitle = wb.createFont();
				    fontTitle.setColor(HSSFColor.BLACK.index);
				    fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
				    fontTitle.setFontHeightInPoints(new Short("15"));
				    
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
				    cell.setCellValue("REPORTE ERRORES");
				    cell.setCellStyle(style0);
		    	    sheet.addMergedRegion(new CellRangeAddress(
		    	            0, //first row (0-based)
		    	            0, //last row  (0-based)
		    	            0, //first column (0-based)
		    	            3  //last column  (0-based)
		    	    ));
		    	    ++lineNum;
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(0).setCellValue("Fecha actual "+FuncionesFechas.getFormatDate(new Date())+".");
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
		    	    /*cell=row.createCell(2);
		    	    cell.setCellValue("TIPO DE DOCUMENTO");
		    	    cell.setCellStyle(style1);*/
		    	    cell=row.createCell(1);
		    	    cell.setCellValue("CÓD DE PERSONAL");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(2);
		    	    cell.setCellValue("FECHA MARCACIÓN");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(3);
		    	    cell.setCellValue("FECHA DE CARGA");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(4);
		    	    cell.setCellValue("USUARIO DE CARGA");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(5);
		    	    cell.setCellValue("MOTIVO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(6);
		    	    cell.setCellValue("GRUPO DE CARGA");
		    	    cell.setCellStyle(style1);
		    	    for (Iterator iterator = listaErroresDet.iterator(); iterator.hasNext();) {
		    	    	lineNum++;
		    	    	VstErroresrrhh obj = (VstErroresrrhh) iterator.next();
						row = sheet.createRow((short)lineNum);
						row.createCell(0).setCellValue((lineNum-3)+"");
						row.createCell(1).setCellValue(obj.getvCodpersonal());
						//funcionesBean.completarCon(item.nHora,2,0,0)
						row.createCell(2).setCellValue(FuncionesFechas.getFormatDate(obj.getdFecha()) + " "+ Funciones.completarCon(obj.getnHora()+"",2,"0",0)+":"+Funciones.completarCon(obj.getnMinuto()+"",2,"0",0)+":"+Funciones.completarCon(obj.getnSegundo()+"",2,"0",0));
						row.createCell(3).setCellValue(obj.getdFecreg());
						row.createCell(4).setCellValue(obj.getvCodusureg());
						row.createCell(5).setCellValue(obj.getvMotivo());
						row.createCell(6).setCellValue(obj.getnGrupocarga()+"");
					}
		    	    
		    	    FileOutputStream fileOut;
		    	    String rutaRpt=Funciones.ObtProp_Resources("ruta.reportes");
		    	    fileOut = new FileOutputStream(rutaRpt+"/rptErrores"+rnd+".xlsx");
					wb.write(fileOut);
					fileOut.close();
					InputStream stream;
					try {
						stream = new FileInputStream(rutaRpt+"/rptErrores"+rnd+".xlsx");					
						StreamedContent fileDownload = new DefaultStreamedContent(stream, "application/vnd.ms-excel", "rptErrores-"+rnd+".xlsx");
						return fileDownload;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					} 
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return null;
		
	}
	
	public boolean validaBuscarErrores() {
		if ((fRegistroI == null || fRegistroF == null)) {
			listaErrores = null;
			Funciones
					.mostrarMensajeError("Debe ingresar un rango de fechas.");
			return false;
		}
		if (!FuncionesFechas.validaFecha(fRegistroI, fRegistroF)) {
			return false;
		}

		return true;
	}
}
