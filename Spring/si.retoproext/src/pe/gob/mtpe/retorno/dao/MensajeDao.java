package pe.gob.mtpe.retorno.dao;

import java.util.List;
import java.util.Map;

import pe.gob.mtpe.retorno.bean.Mensaje;
import pe.gob.mtpe.retorno.bean.Persona;

public interface MensajeDao {
	
	public List<Map> 	listaPreguntas(Persona persona) throws Exception;
	public void 		insertarMensaje(Mensaje mensaje) throws Exception;

}
