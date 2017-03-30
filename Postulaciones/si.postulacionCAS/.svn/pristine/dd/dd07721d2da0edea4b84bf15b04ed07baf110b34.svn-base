package pe.gob.sunafil.postulacioncas.mybatis.despachadores;

import java.util.List;
import java.util.Map;

import pe.gob.sunafil.postulacioncas.bean.Reclamo;
import pe.gob.sunafil.postulacioncas.mybatis.implementacion.IMPReporte;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTReporte;

public class ReporteDespatch {
	INTReporte reporteDao;
	
	public ReporteDespatch(){
		reporteDao=new IMPReporte();
	}
	
	
	public List<Map> reporteConstanciaReclamo(Reclamo reclamo) throws Exception {
		return reporteDao.reporteConstanciaReclamo(reclamo);
	}
	
}
