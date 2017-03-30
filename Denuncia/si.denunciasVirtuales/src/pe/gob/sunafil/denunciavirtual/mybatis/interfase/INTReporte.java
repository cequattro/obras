package pe.gob.sunafil.denunciavirtual.mybatis.interfase;

import java.util.List;
import java.util.Map;

import pe.gob.sunafil.denunciavirtual.bean.Solicitud;

public interface INTReporte {
	
	public List<Map> reporteConstanciaReclamo(Solicitud solicitud) throws Exception;
}
