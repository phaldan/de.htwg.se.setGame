package de.htwg.se.setgame.database.db4o;

import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pavan on 04/06/2015.
 */
public class Player_db4oTest extends TestCase {

    private DaoManager daoManager;
    Player_db4o player_db4o;
    IPlayer player;


    @Test
    public void testCreatePlayer() throws Exception{
        System.out.println("-> Testing Player_db4o: testCreatePlayer()");
        player = null;
        player_db4o = new Player_db4o();
        player = player_db4o.create();
        assertNotNull(player);
    }


    @Test
    public void testAddPlayer () throws Exception{
        System.out.println("-> Testing Player_db4o: testAddPlayer()");
        IPlayer playerFound = null;
        boolean gotPlayer = false;
        player_db4o = new Player_db4o();
        player = null;
        player = player_db4o.create();
        player.setName("Max Mustermann");
        player.setScore(50);
        player.setGame(null);
        player_db4o.add(player);

        String playerName = player.getName();
        playerFound = player_db4o.getByName(playerName);
        if(player.getName().equals(playerFound.getName()) == true
                //&& player.getScore() == playerFound.getScore()
                && player.getGame() == playerFound.getGame()) {
            gotPlayer = true;
        }
        assertTrue(gotPlayer);
    }


    @Test
    public void testGetByNamePlayer() throws Exception{
        System.out.println("-> Testing Player_db4o: testGetByNamePlayer()");
        boolean gotPlayer = false;
        testAddPlayer();
        IPlayer playerFound = null;
        String playerName = player.getName();
        playerFound = player_db4o.getByName(playerName);
        if(player.getName().equals(playerFound.getName()) == true
                && player.getScore() == playerFound.getScore()
                && player.getGame() == playerFound.getGame()) {
                gotPlayer = true;
        }
        assertTrue(gotPlayer);
    }


    @Test
    public void testUpdatePlayer () throws Exception{
        System.out.println("-> Testing Player_db4o: testUpdatePlayer()");
        testAddPlayer();
        boolean gotPlayer = false;
        IPlayer playerFound = null;
        player = null;
        player_db4o = new Player_db4o();
        player = player_db4o.create();
        player.setName("Max Mustermann");
        player.setScore(80);
        player.setGame(null);
        player_db4o.update(player);


        String playerName = player.getName();
        playerFound = player_db4o.getByName(playerName);
        if(player.getName().equals(playerFound.getName()) == true
                && player.getScore() == playerFound.getScore()
                && player.getGame() == playerFound.getGame()) {
            gotPlayer = true;
        }
        assertTrue(gotPlayer);
    }
}