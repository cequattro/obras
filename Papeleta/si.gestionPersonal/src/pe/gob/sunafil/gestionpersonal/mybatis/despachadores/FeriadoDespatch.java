package pe.gob.sunafil.gestionpersonal.mybatis.despachadores;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.mybatis.implementacion.IMPFeriado;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTFeriado;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcFerxint;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstFeriadorrhh;

public class FeriadoDespatch {
	private static final FeriadoDespatch instance = new FeriadoDespatch();
	 
	 private INTFeriado feriadoDAO;
	 private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	 
	 public FeriadoDespatch() {
		 feriadoDAO = new IMPFeriado();
	    }	 
	 
	 public List<VstFeriadorrhh> getFeriados(RhtbcFerxint filtro, Date fechaDesde, Date fechaHasta) throws Exception
	 {
		 return feriadoDAO.getFeriados(filtro, fechaDesde, fechaHasta);
	 }
	 
	 public int insertarFeriado(RhtbcFerxint entidad) throws Exception
	 {
		 return feriadoDAO.insertarFeriado(entidad);
	 }
	 
	 public int actualizarFeriado(RhtbcFerxint entidad) throws Exception
	 {
		 return feriadoDAO.actualizarFeriado(entidad);
	 }
	 
	 public int eliminarFeriado(RhtbcFerxint entidad) throws Exception
	 {
		 return feriadoDAO.eliminarFeriado(entidad);
	 }
	 
}
