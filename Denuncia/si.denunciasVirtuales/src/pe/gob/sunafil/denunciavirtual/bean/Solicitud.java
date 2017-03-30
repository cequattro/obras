package pe.gob.sunafil.denunciavirtual.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Solicitud extends Auditoria implements Serializable {

	private static final long serialVersionUID = 1430351128825026585L;
	
	private String n_codsol;
	private Persona persona;
	private Empresa empresa;
	private String v_coddepemp;
	private String v_codproemp;
	private String v_coddisemp;
	private String v_diremp;
	private String v_dirper;
	private String v_coddepper;
	private String v_codproper;
	private String v_coddisper;
	private String v_telfijo;
	private String v_telcel;
	private String v_email;
	private boolean v_flgrellab;
	private Date d_fecing;
	private Date d_fecces;
	private String v_cargo;
	private String v_codtmon;
	private String n_monto;
	private BigDecimal n_codmat;
	private String v_desotros;
	private String v_motivo;
	private String v_numhoja;
	private String v_anhohoja;
	private String n_flgest;
	private String v_numsol;
	private String v_anhosol;
	private String v_flgres;
	
	public String getN_codsol() {
		return n_codsol;
	}
	public void setN_codsol(String n_codsol) {
		this.n_codsol = n_codsol;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getV_coddepemp() {
		return v_coddepemp;
	}
	public void setV_coddepemp(String v_coddepemp) {
		this.v_coddepemp = v_coddepemp;
	}
	public String getV_codproemp() {
		return v_codproemp;
	}
	public void setV_codproemp(String v_codproemp) {
		this.v_codproemp = v_codproemp;
	}
	public String getV_coddisemp() {
		return v_coddisemp;
	}
	public void setV_coddisemp(String v_coddisemp) {
		this.v_coddisemp = v_coddisemp;
	}
	public String getV_diremp() {
		return v_diremp;
	}
	public void setV_diremp(String v_diremp) {
		this.v_diremp = v_diremp.toUpperCase();//CONVIRTIENDO A MAYUSCULA
	}
	public String getV_dirper() {
		return v_dirper;
	}
	public void setV_dirper(String v_dirper) {
		this.v_dirper = v_dirper.toUpperCase();//CONVIRTIENDO A MAYUSCULA
	}
	public String getV_coddepper() {
		return v_coddepper;
	}
	public void setV_coddepper(String v_coddepper) {
		this.v_coddepper = v_coddepper;
	}
	public String getV_codproper() {
		return v_codproper;
	}
	public void setV_codproper(String v_codproper) {
		this.v_codproper = v_codproper;
	}
	public String getV_coddisper() {
		return v_coddisper;
	}
	public void setV_coddisper(String v_coddisper) {
		this.v_coddisper = v_coddisper;
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
		this.v_email = v_email.toLowerCase();//CONVIRTIENDO A MINUSCULA EL CORREO
	}
	public boolean getV_flgrellab() {
		return v_flgrellab;
	}
	public void setV_flgrellab(boolean v_flgrellab) {
		this.v_flgrellab = v_flgrellab;
	}
	public Date getD_fecing() {
		return d_fecing;
	}
	public void setD_fecing(Date d_fecing) {
		this.d_fecing = d_fecing;
	}
	public Date getD_fecces() {
		return d_fecces;
	}
	public void setD_fecces(Date d_fecces) {
		this.d_fecces = d_fecces;
	}
	public String getV_cargo() {
		return v_cargo;
	}
	public void setV_cargo(String v_cargo) {
		this.v_cargo = v_cargo.toUpperCase();//CONVIRTIENDO A MAYUSCULA EL CARGO
	}
	public String getV_codtmon() {
		return v_codtmon;
	}
	public void setV_codtmon(String v_codtmon) {
		this.v_codtmon = v_codtmon;
	}
	public String getN_monto() {
		return n_monto;
	}
	public void setN_monto(String n_monto) {
		this.n_monto = n_monto;
	}
	public BigDecimal getN_codmat() {
		return n_codmat;
	}
	public void setN_codmat(BigDecimal n_codmat) {
		this.n_codmat = n_codmat;
	}
	public String getV_desotros() {
		return v_desotros;
	}
	public void setV_desotros(String v_desotros) {
		this.v_desotros = v_desotros.toUpperCase();//CONVIRTIENDO A MAYUSCULA LA DESCRIPCION DE OTRA MATERIA
	}
	public String getV_motivo() {
		return v_motivo;
	}
	public void setV_motivo(String v_motivo) {
		this.v_motivo = v_motivo.toUpperCase();//CONVIRTIENDO A MAYUSCULA LA DESCRIPCION DEL MOTIVO
	}
	public String getV_numhoja() {
		return v_numhoja;
	}
	public void setV_numhoja(String v_numhoja) {
		this.v_numhoja = v_numhoja;
	}
	public String getV_anhohoja() {
		return v_anhohoja;
	}
	public void setV_anhohoja(String v_anhohoja) {
		this.v_anhohoja = v_anhohoja;
	}
	public String getN_flgest() {
		return n_flgest;
	}
	public void setN_flgest(String n_flgest) {
		this.n_flgest = n_flgest;
	}
	public String getV_numsol() {
		return v_numsol;
	}
	public void setV_numsol(String v_numsol) {
		this.v_numsol = v_numsol;
	}
	public String getV_anhosol() {
		return v_anhosol;
	}
	public void setV_anhosol(String v_anhosol) {
		this.v_anhosol = v_anhosol;
	}
	public String getV_flgres() {
		return v_flgres;
	}
	public void setV_flgres(String v_flgres) {
		this.v_flgres = v_flgres;
	}
	@Override
	public String toString() {
		return "Solicitud [n_codsol=" + n_codsol + ", persona=" + persona
				+ ", empresa=" + empresa + ", v_coddepemp=" + v_coddepemp
				+ ", v_codproemp=" + v_codproemp + ", v_coddisemp="
				+ v_coddisemp + ", v_diremp=" + v_diremp + ", v_dirper="
				+ v_dirper + ", v_coddepper=" + v_coddepper + ", v_codproper="
				+ v_codproper + ", v_coddisper=" + v_coddisper + ", v_telfijo="
				+ v_telfijo + ", v_telcel=" + v_telcel + ", v_email=" + v_email
				+ ", v_flgrellab=" + v_flgrellab + ", d_fecing=" + d_fecing
				+ ", d_fecces=" + d_fecces + ", v_cargo=" + v_cargo
				+ ", v_codtmon=" + v_codtmon + ", n_monto=" + n_monto
				+ ", n_codmat=" + n_codmat + ", v_desotros=" + v_desotros
				+ ", v_motivo=" + v_motivo + ", v_numhoja=" + v_numhoja
				+ ", v_anhohoja=" + v_anhohoja + ", n_flgest=" + n_flgest
				+ ", v_numsol=" + v_numsol + ", v_anhosol=" + v_anhosol
				+ ", v_flgres=" + v_flgres + "]";
	}
		
	
}
