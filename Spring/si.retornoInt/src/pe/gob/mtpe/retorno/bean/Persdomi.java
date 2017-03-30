package pe.gob.mtpe.retorno.bean;

import java.util.Date;

public class Persdomi  {
	
	/**
	 * Llave
	 */
	
	/**
	 * String nNumcordom 
	 * CORRELATIVO DEL NÚMERO DE DOMICILIO
	 */
	 private Short nNumcordom;

	/**
	* String vCodnacion 
	* CÓDIGO DEL TIPO DE DOCUMENTO DEL DERECHOHABIENTE O PRESTADOR
	*/ 
	 private String vCodtdocide;
		
	 /**
	* String vNumdoc 
	* NÚMERO DE DOCUMENTO DEL DERECHOHABIENTE O PRESTADOR
	*/ 
	 private String vNumdoc;
	 
	/**
	* String vCodpais 
	* CÓDIGO DEL PAÍS EMISOR DEL TIPO DE DOCUMENTO DEL DERECHOHABIENTE
	*/
    private String vCodpais;

	/**
	* String vDesdom 
	* DESCRIPCIÓN DE TODO EL DOMICILIO. USADO PARA LA INFORMACIÓN DE DOMICILIO RENIEC
	*/
    private String vDesdom;
    
	/**
	* String vCoddep 
	* CÓDIGO DEL DEPARTAMENTO O REGIÓN
	*/
    private String vCoddep;

	/**
	* String vCodprov 
	* CÓDIGO DE PROVINCIA
	*/
    private String vCodprov;

	/**
	* String vCoddis 
	* CÓDIGO DE UBIGEO O DISTRITO
	*/
    private String vCoddis;
	
    /**
	* String vBlockdom 
	* BLOCK
	*/
    private String vBlockdom;
    
    /**
	* String vDptodom 
	* DEPARTAMENTO
	*/
    private String vDptodom;
   
    /**
 	* String vEtapadom 
 	* ETAPA
 	*/
    private String vEtapadom;

    /**
 	* String vIntdom 
 	* INTERIOR
 	*/
    private String vIntdom;
    
    /**
  	* String vKmdom 
  	* KILOMETRO
  	*/
    private String vKmdom;

    /**
  	* String vLotedom 
  	* LOTE
  	*/
    private String vLotedom;

    /**
  	* String cMzndom 
  	* MANZANA
  	*/
    private String cMzndom;

    /**
  	* String vNomvia 
  	* NOMBRE DE VIA
  	*/
    private String vNomvia;

    /**
  	* String vNumvia 
  	* NUMERO DE VÍA
  	*/
    private String vNumvia;
    
    /**
  	* String vCodtvia 
  	* CÓDIGO DEL TIPO DE VÍA
  	*/
    private String vCodtvia;

    /**
  	* String vZonadom 
  	* NOMBRE ZONA
  	*/
    private String vZonadom;

    /**
  	* String vCodzona 
  	* CÓDIGO DEL TIPO DE ZONA
  	*/
    private String vCodzona;

    /**
  	* String vDirref 
  	* DIRECCIÓN DE REFERENCIA
  	*/
    private String vDirref;

    /**
  	* String cEstact 
  	* INDICADOR SI EL REGISRO SE ENCUENTRA ACTIVO
  	*/
    private String cEstact;

    /**
  	* Date dFecreg 
  	* INDICA SI EL REGISTRO PROVIENE DE LA CARGA MASIVA DE PLANILLAS 
  	* ELECTRÓNICAS = 1  Ó SI VIENE DE ALGUN SISTEMA = 2
  	*/
    private Date dFecreg;

    /**
  	* Date dFecmod 
  	* FECHA EN LA QUE SE REALIZÓ LA ÚLTIMA MODIFICACIÓN AL REGISTRO
  	*/  
    private Date dFecmod;

    /**
  	* Date dFecanul 
  	* FECHA EN LA QUE SE REALIZÓ LA ANULACIÓN DEL REGISTRO
  	*/ 
    private Date dFecanul;

    /**
  	* String vNumpiso 
  	* NUMERO DE PISO, EN CASO VIVIERA EN UN EDIFICIO.
  	*/ 
    private String vNumpiso;

    /**
  	* String vCodsis 
  	* CODIGO DEL SISTEMA DE DONDE PROVIENE EL REGISTRO.
  	*/
    private String vCodsis;

    /**
  	* String vFlgplan 
  	* INDICA SI EL REGISTRO PROVIENE DE LA CARGA MASIVA DE 
  	* PLANILLAS ELECTRÓNICAS = 1  Ó SI VIENE DE ALGUN SISTEMA = 2
  	*/
    private String vFlgplan;

    /**
  	* String vHostreg 
  	* HOST DESDE DONDE INSERTA EL REGISTRO.
  	*/
    private String vHostreg;

    /**
  	* String vHostmod 
  	* HOST DESDE DONDE SE MODIFICA EL REGISTRO
  	*/
    private String vHostmod;
    
