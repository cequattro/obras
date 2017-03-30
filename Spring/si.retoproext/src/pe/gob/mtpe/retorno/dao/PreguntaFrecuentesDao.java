package pe.gob.mtpe.retorno.dao;

import java.util.List;

import pe.gob.mtpe.retorno.bean.Pregfrec;

public interface PreguntaFrecuentesDao {
	public List<Pregfrec> listarPreguntas() throws Exception;
}
