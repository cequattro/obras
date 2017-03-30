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

import pe.gob.sunafil.tramiteext.persistence.client.SitbTdocideMapper;
import pe.gob.sunafil.tramiteext.mybatis.comuntr.MyBatisConnectionFactory;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocide;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocideExample;

public class test  {
	
	public test()
	{		
	}
	
	public static void main (String [] args) throws Exception {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		  
		SitbTdocideExample example = new SitbTdocideExample();
		example.createCriteria().andDescripcionIsNotNull().andNFlgmpEqualTo(new BigDecimal(1));
		//example.setOrderByClause("");//usar para ordenar
		try {
			SitbTdocideMapper mapper = sqlSession.getMapper (SitbTdocideMapper. class);
			//mapper.updateByExampleSelective(new SitbTdocide(), example);//usar para actualizar solo los campos no nulos enviados en parametro record
		List <SitbTdocide> allRecords = mapper.selectByExample(example);
		for (SitbTdocide s: allRecords){
		System.out.println (s.getId()+":::"+s.getDescripcion());}
		} finally {
		sqlSession.close ();
		}
		}
			
	}