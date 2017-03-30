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

import pe.gob.sunafil.denunciavirtual.siit.persistence.client.IltbcUnidadMapper;
import pe.gob.sunafil.denunciavirtual.mybatis.comunsiit.MyBatisConnectionFactorySiit;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcUnidad;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcUnidadExample;

public class testSiit  {
	
	public testSiit()
	{		
	}
	
	public static void main (String [] args) throws Exception {
		
		SqlSession sqlSession = MyBatisConnectionFactorySiit.getSqlSessionFactory().openSession();
		  
		IltbcUnidadExample example = new IltbcUnidadExample();
		example.createCriteria().andVFlgsunafEqualTo("1").andVFlgsegtraEqualTo("1");
		try {
			IltbcUnidadMapper mapper = sqlSession.getMapper (IltbcUnidadMapper. class);
		List <IltbcUnidad> allRecords = mapper.selectByExample(example);
		for (IltbcUnidad s: allRecords){
		System.out.println (s.getvDescunidad()+" ::: "+s.getvUbigeo().substring(0, 2));}
		} finally {
		sqlSession.close ();
		}
		}
			
	}