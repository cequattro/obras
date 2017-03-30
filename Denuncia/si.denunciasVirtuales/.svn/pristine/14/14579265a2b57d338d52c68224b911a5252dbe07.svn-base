package pe.gob.sunafil.denunciavirtual.mybatis.despachadores;

import java.util.List;
import java.util.Map;

import pe.gob.sunafil.denunciavirtual.bean.Solicitud;
import pe.gob.sunafil.denunciavirtual.mybatis.implementacion.IMPReporte;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTReporte;

public class ReporteDespatch {
	INTReporte reporteDao;
	
	public ReporteDespatch(){
		reporteDao=new IMPReporte();
	}
	
	
	public List<Map> reporteConstanciaReclamo(Solicitud solicitud) throws Exception {
		return reporteDao.reporteConstanciaReclamo(solicitud);
	}
	
}
