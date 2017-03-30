package pe.gob.sunafil.gentrama.mybatis.interfase;

import java.util.List;

import pe.gob.sunafil.gentrama.bean.Permisos;
import pe.gob.sunafil.gentrama.bean.Usuario;







/**
 * Interfase que Declara los metodos de la Validacion del Logueo.
 */
public interface INTLogueo  {
    /**
     * M�todo que retorna el usuario consultado, teniendo como condici�n  de busqueda
     * el c�digo del usuario.
     * 
     * @return Lista de la consulta seg�n el Usuario Logueado.
     * @param loginForm 
     * @throws DaoException En caso de Error, �ste es controlado con el DAOExepcion para registrar el Error.
     */
    public List ValidaLogueo(Usuario loginForm) throws Exception;
    /**
     * M�todo que retorna los permisos del usuario , teniendo como condici�n  de busqueda
     * el c�digo del usuario y el sistema.
     * 
     * @return Lista de la consulta seg�n los permisos encontrados.
     * @param usuarioBean 
     * @throws DaoException En caso de Error, �ste es controlado con el DAOExepcion para registrar el Error.
     */
    public List ObtienePermisos(Usuario usuarioBean) throws Exception;
    /**
     * M�todo que retorna el Menu Hijo , teniendo como condici�n  de busqueda
     * el c�digo del usuario y el sistema.
     * 
     * @return Lista de la consulta seg�n los permisos encontrados.
     * @param usuarioBean 
     * @param permisosBean 
     * @throws DaoException En caso de Error, �ste es controlado con el DAOExepcion para registrar el Error.
     */
   
    public String ObtieneFecha() throws Exception;
    /**
     * M?todo que retorna el Menu Hijo , teniendo como condici?n  de busqueda
     * el c?digo del usuario y el sistema.
     * 
     * @return Lista de la consulta seg?n los permisos encontrados.
     * @param usuarioBean 
     * @param permisosBean 
     * @throws DaoException En caso de Error, ?ste es controlado con el DAOExepcion para registrar el Error.
     */
    
    public List ObtieneMenuPadre(Usuario usuarioBean, Permisos permisosBean) throws Exception;
    /**
     * M?todo que retorna el Menu Padre , teniendo como condici?n  de busqueda
     * el perfil del usuario y el sistema.
     * @return Lista de la consulta seg?n los permisos encontrados.
     * @param usuarioBean 
     * @throws DaoException En caso de Error, ?ste es controlado con el DAOExepcion para registrar el Error.
     */
    public List ObtieneMenuHijo(Usuario usuarioBean) throws Exception;
}
