package pe.gob.sunafil.gestionpersonal.mybatis.interfase;

import java.util.List;

import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargo;


public interface INTCargos {
	public List <SitbPercargo> getCargos(SitbPercargo filtros) throws Exception;	
	public int insertarCargo(SitbPercargo entidad) throws Exception;
	public SitbPercargo getCorrelativoGlobalCargo() throws Exception;
	public int actualizarCargo(SitbPercargo entidad) throws Exception;
	public boolean getTieneCargo(String vDescargo) throws Exception;
	public boolean getTieneCargoRepetidoUpdate(String vDescargo, String nCodcargo) throws Exception;
	public boolean getTienePersonalAsignado(SitbPercargo turno) throws Exception;
}
