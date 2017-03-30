package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.math.BigDecimal;

public class RhtbdPersonalKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHTBD_PERSONAL.V_CODPERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    private String vCodpersonal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHTBD_PERSONAL.N_CORPER
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    private BigDecimal nCorper;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHTBD_PERSONAL.V_CODPERSONAL
     *
     * @return the value of RRHHSYS.RHTBD_PERSONAL.V_CODPERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public String getvCodpersonal() {
        return vCodpersonal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHTBD_PERSONAL.V_CODPERSONAL
     *
     * @param vCodpersonal the value for RRHHSYS.RHTBD_PERSONAL.V_CODPERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setvCodpersonal(String vCodpersonal) {
        this.vCodpersonal = vCodpersonal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHTBD_PERSONAL.N_CORPER
     *
     * @return the value of RRHHSYS.RHTBD_PERSONAL.N_CORPER
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public BigDecimal getnCorper() {
        return nCorper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHTBD_PERSONAL.N_CORPER
     *
     * @param nCorper the value for RRHHSYS.RHTBD_PERSONAL.N_CORPER
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setnCorper(BigDecimal nCorper) {
        this.nCorper = nCorper;
    }
}