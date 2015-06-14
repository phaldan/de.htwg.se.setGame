package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import org.junit.Before;
import org.junit.Test;


import java.util.LinkedHashSet;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardListTest {

    private CardList target;

    @Before
    public void setUp() {
        target = new CardList();
    }

    @Test
    public void getCards_success() {
        java.util.Set<ICard> list = new LinkedHashSet<>();
        target.setCards(list);
        assertNotNull(target.getCards());
        assertSame(list, target.getCards());
    }

    @Test
    public void getId_success() {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getGame_success() {
        Game entity = new Game();
        target.setGame(entity);
        assertSame(entity, target.getGame());
    }
}
