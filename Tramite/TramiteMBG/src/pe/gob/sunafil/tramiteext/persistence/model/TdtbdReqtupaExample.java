package pe.gob.sunafil.tramiteext.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class TdtbdReqtupaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public TdtbdReqtupaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
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
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
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
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRAMITE.TDTBD_REQTUPA
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
     * This class corresponds to the database table TRAMITE.TDTBD_REQTUPA
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

        public Criteria andNNumgrupoIsNull() {
            addCriterion("N_NUMGRUPO is null");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoIsNotNull() {
            addCriterion("N_NUMGRUPO is not null");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoEqualTo(Short value) {
            addCriterion("N_NUMGRUPO =", value, "nNumgrupo");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoNotEqualTo(Short value) {
            addCriterion("N_NUMGRUPO <>", value, "nNumgrupo");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoGreaterThan(Short value) {
            addCriterion("N_NUMGRUPO >", value, "nNumgrupo");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoGreaterThanOrEqualTo(Short value) {
            addCriterion("N_NUMGRUPO >=", value, "nNumgrupo");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoLessThan(Short value) {
            addCriterion("N_NUMGRUPO <", value, "nNumgrupo");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoLessThanOrEqualTo(Short value) {
            addCriterion("N_NUMGRUPO <=", value, "nNumgrupo");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoIn(List<Short> values) {
            addCriterion("N_NUMGRUPO in", values, "nNumgrupo");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoNotIn(List<Short> values) {
            addCriterion("N_NUMGRUPO not in", values, "nNumgrupo");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoBetween(Short value1, Short value2) {
            addCriterion("N_NUMGRUPO between", value1, value2, "nNumgrupo");
            return (Criteria) this;
        }

        public Criteria andNNumgrupoNotBetween(Short value1, Short value2) {
            addCriterion("N_NUMGRUPO not between", value1, value2, "nNumgrupo");
            return (Criteria) this;
        }

        public Criteria andNNumdepIsNull() {
            addCriterion("N_NUMDEP is null");
            return (Criteria) this;
        }

        public Criteria andNNumdepIsNotNull() {
            addCriterion("N_NUMDEP is not null");
            return (Criteria) this;
        }

        public Criteria andNNumdepEqualTo(Short value) {
            addCriterion("N_NUMDEP =", value, "nNumdep");
            return (Criteria) this;
        }

        public Criteria andNNumdepNotEqualTo(Short value) {
            addCriterion("N_NUMDEP <>", value, "nNumdep");
            return (Criteria) this;
        }

        public Criteria andNNumdepGreaterThan(Short value) {
            addCriterion("N_NUMDEP >", value, "nNumdep");
            return (Criteria) this;
        }

        public Criteria andNNumdepGreaterThanOrEqualTo(Short value) {
            addCriterion("N_NUMDEP >=", value, "nNumdep");
            return (Criteria) this;
        }

        public Criteria andNNumdepLessThan(Short value) {
            addCriterion("N_NUMDEP <", value, "nNumdep");
            return (Criteria) this;
        }

        public Criteria andNNumdepLessThanOrEqualTo(Short value) {
            addCriterion("N_NUMDEP <=", value, "nNumdep");
            return (Criteria) this;
        }

        public Criteria andNNumdepIn(List<Short> values) {
            addCriterion("N_NUMDEP in", values, "nNumdep");
            return (Criteria) this;
        }

        public Criteria andNNumdepNotIn(List<Short> values) {
            addCriterion("N_NUMDEP not in", values, "nNumdep");
            return (Criteria) this;
        }

        public Criteria andNNumdepBetween(Short value1, Short value2) {
            addCriterion("N_NUMDEP between", value1, value2, "nNumdep");
            return (Criteria) this;
        }

        public Criteria andNNumdepNotBetween(Short value1, Short value2) {
            addCriterion("N_NUMDEP not between", value1, value2, "nNumdep");
            return (Criteria) this;
        }

        public Criteria andVCodtupaIsNull() {
            addCriterion("V_CODTUPA is null");
            return (Criteria) this;
        }

        public Criteria andVCodtupaIsNotNull() {
            addCriterion("V_CODTUPA is not null");
            return (Criteria) this;
        }

        public Criteria andVCodtupaEqualTo(String value) {
            addCriterion("V_CODTUPA =", value, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaNotEqualTo(String value) {
            addCriterion("V_CODTUPA <>", value, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaGreaterThan(String value) {
            addCriterion("V_CODTUPA >", value, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODTUPA >=", value, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaLessThan(String value) {
            addCriterion("V_CODTUPA <", value, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaLessThanOrEqualTo(String value) {
            addCriterion("V_CODTUPA <=", value, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaLike(String value) {
            addCriterion("V_CODTUPA like", value, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaNotLike(String value) {
            addCriterion("V_CODTUPA not like", value, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaIn(List<String> values) {
            addCriterion("V_CODTUPA in", values, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaNotIn(List<String> values) {
            addCriterion("V_CODTUPA not in", values, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaBetween(String value1, String value2) {
            addCriterion("V_CODTUPA between", value1, value2, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andVCodtupaNotBetween(String value1, String value2) {
            addCriterion("V_CODTUPA not between", value1, value2, "vCodtupa");
            return (Criteria) this;
        }

        public Criteria andNNumreqIsNull() {
            addCriterion("N_NUMREQ is null");
            return (Criteria) this;
        }

        public Criteria andNNumreqIsNotNull() {
            addCriterion("N_NUMREQ is not null");
            return (Criteria) this;
        }

        public Criteria andNNumreqEqualTo(Short value) {
            addCriterion("N_NUMREQ =", value, "nNumreq");
            return (Criteria) this;
        }

        public Criteria andNNumreqNotEqualTo(Short value) {
            addCriterion("N_NUMREQ <>", value, "nNumreq");
            return (Criteria) this;
        }

        public Criteria andNNumreqGreaterThan(Short value) {
            addCriterion("N_NUMREQ >", value, "nNumreq");
            return (Criteria) this;
        }

        public Criteria andNNumreqGreaterThanOrEqualTo(Short value) {
            addCriterion("N_NUMREQ >=", value, "nNumreq");
            return (Criteria) this;
        }

        public Criteria andNNumreqLessThan(Short value) {
            addCriterion("N_NUMREQ <", value, "nNumreq");
            return (Criteria) this;
        }

        public Criteria andNNumreqLessThanOrEqualTo(Short value) {
            addCriterion("N_NUMREQ <=", value, "nNumreq");
            return (Criteria) this;
        }

        public Criteria andNNumreqIn(List<Short> values) {
            addCriterion("N_NUMREQ in", values, "nNumreq");
            return (Criteria) this;
        }

        public Criteria andNNumreqNotIn(List<Short> values) {
            addCriterion("N_NUMREQ not in", values, "nNumreq");
            return (Criteria) this;
        }

        public Criteria andNNumreqBetween(Short value1, Short value2) {
            addCriterion("N_NUMREQ between", value1, value2, "nNumreq");
            return (Criteria) this;
        }

        public Criteria andNNumreqNotBetween(Short value1, Short value2) {
            addCriterion("N_NUMREQ not between", value1, value2, "nNumreq");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoIsNull() {
            addCriterion("N_FLGACTIVO is null");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoIsNotNull() {
            addCriterion("N_FLGACTIVO is not null");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoEqualTo(Short value) {
            addCriterion("N_FLGACTIVO =", value, "nFlgactivo");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoNotEqualTo(Short value) {
            addCriterion("N_FLGACTIVO <>", value, "nFlgactivo");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoGreaterThan(Short value) {
            addCriterion("N_FLGACTIVO >", value, "nFlgactivo");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoGreaterThanOrEqualTo(Short value) {
            addCriterion("N_FLGACTIVO >=", value, "nFlgactivo");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoLessThan(Short value) {
            addCriterion("N_FLGACTIVO <", value, "nFlgactivo");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoLessThanOrEqualTo(Short value) {
            addCriterion("N_FLGACTIVO <=", value, "nFlgactivo");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoIn(List<Short> values) {
            addCriterion("N_FLGACTIVO in", values, "nFlgactivo");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoNotIn(List<Short> values) {
            addCriterion("N_FLGACTIVO not in", values, "nFlgactivo");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoBetween(Short value1, Short value2) {
            addCriterion("N_FLGACTIVO between", value1, value2, "nFlgactivo");
            return (Criteria) this;
        }

        public Criteria andNFlgactivoNotBetween(Short value1, Short value2) {
            addCriterion("N_FLGACTIVO not between", value1, value2, "nFlgactivo");
            return (Criteria) this;
        }

        public Criteria andVDesreqIsNull() {
            addCriterion("V_DESREQ is null");
            return (Criteria) this;
        }

        public Criteria andVDesreqIsNotNull() {
            addCriterion("V_DESREQ is not null");
            return (Criteria) this;
        }

        public Criteria andVDesreqEqualTo(String value) {
            addCriterion("V_DESREQ =", value, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqNotEqualTo(String value) {
            addCriterion("V_DESREQ <>", value, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqGreaterThan(String value) {
            addCriterion("V_DESREQ >", value, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESREQ >=", value, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqLessThan(String value) {
            addCriterion("V_DESREQ <", value, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqLessThanOrEqualTo(String value) {
            addCriterion("V_DESREQ <=", value, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqLike(String value) {
            addCriterion("V_DESREQ like", value, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqNotLike(String value) {
            addCriterion("V_DESREQ not like", value, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqIn(List<String> values) {
            addCriterion("V_DESREQ in", values, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqNotIn(List<String> values) {
            addCriterion("V_DESREQ not in", values, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqBetween(String value1, String value2) {
            addCriterion("V_DESREQ between", value1, value2, "vDesreq");
            return (Criteria) this;
        }

        public Criteria andVDesreqNotBetween(String value1, String value2) {
            addCriterion("V_DESREQ not between", value1, value2, "vDesreq");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRAMITE.TDTBD_REQTUPA
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
     * This class corresponds to the database table TRAMITE.TDTBD_REQTUPA
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