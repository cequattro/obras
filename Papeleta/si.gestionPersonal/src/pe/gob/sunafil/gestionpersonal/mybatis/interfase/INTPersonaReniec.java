package pe.gob.sunafil.gestionpersonal.mybatis.interfase;


import org.reniec.rel.ReniecBean;

import pe.gob.sunafil.gestionpersonal.bean.Persona;


public interface INTPersonaReniec {

	
	public String insertarPersona(ReniecBean persona, String ip, String vNomusureg) throws Exception;
	public String verificaActuPersonaReniec(Persona persona) throws Exception;
	public String actualizarPersona(ReniecBean persona, String ip, String vNomusureg) throws Exception;
	public Persona getTrabajador(Persona persona) throws Exception;
	public ReniecBean getTrabajador(String dni) throws Exception;
}
