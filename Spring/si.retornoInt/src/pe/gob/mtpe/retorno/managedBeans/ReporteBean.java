package pe.gob.mtpe.retorno.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import javassist.bytecode.stackmap.TypeData.ClassName;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mtpe.retorno.bean.ParamReporte;
import pe.gob.mtpe.retorno.service.ReporteService;
import pe.gob.mtpe.retorno.util.funciones.Funciones;
import pe.gob.mtpe.retorno.utils.FacesUtils;

@Controller
@Scope("session")
public class ReporteBean implements Serializable {

	final static Logger logger = Logger.getLogger(ClassName.class);

	@Autowired
	private ReporteService reporteService;

	private ParamReporte paramReporte;
	private boolean enviaReporte;
	public List<Map> lista;
	public boolean rptConTableDs;
	public String reporte;
	public String nombreReporte;
	public Map parameters;		
	
	public ReporteBean() {
		inicializarObjetos();
	}

	private void inicializarObjetos() {
		paramReporte = new ParamReporte();
		
	}
	
	@PostConstruct
	private void inicializaListas(){		
		enviaReporte=false;
		lista = new ArrayList<Map>();
		rptConTableDs = true;
		reporte = "";
		nombreReporte = "";
		parameters = new HashMap();		
	}
	
	public void validaParametros(){
		try {
			String mensaje="";
			mensaje=Funciones.validarFecha(paramReporte.getFechaInicio());
			mensaje=Funciones.validarFecha(paramReporte.getFechaFin());
			RequestContext context=RequestContext.getCurrentInstance();
			lista = new ArrayList<Map>();
			parameters = new HashMap();			

			reporte = "";
			nombreReporte = "";
			rptConTableDs = true;
			paramReporte.setFechaFin("01/"+paramReporte.getFechaFin());
			paramReporte.setFechaInicio("01/"+paramReporte.getFechaInicio());
			
			if("".equals(mensaje)){
				if ("1".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr01.jrxml";
					nombreReporte = "Reporte 1";
					lista = reporteService.mostrarReprote1(paramReporte);
				} else if ("2".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr02.jrxml";
					nombreReporte = "Reporte 2";
					lista = reporteService.mostrarReprote2(paramReporte);
				} else if ("3".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr03.jrxml";
					nombreReporte = "Reporte 3";
					lista = reporteService.mostrarReprote3(paramReporte);
				} else if ("4".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr04.jrxml";
					nombreReporte = "Reporte 4";
					lista = reporteService.mostrarReprote4(paramReporte);
				} else if ("5".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr05.jrxml";
					nombreReporte = "Reporte 5";
					lista = reporteService.mostrarReprote5(paramReporte);
				} else if ("6".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr06.jrxml";
					nombreReporte = "Reporte 6";
					lista = reporteService.mostrarReprote6(paramReporte);
				} else if ("7".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr07.jrxml";
					nombreReporte = "Reporte 7";
					lista = reporteService.mostrarReprote7(paramReporte);
				} else if ("8".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr08.jrxml";
					nombreReporte = "Reporte 8";
					lista = reporteService.mostrarReprote8(paramReporte);
				} else if ("9".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr09.jrxml";
					nombreReporte = "Reporte 9";
					lista = reporteService.mostrarReprote9(paramReporte);
				} else if ("10".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr10.jrxml";
					nombreReporte = "Reporte 10";
					lista = reporteService.mostrarReprote10(paramReporte);
				} else if ("11".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr11.jrxml";
					nombreReporte = "Reporte 11";
					rptConTableDs=false;
					lista = reporteService.mostrarReprote11(paramReporte);
				} else if ("12".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr12.jrxml";
					nombreReporte = "Reporte 12";
					lista = reporteService.mostrarReprote12(paramReporte);
				}else if ("13".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr13.jrxml";
					nombreReporte = "Reporte 13";
					rptConTableDs=false;
					lista = reporteService.mostrarReprote13(paramReporte);
				}else if ("14".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr14.jrxml";
					nombreReporte = "Reporte 14";
					rptConTableDs=false;
					lista = reporteService.mostrarReprote14(paramReporte);
				}else if ("15".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr15.jrxml";
					nombreReporte = "Reporte 15";
					lista = reporteService.mostrarReprote15(paramReporte);
					rptConTableDs=false;
				}else if ("16".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr16.jrxml";
					nombreReporte = "Reporte 16";
					lista = reporteService.mostrarReprote16(paramReporte);
					rptConTableDs=false;
				}else if ("17".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr17.jrxml";
					nombreReporte = "Reporte 17";
					lista = reporteService.mostrarReprote17(paramReporte);
					rptConTableDs=false;
				}else if ("18".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr18.jrxml";
					nombreReporte = "Reporte 18";
					lista = reporteService.mostrarReprote18(paramReporte);
					rptConTableDs=false;
				}else if ("19".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr19.jrxml";
					nombreReporte = "Reporte 19";
					lista = reporteService.mostrarReprote19(paramReporte);
					rptConTableDs=false;
				}else if ("20".equals(paramReporte.getTipoReporte())) {
					reporte = "rptPr20.jrxml";
					nombreReporte = "Reporte 20";
					lista = reporteService.mostrarReprote20(paramReporte);
					rptConTableDs=false;
				}
			}
			
			if(lista==null){
				mensaje+="<br/>La lista de datos esta vacia por favor intente con otro rango<br/>";
			}else{
				if(lista.size()<=0){
					mensaje+="<br/>La lista de datos esta vacia por favor intente con otro rango<br/>";
				}
			}
			if("".equals(mensaje)){
				enviaReporte=true;				
				context.addCallbackParam("error",false);
			}else{
				enviaReporte=false;
				FacesUtils.showFacesMessage(mensaje, 1);
				context.addCallbackParam("error",true);
				
			}
			
		} catch (Exception e) {
			logger.error("ERROR=[] ", e);
		}
		
	}

