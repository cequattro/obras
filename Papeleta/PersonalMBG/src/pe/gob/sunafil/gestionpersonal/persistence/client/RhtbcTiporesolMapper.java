package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTiporesol;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTiporesolExample;

public interface RhtbcTiporesolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int countByExample(RhtbcTiporesolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByExample(RhtbcTiporesolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByPrimaryKey(BigDecimal nCortipres);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insert(RhtbcTiporesol record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insertSelective(RhtbcTiporesol record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    List<RhtbcTiporesol> selectByExample(RhtbcTiporesolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    RhtbcTiporesol selectByPrimaryKey(BigDecimal nCortipres);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") RhtbcTiporesol record, @Param("example") RhtbcTiporesolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExample(@Param("record") RhtbcTiporesol record, @Param("example") RhtbcTiporesolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKeySelective(RhtbcTiporesol record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPORESOL
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKey(RhtbcTiporesol record);
}