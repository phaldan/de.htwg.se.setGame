package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Predicate;
import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.GameDummy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardListDaoDb4oTest {

    private class ModelFactory extends ModelFactoryDummy {

        @Override
        public ICardList createCardList() {
            return new CardListDummy();
        }
    }

    private class ObjectContainer extends ObjectContainerDummy {

        @Override
        public void store(Object o) throws DatabaseClosedException, DatabaseReadOnlyException {
            object = o;
        }

        @Override
        public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> predicate) throws Db4oIOException, DatabaseClosedException {
            return (ObjectSet) list;
        }
    }

    private CardListDaoDb4o target;
    private Object object;
    private ObjectSet<CardListDummy> list;

    @Before
    public void setUp() throws Exception {
        target = new CardListDaoDb4o(new ObjectContainer(), new ModelFactory());
        list = new ObjectSetDummy<>();
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void getByGame_success() throws Exception {
        CardListDummy entity = new CardListDummy();
        list.add(entity);

        assertSame(entity, target.getByGame(new GameDummy()));
    }

    @Test
    public void add_success() throws Exception {
        CardListDummy entity = new CardListDummy();
        target.add(entity);
        assertSame(entity, object);
    }

    @Test
    public void update_success() throws Exception {
        CardListDummy entity = new CardListDummy();
        target.update(entity);
        assertSame(entity, object);
    }
}