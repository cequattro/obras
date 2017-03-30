package pe.gob.sunafil.tramiteext.mybatis.despachadores;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.tramiteext.mybatis.implementacion.IMPConsulta;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTConsulta;
import pe.gob.sunafil.tramiteext.persistence.model.VstConsultastrex;

public class ConsultaDespatch {
	
	private static final ConsultaDespatch instance = new ConsultaDespatch();
	
	private INTConsulta consultaDAO;
	private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	
	public ConsultaDespatch() {
		 consultaDAO = new IMPConsulta();
	    }
	
	public List <VstConsultastrex> getConsulta(String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodtipodocid, String vCodentidad, Short nFlgtrex, String vDesnombre, String vAsuntodetallado, Short nNumdepdest, Short nTipodoc, String vNumdoc, BigDecimal nCodtram, String vCodtupa, Date fechaICargo, Date fechaFCargo, String vCodcorte, String vAnocorte, boolean soloTupa) throws Exception
	{
		return consultaDAO.getConsulta(nNumdep, fechaI, fechaF, vAniohoja, vNumhoja, vCodtipodocid, vCodentidad, nFlgtrex, vDesnombre, vAsuntodetallado, nNumdepdest, nTipodoc, vNumdoc, nCodtram, vCodtupa, fechaICargo, fechaFCargo, vCodcorte, vAnocorte, soloTupa);
	}
	
	public List<Map> reporteTrazabilidad(Map parametros) throws Exception
	{
		return consultaDAO.reporteTrazabilidad(parametros);
	}
	
	public String getHoraCargo(Map parametros) throws Exception
	{
		return consultaDAO.getHoraCargo(parametros);
	}
	
	public String getHoraRegistro(Map parametros) throws Exception
	{
		return consultaDAO.getHoraRegistro(parametros);
	}
	
	public List<Map> reporteTrazabilidadAsociacion(Map parametros) throws Exception
	{
		return consultaDAO.reporteTrazabilidadAsociacion(parametros);
	}
	
	public List<Map> reporteTrazabilidadRegional(Map parametros) throws Exception
	{
		return consultaDAO.reporteTrazabilidadRegional(parametros);
	}

}
