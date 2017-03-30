package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class Distrito implements Serializable {
	
	 
	private static final long serialVersionUID = 1L;

	////LLAVE PRIMARIA
	/**
	 * String vCoddep 
	 * CÓDIGO DEL DEPARTAMENTO.
	 */
	private String vCoddep;

	/**
	 * String vCoddep 
	 * CÓDIGO DEL DISTRITO.
	 */
	private String vCoddis;

	/**
	 * String vCodpro 
	 * CÓDIGO DE LA PROVINCIA.
	 */
	private String vCodpro;
	///////////////////
	
	/**
	 * String vDesdis 
	 * NOMBRE O DESCRIPCIÓN DEL DISTRITO.
	 */
    private String vDesdis;

	/**
	 * String vAbrdis 
	 * ABREVIATURA DEL DISTRITO.
	 */
    private String vAbrdis;

	/**
	 * String vCodreg 
	 * REGIONAL DE TRABAJO
	 */
    private String vCodreg;

	/**
	 * String vCodzon 
	 * ZONA DE TRABAJO
	 */
    private String vCodzon;

	/**
	 * String vFlgact 
	 * INDICA SI SE ENCUENTRA ACTIVO O NO  ACTIVO = 1      NO ACTIVO =0
	 */
    private String vFlgact;
    
	/**
	 * String vCoddepren 
	 * CODIGO DE DEPARTAMENTO SEGUN TABLA 28 DE LAS PARAMETRICAS PARA TREGISTRO SEGUN RENIEC
	 */
    private String vCoddepren;
    
	/**
	 * String vCodproren 
	 * CODIGO DE PROVINCIA SEGUN TABLA 28 DE LAS PARAMETRICAS PARA TREGISTRO SEGUN RENIEC
	 */
	private String vCodproren;
	
	/**
	 * String vCoddisren 
	 * CODIGO DE DISTRITO SEGUN TABLA 28 DE LAS PARAMETRICAS PARA TREGISTRO SEGUN RENIEC
	 */
	private String vCoddisren;
	
	
	
	
	

    public String getvDesdis() {
        return vDesdis;
    }

    public void setvDesdis(String vDesdis) {
        this.vDesdis = vDesdis;
    }

    public String getvAbrdis() {
        return vAbrdis;
    }

    public void setvAbrdis(String vAbrdis) {
        this.vAbrdis = vAbrdis;
    }

    public String getvCodreg() {
        return vCodreg;
    }

    public void setvCodreg(String vCodreg) {
        this.vCodreg = vCodreg;
    }

    public String getvCodzon() {
        return vCodzon;
    }

    public void setvCodzon(String vCodzon) {
        this.vCodzon = vCodzon;
    }

    public String getvFlgact() {
        return vFlgact;
    }

    public void setvFlgact(String vFlgact) {
        this.vFlgact = vFlgact;
    }

	public String getvCoddep() {
		return vCoddep;
	}

	public void setvCoddep(String vCoddep) {
		this.vCoddep = vCoddep;
	}

	public String getvCoddis() {
		return vCoddis;
	}

	public void setvCoddis(String vCoddis) {
		this.vCoddis = vCoddis;
	}

	public String getvCodpro() {
		return vCodpro;
	}

	public void setvCodpro(String vCodpro) {
		this.vCodpro = vCodpro;
	}

	public String getvCoddepren() {
		return vCoddepren;
	}

	public void setvCoddepren(String vCoddepren) {
		this.vCoddepren = vCoddepren;
	}

	public String getvCodproren() {
		return vCodproren;
	}

	public void setvCodproren(String vCodproren) {
		this.vCodproren = vCodproren;
	}

	public String getvCoddisren() {
		return vCoddisren;
	}

	public void setvCoddisren(String vCoddisren) {
		this.vCoddisren = vCoddisren;
	}
    
	
    
}