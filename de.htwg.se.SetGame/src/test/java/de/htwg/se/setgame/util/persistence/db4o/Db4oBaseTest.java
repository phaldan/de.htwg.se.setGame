package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectContainer;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.ModelFactoryDummy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class Db4oBaseTest {

    private class Db4oBaseDummy extends Db4oBase {

        protected Db4oBaseDummy(ObjectContainer db, ModelFactory factory) {
            super(db, factory);
        }
    }

    private class ObjectContainerTest extends ObjectContainerDummy {

        @Override
        public void store(Object o) throws DatabaseClosedException, DatabaseReadOnlyException {
            throw new DatabaseClosedException();
        }
    }

    private Db4oBase target;

    @Before
    public void setUp() throws Exception {
        target = new Db4oBaseDummy(new ObjectContainerTest(), new ModelFactoryDummy());
    }

    @Test
    public void store_success() throws Exception {
        target.store(null);
    }
}