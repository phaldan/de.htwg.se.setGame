package de.htwg.se.setgame.controller.event;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Philipp Daniels
 */
public class AddEventTest {

    @Test
    public void test() {
        assertNotNull(new AddEvent());
    }
}
