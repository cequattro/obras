package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbRegpensionario;
import pe.gob.sunafil.gestionpersonal.persistence.model.SitbRegpensionarioExample;

public interface SitbRegpensionarioMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int countByExample(SitbRegpensionarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int deleteByExample(SitbRegpensionarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int deleteByPrimaryKey(BigDecimal nCodregpen);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int insert(SitbRegpensionario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int insertSelective(SitbRegpensionario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    List<SitbRegpensionario> selectByExample(SitbRegpensionarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    SitbRegpensionario selectByPrimaryKey(BigDecimal nCodregpen);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByExampleSelective(@Param("record") SitbRegpensionario record, @Param("example") SitbRegpensionarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByExample(@Param("record") SitbRegpensionario record, @Param("example") SitbRegpensionarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByPrimaryKeySelective(SitbRegpensionario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_REGPENSIONARIO
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByPrimaryKey(SitbRegpensionario record);
}