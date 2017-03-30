package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbRegional;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbRegionalExample;

public interface SitbRegionalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int countByExample(SitbRegionalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByExample(SitbRegionalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insert(SitbRegional record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insertSelective(SitbRegional record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    List<SitbRegional> selectByExample(SitbRegionalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    SitbRegional selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") SitbRegional record, @Param("example") SitbRegionalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExample(@Param("record") SitbRegional record, @Param("example") SitbRegionalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKeySelective(SitbRegional record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGIONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKey(SitbRegional record);
}