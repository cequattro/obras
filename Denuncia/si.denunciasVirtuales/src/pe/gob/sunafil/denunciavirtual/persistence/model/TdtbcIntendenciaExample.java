package pe.gob.sunafil.denunciavirtual.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TdtbcIntendenciaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public TdtbcIntendenciaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
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
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
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

        public Criteria andNNumintIsNull() {
            addCriterion("N_NUMINT is null");
            return (Criteria) this;
        }

        public Criteria andNNumintIsNotNull() {
            addCriterion("N_NUMINT is not null");
            return (Criteria) this;
        }

        public Criteria andNNumintEqualTo(BigDecimal value) {
            addCriterion("N_NUMINT =", value, "nNumint");
            return (Criteria) this;
        }

        public Criteria andNNumintNotEqualTo(BigDecimal value) {
            addCriterion("N_NUMINT <>", value, "nNumint");
            return (Criteria) this;
        }

        public Criteria andNNumintGreaterThan(BigDecimal value) {
            addCriterion("N_NUMINT >", value, "nNumint");
            return (Criteria) this;
        }

        public Criteria andNNumintGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_NUMINT >=", value, "nNumint");
            return (Criteria) this;
        }

        public Criteria andNNumintLessThan(BigDecimal value) {
            addCriterion("N_NUMINT <", value, "nNumint");
            return (Criteria) this;
        }

        public Criteria andNNumintLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_NUMINT <=", value, "nNumint");
            return (Criteria) this;
        }

        public Criteria andNNumintIn(List<BigDecimal> values) {
            addCriterion("N_NUMINT in", values, "nNumint");
            return (Criteria) this;
        }

        public Criteria andNNumintNotIn(List<BigDecimal> values) {
            addCriterion("N_NUMINT not in", values, "nNumint");
            return (Criteria) this;
        }

        public Criteria andNNumintBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_NUMINT between", value1, value2, "nNumint");
            return (Criteria) this;
        }

        public Criteria andNNumintNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_NUMINT not between", value1, value2, "nNumint");
            return (Criteria) this;
        }

        public Criteria andVDesintIsNull() {
            addCriterion("V_DESINT is null");
            return (Criteria) this;
        }

        public Criteria andVDesintIsNotNull() {
            addCriterion("V_DESINT is not null");
            return (Criteria) this;
        }

        public Criteria andVDesintEqualTo(String value) {
            addCriterion("V_DESINT =", value, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintNotEqualTo(String value) {
            addCriterion("V_DESINT <>", value, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintGreaterThan(String value) {
            addCriterion("V_DESINT >", value, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESINT >=", value, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintLessThan(String value) {
            addCriterion("V_DESINT <", value, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintLessThanOrEqualTo(String value) {
            addCriterion("V_DESINT <=", value, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintLike(String value) {
            addCriterion("V_DESINT like", value, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintNotLike(String value) {
            addCriterion("V_DESINT not like", value, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintIn(List<String> values) {
            addCriterion("V_DESINT in", values, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintNotIn(List<String> values) {
            addCriterion("V_DESINT not in", values, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintBetween(String value1, String value2) {
            addCriterion("V_DESINT between", value1, value2, "vDesint");
            return (Criteria) this;
        }

        public Criteria andVDesintNotBetween(String value1, String value2) {
            addCriterion("V_DESINT not between", value1, value2, "vDesint");
            return (Criteria) this;
        }

        public Criteria andNFlgactIsNull() {
            addCriterion("N_FLGACT is null");
            return (Criteria) this;
        }

        public Criteria andNFlgactIsNotNull() {
            addCriterion("N_FLGACT is not null");
            return (Criteria) this;
        }

        public Criteria andNFlgactEqualTo(BigDecimal value) {
            addCriterion("N_FLGACT =", value, "nFlgact");
            return (Criteria) this;
        }

        public Criteria andNFlgactNotEqualTo(BigDecimal value) {
            addCriterion("N_FLGACT <>", value, "nFlgact");
            return (Criteria) this;
        }

        public Criteria andNFlgactGreaterThan(BigDecimal value) {
            addCriterion("N_FLGACT >", value, "nFlgact");
            return (Criteria) this;
        }

        public Criteria andNFlgactGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_FLGACT >=", value, "nFlgact");
            return (Criteria) this;
        }

        public Criteria andNFlgactLessThan(BigDecimal value) {
            addCriterion("N_FLGACT <", value, "nFlgact");
            return (Criteria) this;
        }

        public Criteria andNFlgactLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_FLGACT <=", value, "nFlgact");
            return (Criteria) this;
        }

        public Criteria andNFlgactIn(List<BigDecimal> values) {
            addCriterion("N_FLGACT in", values, "nFlgact");
            return (Criteria) this;
        }

        public Criteria andNFlgactNotIn(List<BigDecimal> values) {
            addCriterion("N_FLGACT not in", values, "nFlgact");
            return (Criteria) this;
        }

        public Criteria andNFlgactBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_FLGACT between", value1, value2, "nFlgact");
            return (Criteria) this;
        }

        public Criteria andNFlgactNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_FLGACT not between", value1, value2, "nFlgact");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdIsNull() {
            addCriterion("N_NUMDEPUTD is null");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdIsNotNull() {
            addCriterion("N_NUMDEPUTD is not null");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdEqualTo(BigDecimal value) {
            addCriterion("N_NUMDEPUTD =", value, "nNumdeputd");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdNotEqualTo(BigDecimal value) {
            addCriterion("N_NUMDEPUTD <>", value, "nNumdeputd");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdGreaterThan(BigDecimal value) {
            addCriterion("N_NUMDEPUTD >", value, "nNumdeputd");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_NUMDEPUTD >=", value, "nNumdeputd");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdLessThan(BigDecimal value) {
            addCriterion("N_NUMDEPUTD <", value, "nNumdeputd");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_NUMDEPUTD <=", value, "nNumdeputd");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdIn(List<BigDecimal> values) {
            addCriterion("N_NUMDEPUTD in", values, "nNumdeputd");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdNotIn(List<BigDecimal> values) {
            addCriterion("N_NUMDEPUTD not in", values, "nNumdeputd");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_NUMDEPUTD between", value1, value2, "nNumdeputd");
            return (Criteria) this;
        }

        public Criteria andNNumdeputdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_NUMDEPUTD not between", value1, value2, "nNumdeputd");
            return (Criteria) this;
        }

        public Criteria andVUbigeoIsNull() {
            addCriterion("V_UBIGEO is null");
            return (Criteria) this;
        }

        public Criteria andVUbigeoIsNotNull() {
            addCriterion("V_UBIGEO is not null");
            return (Criteria) this;
        }

        public Criteria andVUbigeoEqualTo(String value) {
            addCriterion("V_UBIGEO =", value, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoNotEqualTo(String value) {
            addCriterion("V_UBIGEO <>", value, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoGreaterThan(String value) {
            addCriterion("V_UBIGEO >", value, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoGreaterThanOrEqualTo(String value) {
            addCriterion("V_UBIGEO >=", value, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoLessThan(String value) {
            addCriterion("V_UBIGEO <", value, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoLessThanOrEqualTo(String value) {
            addCriterion("V_UBIGEO <=", value, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoLike(String value) {
            addCriterion("V_UBIGEO like", value, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoNotLike(String value) {
            addCriterion("V_UBIGEO not like", value, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoIn(List<String> values) {
            addCriterion("V_UBIGEO in", values, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoNotIn(List<String> values) {
            addCriterion("V_UBIGEO not in", values, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoBetween(String value1, String value2) {
            addCriterion("V_UBIGEO between", value1, value2, "vUbigeo");
            return (Criteria) this;
        }

        public Criteria andVUbigeoNotBetween(String value1, String value2) {
            addCriterion("V_UBIGEO not between", value1, value2, "vUbigeo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated do_not_delete_during_merge Fri Apr 22 10:45:50 COT 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRAMITE.TDTBC_INTENDENCIA
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
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