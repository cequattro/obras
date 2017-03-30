package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.util.ArrayList;
import java.util.List;

import pe.gob.sunafil.gestionpersonal.persistence.model.RhmvcPerturnoExample.Criteria;

public class RhtbcTurnoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public RhtbcTurnoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
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
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
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

        public Criteria andNCodturnoIsNull() {
            addCriterion("N_CODTURNO is null");
            return (Criteria) this;
        }

        public Criteria andNCodturnoIsNotNull() {
            addCriterion("N_CODTURNO is not null");
            return (Criteria) this;
        }

        public Criteria andNCodturnoEqualTo(Short value) {
            addCriterion("N_CODTURNO =", value, "nCodturno");
            return (Criteria) this;
        }

        public Criteria andNCodturnoNotEqualTo(Short value) {
            addCriterion("N_CODTURNO <>", value, "nCodturno");
            return (Criteria) this;
        }

        public Criteria andNCodturnoGreaterThan(Short value) {
            addCriterion("N_CODTURNO >", value, "nCodturno");
            return (Criteria) this;
        }

        public Criteria andNCodturnoGreaterThanOrEqualTo(Short value) {
            addCriterion("N_CODTURNO >=", value, "nCodturno");
            return (Criteria) this;
        }

        public Criteria andNCodturnoLessThan(Short value) {
            addCriterion("N_CODTURNO <", value, "nCodturno");
            return (Criteria) this;
        }

        public Criteria andNCodturnoLessThanOrEqualTo(Short value) {
            addCriterion("N_CODTURNO <=", value, "nCodturno");
            return (Criteria) this;
        }

        public Criteria andNCodturnoIn(List<Short> values) {
            addCriterion("N_CODTURNO in", values, "nCodturno");
            return (Criteria) this;
        }

        public Criteria andNCodturnoNotIn(List<Short> values) {
            addCriterion("N_CODTURNO not in", values, "nCodturno");
            return (Criteria) this;
        }

        public Criteria andNCodturnoBetween(Short value1, Short value2) {
            addCriterion("N_CODTURNO between", value1, value2, "nCodturno");
            return (Criteria) this;
        }

        public Criteria andNCodturnoNotBetween(Short value1, Short value2) {
            addCriterion("N_CODTURNO not between", value1, value2, "nCodturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoIsNull() {
            addCriterion("V_DESTURNO is null");
            return (Criteria) this;
        }

        public Criteria andVDesturnoIsNotNull() {
            addCriterion("V_DESTURNO is not null");
            return (Criteria) this;
        }

        public Criteria andVDesturnoEqualTo(String value) {
            addCriterion("V_DESTURNO =", value, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoNotEqualTo(String value) {
            addCriterion("V_DESTURNO <>", value, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoGreaterThan(String value) {
            addCriterion("V_DESTURNO >", value, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESTURNO >=", value, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoLessThan(String value) {
            addCriterion("V_DESTURNO <", value, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoLessThanOrEqualTo(String value) {
            addCriterion("V_DESTURNO <=", value, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoLike(String value) {
            addCriterion("V_DESTURNO like", value, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoNotLike(String value) {
            addCriterion("V_DESTURNO not like", value, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoIn(List<String> values) {
            addCriterion("V_DESTURNO in", values, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoNotIn(List<String> values) {
            addCriterion("V_DESTURNO not in", values, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoBetween(String value1, String value2) {
            addCriterion("V_DESTURNO between", value1, value2, "vDesturno");
            return (Criteria) this;
        }

        public Criteria andVDesturnoNotBetween(String value1, String value2) {
            addCriterion("V_DESTURNO not between", value1, value2, "vDesturno");
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

        public Criteria andVFlgnomarcaIsNull() {
            addCriterion("V_FLGNOMARCA is null");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaIsNotNull() {
            addCriterion("V_FLGNOMARCA is not null");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaEqualTo(String value) {
            addCriterion("V_FLGNOMARCA =", value, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaNotEqualTo(String value) {
            addCriterion("V_FLGNOMARCA <>", value, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaGreaterThan(String value) {
            addCriterion("V_FLGNOMARCA >", value, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaGreaterThanOrEqualTo(String value) {
            addCriterion("V_FLGNOMARCA >=", value, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaLessThan(String value) {
            addCriterion("V_FLGNOMARCA <", value, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaLessThanOrEqualTo(String value) {
            addCriterion("V_FLGNOMARCA <=", value, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaLike(String value) {
            addCriterion("V_FLGNOMARCA like", value, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaNotLike(String value) {
            addCriterion("V_FLGNOMARCA not like", value, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaIn(List<String> values) {
            addCriterion("V_FLGNOMARCA in", values, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaNotIn(List<String> values) {
            addCriterion("V_FLGNOMARCA not in", values, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaBetween(String value1, String value2) {
            addCriterion("V_FLGNOMARCA between", value1, value2, "vFlgnomarca");
            return (Criteria) this;
        }

        public Criteria andVFlgnomarcaNotBetween(String value1, String value2) {
            addCriterion("V_FLGNOMARCA not between", value1, value2, "vFlgnomarca");
            return (Criteria) this;
        }
        
        public Criteria andCorrelativoActual() {
      	  StringBuffer sb = new StringBuffer("N_CODTURNO in (select max(N_CODTURNO) from RRHHSYS.RHTBC_TURNO)");    	  
      	  addCriterion(sb.toString());
      	  return (Criteria) this;
      	}
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated do_not_delete_during_merge Wed Oct 05 11:06:41 COT 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHTBC_TURNO
     *
     * @mbggenerated Wed Oct 05 11:06:41 COT 2016
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