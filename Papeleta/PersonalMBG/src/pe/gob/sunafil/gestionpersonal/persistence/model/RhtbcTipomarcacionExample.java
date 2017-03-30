package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class RhtbcTipomarcacionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public RhtbcTipomarcacionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
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
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
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
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
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
     * This class corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
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

        public Criteria andNCodtipoIsNull() {
            addCriterion("N_CODTIPO is null");
            return (Criteria) this;
        }

        public Criteria andNCodtipoIsNotNull() {
            addCriterion("N_CODTIPO is not null");
            return (Criteria) this;
        }

        public Criteria andNCodtipoEqualTo(Short value) {
            addCriterion("N_CODTIPO =", value, "nCodtipo");
            return (Criteria) this;
        }

        public Criteria andNCodtipoNotEqualTo(Short value) {
            addCriterion("N_CODTIPO <>", value, "nCodtipo");
            return (Criteria) this;
        }

        public Criteria andNCodtipoGreaterThan(Short value) {
            addCriterion("N_CODTIPO >", value, "nCodtipo");
            return (Criteria) this;
        }

        public Criteria andNCodtipoGreaterThanOrEqualTo(Short value) {
            addCriterion("N_CODTIPO >=", value, "nCodtipo");
            return (Criteria) this;
        }

        public Criteria andNCodtipoLessThan(Short value) {
            addCriterion("N_CODTIPO <", value, "nCodtipo");
            return (Criteria) this;
        }

        public Criteria andNCodtipoLessThanOrEqualTo(Short value) {
            addCriterion("N_CODTIPO <=", value, "nCodtipo");
            return (Criteria) this;
        }

        public Criteria andNCodtipoIn(List<Short> values) {
            addCriterion("N_CODTIPO in", values, "nCodtipo");
            return (Criteria) this;
        }

        public Criteria andNCodtipoNotIn(List<Short> values) {
            addCriterion("N_CODTIPO not in", values, "nCodtipo");
            return (Criteria) this;
        }

        public Criteria andNCodtipoBetween(Short value1, Short value2) {
            addCriterion("N_CODTIPO between", value1, value2, "nCodtipo");
            return (Criteria) this;
        }

        public Criteria andNCodtipoNotBetween(Short value1, Short value2) {
            addCriterion("N_CODTIPO not between", value1, value2, "nCodtipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoIsNull() {
            addCriterion("V_DESTIPO is null");
            return (Criteria) this;
        }

        public Criteria andVDestipoIsNotNull() {
            addCriterion("V_DESTIPO is not null");
            return (Criteria) this;
        }

        public Criteria andVDestipoEqualTo(String value) {
            addCriterion("V_DESTIPO =", value, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoNotEqualTo(String value) {
            addCriterion("V_DESTIPO <>", value, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoGreaterThan(String value) {
            addCriterion("V_DESTIPO >", value, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESTIPO >=", value, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoLessThan(String value) {
            addCriterion("V_DESTIPO <", value, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoLessThanOrEqualTo(String value) {
            addCriterion("V_DESTIPO <=", value, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoLike(String value) {
            addCriterion("V_DESTIPO like", value, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoNotLike(String value) {
            addCriterion("V_DESTIPO not like", value, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoIn(List<String> values) {
            addCriterion("V_DESTIPO in", values, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoNotIn(List<String> values) {
            addCriterion("V_DESTIPO not in", values, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoBetween(String value1, String value2) {
            addCriterion("V_DESTIPO between", value1, value2, "vDestipo");
            return (Criteria) this;
        }

        public Criteria andVDestipoNotBetween(String value1, String value2) {
            addCriterion("V_DESTIPO not between", value1, value2, "vDestipo");
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
     * This class corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
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
     * This class corresponds to the database table RRHHSYS.RHTBC_TIPOMARCACION
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