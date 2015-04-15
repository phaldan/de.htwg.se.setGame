package de.htwg.se.setgame.controller.impl;

import java.util.LinkedList;
import java.util.List;

import de.htwg.se.setgame.model.IField;
import de.htwg.se.setgame.model.IPack;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.impl.Field;
import de.htwg.se.setgame.model.impl.Pack;
import de.htwg.se.setgame.persistence.IPackDAO;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.setgame.model.ICard;

public class SetControllerTest {
    SetController target;
    LinkedList<ICard> list;
    IField field;

    private class FactoryStub implements ModelFactory {

        @Override
        public IField createField() {
            return field;
        }

        @Override
        public IPack createPack() {
            return null;
        }
    }

    @Before
    public void setUp() {
        field = new Field(new Pack(), 3);
        target = new SetController(new FactoryStub());
        list = new LinkedList<>(target.getSetInField());
    }

    @Test
    public void testIsAssetForController() {
        target.isASetForController(list.get(0), list.get(1), list.get(2), target.getPlayerOne());
    }

}
