package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import de.htwg.se.setgame.model.ICardOption;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardHibernateTest {

    private CardHibernate target;

    @Before
    public void setUp() throws Exception {
        target = new CardHibernate();
    }

    @Test
    public void getId_success() throws Exception {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getCardList_success() {
        CardListHibernate entity = new CardListHibernate();
        target.setCardList(entity);
        assertSame(entity, target.getCardList());
    }

    @Test
    public void getCardOptions_success() {
        LinkedHashSet<ICardOption> list = new LinkedHashSet<>();
        target.setCardOptions(list);
        assertNotNull(list);
        assertSame(list, target.getCardOptions());
    }
}