package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class FieldTest {
    Field target;
    Pack pack = new Pack();
    int unusedSize = pack.getPack().size()-Field.MIN_SIZE;

    @Before
    public void setUp() {
        target = new Field(pack, Field.MIN_SIZE);
    }

    @Test
    public void initialState() {
        assertEquals(Field.MIN_SIZE, target.getCardsInField().size());
        assertEquals(unusedSize, target.getUnusedCards().size());
    }

    @Test
    public void foundSet_success() {
        List<ICard> list = target.getCardsInField();
        target.foundSet(list.get(0), list.get(1), list.get(2));
        assertEquals(unusedSize - Field.MIN_SIZE, target.getUnusedCards().size());
    }

    @Test
    public void setSize_increase() {
        target.setSize(15);
        assertEquals(15, target.getCardsInField().size());
    }

    @Test
    public void setSize_decrease() {
        target.setSize(15);
        target.setSize(6);
        assertEquals(6, target.getCardsInField().size());
    }

    @Test
    public void toString_success() {
        assertFalse(target.toString().isEmpty());
    }
}