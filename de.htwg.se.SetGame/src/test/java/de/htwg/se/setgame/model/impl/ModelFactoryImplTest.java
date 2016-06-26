package de.htwg.se.setgame.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class ModelFactoryImplTest {

    private ModelFactoryImpl target;

    @Before
    public void setUp() {
        target = new ModelFactoryImpl();
    }

    @Test
    public void createSet_success() {
        assertNotNull(target.createSet());
    }

    @Test
    public void createCardList_success() {
        assertNotNull(target.createCardList());
    }

    @Test
    public void createCard_success() {
        assertNotNull(target.createCard());
    }

    @Test
    public void createPlayer_success() {
        assertNotNull(target.createPlayer());
    }

    @Test
    public void createGame_success() {
        assertNotNull(target.createGame());
    }

    @Test
    public void createOption_success() {
        assertNotNull(target.createOption());
    }

    @Test
    public void createOptionValue_success() {
        assertNotNull(target.createOptionValue());
    }

    @Test
    public void createCardOption_success() {
        assertNotNull(target.createCardOption());
    }
}
