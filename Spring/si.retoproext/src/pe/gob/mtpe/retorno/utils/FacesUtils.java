package pe.gob.mtpe.retorno.utils;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


public class FacesUtils { 
	
	final static Logger logger=Logger.getLogger(FacesUtils.class);

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
	
	public static void removeUsuarioLogueado() {
		removeSessionAttribute("usuario");
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
	 
	 public static void mostrarReporte(Map parameters,String reporte,List lista, String nombreReporte) throws  JRException,IOException{
	    	
	   	 byte[] bytes=null;	   	 	
	         logger.info("1 ======>"+reporte);
	         ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	         logger.info(" 2 ======>");
	        
	         logger.info(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         JasperDesign jasperDesign = JRXmlLoader.load(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
	         logger.info(" 3 ======>");
	         JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
	         logger.info(" 4 ======>");
	         bytes = JasperRunManager.runReportToPdf(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,parameters, new JRBeanCollectionDataSource(lista));
	         
	         HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	         
	         response.setHeader("Content-Disposition", "inline; filename=\""+nombreReporte+".pdf\";");
	         
	         ServletOutputStream ouputStream = response.getOutputStream();
	         
	         FacesContext facesContext = FacesContext.getCurrentInstance();
	          try {
	        	  logger.info(" 5 ======>");
	        	 
	              if(bytes != null && bytes.length > 0){
	            	
	                    JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
	                   
	                    ouputStream.flush();
	                    ouputStream.close();
	               	  
	                    facesContext.responseComplete();
	                    facesContext.renderResponse();
	                    logger.info(" 6 ======>");
	                    
	            }
	              
	              logger.info(" 7 ======>");
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
        String ruta=rutaCadena;
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
	 
	 
	 public static String getIpAddress(){
		 HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		 String ip = "";
		 ip = request.getRemoteAddr();  
		 return ip;
	 }
	 
	 
}
