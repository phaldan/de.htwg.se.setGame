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

    protected static final String COLOR_1 = "red";
    protected static final String COLOR_2 = "green";
    protected static final String COLOR_3 = "purple";
    protected static final String FORM_1 = "ovally";
    protected static final String FORM_2 = "wave";
    protected static final String FORM_3 = "balk";
    protected static final String FILL_1 = "halffill";
    protected static final String FILL_2 = "fill";
    protected static final String FILL_3 = "empty";
    protected static final Integer COUNT_1 = 1;
    protected static final Integer COUNT_2 = 2;
    protected static final Integer COUNT_3 = 3;

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
        ICard c = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_1);
        assertTrue(isSet(c, c, c));
    }

    @Test
    public void isSet_success_allDifferent() {
        ICard one   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_1);
        ICard two   = createCard(SetCheckerTest.COLOR_2, SetCheckerTest.FORM_2, SetCheckerTest.FILL_2, SetCheckerTest.COUNT_2);
        ICard three = createCard(SetCheckerTest.COLOR_3, SetCheckerTest.FORM_3, SetCheckerTest.FILL_3, SetCheckerTest.COUNT_3);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotColor() {
        ICard one   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_1);
        ICard two   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_2, SetCheckerTest.FILL_2, SetCheckerTest.COUNT_2);
        ICard three = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_3, SetCheckerTest.FILL_3, SetCheckerTest.COUNT_3);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotForm() {
        ICard one   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_1);
        ICard two   = createCard(SetCheckerTest.COLOR_2, SetCheckerTest.FORM_1, SetCheckerTest.FILL_2, SetCheckerTest.COUNT_2);
        ICard three = createCard(SetCheckerTest.COLOR_3, SetCheckerTest.FORM_1, SetCheckerTest.FILL_3, SetCheckerTest.COUNT_3);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotFill() {
        ICard one   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_1);
        ICard two   = createCard(SetCheckerTest.COLOR_2, SetCheckerTest.FORM_2, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_2);
        ICard three = createCard(SetCheckerTest.COLOR_3, SetCheckerTest.FORM_3, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_3);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotCount() {
        ICard one   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_1);
        ICard two   = createCard(SetCheckerTest.COLOR_2, SetCheckerTest.FORM_2, SetCheckerTest.FILL_2, SetCheckerTest.COUNT_1);
        ICard three = createCard(SetCheckerTest.COLOR_3, SetCheckerTest.FORM_3, SetCheckerTest.FILL_3, SetCheckerTest.COUNT_1);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_success_allDifferentNotFormAndFill() {
        ICard one   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_1);
        ICard two   = createCard(SetCheckerTest.COLOR_2, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_2);
        ICard three = createCard(SetCheckerTest.COLOR_3, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_3);
        assertTrue(isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtColor() {
        ICard one   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_1);
        ICard two   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_2, SetCheckerTest.FILL_2, SetCheckerTest.COUNT_2);
        ICard three = createCard(SetCheckerTest.COLOR_2, SetCheckerTest.FORM_3, SetCheckerTest.FILL_3, SetCheckerTest.COUNT_3);
        assertFalse(isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtForm() {
        ICard one   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_1);
        ICard two   = createCard(SetCheckerTest.COLOR_2, SetCheckerTest.FORM_2, SetCheckerTest.FILL_2, SetCheckerTest.COUNT_2);
        ICard three = createCard(SetCheckerTest.COLOR_3, SetCheckerTest.FORM_2, SetCheckerTest.FILL_3, SetCheckerTest.COUNT_3);
        assertFalse(isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtFill() {
        ICard one   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_2, SetCheckerTest.COUNT_1);
        ICard two   = createCard(SetCheckerTest.COLOR_2, SetCheckerTest.FORM_2, SetCheckerTest.FILL_2, SetCheckerTest.COUNT_2);
        ICard three = createCard(SetCheckerTest.COLOR_3, SetCheckerTest.FORM_3, SetCheckerTest.FILL_3, SetCheckerTest.COUNT_3);
        assertFalse(isSet(one, two, three));
    }

    @Test
    public void isSet_fail_onlyTwoSameAtCount() {
        ICard one   = createCard(SetCheckerTest.COLOR_1, SetCheckerTest.FORM_1, SetCheckerTest.FILL_1, SetCheckerTest.COUNT_1);
        ICard two   = createCard(SetCheckerTest.COLOR_2, SetCheckerTest.FORM_2, SetCheckerTest.FILL_2, SetCheckerTest.COUNT_3);
        ICard three = createCard(SetCheckerTest.COLOR_3, SetCheckerTest.FORM_3, SetCheckerTest.FILL_3, SetCheckerTest.COUNT_3);
        assertFalse(isSet(one, two, three));
    }
}
