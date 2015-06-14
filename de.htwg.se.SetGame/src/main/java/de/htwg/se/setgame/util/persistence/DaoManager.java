package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.util.persistence.Pojo.CardPojo;

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
    CardListDao getCardList();

    /**
     * @return Return instance of PlayerDao
     */
    PlayerDao getPlayer();

    /**
     * @return Return instance of GameDao
     */
    GameDao getGame();
}
