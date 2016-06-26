package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.impl.Option;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionDaoHibernateTest {

    private class HibernateBase extends HibernateBaseDummy {

        @Override
        protected void persist(Object object) {
            objectSpy = object;
        }
    }

    private OptionDaoHibernate target;
    private Object objectSpy;

    @Before
    public void setUp() throws Exception {
        target = new OptionDaoHibernate(new HibernateBase());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void add_success() throws Exception {
        Option option = new Option();
        target.add(option);
        assertSame(option, objectSpy);
    }

    @Test
    public void update_success() throws Exception {
        Option option = new Option();
        target.update(option);
        assertSame(option, objectSpy);
    }
}