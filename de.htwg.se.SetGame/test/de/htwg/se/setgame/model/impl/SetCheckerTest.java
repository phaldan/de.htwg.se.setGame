package de.htwg.se.setgame.model.impl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Philipp Daniels
 */
public class SetCheckerTest {

    @Test
    public void isSet_success_allSame() {
        Card c = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        assertTrue(SetChecker.isSet(c, c, c));
    }

    @Test
    public void isSet_success_allDifferent() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotColor() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_1, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_1, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotForm() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_1, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_1, Card.FILL_3, Card.COUNT_3);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotFill() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_1, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_1, Card.COUNT_3);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotCount() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_1);
        Card three = new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_1);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotFormAndFill() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_1, Card.FILL_1, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_1, Card.FILL_1, Card.COUNT_3);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtColor() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_1, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_2, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtForm() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_2, Card.FILL_3, Card.COUNT_3);
        assertFalse(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtFill() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_2, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtCount() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_3);
        Card three = new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(SetChecker.isSet(one, two, three));
    }
}
