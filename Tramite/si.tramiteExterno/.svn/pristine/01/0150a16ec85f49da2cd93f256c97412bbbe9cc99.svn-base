package pe.gob.sunafil.tramiteext.mybatis.implementacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.tramiteext.mybatis.comuntr.MyBatisConnectionFactory;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegional;
import pe.gob.sunafil.tramiteext.persistence.client.TdmvdRegxcorteMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcTipodoctramiteMapper;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegxcorte;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTipodoctramite;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTipodoctramiteExample;

public class IMPRegional implements INTRegional {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPRegional(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  
	  }			
	
	public List <TdtbcTipodoctramite> getTipoDocTramiteInterno() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcTipodoctramiteExample example = new TdtbcTipodoctramiteExample();
		example.createCriteria().andNFlgactivoEqualTo(new Short("1"));
		example.setOrderByClause("v_destipodoc");
		try {
			TdtbcTipodoctramiteMapper mapper = sqlSession.getMapper (TdtbcTipodoctramiteMapper. class);
			List <TdtbcTipodoctramite> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoDocTramiteInterno "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int recepcionarRegistroInterno(TdmvdRegxcorte entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdmvdRegxcorteMapper mapper = sqlSession.getMapper(TdmvdRegxcorteMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error recepcionarRegistroInterno"+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int extornarRegistroInterno(TdmvdRegxcorte entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdmvdRegxcorteMapper mapper = sqlSession.getMapper(TdmvdRegxcorteMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error extornarRegistroInterno"+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}

}
