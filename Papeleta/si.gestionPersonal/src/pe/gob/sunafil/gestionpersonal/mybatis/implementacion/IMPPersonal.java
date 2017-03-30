package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.client.PrtbcPersonalMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.PrtbcTipopersMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhmvcMarcacionMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhmvcPerturnoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcCargosindicaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcClascarMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcResolucionMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcSindicatoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTiporesolMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTurnoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTurnodiaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdDependientesMapper;
//import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdDestaqueMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdPerdireccionMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdPersonalMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdPerxentfinancieraMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdPerxprofesionMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdPerxregpensionarioMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdPerxseguroMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdPerxsindicatoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbDistritoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbEntfinancieraMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbEscalaremunMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbEstadocivilMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbPercargoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbProfesionMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbRegpensionarioMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbSeguroMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbTdocideMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbTipviaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbVinculfamiliMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbZonaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.TdtbcDependenciaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstDependientesMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstDetpersonalrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstDireccionesMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstEntfinancieraMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstPersonalrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstProfesionMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstRegpensionarioMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstResolucionMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstSeguroMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstSindicatoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstTiporesolucionMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstTurnopersonalrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonalExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonalExample.Criterion;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcTipopers;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcTipopersExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcMarcacionExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturnoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcCargosindica;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcCargosindicaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcClascar;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcClascarExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcResolucion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcResolucionExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcSindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcSindicatoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTiporesol;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTiporesolExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodia;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodiaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdDependientes;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdDependientesExample;
//import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdDestaque;
//import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdDestaqueExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerdireccion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerdireccionExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPersonalExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxentfinanciera;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxentfinancieraExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxprofesion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxprofesionExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxregpensionario;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxregpensionarioExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxseguro;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxseguroExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxsindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxsindicatoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbDistrito;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbDistritoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEntfinanciera;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEntfinancieraExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEscalaremun;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEscalaremunExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEstadocivil;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEstadocivilExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargo;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbProfesion;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbProfesionExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbRegpensionario;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbRegpensionarioExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbSeguro;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbSeguroExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocideExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTipvia;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTipviaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbVinculfamili;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbVinculfamiliExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbZona;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbZonaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependenciaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDependientes;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDependientesExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDetpersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDetpersonalrrhhExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDirecciones;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDireccionesExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstEntfinanciera;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstEntfinancieraExample;
//import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonalExample.Criteria;
//import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhhExample.Criteria;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhhExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstProfesion;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstProfesionExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstRegpensionario;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstRegpensionarioExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstResolucion;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstResolucionExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstSeguro;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstSeguroExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstSindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstSindicatoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTiporesolucion;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTiporesolucionExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTurnopersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTurnopersonalrrhhExample;
import pe.gob.sunafil.gestionpersonal.persistence.client.TdtbcIntendenciaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcIntendenciaExample;

public class IMPPersonal implements INTPersonal {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPPersonal(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }
		
	/*
	 * Recupera el autocompletado por dependencia e intendencia
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getAutocompletarDependenciaEIntendencia(java.lang.String, java.lang.String)
	 */
	public List <TdtbcDependencia> getAutocompletarDependenciaEIntendencia(String query, String nNumint) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcDependenciaExample example = new TdtbcDependenciaExample();
		if("-1".equals(nNumint))
		{
			example.createCriteria().andNFlgactivoEqualTo(new Short("1")).andVFlgmtpeEqualTo("S").andVDesdepLike("%"+query.toUpperCase()+"%");
		}
		else
		{
			example.createCriteria().andNFlgactivoEqualTo(new Short("1")).andVDesdepLike("SUNAFIL%").andNNumintEqualTo(new BigDecimal(nNumint)).andVDesdepLike("%"+query.toUpperCase()+"%");
		}		
		try {
			TdtbcDependenciaMapper mapper = sqlSession.getMapper (TdtbcDependenciaMapper. class);
			List <TdtbcDependencia> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getAutocompletarDependenciaEIntendencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}	
	
