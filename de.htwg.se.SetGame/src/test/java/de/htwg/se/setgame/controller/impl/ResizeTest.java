package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.CardList;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class ResizeTest {

    private Resize target;
    private List<ICard> field;
    private List<ICard> unused;
    private boolean hasSet;

    private class CardListStub extends CardListDummy {

        private List<ICard> cards = new LinkedList<>();

        public CardListStub(List<ICard> cards) {
            this.cards = cards;
        }

        @Override
        public ICard removeCard(ICard card) {
            return cards.remove(card) ? card : null;
        }

        @Override
        public void addCard(ICard card) {
            cards.add(card);
        }

        @Override
        public List<ICard> getCards() {
            return cards;
        }
    }

    private class CardSetStub extends CardSet {

        public CardSetStub() {
            super(new ModelFactoryDummy(), new SetChecker());
        }

        @Override
        public boolean hasSet(List<ICard> cards) {
            return hasSet;
        }
    }

    @Before
    public void setUp() {
        target = new Resize(new CardSetStub());

        field = new LinkedList<>();
        unused = new LinkedList<>();
        hasSet = false;
    }

    private void resize() {
        target.resize(new CardListStub(field), new CardListStub(unused), 3);
    }

    @Test
    public void resize_fail_emptyLists() {
        resize();
        assertTrue(field.isEmpty());
        assertTrue(unused.isEmpty());
    }

    @Test
    public void resize_success_restock() {
        unused.add(new CardDummy());
        unused.add(new CardDummy());
        unused.add(new CardDummy());
        hasSet = true;

        resize();
        assertFalse(field.isEmpty());
        assertEquals(3, field.size());
        assertTrue(unused.isEmpty());
    }

    @Test
    public void resize_success_reduce() {
        field.add(new CardDummy());
        field.add(new CardDummy());
        field.add(new CardDummy());
        field.add(new CardDummy());

        resize();
        assertFalse(field.isEmpty());
        assertEquals(3, field.size());
        assertFalse(unused.isEmpty());
        assertEquals(1, unused.size());
    }
}
