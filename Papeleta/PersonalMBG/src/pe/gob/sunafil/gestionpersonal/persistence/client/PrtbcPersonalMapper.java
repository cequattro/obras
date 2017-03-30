package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonal;
import pe.gob.sunafil.gestionpersonal.persistence.model.PrtbcPersonalExample;

public interface PrtbcPersonalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int countByExample(PrtbcPersonalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByExample(PrtbcPersonalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByPrimaryKey(String vCodpersonal);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insert(PrtbcPersonal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insertSelective(PrtbcPersonal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    List<PrtbcPersonal> selectByExample(PrtbcPersonalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    PrtbcPersonal selectByPrimaryKey(String vCodpersonal);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") PrtbcPersonal record, @Param("example") PrtbcPersonalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExample(@Param("record") PrtbcPersonal record, @Param("example") PrtbcPersonalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKeySelective(PrtbcPersonal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.PRTBC_PERSONAL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKey(PrtbcPersonal record);
}