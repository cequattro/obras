package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import org.reniec.rel.ReniecBean;

import pe.gob.sunafil.gestionpersonal.bean.Persona;
import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPPersonaReniec;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTPersonaReniec;


public class PersonaReniecDespatch {
	
	private INTPersonaReniec persDao;
	
	public PersonaReniecDespatch(){
		persDao=new IMPPersonaReniec();
	}
	
	public String verificaActuPersonaReniec(Persona persona) throws Exception {
		return persDao.verificaActuPersonaReniec(persona);
	} 
	public String insertarPersona(ReniecBean persona, String ip, String vNomusureg) throws Exception {
		return persDao.insertarPersona(persona, ip, vNomusureg);
	}	 
	public String actualizarPersona(ReniecBean persona, String ip, String vNomusureg) throws Exception {
		return persDao.actualizarPersona(persona, ip, vNomusureg);
	}
	public Persona getTrabajador(Persona persona) throws Exception {
		return persDao.getTrabajador(persona);
	}
	public ReniecBean getTrabajador(String dni) throws Exception {
		return persDao.getTrabajador(dni);
	}
}
