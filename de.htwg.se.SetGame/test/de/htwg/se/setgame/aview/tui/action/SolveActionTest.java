package de.htwg.se.setgame.aview.tui.action;

import static org.junit.Assert.*;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.controller.ControllerDummy;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class SolveActionTest {

    private SolveAction target;
    private List<ICard> set;
    private ISet setStub;
    private IPlayer playerSpy;
    private ISet setSpy;

    private class Controller extends ControllerDummy {

        @Override
        public ISet getSet() {
            return setStub;
        }

        @Override
        public void add(ISet set, IPlayer player) {
            setSpy = set;
            playerSpy = player;
        }
    }

    @Before
    public void setUp() {
        target = new SolveAction(new Controller());
        setStub = null;
        setSpy = null;
        playerSpy = null;
    }

    @Test
    public void getCommand_success() {
        assertNotNull(target.getCommand());
        assertEquals(SolveAction.CMD, target.getCommand());
    }

    @Test
    public void getDescription_success() {
        assertNotNull(target.getDescription());
        assertEquals(SolveAction.DESC, target.getDescription());
    }

    @Test
    public void execute_fail() {
        assertEquals(SolveAction.OUTPUT2, target.execute(null));
    }

    @Test
    public void execute_success() {
        setStub = new SetDummy();

        String result = target.execute(null);
        assertNotNull(result);
        assertEquals(String.format(SolveAction.OUTPUT1, setStub), result);

        assertEquals(setStub, setSpy);
        assertNull(playerSpy);
    }
}
