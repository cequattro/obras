package pe.gob.mtpe.retorno.managedBeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Mensaje;
import pe.gob.mtpe.retorno.bean.Persona;
import pe.gob.mtpe.retorno.service.MensajeService;
import pe.gob.mtpe.retorno.service.PersonaService;

@Controller
@Scope("session")
public class PreguntaBean {
	
	final static Logger logger=Logger.getLogger(PreguntaBean.class);

	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private MensajeService mensajeService;
	
	private Persona persona;	
	private Mensaje mensaje;
	private List<Map> lstPreguntasUsu;

	public PreguntaBean() {
		inicializarObjetos();

	}

	private void inicializarObjetos() {
		persona = new Persona();
		mensaje=new Mensaje();
		lstPreguntasUsu=new ArrayList<Map>();
	}
	
	

	public String redPreguntas() {
		String vista = "";
		try {
			DPersona dpersona=new DPersona();
			dpersona.setvCodtdocide(persona.getvCodtdocide());
			dpersona.setvNumdoc(persona.getvNumdoc());				
			persona=personaService.buscarPersona(dpersona);			
			mensaje.setvCodtdocide(persona.getvCodtdocide());
			mensaje.setvNumdoc(persona.getvNumdoc());			
			listarPreguntasUsuario();
			vista = "pretty:pregunta";			
		} catch (Exception e) {
			logger.error(e);
		}
		return vista;

	}
	
	public void enviarPregunta(){
		try {
			mensaje.setvCodtdocide(persona.getvCodtdocide());
			mensaje.setvNumdoc(persona.getvNumdoc());
			mensaje.setvEstreg("S");
			mensajeService.insertarMensaje(mensaje);
			listarPreguntasUsuario();
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	public void listarPreguntasUsuario(){
		try {			
			lstPreguntasUsu=mensajeService.listaPreguntas(persona);			
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	
	public void nuevaPregunta(){
		mensaje=new Mensaje();
	}
	

	/**
	 * GET SET	
	 */

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public List<Map> getLstPreguntasUsu() {
		return lstPreguntasUsu;
	}

	public void setLstPreguntasUsu(List<Map> lstPreguntasUsu) {
		this.lstPreguntasUsu = lstPreguntasUsu;
	}
	
	
	

	
}
