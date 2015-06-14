package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.database.Pojo.CardListPojo;
import de.htwg.se.setgame.database.Pojo.CardPojo;
import de.htwg.se.setgame.database.Pojo.GamePojo;
import de.htwg.se.setgame.database.Pojo.PlayerPojo;
import de.htwg.se.setgame.database.couchDB.Couch_BasicOperations;
import de.htwg.se.setgame.database.couchDB.SetupDB;

/**
 * @author Philipp Daniels
 */
public interface DaoManager {

    /**
     * @return Return instance of CardDao
     */
    CardPojo getCard();

    /**
     * @return Return instance of CardListDao
     */
    CardListPojo getCardList();

    /**
     * @return Return instance of PlayerDao
     */
    PlayerPojo getPlayer();

    /**
     * @return Return instance of GameDao
     */
    GamePojo getGame();

    /**
     * @return Return instance of ISession
     */
    ISession createSession();

    /**
     * Only for CouchDB
     * @return Return instance of SetupDB
     */

     SetupDB getCouchDB();

    /**
     * Only for CouchDB
     * @return Return instance of Couch_BasicOperations
     */
     Couch_BasicOperations  performCouchOperations();
}
