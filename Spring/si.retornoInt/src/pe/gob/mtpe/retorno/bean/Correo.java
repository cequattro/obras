package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class Correo implements Serializable {
	
	/**
	 * String asunto 
	 * ASUNTO DEL CORREO ELECTRONICO A ENVIAR
	 */
	private String asunto;
	
	/**
	 * String contenido 
	 * CONTENIDO DEL CORREO ELECTRONICO A ENVIAR
	 */
	private String contenido;
	
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
	
	

}
