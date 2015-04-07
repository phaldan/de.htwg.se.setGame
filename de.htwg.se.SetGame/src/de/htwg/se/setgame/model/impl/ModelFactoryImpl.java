package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.IField;
import de.htwg.se.setgame.model.IPack;
import de.htwg.se.setgame.model.ModelFactory;

/**
 * @author Philipp Daniels
 */
public class ModelFactoryImpl implements ModelFactory {

    public static final int INITIAL_FIELD_SIZE = 12;

    @Override
    public IField createField() {
        return new Field(createPack(), INITIAL_FIELD_SIZE);
    }

    @Override
    public IPack createPack() {
        return new Pack();
    }
}
