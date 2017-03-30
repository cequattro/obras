package pe.gob.sunafil.gestionpersonal.mybatis.interfase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcTipopers;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodia;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEscalaremun;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargo;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDetpersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTurnopersonalrrhh;

public interface INTTurno {

	public List <RhtbcTurno> getTurnos(RhtbcTurno filtros) throws Exception;	
	public int insertarTurno(RhtbcTurno entidad) throws Exception;
	public RhtbcTurno getCorrelativoGlobalTurno() throws Exception;
	public int actualizarTurno(RhtbcTurno entidad) throws Exception;
	public int eliminarTurno(RhtbcTurno entidad) throws Exception;
	public int eliminarTurnoDia(RhtbcTurno entidad) throws Exception;
	public boolean getTieneTurno(String vDesturno) throws Exception;
	public boolean getTieneTurnoRepetidoUpdate(String vDesturno, Short nCodturno) throws Exception;
	public boolean getTienePersonalAsignado(RhtbcTurno turno) throws Exception;
}