package de.htwg.se.setgame.util.persistence.db4o;

import de.htwg.se.setgame.model.IOption;
import de.htwg.se.setgame.model.ModelFactoryDummy;
import de.htwg.se.setgame.model.impl.Option;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionDaoDb4oTest {

    private class ModelFactory extends ModelFactoryDummy {

        @Override
        public IOption createOption() {
            return new Option();
        }
    }

    private OptionDaoDb4o target;

    @Before
    public void setUp() throws Exception {
        target = new OptionDaoDb4o(new ObjectContainerDummy(), new ModelFactory());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void add_success() throws Exception {
        target.add(new Option());
    }

    @Test
    public void update_success() throws Exception {
        target.update(new Option());
    }
}