package pe.gob.sunafil.tramiteext.mybatis.despachadores;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.sunafil.tramiteext.mybatis.implementacion.IMPBandeja;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTBandeja;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex;

public class BandejaDespatch {
	
	private static final BandejaDespatch instance = new BandejaDespatch();
	
	private INTBandeja bandejaDAO;
	private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	
	public BandejaDespatch() {
		 bandejaDAO = new IMPBandeja();
	    }
	
	public List <VstBandejastrex> getBandeja(String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodtipodocid, String vCodentidad, Short nFlgtrex) throws Exception
	{
		return bandejaDAO.getBandeja(nNumdep, fechaI, fechaF, vAniohoja, vNumhoja, vCodtipodocid, vCodentidad, nFlgtrex);
	}
	
	public List <TdtbdReqtupa> getRequisitosPendientes(VstBandejastrex item) throws Exception
	{
		return bandejaDAO.getRequisitosPendientes(item);
	}
	
	public int actualizarArchivo(VstBandejastrex item) throws Exception
	{
		return bandejaDAO.actualizarArchivo(item);
	}
	
	public int actualizarRegistro(TdmvcRegistro registro) throws Exception
	{
		return bandejaDAO.actualizarRegistro(registro);
	}
	
	public TdmvcRegistro getRegistroPorKey(String vNumanoreg, Short nNumdep, Short nNumtipodoc, String vNumreg) throws Exception
	{
		return bandejaDAO.getRegistroPorKey(vNumanoreg, nNumdep, nNumtipodoc, vNumreg);
	}
	
	public int actualizarRequisito(TdmvdRegreqtupa requisito) throws Exception
	{
		return bandejaDAO.actualizarRequisito(requisito);
	}

}
