package pe.gob.sunafil.tramiteext.utils;



import javax.mail.*;
import javax.mail.internet.*;
import java.io.StringWriter;
import java.io.PrintWriter;

import java.util.Properties;


public class EnviarMail {   
	
	public static String getStackTraceToHTML(final Throwable throwable) {
    	StringWriter sw = new StringWriter();
    	PrintWriter pw = new PrintWriter(sw);
		throwable.printStackTrace(pw);
		String stackTrace = sw.toString();
		return stackTrace.replace(System.getProperty("line.separator"), "<br/>\n");
    }
    
    public void  generarEnvioDeCorreos(String mensajeHtml,String[] direcciones,String asunto) throws Exception{
    	
    	String host= "smtp.gmail.com";
		String user= "sistemas.sunafil@gmail.com";
		String password= "ogtic2015";
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.mail.sender", user);
		properties.put("mail.smtp.user",user); 
		properties.put("mail.smtp.password", password);
		properties.put("mail.smtp.starttls.enable", "true");// TLS si está disponible
		
		//INI::::CODIGO DE PRUEBAS Y VERIFICACION, SOLO COMENTAR EN PRODUCCION: 
//		properties.put("mail.transport.protocol", "smtps");
//		properties.put("mail.smtp.ssl.enable", "true");
//		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		//FIN::::
		
		properties.put("mail.smtp.auth", "true");//Si requiere o no usuario y password para conectarse.
		//properties.put("mail.smtp.port","587"); //NO ME PIDIO ESTO:Puerto de gmail para envio de correos
		
		System.out.println("obtenemos la sesion:");
		Session session = Session.getDefaultInstance(properties);
		
		System.out.println("Ingresamos los mensajes :");
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));

		message.setSubject(asunto);
		
		Address direccionesClase[] = new Address[direcciones.length];
		for (int i = 0; i < direcciones.length; i++) {
			System.out.println("dircciones--> " + direcciones[i] + " " + i);
			direccionesClase[i] = new InternetAddress(direcciones[i]);
		}
		System.out.println("addRecipients and content:");
		message.addRecipients(Message.RecipientType.TO, direccionesClase);
		//MENSAJE COPIA OCULTO:
		/*if ("462".equalsIgnoreCase(n_numdep_evalToOculto)){
			System.out.println("Enviando Mensaje Oculto para copia a librodereclamaciones@sunafil.gob.pe");//COMENTAR PARA PRUEBAS
			message.addRecipients(Message.RecipientType.BCC, new Address[] { new InternetAddress("librodereclamaciones@sunafil.gob.pe") });//COMENTAR PARA PRUEBAS
//			System.out.println("Enviando Mensaje Oculto para copia a rgarrido@sunafil.gob.pe");//DESCOMENTAR PARA PRUEBAS
//			message.addRecipients(Message.RecipientType.BCC, new Address[] { new InternetAddress("rgarrido@sunafil.gob.pe") });//DESCOMENTAR PARA PRUEBAS
		}*/
		
		message.setContent(mensajeHtml, "text/html");
		//Acuse de Recibo
		//message.addHeader("Disposition-Notification-to", (String) properties.get("mail.smtp.mail.sender"));
		//Prioridad Alta
		System.out.println("metemos addheaer X-Priority:");
		message.addHeader("X-Priority", "1");
		
		System.out.println("obtenemos el Transport:");
		Transport t = session.getTransport("smtp");
	    try {
	    	System.out.println("obtenemos el connect():");
	        t.connect(host, user, password);
	        System.out.println("enviando el mensaje:");
	        //SOLO A LOS RECIPIENTS TO
	        //t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
	        //A TODOS LOS RECIPIENTS ALL
	        t.sendMessage(message,message.getAllRecipients());

	    } finally {
	    	System.out.println("cerramos la conexion:");
	        t.close();
	    }	
		System.out.println("Termino el envío de correo.");
    	
    }}
