package de.htwg.se.setgame.model;

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
}
