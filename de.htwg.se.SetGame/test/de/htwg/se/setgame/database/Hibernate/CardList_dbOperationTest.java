package de.htwg.se.setgame.database.Hibernate;


import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by Pavan on 31/05/2015.
 */
public class CardList_dbOperationTest extends TestCase {

    DaoManager daoManager;
    CardList_dbOperation cardList_dbOperation;


    @Test
    public void testGetSession() throws Exception {
        System.out.println("->  testGetSession");
        daoManager=new DaoManager_Operation();
        ISession session =  daoManager.createSession();
        assertNotNull(session);

        System.out.println("->  testGetSession END");
    }



    @Test
    public void testCreateCardList() throws Exception {
        ICardList cardList = null;
        daoManager = new DaoManager_Operation();
        cardList = daoManager.getCardList();
        assertNotNull(cardList);
    }


    @Test
    public void testGetCardListByGame() throws Exception {
        //TODO

    }



    @Test
    public void testAddCardList() throws Exception {
        System.out.println("->  testAddCard");
        boolean cardIsAdded = false;
        daoManager=new DaoManager_Operation();
        ICardList cardList =  daoManager.getCardList();
        ICard card = null;
        card = daoManager.getCard();
        card.setColor("Specialbluehega");
        card.setForm("Specialpik");
        card.setPanelFilling("SpecailpanelFilling_2");
        cardList.addCard(card);
        cardList_dbOperation=new CardList_dbOperation();
        cardList_dbOperation.add(cardList);
        List <ICard> list =  cardList.getCards();
        if (list.contains(card) == true){
            cardIsAdded = true;
        }
        assertTrue(cardIsAdded); //#############
        System.out.println("->  testAddCard END");
    }


    @Test
    public void testUpdateCardList() throws Exception {
        System.out.println("->  testAddCard");
        boolean cardIsAdded = false;
        daoManager=new DaoManager_Operation();
        ICardList cardList =  daoManager.getCardList();
        ICard card = null;
        card = daoManager.getCard();
        card.setColor("Specialgreen");
        card.setForm("Specialpik");
        card.setPanelFilling("SpecailpanelFilling_3");
        cardList.addCard(card);
        cardList_dbOperation=new CardList_dbOperation();
        cardList_dbOperation.update(cardList);
        List <ICard> list =  cardList.getCards();
        if (list.contains(card) == true){
            cardIsAdded = true;
        }
        assertTrue(cardIsAdded);
    }


    @Test
    public void testAddOrUpdateOperation() throws Exception {
        System.out.println("->  testAddCard");
        boolean cardIsAdded = false;
        daoManager=new DaoManager_Operation();
        ICardList cardList =  daoManager.getCardList();
        ICard card = null;
        card = daoManager.getCard();
        card.setColor("SpecialYELLOW");
        card.setForm("Specialpik");
        card.setPanelFilling("SpecailpanelFilling_4");
        cardList.addCard(card);
        cardList_dbOperation=new CardList_dbOperation();
        cardList_dbOperation.addOrUpdateOperation(cardList);
        List <ICard> list =  cardList.getCards();
        if (list.contains(card) == true){
            cardIsAdded = true;
        }
        assertTrue(cardIsAdded);
    }

}



