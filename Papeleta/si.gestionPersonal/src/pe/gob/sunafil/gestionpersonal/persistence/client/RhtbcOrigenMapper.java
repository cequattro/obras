package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcOrigen;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcOrigenExample;

public interface RhtbcOrigenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int countByExample(RhtbcOrigenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int deleteByExample(RhtbcOrigenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int deleteByPrimaryKey(Short nCodorigen);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int insert(RhtbcOrigen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int insertSelective(RhtbcOrigen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    List<RhtbcOrigen> selectByExample(RhtbcOrigenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    RhtbcOrigen selectByPrimaryKey(Short nCodorigen);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByExampleSelective(@Param("record") RhtbcOrigen record, @Param("example") RhtbcOrigenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByExample(@Param("record") RhtbcOrigen record, @Param("example") RhtbcOrigenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByPrimaryKeySelective(RhtbcOrigen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_ORIGEN
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByPrimaryKey(RhtbcOrigen record);
}