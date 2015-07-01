package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.PlayerDao;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.GameCouchDb;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.PlayerCouchDb;
import org.ektorp.CouchDbConnector;

/**
 * @author Philipp Daniels
 */
public class PlayerDaoCouchDb implements PlayerDao {

    private CouchDbConnector db;

    protected PlayerDaoCouchDb(CouchDbConnector db) {
        this.db = db;
    }

    @Override
    public IPlayer create() {
        return new PlayerCouchDb();
    }

    @Override
    public IPlayer getByName(String name) {
        return null;
    }

    @Override
    public void add(IPlayer player) {

    }

    @Override
    public void update(IPlayer player) {
        db.update(player.getGame());
    }
}
