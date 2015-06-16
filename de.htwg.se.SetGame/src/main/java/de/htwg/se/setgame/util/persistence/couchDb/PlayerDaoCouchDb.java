package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.PlayerDao;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.PlayerCouchDb;

/**
 * @author Philipp Daniels
 */
public class PlayerDaoCouchDb implements PlayerDao {

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

    }
}
