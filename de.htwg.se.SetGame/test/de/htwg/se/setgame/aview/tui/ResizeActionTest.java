package de.htwg.se.setgame.aview.tui;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class ResizeActionTest {

    private ResizeAction target;
    private int fieldSize;

    private class Controller extends ControllerDummy {

        @Override
        public void setFieldSize(int size) {
            fieldSize = size;
        }
    }

    @Before
    public void setUp() {
        target = new ResizeAction(new Controller());
    }

    @Test
    public void getCommand_success() {
        assertNotNull(target.getCommand());
        assertEquals(ResizeAction.CMD, target.getCommand());
    }

    @Test
    public void getDescription_success() {
        assertNotNull(target.getDescription());
        assertEquals(ResizeAction.DESC, target.getDescription());
    }

    @Test
    public void execute_success() {
        String result = target.execute(new String[]{"", "1337"});
        assertNotNull(result);
        assertEquals(String.format(ResizeAction.OUTPUT, "1337"), result);
        assertEquals(1337, fieldSize);
    }

    @Test
    public void execute_fail() {
        String result = target.execute(new String[]{""});
        assertNull(result);
        assertEquals(0, fieldSize);
    }
}
