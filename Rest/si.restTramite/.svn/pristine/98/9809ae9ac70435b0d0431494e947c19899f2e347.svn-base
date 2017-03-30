package pe.gob.sunafil.tramiteext.bean;

import java.io.Serializable;

import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcDependencia;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcTramite;

public class AsociacionPorPersona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8237345502371657460L;
	
	private TdmvcRegistro registro;
	private TdtbcTramite tramite;
	private TdtbcDependencia dependenciaDestino;
	private TdtbcEntidad entidad;		

	public AsociacionPorPersona(){}
	
	public AsociacionPorPersona(TdmvcRegistro registro, TdtbcTramite tramite, TdtbcDependencia dependenciaDestino, TdtbcEntidad entidad)
	{
		this.registro=registro;
		this.tramite=tramite;
		this.dependenciaDestino=dependenciaDestino;
		this.entidad=entidad;
	}
	
	public TdmvcRegistro getRegistro() {
		return registro;
	}
	
	public void setRegistro(TdmvcRegistro registro) {
		this.registro = registro;
	}
	
	public TdtbcTramite getTramite() {
		return tramite;
	}
	
	public void setTramite(TdtbcTramite tramite) {
		this.tramite = tramite;
	}
	
	public TdtbcDependencia getDependenciaDestino() {
		return dependenciaDestino;
	}
	
	public void setDependenciaDestino(TdtbcDependencia dependenciaDestino) {
		this.dependenciaDestino = dependenciaDestino;
	}	
	
	public TdtbcEntidad getEntidad() {
		return entidad;
	}

	public void setEntidad(TdtbcEntidad entidad) {
		this.entidad = entidad;
	}

}
