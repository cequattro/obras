package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class ParamBus implements Serializable{

	
	private static final long serialVersionUID = 380551962426052888L;
	
	
	/**
	 * String vDesocupac 
	 * DESCRIPCIÓN DE OCUPACIONES PERSONAL.
	 */
    private String vDesocupac;
    
    /**
	 * String vDesprof 
	 * DESCRIPCIÓN DE PROFESIÓN PERSONAL.
	 */
    private String vDesprof;
    
    /**
	 * String vCodocupac 
	 * CÓDIGO DE OCUPACIÓN PERSONAL.
	 */
    private String vCodocupac;
    
    /**
	 * String vCodprof 
	 * CÓDIGO DE PROFESIÓN PERSONAL.
	 */
    private String vCodprof;
    

	public String getvDesocupac() {
		return vDesocupac;
	}

	public void setvDesocupac(String vDesocupac) {
		this.vDesocupac = vDesocupac;
	}

	public String getvDesprof() {
		return vDesprof;
	}

	public void setvDesprof(String vDesprof) {
		this.vDesprof = vDesprof;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getvCodocupac() {
		return vCodocupac;
	}

	public void setvCodocupac(String vCodocupac) {
		this.vCodocupac = vCodocupac;
	}

	public String getvCodprof() {
		return vCodprof;
	}

	public void setvCodprof(String vCodprof) {
		this.vCodprof = vCodprof;
	}
    
	 
    


}
