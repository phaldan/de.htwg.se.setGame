package de.htwg.se.setgame.model;

import java.util.Set;

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
     * @return Returns a list of ICard instances
     */
    Set<ICard> getCards();

    /**
     * @param list Set list of ICard instances
     */
    void setCards(Set<ICard> list);

    /**
     * @return Return IGame instance
     */
    IGame getGame();

    /**
     * @param game IGame instance
     */
    void setGame(IGame game);
}
