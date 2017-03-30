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
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    int countByExample(TdmvdRegxcorteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    int deleteByExample(TdmvdRegxcorteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    int deleteByPrimaryKey(TdmvdRegxcorteKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    int insert(TdmvdRegxcorte record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    int insertSelective(TdmvdRegxcorte record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    List<TdmvdRegxcorte> selectByExample(TdmvdRegxcorteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    TdmvdRegxcorte selectByPrimaryKey(TdmvdRegxcorteKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    int updateByExampleSelective(@Param("record") TdmvdRegxcorte record, @Param("example") TdmvdRegxcorteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    int updateByExample(@Param("record") TdmvdRegxcorte record, @Param("example") TdmvdRegxcorteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    int updateByPrimaryKeySelective(TdmvdRegxcorte record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVD_REGXCORTE
     *
     * @mbggenerated Wed Jul 06 14:31:38 COT 2016
     */
    int updateByPrimaryKey(TdmvdRegxcorte record);
}