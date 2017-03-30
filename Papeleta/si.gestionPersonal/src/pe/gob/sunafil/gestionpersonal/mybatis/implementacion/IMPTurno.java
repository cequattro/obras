package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTTurno;
import pe.gob.sunafil.gestionpersonal.persistence.client.PrtbcPersonalMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.PrtbcTipopersMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhmvcPerturnoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTurnoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTurnodiaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdPersonalMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbEscalaremunMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbPercargoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbTdocideMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.TdtbcDependenciaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstDetpersonalrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstPersonalrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstTurnopersonalrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonalExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcTipopers;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcTipopersExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturnoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodia;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodiaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPersonalExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEscalaremun;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEscalaremunExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargo;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocideExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependenciaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDetpersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstDetpersonalrrhhExample;
//import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonalExample.Criteria;
//import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhhExample.Criteria;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhhExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTurnopersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTurnopersonalrrhhExample;
import pe.gob.sunafil.gestionpersonal.persistence.client.TdtbcIntendenciaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcIntendenciaExample;

public class IMPTurno implements INTTurno {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPTurno(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }
		
	/*
	 * Recupera el autocompletado por dependencia e intendencia
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getAutocompletarDependenciaEIntendencia(java.lang.String, java.lang.String)
	 */
	public List <RhtbcTurno> getTurnos(RhtbcTurno filtro) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnoExample example = new RhtbcTurnoExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnoExample.Criteria dinamicCriteria = example.createCriteria();
		dinamicCriteria.andNCodturnoIsNotNull();
		if(filtro.getvDesturno()!=null && !"".equals(filtro.getvDesturno().trim()))
		{
			dinamicCriteria.andVDesturnoLike("%"+filtro.getvDesturno().toUpperCase() +"%");
		}
		if(filtro.getvFlgact()!=null && !"".equals(filtro.getvFlgact().trim()))
		{
			dinamicCriteria.andVFlgactEqualTo(filtro.getvFlgact());
		}
		if(filtro.getvFlgnomarca()!=null && !"".equals(filtro.getvFlgnomarca().trim()))
		{
			dinamicCriteria.andVFlgnomarcaEqualTo(filtro.getvFlgnomarca());
		}
		example.or(dinamicCriteria);
		try {
			RhtbcTurnoMapper mapper = sqlSession.getMapper (RhtbcTurnoMapper. class);
			List <RhtbcTurno> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTurno "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}	
	
	public int insertarTurno(RhtbcTurno entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcTurnoMapper mapper = sqlSession.getMapper(RhtbcTurnoMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarTurno "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public RhtbcTurno getCorrelativoGlobalTurno() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnoExample example = new RhtbcTurnoExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbcTurnoMapper mapper = sqlSession.getMapper (RhtbcTurnoMapper. class);
			List <RhtbcTurno> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalTurno "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int actualizarTurno(RhtbcTurno entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcTurnoMapper mapper = sqlSession.getMapper(RhtbcTurnoMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarTurno "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}

	@Override
	public int eliminarTurno(RhtbcTurno entidad) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcTurnoMapper mapper = sqlSession.getMapper(RhtbcTurnoMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCodturno());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminar Turno "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int eliminarTurnoDia(RhtbcTurno entidad) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcTurnodiaMapper mapper = sqlSession.getMapper(RhtbcTurnodiaMapper.class);	
		RhtbcTurnodiaExample example = new RhtbcTurnodiaExample();
		example.createCriteria().andNCodturnoEqualTo(entidad.getnCodturno());
		try {
			mapper.deleteByExample(example);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminar Turno dia "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public boolean getTieneTurno(String vDesturno) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnoExample example = new RhtbcTurnoExample();
		example.createCriteria().andVDesturnoEqualTo(vDesturno);
		try {
			RhtbcTurnoMapper mapper = sqlSession.getMapper (RhtbcTurnoMapper. class);
			List <RhtbcTurno> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneTurno "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneTurnoRepetidoUpdate(String vDesturno, Short nCodturno) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnoExample example = new RhtbcTurnoExample();
		example.createCriteria().andVDesturnoEqualTo(vDesturno).andNCodturnoNotEqualTo(nCodturno);
		try {
			RhtbcTurnoMapper mapper = sqlSession.getMapper (RhtbcTurnoMapper. class);
			List <RhtbcTurno> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneTurnoRepetidoUpdate "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTienePersonalAsignado(RhtbcTurno turno) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcPerturnoExample example = new RhmvcPerturnoExample();
		example.createCriteria().andNCodturnoEqualTo(turno.getnCodturno());
		try {
			RhmvcPerturnoMapper mapper = sqlSession.getMapper (RhmvcPerturnoMapper. class);
			List <RhmvcPerturno> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTienePersonalAsignado "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
}
