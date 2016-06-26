package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.TestAppender;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class HibernateManagerTest {

    private HibernateManager target;
    private boolean shutdown;

    @Before
    public void setUp() throws Exception {
        target = new HibernateManager(new SessionFactoryDummy() {

            @Override
            public Session openSession() throws HibernateException {
                return new SessionDummy() {

                    @Override
                    public Connection close() throws HibernateException {
                        shutdown = true;
                        return null;
                    }
                };
            }
        });
    }

    @Test
    public void getCard_success() throws Exception {
        assertNotNull(target.getCard());
    }

    @Test
    public void getCardList_success() throws Exception {
        assertNotNull(target.getCardList());
    }

    @Test
    public void getGame_success() throws Exception {
        assertNotNull(target.getGame());
    }

    @Test
    public void getPlayer_success() throws Exception {
        assertNotNull(target.getPlayer());
    }

    @Test
    public void getOption_success() throws Exception {
        assertNotNull(target.getOption());
    }

    @Test
    public void getOptionValue_success() throws Exception {
        assertNotNull(target.getOptionValue());
    }

    @Test
    public void getCardOption_success() throws Exception {
        assertNotNull(target.getCardOption());
    }

    @Test
    public void constructor() throws Exception {
        try {
            TestAppender appender = new TestAppender();
            Logger.getRootLogger().removeAllAppenders();
            Logger.getRootLogger().addAppender(appender);
            new HibernateManager();
        } catch (JDBCConnectionException e) {

        }
    }

    @Test
    public void exit_success() {
        shutdown = false;
        target.exit();
        assertTrue(shutdown);
    }
}