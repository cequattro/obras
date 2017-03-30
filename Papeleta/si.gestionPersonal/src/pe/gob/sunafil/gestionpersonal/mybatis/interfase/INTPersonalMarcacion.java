package pe.gob.sunafil.gestionpersonal.mybatis.interfase;

import java.util.Date;
import java.util.List;

import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcDepenrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;

public interface INTPersonalMarcacion {
	public List <VstMarcacionrrhh> getMarcaciones(VstPersonalrrhh filtro, Date fMarcacionI, Date fMarcacionF) throws Exception;
	public boolean esJefeDeDependenciaLogueada(String dni, Short dependencia) throws Exception;
	public List <TdtbcDependencia> getDependenciaRecursiva(Short nNumdepPadre) throws Exception;
	public TdtbcDependencia getDependencia(Short nNumdep) throws Exception;
	public RhtbcDepenrrhh getDependenciaRRHH() throws Exception;
}
