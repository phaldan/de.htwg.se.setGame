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
    public void createPack_success() {
        assertNotNull(target.createPack());
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
}
