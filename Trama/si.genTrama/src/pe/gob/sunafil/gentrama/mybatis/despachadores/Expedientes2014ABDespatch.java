package pe.gob.sunafil.gentrama.mybatis.despachadores;



import pe.gob.sunafil.gentrama.bean.Expedientes2014AB;
import pe.gob.sunafil.gentrama.mybatis.implementacion.IMPExpedientes2014AB;
import pe.gob.sunafil.gentrama.mybatis.interfase.INTExpedientes2014AB;


public class Expedientes2014ABDespatch {

	private INTExpedientes2014AB exp2014abDao;
	
	public  Expedientes2014ABDespatch(){
		exp2014abDao=new IMPExpedientes2014AB();
	}	
	
	public String  registrarExp2014ab(Expedientes2014AB exp) throws Exception {
		return exp2014abDao.registrarExp2014ab(exp);
	}
	public String  registrarExp2014UnicoIlm(Expedientes2014AB exp) throws Exception {
		return exp2014abDao.registrarExp2014UnicoIlm(exp);
	}
	public String  obtDatosActa(Expedientes2014AB exp) throws Exception {
		return exp2014abDao.obtDatosActa(exp);
	}
	
	public String currentDate() throws Exception
	{
		return exp2014abDao.currentDate();
	}
}
