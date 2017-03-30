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
public interface INTTurnoDia {
	
	public List <RhtbcTurnodia> getTurnosDia(Short nCodturno) throws Exception;
	public int insertarTurnoDia(RhtbcTurnodia entidad) throws Exception;
	public int insertarDetalleTurnoDia(RhtbcTurnodia entidad) throws Exception;
	public RhtbcTurnodia getCorrelativoTurnoDia(Short nCodturno) throws Exception;
	public int eliminarTurnoDia(RhtbcTurnodia entidad) throws Exception;
	public int actualizarTurno(RhtbcTurnodia entidad) throws Exception;
	public boolean getTienePersonalAsignado(RhtbcTurnodia turno) throws Exception;
	public boolean getTieneTurnoDiaRepetidoUpdate(String vDesturno, Short nCodturno, Short nCodturnodia) throws Exception;
	public boolean getTieneTurnoDia(Short codTurno,Short codTurnoDia) throws Exception;
	public RhtbcTurnodia getTurnoDia(Short codTurno, Short codTurnoDia) throws Exception;
}
