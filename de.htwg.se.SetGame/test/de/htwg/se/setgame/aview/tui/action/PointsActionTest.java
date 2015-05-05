package de.htwg.se.setgame.aview.tui.action;

import static org.junit.Assert.*;

import de.htwg.se.setgame.controller.ControllerDummy;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.PlayerStub;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class PointsActionTest {

    private PointsAction target;
    private List<IPlayer> players;

    private class Controller extends ControllerDummy {

        @Override
        public List<IPlayer> getPlayers() {
            return players;
        }
    }

    @Before
    public void setUp() {
        target = new PointsAction(new Controller());
        players = new LinkedList<>();
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
        players.add(new PlayerStub("player", 1337));

        String result = target.execute(null);
        assertNotNull(result);
        assertEquals(String.format(PointsAction.OUTPUT, "player", 1337), result);
    }
}
