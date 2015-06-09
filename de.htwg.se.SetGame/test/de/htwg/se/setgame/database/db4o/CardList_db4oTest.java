package de.htwg.se.setgame.database.db4o;

import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.DaoManager;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Pavan on 04/06/2015.
 */
public class CardList_db4oTest {


    private DaoManager daoManager = new DaoManager_Operation();
    CardList_db4o cardList_db4o;
    ICard card;
    ICardList cardList;


    @Test
    public void testCreateCard()throws Exception {
        System.out.println("-> Testing Card_db40: testCreateCard()");
        cardList_db4o = new CardList_db4o();
        cardList = cardList_db4o.create();
        assertNotNull(cardList);
    }


    @Test
    public void testGetCardListByGame() throws Exception{
        IGame game = null;
        cardList = null;
        cardList_db4o = new CardList_db4o();
        cardList = cardList_db4o.getByGame(game);
        assertNull(cardList);
    }



  @Test
    public void testAddCardList(){
        System.out.println("-> Testing CardList_db40: addTest()");

        cardList = daoManager.getCardList();
        card=daoManager.getCard();
        cardList_db4o= new CardList_db4o();
        card.setCard_id(121);
        card.setColor("ExampleColor");
        card.setForm("NewForm");
        card.setPanelFilling("panelFilling_Example");

        cardList.addCard(card);
        cardList_db4o.add(cardList);

        System.out.println("card added" + card);
    }

    @Test
    public void testUpdate() throws Exception{
        System.out.println("-> Testing Card_db40: testUpdate()");
        /*// first add card to update it later
        ICard cardUpdating = daoManager.getCard();
        cardUpdating.setColor("red");
        cardUpdating.setForm("heart");        */

        cardList_db4o = new CardList_db4o();
        cardList = daoManager.getCardList();
        card=daoManager.getCard();
        // card.setCard_id(121);
        card.setColor("ExampleColor");
        card.setForm("NewForm");
        card.setPanelFilling("panelFilling_Example");
        cardList.addCard(card);
        cardList_db4o.update(cardList);
    }
}