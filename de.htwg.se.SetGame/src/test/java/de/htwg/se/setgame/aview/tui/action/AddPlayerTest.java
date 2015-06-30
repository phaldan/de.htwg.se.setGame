package de.htwg.se.setgame.aview.tui.action;

import de.htwg.se.setgame.controller.ControllerDummy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class AddPlayerTest {

    private AddPlayer target;

    @Before
    public void setUp() throws Exception {
        target = new AddPlayer(new ControllerDummy());
    }

    @Test
    public void execute_fail() throws Exception {
        assertNull(target.execute(new String[]{}));
    }

    @Test
    public void execute_success() throws Exception {
        assertEquals(AddPlayer.OUTPUT, target.execute(new String[]{"",""}));
    }
}