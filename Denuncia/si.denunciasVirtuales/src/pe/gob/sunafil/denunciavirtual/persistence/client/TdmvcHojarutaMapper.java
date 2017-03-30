package pe.gob.sunafil.denunciavirtual.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdmvcHojarutaExample;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdmvcHojarutaKey;

public interface TdmvcHojarutaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_HOJARUTA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int countByExample(TdmvcHojarutaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_HOJARUTA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int deleteByExample(TdmvcHojarutaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_HOJARUTA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int deleteByPrimaryKey(TdmvcHojarutaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_HOJARUTA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int insert(TdmvcHojarutaKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_HOJARUTA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int insertSelective(TdmvcHojarutaKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_HOJARUTA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    List<TdmvcHojarutaKey> selectByExample(TdmvcHojarutaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_HOJARUTA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int updateByExampleSelective(@Param("record") TdmvcHojarutaKey record, @Param("example") TdmvcHojarutaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_HOJARUTA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int updateByExample(@Param("record") TdmvcHojarutaKey record, @Param("example") TdmvcHojarutaExample example);
}