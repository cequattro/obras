package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTRptNoMarcacion;

public class IMPRptNoMarcacion implements INTRptNoMarcacion{

private SqlSessionFactory sqlSessionFactory;
	
	public IMPRptNoMarcacion(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }
	
	public List<Map> reporteNoMarcacion(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("NoMarcacion.reporteNoMarcacion", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteNoMarcacion "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
}