    /**
  	* String vNomusureg 
  	* USUARIO QUE CREA EL REGISTRO
  	*/
    private String vNomusureg;

    /**
  	* String vNomusumod 
  	* USUARIO QUE MODIFICA EL REGISTRO
  	*/
    private String vNomusumod;
    
    
    
    

    public Short getnNumcordom() {
		return nNumcordom;
	}

	public void setnNumcordom(Short nNumcordom) {
		this.nNumcordom = nNumcordom;
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

	public String getvCodpais() {
        return vCodpais;
    }

    public void setvCodpais(String vCodpais) {
        this.vCodpais = vCodpais;
    }

    public String getvDesdom() {
        return vDesdom;
    }

    public void setvDesdom(String vDesdom) {
        this.vDesdom = vDesdom;
    }

    public String getvCoddep() {
        return vCoddep;
    }

    public void setvCoddep(String vCoddep) {
        this.vCoddep = vCoddep;
    }

    public String getvCodprov() {
        return vCodprov;
    }

    public void setvCodprov(String vCodprov) {
        this.vCodprov = vCodprov;
    }

    public String getvCoddis() {
        return vCoddis;
    }

    public void setvCoddis(String vCoddis) {
        this.vCoddis = vCoddis;
    }

    public String getvBlockdom() {
        return vBlockdom;
    }

    public void setvBlockdom(String vBlockdom) {
        this.vBlockdom = vBlockdom;
    }

    public String getvDptodom() {
        return vDptodom;
    }

    public void setvDptodom(String vDptodom) {
        this.vDptodom = vDptodom;
    }

    public String getvEtapadom() {
        return vEtapadom;
    }

    public void setvEtapadom(String vEtapadom) {
        this.vEtapadom = vEtapadom;
    }

    public String getvIntdom() {
        return vIntdom;
    }

    public void setvIntdom(String vIntdom) {
        this.vIntdom = vIntdom;
    }

    public String getvKmdom() {
        return vKmdom;
    }

    public void setvKmdom(String vKmdom) {
        this.vKmdom = vKmdom;
    }

    public String getvLotedom() {
        return vLotedom;
    }

    public void setvLotedom(String vLotedom) {
        this.vLotedom = vLotedom;
    }

    public String getcMzndom() {
        return cMzndom;
    }

    public void setcMzndom(String cMzndom) {
        this.cMzndom = cMzndom;
    }

    public String getvNomvia() {
        return vNomvia;
    }

    public void setvNomvia(String vNomvia) {
        this.vNomvia = vNomvia;
    }

    public String getvNumvia() {
        return vNumvia;
    }

    public void setvNumvia(String vNumvia) {
        this.vNumvia = vNumvia;
    }

    public String getvCodtvia() {
        return vCodtvia;
    }

    public void setvCodtvia(String vCodtvia) {
        this.vCodtvia = vCodtvia;
    }

    public String getvZonadom() {
        return vZonadom;
    }

    public void setvZonadom(String vZonadom) {
        this.vZonadom = vZonadom;
    }

    public String getvCodzona() {
        return vCodzona;
    }

    public void setvCodzona(String vCodzona) {
        this.vCodzona = vCodzona;
    }

    public String getvDirref() {
        return vDirref;
    }

    public void setvDirref(String vDirref) {
        this.vDirref = vDirref;
    }

    public String getcEstact() {
        return cEstact;
    }

    public void setcEstact(String cEstact) {
        this.cEstact = cEstact;
    }

    public Date getdFecreg() {
        return dFecreg;
    }

    public void setdFecreg(Date dFecreg) {
        this.dFecreg = dFecreg;
    }

    public Date getdFecmod() {
        return dFecmod;
    }

    public void setdFecmod(Date dFecmod) {
        this.dFecmod = dFecmod;
    }

    public Date getdFecanul() {
        return dFecanul;
    }

    public void setdFecanul(Date dFecanul) {
        this.dFecanul = dFecanul;
    }

    public String getvNumpiso() {
        return vNumpiso;
    }

    public void setvNumpiso(String vNumpiso) {
        this.vNumpiso = vNumpiso;
    }

    public String getvCodsis() {
        return vCodsis;
    }

    public void setvCodsis(String vCodsis) {
        this.vCodsis = vCodsis;
    }

    public String getvFlgplan() {
        return vFlgplan;
    }

    public void setvFlgplan(String vFlgplan) {
        this.vFlgplan = vFlgplan;
    }

    public String getvHostreg() {
        return vHostreg;
    }

    public void setvHostreg(String vHostreg) {
        this.vHostreg = vHostreg;
    }

    public String getvHostmod() {
        return vHostmod;
    }

    public void setvHostmod(String vHostmod) {
        this.vHostmod = vHostmod;
    }

    public String getvNomusureg() {
        return vNomusureg;
    }

    public void setvNomusureg(String vNomusureg) {
        this.vNomusureg = vNomusureg;
    }

    public String getvNomusumod() {
        return vNomusumod;
    }

    public void setvNomusumod(String vNomusumod) {
        this.vNomusumod = vNomusumod;
    }
}