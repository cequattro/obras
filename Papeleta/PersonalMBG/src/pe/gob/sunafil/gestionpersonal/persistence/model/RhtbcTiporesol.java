package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.math.BigDecimal;

public class RhtbcTiporesol {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHTBC_TIPORESOL.N_CORTIPRES
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    private BigDecimal nCortipres;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHTBC_TIPORESOL.V_DESTIPRES
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    private String vDestipres;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHTBC_TIPORESOL.V_FLGACT
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    private String vFlgact;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHTBC_TIPORESOL.N_CORTIPRES
     *
     * @return the value of RRHHSYS.RHTBC_TIPORESOL.N_CORTIPRES
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public BigDecimal getnCortipres() {
        return nCortipres;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHTBC_TIPORESOL.N_CORTIPRES
     *
     * @param nCortipres the value for RRHHSYS.RHTBC_TIPORESOL.N_CORTIPRES
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setnCortipres(BigDecimal nCortipres) {
        this.nCortipres = nCortipres;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHTBC_TIPORESOL.V_DESTIPRES
     *
     * @return the value of RRHHSYS.RHTBC_TIPORESOL.V_DESTIPRES
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public String getvDestipres() {
        return vDestipres;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHTBC_TIPORESOL.V_DESTIPRES
     *
     * @param vDestipres the value for RRHHSYS.RHTBC_TIPORESOL.V_DESTIPRES
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setvDestipres(String vDestipres) {
        this.vDestipres = vDestipres;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHTBC_TIPORESOL.V_FLGACT
     *
     * @return the value of RRHHSYS.RHTBC_TIPORESOL.V_FLGACT
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public String getvFlgact() {
        return vFlgact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHTBC_TIPORESOL.V_FLGACT
     *
     * @param vFlgact the value for RRHHSYS.RHTBC_TIPORESOL.V_FLGACT
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setvFlgact(String vFlgact) {
        this.vFlgact = vFlgact;
    }
}