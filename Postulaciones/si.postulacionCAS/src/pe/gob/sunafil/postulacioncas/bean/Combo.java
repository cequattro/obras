package pe.gob.sunafil.postulacioncas.bean;

import java.io.Serializable; 

public class Combo implements Serializable {
	
	private static final long serialVersionUID = 5499386718289557444L;
	private String v_codigo;
	private String v_descripcion;
	
	public String getV_codigo() {
		return v_codigo;
	}
	public void setV_codigo(String v_codigo) {
		this.v_codigo = v_codigo;
	}
	public String getV_descripcion() {
		return v_descripcion;
	}
	public void setV_descripcion(String v_descripcion) {
		this.v_descripcion = v_descripcion;
	}
	
	
	
}
