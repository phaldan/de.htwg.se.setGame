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

    @Test
    public void setColor_success() {
        target.setColor("color");
        assertEquals("color", target.getColor());
    }

    @Test
    public void setForm_success() {
        target.setForm("form");
        assertEquals("form", target.getForm());
    }

    @Test
    public void setPanelFilling_success() {
        target.setPanelFilling("filling");
        assertEquals("filling", target.getPanelFilling());
    }

    @Test
    public void setNumberOfComponents_success() {
        target.setNumberOfComponents(1337);
        assertEquals(new Integer(1337), target.getNumberOfComponents());
    }

    @Test
    public void toString_success() {
        target.setColor("color");
        target.setNumberOfComponents(1337);
        target.setForm("form");
        target.setPanelFilling("fill");

        String string = target.toString();
        assertTrue(string.contains("color"));
        assertTrue(string.contains("1337"));
        assertTrue(string.contains("form"));
        assertTrue(string.contains("fill"));
    }
}
