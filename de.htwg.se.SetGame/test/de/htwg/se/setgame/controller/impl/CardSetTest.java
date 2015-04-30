package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.aview.CardDummy;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ISet;
import de.htwg.se.setgame.model.SetDummy;
import de.htwg.se.setgame.model.impl.ModelFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardSetTest {

    private CardSet target;
    private ISet setStub;

    private class Checker extends SetChecker {

        @Override
        public boolean isSet(ISet set) {
            return setStub != null && set.getFirst().equals(setStub.getFirst()) && set.getSecond().equals(setStub.getSecond()) && set.getThird().equals(setStub.getThird());
        }
    }

    private class Set extends SetDummy {

        private ICard first;
        private ICard second;
        private ICard third;

        public Set(ICard first, ICard second, ICard third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public ICard getFirst() {
            return first;
        }

        @Override
        public ICard getSecond() {
            return second;
        }

        @Override
        public ICard getThird() {
            return third;
        }
    }

    @Before
    public void setUp() {
        target = new CardSet(new ModelFactoryImpl(), new Checker());

        ICard one = new CardDummy();
        ICard two = new CardDummy();
        ICard three = new CardDummy();
        setStub = new Set(one, two, three);
    }

    private List<ICard> addStub(List<ICard> list) {
        list.add(setStub.getFirst());
        list.add(setStub.getSecond());
        list.add(setStub.getThird());
        return list;
    }

    @Test
    public void hasSet_success_threeCards() {
        List<ICard> list = addStub(new LinkedList<ICard>());
        assertTrue(target.hasSet(list));
    }

    @Test
    public void hasSet_success_fourCards() {
        List<ICard> list = new LinkedList<>();
        list.add(new CardDummy());
        addStub(list).add(new CardDummy());

        assertTrue(target.hasSet(list));
    }

    @Test
    public void hasSet_fail() {
        assertFalse(target.hasSet(new LinkedList<ICard>()));
    }

    @Test
    public void getSet_success() {
        List<ICard> list = addStub(new LinkedList<ICard>());
        ISet set = target.getSet(list);

        assertNotNull(set);
        assertEquals(setStub.getFirst(), set.getFirst());
        assertEquals(setStub.getSecond(), set.getSecond());
        assertEquals(setStub.getThird(), set.getThird());
    }

    @Test
    public void getSet_fail() {
        assertNull(target.getSet(new LinkedList<ICard>()));
    }
}
