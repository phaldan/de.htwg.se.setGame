package de.htwg.se.setgame.aview.tui.action;

import static org.junit.Assert.*;

import de.htwg.se.setgame.aview.CardDummy;
import de.htwg.se.setgame.aview.ControllerDummy;
import de.htwg.se.setgame.model.ICard;
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
    private ICard setCardOne;
    private ICard setCardTwo;
    private ICard setCardThree;
    private int setPlayer;

    private class Controller extends ControllerDummy {

        @Override
        public List<ICard> getSetInField() {
            return set;
        }

        @Override
        public void isASetForController(ICard cardOne, ICard cardTwo, ICard cardThree, int player) {
            setCardOne = cardOne;
            setCardTwo = cardTwo;
            setCardThree = cardThree;
            setPlayer = player;
        }
    }

    @Before
    public void setUp() {
        target = new SolveAction(new Controller());
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
        set = new LinkedList<>();

        String result = target.execute(null);
        assertNotNull(result);
    }

    @Test
    public void execute_success() {
        set = new LinkedList<>();

        ICard card1 = new CardDummy();
        set.add(card1);
        ICard card2 = new CardDummy();
        set.add(card2);
        ICard card3 = new CardDummy();
        set.add(card3);

        String result = target.execute(null);
        assertEquals(card1, setCardOne);
        assertEquals(card2, setCardTwo);
        assertEquals(card3, setCardThree);
        assertEquals(SolveAction.PLAYER, setPlayer);
        assertNotNull(result);
        assertEquals(String.format(SolveAction.OUTPUT1, set), result);
    }
}
