package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPReporte;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTReporte;

public class ReporteDespatch {
	
	 private static final ReporteDespatch instance = new ReporteDespatch();
	 
	 private INTReporte reporteDAO;
	 private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	 
	 public ReporteDespatch() {
		 reporteDAO = new IMPReporte();
	    }	 
	 
	 public List<Map> reportePersonal(Map parametros) throws Exception
	 {
		 return reporteDAO.reportePersonal(parametros);
	 }
	 
	 public List<Map> reportePersonalIndividual(Map parametros) throws Exception
	 {
		 return reporteDAO.reportePersonalIndividual(parametros);
	 }
	 
	 public List<Map> reporteInasistencia(Map parametros) throws Exception
	 {
		 return reporteDAO.reporteInasistencia(parametros);
	 }
	 
	 public List<Map> reporteTardanza(Map parametros) throws Exception
	 {
		 return reporteDAO.reporteTardanza(parametros);
	 }
	 
	 public String ObtieneFechaDMY() throws Exception
	 {
		 return reporteDAO.ObtieneFechaDMY();
	 }
	 
	 public String getPwdMaster() throws Exception
	 {
		 return reporteDAO.getPwdMaster();
	 }
	 	 
}