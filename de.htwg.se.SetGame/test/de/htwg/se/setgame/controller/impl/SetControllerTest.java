package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.Field;
import de.htwg.se.setgame.model.impl.Pack;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class SetControllerTest {

    private SetController target;
    private IField field;
    private Event event;

    private class FactoryStub implements ModelFactory {

        @Override
        public IField createField() {
            return field;
        }

        @Override
        public IPack createPack() {
            return null;
        }

        @Override
        public ISet createSet() {
            return null;
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
        field = new Field(new Pack(), 3);
        event = null;
        target = new SetController(new FactoryStub());
    }

    @Test
    public void exit_success() {
        target.addObserver(new Observer());
        target.exit();
        assertEquals(CloseEvent.class, event.getClass());
    }

}
