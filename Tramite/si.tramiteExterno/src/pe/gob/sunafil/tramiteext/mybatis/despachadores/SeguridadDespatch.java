package pe.gob.sunafil.tramiteext.mybatis.despachadores;

import java.sql.SQLException;
import java.util.List;
 






import org.apache.log4j.Logger;

import pe.gob.sunafil.tramiteext.bean.Usuario;
import pe.gob.sunafil.tramiteext.mybatis.implementacion.IMPSeguridad;
import pe.gob.sunafil.tramiteext.mybatis.interfase.INTSeguridad;
 
 

public class SeguridadDespatch {

	 
	private INTSeguridad seguridadDAO;
	private static Logger depurador = Logger.getLogger(SeguridadDespatch.class
			.getName());

	public SeguridadDespatch() {
		seguridadDAO = new IMPSeguridad();
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
		System.out.println("entra listaClavesDesencriptadas");
		return seguridadDAO.listaClavesDesencriptadas(usuario);
	}

}