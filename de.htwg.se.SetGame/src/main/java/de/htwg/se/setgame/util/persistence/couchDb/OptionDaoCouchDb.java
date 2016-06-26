package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.IOption;
import de.htwg.se.setgame.util.persistence.OptionDao;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.OptionCouchDb;
import org.ektorp.CouchDbConnector;

/**
 * @author Philipp Daniels
 */
public class OptionDaoCouchDb implements OptionDao {

    private CouchDbConnector db;

    protected OptionDaoCouchDb(CouchDbConnector db) {
        this.db = db;
    }

    @Override
    public IOption create() {
        return new OptionCouchDb();
    }

    @Override
    public void add(IOption option) {

    }

    @Override
    public void update(IOption option) {

    }
}
