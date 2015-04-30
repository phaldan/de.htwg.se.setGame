package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ISet;
import de.htwg.se.setgame.model.ModelFactory;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class CardSet {

    private List<ICard> cards;
    private ISet set;
    private ModelFactory factory;
    private SetChecker checker;

    public CardSet(ModelFactory factory, SetChecker checker) {
        this.factory = factory;
        this.checker = checker;
    }

    /**
     * @param cards List of cards
     * @return Returns false, when list of cards has not a single valid set.
     */
    public boolean hasSet(List<ICard> cards) {
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
        set = factory.createSet();
        set.setFirst(cards.get(oneI));
        set.setSecond(cards.get(twoI));
        set.setThird(cards.get(threeI));
        return checker.isSet(set);
    }

    /**
     * @param cards List of cards
     * @return Returns null or a valid set as ISet instance
     */
    public ISet getSet(List<ICard> cards) {
        return hasSet(cards) ? set : null;
    }
}
