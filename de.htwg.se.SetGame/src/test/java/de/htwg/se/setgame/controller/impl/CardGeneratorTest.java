package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.util.persistence.CardDaoDummy;
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

    private class CardListSpy extends CardListDummy {

        @Override
        public Set<ICard> getCards() {
            return cards;
        }
    }

    private class CardDao extends CardDaoDummy {

        @Override
        public ICard create() {
            return new CardSpy();
        }
    }

    private CardGenerator target;
    private Set<ICard> cards;

    @Before
    public void setUp() {
        target = new CardGenerator(new CardDao());
        cards = new LinkedHashSet<>();
    }

    @Test
    public void generate_success() {
        target.generate(new CardListSpy());
        int size = CardGenerator.COLOR.length * CardGenerator.FILL.length * CardGenerator.FORM.length * CardGenerator.COUNT.length;
        assertEquals(size, cards.size());
    }

}
