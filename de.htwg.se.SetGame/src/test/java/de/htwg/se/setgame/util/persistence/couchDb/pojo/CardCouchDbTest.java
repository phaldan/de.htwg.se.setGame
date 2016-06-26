package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.ICardOption;
import de.htwg.se.setgame.model.impl.CardList;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardCouchDbTest {

    private CardCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new CardCouchDb();
    }

    @Test
    public void getCardList_success() {
        CardList list = new CardList();
        target.setCardList(list);
        assertSame(list, target.getCardList());
    }

    @Test
    public void getCardOptions_success() {
        LinkedHashSet<ICardOption> list = new LinkedHashSet<>();
        target.setCardOptions(list);
        assertNotNull(list);
        assertSame(list, target.getCardOptions());
    }
}