package pe.gob.mtpe.retorno.despachadores;

import java.sql.SQLException;
import java.util.List;
 




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.mtpe.retorno.bean.Usuario;
import pe.gob.mtpe.retorno.service.SeguridadService;


@Component
public class SeguridadDespatch {

	@Autowired
	private SeguridadService seguridadDAO;
	private static Logger depurador = Logger.getLogger(SeguridadDespatch.class
			.getName());

	public SeguridadDespatch() {
		//seguridadDAO = new IMPSeguridad();
	}

	public void cambiarClave(String codUsu, String passUsu, String nomHost)
			throws Exception {
		seguridadDAO.cambiarClave(codUsu, passUsu, nomHost);
	}

	public String retornaFlgNuevo(Usuario usua) throws  Exception {
		return seguridadDAO.retornaFlgNuevo(usua);
	}

	public String retornaFechaUltActualizacion(Usuario  usua)
			throws Exception {
		return seguridadDAO.retornaFechaUltActualizacion(usua);
	}

	public String retornaMesesValidacion() throws Exception {

		return seguridadDAO.retornaMesesValidacion();
	}

	public String retornaDiasCaducaFecha(Usuario usua) throws Exception {
		return seguridadDAO.retornaDiasCaducaFecha(usua);
	}

	public String retornaDiasNoActualizaFecha(Usuario usua)
			throws Exception {
		return seguridadDAO.retornaDiasNoActualizaFecha(usua);
	}

	public String retornaMeses(String valor) throws Exception {

		return seguridadDAO.retornaMeses(valor);
	}
	
	public List listaClavesDesencriptadas(Usuario usuario) throws Exception {		
		return seguridadDAO.listaClavesDesencriptadas(usuario);
	}

}