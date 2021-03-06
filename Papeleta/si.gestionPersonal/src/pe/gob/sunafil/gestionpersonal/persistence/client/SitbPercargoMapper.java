package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargo;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbPercargoExample;

public interface SitbPercargoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int countByExample(SitbPercargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int deleteByExample(SitbPercargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int deleteByPrimaryKey(String vCodcargo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int insert(SitbPercargo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int insertSelective(SitbPercargo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    List<SitbPercargo> selectByExample(SitbPercargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    SitbPercargo selectByPrimaryKey(String vCodcargo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByExampleSelective(@Param("record") SitbPercargo record, @Param("example") SitbPercargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByExample(@Param("record") SitbPercargo record, @Param("example") SitbPercargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByPrimaryKeySelective(SitbPercargo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PERCARGO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByPrimaryKey(SitbPercargo record);
}