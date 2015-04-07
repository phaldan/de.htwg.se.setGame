package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

public class FieldTest {
    Field target;

    @Before
    public void setUp() {
        target = new Field(new Pack());
    }

    @Test
    public void testStartUp() {
        assertEquals(Field.MAX, target.getAllCardsInGame().size());
        assertTrue(target.getCardInFieldGame().values().containsAll(target.getCardsInField()));
    }

    @Test
    public void testFoundSet() {
        LinkedList<ICard> list = new LinkedList<>(target.getAllCardsInGame());
        for (int index = 0; index < (list.size() - 2); index++) {
            target.foundSet(list.get(index), list.get((index + 1)), list.get(index + 2));
        }
        assertTrue(target.getAllCardsInGame().isEmpty());
    }

    @Test
    public void testSetSizeOfField() {
        target.setSize(15);
        assertEquals(15, target.getCardsInField().size());
    }

    @Test
    public void testChangeCards() {
        List<ICard> list = new LinkedList<>();
        list.add(target.getCardInFieldGame().get(0));
        list.add(target.getUnusedCards().get(0));
        list.add(target.getUnusedCards().get(1));

        target.changeCards(list);

    }

    @Test
    public void toString_success() {
        assertFalse(target.toString().isEmpty());
    }
}