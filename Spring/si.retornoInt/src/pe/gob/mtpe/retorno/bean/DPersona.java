package pe.gob.mtpe.retorno.bean;

import java.util.Date;
import java.util.List;

public class DPersona  {
	
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
	 * String vEdad 
	 * EDAD DEL POTENCIAL RETORNANTE
	 */
    private String vEdad;

    /**
	 * String vCodpaisres 
	 * CODIGO DEL PAIS
	 */
    private String vCodpaisres;

    /**
	 * String nNumhijos 
	 * NÚMERO DE HIJOS DEL POTENCIAL RETORNANTE
	 */
    private Integer nNumhijos;

    /**
	 * String vFlgdiscap 
	 * INDICADOR SI EL POTENCIAL RETORNANTE ES DISCAPACITADO.
	 */
    private String vFlgdiscap;

    /**
	 * String vCoddiscap 
	 * CÓDIGO DE DISCAPACIDAD.
	 */
    private String vCoddiscap;

    /**
	 * String vFlgjefhog 
	 * INDICADOR SI EL POTENCIA RETORNANTE ES JEFE DE HOJAR.
	 */
    private String vFlgjefhog;

    /**
	 * String vCodniveduper 
	 * CÓDIGO DEL TIPO DE NIVEL EDUCATIVO EN PERÚ.
	 */
    private String vCodniveduper;

    /**
	 * String vCodniveduext 
	 * CÓDIGO DEL TIPO DE NIVEL EDUCATIVO EN EL EXTRANJERO.
	 */
    private String vCodniveduext;

    /**
	 * String vCodprof 
	 * CÓDIGO DE PROFESIÓN DEL POTENCIAL RETORNANTE.
	 */
    private String vCodprof;

    /**
	 * String vEstreg 
	 * ESTADO DEL REGISTRO 1:ACTIVO 0:INACTIVO
	 */
    private String vEstreg;

    /**
	 * String dFecreg 
	 * FECHA DE REGISTRO
	 */
    private Date dFecreg;

    /**
	 * String vCodocuper 
	 * OCUPACIÓN LABORAL EN EL PERÚ
	 */
    private String vCodocuper;

    /**
	 * String vCodocuext 
	 * OCUPACIÓN LABORAL EN EL EXTRANJERO
	 */
    private String vCodocuext;

    /**
	 * String dFeciniper 
	 * FECHA INICIO OCUPACIÓN LABORAL EN EL PERÚ
	 */
    private String dFeciniper;

    /**
	 * String dFecfinper 
	 * FECHA FIN OCUPACIÓN LABORAL EN EL PERÚ
	 */
    private String dFecfinper;

    /**
	 * String dFeciniext 
	 * FECHA INICIO OCUPACIÓN LABORAL EN EL EXTRANJERO
	 */
    private String dFeciniext;

    /**
 	 * String dFeciniext 
 	 * FECHA FIN OCUPACIÓN LABORAL EN EL EXTRANJERO
 	 */
    private String dFecfinext;

    /**
 	 * String vCoddepret1 
 	 * CÓDIGO DEPARTAMENTO RETORNO (01)
 	 */
    private String vCoddepret1;

    /**
 	 * String vCoddepret2 
 	 * CÓDIGO DEPARTAMENTO RETORNO (02)
 	 */
    private String vCoddepret2;

    /**
 	 * String dFecsalper 
 	 * FECHA DE SALIDA DEL PERÚ
 	 */
    private String dFecsalper;

    /**
 	 * String dFecretper 
 	 * FECHA DE RETORNO AL PERÚ
 	 */
    private String dFecretper;

    /**
  	 * String vFlgretfam 
  	 * RETORNO CON FMAILIA S= SI - N= NO
  	 */
    private String vFlgretfam;

    /**
  	 * String vCodsexcon 
  	 * SEXO (1=MASCULINO | 2=FEMENINO), SEXO DEL CONVIVIENTE
  	 */
    private String vCodsexcon;

    /**
  	 * String vEdadcon 
  	 * EDAD CONVIVIENTE
  	 */
    private String vEdadcon;

    /**
  	 * String vCanfamret 
  	 * CANTIDAD DE FAMILIARES QUE RETORNAN AL PERU
  	 */
    private String vCanfamret;

    /**
  	 * String vCodretor 
  	 * CÓDIGO DEL POTENCIAL RETORNANTE
  	 */
    private String vCodretor;

