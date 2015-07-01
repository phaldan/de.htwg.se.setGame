package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.CardListDao;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.CardListCouchDb;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.GameCouchDb;
import org.ektorp.CouchDbConnector;

/**
 * @author Philipp Daniels
 */
public class CardListDaoCouchDb implements CardListDao {

    private CouchDbConnector db;

    protected CardListDaoCouchDb(CouchDbConnector db) {
        this.db = db;
    }

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
        GameCouchDb couch = (GameCouchDb) list.getGame();
        if (couch.getDbId() == null) {
            db.create(couch);
        } else {
            update(list);
        }
    }

    @Override
    public void update(ICardList list) {
        db.update(list.getGame());
    }
}
