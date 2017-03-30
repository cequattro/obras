package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPMarcacion;
import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPReporteMarcacionesUnaPersona;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTMarcacion;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTRptMarcacionUnaPersona;

public class ReporteMarcacionesUnaPersonaDespatch {

	
	private INTRptMarcacionUnaPersona marcacionDAO;
	 private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	 
	 public ReporteMarcacionesUnaPersonaDespatch() {
		 marcacionDAO = new IMPReporteMarcacionesUnaPersona();
	    }	
	 
	 public List<Map> reporteMarcaciones(Map parametros) throws Exception
	 {
		 return marcacionDAO.reporteMarcacionesUnaPersona(parametros);
	 }
	
}
