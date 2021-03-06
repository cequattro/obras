package pe.gob.sunafil.tramiteext.persistence.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegxcorte;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegxcorteExample;
import pe.gob.sunafil.tramiteext.persistence.model.TdmvdRegxcorteKey;

public interface TdmvdRegxcorteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int countByExample(TdmvdRegxcorteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByExample(TdmvdRegxcorteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int deleteByPrimaryKey(TdmvdRegxcorteKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insert(TdmvdRegxcorte record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int insertSelective(TdmvdRegxcorte record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    List<TdmvdRegxcorte> selectByExample(TdmvdRegxcorteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    TdmvdRegxcorte selectByPrimaryKey(TdmvdRegxcorteKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExampleSelective(@Param("record") TdmvdRegxcorte record, @Param("example") TdmvdRegxcorteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByExample(@Param("record") TdmvdRegxcorte record, @Param("example") TdmvdRegxcorteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKeySelective(TdmvdRegxcorte record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    int updateByPrimaryKey(TdmvdRegxcorte record);
}