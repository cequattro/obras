package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SitbSeguroExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    public SitbSeguroExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
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
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
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

        public Criteria andNCodseguroIsNull() {
            addCriterion("N_CODSEGURO is null");
            return (Criteria) this;
        }

        public Criteria andNCodseguroIsNotNull() {
            addCriterion("N_CODSEGURO is not null");
            return (Criteria) this;
        }

        public Criteria andNCodseguroEqualTo(BigDecimal value) {
            addCriterion("N_CODSEGURO =", value, "nCodseguro");
            return (Criteria) this;
        }

        public Criteria andNCodseguroNotEqualTo(BigDecimal value) {
            addCriterion("N_CODSEGURO <>", value, "nCodseguro");
            return (Criteria) this;
        }

        public Criteria andNCodseguroGreaterThan(BigDecimal value) {
            addCriterion("N_CODSEGURO >", value, "nCodseguro");
            return (Criteria) this;
        }

        public Criteria andNCodseguroGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODSEGURO >=", value, "nCodseguro");
            return (Criteria) this;
        }

        public Criteria andNCodseguroLessThan(BigDecimal value) {
            addCriterion("N_CODSEGURO <", value, "nCodseguro");
            return (Criteria) this;
        }

        public Criteria andNCodseguroLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODSEGURO <=", value, "nCodseguro");
            return (Criteria) this;
        }

        public Criteria andNCodseguroIn(List<BigDecimal> values) {
            addCriterion("N_CODSEGURO in", values, "nCodseguro");
            return (Criteria) this;
        }

        public Criteria andNCodseguroNotIn(List<BigDecimal> values) {
            addCriterion("N_CODSEGURO not in", values, "nCodseguro");
            return (Criteria) this;
        }

        public Criteria andNCodseguroBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODSEGURO between", value1, value2, "nCodseguro");
            return (Criteria) this;
        }

        public Criteria andNCodseguroNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODSEGURO not between", value1, value2, "nCodseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroIsNull() {
            addCriterion("V_DESSEGURO is null");
            return (Criteria) this;
        }

        public Criteria andVDesseguroIsNotNull() {
            addCriterion("V_DESSEGURO is not null");
            return (Criteria) this;
        }

        public Criteria andVDesseguroEqualTo(String value) {
            addCriterion("V_DESSEGURO =", value, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroNotEqualTo(String value) {
            addCriterion("V_DESSEGURO <>", value, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroGreaterThan(String value) {
            addCriterion("V_DESSEGURO >", value, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESSEGURO >=", value, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroLessThan(String value) {
            addCriterion("V_DESSEGURO <", value, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroLessThanOrEqualTo(String value) {
            addCriterion("V_DESSEGURO <=", value, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroLike(String value) {
            addCriterion("V_DESSEGURO like", value, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroNotLike(String value) {
            addCriterion("V_DESSEGURO not like", value, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroIn(List<String> values) {
            addCriterion("V_DESSEGURO in", values, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroNotIn(List<String> values) {
            addCriterion("V_DESSEGURO not in", values, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroBetween(String value1, String value2) {
            addCriterion("V_DESSEGURO between", value1, value2, "vDesseguro");
            return (Criteria) this;
        }

        public Criteria andVDesseguroNotBetween(String value1, String value2) {
            addCriterion("V_DESSEGURO not between", value1, value2, "vDesseguro");
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

        public Criteria andNCortipsegIsNull() {
            addCriterion("N_CORTIPSEG is null");
            return (Criteria) this;
        }

        public Criteria andNCortipsegIsNotNull() {
            addCriterion("N_CORTIPSEG is not null");
            return (Criteria) this;
        }

        public Criteria andNCortipsegEqualTo(BigDecimal value) {
            addCriterion("N_CORTIPSEG =", value, "nCortipseg");
            return (Criteria) this;
        }

        public Criteria andNCortipsegNotEqualTo(BigDecimal value) {
            addCriterion("N_CORTIPSEG <>", value, "nCortipseg");
            return (Criteria) this;
        }

        public Criteria andNCortipsegGreaterThan(BigDecimal value) {
            addCriterion("N_CORTIPSEG >", value, "nCortipseg");
            return (Criteria) this;
        }

        public Criteria andNCortipsegGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORTIPSEG >=", value, "nCortipseg");
            return (Criteria) this;
        }

        public Criteria andNCortipsegLessThan(BigDecimal value) {
            addCriterion("N_CORTIPSEG <", value, "nCortipseg");
            return (Criteria) this;
        }

        public Criteria andNCortipsegLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORTIPSEG <=", value, "nCortipseg");
            return (Criteria) this;
        }

        public Criteria andNCortipsegIn(List<BigDecimal> values) {
            addCriterion("N_CORTIPSEG in", values, "nCortipseg");
            return (Criteria) this;
        }

        public Criteria andNCortipsegNotIn(List<BigDecimal> values) {
            addCriterion("N_CORTIPSEG not in", values, "nCortipseg");
            return (Criteria) this;
        }

        public Criteria andNCortipsegBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORTIPSEG between", value1, value2, "nCortipseg");
            return (Criteria) this;
        }

        public Criteria andNCortipsegNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORTIPSEG not between", value1, value2, "nCortipseg");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated do_not_delete_during_merge Wed Mar 22 14:51:16 COT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SIMINTRA1.SITB_SEGURO
     *
     * @mbggenerated Wed Mar 22 14:51:16 COT 2017
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