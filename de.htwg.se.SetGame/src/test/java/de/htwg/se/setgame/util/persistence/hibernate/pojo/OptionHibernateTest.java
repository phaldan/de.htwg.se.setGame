package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionHibernateTest {

    private OptionHibernate target;

    @Before
    public void setUp() throws Exception {
        target = new OptionHibernate();
    }

    @Test
    public void getId_success() throws Exception {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getName_success() throws Exception {
        target.setName("count");
        assertEquals("count", target.getName());
    }
}