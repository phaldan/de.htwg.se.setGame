package de.htwg.se.setgame.util.persistence.hibernate;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.ResultTransformer;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class CriteriaDummy implements Criteria {

    @Override
    public String getAlias() {
        return null;
    }

    @Override
    public Criteria setProjection(Projection projection) {
        return this;
    }

    @Override
    public Criteria add(Criterion criterion) {
        return this;
    }

    @Override
    public Criteria addOrder(Order order) {
        return this;
    }

    @Override
    public Criteria setFetchMode(String s, FetchMode fetchMode) throws HibernateException {
        return this;
    }

    @Override
    public Criteria setLockMode(LockMode lockMode) {
        return this;
    }

    @Override
    public Criteria setLockMode(String s, LockMode lockMode) {
        return this;
    }

    @Override
    public Criteria createAlias(String s, String s1) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createAlias(String s, String s1, JoinType joinType) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createAlias(String s, String s1, int i) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createAlias(String s, String s1, JoinType joinType, Criterion criterion) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createAlias(String s, String s1, int i, Criterion criterion) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createCriteria(String s) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createCriteria(String s, JoinType joinType) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createCriteria(String s, int i) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createCriteria(String s, String s1) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createCriteria(String s, String s1, JoinType joinType) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createCriteria(String s, String s1, int i) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createCriteria(String s, String s1, JoinType joinType, Criterion criterion) throws HibernateException {
        return this;
    }

    @Override
    public Criteria createCriteria(String s, String s1, int i, Criterion criterion) throws HibernateException {
        return this;
    }

    @Override
    public Criteria setResultTransformer(ResultTransformer resultTransformer) {
        return this;
    }

    @Override
    public Criteria setMaxResults(int i) {
        return this;
    }

    @Override
    public Criteria setFirstResult(int i) {
        return this;
    }

    @Override
    public boolean isReadOnlyInitialized() {
        return false;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public Criteria setReadOnly(boolean b) {
        return this;
    }

    @Override
    public Criteria setFetchSize(int i) {
        return this;
    }

    @Override
    public Criteria setTimeout(int i) {
        return this;
    }

    @Override
    public Criteria setCacheable(boolean b) {
        return this;
    }

    @Override
    public Criteria setCacheRegion(String s) {
        return this;
    }

    @Override
    public Criteria setComment(String s) {
        return this;
    }

    @Override
    public Criteria addQueryHint(String s) {
        return this;
    }

    @Override
    public Criteria setFlushMode(FlushMode flushMode) {
        return this;
    }

    @Override
    public Criteria setCacheMode(CacheMode cacheMode) {
        return this;
    }

    @Override
    public List list() throws HibernateException {
        return null;
    }

    @Override
    public ScrollableResults scroll() throws HibernateException {
        return null;
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) throws HibernateException {
        return null;
    }

    @Override
    public Object uniqueResult() throws HibernateException {
        return null;
    }
}
