package pe.gob.sunafil.gentrama.bean;

import java.io.Serializable;
import java.util.Date;

public class Expedientes2014AB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String v_numexpsanc;
	private Date d_fecaper;
	private String n_numdepdes;
	private String v_numactinsp;
	private String v_anhoacta;
	private String n_numdep;
	private Date d_fecnoti;
	private String v_codusureg;
	private String v_hostreg;
	public String getV_numexpsanc() {
		return v_numexpsanc;
	}
	public void setV_numexpsanc(String v_numexpsanc) {
		this.v_numexpsanc = v_numexpsanc;
	}
	public Date getD_fecaper() {
		return d_fecaper;
	}
	public void setD_fecaper(Date d_fecaper) {
		this.d_fecaper = d_fecaper;
	}
	public String getN_numdepdes() {
		return n_numdepdes;
	}
	public void setN_numdepdes(String n_numdepdes) {
		this.n_numdepdes = n_numdepdes;
	}
	public String getV_numactinsp() {
		return v_numactinsp;
	}
	public void setV_numactinsp(String v_numactinsp) {
		this.v_numactinsp = v_numactinsp;
	}
	public String getV_anhoacta() {
		return v_anhoacta;
	}
	public void setV_anhoacta(String v_anhoacta) {
		this.v_anhoacta = v_anhoacta;
	}
	public String getN_numdep() {
		return n_numdep;
	}
	public void setN_numdep(String n_numdep) {
		this.n_numdep = n_numdep;
	}
	public Date getD_fecnoti() {
		return d_fecnoti;
	}
	public void setD_fecnoti(Date d_fecnoti) {
		this.d_fecnoti = d_fecnoti;
	}
	public String getV_codusureg() {
		return v_codusureg;
	}
	public void setV_codusureg(String v_codusureg) {
		this.v_codusureg = v_codusureg;
	}
	public String getV_hostreg() {
		return v_hostreg;
	}
	public void setV_hostreg(String v_hostreg) {
		this.v_hostreg = v_hostreg;
	}
	@Override
	public String toString() {
		return "Expedientes2014AB [v_numexpsanc=" + v_numexpsanc
				+ ", d_fecaper=" + d_fecaper + ", n_numdepdes=" + n_numdepdes
				+ ", v_numactinsp=" + v_numactinsp + ", v_anhoacta="
				+ v_anhoacta + ", n_numdep=" + n_numdep + ", d_fecnoti="
				+ d_fecnoti + ", v_codusureg=" + v_codusureg + ", v_hostreg="
				+ v_hostreg + "]";
	}
	
}
