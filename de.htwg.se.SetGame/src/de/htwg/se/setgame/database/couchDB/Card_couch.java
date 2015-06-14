package de.htwg.se.setgame.database.couchDB;
import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Session;
import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.CardDao;
import de.htwg.se.setgame.util.persistence.DaoManager;

/**
 * Created by Pavan on 07/06/2015.
 */
public class Card_couch implements CardDao {
    static Session dbSession ;
    static Database db;
    private DaoManager daoManager;
    private Couch_BasicOperations basicOperations;
    private SetupDB setupDB;
    private ICard card;
    String dbName = "SetGamedb";



    public  Database setUpConnection(String dbName){

       daoManager= new DaoManager_Operation();
       setupDB= daoManager.getCouchDB();
       return(setupDB.setDatabaseSession(dbName.toLowerCase()));
    }


    /**
     * @return Return new ICard instance
     */
    @Override
    public ICard create() {
        daoManager=new DaoManager_Operation();
        card=  daoManager.getCard();
        return card;
    }

    /**
     * @param card
     * @author Pavan
     */
    @Override
    public Integer add(ICard card) {
        db=setUpConnection(dbName);
        daoManager=new DaoManager_Operation();
         basicOperations= daoManager.performCouchOperations();
         basicOperations.addCard(card, db);
        return null;
    }

    /**
     * Update existent entry
     *
     * @param card ICard instance
     */
    @Override
    public void update(ICard card) {
        db=setUpConnection(dbName);
        daoManager=new DaoManager_Operation();
        basicOperations= daoManager.performCouchOperations();
        basicOperations.updateCard(card,db);


    }
}
