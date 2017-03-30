package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class Profesion implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * String vCodprof 
	 * CODIGO DE PROFESION
	 */
	private String vCodprof;

	/**
	 * String vDesprof 
	 * DESCRIPCION DE LA PROFESION
	 */
    private String vDesprof;

	/**
	 * String nFlgsunmin 
	 * 1 SI ES DE SIMINTRA / 0 SI ES DE SUNAT
	 */
    private Integer nFlgsunmin;

	/**
	 * String vCodggprof 
	 * CODIGO DEL GRAN GRUPO DE PROFESION
	 */
    private String vCodggprof;

	/**
	 * String vFlginei 
	 * CODIGO DEL GRAN GRUPO DE PROFESION
	 */
    private String vFlginei;
    
	/**
	 * String nCorocdem 
	 * CODIGO DEL GRAN GRUPO DE PROFESION
	 */
    private Integer nCorocdem;    
    
    
    public Integer getnCorocdem() {
		return nCorocdem;
	}

	public void setnCorocdem(Integer nCorocdem) {
		this.nCorocdem = nCorocdem;
	}

	public String getvCodprof() {
        return vCodprof;
    }

    public void setvCodprof(String vCodprof) {
        this.vCodprof = vCodprof;
    }

    public String getvDesprof() {
        return vDesprof;
    }

    public void setvDesprof(String vDesprof) {
        this.vDesprof = vDesprof;
    }

    public Integer getnFlgsunmin() {
        return nFlgsunmin;
    }

    public void setnFlgsunmin(Integer nFlgsunmin) {
        this.nFlgsunmin = nFlgsunmin;
    }

    public String getvCodggprof() {
        return vCodggprof;
    }

    public void setvCodggprof(String vCodggprof) {
        this.vCodggprof = vCodggprof;
    }

    public String getvFlginei() {
        return vFlginei;
    }

    public void setvFlginei(String vFlginei) {
        this.vFlginei = vFlginei;
    }
}