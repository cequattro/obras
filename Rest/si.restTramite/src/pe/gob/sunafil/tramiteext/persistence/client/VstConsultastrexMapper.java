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
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int countByExample(VstConsultastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int deleteByExample(VstConsultastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int insert(VstConsultastrex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int insertSelective(VstConsultastrex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    List<VstConsultastrex> selectByExample(VstConsultastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByExampleSelective(@Param("record") VstConsultastrex record, @Param("example") VstConsultastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_CONSULTASTREX
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByExample(@Param("record") VstConsultastrex record, @Param("example") VstConsultastrexExample example);
}