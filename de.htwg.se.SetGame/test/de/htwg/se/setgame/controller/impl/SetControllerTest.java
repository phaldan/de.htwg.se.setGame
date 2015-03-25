package de.htwg.se.setgame.controller.impl;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.setgame.model.ICard;

public class SetControllerTest {
    SetController target;
    LinkedList<ICard> list;

    @Before
    public void setUp() {
        target = new SetController();
        list = new LinkedList<>(target.getSetInField());
    }

    @Test
    public void testIsAssetForController() {
        target.isASetForController(list.get(0), list.get(1), list.get(2), target.getPlayerOne());
    }

}
