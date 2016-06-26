package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.IOptionValue;
import de.htwg.se.setgame.util.persistence.OptionValueDao;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.OptionValueCouchDb;
import org.ektorp.CouchDbConnector;

/**
 * @author Philipp Daniels
 */
public class OptionValueDaoCouchDb implements OptionValueDao {

    private CouchDbConnector db;

    protected OptionValueDaoCouchDb(CouchDbConnector db) {
        this.db = db;
    }

    @Override
    public IOptionValue create() {
        return new OptionValueCouchDb();
    }

    @Override
    public void add(IOptionValue value) {

    }

    @Override
    public void update(IOptionValue value) {

    }
}
