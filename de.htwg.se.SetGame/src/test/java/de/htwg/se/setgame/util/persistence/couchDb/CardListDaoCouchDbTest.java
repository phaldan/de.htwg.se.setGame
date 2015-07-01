package de.htwg.se.setgame.util.persistence.couchDb;

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
        target.add(null);
    }

    @Test
    public void update_success() throws Exception {
        target.update(null);
    }
}