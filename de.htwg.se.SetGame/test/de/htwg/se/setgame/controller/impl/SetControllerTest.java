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
            return new PlayerDummy();
        }
    }

    private class Observer implements IObserver {
        @Override
        public void update(Event e) {
            event = e;
        }
    }

    @Before
    public void setUp() {
        event = null;
        target = new SetController(new FactoryStub());
    }

    @Test
    public void exit_success() {
        target.addObserver(new Observer());
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
}
