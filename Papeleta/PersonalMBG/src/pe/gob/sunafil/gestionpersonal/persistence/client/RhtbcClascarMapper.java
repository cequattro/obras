package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcClascar;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcClascarExample;

public interface RhtbcClascarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int countByExample(RhtbcClascarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByExample(RhtbcClascarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByPrimaryKey(BigDecimal nCorclacar);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insert(RhtbcClascar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insertSelective(RhtbcClascar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    List<RhtbcClascar> selectByExample(RhtbcClascarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    RhtbcClascar selectByPrimaryKey(BigDecimal nCorclacar);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") RhtbcClascar record, @Param("example") RhtbcClascarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExample(@Param("record") RhtbcClascar record, @Param("example") RhtbcClascarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKeySelective(RhtbcClascar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CLASCAR
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKey(RhtbcClascar record);
}