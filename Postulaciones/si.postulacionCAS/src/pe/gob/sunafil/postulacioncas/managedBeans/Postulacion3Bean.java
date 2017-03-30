package pe.gob.sunafil.postulacioncas.managedBeans;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import pe.gob.sunafil.postulacioncas.bean.Combo;
import pe.gob.sunafil.postulacioncas.bean.ExperienciaLaboral;
import pe.gob.sunafil.postulacioncas.bean.ReferenciasLaborales;
import pe.gob.sunafil.postulacioncas.funciones.Funciones;
import pe.gob.sunafil.postulacioncas.mybatis.despachadores.CombosDespatch;
import pe.gob.sunafil.postulacioncas.mybatis.despachadores.Postulacion1Despatch;
import pe.gob.sunafil.postulacioncas.mybatis.despachadores.SecScreenDespatch;
import pe.gob.sunafil.postulacioncas.mybatis.despachadores.ThirdScreenDespatch;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcExperiencia;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxcapacitac;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxformacion;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxotrdoc;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcReferencia;
import pe.gob.sunafil.postulacioncas.utils.EnviarMail;
import pe.gob.sunafil.postulacioncas.utils.FacesUtils;

@ManagedBean(name="postulacion3Bean")
@SessionScoped
public class Postulacion3Bean {
private static Logger logger = Logger.getLogger(Postulacion3Bean.class.getName());
	
	@ManagedProperty("#{postulacion1Bean}")
	private Postulacion1Bean postulacion1Bean;
	@ManagedProperty("#{postulacion2Bean}")
	private Postulacion2Bean postulacion2Bean;
	
	private List<ExperienciaLaboral> lstExperienciaGen = new ArrayList();
	private String entidadg;
	private String puestog;
	private String funcionesg;
	private Date fechaIg;
	private Date fechaFg;
	private String tiempog;
	
	private List<ExperienciaLaboral> lstExperienciaPro = new ArrayList();
	private String entidadp;
	private String puestop;
	private String funcionesp;
	private Date fechaIp;
	private Date fechaFp;
	private String tiempop;
	
	private List<ReferenciasLaborales> lstReferencia = new ArrayList();
	private String entidadr;
	private String nombrerefr;
	private String puestor;
	private String telefonor;
	
	
	private String hvCod;//codigo de hoja de vida global		
	
	private ExperienciaLaboral expLab_a_elim;
	private ReferenciasLaborales refLab_a_elim;
	
	
	public ExperienciaLaboral getExpLab_a_elim() {
		return expLab_a_elim;
	}
	public void setExpLab_a_elim(ExperienciaLaboral expLab_a_elim) {
		this.expLab_a_elim = expLab_a_elim;
	}
	public ReferenciasLaborales getRefLab_a_elim() {
		return refLab_a_elim;
	}
	public void setRefLab_a_elim(ReferenciasLaborales refLab_a_elim) {
		this.refLab_a_elim = refLab_a_elim;
	}
	public String getHvCod() {
		return hvCod;
	}
	public void setHvCod(String hvCod) {
		this.hvCod = hvCod;
	}
	public List<ExperienciaLaboral> getLstExperienciaGen() {
		return lstExperienciaGen;
	}
	public void setLstExperienciaGen(List<ExperienciaLaboral> lstExperienciaGen) {
		this.lstExperienciaGen = lstExperienciaGen;
	}
	public String getEntidadg() {
		return entidadg;
	}
	public void setEntidadg(String entidadg) {
		this.entidadg = entidadg;
	}
	public String getPuestog() {
		return puestog;
	}
	public void setPuestog(String puestog) {
		this.puestog = puestog;
	}
	public String getFuncionesg() {
		return funcionesg;
	}
	public void setFuncionesg(String funcionesg) {
		this.funcionesg = funcionesg;
	}
	public Date getFechaIg() {
		return fechaIg;
	}
	public void setFechaIg(Date fechaIg) {
		this.fechaIg = fechaIg;
	}
	public Date getFechaFg() {
		return fechaFg;
	}
	public void setFechaFg(Date fechaFg) {
		this.fechaFg = fechaFg;
	}
	public String getTiempog() {
		return tiempog;
	}
	public void setTiempog(String tiempog) {
		this.tiempog = tiempog;
	}
	public List<ExperienciaLaboral> getLstExperienciaPro() {
		return lstExperienciaPro;
	}
	public void setLstExperienciaPro(List<ExperienciaLaboral> lstExperienciaPro) {
		this.lstExperienciaPro = lstExperienciaPro;
	}
	public String getEntidadp() {
		return entidadp;
	}
	public void setEntidadp(String entidadp) {
		this.entidadp = entidadp;
	}
	public String getPuestop() {
		return puestop;
	}
	public void setPuestop(String puestop) {
		this.puestop = puestop;
	}
	public String getFuncionesp() {
		return funcionesp;
	}
	public void setFuncionesp(String funcionesp) {
		this.funcionesp = funcionesp;
	}
	public Date getFechaIp() {
		return fechaIp;
	}
	public void setFechaIp(Date fechaIp) {
		this.fechaIp = fechaIp;
	}
	public Date getFechaFp() {
		return fechaFp;
	}
	public void setFechaFp(Date fechaFp) {
		this.fechaFp = fechaFp;
	}
	public String getTiempop() {
		return tiempop;
	}
	public void setTiempop(String tiempop) {
		this.tiempop = tiempop;
	}
	public List<ReferenciasLaborales> getLstReferencia() {
		return lstReferencia;
	}
	public void setLstReferencia(List<ReferenciasLaborales> lstReferencia) {
		this.lstReferencia = lstReferencia;
	}
	public String getEntidadr() {
		return entidadr;
	}
	public void setEntidadr(String entidadr) {
		this.entidadr = entidadr;
	}
	public String getNombrerefr() {
		return nombrerefr;
	}
	public void setNombrerefr(String nombrerefr) {
		this.nombrerefr = nombrerefr;
	}
	public String getPuestor() {
		return puestor;
	}
	public void setPuestor(String puestor) {
		this.puestor = puestor;
	}
	public String getTelefonor() {
		return telefonor;
	}
	public void setTelefonor(String telefonor) {
		this.telefonor = telefonor;
	}
	public Postulacion1Bean getPostulacion1Bean() {
		return postulacion1Bean;
	}
	public void setPostulacion1Bean(Postulacion1Bean postulacion1Bean) {
		this.postulacion1Bean = postulacion1Bean;
	}
	public Postulacion2Bean getPostulacion2Bean() {
		return postulacion2Bean;
	}
	public void setPostulacion2Bean(Postulacion2Bean postulacion2Bean) {
		this.postulacion2Bean = postulacion2Bean;
	}
	
