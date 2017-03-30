package pe.gob.sunafil.tramiteext.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrex;
import pe.gob.sunafil.tramiteext.persistence.model.VstBandejastrexExample;

public interface VstBandejastrexMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_BANDEJASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int countByExample(VstBandejastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_BANDEJASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByExample(VstBandejastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_BANDEJASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insert(VstBandejastrex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_BANDEJASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insertSelective(VstBandejastrex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_BANDEJASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    List<VstBandejastrex> selectByExample(VstBandejastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_BANDEJASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") VstBandejastrex record, @Param("example") VstBandejastrexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.VST_BANDEJASTREX
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExample(@Param("record") VstBandejastrex record, @Param("example") VstBandejastrexExample example);
}