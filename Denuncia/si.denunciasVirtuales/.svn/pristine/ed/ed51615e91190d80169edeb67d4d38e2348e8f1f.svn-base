package pe.gob.sunafil.denunciavirtual.mybatis.implementacion;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.denunciavirtual.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTWebService;

public class IMPWebService implements INTWebService {
	
private SqlSessionFactory sqlSessionFactory;
	
	public IMPWebService(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@Override
	public String verifySessionWS() throws Exception {
		String resultado="";			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			Map parametros = new HashMap();
			parametros.put("P_V_SESION",new String());
			session.selectOne("WebService.verifySessionWS", parametros);
			if(parametros.get("P_V_SESION")!= null){
				System.out.println(":::: "+parametros.get("P_V_SESION").toString());
			}else{
				System.out.println("No se encontró sesion para hoy.");
				return null;
			}
			
			return parametros.get("P_V_SESION").toString();		
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void savenewSessionWS(String v_sesion, String v_codsis,
			String v_flgerror) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Map parametros = new HashMap();
			parametros.put("v_sesion", v_sesion);
			parametros.put("v_codsis", v_codsis);
			parametros.put("v_flgerror", v_flgerror);//???????
			session.insert("WebService.savenewSessionWS", parametros);
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
