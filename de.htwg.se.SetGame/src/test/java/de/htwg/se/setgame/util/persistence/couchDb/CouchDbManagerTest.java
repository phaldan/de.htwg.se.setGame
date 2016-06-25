package de.htwg.se.setgame.util.persistence.couchDb;

import org.ektorp.DbAccessException;
import org.ektorp.http.HttpClient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CouchDbManagerTest {

    private CouchDbManager target;
    private boolean shutdown;

    @Before
    public void setUp() throws Exception {
        target = new CouchDbManager(new CouchDbConnectorDummy() {

            @Override
            public HttpClient getConnection() {
                return new HttpClientDummy() {

                    @Override
                    public void shutdown() {
                        shutdown = true;
                    }
                };
            }
        });
    }

    @Test
    public void getCard_success() throws Exception {
        assertNotNull(target.getCard());
    }

    @Test
    public void getCardList_success() throws Exception {
        assertNotNull(target.getCardList());
    }

    @Test
    public void getPlayer_success() throws Exception {
        assertNotNull(target.getPlayer());
    }

    @Test
    public void getGame_success() throws Exception {
        assertNotNull(target.getGame());
    }

    @Test
    public void constructor() throws Exception {
        try {
            new CouchDbManager();
            fail();
        } catch (Exception e) {
            assertEquals(DbAccessException.class.getName(), e.getClass().getName());
        }
    }

    @Test
    public void exit_success() {
        shutdown = false;
        target.exit();
        assertTrue(shutdown);
    }
}