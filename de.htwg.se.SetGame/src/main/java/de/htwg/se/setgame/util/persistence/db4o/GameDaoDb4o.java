package de.htwg.se.setgame.util.persistence.db4o;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.GameDao;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class GameDaoDb4o implements GameDao {

    @Override
    public IGame create() {
        return null;
    }

    @Override
    public List<IGame> getByPlayer(IPlayer player) {
        return null;
    }

    @Override
    public void add(IGame game) {

    }

    @Override
    public void update(IGame game) {

    }
}
