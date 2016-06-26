package de.htwg.se.setgame.util.persistence.db4o;

import de.htwg.se.setgame.model.IOptionValue;
import de.htwg.se.setgame.model.ModelFactoryDummy;
import de.htwg.se.setgame.model.impl.OptionValue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionValueDaoDb4oTest {

    private class ModelFactory extends ModelFactoryDummy {

        @Override
        public IOptionValue createOptionValue() {
            return new OptionValue();
        }
    }

    private OptionValueDaoDb4o target;

    @Before
    public void setUp() throws Exception {
        target = new OptionValueDaoDb4o(new ObjectContainerDummy(), new ModelFactory());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void add_success() throws Exception {
        target.add(new OptionValue());
    }

    @Test
    public void update_success() throws Exception {
        target.update(new OptionValue());
    }
}