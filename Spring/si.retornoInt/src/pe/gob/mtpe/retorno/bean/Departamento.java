package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class Departamento implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	public Departamento(){
		
	}

   /**
	* String vCoddep 
	* CÓDIGO DEL DEPARTAMENTO.
	*/
	private String vCoddep;

    /**
	 * String vDesdep 
	 * NOMBRE O DESCRIPCIÓN DEL DEPARTAMENTO.
	 */
    private String vDesdep;

    /**
	 * String vFlgact 
	 * INDICA SI SE ENCUENTRA ACTIVO O NO  ACTIVO = 1      NO ACTIVO =0
	 */
    private String vFlgact;

    
    
    
    
    
    
    public String getvCoddep() {
        return vCoddep;
    }

    public void setvCoddep(String vCoddep) {
        this.vCoddep = vCoddep;
    }

    public String getvDesdep() {
        return vDesdep;
    }

    public void setvDesdep(String vDesdep) {
        this.vDesdep = vDesdep;
    }

    public String getvFlgact() {
        return vFlgact;
    }

    public void setvFlgact(String vFlgact) {
        this.vFlgact = vFlgact;
    }	
    
}