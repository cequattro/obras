package pe.gob.sunafil.tramiteext.mybatis.implementacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.tramiteext.mybatis.comuntr.MyBatisConnectionFactory;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTConsulta;
import pe.gob.sunafil.tramiteext.persistence.client.VstConsultastrexMapper;
import pe.gob.sunafil.tramiteext.persistence.model.VstConsultastrexExample.Criteria;
import pe.gob.sunafil.tramiteext.persistence.model.VstConsultastrex;
import pe.gob.sunafil.tramiteext.persistence.model.VstConsultastrexExample;

public class IMPConsulta implements INTConsulta {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPConsulta(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  
	  }
	
	public List <VstConsultastrex> getConsulta(String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodtipodocid, String vCodentidad, Short nFlgtrex, String vDesnombre, String vAsuntodetallado, Short nNumdepdest, Short nTipodoc, String vNumdoc, BigDecimal nCodtram, String vCodtupa, Date fechaICargo, Date fechaFCargo, String vCodcorte, String vAnocorte, boolean soloTupa) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstConsultastrexExample example = new VstConsultastrexExample();
		Criteria dinamicCriteria=example.createCriteria();	
		if(vCodcorte!=null && !"".equals(vCodcorte.trim()) && vAnocorte!=null && !"".equals(vAnocorte.trim()))
		{
			System.out.println("Consulta por cargo");
		}	
		else
		{
			dinamicCriteria.andNNumdepEqualTo(new Short(nNumdep));//.andNNumtipodocEqualTo(new Short("0"));
		}
		if(nFlgtrex!=null)
		{
			dinamicCriteria.andNFlgtrexEqualTo(nFlgtrex);
		}
		if(fechaI!=null && fechaF!=null)
		{
			dinamicCriteria.andDFecregBetween(fechaI, fechaF);
		}
		if(vAniohoja!=null)
		{
			dinamicCriteria.andVAniohojaEqualTo(vAniohoja);
		}
		if(vNumhoja!=null && !"".equals(vNumhoja.trim()))
		{
			dinamicCriteria.andVNumhojaEqualTo(vNumhoja);
		}
		if(vCodtipodocid!=null && !"".equals(vCodtipodocid.trim()))
		{
			dinamicCriteria.andVCodtipodocidEqualTo(vCodtipodocid);
		}
		if(vCodentidad!=null && !"".equals(vCodentidad.trim()))
		{
			dinamicCriteria.andVCodentidadEqualTo(vCodentidad);
		}
		if(vDesnombre!=null && !"".equals(vDesnombre.trim()))
		{
			dinamicCriteria.andVDesnombreLike("%"+vDesnombre+"%");
		}
		if(vAsuntodetallado!=null && !"".equals(vAsuntodetallado.trim()))
		{
			dinamicCriteria.andVAsuntodetalladoLike("%"+vAsuntodetallado+"%");
		}
		if(nNumdepdest!=null)
		{
			dinamicCriteria.andNNumdepdestEqualTo(nNumdepdest);
		}
		if(nTipodoc!=null)
		{
			dinamicCriteria.andNTipodocEqualTo(nTipodoc);
		}
		if(vNumdoc!=null && !"".equals(vNumdoc.trim()))
		{
			dinamicCriteria.andVNumdocEqualTo(vNumdoc);
		}
		if(nCodtram!=null)
		{
			dinamicCriteria.andNCodtramEqualTo(nCodtram);
		}
		if(vCodtupa!=null && !"".equals(vCodtupa.trim()))
		{
			dinamicCriteria.andVCodtupaEqualTo(vCodtupa);
		}
		if(fechaICargo!=null && fechaFCargo!=null)
		{
			dinamicCriteria.andDFeccorteBetween(fechaICargo, fechaFCargo);
		}
		if(vCodcorte!=null && !"".equals(vCodcorte.trim()))
		{
			dinamicCriteria.andVCodcorteEqualTo(vCodcorte);
		}
		if(vAnocorte!=null && !"".equals(vAnocorte.trim()))
		{
			dinamicCriteria.andVAnocorteEqualTo(vAnocorte);
		}
		if(soloTupa)
		{
			dinamicCriteria.andVCodtupaIsNotNull();
		}
		example.or(dinamicCriteria);
		//example.createCriteria().andNNumdepEqualTo(new Short(nNumdep)).andNNumtipodocEqualTo(new Short("0")).andDFecregBetween(fechaI, fechaF).andVAniohojaEqualTo(vAniohoja).andVNumhojaEqualTo(vNumhoja).andVCodtipodocidEqualTo(vCodtipodocid).andVCodentidadEqualTo(vCodentidad);		
		try {
			VstConsultastrexMapper mapper = sqlSession.getMapper (VstConsultastrexMapper. class);
			List <VstConsultastrex> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getConsulta "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List<Map> reporteTrazabilidad(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Trazabilidad.reporteTrazabilidad", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteTrazabilidad "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	public String getHoraCargo(Map parametros) throws Exception 
	{	
		String resultado="";			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=(String)session.selectOne("Trazabilidad.obtieneHoraCargo", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error getHoraCargo "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	public String getHoraRegistro(Map parametros) throws Exception 
	{	
		String resultado="";			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=(String)session.selectOne("Trazabilidad.obtieneHoraRegistro", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error getHoraRegistro "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	public List<Map> reporteTrazabilidadAsociacion(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Trazabilidad.reporteTrazabilidadAsociacion", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteTrazabilidadAsociacion "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	public List<Map> reporteTrazabilidadRegional(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Trazabilidad.reporteTrazabilidadRegional", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteTrazabilidadRegional "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}

}
