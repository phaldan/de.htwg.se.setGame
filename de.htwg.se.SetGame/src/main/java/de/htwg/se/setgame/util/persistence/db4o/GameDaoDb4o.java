package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.util.persistence.GameDao;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class GameDaoDb4o extends Db4oBase implements GameDao {

    protected GameDaoDb4o(ObjectContainer db, ModelFactory factory) {
        super(db, factory);
    }

    @Override
    public IGame create() {
        return getFactory().createGame();
    }

    @Override
    public List<IGame> getByPlayer(final IPlayer player) {
        return getDb().query(new Predicate<IGame>() {

            @Override
            public boolean match(IGame game) {
                return game.getPlayers().contains(player);
            }
        });
    }

    @Override
    public void add(IGame game) {
        store(game);
    }

    @Override
    public void update(IGame game) {
        store(game);
    }
}
