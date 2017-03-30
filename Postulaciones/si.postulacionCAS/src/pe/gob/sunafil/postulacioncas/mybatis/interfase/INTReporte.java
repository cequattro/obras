package pe.gob.sunafil.postulacioncas.mybatis.interfase;

import java.util.List;
import java.util.Map;

import pe.gob.sunafil.postulacioncas.bean.Reclamo;

public interface INTReporte {
	
	public List<Map> reporteConstanciaReclamo(Reclamo reclamo) throws Exception;
}
