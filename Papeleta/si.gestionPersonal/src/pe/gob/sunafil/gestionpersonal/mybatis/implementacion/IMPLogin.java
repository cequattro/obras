package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import java.io.Serializable;

import pe.gob.sunafil.gestionpersonal.bean.Periodo;
import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTLogin;

public class IMPLogin implements INTLogin, Serializable {
	private SqlSessionFactory sqlSessionFactory;
	private static Logger depurador = Logger.getLogger(IMPLogin.class.getName());
    
	public IMPLogin(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
    }	

    
	public Periodo obtenerPeriodo() throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Periodo resultado=new Periodo();
		try {				
			
			resultado=session.selectOne("Login.listarPeriodo");		
		} catch (Exception e) {
			depurador.error("Error en IMPMuestraEmpresa>obtenerPeriodo: "+e.getMessage());			
		} finally {
			session.close();
		}
		return resultado;
	}
	
}
