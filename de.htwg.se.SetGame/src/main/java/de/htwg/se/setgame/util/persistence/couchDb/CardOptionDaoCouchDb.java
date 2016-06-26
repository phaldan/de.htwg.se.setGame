package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.ICardOption;
import de.htwg.se.setgame.util.persistence.CardOptionDao;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.CardOptionCouchDb;
import org.ektorp.CouchDbConnector;

/**
 * @author Philipp Daniels
 */
public class CardOptionDaoCouchDb implements CardOptionDao {

    private CouchDbConnector db;

    protected CardOptionDaoCouchDb(CouchDbConnector db) {
        this.db = db;
    }

    @Override
    public ICardOption create() {
        return new CardOptionCouchDb();
    }

    @Override
    public void add(ICardOption cardOption) {

    }

    @Override
    public void update(ICardOption cardOption) {

    }
}
