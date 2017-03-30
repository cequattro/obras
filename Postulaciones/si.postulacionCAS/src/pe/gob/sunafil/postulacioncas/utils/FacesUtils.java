package pe.gob.sunafil.postulacioncas.utils;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import pe.gob.sunafil.postulacioncas.bean.Usuario;


public class FacesUtils {

	public static Object getSessionAttribute(String attribute) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(false);
		Object o = null;
		if (session!=null) {
			o = session.getAttribute(attribute);
		}
		return o;
	}
	
	public static void setSessionAttribute(String attribue, Object value) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(false);
		session.setAttribute(attribue, value);
	}
	
	public static void removeSessionAttribute(String attribute) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(false);
		session.removeAttribute(attribute);
	}
	
	public static Usuario getUsuarioLogueado() {
		return (Usuario) getSessionAttribute("PGP_Usuario");
	}
	
	public static void setUsuarioLogueado(Usuario usuario) {
		setSessionAttribute("PGP_Usuario", usuario);
	}
	
	public static void removeUsuarioLogueado() {
		removeSessionAttribute("PGP_Usuario");
	}
	
	public static boolean existeUsuarioLogueado() {
		if (getUsuarioLogueado()!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void showFacesMessage(String texto, int tipo) {
		switch (tipo) {
		case 1:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, texto, "Error"));
			break;
		case 2:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, texto, "Fatal"));
			break;
		case 3:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, texto, "Informacion"));
			break;
		case 4:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, texto, "Advertencia"));
			break;
		default:
			break;
		}
	}
	
	 public static void refrescante() {
		    FacesContext context = FacesContext.getCurrentInstance();
		    Application application = context.getApplication();
		    ViewHandler viewHandler = application.getViewHandler();
		    UIViewRoot viewRoot = viewHandler.createView(context, context
		     .getViewRoot().getViewId());
		    context.setViewRoot(viewRoot);
		    context.renderResponse(); 
		  }
	 
	 /**
	  * Si piden reporte se usará este metodo.
	  * @param parameters
	  * @param reporte
	  * @param lista
	  * @param nombreReporte
	  * @throws JRException
	  * @throws IOException
	  */
	 public static void mostrarReporte(Map parameters,String reporte,List lista, String nombreReporte) throws  JRException,IOException{
	    	
	   	 byte[] bytes=null;
	   	 	 parameters.put("P_RUTA_IMAGEN",FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/logos/sunafil_logo_reporte.jpg")) ;
	         System.out.println(" 1 ======>"+reporte);
	         ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	         System.out.println(" 2 ======>");
	        
	         System.out.println(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         JasperDesign jasperDesign = JRXmlLoader.load(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         System.out.println(" 3 ======>");
	         JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
	         System.out.println(" 4 ======>");
	         bytes = JasperRunManager.runReportToPdf(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         
	         HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	         
	         response.setHeader("Content-Disposition", "inline; filename=\""+nombreReporte+".pdf\";");
	         
	         ServletOutputStream ouputStream = response.getOutputStream();
	         
	         FacesContext facesContext = FacesContext.getCurrentInstance();
	          try {
	        	  System.out.println(" 5 ======>");
	        	 
	             
	              if(bytes != null && bytes.length > 0){
	            	
	                    JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
	                   
	                    ouputStream.flush();
	                    ouputStream.close();
	               	  
	                    facesContext.responseComplete();
	                    facesContext.renderResponse();
	                    System.out.println(" 6 ======>");
	                    
	            }
	              
	              
	              
	              
	              
	              System.out.println(" 7 ======>");
	         } catch (Exception e) {
	            
	            e.printStackTrace();
	         }finally{
	        	 
	         }
	          

	  }
	 
	 
	 public static void mostrarReporteJasper(Map parameters,String reporte,List lista, String nombreReporte) throws  JRException,IOException{
	    	
	   	 byte[] bytes=null;
	   	 	 parameters.put("P_RUTA_IMAGEN",FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/logos/cabecera.jpg")) ;
	         System.out.println(" 1 ======>"+reporte);
	         ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	         System.out.println(" 2 ======>");
	        
	         System.out.println(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         //JasperDesign jasperDesign = JRXmlLoader.load(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         System.out.println(" 3 ======>");
	         JasperReport jasperReport = (JasperReport) JRLoader.loadObject(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));//JasperCompileManager.compileReport(jasperDesign);
	         System.out.println(" 4 ======>");
	         bytes = JasperRunManager.runReportToPdf(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         
	         HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	         
	         response.setHeader("Content-Disposition", "inline; filename=\""+nombreReporte+".pdf\";");
	         
	         ServletOutputStream ouputStream = response.getOutputStream();
	         
	         FacesContext facesContext = FacesContext.getCurrentInstance();
	          try {
	        	  System.out.println(" 5 ======>");
	        	 
	             
	              if(bytes != null && bytes.length > 0){
	            	
	                    JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
	                   
	                    ouputStream.flush();
	                    ouputStream.close();
	               	  
	                    facesContext.responseComplete();
	                    facesContext.renderResponse();
	                    System.out.println(" 6 ======>");
	                    
	            }
	              
	              
	              
	              
	              
	              System.out.println(" 7 ======>");
	         } catch (Exception e) {
	            
	            e.printStackTrace();
	         }finally{
	        	 
	         }
	          

	  }
	 
	 
	 public static void mostrarPDF(String rutaCadena,String nombreArchivo)throws Exception{
		 // Prepare.
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String ruta=servletContext.getRealPath(rutaCadena);
        File file = new File(ruta, nombreArchivo);
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            
            input = new BufferedInputStream(new FileInputStream(file), 1024);

            
            response.reset();
            response.setHeader("Content-Type", "application/pdf");
            response.setHeader("Content-Length", String.valueOf(file.length()));
            response.setHeader("Content-Disposition", "inline; filename=\"" + nombreArchivo + "\"");
            output = new BufferedOutputStream(response.getOutputStream(), 1024);

           
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }

            
            output.flush();
        } finally {
            
            close(output);
            close(input);
        }

      
        facesContext.responseComplete();
		 
		 
		 
	}

	private static void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Obtiene la IP del Usuario Logueado
	 * @return
	 */
	public static String getIpAddress() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String ip = "";
		ip = request.getRemoteAddr();
		return ip;
	}
	
	public static boolean validarEmail(String mail) {        
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

	 public static void mostrarArchivo(String rutaCadena,String nombreArchivo,String tipo)throws Exception{
		 // Prepare.
       FacesContext facesContext = FacesContext.getCurrentInstance();
       ExternalContext externalContext = facesContext.getExternalContext();
       HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
       ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
       String ruta=servletContext.getRealPath(rutaCadena);
       System.out.println("00000suta>>"+ruta);
       System.out.println("asssssssss"+nombreArchivo);
       File file = new File(rutaCadena, nombreArchivo);
       BufferedInputStream input = null;
       BufferedOutputStream output = null;

       try {
           
           input = new BufferedInputStream(new FileInputStream(file), 1024);

           
           response.reset();
           response.setHeader("Content-Type", "application/"+tipo);
           response.setHeader("Content-Length", String.valueOf(file.length()));
           response.setHeader("Content-Disposition", "inline; filename=\"" + nombreArchivo + "\"");
           output = new BufferedOutputStream(response.getOutputStream(), 1024);

          
           byte[] buffer = new byte[1024];
           int length;
           while ((length = input.read(buffer)) > 0) {
               output.write(buffer, 0, length);
           }

           
           output.flush();
       } finally {
           
           close(output);
           close(input);
       }

     
       facesContext.responseComplete();
		 
		 
		 
	}
	 

	 public static void enviarReporteJasper(Map parameters,String reporte,List lista,String mensajeHtml,String[] direcciones,String asunto) throws  JRException,IOException, Exception{
	    	
	   	 byte[] bytes=null;
	   	 	 parameters.put("P_RUTA_IMAGEN",FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/logos/cabecera.jpg")) ;
	         System.out.println(" 1 ======>"+reporte);
	         ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	         System.out.println(" 2 ======>");
	        
	         System.out.println(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         //JasperDesign jasperDesign = JRXmlLoader.load(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         System.out.println(" 3 ======>");
	         JasperReport jasperReport = (JasperReport) JRLoader.loadObject(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));//JasperCompileManager.compileReport(jasperDesign);
	         System.out.println(" 4 ======>");
	         bytes = JasperRunManager.runReportToPdf(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         
	         //HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	         
	         //response.setHeader("Content-Disposition", "inline; filename=\""+nombreReporte+".pdf\";");
	         
	         //ServletOutputStream ouputStream = response.getOutputStream();
	         
	         //FacesContext facesContext = FacesContext.getCurrentInstance();
	         
	         
	         System.out.println("Creando el ByteArrayOutputStream outputstream....");
	         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	         
	          try {
	        	  System.out.println(" 5 ======>");
	             
	              if(bytes != null && bytes.length > 0){
	            	
	                    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	                   
//	                    outputStream.flush();
//	                    outputStream.close();
	               	  
//	                    facesContext.responseComplete();
//	                    facesContext.renderResponse();
	                    System.out.println(" 6 ======>");
	                    
	            }
	              System.out.println(" 7 ======>");
	         } catch (Exception e) {
	            e.printStackTrace();
	         }finally{
	        	 
	         }
	          
	          
	        
	          
			////////////////////////////////////////////////////////////////////////
			//ENVIANDO CORREO:
			////////////////////////////////////////////////////////////////////////
			
			//1RO CONSULTAMOS A LA BD POR LA FECHA DE HOY
			
			
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
			
			
			
			Address direccionesClase[] = new Address[direcciones.length];
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println("dircciones--> " + direcciones[i] + " " + i);
				direccionesClase[i] = new InternetAddress(direcciones[i]);
			}
			System.out.println("addRecipients and content:");
			message.addRecipients(Message.RecipientType.TO, direccionesClase);
			
			
			
			
			
			/////////////////////////////////////////////////////
			System.out.println("Creando el MimeMultipart mp....");
			Multipart mp = new MimeMultipart();
			System.out.println("Creando el MimeBodyPart htmlPart....");
			MimeBodyPart htmlPart = new MimeBodyPart();        
			htmlPart.setContent(mensajeHtml, "text/html");
			mp.addBodyPart(htmlPart);
			
			System.out.println("Creando el MimeBodyPart attachment....");
			MimeBodyPart attachment = new MimeBodyPart();
			attachment.setFileName("postulacion_cas.pdf");
			System.out.println("Metiendo el outputStream al attachment....");
			//attachment.setContent(outputStream.toByteArray(), "application/vnd.ms-excel"); //ESTO LO HACE EL NUEVO JAVAMAIL EN JDK 1.6
			DataSource fds = new ByteArrayDataSource(outputStream.toByteArray(),"application/pdf");//application/vnd.ms-excel
			attachment.setDataHandler(new DataHandler(fds));
			mp.addBodyPart(attachment);
			//AQUI SE JUNTA Y ENVIA EN EL CONTENT
			message.setContent(mp);
			/////////////////////////////////////////////////////
			
			
			
			
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
			//t.sendMessage(message,message.getAllRecipients());
			
			} catch(Exception e){
			System.out.println("Ocurrio un error al obtener y/o enviar el mensaje:");
			System.out.println(getStackTraceToHTML(e));
			throw new Exception(e);
			
			}finally {
			System.out.println("cerramos la conexion:");
			t.close();
			}	
			System.out.println("Termino el envio de correo.");
			
//			outputStream.flush();
            outputStream.close();
            
//            Al final se cierra tmb el outupu

	  }
	 
	 
	 public static String getDateDifferenceInDDMMYYYY(Date from, Date to) {
	        Calendar fromDate=Calendar.getInstance();
	        Calendar toDate=Calendar.getInstance();
	        fromDate.setTime(from);
	        toDate.setTime(to);
	        int increment = 0;
	        int year,month,day;
	        System.out.println(fromDate.getActualMaximum(Calendar.DAY_OF_MONTH));
	        if (fromDate.get(Calendar.DAY_OF_MONTH) > toDate.get(Calendar.DAY_OF_MONTH)) {
	            increment =fromDate.getActualMaximum(Calendar.DAY_OF_MONTH);
	        }
	         System.out.println("increment"+increment);
	// DAY CALCULATION
	        if (increment != 0) {
	            day = (toDate.get(Calendar.DAY_OF_MONTH) + increment) - fromDate.get(Calendar.DAY_OF_MONTH);
	            increment = 1;
	        } else {
	            day = toDate.get(Calendar.DAY_OF_MONTH) - fromDate.get(Calendar.DAY_OF_MONTH);
	        }

	// MONTH CALCULATION
	        if ((fromDate.get(Calendar.MONTH) + increment) > toDate.get(Calendar.MONTH)) {
	            month = (toDate.get(Calendar.MONTH) + 12) - (fromDate.get(Calendar.MONTH) + increment);
	            increment = 1;
	        } else {
	            month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) + increment);
	            increment = 0;
	        }

	// YEAR CALCULATION
	        year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);
	     return   year+" años, "+month+" meses, "+day+" días";
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
			return stackTrace.replace(System.getProperty("line.separator"), "\n");
	    }
	 
	 
}
