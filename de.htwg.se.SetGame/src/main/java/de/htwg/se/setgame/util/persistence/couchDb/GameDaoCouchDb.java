package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.GameDao;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.GameCouchDb;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.View;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class GameDaoCouchDb extends CouchDbRepositorySupport<GameCouchDb> implements GameDao {

    private static final String QUERY = "find_by_player";

    private CouchDbConnector db;

    protected GameDaoCouchDb(CouchDbConnector db) {
        super(GameCouchDb.class, db);
        this.db = db;
    }

    @Override
    public IGame create() {
        return new GameCouchDb();
    }

    @Override
    @View(name = QUERY, map = "function(doc) { if (doc.players) { for (player in doc.players) { emit(player.name, doc); } } }")
    public List<IGame> getByPlayer(IPlayer player) {
        ViewQuery query = createQuery(QUERY).key(player.getName());
        return (List) db.queryView(query, GameCouchDb.class);
    }

    @Override
    public void add(IGame game) {
        db.create(game);
    }

    @Override
    public void update(IGame game) {
        db.update(game);
    }
}
