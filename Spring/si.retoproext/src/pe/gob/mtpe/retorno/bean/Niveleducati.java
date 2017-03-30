package pe.gob.mtpe.retorno.bean;

public class Niveleducati {
	
	/**
	 * String vCodnivedu 
	 * CÓDIGO DEL TIPO DE NIVEL EDUCATIVO
	 */
    private String vCodnivedu;

	/**
	 * String vDesnivedu 
	 * NOMBRE O DESCRIPCIÓN DEL TIPO DE NIVEL EDUCATIVO.
	 */
    private String vDesnivedu;

	/**
	 * String nFlgsunmin 
	 * IDENTIFICA SI EL REGISTRO ES DE LA SUNAT O DE MTPE.
	 */
    private Short nFlgsunmin;

    /**
	 * String vFlgsovio 
	 * IDENTIFICA SI EL REGISTRO ES DE SOVIO.
	 */
    private String vFlgsovio;
    
    
    
    
    

    public String getvCodnivedu() {
        return vCodnivedu;
    }

    public void setvCodnivedu(String vCodnivedu) {
        this.vCodnivedu = vCodnivedu;
    }

    public String getvDesnivedu() {
        return vDesnivedu;
    }

    public void setvDesnivedu(String vDesnivedu) {
        this.vDesnivedu = vDesnivedu;
    }

    public Short getnFlgsunmin() {
        return nFlgsunmin;
    }

    public void setnFlgsunmin(Short nFlgsunmin) {
        this.nFlgsunmin = nFlgsunmin;
    }

    public String getvFlgsovio() {
        return vFlgsovio;
    }

    public void setvFlgsovio(String vFlgsovio) {
        this.vFlgsovio = vFlgsovio;
    }
}