package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.ICard;

/**
 * @author Philipp Daniels
 */
public interface CardDao {

    /**
     * @return Return new ICard instance
     */
    ICard create();

    /**
     * Add new entry
     * @param card ICard instance
     */
    void add(ICard card);

    /**
     * Update existent entry
     * @param card ICard instance
     */
    void update(ICard card);
}
