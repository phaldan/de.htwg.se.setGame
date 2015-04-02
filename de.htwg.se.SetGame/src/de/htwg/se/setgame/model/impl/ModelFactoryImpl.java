package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.IField;
import de.htwg.se.setgame.model.IPack;
import de.htwg.se.setgame.model.ModelFactory;

/**
 * @author Philipp Daniels
 */
public class ModelFactoryImpl implements ModelFactory {

    @Override
    public IField createField() {
        IField field = new Field(createPack());
        field.startUp();
        return field;
    }

    @Override
    public IPack createPack() {
        return new Pack();
    }
}
