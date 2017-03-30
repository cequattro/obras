package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.LoginDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.MarcacionDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.PersonalDespatch;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;
import pe.gob.sunafil.gestionpersonal.utils.FacesUtils;

@ManagedBean(name = "rptMarcacionUnaPersonaBean")
@SessionScoped
public class RptMarcacionUnaPersonaBean implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MisMarcacionesBean.class.getName());
	private Date fCargaI=new Date();
	private Date fCargaF=new Date();
	private List<SitbTdocide> listaTipoDoc;
	private VstMarcacionrrhh filtro = new VstMarcacionrrhh();
	private List<VstPersonalrrhh> listaPersonal;
	private String codigoPersonal;
	private String nombrePersonal="";
	private List<VstMarcacionrrhh>listaMarcacion;
	private String justificacionVerTipo;
	private String justificacionVerMotivo;
	private List<Map>listaMarcacionPDF;
	private VstPersonalrrhh filtroMarcaciones = new VstPersonalrrhh();;
	private VstPersonalrrhh personal;
	private boolean option=true;
	
	/*
	 * METODOS GET Y SET
	 * */		


	public String getCodigoPersonal() {
		return codigoPersonal;
	}

	public void setCodigoPersonal(String codigoPersonal) {
		this.codigoPersonal = codigoPersonal;
	}

	public String getNombrePersonal() {
		return nombrePersonal;
	}

	public void setNombrePersonal(String nombrePersonal) {
		this.nombrePersonal = nombrePersonal;
	}

	public List<VstPersonalrrhh> getListaPersonal() {
		return listaPersonal;
	}

	public void setListaPersonal(List<VstPersonalrrhh> listaPersonal) {
		this.listaPersonal = listaPersonal;
	}

	public VstPersonalrrhh getFiltroMarcaciones() {
		return filtroMarcaciones;
	}

	public void setFiltroMarcaciones(VstPersonalrrhh filtroMarcaciones) {
		this.filtroMarcaciones = filtroMarcaciones;
	}

	public VstPersonalrrhh getPersonal() {
		return personal;
	}

	public void setPersonal(VstPersonalrrhh personal) {
		this.personal = personal;
	}

	public boolean isOption() {
		return option;
	}

	public void setOption(boolean option) {
		this.option = option;
	}
	
	public List<SitbTdocide> getListaTipoDoc() {
		PersonalDespatch personalDespatch = new PersonalDespatch();
		try {
			listaTipoDoc = personalDespatch.getTipoDocRemitente();
		} catch (Exception e) {
			listaTipoDoc = null;
			e.printStackTrace();
		}
		return listaTipoDoc;
	}

	public void setListaTipoDoc(List<SitbTdocide> listaTipoDoc) {
		this.listaTipoDoc = listaTipoDoc;
	}
	
	public VstMarcacionrrhh getFiltro() {
		return filtro;
	}

	public void setFiltro(VstMarcacionrrhh filtro) {
		this.filtro = filtro;
	}
	
	public String getJustificacionVerTipo() {
		return justificacionVerTipo;
	}

	public List<Map> getListaMarcacionPDF() {
		return listaMarcacionPDF;
	}

	public void setListaMarcacionPDF(List<Map> listaMarcacionPDF) {
		this.listaMarcacionPDF = listaMarcacionPDF;
	}

	public void setJustificacionVerTipo(String justificacionVerTipo) {
		this.justificacionVerTipo = justificacionVerTipo;
	}

	public String getJustificacionVerMotivo() {
		return justificacionVerMotivo;
	}

	public void setJustificacionVerMotivo(String justificacionVerMotivo) {
		this.justificacionVerMotivo = justificacionVerMotivo;
	}

	public void setListaMarcacion(List<VstMarcacionrrhh> listaMarcacion) {
		this.listaMarcacion = listaMarcacion;
	}

	public void setfCargaI(Date fCargaI) {
		this.fCargaI = fCargaI;
	}

	public void setfCargaF(Date fCargaF) {
		this.fCargaF = fCargaF;
	}

	public Date getfCargaI() {
		return fCargaI;
	}

	public Date getfCargaF() {
		return fCargaF;
	}

	public List<VstMarcacionrrhh> getListaMarcacion() {
		return listaMarcacion;
	}

	
	
	/*
	 * METODO PARA LIMPIAR PANTALLA 
	 * */
	
	public void limpiar(){
		fCargaI=new Date();
		fCargaF=new Date();
		filtro= null;
		codigoPersonal=null;
		listaMarcacion=null;
		listaMarcacionPDF=null;
		desplegarOpcionVisualizarMarcaciones();
	}
	
	/*
	 * METODO PARA BUSCAR LAS MARCACIONES DEL USUARIO EN UN RANGO DE FECHAS
	 * */
	public void buscarMarcacion(){
		codigoPersonal=personal.getvCodpersonal();
    	if(!FuncionesFechas.validaFecha(fCargaI, fCargaF))
    	{	
    		listaMarcacion=null;
    		listaMarcacionPDF=null;
    		return ;}
    	RequestContext.getCurrentInstance().execute("formDialogWidgetVerMarcaciones.hide()");
    	MarcacionDespatch marcacionDespatch=new MarcacionDespatch();
		try {
			//listaMarcacion=marcacionDespatch.getMarcacionesPorCodigo(PGP_Usuario.getV_codpersonal());
			/*for(int i=0;i<listaMarcacion.size();i++)
			{
				if(listaMarcacion.get(i).getdFecha().after(fCargaI) && listaMarcacion.get(i).getdFecha().before(fCargaF)){
					System.out.println("Entroo\nLista ["+(i+1)+"]:"+listaMarcacion.get(i).getdFecha());
				}
			}*/
			
			listaMarcacion=marcacionDespatch.getMarcacionesPorCodigoFecha(codigoPersonal,fCargaI,fCargaF);//"44436285"
			Map parametros = new HashMap();	
			nombrePersonal=personal.getvDesapepat()+" "+personal.getvDesapemat()+" "+personal.getvDesnombres();
			parametros.put("PARAM_NRODOC", codigoPersonal);
			parametros.put("PARAM_STR_FI", FuncionesFechas.getFormatDateDDMMYYYY(fCargaI));
			parametros.put("PARAM_STR_FF", FuncionesFechas.getFormatDateDDMMYYYY(fCargaF));
			listaMarcacionPDF=marcacionDespatch.reporteMisMarcaciones(parametros);
			if(listaMarcacion.isEmpty())
			{
				Funciones.mostrarMensajeInfo("No hay marcaciones en el rango de fechas del personal seleccionado.");
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
    }
	
	/*
	 * METODO PARA MOSTRAR CUADRO DE DIALOGO DONDE ESTAN LOS DETALLES DE SU MARCACION POR JUSTIFICACION
	 * */
	public void selectVerJustificacion(VstMarcacionrrhh item)
    {    	
    	justificacionVerMotivo=item.getvMotjus();
    	justificacionVerTipo=item.getvDestipjus();
    	RequestContext.getCurrentInstance().execute("dialogWidgetDetalleJustificacion.show()");
    }
	
	/*
	 * METODO PARA MOSTRAR LA VISTA REPORTE MARCACION SIN ESTO NO SE MOSTRARIA EL REPORTE MARCACION
	 * */
	 public String verRptMarcacion(){
		 limpiar();
		 //desplegarOpcionVisualizarMarcaciones();
			String vista="pretty:rptMarcacionUnTrabajadorPretty";
	        //CODIGO
	        return  vista;
		}   
	 
	 public String getFormatDMY()
		{
			try {
				LoginDespatch loginDespatch = new LoginDespatch();
		        return loginDespatch.ObtieneFechaDMY();
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
			
		}
	 
	 public void rptMarcacionesPDF(long dat)
	 {
		//valida
		if(!FuncionesFechas.validaFecha(fCargaI,fCargaF))
		{
			limpiar();
			return;
		}
		try {
			if(listaMarcacionPDF!=null)
			{
				Map parametros = new HashMap();			
				parametros.put("fechaActual", getFormatDMY());
				parametros.put("fechaDesde", FuncionesFechas.getFormatDate(fCargaI));
				parametros.put("fechaHasta", FuncionesFechas.getFormatDate(fCargaF));				
				parametros.put("codPersonal", codigoPersonal);
				parametros.put("nomPersonal", nombrePersonal);
				int totalSobretiempo=0;
				for (Iterator iterator = listaMarcacionPDF.iterator(); iterator
						.hasNext();) {
					Map current = (Map) iterator
							.next();
					totalSobretiempo+=Integer.parseInt(current.get("sobretiempo").toString());
				}
				parametros.put("totalSobretiempo", ""+totalSobretiempo);
				FacesUtils.mostrarReporteJasper(parametros, "rptMarcacionesUnaPersona.jasper", listaMarcacionPDF, "RptMarcacionUnaPersona");
				System.out.println("Muestra reporte");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 public StreamedContent rptMarcaciones(long dat)
		{
			//valida
			if(!FuncionesFechas.validaFecha(fCargaI,fCargaF))
			{
				limpiar();
				return null;
			}
				
			//end valida
			long rnd=System.currentTimeMillis();
			try {
				
				if(listaMarcacion!=null)
				{
					Workbook wb = new XSSFWorkbook();
				    Sheet sheet = wb.createSheet("REPORTE MARCACIONES");
				    
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
				    cell.setCellValue("MARCACIONES");
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
		    	    cell.setCellValue("NRO DE DOCUMENTO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(2);
		    	    cell.setCellValue("APELLIDOS Y NOMBRES");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(3);
		    	    cell.setCellValue("FECHA MARCACION");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(4);
		    	    cell.setCellValue("HORA");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(5);
		    	    cell.setCellValue("TIPO");
		    	    cell.setCellStyle(style1);
		    	    cell=row.createCell(6);
		    	    cell.setCellValue("ORIGEN");
		    	    cell.setCellStyle(style1);
		    	    for (Iterator iterator = listaMarcacion.iterator(); iterator.hasNext();) {
		    	    	lineNum++;
						VstMarcacionrrhh obj = (VstMarcacionrrhh) iterator.next();
						row = sheet.createRow((short)lineNum);
						row.createCell(0).setCellValue((lineNum-3)+"");
						row.createCell(1).setCellValue(obj.getvCodpersonal());
						row.createCell(2).setCellValue(obj.getvDesapepat()+" "+obj.getvDesapemat()+" "+obj.getvDesnombres());
						row.createCell(3).setCellValue(obj.getdFechastr());
						row.createCell(4).setCellValue(obj.getHoraMinutosSegundos());
						row.createCell(5).setCellValue(obj.getvDestipo());
						row.createCell(6).setCellValue(obj.getvDesorigen());
					}
		    	   
		    	    FileOutputStream fileOut;
		    	    String rutaRpt=Funciones.ObtProp_Resources("ruta.reportes");
		    	    fileOut = new FileOutputStream(rutaRpt+"/rptMarcacionesUnaPersona"+rnd+".xlsx");
					wb.write(fileOut);
					fileOut.close();
					InputStream stream;
					try {
						stream = new FileInputStream(rutaRpt+"/rptMarcacionesUnaPersona"+rnd+".xlsx");					
						StreamedContent fileDownload = new DefaultStreamedContent(stream, "application/vnd.ms-excel", "rptMarcacionesUnaPersona-"+rnd+".xlsx");
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
	 
	 public void desplegarOpcionVisualizarMarcaciones(){
	    	filtro=new VstMarcacionrrhh();
	    	filtro.setvMotjus("");
	    	setListaPersonal(null);
	    	setFiltroMarcaciones(new VstPersonalrrhh());
	    	setPersonal(new VstPersonalrrhh());
	    	setOption(true);	    		    	
	    	System.out.println("OPTION:"+option);
	    }

	public void seleccionarParaVisualizar(VstPersonalrrhh item){
    	//if()
    	option=false;
    	personal= new VstPersonalrrhh();
    	personal=item;
    	buscarMarcacion();
    }
	
public void buscarPersonal(){
    	
    	if(!validaBuscarPopUp(filtroMarcaciones)){}
    	else
    	{
    		PersonalDespatch personalDespatch = new PersonalDespatch();
    		try {			    			
    			setListaPersonal(personalDespatch.getPersonalRRHH(filtroMarcaciones));    			
    		} catch (Exception e) {
    			setListaPersonal(null);
    			e.printStackTrace();
    		}
    	}
    }

public boolean validaBuscarPopUp(VstPersonalrrhh filtro)
{    	
	if (((filtro.getvCodtipodocid() == null || "".equals(filtro.getvCodtipodocid().trim())) && (filtro.getvCodpersonal()==null || "".equals(filtro.getvCodpersonal().trim())))
			&& ((filtro.getvDesapepat() == null || "".equals(filtro.getvDesapepat().trim())) && (filtro.getvDesapemat() == null || "".equals(filtro.getvDesapemat().trim())) && (filtro.getvDesnombres() == null || "".equals(filtro.getvDesnombres().trim()))))
			 {
		listaPersonal = null;
		Funciones.mostrarMensajeError("Debe ingresar o seleccionar al menos un criterio de búsqueda.");
		return false;
	}    	
	if(Funciones.documentoNoValido(filtro.getvCodtipodocid(), filtro.getvCodpersonal())){return false;}
	return true;
}

	
	
}
