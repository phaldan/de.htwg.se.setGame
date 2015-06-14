package de.htwg.se.setgame.util.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
}
