package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardListHibernateTest {

    private CardListHibernate target;

    @Before
    public void setUp() throws Exception {
        target = new CardListHibernate();
    }

    @Test
    public void getId_success() throws Exception {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getCards_success() throws Exception {
        CardHibernate entity = new CardHibernate();
        target.addCard(entity);
        assertTrue(target.getCards().contains(entity));
    }

    @Test
    public void getGame_success() throws Exception {
        GameHibernate entity = new GameHibernate();
        target.setGame(entity);
        assertSame(entity, target.getGame());
    }
}