package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;

/**
 * @author Philipp Daniels
 */
public class SetChecker {

    /**
     * @param one Instance of ICard
     * @param two Instance of ICard
     * @param three Instance of ICard
     * @return Returns true, when all three cards together are a valid set.
     */
    public static boolean isSet(ICard one, ICard two, ICard three) {
        return compare(one.getColor(), two.getColor(), three.getColor())
                && compare(one.getForm(), two.getForm(), three.getForm())
                && compare(one.getPanelFilling(), two.getPanelFilling(), three.getPanelFilling())
                && compare(one.getNumberOfComponents(), two.getNumberOfComponents(), three.getNumberOfComponents());
    }

    private static boolean compare(Object one, Object two, Object three) {
        return one.equals(two) && one.equals(three) && two.equals(three)
                || !one.equals(two) && !one.equals(three) && !two.equals(three);
    }
}
