package pe.gob.sunafil.postulacioncas.mybatis.despachadores;



import java.util.List;
import java.util.Map;

import pe.gob.sunafil.postulacioncas.bean.Combo;
import pe.gob.sunafil.postulacioncas.bean.ParamConsultaSIIT;
import pe.gob.sunafil.postulacioncas.mybatis.implementacion.IMPConsultaSIIT;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTConsultaSIIT;


public class ConsultaSIITDespatch {

	private INTConsultaSIIT consultaSIITDao;
	
	public  ConsultaSIITDespatch(){
		consultaSIITDao=new IMPConsultaSIIT();
	}	
	
	public List<Map>  obtListaConsultaSIIT(ParamConsultaSIIT parametro) throws Exception {
		return consultaSIITDao.obtListaConsultaSIIT(parametro);
	}
	public String  verificarRMP(ParamConsultaSIIT parametro) throws Exception {
		return consultaSIITDao.verificarRMP(parametro);
	}
	public List<Map>  obtMateriasAsigXOI(String numorden,String anioorden,String numdeporden) throws Exception {
		return consultaSIITDao.obtMateriasAsigXOI(numorden,anioorden,numdeporden);
	}
	public List<Map>  obtListaEtapaSancionadora(String numorden,String anioorden,String numdeporden) throws Exception {
		return consultaSIITDao.obtListaEtapaSancionadora(numorden,anioorden,numdeporden);
	}
	public List<Combo> listaAnhos() throws Exception {
		return consultaSIITDao.listaAnhos();
	}
	
}
