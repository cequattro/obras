package pe.gob.mtpe.retorno.bean;

public class Pais {
	
	/**
	 * String vCodpais 
	 * CODIGO DEL PAIS
	 */
    private String vCodpais;

    /**
	 * String vCodcontin 
	 * CODIGO DEL CONTINENTE AL CUAL PERTENECE EL PAIS
	 */
    private String vCodcontin;

    /**
 	 * String vDespais 
 	 * DESCRIPCION DEL PAIS
 	 */
    private String vDespais;
    
    
    
    

    public String getvCodpais() {
        return vCodpais;
    }

    public void setvCodpais(String vCodpais) {
        this.vCodpais = vCodpais;
    }

    public String getvCodcontin() {
        return vCodcontin;
    }

    public void setvCodcontin(String vCodcontin) {
        this.vCodcontin = vCodcontin;
    }

    public String getvDespais() {
        return vDespais;
    }

    public void setvDespais(String vDespais) {
        this.vDespais = vDespais;
    }
}