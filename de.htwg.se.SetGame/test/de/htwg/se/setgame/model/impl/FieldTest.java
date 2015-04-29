package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IPack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

public class FieldTest {

    private class PackStub implements IPack {

        @Override
        public List<ICard> getPack() {
            return cards;
        }
    }

    private class CardStub implements ICard {

        private String cardColor;
        private String cardForm;
        private String cardFill;
        private Integer cardCount;

        public CardStub(String color, String form, String fill, Integer count) {
            cardColor = color;
            cardForm = form;
            cardFill = fill;
            cardCount = count;
        }

        @Override
        public String getColor() {
            return cardColor;
        }

        @Override
        public String getForm() {
            return cardForm;
        }

        @Override
        public String getPanelFilling() {
            return cardFill;
        }

        @Override
        public Integer getNumberOfComponents() {
            return cardCount;
        }

        @Override
        public void setColor(String color) {

        }

        @Override
        public void setForm(String form) {

        }

        @Override
        public void setPanelFilling(String panelFilling) {

        }

        @Override
        public void setNumberOfComponents(int numberOfComponents) {

        }
    }

    Field target;
    List<ICard> cards;

    @Before
    public void setUp() {
        addCards();

        target = new Field(new PackStub(), Field.MIN_SIZE);
    }

    private void addCards() {
        cards = new LinkedList<>();
        cards.add(new CardStub("color", "form", "fill", 0));
        cards.add(new CardStub("color", "form", "fill", 0));
        cards.add(new CardStub("color", "form", "fill", 0));
        cards.add(new CardStub("color", "form", "fill", 1));
        cards.add(new CardStub("color", "form", "fill", 1));
        cards.add(new CardStub("color", "form", "fill", 1));
    }

    private ICard createCard() {
        return new CardStub("color", "form", "fill", 2);
    }

    @Test
    public void initialState() {
        assertEquals(Field.MIN_SIZE, target.getCardsInField().size());
        assertEquals(cards.size()-Field.MIN_SIZE, target.getUnusedCards().size());
    }

    @Test
    public void foundSet_success() {
        List<ICard> list = target.getCardsInField();
        target.foundSet(list.get(0), list.get(1), list.get(2));
        assertEquals(cards.size()- Field.MIN_SIZE - Field.MIN_SIZE, target.getUnusedCards().size());
    }

    @Test
    public void foundSet_fail_firstNotContained() {
        List<ICard> list = target.getCardsInField();
        target.foundSet(createCard(), list.get(1), list.get(2));
        assertEquals(cards.size()- Field.MIN_SIZE, target.getUnusedCards().size());
    }

    @Test
    public void foundSet_fail_secondNotContained() {
        List<ICard> list = target.getCardsInField();
        target.foundSet(list.get(0), createCard(), list.get(2));
        assertEquals(cards.size()- Field.MIN_SIZE, target.getUnusedCards().size());
    }

    @Test
    public void foundSet_fail_thirdNotContained() {
        List<ICard> list = target.getCardsInField();
        target.foundSet(list.get(0), list.get(1), createCard());
        assertEquals(cards.size()- Field.MIN_SIZE, target.getUnusedCards().size());
    }

    @Test
    public void foundSet_fail_notASet() {
        target.setSize(4);
        List<ICard> list = target.getCardsInField();
        target.foundSet(list.get(0), list.get(1), list.get(3));
        assertEquals(cards.size()- 4, target.getUnusedCards().size());
    }

    @Test
    public void setSize_success_increase() {
        target.setSize(5);
        assertEquals(5, target.getCardsInField().size());
    }

    @Test
    public void setSize_success_decrease() {
        target.setSize(5);
        target.setSize(4);
        assertEquals(4, target.getCardsInField().size());
    }

    @Test
    public void setSize_fail_toSmall() {
        target.setSize(1);
        assertEquals(Field.MIN_SIZE, target.getCardsInField().size());
    }

    @Test
    public void setSize_fail_toBig() {
        target.setSize(100);
        assertEquals(Field.MIN_SIZE, target.getCardsInField().size());
    }

    @Test
    public void toString_success() {
        assertFalse(target.toString().isEmpty());
    }
}