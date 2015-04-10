package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Philipp Daniels
 */
public class SetCheckerTest {

    private SetChecker target;

    @Before
    public void setUp() {
        target = new SetChecker();
    }

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

    @Test
    public void check_success_threeCards() {
        List<ICard> list = new LinkedList<>();
        list.add(new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1));
        list.add(new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2));
        list.add(new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3));
        assertTrue(target.check(list));
    }

    @Test
    public void check_success_fourCards() {
        List<ICard> list = new LinkedList<>();
        list.add(new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1));
        list.add(new Card(Card.COLOR_1, Card.FORM_2, Card.FILL_2, Card.COUNT_2));
        list.add(new Card(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2));
        list.add(new Card(Card.COLOR_2, Card.FORM_3, Card.FILL_3, Card.COUNT_3));
        list.add(new Card(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3));
        assertTrue(target.check(list));
    }

    @Test
    public void check_fail() {
        Card one   = new Card(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        Card two   = new Card(Card.COLOR_1, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        Card three = new Card(Card.COLOR_2, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(SetChecker.isSet(one, two, three));
    }
}