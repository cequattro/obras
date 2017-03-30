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

import pe.gob.sunafil.denunciavirtual.persistence.client.TdtbcTramiteMapper;
import pe.gob.sunafil.denunciavirtual.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcTramite;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcTramiteExample;

public class testTramite  {
	
	public testTramite()
	{		
	}
	
	public static void main (String [] args) throws Exception {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		  
		TdtbcTramiteExample example = new TdtbcTramiteExample();
		example.createCriteria().andNCodtramIsNotNull();
		//example.setOrderByClause("");//usar para ordenar
		try {
			TdtbcTramiteMapper mapper = sqlSession.getMapper (TdtbcTramiteMapper. class);
			//mapper.updateByExampleSelective(new SitbTdocide(), example);//usar para actualizar solo los campos no nulos enviados en parametro record
		List <TdtbcTramite> allRecords = mapper.selectByExample(example);
		for (TdtbcTramite s: allRecords){
		System.out.println (s.getnCodtram()+" ::: "+s.getvDestram());}
		} finally {
		sqlSession.close ();
		}
		}
			
	}