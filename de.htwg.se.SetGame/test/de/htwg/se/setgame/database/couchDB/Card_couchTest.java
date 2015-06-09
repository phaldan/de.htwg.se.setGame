package de.htwg.se.setgame.database.couchDB;

import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pavan on 07/06/2015.
 */
public class Card_couchTest extends TestCase {
    ICard card;
    DaoManager daoManager;
    Card_couch cardCouch;
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
        card = daoManager.getCard();
        assertNotNull(card);
    }


    @Test
     public void testAdd(){
        daoManager=new DaoManager_Operation();
        ICard card =  daoManager.getCard();
        card.setCard_id(145);
        card.setColor("greenSecond");
        card.setForm("heart");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_1");
        cardCouch=new Card_couch();
        cardCouch.add(card);


     }

    public void testUpdate(){
        daoManager=new DaoManager_Operation();
        ICard card =  daoManager.getCard();
        card.setCard_id(121);
        card.setColor("Red");
        card.setForm("heart");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_2");
        cardCouch=new Card_couch();
        cardCouch.update(card);


    }

}