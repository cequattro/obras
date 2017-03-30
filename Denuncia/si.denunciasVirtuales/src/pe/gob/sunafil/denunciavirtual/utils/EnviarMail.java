package pe.gob.sunafil.denunciavirtual.utils;



import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnviarMail {   
    
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
		//message.addRecipients(Message.RecipientType.BCC, new Address[] { new InternetAddress("richard.garrido.a@gmail.com") });
		
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
    	
    }
    /**
     * Para obtener el String en HTML del StackTrace del Error Sucedido y enviarlo al correo.
     * @param throwable
     * @return String
     */
    public static String getStackTraceToHTML(final Throwable throwable) {
    	StringWriter sw = new StringWriter();
    	PrintWriter pw = new PrintWriter(sw);
		throwable.printStackTrace(pw);
		String stackTrace = sw.toString();
		return stackTrace.replace(System.getProperty("line.separator"), "<br/>\n");
    }

}
