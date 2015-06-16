package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.CardListDao;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.CardListCouchDb;

/**
 * @author Philipp Daniels
 */
public class CardListDaoCouchDb implements CardListDao {

    @Override
    public ICardList create() {
        return new CardListCouchDb();
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
