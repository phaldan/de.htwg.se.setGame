package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.PlayerDao;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class PlayerDaoDb4o extends Db4oBase implements PlayerDao{

    protected PlayerDaoDb4o(ObjectContainer db, ModelFactory factory) {
        super(db, factory);
    }

    @Override
    public IPlayer create() {
        return getFactory().createPlayer();
    }

    @Override
    public IPlayer getByName(final String name) {
        List<IPlayer> list = getDb().query(new Predicate<IPlayer>() {

            @Override
            public boolean match(IPlayer player) {
                return player.getName().equals(name);
            }
        });
        return (list == null || list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public void add(IPlayer player) {
        store(player);
    }

    @Override
    public void update(IPlayer player) {
        store(player);
    }
}
