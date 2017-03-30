package pe.gob.sunafil.postulacioncas.mybatis.implementacion;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.postulacioncas.bean.Combo;
import pe.gob.sunafil.postulacioncas.managedBeans.CargaAppBean;
import pe.gob.sunafil.postulacioncas.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.postulacioncas.mybatis.despachadores.CombosDespatch;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTCombos;


/**
 *  Implementacion de la interfaz INTComun
 *
 */
public class IMPCombos implements INTCombos,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6659893109668917629L;
	private SqlSessionFactory sqlSessionFactory;

	private static Logger logger = Logger.getLogger(IMPCombos.class.getName());
	
	public IMPCombos(){
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	 /**
     * Metodo que retorna una lista de tipo de documentos para el registro del 
     * notificador.
     * @return Lista de tipos de documentos.
     * @param tipo
     * @throws DaoException En caso de Error, este es controlado con el DAOExepcion para registrar el Error.
     */	
	@Override
	public List<Combo> listaComboXTipo(String tipo) throws Exception {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			

			if("TipoDocIde".equalsIgnoreCase(tipo)){
				lista=session.selectList("Combos.tiposDocumentoIde");
			}else if("Departamento".equalsIgnoreCase(tipo)){
				lista=session.selectList("Combos.departamentos");
			}else if("TipoZona".equalsIgnoreCase(tipo)){
				lista=session.selectList("Combos.tiposDeZona");
			}else if("TipoVia".equalsIgnoreCase(tipo)){
				lista=session.selectList("Combos.tiposDeVia");
			}else if("Intendencia".equalsIgnoreCase(tipo)){
				lista=session.selectList("Combos.intendencias");
			}else if("Convocatorias".equalsIgnoreCase(tipo)){
				lista=session.selectList("Combos.convocatorias");
			}else if("EstadoCivil".equalsIgnoreCase(tipo)){
				lista=session.selectList("Combos.estadocivil");
			}
			
			
		} catch (Exception e) {
			logger.error("Error en listaTipoDocumentos: "+e.getMessage(),e);
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Combo> listaProvinciasxDep(String coddep) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			Map param = new HashMap<String, String>();
			param.put("coddep", coddep);
			lista=session.selectList("Combos.provinciasxDep",param);
			
		} catch (Exception e) {
			logger.error("Error en listaTipoDocumentos: "+e.getMessage(),e);
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Combo> listaDistritosxPro(String coddep,String codpro) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			Map param = new HashMap<String, String>();
			param.put("coddep", coddep);
			param.put("codpro", codpro);
			lista=session.selectList("Combos.distritosxPro",param);
			
		} catch (Exception e) {
			logger.error("Error en listaTipoDocumentos: "+e.getMessage(),e);
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Combo> listaTiposIdentifDeReclamo() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			
			lista=session.selectList("Combos.tiposIdentifDeReclamo");
			System.out.println("lista tiposIdentifDeReclamo=>"+lista.size());
		} catch (Exception e) {
			logger.error("Error en listaTipoDocumentos: "+e.getMessage(),e);
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Combo> departamentoByCod(String coddep) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			Map param = new HashMap<String, String>();
			param.put("coddep", coddep);
			lista=session.selectList("Combos.departamentoByCod",param);
			
		} catch (Exception e) {
			logger.error("Error al obtener los departamenteos en departamentoByCod: "+e.getMessage(),e);
			throw e;
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Combo> provinciaByCod(String coddep, String codpro) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			Map param = new HashMap<String, String>();
			param.put("coddep", coddep);
			param.put("codpro", codpro);
			lista=session.selectList("Combos.provinciaByCod",param);
			
		} catch (Exception e) {
			logger.error("Error en provinciaByCod: "+e.getMessage(),e);
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Combo> distritoByCod(String coddep, String codpro, String coddis) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			Map param = new HashMap<String, String>();
			param.put("coddep", coddep);
			param.put("codpro", codpro);
			param.put("coddis", coddis);
			lista=session.selectList("Combos.distritoByCod",param);
			
		} catch (Exception e) {
			logger.error("Error en distritoByCod: "+e.getMessage(),e);
			
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Combo> estadoCivilByCod(String codest) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			Map param = new HashMap<String, String>();
			param.put("codest", codest);
			lista=session.selectList("Combos.estadocivilByCod",param);
			
		} catch (Exception e) {
			logger.error("Error al obtener los estados civiles en estadoCivilByCod: "+e.getMessage(),e);
			throw e;
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Combo> convocatoriaByCod(String codconv) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			Map param = new HashMap<String, String>();
			param.put("codconv", codconv);
			lista=session.selectList("Combos.convocatoriaByCod",param);
			
		} catch (Exception e) {
			logger.error("Error al obtener convocatoria en convocatoriaByCod: "+e.getMessage(),e);
			throw e;
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Combo> restarFechas(String fi, String ff) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			Map param = new HashMap<String, String>();
			param.put("fi", fi);
			param.put("ff", ff);
			lista=session.selectList("Combos.restarFechas",param);
			
		} catch (Exception e) {
			logger.error("Error al obtener restarFechas: "+e.getMessage(),e);
			throw e;
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Combo> totalExperiencia(String codhv, String codtexp) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<Combo> lista=new ArrayList<Combo>();
		try {
			Map param = new HashMap<String, String>();
			param.put("codhv", codhv);
			param.put("codtexp", codtexp);
			lista=session.selectList("Combos.totalExperiencia",param);
			
		} catch (Exception e) {
			logger.error("Error al obtener totalExperiencia: "+e.getMessage(),e);
			throw e;
		} finally {
			session.close();
		}
		return lista;
	}

}
