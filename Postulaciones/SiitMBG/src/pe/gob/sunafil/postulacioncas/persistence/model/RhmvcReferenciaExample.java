package pe.gob.sunafil.postulacioncas.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RhmvcReferenciaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public RhmvcReferenciaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
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
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
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

        public Criteria andNCorrefIsNull() {
            addCriterion("N_CORREF is null");
            return (Criteria) this;
        }

        public Criteria andNCorrefIsNotNull() {
            addCriterion("N_CORREF is not null");
            return (Criteria) this;
        }

        public Criteria andNCorrefEqualTo(BigDecimal value) {
            addCriterion("N_CORREF =", value, "nCorref");
            return (Criteria) this;
        }

        public Criteria andNCorrefNotEqualTo(BigDecimal value) {
            addCriterion("N_CORREF <>", value, "nCorref");
            return (Criteria) this;
        }

        public Criteria andNCorrefGreaterThan(BigDecimal value) {
            addCriterion("N_CORREF >", value, "nCorref");
            return (Criteria) this;
        }

        public Criteria andNCorrefGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORREF >=", value, "nCorref");
            return (Criteria) this;
        }

        public Criteria andNCorrefLessThan(BigDecimal value) {
            addCriterion("N_CORREF <", value, "nCorref");
            return (Criteria) this;
        }

        public Criteria andNCorrefLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORREF <=", value, "nCorref");
            return (Criteria) this;
        }

        public Criteria andNCorrefIn(List<BigDecimal> values) {
            addCriterion("N_CORREF in", values, "nCorref");
            return (Criteria) this;
        }

        public Criteria andNCorrefNotIn(List<BigDecimal> values) {
            addCriterion("N_CORREF not in", values, "nCorref");
            return (Criteria) this;
        }

        public Criteria andNCorrefBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORREF between", value1, value2, "nCorref");
            return (Criteria) this;
        }

        public Criteria andNCorrefNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORREF not between", value1, value2, "nCorref");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidIsNull() {
            addCriterion("N_CORHOJVID is null");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidIsNotNull() {
            addCriterion("N_CORHOJVID is not null");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidEqualTo(BigDecimal value) {
            addCriterion("N_CORHOJVID =", value, "nCorhojvid");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidNotEqualTo(BigDecimal value) {
            addCriterion("N_CORHOJVID <>", value, "nCorhojvid");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidGreaterThan(BigDecimal value) {
            addCriterion("N_CORHOJVID >", value, "nCorhojvid");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORHOJVID >=", value, "nCorhojvid");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidLessThan(BigDecimal value) {
            addCriterion("N_CORHOJVID <", value, "nCorhojvid");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("N_CORHOJVID <=", value, "nCorhojvid");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidIn(List<BigDecimal> values) {
            addCriterion("N_CORHOJVID in", values, "nCorhojvid");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidNotIn(List<BigDecimal> values) {
            addCriterion("N_CORHOJVID not in", values, "nCorhojvid");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORHOJVID between", value1, value2, "nCorhojvid");
            return (Criteria) this;
        }

        public Criteria andNCorhojvidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("N_CORHOJVID not between", value1, value2, "nCorhojvid");
            return (Criteria) this;
        }

        public Criteria andVEntidadIsNull() {
            addCriterion("V_ENTIDAD is null");
            return (Criteria) this;
        }

        public Criteria andVEntidadIsNotNull() {
            addCriterion("V_ENTIDAD is not null");
            return (Criteria) this;
        }

        public Criteria andVEntidadEqualTo(String value) {
            addCriterion("V_ENTIDAD =", value, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadNotEqualTo(String value) {
            addCriterion("V_ENTIDAD <>", value, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadGreaterThan(String value) {
            addCriterion("V_ENTIDAD >", value, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadGreaterThanOrEqualTo(String value) {
            addCriterion("V_ENTIDAD >=", value, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadLessThan(String value) {
            addCriterion("V_ENTIDAD <", value, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadLessThanOrEqualTo(String value) {
            addCriterion("V_ENTIDAD <=", value, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadLike(String value) {
            addCriterion("V_ENTIDAD like", value, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadNotLike(String value) {
            addCriterion("V_ENTIDAD not like", value, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadIn(List<String> values) {
            addCriterion("V_ENTIDAD in", values, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadNotIn(List<String> values) {
            addCriterion("V_ENTIDAD not in", values, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadBetween(String value1, String value2) {
            addCriterion("V_ENTIDAD between", value1, value2, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVEntidadNotBetween(String value1, String value2) {
            addCriterion("V_ENTIDAD not between", value1, value2, "vEntidad");
            return (Criteria) this;
        }

        public Criteria andVNomrefIsNull() {
            addCriterion("V_NOMREF is null");
            return (Criteria) this;
        }

        public Criteria andVNomrefIsNotNull() {
            addCriterion("V_NOMREF is not null");
            return (Criteria) this;
        }

        public Criteria andVNomrefEqualTo(String value) {
            addCriterion("V_NOMREF =", value, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefNotEqualTo(String value) {
            addCriterion("V_NOMREF <>", value, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefGreaterThan(String value) {
            addCriterion("V_NOMREF >", value, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefGreaterThanOrEqualTo(String value) {
            addCriterion("V_NOMREF >=", value, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefLessThan(String value) {
            addCriterion("V_NOMREF <", value, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefLessThanOrEqualTo(String value) {
            addCriterion("V_NOMREF <=", value, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefLike(String value) {
            addCriterion("V_NOMREF like", value, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefNotLike(String value) {
            addCriterion("V_NOMREF not like", value, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefIn(List<String> values) {
            addCriterion("V_NOMREF in", values, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefNotIn(List<String> values) {
            addCriterion("V_NOMREF not in", values, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefBetween(String value1, String value2) {
            addCriterion("V_NOMREF between", value1, value2, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVNomrefNotBetween(String value1, String value2) {
            addCriterion("V_NOMREF not between", value1, value2, "vNomref");
            return (Criteria) this;
        }

        public Criteria andVCargoIsNull() {
            addCriterion("V_CARGO is null");
            return (Criteria) this;
        }

        public Criteria andVCargoIsNotNull() {
            addCriterion("V_CARGO is not null");
            return (Criteria) this;
        }

        public Criteria andVCargoEqualTo(String value) {
            addCriterion("V_CARGO =", value, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoNotEqualTo(String value) {
            addCriterion("V_CARGO <>", value, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoGreaterThan(String value) {
            addCriterion("V_CARGO >", value, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoGreaterThanOrEqualTo(String value) {
            addCriterion("V_CARGO >=", value, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoLessThan(String value) {
            addCriterion("V_CARGO <", value, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoLessThanOrEqualTo(String value) {
            addCriterion("V_CARGO <=", value, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoLike(String value) {
            addCriterion("V_CARGO like", value, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoNotLike(String value) {
            addCriterion("V_CARGO not like", value, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoIn(List<String> values) {
            addCriterion("V_CARGO in", values, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoNotIn(List<String> values) {
            addCriterion("V_CARGO not in", values, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoBetween(String value1, String value2) {
            addCriterion("V_CARGO between", value1, value2, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVCargoNotBetween(String value1, String value2) {
            addCriterion("V_CARGO not between", value1, value2, "vCargo");
            return (Criteria) this;
        }

        public Criteria andVTelefonoIsNull() {
            addCriterion("V_TELEFONO is null");
            return (Criteria) this;
        }

        public Criteria andVTelefonoIsNotNull() {
            addCriterion("V_TELEFONO is not null");
            return (Criteria) this;
        }

        public Criteria andVTelefonoEqualTo(String value) {
            addCriterion("V_TELEFONO =", value, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoNotEqualTo(String value) {
            addCriterion("V_TELEFONO <>", value, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoGreaterThan(String value) {
            addCriterion("V_TELEFONO >", value, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoGreaterThanOrEqualTo(String value) {
            addCriterion("V_TELEFONO >=", value, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoLessThan(String value) {
            addCriterion("V_TELEFONO <", value, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoLessThanOrEqualTo(String value) {
            addCriterion("V_TELEFONO <=", value, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoLike(String value) {
            addCriterion("V_TELEFONO like", value, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoNotLike(String value) {
            addCriterion("V_TELEFONO not like", value, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoIn(List<String> values) {
            addCriterion("V_TELEFONO in", values, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoNotIn(List<String> values) {
            addCriterion("V_TELEFONO not in", values, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoBetween(String value1, String value2) {
            addCriterion("V_TELEFONO between", value1, value2, "vTelefono");
            return (Criteria) this;
        }

        public Criteria andVTelefonoNotBetween(String value1, String value2) {
            addCriterion("V_TELEFONO not between", value1, value2, "vTelefono");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated do_not_delete_during_merge Wed Mar 15 11:22:42 COT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHMVC_REFERENCIA
     *
     * @mbggenerated Wed Mar 15 11:22:42 COT 2017
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