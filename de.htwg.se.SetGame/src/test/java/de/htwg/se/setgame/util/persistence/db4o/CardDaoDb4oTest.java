package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import de.htwg.se.setgame.model.CardDummy;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ModelFactoryDummy;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardDaoDb4oTest {

    private class ModelFactory extends ModelFactoryDummy {

        @Override
        public ICard createCard() {
            return new CardDummy();
        }
    }

    private class ObjectContainer extends ObjectContainerDummy {

        @Override
        public void store(Object o) throws DatabaseClosedException, DatabaseReadOnlyException {
            object = o;
        }
    }

    private CardDaoDb4o target;
    private Object object;

    @Before
    public void setUp() {
        target = new CardDaoDb4o(new ObjectContainer(), new ModelFactory());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void add_success() throws Exception {
        CardDummy entity = new CardDummy();
        target.add(entity);
        assertSame(entity, object);
    }

    @Test
    public void update_success() throws Exception {
        CardDummy entity = new CardDummy();
        target.update(entity);
        assertSame(entity, object);
    }
}