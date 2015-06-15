package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Predicate;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.ModelFactoryDummy;
import de.htwg.se.setgame.model.PlayerDummy;
import de.htwg.se.setgame.model.impl.Player;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class PlayerDaoDb4oTest {

    private class ModelFactory extends ModelFactoryDummy {

        @Override
        public IPlayer createPlayer() {
            return new PlayerDummy();
        }
    }

    private class ObjectContainer extends ObjectContainerDummy {

        @Override
        public void store(Object o) throws DatabaseClosedException, DatabaseReadOnlyException {
            object = o;
        }

        @Override
        public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> predicate) throws Db4oIOException, DatabaseClosedException {
            ObjectSetDummy<TargetType> list = new ObjectSetDummy<>();
            TargetType entity = (TargetType) player;
            list.add(entity);
            return predicate.match(entity) ? list : null;
        }
    }

    private PlayerDaoDb4o target;
    private Object object;
    private Player player;

    @Before
    public void setUp() throws Exception {
        target = new PlayerDaoDb4o(new ObjectContainer(), new ModelFactory());
    }

    @Test
    public void create_success() throws Exception{
        assertNotNull(target.create());
    }

    @Test
    public void add_success () throws Exception{
        PlayerDummy entity = new PlayerDummy();
        target.add(entity);
        assertSame(entity, object);
    }

    @Test
    public void update_success() throws Exception {
        PlayerDummy entity = new PlayerDummy();
        target.update(entity);
        assertSame(entity, object);
    }

    @Test
    public void getByName_success() throws Exception {
        player = new Player();
        player.setName("test");

        assertSame(player, target.getByName(player.getName()));
    }
}