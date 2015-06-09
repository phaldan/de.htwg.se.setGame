package de.htwg.se.setgame.database.couchDB;

import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pavan on 07/06/2015.
 */
public class CardList_couchTest extends TestCase {

    ICardList cardList;
    ICard card;
    DaoManager daoManager;
    CardList_couch cardCouch;
    SetupDB setupDB;


    @Test
    public void testSetUpConnection() throws Exception{
        daoManager=new DaoManager_Operation();
        setupDB = daoManager.getCouchDB();
        assertNotNull(setupDB);
    }



    @Test
    public void testCreate() throws Exception {
        daoManager = new DaoManager_Operation();
        cardList = daoManager.getCardList();
        assertNotNull(cardList);
    }




    @Test
    public void testAdd(){
        daoManager=new DaoManager_Operation();
        card =  daoManager.getCard();
         cardList=daoManager.getCardList();
        card.setCard_id(121);
        card.setColor("greenFirst");
        card.setForm("heart");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_1");
        cardList.addCard(card);
        cardCouch=new CardList_couch();
        cardCouch.add(cardList);
    }


    @Test
    public void testUpdateCardList() {
        daoManager=new DaoManager_Operation();
        card =  daoManager.getCard();
        cardList=daoManager.getCardList();
        card.setCard_id(121);
        card.setColor("greenFirst");
        card.setForm("heart2");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_2");
        cardList.addCard(card);
        cardCouch=new CardList_couch();
        cardCouch.update(cardList);
    }


}
