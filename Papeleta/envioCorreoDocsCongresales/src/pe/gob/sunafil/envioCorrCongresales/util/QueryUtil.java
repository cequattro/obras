package pe.gob.sunafil.envioCorrCongresales.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;


/**
 * @author Analisis
 * 
 *   
 */
public class QueryUtil {



	public QueryUtil() {
	}

	

	
	public static ArrayList executeProcedure(Connection conn,
			String storeProcedure) throws QueryException {
		CallableStatement cstmt = null;
		ResultSet rs = null;
		int numParamsInput = 0;
		ArrayList outPutList = new ArrayList();
		try {
			cstmt = conn.prepareCall(CommandUtil.getProcedureName(
					storeProcedure, 1));
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(numParamsInput + 1);
			outPutList = CommandUtil.getVOList(rs); 
		} catch (SQLException e) {
			//logger.error("error SQLException, storeprocedure:"+ storeProcedure);
			throw new QueryException(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			//logger.error("error Exception, storeprocedure:" + storeProcedure);
			throw new QueryException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e1) {
				//logger.error("Error en Execute procedure:" + storeProcedure+ ", al cerrar Resultset");
			}
			try {
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e2) {
				///logger.error("Error en Execute procedure:" + storeProcedure	+ ", al cerrar CallableStatement");
			}
		}
		return outPutList;
	}
	
	
	public static ArrayList executeProcedure(Connection conn,
			String storeProcedure, ParameterCollection paramsInputCollection)
			throws QueryException {
		CallableStatement cstmt = null;
		ResultSet rs = null;
		int numParamsInput = 0; 
		ArrayList outPutList = new ArrayList();
		try {
			numParamsInput = paramsInputCollection.size();
			cstmt = conn.prepareCall(CommandUtil.getProcedureName(
					storeProcedure, numParamsInput + 1));
			for (int i = 1; i <= numParamsInput; i++) {
				Parameter parameter = (Parameter) paramsInputCollection
						.get(i - 1);
				CommandUtil.setParameter(cstmt, i, parameter);
			}

			cstmt.registerOutParameter(numParamsInput + 1,OracleTypes.CURSOR);
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(numParamsInput + 1);
			outPutList = CommandUtil.getVOList(rs);
		} catch (SQLException e) {
//			logger.error("error SQLException, storeprocedure:"							+ storeProcedure);
			throw new QueryException(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
//			logger.error("error Exception, storeprocedure:" + storeProcedure);
			throw new QueryException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e1) {
//				logger.error("Error en Execute procedure:" + storeProcedure						+ ", al cerrar Resultset");
			}
			try {
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e2) {
//				logger.error("Error en Execute procedure:" + storeProcedure						+ ", al cerrar CallableStatement");
			}
		}
		return outPutList;
	}
	 
	
	public static ArrayList executeProcedure(Connection conn,
			String storeProcedure, String paramsInputCollection[])
			throws QueryException {
		CallableStatement cstmt = null;
		ResultSet rs = null;
		int numParamsInput = 0;
		int numParamsOutput = 0;
		int numParamsTotal = 0;
		ArrayList outPutList = new ArrayList();
		try {
			numParamsInput = paramsInputCollection.length;
			cstmt = conn.prepareCall(CommandUtil.getProcedureName(
					storeProcedure, numParamsInput + 1));
			for (int i = 1; i <= numParamsInput; i++)
				cstmt.setString(i, paramsInputCollection[i - 1]);

			cstmt.registerOutParameter(numParamsInput + 1, OracleTypes.CURSOR);
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(numParamsInput + 1);
			outPutList = CommandUtil.getVOList(rs);
		} catch (SQLException e) {
//			logger.error("error SQLException, storeprocedure:"							+ storeProcedure);
			throw new QueryException(e.getMessage(), e);
		} catch (Exception e) {
//			logger.error("error Exception, storeprocedure:" + storeProcedure);
			throw new QueryException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e1) {
//				logger.error("Error en Execute procedure:" + storeProcedure						+ ", al cerrar Resultset");
			}
			try {
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e2) {
//				logger.error("Error en Execute procedure:" + storeProcedure						+ ", al cerrar CallableStatement");
			}
		}
		return outPutList;
	}

	public static String executeScalar(Connection conn, String storeProcedure,
			String paramsInputCollection[]) throws QueryException {
		ParameterCollection parameterCollection = new ParameterCollection();
		for (int i = 0; i < paramsInputCollection.length; i++)
			parameterCollection.addInput(paramsInputCollection[i]);

		ParameterCollection parameterOutputCollection = new ParameterCollection();
		parameterOutputCollection.addOutput(12);
		return (String) CommandUtil.executeScalar(conn, storeProcedure,
				parameterCollection, parameterOutputCollection);
	}
	
	
	public static void execute(Connection conn, String storeProcedure,
			String paramsInputCollection[]) throws QueryException {
		ParameterCollection parameterCollection = new ParameterCollection();
		for (int i = 0; i < paramsInputCollection.length; i++)
			parameterCollection.addInput(paramsInputCollection[i]);

		CommandUtil.execute(conn, storeProcedure, parameterCollection);
	}
}
