package de.htwg.se.setgame.util.persistence.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * @author Philipp Daniels
 */
public class HibernateBaseDummy extends HibernateBase {

    protected HibernateBaseDummy() {
        super(new SessionFactoryDummy());
    }

    @Override
    protected Session getSession() {
        return null;
    }

    @Override
    protected void persist(Object object) {

    }

    @Override
    protected Criteria getCriteria(Class aClass) {
        return null;
    }

    @Override
    protected void close() {

    }
}
