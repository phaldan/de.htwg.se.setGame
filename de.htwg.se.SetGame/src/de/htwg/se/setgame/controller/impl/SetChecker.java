package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.ICard;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class SetChecker {

    /**
     * @param one Instance of ICard
     * @param two Instance of ICard
     * @param three Instance of ICard
     * @return Returns true, when all three cards are together a valid set.
     */
    public static boolean isSet(ICard one, ICard two, ICard three) {
        return compareColor(one, two, three) && compareForm(one, two, three)
                && compareFill(one, two, three) && compareCount(one, two, three);
    }

    private static boolean compareColor(ICard one, ICard two, ICard three) {
        return compare(one.getColor(), two.getColor(), three.getColor());
    }

    private static boolean compareForm(ICard one, ICard two, ICard three) {
        return compare(one.getForm(), two.getForm(), three.getForm());
    }

    private static boolean compareFill(ICard one, ICard two, ICard three) {
        return compare(one.getPanelFilling(), two.getPanelFilling(), three.getPanelFilling());
    }

    private static boolean compareCount(ICard one, ICard two, ICard three) {
        return compare(one.getNumberOfComponents(), two.getNumberOfComponents(), three.getNumberOfComponents());
    }

    private static boolean compare(Object one, Object two, Object three) {
        return isAllSame(one, two, three) || isAllDifferent(one, two, three);
    }

    private static boolean isAllSame(Object one, Object two, Object three) {
        return one.equals(two) && one.equals(three) && two.equals(three);
    }

    private static boolean isAllDifferent(Object one, Object two, Object three) {
        return !one.equals(two) && !one.equals(three) && !two.equals(three);
    }

    private List<ICard> cards;

    /**
     * @param cards List of cards
     * @return Returns false, when list of cards has not a single valid set.
     */
    public boolean check(List<ICard> cards) {
        this.cards = cards;
        return hasSetOne();
    }

    private boolean hasSetOne() {
        for (int i=0; i< cards.size()-2; i++) {
            if (hasSetTwo(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSetTwo(int one) {
        for (int i=one + 1; i < cards.size()-1; i++) {
            if (hasSetThree(one, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSetThree(int oneI, int twoI) {
        for (int i=twoI+1; i < cards.size(); i++) {
            if (checkSet(oneI, twoI, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSet(int oneI, int twoI, int threeI) {
        ICard one = cards.get(oneI);
        ICard two = cards.get(twoI);
        ICard three = cards.get(threeI);
        return SetChecker.isSet(one, two, three);
    }
}
