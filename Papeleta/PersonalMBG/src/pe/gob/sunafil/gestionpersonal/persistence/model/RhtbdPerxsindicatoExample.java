package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RhtbdPerxsindicatoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public RhtbdPerxsindicatoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
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
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
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
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
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
     * This class corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
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

        public Criteria andNCorpersinIsNull() {
            addCriterion("N_CORPERSIN is null");
            return (Criteria) this;
        }

        public Criteria andNCorpersinIsNotNull() {
            addCriterion("N_CORPERSIN is not null");
            return (Criteria) this;
        }

        public Criteria andNCorpersinEqualTo(BigDecimal value) {
            addCriterion("N_CORPERSIN =", value, "nCorpersin");
            return (Criteria) this;
        }

        public Criteria andNCorpersinNotEqualTo(BigDecimal value) {
            addCriterion("N_CORPERSIN <>", value, "nCorpersin");
            return (Criteria) this;
        }

        public Criteria andNCorpersinGreaterThan(BigDecimal value) {
            addCriterion("N_CORPERSIN >", value, "nCorpersin");
            return (Criteria) this;
        }

        public Criteria andNCorpersinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORPERSIN >=", value, "nCorpersin");
            return (Criteria) this;
        }

        public Criteria andNCorpersinLessThan(BigDecimal value) {
            addCriterion("N_CORPERSIN <", value, "nCorpersin");
            return (Criteria) this;
        }

        public Criteria andNCorpersinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORPERSIN <=", value, "nCorpersin");
            return (Criteria) this;
        }

        public Criteria andNCorpersinIn(List<BigDecimal> values) {
            addCriterion("N_CORPERSIN in", values, "nCorpersin");
            return (Criteria) this;
        }

        public Criteria andNCorpersinNotIn(List<BigDecimal> values) {
            addCriterion("N_CORPERSIN not in", values, "nCorpersin");
            return (Criteria) this;
        }

        public Criteria andNCorpersinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORPERSIN between", value1, value2, "nCorpersin");
            return (Criteria) this;
        }

        public Criteria andNCorpersinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORPERSIN not between", value1, value2, "nCorpersin");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalIsNull() {
            addCriterion("V_CODPERSONAL is null");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalIsNotNull() {
            addCriterion("V_CODPERSONAL is not null");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalEqualTo(String value) {
            addCriterion("V_CODPERSONAL =", value, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalNotEqualTo(String value) {
            addCriterion("V_CODPERSONAL <>", value, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalGreaterThan(String value) {
            addCriterion("V_CODPERSONAL >", value, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODPERSONAL >=", value, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalLessThan(String value) {
            addCriterion("V_CODPERSONAL <", value, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalLessThanOrEqualTo(String value) {
            addCriterion("V_CODPERSONAL <=", value, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalLike(String value) {
            addCriterion("V_CODPERSONAL like", value, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalNotLike(String value) {
            addCriterion("V_CODPERSONAL not like", value, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalIn(List<String> values) {
            addCriterion("V_CODPERSONAL in", values, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalNotIn(List<String> values) {
            addCriterion("V_CODPERSONAL not in", values, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalBetween(String value1, String value2) {
            addCriterion("V_CODPERSONAL between", value1, value2, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andVCodpersonalNotBetween(String value1, String value2) {
            addCriterion("V_CODPERSONAL not between", value1, value2, "vCodpersonal");
            return (Criteria) this;
        }

        public Criteria andNCodsindicIsNull() {
            addCriterion("N_CODSINDIC is null");
            return (Criteria) this;
        }

        public Criteria andNCodsindicIsNotNull() {
            addCriterion("N_CODSINDIC is not null");
            return (Criteria) this;
        }

        public Criteria andNCodsindicEqualTo(BigDecimal value) {
            addCriterion("N_CODSINDIC =", value, "nCodsindic");
            return (Criteria) this;
        }

        public Criteria andNCodsindicNotEqualTo(BigDecimal value) {
            addCriterion("N_CODSINDIC <>", value, "nCodsindic");
            return (Criteria) this;
        }

        public Criteria andNCodsindicGreaterThan(BigDecimal value) {
            addCriterion("N_CODSINDIC >", value, "nCodsindic");
            return (Criteria) this;
        }

        public Criteria andNCodsindicGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODSINDIC >=", value, "nCodsindic");
            return (Criteria) this;
        }

        public Criteria andNCodsindicLessThan(BigDecimal value) {
            addCriterion("N_CODSINDIC <", value, "nCodsindic");
            return (Criteria) this;
        }

        public Criteria andNCodsindicLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODSINDIC <=", value, "nCodsindic");
            return (Criteria) this;
        }

        public Criteria andNCodsindicIn(List<BigDecimal> values) {
            addCriterion("N_CODSINDIC in", values, "nCodsindic");
            return (Criteria) this;
        }

        public Criteria andNCodsindicNotIn(List<BigDecimal> values) {
            addCriterion("N_CODSINDIC not in", values, "nCodsindic");
            return (Criteria) this;
        }

        public Criteria andNCodsindicBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODSINDIC between", value1, value2, "nCodsindic");
            return (Criteria) this;
        }

        public Criteria andNCodsindicNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODSINDIC not between", value1, value2, "nCodsindic");
            return (Criteria) this;
        }

        public Criteria andDFeciniIsNull() {
            addCriterion("D_FECINI is null");
            return (Criteria) this;
        }

        public Criteria andDFeciniIsNotNull() {
            addCriterion("D_FECINI is not null");
            return (Criteria) this;
        }

        public Criteria andDFeciniEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECINI =", value, "dFecini");
            return (Criteria) this;
        }

        public Criteria andDFeciniNotEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECINI <>", value, "dFecini");
            return (Criteria) this;
        }

        public Criteria andDFeciniGreaterThan(Date value) {
            addCriterionForJDBCDate("D_FECINI >", value, "dFecini");
            return (Criteria) this;
        }

        public Criteria andDFeciniGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECINI >=", value, "dFecini");
            return (Criteria) this;
        }

        public Criteria andDFeciniLessThan(Date value) {
            addCriterionForJDBCDate("D_FECINI <", value, "dFecini");
            return (Criteria) this;
        }

        public Criteria andDFeciniLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECINI <=", value, "dFecini");
            return (Criteria) this;
        }

        public Criteria andDFeciniIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECINI in", values, "dFecini");
            return (Criteria) this;
        }

        public Criteria andDFeciniNotIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECINI not in", values, "dFecini");
            return (Criteria) this;
        }

        public Criteria andDFeciniBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECINI between", value1, value2, "dFecini");
            return (Criteria) this;
        }

        public Criteria andDFeciniNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECINI not between", value1, value2, "dFecini");
            return (Criteria) this;
        }

        public Criteria andDFecfinIsNull() {
            addCriterion("D_FECFIN is null");
            return (Criteria) this;
        }

        public Criteria andDFecfinIsNotNull() {
            addCriterion("D_FECFIN is not null");
            return (Criteria) this;
        }

        public Criteria andDFecfinEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECFIN =", value, "dFecfin");
            return (Criteria) this;
        }

        public Criteria andDFecfinNotEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECFIN <>", value, "dFecfin");
            return (Criteria) this;
        }

        public Criteria andDFecfinGreaterThan(Date value) {
            addCriterionForJDBCDate("D_FECFIN >", value, "dFecfin");
            return (Criteria) this;
        }

        public Criteria andDFecfinGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECFIN >=", value, "dFecfin");
            return (Criteria) this;
        }

        public Criteria andDFecfinLessThan(Date value) {
            addCriterionForJDBCDate("D_FECFIN <", value, "dFecfin");
            return (Criteria) this;
        }

        public Criteria andDFecfinLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECFIN <=", value, "dFecfin");
            return (Criteria) this;
        }

        public Criteria andDFecfinIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECFIN in", values, "dFecfin");
            return (Criteria) this;
        }

        public Criteria andDFecfinNotIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECFIN not in", values, "dFecfin");
            return (Criteria) this;
        }

        public Criteria andDFecfinBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECFIN between", value1, value2, "dFecfin");
            return (Criteria) this;
        }

        public Criteria andDFecfinNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECFIN not between", value1, value2, "dFecfin");
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

        public Criteria andVCodusumodIsNull() {
            addCriterion("V_CODUSUMOD is null");
            return (Criteria) this;
        }

        public Criteria andVCodusumodIsNotNull() {
            addCriterion("V_CODUSUMOD is not null");
            return (Criteria) this;
        }

        public Criteria andVCodusumodEqualTo(String value) {
            addCriterion("V_CODUSUMOD =", value, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodNotEqualTo(String value) {
            addCriterion("V_CODUSUMOD <>", value, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodGreaterThan(String value) {
            addCriterion("V_CODUSUMOD >", value, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODUSUMOD >=", value, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodLessThan(String value) {
            addCriterion("V_CODUSUMOD <", value, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodLessThanOrEqualTo(String value) {
            addCriterion("V_CODUSUMOD <=", value, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodLike(String value) {
            addCriterion("V_CODUSUMOD like", value, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodNotLike(String value) {
            addCriterion("V_CODUSUMOD not like", value, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodIn(List<String> values) {
            addCriterion("V_CODUSUMOD in", values, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodNotIn(List<String> values) {
            addCriterion("V_CODUSUMOD not in", values, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodBetween(String value1, String value2) {
            addCriterion("V_CODUSUMOD between", value1, value2, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andVCodusumodNotBetween(String value1, String value2) {
            addCriterion("V_CODUSUMOD not between", value1, value2, "vCodusumod");
            return (Criteria) this;
        }

        public Criteria andDFecmodIsNull() {
            addCriterion("D_FECMOD is null");
            return (Criteria) this;
        }

        public Criteria andDFecmodIsNotNull() {
            addCriterion("D_FECMOD is not null");
            return (Criteria) this;
        }

        public Criteria andDFecmodEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECMOD =", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodNotEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECMOD <>", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodGreaterThan(Date value) {
            addCriterionForJDBCDate("D_FECMOD >", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECMOD >=", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodLessThan(Date value) {
            addCriterionForJDBCDate("D_FECMOD <", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECMOD <=", value, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECMOD in", values, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodNotIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECMOD not in", values, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECMOD between", value1, value2, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andDFecmodNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECMOD not between", value1, value2, "dFecmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodIsNull() {
            addCriterion("V_HOSTMOD is null");
            return (Criteria) this;
        }

        public Criteria andVHostmodIsNotNull() {
            addCriterion("V_HOSTMOD is not null");
            return (Criteria) this;
        }

        public Criteria andVHostmodEqualTo(String value) {
            addCriterion("V_HOSTMOD =", value, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodNotEqualTo(String value) {
            addCriterion("V_HOSTMOD <>", value, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodGreaterThan(String value) {
            addCriterion("V_HOSTMOD >", value, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodGreaterThanOrEqualTo(String value) {
            addCriterion("V_HOSTMOD >=", value, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodLessThan(String value) {
            addCriterion("V_HOSTMOD <", value, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodLessThanOrEqualTo(String value) {
            addCriterion("V_HOSTMOD <=", value, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodLike(String value) {
            addCriterion("V_HOSTMOD like", value, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodNotLike(String value) {
            addCriterion("V_HOSTMOD not like", value, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodIn(List<String> values) {
            addCriterion("V_HOSTMOD in", values, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodNotIn(List<String> values) {
            addCriterion("V_HOSTMOD not in", values, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodBetween(String value1, String value2) {
            addCriterion("V_HOSTMOD between", value1, value2, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andVHostmodNotBetween(String value1, String value2) {
            addCriterion("V_HOSTMOD not between", value1, value2, "vHostmod");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinIsNull() {
            addCriterion("N_CODCARSIN is null");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinIsNotNull() {
            addCriterion("N_CODCARSIN is not null");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinEqualTo(BigDecimal value) {
            addCriterion("N_CODCARSIN =", value, "nCodcarsin");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinNotEqualTo(BigDecimal value) {
            addCriterion("N_CODCARSIN <>", value, "nCodcarsin");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinGreaterThan(BigDecimal value) {
            addCriterion("N_CODCARSIN >", value, "nCodcarsin");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODCARSIN >=", value, "nCodcarsin");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinLessThan(BigDecimal value) {
            addCriterion("N_CODCARSIN <", value, "nCodcarsin");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODCARSIN <=", value, "nCodcarsin");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinIn(List<BigDecimal> values) {
            addCriterion("N_CODCARSIN in", values, "nCodcarsin");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinNotIn(List<BigDecimal> values) {
            addCriterion("N_CODCARSIN not in", values, "nCodcarsin");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODCARSIN between", value1, value2, "nCodcarsin");
            return (Criteria) this;
        }

        public Criteria andNCodcarsinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODCARSIN not between", value1, value2, "nCodcarsin");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
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
     * This class corresponds to the database table RRHHSYS.RHTBD_PERXSINDICATO
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