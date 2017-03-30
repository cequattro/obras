package pe.gob.mtpe.retorno.service;

import java.util.List;
import java.util.Map;
import pe.gob.mtpe.retorno.bean.Mensaje;
import pe.gob.mtpe.retorno.bean.Persona;


/**
 * Interfaz que maneja los metodos de preguntas realizadas por el retornante y las respuestas de los operadores de migraciones
 *@version 1.0
 *
 */
public interface MensajeService {
	/**
	 * Metodo que lista las preguntas realizadas por un retornante en especifico y sus respuestas brindadas por los operadores
	 * @param  persona Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Persona Persona} se usa los atributos vCodtdocide y vNumdoc
	 * @return List<{@link java.util.Map Map}> Retorna una lista de Map con la pregunta V_TITMENSAJ y la respuesta V_RESPTA
	 * @throws Exception-Excepcion general 
	 */
	public List<Map> 	listaPreguntas(Persona persona) throws Exception;
	/**
	 * Metodo que inserta pregunta hecha por el retornante
	 * @param  mensaje Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Mensaje Mensaje}
	 * @throws Exception-Excepcion general 
	 */
	public void 		insertarMensaje(Mensaje mensaje) throws Exception;

}
