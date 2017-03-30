package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

public class ParamReporte implements Serializable { 
	
	
	/**
	 * String tipoReporte 
	 * TIPO DE REPORTE A ESCOGER.
	 */
	private String tipoReporte;
	
	/**
	 * String fechaInicio 
	 * FECHA DE INICIO DEL TIPO DE REPORTE.
	 */
	private String fechaInicio;
	
	/**
	 * String fechaFin 
	 * FECHA DE FIN DEL TIPO DE REPORTE.
	 */
	private String fechaFin;
	
	
	
	
	
	public String getTipoReporte() {
		return tipoReporte;
	}
	public void setTipoReporte(String tipoReporte) {
		this.tipoReporte = tipoReporte;
	}
	public String getFechaInicio() {
		
		
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		fechaInicio="01/"+fechaInicio;
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		fechaFin="01/"+fechaFin;
		this.fechaFin = fechaFin;
	}
	
	
	
	

}
