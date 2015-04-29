package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.aview.CardDummy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class SetTest {

    private Set target;

    @Before
    public void setUp() {
        target = new Set();
    }

    @Test
    public void getFirst_success() {
        CardDummy card = new CardDummy();
        target.setFirst(card);

        assertEquals(card, target.getFirst());
        assertNull(target.getSecond());
        assertNull(target.getThird());
    }

    @Test
    public void getSecond_success() {
        CardDummy card = new CardDummy();
        target.setSecond(card);

        assertEquals(card, target.getSecond());
        assertNull(target.getFirst());
        assertNull(target.getThird());
    }

    @Test
    public void getThird_success() {
        CardDummy card = new CardDummy();
        target.setThird(card);

        assertEquals(card, target.getThird());
        assertNull(target.getFirst());
        assertNull(target.getSecond());
    }

    @Test
    public void getAll_success() {
        CardDummy first = new CardDummy();
        CardDummy second = new CardDummy();
        CardDummy third = new CardDummy();

        target.setFirst(first);
        target.setSecond(second);
        target.setThird(third);

        assertNotNull(target.getAll());
        assertEquals(3, target.getAll().size());
        assertTrue(target.getAll().contains(first));
        assertTrue(target.getAll().contains(second));
        assertTrue(target.getAll().contains(third));
    }
}
