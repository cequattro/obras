package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTSeguridad;

 




public class IMPSeguridad implements INTSeguridad {
	
	static Logger depurador = Logger.getLogger(IMPSeguridad.class);
	private SqlSessionFactory sqlSessionFactory;

	public IMPSeguridad() {
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();

	}

	public String retornaFlgNuevo(Usuario usua) throws Exception {
		 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();
		
		try {			 
			return (String) session.selectOne("Seguridad.esUsuarioNuevo",	usua);
		} catch (Exception e) {			
			depurador.log(Level.ERROR, "ERROR : " + e.getMessage());
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}finally{
        	session.close();
        }
	}

	public String retornaFechaUltActualizacion(Usuario usua)
			throws Exception {
		
		 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			 
			return (String) session.selectOne("Seguridad.fechaUltActualizacion", usua);
		} catch (Exception e) {
			 
			depurador.log(Level.ERROR, "ERROR : " + e.getMessage());
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}finally{
        	session.close();
        }
	}

	public String retornaDiasCaducaFecha(Usuario usua) throws Exception {
		 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();		
		
		try {
			 
			return (String) session.selectOne("Seguridad.diasCaducaFecha", usua);
		} catch (Exception e) {
			 
			depurador.log(Level.ERROR, "ERROR : " + e.getMessage());
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}finally{
        	session.close();
        }
	}

	public String retornaDiasNoActualizaFecha(Usuario usua)
			throws Exception {
		 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();	
		
		try {
			 
			return (String) session.selectOne("Seguridad.diasNoActualizaFecha", usua);
		} catch (Exception e) {
			 
			depurador.log(Level.ERROR, "ERROR : " + e.getMessage());
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}finally{
        	session.close();
        }
	}

	public String retornaMeses(String valor) throws Exception {
		 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();	
		try {
			 
			return (String) session.selectOne("Seguridad.numMeses", valor);
		} catch (Exception e) {
			 
			depurador.log(Level.ERROR, "ERROR : " + e.getMessage());
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}finally{
        	session.close();
        }
	}

	public String retornaMesesValidacion() throws Exception {
		 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();	
		try {
			 
			return (String) session.selectOne("Seguridad.numMesValidacion");
		} catch (Exception e) {
			 
			depurador.log(Level.ERROR, "ERROR : " +  e.getMessage());
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}finally{
        	session.close();
        }
	}

	public List listaClavesDesencriptadas(Usuario usuario) throws Exception {
		 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();	
		try {			
			 Map para=new HashMap();
			 para.put("v_codusu",usuario.getV_codusu());
			 String v_codusu=usuario.getV_codusu();
			 List lista =new ArrayList();
			 lista= session.selectList("Seguridad.tresUltClavesEncriptadas", v_codusu);			
			return lista;
		} catch (Exception e) {
			 
			depurador.log(Level.ERROR, "ERROR : " +  e.getMessage());
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}finally{
        	session.close();
        }

	}

	public void cambiarClave(String codUsu, String passUsu, String nomHost)
			throws  Exception {
		 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();	
		try {			 

			Map parametros = new HashMap();
			parametros.put("p_v_codusu", codUsu);
			parametros.put("p_v_pass", passUsu);
			parametros.put("p_v_hostMod", nomHost);

			System.out.println("llega al dao con datos=>"+parametros.toString());
			session.update("Seguridad.cambiarClave", parametros);
			session.commit();
			System.out.println("no pasa el dao");
		} catch (Exception e) {
			session.rollback();
			System.out.println("Exception e=>"+e.getMessage());
			depurador.log(Level.ERROR, "ERROR : " + e.getMessage());
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}finally{
        	session.close();
        }
	}

}