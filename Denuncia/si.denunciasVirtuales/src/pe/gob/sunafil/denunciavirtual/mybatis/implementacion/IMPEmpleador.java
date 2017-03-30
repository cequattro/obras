package pe.gob.sunafil.denunciavirtual.mybatis.implementacion;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.denunciavirtual.bean.Empresa;
import pe.gob.sunafil.denunciavirtual.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.denunciavirtual.mybatis.comunsiit.MyBatisConnectionFactorySiit;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTEmpleador;
import pe.gob.sunafil.denunciavirtual.persistence.client.DlmvSolicitudMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.DlmvdDocxsolMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.DltbEmpleadorMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.DltbcMateriaMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.SitbDepxdistritoMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.SitbTipomonedaMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.TdmvcHojarutaMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.TdmvcRegistroMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.TdtbcCorrelativoMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.TdtbcEntidadMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.TdtbcIntendenciaMapper;
import pe.gob.sunafil.denunciavirtual.persistence.client.TdtbdCentrolabMapper;
import pe.gob.sunafil.denunciavirtual.persistence.model.DlmvSolicitud;
import pe.gob.sunafil.denunciavirtual.persistence.model.DlmvSolicitudExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.DlmvdDocxsol;
import pe.gob.sunafil.denunciavirtual.persistence.model.DltbEmpleador;
import pe.gob.sunafil.denunciavirtual.persistence.model.DltbEmpleadorExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.DltbcMateria;
import pe.gob.sunafil.denunciavirtual.persistence.model.DltbcMateriaExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbDepxdistrito;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbDepxdistritoExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbTipomoneda;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbTipomonedaExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdmvcHojarutaExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdmvcHojarutaKey;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcCorrelativo;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcCorrelativoExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcEntidad;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcEntidadExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcIntendenciaExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbdCentrolab;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbdCentrolabExample;
import pe.gob.sunafil.denunciavirtual.siit.persistence.client.IltbcSoldenvirtualMapper;
import pe.gob.sunafil.denunciavirtual.siit.persistence.client.IltbcUnidadMapper;
import pe.gob.sunafil.denunciavirtual.siit.persistence.client.SitbEmpleadorMapper;
import pe.gob.sunafil.denunciavirtual.siit.persistence.client.VstIntendenRegionalesMapper;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcSoldenvirtual;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcUnidad;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcUnidadExample;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.SitbEmpleador;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.SitbEmpleadorExample;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.VstIntendenRegionales;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.VstIntendenRegionalesExample;

public class IMPEmpleador implements INTEmpleador {

	private static Logger logger = Logger.getLogger(IMPEmpleador.class.getName());
	
	private SqlSessionFactory sqlSessionFactory;
	private SqlSessionFactory sqlSessionFactorySiit;
	
	public IMPEmpleador() {
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
		sqlSessionFactorySiit=MyBatisConnectionFactorySiit.getSqlSessionFactory();
	}

	@Override
	public String verificarEmpMTPE(Empresa empresa) throws Exception {
		System.out.println("Verificando Empleador MTPE");
		SqlSession session = sqlSessionFactory.openSession();
		try{
			ResultSet set = null;
			Map parametros = new HashMap();
			parametros.put("P_V_CODEMP", empresa.getV_codemp());
			session.selectOne("Empleador.verificarEmpMTPE", parametros);
			System.out.println(":::: "+parametros.get("P_V_RESULT").toString());			
			return parametros.get("P_V_RESULT").toString();
		}catch(Exception e){
			logger.error("Ocurrio un error al verificar la competencia de la empresa (verificarEmpMTPE)=>"+e.getMessage(),e);
			throw e;
		} finally {
			session.close();
		}
	}
	
