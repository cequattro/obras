package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.math.BigDecimal;

public class SitbEntfinanciera {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIMINTRA1.SITB_ENTFINANCIERA.N_CODENTFIN
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    private BigDecimal nCodentfin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIMINTRA1.SITB_ENTFINANCIERA.V_DESENTFIN
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    private String vDesentfin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIMINTRA1.SITB_ENTFINANCIERA.V_FLGACT
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    private String vFlgact;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SIMINTRA1.SITB_ENTFINANCIERA.N_CODENTFIN
     *
     * @return the value of SIMINTRA1.SITB_ENTFINANCIERA.N_CODENTFIN
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public BigDecimal getnCodentfin() {
        return nCodentfin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SIMINTRA1.SITB_ENTFINANCIERA.N_CODENTFIN
     *
     * @param nCodentfin the value for SIMINTRA1.SITB_ENTFINANCIERA.N_CODENTFIN
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setnCodentfin(BigDecimal nCodentfin) {
        this.nCodentfin = nCodentfin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SIMINTRA1.SITB_ENTFINANCIERA.V_DESENTFIN
     *
     * @return the value of SIMINTRA1.SITB_ENTFINANCIERA.V_DESENTFIN
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public String getvDesentfin() {
        return vDesentfin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SIMINTRA1.SITB_ENTFINANCIERA.V_DESENTFIN
     *
     * @param vDesentfin the value for SIMINTRA1.SITB_ENTFINANCIERA.V_DESENTFIN
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setvDesentfin(String vDesentfin) {
        this.vDesentfin = vDesentfin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SIMINTRA1.SITB_ENTFINANCIERA.V_FLGACT
     *
     * @return the value of SIMINTRA1.SITB_ENTFINANCIERA.V_FLGACT
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public String getvFlgact() {
        return vFlgact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SIMINTRA1.SITB_ENTFINANCIERA.V_FLGACT
     *
     * @param vFlgact the value for SIMINTRA1.SITB_ENTFINANCIERA.V_FLGACT
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setvFlgact(String vFlgact) {
        this.vFlgact = vFlgact;
    }
}