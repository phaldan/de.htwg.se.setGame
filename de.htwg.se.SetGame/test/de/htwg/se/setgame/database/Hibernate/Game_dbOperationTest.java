package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by Pavan on 07/06/2015.
 */
public class Game_dbOperationTest extends TestCase {
   IGame game;
    ICard card;
    ICardList cardList;
    DaoManager manager;
    IPlayer player;
    Game_dbOperation game_dbOperation;



    @Test
    public void testGetSession() throws Exception {
        System.out.println("->  testGetSession");
        manager=new DaoManager_Operation();
        ISession session =  manager.createSession();
        assertNotNull(session);

        System.out.println("->  testGetSession END");
    }


    @Test
    public void testGetGameByPlayer() throws Exception {
        boolean boolGame = false;
        manager = new DaoManager_Operation();
        IPlayer player = manager.getPlayer();
        game_dbOperation = new Game_dbOperation();
        game = game_dbOperation.create();
        String name = "Max Mustermann";
        player.setName(name);
        player.setScore(90);

        game.setFieldCardList(null);
        game.setWinner(player);

        player.setGame(game);

        List<IGame> gameList = null;
        gameList = game_dbOperation.getByPlayer(name);

        if (gameList.isEmpty() == false){
            boolGame = true;
        }
        assertTrue(boolGame);
    }



    @Test
    public void testAddOrUpdateOperationTest(){
        boolean boolGame = false;
        manager = new DaoManager_Operation();
        cardList=manager.getCardList();
        card= manager.getCard();
        game=manager.getGame();
        player= manager.getPlayer();
        String name = "rajiv gandhi";
        player.setName(name);
        card.setForm("form");
        card.setColor("yellow");
        cardList.addCard(card);
        player.setScore(43);
        game.setWinner(player);
        game.setFieldCardList(cardList);
        game_dbOperation=new Game_dbOperation();
        game_dbOperation.addOrUpdateOperation(game);

        List<IGame> gameList = null;
        gameList = game_dbOperation.getByPlayer(name);

        if (gameList.isEmpty() == false){
            boolGame = true;
        }
        assertTrue(boolGame);
   }


    @Test
    public void testAddGame() throws Exception {
        boolean boolGame = false;
        manager = new DaoManager_Operation();
        cardList=manager.getCardList();
        card= manager.getCard();
        game=manager.getGame();
        player= manager.getPlayer();
        String name = "rajiv gandhi";
        player.setName(name);
        card.setForm("form");
        card.setColor("yellow");
        cardList.addCard(card);
        player.setScore(43);
        game.setWinner(player);
        game.setFieldCardList(cardList);
        game_dbOperation=new Game_dbOperation();
        game_dbOperation.add(game);

        List<IGame> gameList = null;
        gameList = game_dbOperation.getByPlayer(name);

        if (gameList.isEmpty() == false){
            boolGame = true;
        }
        assertTrue(boolGame);
    }


    @Test
    public void testUpdateGame() throws Exception{
        boolean boolGame = false;
        manager = new DaoManager_Operation();
        cardList=manager.getCardList();
        card= manager.getCard();
        game=manager.getGame();
        player= manager.getPlayer();
        String name = "rajiv gandhi";
        player.setName(name);
        card.setForm("form");
        card.setColor("yellow");
        cardList.addCard(card);
        player.setScore(90);
        game.setWinner(player);
        game.setFieldCardList(cardList);
        game_dbOperation=new Game_dbOperation();
        game_dbOperation.update(game);

        List<IGame> gameList = null;
        gameList = game_dbOperation.getByPlayer(name);

        if (gameList.isEmpty() == false){
            boolGame = true;
        }
        assertTrue(boolGame);

    }


}