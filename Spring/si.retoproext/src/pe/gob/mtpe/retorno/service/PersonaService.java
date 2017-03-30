package pe.gob.mtpe.retorno.service;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Distrito;
import pe.gob.mtpe.retorno.bean.Persona;

/**
 * Interfaz de metodos correspondientes al manejo de la tabla persona de SIMINTRA1
 * @version 1.0
 *
 */
public interface PersonaService {	
	/**
	 * Metodo que se encarga de buscar a una persona en SIMINTRA1
	 * @param  persona Objeto de la clase {@link pe.gob.mtpe.retorno.bean.DPersona DPersona} propia del negocio de retorno productivo se usan los atributos vCodtdocide y vNumdoc
	 * @return Retorna un objeto de la clase {@link pe.gob.mtpe.retorno.bean.Persona Persona}
	 * @throws Exception excepcion general
	 */
	public Persona  buscarPersona(DPersona persona) throws Exception;
	/**
	 * Metodo que consulta el numero de personas con ese documento validando si existen o no registros de la persona en SIMINTRA1
	 * @param  persona Objeto de la clase {@link pe.gob.mtpe.retorno.bean.DPersona DPersona} propia del negocio de retorno productivo se usan los atributos vCodtdocide y vNumdoc
	 * @return Retona un Integer 
	 * @throws Exception excepcion general
	 */
	public Integer  consultaNumeroPersonas(DPersona persona) throws Exception;
	/**
	 * Metodo que actualiza  los registro de persona en SIMINTRA1
	 * @param  persona Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Persona Persona} Actualiza cualquier atributo que no sea null usa como parametros la llave vCodtdocide, vNumdoc 
	 * @throws Exception  excepcion general
	 */
	public void     actualizarPersona(Persona persona) throws Exception;
	/**
	 * Metodo que inserta registro de persona en SIMINTRA1 
	 * @param  persona Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Persona Persona} inserta cualquier atributo que no sea null obligatorio es la llave vCodtdocide, vNumdoc 
	 * @throws Exception  excepcion general
	 */
	public void     insertPersona(Persona persona) throws Exception;
	/**
	 * Metodo que verifica que el registro de la persona haya sido actualizada con el web service de la RENIEC 
	 * @param  persona Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Persona Persona} usa como parametros de consulta la llave vCodtdocide, vNumdoc
	 * @return Retorna un String vFlgreniec cuyo valor es  S o N
	 * @throws Exception excepcion general
	 */
	public String   verificaActuPersonaReniec(Persona persona)throws Exception;
	/**
	 * Metodo que obtiene el distrito eqivalente al que nos devuelve el web service de reniec
	 * @param  distrito Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Distrito Distrito} usa como parametro de consulta vCoddepren, vCodproren, vCoddisren
	 * @return Retorna un objeto de la clase {@link pe.gob.mtpe.retorno.bean.Distrito Distrito} equivalente a los datos devueltos por el servicio de RENIEC
	 * @throws Exception excepcion general
	 */
	public Distrito obtieneDistritoNacimiento(Distrito distrito)throws Exception;
	
}
