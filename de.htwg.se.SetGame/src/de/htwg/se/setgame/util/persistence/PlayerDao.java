package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.IPlayer;

/**
 * @author Philipp Daniels
 */
public interface PlayerDao {

    /**
     * @return Return new IPlayer instance
     */
    IPlayer create();

    /**
     * @param name Player name
     * @return Return IPlayer instance with IGame
     */
    IPlayer getByName(String name);

    /**
     * Insert new entry
     * @param player IPlayer instance
     */
    void add(IPlayer player);

    /**
     * Update existent entry
     * @param player IPlayer instance
     */
    void update(IPlayer player);
}
