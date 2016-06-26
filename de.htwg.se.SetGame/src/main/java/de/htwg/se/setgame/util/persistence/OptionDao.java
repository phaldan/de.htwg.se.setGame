package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.IOption;

/**
 * @author Philipp Daniels
 */
public interface OptionDao {

    /**
     * @return Return new IOption instance
     */
    IOption create();

    /**
     * Add new entry
     * @param option IOption instance
     */
    void add(IOption option);

    /**
     * Update existent entry
     * @param option IOption instance
     */
    void update(IOption option);
}
