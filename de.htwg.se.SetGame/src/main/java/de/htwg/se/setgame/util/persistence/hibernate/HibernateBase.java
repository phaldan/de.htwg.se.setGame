package de.htwg.se.setgame.util.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Philipp Daniels
 */
public abstract class HibernateBase {

    private SessionFactory factory;

    protected HibernateBase(SessionFactory factory) {
        this.factory = factory;
    }

    protected Session getSession() {
        return factory.openSession();
    }

    protected void persist(Object object) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(object);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }
}
