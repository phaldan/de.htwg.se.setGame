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
    public void getGame_success() {
        GameCouchDb game = new GameCouchDb();
        target.setGame(game);
        assertSame(game, target.getGame());
    }

    @Test
    public void getScore_success() {
        target.setScore(1337);
        assertEquals(1337, target.getScore());
    }

    @Test
    public void getName_success() {
        target.setName("John Doe");
        assertEquals("John Doe", target.getName());
    }
}