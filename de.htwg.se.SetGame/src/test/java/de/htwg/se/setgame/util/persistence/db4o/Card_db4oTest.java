package de.htwg.se.setgame.util.persistence.db4o;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pavan on 03/06/2015.
 */
public class Card_db4oTest extends TestCase {

    private DaoManager daoManager;
    Card_db4o card_db4o;
    ICard card;

    @Test
    public void testCreateCard()throws Exception {
        System.out.println("-> Testing Card_db40: testCreateCard()");
        card = null;
        card_db4o = new Card_db4o();
        card = card_db4o.create();
        assertNotNull(card);
    }
}