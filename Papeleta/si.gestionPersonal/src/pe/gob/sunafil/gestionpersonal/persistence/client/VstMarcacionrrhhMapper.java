package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstMarcacionrrhhExample;

public interface VstMarcacionrrhhMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_MARCACIONRRHH
     *
     * @mbggenerated Wed Jan 11 10:07:19 COT 2017
     */
    int countByExample(VstMarcacionrrhhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_MARCACIONRRHH
     *
     * @mbggenerated Wed Jan 11 10:07:19 COT 2017
     */
    int deleteByExample(VstMarcacionrrhhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_MARCACIONRRHH
     *
     * @mbggenerated Wed Jan 11 10:07:19 COT 2017
     */
    int insert(VstMarcacionrrhh record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_MARCACIONRRHH
     *
     * @mbggenerated Wed Jan 11 10:07:19 COT 2017
     */
    int insertSelective(VstMarcacionrrhh record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_MARCACIONRRHH
     *
     * @mbggenerated Wed Jan 11 10:07:19 COT 2017
     */
    List<VstMarcacionrrhh> selectByExample(VstMarcacionrrhhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_MARCACIONRRHH
     *
     * @mbggenerated Wed Jan 11 10:07:19 COT 2017
     */
    int updateByExampleSelective(@Param("record") VstMarcacionrrhh record, @Param("example") VstMarcacionrrhhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_MARCACIONRRHH
     *
     * @mbggenerated Wed Jan 11 10:07:19 COT 2017
     */
    int updateByExample(@Param("record") VstMarcacionrrhh record, @Param("example") VstMarcacionrrhhExample example);
}