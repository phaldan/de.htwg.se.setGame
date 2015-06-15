package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Predicate;
import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.CardList;
import de.htwg.se.setgame.model.impl.Game;
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
            return new CardList();
        }
    }

    private class ObjectContainer extends ObjectContainerDummy {

        @Override
        public void store(Object o) throws DatabaseClosedException, DatabaseReadOnlyException {
            object = o;
        }

        @Override
        public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> predicate) throws Db4oIOException, DatabaseClosedException {
            ObjectSet<TargetType> list = new ObjectSetDummy<>();
            TargetType entity = (TargetType) cardList;
            list.add(entity);
            return predicate.match(entity) ? list: null;
        }
    }

    private CardListDaoDb4o target;
    private Object object;
    private CardList cardList;

    @Before
    public void setUp() throws Exception {
        target = new CardListDaoDb4o(new ObjectContainer(), new ModelFactory());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void getByGame_success() throws Exception {
        cardList = new CardList();
        cardList.setGame(new Game());

        assertSame(cardList, target.getByGame(cardList.getGame()));
    }

    @Test
    public void add_success() throws Exception {
        CardList entity = new CardList();
        target.add(entity);
        assertSame(entity, object);
    }

    @Test
    public void update_success() throws Exception {
        CardList entity = new CardList();
        target.update(entity);
        assertSame(entity, object);
    }
}