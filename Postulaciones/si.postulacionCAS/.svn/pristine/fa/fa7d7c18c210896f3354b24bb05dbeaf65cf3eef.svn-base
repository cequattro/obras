package pe.gob.sunafil.postulacioncas.mybatis.implementacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.postulacioncas.bean.Entidad;
import pe.gob.sunafil.postulacioncas.bean.Persona;
import pe.gob.sunafil.postulacioncas.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTPersonaPideReniec;
import pe.gob.sunafil.postulacioncas.utils.FacesUtils;





public class IMPPersonaPideReniec implements INTPersonaPideReniec {

	private static Logger depurador = Logger.getLogger(IMPPersonaPideReniec.class.getName());
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPPersonaPideReniec(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	}

	
	@Override
	public Entidad getPersona(Persona persona) throws Exception {
		System.out.println("buscando trabajador");
		Entidad bean = new Entidad();
		ResultSet set = null;
		Map parametros = new HashMap();
		parametros.put("v_codtdocide", persona.getV_codtdocide());
		parametros.put("v_numdoc", persona.getV_numdoc());
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			bean = (Entidad)session.selectOne("PersonaPideReniec.lstPersona", parametros);
			return bean;
			
		} catch (Exception e) {
			System.out.println("---no encontro nada, debe registrar");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}
	
	public String verificaActuPersonaReniec(Persona persona) throws Exception {
		 
		String resultado=null;
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			persona.setV_flgreniec("N");
			resultado=session.selectOne("PersonaPideReniec.verificaActuPersonaReniec", persona);
			return resultado;
			
		} catch (Exception e) {
			System.out.println("No se encontró la sesion en BD debera registrarse");
			e.printStackTrace();
			return "E";
		} finally {
			session.close();
		}

	}
	
	@Override
	public String insertarPersona(Persona persona) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		String mensaje="";
		try {
			persona.toString();
			String v_hostreg="" +FacesUtils.getIpAddress();
			persona.setV_hostreg(v_hostreg);
			session.insert("PersonaPideReniec.insertPersonaReniec", persona);			
			session.commit();			
		} catch (Exception e) {
			System.out.println("Error en IMPPersona>insertarPersona: "+e.getMessage());	
			mensaje=e.getMessage();				
			session.rollback();
		} finally {
			session.close();
		}
		return mensaje;
	}
	
	
	/**
	 * 
	 * @param Persona
	 * @return
	 * @throws Exception
	 */
	@Override
	public String actualizarPersona(Persona persona) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		String mensaje="";
		try {
			String v_hostmod="" +FacesUtils.getIpAddress();
			persona.setV_hostmod(v_hostmod);
			session.update("PersonaPideReniec.updatePersona", persona);
			session.commit();
		} catch (Exception e) {
			System.out.println("Error en IMPPersona>actualizarPersona: "+e.getMessage());	
			mensaje=e.getMessage();	
			session.rollback();
		} finally {
			session.close();
		}
		return mensaje;
	}

}
