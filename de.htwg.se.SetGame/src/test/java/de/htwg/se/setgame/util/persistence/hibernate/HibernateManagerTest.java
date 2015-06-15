package de.htwg.se.setgame.util.persistence.hibernate;

import org.hibernate.exception.JDBCConnectionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class HibernateManagerTest {

    private HibernateManager target;

    @Before
    public void setUp() throws Exception {
        target = new HibernateManager(new SessionFactoryDummy());
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
    public void test() throws Exception {
        try {
            new HibernateManager();
        } catch (JDBCConnectionException e) {

        }
    }
}