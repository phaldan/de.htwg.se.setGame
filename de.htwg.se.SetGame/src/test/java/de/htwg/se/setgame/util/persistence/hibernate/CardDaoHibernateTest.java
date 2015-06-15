package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.CardDummy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardDaoHibernateTest {

    private class HibernateBase extends HibernateBaseDummy {

        @Override
        protected void persist(Object object) {
            objectSpy = object;
        }
    }

    private CardDaoHibernate target;
    private Object objectSpy;

    @Before
    public void setUp() throws Exception {
        target = new CardDaoHibernate(new HibernateBase());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void add_success() throws Exception {
        CardDummy entity = new CardDummy();
        target.add(entity);
        assertSame(entity, objectSpy);
    }

    @Test
    public void update_success() throws Exception {
        CardDummy entity = new CardDummy();
        target.update(entity);
        assertSame(entity, objectSpy);
    }
}