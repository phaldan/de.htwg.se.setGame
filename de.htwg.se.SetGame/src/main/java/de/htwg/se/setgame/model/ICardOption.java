package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public interface ICardOption {

    /**
     * @return Return id
     */
    Integer getId();

    /**
     * @param id Set identifier
     */
    void setId(Integer id);

    /**
     * @return Return ICard instance
     */
    ICard getCard();

    /**
     * @param card Set ICard instance
     */
    void setCard(ICard card);

    /**
     * @return Return IOptionValue instance
     */
    IOptionValue getOption();

    /**
     * @param option Set IOptionValue instance
     */
    void setOption(IOptionValue option);
}
