package de.htwg.se.setgame.modell.impl;

import de.htwg.se.setgame.modell.ICard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

public class FieldTest {
    Field field;

    @Before
    public void setUp() {
        field = new Field();
        field.startUp();
    }

    @Test
    public void testStartUp() {
        assertEquals(Field.INITIALVALUEOFFIELD, field.getSizeofField());
        assertEquals(Field.MAX, field.getAllCardsInGame().size());
        assertEquals(Field.MAX, field.getRamdomListe().size());
        assertTrue(field.getCardInFieldGame().values().containsAll(field.getCardsInField()));
    }

    @Test
    public void testFoundSet() {
        LinkedList<ICard> list = new LinkedList<>(field.getAllCardsInGame());
        for (int index = 0; index < (list.size() - 2); index++) {
            field.foundSet(list.get(index), list.get((index + 1)), list.get(index + 2));
        }
        assertTrue(field.getAllCardsInGame().isEmpty());
    }

    @Test
    public void testSetSizeOfField() {
        field.setSizeOfField(15);
        assertEquals(15, field.getCardsInField().size());
    }

    @Test
    public void testChangeCards() {
        List<ICard> list = new LinkedList<>();
        list.add(field.getCardInFieldGame().get(0));
        list.add(field.getUnusedCards().get(0));
        list.add(field.getUnusedCards().get(1));

        field.changeCards(list);

    }
}