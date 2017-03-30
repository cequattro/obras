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
	 * Metodo que inserta las preguntas frecuentes
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Pregfrec Pregfrec}>
	 * @throws Exception excepcion general
	 */
	public void insertarPreguntaFrecuente(Pregfrec pregfrec) throws Exception;
	
	/**
	 * Metodo que lista las preguntas frecuentes
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Pregfrec Pregfrec}> Retorna lista de pregunta frecuentes
	 * @throws Exception excepcion general
	 */
	public List<Pregfrec> listarPreguntas() throws Exception;
	
	/**
	 * Metodo que actualiza las preguntas frecuentes
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Pregfrec Pregfrec}>
	 * @throws Exception excepcion general
	 */
	public void actualizarPregunta(Pregfrec  pregfrec) throws Exception;
	
	/**
	 * Metodo que eliminas las preguntas frecuentes
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Pregfrec Pregfrec}>
	 * @throws Exception excepcion general
	 */
	public void eliminarPregunta(Pregfrec  pregfrec) throws Exception;

}
