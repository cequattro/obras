package pe.gob.sunafil.postulacioncas.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxotrdoc;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxotrdocExample;

public interface RhmvcHvxotrdocMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int countByExample(RhmvcHvxotrdocExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int deleteByExample(RhmvcHvxotrdocExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int deleteByPrimaryKey(BigDecimal nCorhvdoc);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int insert(RhmvcHvxotrdoc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int insertSelective(RhmvcHvxotrdoc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    List<RhmvcHvxotrdoc> selectByExample(RhmvcHvxotrdocExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    RhmvcHvxotrdoc selectByPrimaryKey(BigDecimal nCorhvdoc);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByExampleSelective(@Param("record") RhmvcHvxotrdoc record, @Param("example") RhmvcHvxotrdocExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByExample(@Param("record") RhmvcHvxotrdoc record, @Param("example") RhmvcHvxotrdocExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByPrimaryKeySelective(RhmvcHvxotrdoc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXOTRDOC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByPrimaryKey(RhmvcHvxotrdoc record);
}