package pe.gob.mtpe.retorno.bean;

public class Pregfrec {
	
	/**
	 * String nCodprefre 
	 * CODIGO DE PREGUNTA FRECUENTE
	 */
    private String nCodprefre;

    /**
	 * String vDesprefre 
	 * DESCRIPCION DE PREGUNTA FRECUENTE
	 */
    private String vDesprefre;

    /**
   	 * String vEstreg 
   	 * ESTADO DEL REGISTRO 1:ACTIVO 0:INACTIVO
   	 */
    private String vEstreg;

    /**
   	 * String vCodusu 
   	 * CODIGO DE USUARIO QUE REGISTRA
   	 */
    private String vCodusu;

    /**
   	 * String vDesresp 
   	 * RESPUESTA A LA PREGUNTA FRECUENTE
   	 */
    private String vDesresp;
    
    
    

    public String getvDesresp() {
		return vDesresp;
	}

	public void setvDesresp(String vDesresp) {
		this.vDesresp = vDesresp;
	}

	public String getnCodprefre() {
		return nCodprefre;
	}

	public void setnCodprefre(String nCodprefre) {
		this.nCodprefre = nCodprefre;
	}

	public String getvDesprefre() {
        return vDesprefre;
    }

    public void setvDesprefre(String vDesprefre) {
        this.vDesprefre = vDesprefre;
    }

    public String getvEstreg() {
        return vEstreg;
    }

    public void setvEstreg(String vEstreg) {
        this.vEstreg = vEstreg;
    }

    public String getvCodusu() {
        return vCodusu;
    }

    public void setvCodusu(String vCodusu) {
        this.vCodusu = vCodusu;
    }
}