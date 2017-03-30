package pe.gob.sunafil.postulacioncas.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxformacion;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcHvxformacionExample;

public interface RhmvcHvxformacionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int countByExample(RhmvcHvxformacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int deleteByExample(RhmvcHvxformacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int deleteByPrimaryKey(BigDecimal nCorhvfor);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int insert(RhmvcHvxformacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int insertSelective(RhmvcHvxformacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    List<RhmvcHvxformacion> selectByExample(RhmvcHvxformacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    RhmvcHvxformacion selectByPrimaryKey(BigDecimal nCorhvfor);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByExampleSelective(@Param("record") RhmvcHvxformacion record, @Param("example") RhmvcHvxformacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByExample(@Param("record") RhmvcHvxformacion record, @Param("example") RhmvcHvxformacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByPrimaryKeySelective(RhmvcHvxformacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_HVXFORMACION
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByPrimaryKey(RhmvcHvxformacion record);
}