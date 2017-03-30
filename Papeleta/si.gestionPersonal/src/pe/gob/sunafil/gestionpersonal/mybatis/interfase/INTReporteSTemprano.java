package pe.gob.sunafil.gestionpersonal.mybatis.interfase;

import java.util.List;
import java.util.Map;

public interface INTReporteSTemprano {
	public List<Map> reporteSTemprano(Map parametros) throws Exception;
}
