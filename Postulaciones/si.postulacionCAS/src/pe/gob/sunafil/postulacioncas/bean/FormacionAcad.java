package pe.gob.sunafil.postulacioncas.bean;

import java.io.Serializable;

public class FormacionAcad implements Serializable {

	private static final long serialVersionUID = 3467359233339500555L;
	private String v_codfor;
	private String v_codgraaca;
	private String v_centroest;
	private String v_especialidad;
	private String d_fecini;
	private String d_fecfin;
	private String d_fecextdip;
	private String v_codpais;
	private String v_ciudad;
	private String v_codusureg;
	private String d_fecreg;
	private String v_hostreg;
	
	public String getV_codfor() {
		return v_codfor;
	}
	public void setV_codfor(String v_codfor) {
		this.v_codfor = v_codfor;
	}
	public String getV_codgraaca() {
		return v_codgraaca;
	}
	public void setV_codgraaca(String v_codgraaca) {
		this.v_codgraaca = v_codgraaca;
	}
	public String getV_centroest() {
		return v_centroest;
	}
	public void setV_centroest(String v_centroest) {
		this.v_centroest = v_centroest;
	}
	public String getV_especialidad() {
		return v_especialidad;
	}
	public void setV_especialidad(String v_especialidad) {
		this.v_especialidad = v_especialidad;
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
	public String getD_fecextdip() {
		return d_fecextdip;
	}
	public void setD_fecextdip(String d_fecextdip) {
		this.d_fecextdip = d_fecextdip;
	}
	public String getV_codpais() {
		return v_codpais;
	}
	public void setV_codpais(String v_codpais) {
		this.v_codpais = v_codpais;
	}
	public String getV_ciudad() {
		return v_ciudad;
	}
	public void setV_ciudad(String v_ciudad) {
		this.v_ciudad = v_ciudad;
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
		return "FormacionAcad [v_codfor=" + v_codfor + ", v_codgraaca="
				+ v_codgraaca + ", v_centroest=" + v_centroest
				+ ", v_especialidad=" + v_especialidad + ", d_fecini="
				+ d_fecini + ", d_fecfin=" + d_fecfin + ", d_fecextdip="
				+ d_fecextdip + ", v_codpais=" + v_codpais + ", v_ciudad="
				+ v_ciudad + ", v_codusureg=" + v_codusureg + ", d_fecreg="
				+ d_fecreg + ", v_hostreg=" + v_hostreg + "]";
	}
	
	
	
}
