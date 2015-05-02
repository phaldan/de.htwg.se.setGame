package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class Resize {

    private CardSet checker;
    private ICardList fieldCards;
    private ICardList unusedCards;
    private int newSize;

    /**
     * @param checker Instance of CardSet
     */
    public Resize(CardSet checker) {
        this.checker = checker;
    }

    /**
     * @param fieldCards Instance of ICardList
     * @param unusedCards Instance of ICardList
     * @param newSize New size for fieldCards
     */
    public void resize(ICardList fieldCards, ICardList unusedCards, int newSize) {
        this.fieldCards = fieldCards;
        this.unusedCards = unusedCards;
        this.newSize = newSize;
        process();
        hasSet();
    }

    private void process() {
        int currentSize = fieldCards.getCards().size();
        if (currentSize > newSize) {
            reduce(currentSize-newSize);
        } else {
            restock(newSize-currentSize);
        }
    }

    private void reduce(int diff) {
        List<ICard> list = fieldCards.getCards();
        for (int i = 0; i < diff; i++) {
            unusedCards.addCard(list.remove(0));
        }
    }

    private void restock(int diff) {
        List<ICard> list = unusedCards.getCards();
        for (int i = 0; i < diff && list.size() > 0; i++) {
            fieldCards.addCard(list.remove(0));
        }
    }

    private void hasSet() {
        int size = unusedCards.getCards().size();
        List<ICard> list = fieldCards.getCards();
        for (int i = 0; i < size && !checker.hasSet(list); i++) {
            unusedCards.addCard(list.remove(0));
            restock(1);
        }
    }

}
