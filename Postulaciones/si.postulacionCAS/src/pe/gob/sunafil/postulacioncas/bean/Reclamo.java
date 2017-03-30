package pe.gob.sunafil.postulacioncas.bean;

import java.io.Serializable;

public class Reclamo implements Serializable{

	private static final long serialVersionUID = 8054868581989784660L;
	
	private Integer n_codreclam;
	private Integer n_anho;
	private String n_numdep;
	private Integer n_coddir;
	private String v_numdoc;
	private String v_codtdocide;
	private String v_tipusu;
	private String v_telfijo;
	private String v_telcel;
	private String v_email;
	private String v_desreclam;
	private String v_razsocins;
	private String v_codusureg;
	private String d_fecreg;
	private String v_hostreg;
	private String v_codusumod;
	private String d_fecmod;
	private String v_hostmod;
	
	public Integer getN_codreclam() {
		return n_codreclam;
	}
	public void setN_codreclam(Integer n_codreclam) {
		this.n_codreclam = n_codreclam;
	}
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
	public Integer getN_coddir() {
		return n_coddir;
	}
	public void setN_coddir(Integer n_coddir) {
		this.n_coddir = n_coddir;
	}
	public String getV_numdoc() {
		return v_numdoc;
	}
	public void setV_numdoc(String v_numdoc) {
		this.v_numdoc = v_numdoc;
	}
	public String getV_codtdocide() {
		return v_codtdocide;
	}
	public void setV_codtdocide(String v_codtdocide) {
		this.v_codtdocide = v_codtdocide;
	}
	public String getV_tipusu() {
		return v_tipusu;
	}
	public void setV_tipusu(String v_tipusu) {
		this.v_tipusu = v_tipusu;
	}
	public String getV_telfijo() {
		return v_telfijo;
	}
	public void setV_telfijo(String v_telfijo) {
		this.v_telfijo = v_telfijo;
	}
	public String getV_telcel() {
		return v_telcel;
	}
	public void setV_telcel(String v_telcel) {
		this.v_telcel = v_telcel;
	}
	public String getV_email() {
		return v_email;
	}
	public void setV_email(String v_email) {
		this.v_email = v_email;
	}
	public String getV_desreclam() {
		return v_desreclam;
	}
	public void setV_desreclam(String v_desreclam) {
		this.v_desreclam = v_desreclam;
	}
	public String getV_razsocins() {
		return v_razsocins;
	}
	public void setV_razsocins(String v_razsocins) {
		this.v_razsocins = v_razsocins;
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
	@Override
	public String toString() {
		return "Reclamo [n_codreclam=" + n_codreclam + ", n_anho=" + n_anho
				+ ", n_numdep=" + n_numdep + ", n_coddir=" + n_coddir
				+ ", v_numdoc=" + v_numdoc + ", v_codtdocide=" + v_codtdocide
				+ ", v_tipusu=" + v_tipusu + ", v_telfijo=" + v_telfijo
				+ ", v_telcel=" + v_telcel + ", v_email=" + v_email
				+ ", v_desreclam=" + v_desreclam + ", v_razsocins="
				+ v_razsocins + ", v_codusureg=" + v_codusureg + ", d_fecreg="
				+ d_fecreg + ", v_hostreg=" + v_hostreg + ", v_codusumod="
				+ v_codusumod + ", d_fecmod=" + d_fecmod + ", v_hostmod="
				+ v_hostmod + "]";
	}
	
	
}
