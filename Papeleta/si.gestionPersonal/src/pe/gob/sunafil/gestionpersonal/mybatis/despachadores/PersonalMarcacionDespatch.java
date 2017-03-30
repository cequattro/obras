package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPMarcacion;
import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPPersonalMarcacion;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTPersonalMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcDepenrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;

public class PersonalMarcacionDespatch {

	 private static final PersonalMarcacionDespatch instance = new PersonalMarcacionDespatch();

	 private INTPersonalMarcacion personalMarcacionDAO;
	 private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	 
	 public PersonalMarcacionDespatch() {
		 personalMarcacionDAO = new IMPPersonalMarcacion();
	    }	
	 
	 public List <VstMarcacionrrhh> getMarcaciones(VstPersonalrrhh filtro, Date fMarcacionI, Date fMarcacionF) throws Exception
	 {
		 return personalMarcacionDAO.getMarcaciones(filtro, fMarcacionI, fMarcacionF);
	 }
	 
	 public boolean esJefeDeDependenciaLogueada(String dni, Short dependencia) throws Exception
	 {
		 return personalMarcacionDAO.esJefeDeDependenciaLogueada(dni, dependencia);
	 }
	 
	 public List <TdtbcDependencia> getDependenciaRecursiva(Short nNumdepPadre) throws Exception
	 {
		 return personalMarcacionDAO.getDependenciaRecursiva(nNumdepPadre);
	 }
	 
	 public TdtbcDependencia getDependencia(Short nNumdep) throws Exception
	 {
		 return personalMarcacionDAO.getDependencia(nNumdep);
	 }
	 
	 public RhtbcDepenrrhh getDependenciaRRHH() throws Exception
	 {
		 return personalMarcacionDAO.getDependenciaRRHH();
	 }
}
