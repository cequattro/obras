package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.reniec.rel.ReniecBean;

import pe.gob.sunafil.gestionpersonal.bean.Persona;
import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTPersona;



/**
 * 
 * @author Mario Zumaeta
 * 11/07/2013
 *
 */
public class IMPPersona implements INTPersona {

	private static Logger depurador = Logger.getLogger(IMPPersona.class.getName());
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPPersona(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@Override
	public Persona getTrabajador(Persona persona) throws Exception {
		System.out.println("buscando trabajador");
		Persona bean = new Persona();
		ResultSet set = null;
		Map parametros = new HashMap();
		parametros.put("v_codtdocide", persona.getV_codtdocide());
		parametros.put("v_numdoc", persona.getV_numdoc());
		parametros.put("cursorOut",set);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			session.selectOne("Persona.lstPersona", parametros);
			
			if (((List)parametros.get("cursorOut")).size()==0) {
				return null;
			} else {
				bean = (Persona)((List)parametros.get("cursorOut")).get(0);
				return bean;
			}
			
			
		} catch (Exception e) {
			System.out.println("---no encontro nada, debe registrar");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}
	
	@Override
	public List<Persona> listarPersona(Persona persona) throws Exception {
		System.out.println("buscando trabajador");
		List<Persona> resultado=new ArrayList<Persona>();
		ResultSet set = null;
		Map parametros = new HashMap();
		parametros.put("v_codtdocide", persona.getV_codtdocide());
		parametros.put("v_numdoc", persona.getV_numdoc());
		parametros.put("cursorOut",set);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			session.selectOne("Persona.lstPersona", parametros);
			
			resultado = (List<Persona>)parametros.get("cursorOut");
			return resultado;
			
		} catch (Exception e) {
			System.out.println("---no encontro nada, debe registrar");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}
	/**
	 * @author mzumaeta
	 * @FECHA 22/092013
	 */
	@Override
	public String insertarPersona(Persona persona) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		String mensaje="";
		try {
			persona.valuesToString();
			session.insert("Persona.insertPersona", persona);			
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
			session.update("Persona.updatePersona", persona);
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
