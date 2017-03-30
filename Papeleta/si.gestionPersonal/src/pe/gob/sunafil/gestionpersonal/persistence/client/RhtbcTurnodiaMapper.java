package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodia;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodiaExample;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTurnodiaKey;

public interface RhtbcTurnodiaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int countByExample(RhtbcTurnodiaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int deleteByExample(RhtbcTurnodiaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int deleteByPrimaryKey(RhtbcTurnodiaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int insert(RhtbcTurnodia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int insertSelective(RhtbcTurnodia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    List<RhtbcTurnodia> selectByExample(RhtbcTurnodiaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    RhtbcTurnodia selectByPrimaryKey(RhtbcTurnodiaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByExampleSelective(@Param("record") RhtbcTurnodia record, @Param("example") RhtbcTurnodiaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByExample(@Param("record") RhtbcTurnodia record, @Param("example") RhtbcTurnodiaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByPrimaryKeySelective(RhtbcTurnodia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    int updateByPrimaryKey(RhtbcTurnodia record);
}