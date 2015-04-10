package de.htwg.se.setgame.aview.tui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class ActionListTest {

    private ActionList target;

    @Before
    public void setUp() {
        target = new ActionList(new ControllerDummy());
    }

    @Test
    public void get_success() {
        assertNotNull(target.get(HelpAction.CMD));
        assertNotNull(target.get(PointsAction.CMD));
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
