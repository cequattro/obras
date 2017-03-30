package pe.gob.mtpe.retorno.bean;

public class Nacionalidad {
	/**
	 * String vCodnacion 
	 * CÓDIGO DE LA NACIONALIDAD.
	 */
    private String vCodnacion;

	/**
	 * String vDesnacion 
	 * NOMBRE DE LA NACIONALIDAD.
	 */
    private String vDesnacion;

	/**
	 * String nFlgsunmin 
	 * IDENTIFICA SI EL REGISTRO ES DE LA SUNAT O DE MTPE.
	 */
    private Short nFlgsunmin;

    public String getvCodnacion() {
        return vCodnacion;
    }

    public void setvCodnacion(String vCodnacion) {
        this.vCodnacion = vCodnacion;
    }

    public String getvDesnacion() {
        return vDesnacion;
    }

    public void setvDesnacion(String vDesnacion) {
        this.vDesnacion = vDesnacion;
    }

    public Short getnFlgsunmin() {
        return nFlgsunmin;
    }

    public void setnFlgsunmin(Short nFlgsunmin) {
        this.nFlgsunmin = nFlgsunmin;
    }
}