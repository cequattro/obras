package pe.gob.sunafil.envioCorrCongresales.mail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
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

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import pe.gob.sunafil.envioCorrCongresales.util.AplicationUtil;
import pe.gob.sunafil.envioCorrCongresales.util.ComboBean;

public class EnvioMail {

	public static void main(String[] args) throws Exception{
		try{
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("INICIANDO EJECUCION DE ENVIO DE CORREOS PARA DOCUMENTOS CONGRESALES PENDIENTES ...");
			java.util.Date fecha = new Date();
			System.out.println ("FECHA DE EJECUCION: "+fecha);
			
			//::::::::::::: INI PRODUCCION :::::::::::::
            /*
			//OBTENEMOS LAS DIRECCIONES DE CORREOS POR INTENDENCIA:
        	String cadenaDirecciones="";
        	Collection col = (Collection<ComboBean>)AplicationUtil.CargaCombo("tdtbc_correosstd", "v_codpersonal", "v_correo", "where v_flgact='S' and v_flgcongre='S'");
        	for (Iterator i=col.iterator(); i.hasNext(); ){
        	     ComboBean cmb = (ComboBean) i.next();   
        	     cadenaDirecciones = cadenaDirecciones+cmb.getV_nombre()+";";
        	}
        	System.out.println(cadenaDirecciones);
        	String  [] direcciones = StringUtils.split(cadenaDirecciones, ";");
        	for(String correo:direcciones){
    			System.out.println("CorreoObtenido=>"+correo);
    		}
        	*/
        	
        	//::::::::::::: FIN PRODUCCION :::::::::::::
        	
        	//::::::::::::: INI PRUEBAS :::::::::::::
        	
			//PARA REALIZAR PRUEBAS:
//			String [] direcciones = StringUtils.split("rgarrido@sunafil.gob.pe;kaguilar@sunafil.gob.pe;gcastro@sunafil.gob.pe",";");
			String [] direcciones = StringUtils.split("wcastro@sunafil.gob.pe",";");
			
			//::::::::::::: FIN PRUEBAS :::::::::::::
        	
        	
			enviarExcelxCorreo(direcciones);			
			
		System.out.println("FIN!!!!!!!!!!!");
		
		}catch(Exception e){
			System.out.println("ERROR PRINCIPAL DEL MAIN");
			e.printStackTrace();
			System.out.println(getStackTraceToHTML(e));
		}
        
	}
	
