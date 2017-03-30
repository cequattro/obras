package pe.gob.sunafil.tramiteext.mybatis.implementacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.tramiteext.bean.AsociacionPorPersona;
import pe.gob.sunafil.tramiteext.managedBeans.RegistrarBean;
import pe.gob.sunafil.tramiteext.mybatis.comuntr.MyBatisConnectionFactory;
import pe.gob.sunafil.tramiteext.mybatis.comunsiit.MyBatisConnectionFactorySiit;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar;
import pe.gob.sunafil.tramiteext.persistence.client.SitbEmpmtpeMapper;
import pe.gob.sunafil.tramiteext.persistence.client.SitbTdocideMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdbcDependenciasiitMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdmvcHojarutaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdmvcRegistroMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdmvdRegistroMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdmvdRegreqtupaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbComisionesMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbCongresistasMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcCargocongresMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcCorrelativoMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcDependenciaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcEntidadMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcGrupotupaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcIntendenciaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcTipodoctramiteMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcTramiteMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbdCentrolabMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbdReqtupaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbdTupaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.VstDireccionestrexMapper;
import pe.gob.sunafil.tramiteext.persistence.model.SitbEmpmtpe;
import pe.gob.sunafil.tramiteext.persistence.model.SitbEmpmtpeExample;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocide;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocideExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdbcDependenciasiit;
import pe.gob.sunafil.tramiteext.persistence.model.TdbcDependenciasiitExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcHojarutaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcHojarutaKey;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistroExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegistroExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbComisiones;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbComisionesExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbCongresistas;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbCongresistasExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcCargocongres;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcCargocongresExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcCorrelativo;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcCorrelativoExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependenciaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidadExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcGrupotupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcGrupotupaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcIntendenciaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTipodoctramite;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTipodoctramiteExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTramite;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTramiteExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdCentrolab;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdCentrolabExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdTupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdTupaExample;
import pe.gob.sunafil.tramiteext.persistence.model.VstDireccionestrex;
import pe.gob.sunafil.tramiteext.persistence.model.VstDireccionestrexExample;
import pe.gob.sunafil.tramiteext.siit.persistence.client.VstSiitToTramiteMapper;
import pe.gob.sunafil.tramiteext.siit.persistence.model.VstSiitToTramite;
import pe.gob.sunafil.tramiteext.siit.persistence.model.VstSiitToTramiteExample;

public class IMPRegistrar implements INTRegistrar {
	
	private SqlSessionFactory sqlSessionFactory;
	private SqlSessionFactory sqlSessionFactorySiit;
	
	private static Logger logger = Logger.getLogger(IMPRegistrar.class.getName());
	
	public IMPRegistrar(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  
		  sqlSessionFactorySiit=MyBatisConnectionFactorySiit.getSqlSessionFactory();
	  }
	
