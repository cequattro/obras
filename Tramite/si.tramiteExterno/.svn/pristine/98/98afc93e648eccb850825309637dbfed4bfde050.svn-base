package pe.gob.sunafil.tramiteext.mybatis.despachadores;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.tramiteext.mybatis.implementacion.IMPReporte;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTReporte;

public class ReporteDespatch {
	
	private static final ReporteDespatch instance = new ReporteDespatch();
	
	private INTReporte reporteDAO;
	private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	
	public ReporteDespatch() {
		 reporteDAO = new IMPReporte();
	    }
	
	public List<Map> reporteUsuario(Map parametros) throws Exception
	{
		return reporteDAO.reporteUsuario(parametros);
	}
	
	public List<Map> reporteProcedimiento(Map parametros) throws Exception
	{
		return reporteDAO.reporteProcedimiento(parametros);
	}
	
	public List<Map> reporteConsolidado(Map parametros) throws Exception
	{
		return reporteDAO.reporteConsolidado(parametros);
	}

}
