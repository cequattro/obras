package pe.gob.sunafil.gestionpersonal.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class RhtbcTurnodiaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public RhtbcTurnodiaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
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
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
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
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
     *
     * @mbggenerated Thu Mar 30 08:50:03 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RRHHSYS.RHTBC_TURNODIA
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
     * This class corresponds to the database table RRHHSYS.RHTBC_TURNODIA
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

        public Criteria andNCodturnodiaIsNull() {
            addCriterion("N_CODTURNODIA is null");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaIsNotNull() {
            addCriterion("N_CODTURNODIA is not null");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaEqualTo(Short value) {
            addCriterion("N_CODTURNODIA =", value, "nCodturnodia");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaNotEqualTo(Short value) {
            addCriterion("N_CODTURNODIA <>", value, "nCodturnodia");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaGreaterThan(Short value) {
            addCriterion("N_CODTURNODIA >", value, "nCodturnodia");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaGreaterThanOrEqualTo(Short value) {
            addCriterion("N_CODTURNODIA >=", value, "nCodturnodia");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaLessThan(Short value) {
            addCriterion("N_CODTURNODIA <", value, "nCodturnodia");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaLessThanOrEqualTo(Short value) {
            addCriterion("N_CODTURNODIA <=", value, "nCodturnodia");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaIn(List<Short> values) {
            addCriterion("N_CODTURNODIA in", values, "nCodturnodia");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaNotIn(List<Short> values) {
            addCriterion("N_CODTURNODIA not in", values, "nCodturnodia");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaBetween(Short value1, Short value2) {
            addCriterion("N_CODTURNODIA between", value1, value2, "nCodturnodia");
            return (Criteria) this;
        }

        public Criteria andNCodturnodiaNotBetween(Short value1, Short value2) {
            addCriterion("N_CODTURNODIA not between", value1, value2, "nCodturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaIsNull() {
            addCriterion("V_DESTURNODIA is null");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaIsNotNull() {
            addCriterion("V_DESTURNODIA is not null");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaEqualTo(String value) {
            addCriterion("V_DESTURNODIA =", value, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaNotEqualTo(String value) {
            addCriterion("V_DESTURNODIA <>", value, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaGreaterThan(String value) {
            addCriterion("V_DESTURNODIA >", value, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESTURNODIA >=", value, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaLessThan(String value) {
            addCriterion("V_DESTURNODIA <", value, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaLessThanOrEqualTo(String value) {
            addCriterion("V_DESTURNODIA <=", value, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaLike(String value) {
            addCriterion("V_DESTURNODIA like", value, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaNotLike(String value) {
            addCriterion("V_DESTURNODIA not like", value, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaIn(List<String> values) {
            addCriterion("V_DESTURNODIA in", values, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaNotIn(List<String> values) {
            addCriterion("V_DESTURNODIA not in", values, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaBetween(String value1, String value2) {
            addCriterion("V_DESTURNODIA between", value1, value2, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnodiaNotBetween(String value1, String value2) {
            addCriterion("V_DESTURNODIA not between", value1, value2, "vDesturnodia");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrIsNull() {
            addCriterion("V_DESTURNOABR is null");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrIsNotNull() {
            addCriterion("V_DESTURNOABR is not null");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrEqualTo(String value) {
            addCriterion("V_DESTURNOABR =", value, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrNotEqualTo(String value) {
            addCriterion("V_DESTURNOABR <>", value, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrGreaterThan(String value) {
            addCriterion("V_DESTURNOABR >", value, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESTURNOABR >=", value, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrLessThan(String value) {
            addCriterion("V_DESTURNOABR <", value, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrLessThanOrEqualTo(String value) {
            addCriterion("V_DESTURNOABR <=", value, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrLike(String value) {
            addCriterion("V_DESTURNOABR like", value, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrNotLike(String value) {
            addCriterion("V_DESTURNOABR not like", value, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrIn(List<String> values) {
            addCriterion("V_DESTURNOABR in", values, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrNotIn(List<String> values) {
            addCriterion("V_DESTURNOABR not in", values, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrBetween(String value1, String value2) {
            addCriterion("V_DESTURNOABR between", value1, value2, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andVDesturnoabrNotBetween(String value1, String value2) {
            addCriterion("V_DESTURNOABR not between", value1, value2, "vDesturnoabr");
            return (Criteria) this;
        }

        public Criteria andNToleranciaIsNull() {
            addCriterion("N_TOLERANCIA is null");
            return (Criteria) this;
        }

        public Criteria andNToleranciaIsNotNull() {
            addCriterion("N_TOLERANCIA is not null");
            return (Criteria) this;
        }

        public Criteria andNToleranciaEqualTo(Short value) {
            addCriterion("N_TOLERANCIA =", value, "nTolerancia");
            return (Criteria) this;
        }

        public Criteria andNToleranciaNotEqualTo(Short value) {
            addCriterion("N_TOLERANCIA <>", value, "nTolerancia");
            return (Criteria) this;
        }

        public Criteria andNToleranciaGreaterThan(Short value) {
            addCriterion("N_TOLERANCIA >", value, "nTolerancia");
            return (Criteria) this;
        }

        public Criteria andNToleranciaGreaterThanOrEqualTo(Short value) {
            addCriterion("N_TOLERANCIA >=", value, "nTolerancia");
            return (Criteria) this;
        }

        public Criteria andNToleranciaLessThan(Short value) {
            addCriterion("N_TOLERANCIA <", value, "nTolerancia");
            return (Criteria) this;
        }

        public Criteria andNToleranciaLessThanOrEqualTo(Short value) {
            addCriterion("N_TOLERANCIA <=", value, "nTolerancia");
            return (Criteria) this;
        }

        public Criteria andNToleranciaIn(List<Short> values) {
            addCriterion("N_TOLERANCIA in", values, "nTolerancia");
            return (Criteria) this;
        }

        public Criteria andNToleranciaNotIn(List<Short> values) {
            addCriterion("N_TOLERANCIA not in", values, "nTolerancia");
            return (Criteria) this;
        }

        public Criteria andNToleranciaBetween(Short value1, Short value2) {
            addCriterion("N_TOLERANCIA between", value1, value2, "nTolerancia");
            return (Criteria) this;
        }

        public Criteria andNToleranciaNotBetween(Short value1, Short value2) {
            addCriterion("N_TOLERANCIA not between", value1, value2, "nTolerancia");
            return (Criteria) this;
        }

        public Criteria andNHorainiIsNull() {
            addCriterion("N_HORAINI is null");
            return (Criteria) this;
        }

        public Criteria andNHorainiIsNotNull() {
            addCriterion("N_HORAINI is not null");
            return (Criteria) this;
        }

        public Criteria andNHorainiEqualTo(Short value) {
            addCriterion("N_HORAINI =", value, "nHoraini");
            return (Criteria) this;
        }

        public Criteria andNHorainiNotEqualTo(Short value) {
            addCriterion("N_HORAINI <>", value, "nHoraini");
            return (Criteria) this;
        }

        public Criteria andNHorainiGreaterThan(Short value) {
            addCriterion("N_HORAINI >", value, "nHoraini");
            return (Criteria) this;
        }

        public Criteria andNHorainiGreaterThanOrEqualTo(Short value) {
            addCriterion("N_HORAINI >=", value, "nHoraini");
            return (Criteria) this;
        }

        public Criteria andNHorainiLessThan(Short value) {
            addCriterion("N_HORAINI <", value, "nHoraini");
            return (Criteria) this;
        }

        public Criteria andNHorainiLessThanOrEqualTo(Short value) {
            addCriterion("N_HORAINI <=", value, "nHoraini");
            return (Criteria) this;
        }

        public Criteria andNHorainiIn(List<Short> values) {
            addCriterion("N_HORAINI in", values, "nHoraini");
            return (Criteria) this;
        }

        public Criteria andNHorainiNotIn(List<Short> values) {
            addCriterion("N_HORAINI not in", values, "nHoraini");
            return (Criteria) this;
        }

        public Criteria andNHorainiBetween(Short value1, Short value2) {
            addCriterion("N_HORAINI between", value1, value2, "nHoraini");
            return (Criteria) this;
        }

        public Criteria andNHorainiNotBetween(Short value1, Short value2) {
            addCriterion("N_HORAINI not between", value1, value2, "nHoraini");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniIsNull() {
            addCriterion("N_MINUTOINI is null");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniIsNotNull() {
            addCriterion("N_MINUTOINI is not null");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniEqualTo(Short value) {
            addCriterion("N_MINUTOINI =", value, "nMinutoini");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniNotEqualTo(Short value) {
            addCriterion("N_MINUTOINI <>", value, "nMinutoini");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniGreaterThan(Short value) {
            addCriterion("N_MINUTOINI >", value, "nMinutoini");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniGreaterThanOrEqualTo(Short value) {
            addCriterion("N_MINUTOINI >=", value, "nMinutoini");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniLessThan(Short value) {
            addCriterion("N_MINUTOINI <", value, "nMinutoini");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniLessThanOrEqualTo(Short value) {
            addCriterion("N_MINUTOINI <=", value, "nMinutoini");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniIn(List<Short> values) {
            addCriterion("N_MINUTOINI in", values, "nMinutoini");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniNotIn(List<Short> values) {
            addCriterion("N_MINUTOINI not in", values, "nMinutoini");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniBetween(Short value1, Short value2) {
            addCriterion("N_MINUTOINI between", value1, value2, "nMinutoini");
            return (Criteria) this;
        }

        public Criteria andNMinutoiniNotBetween(Short value1, Short value2) {
            addCriterion("N_MINUTOINI not between", value1, value2, "nMinutoini");
            return (Criteria) this;
        }

        public Criteria andNHorafinIsNull() {
            addCriterion("N_HORAFIN is null");
            return (Criteria) this;
        }

        public Criteria andNHorafinIsNotNull() {
            addCriterion("N_HORAFIN is not null");
            return (Criteria) this;
        }

        public Criteria andNHorafinEqualTo(Short value) {
            addCriterion("N_HORAFIN =", value, "nHorafin");
            return (Criteria) this;
        }

        public Criteria andNHorafinNotEqualTo(Short value) {
            addCriterion("N_HORAFIN <>", value, "nHorafin");
            return (Criteria) this;
        }

        public Criteria andNHorafinGreaterThan(Short value) {
            addCriterion("N_HORAFIN >", value, "nHorafin");
            return (Criteria) this;
        }

        public Criteria andNHorafinGreaterThanOrEqualTo(Short value) {
            addCriterion("N_HORAFIN >=", value, "nHorafin");
            return (Criteria) this;
        }

        public Criteria andNHorafinLessThan(Short value) {
            addCriterion("N_HORAFIN <", value, "nHorafin");
            return (Criteria) this;
        }

        public Criteria andNHorafinLessThanOrEqualTo(Short value) {
            addCriterion("N_HORAFIN <=", value, "nHorafin");
            return (Criteria) this;
        }

        public Criteria andNHorafinIn(List<Short> values) {
            addCriterion("N_HORAFIN in", values, "nHorafin");
            return (Criteria) this;
        }

        public Criteria andNHorafinNotIn(List<Short> values) {
            addCriterion("N_HORAFIN not in", values, "nHorafin");
            return (Criteria) this;
        }

        public Criteria andNHorafinBetween(Short value1, Short value2) {
            addCriterion("N_HORAFIN between", value1, value2, "nHorafin");
            return (Criteria) this;
        }

        public Criteria andNHorafinNotBetween(Short value1, Short value2) {
            addCriterion("N_HORAFIN not between", value1, value2, "nHorafin");
            return (Criteria) this;
        }

        public Criteria andNMinutofinIsNull() {
            addCriterion("N_MINUTOFIN is null");
            return (Criteria) this;
        }

        public Criteria andNMinutofinIsNotNull() {
            addCriterion("N_MINUTOFIN is not null");
            return (Criteria) this;
        }

        public Criteria andNMinutofinEqualTo(Short value) {
            addCriterion("N_MINUTOFIN =", value, "nMinutofin");
            return (Criteria) this;
        }

        public Criteria andNMinutofinNotEqualTo(Short value) {
            addCriterion("N_MINUTOFIN <>", value, "nMinutofin");
            return (Criteria) this;
        }

        public Criteria andNMinutofinGreaterThan(Short value) {
            addCriterion("N_MINUTOFIN >", value, "nMinutofin");
            return (Criteria) this;
        }

        public Criteria andNMinutofinGreaterThanOrEqualTo(Short value) {
            addCriterion("N_MINUTOFIN >=", value, "nMinutofin");
            return (Criteria) this;
        }

        public Criteria andNMinutofinLessThan(Short value) {
            addCriterion("N_MINUTOFIN <", value, "nMinutofin");
            return (Criteria) this;
        }

        public Criteria andNMinutofinLessThanOrEqualTo(Short value) {
            addCriterion("N_MINUTOFIN <=", value, "nMinutofin");
            return (Criteria) this;
        }

        public Criteria andNMinutofinIn(List<Short> values) {
            addCriterion("N_MINUTOFIN in", values, "nMinutofin");
            return (Criteria) this;
        }

        public Criteria andNMinutofinNotIn(List<Short> values) {
            addCriterion("N_MINUTOFIN not in", values, "nMinutofin");
            return (Criteria) this;
        }

        public Criteria andNMinutofinBetween(Short value1, Short value2) {
            addCriterion("N_MINUTOFIN between", value1, value2, "nMinutofin");
            return (Criteria) this;
        }

        public Criteria andNMinutofinNotBetween(Short value1, Short value2) {
            addCriterion("N_MINUTOFIN not between", value1, value2, "nMinutofin");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RRHHSYS.RHTBC_TURNODIA
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
     * This class corresponds to the database table RRHHSYS.RHTBC_TURNODIA
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