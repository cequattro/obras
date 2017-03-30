package pe.gob.sunafil.postulacioncas.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RhtbcConvocatoriaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public RhtbcConvocatoriaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
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
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
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

        public Criteria andNCorconvIsNull() {
            addCriterion("N_CORCONV is null");
            return (Criteria) this;
        }

        public Criteria andNCorconvIsNotNull() {
            addCriterion("N_CORCONV is not null");
            return (Criteria) this;
        }

        public Criteria andNCorconvEqualTo(BigDecimal value) {
            addCriterion("N_CORCONV =", value, "nCorconv");
            return (Criteria) this;
        }

        public Criteria andNCorconvNotEqualTo(BigDecimal value) {
            addCriterion("N_CORCONV <>", value, "nCorconv");
            return (Criteria) this;
        }

        public Criteria andNCorconvGreaterThan(BigDecimal value) {
            addCriterion("N_CORCONV >", value, "nCorconv");
            return (Criteria) this;
        }

        public Criteria andNCorconvGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORCONV >=", value, "nCorconv");
            return (Criteria) this;
        }

        public Criteria andNCorconvLessThan(BigDecimal value) {
            addCriterion("N_CORCONV <", value, "nCorconv");
            return (Criteria) this;
        }

        public Criteria andNCorconvLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORCONV <=", value, "nCorconv");
            return (Criteria) this;
        }

        public Criteria andNCorconvIn(List<BigDecimal> values) {
            addCriterion("N_CORCONV in", values, "nCorconv");
            return (Criteria) this;
        }

        public Criteria andNCorconvNotIn(List<BigDecimal> values) {
            addCriterion("N_CORCONV not in", values, "nCorconv");
            return (Criteria) this;
        }

        public Criteria andNCorconvBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORCONV between", value1, value2, "nCorconv");
            return (Criteria) this;
        }

        public Criteria andNCorconvNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORCONV not between", value1, value2, "nCorconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvIsNull() {
            addCriterion("V_NUMCONV is null");
            return (Criteria) this;
        }

        public Criteria andVNumconvIsNotNull() {
            addCriterion("V_NUMCONV is not null");
            return (Criteria) this;
        }

        public Criteria andVNumconvEqualTo(String value) {
            addCriterion("V_NUMCONV =", value, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvNotEqualTo(String value) {
            addCriterion("V_NUMCONV <>", value, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvGreaterThan(String value) {
            addCriterion("V_NUMCONV >", value, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvGreaterThanOrEqualTo(String value) {
            addCriterion("V_NUMCONV >=", value, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvLessThan(String value) {
            addCriterion("V_NUMCONV <", value, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvLessThanOrEqualTo(String value) {
            addCriterion("V_NUMCONV <=", value, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvLike(String value) {
            addCriterion("V_NUMCONV like", value, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvNotLike(String value) {
            addCriterion("V_NUMCONV not like", value, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvIn(List<String> values) {
            addCriterion("V_NUMCONV in", values, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvNotIn(List<String> values) {
            addCriterion("V_NUMCONV not in", values, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvBetween(String value1, String value2) {
            addCriterion("V_NUMCONV between", value1, value2, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVNumconvNotBetween(String value1, String value2) {
            addCriterion("V_NUMCONV not between", value1, value2, "vNumconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvIsNull() {
            addCriterion("V_ANOCONV is null");
            return (Criteria) this;
        }

        public Criteria andVAnoconvIsNotNull() {
            addCriterion("V_ANOCONV is not null");
            return (Criteria) this;
        }

        public Criteria andVAnoconvEqualTo(String value) {
            addCriterion("V_ANOCONV =", value, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvNotEqualTo(String value) {
            addCriterion("V_ANOCONV <>", value, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvGreaterThan(String value) {
            addCriterion("V_ANOCONV >", value, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvGreaterThanOrEqualTo(String value) {
            addCriterion("V_ANOCONV >=", value, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvLessThan(String value) {
            addCriterion("V_ANOCONV <", value, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvLessThanOrEqualTo(String value) {
            addCriterion("V_ANOCONV <=", value, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvLike(String value) {
            addCriterion("V_ANOCONV like", value, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvNotLike(String value) {
            addCriterion("V_ANOCONV not like", value, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvIn(List<String> values) {
            addCriterion("V_ANOCONV in", values, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvNotIn(List<String> values) {
            addCriterion("V_ANOCONV not in", values, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvBetween(String value1, String value2) {
            addCriterion("V_ANOCONV between", value1, value2, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVAnoconvNotBetween(String value1, String value2) {
            addCriterion("V_ANOCONV not between", value1, value2, "vAnoconv");
            return (Criteria) this;
        }

        public Criteria andVSiglaIsNull() {
            addCriterion("V_SIGLA is null");
            return (Criteria) this;
        }

        public Criteria andVSiglaIsNotNull() {
            addCriterion("V_SIGLA is not null");
            return (Criteria) this;
        }

        public Criteria andVSiglaEqualTo(String value) {
            addCriterion("V_SIGLA =", value, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaNotEqualTo(String value) {
            addCriterion("V_SIGLA <>", value, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaGreaterThan(String value) {
            addCriterion("V_SIGLA >", value, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaGreaterThanOrEqualTo(String value) {
            addCriterion("V_SIGLA >=", value, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaLessThan(String value) {
            addCriterion("V_SIGLA <", value, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaLessThanOrEqualTo(String value) {
            addCriterion("V_SIGLA <=", value, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaLike(String value) {
            addCriterion("V_SIGLA like", value, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaNotLike(String value) {
            addCriterion("V_SIGLA not like", value, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaIn(List<String> values) {
            addCriterion("V_SIGLA in", values, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaNotIn(List<String> values) {
            addCriterion("V_SIGLA not in", values, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaBetween(String value1, String value2) {
            addCriterion("V_SIGLA between", value1, value2, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVSiglaNotBetween(String value1, String value2) {
            addCriterion("V_SIGLA not between", value1, value2, "vSigla");
            return (Criteria) this;
        }

        public Criteria andVPuestoIsNull() {
            addCriterion("V_PUESTO is null");
            return (Criteria) this;
        }

        public Criteria andVPuestoIsNotNull() {
            addCriterion("V_PUESTO is not null");
            return (Criteria) this;
        }

        public Criteria andVPuestoEqualTo(String value) {
            addCriterion("V_PUESTO =", value, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoNotEqualTo(String value) {
            addCriterion("V_PUESTO <>", value, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoGreaterThan(String value) {
            addCriterion("V_PUESTO >", value, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoGreaterThanOrEqualTo(String value) {
            addCriterion("V_PUESTO >=", value, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoLessThan(String value) {
            addCriterion("V_PUESTO <", value, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoLessThanOrEqualTo(String value) {
            addCriterion("V_PUESTO <=", value, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoLike(String value) {
            addCriterion("V_PUESTO like", value, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoNotLike(String value) {
            addCriterion("V_PUESTO not like", value, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoIn(List<String> values) {
            addCriterion("V_PUESTO in", values, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoNotIn(List<String> values) {
            addCriterion("V_PUESTO not in", values, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoBetween(String value1, String value2) {
            addCriterion("V_PUESTO between", value1, value2, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVPuestoNotBetween(String value1, String value2) {
            addCriterion("V_PUESTO not between", value1, value2, "vPuesto");
            return (Criteria) this;
        }

        public Criteria andVFlgactIsNull() {
            addCriterion("V_FLGACT is null");
            return (Criteria) this;
        }

        public Criteria andVFlgactIsNotNull() {
            addCriterion("V_FLGACT is not null");
            return (Criteria) this;
        }

        public Criteria andVFlgactEqualTo(String value) {
            addCriterion("V_FLGACT =", value, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactNotEqualTo(String value) {
            addCriterion("V_FLGACT <>", value, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactGreaterThan(String value) {
            addCriterion("V_FLGACT >", value, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactGreaterThanOrEqualTo(String value) {
            addCriterion("V_FLGACT >=", value, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactLessThan(String value) {
            addCriterion("V_FLGACT <", value, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactLessThanOrEqualTo(String value) {
            addCriterion("V_FLGACT <=", value, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactLike(String value) {
            addCriterion("V_FLGACT like", value, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactNotLike(String value) {
            addCriterion("V_FLGACT not like", value, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactIn(List<String> values) {
            addCriterion("V_FLGACT in", values, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactNotIn(List<String> values) {
            addCriterion("V_FLGACT not in", values, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactBetween(String value1, String value2) {
            addCriterion("V_FLGACT between", value1, value2, "vFlgact");
            return (Criteria) this;
        }

        public Criteria andVFlgactNotBetween(String value1, String value2) {
            addCriterion("V_FLGACT not between", value1, value2, "vFlgact");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated do_not_delete_during_merge Wed Mar 15 11:22:42 COT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHTBC_CONVOCATORIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
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