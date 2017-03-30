package pe.gob.mtpe.retorno.service.impl;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mtpe.retorno.service.JavaMailService;
import pe.gob.mtpe.retorno.util.funciones.Funciones;

@Service
public class JavaMailServiceImpl implements JavaMailService {
	
	final static Logger logger=Logger.getLogger(JavaMailServiceImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Autowired
	private SimpleMailMessage templateMessage;

	
	@Transactional
	public String enviar(String subject, String text, String to) {
		String retorno = null;

		MimeMessage message = mailSender.createMimeMessage();
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		String destinos[] = to.split(",");
		
		simpleMailMessage.setTo(destinos);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			helper.setFrom(templateMessage.getFrom());
			helper.setTo(simpleMailMessage.getTo());
			helper.setSubject(simpleMailMessage.getSubject());
			helper.setText(String.format(simpleMailMessage.getText()), true);
			
			mailSender.send(message);
		} catch (MessagingException e) {
			retorno = e.getMessage();
		}
	
		return retorno;
	}
	
	@Transactional
	public void enviarNormal(String subject, String text, String to) {		
		   String ruta = Funciones.ObtieneProperty("pe.gob.mtpe.retorno.util.properties.mtpe_app","mtpe.framework.rutamail");		   
	       final String username = Funciones.leerPropertyExterno(ruta, "mail.username");
	       final String password = Funciones.leerPropertyExterno(ruta, "mail.password");
	       Properties props = new Properties();
	       props.put("mail.smtp.auth",Funciones.leerPropertyExterno(ruta, "mail.smtp.auth"));
	       props.put("mail.smtp.port",Funciones.leerPropertyExterno(ruta, "mail.port"));
	       props.put("mail.smtp.host",Funciones.leerPropertyExterno(ruta, "mail.host"));
	       props.put("mail.smtp.socketFactory.port",Funciones.leerPropertyExterno(ruta, "mail.smtp.socketFactory.port"));
	       props.put("mail.smtp.socketFactory.class", Funciones.leerPropertyExterno(ruta, "mail.smtp.socketFactory.class"));
	       props.put("mail.smtp.starttls.enable",Funciones.leerPropertyExterno(ruta, "mail.smtp.starttls.enable"));
	       //props.put("mail.smtp.socketFactory.fallback","true");
	       //props.put("mail.debug", "false");	       
	     

	       Session session = Session.getInstance(props,
	               new javax.mail.Authenticator() {
	               protected PasswordAuthentication getPasswordAuthentication(){
	                   return new PasswordAuthentication(username,password);
	               }
	       });
	       try{
	    	   
	           SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

	           MimeMessage message = new MimeMessage(session);
	           simpleMailMessage.setTo(to);
	   		   simpleMailMessage.setSubject(subject);
	   		   simpleMailMessage.setText(text);
	           message.setSentDate(new Date());
	          
			   MimeMessageHelper helper = new MimeMessageHelper(message, true);

			   helper.setFrom(templateMessage.getFrom());
			   helper.setTo(simpleMailMessage.getTo());
			   helper.setSubject(simpleMailMessage.getSubject());
			   helper.setText(String.format(simpleMailMessage.getText()), true);
	           
	           //message.saveChanges();
	           Transport.send(message);
	           //Transport transport = session.getTransport("smtp");
	           //transport.connect("servmail.trabajo.gob.pe",username,password);
	           //transport.sendMessage(message, message.getAllRecipients());
	           //transport.close();	         
	       }catch(MessagingException e){
	           logger.error("Error:",e);
	       }
	}

}
