package de.htwg.se.setgame.database.couchDB;

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
public class Game_couchTest extends TestCase {



    IGame game;
    Game_couch game_couch;
    DaoManager daoManager;
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
        game = daoManager.getGame();
        assertNotNull(game);
    }




    @Test
    public void testAdd(){
        daoManager=new DaoManager_Operation();
        game =  daoManager.getGame();
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
        game_couch =new Game_couch();
        game_couch.add(game);
    }


    @Test
    public void testUpdateCardList() {
        daoManager=new DaoManager_Operation();
        game =  daoManager.getGame();
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
        game_couch =new Game_couch();
        game_couch.update(game);
    }


}