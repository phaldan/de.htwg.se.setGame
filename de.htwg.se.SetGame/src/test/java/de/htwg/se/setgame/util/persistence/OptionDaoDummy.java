package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.IOption;

/**
 * @author Philipp Daniels
 */
public class OptionDaoDummy implements OptionDao {
    @Override
    public IOption create() {
        return null;
    }

    @Override
    public void add(IOption option) {

    }

    @Override
    public void update(IOption option) {

    }
}
