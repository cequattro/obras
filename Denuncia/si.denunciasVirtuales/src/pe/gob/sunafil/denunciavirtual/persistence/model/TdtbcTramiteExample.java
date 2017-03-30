package pe.gob.sunafil.denunciavirtual.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TdtbcTramiteExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public TdtbcTramiteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
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
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
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
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
     *
     * @mbggenerated Fri Apr 22 10:45:50 COT 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBC_TRAMITE
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
     * This class corresponds to the database table TRAMITE.TDTBC_TRAMITE
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

        public Criteria andNCodtramIsNull() {
            addCriterion("N_CODTRAM is null");
            return (Criteria) this;
        }

        public Criteria andNCodtramIsNotNull() {
            addCriterion("N_CODTRAM is not null");
            return (Criteria) this;
        }

        public Criteria andNCodtramEqualTo(BigDecimal value) {
            addCriterion("N_CODTRAM =", value, "nCodtram");
            return (Criteria) this;
        }

        public Criteria andNCodtramNotEqualTo(BigDecimal value) {
            addCriterion("N_CODTRAM <>", value, "nCodtram");
            return (Criteria) this;
        }

        public Criteria andNCodtramGreaterThan(BigDecimal value) {
            addCriterion("N_CODTRAM >", value, "nCodtram");
            return (Criteria) this;
        }

        public Criteria andNCodtramGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODTRAM >=", value, "nCodtram");
            return (Criteria) this;
        }

        public Criteria andNCodtramLessThan(BigDecimal value) {
            addCriterion("N_CODTRAM <", value, "nCodtram");
            return (Criteria) this;
        }

        public Criteria andNCodtramLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODTRAM <=", value, "nCodtram");
            return (Criteria) this;
        }

        public Criteria andNCodtramIn(List<BigDecimal> values) {
            addCriterion("N_CODTRAM in", values, "nCodtram");
            return (Criteria) this;
        }

        public Criteria andNCodtramNotIn(List<BigDecimal> values) {
            addCriterion("N_CODTRAM not in", values, "nCodtram");
            return (Criteria) this;
        }

        public Criteria andNCodtramBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODTRAM between", value1, value2, "nCodtram");
            return (Criteria) this;
        }

        public Criteria andNCodtramNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODTRAM not between", value1, value2, "nCodtram");
            return (Criteria) this;
        }

        public Criteria andVDestramIsNull() {
            addCriterion("V_DESTRAM is null");
            return (Criteria) this;
        }

        public Criteria andVDestramIsNotNull() {
            addCriterion("V_DESTRAM is not null");
            return (Criteria) this;
        }

        public Criteria andVDestramEqualTo(String value) {
            addCriterion("V_DESTRAM =", value, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramNotEqualTo(String value) {
            addCriterion("V_DESTRAM <>", value, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramGreaterThan(String value) {
            addCriterion("V_DESTRAM >", value, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESTRAM >=", value, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramLessThan(String value) {
            addCriterion("V_DESTRAM <", value, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramLessThanOrEqualTo(String value) {
            addCriterion("V_DESTRAM <=", value, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramLike(String value) {
            addCriterion("V_DESTRAM like", value, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramNotLike(String value) {
            addCriterion("V_DESTRAM not like", value, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramIn(List<String> values) {
            addCriterion("V_DESTRAM in", values, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramNotIn(List<String> values) {
            addCriterion("V_DESTRAM not in", values, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramBetween(String value1, String value2) {
            addCriterion("V_DESTRAM between", value1, value2, "vDestram");
            return (Criteria) this;
        }

        public Criteria andVDestramNotBetween(String value1, String value2) {
            addCriterion("V_DESTRAM not between", value1, value2, "vDestram");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRAMITE.TDTBC_TRAMITE
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
     * This class corresponds to the database table TRAMITE.TDTBC_TRAMITE
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