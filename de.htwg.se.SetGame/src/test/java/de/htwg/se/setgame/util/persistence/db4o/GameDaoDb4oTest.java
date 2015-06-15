package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Predicate;
import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.Game;
import org.junit.*;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class GameDaoDb4oTest {

    private class ModelFactory extends ModelFactoryDummy {

        @Override
        public IGame createGame() {
            return new Game();
        }
    }

    private class ObjectContainer extends ObjectContainerDummy {

        @Override
        public void store(Object o) throws DatabaseClosedException, DatabaseReadOnlyException {
            object = o;
        }

        @Override
        public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> predicate) throws Db4oIOException, DatabaseClosedException {
            TargetType entity = (TargetType) game;
            return predicate.match(entity) ? new ObjectSetDummy<TargetType>(): null;
        }
    }

    private GameDaoDb4o target;
    private Object object;
    private Game game;

    @Before
    public void setUp() throws Exception {
        target = new GameDaoDb4o(new ObjectContainer(), new ModelFactory());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void getByPlayer_success() throws Exception {
        IPlayer player = new PlayerDummy();
        Set<IPlayer> players = new LinkedHashSet<>();
        players.add(player);

        game = new Game();
        game.setPlayers(players);
        assertNotNull(target.getByPlayer(player));
    }

    @Test
    public void add_success() throws Exception {
        Game entity = new Game();
        target.add(entity);
        assertSame(entity, object);
    }

    @Test
    public void update_success() throws Exception {
        Game entity = new Game();
        target.update(entity);
        assertSame(entity, object);
    }
}