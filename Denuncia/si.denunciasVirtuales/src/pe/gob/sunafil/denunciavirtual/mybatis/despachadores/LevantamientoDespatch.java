package pe.gob.sunafil.denunciavirtual.mybatis.despachadores;

import java.math.BigDecimal;

import pe.gob.sunafil.denunciavirtual.mybatis.implementacion.IMPLevantamiento;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTLevantamiento;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltmvRegistroentrada;


public class LevantamientoDespatch {
private INTLevantamiento levDao;
	
	public LevantamientoDespatch(){
		levDao=new IMPLevantamiento();
	}
	
	public String obtieneNombresTrabajador(String n_codsol) throws Exception {
		return levDao.obtieneNombresTrabajador(n_codsol);
	} 
	
	public int actualizarRegistroEntradaSIIT(IltmvRegistroentrada record, BigDecimal nCodsol) throws Exception{
		return levDao.actualizarRegistroEntradaSIIT(record, nCodsol);
	}
}
