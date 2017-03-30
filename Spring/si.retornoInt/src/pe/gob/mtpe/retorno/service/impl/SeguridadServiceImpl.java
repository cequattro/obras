package pe.gob.mtpe.retorno.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mtpe.retorno.bean.Usuario;
import pe.gob.mtpe.retorno.dao.SeguridadDao;
import pe.gob.mtpe.retorno.service.SeguridadService;

@Service("seguridadService")
public class SeguridadServiceImpl implements SeguridadService {

	final static Logger depurador = Logger.getLogger(SeguridadServiceImpl.class);

	@Autowired
	private SeguridadDao seguridadDao;

	@Override
	public List listaClavesDesencriptadas(Usuario usuario) throws Exception {
		try {			
			Map para = new HashMap();
			para.put("v_codusu", usuario.getV_codusu());
			String v_codusu = usuario.getV_codusu();
			List lista = new ArrayList();
			lista = seguridadDao.tresUltClavesEncriptadas(usuario);			
			return lista;
		} catch (Exception e) {
			depurador.error("ERROR ", e);
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}

	}

	@Override
	public String retornaFlgNuevo(Usuario usua) throws Exception {
		try {
			return seguridadDao.esUsuarioNuevo(usua);
		} catch (Exception e) {
			depurador.error("ERROR : ", e);
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}

	}

	@Override
	public String retornaFechaUltActualizacion(Usuario usua) throws Exception {
		try {

			return seguridadDao.fechaUltActualizacion(usua);
		} catch (Exception e) {
			depurador.error("ERROR : ", e);
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}
	}

	@Override
	public String retornaDiasCaducaFecha(Usuario usua) throws Exception {
		try {
			return seguridadDao.diasCaducaFecha(usua);
		} catch (Exception e) {
			depurador.error("ERROR : ", e);
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}
	}

	@Override
	public String retornaDiasNoActualizaFecha(Usuario usua) throws Exception {
		try {			 
			return seguridadDao.diasNoActualizaFecha(usua);
		} catch (Exception e) {			 
			depurador.error("ERROR : ", e);
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}
	}

	@Override
	public String retornaMeses(String valor) throws Exception {
		try {			 
			return seguridadDao.numMeses(valor);
		} catch (Exception e) {			 
			depurador.error("ERROR : ", e);
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}
	}

	@Override
	public String retornaMesesValidacion() throws Exception {
		try {
			 
			return seguridadDao.numMesValidacion();
		} catch (Exception e) {			 
			depurador.error("ERROR : " , e);
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}
	}

	@Override
	public void cambiarClave(String codUsu, String passUsu, String nomHost) throws Exception {
		try {			 

			Map parametros = new HashMap();
			parametros.put("p_v_codusu", codUsu);
			parametros.put("p_v_pass", passUsu);
			parametros.put("p_v_hostMod", nomHost);			
			seguridadDao.cambiarClave(parametros);			
		} catch (Exception e) {			 
			depurador.error("ERROR : ",e);
			throw new Exception("Error en retornaFlgCongreso de IMPseguridad: " + e);
		}
		
	}

}
