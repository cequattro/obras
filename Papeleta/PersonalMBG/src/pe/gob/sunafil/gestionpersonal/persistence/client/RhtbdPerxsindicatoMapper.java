package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxsindicato;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxsindicatoExample;

public interface RhtbdPerxsindicatoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int countByExample(RhtbdPerxsindicatoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByExample(RhtbdPerxsindicatoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int deleteByPrimaryKey(BigDecimal nCorpersin);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insert(RhtbdPerxsindicato record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int insertSelective(RhtbdPerxsindicato record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    List<RhtbdPerxsindicato> selectByExample(RhtbdPerxsindicatoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    RhtbdPerxsindicato selectByPrimaryKey(BigDecimal nCorpersin);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") RhtbdPerxsindicato record, @Param("example") RhtbdPerxsindicatoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByExample(@Param("record") RhtbdPerxsindicato record, @Param("example") RhtbdPerxsindicatoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKeySelective(RhtbdPerxsindicato record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    int updateByPrimaryKey(RhtbdPerxsindicato record);
}