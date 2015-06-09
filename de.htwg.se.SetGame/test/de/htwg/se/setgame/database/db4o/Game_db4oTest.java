package de.htwg.se.setgame.database.db4o;

import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by Pavan on 04/06/2015.
 */
public class Game_db4oTest extends TestCase {

    private DaoManager daoManager = new DaoManager_Operation();
    Game_db4o game_db4o;
    IGame game;


    @Test
    public void testCreateGame() throws Exception{
        System.out.println("-> Testing Game_db4o: testCreateGame()");
        game = null;
        game_db4o = new Game_db4o();
        game = game_db4o.create();
        assertNotNull(game);
    }


    @Test
    public void testGetGameListByPlayer() throws Exception{
        System.out.println("-> Testing Game_db40: testGetGameListByPlayer()");

        List<IGame> gameList = null;
        game_db4o = new Game_db4o();
        gameList = game_db4o.getByPlayer();
        //TODO
        assertNotNull(gameList);
    }


    @Test
    public void testAddGame() throws Exception{
        System.out.println("-> Testing Game_db40: testAddGame()");

        Player_db4o player_db4o= new Player_db4o();
        IPlayer player = null;
        player = player_db4o.create();
        player.setName("Moritz Mustermann");
        player.setScore(80);

        game_db4o = new Game_db4o();
        game = null;
        game = game_db4o.create();
        game.setWinner(player);
        game.setFieldCardList(null);

        game_db4o.add(game);

    }



    @Test
    public void testUpdateGame () throws Exception{
        System.out.println("-> Testing Player_db4o: testUpdatePlayer()");
        testAddGame();

        Player_db4o player_db4o= new Player_db4o();
        IPlayer player = null;
        player = player_db4o.create();
        player.setName("Max Mustermann");
        player.setScore(80);

        game.setWinner(player);
        player_db4o.update(player);
    }





}