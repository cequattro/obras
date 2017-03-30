package pe.gob.sunafil.denunciavirtual.mybatis.implementacion;

import java.math.BigDecimal;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.denunciavirtual.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.denunciavirtual.mybatis.comunsiit.MyBatisConnectionFactorySiit;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTLevantamiento;
import pe.gob.sunafil.denunciavirtual.siit.persistence.client.IltmvRegistroentradaMapper;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltmvRegistroentrada;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltmvRegistroentradaExample;

public class IMPLevantamiento implements INTLevantamiento {
private static Logger logger = Logger.getLogger(IMPLevantamiento.class.getName());
	
	private SqlSessionFactory sqlSessionFactory;
	private SqlSessionFactory sqlSessionFactorySiit;
	
	public IMPLevantamiento() {
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
		sqlSessionFactorySiit=MyBatisConnectionFactorySiit.getSqlSessionFactory();
	}

	@Override
	public String obtieneNombresTrabajador(String n_codsol) throws Exception {
		logger.info("obteniendo el nombre del denunciante");
		SqlSession session = sqlSessionFactory.openSession();    	
		try {
		    return (String)session.selectOne("Levantamiento.obtieneNombresxCodSol", n_codsol);
		}finally{
	    	session.close();
	    }		
		
	}
	
	public int actualizarRegistroEntradaSIIT(IltmvRegistroentrada record, BigDecimal nCodsol) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactorySiit.openSession();
		IltmvRegistroentradaExample example = new IltmvRegistroentradaExample();
		example.createCriteria().andNCodsolEqualTo(nCodsol);
		IltmvRegistroentradaMapper mapper = sqlSession.getMapper(IltmvRegistroentradaMapper.class);		
		try {
			mapper.updateByExampleSelective(record, example);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarRegistroEntradaSIIT "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
}
