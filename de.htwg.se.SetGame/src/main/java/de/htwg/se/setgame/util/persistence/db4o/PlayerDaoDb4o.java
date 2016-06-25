package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.PlayerDao;

import java.util.LinkedList;
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
        List<IGame> list = getDb().query(new Predicate<IGame>() {

            @Override
            public boolean match(IGame game) {
                for (IPlayer player: game.getPlayers()) {
                    if (checkPlayer(game, player)) {
                        return true;
                    }
                }
                return false;
            }

            private boolean checkPlayer(IGame game, IPlayer player) {
                return player.getGame().equals(game) && player.getName().equals(name);
            }
        });
        return processPlayer(list, name);
    }

    private IPlayer processPlayer(List<IGame> list, String name) {
        if (list != null) {
            for (IGame game: list) {
                for (IPlayer player: game.getPlayers()) {
                    if (player.getName().equals(name)) {
                        return player;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void add(IPlayer player) {
        store(player.getGame());
    }

    @Override
    public void update(IPlayer player) {
        store(player.getGame());
    }
}
