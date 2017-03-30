package pe.gob.mtpe.retorno.service;

import java.util.List;

import pe.gob.mtpe.retorno.bean.Pregfrec;

/**
 * Interfaz que se encarga de manejar las preguntas frecuentes.
 * @version 1.0
 *
 */
public interface PreguntaFrecuentesService {
	
	/**
	 * Metodo que lista las preguntas frecuentes
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Pregfrec Pregfrec}> Retorna lista de pregunta frecuentes
	 * @throws Exception excepcion general
	 */
	public List<Pregfrec> listarPreguntas() throws Exception;

}
