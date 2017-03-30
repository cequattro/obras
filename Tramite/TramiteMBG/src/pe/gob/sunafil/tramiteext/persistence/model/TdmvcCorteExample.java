package pe.gob.sunafil.tramiteext.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TdmvcCorteExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public TdmvcCorteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andVCodcorteIsNull() {
            addCriterion("V_CODCORTE is null");
            return (Criteria) this;
        }

        public Criteria andVCodcorteIsNotNull() {
            addCriterion("V_CODCORTE is not null");
            return (Criteria) this;
        }

        public Criteria andVCodcorteEqualTo(String value) {
            addCriterion("V_CODCORTE =", value, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteNotEqualTo(String value) {
            addCriterion("V_CODCORTE <>", value, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteGreaterThan(String value) {
            addCriterion("V_CODCORTE >", value, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODCORTE >=", value, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteLessThan(String value) {
            addCriterion("V_CODCORTE <", value, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteLessThanOrEqualTo(String value) {
            addCriterion("V_CODCORTE <=", value, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteLike(String value) {
            addCriterion("V_CODCORTE like", value, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteNotLike(String value) {
            addCriterion("V_CODCORTE not like", value, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteIn(List<String> values) {
            addCriterion("V_CODCORTE in", values, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteNotIn(List<String> values) {
            addCriterion("V_CODCORTE not in", values, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteBetween(String value1, String value2) {
            addCriterion("V_CODCORTE between", value1, value2, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVCodcorteNotBetween(String value1, String value2) {
            addCriterion("V_CODCORTE not between", value1, value2, "vCodcorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteIsNull() {
            addCriterion("V_ANOCORTE is null");
            return (Criteria) this;
        }

        public Criteria andVAnocorteIsNotNull() {
            addCriterion("V_ANOCORTE is not null");
            return (Criteria) this;
        }

        public Criteria andVAnocorteEqualTo(String value) {
            addCriterion("V_ANOCORTE =", value, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteNotEqualTo(String value) {
            addCriterion("V_ANOCORTE <>", value, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteGreaterThan(String value) {
            addCriterion("V_ANOCORTE >", value, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteGreaterThanOrEqualTo(String value) {
            addCriterion("V_ANOCORTE >=", value, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteLessThan(String value) {
            addCriterion("V_ANOCORTE <", value, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteLessThanOrEqualTo(String value) {
            addCriterion("V_ANOCORTE <=", value, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteLike(String value) {
            addCriterion("V_ANOCORTE like", value, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteNotLike(String value) {
            addCriterion("V_ANOCORTE not like", value, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteIn(List<String> values) {
            addCriterion("V_ANOCORTE in", values, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteNotIn(List<String> values) {
            addCriterion("V_ANOCORTE not in", values, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteBetween(String value1, String value2) {
            addCriterion("V_ANOCORTE between", value1, value2, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andVAnocorteNotBetween(String value1, String value2) {
            addCriterion("V_ANOCORTE not between", value1, value2, "vAnocorte");
            return (Criteria) this;
        }

        public Criteria andDFeccorteIsNull() {
            addCriterion("D_FECCORTE is null");
            return (Criteria) this;
        }

        public Criteria andDFeccorteIsNotNull() {
            addCriterion("D_FECCORTE is not null");
            return (Criteria) this;
        }

        public Criteria andDFeccorteEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECCORTE =", value, "dFeccorte");
            return (Criteria) this;
        }

        public Criteria andDFeccorteNotEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECCORTE <>", value, "dFeccorte");
            return (Criteria) this;
        }

        public Criteria andDFeccorteGreaterThan(Date value) {
            addCriterionForJDBCDate("D_FECCORTE >", value, "dFeccorte");
            return (Criteria) this;
        }

        public Criteria andDFeccorteGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECCORTE >=", value, "dFeccorte");
            return (Criteria) this;
        }

        public Criteria andDFeccorteLessThan(Date value) {
            addCriterionForJDBCDate("D_FECCORTE <", value, "dFeccorte");
            return (Criteria) this;
        }

        public Criteria andDFeccorteLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECCORTE <=", value, "dFeccorte");
            return (Criteria) this;
        }

        public Criteria andDFeccorteIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECCORTE in", values, "dFeccorte");
            return (Criteria) this;
        }

        public Criteria andDFeccorteNotIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECCORTE not in", values, "dFeccorte");
            return (Criteria) this;
        }

        public Criteria andDFeccorteBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECCORTE between", value1, value2, "dFeccorte");
            return (Criteria) this;
        }

        public Criteria andDFeccorteNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECCORTE not between", value1, value2, "dFeccorte");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiIsNull() {
            addCriterion("N_NUMDEPORI is null");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiIsNotNull() {
            addCriterion("N_NUMDEPORI is not null");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiEqualTo(Short value) {
            addCriterion("N_NUMDEPORI =", value, "nNumdepori");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiNotEqualTo(Short value) {
            addCriterion("N_NUMDEPORI <>", value, "nNumdepori");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiGreaterThan(Short value) {
            addCriterion("N_NUMDEPORI >", value, "nNumdepori");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiGreaterThanOrEqualTo(Short value) {
            addCriterion("N_NUMDEPORI >=", value, "nNumdepori");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiLessThan(Short value) {
            addCriterion("N_NUMDEPORI <", value, "nNumdepori");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiLessThanOrEqualTo(Short value) {
            addCriterion("N_NUMDEPORI <=", value, "nNumdepori");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiIn(List<Short> values) {
            addCriterion("N_NUMDEPORI in", values, "nNumdepori");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiNotIn(List<Short> values) {
            addCriterion("N_NUMDEPORI not in", values, "nNumdepori");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiBetween(Short value1, Short value2) {
            addCriterion("N_NUMDEPORI between", value1, value2, "nNumdepori");
            return (Criteria) this;
        }

        public Criteria andNNumdeporiNotBetween(Short value1, Short value2) {
            addCriterion("N_NUMDEPORI not between", value1, value2, "nNumdepori");
            return (Criteria) this;
        }

        public Criteria andNCantidadIsNull() {
            addCriterion("N_CANTIDAD is null");
            return (Criteria) this;
        }

        public Criteria andNCantidadIsNotNull() {
            addCriterion("N_CANTIDAD is not null");
            return (Criteria) this;
        }

        public Criteria andNCantidadEqualTo(Integer value) {
            addCriterion("N_CANTIDAD =", value, "nCantidad");
            return (Criteria) this;
        }

        public Criteria andNCantidadNotEqualTo(Integer value) {
            addCriterion("N_CANTIDAD <>", value, "nCantidad");
            return (Criteria) this;
        }

        public Criteria andNCantidadGreaterThan(Integer value) {
            addCriterion("N_CANTIDAD >", value, "nCantidad");
            return (Criteria) this;
        }

        public Criteria andNCantidadGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_CANTIDAD >=", value, "nCantidad");
            return (Criteria) this;
        }

        public Criteria andNCantidadLessThan(Integer value) {
            addCriterion("N_CANTIDAD <", value, "nCantidad");
            return (Criteria) this;
        }

        public Criteria andNCantidadLessThanOrEqualTo(Integer value) {
            addCriterion("N_CANTIDAD <=", value, "nCantidad");
            return (Criteria) this;
        }

        public Criteria andNCantidadIn(List<Integer> values) {
            addCriterion("N_CANTIDAD in", values, "nCantidad");
            return (Criteria) this;
        }

        public Criteria andNCantidadNotIn(List<Integer> values) {
            addCriterion("N_CANTIDAD not in", values, "nCantidad");
            return (Criteria) this;
        }

        public Criteria andNCantidadBetween(Integer value1, Integer value2) {
            addCriterion("N_CANTIDAD between", value1, value2, "nCantidad");
            return (Criteria) this;
        }

        public Criteria andNCantidadNotBetween(Integer value1, Integer value2) {
            addCriterion("N_CANTIDAD not between", value1, value2, "nCantidad");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoIsNull() {
            addCriterion("N_FLGANULADO is null");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoIsNotNull() {
            addCriterion("N_FLGANULADO is not null");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoEqualTo(Short value) {
            addCriterion("N_FLGANULADO =", value, "nFlganulado");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoNotEqualTo(Short value) {
            addCriterion("N_FLGANULADO <>", value, "nFlganulado");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoGreaterThan(Short value) {
            addCriterion("N_FLGANULADO >", value, "nFlganulado");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoGreaterThanOrEqualTo(Short value) {
            addCriterion("N_FLGANULADO >=", value, "nFlganulado");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoLessThan(Short value) {
            addCriterion("N_FLGANULADO <", value, "nFlganulado");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoLessThanOrEqualTo(Short value) {
            addCriterion("N_FLGANULADO <=", value, "nFlganulado");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoIn(List<Short> values) {
            addCriterion("N_FLGANULADO in", values, "nFlganulado");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoNotIn(List<Short> values) {
            addCriterion("N_FLGANULADO not in", values, "nFlganulado");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoBetween(Short value1, Short value2) {
            addCriterion("N_FLGANULADO between", value1, value2, "nFlganulado");
            return (Criteria) this;
        }

        public Criteria andNFlganuladoNotBetween(Short value1, Short value2) {
            addCriterion("N_FLGANULADO not between", value1, value2, "nFlganulado");
            return (Criteria) this;
        }

        public Criteria andVObservacionIsNull() {
            addCriterion("V_OBSERVACION is null");
            return (Criteria) this;
        }

        public Criteria andVObservacionIsNotNull() {
            addCriterion("V_OBSERVACION is not null");
            return (Criteria) this;
        }

        public Criteria andVObservacionEqualTo(String value) {
            addCriterion("V_OBSERVACION =", value, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionNotEqualTo(String value) {
            addCriterion("V_OBSERVACION <>", value, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionGreaterThan(String value) {
            addCriterion("V_OBSERVACION >", value, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionGreaterThanOrEqualTo(String value) {
            addCriterion("V_OBSERVACION >=", value, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionLessThan(String value) {
            addCriterion("V_OBSERVACION <", value, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionLessThanOrEqualTo(String value) {
            addCriterion("V_OBSERVACION <=", value, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionLike(String value) {
            addCriterion("V_OBSERVACION like", value, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionNotLike(String value) {
            addCriterion("V_OBSERVACION not like", value, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionIn(List<String> values) {
            addCriterion("V_OBSERVACION in", values, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionNotIn(List<String> values) {
            addCriterion("V_OBSERVACION not in", values, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionBetween(String value1, String value2) {
            addCriterion("V_OBSERVACION between", value1, value2, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVObservacionNotBetween(String value1, String value2) {
            addCriterion("V_OBSERVACION not between", value1, value2, "vObservacion");
            return (Criteria) this;
        }

        public Criteria andVNomusuregIsNull() {
            addCriterion("V_NOMUSUREG is null");
            return (Criteria) this;
        }

        public Criteria andVNomusuregIsNotNull() {
            addCriterion("V_NOMUSUREG is not null");
            return (Criteria) this;
        }

        public Criteria andVNomusuregEqualTo(String value) {
            addCriterion("V_NOMUSUREG =", value, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregNotEqualTo(String value) {
            addCriterion("V_NOMUSUREG <>", value, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregGreaterThan(String value) {
            addCriterion("V_NOMUSUREG >", value, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregGreaterThanOrEqualTo(String value) {
            addCriterion("V_NOMUSUREG >=", value, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregLessThan(String value) {
            addCriterion("V_NOMUSUREG <", value, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregLessThanOrEqualTo(String value) {
            addCriterion("V_NOMUSUREG <=", value, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregLike(String value) {
            addCriterion("V_NOMUSUREG like", value, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregNotLike(String value) {
            addCriterion("V_NOMUSUREG not like", value, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregIn(List<String> values) {
            addCriterion("V_NOMUSUREG in", values, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregNotIn(List<String> values) {
            addCriterion("V_NOMUSUREG not in", values, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregBetween(String value1, String value2) {
            addCriterion("V_NOMUSUREG between", value1, value2, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andVNomusuregNotBetween(String value1, String value2) {
            addCriterion("V_NOMUSUREG not between", value1, value2, "vNomusureg");
            return (Criteria) this;
        }

        public Criteria andDFecregIsNull() {
            addCriterion("D_FECREG is null");
            return (Criteria) this;
        }

        public Criteria andDFecregIsNotNull() {
            addCriterion("D_FECREG is not null");
            return (Criteria) this;
        }

        public Criteria andDFecregEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECREG =", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregNotEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECREG <>", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregGreaterThan(Date value) {
            addCriterionForJDBCDate("D_FECREG >", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECREG >=", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregLessThan(Date value) {
            addCriterionForJDBCDate("D_FECREG <", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECREG <=", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECREG in", values, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregNotIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECREG not in", values, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECREG between", value1, value2, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECREG not between", value1, value2, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andVNomusumodIsNull() {
            addCriterion("V_NOMUSUMOD is null");
            return (Criteria) this;
        }

        public Criteria andVNomusumodIsNotNull() {
            addCriterion("V_NOMUSUMOD is not null");
            return (Criteria) this;
        }

        public Criteria andVNomusumodEqualTo(String value) {
            addCriterion("V_NOMUSUMOD =", value, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodNotEqualTo(String value) {
            addCriterion("V_NOMUSUMOD <>", value, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodGreaterThan(String value) {
            addCriterion("V_NOMUSUMOD >", value, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodGreaterThanOrEqualTo(String value) {
            addCriterion("V_NOMUSUMOD >=", value, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodLessThan(String value) {
            addCriterion("V_NOMUSUMOD <", value, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodLessThanOrEqualTo(String value) {
            addCriterion("V_NOMUSUMOD <=", value, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodLike(String value) {
            addCriterion("V_NOMUSUMOD like", value, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodNotLike(String value) {
            addCriterion("V_NOMUSUMOD not like", value, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodIn(List<String> values) {
            addCriterion("V_NOMUSUMOD in", values, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodNotIn(List<String> values) {
            addCriterion("V_NOMUSUMOD not in", values, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodBetween(String value1, String value2) {
            addCriterion("V_NOMUSUMOD between", value1, value2, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andVNomusumodNotBetween(String value1, String value2) {
            addCriterion("V_NOMUSUMOD not between", value1, value2, "vNomusumod");
            return (Criteria) this;
        }

        public Criteria andDFecmodIsNull() {
            addCriterion("D_FECMOD is null");
            return (Criteria) this;
        }

        public Criteria andDFecmodIsNotNull() {
            addCriterion("D_FECMOD is not null");
            return (Criteria) this;
        }

        public Criteria andDFecmodEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECMOD =", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodNotEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECMOD <>", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodGreaterThan(Date value) {
            addCriterionForJDBCDate("D_FECMOD >", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECMOD >=", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodLessThan(Date value) {
            addCriterionForJDBCDate("D_FECMOD <", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECMOD <=", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECMOD in", values, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodNotIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECMOD not in", values, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECMOD between", value1, value2, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECMOD not between", value1, value2, "dFecmod");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated do_not_delete_during_merge Tue Mar 14 12:53:03 COT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRAMITE.TDMVC_CORTE
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}