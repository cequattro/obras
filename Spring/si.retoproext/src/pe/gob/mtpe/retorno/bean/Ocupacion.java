package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class Ocupacion implements Serializable{
    
	 
	private static final long serialVersionUID = 1L;

	/**
	 * String vCodocupac 
	 * CODIGO DE OCUPACION
	 */
	private String vCodocupac; 

	/**
	 * String vDesocupac 
	 * DESCRIPCION DE OCUPACION
	 */
    private String vDesocupac;

	/**
	 * String nFlgsunmin 
	 * 1 SI ES AGREGADO POR MINTRA / 0 SI ES DE SUNAT
	 */
    private Integer nFlgsunmin;

	/**
	 * String vCodggocup 
	 * CAMPO DEL CODIGO GRAN GRUPO OCUPACION
	 */
    private String vCodggocup;

	/**
	 * String vFlginei 
	 * CODIGO VALIDACION INEI 1=VALIDADO     0=NO VALIDADO
	 */
    private String vFlginei;

    
    
    
    
    public String getvCodocupac() {
        return vCodocupac;
    }

    public void setvCodocupac(String vCodocupac) {
        this.vCodocupac = vCodocupac;
    }

    public String getvDesocupac() {
        return vDesocupac;
    }

    public void setvDesocupac(String vDesocupac) {
        this.vDesocupac = vDesocupac;
    }

    public Integer getnFlgsunmin() {
        return nFlgsunmin;
    }

    public void setnFlgsunmin(Integer nFlgsunmin) {
        this.nFlgsunmin = nFlgsunmin;
    }

    public String getvCodggocup() {
        return vCodggocup;
    }

    public void setvCodggocup(String vCodggocup) {
        this.vCodggocup = vCodggocup;
    }

    public String getvFlginei() {
        return vFlginei;
    }

    public void setvFlginei(String vFlginei) {
        this.vFlginei = vFlginei;
    }
    
    
}