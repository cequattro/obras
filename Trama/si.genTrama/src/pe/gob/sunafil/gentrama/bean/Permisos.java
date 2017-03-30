package pe.gob.sunafil.gentrama.bean;

import java.io.Serializable;

/**
 * Bean que almacena todos los atributos de los Permisos de cada Sistema.
 */
public class Permisos implements Serializable {
    
    /**
     * (String)Atributo que almacena el codigo del Sistema
     */
    public String v_codsis;
    /**
     * (String)Atributo que almacena el nombre del sistema
     */
    public String v_nomsis;
    /**
     * (String)Atributo que almacena codigo del usuario
     */
    public String v_codusu;
    /**
     * (String)Atributo que almacena el codigo del Perfil
     */
    public String v_codper;
    /**
     * (String)Atributo que almacena la descripcion del Perfil
     */
    public String v_desper;
    
	/**
	 * @return the v_codper
	 */
	public String getV_codper() {
		return v_codper;
	}
	/**
	 * @param v_codper the v_codper to set
	 */
	public void setV_codper(String v_codper) {
		this.v_codper = v_codper;
	}
	/**
	 * @return the v_codsis
	 */
	public String getV_codsis() {
		return v_codsis;
	}
	/**
	 * @param v_codsis the v_codsis to set
	 */
	public void setV_codsis(String v_codsis) {
		this.v_codsis = v_codsis;
	}
	/**
	 * @return the v_codusu
	 */
	public String getV_codusu() {
		return v_codusu;
	}
	/**
	 * @param v_codusu the v_codusu to set
	 */
	public void setV_codusu(String v_codusu) {
		this.v_codusu = v_codusu;
	}
	/**
	 * @return the v_desper
	 */
	public String getV_desper() {
		return v_desper;
	}
	/**
	 * @param v_desper the v_desper to set
	 */
	public void setV_desper(String v_desper) {
		this.v_desper = v_desper;
	}
	/**
	 * @return the v_nomsis
	 */
	public String getV_nomsis() {
		return v_nomsis;
	}
	/**
	 * @param v_nomsis the v_nomsis to set
	 */
	public void setV_nomsis(String v_nomsis) {
		this.v_nomsis = v_nomsis;
	}
  
    
    /**
     * Metodo que imprime los datos que contiene el Bean.
     */
    public String toString() {
        String cadena = null;
        cadena = "\n";
        cadena += " \tINFO - PermisosBean : (String)v_codsis => "+v_codsis+"\n";
        cadena += " \tINFO - PermisosBean : (String)v_nomsis => "+v_nomsis+"\n";
        cadena += " \tINFO - PermisosBean : (String)v_codusu => "+v_codusu+"\n";    
        cadena += " \tINFO - PermisosBean : (String)v_codper => "+v_codper+"\n";
        cadena += " \tINFO - PermisosBean : (String)v_desper => "+v_desper+"\n";
        return cadena;
    }
    
    
}
