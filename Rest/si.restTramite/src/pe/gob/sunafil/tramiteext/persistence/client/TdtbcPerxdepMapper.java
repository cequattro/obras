package pe.gob.sunafil.tramiteext.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcPerxdep;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcPerxdepExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbcPerxdepKey;

public interface TdtbcPerxdepMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int countByExample(TdtbcPerxdepExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int deleteByExample(TdtbcPerxdepExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int deleteByPrimaryKey(TdtbcPerxdepKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int insert(TdtbcPerxdep record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int insertSelective(TdtbcPerxdep record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    List<TdtbcPerxdep> selectByExample(TdtbcPerxdepExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    TdtbcPerxdep selectByPrimaryKey(TdtbcPerxdepKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByExampleSelective(@Param("record") TdtbcPerxdep record, @Param("example") TdtbcPerxdepExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByExample(@Param("record") TdtbcPerxdep record, @Param("example") TdtbcPerxdepExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByPrimaryKeySelective(TdtbcPerxdep record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_PERXDEP
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByPrimaryKey(TdtbcPerxdep record);
}