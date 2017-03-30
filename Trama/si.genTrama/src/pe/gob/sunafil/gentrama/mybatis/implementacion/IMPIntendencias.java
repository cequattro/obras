package pe.gob.sunafil.gentrama.mybatis.implementacion;


import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gentrama.bean.Combo;
import pe.gob.sunafil.gentrama.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gentrama.mybatis.interfase.INTIntendencias;


/**
 *  * @author rgarrido
 *  Implementacion de la interfaz INTIntendencias
 *
 */
public class IMPIntendencias implements INTIntendencias,Serializable {
	
	/**
	 * 
	 */
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPIntendencias(){
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	/**
	 * Obtiene la lista de Intendencias con las que se consultará sobre las denuncias del trabajador
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Combo> listaIntendencias() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Combo> lista=new ArrayList<Combo>();	
			Map<String, ResultSet> parametros = new HashMap<String, ResultSet>();
			ResultSet cuLista=null;
			parametros.put("cuLista", cuLista); 
			session.selectList("ConsultaSIIT.obtieneIntendencias",parametros);   
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
