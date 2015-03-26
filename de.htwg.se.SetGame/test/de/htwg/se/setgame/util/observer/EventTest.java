package de.htwg.se.setgame.util.observer;

import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class EventTest {

    private class EventImpl extends Event {
    }

    @Test
    public void test() {
        new EventImpl();
    }
}
