package pe.gob.mtpe.retorno.service;

import java.util.List;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Familia;
import pe.gob.mtpe.retorno.bean.Rango;
import pe.gob.mtpe.retorno.bean.Retorno;

/**
 * Interfaz principal en donde se encuentran metodos propios del negocio de retorno
 * @version 1.0
 *
 */
public interface RetornoService {
	
	/**
	 * Metodo que lista los motivos de retorno
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Retorno Retorno}> Devuelve uan lista de objetos de la clase  {@link pe.gob.mtpe.retorno.bean.Retorno Retorno}
	 * @throws Exception excepcion general
	 */
	public List<Retorno> listarMotivos() throws Exception;
	/**
	 * Metodo que inserta los datos del retornante incluyendo los hijos
	 * @param dPersona objeto de la clase {@link pe.gob.mtpe.retorno.bean.DPersona DPersona}; inserta los datos que no hayan sido ingresados en null,  es obligatorio la llave vCodtdocide, vNumdoc
	 * @throws Exception excepcion general
	 */
	public void 		 insertardPersona(DPersona dPersona) throws Exception;
	/**
	 * Metodo que lista los distintos tipos de rangos
	 * @param pRango objeto de la clase {@link pe.gob.mtpe.retorno.bean.Rango Rango} utiliza como parametro de consulta vTiprango que puede ser 1: RANGO DE SALARIO, 2=RANGO DE TIEMPO DESEMPLEO
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Rango Rango}> Retorna lista de rangos
	 * @throws Exception excepcion general
	 */
	public List<Rango> 	 listarRango(Rango pRango) throws Exception;
	/**
	 * Metodo que valida la existencia de registros de un retornante
	 * @param dPersona objeto de la clase {@link pe.gob.mtpe.retorno.bean.DPersona DPersona} usa como parametros de consulta la llave vCodtdocide, vNumdoc
	 * @return Retorna un Entero
	 * @throws Exception excepcion general
	 */
	public Integer 		 consultaNumeroRegistros(DPersona dPersona) throws Exception; 
	/**
	 * Metodo que se usa para obtener el registro de la ficha del retornante
	 * @param dpersona objeto de la clase {@link pe.gob.mtpe.retorno.bean.DPersona DPersona} usa como parametros de consulta la llave vCodtdocide, vNumdoc
	 * @return retorna un objeto completo de la clase {@link pe.gob.mtpe.retorno.bean.DPersona DPersona}
	 * @throws Exception excepcion general
	 */
	public DPersona 	 cargarDPersona(DPersona dpersona) throws Exception;
	/**
	 * Metodo usado para obtener el motivo de retorno de una persona
	 * @param dpersona objeto de la clase {@link pe.gob.mtpe.retorno.bean.DPersona DPersona} usa como parametros de consulta la llave vCodtdocide, vNumdoc
	 * @return retona un objeto de la clase {@link pe.gob.mtpe.retorno.bean.Retorno Retorno}
	 * @throws Exception excepcion general
	 */
	public Retorno  	 CargarMotivoRetorno(DPersona dpersona) throws Exception;
	/**
	 * Metodo que obtiene la lista de datos de los hijos
	 * @param dpersona objeto de la clase {@link pe.gob.mtpe.retorno.bean.DPersona DPersona} usa como parametros de consulta la llave vCodtdocide, vNumdoc 
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Familia Familia}> Retorna lista de objetos {@link pe.gob.mtpe.retorno.bean.Familia Familia}
	 * @throws Exception Exception excepcion general
	 */
	public List<Familia> cargarHijoRetorno(DPersona dpersona) throws Exception;

}
