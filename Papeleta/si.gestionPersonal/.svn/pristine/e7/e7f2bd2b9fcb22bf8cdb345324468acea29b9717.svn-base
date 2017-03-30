package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTRptMarcacionUnaPersona;

public class IMPReporteMarcacionesUnaPersona implements INTRptMarcacionUnaPersona {

private SqlSessionFactory sqlSessionFactory;
	
	public IMPReporteMarcacionesUnaPersona(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }
	
	public List<Map> reporteMarcacionesUnaPersona(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("RptMarcaciones.reporteMarcaciones", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteMarcacionesUnaPersona"+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
}
