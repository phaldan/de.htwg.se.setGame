package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionValueHibernateTest {

    private OptionValueHibernate target;

    @Before
    public void setUp() throws Exception {
        target = new OptionValueHibernate();
    }

    @Test
    public void getId_success() throws Exception {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getOption_success() throws Exception {
        OptionHibernate option = new OptionHibernate();
        target.setOption(option);
        assertSame(option, target.getOption());
    }

    @Test
    public void getValue_success() throws Exception {
        target.setValue("one");
        assertEquals("one", target.getValue());
    }
}