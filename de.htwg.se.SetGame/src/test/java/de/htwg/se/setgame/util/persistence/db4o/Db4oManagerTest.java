package de.htwg.se.setgame.util.persistence.db4o;

import de.htwg.se.setgame.model.ModelFactoryDummy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class Db4oManagerTest {

    private Db4oManager target;

    @Before
    public void setUp() throws Exception {
        target = new Db4oManager(new ModelFactoryDummy(), new ObjectContainerDummy());
    }

    @After
    public void tearDown() throws Exception {
        target.getDb().close();
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