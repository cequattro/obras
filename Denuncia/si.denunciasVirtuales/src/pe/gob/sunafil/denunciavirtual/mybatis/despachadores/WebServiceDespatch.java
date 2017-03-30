package pe.gob.sunafil.denunciavirtual.mybatis.despachadores;

import pe.gob.sunafil.denunciavirtual.mybatis.implementacion.IMPWebService;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTWebService;


public class WebServiceDespatch {
	
INTWebService wsDAO;
	
	public WebServiceDespatch(){
		wsDAO=new IMPWebService();
	}
	
	
	public String verifySessionWS() throws Exception{
		return wsDAO.verifySessionWS();
	}
	
	public void savenewSessionWS(String v_sesion, String v_codsis, String v_flgerror) throws Exception{
		wsDAO.savenewSessionWS(v_sesion, v_codsis, v_flgerror);
	}

}
