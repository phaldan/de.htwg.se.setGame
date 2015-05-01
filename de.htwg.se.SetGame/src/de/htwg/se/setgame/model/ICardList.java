package de.htwg.se.setgame.model;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public interface ICardList {

    /**
     * @param card Instance of ICard
     */
    void addCard(ICard card);

    /**
     * @param card Instance of ICard
     * @return Returns true, when remove was successful
     */
    boolean removeCard(ICard card);

    /**
     * @return Returns a list of ICard instances
     */
    List<ICard> getCards();
}
