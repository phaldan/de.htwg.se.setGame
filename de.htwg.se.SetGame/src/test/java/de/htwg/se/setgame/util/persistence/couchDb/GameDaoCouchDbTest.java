package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.impl.Player;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.GameCouchDb;
import org.ektorp.ViewQuery;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class GameDaoCouchDbTest {

    private class CouchDbConnector extends CouchDbConnectorDummy {

        @Override
        public void create(Object o) {
            create = o;
        }

        @Override
        public void update(Object o) {
            update = o;
        }

        @Override
        public <T> List<T> queryView(ViewQuery viewQuery, Class<T> aClass) {
            return new LinkedList<>();
        }
    }

    private GameDaoCouchDb target;
    private Object create;
    private Object update;

    @Before
    public void setUp() throws Exception {
        target = new GameDaoCouchDb(new CouchDbConnector());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void getByPlayer_success() throws Exception {
        List<IGame> list = target.getByPlayer(new Player());
        assertNotNull(list);
        assertTrue(list.isEmpty());
    }

    @Test
    public void add_success() throws Exception {
        GameCouchDb entity = new GameCouchDb();
        target.add(entity);
        assertSame(create, entity);
    }

    @Test
    public void update_success() throws Exception {
        GameCouchDb entity = new GameCouchDb();
        target.update(entity);
        assertSame(update, entity);

    }
}