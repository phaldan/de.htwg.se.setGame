package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.aview.ControllerDummy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class ActionListTest {

    private class Impl extends ActionList {

        public Impl() {
            add(new Dummy());
        }
    }

    private class Dummy extends Action {

        public Dummy() {
            super(new ControllerDummy());
        }

        @Override
        public String getCommand() {
            return "action";
        }

        @Override
        public String getDescription() {
            return null;
        }

        @Override
        public String execute(String[] input) {
            return null;
        }
    }

    private ActionList target;

    @Before
    public void setUp() {
        target = new Impl();
    }

    @Test
    public void get_success() {
        assertNotNull(target.get("action"));
    }

    @Test
    public void get_fail() {
        assertNull(target.get("test"));
    }

    @Test
    public void getAll_success() {
        assertNotNull(target.getAll());
    }
}
