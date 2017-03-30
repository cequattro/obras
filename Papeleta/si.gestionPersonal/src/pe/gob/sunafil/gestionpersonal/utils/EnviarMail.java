package pe.gob.sunafil.gestionpersonal.utils;



import javax.mail.*;
import javax.mail.internet.*;
import java.io.StringWriter;
import java.io.PrintWriter;


import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import java.util.Properties;


public class EnviarMail {   
	
	public static String getStackTraceToHTML(final Throwable throwable) {
    	StringWriter sw = new StringWriter();
    	PrintWriter pw = new PrintWriter(sw);
		throwable.printStackTrace(pw);
		String stackTrace = sw.toString();
		return stackTrace.replace(System.getProperty("line.separator"), "<br/>\n");
    }
	
	
public void generarEnvioDeCorreos444(String mensajeHtml,String[] direcciones,String asunto) throws Exception
{
	String host= "smtp.gmail.com";
	String user= "sistemas.sunafil@gmail.com";
	String password= "ogtic2015";
	
	Properties properties = new Properties();
	properties.put("mail.smtp.host", host);
	properties.put("mail.smtp.mail.sender", user);
	properties.put("mail.smtp.user",user); 
	properties.put("mail.smtp.password", password);
	properties.put("mail.smtp.starttls.enable", "true");// TLS si esta disponible
	properties.put("mail.smtp.auth", "true");//Si requiere o no usuario y password para conectarse.
	//properties.put("mail.smtp.port","587"); //NO ME PIDIO ESTO:Puerto de gmail para envio de correos
	
	System.out.println("obtenemos la sesion:");
	Session session = Session.getDefaultInstance(properties);
	
	System.out.println("Ingresamos los mensajes :");
	MimeMessage message = new MimeMessage(session);
	message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));

	message.setSubject(asunto);
//	message.setSubject("PRUEBAAAAAAAAAAAAS::: ["+list.size()+"] Documento(s) Congresal(es) pendientes al : "+fechaReclamacion);
	Address direccionesClase[] = new Address[direcciones.length];
	for (int i = 0; i < direcciones.length; i++) {
		System.out.println("dircciones--> " + direcciones[i] + " " + i);
		direccionesClase[i] = new InternetAddress(direcciones[i]);
	}
	System.out.println("addRecipients and content:");
	message.addRecipients(Message.RecipientType.TO, direccionesClase);
	
	

	
	////////////////////////////////////////////////////
	System.out.println("Creando el MimeMultipart mp....");
	Multipart mp = new MimeMultipart();
	System.out.println("Creando el MimeBodyPart htmlPart....");
    MimeBodyPart htmlPart = new MimeBodyPart();        
    htmlPart.setContent(mensajeHtml, "text/html");
    mp.addBodyPart(htmlPart);
    
    /*System.out.println("Creando el MimeBodyPart attachment....");
    MimeBodyPart attachment = new MimeBodyPart();
    attachment.setFileName("reporte_pendiente_congresal.xls");
    System.out.println("Metiendo el outputStream al attachment....");

    DataSource fds = new ByteArrayDataSource(outputStream.toByteArray(),"application/vnd.ms-excel");
    attachment.setDataHandler(new DataHandler(fds));
    mp.addBodyPart(attachment);*/

    message.setContent(mp);
	////////////////////////////////////////////////////
	
	
	
	
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
        t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

    } catch(Exception e){
    	System.out.println("Ocurrio un error al obtener y/o enviar el mensaje:");
    	System.out.println(getStackTraceToHTML(e));
    	throw new Exception(e);
    	
    }finally {
    	System.out.println("cerramos la conexion:");
        t.close();
    }	
	System.out.println("Termino el envio de correo.");
	
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

}
