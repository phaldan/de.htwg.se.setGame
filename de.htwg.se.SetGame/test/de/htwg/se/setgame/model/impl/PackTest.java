package de.htwg.se.setgame.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.setgame.model.ICard;

import java.util.Arrays;
import java.util.List;

public class PackTest {

    Pack target;

    @Before
    public void setUp() {
        target = new Pack();
    }

    @Test
    public void testGetCards() {
        List<ICard> list = target.getPack();
        assertEquals(Card.COUNT.length * Card.COLOR.length * Card.FILL.length * Card.FORM.length, list.size());

        for (ICard card : list) {
            assertInArray(Card.COLOR, card.getColor());
            assertInArray(Card.FORM, card.getForm());
            assertInArray(Card.FILL, card.getPanelFilling());
            assertInArray(Card.COUNT, card.getNumberOfComponents());
        }
    }

    private void assertInArray(Object[] expected, Object actual) {
        assertTrue(Arrays.asList(expected).contains(actual));
    }

    @Test
    public void isSet_success_allSame() {
        Card c = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        assertTrue(target.isSet(c, c, c));
    }

    @Test
    public void isSet_success_allDifferent() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertTrue(target.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotColor() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_1, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_1, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertTrue(target.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotForm() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_1, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_1, Card.FILL_3, Card.COUNT_3);
        assertTrue(target.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotFill() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_1, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_1, Card.COUNT_3);
        assertTrue(target.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotCount() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_1);
        Card three = new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_1);
        assertTrue(target.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotFormAndFill() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_1, Card.FILL_1, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_1, Card.FILL_1, Card.COUNT_3);
        assertTrue(target.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtColor() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_1, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_2, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(target.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtForm() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_2, Card.FILL_3, Card.COUNT_3);
        assertFalse(target.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtFill() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_2, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(target.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtCount() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_3);
        Card three = new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(target.isSet(one, two, three));
    }
}
