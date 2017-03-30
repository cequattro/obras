package pe.gob.sunafil.postulacioncas.mybatis.despachadores;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.gob.sunafil.postulacioncas.mybatis.implementacion.IMP3rdScreen;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INT3rdScreen;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcExperiencia;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcReferencia;


public class ThirdScreenDespatch {
	
	private static final ThirdScreenDespatch instance = new ThirdScreenDespatch();
	
	private INT3rdScreen terceraDAO;
	private static Logger logger = Logger.getLogger(LoginDespatch.class.getName());
	
	public ThirdScreenDespatch() {
		terceraDAO = new IMP3rdScreen();
	    }
	
	public RhmvcExperiencia getCorrelativoExperiencia() throws Exception
	{
		return terceraDAO.getCorrelativoExperiencia();
	}
	
	public int insertarExperiencia(RhmvcExperiencia entidad) throws Exception
	{
		return terceraDAO.insertarExperiencia(entidad);
	}
	
	public RhmvcReferencia getCorrelativoReferencia() throws Exception
	{
		return terceraDAO.getCorrelativoReferencia();
	}
	
	public int insertarReferencia(RhmvcReferencia entidad) throws Exception
	{
		return terceraDAO.insertarReferencia(entidad);
	}
	
}
