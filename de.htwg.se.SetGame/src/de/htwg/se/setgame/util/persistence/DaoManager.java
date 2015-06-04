package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.database.Pojo.CardListPojo;
import de.htwg.se.setgame.database.Pojo.CardPojo;
import de.htwg.se.setgame.database.Pojo.GamePojo;
import de.htwg.se.setgame.database.Pojo.PlayerPojo;

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

}
