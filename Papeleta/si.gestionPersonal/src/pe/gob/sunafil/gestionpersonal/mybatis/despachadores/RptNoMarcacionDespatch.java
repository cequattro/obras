package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPRptNoMarcacion;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTRptNoMarcacion;

public class RptNoMarcacionDespatch {

 private static final ReporteDespatch instance = new ReporteDespatch();
	 
	 private INTRptNoMarcacion reporteNMDAO;
	 private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	 
	 public RptNoMarcacionDespatch() {
		 reporteNMDAO = new IMPRptNoMarcacion();
	    }	 
	 
	 public List<Map> reporteNoMarcacion(Map parametros) throws Exception{
		 return reporteNMDAO.reporteNoMarcacion(parametros);
	 }
}
