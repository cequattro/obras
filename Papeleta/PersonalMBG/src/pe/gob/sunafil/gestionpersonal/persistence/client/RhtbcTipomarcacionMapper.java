package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipomarcacion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbcTipomarcacionExample;

public interface RhtbcTipomarcacionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int countByExample(RhtbcTipomarcacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByExample(RhtbcTipomarcacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByPrimaryKey(Short nCodtipo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insert(RhtbcTipomarcacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insertSelective(RhtbcTipomarcacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    List<RhtbcTipomarcacion> selectByExample(RhtbcTipomarcacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    RhtbcTipomarcacion selectByPrimaryKey(Short nCodtipo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") RhtbcTipomarcacion record, @Param("example") RhtbcTipomarcacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExample(@Param("record") RhtbcTipomarcacion record, @Param("example") RhtbcTipomarcacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKeySelective(RhtbcTipomarcacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKey(RhtbcTipomarcacion record);
}