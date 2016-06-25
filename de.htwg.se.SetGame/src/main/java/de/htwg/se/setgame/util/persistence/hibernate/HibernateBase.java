package de.htwg.se.setgame.util.persistence.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Philipp Daniels
 */
public class HibernateBase {

    private SessionFactory factory;
    private Session session;

    protected HibernateBase(SessionFactory factory) {
        this.factory = factory;
    }

    protected Session getSession() {
        session = factory.openSession();
        return session;
    }

    protected void persist(Object object) {
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            session.saveOrUpdate(object);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            close();
        }
    }

    protected Criteria getCriteria(Class aClass) {
        return getSession().createCriteria(aClass);
    }

    protected void close() {
        getSession().close();
    }
}
