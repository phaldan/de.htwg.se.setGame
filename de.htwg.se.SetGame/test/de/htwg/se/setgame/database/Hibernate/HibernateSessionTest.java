package de.htwg.se.setgame.database.Hibernate;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Pavan on 29/05/2015.
 */


public class HibernateSessionTest extends TestCase {

    @Test
    public void testConfigureSession() throws Exception {
        HibernateSession hibernateSession = new HibernateSession();
        Session ret_Session = hibernateSession.configureSession();
        assertNotNull(ret_Session);
    }
}