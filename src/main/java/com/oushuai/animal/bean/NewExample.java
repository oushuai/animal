package com.oushuai.animal.bean;

import java.util.ArrayList;
import java.util.List;

public class NewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewExample() {
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

        public Criteria andNewIdIsNull() {
            addCriterion("new_id is null");
            return (Criteria) this;
        }

        public Criteria andNewIdIsNotNull() {
            addCriterion("new_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewIdEqualTo(Integer value) {
            addCriterion("new_id =", value, "newId");
            return (Criteria) this;
        }

        public Criteria andNewIdNotEqualTo(Integer value) {
            addCriterion("new_id <>", value, "newId");
            return (Criteria) this;
        }

        public Criteria andNewIdGreaterThan(Integer value) {
            addCriterion("new_id >", value, "newId");
            return (Criteria) this;
        }

        public Criteria andNewIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_id >=", value, "newId");
            return (Criteria) this;
        }

        public Criteria andNewIdLessThan(Integer value) {
            addCriterion("new_id <", value, "newId");
            return (Criteria) this;
        }

        public Criteria andNewIdLessThanOrEqualTo(Integer value) {
            addCriterion("new_id <=", value, "newId");
            return (Criteria) this;
        }

        public Criteria andNewIdIn(List<Integer> values) {
            addCriterion("new_id in", values, "newId");
            return (Criteria) this;
        }

        public Criteria andNewIdNotIn(List<Integer> values) {
            addCriterion("new_id not in", values, "newId");
            return (Criteria) this;
        }

        public Criteria andNewIdBetween(Integer value1, Integer value2) {
            addCriterion("new_id between", value1, value2, "newId");
            return (Criteria) this;
        }

        public Criteria andNewIdNotBetween(Integer value1, Integer value2) {
            addCriterion("new_id not between", value1, value2, "newId");
            return (Criteria) this;
        }

        public Criteria andNewTitleIsNull() {
            addCriterion("new_title is null");
            return (Criteria) this;
        }

        public Criteria andNewTitleIsNotNull() {
            addCriterion("new_title is not null");
            return (Criteria) this;
        }

