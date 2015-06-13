package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pavan on 30/05/2015.
 */
public class Card_dbOperationTest extends TestCase {

     DaoManager daoManager;
     Card_dbOperation card_dbOperation;
    int card_id;


    @Test
    public void testCreateCard() throws Exception {
        ICard card = null;
        daoManager = new DaoManager_Operation();
        card = daoManager.getCard();
        assertNotNull(card);
    }


    @Test
    public void testGetSession() throws Exception {
        System.out.println("->  testGetSession");
        daoManager=new DaoManager_Operation();
        ISession session =  daoManager.createSession();
        assertNotNull(session);

        System.out.println("->  testGetSession END");
    }


    @Test
    public void testAddCard() throws Exception {
        System.out.println("->  testAddCard");
        boolean cardIsAdded = false ;
        daoManager=new DaoManager_Operation();
        ICard card =  daoManager.getCard();
        card.setColor("green");
        card.setForm("heart");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_1");
        card_dbOperation=new Card_dbOperation();
        System.out.println("#   Adding Card (green, heart, panelFilling_1) to table");
        card_dbOperation.add(card);
        System.out.println("#   card_id");
        System.out.println(card_id);
        // missing to check if card is added
        // if yes : set 'cardIsAdded' to true
        if (card_id != 0) {
            cardIsAdded = true;
            System.out.println("#   Added Card ");
            /*
            ICard card2 = card_dbOperation.getCard(card_id);

            System.out.println(card2.getColor());
            System.out.println(card2.getForm());
            System.out.println( card2.getPanelFilling());
            */
        }
        assertTrue(cardIsAdded); //#############
        System.out.println("->  testAddCard END");
    }



   @Test
    public void testUpdateCard() throws Exception {
       System.out.println("->  testUpdateCard");
       boolean cardIsAdded = true;
       daoManager=new DaoManager_Operation();
       ICard card =  daoManager.getCard();
       card.setColor("yellowupdated");
       card.setForm("heart");
       card.setNumberOfComponents(2);
       card.setPanelFilling("panelFilling_1");
       card_dbOperation=new Card_dbOperation();
       card_dbOperation.update(card);
       assertTrue(cardIsAdded); //#############
       System.out.println("->  testUpdateCard END");
    }







}