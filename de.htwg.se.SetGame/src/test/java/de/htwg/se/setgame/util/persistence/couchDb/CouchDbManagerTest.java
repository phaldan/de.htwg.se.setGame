package de.htwg.se.setgame.util.persistence.couchDb;

import org.apache.http.conn.ConnectTimeoutException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Philipp Daniels
 */
public class CouchDbManagerTest {

    private CouchDbManager target;

    @Before
    public void setUp() throws Exception {
        target = new CouchDbManager(new CouchDbConnectorDummy());
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
        } catch (Exception e) {

        }
    }
}