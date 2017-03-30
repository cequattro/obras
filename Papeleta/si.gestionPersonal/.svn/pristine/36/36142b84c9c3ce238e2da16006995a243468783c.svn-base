package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.MarcacionDespatch;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.client.PrtbcPersonalMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhmvcMarcacionMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhmvcPerturnoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcCargamasivaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcErrcarmasMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTipojusMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTipomarcacionMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbcTurnoMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.RhtbdPersonalMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.TdtbcDependenciaMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstMarcacionrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonalExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcMarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcMarcacionExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturnoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcCargamasiva;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcCargamasivaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcErrcarmas;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcErrcarmasExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipojus;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipojusExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipomarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipomarcacionExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurno;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnoExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPersonalExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbTdocide;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.gestionpersonal.persistence.model.TdtbcDependenciaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhhExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPersonalrrhh;

public class IMPMarcacion implements INTMarcacion {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPMarcacion(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }
		
	public int insertarMarcacion(RhmvcMarcacion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcMarcacionMapper mapper = sqlSession.getMapper(RhmvcMarcacionMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarMarcacion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}		
	
	public RhmvcMarcacion getCorrelativoGlobalMarcacion() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcMarcacionExample example = new RhmvcMarcacionExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhmvcMarcacionMapper mapper = sqlSession.getMapper (RhmvcMarcacionMapper. class);
			List <RhmvcMarcacion> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalMarcacion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean marcoEseDia(Date fecha,String codPersonal) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcMarcacionExample example = new RhmvcMarcacionExample();
		example.createCriteria().andDFechaEqualTo(fecha).andVCodpersonalEqualTo(codPersonal);
		try{
			RhmvcMarcacionMapper mapper = sqlSession.getMapper (RhmvcMarcacionMapper. class);
			List <RhmvcMarcacion> allRecords = mapper.selectByExample(example);		
			System.out.println("Cantidad de elmentos:"+allRecords.size());
			for(RhmvcMarcacion marcacion:allRecords)
				System.out.println("Marcacion:"+marcacion.getvCodpersonal()+ "Fecha:"+marcacion.getdFecha());
			return !allRecords.isEmpty();
		}catch(Exception e){
			return false;
		}finally{
			sqlSession.close();
		}
	}
	
