package com.demo.unitest;

import java.io.Reader;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.math.BigDecimal;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbTdocideMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.TdtbcDependenciaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocideExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependenciaExample;

public class test2  {
	
	public test2()
	{		
	}
	
	public static void main (String [] args) throws Exception {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		  
		TdtbcDependenciaExample example = new TdtbcDependenciaExample();
		example.createCriteria().andVDesdepLike("SUNAFIL%");
		try {
			TdtbcDependenciaMapper mapper = sqlSession.getMapper (TdtbcDependenciaMapper. class);
			List <TdtbcDependencia> allRecords = mapper.selectByExample(example);	
			
			for (TdtbcDependencia s: allRecords){
				System.out.println (s.getvCoddep()+":::"+s.getvDesdep());}
			
		} catch (Exception e) {
        	System.out.println("Error getAutocompletarDependencia "+e.getMessage());   
        	
        } finally {
        	sqlSession.close ();
		}
		}
			
	}