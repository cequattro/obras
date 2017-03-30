package pe.gob.sunafil.envioCorrCongresales.varios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.PropertyResourceBundle;

import javax.sql.DataSource;


public class DBConn {
private static String sDriverBD = null;
private static String sUsuarioBD = null;
private static String sClaveBD = null;
private static String sURLBD = null;

static PropertyResourceBundle properties;
private static DataSource ds = null;


//private String sourceURL 	= "jdbc:oracle:thin:@//odbscan.trabajo.gob.pe:1521/ORAZEUSX";    	
//private String user 		= "NOTIFSYS";
//private String password 	= "c4u3g26z262";

//PRODSUNA
private String sourceURL 	= "jdbc:oracle:thin:@10.1.200.18:1521:PRODSUNA";    	
private String user 		= "TRAMITE";
private String password 	= "tramite";

//DESASUNA
//private String sourceURL 	= "jdbc:oracle:thin:@10.1.200.30:1521:DESASUNA";  	
//private String user 		= "TRAMITE";
//private String password 	= "destra_753";
          
	static {
	    //local
		
        try {Class.forName("oracle.jdbc.driver.OracleDriver");                 
		} catch (Exception e) {
			System.out.println("ERROR EN EL DRIVER => "+e);
		}
		
        /*
		//PRODUCCION
		try{
			//Context initCtx = new InitialContext();
			//Context envCtx = (Context) initCtx.lookup("java:comp/env");
			// se crea y apunta al pool de conecciones
			//ds = (DataSource)envCtx.lookup("jdbc/Inspecciones");
                       
                        //para JBOSS
                        Context ctx=new InitialContext();
                        ds=(DataSource) ctx.lookup("java:/si.inspecciones");
                        //
                        
                        System.out.println(ds);		
			System.out.println(ds.getClass());		
				
		}catch(Exception ce){
				System.out.println("DATA SOURCE ERROR: "+ce.getMessage());
		}
		*/
	}
	
	/**
	 * Obtiene una conexión a la Base de Datos.
	 */
        
	public Connection getConnection() {

		Connection connection = null;
		try {
			
			System.out.println("Listo para la coneccion");
             //PRODUCCION
//		 	 connection = ds.getConnection();
             //LOCAL
             connection = DriverManager.getConnection(sourceURL, user, password);
			 System.out.println("Conneccion Realizada");
			
		} catch (Exception e) {
			System.out.println("ERROR EN EL GETCONNECTION: "+ e);

		}
		return connection;
	}
    
	
  public static Connection beginTrans()  {
    Connection con = null;
    try {
      con = ds.getConnection();
      
      if (con==null)
        throw new Exception();

      if (con.getAutoCommit())    {
        con.setAutoCommit(false);        
        con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
        
        return con;
      }
      else {
        return con;
      }
    }
    catch(Exception e)  {
      System.out.println("Error: "+e);
      return null;
    }
 }

  public static void commitTrans(Connection con)  {
    try {
      System.out.println("Listo para hacer el COMMIT");
      con.commit();
      con.close();
      System.out.println("COMMIT HECHO");
    } catch(Exception e)  {
      System.out.println("ERROR COMMIT => " + e);
      try {con.close();} catch(Exception ex) {}
    }
  }

  public static void rollbackTrans(Connection con)  {
    try {
        
      con.rollback();
      con.close();
      
    } catch(Exception e) { 
      try {con.close();
      } catch(Exception ex)  {} 
    }
  }

  /**
   * Metodo usado para las consultas de masivo rucs en operativos y trabajador
   * @return
   */
  public Connection getBDConnection() {
	   
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Listo para la coneccion");            
            connection = DriverManager.getConnection(sourceURL, user, password);
			//System.out.println("Conneccion Realizada");
			
		} catch (Exception e) {
			System.out.println("ERROR EN EL GETCONNECTION: "+ e);

		}
		return connection;
	}
  
        
}
