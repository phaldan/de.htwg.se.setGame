package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectContainer;
import de.htwg.se.setgame.model.IOptionValue;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.util.persistence.OptionValueDao;

/**
 * @author Philipp Daniels
 */
public class OptionValueDaoDb4o extends Db4oBase implements OptionValueDao {

    protected OptionValueDaoDb4o(ObjectContainer db, ModelFactory factory) {
        super(db, factory);
    }

    @Override
    public IOptionValue create() {
        return getFactory().createOptionValue();
    }

    @Override
    public void add(IOptionValue value) {

    }

    @Override
    public void update(IOptionValue value) {

    }
}
