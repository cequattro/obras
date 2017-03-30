package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class SitbEstadocivilExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public SitbEstadocivilExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
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
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
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
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
     *
     * @mbggenerated Thu Mar 16 10:52:59 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
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
     * This class corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
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

        public Criteria andVCodestcivIsNull() {
            addCriterion("V_CODESTCIV is null");
            return (Criteria) this;
        }

        public Criteria andVCodestcivIsNotNull() {
            addCriterion("V_CODESTCIV is not null");
            return (Criteria) this;
        }

        public Criteria andVCodestcivEqualTo(String value) {
            addCriterion("V_CODESTCIV =", value, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivNotEqualTo(String value) {
            addCriterion("V_CODESTCIV <>", value, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivGreaterThan(String value) {
            addCriterion("V_CODESTCIV >", value, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODESTCIV >=", value, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivLessThan(String value) {
            addCriterion("V_CODESTCIV <", value, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivLessThanOrEqualTo(String value) {
            addCriterion("V_CODESTCIV <=", value, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivLike(String value) {
            addCriterion("V_CODESTCIV like", value, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivNotLike(String value) {
            addCriterion("V_CODESTCIV not like", value, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivIn(List<String> values) {
            addCriterion("V_CODESTCIV in", values, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivNotIn(List<String> values) {
            addCriterion("V_CODESTCIV not in", values, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivBetween(String value1, String value2) {
            addCriterion("V_CODESTCIV between", value1, value2, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVCodestcivNotBetween(String value1, String value2) {
            addCriterion("V_CODESTCIV not between", value1, value2, "vCodestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivIsNull() {
            addCriterion("V_DESESTCIV is null");
            return (Criteria) this;
        }

        public Criteria andVDesestcivIsNotNull() {
            addCriterion("V_DESESTCIV is not null");
            return (Criteria) this;
        }

        public Criteria andVDesestcivEqualTo(String value) {
            addCriterion("V_DESESTCIV =", value, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivNotEqualTo(String value) {
            addCriterion("V_DESESTCIV <>", value, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivGreaterThan(String value) {
            addCriterion("V_DESESTCIV >", value, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESESTCIV >=", value, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivLessThan(String value) {
            addCriterion("V_DESESTCIV <", value, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivLessThanOrEqualTo(String value) {
            addCriterion("V_DESESTCIV <=", value, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivLike(String value) {
            addCriterion("V_DESESTCIV like", value, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivNotLike(String value) {
            addCriterion("V_DESESTCIV not like", value, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivIn(List<String> values) {
            addCriterion("V_DESESTCIV in", values, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivNotIn(List<String> values) {
            addCriterion("V_DESESTCIV not in", values, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivBetween(String value1, String value2) {
            addCriterion("V_DESESTCIV between", value1, value2, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVDesestcivNotBetween(String value1, String value2) {
            addCriterion("V_DESESTCIV not between", value1, value2, "vDesestciv");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminIsNull() {
            addCriterion("V_FLGSUNMIN is null");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminIsNotNull() {
            addCriterion("V_FLGSUNMIN is not null");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminEqualTo(String value) {
            addCriterion("V_FLGSUNMIN =", value, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminNotEqualTo(String value) {
            addCriterion("V_FLGSUNMIN <>", value, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminGreaterThan(String value) {
            addCriterion("V_FLGSUNMIN >", value, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminGreaterThanOrEqualTo(String value) {
            addCriterion("V_FLGSUNMIN >=", value, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminLessThan(String value) {
            addCriterion("V_FLGSUNMIN <", value, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminLessThanOrEqualTo(String value) {
            addCriterion("V_FLGSUNMIN <=", value, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminLike(String value) {
            addCriterion("V_FLGSUNMIN like", value, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminNotLike(String value) {
            addCriterion("V_FLGSUNMIN not like", value, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminIn(List<String> values) {
            addCriterion("V_FLGSUNMIN in", values, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminNotIn(List<String> values) {
            addCriterion("V_FLGSUNMIN not in", values, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminBetween(String value1, String value2) {
            addCriterion("V_FLGSUNMIN between", value1, value2, "vFlgsunmin");
            return (Criteria) this;
        }

        public Criteria andVFlgsunminNotBetween(String value1, String value2) {
            addCriterion("V_FLGSUNMIN not between", value1, value2, "vFlgsunmin");
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
     * This class corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
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
     * This class corresponds to the database table SIMINTRA1.SITB_ESTADOCIVIL
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