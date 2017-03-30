package pe.gob.mtpe.retorno.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.gob.mtpe.retorno.bean.Departamento;
import pe.gob.mtpe.retorno.bean.Discapacidad;
import pe.gob.mtpe.retorno.bean.Distrito;
import pe.gob.mtpe.retorno.bean.Niveleducati;
import pe.gob.mtpe.retorno.bean.Ocupacion;
import pe.gob.mtpe.retorno.bean.Pais;
import pe.gob.mtpe.retorno.bean.ParamBus;
import pe.gob.mtpe.retorno.bean.Profesion;
import pe.gob.mtpe.retorno.bean.Provincia;
import pe.gob.mtpe.retorno.bean.Tdocide;

/**
 * Interfaz en donde se encuentran metodos generales que llaman a SIMINTRA1 
 * @version 1.0
 *
 */
public interface ComunService {

	/**
	 * Metodo que busca ocupaciones de Simintra1
	 * @param  paramBus  Clase parametros de busqueda {@link pe.gob.mtpe.retorno.bean.ParamBus ParamBus}
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Ocupacion Ocupacion}> Retorna lista de Ocupaciones 
	 * @throws Exception-Excepcion general
	 */
	public List<Ocupacion> 		buscarOcupacion(ParamBus paramBus) throws Exception;
	/**
	 * Metodo que busca profesiones de Simintra1
	 * @param  paramBus Clase parametros de busqueda {@link pe.gob.mtpe.retorno.bean.ParamBus ParamBus}
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Profesion Profesion}> Retorna lista de profesiones
	 * @throws Exception-Excepcion general
	 */
	public List<Profesion> 		buscarProfesion(ParamBus paramBus) throws Exception;
	/**
	 * Metodo que lista los tipos de documentos regitrados en simintra1
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Tdocide Tdocide}> Retorna lista de tipos de documentos
	 * @throws Exception-Excepcion general
	 */
	public List<Tdocide> 		listarTipoDocumento() throws Exception;
	/**
	 * Metodo que lista los departamentos registrados en simintra1
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Departamento Departamento}> Retorna lista de departamentos 
	 * @throws Exception
	 */
	public List<Departamento> 	ListaDepartamentos() throws Exception;
	/**
	 * Metodo que lista provincias Simintra1
	 * @param  departamento Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Departamento Departamento}
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Provincia Provincia}> Retorna lista de tipos de provincias
	 * @throws Exception-Excepcion general.
	 */
	public List<Provincia> 		ListaProvincias(Departamento departamento)throws Exception;
	/**
	 * Metodo que lista los distritos registrados en simintra1
	 * @param  provincia Objeto de la clase {@link pe.gob.mtpe.retorno.bean.Provincia Provincia}
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Distrito Distrito}>  Retorna lista de distritos
	 * @throws Exception-Excepcion general.
	 */
	public List<Distrito> 		ListaDistritos(Provincia provincia) throws Exception;
	/**
	 * Metodo que lista los paises de Simintra1
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Pais Pais}> Retona lista de paises
	 * @throws Exception-Excepcion general.
	 */
	public List<Pais> 			listaPais() throws Exception;
	/**
	 * Metodo que  lista las discapacidades
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Discapacidad Discapacidad}>  Retorna lista de discapacidades
	 * @throws Exception-Excepcion general.
	 */
	public List<Discapacidad> 	listaDiscapacidad() throws Exception;
	/**
	 * Metodo que lista los niveles educativos registrados en simintra1
	 * @return List<{@link pe.gob.mtpe.retorno.bean.Niveleducati Niveleducati}>  Retorna lista de nivel educativo
	 * @throws Exception-Excepcion general.
	 */
	public List<Niveleducati> 	listarNivelEducativo() throws Exception;

}
