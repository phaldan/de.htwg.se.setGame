package de.htwg.se.setgame.model.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardOptionTest {

    private CardOption target;

    @Before
    public void setUp() throws Exception {
        target = new CardOption();
    }

    @Test
    public void getId_success() throws Exception {
        assertNull(target.getId());
    }

    @Test
    public void setId_success() throws Exception {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getCard_success() throws Exception {
        assertNull(target.getCard());
    }

    @Test
    public void setCard_success() throws Exception {
        Card card = new Card();
        target.setCard(card);
        assertSame(card, target.getCard());
    }

    @Test
    public void getOption_success() throws Exception {
        assertNull(target.getOption());
    }

    @Test
    public void setOption_success() throws Exception {
        OptionValue optionValue = new OptionValue();
        target.setOption(optionValue);
        assertSame(optionValue, target.getOption());
    }
}