package pe.gob.sunafil.denunciavirtual.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcEntidad;
import pe.gob.sunafil.denunciavirtual.persistence.model.TdtbcEntidadExample;

public interface TdtbcEntidadMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int countByExample(TdtbcEntidadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int deleteByExample(TdtbcEntidadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int deleteByPrimaryKey(String vCodentidad);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int insert(TdtbcEntidad record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int insertSelective(TdtbcEntidad record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    List<TdtbcEntidad> selectByExample(TdtbcEntidadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    TdtbcEntidad selectByPrimaryKey(String vCodentidad);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int updateByExampleSelective(@Param("record") TdtbcEntidad record, @Param("example") TdtbcEntidadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int updateByExample(@Param("record") TdtbcEntidad record, @Param("example") TdtbcEntidadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int updateByPrimaryKeySelective(TdtbcEntidad record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int updateByPrimaryKey(TdtbcEntidad record);
}