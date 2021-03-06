package pe.gob.sunafil.tramiteext.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class SitbDistritoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public SitbDistritoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
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
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
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
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
     *
     * @mbggenerated Tue Mar 14 12:53:03 COT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SIMINTRA1.SITB_DISTRITO
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
     * This class corresponds to the database table SIMINTRA1.SITB_DISTRITO
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

        public Criteria andVCoddepIsNull() {
            addCriterion("V_CODDEP is null");
            return (Criteria) this;
        }

        public Criteria andVCoddepIsNotNull() {
            addCriterion("V_CODDEP is not null");
            return (Criteria) this;
        }

        public Criteria andVCoddepEqualTo(String value) {
            addCriterion("V_CODDEP =", value, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepNotEqualTo(String value) {
            addCriterion("V_CODDEP <>", value, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepGreaterThan(String value) {
            addCriterion("V_CODDEP >", value, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODDEP >=", value, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepLessThan(String value) {
            addCriterion("V_CODDEP <", value, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepLessThanOrEqualTo(String value) {
            addCriterion("V_CODDEP <=", value, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepLike(String value) {
            addCriterion("V_CODDEP like", value, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepNotLike(String value) {
            addCriterion("V_CODDEP not like", value, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepIn(List<String> values) {
            addCriterion("V_CODDEP in", values, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepNotIn(List<String> values) {
            addCriterion("V_CODDEP not in", values, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepBetween(String value1, String value2) {
            addCriterion("V_CODDEP between", value1, value2, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCoddepNotBetween(String value1, String value2) {
            addCriterion("V_CODDEP not between", value1, value2, "vCoddep");
            return (Criteria) this;
        }

        public Criteria andVCodproIsNull() {
            addCriterion("V_CODPRO is null");
            return (Criteria) this;
        }

        public Criteria andVCodproIsNotNull() {
            addCriterion("V_CODPRO is not null");
            return (Criteria) this;
        }

        public Criteria andVCodproEqualTo(String value) {
            addCriterion("V_CODPRO =", value, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproNotEqualTo(String value) {
            addCriterion("V_CODPRO <>", value, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproGreaterThan(String value) {
            addCriterion("V_CODPRO >", value, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODPRO >=", value, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproLessThan(String value) {
            addCriterion("V_CODPRO <", value, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproLessThanOrEqualTo(String value) {
            addCriterion("V_CODPRO <=", value, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproLike(String value) {
            addCriterion("V_CODPRO like", value, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproNotLike(String value) {
            addCriterion("V_CODPRO not like", value, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproIn(List<String> values) {
            addCriterion("V_CODPRO in", values, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproNotIn(List<String> values) {
            addCriterion("V_CODPRO not in", values, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproBetween(String value1, String value2) {
            addCriterion("V_CODPRO between", value1, value2, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andVCodproNotBetween(String value1, String value2) {
            addCriterion("V_CODPRO not between", value1, value2, "vCodpro");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("V_CODDIS is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("V_CODDIS is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("V_CODDIS =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("V_CODDIS <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("V_CODDIS >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODDIS >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("V_CODDIS <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("V_CODDIS <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("V_CODDIS like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("V_CODDIS not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("V_CODDIS in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("V_CODDIS not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("V_CODDIS between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("V_CODDIS not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDescripcionIsNull() {
            addCriterion("V_DESDIS is null");
            return (Criteria) this;
        }

        public Criteria andDescripcionIsNotNull() {
            addCriterion("V_DESDIS is not null");
            return (Criteria) this;
        }

        public Criteria andDescripcionEqualTo(String value) {
            addCriterion("V_DESDIS =", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotEqualTo(String value) {
            addCriterion("V_DESDIS <>", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThan(String value) {
            addCriterion("V_DESDIS >", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThanOrEqualTo(String value) {
            addCriterion("V_DESDIS >=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThan(String value) {
            addCriterion("V_DESDIS <", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThanOrEqualTo(String value) {
            addCriterion("V_DESDIS <=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLike(String value) {
            addCriterion("V_DESDIS like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotLike(String value) {
            addCriterion("V_DESDIS not like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionIn(List<String> values) {
            addCriterion("V_DESDIS in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotIn(List<String> values) {
            addCriterion("V_DESDIS not in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionBetween(String value1, String value2) {
            addCriterion("V_DESDIS between", value1, value2, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotBetween(String value1, String value2) {
            addCriterion("V_DESDIS not between", value1, value2, "descripcion");
            return (Criteria) this;
        }

        public Criteria andVAbrdisIsNull() {
            addCriterion("V_ABRDIS is null");
            return (Criteria) this;
        }

        public Criteria andVAbrdisIsNotNull() {
            addCriterion("V_ABRDIS is not null");
            return (Criteria) this;
        }

        public Criteria andVAbrdisEqualTo(String value) {
            addCriterion("V_ABRDIS =", value, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisNotEqualTo(String value) {
            addCriterion("V_ABRDIS <>", value, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisGreaterThan(String value) {
            addCriterion("V_ABRDIS >", value, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisGreaterThanOrEqualTo(String value) {
            addCriterion("V_ABRDIS >=", value, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisLessThan(String value) {
            addCriterion("V_ABRDIS <", value, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisLessThanOrEqualTo(String value) {
            addCriterion("V_ABRDIS <=", value, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisLike(String value) {
            addCriterion("V_ABRDIS like", value, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisNotLike(String value) {
            addCriterion("V_ABRDIS not like", value, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisIn(List<String> values) {
            addCriterion("V_ABRDIS in", values, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisNotIn(List<String> values) {
            addCriterion("V_ABRDIS not in", values, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisBetween(String value1, String value2) {
            addCriterion("V_ABRDIS between", value1, value2, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVAbrdisNotBetween(String value1, String value2) {
            addCriterion("V_ABRDIS not between", value1, value2, "vAbrdis");
            return (Criteria) this;
        }

        public Criteria andVCodregIsNull() {
            addCriterion("V_CODREG is null");
            return (Criteria) this;
        }

        public Criteria andVCodregIsNotNull() {
            addCriterion("V_CODREG is not null");
            return (Criteria) this;
        }

        public Criteria andVCodregEqualTo(String value) {
            addCriterion("V_CODREG =", value, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregNotEqualTo(String value) {
            addCriterion("V_CODREG <>", value, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregGreaterThan(String value) {
            addCriterion("V_CODREG >", value, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODREG >=", value, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregLessThan(String value) {
            addCriterion("V_CODREG <", value, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregLessThanOrEqualTo(String value) {
            addCriterion("V_CODREG <=", value, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregLike(String value) {
            addCriterion("V_CODREG like", value, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregNotLike(String value) {
            addCriterion("V_CODREG not like", value, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregIn(List<String> values) {
            addCriterion("V_CODREG in", values, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregNotIn(List<String> values) {
            addCriterion("V_CODREG not in", values, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregBetween(String value1, String value2) {
            addCriterion("V_CODREG between", value1, value2, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodregNotBetween(String value1, String value2) {
            addCriterion("V_CODREG not between", value1, value2, "vCodreg");
            return (Criteria) this;
        }

        public Criteria andVCodzonIsNull() {
            addCriterion("V_CODZON is null");
            return (Criteria) this;
        }

        public Criteria andVCodzonIsNotNull() {
            addCriterion("V_CODZON is not null");
            return (Criteria) this;
        }

        public Criteria andVCodzonEqualTo(String value) {
            addCriterion("V_CODZON =", value, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonNotEqualTo(String value) {
            addCriterion("V_CODZON <>", value, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonGreaterThan(String value) {
            addCriterion("V_CODZON >", value, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODZON >=", value, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonLessThan(String value) {
            addCriterion("V_CODZON <", value, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonLessThanOrEqualTo(String value) {
            addCriterion("V_CODZON <=", value, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonLike(String value) {
            addCriterion("V_CODZON like", value, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonNotLike(String value) {
            addCriterion("V_CODZON not like", value, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonIn(List<String> values) {
            addCriterion("V_CODZON in", values, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonNotIn(List<String> values) {
            addCriterion("V_CODZON not in", values, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonBetween(String value1, String value2) {
            addCriterion("V_CODZON between", value1, value2, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCodzonNotBetween(String value1, String value2) {
            addCriterion("V_CODZON not between", value1, value2, "vCodzon");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenIsNull() {
            addCriterion("V_CODDEPREN is null");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenIsNotNull() {
            addCriterion("V_CODDEPREN is not null");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenEqualTo(String value) {
            addCriterion("V_CODDEPREN =", value, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenNotEqualTo(String value) {
            addCriterion("V_CODDEPREN <>", value, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenGreaterThan(String value) {
            addCriterion("V_CODDEPREN >", value, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODDEPREN >=", value, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenLessThan(String value) {
            addCriterion("V_CODDEPREN <", value, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenLessThanOrEqualTo(String value) {
            addCriterion("V_CODDEPREN <=", value, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenLike(String value) {
            addCriterion("V_CODDEPREN like", value, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenNotLike(String value) {
            addCriterion("V_CODDEPREN not like", value, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenIn(List<String> values) {
            addCriterion("V_CODDEPREN in", values, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenNotIn(List<String> values) {
            addCriterion("V_CODDEPREN not in", values, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenBetween(String value1, String value2) {
            addCriterion("V_CODDEPREN between", value1, value2, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCoddeprenNotBetween(String value1, String value2) {
            addCriterion("V_CODDEPREN not between", value1, value2, "vCoddepren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenIsNull() {
            addCriterion("V_CODPROREN is null");
            return (Criteria) this;
        }

        public Criteria andVCodprorenIsNotNull() {
            addCriterion("V_CODPROREN is not null");
            return (Criteria) this;
        }

        public Criteria andVCodprorenEqualTo(String value) {
            addCriterion("V_CODPROREN =", value, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenNotEqualTo(String value) {
            addCriterion("V_CODPROREN <>", value, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenGreaterThan(String value) {
            addCriterion("V_CODPROREN >", value, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODPROREN >=", value, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenLessThan(String value) {
            addCriterion("V_CODPROREN <", value, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenLessThanOrEqualTo(String value) {
            addCriterion("V_CODPROREN <=", value, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenLike(String value) {
            addCriterion("V_CODPROREN like", value, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenNotLike(String value) {
            addCriterion("V_CODPROREN not like", value, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenIn(List<String> values) {
            addCriterion("V_CODPROREN in", values, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenNotIn(List<String> values) {
            addCriterion("V_CODPROREN not in", values, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenBetween(String value1, String value2) {
            addCriterion("V_CODPROREN between", value1, value2, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCodprorenNotBetween(String value1, String value2) {
            addCriterion("V_CODPROREN not between", value1, value2, "vCodproren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenIsNull() {
            addCriterion("V_CODDISREN is null");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenIsNotNull() {
            addCriterion("V_CODDISREN is not null");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenEqualTo(String value) {
            addCriterion("V_CODDISREN =", value, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenNotEqualTo(String value) {
            addCriterion("V_CODDISREN <>", value, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenGreaterThan(String value) {
            addCriterion("V_CODDISREN >", value, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenGreaterThanOrEqualTo(String value) {
            addCriterion("V_CODDISREN >=", value, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenLessThan(String value) {
            addCriterion("V_CODDISREN <", value, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenLessThanOrEqualTo(String value) {
            addCriterion("V_CODDISREN <=", value, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenLike(String value) {
            addCriterion("V_CODDISREN like", value, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenNotLike(String value) {
            addCriterion("V_CODDISREN not like", value, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenIn(List<String> values) {
            addCriterion("V_CODDISREN in", values, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenNotIn(List<String> values) {
            addCriterion("V_CODDISREN not in", values, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenBetween(String value1, String value2) {
            addCriterion("V_CODDISREN between", value1, value2, "vCoddisren");
            return (Criteria) this;
        }

        public Criteria andVCoddisrenNotBetween(String value1, String value2) {
            addCriterion("V_CODDISREN not between", value1, value2, "vCoddisren");
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
     * This class corresponds to the database table SIMINTRA1.SITB_DISTRITO
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
     * This class corresponds to the database table SIMINTRA1.SITB_DISTRITO
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