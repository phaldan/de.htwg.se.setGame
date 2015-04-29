package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.impl.Card;
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

    private ICard createCard(String color, String form, String fill, Integer count) {
        return new CardStub(color, form, fill, count);
    }

    @Test
    public void isSet_success_allSame() {
        ICard c = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        assertTrue(SetChecker.isSet(c, c, c));
    }

    @Test
    public void isSet_success_allDifferent() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        ICard three = createCard(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotColor() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_1, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        ICard three = createCard(Card.COLOR_1, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotForm() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_2, Card.FORM_1, Card.FILL_2, Card.COUNT_2);
        ICard three = createCard(Card.COLOR_3, Card.FORM_1, Card.FILL_3, Card.COUNT_3);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotFill() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_2, Card.FORM_2, Card.FILL_1, Card.COUNT_2);
        ICard three = createCard(Card.COLOR_3, Card.FORM_3, Card.FILL_1, Card.COUNT_3);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotCount() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_1);
        ICard three = createCard(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_1);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotFormAndFill() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_2, Card.FORM_1, Card.FILL_1, Card.COUNT_2);
        ICard three = createCard(Card.COLOR_3, Card.FORM_1, Card.FILL_1, Card.COUNT_3);
        assertTrue(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtColor() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_1, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        ICard three = createCard(Card.COLOR_2, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtForm() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        ICard three = createCard(Card.COLOR_3, Card.FORM_2, Card.FILL_3, Card.COUNT_3);
        assertFalse(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtFill() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_2, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        ICard three = createCard(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(SetChecker.isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtCount() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_3);
        ICard three = createCard(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(SetChecker.isSet(one, two, three));
    }

    @Test
    public void check_success_threeCards() {
        List<ICard> list = new LinkedList<>();
        list.add(createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1));
        list.add(createCard(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2));
        list.add(createCard(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3));
        assertTrue(target.check(list));
    }

    @Test
    public void check_success_fourCards() {
        List<ICard> list = new LinkedList<>();
        list.add(createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1));
        list.add(createCard(Card.COLOR_1, Card.FORM_2, Card.FILL_2, Card.COUNT_2));
        list.add(createCard(Card.COLOR_2, Card.FORM_2, Card.FILL_2, Card.COUNT_2));
        list.add(createCard(Card.COLOR_2, Card.FORM_3, Card.FILL_3, Card.COUNT_3));
        list.add(createCard(Card.COLOR_3, Card.FORM_3, Card.FILL_3, Card.COUNT_3));
        assertTrue(target.check(list));
    }

    @Test
    public void check_fail() {
        ICard one   = createCard(Card.COLOR_1, Card.FORM_1, Card.FILL_1, Card.COUNT_1);
        ICard two   = createCard(Card.COLOR_1, Card.FORM_2, Card.FILL_2, Card.COUNT_2);
        ICard three = createCard(Card.COLOR_2, Card.FORM_3, Card.FILL_3, Card.COUNT_3);
        assertFalse(SetChecker.isSet(one, two, three));
    }
}
