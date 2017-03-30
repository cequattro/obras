package pe.gob.sunafil.postulacioncas.mybatis.implementacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.postulacioncas.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INT2ndScreen;
import pe.gob.sunafil.postulacioncas.persistence.client.RhmvcHvxformacionMapper;
import pe.gob.sunafil.postulacioncas.persistence.client.RhmvcHvxotrdocMapper;
import pe.gob.sunafil.postulacioncas.persistence.client.RhtbcFormacionMapper;
import pe.gob.sunafil.postulacioncas.persistence.client.RhtbcGradoacademiMapper;
import pe.gob.sunafil.postulacioncas.persistence.client.RhtbcTipcapacitacMapper;
import pe.gob.sunafil.postulacioncas.persistence.client.SitbPaisMapper;
import pe.gob.sunafil.postulacioncas.persistence.client.RhmvcHvxcapacitacMapper;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxcapacitac;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxcapacitacExample;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxformacion;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxformacionExample;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxotrdoc;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxotrdocExample;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcFormacion;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcFormacionExample;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcGradoacademi;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcGradoacademiExample;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcTipcapacitac;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcTipcapacitacExample;
import pe.gob.sunafil.postulacioncas.persistence.model.SitbPais;
import pe.gob.sunafil.postulacioncas.persistence.model.SitbPaisExample;


public class IMP2ndScreen implements INT2ndScreen {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMP2ndScreen(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  
	  }			
	
	public List <RhtbcFormacion> getFormaciones() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcFormacionExample example = new RhtbcFormacionExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_desfor");
		try {
			RhtbcFormacionMapper mapper = sqlSession.getMapper (RhtbcFormacionMapper. class);
			List <RhtbcFormacion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getFormaciones "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcGradoacademi> getGradoAcademico() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcGradoacademiExample example = new RhtbcGradoacademiExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_desgraaca");
		try {
			RhtbcGradoacademiMapper mapper = sqlSession.getMapper (RhtbcGradoacademiMapper. class);
			List <RhtbcGradoacademi> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getGradoAcademico "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbPais> getPaises() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbPaisExample example = new SitbPaisExample();
		example.createCriteria().andVCodpaisIsNotNull();
		example.setOrderByClause("v_despais");
		try {
			SitbPaisMapper mapper = sqlSession.getMapper (SitbPaisMapper. class);
			List <SitbPais> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getPaises "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcTipcapacitac> getTiposCapacitacion() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTipcapacitacExample example = new RhtbcTipcapacitacExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_destipcap");
		try {
			RhtbcTipcapacitacMapper mapper = sqlSession.getMapper (RhtbcTipcapacitacMapper. class);
			List <RhtbcTipcapacitac> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTiposCapacitacion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhmvcHvxformacion getCorrelativoMovimientoFormacion() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcHvxformacionExample example = new RhmvcHvxformacionExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhmvcHvxformacionMapper mapper = sqlSession.getMapper (RhmvcHvxformacionMapper. class);
			List <RhmvcHvxformacion> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoMovimientoFormacion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarMovimientoFormacion(RhmvcHvxformacion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcHvxformacionMapper mapper = sqlSession.getMapper(RhmvcHvxformacionMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarMovimientoFormacion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public RhmvcHvxcapacitac getCorrelativoMovimientoCapacitacion() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcHvxcapacitacExample example = new RhmvcHvxcapacitacExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhmvcHvxcapacitacMapper mapper = sqlSession.getMapper (RhmvcHvxcapacitacMapper. class);
			List <RhmvcHvxcapacitac> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoMovimientoCapacitacion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarMovimientoCapacitacion(RhmvcHvxcapacitac entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcHvxcapacitacMapper mapper = sqlSession.getMapper(RhmvcHvxcapacitacMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarMovimientoCapacitacion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public RhmvcHvxotrdoc getCorrelativoOtrosDocumentos() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcHvxotrdocExample example = new RhmvcHvxotrdocExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhmvcHvxotrdocMapper mapper = sqlSession.getMapper (RhmvcHvxotrdocMapper. class);
			List <RhmvcHvxotrdoc> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoOtrosDocumentos "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarOtrosDocumentos(RhmvcHvxotrdoc entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcHvxotrdocMapper mapper = sqlSession.getMapper(RhmvcHvxotrdocMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarOtrosDocumentos "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}

}