	/**
	 * Metodo para enviar un correo a una intendencia regional
	 * @param n_numdep dependencia de la intendencia regional
	 * @param direcciones ->las direcciones a las cuales se le remitirá el correo
	 * @throws Exception
	 */
	public static void enviarExcelxCorreo(String[] direcciones) throws Exception{
		System.out.println("Metodo: enviarExcelxDependencia");
		// TODO Auto-generated method stub
		System.out.println("CREANDO ARCHIVO EXCEL...");
        //============================
        //CREAMOS EL OUTPUTSTREAM
        //============================
		
		System.out.println("Creando el ByteArrayOutputStream outputstream....");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
		ArrayList list= null;
		try {
			//con la conexion de multas
			list=(ArrayList)AplicationUtil.obtieneColeccion("SPR_LST_CONG_PEND_CORREO", new String[]{});
								
			System.out.println("cantidad en la lista => "+list.size());
			
			//CREAMOS EL LIBRO:
			System.out.println("Creando el LibroExcel....");
			Workbook libroReporte = new HSSFWorkbook();
			
			//estilos:
			Font font = libroReporte.createFont();
			font.setColor(HSSFColor.BLACK.index);
    	    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
    	    CellStyle style0 = libroReporte.createCellStyle();
    	    style0.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
    	    style0.setFillPattern(CellStyle.SOLID_FOREGROUND);
    	    style0.setFont(font);	
    	    CellStyle style1 = libroReporte.createCellStyle();
    	    style1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
    	    style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
    	    style1.setFont(font);
    	    style1.setBorderBottom(CellStyle.BORDER_THIN);
    	    style1.setBorderTop(CellStyle.BORDER_THIN);
    	    style1.setBorderRight(CellStyle.BORDER_THIN);
    	    style1.setBorderLeft(CellStyle.BORDER_THIN);
			
			
			
			
			
			
			//UTILIZAMOS LA CLASE SHEET PARA CREAR UNA NUEVA HOJA DE TRABAJO DENTRO DEL LIBRO QUE CREAMOS ANTERIORMENTE
	        Sheet hojaReporte = libroReporte.createSheet("Reporte Congresal Pendiente");
	        	
        	//LA CLASE ROW NOS PERMITIRÁ CREAR LAS FILAS
        
        	//CREAMOS LA PRIMERA FILA:
            Row fila_primera = hojaReporte.createRow(0);
            
            //LLENAMOS LA PRIMERA FILA:
            for(int c=0;c<13;c++){
            	
            	Cell celda = fila_primera.createCell(c);
            	celda.setCellStyle(style1);
            	if(0 ==c)celda.setCellValue("Hoja de Ruta");
            	else if(1 ==c)celda.setCellValue("Año de Hoja de Ruta");
            	else if(2 ==c)celda.setCellValue("Tipo de Documento Congresal");
            	else if(3 ==c)celda.setCellValue("Número de Documento");
            	else if(4 ==c)celda.setCellValue("Asunto");
            	
            	else if(5 ==c)celda.setCellValue("Comisión");
            	else if(6 ==c)celda.setCellValue("Congresista");
            	
            	else if(7 ==c)celda.setCellValue("Fecha Inicio");
            	else if(8 ==c)celda.setCellValue("Fecha Fin");
            	else if(9 ==c)celda.setCellValue("Días por Vencer");
            	else if(10 ==c)celda.setCellValue("Días Vencidos");
            	else if(11 ==c)celda.setCellValue("Días Excedidos");
            	else if(12 ==c)celda.setCellValue("Ubicación Actual del Trámite");
            }
            
            //ITERAMOS LA LISTA PARA AGREGAR TANTAS FILAS MAS EXISTA
            int f=1;
        	for(Iterator i=list.iterator();i.hasNext();){
        		System.out.println("Creando la fila nro=>"+f);
        		//CREAMOS LAS SIGUIENTES  FILA:
                Row filas_siguientes = hojaReporte.createRow(f);
				BasicDynaBean registro=(BasicDynaBean)i.next();
				//SE SUPONE QUE ESTE ITERATOR TIENE 22 COLUMNAS EN SU RESULTADO
				for(int c=0;c<13;c++){
					//CREAMOS LA CELDA A PARTIR DE LA FILA ACTUAL
	                Cell celda = filas_siguientes.createCell(c);
                    if(0 ==c){
                    	celda.setCellValue((String)registro.get("V_NUMHOJA"));
                    	System.out.println("V_NUMHOJA=>"+registro.get("V_NUMHOJA"));
                    }
                    else if(1 ==c){
                    	celda.setCellValue((String)registro.get("V_ANIOHOJA"));
                    	System.out.println("V_ANIOHOJA=>"+registro.get("V_ANIOHOJA"));
                    }
                    else if(2 ==c)celda.setCellValue((String)registro.get("V_DESTIPDOCREF"));
                    else if(3 ==c)celda.setCellValue((String)registro.get("V_NUMDOCREF"));
                    else if(4 ==c)celda.setCellValue((String)registro.get("V_DESASUNTO"));
                    
                    else if(5 ==c)celda.setCellValue((String)registro.get("V_DESCOM"));
                    else if(6 ==c)celda.setCellValue((String)registro.get("V_NOMCONG"));
                    
                    else if(7 ==c)celda.setCellValue((String)registro.get("D_FECINI"));
                    else if(8 ==c)celda.setCellValue((String)registro.get("D_FECFIN"));
                    else if(9 ==c)celda.setCellValue((String)registro.get("N_DIASXVENCER"));
                    else if(10 ==c)celda.setCellValue((String)registro.get("N_DIASVENCIDOS"));
                    else if(11 ==c)celda.setCellValue((String)registro.get("N_DIASEXCEDIDOS"));
                    else if(12 ==c)celda.setCellValue((String)registro.get("UBICACION"));
				}
				f=f+1;
			}
        	System.out.println("Escribimos el libro creado en el outputstream....");
        	libroReporte.write(outputStream);
        	//Cerramos el flujo de datos
            //outputStream.close();
	       
		}catch (Exception e) {			
			e.printStackTrace();
			System.out.println(getStackTraceToHTML(e));
		} finally{
			System.out.println("TERMINO LA CONSULTA Y GENERACION DEL EXCEL DE LA DEPENDENCIA.");
		}
    	
        
        
        ////////////////////////////////////////////////////////////////////////
        //ENVIANDO CORREO:
        ////////////////////////////////////////////////////////////////////////
		
		//1RO CONSULTAMOS A LA BD POR LA FECHA DE HOY
		String fechaReclamacion = AplicationUtil.traeDato("select to_char(sysdate-1,'dd/mm/yyyy') as \"fecha\" from dual", "fecha");
				
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

		message.setSubject("["+list.size()+"] Documento(s) Congresal(es) pendientes al : "+fechaReclamacion);
//		message.setSubject("PRUEBAAAAAAAAAAAAS::: ["+list.size()+"] Documento(s) Congresal(es) pendientes al : "+fechaReclamacion);
		Address direccionesClase[] = new Address[direcciones.length];
		for (int i = 0; i < direcciones.length; i++) {
			System.out.println("dircciones--> " + direcciones[i] + " " + i);
			direccionesClase[i] = new InternetAddress(direcciones[i]);
		}
		System.out.println("addRecipients and content:");
		message.addRecipients(Message.RecipientType.TO, direccionesClase);
		
		
		String mensajeBodyCorreo= "Se adjunta Reporte de Documentos Congresales pendientes a la fecha "+fechaReclamacion;
		if(list.size()==0){
			mensajeBodyCorreo="A la fecha ("+fechaReclamacion+"), no se cuentan con Documentos Congresales Pendientes de Atención";
		}
		
		/////////////////////////////////////////////////////
		System.out.println("Creando el MimeMultipart mp....");
		Multipart mp = new MimeMultipart();
		System.out.println("Creando el MimeBodyPart htmlPart....");
        MimeBodyPart htmlPart = new MimeBodyPart();        
        htmlPart.setContent(mensajeBodyCorreo, "text/html");
        mp.addBodyPart(htmlPart);
        
        System.out.println("Creando el MimeBodyPart attachment....");
        MimeBodyPart attachment = new MimeBodyPart();
        attachment.setFileName("reporte_pendiente_congresal.xls");
        System.out.println("Metiendo el outputStream al attachment....");
        //attachment.setContent(outputStream.toByteArray(), "application/vnd.ms-excel"); //ESTO LO HACE EL NUEVO JAVAMAIL EN JDK 1.6
        DataSource fds = new ByteArrayDataSource(outputStream.toByteArray(),"application/vnd.ms-excel");
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
