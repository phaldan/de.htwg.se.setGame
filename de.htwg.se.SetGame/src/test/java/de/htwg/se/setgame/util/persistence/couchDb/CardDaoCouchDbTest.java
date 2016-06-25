package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.model.impl.Card;
import de.htwg.se.setgame.model.impl.CardList;
import de.htwg.se.setgame.model.impl.Game;
import de.htwg.se.setgame.util.persistence.couchDb.pojo.GameCouchDb;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardDaoCouchDbTest {

    private CardDaoCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new CardDaoCouchDb(new CouchDbConnectorDummy());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void add_success() throws Exception {
        Card card = new Card();
        card.setCardList(new CardList());
        card.getCardList().setGame(new GameCouchDb());
        target.add(card);
    }

    @Test
    public void add_successWithId() throws Exception {
        Card card = new Card();
        card.setCardList(new CardList());

        GameCouchDb game = new GameCouchDb();
        game.setDbId("1337");
        card.getCardList().setGame(game);

        target.add(card);
    }

    @Test
    public void update_success() throws Exception {
        Card card = new Card();
        card.setCardList(new CardList());
        card.getCardList().setGame(new Game());
        target.update(card);
    }
}