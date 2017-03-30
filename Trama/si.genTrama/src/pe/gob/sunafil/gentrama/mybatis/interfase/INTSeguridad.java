package pe.gob.sunafil.gentrama.mybatis.interfase;

import java.util.List;

import pe.gob.sunafil.gentrama.bean.Usuario;

 

 

public interface INTSeguridad {

	// Seguridad Validaciones
	public String retornaFlgNuevo(Usuario usua) throws Exception;

	public String retornaFechaUltActualizacion(Usuario usua)
			throws Exception;

	public String retornaMeses(String valor) throws Exception;

	public String retornaMesesValidacion() throws Exception;

	public List listaClavesDesencriptadas(Usuario usua) throws Exception;

	public void cambiarClave(String codUsu, String passUsu, String nomHost)
			throws Exception;

	public String retornaDiasCaducaFecha(Usuario usua) throws Exception;

	public String retornaDiasNoActualizaFecha(Usuario usua)
			throws Exception;

}
