package pe.gob.sunafil.tramiteext.managedBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.primefaces.context.RequestContext;

import pe.gob.sunafil.tramiteext.bean.Usuario;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.ConsultaDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.RegistrarDespatch;
import pe.gob.sunafil.tramiteext.persistence.model.VstConsultastrex;
import pe.gob.sunafil.tramiteext.utils.FacesUtils;

@ManagedBean(name="consultaBean")
@SessionScoped
public class ConsultaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1080254734910465240L;
	
	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;
	
	private String tipoBusqueda;
	private String tp1HojaRuta;
	private String tp1AnioHR;
	private Date tp2FI;//=new Date();
	private Date tp2FF;//=new Date();
	private String tp2TipoDocRem;
	private String tp2NroDocRem;
	private String tp2Rem;
	private String tp2Asunto;
	private String tp2Dependencia;
	private String tp2TipoDoc;
	private String tp2NroDoc;
	private String tp2Tramite;
	private Date tp3FI;//=new Date();
	private Date tp3FF;//=new Date();
	private String tp3Tupa;
	private Date tp4FI;//=new Date();
	private Date tp4FF;//=new Date();
	private String tp4CodCargo;
	private String tp4AnioCargo;
	private List <VstConsultastrex> bandejaConsultas;
	private List<Map> detalleTrazabilidad;
	private String mensaje;
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Map> getDetalleTrazabilidad() {
		return detalleTrazabilidad;
	}

	public void setDetalleTrazabilidad(List<Map> detalleTrazabilidad) {
		this.detalleTrazabilidad = detalleTrazabilidad;
	}

	public String getTp1HojaRuta() {
		return tp1HojaRuta;
	}

	public void setTp1HojaRuta(String tp1HojaRuta) {
		this.tp1HojaRuta = tp1HojaRuta;
	}

	public String getTp1AnioHR() {
		return tp1AnioHR;
	}

	public void setTp1AnioHR(String tp1AnioHR) {
		this.tp1AnioHR = tp1AnioHR;
	}

	public Date getTp2FI() {
		return tp2FI;
	}

	public void setTp2FI(Date tp2fi) {
		tp2FI = tp2fi;
	}

	public Date getTp2FF() {
		return tp2FF;
	}

	public void setTp2FF(Date tp2ff) {
		tp2FF = tp2ff;
	}

	public String getTp2TipoDocRem() {
		return tp2TipoDocRem;
	}

	public void setTp2TipoDocRem(String tp2TipoDocRem) {
		this.tp2TipoDocRem = tp2TipoDocRem;
	}

	public String getTp2NroDocRem() {
		return tp2NroDocRem;
	}

	public void setTp2NroDocRem(String tp2NroDocRem) {
		this.tp2NroDocRem = tp2NroDocRem;
	}

	public String getTp2Rem() {
		return tp2Rem;
	}

	public void setTp2Rem(String tp2Rem) {
		this.tp2Rem = tp2Rem;
	}

	public String getTp2Asunto() {
		return tp2Asunto;
	}

	public void setTp2Asunto(String tp2Asunto) {
		this.tp2Asunto = tp2Asunto;
	}

	public String getTp2Dependencia() {
		return tp2Dependencia;
	}

	public void setTp2Dependencia(String tp2Dependencia) {
		this.tp2Dependencia = tp2Dependencia;
	}

	public String getTp2TipoDoc() {
		return tp2TipoDoc;
	}

	public void setTp2TipoDoc(String tp2TipoDoc) {
		this.tp2TipoDoc = tp2TipoDoc;
	}

	public String getTp2NroDoc() {
		return tp2NroDoc;
	}

	public void setTp2NroDoc(String tp2NroDoc) {
		this.tp2NroDoc = tp2NroDoc;
	}

	public String getTp2Tramite() {
		return tp2Tramite;
	}

	public void setTp2Tramite(String tp2Tramite) {
		this.tp2Tramite = tp2Tramite;
	}

	public Date getTp3FI() {
		return tp3FI;
	}

	public void setTp3FI(Date tp3fi) {
		tp3FI = tp3fi;
	}

	public Date getTp3FF() {
		return tp3FF;
	}

	public void setTp3FF(Date tp3ff) {
		tp3FF = tp3ff;
	}

	public String getTp3Tupa() {
		return tp3Tupa;
	}

	public void setTp3Tupa(String tp3Tupa) {
		this.tp3Tupa = tp3Tupa;
	}

	public Date getTp4FI() {
		return tp4FI;
	}

	public void setTp4FI(Date tp4fi) {
		tp4FI = tp4fi;
	}

	public Date getTp4FF() {
		return tp4FF;
	}

	public void setTp4FF(Date tp4ff) {
		tp4FF = tp4ff;
	}

	public String getTp4CodCargo() {
		return tp4CodCargo;
	}

	public void setTp4CodCargo(String tp4CodCargo) {
		this.tp4CodCargo = tp4CodCargo;
	}

	public String getTp4AnioCargo() {
		return tp4AnioCargo;
	}

	public void setTp4AnioCargo(String tp4AnioCargo) {
		this.tp4AnioCargo = tp4AnioCargo;
	}

	public List<VstConsultastrex> getBandejaConsultas() {
		return bandejaConsultas;
	}

	public void setBandejaConsultas(List<VstConsultastrex> bandejaConsultas) {
		this.bandejaConsultas = bandejaConsultas;
	}	

	public String getTipoBusqueda() {
		return tipoBusqueda;
	}

	public void setTipoBusqueda(String tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}
	
	public void itemChangeBusqueda()
	{
		tp1HojaRuta="";
		tp1AnioHR="";
		tp2FI=null;
		tp2FF=null;
		tp2TipoDocRem="";
		tp2NroDocRem="";
		tp2Rem="";
		tp2Asunto="";
		tp2Dependencia="";
		tp2TipoDoc="";
		tp2NroDoc="";
		tp2Tramite="";
		tp3FI=null;
		tp3FF=null;
		tp3Tupa="";
		tp4FI=null;
		tp4FF=null;
		tp4CodCargo="";
		tp4AnioCargo="";
		bandejaConsultas=null;
	}
	
	public void dialogSeguimiento(VstConsultastrex item){	
		try {
			ConsultaDespatch consultaDespatch=new ConsultaDespatch();		
			Map parametros = new HashMap();
			parametros.put("PARAM_HRNRO", item.getvNumhoja());
			parametros.put("PARAM_HRANIO", item.getvAniohoja());
			parametros.put("PARAM_CURNRO", item.getvNumreg());
			parametros.put("PARAM_CURANIO", item.getvNumanoreg());
			detalleTrazabilidad=consultaDespatch.reporteTrazabilidad(parametros);
		} catch (Exception e) {
			e.printStackTrace();
			detalleTrazabilidad=null;
		}
		RequestContext.getCurrentInstance().execute("dialogWidgetSeg.show()");
	}
	
	public void xlsBusqueda() 
    {
		try {
			FacesUtils.mostrarXLSX("/jsfDocs/modulos/ejemplo/", "busqueda.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public boolean validarConsulta()
	{
		mensaje="";		
		if("1".equals(tipoBusqueda))
		{
			if("".equals(tp1AnioHR.trim()) || "".equals(tp1HojaRuta.trim()))
			{
				mensaje="Debe ingresar hoja de ruta";
				return false;
			}
		}
		else if("2".equals(tipoBusqueda))
		{
			if(tp2FI==null && tp2FF==null && 
					(tp2TipoDocRem==null || "".equals(tp2TipoDocRem.trim())) && 
					(tp2NroDocRem==null || "".equals(tp2NroDocRem.trim())) && 
					(tp2Rem==null || "".equals(tp2Rem.trim())) &&
					(tp2Asunto==null || "".equals(tp2Asunto.trim())) &&
					(tp2Dependencia==null || "".equals(tp2Dependencia.trim())) &&
					(tp2TipoDoc==null || "".equals(tp2TipoDoc.trim())) &&
					(tp2NroDoc==null || "".equals(tp2NroDoc.trim())) &&
					(tp2Tramite==null || "".equals(tp2Tramite.trim())))
			{
				mensaje="Debe ingresar o seleccionar al menos un filtro";
				return false;
			}
			else if((tp2TipoDocRem!=null && !"".equals(tp2TipoDocRem.trim())) && (tp2NroDocRem==null || "".equals(tp2NroDocRem.trim())))
			{
				mensaje="Si selecciona un tipo de documento de remitente debe ingresar un número de documento.";
				return false;
			}
			if(tp2FI==null && tp2FF!=null)
			{
				mensaje="Se requiere ingresar Fecha Desde y Fecha Hasta.";
	            return false;
			}
			if(tp2FI!=null && tp2FF==null)
			{				
				mensaje="Se requiere ingresar Fecha Desde y Fecha Hasta.";
	            return false;
			}
			if(tp2FI!=null && tp2FF!=null)
			{
				if(tp2FF.before(tp2FI))
				{
					mensaje="La fecha hasta debe ser mayor que la fecha desde.";
		            return false;
				}
			}
		}
		else if("3".equals(tipoBusqueda))
		{
			if(tp3FI==null && tp3FF==null && (tp3Tupa==null || "".equals(tp3Tupa.trim())))
			{
				mensaje="Debe ingresar o seleccionar al menos un filtro";
				return false;
			}
			if(tp3FI==null && tp3FF!=null)
			{
				mensaje="Se requiere ingresar Fecha Desde y Fecha Hasta.";
	            return false;
			}
			if(tp3FI!=null && tp3FF==null)
			{				
				mensaje="Se requiere ingresar Fecha Desde y Fecha Hasta.";
	            return false;
			}
			if(tp3FI!=null && tp3FF!=null)
			{
				if(tp3FF.before(tp3FI))
				{
					mensaje="La fecha hasta debe ser mayor que la fecha desde.";
		            return false;
				}
			}
		}
		else if("4".equals(tipoBusqueda))
		{
			if(tp4FI==null && tp4FF==null && 
					(tp4CodCargo==null || "".equals(tp4CodCargo.trim())) && 
					(tp4AnioCargo==null || "".equals(tp4AnioCargo.trim())))
			{
				mensaje="Debe ingresar o seleccionar al menos un filtro";
				return false;
			}
			
			if((tp4CodCargo==null || "".equals(tp4CodCargo.trim())) && 
					(tp4AnioCargo!=null && !"".equals(tp4AnioCargo.trim())))
			{
				mensaje="Se requiere ingresar código y año de cargo.";
	            return false;
			}
			if((tp4CodCargo!=null && !"".equals(tp4CodCargo.trim())) && 
					(tp4AnioCargo==null || "".equals(tp4AnioCargo.trim())))
			{
				mensaje="Se requiere ingresar código y año de cargo.";
	            return false;
			}			
			
			if(tp4FI==null && tp4FF!=null)
			{
				mensaje="Se requiere ingresar Fecha Desde y Fecha Hasta.";
	            return false;
			}
			if(tp4FI!=null && tp4FF==null)
			{				
				mensaje="Se requiere ingresar Fecha Desde y Fecha Hasta.";
	            return false;
			}
			if(tp4FI!=null && tp4FF!=null)
			{
				if(tp4FF.before(tp4FI))
				{
					mensaje="La fecha hasta debe ser mayor que la fecha desde.";
		            return false;
				}
			}
		}
		return true;
	}
	
	public void buscarBandejaConsultas()
	{
		ConsultaDespatch consultaDespatch = new ConsultaDespatch();
		if(tipoBusqueda!=null && !"".equals(tipoBusqueda))
		{
			if(!validarConsulta())
			{
				bandejaConsultas=null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", mensaje));
				return;
			}
			if("1".equals(tipoBusqueda))
			{
				try {					
					if("".equals(tp1AnioHR.trim()))
					{
						tp1AnioHR=null;
					}
					if("".equals(tp1HojaRuta.trim()))
					{
						tp1HojaRuta=null;
					}
					bandejaConsultas=consultaDespatch.getConsulta(PGP_Usuario.getN_numdep(), null, null, tp1AnioHR!=null?new Short(tp1AnioHR):null, (tp1HojaRuta!=null && !"".equals(tp1HojaRuta))?completarCon(tp1HojaRuta,10,"0",0):null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,false);
				} catch (Exception e) {
					bandejaConsultas=null;
					e.printStackTrace();
				}
			}
			else if("2".equals(tipoBusqueda))
			{
				try {
					Date fechaFplus=tp2FF;
					if(tp2FF!=null)
					{
						Calendar c = Calendar.getInstance(); 
						c.setTime(tp2FF); 
						c.add(Calendar.DATE, 1);
						fechaFplus = c.getTime();
					}
					if("".equals(tp2NroDocRem.trim()))
					{
						tp2NroDocRem=null;
					}
					if("".equals(tp2Rem.trim()))
					{
						tp2Rem=null;
					}
					if("".equals(tp2Asunto.trim()))
					{
						tp2Asunto=null;
					}
					if("".equals(tp2NroDoc.trim()))
					{
						tp2NroDoc=null;
					}
					bandejaConsultas=consultaDespatch.getConsulta(PGP_Usuario.getN_numdep(), tp2FI, tp2FF!=null?fechaFplus:null, null, null, tp2TipoDocRem, tp2NroDocRem, null, tp2Rem, tp2Asunto, (tp2Dependencia!=null && !"".equals(tp2Dependencia))?new Short(tp2Dependencia):null, (tp2TipoDoc!=null && !"".equals(tp2TipoDoc))?new Short(tp2TipoDoc):null, tp2NroDoc, (tp2Tramite!=null && !"".equals(tp2Tramite))?new BigDecimal(tp2Tramite):null,null,null,null,null,null,false);
				} catch (Exception e) {
					bandejaConsultas=null;
					e.printStackTrace();
				}
			}
			else if("3".equals(tipoBusqueda))
			{
				try {
					Date fechaFplus=tp3FF;
					if(tp3FF!=null)
					{
						Calendar c = Calendar.getInstance(); 
						c.setTime(tp3FF); 
						c.add(Calendar.DATE, 1);
						fechaFplus = c.getTime();
					}								
					bandejaConsultas=consultaDespatch.getConsulta(PGP_Usuario.getN_numdep(), tp3FI, tp3FF!=null?fechaFplus:null, null, null, null, null, null,null,null,null,null,null,null,(tp3Tupa!=null && !"".equals(tp3Tupa))?tp3Tupa:null,null,null,null,null,true);
				} catch (Exception e) {
					bandejaConsultas=null;
					e.printStackTrace();
				}
			}
			else if("4".equals(tipoBusqueda))
			{
				try {
					Date fechaFplus=tp4FF;
					if(tp4FF!=null)
					{
						Calendar c = Calendar.getInstance(); 
						c.setTime(tp4FF); 
						c.add(Calendar.DATE, 1);
						fechaFplus = c.getTime();
					}						
					if("".equals(tp4CodCargo.trim()))
					{
						tp4CodCargo=null;
					}
					if("".equals(tp4AnioCargo.trim()))
					{
						tp4AnioCargo=null;
					}
					bandejaConsultas=consultaDespatch.getConsulta(PGP_Usuario.getN_numdep(), null, null, null, null, null, null, null,null,null,null,null,null,null,null,tp4FI, tp4FF!=null?fechaFplus:null,tp4CodCargo,tp4AnioCargo,false);
				} catch (Exception e) {
					bandejaConsultas=null;
					e.printStackTrace();
				}
			}
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe seleccionar un tipo de búsqueda e ingresar algún criterio."));
			return;
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
	
	public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
         
        HSSFCellStyle cellStyle = wb.createCellStyle();  
        cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
         
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            HSSFCell cell = header.getCell(i);
             
            cell.setCellStyle(cellStyle);
        }
    }
	
	public String busqueda(){
		//reset all
		tipoBusqueda="";
		tp1HojaRuta="";
		tp1AnioHR="";
		tp2FI=null;
		tp2FF=null;
		tp2TipoDocRem="";
		tp2NroDocRem="";
		tp2Rem="";
		tp2Asunto="";
		tp2Dependencia="";
		tp2TipoDoc="";
		tp2NroDoc="";
		tp2Tramite="";
		tp3FI=null;
		tp3FF=null;
		tp3Tupa="";
		tp4FI=null;
		tp4FF=null;
		tp4CodCargo="";
		tp4AnioCargo="";
		bandejaConsultas=null;
		
		String vista="pretty:busquedaPretty";
        //CODIGO
        return  vista;
	}
	
	public String getFormatHourCargo(String corte) {
		try {
			ConsultaDespatch consultaDespatch=new ConsultaDespatch();		
			Map parametros = new HashMap();
			parametros.put("PARAM_CORTE", corte);
			return consultaDespatch.getHoraCargo(parametros);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

}
