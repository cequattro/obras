package pe.gob.sunafil.denunciavirtual.managedBeans;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import pe.gob.sunafil.denunciavirtual.mybatis.despachadores.EmpleadorDespatch;
import pe.gob.sunafil.denunciavirtual.mybatis.despachadores.LevantamientoDespatch;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltmvRegistroentrada;
import pe.gob.sunafil.denunciavirtual.utils.FacesUtils;
import pe.gob.sunafil.denunciavirtual.utils.cryptoManager;

@ManagedBean(name="levantamientoBean")
@SessionScoped
public class LevantamientoBean {
	
	private static Logger logger = Logger.getLogger(LevantamientoBean.class.getName());
	
	private String nombre;
	private String s_fecha;
	private String v_param;
	private String n_codsol;
	private boolean mostrar_datos;
		
	public String getS_fecha() {
		return s_fecha;
	}

	public void setS_fecha(String s_fecha) {
		this.s_fecha = s_fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getV_param() {
		return v_param;
	}

	public void setV_param(String v_param) {
		this.v_param = v_param;
	}

	public String getN_codsol() {
		return n_codsol;
	}

	public void setN_codsol(String n_codsol) {
		this.n_codsol = n_codsol;
	}

	public boolean isMostrar_datos() {
		return mostrar_datos;
	}

	public void setMostrar_datos(boolean mostrar_datos) {
		this.mostrar_datos = mostrar_datos;
	}

	public LevantamientoBean()
	{
		s_fecha=new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(new Date());
	}

	public String cargaLevantamientoRI() {
		System.out.println("ENTRANDO A CARGA LEVANTAMIENTO RI");
		mostrar_datos=true;
		if ( v_param != null ) {
			
			String v_desencrip ="";
			
			try {
				System.out.println("decrypting :: "+v_param);
				v_desencrip =  cryptoManager.decrypt(v_param.replace(' ', '+'));
			} catch (Exception e) {
				mostrar_datos=false;
				FacesUtils.showFacesMessage("Existen Inconvenientes al obtener los datos de la denuncia debido al link accedido, por favor comunicarse con sistemas.", 1);
				logger.error(e.getMessage(),e);
			}
			System.out.println("Result decrypt=>"+v_desencrip);
			this.n_codsol = v_desencrip;
			try{			
				LevantamientoDespatch levDsp = new LevantamientoDespatch();
				nombre =levDsp.obtieneNombresTrabajador(n_codsol);
			}catch(Exception e){
				mostrar_datos=false;
				FacesUtils.showFacesMessage("Existen Inconvenientes al obtener los datos de la denuncia, por favor comunicarse con sistemas.", 1);
				logger.error(e.getMessage(),e);
			}
			return null;//DEVOLVEMOS A LA PAG CONFIG EN EL URL-MAPPING DE PRETTY
		}else{
			FacesUtils.showFacesMessage("Existen Inconvenientes al obtener los datos de la denuncia(NP), por favor comunicarse con sistemas.", 1);
			System.out.println("no se envió el v_param");
		}

		// Add a message here, "The n_codsol {..} could not be found."
		return null;//SERIA UNA PAGINA DE ERROR
	}
	
	
	public String datosConfirmacion(){
		LevantamientoDespatch levD=new LevantamientoDespatch();
		String vista="pretty:levantaConfirmacion";
		IltmvRegistroentrada entidad=new IltmvRegistroentrada();
		entidad.setvFlglevri("S");
		entidad.setvFlgreside("N");
		try {
			levD.actualizarRegistroEntradaSIIT(entidad, new BigDecimal(n_codsol));
		} catch (Exception e) {
			e.printStackTrace();
		}
        //CODIGO
        return  vista;
	}
	
	public String desencripta(String value)
	{
		try {
			System.out.println("decrypting :: "+value);
			return cryptoManager.decrypt(value.replace(' ', '+'));
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	//para usar en pretty config pero no sale <action>#{levantamientoBean.VerifyOnLoad(levantamientoBean.nombre)}</action>
	public String VerifyOnLoad(String value)
	{
		try {
			System.out.println("decrypting on load :: "+value);
			cryptoManager.decrypt(value.replace(' ', '+'));
			return "pretty:levantaReserva";
		} catch (Exception e) {
			e.printStackTrace();
			return "pretty:levantaException";
		}
	}

}