        public Criteria andNewTitleEqualTo(String value) {
            addCriterion("new_title =", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleNotEqualTo(String value) {
            addCriterion("new_title <>", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleGreaterThan(String value) {
            addCriterion("new_title >", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleGreaterThanOrEqualTo(String value) {
            addCriterion("new_title >=", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleLessThan(String value) {
            addCriterion("new_title <", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleLessThanOrEqualTo(String value) {
            addCriterion("new_title <=", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleLike(String value) {
            addCriterion("new_title like", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleNotLike(String value) {
            addCriterion("new_title not like", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleIn(List<String> values) {
            addCriterion("new_title in", values, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleNotIn(List<String> values) {
            addCriterion("new_title not in", values, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleBetween(String value1, String value2) {
            addCriterion("new_title between", value1, value2, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleNotBetween(String value1, String value2) {
            addCriterion("new_title not between", value1, value2, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewContentIsNull() {
            addCriterion("new_content is null");
            return (Criteria) this;
        }

        public Criteria andNewContentIsNotNull() {
            addCriterion("new_content is not null");
            return (Criteria) this;
        }

        public Criteria andNewContentEqualTo(String value) {
            addCriterion("new_content =", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentNotEqualTo(String value) {
            addCriterion("new_content <>", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentGreaterThan(String value) {
            addCriterion("new_content >", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentGreaterThanOrEqualTo(String value) {
            addCriterion("new_content >=", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentLessThan(String value) {
            addCriterion("new_content <", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentLessThanOrEqualTo(String value) {
            addCriterion("new_content <=", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentLike(String value) {
            addCriterion("new_content like", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentNotLike(String value) {
            addCriterion("new_content not like", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentIn(List<String> values) {
            addCriterion("new_content in", values, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentNotIn(List<String> values) {
            addCriterion("new_content not in", values, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentBetween(String value1, String value2) {
            addCriterion("new_content between", value1, value2, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentNotBetween(String value1, String value2) {
            addCriterion("new_content not between", value1, value2, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1IsNull() {
            addCriterion("new_photo_id1 is null");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1IsNotNull() {
            addCriterion("new_photo_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1EqualTo(String value) {
            addCriterion("new_photo_id1 =", value, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1NotEqualTo(String value) {
            addCriterion("new_photo_id1 <>", value, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1GreaterThan(String value) {
            addCriterion("new_photo_id1 >", value, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1GreaterThanOrEqualTo(String value) {
            addCriterion("new_photo_id1 >=", value, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1LessThan(String value) {
            addCriterion("new_photo_id1 <", value, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1LessThanOrEqualTo(String value) {
            addCriterion("new_photo_id1 <=", value, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1Like(String value) {
            addCriterion("new_photo_id1 like", value, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1NotLike(String value) {
            addCriterion("new_photo_id1 not like", value, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1In(List<String> values) {
            addCriterion("new_photo_id1 in", values, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1NotIn(List<String> values) {
            addCriterion("new_photo_id1 not in", values, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1Between(String value1, String value2) {
            addCriterion("new_photo_id1 between", value1, value2, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId1NotBetween(String value1, String value2) {
            addCriterion("new_photo_id1 not between", value1, value2, "newPhotoId1");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2IsNull() {
            addCriterion("new_photo_id2 is null");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2IsNotNull() {
            addCriterion("new_photo_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2EqualTo(String value) {
            addCriterion("new_photo_id2 =", value, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2NotEqualTo(String value) {
            addCriterion("new_photo_id2 <>", value, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2GreaterThan(String value) {
            addCriterion("new_photo_id2 >", value, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2GreaterThanOrEqualTo(String value) {
            addCriterion("new_photo_id2 >=", value, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2LessThan(String value) {
            addCriterion("new_photo_id2 <", value, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2LessThanOrEqualTo(String value) {
            addCriterion("new_photo_id2 <=", value, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2Like(String value) {
            addCriterion("new_photo_id2 like", value, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2NotLike(String value) {
            addCriterion("new_photo_id2 not like", value, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2In(List<String> values) {
            addCriterion("new_photo_id2 in", values, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2NotIn(List<String> values) {
            addCriterion("new_photo_id2 not in", values, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2Between(String value1, String value2) {
            addCriterion("new_photo_id2 between", value1, value2, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId2NotBetween(String value1, String value2) {
            addCriterion("new_photo_id2 not between", value1, value2, "newPhotoId2");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3IsNull() {
            addCriterion("new_photo_id3 is null");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3IsNotNull() {
            addCriterion("new_photo_id3 is not null");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3EqualTo(String value) {
            addCriterion("new_photo_id3 =", value, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3NotEqualTo(String value) {
            addCriterion("new_photo_id3 <>", value, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3GreaterThan(String value) {
            addCriterion("new_photo_id3 >", value, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3GreaterThanOrEqualTo(String value) {
            addCriterion("new_photo_id3 >=", value, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3LessThan(String value) {
            addCriterion("new_photo_id3 <", value, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3LessThanOrEqualTo(String value) {
            addCriterion("new_photo_id3 <=", value, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3Like(String value) {
            addCriterion("new_photo_id3 like", value, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3NotLike(String value) {
            addCriterion("new_photo_id3 not like", value, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3In(List<String> values) {
            addCriterion("new_photo_id3 in", values, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3NotIn(List<String> values) {
            addCriterion("new_photo_id3 not in", values, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3Between(String value1, String value2) {
            addCriterion("new_photo_id3 between", value1, value2, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewPhotoId3NotBetween(String value1, String value2) {
            addCriterion("new_photo_id3 not between", value1, value2, "newPhotoId3");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsIsNull() {
            addCriterion("new_key_words is null");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsIsNotNull() {
            addCriterion("new_key_words is not null");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsEqualTo(String value) {
            addCriterion("new_key_words =", value, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsNotEqualTo(String value) {
            addCriterion("new_key_words <>", value, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsGreaterThan(String value) {
            addCriterion("new_key_words >", value, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsGreaterThanOrEqualTo(String value) {
            addCriterion("new_key_words >=", value, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsLessThan(String value) {
            addCriterion("new_key_words <", value, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsLessThanOrEqualTo(String value) {
            addCriterion("new_key_words <=", value, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsLike(String value) {
            addCriterion("new_key_words like", value, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsNotLike(String value) {
            addCriterion("new_key_words not like", value, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsIn(List<String> values) {
            addCriterion("new_key_words in", values, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsNotIn(List<String> values) {
            addCriterion("new_key_words not in", values, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsBetween(String value1, String value2) {
            addCriterion("new_key_words between", value1, value2, "newKeyWords");
            return (Criteria) this;
        }

        public Criteria andNewKeyWordsNotBetween(String value1, String value2) {
            addCriterion("new_key_words not between", value1, value2, "newKeyWords");
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