package pe.gob.mtpe.retorno.bean;

import java.util.Date;

public class Persona  {
	
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
   	 * Date vApepater 
   	 * FECHA DE NACIMIENTO
   	 */
    private Date dFecnac;

    /**
   	 * String cCodsexo 
   	 * SEXO (1=MASCULINO | 2=FEMENINO)
   	 */
    private String cCodsexo;

    /**
   	 * String cEstcivil 
   	 * ESTADO CIVIL (1=SOLTERO | 2=CASADO | 3=VIUDO | 4=DIVORCIADO)
   	 */
    private String cEstcivil;

    /**
   	 * Date dFecfac 
   	 * FECHA DE FALLECIMIENTO (PARA NO VALIDADOS POR RENIEC)
   	 */
    private Date dFecfac;

    /**
   	 * Date dFecact 
   	 * FECHA Y HORA DE ACTUALIZACIÓN DEL REGISTRO (PARA VALIDADOS POR RENIEC)
   	 */
    private Date dFecact;

    /**
   	 * String vCodpais 
   	 * CÓDIGO DEL PAÍS EMISOR DEL TIPO DE DOCUMENTO DEL DERECHOHABIENTE O PRESTADOR (TABLA 28 ANEXO 2)
   	 */
    private String vCodpais;

    /**
   	 * String cEstact 
   	 * INDICADOR SI EL REGISRO SE ENCUENTRA ACTIVO
   	 */
    private String cEstact;

    /**
   	 * Date dFecreg 
   	 * FECHA EN LA QUE SE CREÓ EL REGISTRO
   	 */
    private Date dFecreg;

    /**
   	 * Date dFecmod 
   	 * FECHA EN LA QUE SE REALIZÓ LA ÚLTIMA MODIFICACIÓN AL REGISTRO
   	 */
    private Date dFecmod;

    /**
   	 * Date dFecmod 
   	 * FECHA EN LA QUE SE REALIZÓ LA AKÑADOC{PLK
   	 */
    private Date dFecanul;

    /**
   	 * String vCodnacion 
   	 * CODIGO DE NACIONALIDAD
   	 */
    private String vCodnacion;

    /**
   	 * String vTelfper1 
   	 * NUMERO TELEFONICO 1 DE LA PERSONA.
   	 */
    private String vTelfper1;

    /**
   	 * String vTelfper2 
   	 * NUMERO TELEFONICO  2 DE LA PERSONA.
   	 */
    private String vTelfper2;

    /**
   	 * String vEmail 
   	 * CORREO ELECTRONICO DE LA PERSONA.
   	 */
    private String vEmail;

    /**
   	 * String vCodsisreg 
   	 * CODIGO DEL SISTEMA DE DONDE PROVIENE EL REGISTRO.
   	 */
    private String vCodsisreg;

    /**
   	 * String vCodsisreg 
   	 * INDICA SI EL REGISTRO PROVIENE DE LA CARGA 
   	 * MASIVA DE PLANILLAS ELECTRÓNICAS = 1  Ó SI VIENE DE ALGUN SISTEMA = 2.
   	 */
    private String vFlgplan;

    /**
   	 * String vHostreg 
   	 * HOST DESDE DONDE INSERTA EL REGISTRO
   	 */
    private String vHostreg;

    /**
   	 * String vHostreg 
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

    /**
   	 * String vCodpaisnac 
   	 * CODIGO DEL PAIS DE NACIMIENTO DE LA PERSONA
   	 */
    private String vCodpaisnac;

    /**
   	 * String vCoddepnac 
   	 * CODIGO DEL DEPARTAMENDO DE NACIMIENTO DE LA PERSONA
   	 */
    private String vCoddepnac;

    /**
   	 * String vCodpronac 
   	 * CODIGO DE LA PROVINCIA DE NACIMIENTO DE LA PERSONA
   	 */
    private String vCodpronac;

    /**
   	 * String vCoddisnac 
   	 * CODIGO DEL DISTRITO DE NACIMIENTO DE LA PERSONA
   	 */
    private String vCoddisnac;

