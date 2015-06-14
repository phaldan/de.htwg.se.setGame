package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.CardStub;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ISet;
import de.htwg.se.setgame.model.impl.Card;
import de.htwg.se.setgame.model.impl.Set;
import org.junit.Before;
import org.junit.Test;

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

    private boolean isSet(ICard one, ICard two, ICard three) {
        ISet set = new Set();
        set.setFirst(one);
        set.setSecond(two);
        set.setThird(three);
        return target.isSet(set);
    }

    @Test
    public void isSet_success_allSame() {
        ICard c = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_1);
        assertTrue(isSet(c, c, c));
    }

    @Test
    public void isSet_success_allDifferent() {
        ICard one   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_1);
        ICard two   = createCard(CardGenerator.COLOR_2, CardGenerator.FORM_2, CardGenerator.FILL_2, CardGenerator.COUNT_2);
        ICard three = createCard(CardGenerator.COLOR_3, CardGenerator.FORM_3, CardGenerator.FILL_3, CardGenerator.COUNT_3);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotColor() {
        ICard one   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_1);
        ICard two   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_2, CardGenerator.FILL_2, CardGenerator.COUNT_2);
        ICard three = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_3, CardGenerator.FILL_3, CardGenerator.COUNT_3);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotForm() {
        ICard one   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_1);
        ICard two   = createCard(CardGenerator.COLOR_2, CardGenerator.FORM_1, CardGenerator.FILL_2, CardGenerator.COUNT_2);
        ICard three = createCard(CardGenerator.COLOR_3, CardGenerator.FORM_1, CardGenerator.FILL_3, CardGenerator.COUNT_3);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotFill() {
        ICard one   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_1);
        ICard two   = createCard(CardGenerator.COLOR_2, CardGenerator.FORM_2, CardGenerator.FILL_1, CardGenerator.COUNT_2);
        ICard three = createCard(CardGenerator.COLOR_3, CardGenerator.FORM_3, CardGenerator.FILL_1, CardGenerator.COUNT_3);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotCount() {
        ICard one   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_1);
        ICard two   = createCard(CardGenerator.COLOR_2, CardGenerator.FORM_2, CardGenerator.FILL_2, CardGenerator.COUNT_1);
        ICard three = createCard(CardGenerator.COLOR_3, CardGenerator.FORM_3, CardGenerator.FILL_3, CardGenerator.COUNT_1);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotFormAndFill() {
        ICard one   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_1);
        ICard two   = createCard(CardGenerator.COLOR_2, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_2);
        ICard three = createCard(CardGenerator.COLOR_3, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_3);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtColor() {
        ICard one   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_1);
        ICard two   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_2, CardGenerator.FILL_2, CardGenerator.COUNT_2);
        ICard three = createCard(CardGenerator.COLOR_2, CardGenerator.FORM_3, CardGenerator.FILL_3, CardGenerator.COUNT_3);
        assertFalse(isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtForm() {
        ICard one   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_1);
        ICard two   = createCard(CardGenerator.COLOR_2, CardGenerator.FORM_2, CardGenerator.FILL_2, CardGenerator.COUNT_2);
        ICard three = createCard(CardGenerator.COLOR_3, CardGenerator.FORM_2, CardGenerator.FILL_3, CardGenerator.COUNT_3);
        assertFalse(isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtFill() {
        ICard one   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_2, CardGenerator.COUNT_1);
        ICard two   = createCard(CardGenerator.COLOR_2, CardGenerator.FORM_2, CardGenerator.FILL_2, CardGenerator.COUNT_2);
        ICard three = createCard(CardGenerator.COLOR_3, CardGenerator.FORM_3, CardGenerator.FILL_3, CardGenerator.COUNT_3);
        assertFalse(isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtCount() {
        ICard one   = createCard(CardGenerator.COLOR_1, CardGenerator.FORM_1, CardGenerator.FILL_1, CardGenerator.COUNT_1);
        ICard two   = createCard(CardGenerator.COLOR_2, CardGenerator.FORM_2, CardGenerator.FILL_2, CardGenerator.COUNT_3);
        ICard three = createCard(CardGenerator.COLOR_3, CardGenerator.FORM_3, CardGenerator.FILL_3, CardGenerator.COUNT_3);
        assertFalse(isSet(one, two, three));
    }
}
