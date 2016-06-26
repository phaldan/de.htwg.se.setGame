package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionCouchDbTest {

    private OptionCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new OptionCouchDb();
    }

    @Test
    public void testGetName() throws Exception {
        target.setName("count");
        assertEquals("count", target.getName());
    }
}