    /**
   	 * String vCodsismod 
   	 * CODIGO DEL SISTEMA DE DONDE SE MODIFICA EL REGISTRO.
   	 */
    private String vCodsismod;

    /**
   	 * String vFlatradis 
   	 * INDICA SI EL TRABAJADOR ES DISCAPACITADO. 
   	 * (PERSONAS CON DISCAPACIDAD SEGUN LEY N° 27050).0 = NO DISCAPACITADO 1 = DISCAPACITADO
   	 */
    private String vFlatradis;

    /**
   	 * String vFlgtiploc 
   	 * INDICA SI LA DISCAPACIDAD DEL TRABAJADOR ES DE TIPO LOCOMOCION.0 = NO DISCAPACIDAD 
   	 * POR LOCOMOCION.1 = DISCAPACIDAD POR LOCOMOCION.
   	 */
    private String vFlgtiploc;
    
    /**
   	 * String vFlgtipcom 
   	 * INDICA SI LA DISCAPACIDAD DEL TRABAJADOR ES DE TIPO COMUNICACION.0 = NO DISCAPACIDAD 
   	 * POR COMUNICACION.1 = DISCAPACIDAD POR COMUNICACION.
   	 */
    private String vFlgtipcom;

    /**
   	 * String vFlgtipdes 
   	 * INDICA SI LA DISCAPACIDAD DEL TRABAJADOR ES DE TIPO DESTREZA.0 = NO DISCAPACIDAD 
   	 * POR DESTREZA.1 = DISCAPACIDAD POR DESTREZA.
   	 */
    private String vFlgtipdes;

    /**
   	 * String vFlgtipcon 
   	 * INDICA SI LA DISCAPACIDAD DEL TRABAJADOR ES DE TIPO CONDUCTA.0 = NO DISCAPACIDAD 
   	 * POR CONDUCTA.1 = DISCAPACIDAD POR CONDUCTA.
   	 */
    private String vFlgtipcon;

    /**
   	 * String vFlgtipsit 
   	 * INDICA SI LA DISCAPACIDAD DEL TRABAJADOR ES DE TIPO SITUACION.0 = NO DISCAPACIDAD 
   	 * POR SITUACION.1 = DISCAPACIDAD POR SITUACION.
   	 */
    private String vFlgtipsit;

    /**
   	 * String vFlgme 
   	 * INDICA SI EL TRABAJADOR (EN ESTE CASO MUJER), ESTA EMBARAZADA.S = SI N = NO.
   	 */
    private String vFlgme;

    /**
   	 * String vFlgna 
   	 * INDICA SI EL TRABAJADOR, ES UN NIÑO ADOLESCENTE.S = SI N = NO
   	 */
    private String vFlgna;

    /**
   	 * String vFlgam 
   	 * INDICA SI EL TRABAJADOR, ES UN ADULTO MAYOR.S = SI N = NO
   	 */
    private String vFlgam;

    /**
   	 * String vCodnivedu 
   	 * CODIGO DEL TIPO DE NIVEL EDUCATIVO
   	 */
    private String vCodnivedu;
    
    /**
   	 * String vFlgreniec 
   	 * INDICAR SI EL TRABAJADOR, VIENE DE LA RECIEN. S = SI N=NO
   	 */
    private String vFlgreniec;
    
    /**
   	 * String v_coderror 
   	 * CODIGO DEL ERROR 
   	 */
    private String v_coderror;

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

    public Date getdFecnac() {
        return dFecnac;
    }

    public void setdFecnac(Date dFecnac) {
        this.dFecnac = dFecnac;
    }

    public String getcCodsexo() {
        return cCodsexo;
    }

    public void setcCodsexo(String cCodsexo) {
        this.cCodsexo = cCodsexo;
    }

    public String getcEstcivil() {
        return cEstcivil;
    }

    public void setcEstcivil(String cEstcivil) {
        this.cEstcivil = cEstcivil;
    }

    public Date getdFecfac() {
        return dFecfac;
    }

    public void setdFecfac(Date dFecfac) {
        this.dFecfac = dFecfac;
    }

    public Date getdFecact() {
        return dFecact;
    }

