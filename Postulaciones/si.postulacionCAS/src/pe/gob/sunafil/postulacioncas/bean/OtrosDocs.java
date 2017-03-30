package pe.gob.sunafil.postulacioncas.bean;

import java.io.Serializable;

public class OtrosDocs implements Serializable{

	private static final long serialVersionUID = 8273546310565429207L;
	private String v_descripcion;
	private String v_codusureg;
	private String d_fecreg;
	private String v_hostreg;
	public String getV_descripcion() {
		return v_descripcion;
	}
	public void setV_descripcion(String v_descripcion) {
		this.v_descripcion = v_descripcion;
	}
	public String getV_codusureg() {
		return v_codusureg;
	}
	public void setV_codusureg(String v_codusureg) {
		this.v_codusureg = v_codusureg;
	}
	public String getD_fecreg() {
		return d_fecreg;
	}
	public void setD_fecreg(String d_fecreg) {
		this.d_fecreg = d_fecreg;
	}
	public String getV_hostreg() {
		return v_hostreg;
	}
	public void setV_hostreg(String v_hostreg) {
		this.v_hostreg = v_hostreg;
	}
	

}
