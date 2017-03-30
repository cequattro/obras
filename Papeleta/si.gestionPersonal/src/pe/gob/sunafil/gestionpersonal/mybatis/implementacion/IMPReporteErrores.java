package pe.gob.sunafil.gestionpersonal.mybatis.implementacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.gob.sunafil.gestionpersonal.funciones.Funciones;
import pe.gob.sunafil.gestionpersonal.mybatis.comun.MyBatisConnectionFactory;
import pe.gob.sunafil.gestionpersonal.mybatis.interfase.INTRptErrores;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstErrorescabrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.client.VstErroresrrhhMapper;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErrorescabrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErrorescabrrhhExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErrorescabrrhhExample.Criteria;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErroresrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErroresrrhhExample;

public class IMPReporteErrores implements INTRptErrores{
	private SqlSessionFactory sqlSessionFactory;

	public IMPReporteErrores(){
		  sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		  		  
	  }

	public List<VstErroresrrhh> getErrores(VstErroresrrhh filtro) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstErroresrrhhExample example = new VstErroresrrhhExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.VstErroresrrhhExample.Criteria dinamicCriteria=example.createCriteria();

		dinamicCriteria.andVCodusuregIsNotNull();
		if(filtro.getvMotivo()!=null && !"".equals(filtro.getvMotivo().trim()))
		{
			dinamicCriteria.andVMotivoEqualIgnoreCaseTo(filtro.getvMotivo().toUpperCase());
		}
		if(filtro.getnGrupocarga()!=null)
		{
			dinamicCriteria.andNGrupocargaEqualTo(filtro.getnGrupocarga());
		}
		example.or(dinamicCriteria);
		example.setOrderByClause("n_grupocarga asc, v_codpersonal asc, d_fecha asc");
		try {
			VstErroresrrhhMapper mapper = sqlSession.getMapper(VstErroresrrhhMapper. class);
			List <VstErroresrrhh> allRecords = mapper.selectByExample(example);	
			System.out.println("total ::: "+allRecords.size());
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getReporteErrores "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}

	public List<Map> reporteErrores(Map parametros) throws Exception 
	{	
		List<Map> resultado=new ArrayList<Map>();			
		SqlSession session = sqlSessionFactory.openSession();
		
		try {				
			resultado=session.selectList("Error.reporteErrores", parametros);			 
			return resultado;			
		} catch (Exception e) {			
			System.out.println("Error reporteUsuario "+e.getMessage());   
        	return null;
		} finally {
			session.close();
		}

	}
	
	public List<VstErrorescabrrhh> getErroresCab(Date fRegistroI, Date fRegistroF) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		VstErrorescabrrhhExample example = new VstErrorescabrrhhExample();
		pe.gob.sunafil.gestionpersonal.persistence.model.VstErrorescabrrhhExample.Criteria dinamicCriteria=example.createCriteria();

		dinamicCriteria.andVCodusuregIsNotNull();
		if(fRegistroI!=null && fRegistroF!=null)
		{
			Funciones.imprimir("::: Fecha Registro Inicio:"+fRegistroI + "  Fecha Registro Final:"+fRegistroF);
			dinamicCriteria.andDFecregoBetween(fRegistroI, fRegistroF);
		}
		example.or(dinamicCriteria);
		example.setOrderByClause("n_grupocarga asc, d_fecreg asc");
		try {
			VstErrorescabrrhhMapper mapper = sqlSession.getMapper(VstErrorescabrrhhMapper. class);
			List <VstErrorescabrrhh> allRecords = mapper.selectByExample(example);	
			System.out.println("total ::: "+allRecords.size());
			return allRecords;
		} catch (Exception e) {
        	System.out.println("Error getErroresCab "+e.getMessage());   
        	return null;
        } finally {
        	sqlSession.close ();
		}
	}
	
}
