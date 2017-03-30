package pe.gob.sunafil.denunciavirtual.mybatis.implementacion;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.reniec.rel.ReniecBean;

import pe.gob.sunafil.denunciavirtual.bean.Persona;
import pe.gob.sunafil.denunciavirtual.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTPersonaReniec;





public class IMPPersonaReniec implements INTPersonaReniec {

	private static Logger depurador = Logger.getLogger(IMPPersonaReniec.class.getName());
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPPersonaReniec(){
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
			
			session.selectOne("PersonaReniec.lstPersona", parametros);
			
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
	
	public String verificaActuPersonaReniec(Persona persona) throws Exception {
		System.out.println("::: "+persona.getV_numdoc());
		String resultado=null;
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			persona.setV_flgreniec("N");
			Map parametros = new HashMap();
			parametros.put("v_numdoc", persona.getV_numdoc());
			parametros.put("P_V_EXISTE",new String());
			session.selectOne("PersonaReniec.verificaActuPersonaReniec", parametros);
			System.out.println(":::: "+parametros.get("P_V_EXISTE").toString());
			
			return parametros.get("P_V_EXISTE").toString();
			
		} catch (Exception e) {
			System.out.println("---no encontro nada, debe registrar");
			e.printStackTrace();
			return "E";
		} finally {
			session.close();
		}

	}
	
	@Override
	public String insertarPersona(ReniecBean persona, String ip, String vNomusureg) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		String mensaje="";
		try {
			persona.valuesToString();
			
			Map parametros = new HashMap();
			parametros.put("v_numdoc", persona.getV_numdoc());
			parametros.put("v_appaterno", persona.getV_appaterno());
			parametros.put("v_apmaterno", persona.getV_apmaterno());
			parametros.put("v_nombres", persona.getV_nombres());
			parametros.put("v_fecnac", persona.getV_fecnac());
			parametros.put("v_genero", persona.getV_genero());
			parametros.put("v_estciv", persona.getV_estciv());			
			parametros.put("v_nompadre", persona.getV_nompadre());
			parametros.put("v_nommadre", persona.getV_nommadre());
			parametros.put("v_fecinscrip", persona.getV_fecinscrip());
			parametros.put("v_fecemision", persona.getV_fecemision());
			parametros.put("v_codverific", persona.getV_codverific());
			parametros.put("v_coddepnac", persona.getV_coddepnac());
			parametros.put("v_codprovnac", persona.getV_codprovnac());
			parametros.put("v_coddisnac", persona.getV_coddisnac());
			parametros.put("v_desdepnac", persona.getV_desdepnac());
			parametros.put("v_desprovnac", persona.getV_desprovnac());
			parametros.put("v_desdisnac", persona.getV_desdisnac());
			parametros.put("v_coddepdom", persona.getV_coddepdom());
			parametros.put("v_codprovdom", persona.getV_codprovdom());
			parametros.put("v_coddisdom", persona.getV_coddisdom());
			parametros.put("v_desdepdom", persona.getV_desdepdom());
			parametros.put("v_desprovdom", persona.getV_desprovdom());
			parametros.put("v_desdisdom", persona.getV_desdisdom());
			parametros.put("v_dirdom", persona.getV_dirdom());
			System.out.println("IP :: "+ip);
			parametros.put("v_ip", ip);
			parametros.put("v_nomusureg", vNomusureg);
			parametros.put("V_SALIDA",new String());
			
			session.insert("PersonaReniec.insertPersona", parametros);			
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
	public String actualizarPersona(ReniecBean persona, String ip, String vNomusureg) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		String mensaje="";
		try {
			Map parametros = new HashMap();
			parametros.put("v_numdoc", persona.getV_numdoc());
			parametros.put("v_appaterno", persona.getV_appaterno());
			parametros.put("v_apmaterno", persona.getV_apmaterno());
			parametros.put("v_nombres", persona.getV_nombres());
			parametros.put("v_fecnac", persona.getV_fecnac());
			parametros.put("v_genero", persona.getV_genero());
			parametros.put("v_estciv", persona.getV_estciv());			
			parametros.put("v_nompadre", persona.getV_nompadre());
			parametros.put("v_nommadre", persona.getV_nommadre());
			parametros.put("v_fecinscrip", persona.getV_fecinscrip());
			parametros.put("v_fecemision", persona.getV_fecemision());
			parametros.put("v_codverific", persona.getV_codverific());
			parametros.put("v_coddepnac", persona.getV_coddepnac());
			parametros.put("v_codprovnac", persona.getV_codprovnac());
			parametros.put("v_coddisnac", persona.getV_coddisnac());
			parametros.put("v_desdepnac", persona.getV_desdepnac());
			parametros.put("v_desprovnac", persona.getV_desprovnac());
			parametros.put("v_desdisnac", persona.getV_desdisnac());
			parametros.put("v_coddepdom", persona.getV_coddepdom());
			parametros.put("v_codprovdom", persona.getV_codprovdom());
			parametros.put("v_coddisdom", persona.getV_coddisdom());
			parametros.put("v_desdepdom", persona.getV_desdepdom());
			parametros.put("v_desprovdom", persona.getV_desprovdom());
			parametros.put("v_desdisdom", persona.getV_desdisdom());
			parametros.put("v_dirdom", persona.getV_dirdom());			
			parametros.put("v_ip", ip);
			parametros.put("v_nomusureg", vNomusureg);
			parametros.put("V_SALIDA",new String());
			
			session.update("PersonaReniec.updatePersona", parametros);
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
	
	
	@Override
	public ReniecBean getTrabajador(String dni) throws Exception {
		System.out.println("buscando trabajador");
		ReniecBean bean = new ReniecBean();
		ResultSet set = null;
		Map parametros = new HashMap();
		parametros.put("P_V_DNI", dni);
		parametros.put("cursorOut",set);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			session.selectOne("PersonaReniec.getTrabajador", parametros);
			
			if (((List)parametros.get("cursorOut")).size()==0) {
				return null;
			} else {
				bean = (ReniecBean)((List)parametros.get("cursorOut")).get(0);
				bean.setV_coderror("0000");
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

}
