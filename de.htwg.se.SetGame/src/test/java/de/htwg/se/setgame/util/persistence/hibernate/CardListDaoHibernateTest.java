package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.CardListDummy;
import de.htwg.se.setgame.model.impl.GameDummy;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardListDaoHibernateTest {

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

    private CardListDaoHibernate target;
    private Object objectSpy;
    private Object objectStub;

    @Before
    public void setUp() throws Exception {
        target = new CardListDaoHibernate(new HibernateBase());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void getByGame_success() throws Exception {
        objectStub = new CardListDummy();
        assertSame(objectStub, target.getByGame(new GameDummy()));
    }

    @Test
    public void add_success() throws Exception {
        CardListDummy entity = new CardListDummy();
        target.add(entity);
        assertSame(entity, objectSpy);
    }

    @Test
    public void update_success() throws Exception {
        CardListDummy entity = new CardListDummy();
        target.update(entity);
        assertSame(entity, objectSpy);
    }
}