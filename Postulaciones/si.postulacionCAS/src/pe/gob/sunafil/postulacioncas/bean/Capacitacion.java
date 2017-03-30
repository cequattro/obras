package pe.gob.sunafil.postulacioncas.bean;

import java.io.Serializable;

public class Capacitacion implements Serializable {

	private static final long serialVersionUID = 2318512088746178789L;
	private String v_cortipcap;
	private String v_centroest;
	private String v_tema;
	private String d_fecini;
	private String d_fecfin;
	private String v_horadurac;
	private String v_codusureg;
	private String d_fecreg;
	private String v_hostreg;
	
	public String getV_cortipcap() {
		return v_cortipcap;
	}
	public void setV_cortipcap(String v_cortipcap) {
		this.v_cortipcap = v_cortipcap;
	}
	public String getV_centroest() {
		return v_centroest;
	}
	public void setV_centroest(String v_centroest) {
		this.v_centroest = v_centroest;
	}
	public String getV_tema() {
		return v_tema;
	}
	public void setV_tema(String v_tema) {
		this.v_tema = v_tema;
	}
	public String getD_fecini() {
		return d_fecini;
	}
	public void setD_fecini(String d_fecini) {
		this.d_fecini = d_fecini;
	}
	public String getD_fecfin() {
		return d_fecfin;
	}
	public void setD_fecfin(String d_fecfin) {
		this.d_fecfin = d_fecfin;
	}
	public String getV_horadurac() {
		return v_horadurac;
	}
	public void setV_horadurac(String v_horadurac) {
		this.v_horadurac = v_horadurac;
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
	@Override
	public String toString() {
		return "Capacitacion [v_cortipcap=" + v_cortipcap + ", v_centroest="
				+ v_centroest + ", v_tema=" + v_tema + ", d_fecini=" + d_fecini
				+ ", d_fecfin=" + d_fecfin + ", v_horadurac=" + v_horadurac
				+ ", v_codusureg=" + v_codusureg + ", d_fecreg=" + d_fecreg
				+ ", v_hostreg=" + v_hostreg + "]";
	}
	
	
}
