package pe.gob.sunafil.postulacioncas.mybatis.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.postulacioncas.bean.Reclamo;
import pe.gob.sunafil.postulacioncas.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTReporte;

public class IMPReporte implements INTReporte{
	
	private static Logger depurador = Logger.getLogger(IMPReporte.class.getName());
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPReporte(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	@Override
	public List<Map> reporteConstanciaReclamo(Reclamo reclamo) throws Exception {
		
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Reporte.reporteConstanciaReclamo", reclamo);			 
			return resultado;			
		} catch (Exception e) {			
			depurador.error(e.getMessage());
			return null;
		} finally {
			session.close();
		}

	}
}
