package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.util.persistence.CardDao;
import de.htwg.se.setgame.util.persistence.CardListDao;
import de.htwg.se.setgame.util.persistence.DaoManager;

import java.util.LinkedList;
import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class Resize {

    private CardSet checker;
    private CardDao cardDao;
    private CardListDao cardListDao;
    private ICardList fieldCards;
    private ICardList unusedCards;
    private int newSize;

    /**
     * @param checker Instance of CardSet
     */
    public Resize(CardSet checker, DaoManager dao) {
        this.checker = checker;
        this.cardDao = dao.getCard();
        this.cardListDao = dao.getCardList();
    }

    private void remove(Set<ICard> set, ICardList list) {
        ICard card = set.iterator().next();
        set.remove(card);
        list.getCards().add(card);
        card.setCardList(list);
        cardDao.update(card);
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
        cardListDao.update(fieldCards);
        cardListDao.update(unusedCards);
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
        Set<ICard> set = fieldCards.getCards();
        for (int i = 0; i < diff; i++) {
            remove(set, unusedCards);
        }
    }

    private void restock(int diff) {
        Set<ICard> set = unusedCards.getCards();
        for (int i = 0; i < diff && set.size() > 0; i++) {
            remove(set, fieldCards);
        }
    }

    private void hasSet() {
        int size = unusedCards.getCards().size();
        Set<ICard> set = fieldCards.getCards();
        for (int i = 0; i < size && !checker.hasSet(new LinkedList<>(set)); i++) {
            remove(set, unusedCards);
            restock(1);
        }
    }

}
