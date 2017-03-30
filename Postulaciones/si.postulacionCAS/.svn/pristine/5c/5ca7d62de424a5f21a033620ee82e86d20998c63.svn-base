package pe.gob.sunafil.postulacioncas.mybatis.implementacion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.data.cache.BigDecimalValues;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import pe.gob.sunafil.postulacioncas.bean.HojaDeVida;
import pe.gob.sunafil.postulacioncas.bean.Persona;
import pe.gob.sunafil.postulacioncas.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTPostulacion1;
import pe.gob.sunafil.postulacioncas.persistence.client.RhtbcConvocatoriaMapper;
import pe.gob.sunafil.postulacioncas.persistence.client.RhtbcHojadevidaMapper;
import pe.gob.sunafil.postulacioncas.persistence.client.SitbPersonaMapper;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcConvocatoria;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcConvocatoriaExample;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcHojadevida;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcHojadevidaExample;
import pe.gob.sunafil.postulacioncas.persistence.model.SitbPersona;
import pe.gob.sunafil.postulacioncas.persistence.model.SitbPersonaExample;
import pe.gob.sunafil.postulacioncas.utils.FacesUtils;

public class IMPPostulacion1 implements INTPostulacion1{
	
	private static Logger logger = Logger.getLogger(IMPPostulacion1.class.getName());
	
	private SqlSessionFactory sqlSessionFactory;
	
	public IMPPostulacion1(){
		sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	@Override
	public String obtieneNombreConvocatoria(String n_corconv) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RhtbcConvocatoriaExample example = new RhtbcConvocatoriaExample();
		example.createCriteria().andNCorconvEqualTo(new BigDecimal(n_corconv));
		RhtbcConvocatoriaMapper mapper = sqlSession.getMapper(RhtbcConvocatoriaMapper.class);
		try {
			List <RhtbcConvocatoria> allRecords = mapper.selectByExample(example);
			if(allRecords == null ){
				return null;
			}else if (allRecords.size() == 0){
				return null;
			}else{
				return allRecords.get(0).getvPuesto();
			}
			
		} catch (Exception e) {
			logger.error("Error actualizarRegistroEntradaSIIT "+e.getMessage(),e);   
        	return null;
		} finally{
			sqlSession.close();			
		}
		
	}
	
	
	public String insertarPostulacionCabecera(HojaDeVida hojadevida, Persona persona) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String paso="1";
		
		String out_n_corhojvid ="";
		
