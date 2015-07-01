package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.CardDao;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.CardCouchDb;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.GameCouchDb;
import org.ektorp.CouchDbConnector;

/**
 * @author Philipp Daniels
 */
public class CardDaoCouchDb implements CardDao {

    private CouchDbConnector db;

    protected CardDaoCouchDb(CouchDbConnector db) {
        this.db = db;
    }

    @Override
    public ICard create() {
        return new CardCouchDb();
    }

    @Override
    public void add(ICard card) {
        GameCouchDb couch = (GameCouchDb) card.getCardList().getGame();
        if (couch.getDbId() == null) {
            db.create(couch);
        } else {
            update(card);
        }
    }

    @Override
    public void update(ICard card) {
        if (card.getCardList() != null) {
            db.update(card.getCardList().getGame());
        }
    }
}
