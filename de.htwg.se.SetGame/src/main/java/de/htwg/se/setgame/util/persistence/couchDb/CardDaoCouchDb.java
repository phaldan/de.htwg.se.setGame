package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.CardDao;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.CardCouchDb;

/**
 * @author Philipp Daniels
 */
public class CardDaoCouchDb implements CardDao {

    @Override
    public ICard create() {
        return new CardCouchDb();
    }

    @Override
    public void add(ICard card) {

    }

    @Override
    public void update(ICard card) {

    }
}
