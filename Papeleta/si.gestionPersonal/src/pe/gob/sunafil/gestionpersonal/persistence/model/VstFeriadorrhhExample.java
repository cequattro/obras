package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VstFeriadorrhhExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    public VstFeriadorrhhExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
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
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andVAnioIsNull() {
            addCriterion("V_ANIO is null");
            return (Criteria) this;
        }

        public Criteria andVAnioIsNotNull() {
            addCriterion("V_ANIO is not null");
            return (Criteria) this;
        }

        public Criteria andVAnioEqualTo(String value) {
            addCriterion("V_ANIO =", value, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioNotEqualTo(String value) {
            addCriterion("V_ANIO <>", value, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioGreaterThan(String value) {
            addCriterion("V_ANIO >", value, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioGreaterThanOrEqualTo(String value) {
            addCriterion("V_ANIO >=", value, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioLessThan(String value) {
            addCriterion("V_ANIO <", value, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioLessThanOrEqualTo(String value) {
            addCriterion("V_ANIO <=", value, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioLike(String value) {
            addCriterion("V_ANIO like", value, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioNotLike(String value) {
            addCriterion("V_ANIO not like", value, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioIn(List<String> values) {
            addCriterion("V_ANIO in", values, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioNotIn(List<String> values) {
            addCriterion("V_ANIO not in", values, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioBetween(String value1, String value2) {
            addCriterion("V_ANIO between", value1, value2, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVAnioNotBetween(String value1, String value2) {
            addCriterion("V_ANIO not between", value1, value2, "vAnio");
            return (Criteria) this;
        }

        public Criteria andVCodferIsNull() {
            addCriterion("V_CODFER is null");
            return (Criteria) this;
        }

        public Criteria andVCodferIsNotNull() {
            addCriterion("V_CODFER is not null");
            return (Criteria) this;
        }

        public Criteria andVCodferEqualTo(String value) {
            addCriterion("V_CODFER =", value, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferNotEqualTo(String value) {
            addCriterion("V_CODFER <>", value, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferGreaterThan(String value) {
            addCriterion("V_CODFER >", value, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODFER >=", value, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferLessThan(String value) {
            addCriterion("V_CODFER <", value, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferLessThanOrEqualTo(String value) {
            addCriterion("V_CODFER <=", value, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferLike(String value) {
            addCriterion("V_CODFER like", value, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferNotLike(String value) {
            addCriterion("V_CODFER not like", value, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferIn(List<String> values) {
            addCriterion("V_CODFER in", values, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferNotIn(List<String> values) {
            addCriterion("V_CODFER not in", values, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferBetween(String value1, String value2) {
            addCriterion("V_CODFER between", value1, value2, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andVCodferNotBetween(String value1, String value2) {
            addCriterion("V_CODFER not between", value1, value2, "vCodfer");
            return (Criteria) this;
        }

        public Criteria andDFecferIsNull() {
            addCriterion("D_FECFER is null");
            return (Criteria) this;
        }

        public Criteria andDFecferIsNotNull() {
            addCriterion("D_FECFER is not null");
            return (Criteria) this;
        }

        public Criteria andDFecferEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECFER =", value, "dFecfer");
            return (Criteria) this;
        }

        public Criteria andDFecferNotEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECFER <>", value, "dFecfer");
            return (Criteria) this;
        }

        public Criteria andDFecferGreaterThan(Date value) {
            addCriterionForJDBCDate("D_FECFER >", value, "dFecfer");
            return (Criteria) this;
        }

        public Criteria andDFecferGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECFER >=", value, "dFecfer");
            return (Criteria) this;
        }

        public Criteria andDFecferLessThan(Date value) {
            addCriterionForJDBCDate("D_FECFER <", value, "dFecfer");
            return (Criteria) this;
        }

        public Criteria andDFecferLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECFER <=", value, "dFecfer");
            return (Criteria) this;
        }

        public Criteria andDFecferIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECFER in", values, "dFecfer");
            return (Criteria) this;
        }

        public Criteria andDFecferNotIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECFER not in", values, "dFecfer");
            return (Criteria) this;
        }

        public Criteria andDFecferBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECFER between", value1, value2, "dFecfer");
            return (Criteria) this;
        }

        public Criteria andDFecferNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECFER not between", value1, value2, "dFecfer");
            return (Criteria) this;
        }

        public Criteria andVFlgrecIsNull() {
            addCriterion("V_FLGREC is null");
            return (Criteria) this;
        }

        public Criteria andVFlgrecIsNotNull() {
            addCriterion("V_FLGREC is not null");
            return (Criteria) this;
        }

        public Criteria andVFlgrecEqualTo(String value) {
            addCriterion("V_FLGREC =", value, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecNotEqualTo(String value) {
            addCriterion("V_FLGREC <>", value, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecGreaterThan(String value) {
            addCriterion("V_FLGREC >", value, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecGreaterThanOrEqualTo(String value) {
            addCriterion("V_FLGREC >=", value, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecLessThan(String value) {
            addCriterion("V_FLGREC <", value, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecLessThanOrEqualTo(String value) {
            addCriterion("V_FLGREC <=", value, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecLike(String value) {
            addCriterion("V_FLGREC like", value, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecNotLike(String value) {
            addCriterion("V_FLGREC not like", value, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecIn(List<String> values) {
            addCriterion("V_FLGREC in", values, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecNotIn(List<String> values) {
            addCriterion("V_FLGREC not in", values, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecBetween(String value1, String value2) {
            addCriterion("V_FLGREC between", value1, value2, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVFlgrecNotBetween(String value1, String value2) {
            addCriterion("V_FLGREC not between", value1, value2, "vFlgrec");
            return (Criteria) this;
        }

        public Criteria andVCodusuregIsNull() {
            addCriterion("V_CODUSUREG is null");
            return (Criteria) this;
        }

        public Criteria andVCodusuregIsNotNull() {
            addCriterion("V_CODUSUREG is not null");
            return (Criteria) this;
        }

        public Criteria andVCodusuregEqualTo(String value) {
            addCriterion("V_CODUSUREG =", value, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregNotEqualTo(String value) {
            addCriterion("V_CODUSUREG <>", value, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregGreaterThan(String value) {
            addCriterion("V_CODUSUREG >", value, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODUSUREG >=", value, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregLessThan(String value) {
            addCriterion("V_CODUSUREG <", value, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregLessThanOrEqualTo(String value) {
            addCriterion("V_CODUSUREG <=", value, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregLike(String value) {
            addCriterion("V_CODUSUREG like", value, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregNotLike(String value) {
            addCriterion("V_CODUSUREG not like", value, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregIn(List<String> values) {
            addCriterion("V_CODUSUREG in", values, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregNotIn(List<String> values) {
            addCriterion("V_CODUSUREG not in", values, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregBetween(String value1, String value2) {
            addCriterion("V_CODUSUREG between", value1, value2, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andVCodusuregNotBetween(String value1, String value2) {
            addCriterion("V_CODUSUREG not between", value1, value2, "vCodusureg");
            return (Criteria) this;
        }

        public Criteria andDFecregIsNull() {
            addCriterion("D_FECREG is null");
            return (Criteria) this;
        }

        public Criteria andDFecregIsNotNull() {
            addCriterion("D_FECREG is not null");
            return (Criteria) this;
        }

        public Criteria andDFecregEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECREG =", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregNotEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECREG <>", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregGreaterThan(Date value) {
            addCriterionForJDBCDate("D_FECREG >", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECREG >=", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregLessThan(Date value) {
            addCriterionForJDBCDate("D_FECREG <", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECREG <=", value, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECREG in", values, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregNotIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECREG not in", values, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECREG between", value1, value2, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andDFecregNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECREG not between", value1, value2, "dFecreg");
            return (Criteria) this;
        }

        public Criteria andVHostregIsNull() {
            addCriterion("V_HOSTREG is null");
            return (Criteria) this;
        }

        public Criteria andVHostregIsNotNull() {
            addCriterion("V_HOSTREG is not null");
            return (Criteria) this;
        }

        public Criteria andVHostregEqualTo(String value) {
            addCriterion("V_HOSTREG =", value, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregNotEqualTo(String value) {
            addCriterion("V_HOSTREG <>", value, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregGreaterThan(String value) {
            addCriterion("V_HOSTREG >", value, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregGreaterThanOrEqualTo(String value) {
            addCriterion("V_HOSTREG >=", value, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregLessThan(String value) {
            addCriterion("V_HOSTREG <", value, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregLessThanOrEqualTo(String value) {
            addCriterion("V_HOSTREG <=", value, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregLike(String value) {
            addCriterion("V_HOSTREG like", value, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregNotLike(String value) {
            addCriterion("V_HOSTREG not like", value, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregIn(List<String> values) {
            addCriterion("V_HOSTREG in", values, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregNotIn(List<String> values) {
            addCriterion("V_HOSTREG not in", values, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregBetween(String value1, String value2) {
            addCriterion("V_HOSTREG between", value1, value2, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVHostregNotBetween(String value1, String value2) {
            addCriterion("V_HOSTREG not between", value1, value2, "vHostreg");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarIsNull() {
            addCriterion("V_FLGREGMAR is null");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarIsNotNull() {
            addCriterion("V_FLGREGMAR is not null");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarEqualTo(String value) {
            addCriterion("V_FLGREGMAR =", value, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarNotEqualTo(String value) {
            addCriterion("V_FLGREGMAR <>", value, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarGreaterThan(String value) {
            addCriterion("V_FLGREGMAR >", value, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarGreaterThanOrEqualTo(String value) {
            addCriterion("V_FLGREGMAR >=", value, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarLessThan(String value) {
            addCriterion("V_FLGREGMAR <", value, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarLessThanOrEqualTo(String value) {
            addCriterion("V_FLGREGMAR <=", value, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarLike(String value) {
            addCriterion("V_FLGREGMAR like", value, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarNotLike(String value) {
            addCriterion("V_FLGREGMAR not like", value, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarIn(List<String> values) {
            addCriterion("V_FLGREGMAR in", values, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarNotIn(List<String> values) {
            addCriterion("V_FLGREGMAR not in", values, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarBetween(String value1, String value2) {
            addCriterion("V_FLGREGMAR between", value1, value2, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVFlgregmarNotBetween(String value1, String value2) {
            addCriterion("V_FLGREGMAR not between", value1, value2, "vFlgregmar");
            return (Criteria) this;
        }

        public Criteria andVMotferIsNull() {
            addCriterion("V_MOTFER is null");
            return (Criteria) this;
        }

        public Criteria andVMotferIsNotNull() {
            addCriterion("V_MOTFER is not null");
            return (Criteria) this;
        }

        public Criteria andVMotferEqualTo(String value) {
            addCriterion("V_MOTFER =", value, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferNotEqualTo(String value) {
            addCriterion("V_MOTFER <>", value, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferGreaterThan(String value) {
            addCriterion("V_MOTFER >", value, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferGreaterThanOrEqualTo(String value) {
            addCriterion("V_MOTFER >=", value, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferLessThan(String value) {
            addCriterion("V_MOTFER <", value, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferLessThanOrEqualTo(String value) {
            addCriterion("V_MOTFER <=", value, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferLike(String value) {
            addCriterion("V_MOTFER like", value, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferNotLike(String value) {
            addCriterion("V_MOTFER not like", value, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferIn(List<String> values) {
            addCriterion("V_MOTFER in", values, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferNotIn(List<String> values) {
            addCriterion("V_MOTFER not in", values, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferBetween(String value1, String value2) {
            addCriterion("V_MOTFER between", value1, value2, "vMotfer");
            return (Criteria) this;
        }

        public Criteria andVMotferNotBetween(String value1, String value2) {
            addCriterion("V_MOTFER not between", value1, value2, "vMotfer");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated do_not_delete_during_merge Mon Jan 16 17:26:17 COT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.VST_FERIADORRHH
     *
     * @mbggenerated Mon Jan 16 17:26:17 COT 2017
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