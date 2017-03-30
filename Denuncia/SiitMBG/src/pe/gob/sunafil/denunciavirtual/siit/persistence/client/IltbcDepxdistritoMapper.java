package pe.gob.sunafil.denunciavirtual.siit.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcDepxdistrito;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcDepxdistritoExample;
import pe.gob.sunafil.denunciavirtual.siit.persistence.model.IltbcDepxdistritoKey;

public interface IltbcDepxdistritoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    int countByExample(IltbcDepxdistritoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    int deleteByExample(IltbcDepxdistritoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    int deleteByPrimaryKey(IltbcDepxdistritoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    int insert(IltbcDepxdistrito record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    int insertSelective(IltbcDepxdistrito record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    List<IltbcDepxdistrito> selectByExample(IltbcDepxdistritoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    IltbcDepxdistrito selectByPrimaryKey(IltbcDepxdistritoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    int updateByExampleSelective(@Param("record") IltbcDepxdistrito record, @Param("example") IltbcDepxdistritoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    int updateByExample(@Param("record") IltbcDepxdistrito record, @Param("example") IltbcDepxdistritoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    int updateByPrimaryKeySelective(IltbcDepxdistrito record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIIT.ILTBC_DEPXDISTRITO
     *
     * @mbggenerated Tue Mar 07 17:22:30 COT 2017
     */
    int updateByPrimaryKey(IltbcDepxdistrito record);
}