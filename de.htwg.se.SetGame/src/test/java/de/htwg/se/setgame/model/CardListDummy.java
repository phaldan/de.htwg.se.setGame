package de.htwg.se.setgame.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class CardListDummy implements ICardList {

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public void addCard(ICard card) {

    }

    @Override
    public ICard removeCard(ICard card) {
        return null;
    }

    @Override
    public List<ICard> getCards() {
        return new LinkedList<>();
    }

    @Override
    public IGame getGame() {
        return null;
    }

    @Override
    public void setGame(IGame game) {

    }
}
