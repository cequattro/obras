package pe.gob.sunafil.postulacioncas.mybatis.despachadores;

import pe.gob.sunafil.postulacioncas.bean.Entidad;
import pe.gob.sunafil.postulacioncas.bean.Persona;
import pe.gob.sunafil.postulacioncas.mybatis.implementacion.IMPPersonaPideReniec;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTPersonaPideReniec;



public class PersonaPideReniecDespatch {
	
	private INTPersonaPideReniec persDao;
	
	public PersonaPideReniecDespatch(){
		persDao=new IMPPersonaPideReniec();
	}
	
	public String verificaActuPersonaReniec(Persona persona) throws Exception {
		return persDao.verificaActuPersonaReniec(persona);
	} 
	public String insertarPersona(Persona persona) throws Exception {
		return persDao.insertarPersona(persona);
	}	 
	public String actualizarPersona(Persona persona) throws Exception {
		return persDao.actualizarPersona(persona);
	}
	public Entidad getPersona(Persona persona) throws Exception {
		return persDao.getPersona(persona);
	}
}
