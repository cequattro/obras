package pe.gob.sunafil.tramiteext.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistro;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistroExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvcRegistroKey;

public interface TdmvcRegistroMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int countByExample(TdmvcRegistroExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByExample(TdmvcRegistroExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByPrimaryKey(TdmvcRegistroKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insert(TdmvcRegistro record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insertSelective(TdmvcRegistro record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    List<TdmvcRegistro> selectByExample(TdmvcRegistroExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    TdmvcRegistro selectByPrimaryKey(TdmvcRegistroKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") TdmvcRegistro record, @Param("example") TdmvcRegistroExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExample(@Param("record") TdmvcRegistro record, @Param("example") TdmvcRegistroExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKeySelective(TdmvcRegistro record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_REGISTRO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKey(TdmvcRegistro record);
}