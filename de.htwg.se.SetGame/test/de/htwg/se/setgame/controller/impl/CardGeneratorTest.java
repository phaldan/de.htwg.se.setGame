package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardGeneratorTest {

    private List<ICard> cards;

    private class CardListSpy extends CardListDummy {

        @Override
        public void addCard(ICard card) {
            cards.add(card);
        }
    }

    private class Factory extends ModelFactoryDummy {

        @Override
        public ICard createCard() {
            return new CardDummy();
        }

        @Override
        public ICardList createCardList() {
            return new CardListSpy();
        }
    }

    private CardGenerator target;

    @Before
    public void setUp() {
        target = new CardGenerator(new Factory());
        cards = new LinkedList<>();
    }

    @Test
    public void generate_success() {
        assertNotNull(target.generate());
        int size = CardGenerator.COLOR.length * CardGenerator.FILL.length * CardGenerator.FORM.length * CardGenerator.COUNT.length;
        assertEquals(size, cards.size());
    }

}
