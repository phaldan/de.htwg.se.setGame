package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import de.htwg.se.setgame.model.IPlayer;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class GameHibernateTest {

    private GameHibernate target;

    @Before
    public void setUp() throws Exception {
        target = new GameHibernate();
    }

    @Test
    public void getId_success() throws Exception {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getFieldCardList_success() throws Exception {
        CardListHibernate entity = new CardListHibernate();
        target.setFieldCardList(entity);
        assertSame(entity, target.getFieldCardList());
    }

    @Test
    public void getUnusedCardList_success() throws Exception {
        CardListHibernate entity = new CardListHibernate();
        target.setUnusedCardList(entity);
        assertSame(entity, target.getUnusedCardList());
    }

    @Test
    public void getWinner_success() throws Exception {
        PlayerHibernate entity = new PlayerHibernate();
        target.setWinner(entity);
        assertSame(entity, target.getWinner());
    }

    @Test
    public void getPlayers_success() throws Exception {
        Set<IPlayer> list = new LinkedHashSet<>();
        target.setPlayers(list);
        assertSame(list, target.getPlayers());
    }
}