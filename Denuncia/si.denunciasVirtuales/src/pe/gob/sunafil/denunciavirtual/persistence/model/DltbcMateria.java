package pe.gob.sunafil.denunciavirtual.persistence.model;

import java.math.BigDecimal;

public class DltbcMateria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DENVIRTUAL.DLTBC_MATERIA.N_CODMAT
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    private BigDecimal nCodmat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DENVIRTUAL.DLTBC_MATERIA.V_DESMAT
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    private String vDesmat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DENVIRTUAL.DLTBC_MATERIA.V_FLGACT
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    private String vFlgact;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DENVIRTUAL.DLTBC_MATERIA.N_CODMAT
     *
     * @return the value of DENVIRTUAL.DLTBC_MATERIA.N_CODMAT
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public BigDecimal getnCodmat() {
        return nCodmat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DENVIRTUAL.DLTBC_MATERIA.N_CODMAT
     *
     * @param nCodmat the value for DENVIRTUAL.DLTBC_MATERIA.N_CODMAT
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public void setnCodmat(BigDecimal nCodmat) {
        this.nCodmat = nCodmat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DENVIRTUAL.DLTBC_MATERIA.V_DESMAT
     *
     * @return the value of DENVIRTUAL.DLTBC_MATERIA.V_DESMAT
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public String getvDesmat() {
        return vDesmat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DENVIRTUAL.DLTBC_MATERIA.V_DESMAT
     *
     * @param vDesmat the value for DENVIRTUAL.DLTBC_MATERIA.V_DESMAT
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public void setvDesmat(String vDesmat) {
        this.vDesmat = vDesmat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DENVIRTUAL.DLTBC_MATERIA.V_FLGACT
     *
     * @return the value of DENVIRTUAL.DLTBC_MATERIA.V_FLGACT
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public String getvFlgact() {
        return vFlgact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DENVIRTUAL.DLTBC_MATERIA.V_FLGACT
     *
     * @param vFlgact the value for DENVIRTUAL.DLTBC_MATERIA.V_FLGACT
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public void setvFlgact(String vFlgact) {
        this.vFlgact = vFlgact;
    }
}