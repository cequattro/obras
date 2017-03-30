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

import pe.gob.sunafil.denunciavirtual.persistence.client.SitbTipomonedaMapper;
import pe.gob.sunafil.denunciavirtual.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbTipomoneda;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbTipomonedaExample;

public class test  {
	
	public test()
	{		
	}
	
	public static void main (String [] args) throws Exception {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		  
		SitbTipomonedaExample example = new SitbTipomonedaExample();
		example.createCriteria().andVCodtmonIsNotNull();
		//example.setOrderByClause("");//usar para ordenar
		try {
			SitbTipomonedaMapper mapper = sqlSession.getMapper (SitbTipomonedaMapper. class);
			//mapper.updateByExampleSelective(new SitbTdocide(), example);//usar para actualizar solo los campos no nulos enviados en parametro record
		List <SitbTipomoneda> allRecords = mapper.selectByExample(example);
		for (SitbTipomoneda s: allRecords){
		System.out.println (s.getvCodtmon()+" ::: "+s.getvDestmon()+" ::: "+s.getvAbrtmon());}
		} finally {
		sqlSession.close ();
		}
		}
			
	}