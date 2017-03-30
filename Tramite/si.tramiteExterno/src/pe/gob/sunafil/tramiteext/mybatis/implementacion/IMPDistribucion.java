package pe.gob.sunafil.tramiteext.mybatis.implementacion;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.tramiteext.mybatis.comuntr.MyBatisConnectionFactory;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTDistribucion;
import pe.gob.sunafil.tramiteext.persistence.client.TdmvcCorteMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdmvcRegistroMapper;
import pe.gob.sunafil.tramiteext.persistence.client.TdmvdRegxcorteMapper;
import pe.gob.sunafil.tramiteext.persistence.client.VstBandejastrexMapper;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcCorte;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcCorteExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcCorteKey;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistroExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegxcorte;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegxcorteExample;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrexExample;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrexExample.Criteria;

public class IMPDistribucion implements INTDistribucion {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPDistribucion(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  
	  }	
	
	/*
	 * Recupera el correlativo de corte o cargo por anho
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTDistribucion#getCorrelativoGlobalCorte(java.lang.String)
	 */
	public TdmvcCorte getCorrelativoGlobalCorte(String vAnocorte) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdmvcCorteExample example = new TdmvcCorteExample();
		example.createCriteria().andVAnocorteEqualTo(vAnocorte).andCorrelativoPorAnio(vAnocorte);
		try {
			TdmvcCorteMapper mapper = sqlSession.getMapper (TdmvcCorteMapper. class);
			List <TdmvcCorte> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalCorte "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Inserta un corte o cargo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTDistribucion#insertarCorte(pe.gob.sunafil.tramiteext.persistence.model.TdmvcCorte)
	 */
	public int insertarCorte(TdmvcCorte corte) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdmvcCorteMapper mapper = sqlSession.getMapper(TdmvcCorteMapper.class);		
		try {
			mapper.insert(corte);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarCorte "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	/*
	 * Recupera los registros a asociar a un cargo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTDistribucion#getRegistrosCargo(java.lang.String, java.util.Date, java.util.Date, java.lang.Short, java.lang.String, java.lang.String, java.lang.String, java.lang.Short, java.util.List)
	 */
	public List <VstBandejastrex> getRegistrosCargo(String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodtipodocid, String vCodentidad, Short nFlgtrex, List<Short> destinos) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstBandejastrexExample example = new VstBandejastrexExample();
		Criteria dinamicCriteria=example.createCriteria();
		Criteria dinamicCriteria2=example.createCriteria();
		dinamicCriteria.andNNumtipodocEqualTo(new Short("0")).andVAnocorteIsNull().andVCodcorteIsNull();
		dinamicCriteria2.andVAnocorteIsNull().andVCodcorteIsNull();
		if(nNumdep!=null)
		{
			dinamicCriteria.andNNumdepEqualTo(new Short(nNumdep));	
			dinamicCriteria2.andNNumdeprmpEqualTo(new Short(nNumdep));
		}
		if(nFlgtrex!=null)
		{
			dinamicCriteria.andNFlgtrexEqualTo(nFlgtrex);
			dinamicCriteria2.andNFlgtrexEqualTo(nFlgtrex);
		}
		if(fechaI!=null && fechaF!=null)
		{
			dinamicCriteria.andDFecregBetween(fechaI, fechaF);
			dinamicCriteria2.andDFecrecmpBetween(fechaI, fechaF);
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
		if(destinos!=null)
		{
			dinamicCriteria.andNNumdepdestIn(destinos);
		}		
		example.or(dinamicCriteria);		
		example.or(dinamicCriteria2);
		try {
			VstBandejastrexMapper mapper = sqlSession.getMapper (VstBandejastrexMapper. class);
			List <VstBandejastrex> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getRegistrosCargo "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Actualiza los registros de un cargo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTDistribucion#updateRegistrosCargo(pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro, java.lang.String, java.util.Date, java.util.Date, java.lang.Short, java.lang.String, java.lang.String, java.lang.Short, java.util.List)
	 */
	public int updateRegistrosCargo(TdmvcRegistro entidad, String nNumdep, Date fechaI, Date fechaF, Short vAniohoja, String vNumhoja, String vCodentidad, Short nFlgtrex, List<Short> destinos, List <VstBandejastrex> listaRegistrosCargo) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			
			for (Iterator iterator = listaRegistrosCargo.iterator(); iterator
					.hasNext();) {
				VstBandejastrex vstBandejastrex = (VstBandejastrex) iterator.next();
				TdmvdRegxcorte entDet=new TdmvdRegxcorte();
				entDet.setvNumanoreg(vstBandejastrex.getPkd1());
				entDet.setnNumdep(vstBandejastrex.getPkd2());
				entDet.setnNumtipodoc(vstBandejastrex.getPkd3());
				entDet.setvNumreg(vstBandejastrex.getPkd4());
				entDet.setnNumitem(vstBandejastrex.getPkd5());
				entDet.setnNumenvio(vstBandejastrex.getPkd6());
				entDet.setvCodcorte(entidad.getvCodcorte());
				entDet.setvAnocorte(entidad.getvAnocorte());
				try {
					TdmvdRegxcorteMapper mapper = sqlSession.getMapper (TdmvdRegxcorteMapper. class);
					mapper.updateByPrimaryKeySelective(entDet);		
					sqlSession.commit();
				} catch (Exception e) {
					System.out.println("Falló la actualización de cargo en TdmvdRegxcorte");
				}
			}
			return 1;
		} catch (Exception e) {
			System.out.println("Error updateRegistrosCargo "+e.getMessage());   
        	return 0;
		} finally {
        	sqlSession.close ();
		}
		
		/*SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdmvcRegistroExample example = new TdmvcRegistroExample();
		pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistroExample.Criteria dinamicCriteria=example.createCriteria();	
		pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistroExample.Criteria dinamicCriteria2=example.createCriteria();
		dinamicCriteria.andNNumtipodocEqualTo(new Short("0")).andVAnocorteIsNull().andVCodcorteIsNull();
		dinamicCriteria2.andVAnocorteIsNull().andVCodcorteIsNull();
		if(nNumdep!=null)
		{
			dinamicCriteria.andNNumdepEqualTo(new Short(nNumdep));
			dinamicCriteria2.andNNumdeprmpEqualTo(new Short(nNumdep));
		}
		if(nFlgtrex!=null)
		{
			dinamicCriteria.andNFlgtrexEqualTo(nFlgtrex);
			dinamicCriteria2.andNFlgtrexEqualTo(nFlgtrex);
		}
		if(fechaI!=null && fechaF!=null)
		{
			dinamicCriteria.andDFecregBetween(fechaI, fechaF);
			dinamicCriteria2.andDFecrecmpBetween(fechaI, fechaF);
		}
		if(vAniohoja!=null)
		{
			dinamicCriteria.andVAniohojaEqualTo(vAniohoja);
		}
		if(vNumhoja!=null && !"".equals(vNumhoja.trim()))
		{
			dinamicCriteria.andVNumhojaEqualTo(vNumhoja);
		}
		if(vCodentidad!=null && !"".equals(vCodentidad.trim()))
		{
			dinamicCriteria.andVCodentidadEqualTo(vCodentidad);			
		}		
		if(destinos!=null)
		{
			dinamicCriteria.andNNumdepdestIn(destinos);
		}		
		example.or(dinamicCriteria);
		example.or(dinamicCriteria2);
		try {
			TdmvcRegistroMapper mapper = sqlSession.getMapper (TdmvcRegistroMapper. class);
			mapper.updateByExampleSelective(entidad, example);			
			sqlSession.commit();
			return 1;
		} catch (Exception e) {
        	System.out.println("Error updateRegistrosCargo "+e.getMessage());   
        	return 0;
        } finally {
        	sqlSession.close ();
		}*/
	}
	
	/*
	 * Recupera los registros asociados a un cargo
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTDistribucion#getRegistrosPorCargo(java.lang.String, java.lang.String)
	 */
	public List <VstBandejastrex> getRegistrosPorCargo(String vAnocorte, String vCodcorte) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstBandejastrexExample example = new VstBandejastrexExample();
		example.createCriteria().andVAnocorteEqualTo(vAnocorte).andVCodcorteEqualTo(vCodcorte);//andNNumtipodocEqualTo(new Short("0"))
		example.setOrderByClause("N_NUMDEPDEST, to_number(V_NUMHOJA) DESC");		
		try {
			VstBandejastrexMapper mapper = sqlSession.getMapper (VstBandejastrexMapper. class);
			List <VstBandejastrex> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getRegistrosPorCargo "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Recupera el listado de cargos
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTDistribucion#getHistoricoCargo(java.lang.String, java.util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	public List <TdmvcCorte> getHistoricoCargo(String nNumdep, Date fechaI, Date fechaF, String vAnocorte, String vCodcorte) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		TdmvcCorteExample example = new TdmvcCorteExample();
		pe.gob.sunafil.tramiteext.persistence.model.TdmvcCorteExample.Criteria dinamicCriteria=example.createCriteria();	
		dinamicCriteria.andNFlganuladoEqualTo(new Short("0")).andNNumdeporiEqualTo(new Short(nNumdep));
		if(fechaI!=null && fechaF!=null)
		{
			dinamicCriteria.andDFeccorteBetween(fechaI, fechaF);
		}
		if(vAnocorte!=null && !"".equals(vAnocorte.trim()))
		{
			dinamicCriteria.andVAnocorteEqualTo(vAnocorte);
		}
		if(vCodcorte!=null && !"".equals(vCodcorte.trim()))
		{
			dinamicCriteria.andVCodcorteEqualTo(vCodcorte);
		}		
		example.or(dinamicCriteria);		
		try {
			TdmvcCorteMapper mapper = sqlSession.getMapper (TdmvcCorteMapper. class);
			List <TdmvcCorte> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getHistoricoCargo "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*
	 * Actualiza un cargo en especifico
	 * @see pe.gob.sunafil.tramiteext.mybatis.interfase.INTDistribucion#actualizarCargo(pe.gob.sunafil.tramiteext.persistence.model.TdmvcCorte)
	 */
	public int actualizarCargo(TdmvcCorte corte) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TdmvcCorteMapper mapper = sqlSession.getMapper(TdmvcCorteMapper.class);		
		try {
			mapper.updateByPrimaryKey(corte);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error actualizarCargo "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}

}
