package pe.gob.sunafil.tramiteext.mybatis.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.tramiteext.mybatis.comuntr.MyBatisConnectionFactory;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTReporte;

public class IMPReporte implements INTReporte {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPReporte(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  
	  }
	
	/*
	 * Recupera el listado del reporte por usuario
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTReporte#reporteUsuario(java.util.Map)
	 */
	public List<Map> reporteUsuario(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Total.reporteUsuario", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteUsuario "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	/*
	 * Recupera el listado del reporte por procedimiento (TUPA)
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTReporte#reporteProcedimiento(java.util.Map)
	 */
	public List<Map> reporteProcedimiento(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Administrativo.reporteProcedimiento", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteProcedimiento "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	/*
	 * Recupera el listado del reporte consolidado
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTReporte#reporteProcedimiento(java.util.Map)
	 */
	public List<Map> reporteConsolidado(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Administrativo.reporteConsolidado", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteConsolidado "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}

}
