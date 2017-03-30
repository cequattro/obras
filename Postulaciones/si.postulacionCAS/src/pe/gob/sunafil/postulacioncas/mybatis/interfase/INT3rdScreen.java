package pe.gob.sunafil.postulacioncas.mybatis.interfase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcExperiencia;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxcapacitac;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxformacion;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxotrdoc;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcReferencia;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcFormacion;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcGradoacademi;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcTipcapacitac;
import pe.gob.sunafil.postulacioncas.persistence.model.SitbPais;



public interface INT3rdScreen {
	
	public RhmvcExperiencia getCorrelativoExperiencia() throws Exception;
	
	public int insertarExperiencia(RhmvcExperiencia entidad) throws Exception;
	
	public RhmvcReferencia getCorrelativoReferencia() throws Exception;
	
	public int insertarReferencia(RhmvcReferencia entidad) throws Exception;

}
