package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.CardDummy;
import org.junit.Before;
import org.junit.Test;

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
        assertNotNull(target.getCards());
        assertEquals(0, target.getCards().size());
    }

    @Test
    public void addCard_success() {
        CardDummy card = new CardDummy();
        target.addCard(card);
        assertTrue(target.getCards().contains(card));
        assertEquals(1, target.getCards().size());
    }

    @Test
    public void removeCard_success() {
        CardDummy card = new CardDummy();
        target.addCard(card);
        assertEquals(card, target.removeCard(card));
        assertFalse(target.getCards().contains(card));
        assertEquals(0, target.getCards().size());
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
