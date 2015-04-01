package de.htwg.se.setgame.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.setgame.model.ICard;

import java.util.Arrays;
import java.util.List;

public class PackTest {

    Pack target;

    @Before
    public void setUp() {
        target = new Pack();
    }

    @Test
    public void testGetCards() {
        List<ICard> list = target.getPack();
        assertEquals(Card.COUNT.length * Card.COLOR.length * Card.FILL.length * Card.FORM.length, list.size());

        for (ICard card : list) {
            assertInArray(Card.COLOR, card.getColor());
            assertInArray(Card.FORM, card.getForm());
            assertInArray(Card.FILL, card.getPanelFilling());
            assertInArray(Card.COUNT, card.getNumberOfComponents());
        }
    }

    private void assertInArray(Object[] expected, Object actual) {
        assertTrue(Arrays.asList(expected).contains(actual));
    }
}
