package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;

/**
 * @author Philipp Daniels
 */
public class CardListDaoDummy implements CardListDao {

    @Override
    public ICardList create() {
        return null;
    }

    @Override
    public ICardList getByGame(IGame game) {
        return null;
    }

    @Override
    public void add(ICardList list) {

    }

    @Override
    public void update(ICardList list) {

    }
}
