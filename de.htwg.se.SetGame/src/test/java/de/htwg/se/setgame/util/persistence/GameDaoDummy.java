package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class GameDaoDummy implements GameDao {

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
