package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.impl.CardList;
import de.htwg.se.setgame.model.impl.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class GameCouchDbTest {

    private GameCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new GameCouchDb();
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

    @Test
    public void getFieldCardList_success() {
        CardList list = new CardList();
        target.setFieldCardList(list);
        assertSame(list, target.getFieldCardList());
    }

    @Test
    public void getUnusedCardList_success() {
        CardList list = new CardList();
        target.setUnusedCardList(list);
        assertSame(list, target.getUnusedCardList());
    }

    @Test
    public void getWinner_success() {
        Player player = new Player();
        target.setWinner(player);
        assertSame(player, target.getWinner());
    }

    @Test
    public void getPlayers_success() {
        Set<IPlayer> set = new LinkedHashSet<>();
        target.setPlayers(set);
        assertSame(set, target.getPlayers());
    }

    @Test
    public void getCpu_success() {
        target.setCpu("easy");
        assertEquals("easy", target.getCpu());
    }
}