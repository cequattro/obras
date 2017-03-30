package pe.gob.sunafil.denunciavirtual.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbDepxdistrito;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbDepxdistritoExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.SitbDepxdistritoKey;

public interface SitbDepxdistritoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    int countByExample(SitbDepxdistritoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    int deleteByExample(SitbDepxdistritoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    int deleteByPrimaryKey(SitbDepxdistritoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    int insert(SitbDepxdistrito record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    int insertSelective(SitbDepxdistrito record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    List<SitbDepxdistrito> selectByExample(SitbDepxdistritoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    SitbDepxdistrito selectByPrimaryKey(SitbDepxdistritoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    int updateByExampleSelective(@Param("record") SitbDepxdistrito record, @Param("example") SitbDepxdistritoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    int updateByExample(@Param("record") SitbDepxdistrito record, @Param("example") SitbDepxdistritoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    int updateByPrimaryKeySelective(SitbDepxdistrito record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DEPXDISTRITO
     *
     * @mbggenerated Thu Jun 23 09:48:39 COT 2016
     */
    int updateByPrimaryKey(SitbDepxdistrito record);
}