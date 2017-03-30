package pe.gob.sunafil.postulacioncas.persistence.model;

import java.math.BigDecimal;

public class RhtbcFormacion {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHTBC_FORMACION.N_CODFOR
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    private BigDecimal nCodfor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHTBC_FORMACION.V_DESFOR
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    private String vDesfor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHTBC_FORMACION.V_FLGACT
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    private String vFlgact;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHTBC_FORMACION.N_CODFOR
     *
     * @return the value of RRHHSYS.RHTBC_FORMACION.N_CODFOR
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public BigDecimal getnCodfor() {
        return nCodfor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHTBC_FORMACION.N_CODFOR
     *
     * @param nCodfor the value for RRHHSYS.RHTBC_FORMACION.N_CODFOR
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void setnCodfor(BigDecimal nCodfor) {
        this.nCodfor = nCodfor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHTBC_FORMACION.V_DESFOR
     *
     * @return the value of RRHHSYS.RHTBC_FORMACION.V_DESFOR
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public String getvDesfor() {
        return vDesfor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHTBC_FORMACION.V_DESFOR
     *
     * @param vDesfor the value for RRHHSYS.RHTBC_FORMACION.V_DESFOR
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void setvDesfor(String vDesfor) {
        this.vDesfor = vDesfor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHTBC_FORMACION.V_FLGACT
     *
     * @return the value of RRHHSYS.RHTBC_FORMACION.V_FLGACT
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public String getvFlgact() {
        return vFlgact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHTBC_FORMACION.V_FLGACT
     *
     * @param vFlgact the value for RRHHSYS.RHTBC_FORMACION.V_FLGACT
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void setvFlgact(String vFlgact) {
        this.vFlgact = vFlgact;
    }
}