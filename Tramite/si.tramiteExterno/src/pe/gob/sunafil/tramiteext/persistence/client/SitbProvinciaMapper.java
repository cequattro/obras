package pe.gob.sunafil.tramiteext.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.SitbProvincia;
import pe.gob.sunafil.tramiteext.persistence.model.SitbProvinciaExample;
import pe.gob.sunafil.tramiteext.persistence.model.SitbProvinciaKey;

public interface SitbProvinciaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int countByExample(SitbProvinciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int deleteByExample(SitbProvinciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int deleteByPrimaryKey(SitbProvinciaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int insert(SitbProvincia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int insertSelective(SitbProvincia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    List<SitbProvincia> selectByExample(SitbProvinciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    SitbProvincia selectByPrimaryKey(SitbProvinciaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByExampleSelective(@Param("record") SitbProvincia record, @Param("example") SitbProvinciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByExample(@Param("record") SitbProvincia record, @Param("example") SitbProvinciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByPrimaryKeySelective(SitbProvincia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByPrimaryKey(SitbProvincia record);
}