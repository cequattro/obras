package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTPersonalMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcDepenrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTurnoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.TdtbcDependenciaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstMarcacionrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcDepenrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcDepenrrhhExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependenciaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhhExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;

public class IMPPersonalMarcacion implements INTPersonalMarcacion{
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPPersonalMarcacion(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }
	
	public List <VstMarcacionrrhh> getMarcaciones(VstPersonalrrhh filtro, Date fMarcacionI, Date fMarcacionF) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstMarcacionrrhhExample example = new VstMarcacionrrhhExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhhExample.Criteria dinamicCriteria=example.createCriteria();
		dinamicCriteria.andVCodpersonalIsNotNull();
		if(filtro.getvCodtipodocid()!=null && !"".equals(filtro.getvCodtipodocid().trim()))
		{
			dinamicCriteria.andVCodtipodocidEqualTo(filtro.getvCodtipodocid());
		}
		if(filtro.getvCodpersonal()!=null && !"".equals(filtro.getvCodpersonal().trim()))
		{
			dinamicCriteria.andVCodpersonalEqualTo(filtro.getvCodpersonal());
		}
		if(filtro.getnNumint()!=null)
		{
			dinamicCriteria.andNNumintEqualTo(filtro.getnNumint());
		}
		if(filtro.getnNumdep()!=null)
		{
			dinamicCriteria.andNNumdepEqualTo(filtro.getnNumdep());
		}		
		if(filtro.getvCodtipo()!=null && !"".equals(filtro.getvCodtipo().trim()))
		{
			dinamicCriteria.andVCodtipoEqualTo(filtro.getvCodtipo());
		}
		if(fMarcacionI!=null && fMarcacionF!=null)
		{
			dinamicCriteria.andDFechaBetween(fMarcacionI, fMarcacionF);
		}		
		if(filtro.getvDesapepat()!=null && !"".equals(filtro.getvDesapepat().trim()))
		{
			dinamicCriteria.andVDesapepatEqualTo(filtro.getvDesapepat().toUpperCase());
		}
		if(filtro.getvDesapemat()!=null && !"".equals(filtro.getvDesapemat().trim()))
		{
			dinamicCriteria.andVDesapematEqualTo(filtro.getvDesapemat().toUpperCase());
		}
		if(filtro.getvDesnombres()!=null && !"".equals(filtro.getvDesnombres().trim()))
		{
			dinamicCriteria.andVDesnombresEqualTo(filtro.getvDesnombres().toUpperCase());
		}				
		example.or(dinamicCriteria);
		example.setOrderByClause("v_desapepat asc, d_fecha asc, n_hora asc, n_minuto asc, n_segundo asc");
		try {
			VstMarcacionrrhhMapper mapper = sqlSession.getMapper (VstMarcacionrrhhMapper. class);
			List <VstMarcacionrrhh> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getMarcaciones "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean esJefeDeDependenciaLogueada(String dni, Short dependencia) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcDependenciaExample example = new TdtbcDependenciaExample();
		example.createCriteria().andVCodjefeEqualTo(dni).andNNumdepEqualTo(dependencia);
		try {
			TdtbcDependenciaMapper mapper = sqlSession.getMapper (TdtbcDependenciaMapper. class);
			List <TdtbcDependencia> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error esJefeDeDependenciaLogueada "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <TdtbcDependencia> getDependenciaRecursiva(Short nNumdepPadre) throws Exception
	{
		//System.out.println("Current Padre ::: "+nNumdepPadre);
		List <TdtbcDependencia> allRecords;
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcDependenciaExample example = new TdtbcDependenciaExample();
		example.createCriteria().andNFlgactivoEqualTo(new Short("1")).andNNumintIsNotNull().andNNumdepsupEqualTo(nNumdepPadre);		
		example.setOrderByClause("n_numdep asc");
		try {
			TdtbcDependenciaMapper mapper = sqlSession.getMapper (TdtbcDependenciaMapper. class);
			allRecords = mapper.selectByExample(example);			
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDependenciaRecursiva "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public TdtbcDependencia getDependencia(Short nNumdep) throws Exception
	{		
		List <TdtbcDependencia> allRecords;
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcDependenciaExample example = new TdtbcDependenciaExample();
		example.createCriteria().andNFlgactivoEqualTo(new Short("1")).andNNumintIsNotNull().andNNumdepEqualTo(nNumdep);		
		example.setOrderByClause("n_numdep asc");
		try {
			TdtbcDependenciaMapper mapper = sqlSession.getMapper (TdtbcDependenciaMapper. class);
			allRecords = mapper.selectByExample(example);			
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getDependencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhtbcDepenrrhh getDependenciaRRHH() throws Exception
	{		
		List <RhtbcDepenrrhh> allRecords;
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcDepenrrhhExample example = new RhtbcDepenrrhhExample();
		example.createCriteria().andVFlgactEqualTo("S");
		try {
			RhtbcDepenrrhhMapper mapper = sqlSession.getMapper (RhtbcDepenrrhhMapper. class);
			allRecords = mapper.selectByExample(example);			
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error RhtbcDepenrrhh no hay dependencia RRHH definida en el esquema "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
}
