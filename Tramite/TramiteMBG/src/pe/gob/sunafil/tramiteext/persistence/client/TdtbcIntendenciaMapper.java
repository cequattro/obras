package pe.gob.sunafil.tramiteext.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcIntendencia;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcIntendenciaExample;

public interface TdtbcIntendenciaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int countByExample(TdtbcIntendenciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByExample(TdtbcIntendenciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByPrimaryKey(BigDecimal nNumint);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insert(TdtbcIntendencia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insertSelective(TdtbcIntendencia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    List<TdtbcIntendencia> selectByExample(TdtbcIntendenciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    TdtbcIntendencia selectByPrimaryKey(BigDecimal nNumint);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") TdtbcIntendencia record, @Param("example") TdtbcIntendenciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExample(@Param("record") TdtbcIntendencia record, @Param("example") TdtbcIntendenciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKeySelective(TdtbcIntendencia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKey(TdtbcIntendencia record);
}