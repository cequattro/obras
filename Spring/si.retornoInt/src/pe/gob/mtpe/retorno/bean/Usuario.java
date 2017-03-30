package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

/**
 * Bean que almacena todos los atributos del Usuario Logueado.
 */
public class Usuario implements Serializable {
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1121658858852537067L;
	/**
     * (String)Atributo que almacena el codigo del Usuario del formulario
     */
    public String v_usuario;
    /**
     * (String)Atributo que almacena la contrase�a del usuario del formulario.
     */
    public String v_contrasena;
    /**
     * (String)Atributo que almacena el codigo del sistema
     */
    public String v_codsis;
    /**
     * (String)Atributo que almacena codigo del usuario de la BD
     */
    public String v_codusu;
    /**
     * (String)Atributo que almacena el password de la BD
     */
    public String v_passusu;
    /**
     * (String)Atributo que almacena el Flag que tiene el usuario
     */
    public String v_flgact;
    /**
     * (String)Atributo que almacena el permiso de Adminstracion
     */
    public String n_admin;
    /**
     * (String)Atributo que almacena el codigo del personal.
     */
    public String v_codpersonal;
    /**
     * (String)Atributo que almacena el apellido paterno.
     */
    public String v_desapepat;
    /**
     * (String)Atributo que almacena el apellido materno.
     */
    public String v_desapemat;
    /**
     * (String)Atributo que almacena los nombres.
     */
    public String v_desnombres;
    /**
     * (String)Atributo que almacena el codigo del cargo.
     */
    public String v_codcargo;
    /**
     * (String)Atributo que almacena el nombre del cargo.
     */
    public String v_nomcargo;
    /**
     * (String)Atributo que almacena la descripcion del cargo.
     */
    public String v_descargo;
    /**
     * (String)Atributo que almacena codigo de la escala remunerativa.
     */
    public String v_codescala;
    /**
     * (String)Atributo que almacena la abreviacion de la escala remunerativa.
     */
    public String v_abrvescala;
    /**
     * (String)Atributo que almacena el nombre de la escala remunerativa.
     */
    public String v_nomescala;
    /**
     * (String)Atributo que almacena descripcion de la escala remunerativa.
     */
    public String v_desescala;
    /**
     * (String)Atributo que almacena el codigo del tipo de persona.
     */
    public String v_codtipo;
    /**
     * (String)Atributo que almacena la descripcion del tipo de persona.
     */
    public String v_destipo;
    /**
     * (String)Atributo que almacena el numero de la Dependencia
     */
    public String n_numdep;
    /**
     * (String)Atributo que almacena el codigo de la Dependencia.
     */
    public String v_coddep;
    /**
     * (String)Atributo que almacena la descripcion de la Dependencia.
     */
    public String v_desdep;
    /**
     * (String)Atributo que almacena la abreviacion de la Dependencia.
     */
    public String v_desdepabr;
    /**
     * (String)Atributo que almacena el codigo de la zona.
     */
    public String v_codzon;
    /**
     * (String)Atributo que almacena el nombre de la zona.
     */
    public String v_nomzon;
    /**
     * (String)Atributo que almacena el codigo de la region.
     */
    public String v_codreg;
    /**
     * (String)Atributo que almacena el nombre de la region.
     */
    public String v_nomreg;
    /**
     * (String)Atributo que almacena el codigo de semejanza con la tabla Departamento.
     */
    public String v_codep;
    /**
     * (String)Atributo que almacena el host desde donde ingresa el usuario.
     */
    public String v_hostreg;
    
    
    
