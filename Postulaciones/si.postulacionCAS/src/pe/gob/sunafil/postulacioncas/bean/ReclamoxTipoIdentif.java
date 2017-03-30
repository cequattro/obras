package pe.gob.sunafil.postulacioncas.bean;

import java.io.Serializable;

public class ReclamoxTipoIdentif implements Serializable {

	private static final long serialVersionUID = -4752828032586722676L;
	
	private Integer n_anho;
	private String n_numdep;
	private String n_codtipide;
	private Integer n_codreclam;
	private String v_desotrtir;
	private String v_codusureg;
	private String d_fecreg;
	private String v_hostreg;
	private String v_codusumod;
	private String d_fecmod;
	private String v_hostmod;
	
	
	public Integer getN_anho() {
		return n_anho;
	}
	public void setN_anho(Integer n_anho) {
		this.n_anho = n_anho;
	}
	public String getN_numdep() {
		return n_numdep;
	}
	public void setN_numdep(String n_numdep) {
		this.n_numdep = n_numdep;
	}
	public String getN_codtipide() {
		return n_codtipide;
	}
	public void setN_codtipide(String n_codtipide) {
		this.n_codtipide = n_codtipide;
	}
	public Integer getN_codreclam() {
		return n_codreclam;
	}
	public void setN_codreclam(Integer n_codreclam) {
		this.n_codreclam = n_codreclam;
	}
	public String getV_desotrtir() {
		return v_desotrtir;
	}
	public void setV_desotrtir(String v_desotrtir) {
		this.v_desotrtir = v_desotrtir;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ReclamoxTipoIdentif [n_anho=" + n_anho + ", n_numdep="
				+ n_numdep + ", n_codtipide=" + n_codtipide + ", n_codreclam="
				+ n_codreclam + ", v_desotrtir=" + v_desotrtir
				+ ", v_codusureg=" + v_codusureg + ", d_fecreg=" + d_fecreg
				+ ", v_hostreg=" + v_hostreg + ", v_codusumod=" + v_codusumod
				+ ", d_fecmod=" + d_fecmod + ", v_hostmod=" + v_hostmod + "]";
	}
	
	
}
