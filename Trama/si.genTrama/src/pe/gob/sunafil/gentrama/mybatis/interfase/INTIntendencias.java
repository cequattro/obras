package pe.gob.sunafil.gentrama.mybatis.interfase;

import java.util.List;

import pe.gob.sunafil.gentrama.bean.Combo;

/**
 * @author rgarrido
 * Interface que declara los metodos de los combos y demas cosas comunes entre
 * los difeerentes formularios
**/
public interface INTIntendencias {
	
	 /**
     * Método que retorna una lista de intendencias
     * @return Lista de Intendencias
     * @param -
     * @throws DaoException En caso de Error, este es controlado con el DAOExepcion para registrar el Error.
     */	
	public List<Combo> listaIntendencias() throws Exception;
	
}