    public void setdFecact(Date dFecact) {
        this.dFecact = dFecact;
    }

    public String getvCodpais() {
        return vCodpais;
    }

    public void setvCodpais(String vCodpais) {
        this.vCodpais = vCodpais;
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

    public String getvCodnacion() {
        return vCodnacion;
    }

    public void setvCodnacion(String vCodnacion) {
        this.vCodnacion = vCodnacion;
    }

    public String getvTelfper1() {
        return vTelfper1;
    }

    public void setvTelfper1(String vTelfper1) {
        this.vTelfper1 = vTelfper1;
    }

    public String getvTelfper2() {
        return vTelfper2;
    }

    public void setvTelfper2(String vTelfper2) {
        this.vTelfper2 = vTelfper2;
    }

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public String getvCodsisreg() {
        return vCodsisreg;
    }

    public void setvCodsisreg(String vCodsisreg) {
        this.vCodsisreg = vCodsisreg;
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

    public String getvCodpaisnac() {
        return vCodpaisnac;
    }

    public void setvCodpaisnac(String vCodpaisnac) {
        this.vCodpaisnac = vCodpaisnac;
    }

    public String getvCoddepnac() {
        return vCoddepnac;
    }

    public void setvCoddepnac(String vCoddepnac) {
        this.vCoddepnac = vCoddepnac;
    }

    public String getvCodpronac() {
        return vCodpronac;
    }

    public void setvCodpronac(String vCodpronac) {
        this.vCodpronac = vCodpronac;
    }

    public String getvCoddisnac() {
        return vCoddisnac;
    }

    public void setvCoddisnac(String vCoddisnac) {
        this.vCoddisnac = vCoddisnac;
    }

    public String getvCodsismod() {
        return vCodsismod;
    }

    public void setvCodsismod(String vCodsismod) {
        this.vCodsismod = vCodsismod;
    }

    public String getvFlatradis() {
        return vFlatradis;
    }

    public void setvFlatradis(String vFlatradis) {
        this.vFlatradis = vFlatradis;
    }

    public String getvFlgtiploc() {
        return vFlgtiploc;
    }

    public void setvFlgtiploc(String vFlgtiploc) {
        this.vFlgtiploc = vFlgtiploc;
    }

    public String getvFlgtipcom() {
        return vFlgtipcom;
    }

    public void setvFlgtipcom(String vFlgtipcom) {
        this.vFlgtipcom = vFlgtipcom;
    }

    public String getvFlgtipdes() {
        return vFlgtipdes;
    }

    public void setvFlgtipdes(String vFlgtipdes) {
        this.vFlgtipdes = vFlgtipdes;
    }

    public String getvFlgtipcon() {
        return vFlgtipcon;
    }

    public void setvFlgtipcon(String vFlgtipcon) {
        this.vFlgtipcon = vFlgtipcon;
    }

    public String getvFlgtipsit() {
        return vFlgtipsit;
    }

    public void setvFlgtipsit(String vFlgtipsit) {
        this.vFlgtipsit = vFlgtipsit;
    }

    public String getvFlgme() {
        return vFlgme;
    }

    public void setvFlgme(String vFlgme) {
        this.vFlgme = vFlgme;
    }

    public String getvFlgna() {
        return vFlgna;
    }

    public void setvFlgna(String vFlgna) {
        this.vFlgna = vFlgna;
    }

    public String getvFlgam() {
        return vFlgam;
    }

    public void setvFlgam(String vFlgam) {
        this.vFlgam = vFlgam;
    }

    public String getvCodnivedu() {
        return vCodnivedu;
    }

    public void setvCodnivedu(String vCodnivedu) {
        this.vCodnivedu = vCodnivedu;
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

	public String getvFlgreniec() {
		return vFlgreniec;
	}

	public void setvFlgreniec(String vFlgreniec) {
		this.vFlgreniec = vFlgreniec;
	}

	public String getV_coderror() {
		return v_coderror;
	}

	public void setV_coderror(String v_coderror) {
		this.v_coderror = v_coderror;
	}
    
    
    
}