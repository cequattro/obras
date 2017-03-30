package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RhtbcCargamasivaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public RhtbcCargamasivaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
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
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
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
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
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
     * This class corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
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

        public Criteria andNCodcargaIsNull() {
            addCriterion("N_CODCARGA is null");
            return (Criteria) this;
        }

        public Criteria andNCodcargaIsNotNull() {
            addCriterion("N_CODCARGA is not null");
            return (Criteria) this;
        }

        public Criteria andNCodcargaEqualTo(BigDecimal value) {
            addCriterion("N_CODCARGA =", value, "nCodcarga");
            return (Criteria) this;
        }

        public Criteria andNCodcargaNotEqualTo(BigDecimal value) {
            addCriterion("N_CODCARGA <>", value, "nCodcarga");
            return (Criteria) this;
        }

        public Criteria andNCodcargaGreaterThan(BigDecimal value) {
            addCriterion("N_CODCARGA >", value, "nCodcarga");
            return (Criteria) this;
        }

        public Criteria andNCodcargaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODCARGA >=", value, "nCodcarga");
            return (Criteria) this;
        }

        public Criteria andNCodcargaLessThan(BigDecimal value) {
            addCriterion("N_CODCARGA <", value, "nCodcarga");
            return (Criteria) this;
        }

        public Criteria andNCodcargaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODCARGA <=", value, "nCodcarga");
            return (Criteria) this;
        }

        public Criteria andNCodcargaIn(List<BigDecimal> values) {
            addCriterion("N_CODCARGA in", values, "nCodcarga");
            return (Criteria) this;
        }

        public Criteria andNCodcargaNotIn(List<BigDecimal> values) {
            addCriterion("N_CODCARGA not in", values, "nCodcarga");
            return (Criteria) this;
        }

        public Criteria andNCodcargaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODCARGA between", value1, value2, "nCodcarga");
            return (Criteria) this;
        }

        public Criteria andNCodcargaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODCARGA not between", value1, value2, "nCodcarga");
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

        public Criteria andDFechaIsNull() {
            addCriterion("D_FECHA is null");
            return (Criteria) this;
        }

        public Criteria andDFechaIsNotNull() {
            addCriterion("D_FECHA is not null");
            return (Criteria) this;
        }

        public Criteria andDFechaEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECHA =", value, "dFecha");
            return (Criteria) this;
        }

        public Criteria andDFechaNotEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECHA <>", value, "dFecha");
            return (Criteria) this;
        }

        public Criteria andDFechaGreaterThan(Date value) {
            addCriterionForJDBCDate("D_FECHA >", value, "dFecha");
            return (Criteria) this;
        }

        public Criteria andDFechaGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECHA >=", value, "dFecha");
            return (Criteria) this;
        }

        public Criteria andDFechaLessThan(Date value) {
            addCriterionForJDBCDate("D_FECHA <", value, "dFecha");
            return (Criteria) this;
        }

        public Criteria andDFechaLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("D_FECHA <=", value, "dFecha");
            return (Criteria) this;
        }

        public Criteria andDFechaIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECHA in", values, "dFecha");
            return (Criteria) this;
        }

        public Criteria andDFechaNotIn(List<Date> values) {
            addCriterionForJDBCDate("D_FECHA not in", values, "dFecha");
            return (Criteria) this;
        }

        public Criteria andDFechaBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECHA between", value1, value2, "dFecha");
            return (Criteria) this;
        }

        public Criteria andDFechaNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("D_FECHA not between", value1, value2, "dFecha");
            return (Criteria) this;
        }

        public Criteria andNHoraIsNull() {
            addCriterion("N_HORA is null");
            return (Criteria) this;
        }

        public Criteria andNHoraIsNotNull() {
            addCriterion("N_HORA is not null");
            return (Criteria) this;
        }

        public Criteria andNHoraEqualTo(Short value) {
            addCriterion("N_HORA =", value, "nHora");
            return (Criteria) this;
        }

        public Criteria andNHoraNotEqualTo(Short value) {
            addCriterion("N_HORA <>", value, "nHora");
            return (Criteria) this;
        }

        public Criteria andNHoraGreaterThan(Short value) {
            addCriterion("N_HORA >", value, "nHora");
            return (Criteria) this;
        }

        public Criteria andNHoraGreaterThanOrEqualTo(Short value) {
            addCriterion("N_HORA >=", value, "nHora");
            return (Criteria) this;
        }

        public Criteria andNHoraLessThan(Short value) {
            addCriterion("N_HORA <", value, "nHora");
            return (Criteria) this;
        }

        public Criteria andNHoraLessThanOrEqualTo(Short value) {
            addCriterion("N_HORA <=", value, "nHora");
            return (Criteria) this;
        }

        public Criteria andNHoraIn(List<Short> values) {
            addCriterion("N_HORA in", values, "nHora");
            return (Criteria) this;
        }

        public Criteria andNHoraNotIn(List<Short> values) {
            addCriterion("N_HORA not in", values, "nHora");
            return (Criteria) this;
        }

        public Criteria andNHoraBetween(Short value1, Short value2) {
            addCriterion("N_HORA between", value1, value2, "nHora");
            return (Criteria) this;
        }

        public Criteria andNHoraNotBetween(Short value1, Short value2) {
            addCriterion("N_HORA not between", value1, value2, "nHora");
            return (Criteria) this;
        }

        public Criteria andNMinutoIsNull() {
            addCriterion("N_MINUTO is null");
            return (Criteria) this;
        }

        public Criteria andNMinutoIsNotNull() {
            addCriterion("N_MINUTO is not null");
            return (Criteria) this;
        }

        public Criteria andNMinutoEqualTo(Short value) {
            addCriterion("N_MINUTO =", value, "nMinuto");
            return (Criteria) this;
        }

        public Criteria andNMinutoNotEqualTo(Short value) {
            addCriterion("N_MINUTO <>", value, "nMinuto");
            return (Criteria) this;
        }

        public Criteria andNMinutoGreaterThan(Short value) {
            addCriterion("N_MINUTO >", value, "nMinuto");
            return (Criteria) this;
        }

        public Criteria andNMinutoGreaterThanOrEqualTo(Short value) {
            addCriterion("N_MINUTO >=", value, "nMinuto");
            return (Criteria) this;
        }

        public Criteria andNMinutoLessThan(Short value) {
            addCriterion("N_MINUTO <", value, "nMinuto");
            return (Criteria) this;
        }

        public Criteria andNMinutoLessThanOrEqualTo(Short value) {
            addCriterion("N_MINUTO <=", value, "nMinuto");
            return (Criteria) this;
        }

        public Criteria andNMinutoIn(List<Short> values) {
            addCriterion("N_MINUTO in", values, "nMinuto");
            return (Criteria) this;
        }

        public Criteria andNMinutoNotIn(List<Short> values) {
            addCriterion("N_MINUTO not in", values, "nMinuto");
            return (Criteria) this;
        }

        public Criteria andNMinutoBetween(Short value1, Short value2) {
            addCriterion("N_MINUTO between", value1, value2, "nMinuto");
            return (Criteria) this;
        }

        public Criteria andNMinutoNotBetween(Short value1, Short value2) {
            addCriterion("N_MINUTO not between", value1, value2, "nMinuto");
            return (Criteria) this;
        }

        public Criteria andNSegundoIsNull() {
            addCriterion("N_SEGUNDO is null");
            return (Criteria) this;
        }

        public Criteria andNSegundoIsNotNull() {
            addCriterion("N_SEGUNDO is not null");
            return (Criteria) this;
        }

        public Criteria andNSegundoEqualTo(Short value) {
            addCriterion("N_SEGUNDO =", value, "nSegundo");
            return (Criteria) this;
        }

        public Criteria andNSegundoNotEqualTo(Short value) {
            addCriterion("N_SEGUNDO <>", value, "nSegundo");
            return (Criteria) this;
        }

        public Criteria andNSegundoGreaterThan(Short value) {
            addCriterion("N_SEGUNDO >", value, "nSegundo");
            return (Criteria) this;
        }

        public Criteria andNSegundoGreaterThanOrEqualTo(Short value) {
            addCriterion("N_SEGUNDO >=", value, "nSegundo");
            return (Criteria) this;
        }

        public Criteria andNSegundoLessThan(Short value) {
            addCriterion("N_SEGUNDO <", value, "nSegundo");
            return (Criteria) this;
        }

        public Criteria andNSegundoLessThanOrEqualTo(Short value) {
            addCriterion("N_SEGUNDO <=", value, "nSegundo");
            return (Criteria) this;
        }

        public Criteria andNSegundoIn(List<Short> values) {
            addCriterion("N_SEGUNDO in", values, "nSegundo");
            return (Criteria) this;
        }

        public Criteria andNSegundoNotIn(List<Short> values) {
            addCriterion("N_SEGUNDO not in", values, "nSegundo");
            return (Criteria) this;
        }

        public Criteria andNSegundoBetween(Short value1, Short value2) {
            addCriterion("N_SEGUNDO between", value1, value2, "nSegundo");
            return (Criteria) this;
        }

        public Criteria andNSegundoNotBetween(Short value1, Short value2) {
            addCriterion("N_SEGUNDO not between", value1, value2, "nSegundo");
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

        public Criteria andNGrupocargaIsNull() {
            addCriterion("N_GRUPOCARGA is null");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaIsNotNull() {
            addCriterion("N_GRUPOCARGA is not null");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaEqualTo(BigDecimal value) {
            addCriterion("N_GRUPOCARGA =", value, "nGrupocarga");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaNotEqualTo(BigDecimal value) {
            addCriterion("N_GRUPOCARGA <>", value, "nGrupocarga");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaGreaterThan(BigDecimal value) {
            addCriterion("N_GRUPOCARGA >", value, "nGrupocarga");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_GRUPOCARGA >=", value, "nGrupocarga");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaLessThan(BigDecimal value) {
            addCriterion("N_GRUPOCARGA <", value, "nGrupocarga");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_GRUPOCARGA <=", value, "nGrupocarga");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaIn(List<BigDecimal> values) {
            addCriterion("N_GRUPOCARGA in", values, "nGrupocarga");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaNotIn(List<BigDecimal> values) {
            addCriterion("N_GRUPOCARGA not in", values, "nGrupocarga");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_GRUPOCARGA between", value1, value2, "nGrupocarga");
            return (Criteria) this;
        }

        public Criteria andNGrupocargaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_GRUPOCARGA not between", value1, value2, "nGrupocarga");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
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
     * This class corresponds to the database table RRHHSYS.RHTBC_CARGAMASIVA
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