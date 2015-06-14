package de.htwg.se.setgame.model.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class GameTest {

    private Game target;

    @Before
    public void setUp() throws Exception {
        target = new Game();
    }

    @Test
    public void getId_success() throws Exception {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getPlayers_success() throws Exception {
        Player entity = new Player();
        target.addPlayer(entity);
        assertNotNull(target.getPlayers());
        assertTrue(target.getPlayers().contains(entity));
    }

    @Test
    public void getFieldCardList_success() throws Exception {
        CardList entity = new CardList();
        target.setFieldCardList(entity);
        assertSame(entity, target.getFieldCardList());
    }

    @Test
    public void getUnusedCardList_success() throws Exception {
        CardList entity = new CardList();
        target.setUnusedCardList(entity);
        assertSame(entity, target.getUnusedCardList());
    }

    @Test
    public void getWinner_success() throws Exception {
        Player entity = new Player();
        target.setWinner(entity);
        assertSame(entity, target.getWinner());
    }
}