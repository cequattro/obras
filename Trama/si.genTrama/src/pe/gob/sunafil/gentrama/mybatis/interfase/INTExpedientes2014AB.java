package pe.gob.sunafil.gentrama.mybatis.interfase;



import pe.gob.sunafil.gentrama.bean.Expedientes2014AB;


 

public interface INTExpedientes2014AB {
	
	public String registrarExp2014ab(Expedientes2014AB exp) throws Exception;
	public String registrarExp2014UnicoIlm(Expedientes2014AB exp) throws Exception;
	public String obtDatosActa(Expedientes2014AB exp) throws Exception;
	public String currentDate() throws Exception;
	

}
