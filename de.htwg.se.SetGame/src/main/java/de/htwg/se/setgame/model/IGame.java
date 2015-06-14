package de.htwg.se.setgame.model;

import java.util.List;
import java.util.Set;

/**
 * @author Philipp Daniels
 */
public interface IGame {

    /**
     * @return Return identifier
     */
    Integer getId();

    /**
     * @param id Set identifier
     */
     void setId(Integer id);

    /**
     * @return Return list of IPlayer instances
     */
    Set<IPlayer> getPlayers();

    /**
     * @param list Set list of IPlayer instances
     */
    void setPlayers(Set<IPlayer> list);

    /**
     * @return Return ICardList instance for field cards
     */
    ICardList getFieldCardList();

    /**
     * @param list ICardList instance
     */
    void setFieldCardList(ICardList list);

    /**
     * @return Return ICardList instance for unused cards
     */
    ICardList getUnusedCardList();

    /**
     * @param list ICardList instance
     */
    void setUnusedCardList(ICardList list);

    /**
     * @return Return IPlayer instance
     */
    IPlayer getWinner();

    /**
     * @param player IPlayer instance
     */
    void setWinner(IPlayer player);
}
