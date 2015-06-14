package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardGeneratorTest {

    private Set<ICard> cards;

    private class CardListSpy extends CardListDummy {

        @Override
        public Set<ICard> getCards() {
            return cards;
        }
    }

    private class Factory extends ModelFactoryDummy {

        @Override
        public ICard createCard() {
            return new CardSpy();
        }

        @Override
        public ICardList createCardList() {
            return new CardListSpy();
        }
    }

    private class CardSpy extends CardDummy {

        private String form;
        private String fill;
        private Integer count;
        private String color;

        @Override
        public void setForm(String form) {
            this.form = form;
        }

        @Override
        public void setPanelFilling(String panelFilling) {
            fill = panelFilling;
        }

        @Override
        public void setNumberOfComponents(int numberOfComponents) {
            count = numberOfComponents;
        }

        @Override
        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return form + fill + count + color;
        }
    }

    private CardGenerator target;

    @Before
    public void setUp() {
        target = new CardGenerator(new Factory());
        cards = new LinkedHashSet<>();
    }

    @Test
    public void generate_success() {
        assertNotNull(target.generate());
        int size = CardGenerator.COLOR.length * CardGenerator.FILL.length * CardGenerator.FORM.length * CardGenerator.COUNT.length;
        assertEquals(size, cards.size());
    }

}
