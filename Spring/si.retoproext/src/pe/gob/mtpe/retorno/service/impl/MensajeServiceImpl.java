package pe.gob.mtpe.retorno.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mtpe.retorno.bean.Mensaje;
import pe.gob.mtpe.retorno.bean.Persona;
import pe.gob.mtpe.retorno.dao.MensajeDao;
import pe.gob.mtpe.retorno.service.MensajeService;

@Service("mensajeService")
public class MensajeServiceImpl implements MensajeService {

	@Autowired
	private MensajeDao mensajeDao;

	@Override
	public List<Map> listaPreguntas(Persona persona) throws Exception {
		return mensajeDao.listaPreguntas(persona);
	}

	@Override
	public void insertarMensaje(Mensaje mensaje) throws Exception {
		mensajeDao.insertarMensaje(mensaje);

	}

}
