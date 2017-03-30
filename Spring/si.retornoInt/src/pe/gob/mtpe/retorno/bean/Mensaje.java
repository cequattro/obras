package pe.gob.mtpe.retorno.bean;

import java.util.Date;

public class Mensaje {
	
	/**
	 * Long nCodmensaj 
	 * CODIGO DE MENSAJE AUTOGENERADO
	 */
    private String nCodmensaj;

    /**
   	 * String vTitmensaj 
   	 * TITULO DEL MENSAJE
   	 */
    private String vTitmensaj;

    /**
	 * Date dFecrpta 
	 * FECHA DE RESPUESTA
	 */
    private Date dFecrpta;

    /**
  	 * String vRespta 
  	 * RESPUESTA DE MENSAJE
  	 */
    private String vRespta;

    /**
	 * String vRespta 
	 * NÚMERO DE DOCUMENTO DE IDENTIDAD (PARA VALIDADOS POR RENIEC). 
	 * PARA EL CASO DE IDENTIFICACIÓN ALTERNATIVA ES UN CÓDIGO AUTOGENERADO ALEATORIAMENTE
	 */
    private String vNumdoc;

    /**
	 * String vCodtdocide 
	 * CODIGO DE TIPO DE DOCUMENTO DE IDENTIDAD
	 */
    private String vCodtdocide;

    /**
	 * String vEstreg 
	 * RESPONDIDO=R SIN RESPONDER=S
	 */
    private String vEstreg;

    /**
   	 * Date dFecmensaj 
   	 * FECHA DE RECEPCION DE MENSAJE
   	 */
    private Date dFecmensaj;

    /**
   	 * String vCodusu 
   	 * CODIGO O IDENTIFICADOR DE UN USUARIO. PADRON DE USUARIOS DEL MINTRA.
   	 */
    private String vCodusu;

    public String getnCodmensaj() {
        return nCodmensaj;
    }

    public void setnCodmensaj(String nCodmensaj) {
        this.nCodmensaj = nCodmensaj;
    }

    public String getvTitmensaj() {
        return vTitmensaj;
    }

    public void setvTitmensaj(String vTitmensaj) {
        this.vTitmensaj = vTitmensaj;
    }

    public Date getdFecrpta() {
        return dFecrpta;
    }

    public void setdFecrpta(Date dFecrpta) {
        this.dFecrpta = dFecrpta;
    }

    public String getvRespta() {
        return vRespta;
    }

    public void setvRespta(String vRespta) {
        this.vRespta = vRespta;
    }

    public String getvNumdoc() {
        return vNumdoc;
    }

    public void setvNumdoc(String vNumdoc) {
        this.vNumdoc = vNumdoc;
    }

    public String getvCodtdocide() {
        return vCodtdocide;
    }

    public void setvCodtdocide(String vCodtdocide) {
        this.vCodtdocide = vCodtdocide;
    }

    public String getvEstreg() {
        return vEstreg;
    }

    public void setvEstreg(String vEstreg) {
        this.vEstreg = vEstreg;
    }

    public Date getdFecmensaj() {
        return dFecmensaj;
    }

    public void setdFecmensaj(Date dFecmensaj) {
        this.dFecmensaj = dFecmensaj;
    }

    public String getvCodusu() {
        return vCodusu;
    }

    public void setvCodusu(String vCodusu) {
        this.vCodusu = vCodusu;
    }
}