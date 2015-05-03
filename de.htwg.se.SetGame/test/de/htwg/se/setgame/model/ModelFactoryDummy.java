package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public class ModelFactoryDummy implements ModelFactory {

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

    @Override
    public IPlayer createPlayer() {
        return null;
    }
}
