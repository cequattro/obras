package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPermisos;
import pe.gob.sunafil.gestionpersonal.persistence.model.VstPermisosExample;

public interface VstPermisosMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_PERMISOS
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int countByExample(VstPermisosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_PERMISOS
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByExample(VstPermisosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_PERMISOS
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insert(VstPermisos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_PERMISOS
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insertSelective(VstPermisos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_PERMISOS
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    List<VstPermisos> selectByExample(VstPermisosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_PERMISOS
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") VstPermisos record, @Param("example") VstPermisosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_PERMISOS
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExample(@Param("record") VstPermisos record, @Param("example") VstPermisosExample example);
}