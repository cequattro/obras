package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SitbProfesionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public SitbProfesionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
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
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
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

        public Criteria andVCodprofIsNull() {
            addCriterion("V_CODPROF is null");
            return (Criteria) this;
        }

        public Criteria andVCodprofIsNotNull() {
            addCriterion("V_CODPROF is not null");
            return (Criteria) this;
        }

        public Criteria andVCodprofEqualTo(String value) {
            addCriterion("V_CODPROF =", value, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofNotEqualTo(String value) {
            addCriterion("V_CODPROF <>", value, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofGreaterThan(String value) {
            addCriterion("V_CODPROF >", value, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODPROF >=", value, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofLessThan(String value) {
            addCriterion("V_CODPROF <", value, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofLessThanOrEqualTo(String value) {
            addCriterion("V_CODPROF <=", value, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofLike(String value) {
            addCriterion("V_CODPROF like", value, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofNotLike(String value) {
            addCriterion("V_CODPROF not like", value, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofIn(List<String> values) {
            addCriterion("V_CODPROF in", values, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofNotIn(List<String> values) {
            addCriterion("V_CODPROF not in", values, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofBetween(String value1, String value2) {
            addCriterion("V_CODPROF between", value1, value2, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVCodprofNotBetween(String value1, String value2) {
            addCriterion("V_CODPROF not between", value1, value2, "vCodprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofIsNull() {
            addCriterion("V_DESPROF is null");
            return (Criteria) this;
        }

        public Criteria andVDesprofIsNotNull() {
            addCriterion("V_DESPROF is not null");
            return (Criteria) this;
        }

        public Criteria andVDesprofEqualTo(String value) {
            addCriterion("V_DESPROF =", value, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofNotEqualTo(String value) {
            addCriterion("V_DESPROF <>", value, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofGreaterThan(String value) {
            addCriterion("V_DESPROF >", value, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESPROF >=", value, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofLessThan(String value) {
            addCriterion("V_DESPROF <", value, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofLessThanOrEqualTo(String value) {
            addCriterion("V_DESPROF <=", value, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofLike(String value) {
            addCriterion("V_DESPROF like", value, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofNotLike(String value) {
            addCriterion("V_DESPROF not like", value, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofIn(List<String> values) {
            addCriterion("V_DESPROF in", values, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofNotIn(List<String> values) {
            addCriterion("V_DESPROF not in", values, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofBetween(String value1, String value2) {
            addCriterion("V_DESPROF between", value1, value2, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andVDesprofNotBetween(String value1, String value2) {
            addCriterion("V_DESPROF not between", value1, value2, "vDesprof");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminIsNull() {
            addCriterion("N_FLGSUNMIN is null");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminIsNotNull() {
            addCriterion("N_FLGSUNMIN is not null");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminEqualTo(BigDecimal value) {
            addCriterion("N_FLGSUNMIN =", value, "nFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminNotEqualTo(BigDecimal value) {
            addCriterion("N_FLGSUNMIN <>", value, "nFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminGreaterThan(BigDecimal value) {
            addCriterion("N_FLGSUNMIN >", value, "nFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_FLGSUNMIN >=", value, "nFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminLessThan(BigDecimal value) {
            addCriterion("N_FLGSUNMIN <", value, "nFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_FLGSUNMIN <=", value, "nFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminIn(List<BigDecimal> values) {
            addCriterion("N_FLGSUNMIN in", values, "nFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminNotIn(List<BigDecimal> values) {
            addCriterion("N_FLGSUNMIN not in", values, "nFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_FLGSUNMIN between", value1, value2, "nFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andNFlgsunminNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_FLGSUNMIN not between", value1, value2, "nFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVCodggprofIsNull() {
            addCriterion("V_CODGGPROF is null");
            return (Criteria) this;
        }

        public Criteria andVCodggprofIsNotNull() {
            addCriterion("V_CODGGPROF is not null");
            return (Criteria) this;
        }

        public Criteria andVCodggprofEqualTo(String value) {
            addCriterion("V_CODGGPROF =", value, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofNotEqualTo(String value) {
            addCriterion("V_CODGGPROF <>", value, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofGreaterThan(String value) {
            addCriterion("V_CODGGPROF >", value, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODGGPROF >=", value, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofLessThan(String value) {
            addCriterion("V_CODGGPROF <", value, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofLessThanOrEqualTo(String value) {
            addCriterion("V_CODGGPROF <=", value, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofLike(String value) {
            addCriterion("V_CODGGPROF like", value, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofNotLike(String value) {
            addCriterion("V_CODGGPROF not like", value, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofIn(List<String> values) {
            addCriterion("V_CODGGPROF in", values, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofNotIn(List<String> values) {
            addCriterion("V_CODGGPROF not in", values, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofBetween(String value1, String value2) {
            addCriterion("V_CODGGPROF between", value1, value2, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVCodggprofNotBetween(String value1, String value2) {
            addCriterion("V_CODGGPROF not between", value1, value2, "vCodggprof");
            return (Criteria) this;
        }

        public Criteria andVFlgineiIsNull() {
            addCriterion("V_FLGINEI is null");
            return (Criteria) this;
        }

        public Criteria andVFlgineiIsNotNull() {
            addCriterion("V_FLGINEI is not null");
            return (Criteria) this;
        }

        public Criteria andVFlgineiEqualTo(String value) {
            addCriterion("V_FLGINEI =", value, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiNotEqualTo(String value) {
            addCriterion("V_FLGINEI <>", value, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiGreaterThan(String value) {
            addCriterion("V_FLGINEI >", value, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiGreaterThanOrEqualTo(String value) {
            addCriterion("V_FLGINEI >=", value, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiLessThan(String value) {
            addCriterion("V_FLGINEI <", value, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiLessThanOrEqualTo(String value) {
            addCriterion("V_FLGINEI <=", value, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiLike(String value) {
            addCriterion("V_FLGINEI like", value, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiNotLike(String value) {
            addCriterion("V_FLGINEI not like", value, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiIn(List<String> values) {
            addCriterion("V_FLGINEI in", values, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiNotIn(List<String> values) {
            addCriterion("V_FLGINEI not in", values, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiBetween(String value1, String value2) {
            addCriterion("V_FLGINEI between", value1, value2, "vFlginei");
            return (Criteria) this;
        }

        public Criteria andVFlgineiNotBetween(String value1, String value2) {
            addCriterion("V_FLGINEI not between", value1, value2, "vFlginei");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated do_not_delete_during_merge Thu Mar 16 10:52:59 COT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SIMINTRA1.SITB_PROFESION
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
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