package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPReporteSTemprano;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTReporteSTemprano;

public class ReporteSTempranoDespatch {

 private static final ReporteDespatch instance = new ReporteDespatch();
	 
	 private INTReporteSTemprano reporteSTempranoDAO;
	 private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	 
	 public ReporteSTempranoDespatch() {
		 reporteSTempranoDAO = new IMPReporteSTemprano();
	    }	 
	 
	 public List<Map> reporteSTemprano(Map parametros) throws Exception{
		 return reporteSTempranoDAO.reporteSTemprano(parametros);
	 }
}
