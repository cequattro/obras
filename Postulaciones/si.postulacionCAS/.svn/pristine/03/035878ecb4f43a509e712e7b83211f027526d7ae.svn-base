package pe.gob.sunafil.postulacioncas.mybatis.implementacion;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.postulacioncas.managedBeans.CargaAppBean;
import pe.gob.sunafil.postulacioncas.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTLogueo;


/**
 * Implementacion de los Métodos Declarados en la Interfase INTLogueo.
 */
public class IMPLogueo implements INTLogueo{
	
	private SqlSessionFactory sqlSessionFactory;

	private static Logger logger = Logger.getLogger(CargaAppBean.class.getName());
   
    
	/**
	* Declaracion de la instancia de la clase e inicializacion del DAOManager 
	* para el uso del Ibatis.
	* @param arg0 
	*/
	public IMPLogueo(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  
	}
       
	/**
	* Método con el que se obtiene la fecha de la Base de datos     
	* @return String con la Fecha de la BD formateada.
	* @throws DaoException En caso de Error,este es controlado con el DAOExepcion para registrar el Error.
	*/
	public String ObtieneFecha() throws Exception{   
		
		//declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();    	
		   	
		try {           
		    return (String)session.selectOne("obtieneFecha", null);
		} catch (Exception e) {
			logger.error("Error ObtieneFecha "+e.getMessage(),e);           
	    }finally{
	    	session.close();
	    }
		return null;
	}
    

       
//---    
}
