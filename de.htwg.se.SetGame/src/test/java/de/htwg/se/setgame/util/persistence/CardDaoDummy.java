package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.ICard;

/**
 * @author Philipp Daniels
 */
public class CardDaoDummy implements CardDao {

    @Override
    public ICard create() {
        return null;
    }

    @Override
    public void add(ICard card) {

    }

    @Override
    public void update(ICard card) {

    }
}
