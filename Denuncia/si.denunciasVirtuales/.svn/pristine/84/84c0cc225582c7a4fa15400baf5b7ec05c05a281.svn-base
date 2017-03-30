package pe.gob.sunafil.denunciavirtual.mybatis.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.denunciavirtual.bean.Solicitud;
import pe.gob.sunafil.denunciavirtual.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTReporte;

public class IMPReporte implements INTReporte{
	
	private static Logger depurador = Logger.getLogger(IMPReporte.class.getName());
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPReporte(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	@Override
	public List<Map> reporteConstanciaReclamo(Solicitud solicitud) throws Exception {
		
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Reporte.reporteConstanciaSolicitud", solicitud);			 
			return resultado;			
		} catch (Exception e) {			
			depurador.error(e.getMessage());
			return null;
		} finally {
			session.close();
		}

	}
}
