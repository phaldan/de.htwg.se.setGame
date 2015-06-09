package de.htwg.se.setgame.database.couchDB;

import com.fourspaces.couchdb.Database;
import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pavan on 08/06/2015.
 */
public class Couch_BasicOperationsTest extends TestCase {



    DaoManager daoManager;
    Couch_BasicOperations couch_basicOperations;
    SetupDB setupDB;
    String dbName = "SetCouchBasic_db";


    @Test
    public void testAddCard() throws Exception{
        daoManager=new DaoManager_Operation();

        setupDB = daoManager.getCouchDB();
        Database db = (setupDB.setDatabaseSession(dbName.toLowerCase()));
        ICard card =  daoManager.getCard();
        card.setCard_id(145);
        card.setColor("greenSecond2");
        card.setForm("heart2");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_2");
        couch_basicOperations = new Couch_BasicOperations();
        Couch_BasicOperations.addCard(card, db);
    }


    @Test
    public void testAddCardList() throws Exception{
        daoManager=new DaoManager_Operation();

        setupDB = daoManager.getCouchDB();
        Database db = (setupDB.setDatabaseSession(dbName.toLowerCase()));
        ICard card =  daoManager.getCard();
        ICardList cardList=daoManager.getCardList();
        card.setCard_id(121);
        card.setColor("greenFirst");
        card.setForm("heart");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_1");
        cardList.addCard(card);
        couch_basicOperations = new Couch_BasicOperations();
        Couch_BasicOperations.addCardList(cardList, db);
    }


    @Test
    public void testAddGame() throws Exception{
        daoManager=new DaoManager_Operation();

        setupDB = daoManager.getCouchDB();
        Database db = (setupDB.setDatabaseSession(dbName.toLowerCase()));

        IGame game =  daoManager.getGame();
        ICardList cardList = daoManager.getCardList();
        ICard card = daoManager.getCard();
        card.setCard_id(121);
        card.setColor("greenFirst");
        card.setForm("heart");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_1");
        cardList.addCard(card);
        game.setFieldCardList(cardList);
        IPlayer player = daoManager.getPlayer();
        player.setName("Maximilian");
        player.setScore(60);
        game.setWinner(player);

        couch_basicOperations = new Couch_BasicOperations();
        Couch_BasicOperations.addGame(game, db);
    }




    @Test
    public void testAddPlayer() throws Exception{
        daoManager=new DaoManager_Operation();

        setupDB = daoManager.getCouchDB();
        Database db = (setupDB.setDatabaseSession(dbName.toLowerCase()));

        IPlayer player =  daoManager.getPlayer();
        player.setName("Maximum");
        player.setScore(100);

        couch_basicOperations = new Couch_BasicOperations();
        Couch_BasicOperations.addPlayer(player, db);
    }





    @Test
    public void testUpdateCard () throws Exception{
        daoManager=new DaoManager_Operation();

        setupDB = daoManager.getCouchDB();
        Database db = (setupDB.setDatabaseSession(dbName.toLowerCase()));
        ICard card =  daoManager.getCard();
        card.setCard_id(145);
        card.setColor("greenSecond");
        card.setForm("heart");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_1");
        couch_basicOperations = new Couch_BasicOperations();
        Couch_BasicOperations.updateCard(card, db);

    }



    @Test
    public void testUpdateCardList() throws Exception{
        daoManager=new DaoManager_Operation();

        setupDB = daoManager.getCouchDB();
        Database db = (setupDB.setDatabaseSession(dbName.toLowerCase()));
        ICard card =  daoManager.getCard();
        ICardList cardList=daoManager.getCardList();
        card.setCard_id(121);
        card.setColor("greenFirst");
        card.setForm("heart");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_2");
        cardList.addCard(card);
        couch_basicOperations = new Couch_BasicOperations();
        Couch_BasicOperations.updateCardList(cardList, db);
    }


    @Test
    public void testUpdateGame() throws Exception{
        daoManager=new DaoManager_Operation();

        setupDB = daoManager.getCouchDB();
        Database db = (setupDB.setDatabaseSession(dbName.toLowerCase()));

        IGame game =  daoManager.getGame();
        ICardList cardList = daoManager.getCardList();
        ICard card = daoManager.getCard();
        card.setCard_id(121);
        card.setColor("greenFirst");
        card.setForm("heart");
        card.setNumberOfComponents(2);
        card.setPanelFilling("panelFilling_2");
        cardList.addCard(card);
        game.setFieldCardList(cardList);
        IPlayer player = daoManager.getPlayer();
        player.setName("Maximilian");
        player.setScore(60);
        game.setWinner(player);

        couch_basicOperations = new Couch_BasicOperations();
        Couch_BasicOperations.updateGame(game, db);
    }



    @Test
    public void testUpdatePlayer() throws Exception{
        daoManager=new DaoManager_Operation();

        setupDB = daoManager.getCouchDB();
        Database db = (setupDB.setDatabaseSession(dbName.toLowerCase()));

        IPlayer player =  daoManager.getPlayer();
        player.setName("Maximum");
        player.setScore(200);

        couch_basicOperations = new Couch_BasicOperations();
        Couch_BasicOperations.updatePlayer(player, db);
    }







}