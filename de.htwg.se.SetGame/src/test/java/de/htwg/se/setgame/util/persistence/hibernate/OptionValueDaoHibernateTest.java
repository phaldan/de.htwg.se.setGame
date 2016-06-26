package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.impl.OptionValue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionValueDaoHibernateTest {

    private class HibernateBase extends HibernateBaseDummy {

        @Override
        protected void persist(Object object) {
            objectSpy = object;
        }
    }

    private OptionValueDaoHibernate target;
    private Object objectSpy;

    @Before
    public void setUp() throws Exception {
        target = new OptionValueDaoHibernate(new HibernateBase());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void add_success() throws Exception {
        OptionValue value = new OptionValue();
        target.add(value);
        assertSame(value, objectSpy);
    }

    @Test
    public void update_success() throws Exception {
        OptionValue value = new OptionValue();
        target.update(value);
        assertSame(value, objectSpy);
    }
}