    /**
  	 * String vCodocudes1 
  	 * OCUPACION 1 DESEMPEÑARSE
  	 */
    private String vCodocudes1;

    /**
  	 * String vCodocudes2 
  	 * OCUPACION 2 DESEMPEÑARSE
  	 */
    private String vCodocudes2;

    /**
   	 * String vCodrandes 
   	 * RANGO DE DESEMPLEO
   	 */
    private String vCodrandes;
    
    /**
   	 * String vCodrango 
   	 * CÓDIGO DEL RANGO DE DESEMPLEO
   	 */
    private String vCodrango;
    
    /**
   	 * String nCanfamret 
   	 * CANTIDAD DE FAMILIARES QUE RETORNAN AL PERU
   	 */
    private Integer nCanfamret;
    
    /**
   	 * String vDesdirret 
   	 * DIRECCION EN EL EXTRANGERO
   	 */
    private String  vDesdirret;
    
   
    
   
    
    /**
     * Familia 
     * @return
     */
    private Familia conyugue;
    private List<Familia> lstHijos;
    private Integer nNumhijosRet;
    
    

    public Integer getnCanfamret() {
		return nCanfamret;
	}

	public void setnCanfamret(Integer nCanfamret) {
		this.nCanfamret = nCanfamret;
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

	public String getvEdad() {
        return vEdad;
    }

    public void setvEdad(String vEdad) {
        this.vEdad = vEdad;
    }

    public String getvCodpaisres() {
        return vCodpaisres;
    }

    public void setvCodpaisres(String vCodpaisres) {
        this.vCodpaisres = vCodpaisres;
    }

     

    public Integer getnNumhijos() {
		return nNumhijos;
	}

	public void setnNumhijos(Integer nNumhijos) {
		this.nNumhijos = nNumhijos;
	}

	public String getvFlgdiscap() {
        return vFlgdiscap;
    }

    public void setvFlgdiscap(String vFlgdiscap) {
        this.vFlgdiscap = vFlgdiscap;
    }

    public String getvCoddiscap() {
        return vCoddiscap;
    }

    public void setvCoddiscap(String vCoddiscap) {
        this.vCoddiscap = vCoddiscap;
    }

    public String getvFlgjefhog() {
        return vFlgjefhog;
    }

    public void setvFlgjefhog(String vFlgjefhog) {
        this.vFlgjefhog = vFlgjefhog;
    }

    public String getvCodniveduper() {
        return vCodniveduper;
    }

    public void setvCodniveduper(String vCodniveduper) {
        this.vCodniveduper = vCodniveduper;
    }

    public String getvCodniveduext() {
        return vCodniveduext;
    }

    public void setvCodniveduext(String vCodniveduext) {
        this.vCodniveduext = vCodniveduext;
    }

    public String getvCodprof() {
        return vCodprof;
    }

    public void setvCodprof(String vCodprof) {
        this.vCodprof = vCodprof;
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

    public String getvCodocuper() {
        return vCodocuper;
    }

    public void setvCodocuper(String vCodocuper) {
        this.vCodocuper = vCodocuper;
    }

    public String getvCodocuext() {
        return vCodocuext;
    }

    public void setvCodocuext(String vCodocuext) {
        this.vCodocuext = vCodocuext;
    }

    

    public String getvCoddepret1() {
        return vCoddepret1;
    }

    public void setvCoddepret1(String vCoddepret1) {
        this.vCoddepret1 = vCoddepret1;
    }

    public String getvCoddepret2() {
        return vCoddepret2;
    }

    public void setvCoddepret2(String vCoddepret2) {
        this.vCoddepret2 = vCoddepret2;
    }

   
    public String getvFlgretfam() {
        return vFlgretfam;
    }

    public void setvFlgretfam(String vFlgretfam) {
        this.vFlgretfam = vFlgretfam;
    }

    public String getvCodsexcon() {
        return vCodsexcon;
    }

    public void setvCodsexcon(String vCodsexcon) {
        this.vCodsexcon = vCodsexcon;
    }

    public String getvEdadcon() {
        return vEdadcon;
    }

    public void setvEdadcon(String vEdadcon) {
        this.vEdadcon = vEdadcon;
    }

    public String getvCanfamret() {
        return vCanfamret;
    }

    public void setvCanfamret(String vCanfamret) {
        this.vCanfamret = vCanfamret;
    }

    public String getvCodretor() {
        return vCodretor;
    }

    public void setvCodretor(String vCodretor) {
        this.vCodretor = vCodretor;
    }

    public String getvCodocudes1() {
        return vCodocudes1;
    }

    public void setvCodocudes1(String vCodocudes1) {
        this.vCodocudes1 = vCodocudes1;
    }

    public String getvCodocudes2() {
        return vCodocudes2;
    }

    public void setvCodocudes2(String vCodocudes2) {
        this.vCodocudes2 = vCodocudes2;
    }

    public String getvCodrandes() {
        return vCodrandes;
    }

    public void setvCodrandes(String vCodrandes) {
        this.vCodrandes = vCodrandes;
    }

    public String getvCodrango() {
        return vCodrango;
    }

    public void setvCodrango(String vCodrango) {
        this.vCodrango = vCodrango;
    }

    
    
	public List<Familia> getLstHijos() {
		return lstHijos;
	}

	public void setLstHijos(List<Familia> lstHijos) {
		this.lstHijos = lstHijos;
	}

	public Familia getConyugue() {
		return conyugue;
	}

	public void setConyugue(Familia conyugue) {
		this.conyugue = conyugue;
	}

	
	
	
	
	
	
	public String getdFecsalper() {
		return dFecsalper;
	}

	public void setdFecsalper(String dFecsalper) {		
		this.dFecsalper = dFecsalper;
	}

	public String getdFecretper() {
		return dFecretper;
	}

	public void setdFecretper(String dFecretper) {		
		this.dFecretper = dFecretper;
	}

	public String getdFeciniper() {
		return dFeciniper;
	}

	public void setdFeciniper(String dFeciniper) {		
		this.dFeciniper = dFeciniper;
	}

	public String getdFecfinper() {
		return dFecfinper;
	}

	public void setdFecfinper(String dFecfinper) {		
		this.dFecfinper = dFecfinper;
	}

	public String getdFeciniext() {
		return dFeciniext;
	}

	public void setdFeciniext(String dFeciniext) {		
		this.dFeciniext = dFeciniext;
	}

	public String getdFecfinext() {
		return dFecfinext;
	}

	public void setdFecfinext(String dFecfinext) {		
		this.dFecfinext = dFecfinext;
	}
	
	

	public Integer getnNumhijosRet() {
		return nNumhijosRet;
	}

	public void setnNumhijosRet(Integer nNumhijosRet) {
		this.nNumhijosRet = nNumhijosRet;
	}
	
	



	public String getvDesdirret() {
		return vDesdirret;
	}

	public void setvDesdirret(String vDesdirret) {
		this.vDesdirret = vDesdirret;
	}

	@Override
	public String toString() {
		return "DPersona [vCodtdocide=" + vCodtdocide + ", vNumdoc=" + vNumdoc + ", vEdad=" + vEdad + ", vCodpaisres="
				+ vCodpaisres + ", nNumhijos=" + nNumhijos + ", vFlgdiscap=" + vFlgdiscap + ", vCoddiscap=" + vCoddiscap
				+ ", vFlgjefhog=" + vFlgjefhog + ", vCodniveduper=" + vCodniveduper + ", vCodniveduext=" + vCodniveduext
				+ ", vCodprof=" + vCodprof + ", vEstreg=" + vEstreg + ", dFecreg=" + dFecreg + ", vCodocuper="
				+ vCodocuper + ", vCodocuext=" + vCodocuext + ", dFeciniper=" + dFeciniper + ", dFecfinper="
				+ dFecfinper + ", dFeciniext=" + dFeciniext + ", dFecfinext=" + dFecfinext + ", vCoddepret1="
				+ vCoddepret1 + ", vCoddepret2=" + vCoddepret2 + ", dFecsalper=" + dFecsalper + ", dFecretper="
				+ dFecretper + ", vFlgretfam=" + vFlgretfam + ", vCodsexcon=" + vCodsexcon + ", vEdadcon=" + vEdadcon
				+ ", vCanfamret=" + vCanfamret + ", vCodretor=" + vCodretor + ", vCodocudes1=" + vCodocudes1
				+ ", vCodocudes2=" + vCodocudes2 + ", vCodrandes=" + vCodrandes + ", vCodrango=" + vCodrango
				+ ", nCanfamret=" + nCanfamret + ", conyugue=" + conyugue + ", lstHijos=" + lstHijos + "]";
	}

	
    
    
    
}