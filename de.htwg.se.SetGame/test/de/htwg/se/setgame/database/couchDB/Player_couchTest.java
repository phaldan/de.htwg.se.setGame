package de.htwg.se.setgame.database.couchDB;

import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pavan on 08/06/2015.
 */
public class Player_couchTest extends TestCase {

    IPlayer player;
    DaoManager daoManager;
    Player_couch player_couch;
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
        player = daoManager.getPlayer();
        assertNotNull(player);
    }


    @Test
    public void testAdd(){
        daoManager=new DaoManager_Operation();
        player =  daoManager.getPlayer();
        player.setName("Maximum");
        player.setScore(100);
        player_couch = new Player_couch();
        player_couch.add(player);


    }

    public void testUpdate(){
        daoManager=new DaoManager_Operation();
        player =  daoManager.getPlayer();
        player.setName("Maximum");
        player.setScore(90);
        player_couch = new Player_couch();
        player_couch.update(player);
    }





}