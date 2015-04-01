package de.htwg.se.setgame.model.impl;

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
    public void createField_success() {
        target.createField();
    }

    @Test
    public void createPack_success() {
        target.createPack();
    }
}
