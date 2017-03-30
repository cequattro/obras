package pe.gob.sunafil.gentrama.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gentrama.bean.Combo;
import pe.gob.sunafil.gentrama.bean.ParamConsultaSIIT;
import pe.gob.sunafil.gentrama.funciones.Funciones;
import pe.gob.sunafil.gentrama.mybatis.despachadores.ConsultaSIITDespatch;
import pe.gob.sunafil.gentrama.mybatis.despachadores.IntendenciasDespatch;
import pe.gob.sunafil.gentrama.utils.FacesUtils;
import pe.gob.sunafil.gentrama.utils.Utilitarios;

@ManagedBean(name="consultaBean")
@SessionScoped
public class ConsultaSIITBean  implements Serializable {
	
	private static final long serialVersionUID = -8745562991511314917L;

	private static Logger logger = Logger.getLogger(ConsultaSIITBean.class.getName());
	
	private ParamConsultaSIIT parametros;
	
	private List<Combo> lstIntendencias;
	private List<Combo> lstAnhos;
	@SuppressWarnings("rawtypes")
	private List<Map>  lstResultadoConsultaSIIT;
	@SuppressWarnings("rawtypes")
	private List<Map>  lstMaterias;
	@SuppressWarnings("rawtypes")
	private List<Map>  lstEtapaSancionadora;
	
	private IntendenciasDespatch despachadorIntendencias= new IntendenciasDespatch();
	private ConsultaSIITDespatch despachadorConsultaSIIT = new ConsultaSIITDespatch();
	
	//PARA EL CAPTCHA:
	private String cadenaCaptcha;
	private String codigoCaptchaValidar;
	
	//RUTA UBICACION DE LA GUIA DE USUARIO
	private String destination= Funciones.ObtProp_Resources("ubicacion.guia");
	
	/**
	 * Constructor
	 */
	public ConsultaSIITBean() {
		inicializar();
	}
	
