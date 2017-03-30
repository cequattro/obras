package pe.gob.mtpe.retorno.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pe.gob.mtpe.retorno.bean.Pregfrec;
import pe.gob.mtpe.retorno.service.PreguntaFrecuentesService;

@Controller
@Scope("session")
public class PreguntaFrecuentesBean implements Serializable {

	@Autowired
	private PreguntaFrecuentesService preguntaFrecuentesService;

	private Pregfrec pregfrec;
	private List<Pregfrec> lstPregFrec;

	public PreguntaFrecuentesBean() {
		inicializarObjetos();

	}

	private void inicializarObjetos() {
		pregfrec = new Pregfrec();
		lstPregFrec = new ArrayList<Pregfrec>();

	}

	@PostConstruct
	public void inicializarListas() throws Exception {
		lstPregFrec = preguntaFrecuentesService.listarPreguntas();

	}

	public void limpiarPregunta() throws Exception {
		pregfrec = new Pregfrec();
	}

	public void eliminarPregunta() throws Exception {
		pregfrec.setvEstreg("E");
		preguntaFrecuentesService.eliminarPregunta(pregfrec);
		lstPregFrec = preguntaFrecuentesService.listarPreguntas();

	}

	public void modificarPregunta() throws Exception {
		preguntaFrecuentesService.actualizarPregunta(pregfrec);
		lstPregFrec = preguntaFrecuentesService.listarPreguntas();
	}

	public void grabarPregunta() throws Exception {
		pregfrec.setvEstreg("A");
		preguntaFrecuentesService.insertarPreguntaFrecuente(pregfrec);
		lstPregFrec = preguntaFrecuentesService.listarPreguntas();
	}

	public Pregfrec getPregfrec() {
		return pregfrec;
	}

	public void setPregfrec(Pregfrec pregfrec) {
		this.pregfrec = pregfrec;
	}

	public List<Pregfrec> getLstPregFrec() {
		return lstPregFrec;
	}

	public void setLstPregFrec(List<Pregfrec> lstPregFrec) {
		this.lstPregFrec = lstPregFrec;
	}

}
