package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.IOptionValue;

/**
 * @author Philipp Daniels
 */
public class OptionValueDaoDummy implements OptionValueDao {
    @Override
    public IOptionValue create() {
        return null;
    }

    @Override
    public void add(IOptionValue value) {

    }

    @Override
    public void update(IOptionValue value) {

    }
}
