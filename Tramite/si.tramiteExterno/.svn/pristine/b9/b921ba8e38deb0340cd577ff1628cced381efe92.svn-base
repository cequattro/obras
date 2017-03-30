package pe.gob.sunafil.tramiteext.mybatis.interfase;

import java.util.Date;
import java.util.List;

import pe.gob.sunafil.tramiteext.persistence.model.TdmvcCorte;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex;

public interface INTDistribucion {
	
	public TdmvcCorte getCorrelativoGlobalCorte(String vAnocorte) throws Exception;
	
	public int insertarCorte(TdmvcCorte corte) throws Exception;
	
	public List <VstBandejastrex> getRegistrosCargo(String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodtipodocid, String vCodentidad, Short nFlgtrex, List<Short> destinos) throws Exception;
	
	public int updateRegistrosCargo(TdmvcRegistro entidad, String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodentidad, Short nFlgtrex, List<Short> destinos, List <VstBandejastrex> listaRegistrosCargo) throws Exception;
	
	public List <VstBandejastrex> getRegistrosPorCargo(String vAnocorte, String vCodcorte) throws Exception;
	
	public List <TdmvcCorte> getHistoricoCargo(String nNumdep, Date fechaI, Date fechaF, String vAnocorte, String vCodcorte) throws Exception;
	
	public int actualizarCargo(TdmvcCorte corte) throws Exception;

}
