package de.htwg.se.setgame.util.persistence.db4o;

import de.htwg.se.setgame.model.IPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class Player_db4oTest {

    private Player_db4o target;

    @Before
    public void setUp() throws Exception {
        target = new Player_db4o();
    }

    @Test
    public void create_success() throws Exception{
        assertNotNull(target.create());
    }

    @Test
    public void add_success () throws Exception{
        IPlayer player = target.create();
        player.setName("Max Mustermann");
        target.add(player);

        IPlayer result = target.getByName(player.getName());
        assertNotNull(result);
        assertEquals(player.getName(), result.getName());
    }
}