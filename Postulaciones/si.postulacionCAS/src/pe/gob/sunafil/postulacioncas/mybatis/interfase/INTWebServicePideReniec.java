package pe.gob.sunafil.postulacioncas.mybatis.interfase;

public interface INTWebServicePideReniec {
	
	public String verifySessionWS() throws Exception;
	public void savenewSessionWS(String v_sesion, String v_codsis) throws Exception;
	
}