    /**
     * @return the n_admin
     */
    public String getN_admin() {
        return n_admin;
    }
    /**
     * @param n_admin the n_admin to set
     */
    public void setN_admin(String n_admin) {
        this.n_admin = n_admin;
    }
    /**
     * @return the n_numdep
     */
    public String getN_numdep() {
        return n_numdep;
    }
    /**
     * @param n_numdep the n_numdep to set
     */
    public void setN_numdep(String n_numdep) {
        this.n_numdep = n_numdep;
    }
    /**
     * @return the v_abrvescala
     */
    public String getV_abrvescala() {
        return v_abrvescala;
    }
    /**
     * @param v_abrvescala the v_abrvescala to set
     */
    public void setV_abrvescala(String v_abrvescala) {
        this.v_abrvescala = v_abrvescala;
    }
    /**
     * @return the v_codcargo
     */
    public String getV_codcargo() {
        return v_codcargo;
    }
    /**
     * @param v_codcargo the v_codcargo to set
     */
    public void setV_codcargo(String v_codcargo) {
        this.v_codcargo = v_codcargo;
    }
    /**
     * @return the v_coddep
     */
    public String getV_coddep() {
        return v_coddep;
    }
    /**
     * @param v_coddep the v_coddep to set
     */
    public void setV_coddep(String v_coddep) {
        this.v_coddep = v_coddep;
    }
    /**
     * @return the v_codep
     */
    public String getV_codep() {
        return v_codep;
    }
    /**
     * @param v_codep the v_codep to set
     */
    public void setV_codep(String v_codep) {
        this.v_codep = v_codep;
    }
    /**
     * @return the v_codescala
     */
    public String getV_codescala() {
        return v_codescala;
    }
    /**
     * @param v_codescala the v_codescala to set
     */
    public void setV_codescala(String v_codescala) {
        this.v_codescala = v_codescala;
    }
    /**
     * @return the v_codpersonal
     */
    public String getV_codpersonal() {
        return v_codpersonal;
    }
    /**
     * @param v_codpersonal the v_codpersonal to set
     */
    public void setV_codpersonal(String v_codpersonal) {
        this.v_codpersonal = v_codpersonal;
    }
    /**
     * @return the v_codreg
     */
    public String getV_codreg() {
        return v_codreg;
    }
    /**
     * @param v_codreg the v_codreg to set
     */
    public void setV_codreg(String v_codreg) {
        this.v_codreg = v_codreg;
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
     * @return the v_codtipo
     */
    public String getV_codtipo() {
        return v_codtipo;
    }
    /**
     * @param v_codtipo the v_codtipo to set
     */
    public void setV_codtipo(String v_codtipo) {
        this.v_codtipo = v_codtipo;
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
     * @return the v_codzon
     */
    public String getV_codzon() {
        return v_codzon;
    }
    /**
     * @param v_codzon the v_codzon to set
     */
    public void setV_codzon(String v_codzon) {
        this.v_codzon = v_codzon;
    }
    /**
     * @return the v_contrasena
     */
    public String getV_contrasena() {
        return v_contrasena;
    }
    /**
     * @param v_contrasena the v_contrasena to set
     */
    public void setV_contrasena(String v_contrasena) {
        this.v_contrasena = v_contrasena;
    }
    /**
     * @return the v_desapemat
     */
    public String getV_desapemat() {
        return v_desapemat;
    }
    /**
     * @param v_desapemat the v_desapemat to set
     */
    public void setV_desapemat(String v_desapemat) {
        this.v_desapemat = v_desapemat;
    }
    /**
     * @return the v_desapepat
     */
    public String getV_desapepat() {
        return v_desapepat;
    }
    /**
     * @param v_desapepat the v_desapepat to set
     */
    public void setV_desapepat(String v_desapepat) {
        this.v_desapepat = v_desapepat;
    }
    /**
     * @return the v_descargo
     */
    public String getV_descargo() {
        return v_descargo;
    }
    /**
     * @param v_descargo the v_descargo to set
     */
    public void setV_descargo(String v_descargo) {
        this.v_descargo = v_descargo;
    }
    /**
     * @return the v_desdep
     */
    public String getV_desdep() {
        return v_desdep;
    }
    /**
     * @param v_desdep the v_desdep to set
     */
    public void setV_desdep(String v_desdep) {
        this.v_desdep = v_desdep;
    }
    /**
     * @return the v_desdepabr
     */
    public String getV_desdepabr() {
        return v_desdepabr;
    }
    /**
     * @param v_desdepabr the v_desdepabr to set
     */
    public void setV_desdepabr(String v_desdepabr) {
        this.v_desdepabr = v_desdepabr;
    }
    /**
     * @return the v_desescala
     */
    public String getV_desescala() {
        return v_desescala;
    }
    /**
     * @param v_desescala the v_desescala to set
     */
    public void setV_desescala(String v_desescala) {
        this.v_desescala = v_desescala;
    }
    /**
     * @return the v_desnombres
     */
    public String getV_desnombres() {
        return v_desnombres;
    }
    /**
     * @param v_desnombres the v_desnombres to set
     */
    public void setV_desnombres(String v_desnombres) {
        this.v_desnombres = v_desnombres;
    }
    /**
     * @return the v_destipo
     */
    public String getV_destipo() {
        return v_destipo;
    }
    /**
     * @param v_destipo the v_destipo to set
     */
    public void setV_destipo(String v_destipo) {
        this.v_destipo = v_destipo;
    }
    /**
     * @return the v_flgact
     */
    public String getV_flgact() {
        return v_flgact;
    }
    /**
     * @param v_flgact the v_flgact to set
     */
    public void setV_flgact(String v_flgact) {
        this.v_flgact = v_flgact;
    }
    /**
     * @return the v_nomcargo
     */
    public String getV_nomcargo() {
        return v_nomcargo;
    }
    /**
     * @param v_nomcargo the v_nomcargo to set
     */
    public void setV_nomcargo(String v_nomcargo) {
        this.v_nomcargo = v_nomcargo;
    }
    /**
     * @return the v_nomescala
     */
    public String getV_nomescala() {
        return v_nomescala;
    }
    /**
     * @param v_nomescala the v_nomescala to set
     */
    public void setV_nomescala(String v_nomescala) {
        this.v_nomescala = v_nomescala;
    }
    /**
     * @return the v_nomreg
     */
    public String getV_nomreg() {
        return v_nomreg;
    }
    /**
     * @param v_nomreg the v_nomreg to set
     */
    public void setV_nomreg(String v_nomreg) {
        this.v_nomreg = v_nomreg;
    }
    /**
     * @return the v_nomzon
     */
    public String getV_nomzon() {
        return v_nomzon;
    }
    /**
     * @param v_nomzon the v_nomzon to set
     */
    public void setV_nomzon(String v_nomzon) {
        this.v_nomzon = v_nomzon;
    }
    /**
     * @return the v_passusu
     */
    public String getV_passusu() {
        return v_passusu;
    }
    /**
     * @param v_passusu the v_passusu to set
     */
    public void setV_passusu(String v_passusu) {
        this.v_passusu = v_passusu;
    }
    /**
     * @return the v_usuario
     */
    public String getV_usuario() {
        return v_usuario;
    }
    /**
     * @param v_usuario the v_usuario to set
     */
    public void setV_usuario(String v_usuario) {
        this.v_usuario = v_usuario;
    }
    /**
	 * @return the v_hostreg
	 */
	public String getV_hostreg() {
		return v_hostreg;
	}
	/**
	 * @param v_hostreg the v_hostreg to set
	 */
	public void setV_hostreg(String v_hostreg) {
		this.v_hostreg = v_hostreg;
	}
	
	
    
    
}
