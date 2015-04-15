package de.htwg.se.setgame.aview.tui.action;

import static org.junit.Assert.*;

import de.htwg.se.setgame.aview.tui.CardDummy;
import de.htwg.se.setgame.aview.tui.ControllerDummy;
import de.htwg.se.setgame.model.ICard;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Philipp Daniels
 */
public class SetActionTest {

    private SetAction target;
    private Map<Integer, ICard> cards;
    private ICard setCardOne;
    private ICard setCardTwo;
    private ICard setCardThree;
    private int setPlayer;

    private class Controller extends ControllerDummy {

        @Override
        public Map<Integer, ICard> getCardsAndTheIndexOfCardInField() {
            return cards;
        }

        @Override
        public int getPlayerOne() {
            return 1;
        }

        @Override
        public int getPlayerTwo() {
            return 2;
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
        target = new SetAction(new Controller());
    }

    @Test
    public void getCommand_success() {
        assertNotNull(target.getCommand());
        assertEquals(SetAction.CMD, target.getCommand());
    }

    @Test
    public void getDescription_success() {
        assertNotNull(target.getDescription());
        assertEquals(SetAction.DESC, target.getDescription());
    }

    @Test
    public void execute_failNull() {
        String result = target.execute(null);
        assertNotNull(result);
        assertEquals(SetAction.INVALID_PARAM, result);
    }

    @Test
    public void execute_failEmptyArray() {
        String result = target.execute(new String[]{});
        assertNotNull(result);
    }

    @Test
    public void execute_failPlayer() {
        String result = target.execute(new String[]{"", "test", "0", "1", "2"});
        assertNotNull(result);
        assertEquals(SetAction.INVALID_PLAYER, result);
    }

    @Test
    public void execute_failWrongCard() {
        cards = new TreeMap<>();

        String result = target.execute(new String[]{"",SetAction.PLAYER1, "0", "1", "2"});
        assertNotNull(result);
        assertEquals(SetAction.INVALID_CARD, result);
    }

    @Test
    public void execute_success() {
        cards = new TreeMap<>();

        ICard one = new CardDummy();
        cards.put(0, one);
        ICard two = new CardDummy();
        cards.put(1, two);
        ICard three = new CardDummy();
        cards.put(2, three);

        String result = target.execute(new String[]{"",SetAction.PLAYER1, "0", "1", "2"});
        assertNotNull(result);
        assertEquals(one, setCardOne);
        assertEquals(two, setCardTwo);
        assertEquals(three, setCardThree);
        assertEquals(1, setPlayer);
        assertEquals(SetAction.OUTPUT, result);
    }
}
