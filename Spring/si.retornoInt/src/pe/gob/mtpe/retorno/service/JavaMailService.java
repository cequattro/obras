package pe.gob.mtpe.retorno.service;


public interface JavaMailService {
	
	/**
	 * Metodo que envia mensajes por correo electronico.
	 * @throws Exception-Excepcion general 
	 */	
	public abstract String enviar(String subject, String text, String to);
	/**
	 * Metodo que envia mensajes por correo electronico.
	 * @throws Exception-Excepcion general 
	 */	
	public void enviarNormal(String subject, String text, String to) ;
	
}
