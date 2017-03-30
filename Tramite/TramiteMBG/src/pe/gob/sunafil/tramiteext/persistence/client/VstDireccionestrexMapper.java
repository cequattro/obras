package pe.gob.sunafil.tramiteext.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.VstDireccionestrex;
import pe.gob.sunafil.tramiteext.persistence.model.VstDireccionestrexExample;

public interface VstDireccionestrexMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_DIRECCIONESTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int countByExample(VstDireccionestrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_DIRECCIONESTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByExample(VstDireccionestrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_DIRECCIONESTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insert(VstDireccionestrex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_DIRECCIONESTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insertSelective(VstDireccionestrex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_DIRECCIONESTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    List<VstDireccionestrex> selectByExample(VstDireccionestrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_DIRECCIONESTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") VstDireccionestrex record, @Param("example") VstDireccionestrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_DIRECCIONESTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExample(@Param("record") VstDireccionestrex record, @Param("example") VstDireccionestrexExample example);
}