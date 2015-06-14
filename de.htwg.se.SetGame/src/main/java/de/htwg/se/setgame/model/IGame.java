package de.htwg.se.setgame.model;

import java.util.List;

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
     * @return Return list of IPlayer instance
     */
    List<IPlayer> getPlayers();

    /**
     * @param player Add IPlayer instance
     */
    void addPlayer(IPlayer player);

    /**
     * @param player IPlayer instance
     * @return Return true on success;
     */
    boolean removePlayer(IPlayer player);

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
