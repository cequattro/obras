package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvdPermisoxest;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvdPermisoxestExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvdPermisoxestKey;

public interface RhmvdPermisoxestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    int countByExample(RhmvdPermisoxestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    int deleteByExample(RhmvdPermisoxestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    int deleteByPrimaryKey(RhmvdPermisoxestKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    int insert(RhmvdPermisoxest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    int insertSelective(RhmvdPermisoxest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    List<RhmvdPermisoxest> selectByExample(RhmvdPermisoxestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    RhmvdPermisoxest selectByPrimaryKey(RhmvdPermisoxestKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    int updateByExampleSelective(@Param("record") RhmvdPermisoxest record, @Param("example") RhmvdPermisoxestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    int updateByExample(@Param("record") RhmvdPermisoxest record, @Param("example") RhmvdPermisoxestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    int updateByPrimaryKeySelective(RhmvdPermisoxest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVD_PERMISOXEST
     *
     * @mbggenerated Thu Mar 02 12:30:53 COT 2017
     */
    int updateByPrimaryKey(RhmvdPermisoxest record);
}