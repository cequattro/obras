package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class Provincia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/////LLAVE PRIMARIA
	/**
	 * String vCoddep 
	 * CÓDIGO DEL DEPARTAMENTO.
	 */
	private String vCoddep;

	/**
	 * String vCodpro 
	 * CÓDIGO DE LA PROVINCIA.
	 */
	private String vCodpro;
	////////////////////////////
	
	/**
	 * String vDespro 
	 * NOMBRE DE LA PROVINCIA.
	 */
    private String vDespro;

	/**
	 * String vFlgact 
	 * INDICA SI SE ENCUENTRA ACTIVO O NO  ACTIVO = 1      NO ACTIVO =0
	 */
    private String vFlgact;

    

    public String getvDespro() {
        return vDespro;
    }

    public void setvDespro(String vDespro) {
        this.vDespro = vDespro;
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

	public String getvCodpro() {
		return vCodpro;
	}

	public void setvCodpro(String vCodpro) {
		this.vCodpro = vCodpro;
	}
    
    
}