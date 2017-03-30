package pe.gob.sunafil.postulacioncas.mybatis.implementacion;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.postulacioncas.bean.Combo;
import pe.gob.sunafil.postulacioncas.bean.ParamConsultaSIIT;
import pe.gob.sunafil.postulacioncas.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTConsultaSIIT;

public class IMPConsultaSIIT implements INTConsultaSIIT{
	
	private SqlSessionFactory sqlSessionFactory;
	private static Logger logger = Logger.getLogger(IMPConsultaSIIT.class.getName());
	
	public IMPConsultaSIIT(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	/**
	 * Obtiene la lista de consulta principal del SIIT
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map>  obtListaConsultaSIIT(ParamConsultaSIIT parametro) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		List<Map>  lista=new ArrayList<Map>();
		try {				
			logger.info("parametros de consulta:\n"+parametro.toString());
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("v_nroregmp", parametro.getNroRegMP());
			parametros.put("v_anioregmp", parametro.getAnioRegMP());
			parametros.put("n_numdep",parametro.getV_codIntendencia());
			ResultSet cursorOut=null;
			parametros.put("cuLista",cursorOut);
			session.selectList("ConsultaSIIT.consultaSIIT", parametros);
			lista=(List<Map>)parametros.get("cuLista");
			
			System.out.println("tamaño de lista=>"+lista.size());
			
		} catch (Exception e) {
			logger.error("Error en IMPConsultaSIIT>obtListaConsultaSIIT: "+e.getMessage(),e);			
		} finally {
			session.close();
		}
		return lista;
	}
	
	/**
	 * Metodo utilizado para verificar el Registro de Mesa de Partes, si existe para lima, o si es antiguo, etc.
	 */
	public String verificarRMP(ParamConsultaSIIT parametro) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		String resultado="";
		try {				
			logger.info("verificarRMP::parametros de consulta: "+parametro.toString());
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("v_nroregmp", parametro.getNroRegMP());
			parametros.put("v_anioregmp", parametro.getAnioRegMP());
			parametros.put("n_numdep",parametro.getV_codIntendencia());
			parametros.put("v_result",new String());
			session.selectList("ConsultaSIIT.verificarRMP", parametros);
			resultado=(String)parametros.get("v_result");
			System.out.println("resultado consulta:=>>>>>>>>>"+resultado);
			
		} catch (Exception e) {
			logger.error("Error en IMPConsultaSIIT>verificarRMP: "+e.getMessage(),e);			
		} finally {
			session.close();
		}
		return resultado;
	}
	
	
	/**
	 * Obtiene la lista de Materias Asignadas de una Orden de Inspección
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> obtMateriasAsigXOI(String numorden, String anioorden,String numdeporden) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		List<Map>  lista=new ArrayList<Map>();
		try {				
			logger.info("parametros de consulta:\n"+numorden+"-"+anioorden+"-"+numdeporden);
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numorden", numorden);
			parametros.put("anioorden", anioorden);
			parametros.put("numdeporden",numdeporden);
			ResultSet cuLista=null;
			parametros.put("cuLista", cuLista);
			
			session.selectList("ConsultaSIIT.obtMateriasAsigXOI", parametros);
			lista =(List<Map>)parametros.get("cuLista");
			
			System.out.println("tamaño de lista=>"+lista.size());
			
            
		} catch (Exception e) {
			logger.error("Error en IMPConsultaSIIT>obtMateriasAsigXOI: "+e.getMessage(),e);			
		} finally {
			session.close();
		}
		return lista;
		
	}
	
	/**
	 * Obtiene la lista de Numeros de Acta, Expediente Sanc, Resol 1ra y 2da Instancia
	 */
	@SuppressWarnings("unchecked")
	public List<Map> obtListaEtapaSancionadora(String numorden, String anioorden,String numdeporden) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		List<Map>  lista=new ArrayList<Map>();
		try {				
			logger.info("parametros de consulta:\n"+numorden+"-"+anioorden+"-"+numdeporden);
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numorden", numorden);
			parametros.put("anioorden", anioorden);
			parametros.put("numdeporden",numdeporden);
			ResultSet cuLista=null;
			parametros.put("cuLista", cuLista);
			
			session.selectList("ConsultaSIIT.obtListaEtapaSancionadora", parametros);	
			lista =(List<Map>)parametros.get("cuLista");
			
		} catch (Exception e) {
			logger.error("Error en IMPConsultaSIIT>consultarRetcc: "+e.getMessage(),e);			
		} finally {
			session.close();
		}
		return lista;
		
	}
	
	/**
	 * Se obtiene la lista de años para buscar en la BD
	 */
	@SuppressWarnings("unchecked")
	public List<Combo> listaAnhos() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Combo> lista=new ArrayList<Combo>();	
			Map<String, ResultSet> parametros = new HashMap<String, ResultSet>();
			ResultSet cuLista=null;
			parametros.put("cuLista", cuLista); 
			session.selectList("ConsultaSIIT.obtieneAnhos",parametros);   
            lista =(List<Combo>)parametros.get("cuLista");
			return lista;
		} catch (Exception e) {
			System.out.println("Error en busqueda: "+e.getMessage());
			
		} finally {
			session.close();
		}
		return null;
	}

}