	public DltbEmpleador getEmpleadorPorCodigo(String vCodemp) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		DltbEmpleadorExample example = new DltbEmpleadorExample();
		example.createCriteria().andVCodempEqualTo(vCodemp);
		try {
			DltbEmpleadorMapper mapper = sqlSession.getMapper (DltbEmpleadorMapper. class);
			List <DltbEmpleador> allRecords = mapper.selectByExample(example);
			if(allRecords == null ){
				return null;
			}else if (allRecords.size() == 0){
				return null;
			}else{
				return allRecords.get(0);
			}
			
		} catch (Exception e) {
        	logger.error("Error al obtener el Empelador (getEmpleadorPorCodigo)=> "+e.getMessage(),e);   
        	throw e;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public SitbEmpleador getSitbEmpleadorPorRUC(String vCodemp) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactorySiit.openSession();		
		SitbEmpleadorExample example = new SitbEmpleadorExample();
		example.createCriteria().andVCodempEqualTo(vCodemp);
		try {
			SitbEmpleadorMapper mapper = sqlSession.getMapper (SitbEmpleadorMapper. class);
			List <SitbEmpleador> allRecords = mapper.selectByExample(example);
			if(allRecords == null ){
				return null;
			}else if (allRecords.size() == 0){
				return null;
			}else{
				return allRecords.get(0);
			}
			
		} catch (Exception e) {
        	logger.error("Error al obtener el Empelador (getEmpleadorPorCodigo)=> "+e.getMessage(),e);   
        	throw e;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarEmpleador(DltbEmpleador entidad)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			DltbEmpleadorMapper mapper = sqlSession.getMapper(DltbEmpleadorMapper.class);
			mapper.insert(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			logger.error("Error al insertarEmpleador =>"+e.getMessage(),e);   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public List <String> getIntendenciasHabilitadasSIIT() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactorySiit.openSession();	
		List<String> stringValues = new ArrayList<String>();
		IltbcUnidadExample example = new IltbcUnidadExample();
		example.createCriteria().andVFlgsunafEqualTo("1").andVFlgsegtraEqualTo("1");
		try {
			IltbcUnidadMapper mapper = sqlSession.getMapper (IltbcUnidadMapper. class);
			List <IltbcUnidad> allRecords = mapper.selectByExample(example);		
			for (IltbcUnidad s: allRecords){
				stringValues.add(s.getvUbigeo().substring(0, 2));
			}
			return stringValues;
		} catch (Exception e) {
        	logger.error("Error al obtener las intendencias habilitadas en el SIIT (getIntendenciasHabilitadasSIIT) =>"+e.getMessage(),e);   
        	throw e;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int obtieneNuevaSolicitud()
	{       	
	   SqlSession session = sqlSessionFactory.openSession();    	   	   	
       try {           
           return Integer.parseInt((String)session.selectOne("Empleador.obtieneNuevaSolicitud", null));
       } catch (Exception e) {
    	   logger.error("Error al obtener el correlativo de la solicitud obtieneNuevaSolicitud =>"+e.getMessage(),e);
    	   return -1;
       } finally{
    	   session.close();
       }
    }
	
	public int insertarSolicitud(DlmvSolicitud entidad)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DlmvSolicitudMapper mapper = sqlSession.getMapper(DlmvSolicitudMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			logger.error("Error al insertar la nueva solicitud insertarSolicitud=>"+e.getMessage(),e);
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizarSolicitud(DlmvSolicitud solicitud) 
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DlmvSolicitudMapper mapper = sqlSession.getMapper(DlmvSolicitudMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(solicitud);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {
			logger.error("Ocurrio un error al actualizar la solicitud con los nuevos datos del paso 3 (actualizarSolicitud) =>"+e.getMessage(),e);
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public List <SitbTipomoneda> getTipoMoneda() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbTipomonedaExample example = new SitbTipomonedaExample();
		example.createCriteria().andVCodtmonIsNotNull();
		try {
			SitbTipomonedaMapper mapper = sqlSession.getMapper (SitbTipomonedaMapper. class);
			List <SitbTipomoneda> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoMoneda "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int actualizarArchivo(DlmvdDocxsol archivo) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DlmvdDocxsolMapper mapper = sqlSession.getMapper(DlmvdDocxsolMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(archivo);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarArchivo "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public List <DltbcMateria> getMateria() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		DltbcMateriaExample example = new DltbcMateriaExample();
		example.createCriteria().andVFlgactEqualTo("S");
		try {
			DltbcMateriaMapper mapper = sqlSession.getMapper (DltbcMateriaMapper. class);
			List <DltbcMateria> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getMateria "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public String getCorrelativoSolicitud(String vAnhosol) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		DlmvSolicitudExample example = new DlmvSolicitudExample();
		example.createCriteria().andVAnhosolEqualTo(vAnhosol).andCorrelativoPorAnio(vAnhosol);
		try {
			DlmvSolicitudMapper mapper = sqlSession.getMapper (DlmvSolicitudMapper. class);
			List <DlmvSolicitud> allRecords = mapper.selectByExample(example);	
			return allRecords.get(0).getvNumsol();
			
		} catch (Exception e) {
        	logger.error("Error al obtener el correlativo de codigo de solicitud getCorrelativoSolicitud=>"+e.getMessage(),e);   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarRegistro(TdmvcRegistro registro)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdmvcRegistroMapper mapper = sqlSession.getMapper(TdmvcRegistroMapper.class);		
		try {			
			mapper.insertSelective(registro);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			logger.error("Error insertarRegistro "+e.getMessage(),e);   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public TdtbcIntendencia getIntendenciaPorUbigeo(String vUbigeo) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcIntendenciaExample example = new TdtbcIntendenciaExample();
		example.createCriteria().andVUbigeoEqualTo(vUbigeo);
		try {
			TdtbcIntendenciaMapper mapper = sqlSession.getMapper (TdtbcIntendenciaMapper. class);
			List <TdtbcIntendencia> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	logger.error("Error al obtener la intendencia por ubigeo para tramite getIntendenciaPorUbigeo =>"+e.getMessage(),e);   
        	throw e;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public TdtbcCorrelativo getCorrelativo(String vNumano, Short nNumdep, Short nNumtipodoc) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcCorrelativoExample example = new TdtbcCorrelativoExample();
		example.createCriteria().andNNumtipodocEqualTo(nNumtipodoc).andVNumanoEqualTo(vNumano).andNNumdepEqualTo(nNumdep);
		try {
			TdtbcCorrelativoMapper mapper = sqlSession.getMapper (TdtbcCorrelativoMapper. class);
			List <TdtbcCorrelativo> allRecords = mapper.selectByExample(example);
			if (allRecords.size()==0){
				return null;
			}else{
				return allRecords.get(0);
			}
			
		} catch (Exception e) {
        	logger.error("Error al obtener el correlativo de tramite getCorrelativo "+e.getMessage(),e);   
        	throw e;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int actualizarCorrelativo(TdtbcCorrelativo correlativo) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbcCorrelativoMapper mapper = sqlSession.getMapper(TdtbcCorrelativoMapper.class);		
		try {
			mapper.updateByPrimaryKey(correlativo);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			logger.error("Error al actualizar el Correlativo en Tramite actualizarCorrelativo "+e.getMessage(),e);   
        	throw e;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int insertarCorrelativo(TdtbcCorrelativo correlativo) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbcCorrelativoMapper mapper = sqlSession.getMapper(TdtbcCorrelativoMapper.class);		
		try {
			mapper.insert(correlativo);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			logger.error("Error al insertar el Correlativo en Tramite insertarCorrelativo "+e.getMessage(),e);   
        	throw e;
		} finally{
			sqlSession.close();			
		}
	}
	
	public TdmvcHojarutaKey getCorrelativoGlobal(Short vAniohoja) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdmvcHojarutaExample example = new TdmvcHojarutaExample();
		example.createCriteria().andVAniohojaEqualTo(vAniohoja).andCorrelativoPorAnio(vAniohoja);
		try {
			TdmvcHojarutaMapper mapper = sqlSession.getMapper (TdmvcHojarutaMapper. class);
			List <TdmvcHojarutaKey> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	logger.error("Error getCorrelativoGlobal "+e.getMessage(),e);   
        	throw e;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public void insertarCorrelativoGlobal(TdmvcHojarutaKey correlativoGlobal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdmvcHojarutaMapper mapper = sqlSession.getMapper(TdmvcHojarutaMapper.class);		
		try {
			mapper.insert(correlativoGlobal);
			sqlSession.commit();
		} catch (Exception e) {			
			logger.error("Error insertarCorrelativoGlobal "+e.getMessage(),e);   
        	throw e;
		} finally{
			sqlSession.close();			
		}
	}
	
	public TdtbcEntidad getEntidadPorCodigo(String vCodentidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcEntidadExample example = new TdtbcEntidadExample();
		example.createCriteria().andVCodentidadEqualTo(vCodentidad);
		try {
			TdtbcEntidadMapper mapper = sqlSession.getMapper (TdtbcEntidadMapper. class);
			List <TdtbcEntidad> allRecords = mapper.selectByExample(example);
			if(allRecords.size()==0){
				return null;
			}else{
				return allRecords.get(0);
			}
			
		} catch (Exception e) {
        	logger.error("Error getEntidadPorCodigo "+e.getMessage(),e);   
        	throw e;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarEntidad(TdtbcEntidad entidad) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbcEntidadMapper mapper = sqlSession.getMapper(TdtbcEntidadMapper.class);		
		try {
			mapper.insert(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			logger.error("Error insertarEntidad "+e.getMessage(),e);   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public int actualizarEntidad(TdtbcEntidad entidad){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbcEntidadMapper mapper = sqlSession.getMapper(TdtbcEntidadMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			logger.error("Error actualizarEntidad "+e.getMessage(),e);   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public Short getCorrelativoDireccionPorEntidad(String vCodentidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbdCentrolabExample example = new TdtbdCentrolabExample();
		example.createCriteria().andVCodentidadEqualTo(vCodentidad);
		Short max=0;
		try {
			TdtbdCentrolabMapper mapper = sqlSession.getMapper (TdtbdCentrolabMapper. class);
			List <TdtbdCentrolab> allRecords = mapper.selectByExample(example);		
			
			for (TdtbdCentrolab s: allRecords){
				if(s.getnCodcenlab()>max)
				{
					max=s.getnCodcenlab();
				}
			}
			return (short) (max+1);
		} catch (Exception e) {
        	logger.error("Error getCorrelativoDireccionPorEntidad "+e.getMessage(),e);   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarDireccion(TdtbdCentrolab direccion) 
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbdCentrolabMapper mapper = sqlSession.getMapper(TdtbdCentrolabMapper.class);		
		try {			
			mapper.insert(direccion);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			logger.error("Error insertarDireccion "+e.getMessage(),e);   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public DltbcMateria getMateriaPorCodigo(BigDecimal nCodmat) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		DltbcMateriaExample example = new DltbcMateriaExample();
		example.createCriteria().andNCodmatEqualTo(nCodmat);
		try {
			DltbcMateriaMapper mapper = sqlSession.getMapper (DltbcMateriaMapper. class);
			List <DltbcMateria> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getMateriaPorCodigo "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public SitbTipomoneda getMonedaPorCodigo(String vCodtmon) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbTipomonedaExample example = new SitbTipomonedaExample();
		example.createCriteria().andVCodtmonEqualTo(vCodtmon);
		try {
			SitbTipomonedaMapper mapper = sqlSession.getMapper (SitbTipomonedaMapper. class);
			List <SitbTipomoneda> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	logger.error("Error getMonedaPorCodigo "+e.getMessage(),e);   
        	throw e;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public void insertarReporte(IltbcSoldenvirtual entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactorySiit.openSession();
		IltbcSoldenvirtualMapper mapper = sqlSession.getMapper(IltbcSoldenvirtualMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			
		} catch (Exception e) {			
			logger.error("Error insertarReporte "+e.getMessage(),e);   
        	throw e;
		} finally{
			sqlSession.close();			
		}
	}
	
	public String insertarRegistroEntradaSIIT(Map parametros) throws Exception {
		String resultado=null;		
		SqlSession session = sqlSessionFactorySiit.openSession();
		try {			
			parametros.put("P_O_NUMENTRA",new String());
			session.selectOne("Siit.insertarRegistroEntradaSIIT", parametros);		
			return parametros.get("P_O_NUMENTRA").toString();			
		} catch (Exception e) {			
			logger.error("Error insertarRegistroEntradaSIIT "+e.getMessage(),e);
			throw e;
		} finally {
			session.close();
		}
	}
	
	public SitbDepxdistrito getDependenciaSIITPorUbigeo(String vcoddep,String vcodpro,String vcoddis) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		SitbDepxdistritoExample example = new SitbDepxdistritoExample();
		example.createCriteria().andVCoddepEqualTo(vcoddep).andVCodproEqualTo(vcodpro).andVCoddisEqualTo(vcoddis);
		try {
			SitbDepxdistritoMapper mapper = sqlSession.getMapper (SitbDepxdistritoMapper. class);
			List <SitbDepxdistrito> allRecords = mapper.selectByExample(example);	
			return allRecords.get(0);
		} catch (Exception e) {
        	logger.error("Error al obtener la dependencia de la tabla iltbc_unidad por ubigeo getDependenciaSIITPorUbigeo=>"+e.getMessage(),e);   
        	throw e;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public VstIntendenRegionales getIntendenciaSIITPorCodigo(String nNumdep) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactorySiit.openSession();	
		VstIntendenRegionalesExample example = new VstIntendenRegionalesExample();
		example.createCriteria().andNNumdepEqualTo(nNumdep);
		try {
			VstIntendenRegionalesMapper mapper = sqlSession.getMapper (VstIntendenRegionalesMapper. class);
			List <VstIntendenRegionales> allRecords = mapper.selectByExample(example);					
			return allRecords.get(0);
		} catch (Exception e) {
        	logger.error("Error al obtener la intendencia de la vista vst_intendenciasregionales por n_numdep getIntendenciaSIITPorCodigo=>"+e.getMessage(),e);   
        	throw e;
        } finally {
        	sqlSession.close ();
		}
	}

}
