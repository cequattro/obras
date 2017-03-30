package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPCargos;
import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPTurno;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTCargos;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargo;

public class CargosDespatch {
	private static final CargosDespatch instance = new CargosDespatch();
	 
	 private INTCargos cargosDAO;
	 private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	 
	 public CargosDespatch() {
		 cargosDAO = new IMPCargos();
	    }	 
	 
	 public List <SitbPercargo> getCargos(SitbPercargo filtros) throws Exception
	 {
		 return cargosDAO.getCargos(filtros);
	 }
	 
	 public int insertarCargo(SitbPercargo entidad) throws Exception
	 {
		 return cargosDAO.insertarCargo(entidad);
	 }
	 
	 public SitbPercargo getCorrelativoGlobalCargo() throws Exception{
		 return cargosDAO.getCorrelativoGlobalCargo();
	 }
	 
	 public int actualizarCargo(SitbPercargo entidad) throws Exception{
		 return cargosDAO.actualizarCargo(entidad);
	 }
	 
	 public boolean getTieneCargo(String vDesturno) throws Exception{
		 return cargosDAO.getTieneCargo(vDesturno);
	 }
	 
	 public boolean getTieneCargoRepetidoUpdate(String vDesturno, String nCodturno) throws Exception{
		 return cargosDAO.getTieneCargoRepetidoUpdate(vDesturno, nCodturno);
	 }
	 
	 public boolean getTienePersonalAsignado(SitbPercargo cargo) throws Exception{
		 return cargosDAO.getTienePersonalAsignado(cargo);
	 }
}
