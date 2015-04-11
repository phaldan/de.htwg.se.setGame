package de.htwg.se.setgame.aview.tui;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class CloseActionTest {

    private CloseAction target;
    private boolean exit;

    private class Controller extends ControllerDummy {

        @Override
        public void exit() {
            exit = true;
        }
    }

    @Before
    public void setUp() {
        target = new CloseAction(new Controller());
    }

    @Test
    public void getCommand_success() {
        assertNotNull(target.getCommand());
        assertEquals(CloseAction.CMD, target.getCommand());
    }

    @Test
    public void getDescription_success() {
        assertNotNull(target.getDescription());
        assertEquals(CloseAction.DESC, target.getDescription());
    }

    @Test
    public void execute_success() {
        exit = false;

        String result = target.execute(null);
        assertNotNull(result);
        assertEquals(CloseAction.OUTPUT, result);
        assertTrue(exit);
    }
}
