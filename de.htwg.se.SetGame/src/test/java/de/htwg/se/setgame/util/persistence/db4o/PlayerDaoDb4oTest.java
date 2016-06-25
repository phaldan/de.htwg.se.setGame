package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Predicate;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.ModelFactoryDummy;
import de.htwg.se.setgame.model.PlayerDummy;
import de.htwg.se.setgame.model.impl.Game;
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
        public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> predicate) throws Db4oIOException, DatabaseClosedException {
            ObjectSetDummy<TargetType> list = new ObjectSetDummy<>();
            list.add((TargetType) new Game());
            TargetType entity = (TargetType) game;
            list.add(entity);
            return predicate.match(entity) ? list : null;
        }
    }

    private PlayerDaoDb4o target;
    private Game game;

    @Before
    public void setUp() {
        target = new PlayerDaoDb4o(new ObjectContainer(), new ModelFactory());
    }

    @Test
    public void create_success() {
        assertNotNull(target.create());
    }

    @Test
    public void add_success () {
        Player player = new Player();
        player.setGame(new Game());
        target.add(player);
    }

    @Test
    public void update_success() {
        Player player = new Player();
        player.setGame(new Game());
        target.update(player);
    }

    private Player createPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        game.getPlayers().add(player);
        player.setGame(game);
        return player;
    }

    @Test
    public void getByName_success() {
        game = new Game();
        createPlayer("player1");
        Player player = createPlayer("player2");
        assertSame(player, target.getByName("player2"));
    }

    @Test
    public void getByName_fail() {
        game = new Game();
        createPlayer("player1");
        assertNull(target.getByName("player2"));
    }
}