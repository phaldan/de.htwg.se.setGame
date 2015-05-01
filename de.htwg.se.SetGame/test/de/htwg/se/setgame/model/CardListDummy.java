package de.htwg.se.setgame.model;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class CardListDummy implements ICardList {
    @Override
    public void addCard(ICard card) {

    }

    @Override
    public boolean removeCard(ICard card) {
        return false;
    }

    @Override
    public List<ICard> getCards() {
        return null;
    }
}
