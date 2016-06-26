package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.ICardOption;
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
        int count = set.getFirst().getCardOptions().size();
        ICardOption[] first = set.getFirst().getCardOptions().toArray(new ICardOption[count]);
        ICardOption[] second = set.getSecond().getCardOptions().toArray(new ICardOption[count]);
        ICardOption[] third = set.getThird().getCardOptions().toArray(new ICardOption[count]);
        return compareCardOption(first, second, third);
    }

    private boolean compareCardOption(ICardOption[] first, ICardOption[] second, ICardOption[] third) {
        boolean result = true;
        for (int i = 0; i < first.length; i++) {
            result = result && compareOption(first[i], second[i], third[i]);
        }
        return result;
    }

    private boolean compareOption(ICardOption first, ICardOption second, ICardOption third) {
        return compare(first.getOption().getValue(), second.getOption().getValue(), third.getOption().getValue());

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
