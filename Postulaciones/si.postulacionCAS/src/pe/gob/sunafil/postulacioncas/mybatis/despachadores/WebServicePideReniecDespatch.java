package pe.gob.sunafil.postulacioncas.mybatis.despachadores;

import pe.gob.sunafil.postulacioncas.mybatis.implementacion.IMPWebServicePideReniec;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTWebServicePideReniec;

public class WebServicePideReniecDespatch {
	
INTWebServicePideReniec wsDAO;
	
	public WebServicePideReniecDespatch(){
		wsDAO=new IMPWebServicePideReniec();
	}
	
	
	public String verifySessionWS() throws Exception{
		return wsDAO.verifySessionWS();
	}
	
	public void savenewSessionWS(String v_sesion, String v_codsis) throws Exception{
		wsDAO.savenewSessionWS(v_sesion, v_codsis);
	}

}
