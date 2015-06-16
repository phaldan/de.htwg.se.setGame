package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class PlayerCouchDbTest {

    private PlayerCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new PlayerCouchDb();
    }

    @Test
    public void getDbId_success() throws Exception {
        target.setDbId("id");
        assertEquals("id", target.getDbId());
    }

    @Test
    public void getDbRev_success() throws Exception {
        target.setDbRev("rev");
        assertEquals("rev", target.getDbRev());
    }
}