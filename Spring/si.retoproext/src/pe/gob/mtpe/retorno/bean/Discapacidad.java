package pe.gob.mtpe.retorno.bean;

public class Discapacidad {
	
	/**
	 * String vCoddiscap 
	 * CODIGO DISCAPACIDAD
	 */
    private String vCoddiscap;

    /**
	 * String vDesdiscap 
	 * DESCRIPCION DISCAPACIDAD
	 */
    private String vDesdiscap;

    /**
	 * String vEstreg 
	 * ESTADO DEL REGISTRO 1:ACTIVO 0:INACTIVO
	 */
    private String vEstreg;

    /**
	 * String dFecreg 
	 * FECHA DE REGISTRO
	 */
    private String dFecreg;

    
    
    
    
    public String getvCoddiscap() {
        return vCoddiscap;
    }

    public void setvCoddiscap(String vCoddiscap) {
        this.vCoddiscap = vCoddiscap;
    }

    public String getvDesdiscap() {
        return vDesdiscap;
    }

    public void setvDesdiscap(String vDesdiscap) {
        this.vDesdiscap = vDesdiscap;
    }

    public String getvEstreg() {
        return vEstreg;
    }

    public void setvEstreg(String vEstreg) {
        this.vEstreg = vEstreg;
    }

    public String getdFecreg() {
        return dFecreg;
    }

    public void setdFecreg(String dFecreg) {
        this.dFecreg = dFecreg;
    }
}