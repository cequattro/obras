package pe.gob.sunafil.postulacioncas.mybatis.interfase;



import java.util.List;
import java.util.Map;

import pe.gob.sunafil.postulacioncas.bean.Combo;
import pe.gob.sunafil.postulacioncas.bean.ParamConsultaSIIT;


 

public interface INTConsultaSIIT {
	
	
	public List<Map> obtListaConsultaSIIT(ParamConsultaSIIT parametro) throws Exception;
	public String verificarRMP(ParamConsultaSIIT parametro) throws Exception;
	public List<Map> obtMateriasAsigXOI(String numorden,String anioorden,String numdeporden) throws Exception;
	public List<Map> obtListaEtapaSancionadora(String numorden,String anioorden,String numdeporden) throws Exception;
	public List<Combo> listaAnhos() throws Exception;
	

}
