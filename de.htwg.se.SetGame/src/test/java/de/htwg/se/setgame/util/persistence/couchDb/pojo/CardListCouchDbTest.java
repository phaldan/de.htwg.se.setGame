package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.ICard;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardListCouchDbTest {

    private CardListCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new CardListCouchDb();
    }

    @Test
    public void getGame_success() {
        GameCouchDb game = new GameCouchDb();
        target.setGame(game);
        assertSame(game, target.getGame());
    }

    @Test
    public void getCards_success() {
        Set<ICard> set = new LinkedHashSet<>();
        target.setCards(set);
        assertSame(set, target.getCards());
    }
}