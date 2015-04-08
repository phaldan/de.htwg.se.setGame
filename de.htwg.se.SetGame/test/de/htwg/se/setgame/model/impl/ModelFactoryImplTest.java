package de.htwg.se.setgame.model.impl;

import static org.junit.Assert.*;

import de.htwg.se.setgame.model.IField;
import de.htwg.se.setgame.model.ModelFactory;
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
        IField field = target.createField();
        assertNotNull(field);
        assertEquals(ModelFactoryImpl.INITIAL_FIELD_SIZE, field.getCardsInField().size());
    }

    @Test
    public void createPack_success() {
        assertNotNull(target.createPack());
    }
}
