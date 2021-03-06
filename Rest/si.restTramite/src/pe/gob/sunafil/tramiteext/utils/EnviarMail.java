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
    
    public void  generarEnvioDeCorreos(String mensaje,String[] direcciones,String asunto) throws Exception{
    	
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "servmail.mintra.gob.pe");

		// USUARIO ENVIA MAIL
		properties.put("mail.smtp.mail.sender", "rgarrido@trabajo.gob.pe");

		Session session = Session.getDefaultInstance(properties);

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));

		message.setSubject(asunto);


		Address direccionesClase[] = new Address[direcciones.length];
		for (int i = 0; i < direcciones.length; i++) {
			System.out.println("dircciones--> " + direcciones[i] + " " + i);
			direccionesClase[i] = new InternetAddress(direcciones[i]);
		}
		message.addRecipients(Message.RecipientType.TO, direccionesClase);
		message.setContent(mensaje, "text/html");

		Transport t = session.getTransport("smtp");

		t.connect();
		t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		t.close();

		System.out.println("Termino");
    	
    }}
