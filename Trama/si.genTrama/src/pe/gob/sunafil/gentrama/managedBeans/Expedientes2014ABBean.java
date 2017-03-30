package pe.gob.sunafil.gentrama.managedBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.util.StringUtils;

import pe.gob.sunafil.gentrama.bean.Expedientes2014AB;
import pe.gob.sunafil.gentrama.bean.Usuario;
import pe.gob.sunafil.gentrama.funciones.Funciones;
import pe.gob.sunafil.gentrama.mybatis.despachadores.Expedientes2014ABDespatch;
import pe.gob.sunafil.gentrama.utils.FacesUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import gob.sunafil.xlsx.*;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@ManagedBean(name="exp2014abBean")
@SessionScoped
public class Expedientes2014ABBean  implements Serializable {
	
	private static final long serialVersionUID = -2255841932878027343L;

	private static Logger logger = Logger.getLogger(Expedientes2014ABBean.class.getName());
	
	private Expedientes2014ABDespatch despatchExp= new Expedientes2014ABDespatch();
	private Expedientes2014AB exp2014;
	private boolean muestraDialogConfirm;
	private boolean muestraDlgAlertGrabar;
	private String mensajeOK;
	private String letra;
	private String datosActa;
	private UploadedFile file;
	private StreamedContent fileDownload;
	private StreamedContent fileDownloadFr;
	private Boolean uploaded;
	private Boolean converted;
	
	//De TXT a EXCEL
	private UploadedFile fileTxt;
	private Boolean uploadedTxt;
	private Boolean convertedTxt;
	private StreamedContent fileDownloadTxt;
	
	public Boolean getUploadedTxt() {
		return uploadedTxt;
	}

	public void setUploadedTxt(Boolean uploadedTxt) {
		this.uploadedTxt = uploadedTxt;
	}

	public Boolean getConvertedTxt() {
		return convertedTxt;
	}

	public void setConvertedTxt(Boolean convertedTxt) {
		this.convertedTxt = convertedTxt;
	}	
	
	public UploadedFile getFileTxt() {
		return fileTxt;
	}

	public void setFileTxt(UploadedFile fileTxt) {
		this.fileTxt = fileTxt;
	}

	public Boolean getUploaded() {
		return uploaded;
	}

	public void setUploaded(Boolean uploaded) {
		this.uploaded = uploaded;
	}

	public Boolean getConverted() {
		return converted;
	}

	public void setConverted(Boolean converted) {
		this.converted = converted;
	}

	@ManagedProperty("#{loginBean.PGP_Usuario}")
	private Usuario  PGP_Usuario;
	
	/**
	 * Constructor
	 */
	public Expedientes2014ABBean() {
		inicializar();
	}
	
