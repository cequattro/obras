package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;
import java.util.Date;

public class ParamAdmRetorno implements Serializable{
	
	/**
	 * String vNumdoc 
	 * NÚMERO DE DOCUMENTO DE IDENTIDAD (PARA VALIDADOS POR RENIEC).
	 * PARA EL CASO DE IDENTIFICACIÓN ALTERNATIVA ES UN CÓDIGO AUTOGENERADO ALEATORIAMENTE
	 */
	private String vNumdoc;
	
	/**
	 * String vCodtdocide 
	 * CODIGO DE TIPO DOCUMENTO DE IDENTIDAD
	 */
	private String vCodtdocide;
	
    /**
	 * String vApepater 
	 * APELLIDO PATERNO
	 */
	private String vApepater;
	
    /**
	 * String vApemater 
	 * APELLIDO MATERNO
	 */
	private String vApemater;
	
    /**
	 * String vNombres 
	 * NOMBRES
	 */
	private String vNombres;
    
    /**
   	 * Date dFecreg 
   	 * FECHA EN LA QUE SE CREÓ EL REGISTRO
   	 */
	private Date dFecreg;
	
    /**
   	 * Date dFecreg 
   	 * CÓDIGO DE PAIS RESIDENTE
   	 */
    private String vCodpaisres;
	
	public ParamAdmRetorno(){
		
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

	public String getvApepater() {
		return vApepater;
	}

	public void setvApepater(String vApepater) {
		this.vApepater = vApepater;
	}

	public String getvApemater() {
		return vApemater;
	}

	public void setvApemater(String vApemater) {
		this.vApemater = vApemater;
	}

	public String getvNombres() {
		return vNombres;
	}

	public void setvNombres(String vNombres) {
		this.vNombres = vNombres;
	}

	public Date getdFecreg() {
		return dFecreg;
	}

	public void setdFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public String getvCodpaisres() {
		return vCodpaisres;
	}

	public void setvCodpaisres(String vCodpaisres) {
		this.vCodpaisres = vCodpaisres;
	}
	
	

}
