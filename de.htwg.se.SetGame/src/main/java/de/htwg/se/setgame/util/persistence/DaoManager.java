package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.util.persistence.Pojo.CardListPojo;
import de.htwg.se.setgame.util.persistence.Pojo.CardPojo;
import de.htwg.se.setgame.util.persistence.Pojo.PlayerPojo;

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
    GameDao getGame();
}
