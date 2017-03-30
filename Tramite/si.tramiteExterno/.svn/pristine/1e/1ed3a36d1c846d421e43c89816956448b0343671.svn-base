package pe.gob.sunafil.tramiteext.mybatis.despachadores;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.sunafil.tramiteext.bean.Combo;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTCombos;
import pe.gob.sunafil.tramiteext.mybatis.implementacion.IMPCombos;

/**
 * Capa Intermedia para la Implementacion de los Metodos del DAO ( Interfase y Implentacion)
 */
public class CombosDespatch implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(CombosDespatch.class.getName());
	
	private INTCombos combosDAO;
	
	public CombosDespatch(){
		combosDAO=new IMPCombos();
	}
	
	public List<Combo> listaComboXTipo(String tipo) throws Exception {
		return combosDAO.listaComboXTipo(tipo);
	}
	public List<Combo> listaProvinciasxDep(String coddep) throws Exception {
		return combosDAO.listaProvinciasxDep(coddep);
	}
	public List<Combo> listaDistritosxPro(String coddep,String codpro)throws Exception {
		return combosDAO.listaDistritosxPro(coddep,codpro);
	}
	
	public List<Combo> listaTiposIdentifDeReclamo() throws Exception {
		return combosDAO.listaTiposIdentifDeReclamo();
	}
	
	public List<Combo> departamentoByCod(String coddep) throws Exception {
		return combosDAO.departamentoByCod(coddep);
	}
	
	public List<Combo> provinciaByCod(String coddep, String codpro) throws Exception {
		return combosDAO.provinciaByCod(coddep, codpro);
	}
	
	public List<Combo> distritoByCod(String coddep, String codpro, String coddis) throws Exception {
		return combosDAO.distritoByCod(coddep, codpro, coddis);
	}

}
