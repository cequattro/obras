package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErrorescabrrhh;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstErrorescabrrhhExample;

public interface VstErrorescabrrhhMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ERRORESCABRRHH
     *
     * @mbggenerated Mon Feb 13 11:10:40 COT 2017
     */
    int countByExample(VstErrorescabrrhhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ERRORESCABRRHH
     *
     * @mbggenerated Mon Feb 13 11:10:40 COT 2017
     */
    int deleteByExample(VstErrorescabrrhhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ERRORESCABRRHH
     *
     * @mbggenerated Mon Feb 13 11:10:40 COT 2017
     */
    int insert(VstErrorescabrrhh record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ERRORESCABRRHH
     *
     * @mbggenerated Mon Feb 13 11:10:40 COT 2017
     */
    int insertSelective(VstErrorescabrrhh record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ERRORESCABRRHH
     *
     * @mbggenerated Mon Feb 13 11:10:40 COT 2017
     */
    List<VstErrorescabrrhh> selectByExample(VstErrorescabrrhhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ERRORESCABRRHH
     *
     * @mbggenerated Mon Feb 13 11:10:40 COT 2017
     */
    int updateByExampleSelective(@Param("record") VstErrorescabrrhh record, @Param("example") VstErrorescabrrhhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_ERRORESCABRRHH
     *
     * @mbggenerated Mon Feb 13 11:10:40 COT 2017
     */
    int updateByExample(@Param("record") VstErrorescabrrhh record, @Param("example") VstErrorescabrrhhExample example);
}