package pe.gob.sunafil.gestionpersonal.utils;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import net.sf.jasperreports.engine.util.JRLoader;


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
	 
	 public static void mostrarReporte(Map parameters,String reporte,List lista, String nombreReporte) throws  JRException,IOException{
	    	
	   	 byte[] bytes=null;
	   	 	 parameters.put("PV_RUTA_IMAGEN",FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/logos/logo_mtpe.png")) ;
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
	   	 	 parameters.put("PV_RUTA_IMAGEN",FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/logos/logo_mtpe.png")) ;
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
	 
	 public static void mostrarDosReportesJasper(Map parametros, Map parametros2,String reporte, String reporte2,List lista, List lista2, String nombreReporteConsolidado) throws JRException, IOException
	 {
		 ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		 parametros.put("PV_RUTA_IMAGEN",FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/logos/logo_mtpe.png"));
		 parametros.put("IS_IGNORE_PAGINATION", true);
		 parametros2.put("PV_RUTA_IMAGEN",FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/logos/logo_mtpe.png"));
		 parametros2.put("IS_IGNORE_PAGINATION", true);		 		 

		 JasperReport jreport1 = (JasperReport) JRLoader.loadObject(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte));
		 JasperPrint jprint1 = JasperFillManager.fillReport(jreport1, parametros, new JRBeanCollectionDataSource(lista));

		 JasperReport jreport2 = (JasperReport) JRLoader.loadObject(servletContext.getRealPath("/jsfDocs/modulos/reporte/"+reporte2));
		 JasperPrint jprint2 = JasperFillManager.fillReport(jreport2, parametros2, new JRBeanCollectionDataSource(lista2));//lista 1 no sirve pa nada puede ser otra lista de un elemento

		 List<JasperPrint> jprintlist = new ArrayList<JasperPrint>();

		 jprintlist.add(jprint1);
		 jprintlist.add(jprint2);

		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 JRPdfExporter exporter = new JRPdfExporter();
		 //Add the list as a Parameter
		 exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jprintlist);
		 //this will make a bookmark in the exported PDF for each of the reports
		 exporter.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, Boolean.TRUE);
		 exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		 exporter.exportReport();

		 HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		 response.setHeader("Content-Type", "application/pdf");
		 response.setHeader("Content-Disposition", "inline; filename=\"" + nombreReporteConsolidado + ".pdf\";");
		 ServletOutputStream ouputStream = response.getOutputStream();
		 ouputStream.write(baos.toByteArray());
		 ouputStream.flush();
		 ouputStream.close();
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
	 
	 public static void mostrarXLSX(String rutaCadena,String nombreArchivo)throws Exception{
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
            response.setHeader("Content-Type", "application/vnd.ms-excel");
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
	 
	 public static boolean validarEmail(String mail) {        
	        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	        Matcher matcher = pattern.matcher(mail);
	        return matcher.matches();
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
}