	public Postulacion3Bean() {
		inicializar();
	}
	@SuppressWarnings("rawtypes")
	public void inicializar(){
		logger.info("Entra a inicializar postulacionBean3");
		try {
			//aqui inicializamos al entrar al formulario
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	public String datos3Postulaciones(){
		
		if(postulacion2Bean.getLstFormacion().isEmpty())
		{
			Funciones.mostrarMensajeError("Debe completar la información acerca de su formación académica.");
			return "pretty:registroPostulacion2";
		}
		/*
		if(postulacion2Bean.getLstCapacitacion().isEmpty())
		{
			Funciones.mostrarMensajeError("Debe completar la información acerca de sus capacitaciones.");
			return "pretty:registroPostulacion2";
		}
		if(postulacion2Bean.getLstOtrosDoc().isEmpty())
		{
			Funciones.mostrarMensajeError("Debe completar la información acerca de los documentos complementarios.");
			return "pretty:registroPostulacion2";
		}*/
		return "pretty:registroPostulacion3";
	}
	
	public void mostrarMensajeErrorSistema(){
		Funciones.mostrarMensajeError("Estimado Usuario, ocurrieron inconvenientes al ingresar su hoja de vida, por favor contactarse con sistemas de SUNAFIL.");
	}
	
	public void avisoAntesDeGrabar()
	{
		System.out.println("Se muestra mensaje de aviso");
		RequestContext.getCurrentInstance().execute("dialogConfirmacionGarbar.show()");
	}
	public String datosConfirmacion(){
		if(lstExperienciaGen.isEmpty())
		{
			Funciones.mostrarMensajeError("Debe completar la información acerca de su experiencia laboral general.");
			return "pretty:registroPostulacion3";
		}
		if(lstExperienciaPro.isEmpty())
		{
			Funciones.mostrarMensajeError("Debe completar la información acerca de su experiencia laboral profesional.");
			return "pretty:registroPostulacion3";
		}
		if(lstReferencia.isEmpty())
		{
			Funciones.mostrarMensajeError("Debe completar la información acerca de sus referencias laborales.");
			return "pretty:registroPostulacion3";
		}
		//GUARDAR DATOS DE 3 PANTALLAS
		Postulacion1Despatch firstScreenDespatch = new Postulacion1Despatch();
		SecScreenDespatch secScreenDespatch = new SecScreenDespatch();
		ThirdScreenDespatch thirdScreenDespatch = new ThirdScreenDespatch();
		
		
		try {
			logger.info("ENTRANDO A INSERTAR CABECERAS....");
			hvCod=firstScreenDespatch.insertarPostulacionCabecera(postulacion1Bean.getHojadevida(), postulacion1Bean.getPersona());
		} catch (Exception e) {
			hvCod=null;
			e.printStackTrace();
			mostrarMensajeErrorSistema();
			return "pretty:registroPostulacion3";
		}
		
		if(hvCod!=null)
		{
			logger.info("Se guardo la hoja de vida ::: "+hvCod);
			
			//FORMACION ACADEMICA
			try {
				logger.info("Insertando la lista de Formacion Laboral....");
				for (Iterator iterator = postulacion2Bean.getLstFormacion().iterator(); iterator.hasNext();) {
					Map row = (Map) iterator.next();
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					
					RhmvcHvxformacion nuevaFormacion=new RhmvcHvxformacion();
					nuevaFormacion.setnCorhvfor(new BigDecimal(postulacion2Bean.getSiguienteCorrelativoMovimientoFormacion()));
					nuevaFormacion.setnCorhojvid(new BigDecimal(hvCod));
					nuevaFormacion.setnCodfor(new BigDecimal(row.get("nivel").toString()));
					nuevaFormacion.setnCorgraaca(new BigDecimal(row.get("grado").toString()));
					nuevaFormacion.setvCentroest(row.get("centro").toString());
					nuevaFormacion.setvEspecialidad(row.get("especialidad").toString());
					try {
						if(!"".equals(row.get("fi"))) nuevaFormacion.setdFecini(sdf.parse(row.get("fi").toString()));
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						if(!"".equals(row.get("fe"))) nuevaFormacion.setdFecfin(sdf.parse(row.get("fe").toString()));
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						if(!"".equals(row.get("fex"))) nuevaFormacion.setdFecextdip(sdf.parse(row.get("fex").toString()));
					} catch (Exception e) {
						e.printStackTrace();
					}
					nuevaFormacion.setvCiudad(row.get("ciudad").toString());
					nuevaFormacion.setvCodpais(row.get("pais").toString());
					nuevaFormacion.setdFecreg(new Date());
					nuevaFormacion.setvHostreg(FacesUtils.getIpAddress());
					
					secScreenDespatch.insertarMovimientoFormacion(nuevaFormacion);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				mostrarMensajeErrorSistema();
				return "pretty:registroPostulacion3";
			}
			
			//CAPACITACION
			try {
				logger.info("Insertando la lista de Capacitacion....");
				for (Iterator iterator = postulacion2Bean.getLstCapacitacion().iterator(); iterator.hasNext();) {
					Map row = (Map) iterator.next();
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					
					RhmvcHvxcapacitac nuevaCapacitacion=new RhmvcHvxcapacitac();
					nuevaCapacitacion.setnCorhvcap(new BigDecimal(postulacion2Bean.getSiguienteCorrelativoMovimientoCapacitacion()));
					nuevaCapacitacion.setnCorhojvid(new BigDecimal(hvCod));
					nuevaCapacitacion.setnCortipcap(new BigDecimal(row.get("tipo").toString()));
					nuevaCapacitacion.setvCentroest(row.get("centro").toString());
					nuevaCapacitacion.setvTema(row.get("tema").toString());
					try {
						nuevaCapacitacion.setdFecini(sdf.parse(row.get("fi").toString()));
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						nuevaCapacitacion.setdFecfin(sdf.parse(row.get("ft").toString()));
					} catch (Exception e) {
						e.printStackTrace();
					}
					nuevaCapacitacion.setnHordurac(new BigDecimal(row.get("duracion").toString()));
					nuevaCapacitacion.setdFecreg(new Date());
					nuevaCapacitacion.setvHostreg(FacesUtils.getIpAddress());
					
					secScreenDespatch.insertarMovimientoCapacitacion(nuevaCapacitacion);
				}
			} catch (Exception e) {
				e.printStackTrace();
				mostrarMensajeErrorSistema();
				return "pretty:registroPostulacion3";
			}
			
			//OTROS DOCUMENTOS
			try {
				logger.info("Insertando la lista de Otros Documentos....");
				for (Iterator iterator = postulacion2Bean.getLstOtrosDoc().iterator(); iterator.hasNext();) {
					Map row = (Map) iterator.next();
					
					RhmvcHvxotrdoc nuevoOtro=new RhmvcHvxotrdoc();
					nuevoOtro.setnCorhvdoc(new BigDecimal(postulacion2Bean.getSiguienteCorrelativoOtrosDocumentos()));
					nuevoOtro.setnCorhojvid(new BigDecimal(hvCod));
					nuevoOtro.setvDescripcion(row.get("otrodoc").toString());
					
					secScreenDespatch.insertarOtrosDocumentos(nuevoOtro);
				}
			} catch (Exception e) {
				e.printStackTrace();
				mostrarMensajeErrorSistema();
				return "pretty:registroPostulacion3";
			}
			
			
			//EXPERIENCIA DE TRABAJO - LABORAL GENERAL:
			try {
				logger.info("Insertando la lista de Experiencia Laboral General....");
				for(ExperienciaLaboral expLab:lstExperienciaGen){
					RhmvcExperiencia nuevaexpLab = new RhmvcExperiencia();
					nuevaexpLab.setnCorexp(new BigDecimal(getSiguienteCorrelativoExperiencia()));
					nuevaexpLab.setnCorhojvid(new BigDecimal(hvCod));
					nuevaexpLab.setvEntidad(expLab.getV_entidad());
					
					nuevaexpLab.setvPuesto(expLab.getV_puesto());
					nuevaexpLab.setvFunciones(expLab.getV_funciones());
					
					SimpleDateFormat simpleDate=new SimpleDateFormat("dd/MM/yyyy");
					Date fecIni=simpleDate.parse(expLab.getD_fecini());
					nuevaexpLab.setdFecini(fecIni);
					Date fecFin=simpleDate.parse(expLab.getD_fecfin());
					nuevaexpLab.setdFecfin(fecFin);
					nuevaexpLab.setvFlgtipexp("G");
					nuevaexpLab.setdFecreg(new Date());
					nuevaexpLab.setvHostreg(FacesUtils.getIpAddress());
					thirdScreenDespatch.insertarExperiencia(nuevaexpLab);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				mostrarMensajeErrorSistema();
				return "pretty:registroPostulacion3";
			}
			
			//EXPERIENCIA DE TRABAJO - PROFESIONAL O ESPECIFICA:
			try {
				logger.info("Insertando la lista de Experiencia Laboral Especifica....");
				for(ExperienciaLaboral expLab:lstExperienciaPro){
					RhmvcExperiencia nuevaexpLab = new RhmvcExperiencia();
					nuevaexpLab.setnCorexp(new BigDecimal(getSiguienteCorrelativoExperiencia()));
					nuevaexpLab.setnCorhojvid(new BigDecimal(hvCod));
					nuevaexpLab.setvEntidad(expLab.getV_entidad());
					
					nuevaexpLab.setvPuesto(expLab.getV_puesto());
					nuevaexpLab.setvFunciones(expLab.getV_funciones());
					
					SimpleDateFormat simpleDate=new SimpleDateFormat("dd/MM/yyyy");
					Date fecIni=simpleDate.parse(expLab.getD_fecini());
					nuevaexpLab.setdFecini(fecIni);
					Date fecFin=simpleDate.parse(expLab.getD_fecfin());
					nuevaexpLab.setdFecfin(fecFin);
					nuevaexpLab.setvFlgtipexp("E");
					nuevaexpLab.setdFecreg(new Date());
					nuevaexpLab.setvHostreg(FacesUtils.getIpAddress());
					
					thirdScreenDespatch.insertarExperiencia(nuevaexpLab);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				mostrarMensajeErrorSistema();
				return "pretty:registroPostulacion3";
			}
			
			//REFERENCIAS LABORALES:
			try {
				logger.info("Insertando la lista de Referencias....");
				for(ReferenciasLaborales refLab:lstReferencia){
					RhmvcReferencia nuevaRefLab = new RhmvcReferencia();
					nuevaRefLab.setnCorref(new BigDecimal(getSiguienteCorrelativoReferencia()));
					nuevaRefLab.setnCorhojvid(new BigDecimal(hvCod));
					nuevaRefLab.setvEntidad(refLab.getV_entidad());
					nuevaRefLab.setvNomref(refLab.getV_nomref());
					nuevaRefLab.setvCargo(refLab.getV_cargo());
					nuevaRefLab.setvTelefono(refLab.getV_telefono());
					nuevaRefLab.setdFecreg(new Date());
					nuevaRefLab.setvHostreg(FacesUtils.getIpAddress());
					
					thirdScreenDespatch.insertarReferencia(nuevaRefLab);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				mostrarMensajeErrorSistema();
				return "pretty:registroPostulacion3";
			}
			
			//ENVIO DE CORREO
			EnviarMail enviarCorreo=new EnviarMail();
			String[] direcciones=new String[4];
			direcciones[0]=postulacion1Bean.getHojadevida().getV_correo().toLowerCase();//Mail de postulante
			direcciones[1]="wcastro@sunafil.gob.pe";//Willy
			direcciones[2]="rgarrido@sunafil.gob.pe";//Richard
			direcciones[3]="kaguilar@sunafil.gob.pe";//Richard
			String mensaje="";								
			String asunto="Nueva Postulación";
			mensaje  = formatEmail()+" <br/><br/><br/>";//"<b>DNI</b> =<b>'"+entidadSeleccionada.getvCodentidad()+"'</b> <br/>"
					 //+ ":: Nueva denuncia virtual. <br/>";				 
			if(direcciones.length>0 && direcciones!=null){
				try {
					//enviarCorreo.generarEnvioDeCorreos(mensaje, direcciones,asunto);
					CombosDespatch dspcombos = new CombosDespatch();
					Map parametros = new HashMap();
					Combo convocatoria=dspcombos.convocatoriaByCod(postulacion1Bean.getHojadevida().getN_corconv()).get(0);
					parametros.put("P_CONVOCATORIA", convocatoria.getV_descripcion());//
					parametros.put("P_PUESTO", ""+postulacion1Bean.getHojadevida().getV_desconv().toUpperCase());//			
					parametros.put("P_NOMBRE", postulacion1Bean.getPersona().getV_nombres().toUpperCase()+" "+postulacion1Bean.getPersona().getV_apepat().toUpperCase()+" "+postulacion1Bean.getPersona().getV_apemat().toUpperCase());//
					Combo solDep=dspcombos.departamentoByCod(postulacion1Bean.getPersona().getV_coddepnac()).get(0);
					Combo solPro=dspcombos.provinciaByCod(postulacion1Bean.getPersona().getV_coddepnac(), postulacion1Bean.getPersona().getV_codpronac()).get(0);
					Combo solDis=dspcombos.distritoByCod(postulacion1Bean.getPersona().getV_coddepnac(), postulacion1Bean.getPersona().getV_codpronac(), postulacion1Bean.getPersona().getV_coddisnac()).get(0);
					parametros.put("P_DESDISNAC", solDis.getV_descripcion().toUpperCase());//
					parametros.put("P_DESPRONAC", solPro.getV_descripcion().toUpperCase());//
					parametros.put("P_DESDEPNAC", solDep.getV_descripcion().toUpperCase());
					parametros.put("P_FECNAC", getFormatDate(postulacion1Bean.getPersona().getD_fecnac()));
					parametros.put("P_NACIONALI", postulacion1Bean.getHojadevida().getV_nacionalidad().toUpperCase());
					Combo estadoCivil=dspcombos.estadoCivilByCod(postulacion1Bean.getHojadevida().getV_codestciv()).get(0);
					parametros.put("P_DESESTCIV", estadoCivil.getV_descripcion().toUpperCase());
					parametros.put("P_NUMDOC", postulacion1Bean.getPersona().getV_numdoc().toUpperCase());
					parametros.put("P_DIRECCION", postulacion1Bean.getHojadevida().getV_direccion().toUpperCase());
					parametros.put("P_URBANIZAC", postulacion1Bean.getHojadevida().getV_urbanizac().toUpperCase());			
					Combo solDepDir=dspcombos.departamentoByCod(postulacion1Bean.getHojadevida().getV_coddepdom()).get(0);
					Combo solProDir=dspcombos.provinciaByCod(postulacion1Bean.getHojadevida().getV_coddepdom(), postulacion1Bean.getHojadevida().getV_codprodom()).get(0);
					Combo solDisDir=dspcombos.distritoByCod(postulacion1Bean.getHojadevida().getV_coddepdom(), postulacion1Bean.getHojadevida().getV_codprodom(), postulacion1Bean.getHojadevida().getV_coddisdom()).get(0);						
					parametros.put("P_DESDIS", solDisDir.getV_descripcion().toUpperCase());
					parametros.put("P_DESPRO", solProDir.getV_descripcion().toUpperCase());
					parametros.put("P_DESDEP", solDepDir.getV_descripcion().toUpperCase());
					parametros.put("P_TELFIJ", postulacion1Bean.getHojadevida().getV_telfij());
					parametros.put("P_TELCEL", postulacion1Bean.getHojadevida().getV_telcel());
					parametros.put("P_DESCOLEGIO", postulacion1Bean.getHojadevida().getV_descolegio().toUpperCase());
					parametros.put("P_NUMREGCOL", postulacion1Bean.getHojadevida().getV_numregcol().toUpperCase());
					parametros.put("P_FLGDIS", "S".equals(postulacion1Bean.getHojadevida().getV_flgdis())?"SI":"NO");
					parametros.put("P_FLGFFAA", "S".equals(postulacion1Bean.getHojadevida().getV_flglicfa())?"SI":"NO");					
					parametros.put("P_LST_FORMACION", postulacion2Bean.getLstFormacion());
					parametros.put("P_LST_CAPACITACION", postulacion2Bean.getLstCapacitacion());
					parametros.put("P_LST_OTROS", postulacion2Bean.getLstOtrosDoc());
					//parametros.put("P_LST_OTROS", postulacion2Bean.getLstOtrosDoc());
					parametros.put("P_LST_EXP_GEN", lstExperienciaGen);
					parametros.put("P_LST_EXP_PRO", lstExperienciaPro);
					parametros.put("P_LST_REFERENCIA", lstReferencia);					
					parametros.put("P_FECHA_ACTUAL", "Lima, "+getFormatDate(new Date()).split("/")[0]+" de "+getFormatMes(Integer.parseInt(getFormatDate(new Date()).split("/")[1]))+" del "+getFormatDate(new Date()).split("/")[2]);
					Combo anioMesDiaG=dspcombos.totalExperiencia(hvCod, "G").get(0);
					parametros.put("P_TOTAL_EGEN", anioMesDiaG.getV_descripcion().split("\\|")[0]+" años, "+anioMesDiaG.getV_descripcion().split("\\|")[1]+" meses, "+anioMesDiaG.getV_descripcion().split("\\|")[2]+" días");					
					Combo anioMesDiaE=dspcombos.totalExperiencia(hvCod, "E").get(0);
					parametros.put("P_TOTAL_EPRO", anioMesDiaE.getV_descripcion().split("\\|")[0]+" años, "+anioMesDiaE.getV_descripcion().split("\\|")[1]+" meses, "+anioMesDiaE.getV_descripcion().split("\\|")[2]+" días");
					if("S".equalsIgnoreCase(postulacion1Bean.getHojadevida().getV_flgdis()))
					{
						
						parametros.put("P_CERDIS", "S".equals(postulacion1Bean.getHojadevida().getV_flgcerdis())?"SI":"NO");
					}
					else
					{
						parametros.put("P_CERDIS", "NO");
					}			
					if("S".equalsIgnoreCase(postulacion1Bean.getHojadevida().getV_flglicfa()))
					{				
						parametros.put("P_CERFFAA", "S".equals(postulacion1Bean.getHojadevida().getV_flgcerlicfa())?"SI":"NO");
					}
					else
					{
						parametros.put("P_CERFFAA", "NO");
					}

					List<Map>  dummyList=new ArrayList<Map>();
					dummyList.add(parametros);
					
					FacesUtils.enviarReporteJasper(parametros,"HVReport.jasper",dummyList, mensaje, direcciones,asunto);

					
				} catch (Exception e1) {
					logger.error("Error al enviar el correo, e.getMessage()=>"+e1.getMessage());
					logger.error(e1.getMessage(),e1);
					return "pretty:registroPostulacionFin";
				}
			}
			//END ENVIO DE CORREO
			
			
			logger.info("REGISTRO EXITOSOOOOOOOOOOOO!!!!!!");
			
		}
		
		//END GUARDAR DATOS DE 3 PANTALLAS
		return "pretty:registroPostulacionFin";
	}
	
	public static String getFormatDate(Date date) {
		if(date!=null){
			return new SimpleDateFormat("dd/MM/yyyy").format(date);}
		else{
			return "";}
	}
	
	public void clearNewItemExperienciaGeneral()
	{
		entidadg="";
		puestog="";
		funcionesg="";
		fechaIg=null;
		fechaFg=null;
		tiempog="";
	}
	
	public void avisoRemoveItemExperienciaGeneral(ExperienciaLaboral delItem)
	{
		expLab_a_elim=delItem;
		RequestContext.getCurrentInstance().execute("dialogEliminarExpLabGen.show()");
	}
	
	public void removeItemExperienciaGeneral()
	{
		if(lstExperienciaGen!=null)
		{
			lstExperienciaGen.remove(expLab_a_elim);
			if(lstExperienciaGen.isEmpty())
			{
				lstExperienciaGen = new ArrayList();
			}
		}
	}
	
	public boolean validaAddItemExperienciaGeneral()
	{
		if(entidadg!=null && !"".equals(entidadg.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar una entidad o empresa.");
			return false;
		}
		if(puestog!=null && !"".equals(puestog.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar un puesto o cargo.");
			return false;
		}
		if(funcionesg!=null && !"".equals(funcionesg.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar las funciones realizadas.");
			return false;
		}
		if(fechaIg!=null){
			if(!fechaIg.before(new Date())){
				Funciones.mostrarMensajeError("La fecha de inicio no puede ser posterior a la fecha actual.");				
				return false;
			}
		}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar la fecha de inicio.");
			return false;
		}
		if(fechaFg!=null){
			if(!fechaFg.before(new Date())){
				Funciones.mostrarMensajeError("La fecha de término no puede ser posterior a la fecha actual.");				
				return false;
			}

			if(fechaFg.before(fechaIg)){
				Funciones.mostrarMensajeError("La fecha de término no puede ser anterior a la fecha de inicio.");				
				return false;
			}
		}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar la fecha de término.");
			return false;
		}
		/*if(tiempog!=null && !"".equals(tiempog.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar el tiempo en el cargo.");
			return false;
		}*/
		return true;
	}
	
	public void addItemExperienciaGeneral()
	{
		if(!validaAddItemExperienciaGeneral())
		{
			return;
		}
		CombosDespatch dspcombos = new CombosDespatch();
		if(lstExperienciaGen!=null)
		{
			ExperienciaLaboral mMap = new ExperienciaLaboral();
			mMap.setV_entidad(entidadg.toUpperCase());
			mMap.setV_puesto(puestog.toUpperCase());
			mMap.setV_funciones(funcionesg.toUpperCase());
			mMap.setD_fecini(getFormatDate(fechaIg));
			mMap.setD_fecfin(getFormatDate(fechaFg));
			try {
				Combo anioMesDia=dspcombos.restarFechas(getFormatDate(fechaIg), getFormatDate(fechaFg)).get(0);
				mMap.setN_tiempmes(anioMesDia.getV_descripcion().split("\\|")[0]+" años, "+anioMesDia.getV_descripcion().split("\\|")[1]+" meses, "+anioMesDia.getV_descripcion().split("\\|")[2]+" días");
			} catch (Exception e) {
				System.out.println("No pudo calcular la diferencia de fechas en BD, se calculará en servidor.");
				e.printStackTrace();				
				mMap.setN_tiempmes(FacesUtils.getDateDifferenceInDDMMYYYY(fechaIg, fechaFg));
			}			
			mMap.setV_flgtipexp("G");
	        lstExperienciaGen.add(mMap);	       
		}
		else
		{
			lstExperienciaGen = new ArrayList();
			
			ExperienciaLaboral mMap = new ExperienciaLaboral();
			mMap.setV_entidad(entidadg.toUpperCase());
			mMap.setV_puesto(puestog.toUpperCase());
			mMap.setV_funciones(funcionesg.toUpperCase());
			mMap.setD_fecini(getFormatDate(fechaIg));
			mMap.setD_fecfin(getFormatDate(fechaFg));
			try {
				Combo anioMesDia=dspcombos.restarFechas(getFormatDate(fechaIg), getFormatDate(fechaFg)).get(0);
				mMap.setN_tiempmes(anioMesDia.getV_descripcion().split("\\|")[0]+" años, "+anioMesDia.getV_descripcion().split("\\|")[1]+" meses, "+anioMesDia.getV_descripcion().split("\\|")[2]+" días");
			} catch (Exception e) {
				System.out.println("No pudo calcular la diferencia de fechas en BD, se calculará en servidor.");
				e.printStackTrace();				
				mMap.setN_tiempmes(FacesUtils.getDateDifferenceInDDMMYYYY(fechaIg, fechaFg));
			}
			mMap.setV_flgtipexp("G");
	        lstExperienciaGen.add(mMap);
		}
		clearNewItemExperienciaGeneral();
	}
	
	public void clearNewItemExperienciaProfesional()
	{
		entidadp="";
		puestop="";
		funcionesp="";
		fechaIp=null;
		fechaFp=null;
		tiempop="";
	}
	
	public void avisoRemoveItemExperienciaProfesional(ExperienciaLaboral delItem)
	{
		expLab_a_elim=delItem;
		RequestContext.getCurrentInstance().execute("dialogEliminarExpLabPro.show()");
	}
	
	public void removeItemExperienciaProfesional()
	{
		if(lstExperienciaPro!=null)
		{
			lstExperienciaPro.remove(expLab_a_elim);
			if(lstExperienciaPro.isEmpty())
			{
				lstExperienciaPro = new ArrayList();
			}
		}
	}
	
	
	
	public boolean validaAddItemExperienciaProfesional()
	{
		if(entidadp!=null && !"".equals(entidadp.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar una entidad o empresa.");
			return false;
		}
		if(puestop!=null && !"".equals(puestop.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar un puesto o cargo.");
			return false;
		}
		if(funcionesp!=null && !"".equals(funcionesp.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar las funciones realizadas.");
			return false;
		}
		if(fechaIp!=null){
			if(!fechaIp.before(new Date())){
				Funciones.mostrarMensajeError("La fecha de inicio no puede ser posterior a la fecha actual.");				
				return false;
			}
		}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar la fecha de inicio.");
			return false;
		}
		if(fechaFp!=null){
			if(!fechaFp.before(new Date())){
				Funciones.mostrarMensajeError("La fecha de término no puede ser posterior a la fecha actual.");				
				return false;
			}

			if(fechaFp.before(fechaIp)){
				Funciones.mostrarMensajeError("La fecha de término no puede ser anterior a la fecha de inicio.");				
				return false;
			}
		}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar la fecha de término.");
			return false;
		}
		/*if(tiempop!=null && !"".equals(tiempop.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar el tiempo en el cargo.");
			return false;
		}*/
		return true;
	}
	
	public void addItemExperienciaProfesional()
	{
		if(!validaAddItemExperienciaProfesional())
		{
			return;
		}
		CombosDespatch dspcombos = new CombosDespatch();
		if(lstExperienciaPro!=null)
		{
			ExperienciaLaboral mMap = new ExperienciaLaboral();
			mMap.setV_entidad(entidadp.toUpperCase());
			mMap.setV_puesto(puestop.toUpperCase());
			mMap.setV_funciones(funcionesp.toUpperCase());
			mMap.setD_fecini(getFormatDate(fechaIp));
			mMap.setD_fecfin(getFormatDate(fechaFp));
			try {
				Combo anioMesDia=dspcombos.restarFechas(getFormatDate(fechaIp), getFormatDate(fechaFp)).get(0);
				mMap.setN_tiempmes(anioMesDia.getV_descripcion().split("\\|")[0]+" años, "+anioMesDia.getV_descripcion().split("\\|")[1]+" meses, "+anioMesDia.getV_descripcion().split("\\|")[2]+" días");
			} catch (Exception e) {
				System.out.println("No pudo calcular la diferencia de fechas en BD, se calculará en servidor.");
				e.printStackTrace();				
				mMap.setN_tiempmes(FacesUtils.getDateDifferenceInDDMMYYYY(fechaIp, fechaFp));
			}
			mMap.setV_flgtipexp("P");
	        lstExperienciaPro.add(mMap);	       
		}
		else
		{
			lstExperienciaPro = new ArrayList();
			
			ExperienciaLaboral mMap = new ExperienciaLaboral();
			mMap.setV_entidad(entidadp.toUpperCase());
			mMap.setV_puesto(puestop.toUpperCase());
			mMap.setV_funciones(funcionesp.toUpperCase());
			mMap.setD_fecini(getFormatDate(fechaIp));
			mMap.setD_fecfin(getFormatDate(fechaFp));
			try {
				Combo anioMesDia=dspcombos.restarFechas(getFormatDate(fechaIp), getFormatDate(fechaFp)).get(0);
				mMap.setN_tiempmes(anioMesDia.getV_descripcion().split("\\|")[0]+" años, "+anioMesDia.getV_descripcion().split("\\|")[1]+" meses, "+anioMesDia.getV_descripcion().split("\\|")[2]+" días");
			} catch (Exception e) {
				System.out.println("No pudo calcular la diferencia de fechas en BD, se calculará en servidor.");
				e.printStackTrace();				
				mMap.setN_tiempmes(FacesUtils.getDateDifferenceInDDMMYYYY(fechaIp, fechaFp));
			}
			mMap.setV_flgtipexp("P");
	        lstExperienciaPro.add(mMap);
		}
		clearNewItemExperienciaProfesional();
	}
	
	public void clearNewItemReferencia()
	{
		entidadr="";
		nombrerefr="";
		puestor="";
		telefonor="";
	}
	
	
	public void avisoRemoveItemReferencia(ReferenciasLaborales delItem)
	{
		refLab_a_elim=delItem;
		RequestContext.getCurrentInstance().execute("dialogEliminarRefLab.show()");
	}
	
	public void removeItemReferencia()
	{
		if(lstReferencia!=null)
		{
			lstReferencia.remove(refLab_a_elim);
			if(lstReferencia.isEmpty())
			{
				lstReferencia = new ArrayList();
			}
		}
	}
	
	public boolean validaAddItemReferencia()
	{
		if(entidadr!=null && !"".equals(entidadr.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar una entidad o empresa.");
			return false;
		}
		if(nombrerefr!=null && !"".equals(nombrerefr.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar el nombre de referente.");
			return false;
		}
		if(puestor!=null && !"".equals(puestor.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar el puesto o cargo del referente.");
			return false;
		}
		if(telefonor!=null && !"".equals(telefonor.trim())){}
		else
		{
			Funciones.mostrarMensajeError("Debe ingresar el teléfono.");
			return false;
		}
		return true;
	}
	
	public void addItemReferencia()
	{
		if(!validaAddItemReferencia())
		{
			return;
		}
		if(lstReferencia!=null)
		{
			ReferenciasLaborales mMap = new ReferenciasLaborales();
			mMap.setV_entidad(entidadr.toUpperCase());
			mMap.setV_nomref(nombrerefr.toUpperCase());
			mMap.setV_cargo(puestor.toUpperCase());
			mMap.setV_telefono(telefonor);
			lstReferencia.add(mMap);	       
		}
		else
		{
			lstReferencia = new ArrayList();
			
			ReferenciasLaborales mMap = new ReferenciasLaborales();
			mMap.setV_entidad(entidadr.toUpperCase());
			mMap.setV_nomref(nombrerefr.toUpperCase());
			mMap.setV_cargo(puestor.toUpperCase());
			mMap.setV_telefono(telefonor);
			lstReferencia.add(mMap);
		}
		clearNewItemReferencia();
	}
	
	public String getSiguienteCorrelativoExperiencia()
	{
		ThirdScreenDespatch thirdScreenDespatch=new ThirdScreenDespatch();
		try {
			RhmvcExperiencia correlativo=thirdScreenDespatch.getCorrelativoExperiencia();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCorexp().add(new BigDecimal(1)));
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
	
	public String getSiguienteCorrelativoReferencia()
	{
		ThirdScreenDespatch thirdScreenDespatch=new ThirdScreenDespatch();
		try {
			RhmvcReferencia correlativo=thirdScreenDespatch.getCorrelativoReferencia();
			if(correlativo!=null)
			{
				return ""+(correlativo.getnCorref().add(new BigDecimal(1)));
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
	
	
	public String datos2Postulaciones(){
		return "pretty:registroPostulacion2";
	}
	
	public String formatEmail()
	{
		String body="";
		CombosDespatch dspcombos = new CombosDespatch();
		try {
			Combo convocatoria=dspcombos.convocatoriaByCod(postulacion1Bean.getHojadevida().getN_corconv()).get(0);		
			Combo solDep=dspcombos.departamentoByCod(postulacion1Bean.getPersona().getV_coddepnac()).get(0);
			Combo solPro=dspcombos.provinciaByCod(postulacion1Bean.getPersona().getV_coddepnac(), postulacion1Bean.getPersona().getV_codpronac()).get(0);
			Combo solDis=dspcombos.distritoByCod(postulacion1Bean.getPersona().getV_coddepnac(), postulacion1Bean.getPersona().getV_codpronac(), postulacion1Bean.getPersona().getV_coddisnac()).get(0);
			Combo estadoCivil=dspcombos.estadoCivilByCod(postulacion1Bean.getHojadevida().getV_codestciv()).get(0);
			Combo solDepDir=dspcombos.departamentoByCod(postulacion1Bean.getHojadevida().getV_coddepdom()).get(0);
			Combo solProDir=dspcombos.provinciaByCod(postulacion1Bean.getHojadevida().getV_coddepdom(), postulacion1Bean.getHojadevida().getV_codprodom()).get(0);
			Combo solDisDir=dspcombos.distritoByCod(postulacion1Bean.getHojadevida().getV_coddepdom(), postulacion1Bean.getHojadevida().getV_codprodom(), postulacion1Bean.getHojadevida().getV_coddisdom()).get(0);
			body="Estimado Postulante, <br/><br/>Su hoja de vida ha sido enviada de manera satisfactoria.<br/><br/>"
					+ "<style type=\"text/css\">\n" +
					".tg  {border-collapse:collapse;border-spacing:0;}\n" +
					".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;}\n" +
					".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;}\n" +
					".tg .tg-yw4l{vertical-align:top}\n" +
					"</style>\n" +
					"<table class=\"tg\">\n" +
					"<tr>\n" +
					"    <th class=\"tg-yw4l\" colspan=\"2\" style=\"vertical-align:middle;\"><img alt=\"\" height=\"40px\" src=\"http://www.sunafil.gob.pe/portal/images/Logo-Sunafil-Final.png\"></th>\n" +
					"    <th class=\"tg-yw4l\" colspan=\"2\" style=\"vertical-align:middle;\">FORMATO DE HOJA DE VIDA</th>\n" +//N&#176; "+hvCod+"
					"  </tr>"+
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\" style=\"color:white;background-color:#666666\"><center>CONVOCATORIA "+convocatoria.getV_descripcion()+"<BR/>PUESTO "+postulacion1Bean.getHojadevida().getV_desconv().toUpperCase()+"</center></td>\n" +
					"  </tr>\n" +
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">Entidad:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">Superintendencia Nacional de Fiscalizaci&oacute;n Laboral</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">NOMBRES Y APELLIDOS:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+postulacion1Bean.getPersona().getV_nombres().toUpperCase()+" "+postulacion1Bean.getPersona().getV_apepat().toUpperCase()+" "+postulacion1Bean.getPersona().getV_apemat().toUpperCase()+"</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">LUGAR Y FECHA DE NACIMIENTO:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+solDis.getV_descripcion().toUpperCase()+"/"+solPro.getV_descripcion().toUpperCase()+"/"+solDis.getV_descripcion().toUpperCase()+" "+getFormatDate(postulacion1Bean.getPersona().getD_fecnac())+"</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">NACIONALIDAD:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+postulacion1Bean.getHojadevida().getV_nacionalidad().toUpperCase()+"</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">ESTADO CIVIL:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+estadoCivil.getV_descripcion().toUpperCase()+"</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">DOCUMENTO DE IDENTIDAD:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+postulacion1Bean.getPersona().getV_numdoc().toUpperCase()+"</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">DIRECCION ACTUAL:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+postulacion1Bean.getHojadevida().getV_direccion().toUpperCase()+"<BR/>"+postulacion1Bean.getHojadevida().getV_urbanizac().toUpperCase()+"<BR/>"+solDisDir.getV_descripcion().toUpperCase()+"/"+solProDir.getV_descripcion().toUpperCase()+"/"+solDisDir.getV_descripcion().toUpperCase()+"</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">TELEFONO:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+postulacion1Bean.getHojadevida().getV_telfij()+"</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">CELULAR:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+postulacion1Bean.getHojadevida().getV_telcel()+"</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">COLEGIATURA:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+postulacion1Bean.getHojadevida().getV_descolegio().toUpperCase()+" "+postulacion1Bean.getHojadevida().getV_numregcol().toUpperCase()+"</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">PERSONA CON DISCAPACIDAD:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+("S".equals(postulacion1Bean.getHojadevida().getV_flgdis())?"SI":"NO")+"</td>\n" +
					"  </tr>\n" +
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\">LICENCIADO DE LAS FF. AA.:</td>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"3\">"+("S".equals(postulacion1Bean.getHojadevida().getV_flglicfa())?"SI":"NO")+"</td>\n" +
					"  </tr>\n" +
					
					/*"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\"> "+
				    		getTablaFormacion()+
					"    </td>" +
					"  </tr>\n" +*/
					
					"  <tr>\n" +
					"    <td class=\"tg-yw4l\" colspan=\"4\" style=\"color:white;background-color:#666666\"> Su postulación ha sido enviada de manera satisfactoria. </td>" +
					"  </tr>\n" +
					"</table>\n";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return body;
	}
	
	public String getTablaFormacion()
	{
		String tabla="<table class=\"tg\" border=\"1px\">\n" +
				"  <tr>\n" +
				"    <th class=\"tg-s6z2\">NIVEL</th>\n" +
				"    <th class=\"tg-031e\">GRADO ACADÉMICO</th>\n" +
				"    <th class=\"tg-031e\">CENTRO DE ESTUDIOS</th>\n" +
				"    <th class=\"tg-031e\">ESPECIALIDAD</th>\n" +
				"    <th class=\"tg-yw4l\">FECHA DE INICIO</th>\n" +
				"    <th class=\"tg-yw4l\">FECHA DE EGRESO</th>\n" +
				"    <th class=\"tg-yw4l\">FECHA DE EXTENSIÓN DE DIPLOMA</th>\n" +
				"    <th class=\"tg-yw4l\">CIUDAD/PAIS</th>\n" +
				"  </tr>\n";
		for (Iterator iterator = postulacion2Bean.getLstFormacion().iterator(); iterator
				.hasNext();) {
			Map row = (Map) iterator
					.next();
			tabla=tabla+"  <tr>\n" +
						"    <td class=\"tg-s6z2\">"+row.get("nivelDes").toString()+"</td>\n" +
						"    <td class=\"tg-031e\">"+row.get("gradoDes").toString()+"</td>\n" +
						"    <td class=\"tg-031e\">"+row.get("centro").toString()+"</td>\n" +
						"    <td class=\"tg-031e\">"+row.get("especialidad").toString()+"</td>\n" +
						"    <td class=\"tg-yw4l\">"+row.get("fi").toString()+"</td>\n" +
						"    <td class=\"tg-yw4l\">"+row.get("fe").toString()+"</td>\n" +
						"    <td class=\"tg-yw4l\">"+row.get("fex").toString()+"</td>\n" +
						"    <td class=\"tg-yw4l\">"+row.get("ciudad").toString()+" "+row.get("pais").toString()+"</td>\n" +
						"  </tr>\n";
		}
		return tabla+"</table>";
	}
	
	//public String getTablaFormacion(){}
	
	public void imprimirConfirmacion() 
    {
		CombosDespatch dspcombos = new CombosDespatch();
		try {			
			Map parametros = new HashMap();
			Combo convocatoria=dspcombos.convocatoriaByCod(postulacion1Bean.getHojadevida().getN_corconv()).get(0);
			parametros.put("P_CONVOCATORIA", convocatoria.getV_descripcion());//
			parametros.put("P_PUESTO", ""+postulacion1Bean.getHojadevida().getV_desconv().toUpperCase());//			
			parametros.put("P_NOMBRE", postulacion1Bean.getPersona().getV_nombres().toUpperCase()+" "+postulacion1Bean.getPersona().getV_apepat().toUpperCase()+" "+postulacion1Bean.getPersona().getV_apemat().toUpperCase());//
			Combo solDep=dspcombos.departamentoByCod(postulacion1Bean.getPersona().getV_coddepnac()).get(0);
			Combo solPro=dspcombos.provinciaByCod(postulacion1Bean.getPersona().getV_coddepnac(), postulacion1Bean.getPersona().getV_codpronac()).get(0);
			Combo solDis=dspcombos.distritoByCod(postulacion1Bean.getPersona().getV_coddepnac(), postulacion1Bean.getPersona().getV_codpronac(), postulacion1Bean.getPersona().getV_coddisnac()).get(0);
			parametros.put("P_DESDISNAC", solDis.getV_descripcion().toUpperCase());//
			parametros.put("P_DESPRONAC", solPro.getV_descripcion().toUpperCase());//
			parametros.put("P_DESDEPNAC", solDep.getV_descripcion().toUpperCase());
			parametros.put("P_FECNAC", getFormatDate(postulacion1Bean.getPersona().getD_fecnac()));
			parametros.put("P_NACIONALI", postulacion1Bean.getHojadevida().getV_nacionalidad().toUpperCase());
			Combo estadoCivil=dspcombos.estadoCivilByCod(postulacion1Bean.getHojadevida().getV_codestciv()).get(0);
			parametros.put("P_DESESTCIV", estadoCivil.getV_descripcion().toUpperCase());
			parametros.put("P_NUMDOC", postulacion1Bean.getPersona().getV_numdoc().toUpperCase());
			parametros.put("P_DIRECCION", postulacion1Bean.getHojadevida().getV_direccion().toUpperCase());
			parametros.put("P_URBANIZAC", postulacion1Bean.getHojadevida().getV_urbanizac().toUpperCase());			
			Combo solDepDir=dspcombos.departamentoByCod(postulacion1Bean.getHojadevida().getV_coddepdom()).get(0);
			Combo solProDir=dspcombos.provinciaByCod(postulacion1Bean.getHojadevida().getV_coddepdom(), postulacion1Bean.getHojadevida().getV_codprodom()).get(0);
			Combo solDisDir=dspcombos.distritoByCod(postulacion1Bean.getHojadevida().getV_coddepdom(), postulacion1Bean.getHojadevida().getV_codprodom(), postulacion1Bean.getHojadevida().getV_coddisdom()).get(0);						
			parametros.put("P_DESDIS", solDisDir.getV_descripcion().toUpperCase());
			parametros.put("P_DESPRO", solProDir.getV_descripcion().toUpperCase());
			parametros.put("P_DESDEP", solDepDir.getV_descripcion().toUpperCase());
			parametros.put("P_TELFIJ", postulacion1Bean.getHojadevida().getV_telfij());
			parametros.put("P_TELCEL", postulacion1Bean.getHojadevida().getV_telcel());
			parametros.put("P_DESCOLEGIO", postulacion1Bean.getHojadevida().getV_descolegio().toUpperCase());
			parametros.put("P_NUMREGCOL", postulacion1Bean.getHojadevida().getV_numregcol().toUpperCase());
			parametros.put("P_FLGDIS", "S".equals(postulacion1Bean.getHojadevida().getV_flgdis())?"SI":"NO");
			parametros.put("P_FLGFFAA", "S".equals(postulacion1Bean.getHojadevida().getV_flglicfa())?"SI":"NO");
			
			parametros.put("P_LST_FORMACION", postulacion2Bean.getLstFormacion());
			parametros.put("P_LST_CAPACITACION", postulacion2Bean.getLstCapacitacion());
			parametros.put("P_LST_OTROS", postulacion2Bean.getLstOtrosDoc());
			//parametros.put("P_LST_OTROS", postulacion2Bean.getLstOtrosDoc());
			parametros.put("P_LST_EXP_GEN", lstExperienciaGen);
			parametros.put("P_LST_EXP_PRO", lstExperienciaPro);
			parametros.put("P_LST_REFERENCIA", lstReferencia);
			
			parametros.put("P_FECHA_ACTUAL", "Lima, "+getFormatDate(new Date()).split("/")[0]+" de "+getFormatMes(Integer.parseInt(getFormatDate(new Date()).split("/")[1]))+" del "+getFormatDate(new Date()).split("/")[2]);
			
			Combo anioMesDiaG=dspcombos.totalExperiencia(hvCod, "G").get(0);
			parametros.put("P_TOTAL_EGEN", anioMesDiaG.getV_descripcion().split("\\|")[0]+" años, "+anioMesDiaG.getV_descripcion().split("\\|")[1]+" meses, "+anioMesDiaG.getV_descripcion().split("\\|")[2]+" días");
			
			Combo anioMesDiaE=dspcombos.totalExperiencia(hvCod, "E").get(0);
			parametros.put("P_TOTAL_EPRO", anioMesDiaE.getV_descripcion().split("\\|")[0]+" años, "+anioMesDiaE.getV_descripcion().split("\\|")[1]+" meses, "+anioMesDiaE.getV_descripcion().split("\\|")[2]+" días");
			
			if("S".equalsIgnoreCase(postulacion1Bean.getHojadevida().getV_flgdis()))
			{
				
				parametros.put("P_CERDIS", "S".equals(postulacion1Bean.getHojadevida().getV_flgcerdis())?"SI":"NO");
			}
			else
			{
				parametros.put("P_CERDIS", "NO");
			}			
			if("S".equalsIgnoreCase(postulacion1Bean.getHojadevida().getV_flglicfa()))
			{				
				parametros.put("P_CERFFAA", "S".equals(postulacion1Bean.getHojadevida().getV_flgcerlicfa())?"SI":"NO");
			}
			else
			{
				parametros.put("P_CERFFAA", "NO");
			}

			List<Map>  dummyList=new ArrayList<Map>();
			dummyList.add(parametros);
			FacesUtils.mostrarReporteJasper(parametros, "HVReport.jasper", dummyList, "ConstanciaDePostulacion");
			System.out.println("Muestra reporte");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	
	public static String getFormatMes(int mes) {
		if(mes!=0){
			switch (mes) {
			case 1:
				return "ENERO";
			case 2:
				return "FEBRERO";
			case 3:
				return "MARZO";
			case 4:
				return "ABRIL";
			case 5:
				return "MAYO";
			case 6:
				return "JUNIO";
			case 7:
				return "JULIO";
			case 8:
				return "AGOSTO";
			case 9:
				return "SETIEMBRE";
			case 10:
				return "OCTUBRE";
			case 11:
				return "NOVIEMBRE";
			case 12:
				return "DICIEMBRE";
			default:
				break;
			}
			return "";
			}
		else{
			return "";}
	}
	
}
