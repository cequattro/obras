package pe.gob.sunafil.denunciavirtual.mybatis.despachadores;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.sunafil.denunciavirtual.bean.Combo;
import pe.gob.sunafil.denunciavirtual.mybatis.implementacion.IMPCombos;
import pe.gob.sunafil.denunciavirtual.mybatis.interfase.INTCombos;

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
	
	/**
	 * Obtiene todas las provincias del departamento seleccionado
	 * @param coddep
	 * @return
	 * @throws Exception
	 */
	public List<Combo> listaProvinciasxDep(String coddep) throws Exception {
		return combosDAO.listaProvinciasxDep(coddep);
	}
	
	/**
	 * Obtiene las provincias por el departamento de competencia SUNAFIL Seleccionado
	 * @param coddep
	 * @return
	 * @throws Exception
	 */
	public List<Combo> listaProvinciasxDepEmp(String coddep) throws Exception {
		return combosDAO.listaProvinciasxDepEmp(coddep);
	}
	/**
	 * Obtiene todos los distritos de la provincia seleccionada
	 * @param coddep
	 * @param codpro
	 * @return
	 * @throws Exception
	 */
	public List<Combo> listaDistritosxPro(String coddep,String codpro)throws Exception {
		return combosDAO.listaDistritosxPro(coddep,codpro);
	}
	/**
	 * Obtiene los distritos de la provincia de competencia de SUNAFIL seleccionada
	 * @param coddep
	 * @param codpro
	 * @return
	 * @throws Exception
	 */
	public List<Combo> listaDistritosxProEmp(String coddep,String codpro)throws Exception {
		return combosDAO.listaDistritosxProEmp(coddep,codpro);
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