	public void mostrarReportePDF() throws Exception {
		try {			
			if(rptConTableDs){				
				parameters.put("P_LISTA", lista);
				FacesUtils.mostrarReporte(parameters, reporte, lista.subList(0, 1), nombreReporte);
			}else{
				FacesUtils.mostrarReporte(parameters, reporte, lista, nombreReporte);
			}
		} catch (Exception e) {
			logger.error("ERROR ", e);
		}

	}

	public void mostrarReporteXLS() throws Exception {
		try {
			
			reporte="x"+reporte;
			if (rptConTableDs) {
				parameters.put("P_LISTA", lista);
				FacesUtils.mostrarReporteExcel(parameters, reporte, lista.subList(0, 1), nombreReporte);
			} else if(!rptConTableDs && ("11".equals(paramReporte.getTipoReporte()) || "13".equals(paramReporte.getTipoReporte()) || "14".equals(paramReporte.getTipoReporte()) || "20".equals(paramReporte.getTipoReporte()) )){
				FacesUtils.mostrarReporteExcel(parameters, reporte, lista, nombreReporte);			
			}else {				
				//CONSTRUIMOS EL REPORTE EN EXCEL Y LO FLUSHEAMOS
				Workbook wb = new XSSFWorkbook();
				Sheet sheet = wb.createSheet(nombreReporte);
				CellStyle style0 =wb.createCellStyle();
				CellStyle style1 =wb.createCellStyle();
				CellStyle style2 =wb.createCellStyle();
				//CREAMOS LOS ESTILOS PARA LAS CELDAS DE EXCEL
			    FacesUtils.crearEstilosToWorkbook(wb,style0,style1,style2);
			    int lineNum=0;
			    //INSTANCIAMOS LA PRIMERA LINEA O FILA
			    Row row = sheet.createRow((short)lineNum);
			    
			    if ("15".equals(paramReporte.getTipoReporte())) {
			    	//CREAMOS LOS ENCABEZADOS DEL REPORTE
				    FacesUtils.crearEncabezadoReporte15(wb,sheet,row,style0,style1,lineNum);
				    lineNum=5;//YA QUE DEBE EMPEZAR LUEGO DE LA CABECERA
		    	    //=============================================================
		    	    //INI INGRESANDO LA DATA OBTENIDA DE BASE DE DATOS
		    	    //=============================================================
		    	    String tot_hombres="";
		    	    String tot_mujeres="";
		    	    String tot_total="";
		    	    for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
						Map map = (Map) iterator.next();							
						row = sheet.createRow((short)lineNum);
			    	    row.createCell(1).setCellValue(map.get("RANGO")+"");
			    	    row.getCell(1).setCellStyle(style2);
			    	    row.createCell(2).setCellValue(map.get("HOMBRES")+"");
			    	    row.getCell(2).setCellStyle(style2);
			    	    row.createCell(3).setCellValue(map.get("MUJERES")+"");
			    	    row.getCell(3).setCellStyle(style2);
			    	    row.createCell(4).setCellValue(map.get("TOTAL")+"");
			    	    row.getCell(4).setCellStyle(style2);
			    	    tot_hombres=map.get("TOT_HOMBRES")+"";
			    	    tot_mujeres=map.get("TOT_MUJERES")+"";
			    	    tot_total=map.get("TOTAL_GENERAL")+"";
			    	    lineNum++;
						
					}
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(1).setCellValue("TOTAL");
		    	    row.getCell(1).setCellStyle(style2);
		    	    row.createCell(2).setCellValue(tot_hombres);
		    	    row.getCell(2).setCellStyle(style2);
		    	    row.createCell(3).setCellValue(tot_mujeres);
		    	    row.getCell(3).setCellStyle(style2);
		    	    row.createCell(4).setCellValue(tot_total);
		    	    row.getCell(4).setCellStyle(style2);
		    	    //=============================================================
		    	    //FIN INGRESANDO LA DATA OBTENIDA DE BASE DE DATOS
		    	    //=============================================================
			    }else if ("16".equals(paramReporte.getTipoReporte())) {
			    	//CREAMOS LOS ENCABEZADOS DEL REPORTE
				    FacesUtils.crearEncabezadoReporte16(wb,sheet,row,style0,style1,lineNum);
				    lineNum=6;//YA QUE DEBE EMPEZAR LUEGO DE LA CABECERA
				    //=============================================================
		    	    //INI INGRESANDO LA DATA OBTENIDA DE BASE DE DATOS
		    	    //=============================================================
		    	    float tot_jov=0;
		    	    float tot_adjov=0;
		    	    float tot_adu=0;
		    	    float tot_adumay=0;
		    	    float tot_total=0;
		    	    for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
						Map map = (Map) iterator.next();							
						row = sheet.createRow((short)lineNum);
			    	    row.createCell(1).setCellValue(map.get("RANGO")+"");
			    	    row.getCell(1).setCellStyle(style2);
			    	    row.createCell(2).setCellValue(map.get("joven")+"");
			    	    row.getCell(2).setCellStyle(style2);
			    	    row.createCell(3).setCellValue(map.get("porjoven")+"");
			    	    row.getCell(3).setCellStyle(style2);
			    	    row.createCell(4).setCellValue(map.get("adjov")+"");
			    	    row.getCell(4).setCellStyle(style2);
			    	    row.createCell(5).setCellValue(map.get("poradjov")+"");
			    	    row.getCell(5).setCellStyle(style2);
			    	    row.createCell(6).setCellValue(map.get("adult")+"");
			    	    row.getCell(6).setCellStyle(style2);
			    	    row.createCell(7).setCellValue(map.get("poradult")+"");
			    	    row.getCell(7).setCellStyle(style2);
			    	    row.createCell(8).setCellValue(map.get("adultmay")+"");
			    	    row.getCell(8).setCellStyle(style2);
			    	    row.createCell(9).setCellValue(map.get("poradultmay")+"");
			    	    row.getCell(9).setCellStyle(style2);
			    	    row.createCell(10).setCellValue(map.get("TOTAL")+"");
			    	    row.getCell(10).setCellStyle(style2);
			    	    
			    	    tot_jov=tot_jov+Float.parseFloat(map.get("joven")+"");
			    	    tot_adjov=tot_adjov+Float.parseFloat(map.get("adjov")+"");;
			    	    tot_adu=tot_adu+Float.parseFloat(map.get("adult")+"");;
			    	    tot_adumay=tot_adumay+Float.parseFloat(map.get("adultmay")+"");;
			    	    tot_total=tot_total+Float.parseFloat(map.get("TOTAL")+"");;
			    	    lineNum++;
						
					}
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(1).setCellValue("TOTAL");
		    	    row.getCell(1).setCellStyle(style2);
		    	    row.createCell(2).setCellValue(tot_jov);	
		    	    row.getCell(2).setCellStyle(style2);
		    	    row.createCell(3).setCellValue(Math.round(tot_jov*100/tot_total));
		    	    row.getCell(3).setCellStyle(style2);
		    	    row.createCell(4).setCellValue(tot_adjov);
		    	    row.getCell(4).setCellStyle(style2);
		    	    row.createCell(5).setCellValue(Math.round(tot_adjov*100/tot_total));
		    	    row.getCell(5).setCellStyle(style2);
		    	    row.createCell(6).setCellValue(tot_adu);
		    	    row.getCell(6).setCellStyle(style2);
		    	    row.createCell(7).setCellValue(Math.round(tot_adu*100/tot_total));
		    	    row.getCell(7).setCellStyle(style2);
		    	    row.createCell(8).setCellValue(tot_adumay);
		    	    row.getCell(8).setCellStyle(style2);
		    	    row.createCell(9).setCellValue(Math.round(tot_adumay*100/tot_total));
		    	    row.getCell(9).setCellStyle(style2);
		    	    row.createCell(10).setCellValue(tot_total);
		    	    row.getCell(10).setCellStyle(style2);
		    	    //=============================================================
		    	    //FIN INGRESANDO LA DATA OBTENIDA DE BASE DE DATOS
		    	    //=============================================================
				    
			    }else if ("17".equals(paramReporte.getTipoReporte())) {
			    	//CREAMOS LOS ENCABEZADOS DEL REPORTE
				    FacesUtils.crearEncabezadoReporte17(wb,sheet,row,style0,style1,lineNum);
				    lineNum=5;//YA QUE DEBE EMPEZAR LUEGO DE LA CABECERA
				    //=============================================================
		    	    //INI INGRESANDO LA DATA OBTENIDA DE BASE DE DATOS
		    	    //=============================================================
				    float pais=0;
				    float de0a4=0;
				    float de5a9=0;
				    float de10a14=0;
				    float de15a19=0;
				    float de20a24=0;
				    float de25a29=0;
				    float de30a34=0;
				    float de35a39=0;
				    float de40a44=0;
				    float de45a49=0;
				    float de50a54=0;
				    float de55a59=0;
				    float de60a64=0;
				    float de65a69=0;
				    float de70a74=0;
				    float de75a79=0;
				    float de80aMas=0;		    	    
		    	    float tot_total=0;
		    	    for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
						Map map = (Map) iterator.next();							
						boolean totalEsCero = Integer.parseInt(map.get("TOTAL")+"") == 0 ? true:false;
						row = sheet.createRow((short)lineNum);
			    	    row.createCell(1).setCellValue(map.get("pais")+"");
			    	    row.getCell(1).setCellStyle(style2);
			    	    row.createCell(2).setCellValue(map.get("de0a4")+"");
			    	    row.getCell(2).setCellStyle(style2);
			    	    row.createCell(3).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de0a4")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));//redondeo a 1 decimal
			    	    row.getCell(3).setCellStyle(style2);
			    	    row.createCell(4).setCellValue(map.get("de5a9")+"");
			    	    row.getCell(4).setCellStyle(style2);
			    	    row.createCell(5).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de5a9")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(5).setCellStyle(style2);
			    	    row.createCell(6).setCellValue(map.get("de10a14")+"");
			    	    row.getCell(6).setCellStyle(style2);
			    	    row.createCell(7).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de10a14")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(7).setCellStyle(style2);
			    	    row.createCell(8).setCellValue(map.get("de15a19")+"");
			    	    row.getCell(8).setCellStyle(style2);
			    	    row.createCell(9).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de15a19")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(9).setCellStyle(style2);
			    	    row.createCell(10).setCellValue(map.get("de20a24")+"");
			    	    row.getCell(10).setCellStyle(style2);
			    	    row.createCell(11).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de20a24")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(11).setCellStyle(style2);
			    	    row.createCell(12).setCellValue(map.get("de25a29")+"");
			    	    row.getCell(12).setCellStyle(style2);
			    	    row.createCell(13).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de25a29")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(13).setCellStyle(style2);
			    	    row.createCell(14).setCellValue(map.get("de30a34")+"");
			    	    row.getCell(14).setCellStyle(style2);
			    	    row.createCell(15).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de30a34")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(15).setCellStyle(style2);
			    	    row.createCell(16).setCellValue(map.get("de35a39")+"");
			    	    row.getCell(16).setCellStyle(style2);
			    	    row.createCell(17).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de35a39")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(17).setCellStyle(style2);
			    	    row.createCell(18).setCellValue(map.get("de40a44")+"");
			    	    row.getCell(18).setCellStyle(style2);
			    	    row.createCell(19).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de40a44")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(19).setCellStyle(style2);
			    	    row.createCell(20).setCellValue(map.get("de45a49")+"");
			    	    row.getCell(20).setCellStyle(style2);
			    	    row.createCell(21).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de45a49")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(21).setCellStyle(style2);
			    	    row.createCell(22).setCellValue(map.get("de50a54")+"");
			    	    row.getCell(22).setCellStyle(style2);
			    	    row.createCell(23).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de50a54")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(23).setCellStyle(style2);
			    	    row.createCell(24).setCellValue(map.get("de55a59")+"");
			    	    row.getCell(24).setCellStyle(style2);
			    	    row.createCell(25).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de55a59")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(25).setCellStyle(style2);
			    	    row.createCell(26).setCellValue(map.get("de60a64")+"");
			    	    row.getCell(26).setCellStyle(style2);
			    	    row.createCell(27).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de60a64")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(27).setCellStyle(style2);
			    	    row.createCell(28).setCellValue(map.get("de65a69")+"");
			    	    row.getCell(28).setCellStyle(style2);
			    	    row.createCell(29).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de65a69")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(29).setCellStyle(style2);
			    	    row.createCell(30).setCellValue(map.get("de70a74")+"");
			    	    row.getCell(30).setCellStyle(style2);
			    	    row.createCell(31).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de70a74")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(31).setCellStyle(style2);
			    	    row.createCell(32).setCellValue(map.get("de75a79")+"");
			    	    row.getCell(32).setCellStyle(style2);
			    	    row.createCell(33).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de75a79")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(33).setCellStyle(style2);
			    	    row.createCell(34).setCellValue(map.get("de80aMas")+"");
			    	    row.getCell(34).setCellStyle(style2);
			    	    row.createCell(35).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de80aMas")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(35).setCellStyle(style2);
			    	    row.createCell(36).setCellValue(map.get("TOTAL")+"");
			    	    row.getCell(36).setCellStyle(style2);
			    	    
			    	    de0a4=de0a4+Float.parseFloat(map.get("de0a4")+"");
			    	    de5a9=de5a9+Float.parseFloat(map.get("de5a9")+"");
			    	    de10a14=de10a14+Float.parseFloat(map.get("de10a14")+"");
			    	    de15a19=de15a19+Float.parseFloat(map.get("de15a19")+"");
			    	    de20a24=de20a24+Float.parseFloat(map.get("de20a24")+"");
			    	    de25a29=de25a29+Float.parseFloat(map.get("de25a29")+"");
			    	    de30a34=de30a34+Float.parseFloat(map.get("de30a34")+"");
			    	    de35a39=de35a39+Float.parseFloat(map.get("de35a39")+"");
			    	    de40a44=de40a44+Float.parseFloat(map.get("de40a44")+"");
			    	    de45a49=de45a49+Float.parseFloat(map.get("de45a49")+"");
			    	    de50a54=de50a54+Float.parseFloat(map.get("de50a54")+"");
			    	    de55a59=de55a59+Float.parseFloat(map.get("de55a59")+"");
			    	    de60a64=de60a64+Float.parseFloat(map.get("de60a64")+"");
			    	    de65a69=de65a69+Float.parseFloat(map.get("de65a69")+"");
			    	    de70a74=de70a74+Float.parseFloat(map.get("de70a74")+"");
			    	    de75a79=de75a79+Float.parseFloat(map.get("de75a79")+"");
			    	    de80aMas=de80aMas+Float.parseFloat(map.get("de80aMas")+"");
			    	    tot_total=tot_total+Float.parseFloat(map.get("TOTAL")+"");
			    	    lineNum++;
						
					}
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(1).setCellValue("TOTAL");
		    	    row.getCell(1).setCellStyle(style2);
		    	    row.createCell(2).setCellValue(de0a4);
		    	    row.getCell(2).setCellStyle(style2);
		    	    row.createCell(3).setCellValue(Math.round(de0a4*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(3).setCellStyle(style2);
		    	    row.createCell(2).setCellValue(de0a4);
		    	    row.getCell(2).setCellStyle(style2);
		    	    row.createCell(3).setCellValue(Math.round(de0a4*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(3).setCellStyle(style2);
		    	    row.createCell(4).setCellValue(de5a9);
		    	    row.getCell(4).setCellStyle(style2);
		    	    row.createCell(5).setCellValue(Math.round(de5a9*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(5).setCellStyle(style2);
		    	    row.createCell(6).setCellValue(de10a14);
		    	    row.getCell(6).setCellStyle(style2);
		    	    row.createCell(7).setCellValue(Math.round(de10a14*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(7).setCellStyle(style2);
		    	    row.createCell(8).setCellValue(de15a19);
		    	    row.getCell(8).setCellStyle(style2);
		    	    row.createCell(9).setCellValue(Math.round(de15a19*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(9).setCellStyle(style2);
		    	    row.createCell(10).setCellValue(de20a24);
		    	    row.getCell(10).setCellStyle(style2);
		    	    row.createCell(11).setCellValue(Math.round(de20a24*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(11).setCellStyle(style2);
		    	    row.createCell(12).setCellValue(de25a29);
		    	    row.getCell(12).setCellStyle(style2);
		    	    row.createCell(13).setCellValue(Math.round(de25a29*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(13).setCellStyle(style2);
		    	    row.createCell(14).setCellValue(de30a34);
		    	    row.getCell(14).setCellStyle(style2);
		    	    row.createCell(15).setCellValue(Math.round(de30a34*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(15).setCellStyle(style2);
		    	    row.createCell(16).setCellValue(de35a39);
		    	    row.getCell(16).setCellStyle(style2);
		    	    row.createCell(17).setCellValue(Math.round(de35a39*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(17).setCellStyle(style2);
		    	    row.createCell(18).setCellValue(de40a44);
		    	    row.getCell(18).setCellStyle(style2);
		    	    row.createCell(19).setCellValue(Math.round(de40a44*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(19).setCellStyle(style2);
		    	    row.createCell(20).setCellValue(de45a49);
		    	    row.getCell(20).setCellStyle(style2);
		    	    row.createCell(21).setCellValue(Math.round(de45a49*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(21).setCellStyle(style2);
		    	    row.createCell(22).setCellValue(de50a54);
		    	    row.getCell(22).setCellStyle(style2);
		    	    row.createCell(23).setCellValue(Math.round(de50a54*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(23).setCellStyle(style2);
		    	    row.createCell(24).setCellValue(de55a59);
		    	    row.getCell(24).setCellStyle(style2);
		    	    row.createCell(25).setCellValue(Math.round(de55a59*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(25).setCellStyle(style2);
		    	    row.createCell(26).setCellValue(de60a64);
		    	    row.getCell(26).setCellStyle(style2);
		    	    row.createCell(27).setCellValue(Math.round(de60a64*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(27).setCellStyle(style2);
		    	    row.createCell(28).setCellValue(de65a69);
		    	    row.getCell(28).setCellStyle(style2);
		    	    row.createCell(29).setCellValue(Math.round(de65a69*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(29).setCellStyle(style2);
		    	    row.createCell(30).setCellValue(de70a74);
		    	    row.getCell(30).setCellStyle(style2);
		    	    row.createCell(31).setCellValue(Math.round(de70a74*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(31).setCellStyle(style2);
		    	    row.createCell(32).setCellValue(de75a79);
		    	    row.getCell(32).setCellStyle(style2);
		    	    row.createCell(33).setCellValue(Math.round(de75a79*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(33).setCellStyle(style2);
		    	    row.createCell(34).setCellValue(de80aMas);
		    	    row.getCell(34).setCellStyle(style2);
		    	    row.createCell(35).setCellValue(Math.round(de80aMas*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(35).setCellStyle(style2);
		    	    row.createCell(36).setCellValue(tot_total);
		    	    row.getCell(36).setCellStyle(style2);
		    	    //=============================================================
		    	    //FIN INGRESANDO LA DATA OBTENIDA DE BASE DE DATOS
		    	    //=============================================================
				    
				    
				    
				    
				    
				    
			    }else if ("18".equals(paramReporte.getTipoReporte())) {
			    	//CREAMOS LOS ENCABEZADOS DEL REPORTE
				    FacesUtils.crearEncabezadoReporte18(wb,sheet,row,style0,style1,lineNum);
				    lineNum=5;//YA QUE DEBE EMPEZAR LUEGO DE LA CABECERA
				    
		    	    //=============================================================
		    	    //INI INGRESANDO LA DATA OBTENIDA DE BASE DE DATOS
		    	    //=============================================================
		    	    float tot_hombres=0;
		    	    float tot_mujeres=0;
		    	    float tot_total=0;
		    	    for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
						Map map = (Map) iterator.next();							
						boolean totalEsCero = Integer.parseInt(map.get("TOTAL")+"") == 0 ? true:false;
						row = sheet.createRow((short)lineNum);
			    	    row.createCell(1).setCellValue(map.get("departamento")+"");
			    	    row.getCell(1).setCellStyle(style2);
			    	    row.createCell(2).setCellValue(map.get("HOMBRES")+"");
			    	    row.getCell(2).setCellStyle(style2);
			    	    row.createCell(3).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("HOMBRES")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));//redondeo a 1 decimal
			    	    row.getCell(3).setCellStyle(style2);
			    	    row.createCell(4).setCellValue(map.get("MUJERES")+"");
			    	    row.getCell(4).setCellStyle(style2);
			    	    row.createCell(5).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("MUJERES")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));//redondeo a 1 decimal
			    	    row.getCell(5).setCellStyle(style2);
			    	    row.createCell(6).setCellValue(map.get("TOTAL")+"");
			    	    row.getCell(6).setCellStyle(style2);
			    	    
			    	    tot_hombres=tot_hombres+Float.parseFloat(map.get("HOMBRES")+"");
			    	    tot_mujeres=tot_mujeres+Float.parseFloat(map.get("MUJERES")+"");
			    	    tot_total=tot_total+Float.parseFloat(map.get("TOTAL")+"");
			    	    lineNum++;
						
					}
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(1).setCellValue("TOTAL");
		    	    row.getCell(1).setCellStyle(style2);
		    	    row.createCell(2).setCellValue(tot_hombres);
		    	    row.getCell(2).setCellStyle(style2);
		    	    row.createCell(3).setCellValue(Math.round(tot_hombres*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(3).setCellStyle(style2);
		    	    row.createCell(4).setCellValue(tot_mujeres);
		    	    row.getCell(4).setCellStyle(style2);
		    	    row.createCell(5).setCellValue(Math.round(tot_mujeres*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(5).setCellStyle(style2);
		    	    row.createCell(6).setCellValue(tot_total);
		    	    row.getCell(6).setCellStyle(style2);
		    	    //=============================================================
		    	    //FIN INGRESANDO LA DATA OBTENIDA DE BASE DE DATOS
		    	    //=============================================================
				    
				    
			    }else if ("19".equals(paramReporte.getTipoReporte())) {
			    	//CREAMOS LOS ENCABEZADOS DEL REPORTE
				    FacesUtils.crearEncabezadoReporte19(wb,sheet,row,style0,style1,lineNum);
				    lineNum=5;//YA QUE DEBE EMPEZAR LUEGO DE LA CABECERA
				    
				  //=============================================================
		    	    //INI INGRESANDO LA DATA OBTENIDA DE BASE DE DATOS
		    	    //=============================================================
				    
				    float de0a4=0;
				    float de5a9=0;
				    float de10a14=0;
				    float de15a19=0;
				    float de20a24=0;
				    float de25a29=0;
				    float de30a34=0;
				    float de35a39=0;
				    float de40a44=0;
				    float de45a49=0;
				    float de50a54=0;
				    float de55a59=0;
				    float de60a64=0;
				    float de65a69=0;
				    float de70a74=0;
				    float de75a79=0;
				    float de80aMas=0;		    	    
		    	    float tot_total=0;
		    	    for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
						Map map = (Map) iterator.next();							
						boolean totalEsCero = Integer.parseInt(map.get("TOTAL")+"") == 0 ? true:false;
						row = sheet.createRow((short)lineNum);
			    	    row.createCell(1).setCellValue(map.get("departamento")+"");
			    	    row.getCell(1).setCellStyle(style2);
			    	    row.createCell(2).setCellValue(map.get("de0a4")+"");
			    	    row.getCell(2).setCellStyle(style2);
			    	    row.createCell(3).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de0a4")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));//redondeo a 1 decimal
			    	    row.getCell(3).setCellStyle(style2);
			    	    row.createCell(4).setCellValue(map.get("de5a9")+"");
			    	    row.getCell(4).setCellStyle(style2);
			    	    row.createCell(5).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de5a9")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(5).setCellStyle(style2);
			    	    row.createCell(6).setCellValue(map.get("de10a14")+"");
			    	    row.getCell(6).setCellStyle(style2);
			    	    row.createCell(7).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de10a14")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(7).setCellStyle(style2);
			    	    row.createCell(8).setCellValue(map.get("de15a19")+"");
			    	    row.getCell(8).setCellStyle(style2);
			    	    row.createCell(9).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de15a19")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(9).setCellStyle(style2);
			    	    row.createCell(10).setCellValue(map.get("de20a24")+"");
			    	    row.getCell(10).setCellStyle(style2);
			    	    row.createCell(11).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de20a24")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(11).setCellStyle(style2);
			    	    row.createCell(12).setCellValue(map.get("de25a29")+"");
			    	    row.getCell(12).setCellStyle(style2);
			    	    row.createCell(13).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de25a29")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(13).setCellStyle(style2);
			    	    row.createCell(14).setCellValue(map.get("de30a34")+"");
			    	    row.getCell(14).setCellStyle(style2);
			    	    row.createCell(15).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de30a34")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(15).setCellStyle(style2);
			    	    row.createCell(16).setCellValue(map.get("de35a39")+"");
			    	    row.getCell(16).setCellStyle(style2);
			    	    row.createCell(17).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de35a39")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(17).setCellStyle(style2);
			    	    row.createCell(18).setCellValue(map.get("de40a44")+"");
			    	    row.getCell(18).setCellStyle(style2);
			    	    row.createCell(19).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de40a44")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(19).setCellStyle(style2);
			    	    row.createCell(20).setCellValue(map.get("de45a49")+"");
			    	    row.getCell(20).setCellStyle(style2);
			    	    row.createCell(21).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de45a49")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(21).setCellStyle(style2);
			    	    row.createCell(22).setCellValue(map.get("de50a54")+"");
			    	    row.getCell(22).setCellStyle(style2);
			    	    row.createCell(23).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de50a54")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(23).setCellStyle(style2);
			    	    row.createCell(24).setCellValue(map.get("de55a59")+"");
			    	    row.getCell(24).setCellStyle(style2);
			    	    row.createCell(25).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de55a59")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(25).setCellStyle(style2);
			    	    row.createCell(26).setCellValue(map.get("de60a64")+"");
			    	    row.getCell(26).setCellStyle(style2);
			    	    row.createCell(27).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de60a64")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(27).setCellStyle(style2);
			    	    row.createCell(28).setCellValue(map.get("de65a69")+"");
			    	    row.getCell(28).setCellStyle(style2);
			    	    row.createCell(29).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de65a69")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(29).setCellStyle(style2);
			    	    row.createCell(30).setCellValue(map.get("de70a74")+"");
			    	    row.getCell(30).setCellStyle(style2);
			    	    row.createCell(31).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de70a74")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(31).setCellStyle(style2);
			    	    row.createCell(32).setCellValue(map.get("de75a79")+"");
			    	    row.getCell(32).setCellStyle(style2);
			    	    row.createCell(33).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de75a79")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(33).setCellStyle(style2);
			    	    row.createCell(34).setCellValue(map.get("de80aMas")+"");
			    	    row.getCell(34).setCellStyle(style2);
			    	    row.createCell(35).setCellValue(totalEsCero?0:(Math.round(Float.parseFloat(map.get("de80aMas")+"")*1000/Float.parseFloat(map.get("TOTAL")+"")))/Float.parseFloat(10+""));
			    	    row.getCell(35).setCellStyle(style2);
			    	    row.createCell(36).setCellValue(map.get("TOTAL")+"");
			    	    row.getCell(36).setCellStyle(style2);
			    	    
			    	    de0a4=de0a4+Float.parseFloat(map.get("de0a4")+"");
			    	    de5a9=de5a9+Float.parseFloat(map.get("de5a9")+"");
			    	    de10a14=de10a14+Float.parseFloat(map.get("de10a14")+"");
			    	    de15a19=de15a19+Float.parseFloat(map.get("de15a19")+"");
			    	    de20a24=de20a24+Float.parseFloat(map.get("de20a24")+"");
			    	    de25a29=de25a29+Float.parseFloat(map.get("de25a29")+"");
			    	    de30a34=de30a34+Float.parseFloat(map.get("de30a34")+"");
			    	    de35a39=de35a39+Float.parseFloat(map.get("de35a39")+"");
			    	    de40a44=de40a44+Float.parseFloat(map.get("de40a44")+"");
			    	    de45a49=de45a49+Float.parseFloat(map.get("de45a49")+"");
			    	    de50a54=de50a54+Float.parseFloat(map.get("de50a54")+"");
			    	    de55a59=de55a59+Float.parseFloat(map.get("de55a59")+"");
			    	    de60a64=de60a64+Float.parseFloat(map.get("de60a64")+"");
			    	    de65a69=de65a69+Float.parseFloat(map.get("de65a69")+"");
			    	    de70a74=de70a74+Float.parseFloat(map.get("de70a74")+"");
			    	    de75a79=de75a79+Float.parseFloat(map.get("de75a79")+"");
			    	    de80aMas=de80aMas+Float.parseFloat(map.get("de80aMas")+"");
			    	    tot_total=tot_total+Float.parseFloat(map.get("TOTAL")+"");
			    	    lineNum++;
						
					}
		    	    row = sheet.createRow((short)lineNum);
		    	    row.createCell(1).setCellValue("TOTAL");
		    	    row.getCell(1).setCellStyle(style2);
		    	    row.createCell(2).setCellValue(de0a4);
		    	    row.getCell(2).setCellStyle(style2);
		    	    row.createCell(3).setCellValue(Math.round(de0a4*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(3).setCellStyle(style2);
		    	    row.createCell(2).setCellValue(de0a4);
		    	    row.getCell(2).setCellStyle(style2);
		    	    row.createCell(3).setCellValue(Math.round(de0a4*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(3).setCellStyle(style2);
		    	    row.createCell(4).setCellValue(de5a9);
		    	    row.getCell(4).setCellStyle(style2);
		    	    row.createCell(5).setCellValue(Math.round(de5a9*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(5).setCellStyle(style2);
		    	    row.createCell(6).setCellValue(de10a14);
		    	    row.getCell(6).setCellStyle(style2);
		    	    row.createCell(7).setCellValue(Math.round(de10a14*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(7).setCellStyle(style2);
		    	    row.createCell(8).setCellValue(de15a19);
		    	    row.getCell(8).setCellStyle(style2);
		    	    row.createCell(9).setCellValue(Math.round(de15a19*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(9).setCellStyle(style2);
		    	    row.createCell(10).setCellValue(de20a24);
		    	    row.getCell(10).setCellStyle(style2);
		    	    row.createCell(11).setCellValue(Math.round(de20a24*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(11).setCellStyle(style2);
		    	    row.createCell(12).setCellValue(de25a29);
		    	    row.getCell(12).setCellStyle(style2);
		    	    row.createCell(13).setCellValue(Math.round(de25a29*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(13).setCellStyle(style2);
		    	    row.createCell(14).setCellValue(de30a34);
		    	    row.getCell(14).setCellStyle(style2);
		    	    row.createCell(15).setCellValue(Math.round(de30a34*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(15).setCellStyle(style2);
		    	    row.createCell(16).setCellValue(de35a39);
		    	    row.getCell(16).setCellStyle(style2);
		    	    row.createCell(17).setCellValue(Math.round(de35a39*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(17).setCellStyle(style2);
		    	    row.createCell(18).setCellValue(de40a44);
		    	    row.getCell(18).setCellStyle(style2);
		    	    row.createCell(19).setCellValue(Math.round(de40a44*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(19).setCellStyle(style2);
		    	    row.createCell(20).setCellValue(de45a49);
		    	    row.getCell(20).setCellStyle(style2);
		    	    row.createCell(21).setCellValue(Math.round(de45a49*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(21).setCellStyle(style2);
		    	    row.createCell(22).setCellValue(de50a54);
		    	    row.getCell(22).setCellStyle(style2);
		    	    row.createCell(23).setCellValue(Math.round(de50a54*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(23).setCellStyle(style2);
		    	    row.createCell(24).setCellValue(de55a59);
		    	    row.getCell(24).setCellStyle(style2);
		    	    row.createCell(25).setCellValue(Math.round(de55a59*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(25).setCellStyle(style2);
		    	    row.createCell(26).setCellValue(de60a64);
		    	    row.getCell(26).setCellStyle(style2);
		    	    row.createCell(27).setCellValue(Math.round(de60a64*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(27).setCellStyle(style2);
		    	    row.createCell(28).setCellValue(de65a69);
		    	    row.getCell(28).setCellStyle(style2);
		    	    row.createCell(29).setCellValue(Math.round(de65a69*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(29).setCellStyle(style2);
		    	    row.createCell(30).setCellValue(de70a74);
		    	    row.getCell(30).setCellStyle(style2);
		    	    row.createCell(31).setCellValue(Math.round(de70a74*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(31).setCellStyle(style2);
		    	    row.createCell(32).setCellValue(de75a79);
		    	    row.getCell(32).setCellStyle(style2);
		    	    row.createCell(33).setCellValue(Math.round(de75a79*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(33).setCellStyle(style2);
		    	    row.createCell(34).setCellValue(de80aMas);
		    	    row.getCell(34).setCellStyle(style2);
		    	    row.createCell(35).setCellValue(Math.round(de80aMas*1000/tot_total)/Float.parseFloat(10+""));
		    	    row.getCell(35).setCellStyle(style2);
		    	    row.createCell(36).setCellValue(tot_total);
		    	    row.getCell(36).setCellStyle(style2);
		    	    //=============================================================
		    	    //FIN INGRESANDO LA DATA OBTENIDA DE BASE DE DATOS
		    	    //=============================================================
				    
				    
				}
			    
	    	    FacesUtils.mostrarReporteWorkbookExcel(wb,nombreReporte);
		    	    
			}
		} catch (Exception e) {
			logger.error("ERROR ", e);
		}

	}

	public ParamReporte getParamReporte() {
		return paramReporte;
	}

	public void setParamReporte(ParamReporte paramReporte) {
		this.paramReporte = paramReporte;
	}

	public boolean isEnviaReporte() {
		return enviaReporte;
	}

	public void setEnviaReporte(boolean enviaReporte) {
		this.enviaReporte = enviaReporte;
	}

	public List<Map> getLista() {
		return lista;
	}

	public void setLista(List<Map> lista) {
		this.lista = lista;
	}

	public boolean isRptConTableDs() {
		return rptConTableDs;
	}

	public void setRptConTableDs(boolean rptConTableDs) {
		this.rptConTableDs = rptConTableDs;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public String getNombreReporte() {
		return nombreReporte;
	}

	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}
	
	

}
