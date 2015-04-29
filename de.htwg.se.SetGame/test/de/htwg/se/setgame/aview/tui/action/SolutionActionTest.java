package de.htwg.se.setgame.aview.tui.action;

import static org.junit.Assert.*;

import de.htwg.se.setgame.aview.CardDummy;
import de.htwg.se.setgame.aview.ControllerDummy;
import de.htwg.se.setgame.model.ICard;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author Philipp Daniels
 */
public class SolutionActionTest {

    private SolutionAction target;
    private List<ICard> set;
    private Map<Integer, ICard> map;

    private class Controller extends ControllerDummy {

        @Override
        public List<ICard> getSetInField() {
            return set;
        }

        @Override
        public Map<Integer, ICard> getCardsAndTheIndexOfCardInField() {
            return map;
        }
    }

    @Before
    public void setUp() {
        target = new SolutionAction(new Controller());
    }

    @Test
    public void getCommand_success() {
        assertNotNull(target.getCommand());
        assertEquals(SolutionAction.CMD, target.getCommand());
    }

    @Test
    public void getDescription_success() {
        assertNotNull(target.getDescription());
        assertEquals(SolutionAction.DESC, target.getDescription());
    }

    @Test
    public void execute_success() {
        ICard card1 = new CardDummy();
        ICard card2 = new CardDummy();
        ICard card3 = new CardDummy();
        set = new LinkedList<>(Arrays.asList(card1, card2, card3));

        map = new TreeMap<>();
        map.put(0, card1);
        map.put(1, card2);
        map.put(2, card3);

        String result = target.execute(null);
        assertNotNull(result);
        assertTrue(result.contains(SolutionAction.OUTPUT));
        assertEntry(result, 0, card1);
        assertEntry(result, 1, card2);
        assertEntry(result, 2, card3);
    }

    private void assertEntry(String result, int key, ICard card){
        assertTrue(result.contains(String.format(SolutionAction.FORMAT, key, card)));
    }
}
