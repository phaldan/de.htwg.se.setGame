package de.htwg.se.setgame.model.impl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class PlayerTest {

    private Player target;

    @Before
    public void setUp() {
        target = new Player();
        target.setName("name");
        target.setId(1337);
    }

    @Test
    public void constructor() {
        assertEquals(1337, target.getId());
        assertEquals("name", target.getName());
        assertEquals(0, target.getScore());
    }

    @Test
    public void setId_getId() {
        target.setId(12);
        assertEquals(12, target.getId());
    }

    @Test
    public void setName_getName() {
        target.setName("Player");
        assertEquals("Player", target.getName());
    }

    @Test
    public void setScore_getScore() {
        target.setScore(50);
        assertEquals(50, target.getScore());
    }

    @Test
    public void toString_success() {
        target.setName("name");
        assertTrue(target.toString().contains("name"));
    }
}
