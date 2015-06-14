package de.htwg.se.setgame.model;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public interface ICardList {

    /**
     * @return Return identifier
     */
    Integer getId();

    /**
     * @param id Set identifier
     */
    void setId(Integer id);

    /**
     * @param card Instance of ICard
     */
    void addCard(ICard card);

    /**
     * @param card Instance of ICard
     * @return Returns removed ICard instance, or null
     */
    ICard removeCard(ICard card);

    /**
     * @return Returns a list of ICard instances
     */
    List<ICard> getCards();

    /**
     * @return Return IGame instance
     */
    IGame getGame();

    /**
     * @param game IGame instance
     */
    void setGame(IGame game);
}
