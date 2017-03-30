package pe.gob.sunafil.postulacioncas.mybatis.implementacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.postulacioncas.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INT3rdScreen;
import pe.gob.sunafil.postulacioncas.persistence.client.RhmvcExperienciaMapper;
import pe.gob.sunafil.postulacioncas.persistence.client.RhmvcReferenciaMapper;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcExperiencia;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcExperienciaExample;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcReferencia;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcReferenciaExample;


public class IMP3rdScreen implements INT3rdScreen {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMP3rdScreen(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  
	  }			
	
	public RhmvcExperiencia getCorrelativoExperiencia() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcExperienciaExample example = new RhmvcExperienciaExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhmvcExperienciaMapper mapper = sqlSession.getMapper (RhmvcExperienciaMapper. class);
			List <RhmvcExperiencia> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoExperiencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarExperiencia(RhmvcExperiencia entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcExperienciaMapper mapper = sqlSession.getMapper(RhmvcExperienciaMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarExperiencia "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public RhmvcReferencia getCorrelativoReferencia() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcReferenciaExample example = new RhmvcReferenciaExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhmvcReferenciaMapper mapper = sqlSession.getMapper (RhmvcReferenciaMapper. class);
			List <RhmvcReferencia> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoReferencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarReferencia(RhmvcReferencia entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcReferenciaMapper mapper = sqlSession.getMapper(RhmvcReferenciaMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarReferencia "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}

}
