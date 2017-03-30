package pe.gob.sunafil.tramiteext.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidad;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcEntidadExample;

public interface TdtbcEntidadMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int countByExample(TdtbcEntidadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByExample(TdtbcEntidadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByPrimaryKey(String vCodentidad);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insert(TdtbcEntidad record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insertSelective(TdtbcEntidad record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    List<TdtbcEntidad> selectByExample(TdtbcEntidadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    TdtbcEntidad selectByPrimaryKey(String vCodentidad);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") TdtbcEntidad record, @Param("example") TdtbcEntidadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExample(@Param("record") TdtbcEntidad record, @Param("example") TdtbcEntidadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKeySelective(TdtbcEntidad record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_ENTIDAD
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKey(TdtbcEntidad record);
}