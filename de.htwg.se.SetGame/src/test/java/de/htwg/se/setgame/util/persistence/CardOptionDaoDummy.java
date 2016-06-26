package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.ICardOption;

/**
 * @author Philipp Daniels
 */
public class CardOptionDaoDummy implements CardOptionDao {

    @Override
    public ICardOption create() {
        return null;
    }

    @Override
    public void add(ICardOption cardOption) {

    }

    @Override
    public void update(ICardOption cardOption) {

    }
}
