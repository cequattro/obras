package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTiporesolucion;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstTiporesolucionExample;

public interface VstTiporesolucionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_TIPORESOLUCION
     *
     * @mbggenerated Wed Mar 29 15:54:11 COT 2017
     */
    int countByExample(VstTiporesolucionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_TIPORESOLUCION
     *
     * @mbggenerated Wed Mar 29 15:54:11 COT 2017
     */
    int deleteByExample(VstTiporesolucionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_TIPORESOLUCION
     *
     * @mbggenerated Wed Mar 29 15:54:11 COT 2017
     */
    int insert(VstTiporesolucion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_TIPORESOLUCION
     *
     * @mbggenerated Wed Mar 29 15:54:11 COT 2017
     */
    int insertSelective(VstTiporesolucion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_TIPORESOLUCION
     *
     * @mbggenerated Wed Mar 29 15:54:11 COT 2017
     */
    List<VstTiporesolucion> selectByExample(VstTiporesolucionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_TIPORESOLUCION
     *
     * @mbggenerated Wed Mar 29 15:54:11 COT 2017
     */
    int updateByExampleSelective(@Param("record") VstTiporesolucion record, @Param("example") VstTiporesolucionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_TIPORESOLUCION
     *
     * @mbggenerated Wed Mar 29 15:54:11 COT 2017
     */
    int updateByExample(@Param("record") VstTiporesolucion record, @Param("example") VstTiporesolucionExample example);
}