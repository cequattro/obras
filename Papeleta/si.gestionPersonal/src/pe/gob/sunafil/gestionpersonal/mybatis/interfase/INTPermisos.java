package pe.gob.sunafil.gestionpersonal.mybatis.interfase;


import java.math.BigDecimal;
import java.util.List;

import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPermisos;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvdPermisoxest;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcEstpermiso;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPermisos;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;

public interface INTPermisos {
	
	public String insertarPermiso(RhmvcPermisos entidad) throws Exception;
	public String insertarPermisoXEst(RhmvdPermisoxest entidad) throws Exception;
	public RhmvcPermisos getCorrelativoGlobalPermiso() throws Exception;
	public RhmvdPermisoxest getCorrelativoGlobalPermisoXEst(BigDecimal codPer) throws Exception;
	public List<RhtbcEstpermiso> getEstadoPermiso() throws Exception;
	public List <VstPermisos> getPermisosPersonal(VstPermisos filtro) throws Exception;
	
}
