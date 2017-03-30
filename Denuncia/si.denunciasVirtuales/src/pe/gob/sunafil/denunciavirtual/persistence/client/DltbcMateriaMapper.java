package pe.gob.sunafil.denunciavirtual.persistence.client;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.denunciavirtual.persistence.model.DltbcMateria;
import pe.gob.sunafil.denunciavirtual.persistence.model.DltbcMateriaExample;

public interface DltbcMateriaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int countByExample(DltbcMateriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int deleteByExample(DltbcMateriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int deleteByPrimaryKey(BigDecimal nCodmat);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int insert(DltbcMateria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int insertSelective(DltbcMateria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    List<DltbcMateria> selectByExample(DltbcMateriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    DltbcMateria selectByPrimaryKey(BigDecimal nCodmat);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int updateByExampleSelective(@Param("record") DltbcMateria record, @Param("example") DltbcMateriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int updateByExample(@Param("record") DltbcMateria record, @Param("example") DltbcMateriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int updateByPrimaryKeySelective(DltbcMateria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DENVIRTUAL.DLTBC_MATERIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    int updateByPrimaryKey(DltbcMateria record);
}