package pe.gob.sunafil.gestionpersonal.mybatis.interfase;

import java.util.List;
import java.util.Map;



public interface INTRptMarcacionUnaPersona {

	List<Map> reporteMarcacionesUnaPersona(Map parametros) throws Exception;

	
	
}
