package de.htwg.se.setgame.aview.tui.action;

import static org.junit.Assert.*;

import de.htwg.se.setgame.aview.ControllerDummy;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class ActionListImplTest {

    private ActionListImpl target;

    @Before
    public void setUp() {
        target = new ActionListImpl(new ControllerDummy());
    }

    @Test
    public void get_success() {
        assertEntry(HelpAction.CMD);
        assertEntry(PointsAction.CMD);
        assertEntry(ResizeAction.CMD);
        assertEntry(NewAction.CMD);
        assertEntry(SolutionAction.CMD);
        assertEntry(SolveAction.CMD);
        assertEntry(CloseAction.CMD);
        assertEntry(SetAction.CMD);
    }

    private void assertEntry(String command) {
        assertNotNull(target.get(command));
    }
}
