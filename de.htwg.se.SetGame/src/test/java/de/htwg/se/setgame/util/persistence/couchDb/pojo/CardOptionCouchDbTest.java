package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardOptionCouchDbTest {

    private CardOptionCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new CardOptionCouchDb();
    }

    @Test
    public void getCard_success() throws Exception {
        CardCouchDb card = new CardCouchDb();
        target.setCard(card);
        assertSame(card, target.getCard());
    }

    @Test
    public void getOption_success() throws Exception {
        OptionValueCouchDb option = new OptionValueCouchDb();
        target.setOption(option);
        assertSame(option, target.getOption());
    }
}