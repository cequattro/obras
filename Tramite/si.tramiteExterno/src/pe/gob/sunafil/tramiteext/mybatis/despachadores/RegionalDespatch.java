package pe.gob.sunafil.tramiteext.mybatis.despachadores;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.tramiteext.mybatis.implementacion.IMPRegional;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegional;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegxcorte;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTipodoctramite;

public class RegionalDespatch {
	
	private static final RegionalDespatch instance = new RegionalDespatch();
	
	private INTRegional regionalDAO;
	private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	
	public RegionalDespatch() {
		regionalDAO = new IMPRegional();
	    }		

	public List <TdtbcTipodoctramite> getTipoDocTramiteInterno() throws Exception
	{
		return regionalDAO.getTipoDocTramiteInterno();
	}
	
	public int recepcionarRegistroInterno(TdmvdRegxcorte entidad) throws Exception
	{
		return regionalDAO.recepcionarRegistroInterno(entidad);
	}
	
	public int extornarRegistroInterno(TdmvdRegxcorte entidad) throws Exception
	{
		return regionalDAO.extornarRegistroInterno(entidad);
	}
}
