package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VstResolucionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    public VstResolucionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
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
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
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

        public Criteria andNCodresIsNull() {
            addCriterion("N_CODRES is null");
            return (Criteria) this;
        }

        public Criteria andNCodresIsNotNull() {
            addCriterion("N_CODRES is not null");
            return (Criteria) this;
        }

        public Criteria andNCodresEqualTo(BigDecimal value) {
            addCriterion("N_CODRES =", value, "nCodres");
            return (Criteria) this;
        }

        public Criteria andNCodresNotEqualTo(BigDecimal value) {
            addCriterion("N_CODRES <>", value, "nCodres");
            return (Criteria) this;
        }

        public Criteria andNCodresGreaterThan(BigDecimal value) {
            addCriterion("N_CODRES >", value, "nCodres");
            return (Criteria) this;
        }

        public Criteria andNCodresGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODRES >=", value, "nCodres");
            return (Criteria) this;
        }

        public Criteria andNCodresLessThan(BigDecimal value) {
            addCriterion("N_CODRES <", value, "nCodres");
            return (Criteria) this;
        }

        public Criteria andNCodresLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CODRES <=", value, "nCodres");
            return (Criteria) this;
        }

        public Criteria andNCodresIn(List<BigDecimal> values) {
            addCriterion("N_CODRES in", values, "nCodres");
            return (Criteria) this;
        }

        public Criteria andNCodresNotIn(List<BigDecimal> values) {
            addCriterion("N_CODRES not in", values, "nCodres");
            return (Criteria) this;
        }

        public Criteria andNCodresBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODRES between", value1, value2, "nCodres");
            return (Criteria) this;
        }

        public Criteria andNCodresNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CODRES not between", value1, value2, "nCodres");
            return (Criteria) this;
        }

        public Criteria andNCortipresIsNull() {
            addCriterion("N_CORTIPRES is null");
            return (Criteria) this;
        }

        public Criteria andNCortipresIsNotNull() {
            addCriterion("N_CORTIPRES is not null");
            return (Criteria) this;
        }

        public Criteria andNCortipresEqualTo(BigDecimal value) {
            addCriterion("N_CORTIPRES =", value, "nCortipres");
            return (Criteria) this;
        }

        public Criteria andNCortipresNotEqualTo(BigDecimal value) {
            addCriterion("N_CORTIPRES <>", value, "nCortipres");
            return (Criteria) this;
        }

        public Criteria andNCortipresGreaterThan(BigDecimal value) {
            addCriterion("N_CORTIPRES >", value, "nCortipres");
            return (Criteria) this;
        }

        public Criteria andNCortipresGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORTIPRES >=", value, "nCortipres");
            return (Criteria) this;
        }

        public Criteria andNCortipresLessThan(BigDecimal value) {
            addCriterion("N_CORTIPRES <", value, "nCortipres");
            return (Criteria) this;
        }

        public Criteria andNCortipresLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORTIPRES <=", value, "nCortipres");
            return (Criteria) this;
        }

        public Criteria andNCortipresIn(List<BigDecimal> values) {
            addCriterion("N_CORTIPRES in", values, "nCortipres");
            return (Criteria) this;
        }

        public Criteria andNCortipresNotIn(List<BigDecimal> values) {
            addCriterion("N_CORTIPRES not in", values, "nCortipres");
            return (Criteria) this;
        }

        public Criteria andNCortipresBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORTIPRES between", value1, value2, "nCortipres");
            return (Criteria) this;
        }

        public Criteria andNCortipresNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORTIPRES not between", value1, value2, "nCortipres");
            return (Criteria) this;
        }

        public Criteria andVNumresIsNull() {
            addCriterion("V_NUMRES is null");
            return (Criteria) this;
        }

        public Criteria andVNumresIsNotNull() {
            addCriterion("V_NUMRES is not null");
            return (Criteria) this;
        }

        public Criteria andVNumresEqualTo(String value) {
            addCriterion("V_NUMRES =", value, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresNotEqualTo(String value) {
            addCriterion("V_NUMRES <>", value, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresGreaterThan(String value) {
            addCriterion("V_NUMRES >", value, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresGreaterThanOrEqualTo(String value) {
            addCriterion("V_NUMRES >=", value, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresLessThan(String value) {
            addCriterion("V_NUMRES <", value, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresLessThanOrEqualTo(String value) {
            addCriterion("V_NUMRES <=", value, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresLike(String value) {
            addCriterion("V_NUMRES like", value, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresNotLike(String value) {
            addCriterion("V_NUMRES not like", value, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresIn(List<String> values) {
            addCriterion("V_NUMRES in", values, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresNotIn(List<String> values) {
            addCriterion("V_NUMRES not in", values, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresBetween(String value1, String value2) {
            addCriterion("V_NUMRES between", value1, value2, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVNumresNotBetween(String value1, String value2) {
            addCriterion("V_NUMRES not between", value1, value2, "vNumres");
            return (Criteria) this;
        }

        public Criteria andVAnoresIsNull() {
            addCriterion("V_ANORES is null");
            return (Criteria) this;
        }

        public Criteria andVAnoresIsNotNull() {
            addCriterion("V_ANORES is not null");
            return (Criteria) this;
        }

        public Criteria andVAnoresEqualTo(String value) {
            addCriterion("V_ANORES =", value, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresNotEqualTo(String value) {
            addCriterion("V_ANORES <>", value, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresGreaterThan(String value) {
            addCriterion("V_ANORES >", value, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresGreaterThanOrEqualTo(String value) {
            addCriterion("V_ANORES >=", value, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresLessThan(String value) {
            addCriterion("V_ANORES <", value, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresLessThanOrEqualTo(String value) {
            addCriterion("V_ANORES <=", value, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresLike(String value) {
            addCriterion("V_ANORES like", value, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresNotLike(String value) {
            addCriterion("V_ANORES not like", value, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresIn(List<String> values) {
            addCriterion("V_ANORES in", values, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresNotIn(List<String> values) {
            addCriterion("V_ANORES not in", values, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresBetween(String value1, String value2) {
            addCriterion("V_ANORES between", value1, value2, "vAnores");
            return (Criteria) this;
        }

        public Criteria andVAnoresNotBetween(String value1, String value2) {
            addCriterion("V_ANORES not between", value1, value2, "vAnores");
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

        public Criteria andVNomarchivIsNull() {
            addCriterion("V_NOMARCHIV is null");
            return (Criteria) this;
        }

        public Criteria andVNomarchivIsNotNull() {
            addCriterion("V_NOMARCHIV is not null");
            return (Criteria) this;
        }

        public Criteria andVNomarchivEqualTo(String value) {
            addCriterion("V_NOMARCHIV =", value, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivNotEqualTo(String value) {
            addCriterion("V_NOMARCHIV <>", value, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivGreaterThan(String value) {
            addCriterion("V_NOMARCHIV >", value, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivGreaterThanOrEqualTo(String value) {
            addCriterion("V_NOMARCHIV >=", value, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivLessThan(String value) {
            addCriterion("V_NOMARCHIV <", value, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivLessThanOrEqualTo(String value) {
            addCriterion("V_NOMARCHIV <=", value, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivLike(String value) {
            addCriterion("V_NOMARCHIV like", value, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivNotLike(String value) {
            addCriterion("V_NOMARCHIV not like", value, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivIn(List<String> values) {
            addCriterion("V_NOMARCHIV in", values, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivNotIn(List<String> values) {
            addCriterion("V_NOMARCHIV not in", values, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivBetween(String value1, String value2) {
            addCriterion("V_NOMARCHIV between", value1, value2, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVNomarchivNotBetween(String value1, String value2) {
            addCriterion("V_NOMARCHIV not between", value1, value2, "vNomarchiv");
            return (Criteria) this;
        }

        public Criteria andVDestipresIsNull() {
            addCriterion("V_DESTIPRES is null");
            return (Criteria) this;
        }

        public Criteria andVDestipresIsNotNull() {
            addCriterion("V_DESTIPRES is not null");
            return (Criteria) this;
        }

        public Criteria andVDestipresEqualTo(String value) {
            addCriterion("V_DESTIPRES =", value, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresNotEqualTo(String value) {
            addCriterion("V_DESTIPRES <>", value, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresGreaterThan(String value) {
            addCriterion("V_DESTIPRES >", value, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESTIPRES >=", value, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresLessThan(String value) {
            addCriterion("V_DESTIPRES <", value, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresLessThanOrEqualTo(String value) {
            addCriterion("V_DESTIPRES <=", value, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresLike(String value) {
            addCriterion("V_DESTIPRES like", value, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresNotLike(String value) {
            addCriterion("V_DESTIPRES not like", value, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresIn(List<String> values) {
            addCriterion("V_DESTIPRES in", values, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresNotIn(List<String> values) {
            addCriterion("V_DESTIPRES not in", values, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresBetween(String value1, String value2) {
            addCriterion("V_DESTIPRES between", value1, value2, "vDestipres");
            return (Criteria) this;
        }

        public Criteria andVDestipresNotBetween(String value1, String value2) {
            addCriterion("V_DESTIPRES not between", value1, value2, "vDestipres");
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
     * This class corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated do_not_delete_during_merge Thu Mar 30 08:50:04 COT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.VST_RESOLUCION
     *
     * @mbggenerated Thu Mar 30 08:50:04 COT 2017
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