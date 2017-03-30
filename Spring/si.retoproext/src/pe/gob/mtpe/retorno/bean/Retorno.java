package pe.gob.mtpe.retorno.bean;

import java.util.Date;

public class Retorno {
	
	/**
	 * String vCodretor 
	 * CODIGO DE RETORNO
	 */
    private String vCodretor;

    /**
	 * String vDesretor 
	 * DESCRIPCION DE RETORNO
	 */
    private String vDesretor;

    /**
	 * String vEstreg 
	 * ESTADO DEL REGISTRO 1:ACTIVO 0:INACTIVO
	 */
    private String vEstreg;
    
    /**
	 * Date dFecreg 
	 * FECHA DE REGISTRO
	 */
    private Date dFecreg;
    
    
    
    
    
    
    

    public String getvCodretor() {
        return vCodretor;
    }

    public void setvCodretor(String vCodretor) {
        this.vCodretor = vCodretor;
    }

    public String getvDesretor() {
        return vDesretor;
    }

    public void setvDesretor(String vDesretor) {
        this.vDesretor = vDesretor;
    }

    public String getvEstreg() {
        return vEstreg;
    }

    public void setvEstreg(String vEstreg) {
        this.vEstreg = vEstreg;
    }

    public Date getdFecreg() {
        return dFecreg;
    }

    public void setdFecreg(Date dFecreg) {
        this.dFecreg = dFecreg;
    }
}