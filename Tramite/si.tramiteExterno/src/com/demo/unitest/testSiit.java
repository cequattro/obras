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

import pe.gob.sunafil.tramiteext.siit.persistence.client.VstSiitToTramiteMapper;
import pe.gob.sunafil.tramiteext.mybatis.comunsiit.MyBatisConnectionFactorySiit;
import pe.gob.sunafil.tramiteext.siit.persistence.model.VstSiitToTramite;
import pe.gob.sunafil.tramiteext.siit.persistence.model.VstSiitToTramiteExample;

public class testSiit  {
	
	public testSiit()
	{		
	}
	
	public static void main (String [] args) throws Exception {
		
		SqlSession sqlSession = MyBatisConnectionFactorySiit.getSqlSessionFactory().openSession();
		  
		VstSiitToTramiteExample example = new VstSiitToTramiteExample();
		example.createCriteria().andVNrohrEqualTo("0000040835");
		try {
			VstSiitToTramiteMapper mapper = sqlSession.getMapper (VstSiitToTramiteMapper. class);
		List <VstSiitToTramite> allRecords = mapper.selectByExample(example);
		for (VstSiitToTramite s: allRecords){
		System.out.println (s.getvNrohr()+":::"+s.getvAniohr()+":::"+s.getvNrooic());}
		} finally {
		sqlSession.close ();
		}
		}
			
	}