package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.impl.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class PlayerDaoCouchDbTest {

    private PlayerDaoCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new PlayerDaoCouchDb(new CouchDbConnectorDummy());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void getByName_success() throws Exception {
        assertNull(target.getByName(null));
    }

    @Test
    public void add_success() throws Exception {
        target.add(new Player());
    }

    @Test
    public void update_success() throws Exception {
        target.update(new Player());
    }
}