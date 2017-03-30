package pe.gob.mtpe.retorno.service;

import java.util.List;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Mensaje;
import pe.gob.mtpe.retorno.bean.Persona;

public interface MensajeService {

	/**
	 * Metodo que lista las preguntas realizadas por un retornante en especifico y sus respuestas brindadas por los operadores
	 * @param  persona Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Persona Persona} se usa los atributos vCodtdocide y vNumdoc
	 * @return List<{@link java.util.Map Map}> Retorna una lista de Map con la pregunta V_TITMENSAJ y la respuesta V_RESPTA
	 * @throws Exception-Excepcion general 
	 */
	public List<Mensaje> listaPreguntas(DPersona persona) throws Exception;
	
	/**
	 * Metodo que Muestra las preguntas realizadas por un retornante en especifico y sus respuestas brindadas por los operadores
	 * @throws Exception-Excepcion general.
	 */
	public Mensaje morstarPregunta(Mensaje mensaje) throws Exception;
	
	/**
	 * Metodo que Actualiza las preguntas realizadas por un retornante en especifico y sus respuestas brindadas por los operadores
	 * @throws Exception-Excepcion general.
	 */
	public void actualizarMensaje(Mensaje mensaje) throws Exception;
}
