package pe.gob.sunafil.tramiteext.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdTupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdTupaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdTupaKey;

public interface TdtbdTupaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int countByExample(TdtbdTupaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByExample(TdtbdTupaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByPrimaryKey(TdtbdTupaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insert(TdtbdTupa record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insertSelective(TdtbdTupa record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    List<TdtbdTupa> selectByExample(TdtbdTupaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    TdtbdTupa selectByPrimaryKey(TdtbdTupaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") TdtbdTupa record, @Param("example") TdtbdTupaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExample(@Param("record") TdtbdTupa record, @Param("example") TdtbdTupaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKeySelective(TdtbdTupa record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_TUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKey(TdtbdTupa record);
}