package pe.gob.mtpe.retorno.bean;

import java.util.Date;

public class Familia {
	
	/**
	 * Llave
	 */
	/**
   	 * Integer nCodfam 
   	 * CODIGO DE FAMILIA
   	 */
	 private Integer nCodfam;

	 
	 /**
	   * String vCodtdocide 
	   * CODIGO DE TIPO DOCUMENTO DE IDENTIDAD
	   */
	 private String vCodtdocide;

	 
	 /**
	  * String vNumdoc 
	  * NÚMERO DE DOCUMENTO DE IDENTIDAD (PARA VALIDADOS POR RENIEC). 
	  * PARA EL CASO DE IDENTIFICACIÓN ALTERNATIVA ES UN CÓDIGO AUTOGENERADO ALEATORIAMENTE
	  */
	 private String vNumdoc;
	/**
	 *  
	 */
	
	 /**
	  * String vCodsex 
	  * SEXO (1=MASCULINO | 2=FEMENINO)
	  */
    private String vCodsex;
	
    /**
   	 * String vEdad 
   	 * EDAD DEL POTENCIAL RETORNANTE
   	 */
    private String vEdad;

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
  
    

	public Integer getnCodfam() {
		return nCodfam;
	}

	public void setnCodfam(Integer nCodfam) {
		this.nCodfam = nCodfam;
	}

	public String getvCodtdocide() {
		return vCodtdocide;
	}

	public void setvCodtdocide(String vCodtdocide) {
		this.vCodtdocide = vCodtdocide;
	}

	public String getvNumdoc() {
		return vNumdoc;
	}

	public void setvNumdoc(String vNumdoc) {
		this.vNumdoc = vNumdoc;
	}

	public String getvCodsex() {
        return vCodsex;
    }

    public void setvCodsex(String vCodsex) {
        this.vCodsex = vCodsex;
    }

    public String getvEdad() {
        return vEdad;
    }

    public void setvEdad(String vEdad) {
        this.vEdad = vEdad;
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