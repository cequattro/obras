package pe.gob.sunafil.tramiteext.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.VstConsultastrex;
import pe.gob.sunafil.tramiteext.persistence.model.VstConsultastrexExample;

public interface VstConsultastrexMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int countByExample(VstConsultastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByExample(VstConsultastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insert(VstConsultastrex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insertSelective(VstConsultastrex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    List<VstConsultastrex> selectByExample(VstConsultastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") VstConsultastrex record, @Param("example") VstConsultastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExample(@Param("record") VstConsultastrex record, @Param("example") VstConsultastrexExample example);
}