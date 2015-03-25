package de.htwg.se.setgame.model.impl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    Card target;

    @Before
    public void setUp() {
        target = new Card("red", "wave", "fill", 1);
    }

    @Test
    public void testInitialState() {
        assertNotNull(target);
        assertNotNull(target.getColor());
        assertNotNull(target.getForm());
        assertNotNull(target.getPanelFilling());
        assertNotEquals(-1, target.getNumberOfComponents());
    }
}
