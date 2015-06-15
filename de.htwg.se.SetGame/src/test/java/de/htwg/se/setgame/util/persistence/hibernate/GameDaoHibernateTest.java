package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.PlayerDummy;
import de.htwg.se.setgame.model.impl.GameDummy;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class GameDaoHibernateTest {

    private class HibernateBase extends HibernateBaseDummy {

        @Override
        protected void persist(Object object) {
            objectSpy = object;
        }

        @Override
        protected Criteria getCriteria(Class aClass) {
            return new CriteriaDummy() {

                @Override
                public List list() throws HibernateException {
                    return list;
                }
            };
        }
    }

    private GameDaoHibernate target;
    private Object objectSpy;
    private List<GameDummy> list = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        target = new GameDaoHibernate(new HibernateBase());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void getByPlayer_success() throws Exception {
        assertNotNull(target.getByPlayer(new PlayerDummy()));
    }

    @Test
    public void add_success() throws Exception {
        GameDummy entity = new GameDummy();
        target.add(entity);
        assertSame(entity, objectSpy);
    }

    @Test
    public void update_success() throws Exception {
        GameDummy entity = new GameDummy();
        target.update(entity);
        assertSame(entity, objectSpy);
    }
}