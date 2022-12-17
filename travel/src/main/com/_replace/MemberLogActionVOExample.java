package com._replace;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberLogActionVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberLogActionVOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andMaIdxIsNull() {
            addCriterion("ma_idx is null");
            return (Criteria) this;
        }

        public Criteria andMaIdxIsNotNull() {
            addCriterion("ma_idx is not null");
            return (Criteria) this;
        }

        public Criteria andMaIdxEqualTo(Long value) {
            addCriterion("ma_idx =", value, "maIdx");
            return (Criteria) this;
        }

        public Criteria andMaIdxNotEqualTo(Long value) {
            addCriterion("ma_idx <>", value, "maIdx");
            return (Criteria) this;
        }

        public Criteria andMaIdxGreaterThan(Long value) {
            addCriterion("ma_idx >", value, "maIdx");
            return (Criteria) this;
        }

        public Criteria andMaIdxGreaterThanOrEqualTo(Long value) {
            addCriterion("ma_idx >=", value, "maIdx");
            return (Criteria) this;
        }

        public Criteria andMaIdxLessThan(Long value) {
            addCriterion("ma_idx <", value, "maIdx");
            return (Criteria) this;
        }

        public Criteria andMaIdxLessThanOrEqualTo(Long value) {
            addCriterion("ma_idx <=", value, "maIdx");
            return (Criteria) this;
        }

        public Criteria andMaIdxIn(List<Long> values) {
            addCriterion("ma_idx in", values, "maIdx");
            return (Criteria) this;
        }

        public Criteria andMaIdxNotIn(List<Long> values) {
            addCriterion("ma_idx not in", values, "maIdx");
            return (Criteria) this;
        }

        public Criteria andMaIdxBetween(Long value1, Long value2) {
            addCriterion("ma_idx between", value1, value2, "maIdx");
            return (Criteria) this;
        }

        public Criteria andMaIdxNotBetween(Long value1, Long value2) {
            addCriterion("ma_idx not between", value1, value2, "maIdx");
            return (Criteria) this;
        }

        public Criteria andMaStateIsNull() {
            addCriterion("ma_state is null");
            return (Criteria) this;
        }

        public Criteria andMaStateIsNotNull() {
            addCriterion("ma_state is not null");
            return (Criteria) this;
        }

        public Criteria andMaStateEqualTo(Boolean value) {
            addCriterion("ma_state =", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateNotEqualTo(Boolean value) {
            addCriterion("ma_state <>", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateGreaterThan(Boolean value) {
            addCriterion("ma_state >", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ma_state >=", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateLessThan(Boolean value) {
            addCriterion("ma_state <", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateLessThanOrEqualTo(Boolean value) {
            addCriterion("ma_state <=", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateIn(List<Boolean> values) {
            addCriterion("ma_state in", values, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateNotIn(List<Boolean> values) {
            addCriterion("ma_state not in", values, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateBetween(Boolean value1, Boolean value2) {
            addCriterion("ma_state between", value1, value2, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ma_state not between", value1, value2, "maState");
            return (Criteria) this;
        }

        public Criteria andMaTypeIsNull() {
            addCriterion("ma_type is null");
            return (Criteria) this;
        }

        public Criteria andMaTypeIsNotNull() {
            addCriterion("ma_type is not null");
            return (Criteria) this;
        }

        public Criteria andMaTypeEqualTo(Boolean value) {
            addCriterion("ma_type =", value, "maType");
            return (Criteria) this;
        }

        public Criteria andMaTypeNotEqualTo(Boolean value) {
            addCriterion("ma_type <>", value, "maType");
            return (Criteria) this;
        }

        public Criteria andMaTypeGreaterThan(Boolean value) {
            addCriterion("ma_type >", value, "maType");
            return (Criteria) this;
        }

        public Criteria andMaTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ma_type >=", value, "maType");
            return (Criteria) this;
        }

        public Criteria andMaTypeLessThan(Boolean value) {
            addCriterion("ma_type <", value, "maType");
            return (Criteria) this;
        }

        public Criteria andMaTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("ma_type <=", value, "maType");
            return (Criteria) this;
        }

        public Criteria andMaTypeIn(List<Boolean> values) {
            addCriterion("ma_type in", values, "maType");
            return (Criteria) this;
        }

        public Criteria andMaTypeNotIn(List<Boolean> values) {
            addCriterion("ma_type not in", values, "maType");
            return (Criteria) this;
        }

        public Criteria andMaTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("ma_type between", value1, value2, "maType");
            return (Criteria) this;
        }

        public Criteria andMaTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ma_type not between", value1, value2, "maType");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateIsNull() {
            addCriterion("ma_create_date is null");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateIsNotNull() {
            addCriterion("ma_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateEqualTo(Date value) {
            addCriterion("ma_create_date =", value, "maCreateDate");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateNotEqualTo(Date value) {
            addCriterion("ma_create_date <>", value, "maCreateDate");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateGreaterThan(Date value) {
            addCriterion("ma_create_date >", value, "maCreateDate");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ma_create_date >=", value, "maCreateDate");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateLessThan(Date value) {
            addCriterion("ma_create_date <", value, "maCreateDate");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("ma_create_date <=", value, "maCreateDate");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateIn(List<Date> values) {
            addCriterion("ma_create_date in", values, "maCreateDate");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateNotIn(List<Date> values) {
            addCriterion("ma_create_date not in", values, "maCreateDate");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateBetween(Date value1, Date value2) {
            addCriterion("ma_create_date between", value1, value2, "maCreateDate");
            return (Criteria) this;
        }

        public Criteria andMaCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("ma_create_date not between", value1, value2, "maCreateDate");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxIsNull() {
            addCriterion("ma_mb_idx is null");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxIsNotNull() {
            addCriterion("ma_mb_idx is not null");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxEqualTo(Long value) {
            addCriterion("ma_mb_idx =", value, "maMbIdx");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxNotEqualTo(Long value) {
            addCriterion("ma_mb_idx <>", value, "maMbIdx");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxGreaterThan(Long value) {
            addCriterion("ma_mb_idx >", value, "maMbIdx");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxGreaterThanOrEqualTo(Long value) {
            addCriterion("ma_mb_idx >=", value, "maMbIdx");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxLessThan(Long value) {
            addCriterion("ma_mb_idx <", value, "maMbIdx");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxLessThanOrEqualTo(Long value) {
            addCriterion("ma_mb_idx <=", value, "maMbIdx");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxIn(List<Long> values) {
            addCriterion("ma_mb_idx in", values, "maMbIdx");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxNotIn(List<Long> values) {
            addCriterion("ma_mb_idx not in", values, "maMbIdx");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxBetween(Long value1, Long value2) {
            addCriterion("ma_mb_idx between", value1, value2, "maMbIdx");
            return (Criteria) this;
        }

        public Criteria andMaMbIdxNotBetween(Long value1, Long value2) {
            addCriterion("ma_mb_idx not between", value1, value2, "maMbIdx");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxIsNull() {
            addCriterion("ma_ct_idx is null");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxIsNotNull() {
            addCriterion("ma_ct_idx is not null");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxEqualTo(Long value) {
            addCriterion("ma_ct_idx =", value, "maCtIdx");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxNotEqualTo(Long value) {
            addCriterion("ma_ct_idx <>", value, "maCtIdx");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxGreaterThan(Long value) {
            addCriterion("ma_ct_idx >", value, "maCtIdx");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxGreaterThanOrEqualTo(Long value) {
            addCriterion("ma_ct_idx >=", value, "maCtIdx");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxLessThan(Long value) {
            addCriterion("ma_ct_idx <", value, "maCtIdx");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxLessThanOrEqualTo(Long value) {
            addCriterion("ma_ct_idx <=", value, "maCtIdx");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxIn(List<Long> values) {
            addCriterion("ma_ct_idx in", values, "maCtIdx");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxNotIn(List<Long> values) {
            addCriterion("ma_ct_idx not in", values, "maCtIdx");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxBetween(Long value1, Long value2) {
            addCriterion("ma_ct_idx between", value1, value2, "maCtIdx");
            return (Criteria) this;
        }

        public Criteria andMaCtIdxNotBetween(Long value1, Long value2) {
            addCriterion("ma_ct_idx not between", value1, value2, "maCtIdx");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxIsNull() {
            addCriterion("ma_mt_idx is null");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxIsNotNull() {
            addCriterion("ma_mt_idx is not null");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxEqualTo(Long value) {
            addCriterion("ma_mt_idx =", value, "maMtIdx");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxNotEqualTo(Long value) {
            addCriterion("ma_mt_idx <>", value, "maMtIdx");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxGreaterThan(Long value) {
            addCriterion("ma_mt_idx >", value, "maMtIdx");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxGreaterThanOrEqualTo(Long value) {
            addCriterion("ma_mt_idx >=", value, "maMtIdx");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxLessThan(Long value) {
            addCriterion("ma_mt_idx <", value, "maMtIdx");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxLessThanOrEqualTo(Long value) {
            addCriterion("ma_mt_idx <=", value, "maMtIdx");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxIn(List<Long> values) {
            addCriterion("ma_mt_idx in", values, "maMtIdx");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxNotIn(List<Long> values) {
            addCriterion("ma_mt_idx not in", values, "maMtIdx");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxBetween(Long value1, Long value2) {
            addCriterion("ma_mt_idx between", value1, value2, "maMtIdx");
            return (Criteria) this;
        }

        public Criteria andMaMtIdxNotBetween(Long value1, Long value2) {
            addCriterion("ma_mt_idx not between", value1, value2, "maMtIdx");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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