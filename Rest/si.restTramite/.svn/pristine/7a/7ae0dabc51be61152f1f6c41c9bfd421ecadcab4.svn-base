package com.demo.unitest;

import java.io.Reader;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.math.BigDecimal;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pe.gob.sunafil.tramiteext.persistence.client.SitbTdocideMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcDependenciaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcEntidadMapper;
import pe.gob.sunafil.tramiteext.mybatis.comuntr.MyBatisConnectionFactory;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocide;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocideExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependenciaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad;

public class test3  {
	
	public test3()
	{		
	}
	
	public static void main (String [] args) throws Exception {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		TdtbcEntidad ent= new TdtbcEntidad();
		ent.setvCodentidad("44436285");
		ent.setvCodtipodocid("03");
		ent.setvDesnombre("WILLY CASTRO ALVARADO");
		ent.setvDirentidad("LIMA LINCE");
		ent.setvDescorreoe("");
		ent.setvNomusureg("TRAMITE");
		ent.setdFecreg(new Date());
		ent.setvNomusumod("TRAMITE");
		ent.setdFecmod(new Date());
		ent.setvApepat("CASTRO");
		ent.setvApemat("ALVARADO");
		ent.setvNombres("WILLY");
		TdtbcEntidadMapper mapper = sqlSession.getMapper(TdtbcEntidadMapper.class);		
		try {
			mapper.insert(ent);
			sqlSession.commit();
			System.out.println("Entidad grabada");
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			sqlSession.close();			
		}
				  
	}
			
	}