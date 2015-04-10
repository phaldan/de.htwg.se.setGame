package de.htwg.se.setgame.aview.tui;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class ActionListTest {

    @Test
    public void test() {
        ActionList target = new ActionList(new ControllerDummy());
        assertNotNull(target.get(HelpAction.CMD));
    }
}
