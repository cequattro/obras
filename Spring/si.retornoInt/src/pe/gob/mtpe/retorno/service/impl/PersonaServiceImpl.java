package pe.gob.mtpe.retorno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Distrito;
import pe.gob.mtpe.retorno.bean.Persona;
import pe.gob.mtpe.retorno.dao.PersonaDao;
import pe.gob.mtpe.retorno.service.PersonaService;

@Service("personaService")
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaDao personaDao;
	

	@Override
	public Persona buscarPersona(DPersona persona) throws Exception {		 
		return personaDao.buscarPersona(persona);
	}


	@Override
	public Integer consultaNumeroPersonas(DPersona persona) throws Exception {
		return personaDao.consultaNumeroPersonas(persona);
	}


	@Override
	public void actualizarPersona(Persona persona) throws Exception {
		personaDao.actualizarPersona(persona);
		
	}


	@Override
	public void insertPersona(Persona persona) throws Exception {
		personaDao.insertPersona(persona);
		
	}


	@Override
	public String verificaActuPersonaReniec(Persona persona) throws Exception {		
		return personaDao.verificaActuPersonaReniec(persona);
	}


	@Override
	public Distrito obtieneDistritoNacimiento(Distrito distrito) {	
		try {
			return personaDao.obtieneDistritoNacimiento(distrito);
		} catch (Exception e) {
			return null;
		}
		
	}

}
