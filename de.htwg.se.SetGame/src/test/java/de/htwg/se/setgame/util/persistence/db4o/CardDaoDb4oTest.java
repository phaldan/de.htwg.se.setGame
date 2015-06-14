package de.htwg.se.setgame.util.persistence.db4o;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pavan on 03/06/2015.
 */
public class CardDaoDb4oTest extends TestCase {

    private DaoManager daoManager;
    CardDaoDb4o card_daoDb4O;
    ICard card;

    @Test
    public void testCreateCard()throws Exception {
        System.out.println("-> Testing Card_db40: testCreateCard()");
        card = null;
        card_daoDb4O = new CardDaoDb4o();
        card = card_daoDb4O.create();
        assertNotNull(card);
    }
}