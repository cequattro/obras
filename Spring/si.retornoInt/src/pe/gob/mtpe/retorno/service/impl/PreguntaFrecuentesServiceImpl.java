package pe.gob.mtpe.retorno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mtpe.retorno.bean.Pregfrec;
import pe.gob.mtpe.retorno.dao.PreguntaFrecuentesDao;
import pe.gob.mtpe.retorno.service.PreguntaFrecuentesService;


@Service("preguntaFrecuentesService")
public class PreguntaFrecuentesServiceImpl implements PreguntaFrecuentesService {
	
	@Autowired
	private PreguntaFrecuentesDao preguntaFrecuentesDao;

	@Override
	public void insertarPreguntaFrecuente(Pregfrec pregfrec) throws Exception {
		preguntaFrecuentesDao.insertarPreguntaFrecuente(pregfrec);
		
	}

	@Override
	public List<Pregfrec> listarPreguntas() throws Exception {		
		return preguntaFrecuentesDao.listarPreguntas();
	}

	@Override
	public void actualizarPregunta(Pregfrec pregfrec) throws Exception {
		preguntaFrecuentesDao.actualizarPregunta(pregfrec);
		
	}

	@Override
	public void eliminarPregunta(Pregfrec pregfrec) throws Exception {
		preguntaFrecuentesDao.eliminarPregunta(pregfrec);
		
	}

}