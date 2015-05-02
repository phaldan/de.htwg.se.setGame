package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public class ModelFactoryDummy implements ModelFactory {

    @Override
    public IPack createPack() {
        return null;
    }

    @Override
    public ISet createSet() {
        return null;
    }

    @Override
    public ICardList createCardList() {
        return null;
    }

    @Override
    public ICard createCard() {
        return null;
    }
}
