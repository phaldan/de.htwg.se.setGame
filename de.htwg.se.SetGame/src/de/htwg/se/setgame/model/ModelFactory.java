package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public interface ModelFactory {

    /**
     * @return Return new ISet instance
     */
    ISet createSet();

    /**
     * @return Return new ICardList instance
     */
    ICardList createCardList();

    /**
     * @return Return new ICard instance
     */
    ICard createCard();

    /**
     * @return Return new IPlayer instance
     */
    IPlayer createPlayer();
}
