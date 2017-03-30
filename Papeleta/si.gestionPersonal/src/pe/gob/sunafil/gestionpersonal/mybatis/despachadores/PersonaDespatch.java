package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;


import java.util.List;

import pe.gob.sunafil.gestionpersonal.bean.Persona;
import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPPersona;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTPersona;

public class PersonaDespatch {
	
	private INTPersona persDao;
	
	public PersonaDespatch(){
		persDao=new IMPPersona();
	}
	
	public Persona getTrabajador(Persona persona) throws Exception{
		return persDao.getTrabajador(persona);
	}
	public String insertarPersona(Persona persona) throws Exception {
		return persDao.insertarPersona(persona);
	}
	public List<Persona> listarPersona(Persona persona) throws Exception {
		return persDao.listarPersona(persona);
	}
	public String actualizarPersona(Persona persona) throws Exception {
		return persDao.actualizarPersona(persona);
	}
}
