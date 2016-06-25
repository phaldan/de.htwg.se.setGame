package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.impl.CardList;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.GameCouchDb;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardListDaoCouchDbTest {

    private CardListDaoCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new CardListDaoCouchDb(new CouchDbConnectorDummy());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void getByGame_success() throws Exception {
        assertNull(target.getByGame(null));
    }

    @Test
    public void add_success() throws Exception {
        CardList list = new CardList();
        list.setGame(new GameCouchDb());
        target.add(list);
    }

    @Test
    public void add_successWithId() throws Exception {
        GameCouchDb game = new GameCouchDb();
        game.setDbId("1337");

        CardList list = new CardList();
        list.setGame(game);
        target.add(list);
    }

    @Test
    public void update_success() throws Exception {
        target.update(new CardList());
    }
}