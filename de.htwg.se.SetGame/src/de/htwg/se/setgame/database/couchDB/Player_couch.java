package de.htwg.se.setgame.database.couchDB;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Session;
import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.DaoManager;
import de.htwg.se.setgame.util.persistence.PlayerDao;

/**
 * Created by Pavan on 07/06/2015.
 */
public class Player_couch implements PlayerDao {
    static Session dbSession ;
    static Database db;
    private DaoManager daoManager;
    private Couch_BasicOperations basicOperations;
    private SetupDB setupDB;
    private IPlayer player;
    String dbName = "SetGamedb";


    public  Database setUpConnection(String dbName){

        daoManager= new DaoManager_Operation();
        setupDB= daoManager.getCouchDB();
        return(setupDB.setDatabaseSession(dbName.toLowerCase()));
    }
    /**
     * @return Return new IPlayer instance
     */
    @Override
    public IPlayer create() {
        daoManager=new DaoManager_Operation();
        player=  daoManager.getPlayer();
        return player;
    }

    /**
     * @param name Player name
     * @return Return IPlayer instance with IGame
     */
    @Override
    public IPlayer getByName(String name) {
        return null;
    }

    /**
     * Insert new entry
     *
     * @param player IPlayer instance
     */

    @Override
    public void add(IPlayer player) {
        db=setUpConnection(dbName);
        daoManager=new DaoManager_Operation();
        basicOperations= daoManager.performCouchOperations();
        basicOperations.addPlayer(player, db);

    }

    /**
     * Update existent entry
     *
     * @param player IPlayer instance
     */
    @Override
    public void update(IPlayer player) {
        db=setUpConnection(dbName);
        daoManager=new DaoManager_Operation();
        basicOperations= daoManager.performCouchOperations();
        basicOperations.updatePlayer(player,db);
    }
}
