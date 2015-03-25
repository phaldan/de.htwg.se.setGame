package de.htwg.se.setgame.modell.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.setgame.modell.ICard;

import java.util.Arrays;

public class PackTest {

    Pack target;

    @Before
    public void setUp() {
        target = new Pack();
    }

    @Test
    public void testGetCards() {
        for (ICard card : target.getPack()) {
            assertInArray(Pack.COLORS, card.getColor());
            assertInArray(Pack.FORME, card.getForm());
            assertInArray(Pack.FILL, card.getPanelFilling());
            assertInArray(Pack.NUMBEROFCOMPONET, card.getNumberOfComponents());
        }
    }

    private void assertInArray(Object[] expected, Object actual) {
        assertTrue(Arrays.asList(expected).contains(actual));
    }
}
