/*
 * Created on Oct 26, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package pe.gob.sunafil.envioCorrCongresales.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import pe.gob.sunafil.envioCorrCongresales.varios.DBConn;


/**
 * 
 * @author rgarrido
 *
 */
public class AplicationUtil {
	
	 public  AplicationUtil(){
		 
	 }
	
		public static Connection getConnection() {
			Connection con = null;
			DBConn cnx = new DBConn();
			con=cnx.getConnection();
			return con;
			
		}
	 
	 /*********************************************************************************************/
	 /*********************************************************************************************/
	
	 
	 public static String traeDato(String sql,String campo)throws SQLException{
	    
	 	String  dato=null;
	 	Connection con = getConnection();
		
		Statement stm = con.createStatement();
		String  select =sql;
		System.out.println("cadena===>"+ select);
		
		ResultSet rst = stm.executeQuery(select);
		
		try {
			while (rst.next()) {
				dato = rst.getString(campo);

			}
			rst.close();
			stm.close();
			con.close();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage()+"--"+ e1);
			}
		finally {
			try {
				con.close();
			} catch (SQLException e1) {
				System.err.println(e1.getMessage()+"--"+ e1);
				e1.printStackTrace();
			}
		}
		
		return dato;

 }
	 
	 
	 public static ArrayList obtieneColeccion(String procedure, String[] paramsInputCollection)throws SQLException{
		    
		 ArrayList lista = new ArrayList();
		
		 Connection con = getConnection();
		 
			CallableStatement cs = null;
			ResultSet rs = null;

			
			try {
				lista = QueryUtil.executeProcedure(con, procedure, paramsInputCollection);
				
			} catch (QueryException e2) {
				e2.printStackTrace();
			}  finally {
				try {
					con.close();
				} catch (SQLException e1) {
					System.out.print("Error al finalizando conexion");
					System.err.println(e1.getMessage()+"--"+ e1);
					e1.printStackTrace();
				}
			}
			return lista;

	 }
	 
	 public static ArrayList CargaCombo(String procedure,String condicion[])throws SQLException{
		    
		 ArrayList lista = new ArrayList();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
			try {
				String[] param= new String[condicion.length];
			
				con = getConnection();
			
				for(int i=0;i<condicion.length;i++){
					param[i]=condicion[i];
				}
				lista = QueryUtil.executeProcedure(con,procedure,param);
//			     logger.info("lista--->"+lista.size());
			} catch (QueryException e2) {
			
				e2.printStackTrace();
			
			} finally {
				try {
					con.close();
				} catch (SQLException e1) {					
//					logger.info(e1.getMessage(), e1);
				}
			}
			return lista;
	
	 }
	 
	 public static ArrayList CargaCombo(String procedure)throws SQLException{
		    
		 ArrayList lista = new ArrayList();
			Connection con = null;
			CallableStatement cs = null;
			ResultSet rs = null;

			
			try {
				
				con = getConnection();
				lista = QueryUtil.executeProcedure(con,procedure);

//				logger.info("size*******" + lista.size());

			} catch (QueryException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				// } catch (JDBCUtilException e) {
				// logger.info(e.getMessage(), e);
				// throw new DAOException(e.getMessage(), e);
			}finally {
				try {
					con.close();
				} catch (SQLException e1) {
//					logger.info(e1.getMessage(), e1);
				}
			}
			return lista;
	
	 }
	 
	 public static String obtieneString(String procedure, String params[]) throws Exception{ 
	    	Connection con = null;
	    	String datoString="";
			try{
				con = getConnection();
				datoString = (String)QueryUtil.executeScalar(con, procedure, params);
			}finally {
				try {
					con.close();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage()+" e=>"+ e1);
				}
			}
			return datoString;
		}
	 
	 public static Collection CargaCombo(String tabla, String codigo, String descripcion, String condicion) throws SQLException {

			Collection combo = new ArrayList();

			String sql = "";
			Connection con = getConnection();
			Statement stm = con.createStatement();
			sql = "select " + codigo + "," + descripcion + " from " + tabla + " " + condicion;

			try {
				ResultSet rst = stm.executeQuery(sql);
				while (rst.next()) {
					ComboBean vo = new ComboBean();
					vo.setV_codigo(rst.getString(1));
					vo.setV_nombre(rst.getString(2));
					combo.add(vo);
				}

				rst.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				throw new SQLException("OracleUtilDAO: cargaCombo(): SQLException: " + e.toString());
			} finally {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			return combo;
		}
}
