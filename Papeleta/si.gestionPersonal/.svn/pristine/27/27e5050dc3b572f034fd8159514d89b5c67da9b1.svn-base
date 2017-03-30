package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPReporteErrores;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTRptErrores;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErrorescabrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErroresrrhh;

public class ReporteErroresDespatch {
	private static final ReporteErroresDespatch instance = new ReporteErroresDespatch();

	 private INTRptErrores reporteErroresDAO;
	 private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	 
	 public ReporteErroresDespatch() {
		 reporteErroresDAO = new IMPReporteErrores();
	    }	
	 public List<VstErroresrrhh> getErrores(VstErroresrrhh filtro) throws Exception
	 {
		 return reporteErroresDAO.getErrores(filtro);
	 }
	 
	 public List<Map> reporteErrores(Map parametros) throws Exception
	 {
		 return reporteErroresDAO.reporteErrores(parametros);
	 }
	 
	 public List<VstErrorescabrrhh> getErroresCab(Date fRegistroI, Date fRegistroF) throws Exception
	 {
		 return reporteErroresDAO.getErroresCab(fRegistroI, fRegistroF);
	 }
	 
}
