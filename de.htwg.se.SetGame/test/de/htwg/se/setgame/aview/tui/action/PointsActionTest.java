package de.htwg.se.setgame.aview.tui.action;

import static org.junit.Assert.*;

import de.htwg.se.setgame.aview.ControllerDummy;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class PointsActionTest {

    private PointsAction target;
    private int pointsOne;
    private int pointsTwo;

    private class Controller extends ControllerDummy {

        @Override
        public int getPlayerOnePoints() {
            return pointsOne;
        }

        @Override
        public int getPlayerTwoPoints() {
            return pointsTwo;
        }
    }

    @Before
    public void setUp() {
        target = new PointsAction(new Controller());
    }

    @Test
    public void getCommand_success() {
        assertNotNull(target.getCommand());
        assertEquals(PointsAction.CMD, target.getCommand());
    }

    @Test
    public void getDescription_success() {
        assertNotNull(target.getDescription());
        assertEquals(PointsAction.DESC, target.getDescription());
    }

    @Test
    public void execute_success() {
        pointsOne = 12;
        pointsTwo = 5;

        String result = target.execute(null);
        assertNotNull(result);
        assertTrue(result.contains(Integer.toString(pointsOne)));
        assertTrue(result.contains(Integer.toString(pointsTwo)));
        assertEquals(String.format(PointsAction.OUTPUT, pointsOne, pointsTwo), result);
    }
}
