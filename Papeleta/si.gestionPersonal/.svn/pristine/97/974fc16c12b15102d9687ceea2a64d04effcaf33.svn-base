package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTCargos;
import pe.gob.sunafil.gestionpersonal.persistence.client.SitbPercargoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargo;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargoExample;

public class IMPCargos implements INTCargos{
	
private SqlSessionFactory sqlSessionFactory;
	
	public IMPCargos(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }

	@Override
	public List<SitbPercargo> getCargos(SitbPercargo filtro) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbPercargoExample example = new SitbPercargoExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargoExample.Criteria dinamicCriteria = example.createCriteria();
		dinamicCriteria.andVCodcargoIsNotNull();
		if(filtro.getvNomcargo()!=null && !"".equals(filtro.getvNomcargo().trim()))
		{
			dinamicCriteria.andVNomcargoLike("%"+filtro.getvNomcargo().toUpperCase() +"%");
		}
		if(filtro.getvFlgact()!=null && !"".equals(filtro.getvFlgact().trim()))
		{
			dinamicCriteria.andVFlgactEqualTo(filtro.getvFlgact());
		}
		example.or(dinamicCriteria);
		try {
			SitbPercargoMapper mapper = sqlSession.getMapper (SitbPercargoMapper. class);
			List <SitbPercargo> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getCargo "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}

	@Override
	public int insertarCargo(SitbPercargo entidad) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SitbPercargoMapper mapper = sqlSession.getMapper(SitbPercargoMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarCargo "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}

	@Override
	public SitbPercargo getCorrelativoGlobalCargo() throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbPercargoExample example = new SitbPercargoExample();
		example.createCriteria().andCorrelativoActual();
		try {
			SitbPercargoMapper mapper = sqlSession.getMapper (SitbPercargoMapper. class);
			List <SitbPercargo> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalCargo "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}

	@Override
	public int actualizarCargo(SitbPercargo entidad) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SitbPercargoMapper mapper = sqlSession.getMapper(SitbPercargoMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarCargo "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}

	@Override
	public boolean getTieneCargo(String vNomcargo) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbPercargoExample example = new SitbPercargoExample();
		example.createCriteria().andVNomcargoEqualTo(vNomcargo);
		try {
			SitbPercargoMapper mapper = sqlSession.getMapper (SitbPercargoMapper. class);
			List <SitbPercargo> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneCargo "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}

	@Override
	public boolean getTieneCargoRepetidoUpdate(String vDescargo, String nCodcargo)throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbPercargoExample example = new SitbPercargoExample();
		example.createCriteria().andVDescargoEqualTo(vDescargo).andVCodcargoNotEqualTo(nCodcargo);
		try {
			SitbPercargoMapper mapper = sqlSession.getMapper (SitbPercargoMapper. class);
			List <SitbPercargo> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTieneTurnoRepetidoUpdate "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}

	@Override
	public boolean getTienePersonalAsignado(SitbPercargo cargo)
			throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbPercargoExample example = new SitbPercargoExample();
		example.createCriteria().andVCodcargoEqualTo(cargo.getvCodcargo());
		try {
			SitbPercargoMapper mapper = sqlSession.getMapper (SitbPercargoMapper. class);
			List <SitbPercargo> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getTienePersonalAsignado "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}

}
