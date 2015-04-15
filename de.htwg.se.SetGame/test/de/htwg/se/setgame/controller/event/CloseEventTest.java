package de.htwg.se.setgame.controller.event;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CloseEventTest {

    @Test
    public void test() {
        assertNotNull(new CloseEvent());
    }
}
