package pe.gob.mtpe.retorno.bean;

public class Tdocide {
	
	/**
	 * String vCodtdocide 
	 * CÓDIGO DEL TIPO DE DOCUMENTO DE IDENTIDAD DEL TRABAJADOR.
	 */
    private String vCodtdocide;

	/**
	 * String vDestdocide 
	 * DESCRIPCIÓN DEL TIPO DE DOCUMENTO DE IDENTIDAD.
	 */
    private String vDestdocide;

	/**
	 * String vDesabr 
	 * ABREVIATURA DEL TIPO DE DOCUMENTO DE IDENTIDAD.
	 */
    private String vDesabr;

	/**
	 * Short vDesabr 
	 * IDENTIFICA SI EL REGISTRO ES DE LA SUNAT O DE MTPE.
	 */
    private Short nFlgsunmin;

	/**
	 * Short nFlgestdoc 
	 * IDENTIFICA SI EL TIPO DE DOCUMENTO DE IDENTIDAD ESTA ACTIVO (1) o NO (0)
	 */
    private Short nFlgestdoc;

	/**
	 * Short nFlgvidley 
	 * IDENTIFICA LOS TIPOS DE DOCUMENTOS QUE SE USAN EN EL SISTEMA DE SEGURO VIDA LEY
	 */
    private Short nFlgvidley;

	/**
	 * Short nFlgvac 
	 * IDENTIFICA LOS TIPOS DE DOCUMENTOS QUE SE USAN EN EL SISTEMA DE SEGURO VIDA LEY
	 */
    private Short nFlgvac;

    /**
	 * Short vFlgvupe 
	 * FLAG VUPE PARA CIUDADANOS
	 */
    private String vFlgvupe;

    /**
	 * Short vFlgvupeemp 
	 * FLAG VUPE PARA EMPRESAS
	 */
    private String vFlgvupeemp;

    /**
	 * Short vFlgvupeemp 
	 * FLAG PARA EL SISTEMA DE TRABAJADORAS DEL HOGAR
	 */
    private String vFlgth;

    /**
  	 * Short vFlgvupeemp 
  	 * FLAG PARA EL SISTEMA DE TRABAJADORAS DEL HOGAR
  	 */
    private String vFlgsirov;
    
    
    
    
    
    
    
    
    

    public String getvCodtdocide() {
        return vCodtdocide;
    }

    public void setvCodtdocide(String vCodtdocide) {
        this.vCodtdocide = vCodtdocide;
    }

    public String getvDestdocide() {
        return vDestdocide;
    }

    public void setvDestdocide(String vDestdocide) {
        this.vDestdocide = vDestdocide;
    }

    public String getvDesabr() {
        return vDesabr;
    }

    public void setvDesabr(String vDesabr) {
        this.vDesabr = vDesabr;
    }

    public Short getnFlgsunmin() {
        return nFlgsunmin;
    }

    public void setnFlgsunmin(Short nFlgsunmin) {
        this.nFlgsunmin = nFlgsunmin;
    }

    public Short getnFlgestdoc() {
        return nFlgestdoc;
    }

    public void setnFlgestdoc(Short nFlgestdoc) {
        this.nFlgestdoc = nFlgestdoc;
    }

    public Short getnFlgvidley() {
        return nFlgvidley;
    }

    public void setnFlgvidley(Short nFlgvidley) {
        this.nFlgvidley = nFlgvidley;
    }

    public Short getnFlgvac() {
        return nFlgvac;
    }

    public void setnFlgvac(Short nFlgvac) {
        this.nFlgvac = nFlgvac;
    }

    public String getvFlgvupe() {
        return vFlgvupe;
    }

    public void setvFlgvupe(String vFlgvupe) {
        this.vFlgvupe = vFlgvupe;
    }

    public String getvFlgvupeemp() {
        return vFlgvupeemp;
    }

    public void setvFlgvupeemp(String vFlgvupeemp) {
        this.vFlgvupeemp = vFlgvupeemp;
    }

    public String getvFlgth() {
        return vFlgth;
    }

    public void setvFlgth(String vFlgth) {
        this.vFlgth = vFlgth;
    }

    public String getvFlgsirov() {
        return vFlgsirov;
    }

    public void setvFlgsirov(String vFlgsirov) {
        this.vFlgsirov = vFlgsirov;
    }
}