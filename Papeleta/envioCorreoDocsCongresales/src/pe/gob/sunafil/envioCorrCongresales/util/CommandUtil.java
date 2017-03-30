/*
 * Created on Oct 26, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package pe.gob.sunafil.envioCorrCongresales.util;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import oracle.sql.CLOB;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;



/**
 * @author Analisis
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class CommandUtil {

	

	private CommandUtil() {
	}

	
	public static String getProcedureName(String procedureName, int paramsQty) {
		String prepareCall = "";
		prepareCall = "{call " + procedureName + "(";
		for (int i = 0; i < paramsQty; i++)
			prepareCall = i >= paramsQty - 1 ? prepareCall + "?" : prepareCall
					+ "?,";

		prepareCall = prepareCall + ")}";
		return prepareCall;
	}
	
	/*
	public static ArrayList getVOList(ResultSet rs) throws Exception {
		String dynaBeanName = "ValueObject";
		ArrayList VOList = new ArrayList();
		HashMap map = new HashMap();
		ArrayList list = new ArrayList();
		int columnsNum = rs.getMetaData().getColumnCount();
		String columnName[] = new String[columnsNum];
		Class type = java.lang.String.class;
		try {
			for (int i = 0; i < columnsNum; i++) {
				columnName[i] = rs.getMetaData().getColumnName(i + 1);
				DynaProperty prop = new DynaProperty(columnName[i], type);
				list.add(prop);
			}

			DynaProperty properties[] = (DynaProperty[]) list.toArray(new DynaProperty[0]);
			org.apache.commons.beanutils.DynaBean dynaBean;
			
			
			for (; rs.next(); VOList.add(map)) {
				dynaBean = null;
				for (int i = 0; i < columnsNum; i++) {
					map = new HashMap();
					String name = columnName[i];
					String value = rs.getString(name);
					map.put(name, value);
					DynaClass dynaClass = new BasicDynaClass(dynaBeanName,null, properties);
					dynaBean = dynaClass.newInstance();
					BeanUtils.populate(dynaBean, map);
					
				}

			}

		} catch (SQLException e) {
			new QueryException(e.getMessage(), e);
		}
		catch (Exception e) {
			new QueryException(e.getMessage(), e);
		}
		return VOList;
	}*/

	public static ArrayList getVOList(ResultSet rs) throws Exception {
		String dynaBeanName = "ValueObject";
		ArrayList VOList = new ArrayList();
		HashMap map = new HashMap();
		ArrayList list = new ArrayList();
		int columnsNum = rs.getMetaData().getColumnCount();
		String columnName[] = new String[columnsNum];
		Class type = java.lang.String.class;
		try {
			for (int i = 0; i < columnsNum; i++) {
				columnName[i] = rs.getMetaData().getColumnName(i + 1);
				DynaProperty prop = new DynaProperty(columnName[i], type);
				list.add(prop);
			}

			DynaProperty properties[] = (DynaProperty[]) list.toArray(new DynaProperty[0]);
			org.apache.commons.beanutils.DynaBean dynaBean;
			for (; rs.next(); VOList.add(dynaBean)) {
				dynaBean = null;
				//System.out.println("***********************************************");
				for (int i = 0; i < columnsNum; i++) {
					String name = columnName[i];
					String value = rs.getString(name);
					map.put(name, value);
					//System.out.println("["+name+"]=> "+value);
					DynaClass dynaClass = new BasicDynaClass(dynaBeanName,
							null, properties);
					dynaBean = dynaClass.newInstance();
					BeanUtils.populate(dynaBean, map);
				}

			}

		} catch (SQLException e) {
//			logger.error(e.getMessage(), e);
			new QueryException(e.getMessage(), e);
		}
		catch (Exception e) {
//			logger.error(e.getMessage(), e);
			new QueryException(e.getMessage(), e);
		}
		return VOList;
	}
	
	
	public static void setParameter(CallableStatement cstmt, int i,
			Parameter parameter) throws SQLException {
		Object value = parameter.getDataValue();
		int dataType = parameter.getDatatype();
		if (dataType == 12)
			cstmt.setString(i, (String) value);
		if (dataType == 4)
			cstmt.setInt(i, Integer.parseInt((String) value));
		if (dataType == 2)
			cstmt.setBigDecimal(i, new BigDecimal((String) value));
		if (dataType == 91)
			cstmt.setDate(i, (Date) value);
		if (dataType == -1)			
			cstmt.setObject(i, value, java.sql.Types.LONGVARCHAR);
		if (dataType == 2005){			
			cstmt.setClob(i, (CLOB)value);
		}
			
		
	}
	public static Object executeScalar(Connection conn, String storeProcedure,
			ParameterCollection paramsInputCollection,
			ParameterCollection parameterOutputCollection)
			throws QueryException {
		CallableStatement cstmt = null;
		ResultSet rs = null;
		int numParamsInput = 0;
		int numParamsOutput = 0;
		int numParamsTotal = 0;
		Object outPut = null;
		try {
			numParamsInput = paramsInputCollection.size();
			numParamsOutput = parameterOutputCollection.size();
			numParamsTotal = numParamsInput + numParamsOutput;
			outPut = new Object();
			cstmt = conn.prepareCall(getProcedureName(storeProcedure,
					numParamsTotal));
			for (int i = 1; i <= numParamsInput; i++) {
				Parameter parameter = (Parameter) paramsInputCollection
						.get(i - 1);
				setParameter(cstmt, i, parameter);
			}

			for (int i = 1; i <= numParamsOutput; i++)
				cstmt.registerOutParameter(numParamsInput + i,
						parameterOutputCollection.getDataType(i - 1));

			cstmt.execute();
			outPut = getScalarResult(cstmt, parameterOutputCollection,
					numParamsInput);
		} catch (SQLException e) {
			System.out.println("Error SQLException en executeScalar:"
					+ storeProcedure+" e=>"+ e);
			throw new QueryException(e.getMessage(), e);
		} catch (Exception e) {
			System.out.println("Error Exception en executeScalar:" + storeProcedure
					+" e=>"+e);
			throw new QueryException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e1) {
				System.out.println("Error en executeScalar:" + storeProcedure
						+ " al cerrar rs o cstmt"+" e=>"+e1);
			}
		}
		return outPut;
	}
	
	public static Object getScalarResult(CallableStatement cstmt,
			ParameterCollection parameterOutputCollection, int numParamsInput)
			throws SQLException, Exception {
		Object out = new Object();
		int index = numParamsInput + 1;
		out = cstmt.getObject(index);
		return out;
	}
	public static void execute(Connection conn, String storeProcedure,
			ParameterCollection paramsInputCollection) throws QueryException {
		CallableStatement cstmt = null;
		ResultSet rs = null;
		int numParamsInput = 0;
		Object outPut = null;
		try {
			numParamsInput = paramsInputCollection.size();
			outPut = new Object();
			cstmt = conn.prepareCall(getProcedureName(storeProcedure,
					numParamsInput));
			for (int i = 1; i <= numParamsInput; i++) {
				Parameter parameter = (Parameter) paramsInputCollection
						.get(i - 1);
				setParameter(cstmt, i, parameter);
			}

			cstmt.execute();
		} catch (SQLException e) {
			System.out.println("Error SQLException en execute:" + storeProcedure+" e=>"+ e);
			throw new QueryException(e.getMessage(), e);
		} catch (Exception e) {
			System.out.println("Error Exception en execute:" + storeProcedure+" e=>"+ e);
			throw new QueryException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e1) {
				System.out.println("Error en execute:" + storeProcedure+ " al cerrar rs o cstmt"+" e=>"+ e1);
			}
		}
	}
}