	/**
	 * Metodo para inicializar los valores
	 */
	public void inicializar(){
		exp2014=new Expedientes2014AB();
		muestraDialogConfirm = false;
		muestraDlgAlertGrabar=false;
		mensajeOK="";
		letra="";
		datosActa=null;
	}
	
	
	/**
	 * Metodo que es utilizado para validar los datos ingresados 
	 * @return String mensaje
	 */
	public String mensajesValidacion(Expedientes2014AB exp){
		
		
		String mensajes=null;
        if(exp.getV_numexpsanc()==null || exp.getV_numexpsanc().equals("")){
        	mensajes=Funciones.ObtProp_Resources("regexp.nested.v_numexpsanc");
        }else if(exp.getN_numdepdes()==null || exp.getN_numdepdes().equals("-1")){
        	mensajes=Funciones.ObtProp_Resources("regexp.nested.n_numdepdes");
        }else if(exp.getV_numactinsp()==null || exp.getV_numactinsp().equals("")){
        	mensajes=Funciones.ObtProp_Resources("regexp.nested.v_numactinsp");
        }else if(exp.getV_anhoacta()==null || exp.getV_anhoacta().equals("-1")){
        	mensajes=Funciones.ObtProp_Resources("regexp.nested.v_anhoacta");
        }
        //**********************************************************
		
		System.out.println("Salio en mensajes=>"+mensajes);
		return mensajes;
	}
	
	
	/**
	 * Método con el que se consulta a la Base de Datos por una denuncia.
	 */
	public void registrarExp2014ab(){
		
		logger.info("ENTRA A registrarExp2014ab");
		
		try {
			muestraDlgAlertGrabar=false;
			String mensaje=null;
			mensaje=mensajesValidacion(exp2014);
			if(mensaje==null){
				logger.info("mensajes null entonces consultamos a la BD");
				//************************************************************************
				//INGRESAMOS LA DATA
				//************************************************************************
				System.out.println(exp2014);
				exp2014.setN_numdep(PGP_Usuario.getN_numdep());
				exp2014.setV_codusureg(PGP_Usuario.getV_codusu());
				exp2014.setV_hostreg(PGP_Usuario.getV_hostreg());
				System.out.println("PGP_Usuario.getN_numdep()=>>>>>>"+PGP_Usuario.getN_numdep());
				
				String resultado=despatchExp.registrarExp2014ab(exp2014);
//				String resultado="asasd|OK";
				System.out.println("***********resultVer=>"+resultado);
				
				if(resultado.endsWith("OK")){
					muestraDialogConfirm=true;
					String mensajes[] = StringUtils.split(resultado, "|");
					mensajeOK	= mensajes[0];
				}else{
					String mensajes[] = StringUtils.split(resultado, "|");
					mensaje 	= mensajes[0];
					FacesUtils.showFacesMessage(mensaje, 1);
				}
			
			}else{
				FacesUtils.showFacesMessage(mensaje, 1);				
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	
	public void mostrarDlgAlertGrabar(){
		logger.info("ENTRA A mostrarDlgAlertGrabar");
		try {
			
			muestraDlgAlertGrabar=true;
			String mensaje=null;
			mensaje=mensajesValidacion(exp2014);
			if(mensaje!=null){
				muestraDlgAlertGrabar=false;
				FacesUtils.showFacesMessage(mensaje, 1);				
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	public void numdepdesSelChanged(){
		if(exp2014.getN_numdepdes().equals("465")){
			letra="A";
		}else if(exp2014.getN_numdepdes().equals("466")){
			letra="B";
		}else{
			letra="";
		}
	}
	
	public void obtieneDatosActa(){
		System.out.println("Ingresando a obtieneDatosActa()");
		System.out.println("exp2014.getV_numactinsp()=>"+exp2014.getV_numactinsp());
		System.out.println("exp2014.getV_anhoacta()=>"+exp2014.getV_anhoacta());
		
		if(!"-1".equals(exp2014.getV_anhoacta()) && !"".equals(exp2014.getV_anhoacta()) && null!=exp2014.getV_anhoacta() && !exp2014.getV_numactinsp().trim().equals("")){
			//datosActa="El Acta de Infracción xxx-xxxx tiene la razon social: y ruc:";
			try {
				exp2014.setN_numdep(PGP_Usuario.getN_numdep());
				datosActa=despatchExp.obtDatosActa(exp2014);
				if(datosActa==null || "".equals(datosActa)){
					datosActa="<b>El Acta de Infracción no existe, por favor verificar.</b>";
				}else{
					datosActa="<b>Datos del Acta:</b> "+datosActa;
				}
			}catch(Exception e){
				logger.error(e.getMessage(),e);
			}
		}else{
			datosActa=null;
		}
	}
	
	/**
	 * Metodo que nos lleva a la pagina de ingreso de Expedientes AB 2014 para la SIRE1 y SIRE2
	 * @return vista
	 */
	public String toExpedientesAB(){
		logger.info("Ingresando a la toExpedientesAB");
		
		//VALIDAMOS SI ES DE SUNAFIL ILM
		if(PGP_Usuario.getN_numdep().equals("462")){
			//LIMPIAMOS LA PAGINA:
			inicializar();
			return "pretty:expsancab";
		}else{
			//LIMPIAMOS LA PAGINA:
			String mensaje=Funciones.ObtProp_Resources("regexp.usu.noILM");;
			FacesUtils.showFacesMessage(mensaje, 4);
			return "pretty:inicio";
		}
		
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////
	///ESTA PARTE ES ARA EL REGISTRO NORMAL DEL EXPEDIENTES UNICOS 2014
	/////////////////////////////////////////////////////////////////////////
	public String toExpedientes2014ilm(){
		logger.info("Ingresando a la toExpedientes2014ilm");
		
		//VALIDAMOS SI ES DE SUNAFIL ILM
		if(PGP_Usuario.getN_numdep().equals("462")){
			//LIMPIAMOS LA PAGINA:
			inicializar();
			return "pretty:expsanc2014ilm";
		}else{
			//LIMPIAMOS LA PAGINA:
			String mensaje=Funciones.ObtProp_Resources("regexp.usu.noILM");;
			FacesUtils.showFacesMessage(mensaje, 4);
			return "pretty:inicio";
		}
		
	}
	/**
	 * metodo para grabar los expedientes unicos de la sire 1
	 */
	public void registrarExp2014UnicoIlm(){
		
		logger.info("ENTRA A registrarExp2014UnicoIlm");
		
		try {
			muestraDlgAlertGrabar=false;
			String mensaje=null;
			mensaje=mensajesValidacion(exp2014);
			if(mensaje==null){
				logger.info("mensajes null entonces consultamos a la BD");
				//************************************************************************
				//INGRESAMOS LA DATA
				//************************************************************************
				System.out.println(exp2014);
				exp2014.setN_numdep(PGP_Usuario.getN_numdep());
				exp2014.setV_codusureg(PGP_Usuario.getV_codusu());
				exp2014.setV_hostreg(PGP_Usuario.getV_hostreg());
				System.out.println("PGP_Usuario.getN_numdep()=>>>>>>"+PGP_Usuario.getN_numdep());
				
				String resultado=despatchExp.registrarExp2014UnicoIlm(exp2014);
//				String resultado="asasd|OK";
				System.out.println("***********resultVer=>"+resultado);
				
				if(resultado.endsWith("OK")){
					muestraDialogConfirm=true;
					String mensajes[] = StringUtils.split(resultado, "|");
					mensajeOK	= mensajes[0];
				}else{
					String mensajes[] = StringUtils.split(resultado, "|");
					mensaje 	= mensajes[0];
					FacesUtils.showFacesMessage(mensaje, 1);
				}
			
			}else{
				FacesUtils.showFacesMessage(mensaje, 1);				
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	/**
	 * Metodo que nos lleva a la pagina de Inicio
	 * @return vista
	 */
	public String toInicio(){
		logger.info("Ingresando a la toInicio");
		//LIMPIAMOS LA PAGINA:
		inicializar();
		return "pretty:inicio";
	}
	//***************************************************
	//ZONA DE GETTERS AND SETTERS
	//***************************************************
	
	public Expedientes2014AB getExp2014() {
		return exp2014;
	}

	public void setExp2014(Expedientes2014AB exp2014) {
		this.exp2014 = exp2014;
	}

	public boolean isMuestraDialogConfirm() {
		return muestraDialogConfirm;
	}

	public void setMuestraDialogConfirm(boolean muestraDialogConfirm) {
		this.muestraDialogConfirm = muestraDialogConfirm;
	}

	public String getMensajeOK() {
		return mensajeOK;
	}

	public void setMensajeOK(String mensajeOK) {
		this.mensajeOK = mensajeOK;
	}

	public Usuario getPGP_Usuario() {
		return PGP_Usuario;
	}

	public void setPGP_Usuario(Usuario pGP_Usuario) {
		PGP_Usuario = pGP_Usuario;
	}

	public boolean isMuestraDlgAlertGrabar() {
		return muestraDlgAlertGrabar;
	}

	public void setMuestraDlgAlertGrabar(boolean muestraDlgAlertGrabar) {
		this.muestraDlgAlertGrabar = muestraDlgAlertGrabar;
	}
	
	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getDatosActa() {
		return datosActa;
	}

	public void setDatosActa(String datosActa) {
		this.datosActa = datosActa;
	}
	
	public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public StreamedContent getFileDownload() {
    	export();
        return fileDownload;
    }
    
    public StreamedContent getFileDownloadFr() {
    	exportFr();
        return fileDownloadFr;
    }
    
    public StreamedContent getFileDownloadTxt() {
    	exportTxt();
        return fileDownloadTxt;
    }
    
    public void reset()
    {
    	setUploaded(false);
    	setConverted(false);
    }
    
    public void resetTxt()
    {
    	setUploadedTxt(false);
    	setConvertedTxt(false);
    }
    
    public void convert()
    {
    	System.out.println("begin validator");
        tramaConverterXlsx converter = new tramaConverterXlsx();
        try {
        	tramaConverterXlsx.setCurDate(despatchExp.currentDate());
			System.out.println("fecha actual para conversor ::: "+tramaConverterXlsx.getCurDate());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();			
			tramaConverterXlsx.setCurDate(new Date().toLocaleString());
		}
        converter.Process();
        //System.out.println(validator.getErrorLog());
        FacesMessage message = new FacesMessage("", "Archivo convertido a trama satisfactoriamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);        
        System.out.println("end validator");
        setConverted(true);
    }
    
    public void convertTxt()
    {
    	System.out.println("begin validator");
        tramaConverterTxt converter = new tramaConverterTxt();
        try {
        	tramaConverterTxt.setCurDate(despatchExp.currentDate());
			System.out.println("fecha actual para conversor ::: "+tramaConverterTxt.getCurDate());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();			
			tramaConverterTxt.setCurDate(new Date().toLocaleString());
		}
        converter.Process();
        //System.out.println(validator.getErrorLog());
        FacesMessage message = new FacesMessage("", "Archivo convertido a EXCEL satisfactoriamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);        
        System.out.println("end validator");
        setConvertedTxt(true);
    }
    
    public void export()
    {
    	//InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/txt/temporal_TramaBN_libros.txt");
    	InputStream stream;
		try {
			String rutaTxt=Funciones.ObtProp_Resources("ruta.txt");
			stream = new FileInputStream(rutaTxt+"/temporal_TramaBN_libros.txt");
			//stream = new FileInputStream("D://Willy//fileconverter//code//EPS Exclusions//ExportBN//temporal_TramaBN_libros.txt");	
			String dia=despatchExp.currentDate().replace("/", "-").split("-")[0];
			String mes=despatchExp.currentDate().replace("/", "-").split("-")[1];
			String anio=despatchExp.currentDate().replace("/", "-").split("-")[2].substring(2);
			fileDownload = new DefaultStreamedContent(stream, "text/plain", "PGFA00111"+anio+mes+dia+".ING");
			//fileDownload = new DefaultStreamedContent(stream, "text/plain", "trama_bn"+despatchExp.currentDate().replace("/", "-")+".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
    }
    
    public void exportTxt()
    {
    	//InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/txt/temporal_TramaBN_libros.txt");
    	InputStream stream;
		try {
			String rutaXls=Funciones.ObtProp_Resources("ruta.xls");
			stream = new FileInputStream(rutaXls+"/workbookOut.xlsx");
			//stream = new FileInputStream("D://Willy//fileconverter//code//EPS Exclusions//RewriteBN//workbookOut.xlsx");
			fileDownloadTxt = new DefaultStreamedContent(stream, "application/vnd.ms-excel", "xls_bn"+despatchExp.currentDate().replace("/", "-")+".xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
    }
    
    public void exportFr()
    {
    	InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/txt/temporal_TramaBN_libro4.txt");
        fileDownloadFr = new DefaultStreamedContent(stream, "text/plain", "downloaded_fraccionamiento.txt");
    }
    
    public void validate()
    {    
    	System.out.println("begin validator");
        tramaValidatorXlsx validator = new tramaValidatorXlsx();        
        validator.Process();
        System.out.println(validator.getErrorLog());
        FacesMessage message = new FacesMessage("", validator.getErrorLog());
        FacesContext.getCurrentInstance().addMessage(null, message);
        validator.resetErrorLog();
        System.out.println("end validator");
    }
    
    public void upload() {    	
        if(file != null) {        	
        	if(!file.getFileName().toUpperCase().contains(".XLSX"))
        	{
        		FacesMessage message = new FacesMessage("", "Debe seleccionar un archivo excel con extensión XLSX.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            return;
        	}        	
        	
        	System.out.println("begin upload");
            FacesMessage message = new FacesMessage("", file.getFileName() + " fue subido.");
            //FacesContext.getCurrentInstance().addMessage(null, message);
            InputStream in;
			try {
				in = file.getInputstream();
				String rutaImport=Funciones.ObtProp_Resources("ruta.import");
				File file = new File(rutaImport+"/temporal.xlsx");
				//File file = new File("D://Willy//fileconverter//code//EPS Exclusions//ImportBN//temporal.xlsx");
				OutputStream out = new FileOutputStream(file);
		        byte[] buf = new byte[1024];
		        int len;
		        while((len=in.read(buf))>0){
		            out.write(buf,0,len);
		        }
		        out.close();
		        in.close();
		        System.out.println("end upload");
		        
		        System.out.println("begin validator");
		        tramaValidatorXlsx validator = new tramaValidatorXlsx();        
		        validator.Process();
		        System.out.println(validator.getErrorLog());
		        if(tramaValidatorXlsx.isHayError())
		        {
		        	message = new FacesMessage("", validator.getErrorLog());
			        FacesContext.getCurrentInstance().addMessage(null, message);
			        setUploaded(false);
		        }
		        else
		        {
		        	message = new FacesMessage("", this.file.getFileName() + " fue subido y validado de manera satisfactoria. Usted ya puede generar la trama de envío al BN.");
		        	FacesContext.getCurrentInstance().addMessage(null, message);
		        	setUploaded(true);
		        }
		        validator.resetErrorLog();//resetea la cadena log de errores y flag hayError
		        System.out.println("end validator");		        
		        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = new FacesMessage("", file.getFileName() + " no fue subido, contactar con el administrador.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
			}
            
            
            
        }
        else
        {
        	FacesMessage message = new FacesMessage("", "Seleccione un archivo.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void uploadTxt() {    	
        if(fileTxt != null) {        	
        	if(!fileTxt.getFileName().toUpperCase().contains(".TXT") && !fileTxt.getFileName().toUpperCase().contains(".PAGOS"))
        	{
        		FacesMessage message = new FacesMessage("", "Debe seleccionar un archivo texto con extensión TXT o PAGOS.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            return;
        	}        	
        	
        	System.out.println("begin upload");
            FacesMessage message = new FacesMessage("", fileTxt.getFileName() + " fue subido.");
            //FacesContext.getCurrentInstance().addMessage(null, message);
            InputStream in;
			try {
				in = fileTxt.getInputstream();
				String rutaXls=Funciones.ObtProp_Resources("ruta.xls");
				File file = new File(rutaXls+"/temporal.txt");
				//File file = new File("D://Willy//fileconverter//code//EPS Exclusions//RewriteBN//temporal.txt");
				OutputStream out = new FileOutputStream(file);
		        byte[] buf = new byte[1024];
		        int len;
		        while((len=in.read(buf))>0){
		            out.write(buf,0,len);
		        }
		        out.close();
		        in.close();
		        System.out.println("end upload");
		        
		        System.out.println("begin validator");
		        tramaValidatorTxt validator = new tramaValidatorTxt();        
		        validator.Process();
		        System.out.println(validator.getErrorLog());
		        if(tramaValidatorTxt.isHayError())
		        {
		        	message = new FacesMessage("", validator.getErrorLog());
			        FacesContext.getCurrentInstance().addMessage(null, message);
			        setUploadedTxt(false);
		        }
		        else
		        {
		        	message = new FacesMessage("", this.fileTxt.getFileName() + " fue subido y validado de manera satisfactoria. Usted ya puede generar el archivo EXCEL.");
		        	FacesContext.getCurrentInstance().addMessage(null, message);
		        	setUploadedTxt(true);
		        }
		        validator.resetErrorLog();//resetea la cadena log de errores y flag hayError
		        System.out.println("end validator");		        
		        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = new FacesMessage("", fileTxt.getFileName() + " no fue subido, contactar con el administrador.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
			}
            
            
            
        }
        else
        {
        	FacesMessage message = new FacesMessage("", "Seleccione un archivo.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public static void showFile() throws IOException {
        try {        	
        	InputStream stream = new FileInputStream("D://Willy//fileconverter//code//EPS Exclusions//ExportBN//temporal_TramaBN_libros.txt");        	
        	//InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/txt/temporal_TramaBN_libros.txt");
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.setHeader("Content-Disposition", "inline; filename=\"trama_bn.txt\";");
            response.setHeader("Content-Type", "text/plain");
            ServletOutputStream ouputStream = response.getOutputStream();            
            final byte data[] = new byte[1024];
            int count;
            while ((count = stream.read(data, 0, 1024)) != -1) {
            	ouputStream.write(data, 0, count);
            }
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ouputStream.flush();
            ouputStream.close();
            facesContext.responseComplete();
            facesContext.renderResponse();
        } catch (Exception e) {
            e.printStackTrace();            
        }
    }
    
    public String genTxt(){
    	resetTxt();
		String vista="pretty:inicioTxt";
        //CODIGO
        return  vista;
	}
    
    public String genXlsx(){
    	reset();
		String vista="pretty:inicio";
        //CODIGO
        return  vista;
	}
    
    public void onTabChange(TabChangeEvent event) {
    	reset();
    	resetTxt();
    }

}
