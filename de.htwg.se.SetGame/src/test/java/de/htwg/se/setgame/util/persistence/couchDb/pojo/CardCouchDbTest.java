package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.impl.CardList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardCouchDbTest {

    private CardCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new CardCouchDb();
    }

    @Test
    public void getCardList_success() {
        CardList list = new CardList();
        target.setCardList(list);
        assertSame(list, target.getCardList());
    }

    @Test
    public void getNumberOfComponents_success() {
        target.setNumberOfComponents(1);
        assertEquals(new Integer(1), target.getNumberOfComponents());
    }

    @Test
    public void getColor_success() {
        target.setColor("green");
        assertEquals("green", target.getColor());
    }

    @Test
    public void getForm_success() {
        target.setForm("circle");
        assertEquals("circle", target.getForm());
    }

    @Test
    public void getPanelFilling_success() {
        target.setPanelFilling("full");
        assertEquals("full", target.getPanelFilling());
    }
}