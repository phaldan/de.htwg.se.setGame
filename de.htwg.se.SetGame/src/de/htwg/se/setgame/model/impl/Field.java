package de.htwg.se.setgame.model.impl;

import java.util.LinkedList;
import java.util.List;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IField;
import de.htwg.se.setgame.model.IPack;

/**
 * Class Field.
 *
 * @author David Simon & Raina Bertolini
 */
public class Field implements IField {
    public static final int MIN_SIZE = 3;

    private int size = 0;
    private LinkedList<ICard> unusedCards;
    private LinkedList<ICard> cards = new LinkedList<>();
    private SetChecker checker = new SetChecker();

    /**
     * startup of the objects
     */
    public Field(IPack pack, int size) {
        unusedCards = new LinkedList<>(pack.getPack());
        setSize(size);
    }

    @Override
    public void foundSet(ICard cardOne, ICard cardTwo, ICard cardThree) {
        if (containsCards(cardOne, cardTwo, cardThree) && SetChecker.isSet(cardOne, cardTwo, cardThree)) {
            removeCards(cardOne, cardTwo, cardThree);
            restock();
        }

    }

    private boolean containsCards(ICard one, ICard two, ICard three) {
        return cards.contains(one) && cards.contains(two) && cards.contains(three);
    }

    private void removeCards(ICard one, ICard two, ICard three) {
        cards.remove(one);
        cards.remove(two);
        cards.remove(three);
    }

    @Override
    public List<ICard> getCardsInField() {
        return cards;
    }

    @Override
    public void setSize(int size) {
        if (size >= MIN_SIZE && size <= unusedCards.size()) {
            this.size = size;
            restock();
            reduce();
        }
    }

    private void restock() {
        do {
            processRestock();
        } while (!hasSet());
    }

    private void processRestock() {
        int max = size-cards.size();
        for (int i = 0; i < max; i++) {
            addCard();
        }
    }

    private void addCard() {
        Double index = (Math.random()*unusedCards.size());
        ICard c = unusedCards.remove(index.intValue());
        cards.add(c);
    }

    private boolean hasSet() {
        if (!checker.check(cards)) {
            removeCard();
            removeCard();
            return false;
        }
        return true;
    }

    private void reduce() {
        int max = cards.size()-size;
        for (int i = 0; i < max; i++) {
            removeCard();
        }
    }

    private void removeCard() {
        unusedCards.add(cards.poll());
    }

    @Override
    public List<ICard> getUnusedCards() {
        return unusedCards;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (ICard card : getCardsInField()) {
            builder.append(card).append("\n");
        }
        return builder.toString();
    }
}
