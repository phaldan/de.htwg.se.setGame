package de.htwg.se.setgame.model;

import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class CardDummy implements ICard {

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public ICardList getCardList() {
        return null;
    }

    @Override
    public void setCardList(ICardList list) {

    }

    @Override
    public Set<ICardOption> getCardOptions() {
        return null;
    }

    @Override
    public void setCardOptions(Set<ICardOption> list) {

    }
}
