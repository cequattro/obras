package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstSeguro;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstSeguroExample;

public interface VstSeguroMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:59:37 COT 2017
     */
    int countByExample(VstSeguroExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:59:37 COT 2017
     */
    int deleteByExample(VstSeguroExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:59:37 COT 2017
     */
    int insert(VstSeguro record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:59:37 COT 2017
     */
    int insertSelective(VstSeguro record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:59:37 COT 2017
     */
    List<VstSeguro> selectByExample(VstSeguroExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:59:37 COT 2017
     */
    int updateByExampleSelective(@Param("record") VstSeguro record, @Param("example") VstSeguroExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:59:37 COT 2017
     */
    int updateByExample(@Param("record") VstSeguro record, @Param("example") VstSeguroExample example);
}