package pe.gob.sunafil.postulacioncas.mybatis.despachadores;

import java.io.Serializable;

import org.apache.log4j.Logger;

import pe.gob.sunafil.postulacioncas.bean.DomicilioEntidad;
import pe.gob.sunafil.postulacioncas.bean.Entidad;
import pe.gob.sunafil.postulacioncas.bean.Reclamo;
import pe.gob.sunafil.postulacioncas.mybatis.implementacion.IMPReclamo;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTReclamo;

public class ReclamoDespatch implements Serializable{
	
	private static final long serialVersionUID = 5587223809983137349L;

	private static Logger logger = Logger.getLogger(CombosDespatch.class.getName());
	
	private INTReclamo reclamoDAO;
	
	public ReclamoDespatch(){
		reclamoDAO=new IMPReclamo();
	}
	
	public String insertarReclamo(Reclamo reclamo,Entidad entidad,DomicilioEntidad domEntidad,String[] selectedTiposIdentifDeReclamo,String v_desotrtir) throws Exception {
		return reclamoDAO.insertarReclamo(reclamo,entidad,domEntidad, selectedTiposIdentifDeReclamo,v_desotrtir);
	}
}
