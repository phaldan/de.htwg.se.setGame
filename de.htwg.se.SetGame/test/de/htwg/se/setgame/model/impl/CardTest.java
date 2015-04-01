package de.htwg.se.setgame.model.impl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    Card target;

    @Before
    public void setUp() {
        target = new Card();
    }

    private Card getInstance() {
        return new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
    }

    @Test
    public void testInitialState() {
        assertNull(target.getColor());
        assertNull(target.getForm());
        assertNull(target.getPanelFilling());
        assertNull(target.getNumberOfComponents());
    }

    @Test
    public void setColor_success() {
        target.setColor(Card.COLOR_1);
        assertEquals(Card.COLOR_1, target.getColor());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setColor_fail() {
        target.setColor("");
    }

    @Test
    public void setForm_success() {
        target.setForm(Card.FORM_1);
        assertEquals(Card.FORM_1, target.getForm());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setForm_fail() {
        target.setForm("");
    }

    @Test
    public void setPanelFilling_success() {
        target.setPanelFilling(Card.FILL_1);
        assertEquals(Card.FILL_1, target.getPanelFilling());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPanelFilling_fail() {
        target.setPanelFilling("");
    }

    @Test
    public void setNumberOfComponents_success() {
        target.setNumberOfComponents(Card.COUNT_1);
        assertEquals(Card.COUNT_1, target.getNumberOfComponents());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNumberOfComponents_fail() {
        target.setNumberOfComponents(0);
    }

    @Test
    public void testAlternativeConstructor() {
        target = getInstance();
        assertEquals(Card.COLOR_1, target.getColor());
        assertEquals(Card.FORM_1, target.getForm());
        assertEquals(Card.FILL_1, target.getPanelFilling());
        assertEquals(Card.COUNT_1, target.getNumberOfComponents());
    }

    @Test
    public void toString_success() {
        target = getInstance();
        String string = target.toString();
        assertTrue(string.contains(Card.COLOR_1));
        assertTrue(string.contains(Card.FORM_1));
        assertTrue(string.contains(Card.FILL_1));
        assertTrue(string.contains(Card.COUNT_1.toString()));
    }

    @Test
    public void compareTo_success() {
        target = getInstance();
        assertTrue(target.compareTo(getInstance()));
    }

    @Test
    public void compareTo_failColor() {
        target = getInstance();
        Card c = getInstance();
        c.setColor(Card.COLOR_2);
        assertFalse(target.compareTo(c));
    }

    @Test
    public void compareTo_failForm() {
        target = getInstance();
        Card c = getInstance();
        c.setForm(Card.FORM_2);
        assertFalse(target.compareTo(c));
    }

    @Test
    public void compareTo_failFill() {
        target = getInstance();
        Card c = getInstance();
        c.setPanelFilling(Card.FILL_2);
        assertFalse(target.compareTo(c));
    }

    @Test
    public void compareTo_failCount() {
        target = getInstance();
        Card c = getInstance();
        c.setNumberOfComponents(Card.COUNT_2);
        assertFalse(target.compareTo(c));
    }
}
