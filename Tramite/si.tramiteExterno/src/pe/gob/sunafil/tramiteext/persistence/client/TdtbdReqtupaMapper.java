package pe.gob.sunafil.tramiteext.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupa;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupaExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdtbdReqtupaKey;

public interface TdtbdReqtupaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int countByExample(TdtbdReqtupaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int deleteByExample(TdtbdReqtupaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int deleteByPrimaryKey(TdtbdReqtupaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int insert(TdtbdReqtupa record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int insertSelective(TdtbdReqtupa record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    List<TdtbdReqtupa> selectByExample(TdtbdReqtupaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    TdtbdReqtupa selectByPrimaryKey(TdtbdReqtupaKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByExampleSelective(@Param("record") TdtbdReqtupa record, @Param("example") TdtbdReqtupaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByExample(@Param("record") TdtbdReqtupa record, @Param("example") TdtbdReqtupaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByPrimaryKeySelective(TdtbdReqtupa record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Fri Apr 15 16:36:02 COT 2016
     */
    int updateByPrimaryKey(TdtbdReqtupa record);
}