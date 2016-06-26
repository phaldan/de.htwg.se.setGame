package de.htwg.se.setgame.util.persistence.db4o;

import de.htwg.se.setgame.model.ICardOption;
import de.htwg.se.setgame.model.ModelFactoryDummy;
import de.htwg.se.setgame.model.impl.CardOption;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardOptionDaoDb4oTest {

    private class ModelFactory extends ModelFactoryDummy {

        @Override
        public ICardOption createCardOption() {
            return new CardOption();
        }
    }

    private CardOptionDaoDb4o target;

    @Before
    public void setUp() throws Exception {
        target = new CardOptionDaoDb4o(new ObjectContainerDummy(), new ModelFactory());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void add_success() throws Exception {
        target.add(new CardOption());
    }

    @Test
    public void update_success() throws Exception {
        target.update(new CardOption());
    }
}