package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.bean.Permisos;
import pe.gob.sunafil.gestionpersonal.bean.Usuario;
import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTLogueo;










/**
 * Implementacion de los Métodos Declarados en la Interfase INTLogueo.
 */
public class IMPLogueo implements INTLogueo{
	
	private SqlSessionFactory sqlSessionFactory;
    //Declaración de DEPURADOR para hacer el debug de la clase.
   
    
    /**
     * Declaracion de la instancia de la clase e inicializacion del DAOManager 
     * para el uso del Ibatis.
     * @param arg0 
     */
  public IMPLogueo(){
	  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	  
  }
    
    /**
     * M�todo que retorna el usuario consultado, teniendo como condici�n  de busqueda
     * el c�digo del usuario.
     * 
     * @return Lista de la consulta seg�n el Usuario Logueado.
     * @param loginForm 
     * @throws DaoException En caso de Error, �ste es controlado con el DAOExepcion para registrar el Error.
     */
    public List ValidaLogueo(Usuario loginForm) throws Exception{
    	 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
    		SqlSession session = sqlSessionFactory.openSession();
        try {                       
          
            //Declaraci�n del Objeto MAP para el envio de los par�metros.
            Map parametros = new HashMap();
            parametros.put("v_usuario",loginForm.getV_usuario().toUpperCase());
            ResultSet cuLista=null;
            parametros.put("cuLista", cuLista);            
            session.selectList("Logueo.obtieneUsuario",parametros);   
            List lista =(List) parametros.get("cuLista");
                
            System.out.println("numero "+lista.size());
            return lista;
        } catch (Exception e) {
        	System.out.println("Error ValidaLogueo "+e.getMessage());           
        }finally{
        	session.close();
        }
		return null;
    }
    
    public List getNombrePorUsername(String userName) throws Exception{
   	 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
   		SqlSession session = sqlSessionFactory.openSession();
       try {                       
         
           //Declaraci�n del Objeto MAP para el envio de los par�metros.
           Map parametros = new HashMap();
           parametros.put("v_usuario",userName);
           ResultSet cuLista=null;
           parametros.put("cuLista", cuLista);            
           session.selectList("Logueo.obtieneUsuario",parametros);   
           List lista =(List) parametros.get("cuLista");
               
           System.out.println("numero "+lista.size());
           return lista;                     
       } catch (Exception e) {
       	System.out.println("Error getNombrePorUsername "+e.getMessage());           
       }finally{
       	session.close();
       }
		return null;
   }
    
    
    /**
     * M�todo que retorna los permisos del usuario , teniendo como condici�n  de busqueda
     * el c�digo del usuario y el sistema.
     * 
     * @return Lista de la consulta seg�n los permisos encontrados.
     * @param usuarioBean 
     * @throws DaoException En caso de Error, �ste es controlado con el DAOExepcion para registrar el Error.
     */
   public List ObtienePermisos(Usuario usuarioBean) throws Exception{
	   
	   //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();
	   
        try {     
            
            //Declaraci�n del Objeto MAP para el envio de los par�metros.
            Map parametros = new HashMap();
            parametros.put("v_usuario",usuarioBean.getV_usuario().toUpperCase());                    
            parametros.put("v_codsis",usuarioBean.getV_codsis());            
            ResultSet cuLista=null;
            parametros.put("cuLista", cuLista);               
            session.selectList("Logueo.obtienePermisos",parametros); 
            List lista =(List) parametros.get("cuLista");
            
            return lista;
        } catch (Exception e) {             
        	System.out.println("Error ObtienePermisos "+e.getMessage());           
        }finally{
        	session.close();
        }
		return null;
    }    
         
    
        
    
 
    
     /**
     * M�todo con el que se obtiene la fecha de la Base de datos     
     * @return String con la Fecha de la BD formateada.
     * @throws DaoException En caso de Error, �ste es controlado con el DAOExepcion para registrar el Error.
     */
    public String ObtieneFecha() throws Exception{   
    	
    	 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();    	
    	   	
        try {           
            return (String)session.selectOne("obtieneFecha", null);
        } catch (Exception e) {
        	System.out.println("Error obtieneFecha "+e.getMessage());           
        }finally{
        	session.close();
        }
		return null;
    }
    
    public String ObtieneHora() throws Exception{   
    	
   	 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();    	
   	   	
       try {           
           return (String)session.selectOne("obtieneHora", null);
       } catch (Exception e) {
       	System.out.println("Error obtieneHora "+e.getMessage());           
       }finally{
       	session.close();
       }
		return null;
   }
    
    public String ObtieneFechaDMY() throws Exception{   
    	
   	 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();    	
   	   	
       try {           
           return (String)session.selectOne("obtieneFechaDMY", null);
       } catch (Exception e) {
       	System.out.println("Error obtieneFechaDMY "+e.getMessage());           
       }finally{
       	session.close();
       }
		return null;
   }
    
    /**
     * M?todo que retorna el Menu Hijo , teniendo como condici?n  de busqueda
     * el c?digo del usuario y el sistema.
     * 
     * @return Lista de la consulta seg?n los permisos encontrados.
     * @param usuarioBean 
     * @throws DaoException En caso de Error, ?ste es controlado con el DAOExepcion para registrar el Error.
     */
    public List ObtieneMenuHijo(Usuario usuarioBean) throws Exception{
    	
    	 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();
    	
        try {            
                      
            //Declaraci?n del Objeto MAP para el envio de los par?metros.
            Map parametros = new HashMap();
            parametros.put("v_usuario",usuarioBean.getV_usuario().toUpperCase());                    
            parametros.put("v_codsis",usuarioBean.getV_codsis());            
            ResultSet cuLista=null;
            parametros.put("cuLista", cuLista);           
              
            session.selectList("Logueo.obtieneMenuHijo",parametros);           
            List lista =(List) parametros.get("cuLista");
            return lista;
        } catch (Exception e) {             
        	System.out.println("Error ObtieneMenuHijo "+e.getMessage());           
        }finally{
        	session.close();
        }
		return null;
    }   
        
    
    
     /**
     * M?todo que retorna el Menu Padre , teniendo como condici?n  de busqueda
     * el perfil del usuario y el sistema.
     * 
     * @return Lista de la consulta seg?n los permisos encontrados.
     * @param usuarioBean 
     * @param permisosBean 
     * @throws DaoException En caso de Error, ?ste es controlado con el DAOExepcion para registrar el Error.
     */
    public List ObtieneMenuPadre(Usuario usuarioBean, Permisos permisosBean) throws Exception{
    	
    	 //declaracion del sqlSessionFactory para la ejecucion de sentencias en MyIbatis
		SqlSession session = sqlSessionFactory.openSession();    	
    	
        try {            
           
            
            //Declaraci?n del Objeto MAP para el envio de los par?metros.
            Map parametros = new HashMap();
            parametros.put("v_perfil",permisosBean.getV_codper());                    
            parametros.put("v_codsis",usuarioBean.getV_codsis());            
            ResultSet cuLista=null;
            parametros.put("cuLista", cuLista);              
           
            session.selectList("Logueo.obtieneMenuPadre",parametros);           
            List lista =(List) parametros.get("cuLista");
            return lista;
        } catch (Exception e) {             
        	System.out.println("Error ObtieneMenuPadre "+e.getMessage());           
        }finally{
        	session.close();
        }
		return null;
    }  

       
//---    
}
