package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.reniec.rel.ReniecBean;

import pe.gob.sunafil.gestionpersonal.bean.Persona;
import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTPermisos;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTPersona;
import pe.gob.sunafil.gestionpersonal.persistence.client.PrtbcPersonalMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhmvcPermisosMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhmvdPermisoxestMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcEstpermisoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTurnoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstPermisosMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstPersonalrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPermisos;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPermisosExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvdPermisoxest;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvdPermisoxestExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcEstpermiso;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcEstpermisoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPermisos;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPermisosExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhhExample;



/**
 * 
 * @author Mario Zumaeta
 * 11/07/2013
 *
 */
public class IMPPermisos implements INTPermisos {

	private static Logger depurador = Logger.getLogger(IMPPermisos.class.getName());
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPPermisos(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	}


	@Override
	public String insertarPermiso(RhmvcPermisos entidad) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcPermisosMapper mapper = sqlSession.getMapper(RhmvcPermisosMapper.class);		
		String mensaje="";
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();			
		} catch (Exception e) {
			System.out.println("Error en IMPPermisos>insertarPermiso: "+e.getMessage());	
			mensaje=e.getMessage();				
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return mensaje;
	}
	
	public String insertarPermisoXEst(RhmvdPermisoxest entidad) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvdPermisoxestMapper mapper = sqlSession.getMapper(RhmvdPermisoxestMapper.class);		
		String mensaje="";
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();			
		} catch (Exception e) {
			System.out.println("Error en IMPPermisos>insertarPermisoXEst: "+e.getMessage());	
			mensaje=e.getMessage();				
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return mensaje;
	}
	
	public RhmvcPermisos getCorrelativoGlobalPermiso() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcPermisosExample example = new RhmvcPermisosExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhmvcPermisosMapper mapper = sqlSession.getMapper (RhmvcPermisosMapper. class);
			List <RhmvcPermisos> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalPermiso "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhmvdPermisoxest getCorrelativoGlobalPermisoXEst(BigDecimal codPer) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvdPermisoxestExample example = new RhmvdPermisoxestExample();
		example.createCriteria().andCorrelativoActual(codPer);
		try {
			RhmvdPermisoxestMapper mapper = sqlSession.getMapper (RhmvdPermisoxestMapper. class);
			List <RhmvdPermisoxest> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalPermiso "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List<RhtbcEstpermiso> getEstadoPermiso() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcEstpermisoExample example = new RhtbcEstpermisoExample();
		example.createCriteria().andVDesestperIsNotNull();
		
		try {
			RhtbcEstpermisoMapper mapper = sqlSession.getMapper (RhtbcEstpermisoMapper. class);
			List <RhtbcEstpermiso> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getEstadoPermiso "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstPermisos> getPermisosPersonal(VstPermisos filtro) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstPermisosExample example = new VstPermisosExample();
		example.createCriteria();
		
		try {
			//VstPersonalrrhhMapper mapper = sqlSession.getMapper (VstPersonalrrhhMapper. class);
			
			VstPermisosMapper mapper = sqlSession.getMapper (VstPermisosMapper. class);
			List <VstPermisos> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getPermisosPersonal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
}