		try {
			//********************************************************
			//VERIFICAMOS SI LA PERSONA EXISTE:
			//********************************************************
			SitbPersonaExample examplePer = new SitbPersonaExample();
			examplePer.createCriteria().andVCodtdocideEqualTo(persona.getV_codtdocide()).andVNumdocEqualTo(persona.getV_numdoc());
			SitbPersonaMapper  mapperPer = sqlSession.getMapper(SitbPersonaMapper.class);
			List <SitbPersona> allRecordsPer = mapperPer.selectByExample(examplePer);
			
			
			
			if(allRecordsPer.size()>=1){//EXISTE
				
				paso="2.1";
				
				SitbPersona personaBD = allRecordsPer.get(0);
				
				//ACTUALIZAMOS A LA PERSONA SEGUN SEA O NO DE RENIEC
				SitbPersonaMapper  mapperPerAct = sqlSession.getMapper(SitbPersonaMapper.class);
				SitbPersona sitbPersonaAct = new SitbPersona();
				
				sitbPersonaAct.setvNumdoc(persona.getV_numdoc());
				sitbPersonaAct.setvCodtdocide(persona.getV_codtdocide());
				sitbPersonaAct.setvCoddepsun(persona.getV_coddepnac());//INGRESANDO AL NUEVO CAMPO DEP NAC SUNAFIL
				sitbPersonaAct.setvCodprosun(persona.getV_codpronac());//INGRESANDO AL NUEVO CAMPO PRO NAC SUNAFIL
				sitbPersonaAct.setvCoddissun(persona.getV_coddisnac());//INGRESANDO AL NUEVO CAMPO DIS NAC SUNAFIL
				
				if(!"S".equals(personaBD.getvFlgreniec())){//SI NO VIENE DE RENIEC ACTUALIZAMOS TODOS LOS DEMAS DATOS NECESARIOS:
					sitbPersonaAct.setvApepater(persona.getV_apepat());
					sitbPersonaAct.setvApemater(persona.getV_apemat());
					sitbPersonaAct.setvNombres(persona.getV_nombres());
					sitbPersonaAct.setdFecnac(persona.getD_fecnac());
					sitbPersonaAct.setvNomusumod("CONVOCATORIACAS");//le ponemos el esquema de rrhhsys
					sitbPersonaAct.setdFecmod(new Date());//le ponemos el esquema de rrhhsys
					sitbPersonaAct.setvHostmod(FacesUtils.getIpAddress());
				}
				mapperPerAct.updateByPrimaryKeySelective(sitbPersonaAct);
				
			}else{
				paso="2.2";
				//COMO NO EXISTE SE INSERTA:
				SitbPersonaMapper  mapperPerIns = sqlSession.getMapper(SitbPersonaMapper.class);
				SitbPersona sitbPersonaIns = new SitbPersona();
				
				sitbPersonaIns.setvNumdoc(persona.getV_numdoc());
				sitbPersonaIns.setvCodtdocide(persona.getV_codtdocide());
				sitbPersonaIns.setvCoddepsun(persona.getV_coddepnac());//INGRESANDO AL NUEVO CAMPO DEP NAC SUNAFIL
				sitbPersonaIns.setvCodprosun(persona.getV_codpronac());//INGRESANDO AL NUEVO CAMPO PRO NAC SUNAFIL
				sitbPersonaIns.setvCoddissun(persona.getV_coddisnac());//INGRESANDO AL NUEVO CAMPO DIS NAC SUNAFIL
				sitbPersonaIns.setvApepater(persona.getV_apepat());
				sitbPersonaIns.setvApemater(persona.getV_apemat());
				sitbPersonaIns.setvNombres(persona.getV_nombres());
				sitbPersonaIns.setdFecnac(persona.getD_fecnac());
				sitbPersonaIns.setvFlgreniec("N");//no es de reniec
				sitbPersonaIns.setvCodsisreg("016");//codigo de sistema de ingreso de data
				sitbPersonaIns.setvNomusureg("CONVOCATORIACAS");//le ponemos el esquema de rrhhsys
				sitbPersonaIns.setdFecreg(new Date());
				sitbPersonaIns.setvHostreg(FacesUtils.getIpAddress());
				mapperPerIns.insertSelective(sitbPersonaIns);
				
			}
			
			paso="3";
			
			//********************************************************
			//INSERTANDO LA TABLA CABECERA:
			//********************************************************
			RhtbcHojadevidaExample exampleHV1 = new RhtbcHojadevidaExample();
			exampleHV1.createCriteria().andCorrelativoActual();
			BigDecimal n_corhojvid = new BigDecimal(0);
		
			
			//OBTENEMOS EL CORRELATIVO DE HOJA DE VIDA:
			RhtbcHojadevidaMapper mapperHV1 = sqlSession.getMapper(RhtbcHojadevidaMapper.class);
			List <RhtbcHojadevida> allRecords = mapperHV1.selectByExample(exampleHV1);
			
			paso="4";
			
			if(allRecords.size()>=1){
				n_corhojvid = allRecords.get(0).getnCorhojvid();
			}
			n_corhojvid = n_corhojvid.add(new BigDecimal(1));//sumando 1
			
			out_n_corhojvid = n_corhojvid+"";//PARA LA SALIDA DE ESTE METODO.
			
			RhtbcHojadevidaMapper mapperHV2 = sqlSession.getMapper(RhtbcHojadevidaMapper.class);
			
			//INSERTANDO LA HOJA DE VIDA:
			RhtbcHojadevida record = new RhtbcHojadevida();
			record.setnCorhojvid(n_corhojvid);
			record.setvNumdoc(persona.getV_numdoc());
			record.setvCodtdocide(persona.getV_codtdocide());
			record.setnCorconv(new BigDecimal(hojadevida.getN_corconv()));
			record.setvNacionali(hojadevida.getV_nacionalidad().toUpperCase());
			record.setvCoddepdom(hojadevida.getV_coddepdom());
			record.setvCodprodom(hojadevida.getV_codprodom());
			record.setvCoddisdom(hojadevida.getV_coddisdom());
			record.setvUrbanizac(hojadevida.getV_urbanizac().toUpperCase());
			record.setvDireccion(hojadevida.getV_direccion().toUpperCase());
			record.setvTelfij(hojadevida.getV_telfij());
			record.setvTelcel(hojadevida.getV_telcel());
			record.setvDescolegio(hojadevida.getV_descolegio().toUpperCase());
			record.setvNumregcol(hojadevida.getV_numregcol().toUpperCase());
			record.setvFlgdis(hojadevida.getV_flgdis());
			if("S".equalsIgnoreCase(hojadevida.getV_flgdis()))
			{
				record.setvFlgdiscer(hojadevida.getV_flgcerdis());
			}
			else
			{
				record.setvFlgdiscer("N");
			}
			record.setvFlglicfa(hojadevida.getV_flglicfa());
			if("S".equalsIgnoreCase(hojadevida.getV_flglicfa()))
			{
				record.setvFlglicfacer(hojadevida.getV_flgcerlicfa());
			}
			else
			{
				record.setvFlglicfacer("N");
			}
			record.setvHostreg(FacesUtils.getIpAddress());
			record.setvCodestciv(hojadevida.getV_codestciv());
			record.setvCorele(hojadevida.getV_correo().toUpperCase());
			record.setdFecreg(new Date());
			
			mapperHV2.insertSelective(record);
			sqlSession.commit();
			
		} catch (Exception e) {
        	System.out.println("Error getCorrelativoGlobalTurno "+e.getMessage());   
        	logger.error(e.getMessage(),e);
        	return null;
        } finally {
        	sqlSession.close ();
		}
		
		return out_n_corhojvid;//DEVOLVEMOS EL CORRELATIVO DE LA HOJA DE VIDA
	}
	
	
	
}
