package de.htwg.se.setgame.aview.tui;

import static org.junit.Assert.*;

import de.htwg.se.setgame.TestAppender;
import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.controller.ControllerDummy;
import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.util.observer.Event;
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
    private ISet set;
    private Action action;
    private boolean actionExecute;
    private List<Action> actions;
    private List<IPlayer> players;

    private class Controller extends ControllerDummy {

        @Override
        public Map<Integer, ICard> getCardsAndTheIndexOfCardInField() {
            return cards;
        }

        @Override
        public List<IPlayer> getPlayers() {
            return players;
        }

        @Override
        public ISet getSet() {
            return set;
        }
    }

    private class ActionListStub extends ActionList {

        @Override
        public List<Action> getAll() {
            return actions;
        }

        @Override
        public Action get(String command) {
            return action;
        }
    }

    private class ActionDummy extends Action {

        private String commandStub;

        public ActionDummy() {
            super(new ControllerDummy());
        }

        public ActionDummy(String command) {
            super(new ControllerDummy());
            commandStub = command;
        }

        @Override
        public String getCommand() {
            return commandStub;
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

    private class EventDummy implements Event {

    }

    @Before
    public void setUp() {
        target = new TextUI(new Controller(), new ActionListStub());

        cards = new TreeMap<>();
        actionExecute = false;
        actions = new LinkedList<>();
        players = new LinkedList<>();
        set = null;

        testAppender = new TestAppender();
        Logger.getRootLogger().removeAllAppenders();
        Logger.getRootLogger().addAppender(testAppender);
    }

    @Test
    public void printTUI_success() {
        ICard card = new CardDummy();
        cards.put(0, card);
        actions.add(new ActionDummy("action"));

        target.printTUI();

        String result = testAppender.getLog();
        assertFalse(result.isEmpty());
        assertTrue(result.contains(card.toString()));
        assertTrue(result.contains("action"));
    }

    @Test
    public void update_success() {
        cards.put(0, new CardDummy());

        target.update(null);
        assertFalse(testAppender.getLog().isEmpty());
        assertTrue(target.getContinue());
    }

    @Test
    public void update_success_withEvent() {
        cards.put(0, new CardDummy());

        target.update(new EventDummy());
        assertFalse(testAppender.getLog().isEmpty());
        assertTrue(target.getContinue());
    }

    @Test
    public void processInputLine_failNobodyWinsNoSet() {
        players.add(new PlayerStub("player", 1));
        players.add(new PlayerStub("player", 1));
        assertWinner(TextUI.MSG_DRAW);
    }

    @Test
    public void processInputLine_failPlayerWins() {
        players.add(new PlayerStub("player", 1));
        assertWinner(String.format(TextUI.MSG_WINNER, "player"));
    }

    private void assertWinner(String winner) {
        assertTrue(target.processInputLine(null));

        String result = testAppender.getLog();
        assertFalse(result.isEmpty());
        assertTrue(result.contains(TextUI.GAME_FINISH));
        assertTrue(result.contains(winner));
    }

    @Test
    public void processInputLine_failInvalidAction() {
        set = new SetDummy();

        assertTrue(target.processInputLine("test"));
        assertTrue(testAppender.getLog().contains(TextUI.INVALID_ACTION));
    }

    @Test
    public void processInputLine_success() {
        set = new SetDummy();
        action = new ActionDummy();

        assertTrue(target.processInputLine("test"));
        assertFalse(testAppender.getLog().contains(TextUI.INVALID_ACTION));
        assertTrue(actionExecute);
    }

    @Test
    public void update_success_closeEvent() {
        target.update(new CloseEvent());

        assertTrue(testAppender.getLog().contains(TextUI.CLOSE));
        assertFalse(target.getContinue());
    }
}
