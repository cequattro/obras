package pe.gob.sunafil.gestionpersonal.mybatis.interfase;

import java.util.List;

import pe.gob.sunafil.gestionpersonal.bean.Combo;

/**
 * Interface que declara los metodos de los combos y demas cosas comunes entre
 * los difeerentes formularios
**/
public interface INTCombos {
	
	 /**
     * Metodo que retorna una lista de tipo de documentos para el registro del 
     * notificador.
     * @return Lista de tipos de documentos.
     * @param tipo
     * @throws DaoException En caso de Error, este es controlado con el DAOExepcion para registrar el Error.
     */	
	public List<Combo> listaComboXTipo(String tipo) throws Exception;
	
	public List<Combo> listaProvinciasxDep(String coddep) throws Exception;
	
	public List<Combo> listaDistritosxPro(String coddep,String codpro) throws Exception;
	
	public List<Combo> listaTiposIdentifDeReclamo() throws Exception;
	
	public List<Combo> departamentoByCod(String coddep) throws Exception;
	
	public List<Combo> provinciaByCod(String coddep, String codpro) throws Exception;
	
	public List<Combo> distritoByCod(String coddep, String codpro, String coddis) throws Exception;
}