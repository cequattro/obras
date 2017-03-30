package pe.gob.sunafil.postulacioncas.mybatis.interfase;


import org.reniec.rel.ReniecBean;

import pe.gob.sunafil.postulacioncas.bean.Persona;


public interface INTPersonaReniec {

	
	public String insertarPersona(ReniecBean persona, String ip, String vNomusureg) throws Exception;
	public String verificaActuPersonaReniec(Persona persona) throws Exception;
	public String actualizarPersona(ReniecBean persona, String ip, String vNomusureg) throws Exception;
	public Persona getTrabajador(Persona persona) throws Exception;
	public ReniecBean getTrabajador(String dni) throws Exception;
}