package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.ControllerDummy;
import de.htwg.se.setgame.model.CardDummy;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.impl.Card;
import de.htwg.se.setgame.util.observer.Event;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class GameFieldTest {

    private class Controller extends ControllerDummy {

        @Override
        public Map<Integer, ICard> getCardsAndTheIndexOfCardInField() {
            cardsRequested = true;
            return cards;
        }
    }

    private class EventDummy implements Event {

    }

    private class Dialog extends MessageDialog {

        @Override
        public void show(String title, String message) {
            dialogTitle = title;
            dialogMessage = message;
        }
    }

    private GameField target;
    private TreeMap<Integer, ICard> cards;
    private boolean cardsRequested;
    private String dialogTitle;
    private String dialogMessage;

    @Before
    public void setUp() {
        cards = new TreeMap<>();
        cards.put(0, new Card());
        cards.put(1, new Card());
        cards.put(2, new Card());
        cards.put(3, new Card());

        cardsRequested = false;
        dialogTitle = null;
        dialogMessage = null;

        target = new GameField(new Controller(), new Dialog());
    }

    @Test
    public void getSelected_success_emptyList() {
        assertFalse(cardsRequested);
        assertTrue(target.getSelected().isEmpty());
        assertNull(dialogTitle);
        assertNull(dialogMessage);
    }

    @Test
    public void update_success() {
        cardsRequested = false;
        target.update(new EventDummy());

        assertTrue(cardsRequested);
        assertNull(dialogTitle);
        assertNull(dialogMessage);
    }

    @Test
    public void actionPerformed_fail() {
        target.actionPerformed(null);
        assertNull(dialogTitle);
        assertNull(dialogMessage);
    }

    @Test
    public void actionPerformed_success() {
        target.update(new EventDummy());
        selectField();
        target.actionPerformed(null);
        assertEquals(GameField.DIALOG_TITLE, dialogTitle);
        assertEquals(GameField.DIALOG_MESSAGE, dialogMessage);
    }

    private void selectField() {
        for (Field field: target.getFields()) {
            field.actionPerformed(null);
        }
    }
}
