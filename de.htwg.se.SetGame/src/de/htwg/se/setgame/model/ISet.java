package de.htwg.se.setgame.model;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public interface ISet {

    /**
     * @return Return ICard instance
     */
    ICard getFirst();

    /**
     * @param first Instance of ICard
     */
    void setFirst(ICard first);

    /**
     * @return Return ICard instance
     */
    ICard getSecond();

    /**
     * @param second Instance of ICard
     */
    void setSecond(ICard second);

    /**
     * @return Return ICard instance
     */
    ICard getThird();

    /**
     * @param third Instance of ICard
     */
    void setThird(ICard third);

    /**
     * @return Return all three ICard instances
     */
    List<ICard> getAll();
}
