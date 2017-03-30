package pe.gob.sunafil.denunciavirtual.siit.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcSoldenvirtual;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcSoldenvirtualExample;

public interface IltbcSoldenvirtualMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    int countByExample(IltbcSoldenvirtualExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    int deleteByExample(IltbcSoldenvirtualExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    int deleteByPrimaryKey(BigDecimal nCodsol);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    int insert(IltbcSoldenvirtual record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    int insertSelective(IltbcSoldenvirtual record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    List<IltbcSoldenvirtual> selectByExample(IltbcSoldenvirtualExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    IltbcSoldenvirtual selectByPrimaryKey(BigDecimal nCodsol);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    int updateByExampleSelective(@Param("record") IltbcSoldenvirtual record, @Param("example") IltbcSoldenvirtualExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    int updateByExample(@Param("record") IltbcSoldenvirtual record, @Param("example") IltbcSoldenvirtualExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    int updateByPrimaryKeySelective(IltbcSoldenvirtual record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_SOLDENVIRTUAL
     *
     * @mbggenerated Tue May 10 09:08:07 COT 2016
     */
    int updateByPrimaryKey(IltbcSoldenvirtual record);
}