package pe.gob.sunafil.gentrama.mybatis.implementacion;


import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.gentrama.bean.Expedientes2014AB;
import pe.gob.sunafil.gentrama.bean.ParamConsultaSIIT;
import pe.gob.sunafil.gentrama.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gentrama.mybatis.interfase.INTExpedientes2014AB;

public class IMPExpedientes2014AB implements INTExpedientes2014AB{
	
	private SqlSessionFactory sqlSessionFactory;
	private static Logger logger = Logger.getLogger(IMPExpedientes2014AB.class.getName());
	
	public IMPExpedientes2014AB(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	
	public String registrarExp2014ab(Expedientes2014AB exp) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		String resultado="";
		try {				
			logger.info("registrarExp2014ab::parametros de consulta: "+exp.toString());
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("v_numexpsanc", exp.getV_numexpsanc());
			parametros.put("d_fecaper", exp.getD_fecaper());
			parametros.put("n_numdepdes", exp.getN_numdepdes());
			parametros.put("v_numactinsp", exp.getV_numactinsp());
			parametros.put("v_anhoacta", exp.getV_anhoacta());
			parametros.put("n_numdep", exp.getN_numdep());
			parametros.put("d_fecnoti", exp.getD_fecnoti());
			parametros.put("v_codusureg", exp.getV_codusureg());
			parametros.put("v_hostreg", exp.getV_hostreg());
			parametros.put("v_result",new String());
			session.insert("Exp2014AB.registrarExp2014ab", parametros);
			resultado=(String)parametros.get("v_result");
			System.out.println("resultado consulta:=>>>>>>>>>"+resultado);
			session.commit();
			
		} catch (Exception e) {
			logger.error("Error en IMPExpedientes2014AB>registrarExp2014ab: "+e.getMessage(),e);			
		} finally {
			session.close();
		}
		return resultado;
	}
	
	public String obtDatosActa(Expedientes2014AB exp) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		String resultado="";
		try {				
			logger.info("obtDatosActa::parametros de consulta: "+exp.toString());
			resultado= (String)session.selectOne("Exp2014AB.obtDatosActa", exp);
			System.out.println("resultado consulta:=>>>>>>>>>"+resultado);
			session.commit();
			
		} catch (Exception e) {
			logger.error("Error en IMPExpedientes2014AB>obtDatosActa: "+e.getMessage(),e);			
		} finally {
			session.close();
		}
		return resultado;
	}
	
	
	public String registrarExp2014UnicoIlm(Expedientes2014AB exp) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		String resultado="";
		try {				
			logger.info("registrarExp2014UnicoIlm::parametros de consulta: "+exp.toString());
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("v_numexpsanc", exp.getV_numexpsanc());
			parametros.put("d_fecaper", exp.getD_fecaper());
			parametros.put("n_numdepdes", exp.getN_numdepdes());
			parametros.put("v_numactinsp", exp.getV_numactinsp());
			parametros.put("v_anhoacta", exp.getV_anhoacta());
			parametros.put("n_numdep", exp.getN_numdep());
			parametros.put("d_fecnoti", exp.getD_fecnoti());
			parametros.put("v_codusureg", exp.getV_codusureg());
			parametros.put("v_hostreg", exp.getV_hostreg());
			parametros.put("v_result",new String());
			session.insert("Exp2014AB.registrarExp2014UnicoIlm", parametros);
			resultado=(String)parametros.get("v_result");
			System.out.println("resultado consulta:=>>>>>>>>>"+resultado);
			session.commit();
			
		} catch (Exception e) {
			logger.error("Error en IMPExpedientes2014AB>registrarExp2014ab: "+e.getMessage(),e);			
		} finally {
			session.close();
		}
		return resultado;
	}

	public String currentDate() throws Exception 
	{
		SqlSession session=sqlSessionFactory.openSession();
		try {
			String result="";					
			ResultSet rs=session.getConnection().prepareStatement("select TO_CHAR(SYSDATE, 'dd/MM/yyyy') fecha from dual").executeQuery();
			while(rs.next())
			{
				result=rs.getString("fecha");
			}
			return result;
		} catch (Exception e) {
			logger.error("Error obteniendo la fecha de base de datos ::: "+e.getMessage(),e);
			return "";
		}finally {
			session.close();
		}
	}

}
