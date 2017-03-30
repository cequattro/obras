package pe.gob.sunafil.postulacioncas.mybatis.implementacion;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.postulacioncas.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTWebServicePideReniec;

public class IMPWebServicePideReniec implements INTWebServicePideReniec {
	
private SqlSessionFactory sqlSessionFactory;
	
	public IMPWebServicePideReniec(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@Override
	public String verifySessionWS() throws Exception {
		String resultado="";			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectOne("WebServicePideReniec.verifySessionWS");			 
			return resultado;			
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void savenewSessionWS(String v_sesion, String v_codsis) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Map parametros = new HashMap();
			parametros.put("v_sesion", v_sesion);
			parametros.put("v_codsis", v_codsis);
			session.insert("WebServicePideReniec.savenewSessionWS", parametros);
			session.commit();
			System.out.println("INSERTO savenewSessionWS");
		} catch (Exception e) {
			session.rollback();
			System.out.println("ERROR EN savenewSessionWS");
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
