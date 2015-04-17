package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IField;
import de.htwg.se.setgame.model.IPack;
import de.htwg.se.setgame.model.ModelFactory;
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

    SetController target;
    LinkedList<ICard> list;
    IField field;
    Event event;

    private class FactoryStub implements ModelFactory {

        @Override
        public IField createField() {
            return field;
        }

        @Override
        public IPack createPack() {
            return null;
        }
    }

    private class Oberserver implements IObserver {

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
        list = new LinkedList<>(target.getSetInField());
    }

    @Test
    public void testIsAssetForController() {
        target.isASetForController(list.get(0), list.get(1), list.get(2), target.getPlayerOne());
    }

    @Test
    public void exit_success() {
        target.addObserver(new Oberserver());
        target.exit();
        assertEquals(CloseEvent.class, event.getClass());
    }

}
