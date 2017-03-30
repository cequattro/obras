package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.hssf.record.VCenterRecord;

import pe.gob.sunafil.gestionpersonal.bean.Persona;
import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTTurnoDia;
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
public class IMPTurnoDia implements INTTurnoDia {
private SqlSessionFactory sqlSessionFactory;
	
	public IMPTurnoDia() {
		
	
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }
	
	public List <RhtbcTurnodia> getTurnosDia(Short nCodturno) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnodiaExample example = new RhtbcTurnodiaExample();
		
		example.createCriteria().andNCodturnoEqualTo(nCodturno);
		example.setOrderByClause("n_codturnodia asc");
			
		try {
			RhtbcTurnodiaMapper mapper = sqlSession.getMapper (RhtbcTurnodiaMapper.class);
			List <RhtbcTurnodia> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTurnosDia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	public RhtbcTurnodia getTurnoDia(Short codTurno, Short codTurnoDia) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnodiaExample example = new RhtbcTurnodiaExample();
		
		example.createCriteria().andNCodturnoEqualTo(codTurno).andNCodturnodiaEqualTo(codTurnoDia);
		//example.setOrderByClause("n_codturnodia asc");	
		try {
			RhtbcTurnodiaMapper mapper = sqlSession.getMapper (RhtbcTurnodiaMapper.class);
			List <RhtbcTurnodia> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getTurnosDia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	public int insertarTurnoDia(RhtbcTurnodia entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcTurnodiaMapper mapper = sqlSession.getMapper(RhtbcTurnodiaMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarTurnoDia "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int insertarDetalleTurnoDia(RhtbcTurnodia entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcTurnodiaMapper mapper = sqlSession.getMapper(RhtbcTurnodiaMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDetalleTurnoDia "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public RhtbcTurnodia getCorrelativoTurnoDia(Short nCodturno) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnodiaExample example = new RhtbcTurnodiaExample();
		example.createCriteria().andCorrelativoActual(nCodturno);
		try {
			RhtbcTurnodiaMapper mapper = sqlSession.getMapper (RhtbcTurnodiaMapper. class);
			List <RhtbcTurnodia> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoTurnoDia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int eliminarTurnoDia(RhtbcTurnodia entidad) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcTurnodiaMapper mapper = sqlSession.getMapper(RhtbcTurnodiaMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminar Turno "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizarTurno(RhtbcTurnodia entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcTurnodiaMapper mapper = sqlSession.getMapper(RhtbcTurnodiaMapper.class);		
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
	
	public boolean getTienePersonalAsignado(RhtbcTurnodia turno) throws Exception
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
	
	public boolean getTieneTurnoDia(Short codTurno,Short codTurnoDia) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnodiaExample example = new RhtbcTurnodiaExample();
		example.createCriteria().andNCodturnodiaEqualTo(codTurnoDia).andNCodturnoEqualTo(codTurno);
		try {
			RhtbcTurnodiaMapper mapper = sqlSession.getMapper (RhtbcTurnodiaMapper. class);
			List <RhtbcTurnodia> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneTurnoDia "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneTurnoDiaRepetidoUpdate(String vDesturno, Short nCodturno, Short nCodturnodia) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTurnodiaExample example = new RhtbcTurnodiaExample();
		example.createCriteria().andVDesturnodiaEqualTo(vDesturno).andNCodturnoNotEqualTo(nCodturno).andNCodturnodiaNotEqualTo(nCodturnodia);
		try {
			RhtbcTurnodiaMapper mapper = sqlSession.getMapper (RhtbcTurnodiaMapper. class);
			List <RhtbcTurnodia> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneTurnoDiaRepetidoUpdate "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	
	
	
}