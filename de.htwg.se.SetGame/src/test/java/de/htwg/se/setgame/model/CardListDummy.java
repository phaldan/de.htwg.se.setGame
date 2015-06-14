package de.htwg.se.setgame.model;

import java.util.LinkedHashSet;
import java.util.Set;

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
    public Set<ICard> getCards() {
        return new LinkedHashSet<>();
    }

    @Override
    public void setCards(Set<ICard> list) {

    }

    @Override
    public IGame getGame() {
        return null;
    }

    @Override
    public void setGame(IGame game) {

    }
}
