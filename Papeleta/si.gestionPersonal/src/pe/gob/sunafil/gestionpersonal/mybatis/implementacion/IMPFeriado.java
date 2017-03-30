package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTFeriado;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcFerxintMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTurnodiaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstFeriadorrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcFerxint;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcFerxintKey;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcFerxintExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodia;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstFeriadorrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstFeriadorrhhExample;

public class IMPFeriado implements INTFeriado{
	
private SqlSessionFactory sqlSessionFactory;
	
	public IMPFeriado(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }

	@Override
	public List<VstFeriadorrhh> getFeriados(RhtbcFerxint filtro, Date fechaDesde, Date fechaHasta) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstFeriadorrhhExample example = new VstFeriadorrhhExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.VstFeriadorrhhExample.Criteria dinamicCriteria = example.createCriteria();
		dinamicCriteria.andVCodferIsNotNull();
		if(filtro.getnNumint()!=null && !filtro.getnNumint().equals(new BigDecimal("0")))
		{
			dinamicCriteria.andNNumintEqualTo(filtro.getnNumint());
		}
		if(fechaDesde!=null && fechaHasta!=null)
		{
			dinamicCriteria.andDFecferBetween(fechaDesde, fechaHasta);
		}		
		example.or(dinamicCriteria);
		try {
			VstFeriadorrhhMapper mapper = sqlSession.getMapper (VstFeriadorrhhMapper. class);
			List <VstFeriadorrhh> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getFeriados "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}

	@Override
	public int insertarFeriado(RhtbcFerxint entidad) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcFerxintMapper mapper = sqlSession.getMapper(RhtbcFerxintMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarFeriado "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}

	@Override
	public int actualizarFeriado(RhtbcFerxint entidad) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcFerxintMapper mapper = sqlSession.getMapper(RhtbcFerxintMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarFeriado "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int eliminarFeriado(RhtbcFerxint entidad) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcFerxintMapper mapper = sqlSession.getMapper(RhtbcFerxintMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminar Feriado "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}

}
