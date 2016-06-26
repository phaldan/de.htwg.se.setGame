package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardOptionHibernateTest {

    private CardOptionHibernate target;

    @Before
    public void setUp() throws Exception {
        target = new CardOptionHibernate();
    }

    @Test
    public void getId_success() throws Exception {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getCard_success() throws Exception {
        CardHibernate card = new CardHibernate();
        target.setCard(card);
        assertSame(card, target.getCard());
    }

    @Test
    public void getOption_success() throws Exception {
        OptionValueHibernate option = new OptionValueHibernate();
        target.setOption(option);
        assertSame(option, target.getOption());
    }
}