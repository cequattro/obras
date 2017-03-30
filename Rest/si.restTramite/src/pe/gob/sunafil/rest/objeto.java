/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunafil.rest;

import java.util.ArrayList;
import java.util.List;

import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad;

/**
 *
 * @author wcastro
 */
public class objeto {
    
	private TdtbcEntidad entidad;
	private TdmvcRegistro registro;	    
	private String errorCode;
	private String fechaEmisionFormat;
	private String errorMessage;
    
    public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getFechaEmisionFormat() {
		return fechaEmisionFormat;
	}

	public void setFechaEmisionFormat(String fechaEmisionFormat) {
		this.fechaEmisionFormat = fechaEmisionFormat;
	}

	public TdtbcEntidad getEntidad() {
		return entidad;
	}

	public void setEntidad(TdtbcEntidad entidad) {
		this.entidad = entidad;
	}

	public TdmvcRegistro getRegistro() {
		return registro;
	}

	public void setRegistro(TdmvcRegistro registro) {
		this.registro = registro;
	}		

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
    public String toString() {
       return "DataObject [entidad=" + entidad.getvNomusureg() + ", registro=" + registro.getvNumhoja()+"-"+registro.getvAniohoja()+ ", errorCode"+ errorCode + "]";
    }
    
}
