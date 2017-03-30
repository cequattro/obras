package pe.gob.sunafil.tramiteext.managedBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import pe.gob.sunafil.tramiteext.bean.Permisos;
import pe.gob.sunafil.tramiteext.bean.Usuario;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.BandejaDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.ConsultaDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.RegionalDespatch;
import pe.gob.sunafil.tramiteext.mybatis.despachadores.RegistrarDespatch;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegxcorte;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTipodoctramite;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex;
import pe.gob.sunafil.tramiteext.utils.FacesUtils;

@ManagedBean(name="regionalBean")
@SessionScoped
public class RegionalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7121114257944044002L;
	
	
	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;
	@ManagedProperty("#{loginBean.PGP_Permisos}")
	private Permisos PGP_Permisos;		

	private List <Map> listaRegional;
	private String hojaHR;
	private String anioHR;
	private String tipoDoc;	
	private String nroDoc;
	private List <TdtbcTipodoctramite> listaTipoDocTraInterno;
	private Map itemSeleccionado;
	private Map itemExtornado;

	public Map getItemExtornado() {
		return itemExtornado;
	}

	public void setItemExtornado(Map itemExtornado) {
		this.itemExtornado = itemExtornado;
	}

	public Map getItemSeleccionado() {
		return itemSeleccionado;
	}

	public void setItemSeleccionado(Map itemSeleccionado) {
		this.itemSeleccionado = itemSeleccionado;
	}

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}
	
	public Permisos getPGP_Permisos() {
		return PGP_Permisos;
	}

	public void setPGP_Permisos(Permisos pGP_Permisos) {
		PGP_Permisos = pGP_Permisos;
	}
	
	public List<Map> getListaRegional() {
		return listaRegional;
	}

	public void setListaRegional(List<Map> listaRegional) {
		this.listaRegional = listaRegional;
	}

	public String getHojaHR() {
		return hojaHR;
	}

	public void setHojaHR(String hojaHR) {
		this.hojaHR = hojaHR;
	}

	public String getAnioHR() {
		return anioHR;
	}

	public void setAnioHR(String anioHR) {
		this.anioHR = anioHR;
	}
	
	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}
	
	public List<TdtbcTipodoctramite> getListaTipoDocTraInterno() {
		RegionalDespatch regionalDespatch = new RegionalDespatch();
		try {
			listaTipoDocTraInterno=regionalDespatch.getTipoDocTramiteInterno();
		} catch (Exception e) {
			listaTipoDocTraInterno=null;
			e.printStackTrace();
		}
		return listaTipoDocTraInterno;
	}

	public void setListaTipoDocTraInterno(
			List<TdtbcTipodoctramite> listaTipoDocTraInterno) {
		this.listaTipoDocTraInterno = listaTipoDocTraInterno;
	}
	
	public void buscar()
	{
		if(anioHR!=null && !"".equals(anioHR.trim()) && hojaHR!=null && !"".equals(hojaHR.trim()) && tipoDoc!=null && !"".equals(tipoDoc.trim()) && nroDoc!=null && !"".equals(nroDoc.trim()))
		{
			if(anioHR.trim().length()==4)
			{
				hojaHR=completarCon(hojaHR,10,"0",0);//para autocompletar con ceros a la izq
				if(tipoDoc!=null && !"".equals(tipoDoc.trim()))
				{
					System.out.println("tipoDoc :: "+tipoDoc);
				}
				else
				{
					tipoDoc=null;
				}
				if(nroDoc!=null && !"".equals(nroDoc.trim()))
				{
					nroDoc=completarCon(nroDoc,10,"0",0);//para autocompletar con ceros a la izq
				}
				else
				{
					nroDoc=null;
				}
				try {
					ConsultaDespatch consultaDespatch=new ConsultaDespatch();
					Map parametros = new HashMap();
					parametros.put("PARAM_HRNRO", hojaHR);
					parametros.put("PARAM_HRANIO", anioHR);
					parametros.put("PARAM_NTDOC", tipoDoc);
					parametros.put("PARAM_NREG", nroDoc);
					parametros.put("PARAM_INTENDENCIA", PGP_Usuario.getN_numint());
					listaRegional=consultaDespatch.reporteTrazabilidadRegional(parametros);
					System.out.println("list size ::: "+listaRegional.size());
					if(listaRegional.size()==0)
					{
						listaRegional=null;
					}
				} catch (Exception e) {
					listaRegional=null;
					e.printStackTrace();
				}							
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Primero debe ingresar un año válido."));
			}
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Debe ingresar todos los criterios de búsqueda."));
		}
	}
	
	public void recepcionar()
	{
		//update a campos n_flgtrex de cabecera e insercion en nueva tabla TDMVD_REGXCORTE teniendo en cuenta la dependencia y fecha de recepcion
		try {
			BandejaDespatch bandejaDespatch = new BandejaDespatch();
			TdmvcRegistro entRegRegional=new TdmvcRegistro();
			entRegRegional.setvNumanoreg(itemSeleccionado.get("V_NUMANOREG").toString());
			entRegRegional.setnNumdep(new Short(itemSeleccionado.get("N_NUMDEP").toString()));
			entRegRegional.setnNumtipodoc(new Short(itemSeleccionado.get("N_NUMTIPODOC").toString()));
			entRegRegional.setvNumreg(itemSeleccionado.get("V_NUMREG").toString());
			entRegRegional.setnFlgtrex(new Short("0"));
			bandejaDespatch.actualizarRegistro(entRegRegional);
			//insertar recepcion de registro interno
			RegionalDespatch regionalDespatch = new RegionalDespatch();
			TdmvdRegxcorte entRegXCorte=new TdmvdRegxcorte();
			entRegXCorte.setvNumanoreg(itemSeleccionado.get("PKD1").toString());
			entRegXCorte.setnNumdep(new Short(itemSeleccionado.get("PKD2").toString()));
			entRegXCorte.setnNumtipodoc(new Short(itemSeleccionado.get("PKD3").toString()));
			entRegXCorte.setvNumreg(itemSeleccionado.get("PKD4").toString());
			entRegXCorte.setnNumitem(new Short(itemSeleccionado.get("PKD5").toString()));
			entRegXCorte.setnNumenvio(new Short(itemSeleccionado.get("PKD6").toString()));
			entRegXCorte.setdFecrecmp(new Date());
			entRegXCorte.setnNumdeprmp(new Short(PGP_Usuario.getN_numdep()));
			entRegXCorte.setvNomusureg(PGP_Usuario.getV_codusu());
			entRegXCorte.setdFecreg(new Date());
			entRegXCorte.setvHostreg(FacesUtils.getIpAddress());
			regionalDespatch.recepcionarRegistroInterno(entRegXCorte);
			//post load
			buscar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Documento fue recepcionado."));
		} catch (Exception e) {
			buscar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Hubo problemas con la recepción."));
		}		
	}
	
	public void recepcionarTodo()
	{
		try {
			for (Iterator iterator = listaRegional.iterator(); iterator.hasNext();) {
				Map map = (Map) iterator.next();
				//update a campos n_flgtrex de cabecera e insercion en nueva tabla TDMVD_REGXCORTE teniendo en cuenta la dependencia y fecha de recepcion
				try {
					if(map.get("N_NUMDEPRMP")!=null)
					{
						System.out.println("Se evitó un documento ya recepcionado");
					}
					else
					{
						BandejaDespatch bandejaDespatch = new BandejaDespatch();
						TdmvcRegistro entRegRegional=new TdmvcRegistro();
						entRegRegional.setvNumanoreg(map.get("V_NUMANOREG").toString());
						entRegRegional.setnNumdep(new Short(map.get("N_NUMDEP").toString()));
						entRegRegional.setnNumtipodoc(new Short(map.get("N_NUMTIPODOC").toString()));
						entRegRegional.setvNumreg(map.get("V_NUMREG").toString());
						entRegRegional.setnFlgtrex(new Short("0"));
						bandejaDespatch.actualizarRegistro(entRegRegional);
						//insertar recepcion de registro interno
						RegionalDespatch regionalDespatch = new RegionalDespatch();
						TdmvdRegxcorte entRegXCorte=new TdmvdRegxcorte();
						entRegXCorte.setvNumanoreg(map.get("PKD1").toString());
						entRegXCorte.setnNumdep(new Short(map.get("PKD2").toString()));
						entRegXCorte.setnNumtipodoc(new Short(map.get("PKD3").toString()));
						entRegXCorte.setvNumreg(map.get("PKD4").toString());
						entRegXCorte.setnNumitem(new Short(map.get("PKD5").toString()));
						entRegXCorte.setnNumenvio(new Short(map.get("PKD6").toString()));
						entRegXCorte.setdFecrecmp(new Date());
						entRegXCorte.setnNumdeprmp(new Short(PGP_Usuario.getN_numdep()));
						entRegXCorte.setvNomusureg(PGP_Usuario.getV_codusu());
						entRegXCorte.setdFecreg(new Date());
						entRegXCorte.setvHostreg(FacesUtils.getIpAddress());
						regionalDespatch.recepcionarRegistroInterno(entRegXCorte);
					}														
				} catch (Exception e) {
					e.printStackTrace();
				}
			}		
			//post load
			buscar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Documentos fueron recepcionados."));
		} catch (Exception e) {
			buscar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Hubo problemas con la recepción."));
		}		
	}
	
	public void extornar()
	{
		//eliminación de la tabla TDMVD_REGXCORTE
		try {					
			//eliminar recepcion de registro interno
			RegionalDespatch regionalDespatch = new RegionalDespatch();
			TdmvdRegxcorte entRegXCorte=new TdmvdRegxcorte();
			entRegXCorte.setvNumanoreg(itemExtornado.get("PKD1").toString());
			entRegXCorte.setnNumdep(new Short(itemExtornado.get("PKD2").toString()));
			entRegXCorte.setnNumtipodoc(new Short(itemExtornado.get("PKD3").toString()));
			entRegXCorte.setvNumreg(itemExtornado.get("PKD4").toString());
			entRegXCorte.setnNumitem(new Short(itemExtornado.get("PKD5").toString()));
			entRegXCorte.setnNumenvio(new Short(itemExtornado.get("PKD6").toString()));			
			regionalDespatch.extornarRegistroInterno(entRegXCorte);
			//post load
			buscar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Documento fue extornado."));
		} catch (Exception e) {
			buscar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Hubo problemas con el extorno."));
		}
	}
	
	public void dialogReferencia(Map item){		
		itemSeleccionado=item;
		RequestContext.getCurrentInstance().execute("dialogWidget.show()");
	}
	
	public void dialogReferenciaTodo(){		
		RequestContext.getCurrentInstance().execute("dialogWidget2.show()");
	}
	
	public void dialogReferenciaExtornar(Map item){		
		itemExtornado=item;
		RequestContext.getCurrentInstance().execute("dialogWidget3.show()");
	}
	
	public String busqueda(){
		//reset all
		hojaHR="";
		anioHR="";
		tipoDoc="";
		nroDoc="";
		listaRegional=null;
		
		String vista="pretty:regionalPretty";
        //CODIGO
        return  vista;
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
