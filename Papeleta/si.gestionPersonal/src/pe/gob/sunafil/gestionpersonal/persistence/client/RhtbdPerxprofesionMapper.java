package pe.gob.sunafil.gestionpersonal.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxprofesion;
import pe.gob.sunafil.gestionpersonal.persistence.model.RhtbdPerxprofesionExample;

public interface RhtbdPerxprofesionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int countByExample(RhtbdPerxprofesionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int deleteByExample(RhtbdPerxprofesionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int deleteByPrimaryKey(BigDecimal nCorperpro);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int insert(RhtbdPerxprofesion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int insertSelective(RhtbdPerxprofesion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    List<RhtbdPerxprofesion> selectByExample(RhtbdPerxprofesionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    RhtbdPerxprofesion selectByPrimaryKey(BigDecimal nCorperpro);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByExampleSelective(@Param("record") RhtbdPerxprofesion record, @Param("example") RhtbdPerxprofesionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByExample(@Param("record") RhtbdPerxprofesion record, @Param("example") RhtbdPerxprofesionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByPrimaryKeySelective(RhtbdPerxprofesion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXPROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    int updateByPrimaryKey(RhtbdPerxprofesion record);
}