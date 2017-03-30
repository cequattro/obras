package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEstadocivil;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbEstadocivilExample;

public interface SitbEstadocivilMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int countByExample(SitbEstadocivilExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int deleteByExample(SitbEstadocivilExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int deleteByPrimaryKey(String vCodestciv);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int insert(SitbEstadocivil record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int insertSelective(SitbEstadocivil record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    List<SitbEstadocivil> selectByExample(SitbEstadocivilExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    SitbEstadocivil selectByPrimaryKey(String vCodestciv);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByExampleSelective(@Param("record") SitbEstadocivil record, @Param("example") SitbEstadocivilExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByExample(@Param("record") SitbEstadocivil record, @Param("example") SitbEstadocivilExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByPrimaryKeySelective(SitbEstadocivil record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByPrimaryKey(SitbEstadocivil record);
}