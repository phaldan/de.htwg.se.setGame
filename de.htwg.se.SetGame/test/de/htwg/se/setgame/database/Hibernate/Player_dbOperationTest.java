package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pavan on 01/06/2015.
 */
public class Player_dbOperationTest extends TestCase {

    DaoManager daoManager;
    Player_dbOperation player_dbOperation;


    @Test
    public void testGetSession()throws Exception {
        System.out.println("->    testGetSession");
        daoManager = new DaoManager_Operation();
        ISession session = daoManager.createSession();
        assertNotNull(session);
        System.out.println("->    testGetSession END");
    }


    @Test
    public void testCreatePlayer() throws Exception{
        System.out.println("->   testCreatePlayer");
        IPlayer player = null;
        daoManager = new DaoManager_Operation();
        player = daoManager.getPlayer();
        assertNotNull(player);
        System.out.println("->   testCreatePlayer END");
    }


    @Test
    public void testAddAndGetPlayer() throws Exception{
        System.out.println("->    testAddPlayer");
        boolean playerIsAdded = false;
        //Integer player_ID = null;
        daoManager = new DaoManager_Operation();
        IPlayer player = daoManager.getPlayer();
        String playerName = "TestPlayer_1";
        player.setName(playerName);
        player.setScore(100);
        player_dbOperation = new Player_dbOperation();
        System.out.println("#   Adding Player to table");
        player_dbOperation.add(player);
        System.out.println("#   Getting Player from table");
        IPlayer player_check = null;
        player_check = player_dbOperation.getByName(playerName);
        System.out.println("#   Getting Player from table");

        assertNotNull(player_check);
        /*
        if(player_check != null){
            //if (player_ID != null){
            playerIsAdded = true;
            System.out.println("#   Added player");
        }
        assertTrue(playerIsAdded);
        */
        System.out.println("->    testAddPlayer END");
    }


    @Test
    public void testUpdatePlayer() throws Exception{
        boolean playerIsUpdated = false;
        IPlayer player = null;
        daoManager = new DaoManager_Operation();
        player = daoManager.getPlayer();
        String playerName = "TestPlayer_2";
        player.setName(playerName);
        player.setScore(80);
        player_dbOperation = new Player_dbOperation();
        System.out.println("#   Adding Player to table");
        player_dbOperation.add(player);
        System.out.println("#   Update Player in table");
        player.setName("TestPlayer_2");
        player.setScore(100);
        player_dbOperation.update(player);

        IPlayer player_check = null;
        player_check = player_dbOperation.getByName(playerName);
        System.out.println("#   Getting Player from table");

        assertNotNull(player_check);
       /* if(player_check != null){
            //if (player_ID != null){
            playerIsUpdated = true;
            System.out.println("#   Added player");
        }
        assertTrue(playerIsUpdated);
        */
        // get player by name and see if player was updated.
        // if-else : set assert to true
        //assertTrue(false);
    }


    @Test
    public void testGetByName() throws Exception {
        System.out.println("->    testGetByName");
        boolean playerIsUpdated = false;
        IPlayer player = null;
        daoManager = new DaoManager_Operation();
        player = daoManager.getPlayer();
        String playerName = "TestPlayer_2";
        player.setName(playerName);
        player.setScore(80);
        player_dbOperation = new Player_dbOperation();
        System.out.println("#   Adding Player to table");
        player_dbOperation.add(player);

        IPlayer player_check = null;
        player_check = player_dbOperation.getByName(playerName);
        System.out.println("#   Getting Player from table");

        assertNotNull(player_check);
        System.out.println("->    testGetByName END");
    }


    @Test
    public void testAddOrUpdateOperation() throws Exception {
        System.out.println("->    testGetByName");
        //boolean playerIsUpdated = false;
        IPlayer player = null;
        daoManager = new DaoManager_Operation();
        player = daoManager.getPlayer();
        String playerName = "TestPlayer_2";
        player.setName(playerName);
        player.setScore(80);
        player_dbOperation = new Player_dbOperation();
        System.out.println("#   Adding Player to table");
        player_dbOperation.add(player);

        IPlayer player_check = null;
        player_check = player_dbOperation.getByName(playerName);
        System.out.println("#   Getting Player from table");

        assertNotNull(player_check);
        System.out.println("->    testGetByName END");
    }


}