	public boolean getExistePersonal(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		PrtbcPersonalExample example = new PrtbcPersonalExample();
		example.createCriteria().andNCodperrhhEqualTo(new BigDecimal(vCodpersonal)).andNFlgactivoEqualTo(new Short("1"));
		try {
			PrtbcPersonalMapper mapper = sqlSession.getMapper (PrtbcPersonalMapper. class);
			List <PrtbcPersonal> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getExistePersonal "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public PrtbcPersonal getPersonal(String vCodpersonal) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		PrtbcPersonalExample example = new PrtbcPersonalExample();
		example.createCriteria().andNCodperrhhEqualTo(new BigDecimal(vCodpersonal)).andNFlgactivoEqualTo(new Short("1"));
		try {
			PrtbcPersonalMapper mapper = sqlSession.getMapper (PrtbcPersonalMapper. class);
			List <PrtbcPersonal> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getPersonal "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean getTieneTurnoActivoParaPersonal(String vCodpersonal, String vflagAct)throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcPerturnoExample example = new RhmvcPerturnoExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andVFlgactEqualTo(vflagAct);
		try {
			RhmvcPerturnoMapper mapper = sqlSession.getMapper(RhmvcPerturnoMapper. class);
			List <RhmvcPerturno> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error getExisteTurnoActivoParaPersonal "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean tienePermisosParaJustificar(String vCodpersonal, String vflagAct,String vflagPrinc)throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbdPersonalExample example = new RhtbdPersonalExample();
		example.createCriteria().andVCodpersonalEqualTo(vCodpersonal).andVFlgactEqualTo(vflagAct).andVFlgprinEqualTo(vflagPrinc);
		try {
			RhtbdPersonalMapper mapper = sqlSession.getMapper(RhtbdPersonalMapper. class);
			List <RhtbdPersonal> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error tienePermisosParaJustificar "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhmvcMarcacion> eliminarMarcacionesRepetidas(Date dFechaI, Date dFechaF) throws Exception
	{
		List <RhmvcMarcacion> allRecordsDeleted=new ArrayList<RhmvcMarcacion>();
		int numRowsDeleted=0;
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcMarcacionExample example = new RhmvcMarcacionExample();
		example.createCriteria().andDFechaGreaterThanOrEqualTo(dFechaI).andDFechaLessThanOrEqualTo(dFechaF);	
		example.setOrderByClause("v_codpersonal, d_fecha, n_hora, n_minuto, n_segundo");
		try {
			RhmvcMarcacionMapper mapper = sqlSession.getMapper (RhmvcMarcacionMapper. class);
			List <RhmvcMarcacion> allRecords = mapper.selectByExample(example);			
			for (int i=0;i<allRecords.size();i++)
			{				
				if(i!=0)
				{
					RhmvcMarcacion currentItem=allRecords.get(i);
					RhmvcMarcacion previousItem=allRecords.get(i-1);
					if(currentItem.getvCodpersonal().equals(previousItem.getvCodpersonal()) &&
					   currentItem.getdFecha().equals(previousItem.getdFecha()) &&
					   currentItem.getnHora().equals(previousItem.getnHora()) &&
					   currentItem.getnMinuto().equals(previousItem.getnMinuto())							
							)
					{						
						//System.out.println("PERSONAL :: "+currentItem.getvCodpersonal()+" FECHA :: "+currentItem.getdFecha().toLocaleString());
						mapper.deleteByPrimaryKey(currentItem.getnCodmarcacion());
						sqlSession.commit();
						allRecordsDeleted.add(currentItem);
						++numRowsDeleted;
					}
				}
			}
			return allRecordsDeleted;
		} catch (Exception e) {
        	System.out.println("Error eliminarMarcacionesRepetidas "+e.getMessage());
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public boolean existeMarcacion(String codPersonal,Date fecha, String vDestipo ) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		VstMarcacionrrhhExample example = new VstMarcacionrrhhExample();
		example.createCriteria().andDFechaEqualTo(fecha).andVCodpersonalEqualTo(codPersonal).andVDestipoEqualTo(vDestipo);
		try {
			VstMarcacionrrhhMapper mapper = sqlSession.getMapper (VstMarcacionrrhhMapper. class);
			List <VstMarcacionrrhh> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error existeMarcacion "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <VstMarcacionrrhh> getMarcaciones(VstPersonalrrhh filtro, Date fMarcacionI, Date fMarcacionF) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstMarcacionrrhhExample example = new VstMarcacionrrhhExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhhExample.Criteria dinamicCriteria=example.createCriteria();
		dinamicCriteria.andVCodpersonalIsNotNull();
		if(filtro.getvCodtipodocid()!=null && !"".equals(filtro.getvCodtipodocid().trim()))
		{
			dinamicCriteria.andVCodtipodocidEqualTo(filtro.getvCodtipodocid());
		}
		if(filtro.getvCodpersonal()!=null && !"".equals(filtro.getvCodpersonal().trim()))
		{
			dinamicCriteria.andVCodpersonalEqualTo(filtro.getvCodpersonal());
		}
		if(filtro.getnNumdep()!=null)
		{
			dinamicCriteria.andNNumdepEqualTo(filtro.getnNumdep());
		}		
		if(filtro.getvCodtipo()!=null && !"".equals(filtro.getvCodtipo().trim()))
		{
			dinamicCriteria.andVCodtipoEqualTo(filtro.getvCodtipo());
		}
		if(fMarcacionI!=null && fMarcacionF!=null)
		{
			dinamicCriteria.andDFechaBetween(fMarcacionI, fMarcacionF);
		}
		if(filtro.getvDesapepat()!=null && !"".equals(filtro.getvDesapepat().trim()))
		{
			dinamicCriteria.andVDesapepatEqualTo(filtro.getvDesapepat().toUpperCase());
		}
		if(filtro.getvDesapemat()!=null && !"".equals(filtro.getvDesapemat().trim()))
		{
			dinamicCriteria.andVDesapematEqualTo(filtro.getvDesapemat().toUpperCase());
		}
		if(filtro.getvDesnombres()!=null && !"".equals(filtro.getvDesnombres().trim()))
		{
			dinamicCriteria.andVDesnombresEqualTo(filtro.getvDesnombres().toUpperCase());
		}
		example.or(dinamicCriteria);		
		try {
			VstMarcacionrrhhMapper mapper = sqlSession.getMapper (VstMarcacionrrhhMapper. class);
			List <VstMarcacionrrhh> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getMarcaciones "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcTipomarcacion> getTipoMarcacion() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTipomarcacionExample example = new RhtbcTipomarcacionExample();
		example.createCriteria().andVFlgactEqualTo("S");		
		try {
			RhtbcTipomarcacionMapper mapper = sqlSession.getMapper (RhtbcTipomarcacionMapper. class);
			List <RhtbcTipomarcacion> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoMarcacion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	/*public List <RhtbcTipomarcacion> getTipoMarcacion(int tipo) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTipomarcacionExample example = new RhtbcTipomarcacionExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipomarcacionExample.Criteria dinamicCriteria=example.createCriteria();
		dinamicCriteria.andVFlgactEqualTo("S");
		if(tipo==1 || tipo==2){
			if(tipo==1) dinamicCriteria.andVDestipoEqualTo("ENTRADA");
			else dinamicCriteria.andVDestipoEqualTo("SALIDA");
			}
		try {
			RhtbcTipomarcacionMapper mapper = sqlSession.getMapper (RhtbcTipomarcacionMapper. class);
			List <RhtbcTipomarcacion> allRecords = mapper.selectByExample(example);	
			
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoMarcacion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}*/
	
	public List <RhtbcTipojus> getTipoJustificacion() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcTipojusExample example = new RhtbcTipojusExample();
		example.createCriteria().andVFlgactEqualTo("S");		
		try {
			RhtbcTipojusMapper mapper = sqlSession.getMapper (RhtbcTipojusMapper. class);
			List <RhtbcTipojus> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTipoJustificacion "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int eliminarJustificacion(RhmvcMarcacion entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhmvcMarcacionMapper mapper = sqlSession.getMapper(RhmvcMarcacionMapper.class);		
		try {
			mapper.deleteByPrimaryKey(entidad.getnCodmarcacion());
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error eliminarJustificacion "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public List<VstMarcacionrrhh> getMarcacionesPorCodigoFecha(String vCodPersonal,Date fechaInicio,Date fechaFinal) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstMarcacionrrhhExample example = new VstMarcacionrrhhExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhhExample.Criteria dinamicCriteria = example.createCriteria();
		System.out.println("Fecha Inicio:"+fechaInicio+" Fecha Final:"+fechaFinal);
		if(vCodPersonal!=null && !"".equals(vCodPersonal.trim()))
		{
			dinamicCriteria.andVCodpersonalEqualTo(vCodPersonal);
		}
		if(fechaInicio!=null && fechaFinal!=null){
			dinamicCriteria.andDFechaBetween(fechaInicio, fechaFinal);
		}
		example.or(dinamicCriteria);
		try {
			VstMarcacionrrhhMapper mapper = sqlSession.getMapper (VstMarcacionrrhhMapper. class);
			List <VstMarcacionrrhh> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getTurno "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarItemCargaMasiva(RhtbcCargamasiva entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcCargamasivaMapper mapper = sqlSession.getMapper(RhtbcCargamasivaMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarItemCargaMasiva "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public RhtbcCargamasiva getCorrelativoGlobalItemCargaMasiva() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcCargamasivaExample example = new RhtbcCargamasivaExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbcCargamasivaMapper mapper = sqlSession.getMapper (RhtbcCargamasivaMapper. class);
			List <RhtbcCargamasiva> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalItemCargaMasiva "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public RhtbcCargamasiva getCorrelativoGlobalGrupoCargaMasiva() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcCargamasivaExample example = new RhtbcCargamasivaExample();
		example.createCriteria().andCorrelativoGrupoActual();
		try {
			RhtbcCargamasivaMapper mapper = sqlSession.getMapper (RhtbcCargamasivaMapper. class);
			List <RhtbcCargamasiva> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalGrupoCargaMasiva "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public int insertarItemError(RhtbcErrcarmas entidad) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcErrcarmasMapper mapper = sqlSession.getMapper(RhtbcErrcarmasMapper.class);		
		try {
			mapper.insertSelective(entidad);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {			
			System.out.println("Error insertarItemError "+e.getMessage());   
        	return 0;
		} finally{
			sqlSession.close();			
		}
	}
	
	public RhtbcErrcarmas getCorrelativoGlobalItemError() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcErrcarmasExample example = new RhtbcErrcarmasExample();
		example.createCriteria().andCorrelativoActual();
		try {
			RhtbcErrcarmasMapper mapper = sqlSession.getMapper (RhtbcErrcarmasMapper. class);
			List <RhtbcErrcarmas> allRecords = mapper.selectByExample(example);		
			return allRecords.get(0);
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalItemError "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public String getSiguienteCorrelativoItemError()
	{
		try {
			RhtbcErrcarmas correlativo=getCorrelativoGlobalItemError();
			if(correlativo!=null)
			{
				return ""+(Long.parseLong(""+correlativo.getnCoderror())+1);
			}
			else
			{
				//devuelve correlativo en 1				
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	public boolean existeMarcacion(RhtbcCargamasiva entidad)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhmvcMarcacionExample example = new RhmvcMarcacionExample();
		entidad.setvCodpersonal(completarCon(entidad.getvCodpersonal(),8,"0",0));//completar a 8 digitos pues el reloj guarda el dni en numero entero largo
		example.createCriteria().andVCodpersonalEqualTo(entidad.getvCodpersonal()).andDFechaEqualTo(entidad.getdFecha()).andNHoraEqualTo(entidad.getnHora()).andNMinutoEqualTo(entidad.getnMinuto());
		try {
			RhmvcMarcacionMapper mapper = sqlSession.getMapper (RhmvcMarcacionMapper. class);
			List <RhmvcMarcacion> allRecords = mapper.selectByExample(example);		
			return !allRecords.isEmpty();
		} catch (Exception e) {
        	System.out.println("Error existeMarcacion "+e.getMessage());   
        	return false;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcErrcarmas> depurarCargaMasivaItemsRepetidos(BigDecimal nGrupocarga) throws Exception
	{
		List <RhtbcErrcarmas> allRecordsDepured=new ArrayList<RhtbcErrcarmas>();
		int numRowsDepured=0;
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcCargamasivaExample example = new RhtbcCargamasivaExample();
		example.createCriteria().andNGrupocargaEqualTo(nGrupocarga);	
		example.setOrderByClause("v_codpersonal, d_fecha, n_hora, n_minuto, n_segundo");
		try {
			RhtbcCargamasivaMapper mapper = sqlSession.getMapper (RhtbcCargamasivaMapper. class);
			RhtbcErrcarmasMapper mapperError = sqlSession.getMapper(RhtbcErrcarmasMapper.class);
			List <RhtbcCargamasiva> allRecords = mapper.selectByExample(example);			
			for (int i=0;i<allRecords.size();i++)
			{			
				if(i==0)
				{
					RhtbcCargamasiva currentItem=allRecords.get(i);
					if(existeMarcacion(currentItem))
					{
						RhtbcErrcarmas currentError=new RhtbcErrcarmas();
						currentError.setnCoderror(new BigDecimal(getSiguienteCorrelativoItemError()));	    			
						currentError.setvCodpersonal(currentItem.getvCodpersonal());
						currentError.setdFecha(currentItem.getdFecha());
						currentError.setnHora(currentItem.getnHora());
						currentError.setnMinuto(currentItem.getnMinuto());
						currentError.setnSegundo(currentItem.getnSegundo());
						currentError.setvCodusureg(currentItem.getvCodusureg());
						currentError.setdFecreg(currentItem.getdFecreg());
						currentError.setvHostreg(currentItem.getvHostreg());
						currentError.setvMotivo("Marcación ya existe en la Base de Datos.");
						currentError.setnGrupocarga(nGrupocarga);
						currentError.setnCodcarga(currentItem.getnCodcarga());
		    			
						mapperError.insertSelective(currentError);
						sqlSession.commit();
						
						allRecordsDepured.add(currentError);
						++numRowsDepured;
					}
				}
				if(i!=0)
				{
					RhtbcCargamasiva currentItem=allRecords.get(i);
					RhtbcCargamasiva previousItem=allRecords.get(i-1);
					if(
						(Long.parseLong(currentItem.getvCodpersonal())==Long.parseLong(previousItem.getvCodpersonal()) &&
							currentItem.getdFecha().equals(previousItem.getdFecha()) &&
							currentItem.getnHora().equals(previousItem.getnHora()) &&
							currentItem.getnMinuto().equals(previousItem.getnMinuto()))
					   ||
					   		existeMarcacion(currentItem)
						)//se incluyo condición para validar con tabla marcacion de bd
					{	
						RhtbcErrcarmas currentError=new RhtbcErrcarmas();
						currentError.setnCoderror(new BigDecimal(getSiguienteCorrelativoItemError()));	    			
						currentError.setvCodpersonal(currentItem.getvCodpersonal());
						currentError.setdFecha(currentItem.getdFecha());
						currentError.setnHora(currentItem.getnHora());
						currentError.setnMinuto(currentItem.getnMinuto());
						currentError.setnSegundo(currentItem.getnSegundo());
						currentError.setvCodusureg(currentItem.getvCodusureg());
						currentError.setdFecreg(currentItem.getdFecreg());
						currentError.setvHostreg(currentItem.getvHostreg());		
						if(existeMarcacion(currentItem))
						{
							currentError.setvMotivo("Marcación ya existe en la Base de Datos.");
						}
						else
						{
							currentError.setvMotivo("Marcación repetida.");
						}
						currentError.setnGrupocarga(nGrupocarga);
						currentError.setnCodcarga(currentItem.getnCodcarga());
		    			
						mapperError.insertSelective(currentError);
						sqlSession.commit();
						
						allRecordsDepured.add(currentError);
						++numRowsDepured;
					}
				}
			}
			return allRecordsDepured;
		} catch (Exception e) {
        	System.out.println("Error depurarCargaMasivaItemsRepetidos "+e.getMessage());
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public String getSiguienteCorrelativoGlobalMarcacion()
	{
		try {
			RhmvcMarcacion correlativo=getCorrelativoGlobalMarcacion();
			if(correlativo!=null)
			{
				return ""+(Long.parseLong(""+correlativo.getnCodmarcacion())+1);
			}
			else
			{
				//devuelve correlativo en 1				
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	public List <RhmvcMarcacion> insertarCargaMasivaAMarcaciones(BigDecimal nGrupocarga) throws Exception
	{
		List <RhmvcMarcacion> allRecordsDepured=new ArrayList<RhmvcMarcacion>();
		int numRowsDepured=0;
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcCargamasivaExample example = new RhtbcCargamasivaExample();
		example.createCriteria().andNGrupocargaEqualTo(nGrupocarga).andSinErroresDeGrupo(nGrupocarga);	
		
		try {
			RhtbcCargamasivaMapper mapper = sqlSession.getMapper (RhtbcCargamasivaMapper. class);
			RhmvcMarcacionMapper mapperMarcacion = sqlSession.getMapper(RhmvcMarcacionMapper.class);
			List <RhtbcCargamasiva> allRecords = mapper.selectByExample(example);			
			for (int i=0;i<allRecords.size();i++)
			{				
					RhtbcCargamasiva currentItem=allRecords.get(i);
					RhmvcMarcacion entidad=new RhmvcMarcacion();
	    			entidad.setnCodmarcacion(new BigDecimal(getSiguienteCorrelativoGlobalMarcacion()));
	    			PrtbcPersonal equivalencia=getPersonal(currentItem.getvCodpersonal());
	    			entidad.setvCodpersonal(equivalencia.getvCodpersonal());
	    			entidad.setnCodorigen(new Short("1"));
	    			String horaMinuto=(completarCon(currentItem.getnHora()+"",2,"0",0)+""+completarCon(currentItem.getnMinuto()+"",2,"0",0)+"");
	    			if(Integer.parseInt(horaMinuto)<=1659)//1729
	    			{
	    				entidad.setnCodtipo(new Short("1"));//ENTRADA
	    			}
	    			if(Integer.parseInt(horaMinuto)>=1700)//1730
	    			{
	    				entidad.setnCodtipo(new Short("2"));//SALIDA
	    			}				    					    					    			
	    			entidad.setdFecha(currentItem.getdFecha());
	    			entidad.setnHora(currentItem.getnHora());
	    			entidad.setnMinuto(currentItem.getnMinuto());
	    			entidad.setnSegundo(currentItem.getnSegundo());
	    			//campos auditoria
	    			entidad.setvCodusureg(currentItem.getvCodusureg());
	    			entidad.setdFecreg(currentItem.getdFecreg());
	    			entidad.setvHostreg(currentItem.getvHostreg());
	    			
	    			System.out.println("Insertando Marcación ::: Fecha : "+currentItem.getdFecha()+" "
							+currentItem.getnHora()+":"+currentItem.getnMinuto()+":"+currentItem.getnSegundo()
							+" Personal : "+currentItem.getvCodpersonal());
	    			insertarMarcacion(entidad);
	    			allRecordsDepured.add(entidad);
					++numRowsDepured;									
			}
			return allRecordsDepured;
		} catch (Exception e) {
        	System.out.println("Error insertarCargaMasivaAMarcaciones "+e.getMessage());
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List <RhtbcErrcarmas> getErroresDeGrupo(BigDecimal nGrupocarga) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		RhtbcErrcarmasExample example = new RhtbcErrcarmasExample();
		example.createCriteria().andNGrupocargaEqualTo(nGrupocarga);	
		example.setOrderByClause("v_motivo, v_codpersonal, d_fecha, n_hora, n_minuto, n_segundo");
		try {
			RhtbcErrcarmasMapper mapper = sqlSession.getMapper (RhtbcErrcarmasMapper. class);
			List <RhtbcErrcarmas> allRecords = mapper.selectByExample(example);		
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getErroresDeGrupo "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
	public List<Map> reporteMisMarcaciones(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("MisMarcaciones.reporteMisMarcaciones", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteMisMarcaciones "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
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
	
}
