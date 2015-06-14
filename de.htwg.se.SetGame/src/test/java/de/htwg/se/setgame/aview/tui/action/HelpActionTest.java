package de.htwg.se.setgame.aview.tui.action;

import static org.junit.Assert.*;

import de.htwg.se.setgame.model.CardDummy;
import de.htwg.se.setgame.controller.ControllerDummy;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ISet;
import de.htwg.se.setgame.model.SetDummy;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class HelpActionTest {

    private HelpAction target;
    private CardDummy card;

    private class ControllerStub extends ControllerDummy {

        @Override
        public ISet getSet() {
            return new Set();
        }
    }

    private class Set extends SetDummy {

        @Override
        public ICard getFirst() {
            return card;
        }
    }

    @Before
    public void setUp() {
        target = new HelpAction(new ControllerStub());
    }

    @Test
    public void getCommand_success() {
        assertNotNull(target.getCommand());
        assertEquals(HelpAction.CMD, target.getCommand());
    }

    @Test
    public void getDescription_success() {
        assertNotNull(target.getDescription());
        assertEquals(HelpAction.DESC, target.getDescription());
    }

    @Test
    public void execute_success() {
        card = new CardDummy();
        assertNotNull(target.execute(null));
        assertEquals(String.format(HelpAction.OUTPUT, card), target.execute(null));
        assertTrue(target.execute(null).contains(card.toString()));
    }
}
