package de.htwg.se.setgame.database.couchDB;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Session;
import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.DaoManager;
import de.htwg.se.setgame.util.persistence.GameDao;

import java.util.List;

/**
 * Created by Pavan on 07/06/2015.
 */
public class Game_couch implements GameDao {
    static Session dbSession ;
    static Database db;
    private DaoManager daoManager;
    private Couch_BasicOperations basicOperations;
    private SetupDB setupDB;
    private IGame game;
    String dbName = "SetGamedb";

    public  Database setUpConnection(String dbName){

        daoManager= new DaoManager_Operation();
        setupDB= daoManager.getCouchDB();
        return(setupDB.setDatabaseSession(dbName.toLowerCase()));
    }
    /**
     * @return Return new IGame instance
     */
    @Override
    public IGame create() {
        daoManager=new DaoManager_Operation();
        game=  daoManager.getGame();
        return game;
    }

    /**
     * @return Return list of IGame instances with winner
     */
    @Override
    public List<IGame> getByPlayer() {
        return null;
    }

    /**
     * Create new entry
     *
     * @param game IGame instance
     */
    @Override
    public void add(IGame game) {
        db=setUpConnection(dbName);
        daoManager=new DaoManager_Operation();
        basicOperations= daoManager.performCouchOperations();
        basicOperations.addGame(game, db);

    }

    /**
     * Update existent entry
     *
     * @param game IGame instance
     */
    @Override
    public void update(IGame game) {
        db=setUpConnection(dbName);
        daoManager=new DaoManager_Operation();
        basicOperations= daoManager.performCouchOperations();
        basicOperations.updateGame(game,db);

    }
}
