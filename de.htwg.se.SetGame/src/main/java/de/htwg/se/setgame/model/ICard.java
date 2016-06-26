package de.htwg.se.setgame.model;

import java.util.Set;

/**
 * @author Philipp
 */
public interface ICard {

    /**
     * @return Return id
     */
    Integer getId();

    /**
     * @param id Set identifier
     */
    void setId(Integer id);

    /**
     * @return ICardList instance
     */
    ICardList getCardList();

    /**
     * @param list ICardList instance
     */
    void setCardList(ICardList list);

    /**
     * @return Return list of ICardOption instances
     */
    Set<ICardOption> getCardOptions();

    /**
     * @param list Set list of ICardOption instances
     */
    void setCardOptions(Set<ICardOption> list);

    /**
     * @return string method
     */
    String toString();
}