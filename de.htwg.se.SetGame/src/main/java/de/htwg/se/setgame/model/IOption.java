package de.htwg.se.setgame.model;

import java.util.Set;

/**
 * @author Philipp Daniels
 */
public interface IOption {

    /**
     * @return Return id
     */
    Integer getId();

    /**
     * @param id Set identifier
     */
    void setId(Integer id);

    /**
     * @return Returns name of IOption instance
     */
    String getName();

    /**
     * @param name Set name of IOption instance
     */
    void setName(String name);

    /**
     * @return Return list of IOptionValue instances
     */
    Set<IOptionValue> getOptionValues();

    /**
     * @param set Set list of IOptionValue instances
     */
    void setOptionValues(Set<IOptionValue> set);
}
