package de.htwg.se.setgame.aview.tui.action;

import de.htwg.se.setgame.controller.ControllerDummy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CpuActionTest {

    private CpuAction target;

    @Before
    public void setUp() throws Exception {
        target = new CpuAction(new ControllerDummy());
    }

    @Test
    public void execute_fail() throws Exception {
        assertEquals(CpuAction.OUTPUT2, target.execute(new String[]{}));
    }

    @Test
    public void execute_success() throws Exception {
        assertEquals(CpuAction.OUTPUT1, target.execute(new String[]{"", ""}));
    }
}