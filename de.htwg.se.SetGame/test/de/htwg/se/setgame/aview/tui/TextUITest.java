package de.htwg.se.setgame.aview.tui;

import static org.junit.Assert.*;

import de.htwg.se.setgame.TestAppender;
import de.htwg.se.setgame.model.ICard;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Philipp Daniels
 */
public class TextUITest {

    private TestAppender testAppender;
    private TextUI target;
    private Map<Integer, ICard> cards;
    private boolean setInGame;
    private List<ICard> cardinGame;
    private int player1;
    private int player2;
    private Action action;
    private boolean actionExecute;

    private class Controller extends ControllerDummy {

        @Override
        public Map<Integer, ICard> getCardsAndTheIndexOfCardInField() {
            return cards;
        }

        @Override
        public boolean stillSetInGame() {
            return setInGame;
        }

        @Override
        public List<ICard> getCardinGame() {
            return cardinGame;
        }

        @Override
        public int getPlayerOnePoints() {
            return player1;
        }

        @Override
        public int getPlayerTwoPoints() {
            return player2;
        }
    }

    private class ActionListStub extends ActionList {

        public ActionListStub() {
            super(new ControllerDummy());
        }

        @Override
        public List<Action> getAll() {
            return new LinkedList<>();
        }

        @Override
        public Action get(String command) {
            return action;
        }
    }

    private class ActionDummy extends Action {

        public ActionDummy() {
            super(new ControllerDummy());
        }

        @Override
        public String getCommand() {
            return null;
        }

        @Override
        public String getDescription() {
            return null;
        }

        @Override
        public String execute(String[] input) {
            actionExecute = true;
            return null;
        }
    }

    @Before
    public void setUp() {
        target = new TextUI(new Controller(), new ActionListStub());

        cards = new TreeMap<>();
        setInGame = false;
        cardinGame = new LinkedList<>();
        player1 = 0;
        player2 = 0;
        actionExecute = false;

        testAppender = new TestAppender();
        Logger.getRootLogger().removeAllAppenders();
        Logger.getRootLogger().addAppender(testAppender);
    }

    @Test
    public void printTUI_success() {
        ICard card = new CardDummy();
        cards.put(0, card);

        target = new TextUI(new Controller());
        target.printTUI();

        String result = testAppender.getLog();
        assertFalse(result.isEmpty());
        assertTrue(result.contains(card.toString()));
    }

    @Test
    public void update_success() {
        cards.put(0, new CardDummy());

        target.update(null);
        assertFalse(testAppender.getLog().isEmpty());
    }

    @Test
    public void processInputLine_failNobodyWinsNoSet() {
        assertWinner(TextUI.WINNER_NOBODY);
    }

    @Test
    public void processInputLine_failNobodyWinsNoCards() {
        setInGame = true;
        assertWinner(TextUI.WINNER_NOBODY);
    }

    @Test
    public void processInputLine_failPlayerWins() {
        player1 = 1;
        assertWinner(TextUI.WINNER_PLAYER1);
    }

    @Test
    public void processInputLine_failPlayer2Wins() {
        player2 = 1;
        assertWinner(TextUI.WINNER_PLAYER2);
    }

    private void assertWinner(String winner) {
        assertFalse(target.processInputLine(null));

        String result = testAppender.getLog();
        assertFalse(result.isEmpty());
        assertTrue(result.contains(TextUI.GAME_FINISH));
        assertTrue(result.contains(String.format(TextUI.PLAYER_POINTS, player1, player2)));
        assertTrue(result.contains(winner));
    }

    @Test
    public void processInputLine_failInvalidAction() {
        setInGame = true;
        cardinGame.add(new CardDummy());

        assertTrue(target.processInputLine("test"));
        assertTrue(testAppender.getLog().contains(TextUI.INVALID_ACTION));
    }

    @Test
    public void processInputLine_success() {
        setInGame = true;
        cardinGame.add(new CardDummy());
        action = new ActionDummy();

        assertTrue(target.processInputLine("test"));
        assertFalse(testAppender.getLog().contains(TextUI.INVALID_ACTION));
        assertTrue(actionExecute);
    }
}