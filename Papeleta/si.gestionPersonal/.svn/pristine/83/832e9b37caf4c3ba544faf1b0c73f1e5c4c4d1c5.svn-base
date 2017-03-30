package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.bean.Persona;
import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTReporte;

public class IMPReporte implements INTReporte {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPReporte(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }
		
	public List<Map> reportePersonal(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("GesPer.reportePersonal", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reportePersonal "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	public List<Map> reportePersonalIndividual(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("GesPer.reportePersonalIndividual", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reportePersonal "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	public List<Map> reporteInasistencia(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Inasistencia.reporteInasistencia", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteInasistencia "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	public List<Map> reporteTardanza(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Tardanza.reporteTardanza", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteTardanza "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	public String ObtieneFechaDMY() throws Exception{   
    	
	   	 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
			SqlSession session = sqlSessionFactory.openSession();    	
	   	   	
	       try {           
	           return (String)session.selectOne("obtieneFechaDMY", null);
	       } catch (Exception e) {
	       	System.out.println("Error obtieneFechaDMY "+e.getMessage());           
	       }finally{
	       	session.close();
	       }
			return null;
	   }
	
	public String getPwdMaster() throws Exception {		
		String resultado=null;
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Map parametros = new HashMap();
			parametros.put("PASSW",new String());
			session.selectOne("pwdMaster", parametros);	
			return parametros.get("PASSW").toString();
			
		} catch (Exception e) {
			System.out.println("---no encontro clave maestra por defecto---");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}
	
}
