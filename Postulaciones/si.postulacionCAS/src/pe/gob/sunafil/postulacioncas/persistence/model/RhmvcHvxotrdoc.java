package pe.gob.sunafil.postulacioncas.persistence.model;

import java.math.BigDecimal;

public class RhmvcHvxotrdoc {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHMVC_HVXOTRDOC.N_CORHVDOC
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    private BigDecimal nCorhvdoc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHMVC_HVXOTRDOC.N_CORHOJVID
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    private BigDecimal nCorhojvid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RRHHSYS.RHMVC_HVXOTRDOC.V_DESCRIPCION
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    private String vDescripcion;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHMVC_HVXOTRDOC.N_CORHVDOC
     *
     * @return the value of RRHHSYS.RHMVC_HVXOTRDOC.N_CORHVDOC
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    public BigDecimal getnCorhvdoc() {
        return nCorhvdoc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHMVC_HVXOTRDOC.N_CORHVDOC
     *
     * @param nCorhvdoc the value for RRHHSYS.RHMVC_HVXOTRDOC.N_CORHVDOC
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    public void setnCorhvdoc(BigDecimal nCorhvdoc) {
        this.nCorhvdoc = nCorhvdoc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHMVC_HVXOTRDOC.N_CORHOJVID
     *
     * @return the value of RRHHSYS.RHMVC_HVXOTRDOC.N_CORHOJVID
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    public BigDecimal getnCorhojvid() {
        return nCorhojvid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHMVC_HVXOTRDOC.N_CORHOJVID
     *
     * @param nCorhojvid the value for RRHHSYS.RHMVC_HVXOTRDOC.N_CORHOJVID
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    public void setnCorhojvid(BigDecimal nCorhojvid) {
        this.nCorhojvid = nCorhojvid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RRHHSYS.RHMVC_HVXOTRDOC.V_DESCRIPCION
     *
     * @return the value of RRHHSYS.RHMVC_HVXOTRDOC.V_DESCRIPCION
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    public String getvDescripcion() {
        return vDescripcion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RRHHSYS.RHMVC_HVXOTRDOC.V_DESCRIPCION
     *
     * @param vDescripcion the value for RRHHSYS.RHMVC_HVXOTRDOC.V_DESCRIPCION
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    public void setvDescripcion(String vDescripcion) {
        this.vDescripcion = vDescripcion;
    }
}