package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTReporteSTemprano;

public class IMPReporteSTemprano implements INTReporteSTemprano{

private SqlSessionFactory sqlSessionFactory;
	
	public IMPReporteSTemprano(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }
	
	public List<Map> reporteSTemprano(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("SaleAntes.reporteSaleAntes", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteTardanza "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
}
