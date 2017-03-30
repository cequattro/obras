package pe.gob.sunafil.postulacioncas.mybatis.despachadores;

import java.io.Serializable;

import org.apache.log4j.Logger;

import pe.gob.sunafil.postulacioncas.bean.HojaDeVida;
import pe.gob.sunafil.postulacioncas.bean.Persona;
import pe.gob.sunafil.postulacioncas.mybatis.implementacion.IMPPostulacion1;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTPostulacion1;

public class Postulacion1Despatch implements Serializable{

	private static final long serialVersionUID = 6046729202918921104L;
	private static Logger logger = Logger.getLogger(Postulacion1Despatch.class.getName());
	
private INTPostulacion1 postulacion1DAO;
	
	public Postulacion1Despatch(){
		postulacion1DAO=new IMPPostulacion1();
	}
	
	public String obtieneNombreConvocatoria(String v_desconv) throws Exception 
	{
		return postulacion1DAO.obtieneNombreConvocatoria(v_desconv);
	}
	
	public String insertarPostulacionCabecera(HojaDeVida hojadevida, Persona persona) throws Exception
	{
		return postulacion1DAO.insertarPostulacionCabecera(hojadevida, persona);
	}
}
