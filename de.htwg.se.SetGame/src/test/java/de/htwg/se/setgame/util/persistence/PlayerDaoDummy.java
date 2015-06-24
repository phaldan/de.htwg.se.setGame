package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.IPlayer;

/**
 * @author Philipp Daniels
 */
public class PlayerDaoDummy implements PlayerDao {

    @Override
    public IPlayer create() {
        return null;
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
