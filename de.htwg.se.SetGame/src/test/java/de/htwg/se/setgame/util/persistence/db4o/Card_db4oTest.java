package de.htwg.se.setgame.util.persistence.db4o;

import de.htwg.se.setgame.util.persistence.hibernate.DaoManager_Operation;
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


    @Test
    public void testAdd() throws Exception{
        System.out.println("-> Testing Card_db40: addTest()");
        daoManager = new DaoManager_Operation();
        card = daoManager.getCard();
        card_db4o = new Card_db4o();
        card.setColor("ExampleColor");
        card.setForm("NewForm");
        card.setPanelFilling("panelFilling_Example");
        card_db4o.add(card);

        System.out.println("card added"+ card);
    }

    @Test
    public void testUpdate() throws Exception{
        System.out.println("-> Testing Card_db40: testUpdate()");
        daoManager = new DaoManager_Operation();
        /*// first add card to update it later
        ICard cardUpdating = daoManager.getCard();
        cardUpdating.setColor("red");
        cardUpdating.setForm("heart");        */

        card_db4o = new Card_db4o();
        card = daoManager.getCard();
       // card.setCard_id(121);
        card.setColor("ExampleColor");
        card.setForm("NewForm");
        card.setPanelFilling("panelFilling_Example");
        card_db4o.update(card);
    }
}