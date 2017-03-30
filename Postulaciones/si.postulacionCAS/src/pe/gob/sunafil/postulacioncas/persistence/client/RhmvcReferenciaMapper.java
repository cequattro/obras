package pe.gob.sunafil.postulacioncas.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcReferencia;
import pe.gob.sunafil.postulacioncas.persistence.model.RhmvcReferenciaExample;

public interface RhmvcReferenciaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    int countByExample(RhmvcReferenciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    int deleteByExample(RhmvcReferenciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    int deleteByPrimaryKey(BigDecimal nCorref);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    int insert(RhmvcReferencia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    int insertSelective(RhmvcReferencia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    List<RhmvcReferencia> selectByExample(RhmvcReferenciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    RhmvcReferencia selectByPrimaryKey(BigDecimal nCorref);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    int updateByExampleSelective(@Param("record") RhmvcReferencia record, @Param("example") RhmvcReferenciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    int updateByExample(@Param("record") RhmvcReferencia record, @Param("example") RhmvcReferenciaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    int updateByPrimaryKeySelective(RhmvcReferencia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Thu Mar 09 14:36:47 COT 2017
     */
    int updateByPrimaryKey(RhmvcReferencia record);
}