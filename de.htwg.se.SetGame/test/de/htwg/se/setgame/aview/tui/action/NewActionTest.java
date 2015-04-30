package de.htwg.se.setgame.aview.tui.action;

import static org.junit.Assert.*;

import de.htwg.se.setgame.controller.ControllerDummy;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class NewActionTest {

    private NewAction target;
    private boolean newGame;

    private class Controller extends ControllerDummy {

        @Override
        public void newGame() {
            newGame = true;
        }
    }

    @Before
    public void setUp() {
        target = new NewAction(new Controller());
    }

    @Test
    public void getCommand_success() {
        assertNotNull(target.getCommand());
        assertEquals(NewAction.CMD, target.getCommand());
    }

    @Test
    public void getDescription_success() {
        assertNotNull(target.getDescription());
        assertEquals(NewAction.DESC, target.getDescription());
    }

    @Test
    public void execute_success() {
        newGame = false;

        String result = target.execute(null);
        assertNotNull(result);
        assertEquals(NewAction.OUTPUT, result);
        assertTrue(newGame);
    }
}
