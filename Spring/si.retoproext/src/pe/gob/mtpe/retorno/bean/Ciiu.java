package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class Ciiu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	///LLAVE PRIMARIA
    /**
	 * String vCodciiu 
	 * CÓDIGO DEL CIIU.
	 */
	private String vCodciiu;

    /**
	 * String vCodsec 
	 * CÓDIGO DEL TIPO DE RUBRO DEL EMPLEADOR.
	 */	
    private String vCodsec;
	//////////////////
	
    /**
	 * String vDesciiu 
	 * DESCRIPCIÓN DEL CIIU.
	 */	
    private String vDesciiu;

    /**
	 * Integer iFlgsunmin 
	 * IDENTIFICA SI EL REGISTRO ES DE LA SUNAT O DE MTPE.
	 */
    private Integer iFlgsunmin;

    /**
	 * String vCiiuSunat 
	 * CÓDIGO DEL CIIU QUE OTORGA LA SUNAT.
	 */
    private String vCiiuSunat;

    
    
    
    public String getvDesciiu() {
        return vDesciiu;
    }

    public void setvDesciiu(String vDesciiu) {
        this.vDesciiu = vDesciiu;
    }

    public Integer getiFlgsunmin() {
        return iFlgsunmin;
    }

    public void setiFlgsunmin(Integer iFlgsunmin) {
        this.iFlgsunmin = iFlgsunmin;
    }

    public String getvCiiuSunat() {
        return vCiiuSunat;
    }

    public void setvCiiuSunat(String vCiiuSunat) {
        this.vCiiuSunat = vCiiuSunat;
    }

	public String getvCodciiu() {
		return vCodciiu;
	}

	public void setvCodciiu(String vCodciiu) {
		this.vCodciiu = vCodciiu;
	}

	public String getvCodsec() {
		return vCodsec;
	}

	public void setvCodsec(String vCodsec) {
		this.vCodsec = vCodsec;
	}
    
}