	/*
	 * Recupera los tipos de documento del remitente
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getTipoDocRemitente()
	 */
	public int pertenece_Sunafil(String nroDoc)throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();    	
		SitbEmpmtpeExample example= new SitbEmpmtpeExample();
		example.createCriteria().andIdEqualTo(nroDoc);
        try {           
        	SitbEmpmtpeMapper mapper = session.getMapper(SitbEmpmtpeMapper.class);
        	List <SitbEmpmtpe> allRecords = mapper.selectByExample(example);
        	if(allRecords.size()>0)
        		return 1;
        } catch (Exception e) {
        	System.out.println("Error pertenece_Sunafil "+e.getMessage()); 
        	return 0;
        }finally{
        	session.close();
        }
		return 0;
	}
	
	public List <SitbTdocide> getTipoDocRemitente() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		SitbTdocideExample example = new SitbTdocideExample();
		example.createCriteria().andDescripcionIsNotNull().andNFlgmpEqualTo(new BigDecimal(1));
		try {
			SitbTdocideMapper mapper = sqlSession.getMapper (SitbTdocideMapper. class);
			List <SitbTdocide> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoDocRemitente "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera los tipos de documento de trámite
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getTipoDocTramite()
	 */
	public List <TdtbcTipodoctramite> getTipoDocTramite() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcTipodoctramiteExample example = new TdtbcTipodoctramiteExample();
		example.createCriteria().andVDestipodocIsNotNull().andNFlgmpEqualTo(new BigDecimal(1)).andNFlgconNotEqualTo(new BigDecimal(1));
		try {
			TdtbcTipodoctramiteMapper mapper = sqlSession.getMapper (TdtbcTipodoctramiteMapper. class);
			List <TdtbcTipodoctramite> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoDocTramite "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <TdtbcTipodoctramite> getTipoDocTramiteCongresal() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcTipodoctramiteExample example = new TdtbcTipodoctramiteExample();
		example.createCriteria().andVDestipodocIsNotNull().andNFlgmpEqualTo(new BigDecimal(1)).andNFlgconEqualTo(new BigDecimal(1));
		try {
			TdtbcTipodoctramiteMapper mapper = sqlSession.getMapper (TdtbcTipodoctramiteMapper. class);
			List <TdtbcTipodoctramite> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoDocTramiteCongresal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera el autocompletado por dependencia
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getAutocompletarDependencia(java.lang.String)
	 */
	public List <TdtbcDependencia> getAutocompletarDependencia(String query) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcDependenciaExample example = new TdtbcDependenciaExample();
		example.createCriteria().andNFlgactivoEqualTo(new Short("1")).andVDesdepLike("SUNAFIL%").andVDesdepLike("%"+query.toUpperCase()+"%");
		try {
			TdtbcDependenciaMapper mapper = sqlSession.getMapper (TdtbcDependenciaMapper. class);
			List <TdtbcDependencia> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getAutocompletarDependencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera los tipos de tramite
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getTipoTramite()
	 */
	public List <TdtbcTramite> getTipoTramite() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcTramiteExample example = new TdtbcTramiteExample();
		example.createCriteria().andNFlgactEqualTo(new BigDecimal(1)).andNCodtramNotEqualTo(new BigDecimal("8"));
		try {
			TdtbcTramiteMapper mapper = sqlSession.getMapper (TdtbcTramiteMapper. class);
			List <TdtbcTramite> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoTramite "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <TdtbcTramite> getTipoTramiteSinTupa() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcTramiteExample example = new TdtbcTramiteExample();
		example.createCriteria().andNFlgactEqualTo(new BigDecimal(1)).andNCodtramNotEqualTo(new BigDecimal("8")).andNCodtramNotEqualTo(new BigDecimal("1"));
		try {
			TdtbcTramiteMapper mapper = sqlSession.getMapper (TdtbcTramiteMapper. class);
			List <TdtbcTramite> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoTramite "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera las dependencias de una intendencia
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getDependencia(java.lang.String)
	 */
	public List <TdtbcDependencia> getDependencia(String nNumint) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcDependenciaExample example = new TdtbcDependenciaExample();
		example.createCriteria().andNFlgactivoEqualTo(new Short("1")).andNNumintEqualTo(new BigDecimal(nNumint));
		try {
			TdtbcDependenciaMapper mapper = sqlSession.getMapper (TdtbcDependenciaMapper. class);
			List <TdtbcDependencia> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDependencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera el autocompletado por dependencia e intendencia
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getAutocompletarDependenciaEIntendencia(java.lang.String, java.lang.String)
	 */
	public List <TdtbcDependencia> getAutocompletarDependenciaEIntendencia(String query, String nNumint) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcDependenciaExample example = new TdtbcDependenciaExample();
		example.createCriteria().andNFlgactivoEqualTo(new Short("1")).andVDesdepLike("SUNAFIL%").andNNumintEqualTo(new BigDecimal(nNumint)).andVDesdepLike("%"+query.toUpperCase()+"%");
		try {
			TdtbcDependenciaMapper mapper = sqlSession.getMapper (TdtbcDependenciaMapper. class);
			List <TdtbcDependencia> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getAutocompletarDependenciaEIntendencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera intendencia por su codigo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getIntendencia(java.lang.String)
	 */
	public List <TdtbcIntendencia> getIntendencia(String nNumint) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcIntendenciaExample example = new TdtbcIntendenciaExample();
		if("1".equals(nNumint))
		{
			example.createCriteria().andNNumintIsNotNull();			
		}
		else
		{
			example.createCriteria().andNNumintEqualTo(new BigDecimal(nNumint));
		}
		try {
			TdtbcIntendenciaMapper mapper = sqlSession.getMapper (TdtbcIntendenciaMapper. class);
			List <TdtbcIntendencia> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getIntendencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera la lista de procedimientos (TUPA)
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getProcedimiento()
	 */
	public List <TdtbdTupa> getProcedimiento(BigDecimal nNumint) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//recupera el grupo tupa activo
		TdtbcGrupotupaExample exampleGr = new TdtbcGrupotupaExample();
		exampleGr.createCriteria().andNFlgactivoEqualTo(new BigDecimal(1));
		TdtbcGrupotupa grupoActual = new TdtbcGrupotupa();		
		try {
			TdtbcGrupotupaMapper mapperGr = sqlSession.getMapper (TdtbcGrupotupaMapper. class);
			List <TdtbcGrupotupa> allRecordsGr = mapperGr.selectByExample(exampleGr);		
			grupoActual=allRecordsGr.get(0);
		} catch (Exception e) {
        	System.out.println("Error getProcedimiento obteniendo grupoTupa actual "+e.getMessage());   
        	return null;
        }
		//end recupera el grupo tupa activo
		
		TdtbdTupaExample example = new TdtbdTupaExample();
		example.createCriteria().andNNumgrupoEqualTo(grupoActual.getnNumgrupo()).andNNumintEqualTo(nNumint).andVFlgactEqualTo("S");//aqui va el grupo tupa activo
		example.setOrderByClause("to_number(v_codtupa) asc");
		try {
			TdtbdTupaMapper mapper = sqlSession.getMapper (TdtbdTupaMapper. class);
			List <TdtbdTupa> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getProcedimiento "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <TdtbdTupa> getProcedimientoAll(BigDecimal nNumint) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//recupera el grupo tupa activo
		TdtbcGrupotupaExample exampleGr = new TdtbcGrupotupaExample();
		exampleGr.createCriteria().andNFlgactivoEqualTo(new BigDecimal(1));
		TdtbcGrupotupa grupoActual = new TdtbcGrupotupa();		
		try {
			TdtbcGrupotupaMapper mapperGr = sqlSession.getMapper (TdtbcGrupotupaMapper. class);
			List <TdtbcGrupotupa> allRecordsGr = mapperGr.selectByExample(exampleGr);		
			grupoActual=allRecordsGr.get(0);
		} catch (Exception e) {
        	System.out.println("Error getProcedimientoAll obteniendo grupoTupa actual "+e.getMessage());   
        	return null;
        }
		//end recupera el grupo tupa activo
		
		TdtbdTupaExample example = new TdtbdTupaExample();
		example.createCriteria().andNNumgrupoEqualTo(grupoActual.getnNumgrupo()).andNNumintEqualTo(nNumint);//aqui va el grupo tupa activo
		example.setOrderByClause("to_number(v_codtupa) asc");
		try {
			TdtbdTupaMapper mapper = sqlSession.getMapper (TdtbdTupaMapper. class);
			List <TdtbdTupa> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getProcedimientoAll "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera un procedimiento (TUPA) por su codigo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getProcedimientoPorNro(java.lang.String)
	 */
	public TdtbdTupa getProcedimientoPorNro(String vCodtupa, BigDecimal nNumint) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//recupera el grupo tupa activo
		TdtbcGrupotupaExample exampleGr = new TdtbcGrupotupaExample();
		exampleGr.createCriteria().andNFlgactivoEqualTo(new BigDecimal(1));
		TdtbcGrupotupa grupoActual = new TdtbcGrupotupa();		
		try {
			TdtbcGrupotupaMapper mapperGr = sqlSession.getMapper (TdtbcGrupotupaMapper. class);
			List <TdtbcGrupotupa> allRecordsGr = mapperGr.selectByExample(exampleGr);		
			grupoActual=allRecordsGr.get(0);
		} catch (Exception e) {
        	System.out.println("Error getProcedimientoPorNro obteniendo grupoTupa actual "+e.getMessage());   
        	return null;
        }
		//end recupera el grupo tupa activo
		
		TdtbdTupaExample example = new TdtbdTupaExample();
		example.createCriteria().andNNumgrupoEqualTo(grupoActual.getnNumgrupo()).andVCodtupaEqualTo(vCodtupa).andNNumintEqualTo(nNumint).andVFlgactEqualTo("S");//aqui va el grupo tupa activo
		try {
			TdtbdTupaMapper mapper = sqlSession.getMapper (TdtbdTupaMapper. class);
			List <TdtbdTupa> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getProcedimientoPorNro "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera el listado de procedimientos (TUPA) por codigo y descripcion
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getProcedimientoPorNroYDescripcion(java.lang.String, java.lang.String)
	 */
	public List <TdtbdTupa> getProcedimientoPorNroYDescripcion(String vCodtupa, String vDestupa, BigDecimal nNumint) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//recupera el grupo tupa activo
		TdtbcGrupotupaExample exampleGr = new TdtbcGrupotupaExample();
		exampleGr.createCriteria().andNFlgactivoEqualTo(new BigDecimal(1));
		TdtbcGrupotupa grupoActual = new TdtbcGrupotupa();		
		try {
			TdtbcGrupotupaMapper mapperGr = sqlSession.getMapper (TdtbcGrupotupaMapper. class);
			List <TdtbcGrupotupa> allRecordsGr = mapperGr.selectByExample(exampleGr);		
			grupoActual=allRecordsGr.get(0);
		} catch (Exception e) {
        	System.out.println("Error getProcedimientoPorNroYDescripcion obteniendo grupoTupa actual "+e.getMessage());   
        	return null;
        }
		//end recupera el grupo tupa activo
		
		TdtbdTupaExample example = new TdtbdTupaExample();		
		if("".equals(vCodtupa) && "".equals(vDestupa))
		{
			example.createCriteria().andNNumgrupoEqualTo(grupoActual.getnNumgrupo()).andNNumintEqualTo(nNumint).andVFlgactEqualTo("S");//aqui va el grupo tupa activo
		}
		else if(!"".equals(vCodtupa) && "".equals(vDestupa))
		{
			example.createCriteria().andNNumgrupoEqualTo(grupoActual.getnNumgrupo()).andVCodtupaEqualTo(vCodtupa).andNNumintEqualTo(nNumint).andNNumintEqualTo(nNumint).andVFlgactEqualTo("S");//aqui va el grupo tupa activo
		}
		else if("".equals(vCodtupa) && !"".equals(vDestupa))
		{
			example.createCriteria().andNNumgrupoEqualTo(grupoActual.getnNumgrupo()).andVDestupaLike("%"+vDestupa+"%").andNNumintEqualTo(nNumint).andVFlgactEqualTo("S");//aqui va el grupo tupa activo
		}
		else if(!"".equals(vCodtupa) && !"".equals(vDestupa))
		{
			example.createCriteria().andNNumgrupoEqualTo(grupoActual.getnNumgrupo()).andVCodtupaEqualTo(vCodtupa).andVDestupaEqualTo("%"+vDestupa+"%").andNNumintEqualTo(nNumint).andVFlgactEqualTo("S");//aqui va el grupo tupa activo
		}
		example.setOrderByClause("to_number(v_codtupa) asc");
		try {
			TdtbdTupaMapper mapper = sqlSession.getMapper (TdtbdTupaMapper. class);
			List <TdtbdTupa> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getProcedimientoPorNroYDescripcion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera una dependencia por su codigo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getDependenciaPorCodigo(java.lang.Short)
	 */
	public TdtbcDependencia getDependenciaPorCodigo(Short nNumdep) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcDependenciaExample example = new TdtbcDependenciaExample();
		example.createCriteria().andNFlgactivoEqualTo(new Short("1")).andNNumdepEqualTo(nNumdep);
		try {
			TdtbcDependenciaMapper mapper = sqlSession.getMapper (TdtbcDependenciaMapper. class);
			List <TdtbcDependencia> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getDependencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera los requisitos de un procedimiento (TUPA)
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getRequisitosPorTupa(pe.gob.sunafil.tramiteext.persistence.model.TdtbdTupa)
	 */
	public List <TdtbdReqtupa> getRequisitosPorTupa(TdtbdTupa tupa) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbdReqtupaExample example = new TdtbdReqtupaExample();
		example.createCriteria().andNFlgactivoEqualTo(new Short("1")).andNNumgrupoEqualTo(tupa.getnNumgrupo()).andNNumdepEqualTo(tupa.getnNumdep()).andVCodtupaEqualTo(tupa.getvCodtupa());
		try {
			TdtbdReqtupaMapper mapper = sqlSession.getMapper (TdtbdReqtupaMapper. class);
			List <TdtbdReqtupa> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDependencia "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera una entidad por nro de documento
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getEntidadPorCodigo(java.lang.String)
	 */
	public TdtbcEntidad getEntidadPorCodigo(String vCodentidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcEntidadExample example = new TdtbcEntidadExample();
		example.createCriteria().andVCodentidadEqualTo(vCodentidad);
		try {
			TdtbcEntidadMapper mapper = sqlSession.getMapper (TdtbcEntidadMapper. class);
			List <TdtbcEntidad> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getEntidadPorCodigo "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera las direcciones de una entidad por su numero de documento
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getDireccionesPorEntidad(java.lang.String)
	 */
	public List <TdtbdCentrolab> getDireccionesPorEntidad(String vCodentidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbdCentrolabExample example = new TdtbdCentrolabExample();
		example.createCriteria().andVCodentidadEqualTo(vCodentidad);
		try {
			TdtbdCentrolabMapper mapper = sqlSession.getMapper (TdtbdCentrolabMapper. class);
			List <TdtbdCentrolab> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDireccionesPorEntidad "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera las direcciones de una entidad por su numero de documento
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getDirsPorEntidad(java.lang.String)
	 */
	public List <VstDireccionestrex> getDirsPorEntidad(String vCodentidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstDireccionestrexExample example = new VstDireccionestrexExample();
		example.createCriteria().andVCodentidadEqualTo(vCodentidad);
		try {
			VstDireccionestrexMapper mapper = sqlSession.getMapper (VstDireccionestrexMapper. class);
			List <VstDireccionestrex> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getDirsPorEntidad "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public VstDireccionestrex getDirPorCodigoYEntidad(String vCodentidad, Short nCodcenlab) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstDireccionestrexExample example = new VstDireccionestrexExample();
		example.createCriteria().andVCodentidadEqualTo(vCodentidad).andNCodcenlabEqualTo(nCodcenlab);
		try {
			VstDireccionestrexMapper mapper = sqlSession.getMapper (VstDireccionestrexMapper. class);
			List <VstDireccionestrex> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getDirPorCodigoYEntidad "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Inserta una nueva entidad
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#insertarEntidad(pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad)
	 */
	public int insertarEntidad(TdtbcEntidad entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbcEntidadMapper mapper = sqlSession.getMapper(TdtbcEntidadMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarEntidad "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*
	 * Recupera una entidad en base a su numero y tipo de documento
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getEntidadPorCodigoYTipoDoc(java.lang.String, java.lang.String)
	 */
	public TdtbcEntidad getEntidadPorCodigoYTipoDoc(String vCodentidad, String vCodtipodocid) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcEntidadExample example = new TdtbcEntidadExample();
		example.createCriteria().andVCodentidadEqualTo(vCodentidad).andVCodtipodocidEqualTo(vCodtipodocid);
		try {
			TdtbcEntidadMapper mapper = sqlSession.getMapper (TdtbcEntidadMapper. class);
			List <TdtbcEntidad> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getEntidadPorCodigoYTipoDoc "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Inserta una nueva direccion de entidad
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#insertarDireccion(pe.gob.sunafil.tramiteext.persistence.model.TdtbdCentrolab)
	 */
	public int insertarDireccion(TdtbdCentrolab direccion) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbdCentrolabMapper mapper = sqlSession.getMapper(TdtbdCentrolabMapper.class);		
		try {			
			mapper.insert(direccion);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarDireccion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*
	 * Asociacion por entidad
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getAsociacionPorPersona(pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad, java.lang.String)
	 */
	public List <AsociacionPorPersona> getAsociacionPorPersona(TdtbcEntidad entidad, String nNumdep) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List <AsociacionPorPersona> lista=new ArrayList<AsociacionPorPersona>();
		
		TdmvcRegistroExample example = new TdmvcRegistroExample();
		example.createCriteria().andNNumdepEqualTo(new Short(nNumdep)).andNNumtipodocEqualTo(new Short("0")).andVCodentidadEqualTo(entidad.getvCodentidad());
		try {
			TdmvcRegistroMapper mapper = sqlSession.getMapper (TdmvcRegistroMapper. class);
			List <TdmvcRegistro> allRecords = mapper.selectByExample(example);	
			
			//recuperando tramite y dependencia
			for (TdmvcRegistro s: allRecords){
				//tramite
				TdtbcTramite tramite;
				try {
					TdtbcTramiteExample example1 = new TdtbcTramiteExample();
					example1.createCriteria().andNCodtramEqualTo(s.getnCodtram());
					TdtbcTramiteMapper mapper1 = sqlSession.getMapper (TdtbcTramiteMapper. class);
					tramite=mapper1.selectByExample(example1).get(0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error getAsociacionPorPersona recuperando tramite "+e.getMessage());
					tramite=null;
				}
				
				//dependencia
				TdtbcDependenciaExample example2 = new TdtbcDependenciaExample();
				example2.createCriteria().andNNumdepEqualTo(s.getnNumdepdest());
				TdtbcDependenciaMapper mapper2 = sqlSession.getMapper (TdtbcDependenciaMapper. class);
				TdtbcDependencia dependenciaDestino=mapper2.selectByExample(example2).get(0);
				
				lista.add(new AsociacionPorPersona(s, tramite, dependenciaDestino, entidad));
			}
			
			return lista;
		} catch (Exception e) {
        	System.out.println("Error getRequisitosPorTupaAsociacionPorPersona "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Asociacion por hoja de ruta
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getAsociacionPorHR(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List <AsociacionPorPersona> getAsociacionPorHR(String vAniohoja, String vNumhoja, String nNumdep) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List <AsociacionPorPersona> lista=new ArrayList<AsociacionPorPersona>();
		
		TdmvcRegistroExample example = new TdmvcRegistroExample();
		//se comento el filtro por la dependencia para que pueda asociar HR a nivel nacional
		//example.createCriteria().andNNumdepEqualTo(new Short(nNumdep)).andNNumtipodocEqualTo(new Short("0")).andVAniohojaEqualTo(new Short(vAniohoja)).andVNumhojaEqualTo(completarCon(vNumhoja,10,"0",0));
		example.createCriteria().andVAniohojaEqualTo(new Short(vAniohoja)).andVNumhojaEqualTo(completarCon(vNumhoja,10,"0",0));
		try {
			TdmvcRegistroMapper mapper = sqlSession.getMapper (TdmvcRegistroMapper. class);
			List <TdmvcRegistro> allRecords = mapper.selectByExample(example);	
			
			//recuperando tramite, dependencia y entidad
			for (TdmvcRegistro s: allRecords){
				//tramite				
				TdtbcTramite tramite;
				try {
					TdtbcTramiteExample example1 = new TdtbcTramiteExample();
					example1.createCriteria().andNCodtramEqualTo(s.getnCodtram());
					TdtbcTramiteMapper mapper1 = sqlSession.getMapper (TdtbcTramiteMapper. class);
					tramite=mapper1.selectByExample(example1).get(0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error getAsociacionPorHR recuperando tramite "+e.getMessage());
					//tramite=null;
					tramite=new TdtbcTramite();
					tramite.setnCodtram(new BigDecimal(100));
					tramite.setvDestram(" ");
					tramite.setnFlgact(new BigDecimal(1));
				}
				
				//detalle registro
				TdmvdRegistroExample example22 = new TdmvdRegistroExample();
				example22.createCriteria().andVNumanoregEqualTo(s.getvNumanoreg()).andNNumdepEqualTo(s.getnNumdep()).andNNumtipodocEqualTo(s.getnNumtipodoc()).andVNumregEqualTo(s.getvNumreg());
				TdmvdRegistroMapper mapper22 = sqlSession.getMapper (TdmvdRegistroMapper. class);
				TdmvdRegistro detalle=mapper22.selectByExample(example22).get(0);
				
				//dependencia
				TdtbcDependenciaExample example2 = new TdtbcDependenciaExample();
				example2.createCriteria().andNNumdepEqualTo(detalle.getnNumdepdest());//s.getnNumdepdest()
				TdtbcDependenciaMapper mapper2 = sqlSession.getMapper (TdtbcDependenciaMapper. class);
				TdtbcDependencia dependenciaDestino=mapper2.selectByExample(example2).get(0);
				
				//entidad
				TdtbcEntidad entidad;
				try {
				TdtbcEntidadExample example3 = new TdtbcEntidadExample();
				example3.createCriteria().andVCodentidadEqualTo(s.getvCodentidad());
				TdtbcEntidadMapper mapper3 = sqlSession.getMapper (TdtbcEntidadMapper. class);
				
					entidad=mapper3.selectByExample(example3).get(0);
				} catch (Exception e) {
					entidad=new TdtbcEntidad();
				}
				
				
				lista.add(new AsociacionPorPersona(s, tramite, dependenciaDestino, entidad));
			}
			
			return lista;
		} catch (Exception e) {
        	System.out.println("Error getAsociacionPorHR "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * completado de cadenas a longitud 10
	 */
	public static String completarCon(String base, int longitud,String charCompletar, int lado)
	{
		String result="";
		if(base.length()<longitud)
		{
			int n=longitud-base.length();
			String ceros="";
			for (int i = 0; i < n; i++) {
				ceros+=charCompletar;
			}
			if(lado==0)//izq
			{
				result = ceros+base;
			}
			else if(lado==1)//der
			{
				result = base+ceros;
			}
		}
		else if(base.length()>longitud)
		{
			result = base.substring(0, longitud);
		}
		else if(base.length()==longitud)
		{
			result=base;
		}
		return result;
	}
	
	/*
	 * Asociacion por inspecciones SIIT
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getAsociacionPorInspeccion(pe.gob.sunafil.tramiteext.siit.persistence.model.VstSiitToTramite, java.util.List)
	 */
	public List <VstSiitToTramite> getAsociacionPorInspeccion(VstSiitToTramite parametros, List <Short> dependenciasSIIT) throws Exception
	{		
		SqlSession sqlSession = sqlSessionFactorySiit.openSession();		
		VstSiitToTramiteExample example = new VstSiitToTramiteExample();
		if(parametros.getvNrooic()!=null && parametros.getvAniooic()!=null && !"".equals(parametros.getvNrooic().trim()) && !"".equals(parametros.getvAniooic()))
		{			
			example.or().andVNrooicEqualTo(completarCon(parametros.getvNrooic(),10,"0",0)).andVAniooicEqualTo(parametros.getvAniooic()).andNNumdepoicIn(dependenciasSIIT);
		}
		else if(parametros.getvNroacta()!=null && parametros.getvAnioacta()!=null && !"".equals(parametros.getvNroacta().trim()) && !"".equals(parametros.getvAnioacta()))
		{
			example.or().andVNroactaEqualTo(completarCon(parametros.getvNroacta(),10,"0",0)).andVAnioactaEqualTo(parametros.getvAnioacta()).andNNumdepoicIn(dependenciasSIIT);
		}
		else if(parametros.getvNroexpsan()!=null && parametros.getvAnioexpsanc()!=null && !"".equals(parametros.getvNroexpsan().trim()) && !"".equals(parametros.getvAnioexpsanc()))
		{
			example.or().andVNroexpsanEqualTo(completarCon(parametros.getvNroexpsan(),10,"0",0)).andVAnioexpsancEqualTo(parametros.getvAnioexpsanc()).andNNumdepoicIn(dependenciasSIIT);
		}
		else if(parametros.getvNrores1ra()!=null && parametros.getvAniores1ra()!=null && !"".equals(parametros.getvNrores1ra().trim()) && !"".equals(parametros.getvAniores1ra()))
		{
			example.or().andVNrores1raEqualTo(completarCon(parametros.getvNrores1ra(),10,"0",0)).andVAniores1raEqualTo(parametros.getvAniores1ra()).andNNumdepoicIn(dependenciasSIIT);
		}
		else if(parametros.getvNrores2da()!=null && parametros.getvAniores2da()!=null && !"".equals(parametros.getvNrores2da().trim()) && !"".equals(parametros.getvAniores2da()))
		{
			example.or().andVNrores2daEqualTo(completarCon(parametros.getvNrores2da(),10,"0",0)).andVAniores2daEqualTo(parametros.getvAniores2da()).andNNumdepoicIn(dependenciasSIIT);
		}
		try {
			VstSiitToTramiteMapper mapper = sqlSession.getMapper (VstSiitToTramiteMapper. class);
			List <VstSiitToTramite> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getAsociacionPorInspeccion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera las equivalencias de dependencias SIIT
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getEquivalenciaDependenciasSIIT(java.lang.String)
	 */
	public List <Short> getEquivalenciaDependenciasSIIT(String nNumdep) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		List<Short> shortValues = new ArrayList<Short>();
		TdbcDependenciasiitExample example = new TdbcDependenciasiitExample();
		example.createCriteria().andNNumdepEqualTo(new Short(nNumdep));
		try {
			TdbcDependenciasiitMapper mapper = sqlSession.getMapper (TdbcDependenciasiitMapper. class);
			List <TdbcDependenciasiit> allRecords = mapper.selectByExample(example);		
			for (TdbcDependenciasiit s: allRecords){
				shortValues.add(s.getnNumdepsiit());
			}
			return shortValues;
		} catch (Exception e) {
        	System.out.println("Error getEquivalenciaDependenciasSIIT "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Actualiza una entidad
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#actualizarEntidad(pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad)
	 */
	public int actualizarEntidad(TdtbcEntidad entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbcEntidadMapper mapper = sqlSession.getMapper(TdtbcEntidadMapper.class);		
		try {
			mapper.updateByPrimaryKeySelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarEntidad "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*
	 * Inserta en cabecera de registro
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#insertarRegistro(pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro)
	 */
	public int insertarRegistro(TdmvcRegistro registro) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdmvcRegistroMapper mapper = sqlSession.getMapper(TdmvcRegistroMapper.class);		
		try {			
			try {
				if(registro.getvNumdoc()!=null)
				{
					registro.setvNumdoc(registro.getvNumdoc().toUpperCase());
				}				
			} catch (Exception e) {				
			}
			mapper.insert(registro);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarRegistro "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*
	 * Recupera correlativo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getCorrelativo(java.lang.String, java.lang.Short, java.lang.Short)
	 */
	public TdtbcCorrelativo getCorrelativo(String vNumano, Short nNumdep, Short nNumtipodoc) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcCorrelativoExample example = new TdtbcCorrelativoExample();
		example.createCriteria().andNNumtipodocEqualTo(nNumtipodoc).andVNumanoEqualTo(vNumano).andNNumdepEqualTo(nNumdep);
		try {
			TdtbcCorrelativoMapper mapper = sqlSession.getMapper (TdtbcCorrelativoMapper. class);
			List <TdtbcCorrelativo> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativo "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Inserta un nuevo correlativo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#insertarCorrelativo(pe.gob.sunafil.tramiteext.persistence.model.TdtbcCorrelativo)
	 */
	public int insertarCorrelativo(TdtbcCorrelativo correlativo) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbcCorrelativoMapper mapper = sqlSession.getMapper(TdtbcCorrelativoMapper.class);		
		try {
			mapper.insert(correlativo);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarCorrelativo "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*
	 * Actualiza un correlativo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#actualizarCorrelativo(pe.gob.sunafil.tramiteext.persistence.model.TdtbcCorrelativo)
	 */
	public int actualizarCorrelativo(TdtbcCorrelativo correlativo) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbcCorrelativoMapper mapper = sqlSession.getMapper(TdtbcCorrelativoMapper.class);		
		try {
			mapper.updateByPrimaryKey(correlativo);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarCorrelativo "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*
	 * Recupera un correlativo nuevo para una nueva dirección de una entidad
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getCorrelativoDireccionPorEntidad(java.lang.String)
	 */
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
        	System.out.println("Error getCorrelativoDireccionPorEntidad "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Inserta requisito de procedimiento (TUPA) asociado a un registro
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#insertarRequisito(pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupa)
	 */
	public int insertarRequisito(TdmvdRegreqtupa requisito) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdmvdRegreqtupaMapper mapper = sqlSession.getMapper(TdmvdRegreqtupaMapper.class);		
		try {
			mapper.insert(requisito);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarRequisito "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*
	 * Recupera un nuevo correlativo global
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getCorrelativoGlobal(java.lang.Short)
	 */
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
        	System.out.println("Error getCorrelativoGlobal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Inserta un nuevo correlativo global
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#insertarCorrelativoGlobal(pe.gob.sunafil.tramiteext.persistence.model.TdmvcHojarutaKey)
	 */
	public int insertarCorrelativoGlobal(TdmvcHojarutaKey correlativoGlobal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdmvcHojarutaMapper mapper = sqlSession.getMapper(TdmvcHojarutaMapper.class);		
		try {
			mapper.insert(correlativoGlobal);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarCorrelativoGlobal "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}		
	
	/*
	 * Recupera datos para el reporte de hoja de ruta
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#reporteHojaRuta(java.util.Map)
	 */
	public List<Map> reporteHojaRuta(Map map) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Reporte.reporteHojaDeRuta", map);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteHojaRuta "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	/*
	 * Recupera una direccion en especifico de una entidad
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getDireccionPorEntidadYCodigo(java.lang.String, java.lang.Short)
	 */
	public TdtbdCentrolab getDireccionPorEntidadYCodigo(String vCodentidad, Short nCodcenlab) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbdCentrolabExample example = new TdtbdCentrolabExample();
		example.createCriteria().andVCodentidadEqualTo(vCodentidad).andNCodcenlabEqualTo(nCodcenlab);
		try {
			TdtbdCentrolabMapper mapper = sqlSession.getMapper (TdtbdCentrolabMapper. class);
			List <TdtbdCentrolab> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getDireccionPorEntidadYCodigo "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera procedimiento (TUPA) por su codigo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getProcedimientoPorKey(java.lang.Short, java.lang.Short, java.lang.String)
	 */
	public TdtbdTupa getProcedimientoPorKey(Short nNumgrupo, Short nNumdep, String vCodtupa) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();						
		TdtbdTupaExample example = new TdtbdTupaExample();
		example.createCriteria().andNNumgrupoEqualTo(nNumgrupo).andNNumdepEqualTo(nNumdep).andVCodtupaEqualTo(vCodtupa);
		try {
			TdtbdTupaMapper mapper = sqlSession.getMapper (TdtbdTupaMapper. class);
			List <TdtbdTupa> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getProcedimientoPorKey "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera los requisitos de un procedimiento (TUPA) asociado a un registro
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getRequisitosSeleccionadosPorRegistro(java.lang.String, java.lang.Short, java.lang.Short, java.lang.String)
	 */
	public List <TdmvdRegreqtupa> getRequisitosSeleccionadosPorRegistro(String vNumanoreg, Short nNumdep, Short nNumtipodoc, String vNumreg) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdmvdRegreqtupaExample example = new TdmvdRegreqtupaExample();
		example.createCriteria().andNFlgpresentadoEqualTo(new Short("1")).andVNumanoregEqualTo(vNumanoreg).andNNumdepEqualTo(nNumdep).andNNumtipodocEqualTo(nNumtipodoc).andVNumregEqualTo(vNumreg);
		try {
			TdmvdRegreqtupaMapper mapper = sqlSession.getMapper (TdmvdRegreqtupaMapper. class);
			List <TdmvdRegreqtupa> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
			logger.error("Error getRequisitosSeleccionadosPorRegistro "+e.getMessage(),e);   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera una entidad en base a su razon social o nombre completo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getEntidadPorRazonSocial(java.lang.String)
	 */
	public List <TdtbcEntidad> getEntidadPorRazonSocial(String vDesnombre) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcEntidadExample example = new TdtbcEntidadExample();
		example.createCriteria().andVCodtipodocidEqualTo("09").andVDesnombreLike("%"+vDesnombre+"%");
		try {
			TdtbcEntidadMapper mapper = sqlSession.getMapper (TdtbcEntidadMapper. class);
			List <TdtbcEntidad> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
			logger.error("Error getEntidadPorRazonSocial "+e.getMessage(),e);   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera los requisitos de un procedimiento  sin importar el estado(TUPA)
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getRequisitosPorTupaAll(pe.gob.sunafil.tramiteext.persistence.model.TdtbdTupa)
	 */
	public List <TdtbdReqtupa> getRequisitosPorTupaAll(TdtbdTupa tupa) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbdReqtupaExample example = new TdtbdReqtupaExample();
		example.createCriteria().andNNumgrupoEqualTo(tupa.getnNumgrupo()).andNNumdepEqualTo(tupa.getnNumdep()).andVCodtupaEqualTo(tupa.getvCodtupa());
		try {
			TdtbdReqtupaMapper mapper = sqlSession.getMapper (TdtbdReqtupaMapper. class);
			List <TdtbdReqtupa> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
			logger.error("Error getRequisitosPorTupaAll "+e.getMessage(),e);   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera todos los requisitos historial de un procedimiento (TUPA) asociado a un registro
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTRegistrar#getRequisitosAllPorRegistro(java.lang.String, java.lang.Short, java.lang.Short, java.lang.String)
	 */
	public List <TdmvdRegreqtupa> getRequisitosAllPorRegistro(String vNumanoreg, Short nNumdep, Short nNumtipodoc, String vNumreg) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdmvdRegreqtupaExample example = new TdmvdRegreqtupaExample();
		example.createCriteria().andVNumanoregEqualTo(vNumanoreg).andNNumdepEqualTo(nNumdep).andNNumtipodocEqualTo(nNumtipodoc).andVNumregEqualTo(vNumreg);
		try {
			TdmvdRegreqtupaMapper mapper = sqlSession.getMapper (TdmvdRegreqtupaMapper. class);
			List <TdmvdRegreqtupa> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
			logger.error("Error getRequisitosAllPorRegistro "+e.getMessage(),e);   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}

	
	public List<TdtbComisiones> getListaComisiones() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbComisionesExample example = new TdtbComisionesExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_descom");
		try {
			TdtbComisionesMapper mapper = sqlSession.getMapper(TdtbComisionesMapper. class);
			List <TdtbComisiones> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	logger.error("Error getListaComisiones "+e.getMessage(),e);
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List<TdtbCongresistas> getListaCongresistas() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdtbCongresistasExample example = new TdtbCongresistasExample();
		example.createCriteria().andVFlgactEqualTo("S");
		example.setOrderByClause("v_nomcong");
		try {
			TdtbCongresistasMapper mapper = sqlSession.getMapper(TdtbCongresistasMapper.class);
			List <TdtbCongresistas> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	logger.error("Error getListaCongresistas "+e.getMessage(),e);   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <TdtbcCargocongres> getCargosCongresales() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdtbcCargocongresExample example = new TdtbcCargocongresExample();
		example.createCriteria().andVFlgactEqualTo("S");
		try {
			TdtbcCargocongresMapper mapper = sqlSession.getMapper (TdtbcCargocongresMapper. class);
			List <TdtbcCargocongres> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getCargosCongresales "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
}
