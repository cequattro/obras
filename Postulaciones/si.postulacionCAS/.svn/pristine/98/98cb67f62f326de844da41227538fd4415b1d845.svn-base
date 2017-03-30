package pe.gob.sunafil.postulacioncas.mybatis.interfase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxcapacitac;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxformacion;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxotrdoc;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcFormacion;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcGradoacademi;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcTipcapacitac;
import pe.gob.sunafil.postulacioncas.persistence.model.SitbPais;



public interface INT2ndScreen {		
	
	public List <RhtbcFormacion> getFormaciones() throws Exception;
	
	public List <RhtbcGradoacademi> getGradoAcademico() throws Exception;
	
	public List <SitbPais> getPaises() throws Exception;
	
	public List <RhtbcTipcapacitac> getTiposCapacitacion() throws Exception;
	
	public RhmvcHvxformacion getCorrelativoMovimientoFormacion() throws Exception;
	
	public int insertarMovimientoFormacion(RhmvcHvxformacion entidad) throws Exception;
	
	public RhmvcHvxcapacitac getCorrelativoMovimientoCapacitacion() throws Exception;
	
	public int insertarMovimientoCapacitacion(RhmvcHvxcapacitac entidad) throws Exception;
	
	public RhmvcHvxotrdoc getCorrelativoOtrosDocumentos() throws Exception;
	
	public int insertarOtrosDocumentos(RhmvcHvxotrdoc entidad) throws Exception;

}
