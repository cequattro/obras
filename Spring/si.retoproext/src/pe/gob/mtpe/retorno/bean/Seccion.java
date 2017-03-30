package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class Seccion implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3577205635819022162L;

    /**
	 * String vCodsec 
	 * CÓDIGO DEL TIPO DE RUBRO DEL EMPLEADOR.
	 */
	private String vCodsec;

    /**
	 * String vDessec 
	 * NOMBRE DEL TIPO DE RUBRO DEL EMPLEADOR.
	 */
    private String vDessec;
    
    
    
    
    
    
    
    

    public String getvCodsec() {
        return vCodsec;
    }

    public void setvCodsec(String vCodsec) {
        this.vCodsec = vCodsec;
    }

    public String getvDessec() {
        return vDessec;
    }

    public void setvDessec(String vDessec) {
        this.vDessec = vDessec;
    }
}