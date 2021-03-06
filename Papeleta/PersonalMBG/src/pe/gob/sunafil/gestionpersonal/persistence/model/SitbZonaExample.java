package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SitbZonaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public SitbZonaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
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
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
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

        public Criteria andVCodzonaIsNull() {
            addCriterion("V_CODZONA is null");
            return (Criteria) this;
        }

        public Criteria andVCodzonaIsNotNull() {
            addCriterion("V_CODZONA is not null");
            return (Criteria) this;
        }

        public Criteria andVCodzonaEqualTo(String value) {
            addCriterion("V_CODZONA =", value, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaNotEqualTo(String value) {
            addCriterion("V_CODZONA <>", value, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaGreaterThan(String value) {
            addCriterion("V_CODZONA >", value, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODZONA >=", value, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaLessThan(String value) {
            addCriterion("V_CODZONA <", value, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaLessThanOrEqualTo(String value) {
            addCriterion("V_CODZONA <=", value, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaLike(String value) {
            addCriterion("V_CODZONA like", value, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaNotLike(String value) {
            addCriterion("V_CODZONA not like", value, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaIn(List<String> values) {
            addCriterion("V_CODZONA in", values, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaNotIn(List<String> values) {
            addCriterion("V_CODZONA not in", values, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaBetween(String value1, String value2) {
            addCriterion("V_CODZONA between", value1, value2, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVCodzonaNotBetween(String value1, String value2) {
            addCriterion("V_CODZONA not between", value1, value2, "vCodzona");
            return (Criteria) this;
        }

        public Criteria andVDeszonIsNull() {
            addCriterion("V_DESZON is null");
            return (Criteria) this;
        }

        public Criteria andVDeszonIsNotNull() {
            addCriterion("V_DESZON is not null");
            return (Criteria) this;
        }

        public Criteria andVDeszonEqualTo(String value) {
            addCriterion("V_DESZON =", value, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonNotEqualTo(String value) {
            addCriterion("V_DESZON <>", value, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonGreaterThan(String value) {
            addCriterion("V_DESZON >", value, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESZON >=", value, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonLessThan(String value) {
            addCriterion("V_DESZON <", value, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonLessThanOrEqualTo(String value) {
            addCriterion("V_DESZON <=", value, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonLike(String value) {
            addCriterion("V_DESZON like", value, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonNotLike(String value) {
            addCriterion("V_DESZON not like", value, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonIn(List<String> values) {
            addCriterion("V_DESZON in", values, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonNotIn(List<String> values) {
            addCriterion("V_DESZON not in", values, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonBetween(String value1, String value2) {
            addCriterion("V_DESZON between", value1, value2, "vDeszon");
            return (Criteria) this;
        }

        public Criteria andVDeszonNotBetween(String value1, String value2) {
            addCriterion("V_DESZON not between", value1, value2, "vDeszon");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated do_not_delete_during_merge Thu Mar 30 08:50:03 COT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SIMINTRA1.SITB_ZONA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
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