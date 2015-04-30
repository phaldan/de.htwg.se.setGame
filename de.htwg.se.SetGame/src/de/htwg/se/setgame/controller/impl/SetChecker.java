package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.ISet;

/**
 * @author Philipp Daniels
 */
public class SetChecker {

    /**
     * @param set Instance of ISet
     * @return Returns true, when all three cards are together a valid set.
     */
    public boolean isSet(ISet set) {
        return compareColor(set) && compareForm(set) && compareFill(set) && compareCount(set);
    }

    private boolean compareColor(ISet s) {
        return compare(s.getFirst().getColor(), s.getSecond().getColor(), s.getThird().getColor());
    }

    private boolean compareForm(ISet s) {
        return compare(s.getFirst().getForm(), s.getSecond().getForm(), s.getThird().getForm());
    }

    private boolean compareFill(ISet s) {
        return compare(s.getFirst().getPanelFilling(), s.getSecond().getPanelFilling(), s.getThird().getPanelFilling());
    }

    private boolean compareCount(ISet s) {
        return compare(s.getFirst().getNumberOfComponents(), s.getSecond().getNumberOfComponents(), s.getThird().getNumberOfComponents());
    }

    private boolean compare(Object one, Object two, Object three) {
        return isAllSame(one, two, three) || isAllDifferent(one, two, three);
    }

    private boolean isAllSame(Object one, Object two, Object three) {
        return one.equals(two) && one.equals(three) && two.equals(three);
    }

    private boolean isAllDifferent(Object one, Object two, Object three) {
        return !one.equals(two) && !one.equals(three) && !two.equals(three);
    }
}
