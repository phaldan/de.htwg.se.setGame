package de.htwg.se.setgame.model;

import java.util.List;

/**
 * @author Philipp
 */
public interface IPack {

    /**
     * @return pack of cards
     */
    List<ICard> getPack();

    /**
     * @param one Instance of ICard
     * @param two Instance of ICard
     * @param three Instance of ICard
     * @return Returns true, when all three cards together are a valid set.
     */
    boolean isSet(ICard one, ICard two, ICard three);
}
