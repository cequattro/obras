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
@Scope("request")
public class PreguntaFrecBean implements Serializable{
	
	@Autowired
	private PreguntaFrecuentesService preguntaFrecuentesService;
	
	
	 
	private List<Pregfrec> lstPregFrec;
	
	public PreguntaFrecBean(){
		inicializarObjetos();
		
	}
	
	private void inicializarObjetos(){
		lstPregFrec=new ArrayList<Pregfrec>();
		
	}
	
	@PostConstruct 
	public void inicializarListas() throws Exception{
		lstPregFrec=preguntaFrecuentesService.listarPreguntas();		
		 
	}
	
	public String regresarFormRetorno(){
		return "pretty:fichaRetorno";
	}

	public List<Pregfrec> getLstPregFrec() {
		return lstPregFrec;
	}

	public void setLstPregFrec(List<Pregfrec> lstPregFrec) {
		this.lstPregFrec = lstPregFrec;
	}
	
	
	
	

}
