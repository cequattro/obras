package pe.gob.mtpe.retorno.dao;

import java.util.List;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Mensaje;

public interface MensajeDao {
	
	public List<Mensaje> listaPreguntas(DPersona persona) throws Exception;
	public Mensaje morstarPregunta(Mensaje mensaje) throws Exception;
	public void actualizarMensaje(Mensaje mensaje) throws Exception;

}
