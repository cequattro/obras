package pe.gob.sunafil.tramiteext.mybatis.implementacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.tramiteext.mybatis.comuntr.MyBatisConnectionFactory;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTBandeja;
import pe.gob.sunafil.tramiteext.persistence.client.SitbTdocideMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdmvcRegistroMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdmvdRegreqtupaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcCorrelativoMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcDependenciaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcEntidadMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcTipodoctramiteMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbcTramiteMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdtbdReqtupaMapper;
import pe.gob.sunafil.tramiteext.persistence.client.VstBandejastrexMapper;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocide;
import pe.gob.sunafil.tramiteext.persistence.model.SitbTdocideExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistroExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcCorrelativo;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcCorrelativoExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependenciaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTipodoctramite;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTipodoctramiteExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTramiteExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupaExample;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrexExample;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrexExample.Criteria;

public class IMPBandeja implements INTBandeja {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPBandeja(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  
	  }
	
	/*
	 * Recupera el listado de registros en las bandejas
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTBandeja#getBandeja(java.lang.String, java.util.Date, java.util.Date, java.lang.Short, java.lang.String, java.lang.String, java.lang.String, java.lang.Short)
	 */
	public List <VstBandejastrex> getBandeja(String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodtipodocid, String vCodentidad, Short nFlgtrex) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstBandejastrexExample example = new VstBandejastrexExample();
		Criteria dinamicCriteria=example.createCriteria();	
		dinamicCriteria.andNNumdepEqualTo(new Short(nNumdep)).andNNumtipodocEqualTo(new Short("0"));
		if(nFlgtrex!=null)
		{
			dinamicCriteria.andNFlgtrexEqualTo(nFlgtrex);
		}
		if(fechaI!=null && fechaF!=null)
		{
			dinamicCriteria.andDFecregBetween(fechaI, fechaF);
		}
		if(vAniohoja!=null)
		{
			dinamicCriteria.andVAniohojaEqualTo(vAniohoja);
		}
		if(vNumhoja!=null && !"".equals(vNumhoja.trim()))
		{
			dinamicCriteria.andVNumhojaEqualTo(vNumhoja);
		}
		if(vCodtipodocid!=null && !"".equals(vCodtipodocid.trim()))
		{
			dinamicCriteria.andVCodtipodocidEqualTo(vCodtipodocid);
		}
		if(vCodentidad!=null && !"".equals(vCodentidad.trim()))
		{
			dinamicCriteria.andVCodentidadEqualTo(vCodentidad);
		}		
		example.or(dinamicCriteria);
		//example.createCriteria().andNNumdepEqualTo(new Short(nNumdep)).andNNumtipodocEqualTo(new Short("0")).andDFecregBetween(fechaI, fechaF).andVAniohojaEqualTo(vAniohoja).andVNumhojaEqualTo(vNumhoja).andVCodtipodocidEqualTo(vCodtipodocid).andVCodentidadEqualTo(vCodentidad);		
		try {
			VstBandejastrexMapper mapper = sqlSession.getMapper (VstBandejastrexMapper. class);
			List <VstBandejastrex> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getBandeja "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera los requisitos pendientes de un procedimiento (TUPA) asociado a un registro
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTBandeja#getRequisitosPendientes(pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex)
	 */
	public List <TdtbdReqtupa> getRequisitosPendientes(VstBandejastrex item) throws Exception
	{
		List <TdtbdReqtupa> listaRequisitosPendientes=new ArrayList<TdtbdReqtupa>();
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdmvdRegreqtupaExample example = new TdmvdRegreqtupaExample();
		example.createCriteria().andNFlgpresentadoEqualTo(new Short("0")).andVNumanoregEqualTo(item.getvNumanoreg()).andNNumdepEqualTo(item.getnNumdep()).andNNumtipodocEqualTo(item.getnNumtipodoc()).andVNumregEqualTo(item.getvNumreg());
		try {
			TdmvdRegreqtupaMapper mapper = sqlSession.getMapper (TdmvdRegreqtupaMapper. class);
			List <TdmvdRegreqtupa> allRecords = mapper.selectByExample(example);		
			
			for (TdmvdRegreqtupa s: allRecords){
				TdtbdReqtupa requisito;
				try {
					TdtbdReqtupaExample example1 = new TdtbdReqtupaExample();
					example1.createCriteria().andNNumgrupoEqualTo(s.getnNumgrupo()).andNNumdepEqualTo(s.getnNumdepdest()).andVCodtupaEqualTo(s.getvCodtupa()).andNNumreqEqualTo(s.getnNumreq());				
					TdtbdReqtupaMapper mapper1 = sqlSession.getMapper (TdtbdReqtupaMapper. class);
					requisito=mapper1.selectByExample(example1).get(0);
				} catch (Exception e) {
					System.out.println("Error getRequisitosPendientes recuperando tramite "+e.getMessage());
					requisito=null;
				}				
				listaRequisitosPendientes.add(requisito);
			}
			return listaRequisitosPendientes;
		} catch (Exception e) {
        	System.out.println("Error getRequisitosPendientes "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Actualiza el nombre de un archivo adjunto asociado a un registro
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTBandeja#actualizarArchivo(pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex)
	 */
	public int actualizarArchivo(VstBandejastrex item) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//recuperando registro original
		TdmvcRegistro entidad=new TdmvcRegistro();
		TdmvcRegistroExample example = new TdmvcRegistroExample();
		example.createCriteria().andVNumanoregEqualTo(item.getvNumanoreg()).andNNumdepEqualTo(item.getnNumdep()).andNNumtipodocEqualTo(item.getnNumtipodoc()).andVNumregEqualTo(item.getvNumreg());
		try {
			TdmvcRegistroMapper mapper = sqlSession.getMapper (TdmvcRegistroMapper. class);
			List <TdmvcRegistro> allRecords = mapper.selectByExample(example);		
			entidad=allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error actualizarArchivo obteniendo cabecera registro "+e.getMessage());   
        	entidad=null;
        }
		//end recuperando registro original
		
		if(entidad!=null)
		{
			TdmvcRegistroMapper mapper2 = sqlSession.getMapper(TdmvcRegistroMapper.class);			
			try {
				entidad.setvDescdoc(item.getvNumanoreg()+"-"+item.getnNumdep()+"-"+item.getnNumtipodoc()+"-"+item.getvNumreg()+".pdf");
				entidad.setdFecreg(null);//para que no actualize campo de fecha de registro al subsanar o actualizar
				entidad.setdFecrecep(null);
				entidad.setdFecemision(null);
				entidad.setdFecmod(new Date());
				mapper2.updateByPrimaryKeySelective(entidad);
				sqlSession.commit();
				return 1;
			} catch (Exception e) {			
				System.out.println("Error actualizarArchivo "+e.getMessage());   
	        	return 0;
			} finally{
				sqlSession.close();			
			}
		}
		else
		{
			return 0;
		}
	}
	
	/*
	 * Actualiza un registro
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTBandeja#actualizarRegistro(pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro)
	 */
	public int actualizarRegistro(TdmvcRegistro registro) throws Exception
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
			mapper.updateByPrimaryKeySelective(registro);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarRegistro "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*
	 * Recupera un registro por su codigo PK
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTBandeja#getRegistroPorKey(java.lang.String, java.lang.Short, java.lang.Short, java.lang.String)
	 */
	public TdmvcRegistro getRegistroPorKey(String vNumanoreg, Short nNumdep, Short nNumtipodoc, String vNumreg) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdmvcRegistroExample example = new TdmvcRegistroExample();
		example.createCriteria().andVNumanoregEqualTo(vNumanoreg).andNNumdepEqualTo(nNumdep).andNNumtipodocEqualTo(nNumtipodoc).andVNumregEqualTo(vNumreg);
		try {
			TdmvcRegistroMapper mapper = sqlSession.getMapper (TdmvcRegistroMapper. class);
			List <TdmvcRegistro> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getRegistroPorKey "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Actualiza un requisito de procedimiento (TUPA) asociado a un registro
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTBandeja#actualizarRequisito(pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegreqtupa)
	 */
	public int actualizarRequisito(TdmvdRegreqtupa requisito) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdmvdRegreqtupaMapper mapper = sqlSession.getMapper(TdmvdRegreqtupaMapper.class);		
		try {
			mapper.updateByPrimaryKey(requisito);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarRequisito "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}

}
