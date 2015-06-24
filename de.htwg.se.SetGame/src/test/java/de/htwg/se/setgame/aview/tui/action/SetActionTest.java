package de.htwg.se.setgame.aview.tui.action;

import static org.junit.Assert.*;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.controller.ControllerDummy;
import de.htwg.se.setgame.model.impl.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Philipp Daniels
 */
public class SetActionTest {

    private SetAction target;
    private Map<Integer, ICard> cards;
    private List<IPlayer> players;
    private ISet setSpy;
    private IPlayer playerSpy;

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
        public ISet createSet() {
            return new Set();
        }

        @Override
        public void add(ISet set, IPlayer player) {
            setSpy = set;
            playerSpy = player;
        }
    }

    private class Set extends SetDummy {

        private ICard one;
        private ICard two;
        private ICard three;

        @Override
        public ICard getFirst() {
            return one;
        }

        @Override
        public ICard getSecond() {
            return two;
        }

        @Override
        public ICard getThird() {
            return three;
        }

        @Override
        public void setFirst(ICard first) {
            one = first;
        }

        @Override
        public void setSecond(ICard second) {
            two = second;
        }

        @Override
        public void setThird(ICard third) {
            three = third;
        }
    }

    @Before
    public void setUp() {
        target = new SetAction(new Controller());
        players = new LinkedList<>();
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
        String result = target.execute(new String[]{"", "0", "0", "1", "2"});
        assertNotNull(result);
        assertEquals(SetAction.INVALID_PLAYER, result);
    }

    @Test
    public void execute_failWrongCard() {
        cards = new TreeMap<>();
        IPlayer player = new Player();
        player.setName("0");
        players.add(player);

        String result = target.execute(new String[]{"", "0", "0", "1", "2"});
        assertNotNull(result);
        assertEquals(SetAction.INVALID_CARD, result);
    }

    @Test
    public void execute_success() {
        ICard one = new CardDummy();
        ICard two = new CardDummy();
        ICard three = new CardDummy();

        cards = new TreeMap<>();
        cards.put(0, one);
        cards.put(1, two);
        cards.put(2, three);

        IPlayer player = new Player();
        player.setName("0");
        players.add(player);

        String result = target.execute(new String[]{"","0", "0", "1", "2"});
        assertNotNull(result);
        assertEquals(SetAction.OUTPUT, result);

        assertEquals(one, setSpy.getFirst());
        assertEquals(two, setSpy.getSecond());
        assertEquals(three, setSpy.getThird());
        assertEquals(player, playerSpy);
    }
}
