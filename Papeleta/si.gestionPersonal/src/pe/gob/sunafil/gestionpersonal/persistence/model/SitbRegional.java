package pe.gob.sunafil.gestionpersonal.persistence.model;

public class SitbRegional {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIMINTRA1.SITB_REGIONAL.V_CODREG
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIMINTRA1.SITB_REGIONAL.V_NOMREG
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    private String descripcion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SIMINTRA1.SITB_REGIONAL.V_CODEP
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    private String vCodep;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SIMINTRA1.SITB_REGIONAL.V_CODREG
     *
     * @return the value of SIMINTRA1.SITB_REGIONAL.V_CODREG
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SIMINTRA1.SITB_REGIONAL.V_CODREG
     *
     * @param id the value for SIMINTRA1.SITB_REGIONAL.V_CODREG
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SIMINTRA1.SITB_REGIONAL.V_NOMREG
     *
     * @return the value of SIMINTRA1.SITB_REGIONAL.V_NOMREG
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SIMINTRA1.SITB_REGIONAL.V_NOMREG
     *
     * @param descripcion the value for SIMINTRA1.SITB_REGIONAL.V_NOMREG
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SIMINTRA1.SITB_REGIONAL.V_CODEP
     *
     * @return the value of SIMINTRA1.SITB_REGIONAL.V_CODEP
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public String getvCodep() {
        return vCodep;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SIMINTRA1.SITB_REGIONAL.V_CODEP
     *
     * @param vCodep the value for SIMINTRA1.SITB_REGIONAL.V_CODEP
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public void setvCodep(String vCodep) {
        this.vCodep = vCodep;
    }
}