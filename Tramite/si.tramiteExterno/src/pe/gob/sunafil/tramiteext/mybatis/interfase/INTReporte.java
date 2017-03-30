package pe.gob.sunafil.tramiteext.mybatis.interfase;

import java.util.List;
import java.util.Map;

public interface INTReporte {
	
	public List<Map> reporteUsuario(Map parametros) throws Exception;
	
	public List<Map> reporteProcedimiento(Map parametros) throws Exception;
	
	public List<Map> reporteConsolidado(Map parametros) throws Exception;

}
