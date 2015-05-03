package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class SetControllerTest {

    private SetController target;
    private Event event;

    private class FactoryStub extends ModelFactoryDummy {

        @Override
        public ICardList createCardList() {
            return new CardListDummy();
        }

        @Override
        public ICard createCard() {
            return new CardDummy();
        }

        @Override
        public IPlayer createPlayer() {
            return new Player();
        }

        @Override
        public ISet createSet() {
            return new SetDummy();
        }
    }

    private class Player extends PlayerDummy {

        private int score = 0;

        @Override
        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public int getScore() {
            return score;
        }
    }

    private class Observer implements IObserver {
        @Override
        public void update(Event e) {
            event = e;
        }
    }

    private class SetStub extends SetDummy {

        private ICard one;
        private ICard two;
        private ICard three;

        public SetStub(ICard one, ICard two, ICard three) {
            this.one = one;
            this.two = two;
            this.three = three;
        }

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
    }

    @Before
    public void setUp() {
        event = null;
        target = new SetController(new FactoryStub());
        target.addObserver(new Observer());
    }

    @Test
    public void exit_success() {
        target.exit();
        assertEquals(CloseEvent.class, event.getClass());
    }

    @Test
    public void getCardsAndTheIndexOfCardInField_fail() {
        assertNotNull(target.getCardsAndTheIndexOfCardInField());
        assertTrue(target.getCardsAndTheIndexOfCardInField().isEmpty());
    }

    @Test
    public void getSetInField_fail() {
        assertNotNull(target.getSetInField());
        assertTrue(target.getSetInField().isEmpty());
    }

    @Test
    public void stillSetInGame_fail() {
        assertFalse(target.stillSetInGame());
    }

    @Test
    public void getFirstInSet_fail() {
        assertNull(target.getFirstInSet());
    }

    @Test
    public void newGame_success() {
        target.newGame();
    }

    @Test
    public void getPlayers_success() {
        assertNotNull(target.getPlayers());
        assertFalse(target.getPlayers().isEmpty());
        assertEquals(2, target.getPlayers().size());
    }

    @Test
    public void createSet_success() {
        assertNotNull(target.createSet());
    }

    @Test
    public void add_fail_playerNotContained() {
        ISet set = new SetDummy();
        IPlayer player = new PlayerDummy();

        target.add(set, player);
        assertNull(event);
    }

    @Test
    public void add_fail_notValidSet() {
        ICard card1 = new CardStub("color", "form", "fill", 0);
        ICard card2 = new CardStub("color", "form", "fill", 1);
        ISet set = new SetStub(card1, card1, card2);
        IPlayer player = target.getPlayers().get(0);

        target.add(set, player);
        assertNull(event);
        assertEquals(0, player.getScore());
    }

    @Test
    public void add_success() {
        ICard card = new CardStub("color", "form", "fill", 0);
        ISet set = new SetStub(card, card, card);
        IPlayer player = target.getPlayers().get(0);

        target.newGame();
        target.add(set, player);
        assertNotNull(event);
        assertEquals(1, player.getScore());
    }
}
