package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.PlayerDummy;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class PlayerDaoHibernateTest {

    private class HibernateBase extends HibernateBaseDummy {

        @Override
        protected void persist(Object object) {
            objectSpy = object;
        }

        @Override
        protected Criteria getCriteria(Class aClass) {
            return new CriteriaDummy() {

                @Override
                public Object uniqueResult() throws HibernateException {
                    return objectStub;
                }
            };
        }
    }

    private PlayerDaoHibernate target;
    private Object objectSpy;
    private Object objectStub;

    @Before
    public void setUp() {
        target = new PlayerDaoHibernate(new HibernateBase());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void getByName_success() throws Exception {
        objectStub = new PlayerDummy();
        assertSame(objectStub, target.getByName("name"));
    }

    @Test
    public void add_success() throws Exception {
        PlayerDummy entity = new PlayerDummy();
        target.add(entity);
        assertSame(entity, objectSpy);
    }

    @Test
    public void update_success() throws Exception {
        PlayerDummy entity = new PlayerDummy();
        target.update(entity);
        assertSame(entity, objectSpy);
    }
}