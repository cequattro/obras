package pe.gob.sunafil.denunciavirtual.mybatis.interfase;

public interface INTWebService {
	
	public String verifySessionWS() throws Exception;
	public void savenewSessionWS(String v_sesion, String v_codsis, String v_flgerror) throws Exception;
	
}
