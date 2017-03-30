package pe.gob.sunafil.tramiteext.mybatis.despachadores;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.sunafil.tramiteext.mybatis.implementacion.IMPDistribucion;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTDistribucion;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcCorte;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex;

public class DistribucionDespatch {
	
	private static final DistribucionDespatch instance = new DistribucionDespatch();
	
	private INTDistribucion distribucionDAO;
	private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	
	public DistribucionDespatch() {
		 distribucionDAO = new IMPDistribucion();
	    }
	
	public TdmvcCorte getCorrelativoGlobalCorte(String vAnocorte) throws Exception
	{
		return distribucionDAO.getCorrelativoGlobalCorte(vAnocorte);
	}
	
	public int insertarCorte(TdmvcCorte corte) throws Exception
	{
		return distribucionDAO.insertarCorte(corte);
	}
	
	public List <VstBandejastrex> getRegistrosCargo(String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodtipodocid, String vCodentidad, Short nFlgtrex, List<Short> destinos) throws Exception
	{
		return distribucionDAO.getRegistrosCargo(nNumdep, fechaI, fechaF, vAniohoja, vNumhoja, vCodtipodocid, vCodentidad, nFlgtrex, destinos);
	}
	
	public int updateRegistrosCargo(TdmvcRegistro entidad, String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodentidad, Short nFlgtrex, List<Short> destinos, List <VstBandejastrex> listaRegistrosCargo) throws Exception
	{
		return distribucionDAO.updateRegistrosCargo(entidad, nNumdep, fechaI, fechaF, vAniohoja, vNumhoja, vCodentidad, nFlgtrex, destinos, listaRegistrosCargo);
	}
	
	public List <VstBandejastrex> getRegistrosPorCargo(String vAnocorte, String vCodcorte) throws Exception
	{
		return distribucionDAO.getRegistrosPorCargo(vAnocorte, vCodcorte);
	}
	
	public List <TdmvcCorte> getHistoricoCargo(String nNumdep, Date fechaI, Date fechaF, String vAnocorte, String vCodcorte) throws Exception
	{
		return distribucionDAO.getHistoricoCargo(nNumdep, fechaI, fechaF, vAnocorte, vCodcorte);
	}
	
	public int actualizarCargo(TdmvcCorte corte) throws Exception
	{
		return distribucionDAO.actualizarCargo(corte);
	}

}
