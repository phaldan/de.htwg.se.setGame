package de.htwg.se.setgame.util.persistence.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class HibernateBaseTest {

    private class SessionFactory extends SessionFactoryDummy {

        @Override
        public Session openSession() throws HibernateException {
            return new SessionDummy() {

                @Override
                public Criteria createCriteria(Class aClass) {
                    return new CriteriaDummy();
                }

                @Override
                public Connection close() throws HibernateException {
                    closeCalled = true;
                    return null;
                }

                @Override
                public void saveOrUpdate(Object o) {
                    object = o;
                }
            };
        }
    }

    private HibernateBase target;
    private boolean closeCalled;
    private Object object;

    @Before
    public void setUp() throws Exception {
        target = new HibernateBase(new SessionFactory());
    }

    @Test
    public void getSession_success() throws Exception {
        assertNotNull(target.getSession());
    }

    @Test
    public void persist_success() throws Exception {
        closeCalled = false;
        Object entity = new Object();
        target.persist(entity);
        assertSame(entity, object);
        assertTrue(closeCalled);
    }

    @Test
    public void getCriteria_success() throws Exception {
        assertNotNull(target.getCriteria(null));
    }

    @Test
    public void close_success() throws Exception {
        closeCalled = false;
        target.getSession();
        target.close();
        assertTrue(closeCalled);
    }
}