package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;


import java.math.BigDecimal;
import java.util.List;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPPermisos;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTPermisos;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPermisos;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvdPermisoxest;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcEstpermiso;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPermisos;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;


public class PermisosDespatch {
	
	private INTPermisos permisoDao;
	
	public PermisosDespatch(){
		permisoDao=new IMPPermisos();
	}
	public String insertarPermiso(RhmvcPermisos permiso) throws Exception {
		return permisoDao.insertarPermiso(permiso);
	}
	public String insertarPermisoXEst(RhmvdPermisoxest permiso) throws Exception {
		return permisoDao.insertarPermisoXEst(permiso);
	}
	public RhmvcPermisos getCorrelativoGlobalPermiso() throws Exception{
		 return permisoDao.getCorrelativoGlobalPermiso();
	}
	
	public RhmvdPermisoxest getCorrelativoGlobalPermisoXEst(BigDecimal codPer) throws Exception{
		 return permisoDao.getCorrelativoGlobalPermisoXEst(codPer);
	}
	
	public List <RhtbcEstpermiso> getEstadoPermiso() throws Exception
	{
		 return permisoDao.getEstadoPermiso();
	}
	
	 public List <VstPermisos> getPermisosPersonal(VstPermisos filtro) throws Exception
	 {
		 return permisoDao.getPermisosPersonal(filtro);
	 }
}
