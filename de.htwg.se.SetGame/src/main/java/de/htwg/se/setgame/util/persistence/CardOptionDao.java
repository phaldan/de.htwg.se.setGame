package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.ICardOption;

/**
 * @author Philipp Daniels
 */
public interface CardOptionDao {

    /**
     * @return Return new ICardOption instance
     */
    ICardOption create();

    /**
     * Add new entry
     * @param cardOption ICardOption instance
     */
    void add(ICardOption cardOption);

    /**
     * Update existent entry
     * @param cardOption ICardOption instance
     */
    void update(ICardOption cardOption);
}
