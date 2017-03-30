package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class Nivedu implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Integer nCornivedu 
	 * CODIGO DE NIVEL EDUCATIVO.
	 */
	private Integer nCornivedu;

	/**
	 * String vDesnivesu 
	 * DESCRIPCIÓN DE NIVEL EDUCATIVO.
	 */
    private String vDesnivesu;

	/**
	 * String vFlgact 
	 * INDICA SI SE ENCUENTRA ACTIVO O NO  ACTIVO = 1      NO ACTIVO =0
	 */
    private String vFlgact;

    /**
  	* String vHostreg 
  	* HOST DESDE DONDE INSERTA EL REGISTRO.
  	*/
    private String vHostreg;
    

    public Integer getnCornivedu() {
        return nCornivedu;
    }

    public void setnCornivedu(Integer nCornivedu) {
        this.nCornivedu = nCornivedu;
    }

    public String getvDesnivesu() {
        return vDesnivesu;
    }

    public void setvDesnivesu(String vDesnivesu) {
        this.vDesnivesu = vDesnivesu;
    }

    public String getvFlgact() {
        return vFlgact;
    }

    public void setvFlgact(String vFlgact) {
        this.vFlgact = vFlgact;
    }

    public String getvHostreg() {
        return vHostreg;
    }

    public void setvHostreg(String vHostreg) {
        this.vHostreg = vHostreg;
    }
}