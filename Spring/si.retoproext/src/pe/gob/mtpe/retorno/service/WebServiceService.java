package pe.gob.mtpe.retorno.service;

import java.util.Map;

/**
 * Interfaz que se usa para obtener los datos autenticacion para el web service
 * @version 1.0
 *
 */
public interface WebServiceService {
	/**
	 * Metoto que  obtiene los datos los datos autenticacion para el web service
	 * @return Map datos de autenticacion n_corws, v_usuario, v_clave, v_dnifun
	 * @throws Exception
	 */
	public Map<String, String> obenterDatosServicio() throws Exception;
}
