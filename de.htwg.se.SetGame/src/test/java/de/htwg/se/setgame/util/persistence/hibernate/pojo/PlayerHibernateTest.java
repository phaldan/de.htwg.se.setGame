package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class PlayerHibernateTest {

    private PlayerHibernate target;

    @Before
    public void setUp() throws Exception {
        target = new PlayerHibernate();
    }

    @Test
    public void getId_success() throws Exception {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getName_success() throws Exception {
        target.setName("player");
        assertEquals("player", target.getName());
    }

    @Test
    public void getScore_success() throws Exception {
        target.setScore(1337);
        assertEquals(1337, target.getScore());
    }

    @Test
    public void getGame_success() throws Exception {
        GameHibernate entity = new GameHibernate();
        target.setGame(entity);
        assertSame(entity, target.getGame());
    }
}