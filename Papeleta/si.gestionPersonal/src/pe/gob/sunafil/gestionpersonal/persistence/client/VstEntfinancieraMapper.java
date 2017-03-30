package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstEntfinanciera;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstEntfinancieraExample;

public interface VstEntfinancieraMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ENTFINANCIERA
     *
     * @mbggenerated Thu Mar 16 17:22:50 COT 2017
     */
    int countByExample(VstEntfinancieraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ENTFINANCIERA
     *
     * @mbggenerated Thu Mar 16 17:22:50 COT 2017
     */
    int deleteByExample(VstEntfinancieraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ENTFINANCIERA
     *
     * @mbggenerated Thu Mar 16 17:22:50 COT 2017
     */
    int insert(VstEntfinanciera record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ENTFINANCIERA
     *
     * @mbggenerated Thu Mar 16 17:22:50 COT 2017
     */
    int insertSelective(VstEntfinanciera record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ENTFINANCIERA
     *
     * @mbggenerated Thu Mar 16 17:22:50 COT 2017
     */
    List<VstEntfinanciera> selectByExample(VstEntfinancieraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ENTFINANCIERA
     *
     * @mbggenerated Thu Mar 16 17:22:50 COT 2017
     */
    int updateByExampleSelective(@Param("record") VstEntfinanciera record, @Param("example") VstEntfinancieraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ENTFINANCIERA
     *
     * @mbggenerated Thu Mar 16 17:22:50 COT 2017
     */
    int updateByExample(@Param("record") VstEntfinanciera record, @Param("example") VstEntfinancieraExample example);
}