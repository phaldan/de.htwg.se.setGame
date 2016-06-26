package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.IOptionValue;

/**
 * @author Philipp Daniels
 */
public interface OptionValueDao {

    /**
     * @return Return new IOption instance
     */
    IOptionValue create();

    /**
     * Add new entry
     * @param value IOptionValue instance
     */
    void add(IOptionValue value);

    /**
     * Update existent entry
     * @param value IOptionValue instance
     */
    void update(IOptionValue value);
}
