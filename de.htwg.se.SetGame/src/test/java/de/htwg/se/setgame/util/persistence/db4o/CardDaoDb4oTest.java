package de.htwg.se.setgame.util.persistence.db4o;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ModelFactoryDummy;
import de.htwg.se.setgame.model.impl.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardDaoDb4oTest {

    private class ModelFactory extends ModelFactoryDummy {

        @Override
        public ICard createCard() {
            return new Card();
        }
    }

    private CardDaoDb4o target;

    @Before
    public void setUp() {
        target = new CardDaoDb4o(new ObjectContainerDummy(), new ModelFactory());
    }

    @Test
    public void create_success() throws Exception {
        assertNotNull(target.create());
    }

    @Test
    public void add_success() throws Exception {
        CardList list = new CardList();
        list.setGame(new Game());
        Card entity = new Card();
        entity.setCardList(list);
        target.add(entity);
    }

    @Test
    public void update_success() throws Exception {
        CardList list = new CardList();
        list.setGame(new Game());
        Card entity = new Card();
        entity.setCardList(list);
        target.update(entity);
    }
}