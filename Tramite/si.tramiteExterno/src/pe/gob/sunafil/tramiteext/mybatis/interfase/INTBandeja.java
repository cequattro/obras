package pe.gob.sunafil.tramiteext.mybatis.interfase;

import java.util.Date;
import java.util.List;

import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex;

public interface INTBandeja {
	
	public List <VstBandejastrex> getBandeja(String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodtipodocid, String vCodentidad, Short nFlgtrex) throws Exception;
	
	public List <TdtbdReqtupa> getRequisitosPendientes(VstBandejastrex item) throws Exception;
	
	public int actualizarArchivo(VstBandejastrex item) throws Exception;
	
	public int actualizarRegistro(TdmvcRegistro registro) throws Exception;
	
	public TdmvcRegistro getRegistroPorKey(String vNumanoreg, Short nNumdep, Short nNumtipodoc, String vNumreg) throws Exception;
	
	public int actualizarRequisito(TdmvdRegreqtupa requisito) throws Exception;

}