	public List<PrtbcPersonal> getAutoCompletarPersonal(String query) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PrtbcPersonalExample example= new PrtbcPersonalExample();
		example.or().andVDesnombresLike("%"+query.toUpperCase()+"%");
		example.or().andVDesapepatLike("%"+query.toUpperCase()+"%");
		example.or().andVDesapematLike("%"+query.toUpperCase()+"%");
		//.andVDesnombresLike("%"+query.toUpperCase()+"%");
		//.andVDesapepatLike("%"+query.toUpperCase()+"%");
		//.andVDesapematLike("%"+query.toUpperCase()+"%");
		try {
			PrtbcPersonalMapper mapper = sqlSession.getMapper (PrtbcPersonalMapper. class);
			List <PrtbcPersonal> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getAutocompletarPersonal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
		//example.createCriteria().andv
	}
	public List <SitbTdocide> getTipoDocRemitente() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbTdocideExample example = new SitbTdocideExample();
		example.createCriteria().andDescripcionIsNotNull().andNFlgmpEqualTo(new BigDecimal(1)).andIdNotEqualTo("09");
		try {
			SitbTdocideMapper mapper = sqlSession.getMapper (SitbTdocideMapper. class);
			List <SitbTdocide> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoDocRemitente "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <PrtbcPersonal> getPersonal(PrtbcPersonal filtro) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		PrtbcPersonalExample example = new PrtbcPersonalExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonalExample.Criteria dinamicCriteria=example.createCriteria();
		dinamicCriteria.andVCodpersonalIsNotNull();
		if(filtro.getvCodtipodocid()!=null && !"".equals(filtro.getvCodtipodocid().trim()))
		{
			dinamicCriteria.andVCodtipodocidEqualTo(filtro.getvCodtipodocid());
		}
		if(filtro.getvCodpersonal()!=null && !"".equals(filtro.getvCodpersonal().trim()))
		{
			dinamicCriteria.andVCodpersonalEqualTo(filtro.getvCodpersonal());
		}
		if(filtro.getnNumdep()!=null)
		{
			dinamicCriteria.andNNumdepEqualTo(filtro.getnNumdep());
		}
		if(filtro.getvDesapepat()!=null && !"".equals(filtro.getvDesapepat().trim()))
		{
			dinamicCriteria.andVDesapepatLike("%"+filtro.getvDesapepat().toUpperCase()+"%");
		}
		if(filtro.getvDesapemat()!=null && !"".equals(filtro.getvDesapemat().trim()))
		{
			dinamicCriteria.andVDesapematLike("%"+filtro.getvDesapemat().toUpperCase()+"%");
		}
		if(filtro.getvDesnombres()!=null && !"".equals(filtro.getvDesnombres().trim()))
		{
			dinamicCriteria.andVDesnombresLike("%"+filtro.getvDesnombres().toUpperCase()+"%");
		}
		example.or(dinamicCriteria);
		try {
			PrtbcPersonalMapper mapper = sqlSession.getMapper (PrtbcPersonalMapper. class);
			List <PrtbcPersonal> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getPersonal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstPersonalrrhh> getPersonalRRHH(VstPersonalrrhh filtro) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstPersonalrrhhExample example = new VstPersonalrrhhExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhhExample.Criteria dinamicCriteria=example.createCriteria();
		dinamicCriteria.andVCodpersonalIsNotNull();
		if(filtro.getvCodtipodocid()!=null && !"".equals(filtro.getvCodtipodocid().trim()))
		{
			dinamicCriteria.andVCodtipodocidEqualTo(filtro.getvCodtipodocid());
		}
		if(filtro.getvCodpersonal()!=null && !"".equals(filtro.getvCodpersonal().trim()))
		{
			dinamicCriteria.andVCodpersonalEqualTo(filtro.getvCodpersonal());
		}
		if(filtro.getnNumint()!=null)
		{
			dinamicCriteria.andNNumintEqualTo(filtro.getnNumint());
		}
		if(filtro.getnNumdep()!=null)
		{
			dinamicCriteria.andNNumdepEqualTo(filtro.getnNumdep());
		}
		if(filtro.getvDesapepat()!=null && !"".equals(filtro.getvDesapepat().trim()))
		{
			dinamicCriteria.andVDesapepatLike("%"+filtro.getvDesapepat().toUpperCase()+"%");
		}
		if(filtro.getvDesapemat()!=null && !"".equals(filtro.getvDesapemat().trim()))
		{
			dinamicCriteria.andVDesapematLike("%"+filtro.getvDesapemat().toUpperCase()+"%");
		}
		if(filtro.getvDesnombres()!=null && !"".equals(filtro.getvDesnombres().trim()))
		{
			dinamicCriteria.andVDesnombresLike("%"+filtro.getvDesnombres().toUpperCase()+"%");
		}
		example.or(dinamicCriteria);
		example.setOrderByClause("V_DESDEP ASC, V_DESAPEPAT ASC");
		try {
			VstPersonalrrhhMapper mapper = sqlSession.getMapper (VstPersonalrrhhMapper. class);
			List <VstPersonalrrhh> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getPersonalRRHH "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <PrtbcTipopers> getTipoPersonal() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		PrtbcTipopersExample example = new PrtbcTipopersExample();
		example.createCriteria().andNFlgactivoEqualTo(new Short("1"));
		example.setOrderByClause("v_destipo");
		try {
			PrtbcTipopersMapper mapper = sqlSession.getMapper (PrtbcTipopersMapper. class);
			List <PrtbcTipopers> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoPersonal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbPercargo> getCargos() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbPercargoExample example = new SitbPercargoExample();
		example.createCriteria().andVFlgactEqualTo("1");
		example.setOrderByClause("v_nomcargo");
		try {
			SitbPercargoMapper mapper = sqlSession.getMapper (SitbPercargoMapper. class);
			List <SitbPercargo> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getCargos "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbEscalaremun> getEscalas() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbEscalaremunExample example = new SitbEscalaremunExample();
		example.createCriteria().andVFlgactEqualTo("1");
		example.setOrderByClause("v_nomescala");
		try {
			SitbEscalaremunMapper mapper = sqlSession.getMapper (SitbEscalaremunMapper. class);
			List <SitbEscalaremun> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getEscalas "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarPersonal(PrtbcPersonal entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PrtbcPersonalMapper mapper = sqlSession.getMapper(PrtbcPersonalMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarPersonal "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizarPersonal(PrtbcPersonal entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PrtbcPersonalMapper mapper = sqlSession.getMapper(PrtbcPersonalMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarPersonal "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public TdtbcDependencia getDependenciaPorCodigo(Short nNumdep) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcDependenciaExample example = new TdtbcDependenciaExample();
		example.createCriteria().andNFlgactivoEqualTo(new Short("1")).andNNumdepEqualTo(nNumdep);
		try {
			TdtbcDependenciaMapper mapper = sqlSession.getMapper (TdtbcDependenciaMapper. class);
			List <TdtbcDependencia> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getDependencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <TdtbcIntendencia> getIntendencia(String nNumint) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcIntendenciaExample example = new TdtbcIntendenciaExample();
		if("1".equals(nNumint))
		{
			example.createCriteria().andNNumintIsNotNull();			
		}
		else
		{
			example.createCriteria().andNNumintEqualTo(new BigDecimal(nNumint));
		}
		try {
			TdtbcIntendenciaMapper mapper = sqlSession.getMapper (TdtbcIntendenciaMapper. class);
			List <TdtbcIntendencia> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getIntendencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcTurno> getTurnos() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnoExample example = new RhtbcTurnoExample();
		example.createCriteria().andVFlgactEqualTo("S"); 
		try {
			RhtbcTurnoMapper mapper = sqlSession.getMapper (RhtbcTurnoMapper. class);
			List <RhtbcTurno> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTurnos "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcTurnodia> getTurnoDia(Short nCodturno) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnodiaExample example = new RhtbcTurnodiaExample();
		example.createCriteria().andNCodturnoEqualTo(nCodturno);
		try {
			RhtbcTurnodiaMapper mapper = sqlSession.getMapper (RhtbcTurnodiaMapper. class);
			List <RhtbcTurnodia> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTurnoDia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstTurnopersonalrrhh> getTurnoPersonal(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstTurnopersonalrrhhExample example = new VstTurnopersonalrrhhExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			VstTurnopersonalrrhhMapper mapper = sqlSession.getMapper (VstTurnopersonalrrhhMapper. class);
			List <VstTurnopersonalrrhh> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTurnoPersonal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstTurnopersonalrrhh> getTurnoPersonal(String vCodpersonal,Date fecha) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstTurnopersonalrrhhExample example = new VstTurnopersonalrrhhExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinGreaterThanOrEqualTo(fecha).andDFecinicioLessThanOrEqualTo(fecha);
		try {
			VstTurnopersonalrrhhMapper mapper = sqlSession.getMapper (VstTurnopersonalrrhhMapper. class);
			List <VstTurnopersonalrrhh> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTurnoPersonal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbdPersonal> getDetallePersonal(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPersonalExample example = new RhtbdPersonalExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			RhtbdPersonalMapper mapper = sqlSession.getMapper (RhtbdPersonalMapper. class);
			List <RhtbdPersonal> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetallePersonal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhmvcPerturno getCorrelativoGlobalPerTurno() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcPerturnoExample example = new RhmvcPerturnoExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhmvcPerturnoMapper mapper = sqlSession.getMapper (RhmvcPerturnoMapper. class);
			List <RhmvcPerturno> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalPerTurno "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarPerTurno(RhmvcPerturno entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcPerturnoMapper mapper = sqlSession.getMapper(RhmvcPerturnoMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarPerTurno "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int insertarDetallePersonal(RhtbdPersonal entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPersonalMapper mapper = sqlSession.getMapper(RhtbdPersonalMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDetallePersonal "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizarDetallePersonal(RhtbdPersonal entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPersonalMapper mapper = sqlSession.getMapper(RhtbdPersonalMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarDetallePersonal "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int eliminarDetallePersonal(RhtbdPersonal entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPersonalMapper mapper = sqlSession.getMapper(RhtbdPersonalMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarDetallePersonal "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public RhtbdPersonal getCorrelativoGlobalDetalle(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPersonalExample example = new RhtbdPersonalExample();
		example.createCriteria().andCorrelativoPorPersona(vCodpersonal);
		try {
			RhtbdPersonalMapper mapper = sqlSession.getMapper (RhtbdPersonalMapper. class);
			List <RhtbdPersonal> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalDetalle "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstDetpersonalrrhh> getVistaDetallePersonal(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstDetpersonalrrhhExample example = new VstDetpersonalrrhhExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			VstDetpersonalrrhhMapper mapper = sqlSession.getMapper (VstDetpersonalrrhhMapper. class);
			List <VstDetpersonalrrhh> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getVistaDetallePersonal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int disableDetallePersonal(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPersonalExample example = new RhtbdPersonalExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		RhtbdPersonalMapper mapper = sqlSession.getMapper(RhtbdPersonalMapper.class);	
		RhtbdPersonal det=new RhtbdPersonal();
		det.setvFlgprin("N");
		try {
			mapper.updateByExampleSelective(det, example);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error disableDetallePersonal "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int disableFlgActDetallePersonal(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPersonalExample example = new RhtbdPersonalExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		RhtbdPersonalMapper mapper = sqlSession.getMapper(RhtbdPersonalMapper.class);	
		RhtbdPersonal det=new RhtbdPersonal();
		det.setvFlgact("N");
		try {
			mapper.updateByExampleSelective(det, example);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error disableFlgActDetallePersonal "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int eliminarPerTurno(RhmvcPerturno entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcPerturnoMapper mapper = sqlSession.getMapper(RhmvcPerturnoMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCodperturno());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarPerTurno "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizarPerTurno(RhmvcPerturno entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcPerturnoMapper mapper = sqlSession.getMapper(RhmvcPerturnoMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarPerTurno "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int disableDateDetallePersonal(String vCodpersonal, Date dFecfin) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPersonalExample example = new RhtbdPersonalExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andVFlgactEqualTo("S").andDFecfinIsNull();
		RhtbdPersonalMapper mapper = sqlSession.getMapper(RhtbdPersonalMapper.class);	
		RhtbdPersonal det=new RhtbdPersonal();
		det.setdFecfin(dFecfin);
		try {
			mapper.updateByExampleSelective(det, example);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error disableDateDetallePersonal "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public String currentDate() throws Exception 
	{
		SqlSession session=sqlSessionFactory.openSession();
		try {
			String result="";					
			ResultSet rs=session.getConnection().prepareStatement("select TO_CHAR(SYSDATE, 'dd/MM/yyyy') fecha from dual").executeQuery();
			while(rs.next())
			{
				result=rs.getString("fecha");
			}
			return result;
		} catch (Exception e) {
			System.out.println("Error obteniendo la fecha de base de datos ::: "+e.getMessage());
			return "";
		}finally {
			session.close();
		}
	}
	
	public boolean getTieneTurnoActivo(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcPerturnoExample example = new RhmvcPerturnoExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andVFlgactEqualTo("S");
		try {
			RhmvcPerturnoMapper mapper = sqlSession.getMapper (RhmvcPerturnoMapper. class);
			List <RhmvcPerturno> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalPerTurno "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int disableDatePerTurno(String vCodpersonal, Date dFecfin) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcPerturnoExample example = new RhmvcPerturnoExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andVFlgactEqualTo("S").andDFecfinIsNull();
		RhmvcPerturnoMapper mapper = sqlSession.getMapper(RhmvcPerturnoMapper.class);	
		RhmvcPerturno det=new RhmvcPerturno();
		det.setdFecfin(dFecfin);
		det.setvFlgact("N");
		try {
			mapper.updateByExampleSelective(det, example);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error disableDatePerTurno "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public RhtbdPersonal getMinDateDetalle(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPersonalExample example = new RhtbdPersonalExample();
		example.createCriteria().andMinDatePorPersona(vCodpersonal);
		try {
			RhtbdPersonalMapper mapper = sqlSession.getMapper (RhtbdPersonalMapper. class);
			List <RhtbdPersonal> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getMinDateDetalle "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhmvcPerturno getMinDatePerTurno(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcPerturnoExample example = new RhmvcPerturnoExample();
		example.createCriteria().andMinDatePorPersona(vCodpersonal);
		try {
			RhmvcPerturnoMapper mapper = sqlSession.getMapper (RhmvcPerturnoMapper. class);
			List <RhmvcPerturno> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getMinDatePerTurno "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhmvcPerturno getMaxDatePerTurno(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcPerturnoExample example = new RhmvcPerturnoExample();
		example.createCriteria().andMaxDatePorPersona(vCodpersonal);
		try {
			RhmvcPerturnoMapper mapper = sqlSession.getMapper (RhmvcPerturnoMapper. class);
			List <RhmvcPerturno> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getMaxDatePerTurno "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneOtroTurnoActivo(String vCodpersonal, Short nCodperturno) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcPerturnoExample example = new RhmvcPerturnoExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andVFlgactEqualTo("S").andNCodperturnoNotEqualTo(nCodperturno);
		try {
			RhmvcPerturnoMapper mapper = sqlSession.getMapper (RhmvcPerturnoMapper. class);
			List <RhmvcPerturno> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneOtroTurnoActivo "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneDetalleActivo(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPersonalExample example = new RhtbdPersonalExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andVFlgactEqualTo("S");
		try {
			RhtbdPersonalMapper mapper = sqlSession.getMapper (RhtbdPersonalMapper. class);
			List <RhtbdPersonal> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneDetalleActivo "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}	
	
	public RhtbdPersonal getDefaultDetalle(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPersonalExample example = new RhtbdPersonalExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andVFlgactEqualTo("S").andVFlgprinEqualTo("S");
		try {
			RhtbdPersonalMapper mapper = sqlSession.getMapper (RhtbdPersonalMapper. class);
			List <RhtbdPersonal> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getDefaultDetalle "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean tieneMarcacionMayorAFecha(String vCodpersonal, Date fecha) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcMarcacionExample example = new RhmvcMarcacionExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFechaGreaterThanOrEqualTo(fecha);
		try {
			RhmvcMarcacionMapper mapper = sqlSession.getMapper (RhmvcMarcacionMapper. class);
			List <RhmvcMarcacion> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error tieneMarcacionMayorAFecha "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	//NUEVOS CAMPOS
	
	public List <RhtbcSindicato> getSindicatos() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcSindicatoExample example = new RhtbcSindicatoExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_dessindic");
		try {
			RhtbcSindicatoMapper mapper = sqlSession.getMapper (RhtbcSindicatoMapper. class);
			List <RhtbcSindicato> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getSindicatos "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbProfesion> getProfesiones() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbProfesionExample example = new SitbProfesionExample();
		example.createCriteria().andVDesprofIsNotNull();
		example.setOrderByClause("v_desprof");
		try {
			SitbProfesionMapper mapper = sqlSession.getMapper (SitbProfesionMapper. class);
			List <SitbProfesion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getProfesiones "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbEntfinanciera> getEntidadesFinancieras() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbEntfinancieraExample example = new SitbEntfinancieraExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_desentfin");
		try {
			SitbEntfinancieraMapper mapper = sqlSession.getMapper (SitbEntfinancieraMapper. class);
			List <SitbEntfinanciera> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getEntidadesFinancieras "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbSeguro> getSeguros() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbSeguroExample example = new SitbSeguroExample();
		example.createCriteria().andVFlgactEqualTo("S").andNCortipsegEqualTo(new BigDecimal("1"));
		example.setOrderByClause("v_desseguro");
		try {
			SitbSeguroMapper mapper = sqlSession.getMapper (SitbSeguroMapper. class);
			List <SitbSeguro> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getSeguros "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbSeguro> getSegurosSCTR() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbSeguroExample example = new SitbSeguroExample();
		example.createCriteria().andVFlgactEqualTo("S").andNCortipsegEqualTo(new BigDecimal("2"));
		example.setOrderByClause("v_desseguro");
		try {
			SitbSeguroMapper mapper = sqlSession.getMapper (SitbSeguroMapper. class);
			List <SitbSeguro> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getSegurosSCTR "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbRegpensionario> getRegimenesPensionarios() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbRegpensionarioExample example = new SitbRegpensionarioExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_desregpen");
		try {
			SitbRegpensionarioMapper mapper = sqlSession.getMapper (SitbRegpensionarioMapper. class);
			List <SitbRegpensionario> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getRegimenesPensionarios "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbEstadocivil> getEstadosCiviles() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbEstadocivilExample example = new SitbEstadocivilExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_desestciv");
		try {
			SitbEstadocivilMapper mapper = sqlSession.getMapper (SitbEstadocivilMapper. class);
			List <SitbEstadocivil> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getEstadosCiviles "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbDistrito> getDistritos() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbDistritoExample example = new SitbDistritoExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_desdis");
		try {
			SitbDistritoMapper mapper = sqlSession.getMapper (SitbDistritoMapper. class);
			List <SitbDistrito> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDistritos "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbZona> getZonas() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbZonaExample example = new SitbZonaExample();
		example.createCriteria().andVDeszonIsNotNull();
		example.setOrderByClause("v_deszon");
		try {
			SitbZonaMapper mapper = sqlSession.getMapper (SitbZonaMapper. class);
			List <SitbZona> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getZonas "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbTipvia> getTiposVia() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbTipviaExample example = new SitbTipviaExample();
		example.createCriteria().andVDestviaIsNotNull();
		example.setOrderByClause("v_destvia");
		try {
			SitbTipviaMapper mapper = sqlSession.getMapper (SitbTipviaMapper. class);
			List <SitbTipvia> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTiposVia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <SitbVinculfamili> getVinculos() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbVinculfamiliExample example = new SitbVinculfamiliExample();
		example.createCriteria().andNFlgrrhhEqualTo(new BigDecimal("1"));
		example.setOrderByClause("v_desvinfam");
		try {
			SitbVinculfamiliMapper mapper = sqlSession.getMapper (SitbVinculfamiliMapper. class);
			List <SitbVinculfamili> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getVinculos "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcTiporesol> getTiposResolucion() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTiporesolExample example = new RhtbcTiporesolExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_destipres");
		try {
			RhtbcTiporesolMapper mapper = sqlSession.getMapper (RhtbcTiporesolMapper. class);
			List <RhtbcTiporesol> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTiposResolucion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcResolucion> getResolucionesDestaque() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcResolucionExample example = new RhtbcResolucionExample();
		example.createCriteria().andNCortipresEqualTo(new BigDecimal("1"));
		example.setOrderByClause("v_anores, v_numres");
		try {
			RhtbcResolucionMapper mapper = sqlSession.getMapper (RhtbcResolucionMapper. class);
			List <RhtbcResolucion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getResolucionesDestaque "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstTiporesolucion> getTodasResoluciones() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstTiporesolucionExample example = new VstTiporesolucionExample();
		example.createCriteria().andNCortipresEqualTo(new BigDecimal("1"));
		example.setOrderByClause("v_anores, v_numres");
		try {
			VstTiporesolucionMapper mapper = sqlSession.getMapper (VstTiporesolucionMapper. class);
			List <VstTiporesolucion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTodasResoluciones "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcCargosindica> getCargosSindicales() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcCargosindicaExample example = new RhtbcCargosindicaExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_descarsin");
		try {
			RhtbcCargosindicaMapper mapper = sqlSession.getMapper (RhtbcCargosindicaMapper. class);
			List <RhtbcCargosindica> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getCargosSindicales "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcClascar> getClasificacionCargos() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcClascarExample example = new RhtbcClascarExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_desclacar");
		try {
			RhtbcClascarMapper mapper = sqlSession.getMapper (RhtbcClascarMapper. class);
			List <RhtbcClascar> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getClasificacionCargos "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	//INSERT NUEVOS
	
	public int insertarDetalleSindicato(RhtbdPerxsindicato entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxsindicatoMapper mapper = sqlSession.getMapper(RhtbdPerxsindicatoMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDetalleSindicato "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int insertarDetalleProfesion(RhtbdPerxprofesion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxprofesionMapper mapper = sqlSession.getMapper(RhtbdPerxprofesionMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDetalleProfesion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int insertarDetalleInformacionFinanciera(RhtbdPerxentfinanciera entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxentfinancieraMapper mapper = sqlSession.getMapper(RhtbdPerxentfinancieraMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDetalleInformacionFinanciera "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int insertarDetalleSeguro(RhtbdPerxseguro entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxseguroMapper mapper = sqlSession.getMapper(RhtbdPerxseguroMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDetalleSeguro "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int insertarDetalleRegimenPensionario(RhtbdPerxregpensionario entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxregpensionarioMapper mapper = sqlSession.getMapper(RhtbdPerxregpensionarioMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDetalleRegimenPensionario "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int insertarDetalleDireccion(RhtbdPerdireccion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerdireccionMapper mapper = sqlSession.getMapper(RhtbdPerdireccionMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDetalleDireccion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*public int insertarDetalleDestaque(RhtbdDestaque entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdDestaqueMapper mapper = sqlSession.getMapper(RhtbdDestaqueMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDetalleDestaque "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}*/
	
	public int insertarDependiente(RhtbdDependientes entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdDependientesMapper mapper = sqlSession.getMapper(RhtbdDependientesMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDependiente "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int insertarResolucion(RhtbcResolucion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcResolucionMapper mapper = sqlSession.getMapper(RhtbcResolucionMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarResolucion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	//UPDATE NUEVOS
	
	public int actualizarDetalleSindicato(RhtbdPerxsindicato entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxsindicatoMapper mapper = sqlSession.getMapper(RhtbdPerxsindicatoMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarDetalleSindicato "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizaDetalleProfesion(RhtbdPerxprofesion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxprofesionMapper mapper = sqlSession.getMapper(RhtbdPerxprofesionMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizaDetalleProfesion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizaDetalleInformacionFinanciera(RhtbdPerxentfinanciera entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxentfinancieraMapper mapper = sqlSession.getMapper(RhtbdPerxentfinancieraMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizaDetalleInformacionFinanciera "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizaDetalleSeguro(RhtbdPerxseguro entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxseguroMapper mapper = sqlSession.getMapper(RhtbdPerxseguroMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizaDetalleSeguro "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizaDetalleRegimenPensionario(RhtbdPerxregpensionario entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxregpensionarioMapper mapper = sqlSession.getMapper(RhtbdPerxregpensionarioMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizaDetalleRegimenPensionario "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizaDetalleDireccion(RhtbdPerdireccion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerdireccionMapper mapper = sqlSession.getMapper(RhtbdPerdireccionMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizaDetalleDireccion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*public int actualizaDetalleDestaque(RhtbdDestaque entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdDestaqueMapper mapper = sqlSession.getMapper(RhtbdDestaqueMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizaDetalleDestaque "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}*/
	
	public int actualizaDependiente(RhtbdDependientes entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdDependientesMapper mapper = sqlSession.getMapper(RhtbdDependientesMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizaDependiente "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizaResolucion(RhtbcResolucion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcResolucionMapper mapper = sqlSession.getMapper(RhtbcResolucionMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizaResolucion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	//GETBYPERSONAL NUEVOS
	
	public List <RhtbdPerxsindicato> getDetalleSindicato(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxsindicatoExample example = new RhtbdPerxsindicatoExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			RhtbdPerxsindicatoMapper mapper = sqlSession.getMapper (RhtbdPerxsindicatoMapper. class);
			List <RhtbdPerxsindicato> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleSindicato "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbdPerxprofesion> getDetalleProfesion(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxprofesionExample example = new RhtbdPerxprofesionExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			RhtbdPerxprofesionMapper mapper = sqlSession.getMapper (RhtbdPerxprofesionMapper. class);
			List <RhtbdPerxprofesion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleProfesion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbdPerxentfinanciera> getDetalleInformacionFinanciera(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxentfinancieraExample example = new RhtbdPerxentfinancieraExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			RhtbdPerxentfinancieraMapper mapper = sqlSession.getMapper (RhtbdPerxentfinancieraMapper. class);
			List <RhtbdPerxentfinanciera> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleInformacionFinanciera "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbdPerxseguro> getDetalleSeguro(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxseguroExample example = new RhtbdPerxseguroExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			RhtbdPerxseguroMapper mapper = sqlSession.getMapper (RhtbdPerxseguroMapper. class);
			List <RhtbdPerxseguro> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleSeguro "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbdPerxregpensionario> getDetalleRegimenPensionario(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxregpensionarioExample example = new RhtbdPerxregpensionarioExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			RhtbdPerxregpensionarioMapper mapper = sqlSession.getMapper (RhtbdPerxregpensionarioMapper. class);
			List <RhtbdPerxregpensionario> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleRegimenPensionario "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbdPerdireccion> getDetalleDireccion(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerdireccionExample example = new RhtbdPerdireccionExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			RhtbdPerdireccionMapper mapper = sqlSession.getMapper (RhtbdPerdireccionMapper. class);
			List <RhtbdPerdireccion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleDireccion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*public List <RhtbdDestaque> getDetalleDestaque(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdDestaqueExample example = new RhtbdDestaqueExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			RhtbdDestaqueMapper mapper = sqlSession.getMapper (RhtbdDestaqueMapper. class);
			List <RhtbdDestaque> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleDestaque "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}*/
	
	public List <RhtbdDependientes> getDependientes(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdDependientesExample example = new RhtbdDependientesExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			RhtbdDependientesMapper mapper = sqlSession.getMapper (RhtbdDependientesMapper. class);
			List <RhtbdDependientes> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDependientes "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcResolucion> getResoluciones() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcResolucionExample example = new RhtbcResolucionExample();
		example.createCriteria().andNCodresIsNotNull();
		try {
			RhtbcResolucionMapper mapper = sqlSession.getMapper (RhtbcResolucionMapper. class);
			List <RhtbcResolucion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getResoluciones "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	//GETBYPERSONAL NUEVOS (VISTAS)
	
	public List <VstSindicato> getDetalleSindicatoVista(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstSindicatoExample example = new VstSindicatoExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			VstSindicatoMapper mapper = sqlSession.getMapper (VstSindicatoMapper. class);
			List <VstSindicato> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleSindicatoVista "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstProfesion> getDetalleProfesionVista(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstProfesionExample example = new VstProfesionExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			VstProfesionMapper mapper = sqlSession.getMapper (VstProfesionMapper. class);
			List <VstProfesion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleProfesionVista "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstEntfinanciera> getDetalleInformacionFinancieraVista(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstEntfinancieraExample example = new VstEntfinancieraExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			VstEntfinancieraMapper mapper = sqlSession.getMapper (VstEntfinancieraMapper. class);
			List <VstEntfinanciera> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleInformacionFinancieraVista "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstSeguro> getDetalleSeguroVista(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstSeguroExample example = new VstSeguroExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andNCortipsegEqualTo(new BigDecimal("1"));
		try {
			VstSeguroMapper mapper = sqlSession.getMapper (VstSeguroMapper. class);
			List <VstSeguro> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleSeguroVista "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstSeguro> getDetalleSeguroVistaSCTR(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstSeguroExample example = new VstSeguroExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andNCortipsegEqualTo(new BigDecimal("2"));
		try {
			VstSeguroMapper mapper = sqlSession.getMapper (VstSeguroMapper. class);
			List <VstSeguro> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleSeguroVistaSCTR "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstRegpensionario> getDetalleRegimenPensionarioVista(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstRegpensionarioExample example = new VstRegpensionarioExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			VstRegpensionarioMapper mapper = sqlSession.getMapper (VstRegpensionarioMapper. class);
			List <VstRegpensionario> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleRegimenPensionarioVista "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstDirecciones> getDetalleDireccionVista(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstDireccionesExample example = new VstDireccionesExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			VstDireccionesMapper mapper = sqlSession.getMapper (VstDireccionesMapper. class);
			List <VstDirecciones> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDetalleDireccionVista "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstDependientes> getDependientesVista(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstDependientesExample example = new VstDependientesExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		try {
			VstDependientesMapper mapper = sqlSession.getMapper (VstDependientesMapper. class);
			List <VstDependientes> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDependientesVista "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstResolucion> getResolucionesVista() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstResolucionExample example = new VstResolucionExample();
		example.createCriteria().andNCodresIsNotNull();
		try {
			VstResolucionMapper mapper = sqlSession.getMapper (VstResolucionMapper. class);
			List <VstResolucion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getResolucionesVista "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstResolucion> getResolucionesVista(RhtbcResolucion filtro) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstResolucionExample example = new VstResolucionExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.VstResolucionExample.Criteria dinamicCriteria = example.createCriteria();
		dinamicCriteria.andNCodresIsNotNull();
		if(filtro.getnCortipres()!=null && !(new BigDecimal("0")).equals(filtro.getnCortipres()))
		{
			dinamicCriteria.andNCortipresEqualTo(filtro.getnCortipres());
		}		
		if(filtro.getvNumres()!=null && !"".equals(filtro.getvNumres().trim()))
		{
			dinamicCriteria.andVNumresEqualTo(filtro.getvNumres());
		}
		if(filtro.getvAnores()!=null && !"".equals(filtro.getvAnores().trim()))
		{
			dinamicCriteria.andVAnoresEqualTo(filtro.getvAnores());
		}
				
		example.or(dinamicCriteria);
		try {
			VstResolucionMapper mapper = sqlSession.getMapper (VstResolucionMapper. class);
			List <VstResolucion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getResolucionesVista "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	//CORRELATIVOS NUEVOS
	
	public RhtbdPerxsindicato getCorrelativoSindicato() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxsindicatoExample example = new RhtbdPerxsindicatoExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbdPerxsindicatoMapper mapper = sqlSession.getMapper (RhtbdPerxsindicatoMapper. class);
			List <RhtbdPerxsindicato> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoSindicato "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhtbdPerxprofesion getCorrelativoProfesion() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxprofesionExample example = new RhtbdPerxprofesionExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbdPerxprofesionMapper mapper = sqlSession.getMapper (RhtbdPerxprofesionMapper. class);
			List <RhtbdPerxprofesion> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoProfesion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhtbdPerxentfinanciera getCorrelativoInformacionFinanciera() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxentfinancieraExample example = new RhtbdPerxentfinancieraExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbdPerxentfinancieraMapper mapper = sqlSession.getMapper (RhtbdPerxentfinancieraMapper. class);
			List <RhtbdPerxentfinanciera> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoInformacionFinanciera "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhtbdPerxseguro getCorrelativoSeguro() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxseguroExample example = new RhtbdPerxseguroExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbdPerxseguroMapper mapper = sqlSession.getMapper (RhtbdPerxseguroMapper. class);
			List <RhtbdPerxseguro> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoSeguro "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhtbdPerxregpensionario getCorrelativoRegimenPensionario() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxregpensionarioExample example = new RhtbdPerxregpensionarioExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbdPerxregpensionarioMapper mapper = sqlSession.getMapper (RhtbdPerxregpensionarioMapper. class);
			List <RhtbdPerxregpensionario> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoRegimenPensionario "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhtbdPerdireccion getCorrelativoDireccion() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerdireccionExample example = new RhtbdPerdireccionExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbdPerdireccionMapper mapper = sqlSession.getMapper (RhtbdPerdireccionMapper. class);
			List <RhtbdPerdireccion> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoDireccion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*public RhtbdDestaque getCorrelativoDestaque() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdDestaqueExample example = new RhtbdDestaqueExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbdDestaqueMapper mapper = sqlSession.getMapper (RhtbdDestaqueMapper. class);
			List <RhtbdDestaque> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoDestaque "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}*/
	
	public RhtbcResolucion getCorrelativoResolucion() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcResolucionExample example = new RhtbcResolucionExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbcResolucionMapper mapper = sqlSession.getMapper (RhtbcResolucionMapper. class);
			List <RhtbcResolucion> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoResolucion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	//DELETES NUEVOS
	
	public int eliminarDetalleSindicato(RhtbdPerxsindicato entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxsindicatoMapper mapper = sqlSession.getMapper(RhtbdPerxsindicatoMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCorpersin());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarDetalleSindicato "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int eliminarDetalleProfesion(RhtbdPerxprofesion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxprofesionMapper mapper = sqlSession.getMapper(RhtbdPerxprofesionMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCorperpro());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarDetalleProfesion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int eliminarDetalleInformacionFinanciera(RhtbdPerxentfinanciera entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxentfinancieraMapper mapper = sqlSession.getMapper(RhtbdPerxentfinancieraMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCorperentfin());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarDetalleInformacionFinanciera "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int eliminarDetalleSeguro(RhtbdPerxseguro entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxseguroMapper mapper = sqlSession.getMapper(RhtbdPerxseguroMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCorperseg());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarDetalleSeguro "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int eliminarDetalleRegimenPensionario(RhtbdPerxregpensionario entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerxregpensionarioMapper mapper = sqlSession.getMapper(RhtbdPerxregpensionarioMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCorperregpen());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarRegimenPensionario "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int eliminarDetalleDireccion(RhtbdPerdireccion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerdireccionMapper mapper = sqlSession.getMapper(RhtbdPerdireccionMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCorperdir());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarDireccion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*public int eliminarDestaque(RhtbdDestaque entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdDestaqueMapper mapper = sqlSession.getMapper(RhtbdDestaqueMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCordes());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarDestaque "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}*/
	
	public int eliminarDependiente(RhtbdDependientes entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdDependientesMapper mapper = sqlSession.getMapper(RhtbdDependientesMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarDependiente "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int eliminarResolucion(RhtbcResolucion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcResolucionMapper mapper = sqlSession.getMapper(RhtbcResolucionMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCodres());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarResolucion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	//AUTOCOMPLETE NUEVO
	
	public List <SitbProfesion> getAutocompletarProfesion(String query) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbProfesionExample example = new SitbProfesionExample();
		example.createCriteria().andVDesprofLike("%"+query.toUpperCase()+"%");		
		try {
			SitbProfesionMapper mapper = sqlSession.getMapper (SitbProfesionMapper. class);
			List <SitbProfesion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getAutocompletarProfesion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	//VALIDA REPETIDO NUEVO
	
	public boolean getTieneProfesionRepetidaUpdate(String vCodprof, String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxprofesionExample example = new RhtbdPerxprofesionExample();
		example.createCriteria().andVCodprofEqualTo(vCodprof).andVCodpersonalEqualTo(vCodpersonal);
		try {
			RhtbdPerxprofesionMapper mapper = sqlSession.getMapper (RhtbdPerxprofesionMapper. class);
			List <RhtbdPerxprofesion> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneProfesionRepetidaUpdate "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneEntidadCruzeIni(String vCodpersonal, Date dFecini) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxentfinancieraExample example = new RhtbdPerxentfinancieraExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFeciniGreaterThanOrEqualTo(dFecini);
		try {
			RhtbdPerxentfinancieraMapper mapper = sqlSession.getMapper (RhtbdPerxentfinancieraMapper. class);
			List <RhtbdPerxentfinanciera> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneEntidadCruzeIni "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneEntidadCruzeFin(String vCodpersonal, Date dFecini) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxentfinancieraExample example = new RhtbdPerxentfinancieraExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinGreaterThanOrEqualTo(dFecini);
		try {
			RhtbdPerxentfinancieraMapper mapper = sqlSession.getMapper (RhtbdPerxentfinancieraMapper. class);
			List <RhtbdPerxentfinanciera> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneEntidadCruzeFin "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneEntidadActiva(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxentfinancieraExample example = new RhtbdPerxentfinancieraExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinIsNull();
		try {
			RhtbdPerxentfinancieraMapper mapper = sqlSession.getMapper (RhtbdPerxentfinancieraMapper. class);
			List <RhtbdPerxentfinanciera> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneEntidadActiva "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneSeguroCruzeIni(String vCodpersonal, Date dFecini) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstSeguroExample example = new VstSeguroExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFeciniGreaterThanOrEqualTo(dFecini).andNCortipsegEqualTo(new BigDecimal("1"));
		try {
			VstSeguroMapper mapper = sqlSession.getMapper (VstSeguroMapper. class);
			List <VstSeguro> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneSeguroCruzeIni "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneSeguroCruzeFin(String vCodpersonal, Date dFecini) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstSeguroExample example = new VstSeguroExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinGreaterThanOrEqualTo(dFecini).andNCortipsegEqualTo(new BigDecimal("1"));
		try {
			VstSeguroMapper mapper = sqlSession.getMapper (VstSeguroMapper. class);
			List <VstSeguro> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneSeguroCruzeFin "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneSeguroActivo(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstSeguroExample example = new VstSeguroExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinIsNull().andNCortipsegEqualTo(new BigDecimal("1"));
		try {
			VstSeguroMapper mapper = sqlSession.getMapper (VstSeguroMapper. class);
			List <VstSeguro> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneSeguroActivo "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneSeguroSCTRCruzeIni(String vCodpersonal, Date dFecini) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstSeguroExample example = new VstSeguroExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFeciniGreaterThanOrEqualTo(dFecini).andNCortipsegEqualTo(new BigDecimal("2"));
		try {
			VstSeguroMapper mapper = sqlSession.getMapper (VstSeguroMapper. class);
			List <VstSeguro> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneSeguroSCTRCruzeIni "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneSeguroSCTRCruzeFin(String vCodpersonal, Date dFecini) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstSeguroExample example = new VstSeguroExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinGreaterThanOrEqualTo(dFecini).andNCortipsegEqualTo(new BigDecimal("2"));
		try {
			VstSeguroMapper mapper = sqlSession.getMapper (VstSeguroMapper. class);
			List <VstSeguro> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneSeguroSCTRCruzeFin "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneSeguroSCTRActivo(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstSeguroExample example = new VstSeguroExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinIsNull().andNCortipsegEqualTo(new BigDecimal("2"));
		try {
			VstSeguroMapper mapper = sqlSession.getMapper (VstSeguroMapper. class);
			List <VstSeguro> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneSeguroSCTRActivo "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneRegimenCruzeIni(String vCodpersonal, Date dFecini) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxregpensionarioExample example = new RhtbdPerxregpensionarioExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFeciniGreaterThanOrEqualTo(dFecini);
		try {
			RhtbdPerxregpensionarioMapper mapper = sqlSession.getMapper (RhtbdPerxregpensionarioMapper. class);
			List <RhtbdPerxregpensionario> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneRegimenCruzeIni "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneRegimenCruzeFin(String vCodpersonal, Date dFecini) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxregpensionarioExample example = new RhtbdPerxregpensionarioExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinGreaterThanOrEqualTo(dFecini);
		try {
			RhtbdPerxregpensionarioMapper mapper = sqlSession.getMapper (RhtbdPerxregpensionarioMapper. class);
			List <RhtbdPerxregpensionario> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneRegimenCruzeFin "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneRegimenActivo(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxregpensionarioExample example = new RhtbdPerxregpensionarioExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinIsNull();
		try {
			RhtbdPerxregpensionarioMapper mapper = sqlSession.getMapper (RhtbdPerxregpensionarioMapper. class);
			List <RhtbdPerxregpensionario> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneRegimenActivo "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneSindicatoCruzeIni(String vCodpersonal, Date dFecini) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxsindicatoExample example = new RhtbdPerxsindicatoExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFeciniGreaterThanOrEqualTo(dFecini);
		try {
			RhtbdPerxsindicatoMapper mapper = sqlSession.getMapper (RhtbdPerxsindicatoMapper. class);
			List <RhtbdPerxsindicato> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneSindicatoCruzeIni "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneSindicatoCruzeFin(String vCodpersonal, Date dFecini) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxsindicatoExample example = new RhtbdPerxsindicatoExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinGreaterThanOrEqualTo(dFecini);
		try {
			RhtbdPerxsindicatoMapper mapper = sqlSession.getMapper (RhtbdPerxsindicatoMapper. class);
			List <RhtbdPerxsindicato> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneSindicatoCruzeFin "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneSindicatoActivo(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPerxsindicatoExample example = new RhtbdPerxsindicatoExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andDFecfinIsNull();
		try {
			RhtbdPerxsindicatoMapper mapper = sqlSession.getMapper (RhtbdPerxsindicatoMapper. class);
			List <RhtbdPerxsindicato> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneSindicatoActivo "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneDependienteRepetido(String vCodpersonal, String vCodtdocide, String vNumdoc) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdDependientesExample example = new RhtbdDependientesExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andVCodtdocideEqualTo(vCodtdocide).andVNumdocEqualTo(vNumdoc);
		try {
			RhtbdDependientesMapper mapper = sqlSession.getMapper (RhtbdDependientesMapper. class);
			List <RhtbdDependientes> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneDependienteRepetido "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneResolucionRepetida(String vNumres, String vAnores, BigDecimal nCortipres) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcResolucionExample example = new RhtbcResolucionExample();
		example.createCriteria().andVNumresEqualTo(vNumres).andVAnoresEqualTo(vAnores).andNCortipresEqualTo(nCortipres);
		try {
			RhtbcResolucionMapper mapper = sqlSession.getMapper (RhtbcResolucionMapper. class);
			List <RhtbcResolucion> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneResolucionRepetida "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getEsResolucionAsignada(BigDecimal nCodres) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPersonalExample example = new RhtbdPersonalExample();
		example.createCriteria().andNCodresEqualTo(nCodres);
		try {
			RhtbdPersonalMapper mapper = sqlSession.getMapper (RhtbdPersonalMapper. class);
			List <RhtbdPersonal> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getEsResolucionAsignada "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	//DESACTIVAR NUEVO
	
	public int desactivarUltDetallesDireccionPorPersonal(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbdPerdireccionExample example = new RhtbdPerdireccionExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal);
		RhtbdPerdireccionMapper mapper = sqlSession.getMapper(RhtbdPerdireccionMapper.class);		
		try {
			RhtbdPerdireccion record=new RhtbdPerdireccion();
			record.setvFlgdirult("N");
			mapper.updateByExampleSelective(record, example);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error desactivarUltDetallesDireccionPorPersonal "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
}
