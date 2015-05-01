package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.*;

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

    @Override
    public ISet createSet() {
        return new Set();
    }

    @Override
    public ICardList createCardList() {
        return new CardList();
    }

    @Override
    public ICard createCard() {
        return new Card();
    }


}
