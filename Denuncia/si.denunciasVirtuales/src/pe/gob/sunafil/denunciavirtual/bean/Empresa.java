package pe.gob.sunafil.denunciavirtual.bean;

import java.io.Serializable;

public class Empresa extends Auditoria implements Serializable {

	private static final long serialVersionUID = -4893397800485370652L;
	
	private String v_codemp;
	private String v_razsoc;
	private String v_flgcompsunafil;
	
	public String getV_codemp() {
		return v_codemp;
	}
	public void setV_codemp(String v_codemp) {
		this.v_codemp = v_codemp;
	}
	public String getV_razsoc() {
		return v_razsoc;
	}
	public void setV_razsoc(String v_razsoc) {
		this.v_razsoc = v_razsoc;
	}
	public String getV_flgcompsunafil() {
		return v_flgcompsunafil;
	}
	public void setV_flgcompsunafil(String v_flgcompsunafil) {
		this.v_flgcompsunafil = v_flgcompsunafil;
	}
	@Override
	public String toString() {
		return "Empresa [v_codemp=" + v_codemp + ", v_razsoc=" + v_razsoc
				+ ", v_flgcompsunafil=" + v_flgcompsunafil + "]";
	}
}
