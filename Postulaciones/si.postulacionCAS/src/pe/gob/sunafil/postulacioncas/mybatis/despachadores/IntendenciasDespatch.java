package pe.gob.sunafil.postulacioncas.mybatis.despachadores;

import java.io.Serializable;
import java.util.List;

import pe.gob.sunafil.postulacioncas.bean.Combo;
import pe.gob.sunafil.postulacioncas.mybatis.implementacion.IMPIntendencias;
import pe.gob.sunafil.postulacioncas.mybatis.interfase.INTIntendencias;

/**
 * Capa Intermedia para la Implementacion de los M�todos del DAO ( Interfase y Implentaci�n)
 */
public class IntendenciasDespatch implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	

	private INTIntendencias intendenciasDAO;
	
	public IntendenciasDespatch(){
		intendenciasDAO=new IMPIntendencias();
	}
	
	public List<Combo> listaIntendencias() throws Exception {
		return intendenciasDAO.listaIntendencias();
	}

}
