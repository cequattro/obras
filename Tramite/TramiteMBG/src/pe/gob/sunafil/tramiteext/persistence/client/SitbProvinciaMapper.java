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
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int countByExample(SitbProvinciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByExample(SitbProvinciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByPrimaryKey(SitbProvinciaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insert(SitbProvincia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insertSelective(SitbProvincia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    List<SitbProvincia> selectByExample(SitbProvinciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    SitbProvincia selectByPrimaryKey(SitbProvinciaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") SitbProvincia record, @Param("example") SitbProvinciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExample(@Param("record") SitbProvincia record, @Param("example") SitbProvinciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKeySelective(SitbProvincia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROVINCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKey(SitbProvincia record);
}