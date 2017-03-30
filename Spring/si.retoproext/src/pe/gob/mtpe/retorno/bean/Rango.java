package pe.gob.mtpe.retorno.bean;

import java.util.Date;

public class Rango {
	
	/**
	 * String vCodrango 
	 * CODIGO DE RANGO
	 */
    private String vCodrango;

    /**
	 * String vDesrango 
	 * DESCRIPCION DE RANGO
	 */
    private String vDesrango;

    /**
	 * String iEstreg 
	 * ESTADO DEL REGISTRO 1:ACTIVO 0:INACTIVO
	 */    
    private String iEstreg;

    /**
	 * String vTiprango 
	 * 1: RANGO DE SALARIO, 2=RANGO DE TIEMPO DESEMPLEO
	 */ 
    private String vTiprango;

    /**
	 * Date dFecreg 
	 * FECHA DE REGISTRO
	 */ 
    private Date dFecreg;

    
    
    
    
    
    
    
    
    public String getvCodrango() {
        return vCodrango;
    }

    public void setvCodrango(String vCodrango) {
        this.vCodrango = vCodrango;
    }

    public String getvDesrango() {
        return vDesrango;
    }

    public void setvDesrango(String vDesrango) {
        this.vDesrango = vDesrango;
    }

    public String getiEstreg() {
        return iEstreg;
    }

    public void setiEstreg(String iEstreg) {
        this.iEstreg = iEstreg;
    }

    public String getvTiprango() {
        return vTiprango;
    }

    public void setvTiprango(String vTiprango) {
        this.vTiprango = vTiprango;
    }

    public Date getdFecreg() {
        return dFecreg;
    }

    public void setdFecreg(Date dFecreg) {
        this.dFecreg = dFecreg;
    }
}