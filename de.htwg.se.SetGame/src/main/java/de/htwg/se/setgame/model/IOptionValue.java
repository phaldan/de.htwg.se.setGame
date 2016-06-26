package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public interface IOptionValue {

    /**
     * @return Return id
     */
    Integer getId();

    /**
     * @param id Set identifier
     */
    void setId(Integer id);

    /**
     * @return Return IOption instance
     */
    IOption getOption();

    /**
     * @param option Set IOption instance
     */
    void setOption(IOption option);

    /**
     * @return Return value
     */
    String getValue();

    /**
     * @param value Set value
     */
    void setValue(String value);
}