	/**
	 * Metodo para inicializar los valores
	 */
	@SuppressWarnings("rawtypes")
	public void inicializar(){
		
		logger.info("ENTRA A INICIALIZAR");
		parametros=new ParamConsultaSIIT();
		lstIntendencias= new ArrayList<Combo>();
		try {
			logger.info("Obtenemos la lista de Intendencias");
			lstIntendencias=despachadorIntendencias.listaIntendencias(); 
			logger.info("Obtenemos la lista de años");
			lstAnhos=despachadorConsultaSIIT.listaAnhos(); 
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
		lstResultadoConsultaSIIT= new ArrayList<Map>(); 
		lstMaterias = new ArrayList<Map>();
		lstEtapaSancionadora = new ArrayList<Map>();
		cadenaCaptcha = Utilitarios.cadenaAleatoria().toUpperCase();
		codigoCaptchaValidar="";
	}
	
	
	/**
	 * Metodo que es utilizado para validar los datos ingresados para buscar
	 * @param param ParamConsultaSIIT
	 * @return String mensaje
	 */
	public String mensajesValidacion(ParamConsultaSIIT param){
		String codIntendencia=param.getV_codIntendencia();
		String nroRegMP=param.getNroRegMP();
		String anioRegMP=param.getAnioRegMP().toString();
		
		String mensajes=null;
		if(codIntendencia.equals("-1")){
			mensajes=Funciones.ObtProp_Resources("bsq.emptyIntendencia");
		}else if(nroRegMP.trim().equals("")){
			mensajes=Funciones.ObtProp_Resources("bsq.emptyNroRegMP");
		}else if(anioRegMP.trim().equals("")){
			mensajes=Funciones.ObtProp_Resources("bsq.emptyAnioRegMP");
		}else if(codigoCaptchaValidar.trim().equals("")){
			mensajes=Funciones.ObtProp_Resources("bsq.emptyCodigoCaptcha");
		}else
        //**********************************************************
  		//VALIDANDO CAPTCHA TEXTO U.u
        //**********************************************************
        if(!codigoCaptchaValidar.equalsIgnoreCase(cadenaCaptcha)){
        	mensajes=Funciones.ObtProp_Resources("bsq.codigoCaptchaError");
        }
        //**********************************************************
		
		System.out.println("Salio en mensajes=>"+mensajes);
		return mensajes;
	}
	
	
	/**
	 * Método con el que se consulta a la Base de Datos por una denuncia.
	 */
	public void realizarConsulta(){
		
		logger.info("ENTRA A REALIZAR CONSULTA-RICHIIIIIIINN");
		logger.info("parametros.getV_codIntendencia() "+ parametros.getV_codIntendencia());
		logger.info("parametros.getNroRegMP() "+ parametros.getNroRegMP());
		logger.info("parametros.getAnioRegMP() "+ parametros.getAnioRegMP());
		
		try {
			
			String mensaje=null;
			mensaje=mensajesValidacion(parametros);
			if(mensaje==null){
				logger.info("mensajes null entonces consultamos a la BD");
				//************************************************************************
				//1RO CONSULTAMOS SI EXISTE EL REG.MP(ILM-INSSI) O ES ANTIGUO(ILM-INSSI)
				//    SI ES REGIONAL NO SE DEVOLVERA NADA ASI QUE PASA HASTA EL ELSE FINAL
				//************************************************************************
				String resultVerif = despachadorConsultaSIIT.verificarRMP(parametros);
				if(resultVerif.equalsIgnoreCase("RMP_ANTIGUO")){
					FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("bsq.AntiguoRMP"),4);
				}else if(resultVerif.equalsIgnoreCase("NO_EXISTE")){
					FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("bsq.NoExisteRMP"),4);
				}else{
					
					//********************************************************
					//2DO CONSULTAMOS EL ESTADO DE LA SOLICITUD
					//********************************************************
					lstResultadoConsultaSIIT=despachadorConsultaSIIT.obtListaConsultaSIIT(parametros);
					System.out.println("***********size=>"+lstResultadoConsultaSIIT.size());
					
					if(lstResultadoConsultaSIIT.size()==0){
						FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("bsq.NoDataRegiones"),4);
					}
				}
				refrescarCaptcha();
			}else{
				FacesUtils.showFacesMessage(mensaje, 1);				
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	
	/**
	 * Muestra las materias asignadas a una orden de inspeccion en especifico
	 */
	public void mostrarMaterias(){
		
		logger.info("ENTRA A MOSTRAR LAS MATERIAS!!");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		String numorden = params.get("numorden");
		String anioorden = params.get("anioorden");
		String numdeporden = params.get("numdeporden");
		logger.info("Parametros Obtenidos=>"+numorden+"-"+anioorden+"-"+numdeporden);
		try {
			//OBTENEMOS LAS MATERIAS ASIGNADAS A LA ORDEN:
			lstMaterias=despachadorConsultaSIIT.obtMateriasAsigXOI(numorden,anioorden,numdeporden);
			logger.info("Cantiad de Materias encontadas:"+lstMaterias.size());
			if(lstMaterias.size()==0){
				FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("dlg.mat.NoData"),4);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	
	/**
	 * Metodo que muestra la etapa sancionadora, apartir del Acta de Infracción hasta la RS de 2da Instancia
	 * por una orden de inspeccion en especifico
	 */
	public void mostrarEtapaSancioandora(){
		
		logger.info("ENTRA A MOSTRAR LA ETAPA SANCIONADORA!!");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		String numorden = params.get("numorden");
		String anioorden = params.get("anioorden");
		String numdeporden = params.get("numdeporden");
		logger.info("Parametros Obtenidos nroOrden-anio-numdep=>"+numorden+"-"+anioorden+"-"+numdeporden);
		try {
			
			//OBTENEMOS LA LISTA DE NUMEROS DE ACTAS, EXP SANC, RS1RA, RS2DA INSTANCIA:
			lstEtapaSancionadora=despachadorConsultaSIIT.obtListaEtapaSancionadora(numorden,anioorden,numdeporden);
			if(lstMaterias.size()==0){
				FacesUtils.showFacesMessage(Funciones.ObtProp_Resources("dlg.mat.NoData"),4);
			}
			
			
		} catch (Exception e) {
			logger.info(e.getMessage(),e);
		}
	}
	
	
	/**
	 * Metodo para refrescar el código captcha
	 */
	public void refrescarCaptcha(){
		cadenaCaptcha = Utilitarios.cadenaAleatoria().toUpperCase();
	}
	
	
	/**
	 * Metodo Utilizado para cerrar sesion en el Sistema.
	 * @return
	 */
	public String salir(){
		logger.info("Terminando la Sesion");
		Utilitarios.terminarSesion();
		return "pretty:salir";
	}	
	
	/**
	 * Metodo que muestra el PDF en otra pestaña del navegador.
	 * @throws Exception
	 */
	public void mostrarGuiaUsuario() throws Exception{
		FacesUtils.mostrarPDF(destination, "MANUAL_O_GUIA_DEL_USUARIO.pdf");
	}
	
	//***************************************************
	//ZONA DE GETTERS AND SETTERS
	//***************************************************
	public ParamConsultaSIIT getParametros() {
		return parametros;
	}

	public void setParametros(ParamConsultaSIIT parametros) {
		this.parametros = parametros;
	}

	public List<Combo> getLstIntendencias() {
		return lstIntendencias;
	}

	public void setLstIntendencias(List<Combo> lstIntendencias) {
		this.lstIntendencias = lstIntendencias;
	}

	public List<Map> getLstResultadoConsultaSIIT() {
		return lstResultadoConsultaSIIT;
	}

	public void setLstResultadoConsultaSIIT(List<Map> lstResultadoConsultaSIIT) {
		this.lstResultadoConsultaSIIT = lstResultadoConsultaSIIT;
	}

	public List<Map> getLstMaterias() {
		return lstMaterias;
	}

	public void setLstMaterias(List<Map> lstMaterias) {
		this.lstMaterias = lstMaterias;
	}

	public List<Map> getLstEtapaSancionadora() {
		return lstEtapaSancionadora;
	}

	public void setLstEtapaSancionadora(List<Map> lstEtapaSancionadora) {
		this.lstEtapaSancionadora = lstEtapaSancionadora;
	}
	
	public String getCadenaCaptcha() {
		return cadenaCaptcha;
	}

	public void setCadenaCaptcha(String cadenaCaptcha) {
		this.cadenaCaptcha = cadenaCaptcha;
	}

	public String getCodigoCaptchaValidar() {
		return codigoCaptchaValidar;
	}

	public void setCodigoCaptchaValidar(String codigoCaptchaValidar) {
		this.codigoCaptchaValidar = codigoCaptchaValidar;
	}

	public List<Combo> getLstAnhos() {
		return lstAnhos;
	}

	public void setLstAnhos(List<Combo> lstAnhos) {
		this.lstAnhos = lstAnhos;
	}

}
