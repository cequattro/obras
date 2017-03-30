package pe.gob.sunafil.tramiteext.mybatis.interfase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pe.gob.sunafil.tramiteext.persistence.model.VstConsultastrex;

public interface INTConsulta {
	
	public List <VstConsultastrex> getConsulta(String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodtipodocid, String vCodentidad, Short nFlgtrex, String vDesnombre, String vAsuntodetallado, Short nNumdepdest, Short nTipodoc, String vNumdoc, BigDecimal nCodtram, String vCodtupa, Date fechaICargo, Date fechaFCargo, String vCodcorte, String vAnocorte, boolean soloTupa) throws Exception;
	
	public List<Map> reporteTrazabilidad(Map parametros) throws Exception;
	
	public String getHoraCargo(Map parametros) throws Exception;
	
	public String getHoraRegistro(Map parametros) throws Exception;
	
	public List<Map> reporteTrazabilidadAsociacion(Map parametros) throws Exception;
	
	public List<Map> reporteTrazabilidadRegional(Map parametros) throws Exception;

}
