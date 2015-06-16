package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.IGame;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
}