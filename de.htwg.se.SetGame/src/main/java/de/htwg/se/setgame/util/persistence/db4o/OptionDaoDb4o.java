package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectContainer;
import de.htwg.se.setgame.model.IOption;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.util.persistence.OptionDao;

/**
 * @author Philipp Daniels
 */
public class OptionDaoDb4o extends Db4oBase implements OptionDao {

    protected OptionDaoDb4o(ObjectContainer db, ModelFactory factory) {
        super(db, factory);
    }

    @Override
    public IOption create() {
        return getFactory().createOption();
    }

    @Override
    public void add(IOption option) {
    }

    @Override
    public void update(IOption option) {

    }
}
