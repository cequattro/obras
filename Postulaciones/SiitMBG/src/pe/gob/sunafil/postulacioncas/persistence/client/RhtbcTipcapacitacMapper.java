package pe.gob.sunafil.postulacioncas.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcTipcapacitac;
import pe.gob.sunafil.postulacioncas.persistence.model.RhtbcTipcapacitacExample;

public interface RhtbcTipcapacitacMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int countByExample(RhtbcTipcapacitacExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int deleteByExample(RhtbcTipcapacitacExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int deleteByPrimaryKey(BigDecimal nCortipcap);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int insert(RhtbcTipcapacitac record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int insertSelective(RhtbcTipcapacitac record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    List<RhtbcTipcapacitac> selectByExample(RhtbcTipcapacitacExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    RhtbcTipcapacitac selectByPrimaryKey(BigDecimal nCortipcap);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByExampleSelective(@Param("record") RhtbcTipcapacitac record, @Param("example") RhtbcTipcapacitacExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByExample(@Param("record") RhtbcTipcapacitac record, @Param("example") RhtbcTipcapacitacExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByPrimaryKeySelective(RhtbcTipcapacitac record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPCAPACITAC
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    int updateByPrimaryKey(RhtbcTipcapacitac record);
}