package pe.gob.sunafil.denunciavirtual.bean;

import java.io.Serializable;

public class Auditoria implements Serializable{
	
	private static final long serialVersionUID = 6302297540321407061L;
	
	private String v_codusureg;
	private String d_fecreg;
	private String v_hostreg;
	private String v_codusumod;
	private String d_fecmod;
	private String v_hostmod;
	
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
	public String getV_codusumod() {
		return v_codusumod;
	}
	public void setV_codusumod(String v_codusumod) {
		this.v_codusumod = v_codusumod;
	}
	public String getD_fecmod() {
		return d_fecmod;
	}
	public void setD_fecmod(String d_fecmod) {
		this.d_fecmod = d_fecmod;
	}
	public String getV_hostmod() {
		return v_hostmod;
	}
	public void setV_hostmod(String v_hostmod) {
		this.v_hostmod = v_hostmod;
	}
	
}
