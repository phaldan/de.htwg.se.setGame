package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.impl.CardOption;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardOptionDaoCouchDbTest {

    private CardOptionDaoCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new CardOptionDaoCouchDb(new CouchDbConnectorDummy());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void add_success() throws Exception {
        target.add(new CardOption());
    }

    @Test
    public void update_success() throws Exception {
        target.update(new CardOption());
    }
}