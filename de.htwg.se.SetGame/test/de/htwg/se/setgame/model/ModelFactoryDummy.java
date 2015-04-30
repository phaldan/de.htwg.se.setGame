package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public class ModelFactoryDummy implements ModelFactory {

    @Override
    public IField createField() {
        return null;
    }

    @Override
    public IPack createPack() {
        return null;
    }

    @Override
    public ISet createSet() {
        return null;
    }
}
