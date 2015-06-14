package de.htwg.se.setgame.database.couchDB;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Session;
import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.CardListDao;
import de.htwg.se.setgame.util.persistence.DaoManager;

/**
 * Created by Pavan on 07/06/2015.
 */
public class CardList_couch implements CardListDao {
    static Session dbSession ;
    static Database db;
    private DaoManager daoManager;
    private Couch_BasicOperations basicOperations;
    private SetupDB setupDB;
    private ICardList cardList;
    String dbName = "SetGamedb";



    public  Database setUpConnection(String dbName){

        daoManager= new DaoManager_Operation();
        setupDB= daoManager.getCouchDB();
        return(setupDB.setDatabaseSession(dbName.toLowerCase()));
    }
    /**
     * @return Return new ICardList instance
     */
    @Override
    public ICardList create() {
        daoManager=new DaoManager_Operation();
        cardList=  daoManager.getCardList();
        return cardList;
    }

    /**
     * @param game IGame instance
     * @return Return ICardList instance with ICards
     */
    @Override
    public ICardList getByGame(IGame game) {
        return null;
    }

    /**
     * Add new entry
     *
     * @param list ICardList instance
     */
    @Override
    public void add(ICardList list) {
        db=setUpConnection(dbName);
        daoManager=new DaoManager_Operation();
        basicOperations= daoManager.performCouchOperations();
        basicOperations.addCardList(cardList, db);
    }

    /**
     * Update existent entry
     *
     * @param list ICardList instance
     */
    @Override
    public void update(ICardList list) {
        db=setUpConnection(dbName);
        daoManager=new DaoManager_Operation();
        basicOperations= daoManager.performCouchOperations();
        basicOperations.updateCardList(list,db);

    }
}
