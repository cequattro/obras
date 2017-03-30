package pe.gob.mtpe.retorno.service.impl;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mtpe.retorno.bean.Permisos;
import pe.gob.mtpe.retorno.bean.Usuario;
import pe.gob.mtpe.retorno.dao.LogeoDao;
import pe.gob.mtpe.retorno.service.LogeoService;

@Service("logeoService")
public class LogeoServiceImpl implements LogeoService {

	final static Logger logger = Logger.getLogger(LogeoServiceImpl.class);

	@Autowired
	private LogeoDao logeoDao;

	@Override
	public List ValidaLogueo(Usuario loginForm) throws Exception {
		try {

			// Declaración del Objeto MAP para el envio de los parámetros.
			Map parametros = new HashMap();
			parametros.put("v_usuario", loginForm.getV_usuario().toUpperCase());
			ResultSet cuLista = null;
			parametros.put("cuLista", cuLista);
			logeoDao.obtieneUsuario(parametros);
			List lista = (List) parametros.get("cuLista");			
			return lista;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List ObtienePermisos(Usuario usuarioBean) throws Exception {

		try {

			// Declaración del Objeto MAP para el envio de los parámetros.
			Map parametros = new HashMap();
			parametros.put("v_usuario", usuarioBean.getV_usuario().toUpperCase());
			parametros.put("v_codsis", usuarioBean.getV_codsis());
			ResultSet cuLista = null;
			parametros.put("cuLista", cuLista);
			logeoDao.obtienePermisos(parametros);
			List lista = (List) parametros.get("cuLista");

			return lista;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List ObtieneMenuHijo(Usuario usuarioBean) throws Exception {
		try {

			// Declaración del Objeto MAP para el envio de los parámetros.
			Map parametros = new HashMap();
			parametros.put("v_usuario", usuarioBean.getV_usuario().toUpperCase());
			parametros.put("v_codsis", usuarioBean.getV_codsis());
			ResultSet cuLista = null;
			parametros.put("cuLista", cuLista);

			logeoDao.obtieneMenuHijo(parametros);
			List lista = (List) parametros.get("cuLista");
			return lista;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List ObtieneMenuPadre(Usuario usuarioBean, Permisos permisosBean) throws Exception {
		try {

			// Declaración del Objeto MAP para el envio de los parámetros.
			Map parametros = new HashMap();
			parametros.put("v_perfil", permisosBean.getV_codper());			
			parametros.put("v_codsis", usuarioBean.getV_codsis());
			ResultSet cuLista = null;
			parametros.put("cuLista", cuLista);

			logeoDao.obtieneMenuPadre(parametros);
			List lista = (List) parametros.get("cuLista");
			return lista;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public String ObtieneFecha() throws Exception {
		try {   			
			String fecha=logeoDao.obtieneFecha();			
            return fecha;
        } catch (Exception e) {
        	logger.error(e);          
        }
		return null;
	}

}
