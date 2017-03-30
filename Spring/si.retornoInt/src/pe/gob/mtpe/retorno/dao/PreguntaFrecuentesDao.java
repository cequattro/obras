package pe.gob.mtpe.retorno.dao;

import java.util.List;

import pe.gob.mtpe.retorno.bean.Pregfrec;

public interface PreguntaFrecuentesDao {
	
	public void insertarPreguntaFrecuente(Pregfrec pregfrec) throws Exception;
	public List<Pregfrec> listarPreguntas() throws Exception;
	public void actualizarPregunta(Pregfrec  pregfrec) throws Exception;
	public void eliminarPregunta(Pregfrec  pregfrec) throws Exception;

}
